package com.ss.android.socialbase.downloader.segment;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class MultiSegmentWriter {
    private static final int MIN_CACHE_BYTES = 65536;
    private static final int MIN_CACHE_TIME_MS = 200;
    private static final int MIN_SYNC_STEP_BYTE = 65536;
    private static final long MIN_SYNC_TIME_MS = 500;
    private static final String TAG = "MultiSegmentWriter";
    private final AppStatusManager appStatusManager;
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private final List<SegmentOutput> doneOutputs;
    private final IDownloadCache downloadCache;
    private final DownloadInfo downloadInfo;
    private BaseException exception;
    private final boolean hasSyncStrategy;
    private final boolean isMonitorRw;
    private volatile long lastSyncBytes;
    private volatile long lastSyncTimestamp;
    private final long minSyncLength;
    private boolean needSync;
    private final List<SegmentOutput> outputs;
    private volatile boolean paused;
    private final IBufferPool pool;
    private final DownloadSetting setting;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private long syncTimeNs;
    private volatile boolean threadDirty;

    private boolean isNeedSync(long r3, long r5) {
        if (r3 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L5;
    L7:
        return false;
    L5:
        if (r5 <= 500) goto L7;
        return true;
    }

    MultiSegmentWriter(DownloadInfo r7, IDownloadRunnableCallback r8, IBufferPool r9) {
        IDownloadRunnableCallback r10 = (IDownloadRunnableCallback) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadRunnableCallback.class, "com.obric.aiagent.plugin");
        IBufferPool r11 = (IBufferPool) ZeusTransformUtils.wrapperContextForParams(r9, IBufferPool.class, "com.obric.aiagent.plugin");
        this.outputs = new LinkedList();
        this.doneOutputs = new ArrayList();
        boolean r0 = false;
        this.threadDirty = false;
        this.paused = false;
        this.canceled = false;
        this.needSync = true;
        this.lastSyncBytes = 0;
        this.lastSyncTimestamp = 0;
        this.downloadInfo = r7;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        this.callback = r10;
        this.pool = r11;
        this.appStatusManager = AppStatusManager.getInstance();
        DownloadSetting r12 = DownloadSetting.obtain(r7.getId());
        this.setting = r12;
        if (r12.optInt(DownloadSettingKeys.SYNC_STRATEGY, 0) != 1) goto L5;
        boolean r13 = true;
    L6:
        this.hasSyncStrategy = r13;
        if (r13 == false) goto L9;
        long r14 = r12.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_FG, DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        long r2 = r12.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_BG, 1000);
        this.syncIntervalMsFg = Math.max(r14, 500);
        this.syncIntervalMsBg = Math.max(r2, 500);
        this.minSyncLength = r12.optLong(DownloadSettingKeys.SYNC_MIN_LENGTH, 10485760);
    L11:
        if (r12.optInt(DownloadSettingKeys.MONITOR_RW) != 1) goto L13;
        r0 = true;
    L13:
        this.isMonitorRw = r0;
        return;
    L9:
        this.syncIntervalMsFg = 0;
        this.syncIntervalMsBg = 0;
        this.minSyncLength = 0;
        goto L11
    L5:
        r13 = false;
        goto L6
    }

    void assignOutput(SegmentOutput r2) {
        monitor-enter(this);
        this.outputs.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void loopAndWrite(IInput r28) {
        IInput r0 = (IInput) ZeusTransformUtils.wrapperContextForParams(r28, IInput.class, "com.obric.aiagent.plugin");
        if (this.paused == false) goto L5;
        return;
    L5:
        if (this.canceled == true) goto L405;
        this.exception = null;
        DownloadInfo r4 = this.downloadInfo;
        IDownloadRunnableCallback r3 = this.callback;
        IBufferPool r5 = this.pool;
        long r6 = r4.getCurBytes();
        long r8 = System.nanoTime();
        boolean r14 = this.isMonitorRw;
        int r15 = 0;
        if (this.hasSyncStrategy == false) goto L378;
        long r16 = r4.getTotalBytes();
        if (r16 <= 0) goto L378;
        if (r16 > this.minSyncLength) goto L378;
        this.needSync = false;
    L378:
        r4.updateRealStartDownloadTime();     // Catch: Throwable -> L149 BaseException -> L237 StreamClosedException -> L286
        this.lastSyncTimestamp = SystemClock.uptimeMillis();     // Catch: Throwable -> L149 BaseException -> L237 StreamClosedException -> L286
        r15 = 0;
        long r10 = 0;
        long r17 = 0;
        long r22 = 0;
        long r20 = 0;
    L16:
        if (r14 == true) goto L387;
    L18:
        Buffer r2 = r0.read();     // Catch: Throwable -> L140 BaseException -> L143 StreamClosedException -> L146
        if (r14 == true) goto L21;
    L22:
        r22 = r22;
        int r12 = r2.size;     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        if (r12 != (-1)) goto L28;
        outputDone(r2.output);     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        r5.recycle(r2);     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        goto L16
    L28:
        if (r14 == false) goto L30;
        r10 = System.nanoTime();     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
    L30:
        r2.output.write(r2);     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        if (r14 == true) goto L33;
    L34:
        long r18 = r17;
        r5.recycle(r2);     // Catch: Throwable -> L125 BaseException -> L128 StreamClosedException -> L131
        if (this.threadDirty == true) goto L38;
    L83:
        r15 = r15 + r12;
        if (r15 < 65536) goto L123;
        r3 = r3;
        long r7 = SystemClock.uptimeMillis();     // Catch: Throwable -> L117 BaseException -> L119 StreamClosedException -> L121
        if ((r7 - r20) <= 200) goto L124;
        long r25 = r10;
        boolean r11 = r3.onProgress(r15);     // Catch: Throwable -> L117 BaseException -> L119 StreamClosedException -> L121
    L115:
        e = e;
    L288:
        this.exception = e;     // Catch: Throwable -> L290
        throw e;     // Catch: Throwable -> L290
    L113:
        e = e;
        r15 = 0;
    L240:
        if (this.paused == false) goto L242;
    L249:
        if (r15 <= 0) goto L253;
        r3.onProgress(r15);     // Catch: Throwable -> L335
    L253:
        if (this.canceled == false) goto L376;
    L261:
        Throwable r9 = null;
    L262:
        monitor-enter(this);
        close(this.outputs);     // Catch: Throwable -> L283
        this.outputs.clear();     // Catch: Throwable -> L283
        monitor-exit(this);     // Catch: Throwable -> L283
        DownloadMonitorHelper.monitorDownloadIO(this.setting, r4, r4.getUrl(), null, this.paused, this.canceled, this.exception, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.syncTimeNs, null);
        if (r9 != null) goto L268;
        return;
    L268:
        if (this.paused == false) goto L270;
    L275:
        boolean r19 = true;
    L276:
        if (r19 == true) goto L401;
        DownloadHelper.parseException(r9, "loopAndWrite_finally");     // Catch: BaseException -> L279
        return;
    L279:
        e = move-exception;
        this.exception = e;
        throw e;
    L401:
        return;
    L270:
        if (this.canceled == true) goto L275;
        if (this.exception != null) goto L275;
        r19 = false;
    L283:
        th = move-exception;
        throw th;
    L376:
        this.needSync = true;     // Catch: Throwable -> L257
        flushAndSync();     // Catch: Throwable -> L257
    L257:
        th = move-exception;
        r9 = th;
        if (Logger.debug() == false) goto L262;
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "Finally sync, e = " + r9);
        goto L262
    L242:
        if (this.canceled == true) goto L249;
        if (Logger.debug() == false) goto L247;
        e.printStackTrace();     // Catch: Throwable -> L290
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "BaseException: " + e);     // Catch: Throwable -> L290
    L247:
        this.exception = e;     // Catch: Throwable -> L290
        throw e;     // Catch: Throwable -> L290
    L111:
        th = th;
        r15 = 0;
    L152:
        if (this.paused == false) goto L154;
    L200:
        if (r15 <= 0) goto L204;
        r3.onProgress(r15);     // Catch: Throwable -> L333
    L204:
        if (this.canceled == false) goto L374;
    L212:
        Throwable r13 = null;
    L213:
        monitor-enter(this);
        close(this.outputs);     // Catch: Throwable -> L234
        this.outputs.clear();     // Catch: Throwable -> L234
        monitor-exit(this);     // Catch: Throwable -> L234
        DownloadMonitorHelper.monitorDownloadIO(this.setting, r4, r4.getUrl(), null, this.paused, this.canceled, this.exception, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.syncTimeNs, null);
        if (r13 != null) goto L219;
        return;
    L219:
        if (this.paused == false) goto L221;
    L226:
        boolean r110 = true;
    L227:
        if (r110 == true) goto L399;
        DownloadHelper.parseException(r13, "loopAndWrite_finally");     // Catch: BaseException -> L230
        return;
    L230:
        e = move-exception;
        this.exception = e;
        throw e;
    L399:
        return;
    L221:
        if (this.canceled == true) goto L226;
        if (this.exception != null) goto L226;
        r110 = false;
    L234:
        th = move-exception;
        throw th;
    L374:
        this.needSync = true;     // Catch: Throwable -> L208
        flushAndSync();     // Catch: Throwable -> L208
    L208:
        th = move-exception;
        r13 = th;
        if (Logger.debug() == false) goto L213;
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "Finally sync, e = " + r13);
        goto L213
    L154:
        if (this.canceled == true) goto L200;
        if (Logger.debug() == false) goto L348;
        th.printStackTrace();     // Catch: Throwable -> L290
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "Throwable: " + th);     // Catch: Throwable -> L290
    L348:
        DownloadHelper.parseException(th, "loopAndWrite");     // Catch: BaseException -> L197 Throwable -> L290
        if (r15 <= 0) goto L164;
        r3.onProgress(r15);     // Catch: Throwable -> L332
    L164:
        if (this.canceled == false) goto L360;
    L172:
        Throwable r21 = null;
    L173:
        monitor-enter(this);
        close(this.outputs);     // Catch: Throwable -> L194
        this.outputs.clear();     // Catch: Throwable -> L194
        monitor-exit(this);     // Catch: Throwable -> L194
        DownloadMonitorHelper.monitorDownloadIO(this.setting, r4, r4.getUrl(), null, this.paused, this.canceled, this.exception, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.syncTimeNs, null);
        if (r21 != null) goto L179;
        return;
    L179:
        if (this.paused == false) goto L181;
    L186:
        boolean r111 = true;
    L187:
        if (r111 == true) goto L397;
        DownloadHelper.parseException(r21, "loopAndWrite_finally");     // Catch: BaseException -> L190
        return;
    L190:
        e = move-exception;
        this.exception = e;
        throw e;
    L397:
        return;
    L181:
        if (this.canceled == true) goto L186;
        if (this.exception != null) goto L186;
        r111 = false;
    L194:
        th = move-exception;
        throw th;
    L360:
        this.needSync = true;     // Catch: Throwable -> L168
        flushAndSync();     // Catch: Throwable -> L168
    L168:
        th = move-exception;
        r21 = th;
        if (Logger.debug() == false) goto L173;
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "Finally sync, e = " + r21);
        goto L173
    L197:
        e = move-exception;
        this.exception = e;     // Catch: Throwable -> L290
        throw e;     // Catch: Throwable -> L290
    L90:
        if (this.needSync == false) goto L93;
        checkAndSync(r7, r11);     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
    L93:
        if (DeviceBandwidthSampler.isWifi() == false) goto L95;
    L110:
        r20 = r7;
        r3 = r3;
        r17 = r18;
        r22 = r22;
        r10 = r25;
        r15 = 0;
        goto L16
    L95:
        if (r4.isOnlyWifi() == false) goto L102;
        DeviceBandwidthSampler.updateNetworkStatus();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
        if (DeviceBandwidthSampler.isMobileNet() == false) goto L102;
        throw new DownloadOnlyWifiException();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
    L102:
        if (r4.isDownloadFromReserveWifi() == false) goto L110;
        if (r4.isPauseReserveOnWifi() == false) goto L110;
        DeviceBandwidthSampler.updateNetworkStatus();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
        if (DeviceBandwidthSampler.isMobileNet() == false) goto L110;
        throw new DownloadPauseReserveWifiException();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
    L124:
        r3 = r3;
        r17 = r18;
        r10 = r10;
    L121:
        e = e;
    L119:
        e = e;
    L130:
        r15 = r15;
    L117:
        th = th;
    L127:
        r15 = r15;
        goto L152
    L123:
        r3 = r3;
        goto L124
    L38:
        if (this.paused == true) goto L45;
        if (this.canceled == true) goto L45;
        this.threadDirty = false;     // Catch: Throwable -> L125 BaseException -> L128 StreamClosedException -> L131
    L45:
        if (r15 <= 0) goto L49;
        r3.onProgress(r15);     // Catch: Throwable -> L331
    L49:
        if (this.canceled == true) goto L57;
        boolean r23 = true;
        this.needSync = true;     // Catch: Throwable -> L53
        flushAndSync();     // Catch: Throwable -> L53
    L58:
        Throwable th = null;
    L59:
        monitor-enter(this);
        close(this.outputs);     // Catch: Throwable -> L80
        this.outputs.clear();     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        boolean r112 = r23;
        DownloadMonitorHelper.monitorDownloadIO(this.setting, r4, r4.getUrl(), null, this.paused, this.canceled, this.exception, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.syncTimeNs, null);
        if (th != null) goto L65;
        return;
    L65:
        if (this.paused == false) goto L67;
    L72:
        boolean r113 = r112;
    L73:
        if (r113 == true) goto L395;
        DownloadHelper.parseException(th, "loopAndWrite_finally");     // Catch: BaseException -> L76
        return;
    L76:
        e = move-exception;
        this.exception = e;
        throw e;
    L395:
        return;
    L67:
        if (this.canceled == true) goto L72;
        if (this.exception != null) goto L72;
        r113 = false;
    L80:
        th = move-exception;
        throw th;
    L53:
        th = th;
        if (Logger.debug() == false) goto L59;
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "Finally sync, e = " + th);
        goto L59
    L57:
        r23 = true;
    L131:
        e = e;
    L128:
        e = e;
        r3 = r3;
    L125:
        th = th;
        r3 = r3;
        goto L127
    L33:
        r17 = r17 + (System.nanoTime() - r10);
        goto L34
    L138:
        e = e;
    L136:
        e = e;
    L145:
        r18 = r17;
    L134:
        th = th;
    L142:
        r18 = r17;
        goto L152
    L21:
        r22 = r22 + (System.nanoTime() - r10);
        goto L22
    L387:
        r10 = System.nanoTime();     // Catch: Throwable -> L140 BaseException -> L143 StreamClosedException -> L146
    L146:
        e = e;
    L143:
        e = e;
        r22 = r22;
    L140:
        th = th;
        r22 = r22;
        goto L142
    L290:
        th = move-exception;
        if (r15 <= 0) goto L296;
        r3.onProgress(r15);     // Catch: Throwable -> L334
    L296:
        if (this.canceled == true) goto L304;
        boolean r114 = true;
        this.needSync = true;     // Catch: Throwable -> L300
        flushAndSync();     // Catch: Throwable -> L300
    L305:
        Throwable th2 = null;
    L306:
        monitor-enter(this);
        close(this.outputs);     // Catch: Throwable -> L327
        this.outputs.clear();     // Catch: Throwable -> L327
        boolean r26 = r114;
        DownloadMonitorHelper.monitorDownloadIO(this.setting, r4, r4.getUrl(), null, this.paused, this.canceled, this.exception, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.syncTimeNs, null);
        if (th2 != null) goto L312;
        throw th;
    L312:
        if (this.paused == false) goto L314;
    L319:
        boolean r115 = r26;
    L320:
        if (r115 == true) goto L403;
        DownloadHelper.parseException(th2, "loopAndWrite_finally");     // Catch: BaseException -> L323
        throw th;
    L323:
        e = move-exception;
        this.exception = e;
        throw e;
    L403:
        throw th;
    L314:
        if (this.canceled == true) goto L319;
        if (this.exception != null) goto L319;
        r115 = false;
    L327:
        th = move-exception;
        throw th;
    L300:
        th2 = th;
        if (Logger.debug() == false) goto L306;
        Logger.taskDebug(TAG, r4.getId(), "loopAndWrite", "Finally sync, e = " + th2);
        goto L306
    L304:
        r114 = true;
    L286:
        e = e;
    L237:
        e = e;
        r3 = r3;
        r15 = 0;
        r18 = 0;
        r22 = 0;
    L149:
        th = th;
        r3 = r3;
        r15 = 0;
        r18 = 0;
        r22 = 0;
        goto L152
    }

    private void checkAndSync(long r7, boolean r9) {
        long r0 = r7 - this.lastSyncTimestamp;
        if (this.hasSyncStrategy == true) goto L5;
        long r2 = this.downloadInfo.getCurBytes() - this.lastSyncBytes;
        if (r9 == false) goto L14;
    L15:
        flushAndSync();
        this.lastSyncTimestamp = r7;
        return;
    L14:
        if (isNeedSync(r2, r0) == true) goto L15;
        return;
    L5:
        if (this.appStatusManager.isAppForeground() == false) goto L7;
        long r3 = this.syncIntervalMsFg;
    L9:
        if (r0 <= r3) goto L17;
        flushAndSync();
        this.lastSyncTimestamp = r7;
        return;
    L17:
        return;
    L7:
        r3 = this.syncIntervalMsBg;
        goto L9
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    private void outputDone(IOutput r4) {
        IOutput r5 = (IOutput) ZeusTransformUtils.wrapperContextForParams(r4, IOutput.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        this.doneOutputs.add((SegmentOutput) ZeusTransformUtils.preCheckCast(r5, SegmentOutput.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void flushAndSync() {
        boolean r0 = this.isMonitorRw;
        if (r0 == false) goto L5;
        long r1 = System.nanoTime();
    L6:
        DownloadInfo r3 = this.downloadInfo;
        IDownloadCache r4 = this.downloadCache;
        List<SegmentOutput> r5 = this.outputs;
        List<SegmentOutput> r6 = this.doneOutputs;
        Map<Long, Segment> r7 = r4.getSegmentMap(r3.getId());
        if (r7 != null) goto L9;
        r7 = new HashMap(4);
    L9:
        boolean r8 = false;
        monitor-enter(this);
        flush(r5);     // Catch: Throwable -> L28
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
    L19:
        updateSegmentToMap(r5, r7);     // Catch: Throwable -> L28
        if (r6.size() <= 0) goto L22;
        close(r6);     // Catch: Throwable -> L28
        r5.removeAll(r6);     // Catch: Throwable -> L28
        r6.clear();     // Catch: Throwable -> L28
    L22:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r8 == false) goto L25;
        r3.updateRealDownloadTime(true);
        r4.updateSegments(r3.getId(), r7);
        r4.updateDownloadInfo(r3);
        this.lastSyncBytes = r3.getCurBytes();
    L25:
        if (r0 == false) goto L35;
        this.syncTimeNs += System.nanoTime() - r1;
        return;
    L35:
        return;
    L14:
        if (this.needSync == false) goto L16;
        sync(r5);     // Catch: Throwable -> L17
    L16:
        r8 = true;
    L28:
        th = move-exception;
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    private void flush(List<SegmentOutput> r3) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SegmentOutput) ZeusTransformUtils.preCheckCast(r2.next(), SegmentOutput.class, "com.obric.aiagent.plugin")).flush();
        goto L4
    }

    private void sync(List<SegmentOutput> r3) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SegmentOutput) ZeusTransformUtils.preCheckCast(r2.next(), SegmentOutput.class, "com.obric.aiagent.plugin")).sync();
        goto L4
    }

    private void close(List<SegmentOutput> r3) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SegmentOutput) ZeusTransformUtils.preCheckCast(r2.next(), SegmentOutput.class, "com.obric.aiagent.plugin")).close();
        goto L4
    }

    private void updateSegmentToMap(List<SegmentOutput> r5, Map<Long, Segment> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Segment r9 = ((SegmentOutput) ZeusTransformUtils.preCheckCast(r8.next(), SegmentOutput.class, "com.obric.aiagent.plugin")).getSegment();
        Segment r1 = (Segment) ZeusTransformUtils.preCheckCast(r7.get(Long.valueOf(r9.getStartOffset())), Segment.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        r1.setCurrentOffset(r9.getCurrentOffset());
        r1.setEndOffset(r9.getEndOffset());
        goto L4
    L7:
        Segment r2 = new Segment(r9);
        r7.put(Long.valueOf(r9.getStartOffset()), r2);
        goto L4
    }

    public void cancel() {
        this.canceled = true;
        this.threadDirty = true;
    }

    public void pause() {
        this.paused = true;
        this.threadDirty = true;
    }
}

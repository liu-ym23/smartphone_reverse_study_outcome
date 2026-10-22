package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.PluginDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadThreadPool {
    private static String TAG = "DownloadThreadPool";
    private AtomicInteger clearTimes;
    private Map<Integer, DownloadRunnable> downloadRunnablePool;

    static {
    }

    public DownloadThreadPool() {
        this.downloadRunnablePool = new ConcurrentHashMap();
        this.clearTimes = new AtomicInteger(0);
    }

    public Future execute(DownloadRunnable r8) {
        r8.prepareDownload();
        int r3 = 0;
        if (this.clearTimes.compareAndSet(500, 0) == false) goto L5;
        clearRunnableNotAlive();
    L5:
        this.clearTimes.incrementAndGet();
        this.downloadRunnablePool.put(Integer.valueOf(r8.getDownloadId()), r8);
        DownloadTask r1 = r8.getDownloadTask();
        r1.getTimingInfo().beforeThreadExecuteTime = System.currentTimeMillis();     // Catch: Exception -> L11
        ExecutorService r7 = getDownloadExecutorService(r8);     // Catch: Exception -> L11
        if (Logger.debugScene(r8.getDownloadInfo()) == false) goto L9;
        Logger.taskDebug(TAG, r8.getDownloadInfo(), "execute", "Executor:" + r7);     // Catch: Exception -> L11
    L9:
        Future<?> r9 = r7.submit(r8);     // Catch: Exception -> L11
        r8.setFuture(r9);     // Catch: Exception -> L11
        return r9;
    L11:
        e = move-exception;
        Logger.taskError(TAG, r8.getDownloadId(), "execute", "Error:" + e);
        if (r1 == null) goto L18;
        IDownloadMonitorDepend r10 = r1.getMonitorDepend();
        DownloadInfo r0 = r1.getDownloadInfo();
        BaseException r2 = new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(e, "DownloadThreadPoolExecute"));
        if (r1.getDownloadInfo() == null) goto L17;
        r3 = r1.getDownloadInfo().getStatus();
    L17:
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r10, r0, r2, r3);
    L18:
        e.printStackTrace();
        return null;
    }

    private void clearRunnableNotAlive() {
        Iterator<Map.Entry<Integer, DownloadRunnable>> r3 = this.downloadRunnablePool.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        if (((DownloadRunnable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), DownloadRunnable.class, "com.obric.aiagent.plugin")).isAlive() == true) goto L4;
        r3.remove();
        goto L4
    }

    public void removeUnAliveDownloadRunnable(DownloadRunnable r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, DownloadRunnable>> r3 = this.downloadRunnablePool.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L14;
        if (((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue() != r4) goto L6;
        r3.remove();
        return;
    }

    public boolean containsTask(int r2) {
        DownloadRunnable r1 = (DownloadRunnable) ZeusTransformUtils.preCheckCast(this.downloadRunnablePool.get(Integer.valueOf(r2)), DownloadRunnable.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.isAlive() == false) goto L7;
        return true;
    }

    public DownloadRunnable cancel(int r3) {
        clearRunnableNotAlive();
        DownloadRunnable r4 = (DownloadRunnable) ZeusTransformUtils.preCheckCast(this.downloadRunnablePool.remove(Integer.valueOf(r3)), DownloadRunnable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        r4.cancel();
        removeFromThreadPool(r4);
    L5:
        return r4;
    }

    public void pause(int r3) {
        clearRunnableNotAlive();
        DownloadRunnable r4 = (DownloadRunnable) ZeusTransformUtils.preCheckCast(this.downloadRunnablePool.remove(Integer.valueOf(r3)), DownloadRunnable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.pause();
        removeFromThreadPool(r4);
        return;
    }

    private void removeFromThreadPool(DownloadRunnable r3) {
        if (r3 != null) goto L13;
        return;
    L13:
        ExecutorService r2 = getDownloadExecutorService(r3);     // Catch: Exception -> L10
        if (ZeusTransformUtils.instanceOf(r2, ThreadPoolExecutor.class) == false) goto L15;
        ((ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r2, ThreadPoolExecutor.class, "com.obric.aiagent.plugin")).remove(r3);     // Catch: Exception -> L10
        Future r4 = r3.getFuture();     // Catch: Exception -> L10
        if (r4 == null) goto L16;
        r4.cancel(true);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    private ExecutorService getDownloadExecutorService(DownloadRunnable r5) {
        ExecutorService r0 = null;
        DownloadInfo r1 = r5.getDownloadTask().getDownloadInfo();     // Catch: Throwable -> L27 Exception -> L29
        if (r1.isFastDownload() == false) goto L6;
        r0 = DownloadComponentManager.getFastThreadExecutor();     // Catch: Throwable -> L27 Exception -> L29
    L6:
        if (r0 != null) goto L17;
        int r2 = r1.getExecutorGroup();     // Catch: Throwable -> L27 Exception -> L29
        if (r2 != 3) goto L10;
        r0 = DownloadComponentManager.getMixFrequentThreadExecutor();     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L10:
        if (r2 != 4) goto L12;
        r0 = DownloadComponentManager.getMixApkThreadExecutor();     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L12:
        if (r2 != 7) goto L17;
        r0 = DownloadComponentManager.getCustomThreadExecutor();     // Catch: Throwable -> L27 Exception -> L29
    L17:
        if (r0 == null) goto L19;
    L21:
        if (r0 == null) goto L23;
    L25:
        if (r0 == null) goto L33;
        return r0;
    L33:
        return DownloadComponentManager.getMixDefaultThreadExecutor();
    L23:
        if (PluginDownloadEngine.isEnabledDownloadPluginOpt(r1) == false) goto L25;
        r0 = PluginDownloadEngine.getInstance().getPluginExecutor();     // Catch: Throwable -> L27 Exception -> L29
    L19:
        if (canUseSegmentThreadPool(r1, r5) == false) goto L21;
        r0 = DownloadComponentManager.getSegmentDownloadThreadExecutorService();     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = move-exception;
        if (0 != 0) goto L36;
        DownloadComponentManager.getMixDefaultThreadExecutor();
    L36:
        throw th;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        if (0 == 0) goto L33;
        return null;
    }

    private boolean canUseSegmentThreadPool(DownloadInfo r7, DownloadRunnable r8) {
        long r2 = 0;
        if (r7.getExpectFileLength() > 0) goto L5;
        return false;
    L5:
        JSONObject r6 = DownloadSetting.obtain(r7.getId()).optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
        if (r6 == null) goto L9;
        r2 = r6.optLong(DownloadSettingKeys.SegmentConfig.EXPECT_MIN_DOWNLOAD_SIZE);
    L9:
        if (r2 >= 104857600) goto L12;
        return false;
    L12:
        if (r7.getExpectFileLength() <= r2) goto L15;
        return true;
    L15:
        r8.setEnableSegmentDownload(false);
        return false;
    }

    public List<Integer> getAllAliveDownloadIds() {
        clearRunnableNotAlive();
        return new ArrayList(this.downloadRunnablePool.keySet());
    }

    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        DownloadRunnable r1 = (DownloadRunnable) ZeusTransformUtils.preCheckCast(this.downloadRunnablePool.get(Integer.valueOf(r2)), DownloadRunnable.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.setThrottleNetSpeed(r3, r5);
        return;
    }
}

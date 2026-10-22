package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import android.util.SparseArray;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadGlobalThrottleService implements IDownloadGlobalThrottleService {
    private final int DOWNLOADER_VALID_TIME;
    private final int DYNAMIC_AND_FIXED_THROTTLE;
    private final int NO_TASK_THROTTLE_VALUE_DEFAULT;
    private final int ONLY_DYNAMIC_THROTTLE;
    private final int SPEED_THRESHOLD_MIN;
    private final int STOP_THROTTLE;
    private final String TAG;
    private final int TASK_SPEED_THRESHOLD_MIN;
    private final double THROTTLE_FACTOR_LOW;
    private final int VALID_NET_BANDWIDTH_MIN;
    private SparseArray mAllTask;
    private volatile int mPriority;
    private volatile int mThrottleSpeed;

    static /* synthetic */ void access$000(DownloadGlobalThrottleService r0, DownloadTask r1) {
        r0.startInternal(r1);
    }

    static /* synthetic */ void access$100(DownloadGlobalThrottleService r0, DownloadTask r1) {
        r0.endInternal(r1);
    }

    static /* synthetic */ void access$200(DownloadGlobalThrottleService r0, int r1, int r2) {
        r0.setGlobalThrottleInternal(r1, r2);
    }

    public DownloadGlobalThrottleService() {
        this.TAG = "globalThrottle";
        this.NO_TASK_THROTTLE_VALUE_DEFAULT = UiType.FLAG_REMOTE_CARD;
        this.SPEED_THRESHOLD_MIN = 512000;
        this.TASK_SPEED_THRESHOLD_MIN = 51200;
        this.STOP_THROTTLE = 0;
        this.DYNAMIC_AND_FIXED_THROTTLE = -1;
        this.ONLY_DYNAMIC_THROTTLE = -2;
        this.THROTTLE_FACTOR_LOW = 0.5d;
        this.DOWNLOADER_VALID_TIME = DownloadErrorCode.ERROR_CRONET_ERROR_BASE;
        this.VALID_NET_BANDWIDTH_MIN = 204800;
        this.mAllTask = new SparseArray();
        this.mThrottleSpeed = 0;
        this.mPriority = 0;
    }

    private void deleteTaskAndThrottleSpeedReset(DownloadTask r6) {
        SparseArray r0 = this.mAllTask;
        monitor-enter(r0);
        this.mAllTask.remove(r6.getDownloadId());     // Catch: Throwable -> L14
        if (Logger.debugScene(r6.getDownloadInfo()) == false) goto L8;
        Logger.taskDebug("globalThrottle", r6.getDownloadInfo(), "deleteTaskAndThrottleSpeedReset", "taskCount=" + this.mAllTask.size() + ",mThrottleSpeed=" + this.mThrottleSpeed);     // Catch: Throwable -> L14
    L8:
        if (this.mThrottleSpeed != 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        throttleSpeedReset();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void stopThrottle() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug("globalThrottle", "stopThrottle", "stop throttle!");
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mAllTask.size()) goto L12;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.mAllTask.valueAt(r0), DownloadTask.class, "com.obric.aiagent.plugin");
        r3.getDownloadInfo().setThrottleNetSpeed(0);
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug("globalThrottle", "stopThrottle", "TTNet api set speed=0");
    L11:
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).setThrottleNetSpeed(r3.getDownloadId(), 0);
        r0 = r0 + 1;
        goto L7
    }

    private int getThrottleTaskSize() {
        int r1 = 0;
        if (this.mAllTask.size() != 0) goto L5;
        return 0;
    L5:
        int r0 = 0;
    L7:
        if (r1 >= this.mAllTask.size()) goto L14;
        if (((DownloadTask) ZeusTransformUtils.preCheckCast(this.mAllTask.valueAt(r1), DownloadTask.class, "com.obric.aiagent.plugin")).getTaskPriority() > this.mPriority) goto L12;
        r0 = r0 + 1;
    L12:
        r1 = r1 + 1;
        goto L7
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug("globalThrottle", "getThrottleTaskSize", "throttle task size=" + r0);
    L16:
        return r0;
    }

    private void throttleSpeedReset() {
        int r0 = getThrottleTaskSize();
        int r2 = 0;
        if (this.mThrottleSpeed <= 0) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = this.mThrottleSpeed / r0;
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug("globalThrottle", "throttleSpeedReset", "mThrottleSpeed=" + this.mThrottleSpeed + ",taskCount=" + r0);
    L14:
        if (r2 >= this.mAllTask.size()) goto L27;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.mAllTask.valueAt(r2), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r3.getTaskPriority() > this.mPriority) goto L26;
        int r4 = 51200;
        if (r1 == 0) goto L21;
        if (r1 >= 51200) goto L21;
    L23:
        if (Logger.debug() == false) goto L25;
        Logger.globalDebug("globalThrottle", "throttleSpeedReset", "TTNet api set speed=" + r4);
    L25:
        long r8 = r4;
        r3.getDownloadInfo().setThrottleNetSpeed(r8);
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).setThrottleNetSpeed(r3.getDownloadId(), r8);
    L21:
        r4 = r1;
    L26:
        r2 = r2 + 1;
        goto L14
    L27:
        return;
    L7:
        if (this.mThrottleSpeed != 0) goto L9;
        r1 = 0;
        goto L11
    L9:
        r1 = UiType.FLAG_REMOTE_CARD;
        goto L11
    }

    private void addTaskAndThrottleSpeedReset(DownloadTask r5) {
        if (Logger.debugScene(r5.getDownloadInfo()) == false) goto L6;
        Logger.taskDebug("globalThrottle", r5.getDownloadInfo(), "addTaskAndThrottleSpeedReset", "add to map!");
    L6:
        if (r5.getTaskPriority() <= this.mPriority) goto L8;
        return;
    L8:
        SparseArray r0 = this.mAllTask;
        monitor-enter(r0);
        this.mAllTask.put(r5.getDownloadId(), r5);     // Catch: Throwable -> L17
        if (this.mThrottleSpeed > 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L14:
        throttleSpeedReset();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private int getBandwidth() {
        int r2 = Math.max(DownloadHelper.convertToBytes(NetTrafficManager.getInstance().getRealTimeSpeed()), DownloadHelper.convertToBytes(NetTrafficManager.getInstance().getDownloadKBitsPerSecond()));
        if (r2 >= 0) goto L6;
        return 0;
    L6:
        return r2;
    }

    private int getGlobalThrottleSpeed() {
        SparseArray r0 = this.mAllTask;
        monitor-enter(r0);
        int r1 = getThrottleTaskSize();     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        int r6 = getBandwidth();
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug("globalThrottle", "getGlobalThrottleSpeed", "bandwidth=" + r6 + ",taskRunningTime=" + NetTrafficManager.getInstance().getTaskRunningTime() + ",taskCount=" + r1);
    L9:
        if (r1 > 0) goto L11;
    L16:
        double r2 = 2097152.0d;
    L18:
        if (r2 >= 512000.0d) goto L21;
        r2 = 512000.0d;
    L21:
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug("globalThrottle", "getGlobalThrottleSpeed", "throttleSpeed=" + r2);
    L24:
        return (int) r2;
    L11:
        if (NetTrafficManager.getInstance().getTaskRunningTime() < 2000) goto L13;
    L15:
        r2 = ((double) r6) * 0.5d;
        goto L18
    L13:
        if (r6 >= 204800) goto L15;
    L25:
        th = move-exception;
        throw th;
    }

    private void dynamicThrottle() {
        int r0 = 0;
    L4:
        if (r0 >= this.mAllTask.size()) goto L9;
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.mAllTask.valueAt(r0), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r1.getTaskPriority() > this.mPriority) goto L8;
        long r5 = -1;
        r1.getDownloadInfo().setThrottleNetSpeed(r5);
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).setThrottleNetSpeed(r1.getDownloadId(), r5);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void start(final DownloadTask r5) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) > 0) goto L6;
        return;
    L6:
        if (Logger.debugScene(r5.getDownloadInfo()) == false) goto L9;
        Logger.taskDebug("globalThrottle", r5.getDownloadInfo(), "start", "start throttle!");
    L9:
        if (DownloadUtils.isMainThread() == false) goto L11;
        DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new AnonymousClass1(this, r5));
        return;
    L11:
        startInternal(r5);
    }

    private void startInternal(DownloadTask r1) {
        addTaskAndThrottleSpeedReset(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void end(final DownloadTask r4) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) > 0) goto L5;
        return;
    L5:
        DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new AnonymousClass2(this, r4));
    }

    private void endInternal(DownloadTask r5) {
        if (Logger.debugScene(r5.getDownloadInfo()) == false) goto L5;
        Logger.taskDebug("globalThrottle", r5.getDownloadInfo(), "endInternal", "task end!");
    L5:
        deleteTaskAndThrottleSpeedReset(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void setGlobalThrottle(final int r4, final int r5) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) > 0) goto L6;
        return;
    L6:
        if (DownloadUtils.isMainThread() == false) goto L8;
        DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new AnonymousClass3(this, r4, r5));
        return;
    L8:
        setGlobalThrottleInternal(r4, r5);
    }

    private void setGlobalThrottleInternal(int r5, int r6) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug("globalThrottle", "setGlobalThrottleInternal", "global throttle speed=" + r5 + ",priority=" + r6);
    L5:
        this.mThrottleSpeed = r5;
        if (r5 != (-1)) goto L8;
        this.mThrottleSpeed = getGlobalThrottleSpeed();
    L8:
        this.mPriority = r6;
        SparseArray r7 = this.mAllTask;
        monitor-enter(r7);
        if (r5 > 0) goto L17;
        if (r5 == (-1)) goto L17;
        if (r5 != (-2)) goto L16;
        dynamicThrottle();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L16:
        this.mThrottleSpeed = 0;     // Catch: Throwable -> L20
        stopThrottle();     // Catch: Throwable -> L20
    L17:
        throttleSpeedReset();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}

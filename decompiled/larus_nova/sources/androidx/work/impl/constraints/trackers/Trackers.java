package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class Trackers {
    private static Trackers sInstance;
    private BatteryChargingTracker mBatteryChargingTracker;
    private BatteryNotLowTracker mBatteryNotLowTracker;
    private NetworkStateTracker mNetworkStateTracker;
    private StorageNotLowTracker mStorageNotLowTracker;

    public BatteryChargingTracker getBatteryChargingTracker() {
        return this.mBatteryChargingTracker;
    }

    public BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.mBatteryNotLowTracker;
    }

    public NetworkStateTracker getNetworkStateTracker() {
        return this.mNetworkStateTracker;
    }

    public StorageNotLowTracker getStorageNotLowTracker() {
        return this.mStorageNotLowTracker;
    }

    public static synchronized void setInstance(Trackers r100) {
        monitor-enter(Trackers.class);
        sInstance = r100;     // Catch: Throwable -> L7
        monitor-exit(Trackers.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Trackers(Context r100, TaskExecutor r101) {
        Context r102 = r100.getApplicationContext();
        this.mBatteryChargingTracker = new BatteryChargingTracker(r102, r101);
        this.mBatteryNotLowTracker = new BatteryNotLowTracker(r102, r101);
        this.mNetworkStateTracker = new NetworkStateTracker(r102, r101);
        this.mStorageNotLowTracker = new StorageNotLowTracker(r102, r101);
    }

    public static synchronized Trackers getInstance(Context r100, TaskExecutor r101) {
        monitor-enter(Trackers.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new Trackers(r100, r101);     // Catch: Throwable -> L10
    L7:
        Trackers r102 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(Trackers.class);
        return r102;
    }
}

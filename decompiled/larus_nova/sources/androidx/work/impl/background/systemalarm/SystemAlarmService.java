package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.utils.WakeLocks;

/* JADX INFO: loaded from: classes17.dex */
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {
    private static final String TAG = null;
    private SystemAlarmDispatcher mDispatcher;
    private boolean mIsShutdown;

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.CommandsCompletedListener
    public void onAllCommandsCompleted() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.checkWakeLocks();
        stopSelf();
    }

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmService");
    }

    private void initializeDispatcher() {
        SystemAlarmDispatcher r100 = new SystemAlarmDispatcher(this);
        this.mDispatcher = r100;
        r100.setCompletedListener(this);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        initializeDispatcher();
        this.mIsShutdown = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        this.mDispatcher.onDestroy();
    }

    public SystemAlarmService() {
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        if (this.mIsShutdown == false) goto L5;
        Logger.get().info(TAG, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
        this.mDispatcher.onDestroy();
        initializeDispatcher();
        this.mIsShutdown = false;
    L5:
        if (r100 == null) goto L9;
        this.mDispatcher.add(r100, r102);
        return 3;
    L9:
        return 3;
    }
}

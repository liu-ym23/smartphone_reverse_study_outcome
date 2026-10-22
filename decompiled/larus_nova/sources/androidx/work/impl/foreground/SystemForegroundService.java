package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes17.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String TAG = null;
    private static SystemForegroundService sForegroundService;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        stopForeground(true);
    L5:
        sForegroundService = null;
        stopSelf();
    }

    static {
        TAG = Logger.tagWithPrefix("SystemFgService");
        sForegroundService = null;
    }

    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher r100 = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = r100;
        r100.setCallback(this);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public SystemForegroundService() {
    }

    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(final int r100) {
        this.mHandler.post(new AnonymousClass3(this, r100));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void notify(final int r100, final Notification r101) {
        this.mHandler.post(new AnonymousClass2(this, r100, r101));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        if (this.mIsShutdown == false) goto L5;
        Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
        this.mDispatcher.onDestroy();
        initializeDispatcher();
        this.mIsShutdown = false;
    L5:
        if (r100 == null) goto L9;
        this.mDispatcher.onStartCommand(r100);
        return 3;
    L9:
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(final int r100, final int r101, final Notification r102) {
        this.mHandler.post(new AnonymousClass1(this, r100, r102, r101));
    }
}

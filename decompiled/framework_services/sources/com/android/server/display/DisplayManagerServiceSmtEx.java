package com.android.server.display;

import android.content.Context;
import android.hardware.display.DisplayManagerInternalSmtEx;
import android.os.Handler;
import android.os.IBinder;
import android.util.Slog;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayManagerServiceSmtEx extends DisplayManagerServiceSmtBase {
    private static final String TAG = "DisplayManagerServiceSmtEx";
    private static final long TIME_OUT = 1000;
    private int mChangedPowerMode;
    private Context mContext;
    private boolean mDisplayPowerModeChanged;
    private Handler mHandler;
    private volatile int mLastPowerMode;
    private final Object mPowerModeLock;
    private Runnable mResetPowerModeRunnable;

    final class LocalServiceSmtEx extends DisplayManagerInternalSmtEx {
        final /* synthetic */ DisplayManagerServiceSmtEx this$0;

        LocalServiceSmtEx(DisplayManagerServiceSmtEx this$0) {
            this.this$0 = this$0;
        }

        public float getScreenBrightness() {
            return -1.0f;
        }

        public void setLastDisplayPowerMode(int mode) {
            this.this$0.setLastDisplayPowerMode(mode);
        }

        public void setAutoBrightness(float brightness) {
        }
    }

    public void init(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }

    public DisplayManagerServiceSmtEx(DisplayManagerService service) {
        super(service);
        this.mPowerModeLock = new Object();
        this.mResetPowerModeRunnable = new AnonymousClass1(this);
    }

    public void setLastDisplayPowerMode(int mode) {
        this.mLastPowerMode = mode;
        Slog.i(TAG, "setLastDisplayPowerMode powerMode=" + this.mLastPowerMode);
    }

    public void setDisplayPowerMode(int powerMode) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MODIFY_USER_PREFERRED_DISPLAY_MODE", null);
        Object r0 = this.mPowerModeLock;     // Catch: Exception -> L17
        monitor-enter(r0);     // Catch: Exception -> L17
    L10:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L6:
        if (this.mLastPowerMode != powerMode) goto L12;
        Slog.i(TAG, "setDisplayPowerMode return by powerMode is same");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        this.mChangedPowerMode = powerMode;     // Catch: Throwable -> L10
        IBinder displayToken = this.mService.getDisplayToken(0);     // Catch: Throwable -> L10
        SurfaceControl.setDisplayPowerMode(displayToken, powerMode);     // Catch: Throwable -> L10
        this.mDisplayPowerModeChanged = true;     // Catch: Throwable -> L10
        Slog.i(TAG, "setPowerMode powerMode=" + powerMode);     // Catch: Throwable -> L10
        this.mHandler.postDelayed(this.mResetPowerModeRunnable, 1000);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public void resetDisplayPowerMode() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MODIFY_USER_PREFERRED_DISPLAY_MODE", null);
        Object r0 = this.mPowerModeLock;     // Catch: Exception -> L22
        monitor-enter(r0);     // Catch: Exception -> L22
    L10:
        th = move-exception;
        throw th;     // Catch: Exception -> L22
    L6:
        if (this.mDisplayPowerModeChanged == true) goto L12;
        Slog.i(TAG, "resetDisplayPowerMode return by powerMode not changed");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        this.mDisplayPowerModeChanged = false;     // Catch: Throwable -> L10
        this.mHandler.removeCallbacks(this.mResetPowerModeRunnable);     // Catch: Throwable -> L10
        if (this.mChangedPowerMode != this.mLastPowerMode) goto L17;
        Slog.i(TAG, "resetDisplayPowerMode return by powerMode is same");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L17:
        IBinder displayToken = this.mService.getDisplayToken(0);     // Catch: Throwable -> L10
        SurfaceControl.setDisplayPowerMode(displayToken, this.mLastPowerMode);     // Catch: Throwable -> L10
        Slog.i(TAG, "resetPowerMode powerMode=" + this.mLastPowerMode);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
    }
}

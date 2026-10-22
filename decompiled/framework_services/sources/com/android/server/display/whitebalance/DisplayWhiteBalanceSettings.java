package com.android.server.display.whitebalance;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.display.color.ColorDisplayService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayWhiteBalanceSettings implements ColorDisplayService.DisplayWhiteBalanceListener {
    private static final int MSG_SET_ACTIVE = 1;
    protected static final String TAG = "DisplayWhiteBalanceSettings";
    private boolean mActive;
    private DisplayWhiteBalanceController.Callbacks mCallbacks;
    private final ColorDisplayService.ColorDisplayServiceInternal mCdsi;
    private final Context mContext;
    private boolean mEnabled;
    private final Handler mHandler;
    protected boolean mLoggingEnabled;

    private final class DisplayWhiteBalanceSettingsHandler extends Handler {
        final /* synthetic */ DisplayWhiteBalanceSettings this$0;

        DisplayWhiteBalanceSettingsHandler(DisplayWhiteBalanceSettings r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L11;
            };
        L5:
            DisplayWhiteBalanceSettings r0 = this.this$0;
            if (msg.arg1 == 0) goto L8;
            boolean r1 = true;
        L9:
            DisplayWhiteBalanceSettings.m4153$$Nest$msetActive(r0, r1);
            DisplayWhiteBalanceSettings.m4154$$Nest$msetEnabled(this.this$0, DisplayWhiteBalanceSettings.m4152$$Nest$fgetmCdsi(this.this$0).isDisplayWhiteBalanceEnabled());
            return;
        L8:
            r1 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCdsi, reason: not valid java name */
    static /* bridge */ /* synthetic */ ColorDisplayService.ColorDisplayServiceInternal m4152$$Nest$fgetmCdsi(DisplayWhiteBalanceSettings r0) {
        return r0.mCdsi;
    }

    /* JADX INFO: renamed from: -$$Nest$msetActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4153$$Nest$msetActive(DisplayWhiteBalanceSettings r0, boolean r1) {
        r0.setActive(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4154$$Nest$msetEnabled(DisplayWhiteBalanceSettings r0, boolean r1) {
        r0.setEnabled(r1);
    }

    public DisplayWhiteBalanceSettings(Context context, Handler handler) {
        validateArguments(context, handler);
        this.mLoggingEnabled = false;
        this.mContext = context;
        this.mHandler = new DisplayWhiteBalanceSettingsHandler(this, handler.getLooper());
        this.mCallbacks = null;
        this.mCdsi = (ColorDisplayService.ColorDisplayServiceInternal) LocalServices.getService(ColorDisplayService.ColorDisplayServiceInternal.class);
        setEnabled(this.mCdsi.isDisplayWhiteBalanceEnabled());
        boolean isActive = this.mCdsi.setDisplayWhiteBalanceListener(this);
        setActive(isActive);
    }

    public boolean setCallbacks(DisplayWhiteBalanceController.Callbacks callbacks) {
        if (this.mCallbacks != callbacks) goto L6;
        return false;
    L6:
        this.mCallbacks = callbacks;
        return true;
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        this.mLoggingEnabled = loggingEnabled;
        return true;
    }

    public boolean isEnabled() {
        if (this.mEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mActive == false) goto L7;
        return true;
    }

    public void dump(PrintWriter writer) {
        writer.println("DisplayWhiteBalanceSettings:");
        writer.println("----------------------------");
        writer.println("  mLoggingEnabled=" + this.mLoggingEnabled);
        writer.println("  mContext=" + this.mContext);
        writer.println("  mHandler=" + this.mHandler);
        writer.println("  mEnabled=" + this.mEnabled);
        writer.println("  mActive=" + this.mActive);
        writer.println("  mCallbacks=" + this.mCallbacks);
    }

    @Override // com.android.server.display.color.ColorDisplayService.DisplayWhiteBalanceListener
    public void onDisplayWhiteBalanceStatusChanged(boolean r4) {
        this.mHandler.obtainMessage(1, r4 ? 1 : 0, 0).sendToTarget();
    }

    private void validateArguments(Context context, Handler handler) {
        context.getClass();
        handler.getClass();
    }

    private void setEnabled(boolean enabled) {
        if (this.mEnabled != enabled) goto L6;
        return;
    L6:
        if (this.mLoggingEnabled == false) goto L8;
        Slog.d(TAG, "Setting: " + enabled);
    L8:
        this.mEnabled = enabled;
        if (this.mCallbacks == null) goto L12;
        this.mCallbacks.updateWhiteBalance();
        return;
    }

    private void setActive(boolean active) {
        if (this.mActive != active) goto L6;
        return;
    L6:
        if (this.mLoggingEnabled == false) goto L8;
        Slog.d(TAG, "Active: " + active);
    L8:
        this.mActive = active;
        if (this.mCallbacks == null) goto L12;
        this.mCallbacks.updateWhiteBalance();
        return;
    }
}

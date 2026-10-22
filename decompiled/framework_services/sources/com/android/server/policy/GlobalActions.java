package com.android.server.policy;

import android.content.Context;
import android.os.Handler;
import android.util.Slog;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes2.dex */
class GlobalActions implements GlobalActionsProvider.GlobalActionsListener {
    private static final boolean DEBUG = true;
    private static final String TAG = "GlobalActions";
    private final Context mContext;
    private boolean mDeviceProvisioned;
    private boolean mGlobalActionsAvailable;
    private final GlobalActionsProvider mGlobalActionsProvider;
    private final Handler mHandler;
    private boolean mKeyguardShowing;
    private LegacyGlobalActions mLegacyGlobalActions;
    private final Runnable mShowTimeout;
    private boolean mShowing;
    private final WindowManagerPolicy.WindowManagerFuncs mWindowManagerFuncs;

    public GlobalActions(Context context, WindowManagerPolicy.WindowManagerFuncs windowManagerFuncs) {
        this.mShowTimeout = new AnonymousClass1(this);
        this.mContext = context;
        this.mHandler = new Handler();
        this.mWindowManagerFuncs = windowManagerFuncs;
        this.mGlobalActionsProvider = (GlobalActionsProvider) LocalServices.getService(GlobalActionsProvider.class);
        if (this.mGlobalActionsProvider == null) goto L5;
        this.mGlobalActionsProvider.setGlobalActionsListener(this);
        return;
    L5:
        Slog.i(TAG, "No GlobalActionsProvider found, defaulting to LegacyGlobalActions");
    }

    private void ensureLegacyCreated() {
        if (this.mLegacyGlobalActions == null) goto L5;
        return;
    L5:
        this.mLegacyGlobalActions = new LegacyGlobalActions(this.mContext, this.mWindowManagerFuncs, new GlobalActions$$ExternalSyntheticLambda0(this));
    }

    public void showDialog(boolean keyguardShowing, boolean deviceProvisioned) {
        Slog.d(TAG, "showDialog " + keyguardShowing + " " + deviceProvisioned);
        if (this.mGlobalActionsProvider != null) goto L5;
    L7:
        this.mKeyguardShowing = keyguardShowing;
        this.mDeviceProvisioned = deviceProvisioned;
        this.mShowing = true;
        if (this.mGlobalActionsAvailable == false) goto L10;
        this.mHandler.postDelayed(this.mShowTimeout, 5000);
        this.mGlobalActionsProvider.showGlobalActions();
        return;
    L10:
        ensureLegacyCreated();
        this.mLegacyGlobalActions.showDialog(this.mKeyguardShowing, this.mDeviceProvisioned);
        return;
    L5:
        if (this.mGlobalActionsProvider.isGlobalActionsDisabled() == false) goto L7;
    }

    @Override // com.android.server.policy.GlobalActionsProvider.GlobalActionsListener
    public void onGlobalActionsShown() {
        Slog.d(TAG, "onGlobalActionsShown");
        this.mHandler.removeCallbacks(this.mShowTimeout);
    }

    @Override // com.android.server.policy.GlobalActionsProvider.GlobalActionsListener
    public void onGlobalActionsDismissed() {
        Slog.d(TAG, "onGlobalActionsDismissed");
        this.mShowing = false;
    }

    @Override // com.android.server.policy.GlobalActionsProvider.GlobalActionsListener
    public void onGlobalActionsAvailableChanged(boolean available) {
        Slog.d(TAG, "onGlobalActionsAvailableChanged " + available);
        this.mGlobalActionsAvailable = available;
        if (this.mShowing == true) goto L5;
        return;
    L5:
        if (this.mGlobalActionsAvailable == true) goto L9;
        this.mHandler.removeCallbacks(this.mShowTimeout);
        ensureLegacyCreated();
        this.mLegacyGlobalActions.showDialog(this.mKeyguardShowing, this.mDeviceProvisioned);
        return;
    }
}

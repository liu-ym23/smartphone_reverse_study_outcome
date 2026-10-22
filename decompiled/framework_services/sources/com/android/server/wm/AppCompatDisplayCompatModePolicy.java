package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatDisplayCompatModePolicy {
    private boolean mIsRestartMenuEnabledForDisplayMove;

    AppCompatDisplayCompatModePolicy() {
    }

    boolean isRestartMenuEnabledForDisplayMove() {
        return false;
    }

    void onMovedToDisplay() {
        this.mIsRestartMenuEnabledForDisplayMove = true;
    }

    void onProcessRestarted() {
        this.mIsRestartMenuEnabledForDisplayMove = false;
    }
}

package com.android.server.policy;

/* JADX INFO: loaded from: classes2.dex */
public interface GlobalActionsProvider {

    public interface GlobalActionsListener {
        void onGlobalActionsAvailableChanged(boolean r1);

        void onGlobalActionsDismissed();

        void onGlobalActionsShown();
    }

    boolean isGlobalActionsDisabled();

    void setGlobalActionsListener(GlobalActionsListener r1);

    void showGlobalActions();
}

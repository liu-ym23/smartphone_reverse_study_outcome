package com.stepos.launcher.assistant.slidepanel;

import android.view.View;

/* loaded from: classes.dex */
public interface IOverlayAllTasksEntryListener {
    void onAllTasksEntryVisibilityChanged(boolean z10);

    default void onOverlayPageIndicatorClicked(View view) {
        if (view != null) {
            OverlayAllTasksBroadcastHelper.openAllSessions(view.getContext(), view);
        }
    }
}

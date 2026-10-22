package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
interface WindowContainerListener extends ConfigurationContainerListener {
    default void onDisplayChanged(DisplayContent dc) {
    }

    default void onRemoved() {
    }

    default void onVisibleRequestedChanged(boolean isVisibleRequested) {
    }
}

package com.android.server.wm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtActivityClientController extends IExtBase {
    default boolean supportFreefrom(int taskId) {
        return false;
    }

    default boolean toggleSwitchFromFullScreenToFreeform(int taskId, int startMode) {
        return false;
    }

    default void scheduleExecutePendingToggleSwitchFromFullScreenToFreeform(String reason) {
    }
}

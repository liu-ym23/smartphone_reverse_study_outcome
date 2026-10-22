package com.android.server.notification;

import android.content.IntentFilter;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface INotificationManagerOptEx {
    default void addAction(IntentFilter filter) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void receiveAction(String action) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean inSleepMode() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}

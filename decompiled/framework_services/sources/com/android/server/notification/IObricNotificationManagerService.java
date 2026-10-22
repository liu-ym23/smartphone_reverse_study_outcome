package com.android.server.notification;

import android.app.IObricNotificationManager;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricNotificationManagerService extends IObricBase {
    default void allowNotificationListenerForSpecificApps() {
    }

    default void onPanelShown() {
    }

    default void onPanelHidden() {
    }

    default IObricNotificationManager getIObricExt() {
        return null;
    }
}

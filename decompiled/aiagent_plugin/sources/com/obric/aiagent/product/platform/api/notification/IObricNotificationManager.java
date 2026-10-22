package com.obric.aiagent.product.platform.api.notification;

/* JADX INFO: compiled from: IObricNotificationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricNotificationManager {
    boolean isPanelShown();

    boolean registerNotificationListener(ObricNotificationListener r1);

    boolean registerToastShowListener(ObricToastShowListener r1);

    boolean unregisterNotificationListener(ObricNotificationListener r1);

    boolean unregisterToastShowListener(ObricToastShowListener r1);
}

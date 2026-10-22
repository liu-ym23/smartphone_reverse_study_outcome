package com.android.server.notification;

import android.app.Notification;

/* JADX INFO: loaded from: classes2.dex */
interface NotificationManagerPrivate {
    NotificationRecord getNotificationByKey(String r1);

    boolean isBlockSoundAndVibrate(String r1, Notification r2);

    boolean isBlockedSound(String r1);

    void timeoutNotification(String r1);
}

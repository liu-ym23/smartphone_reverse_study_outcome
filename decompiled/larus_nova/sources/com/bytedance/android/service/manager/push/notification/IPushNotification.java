package com.bytedance.android.service.manager.push.notification;

import android.app.Notification;

/* JADX INFO: loaded from: classes12.dex */
public interface IPushNotification {
    Notification getNotification();

    void show();

    void show(String r100, int r101);
}

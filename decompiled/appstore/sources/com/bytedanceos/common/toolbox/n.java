package com.bytedanceos.common.toolbox;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public n() {
    }

    public Notification.Builder a(Notification.Builder r10) {
        ((NotificationManager) BaseApplication.c().getSystemService("notification")).createNotificationChannel(new NotificationChannel("1", BaseApplication.c().getClass().getSimpleName(), 2));
        r10.setChannelId("1");
        return r10;
    }

    public androidx.core.app.h b(androidx.core.app.h r10) {
        ((NotificationManager) BaseApplication.c().getSystemService("notification")).createNotificationChannel(new NotificationChannel("1", BaseApplication.c().getClass().getSimpleName(), 2));
        r10.e("1");
        return r10;
    }
}

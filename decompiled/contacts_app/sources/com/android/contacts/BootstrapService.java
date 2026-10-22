package com.android.contacts;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class BootstrapService extends Service {
    private static final String FOREGROUND_CHANNEL_ID = "forgound_channel_id";

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public BootstrapService() {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(this);
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    public static void startForeground(Service r4) {
        NotificationChannel r0 = new NotificationChannel(FOREGROUND_CHANNEL_ID, "foreground", 3);
        ((NotificationManager) r4.getSystemService("notification")).createNotificationChannel(r0);
        r4.startForeground(8888, new Notification.Builder(r4, FOREGROUND_CHANNEL_ID).build());
    }
}

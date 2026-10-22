package com.bytedance.android.service.manager.push.notification;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface INotificationMonitorService {
    boolean enableMonitorNotificationShow();

    boolean onForeGroundNotificationShow(ComponentName r100, Notification r101);

    void onPendingIntent(Object r100, Intent r101);
}

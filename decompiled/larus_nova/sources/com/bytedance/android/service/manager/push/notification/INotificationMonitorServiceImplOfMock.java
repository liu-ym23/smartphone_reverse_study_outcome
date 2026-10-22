package com.bytedance.android.service.manager.push.notification;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes12.dex */
public class INotificationMonitorServiceImplOfMock implements INotificationMonitorService {
    public INotificationMonitorServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.push.notification.INotificationMonitorService
    public boolean enableMonitorNotificationShow() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.notification.INotificationMonitorService
    public boolean onForeGroundNotificationShow(ComponentName r100, Notification r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.push.notification.INotificationMonitorService
    public void onPendingIntent(Object r100, Intent r101) {
    }
}

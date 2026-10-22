package com.android.server.notification;

import android.net.Uri;
import android.os.UserHandle;
import android.service.notification.ZenModeConfig;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class CustomManualConditionProvider extends SystemConditionProviderService {
    private static final String SIMPLE_NAME = null;

    public CustomManualConditionProvider() {
    }

    static {
        SIMPLE_NAME = CustomManualConditionProvider.class.getSimpleName();
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public boolean isValidConditionId(Uri id) {
        return ZenModeConfig.isValidCustomManualConditionId(id);
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onBootComplete() {
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onUserSwitched(UserHandle user) {
    }

    @Override // android.service.notification.ConditionProviderService
    public void onConnected() {
    }

    @Override // android.service.notification.ConditionProviderService
    public void onSubscribe(Uri conditionId) {
    }

    @Override // android.service.notification.ConditionProviderService
    public void onUnsubscribe(Uri conditionId) {
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void dump(PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        pw.print("    ");
        pw.print(SIMPLE_NAME);
        pw.println(": ENABLED");
    }
}

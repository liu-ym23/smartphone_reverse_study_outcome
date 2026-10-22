package com.android.server.notification;

import android.content.Context;
import android.os.Handler;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationHistoryDatabaseFactory {
    private static NotificationHistoryDatabase sTestingNotificationHistoryDb;

    public NotificationHistoryDatabaseFactory() {
    }

    public static void setTestingNotificationHistoryDatabase(NotificationHistoryDatabase db) {
        sTestingNotificationHistoryDb = db;
    }

    public static NotificationHistoryDatabase create(Context context, Handler handler, File rootDir) {
        if (sTestingNotificationHistoryDb == null) goto L7;
        return sTestingNotificationHistoryDb;
    L7:
        return new NotificationHistoryDatabase(handler, rootDir);
    }
}

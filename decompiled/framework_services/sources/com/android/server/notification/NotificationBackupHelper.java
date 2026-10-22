package com.android.server.notification;

import android.app.INotificationManager;
import android.app.backup.BlobBackupHelper;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationBackupHelper extends BlobBackupHelper {
    static final int BLOB_VERSION = 1;
    static final boolean DEBUG = false;
    static final String TAG = "NotifBackupHelper";
    private final NotificationManagerInternal mNm;
    private final int mUserId;

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public NotificationBackupHelper(int userId) {
        super(1, new String[]{"notifications"});
        this.mUserId = userId;
        this.mNm = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
    }

    protected byte[] getBackupPayload(String key) {
        if ("notifications".equals(key) == false) goto L11;
        INotificationManager nm = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));     // Catch: Exception -> L6
        byte[] newPayload = nm.getBackupPayload(this.mUserId);     // Catch: Exception -> L6
        return newPayload;
    L6:
        e = move-exception;
        Slog.e(TAG, "Couldn't communicate with notification manager", e);
        return null;
    L11:
        return null;
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (DEBUG == false) goto L6;
        Slog.v(TAG, "Got restore of " + key);
    L6:
        if ("notifications".equals(key) == false) goto L14;
        INotificationManager nm = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));     // Catch: Exception -> L9
        nm.applyRestore(payload, this.mUserId);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Couldn't communicate with notification manager", e);
        return;
    }
}

package com.android.server.backup;

import android.app.backup.BlobBackupHelper;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.locales.LocaleManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class AppSpecificLocalesBackupHelper extends BlobBackupHelper {
    private static final int BLOB_VERSION = 1;
    private static final String DATA_TYPE_APP_LOCALES = "app_locales:locales";
    private static final boolean DEBUG = false;
    private static final String ERROR_BACKUP_FAILED = "backup_failed";
    private static final String ERROR_RESTORE_FAILED = "restore_failed";
    private static final String ERROR_UNEXPECTED_KEY = "unexpected_key";
    private static final String KEY_APP_LOCALES = "app_locales";
    private static final String TAG = "AppLocalesBackupHelper";
    private final LocaleManagerInternal mLocaleManagerInternal;
    private final int mUserId;

    public AppSpecificLocalesBackupHelper(int userId) {
        super(1, new String[]{KEY_APP_LOCALES});
        this.mUserId = userId;
        this.mLocaleManagerInternal = (LocaleManagerInternal) LocalServices.getService(LocaleManagerInternal.class);
    }

    protected byte[] getBackupPayload(String key) {
        if (KEY_APP_LOCALES.equals(key) == true) goto L10;
        Slog.w(TAG, "Unexpected backup key " + key);
        getLogger().logItemsBackupFailed(DATA_TYPE_APP_LOCALES, 1, ERROR_UNEXPECTED_KEY);
        return null;
    L10:
        byte[] newPayload = this.mLocaleManagerInternal.getBackupPayload(this.mUserId);     // Catch: Exception -> L6
        getLogger().logItemsBackedUp(DATA_TYPE_APP_LOCALES, 1);     // Catch: Exception -> L6
        return newPayload;
    L6:
        e = move-exception;
        Slog.e(TAG, "Couldn't communicate with locale manager", e);
        getLogger().logItemsBackupFailed(DATA_TYPE_APP_LOCALES, 1, ERROR_BACKUP_FAILED);
        return null;
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (KEY_APP_LOCALES.equals(key) == true) goto L10;
        Slog.w(TAG, "Unexpected restore key " + key);
        getLogger().logItemsBackupFailed(DATA_TYPE_APP_LOCALES, 1, ERROR_UNEXPECTED_KEY);
        return;
    L10:
        this.mLocaleManagerInternal.stageAndApplyRestoredPayload(payload, this.mUserId);     // Catch: Exception -> L6
        getLogger().logItemsRestored(DATA_TYPE_APP_LOCALES, 1);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Couldn't communicate with locale manager", e);
        getLogger().logItemsRestoreFailed(DATA_TYPE_APP_LOCALES, 1, ERROR_RESTORE_FAILED);
    }
}

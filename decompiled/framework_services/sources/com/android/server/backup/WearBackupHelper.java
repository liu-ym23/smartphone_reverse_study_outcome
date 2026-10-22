package com.android.server.backup;

import android.app.backup.BlobBackupHelper;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes.dex */
public class WearBackupHelper extends BlobBackupHelper {
    private static final int BLOB_VERSION = 1;
    private static final String KEY_WEAR_BACKUP = "wear";
    private final WearBackupInternal mWearBackupInternal;

    public WearBackupHelper() {
        super(1, new String[]{KEY_WEAR_BACKUP});
        this.mWearBackupInternal = (WearBackupInternal) LocalServices.getService(WearBackupInternal.class);
    }

    protected byte[] getBackupPayload(String key) {
        if (KEY_WEAR_BACKUP.equals(key) == true) goto L5;
    L7:
        return null;
    L5:
        if (this.mWearBackupInternal == null) goto L7;
        return this.mWearBackupInternal.getBackupPayload(getLogger());
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (KEY_WEAR_BACKUP.equals(key) == true) goto L5;
        return;
    L5:
        if (this.mWearBackupInternal == null) goto L9;
        this.mWearBackupInternal.applyRestoredPayload(payload);
        return;
    }
}

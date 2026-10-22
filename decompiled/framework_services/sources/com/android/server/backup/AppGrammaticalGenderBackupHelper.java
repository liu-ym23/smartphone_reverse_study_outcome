package com.android.server.backup;

import android.app.backup.BackupDataOutput;
import android.app.backup.BlobBackupHelper;
import android.os.ParcelFileDescriptor;
import com.android.server.LocalServices;
import com.android.server.grammaticalinflection.GrammaticalInflectionManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class AppGrammaticalGenderBackupHelper extends BlobBackupHelper {
    private static final int BLOB_VERSION = 1;
    private static final String KEY_APP_GENDER = "app_gender";
    private final GrammaticalInflectionManagerInternal mGrammarInflectionManagerInternal;
    private final int mUserId;

    public AppGrammaticalGenderBackupHelper(int userId) {
        super(1, new String[]{KEY_APP_GENDER});
        this.mUserId = userId;
        this.mGrammarInflectionManagerInternal = (GrammaticalInflectionManagerInternal) LocalServices.getService(GrammaticalInflectionManagerInternal.class);
    }

    public void performBackup(ParcelFileDescriptor oldStateFd, BackupDataOutput data, ParcelFileDescriptor newStateFd) {
        if ((data.getTransportFlags() & 1) != 0) goto L5;
        return;
    L5:
        super.performBackup(oldStateFd, data, newStateFd);
    }

    protected byte[] getBackupPayload(String key) {
        if (KEY_APP_GENDER.equals(key) == true) goto L5;
    L7:
        return null;
    L5:
        if (this.mGrammarInflectionManagerInternal == null) goto L7;
        return this.mGrammarInflectionManagerInternal.getBackupPayload(this.mUserId);
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (KEY_APP_GENDER.equals(key) == true) goto L5;
        return;
    L5:
        if (this.mGrammarInflectionManagerInternal == null) goto L9;
        this.mGrammarInflectionManagerInternal.stageAndApplyRestoredPayload(payload, this.mUserId);
        return;
    }
}

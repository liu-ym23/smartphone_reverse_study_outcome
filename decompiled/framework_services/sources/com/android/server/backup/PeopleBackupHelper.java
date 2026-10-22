package com.android.server.backup;

import android.app.backup.BlobBackupHelper;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.people.PeopleServiceInternal;

/* JADX INFO: loaded from: classes.dex */
class PeopleBackupHelper extends BlobBackupHelper {
    private static final boolean DEBUG = false;
    private static final String KEY_CONVERSATIONS = "people_conversation_infos";
    private static final int STATE_VERSION = 1;
    private static final String TAG = null;
    private final int mUserId;

    static {
        TAG = PeopleBackupHelper.class.getSimpleName();
    }

    PeopleBackupHelper(int userId) {
        super(1, new String[]{KEY_CONVERSATIONS});
        this.mUserId = userId;
    }

    protected byte[] getBackupPayload(String key) {
        if (KEY_CONVERSATIONS.equals(key) == true) goto L6;
        Slog.w(TAG, "Unexpected backup key " + key);
        return new byte[0];
    L6:
        PeopleServiceInternal ps = (PeopleServiceInternal) LocalServices.getService(PeopleServiceInternal.class);
        return ps.getBackupPayload(this.mUserId);
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (KEY_CONVERSATIONS.equals(key) == true) goto L6;
        Slog.w(TAG, "Unexpected restore key " + key);
        return;
    L6:
        PeopleServiceInternal ps = (PeopleServiceInternal) LocalServices.getService(PeopleServiceInternal.class);
        ps.restore(this.mUserId, payload);
    }
}

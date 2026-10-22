package com.android.server.backup;

import android.app.backup.BlobBackupHelper;
import android.app.usage.UsageStatsManagerInternal;
import com.android.server.LocalServices;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class UsageStatsBackupHelper extends BlobBackupHelper {
    static final int BLOB_VERSION = 1;
    static final boolean DEBUG = false;
    static final String KEY_USAGE_STATS = "usage_stats";
    static final String TAG = "UsgStatsBackupHelper";
    private final int mUserId;

    public UsageStatsBackupHelper(int userId) {
        super(1, new String[]{KEY_USAGE_STATS});
        this.mUserId = userId;
    }

    protected byte[] getBackupPayload(String key) {
        if (KEY_USAGE_STATS.equals(key) == false) goto L11;
        UsageStatsManagerInternal localUsageStatsManager = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        out.writeInt(0);     // Catch: IOException -> L7
        out.write(localUsageStatsManager.getBackupPayload(this.mUserId, key));     // Catch: IOException -> L7
    L10:
        return baos.toByteArray();
    L8:
        baos.reset();
        goto L10
    L11:
        return null;
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (KEY_USAGE_STATS.equals(key) == false) goto L11;
        UsageStatsManagerInternal localUsageStatsManager = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(payload));
        in.readInt();     // Catch: IOException -> L7
        byte[] restoreData = new byte[payload.length - 4];     // Catch: IOException -> L7
        in.read(restoreData, 0, restoreData.length);     // Catch: IOException -> L7
        localUsageStatsManager.applyRestoredPayload(this.mUserId, key, restoreData);     // Catch: IOException -> L7
        return;
    L8:
        return;
    }
}

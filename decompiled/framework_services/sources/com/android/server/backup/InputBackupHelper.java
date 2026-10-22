package com.android.server.backup;

import android.app.backup.BlobBackupHelper;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.input.InputManagerInternal;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InputBackupHelper extends BlobBackupHelper {
    private static final int BLOB_VERSION = 1;
    private static final String KEY_INPUT_GESTURES = "input_gestures";
    private static final String TAG = "InputBackupHelper";
    private final InputManagerInternal mInputManagerInternal;
    private final int mUserId;

    public InputBackupHelper(int userId) {
        super(1, new String[]{KEY_INPUT_GESTURES});
        this.mUserId = userId;
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
    }

    protected byte[] getBackupPayload(String key) {
        Map<Integer, byte[]> payloads = this.mInputManagerInternal.getBackupPayload(this.mUserId);     // Catch: Exception -> L9
        if (KEY_INPUT_GESTURES.equals(key) == true) goto L7;
        return null;
    L7:
        return payloads.getOrDefault(0, null);
    L9:
        exception = move-exception;
        Slog.e(TAG, "Failed to get backup payload for input gestures", exception);
        return null;
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        Map<Integer, byte[]> payloads = new HashMap();
        if (KEY_INPUT_GESTURES.equals(key) == false) goto L10;
        payloads.put(0, payload);
    L10:
        this.mInputManagerInternal.applyBackupPayload(payloads, this.mUserId);     // Catch: Exception -> L7
        return;
    L7:
        exception = move-exception;
        Slog.e(TAG, "Failed to apply input backup payload", exception);
    }
}

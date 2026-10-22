package com.android.server.display;

import android.app.backup.BlobBackupHelper;
import android.hardware.display.DisplayManagerInternal;
import android.util.AtomicFile;
import android.util.AtomicFileOutputStream;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.utils.DebugUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayBackupHelper extends BlobBackupHelper {
    private static final int BLOB_VERSION = 1;
    private static final boolean DEBUG = false;
    private static final String KEY_DISPLAY = "display";
    private static final String TAG = "DisplayBackupHelper";
    private final Injector mInjector;
    private final int mUserId;

    static class Injector {
        private final boolean mIsDisplayTopologyEnabled;

        Injector() {
            this.mIsDisplayTopologyEnabled = new DisplayManagerFlags().isDisplayTopologyEnabled();
        }

        boolean isDisplayTopologyFlagEnabled() {
            return this.mIsDisplayTopologyEnabled;
        }

        DisplayManagerInternal getDisplayManagerInternal() {
            return (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        }

        byte[] readTopologyFile(int userId) throws IOException {
            return getTopologyFile(userId).readFully();
        }

        AtomicFileOutputStream writeTopologyFile(int userId) throws IOException {
            return new AtomicFileOutputStream(getTopologyFile(userId));
        }

        private AtomicFile getTopologyFile(int userId) {
            return new AtomicFile(DisplayTopologyXmlStore.getUserTopologyFile(userId), "topology-state");
        }
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    public DisplayBackupHelper(int userId) {
        this(userId, new Injector());
    }

    DisplayBackupHelper(int userId, Injector injector) {
        super(1, new String[]{KEY_DISPLAY});
        this.mUserId = userId;
        this.mInjector = injector;
    }

    protected byte[] getBackupPayload(String key) {
        if (KEY_DISPLAY.equals(key) == true) goto L5;
    L14:
        return null;
    L5:
        if (this.mInjector.isDisplayTopologyFlagEnabled() == false) goto L14;
        byte[] result = this.mInjector.readTopologyFile(this.mUserId);     // Catch: IOException -> L9
        Slog.i(TAG, "getBackupPayload for " + key + " done, size=" + result.length);     // Catch: IOException -> L9
        return result;
    L9:
        e = move-exception;
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Skip topology backup", e);
    L13:
        return null;
    }

    protected void applyRestoredPayload(String key, byte[] payload) {
        if (KEY_DISPLAY.equals(key) == true) goto L5;
        return;
    L5:
        if (this.mInjector.isDisplayTopologyFlagEnabled() == false) goto L34;
        AtomicFileOutputStream oStream = this.mInjector.writeTopologyFile(this.mUserId);     // Catch: IOException -> L16
        oStream.write(payload);     // Catch: Throwable -> L18
        oStream.markSuccess();     // Catch: Throwable -> L18
        Slog.i(TAG, "applyRestoredPayload for " + key + " size=" + payload.length + " to " + oStream);     // Catch: Throwable -> L18
        oStream.close();     // Catch: IOException -> L16
        DisplayManagerInternal displayManagerInternal = this.mInjector.getDisplayManagerInternal();
        if (displayManagerInternal != null) goto L14;
        Slog.e(TAG, "DisplayManagerInternal is null");
        return;
    L14:
        displayManagerInternal.reloadTopologies(this.mUserId);
        return;
    L18:
        th = move-exception;
        if (oStream != null) goto L31;
    L25:
        throw th;     // Catch: IOException -> L16
    L31:
        oStream.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "applyRestoredPayload failed", e);
        return;
    }
}

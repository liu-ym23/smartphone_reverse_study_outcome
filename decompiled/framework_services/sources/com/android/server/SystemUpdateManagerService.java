package com.android.server;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.ISystemUpdateManager;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SystemUpdateManagerService extends ISystemUpdateManager.Stub {
    private static final String INFO_FILE = "system-update-info.xml";
    private static final int INFO_FILE_VERSION = 0;
    private static final String KEY_BOOT_COUNT = "boot-count";
    private static final String KEY_INFO_BUNDLE = "info-bundle";
    private static final String KEY_UID = "uid";
    private static final String KEY_VERSION = "version";
    private static final String TAG = "SystemUpdateManagerService";
    private static final String TAG_INFO = "info";
    private static final int UID_UNKNOWN = -1;
    private final Context mContext;
    private final AtomicFile mFile;
    private int mLastStatus;
    private int mLastUid;
    private final Object mLock;

    public SystemUpdateManagerService(Context context) {
        this.mLock = new Object();
        this.mLastUid = -1;
        this.mLastStatus = 0;
        this.mContext = context;
        this.mFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), INFO_FILE));
        Object r0 = this.mLock;
        monitor-enter(r0);
        loadSystemUpdateInfoLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateSystemUpdateInfo(PersistableBundle infoBundle) {
        updateSystemUpdateInfo_enforcePermission();
        int status = infoBundle.getInt("status", 0);
        if (status != 0) goto L6;
        Slog.w(TAG, "Invalid status info. Ignored");
        return;
    L6:
        int uid = Binder.getCallingUid();
        if (this.mLastUid != (-1)) goto L9;
    L14:
        Object r2 = this.mLock;
        monitor-enter(r2);
        saveSystemUpdateInfoLocked(infoBundle, uid);     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L9:
        if (this.mLastUid == uid) goto L14;
        if (status != 1) goto L14;
        Slog.i(TAG, "Inactive updater reporting IDLE status. Ignored");
    }

    public Bundle retrieveSystemUpdateInfo() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.READ_SYSTEM_UPDATE_INFO") == (-1)) goto L5;
    L9:
        Object r0 = this.mLock;
        monitor-enter(r0);
        Bundle r1 = loadSystemUpdateInfoLocked();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.RECOVERY") != (-1)) goto L9;
        throw new SecurityException("Can't read system update info. Requiring READ_SYSTEM_UPDATE_INFO or RECOVERY permission.");
    }

    private Bundle loadSystemUpdateInfoLocked() {
        PersistableBundle loadedBundle = null;
        FileInputStream fis = this.mFile.openRead();     // Catch: IOException -> L9 XmlPullParserException -> L11 FileNotFoundException -> L13
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L16
        loadedBundle = readInfoFileLocked(parser);     // Catch: Throwable -> L16
        if (fis == null) goto L27;
        fis.close();     // Catch: IOException -> L9 XmlPullParserException -> L11 FileNotFoundException -> L13
    L27:
        if (loadedBundle == null) goto L29;
        int version = loadedBundle.getInt(KEY_VERSION, -1);
        if (version != (-1)) goto L34;
        Slog.w(TAG, "Invalid info file (invalid version). Ignored");
        return removeInfoFileAndGetDefaultInfoBundleLocked();
    L34:
        int lastUid = loadedBundle.getInt("uid", -1);
        if (lastUid != (-1)) goto L38;
        Slog.w(TAG, "Invalid info file (invalid UID). Ignored");
        return removeInfoFileAndGetDefaultInfoBundleLocked();
    L38:
        int lastBootCount = loadedBundle.getInt(KEY_BOOT_COUNT, -1);
        if (lastBootCount != (-1)) goto L41;
    L53:
        Slog.w(TAG, "Outdated info file. Ignored");
        return removeInfoFileAndGetDefaultInfoBundleLocked();
    L41:
        if (lastBootCount != getBootCount()) goto L53;
        PersistableBundle infoBundle = loadedBundle.getPersistableBundle(KEY_INFO_BUNDLE);
        if (infoBundle != null) goto L47;
        Slog.w(TAG, "Invalid info file (missing info). Ignored");
        return removeInfoFileAndGetDefaultInfoBundleLocked();
    L47:
        int lastStatus = infoBundle.getInt("status", 0);
        if (lastStatus != 0) goto L51;
        Slog.w(TAG, "Invalid info file (invalid status). Ignored");
        return removeInfoFileAndGetDefaultInfoBundleLocked();
    L51:
        this.mLastStatus = lastStatus;
        this.mLastUid = lastUid;
        return new Bundle(infoBundle);
    L29:
        return removeInfoFileAndGetDefaultInfoBundleLocked();
    L16:
        th = move-exception;
        if (fis != null) goto L55;
    L23:
        throw th;     // Catch: IOException -> L9 XmlPullParserException -> L11 FileNotFoundException -> L13
    L55:
        fis.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L9 XmlPullParserException -> L11 FileNotFoundException -> L13
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to read the info file:", e);
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to parse the info file:", e);
        goto L27
    L26:
        Slog.i(TAG, "No existing info file " + this.mFile.getBaseFile());
        goto L27
    }

    private void saveSystemUpdateInfoLocked(PersistableBundle infoBundle, int uid) {
        PersistableBundle outBundle = new PersistableBundle();
        outBundle.putPersistableBundle(KEY_INFO_BUNDLE, infoBundle);
        outBundle.putInt(KEY_VERSION, 0);
        outBundle.putInt("uid", uid);
        outBundle.putInt(KEY_BOOT_COUNT, getBootCount());
        if (writeInfoFileLocked(outBundle) == false) goto L6;
        this.mLastUid = uid;
        this.mLastStatus = infoBundle.getInt("status");
        return;
    }

    private PersistableBundle readInfoFileLocked(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
    L2:
        int type = parser.next();
        if (type == 1) goto L10;
        if (type != 2) goto L2;
        if (TAG_INFO.equals(parser.getName()) == false) goto L2;
        return PersistableBundle.restoreFromXml(parser);
    L10:
        return null;
    }

    private boolean writeInfoFileLocked(PersistableBundle outBundle) {
        FileOutputStream fos = null;
        fos = this.mFile.startWrite();     // Catch: Throwable -> L5
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: Throwable -> L5
        out.startDocument(null, true);     // Catch: Throwable -> L5
        out.startTag(null, TAG_INFO);     // Catch: Throwable -> L5
        outBundle.saveToXml(out);     // Catch: Throwable -> L5
        out.endTag(null, TAG_INFO);     // Catch: Throwable -> L5
        out.endDocument();     // Catch: Throwable -> L5
        this.mFile.finishWrite(fos);     // Catch: Throwable -> L5
        return true;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to save the info file:", e);
        if (fos == null) goto L13;
        this.mFile.failWrite(fos);
        return false;
    L13:
        return false;
    }

    private Bundle removeInfoFileAndGetDefaultInfoBundleLocked() {
        if (this.mFile.exists() == false) goto L5;
        Slog.i(TAG, "Removing info file");
        this.mFile.delete();
    L5:
        this.mLastStatus = 0;
        this.mLastUid = -1;
        Bundle infoBundle = new Bundle();
        infoBundle.putInt("status", 0);
        return infoBundle;
    }

    private int getBootCount() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "boot_count", 0);
    }
}

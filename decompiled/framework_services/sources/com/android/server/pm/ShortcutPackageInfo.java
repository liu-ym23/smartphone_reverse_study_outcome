package com.android.server.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Slog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.backup.BackupUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import libcore.util.HexEncoding;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ShortcutPackageInfo {
    private static final String ATTR_BACKUP_ALLOWED = "allow-backup";
    private static final String ATTR_BACKUP_ALLOWED_INITIALIZED = "allow-backup-initialized";
    private static final String ATTR_BACKUP_SOURCE_BACKUP_ALLOWED = "bk_src_backup-allowed";
    private static final String ATTR_BACKUP_SOURCE_VERSION = "bk_src_version";
    private static final String ATTR_LAST_UPDATE_TIME = "last_udpate_time";
    private static final String ATTR_SHADOW = "shadow";
    private static final String ATTR_SIGNATURE_HASH = "hash";
    private static final String ATTR_VERSION = "version";
    private static final String TAG = "ShortcutService";
    static final String TAG_ROOT = "package-info";
    private static final String TAG_SIGNATURE = "signature";
    private boolean mBackupAllowed;
    private boolean mBackupAllowedInitialized;
    private boolean mBackupSourceBackupAllowed;
    private long mBackupSourceVersionCode;
    private boolean mIsShadow;
    private long mLastUpdateTime;
    private ArrayList<byte[]> mSigHashes;
    private long mVersionCode;

    private ShortcutPackageInfo(long versionCode, long lastUpdateTime, ArrayList<byte[]> sigHashes, boolean isShadow) {
        this.mVersionCode = -1;
        this.mBackupSourceVersionCode = -1;
        this.mVersionCode = versionCode;
        this.mLastUpdateTime = lastUpdateTime;
        this.mIsShadow = isShadow;
        this.mSigHashes = sigHashes;
        this.mBackupAllowed = false;
        this.mBackupSourceBackupAllowed = false;
    }

    public static ShortcutPackageInfo newEmpty() {
        return new ShortcutPackageInfo(-1, 0, new ArrayList(0), false);
    }

    public boolean isShadow() {
        return this.mIsShadow;
    }

    public void setShadow(boolean shadow) {
        this.mIsShadow = shadow;
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public long getBackupSourceVersionCode() {
        return this.mBackupSourceVersionCode;
    }

    public boolean isBackupSourceBackupAllowed() {
        return this.mBackupSourceBackupAllowed;
    }

    public long getLastUpdateTime() {
        return this.mLastUpdateTime;
    }

    public boolean isBackupAllowed() {
        return this.mBackupAllowed;
    }

    public void updateFromPackageInfo(PackageInfo pi) {
        if (pi == null) goto L5;
        this.mVersionCode = pi.getLongVersionCode();
        this.mLastUpdateTime = pi.lastUpdateTime;
        this.mBackupAllowed = ShortcutService.shouldBackupApp(pi);
        this.mBackupAllowedInitialized = true;
        return;
    }

    public boolean hasSignatures() {
        if (this.mSigHashes.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int canRestoreTo(ShortcutService s, PackageInfo currentPackage, boolean anyVersionOkay) {
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (BackupUtils.signaturesMatch(this.mSigHashes, currentPackage, pmi) == true) goto L7;
        Slog.w(TAG, "Can't restore: Package signature mismatch");
        return 102;
    L7:
        if (ShortcutService.shouldBackupApp(currentPackage) == true) goto L9;
    L18:
        Slog.w(TAG, "Can't restore: package didn't or doesn't allow backup");
        return 101;
    L9:
        if (this.mBackupSourceBackupAllowed == false) goto L18;
        if (anyVersionOkay == false) goto L13;
        return 0;
    L13:
        if (currentPackage.getLongVersionCode() >= this.mBackupSourceVersionCode) goto L20;
        Slog.w(TAG, String.format("Can't restore: package current version %d < backed up version %d", new Object[]{Long.valueOf(currentPackage.getLongVersionCode()), Long.valueOf(this.mBackupSourceVersionCode)}));
        return 100;
    L20:
        return 0;
    }

    public static ShortcutPackageInfo generateForInstalledPackageForTest(ShortcutService s, String packageName, int packageUserId) {
        PackageInfo pi = s.getPackageInfoWithSignatures(packageName, packageUserId);
        SigningInfo signingInfo = pi.signingInfo;
        if (signingInfo != null) goto L6;
        Slog.e(TAG, "Can't get signatures: package=" + packageName);
        return null;
    L6:
        Signature[] signatures = signingInfo.getApkContentsSigners();
        ShortcutPackageInfo ret = new ShortcutPackageInfo(pi.getLongVersionCode(), pi.lastUpdateTime, BackupUtils.hashSignatureArray(signatures), false);
        ret.mBackupSourceBackupAllowed = ShortcutService.shouldBackupApp(pi);
        ret.mBackupSourceVersionCode = pi.getLongVersionCode();
        return ret;
    }

    public void refreshSignature(ShortcutService s, ShortcutPackageItem pkg) {
        if (this.mIsShadow == false) goto L6;
        s.wtf("Attempted to refresh package info for shadow package " + pkg.getPackageName() + ", user=" + pkg.getOwnerUserId());
        return;
    L6:
        PackageInfo pi = s.getPackageInfoWithSignatures(pkg.getPackageName(), pkg.getPackageUserId());
        if (pi != null) goto L10;
        Slog.w(TAG, "Package not found: " + pkg.getPackageName());
        return;
    L10:
        SigningInfo signingInfo = pi.signingInfo;
        if (signingInfo != null) goto L14;
        Slog.w(TAG, "Not refreshing signature for " + pkg.getPackageName() + " since it appears to have no signing info.");
        return;
    L14:
        Signature[] signatures = signingInfo.getApkContentsSigners();
        this.mSigHashes = BackupUtils.hashSignatureArray(signatures);
    }

    public void saveToXml(ShortcutService s, TypedXmlSerializer out, boolean forBackup) throws IOException {
        if (forBackup == true) goto L4;
    L6:
        out.startTag(null, TAG_ROOT);
        ShortcutService.writeAttr(out, ATTR_VERSION, this.mVersionCode);
        ShortcutService.writeAttr(out, ATTR_LAST_UPDATE_TIME, this.mLastUpdateTime);
        ShortcutService.writeAttr(out, ATTR_SHADOW, this.mIsShadow);
        ShortcutService.writeAttr(out, ATTR_BACKUP_ALLOWED, this.mBackupAllowed);
        ShortcutService.writeAttr(out, ATTR_BACKUP_ALLOWED_INITIALIZED, this.mBackupAllowedInitialized);
        ShortcutService.writeAttr(out, ATTR_BACKUP_SOURCE_VERSION, this.mBackupSourceVersionCode);
        ShortcutService.writeAttr(out, ATTR_BACKUP_SOURCE_BACKUP_ALLOWED, this.mBackupSourceBackupAllowed);
        int i = 0;
    L8:
        if (i >= this.mSigHashes.size()) goto L10;
        out.startTag(null, TAG_SIGNATURE);
        String encoded = Base64.getEncoder().encodeToString(this.mSigHashes.get(i));
        ShortcutService.writeAttr(out, ATTR_SIGNATURE_HASH, encoded);
        out.endTag(null, TAG_SIGNATURE);
        i = i + 1;
        goto L8
    L10:
        out.endTag(null, TAG_ROOT);
        return;
    L4:
        if (this.mBackupAllowedInitialized == true) goto L6;
        s.wtf("Backup happened before mBackupAllowed is initialized.");
        goto L6
    }

    public void loadFromXml(TypedXmlPullParser parser, boolean fromBackup) throws IOException, XmlPullParserException {
        TypedXmlPullParser r1 = parser;
        long versionCode = ShortcutService.parseLongAttribute(r1, ATTR_VERSION, -1);
        long lastUpdateTime = ShortcutService.parseLongAttribute(r1, ATTR_LAST_UPDATE_TIME);
        int r9 = 1;
        if (fromBackup == false) goto L5;
    L8:
        boolean shadow = true;
    L9:
        long backupSourceVersion = ShortcutService.parseLongAttribute(r1, ATTR_BACKUP_SOURCE_VERSION, -1);
        boolean backupAllowed = ShortcutService.parseBooleanAttribute(r1, ATTR_BACKUP_ALLOWED, true);
        boolean backupSourceBackupAllowed = ShortcutService.parseBooleanAttribute(r1, ATTR_BACKUP_SOURCE_BACKUP_ALLOWED, true);
        ArrayList<byte[]> hashes = new ArrayList();
        int outerDepth = r1.getDepth();
    L10:
        int type = r1.next();
        if (type == r9) goto L35;
        if (type != 3) goto L19;
        if (r1.getDepth() <= outerDepth) goto L35;
    L19:
        if (type != 2) goto L10;
        int depth = r1.getDepth();
        String tag = r1.getName();
        int outerDepth2 = outerDepth;
        if (depth != (outerDepth2 + 1)) goto L33;
        switch(tag.hashCode()) {
            case 1073584312: goto L27;
            default: goto L29;
        };
    L29:
        byte r2 = -1;
    L30:
        switch(r2) {
            case 0: goto L32;
            default: goto L33;
        };
    L32:
        String hash = ShortcutService.parseStringAttribute(r1, ATTR_SIGNATURE_HASH);
        byte[] decoded = Base64.getDecoder().decode(hash);
        hashes.add(decoded);
        r1 = parser;
        outerDepth = outerDepth2;
        r9 = 1;
        goto L10
    L27:
        if (tag.equals(TAG_SIGNATURE) == false) goto L29;
        r2 = 0;
    L33:
        ShortcutService.warnForInvalidTag(depth, tag);
        r1 = parser;
        outerDepth = outerDepth2;
        r9 = 1;
    L35:
        if (fromBackup == false) goto L37;
        this.mVersionCode = -1;
        this.mBackupSourceVersionCode = versionCode;
        this.mBackupSourceBackupAllowed = backupAllowed;
    L38:
        this.mLastUpdateTime = lastUpdateTime;
        this.mIsShadow = shadow;
        this.mSigHashes = hashes;
        this.mBackupAllowed = false;
        this.mBackupAllowedInitialized = false;
        return;
    L37:
        this.mVersionCode = versionCode;
        this.mBackupSourceVersionCode = backupSourceVersion;
        this.mBackupSourceBackupAllowed = backupSourceBackupAllowed;
        goto L38
    L5:
        if (ShortcutService.parseBooleanAttribute(r1, ATTR_SHADOW) == true) goto L8;
        shadow = false;
        goto L9
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println();
        pw.print(prefix);
        pw.println("PackageInfo:");
        pw.print(prefix);
        pw.print("  IsShadow: ");
        pw.print(this.mIsShadow);
        if (this.mIsShadow == false) goto L5;
        String r0 = " (not installed)";
    L6:
        pw.print(r0);
        pw.println();
        pw.print(prefix);
        pw.print("  Version: ");
        pw.print(this.mVersionCode);
        pw.println();
        if (this.mBackupAllowedInitialized == false) goto L10;
        pw.print(prefix);
        pw.print("  Backup Allowed: ");
        pw.print(this.mBackupAllowed);
        pw.println();
    L10:
        if (this.mBackupSourceVersionCode == (-1)) goto L12;
        pw.print(prefix);
        pw.print("  Backup source version: ");
        pw.print(this.mBackupSourceVersionCode);
        pw.println();
        pw.print(prefix);
        pw.print("  Backup source backup allowed: ");
        pw.print(this.mBackupSourceBackupAllowed);
        pw.println();
    L12:
        pw.print(prefix);
        pw.print("  Last package update time: ");
        pw.print(this.mLastUpdateTime);
        pw.println();
        int i = 0;
    L14:
        if (i >= this.mSigHashes.size()) goto L17;
        pw.print(prefix);
        pw.print("    ");
        pw.print("SigHash: ");
        pw.println(HexEncoding.encode(this.mSigHashes.get(i)));
        i = i + 1;
        goto L14
    L17:
        return;
    L5:
        r0 = " (installed)";
        goto L6
    }
}

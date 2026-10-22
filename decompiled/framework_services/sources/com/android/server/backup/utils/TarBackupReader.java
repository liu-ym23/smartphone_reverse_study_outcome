package com.android.server.backup.utils;

import android.app.backup.IBackupManagerMonitor;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.FileMetadata;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.restore.RestorePolicy;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
public class TarBackupReader {
    private static final int TAR_HEADER_LENGTH_FILESIZE = 12;
    private static final int TAR_HEADER_LENGTH_MODE = 8;
    private static final int TAR_HEADER_LENGTH_MODTIME = 12;
    private static final int TAR_HEADER_LENGTH_PATH = 100;
    private static final int TAR_HEADER_LENGTH_PATH_PREFIX = 155;
    private static final int TAR_HEADER_LONG_RADIX = 8;
    private static final int TAR_HEADER_OFFSET_FILESIZE = 124;
    private static final int TAR_HEADER_OFFSET_MODE = 100;
    private static final int TAR_HEADER_OFFSET_MODTIME = 136;
    private static final int TAR_HEADER_OFFSET_PATH = 0;
    private static final int TAR_HEADER_OFFSET_PATH_PREFIX = 345;
    private static final int TAR_HEADER_OFFSET_TYPE_CHAR = 156;
    private BackupManagerMonitorEventSender mBackupManagerMonitorEventSender;
    private final BytesReadListener mBytesReadListener;
    private final InputStream mInputStream;
    private byte[] mWidgetData;

    public TarBackupReader(InputStream inputStream, BytesReadListener bytesReadListener, IBackupManagerMonitor monitor) {
        this.mWidgetData = null;
        this.mInputStream = inputStream;
        this.mBytesReadListener = bytesReadListener;
        this.mBackupManagerMonitorEventSender = new BackupManagerMonitorEventSender(monitor);
    }

    public FileMetadata readTarHeaders() throws IOException {
        byte[] block = new byte[512];
        FileMetadata info = null;
        if (readTarHeader(block) == true) goto L52;
    L51:
        return info;
    L52:
        info = new FileMetadata();     // Catch: IOException -> L9
        info.size = extractRadix(block, 124, 12, 8);     // Catch: IOException -> L9
        info.mtime = extractRadix(block, 136, 12, 8);     // Catch: IOException -> L9
        info.mode = extractRadix(block, 100, 8, 8);     // Catch: IOException -> L9
        info.path = extractString(block, 345, 155);     // Catch: IOException -> L9
        String path = extractString(block, 0, 100);     // Catch: IOException -> L9
        if (path.length() > 0) goto L7;
    L12:
        int typeChar = block[156(0x9c, float:2.19E-43)];     // Catch: IOException -> L9
        if (typeChar != 120) goto L21;
        boolean gotHeader = readPaxExtendedHeader(info);     // Catch: IOException -> L9
        if (gotHeader == false) goto L17;
        gotHeader = readTarHeader(block);     // Catch: IOException -> L9
    L17:
        if (gotHeader == false) goto L20;
        typeChar = block[156(0x9c, float:2.19E-43)];     // Catch: IOException -> L9
        goto L21
    L20:
        throw new IOException("Bad or missing pax header");     // Catch: IOException -> L9
    L21:
        switch(typeChar) {
            case 0: goto L47;
            case 48: goto L27;
            case 53: goto L24;
            default: goto L22;
        };     // Catch: IOException -> L9
    L22:
        Slog.e(BackupManagerService.TAG, "Unknown tar entity type: " + typeChar);     // Catch: IOException -> L9
        throw new IOException("Unknown entity type " + typeChar);     // Catch: IOException -> L9
    L24:
        info.type = 2;     // Catch: IOException -> L9
        if (info.size == 0) goto L29;
        Slog.w(BackupManagerService.TAG, "Directory entry with nonzero size in header");     // Catch: IOException -> L9
        info.size = 0;     // Catch: IOException -> L9
    L29:
        if ("shared/".regionMatches(0, info.path, 0, "shared/".length()) == false) goto L32;
        info.path = info.path.substring("shared/".length());     // Catch: IOException -> L9
        info.packageName = UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE;     // Catch: IOException -> L9
        info.domain = "shared";     // Catch: IOException -> L9
        Slog.i(BackupManagerService.TAG, "File in shared storage: " + info.path);     // Catch: IOException -> L9
        goto L51
    L32:
        if ("apps/".regionMatches(0, info.path, 0, "apps/".length()) == false) goto L51;
        info.path = info.path.substring("apps/".length());     // Catch: IOException -> L9
        int slash = info.path.indexOf(47);     // Catch: IOException -> L9
        if (slash < 0) goto L45;
        info.packageName = info.path.substring(0, slash);     // Catch: IOException -> L9
        info.path = info.path.substring(slash + 1);     // Catch: IOException -> L9
        if (info.path.equals(UserBackupManagerService.BACKUP_MANIFEST_FILENAME) == true) goto L51;
        if (info.path.equals(UserBackupManagerService.BACKUP_METADATA_FILENAME) == true) goto L51;
        int slash2 = info.path.indexOf(47);     // Catch: IOException -> L9
        if (slash2 < 0) goto L43;
        info.domain = info.path.substring(0, slash2);     // Catch: IOException -> L9
        info.path = info.path.substring(slash2 + 1);     // Catch: IOException -> L9
        goto L51
    L43:
        throw new IOException("Illegal semantic path in non-manifest " + info.path);     // Catch: IOException -> L9
    L45:
        throw new IOException("Illegal semantic path in " + info.path);     // Catch: IOException -> L9
    L27:
        info.type = 1;     // Catch: IOException -> L9
        goto L29
    L47:
        return null;
    L7:
        if (info.path.length() <= 0) goto L11;
        info.path += '/';     // Catch: IOException -> L9
    L11:
        info.path += path;     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "Parse error in header: " + e.getMessage());
        throw e;
    }

    private static int readExactly(InputStream in, byte[] buffer, int offset, int size) throws IOException {
        if (size <= 0) goto L11;
        int soFar = 0;
    L4:
        if (soFar >= size) goto L9;
        int nRead = in.read(buffer, offset + soFar, size - soFar);
        if (nRead <= 0) goto L9;
        soFar = soFar + nRead;
    L9:
        return soFar;
    L11:
        throw new IllegalArgumentException("size must be > 0");
    }

    public Signature[] readAppManifestAndReturnSignatures(FileMetadata info) throws IOException {
        if (info.size > 65536) goto L37;
        byte[] buffer = new byte[(int) info.size];
        char r7 = 0;
        if (readExactly(this.mInputStream, buffer, 0, (int) info.size) != info.size) goto L35;
        this.mBytesReadListener.onBytesRead(info.size);
        String[] str = new String[1];
        int offset = extractLine(buffer, 0, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int version = Integer.parseInt(str[0]);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        if (version != 1) goto L29;
        int offset2 = extractLine(buffer, offset, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        String manifestPackage = str[0];     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        if (manifestPackage.equals(info.packageName) == false) goto L27;
        int offset3 = extractLine(buffer, offset2, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        info.version = Integer.parseInt(str[0]);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int offset4 = extractLine(buffer, offset3, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        Integer.parseInt(str[0]);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int offset5 = extractLine(buffer, offset4, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        if (str[0].length() <= 0) goto L18;
        String r12 = str[0];     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
    L19:
        info.installerPackageName = r12;     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int offset6 = extractLine(buffer, offset5, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        info.hasApk = str[0].equals("1");     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int offset7 = extractLine(buffer, offset6, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int numSigs = Integer.parseInt(str[0]);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        if (numSigs <= 0) goto L26;
        Signature[] sigs = new Signature[numSigs];     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int i = 0;
    L22:
        if (i >= numSigs) goto L25;
        offset7 = extractLine(buffer, offset7, str);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        char r16 = r7;
        sigs[i] = new Signature(str[r16]);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        i = i + 1;     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        r7 = r16;
        goto L22
    L25:
        return sigs;
    L26:
        Slog.i(BackupManagerService.TAG, "Missing signature on backed-up package " + info.packageName);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        this.mBackupManagerMonitorEventSender.monitorEvent(42, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName));     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
    L33:
        return null;
    L18:
        r12 = null;
        goto L19
    L27:
        Slog.i(BackupManagerService.TAG, "Expected package " + info.packageName + " but restore manifest claims " + manifestPackage);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        Bundle monitoringExtras = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        this.mBackupManagerMonitorEventSender.monitorEvent(43, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras, "android.app.backup.extra.LOG_MANIFEST_PACKAGE_NAME", manifestPackage));     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        goto L33
    L29:
        Slog.i(BackupManagerService.TAG, "Unknown restore manifest version " + version + " for package " + info.packageName);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        Bundle monitoringExtras2 = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        this.mBackupManagerMonitorEventSender.monitorEvent(44, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras2, "android.app.backup.extra.LOG_EVENT_PACKAGE_VERSION", version));     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
    L14:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, e.getMessage());
        goto L33
    L32:
        Slog.w(BackupManagerService.TAG, "Corrupt restore manifest for package " + info.packageName);
        this.mBackupManagerMonitorEventSender.monitorEvent(46, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName));
        goto L33
    L35:
        throw new IOException("Unexpected EOF in manifest");
    L37:
        throw new IOException("Restore manifest too big; corrupt? size=" + info.size);
    }

    public RestorePolicy chooseRestorePolicy(PackageManager packageManager, boolean allowApks, FileMetadata info, Signature[] signatures, PackageManagerInternal pmi, int userId, Context context) {
        return chooseRestorePolicy(packageManager, allowApks, info, signatures, pmi, userId, BackupEligibilityRules.forBackup(packageManager, pmi, userId, context), context);
    }

    public RestorePolicy chooseRestorePolicy(PackageManager packageManager, boolean allowApks, FileMetadata info, Signature[] signatures, PackageManagerInternal pmi, int userId, BackupEligibilityRules eligibilityRules, Context context) {
        if (signatures == null) goto L5;
        RestorePolicy policy = RestorePolicy.IGNORE;
        PackageInfo pkgInfo = packageManager.getPackageInfoAsUser(info.packageName, 134217728, userId);     // Catch: PackageManager.NameNotFoundException -> L21
        int r13 = pkgInfo.applicationInfo.flags;     // Catch: PackageManager.NameNotFoundException -> L21
        if (eligibilityRules.isAppBackupAllowed(pkgInfo.applicationInfo) == true) goto L67;
        policy = policy;
        Slog.i(BackupManagerService.TAG, "Restore manifest from " + info.packageName + " but allowBackup=false");     // Catch: PackageManager.NameNotFoundException -> L44
        this.mBackupManagerMonitorEventSender.monitorEvent(39, pkgInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L44
    L51:
        RestorePolicy policy2 = policy;
    L61:
        if (policy2 == RestorePolicy.ACCEPT_IF_APK) goto L63;
    L65:
        return policy2;
    L63:
        if (info.hasApk == true) goto L65;
        Slog.i(BackupManagerService.TAG, "Cannot restore package " + info.packageName + " without the matching .apk");
        this.mBackupManagerMonitorEventSender.monitorEvent(41, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName));
        goto L65
    L67:
        if (UserHandle.isCore(pkgInfo.applicationInfo.uid) == false) goto L25;
        if (pkgInfo.applicationInfo.backupAgentName != null) goto L25;
        Slog.w(BackupManagerService.TAG, "Package " + info.packageName + " is system level with no agent");     // Catch: PackageManager.NameNotFoundException -> L21
        policy = policy;
        this.mBackupManagerMonitorEventSender.monitorEvent(38, pkgInfo, 2, null);     // Catch: PackageManager.NameNotFoundException -> L19
    L25:
        if (eligibilityRules.signaturesMatch(signatures, pkgInfo) == true) goto L27;
        Slog.w(BackupManagerService.TAG, "Restore manifest signatures do not match installed application for " + info.packageName);     // Catch: PackageManager.NameNotFoundException -> L44
        this.mBackupManagerMonitorEventSender.monitorEvent(37, pkgInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L44
        goto L51
    L27:
        if ((pkgInfo.applicationInfo.flags & 131072) == 0) goto L30;
        Slog.i(BackupManagerService.TAG, "Package has restoreAnyVersion; taking data");     // Catch: PackageManager.NameNotFoundException -> L19
        this.mBackupManagerMonitorEventSender.monitorEvent(34, pkgInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L19
        policy2 = RestorePolicy.ACCEPT;     // Catch: PackageManager.NameNotFoundException -> L19
        goto L61
    L30:
        if (pkgInfo.getLongVersionCode() < info.version) goto L38;
        Slog.i(BackupManagerService.TAG, "Sig + version match; taking data");     // Catch: PackageManager.NameNotFoundException -> L19
        RestorePolicy policy3 = RestorePolicy.ACCEPT;     // Catch: PackageManager.NameNotFoundException -> L19
        this.mBackupManagerMonitorEventSender.monitorEvent(35, pkgInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L34
        policy2 = policy3;
        goto L61
    L38:
        if (isAllowlistedForVToURestore(info, pkgInfo, userId, context) == false) goto L46;
        Slog.i(BackupManagerService.TAG, "Performing a V to U downgrade; package: " + info.packageName + " is allowlisted");     // Catch: PackageManager.NameNotFoundException -> L44
        RestorePolicy policy4 = RestorePolicy.ACCEPT;     // Catch: PackageManager.NameNotFoundException -> L44
        this.mBackupManagerMonitorEventSender.monitorEvent(70, pkgInfo, 3, null);     // Catch: PackageManager.NameNotFoundException -> L42
        policy2 = policy4;
        goto L61
    L46:
        if (allowApks == false) goto L48;
        Slog.i(BackupManagerService.TAG, "Data version " + info.version + " is newer than installed version " + pkgInfo.getLongVersionCode() + " - requiring apk");     // Catch: PackageManager.NameNotFoundException -> L44
        policy2 = RestorePolicy.ACCEPT_IF_APK;     // Catch: PackageManager.NameNotFoundException -> L44
        goto L61
    L48:
        Slog.i(BackupManagerService.TAG, "Data requires newer version " + info.version + "; ignoring");     // Catch: PackageManager.NameNotFoundException -> L44
        this.mBackupManagerMonitorEventSender.monitorEvent(36, pkgInfo, 3, BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_OLD_VERSION", info.version));     // Catch: PackageManager.NameNotFoundException -> L44
        policy2 = RestorePolicy.IGNORE;     // Catch: PackageManager.NameNotFoundException -> L44
    L56:
        if (allowApks == false) goto L58;
        Slog.i(BackupManagerService.TAG, "Package " + info.packageName + " not installed; requiring apk in dataset");
        policy2 = RestorePolicy.ACCEPT_IF_APK;
    L59:
        Bundle monitoringExtras = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName);
        this.mBackupManagerMonitorEventSender.monitorEvent(40, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras, "android.app.backup.extra.LOG_POLICY_ALLOW_APKS", allowApks));
        goto L61
    L58:
        policy2 = RestorePolicy.IGNORE;
        goto L59
    L5:
        return RestorePolicy.IGNORE;
    }

    public void skipTarPadding(long size) throws IOException {
        long partial = (size + 512) % 512;
        if (partial <= 0) goto L9;
        int needed = 512 - ((int) partial);
        byte[] buffer = new byte[needed];
        if (readExactly(this.mInputStream, buffer, 0, needed) != needed) goto L8;
        this.mBytesReadListener.onBytesRead(needed);
        return;
    L8:
        throw new IOException("Unexpected EOF in padding");
    }

    public void readMetadata(FileMetadata info) throws IOException {
        if (info.size > 65536) goto L29;
        byte[] buffer = new byte[(int) info.size];
        if (readExactly(this.mInputStream, buffer, 0, (int) info.size) != info.size) goto L27;
        this.mBytesReadListener.onBytesRead(info.size);
        String[] str = new String[1];
        int offset = extractLine(buffer, 0, str);
        int version = Integer.parseInt(str[0]);
        if (version != 1) goto L24;
        int offset2 = extractLine(buffer, offset, str);
        String pkg = str[0];
        if (info.packageName.equals(pkg) == false) goto L22;
        ByteArrayInputStream bin = new ByteArrayInputStream(buffer, offset2, buffer.length - offset2);
        DataInputStream in = new DataInputStream(bin);
    L12:
        if (bin.available() <= 0) goto L38;
        int token = in.readInt();
        int size = in.readInt();
        if (size > 65536) goto L20;
        switch(token) {
            case 33549569: goto L17;
            default: goto L16;
        };
    L17:
        this.mWidgetData = new byte[size];
        in.read(this.mWidgetData);
        goto L12
    L16:
        Slog.i(BackupManagerService.TAG, "Ignoring metadata blob " + Integer.toHexString(token) + " for " + info.packageName);
        in.skipBytes(size);
        goto L12
    L20:
        throw new IOException("Datum " + Integer.toHexString(token) + " too big; corrupt? size=" + info.size);
    L38:
        return;
    L22:
        Slog.w(BackupManagerService.TAG, "Metadata mismatch: package " + info.packageName + " but widget data for " + pkg);
        Bundle monitoringExtras = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName);
        this.mBackupManagerMonitorEventSender.monitorEvent(47, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras, "android.app.backup.extra.LOG_WIDGET_PACKAGE_NAME", pkg));
        return;
    L24:
        Slog.w(BackupManagerService.TAG, "Unsupported metadata version " + version);
        Bundle monitoringExtras2 = BackupManagerMonitorEventSender.putMonitoringExtra(null, "android.app.backup.extra.LOG_EVENT_PACKAGE_NAME", info.packageName);
        this.mBackupManagerMonitorEventSender.monitorEvent(48, null, 3, BackupManagerMonitorEventSender.putMonitoringExtra(monitoringExtras2, "android.app.backup.extra.LOG_EVENT_PACKAGE_VERSION", version));
        return;
    L27:
        throw new IOException("Unexpected EOF in widget data");
    L29:
        throw new IOException("Metadata too big; corrupt? size=" + info.size);
    }

    private static int extractLine(byte[] buffer, int offset, String[] outStr) throws IOException {
        int end = buffer.length;
        if (offset >= end) goto L13;
        int pos = offset;
    L5:
        if (pos >= end) goto L10;
        byte c = buffer[pos];
        if (c == 10) goto L10;
        pos = pos + 1;
    L10:
        outStr[0] = new String(buffer, offset, pos - offset);
        return pos + 1;
    L13:
        throw new IOException("Incomplete data");
    }

    private boolean readTarHeader(byte[] block) throws IOException {
        int got = readExactly(this.mInputStream, block, 0, 512);
        if (got != 0) goto L5;
        return false;
    L5:
        if (got < 512) goto L9;
        this.mBytesReadListener.onBytesRead(512);
        return true;
    L9:
        throw new IOException("Unable to read full block header");
    }

    private boolean readPaxExtendedHeader(FileMetadata info) throws IOException {
        if (info.size > 32768) goto L35;
        int numBlocks = (int) ((info.size + 511) >> 9);
        byte[] data = new byte[numBlocks * 512];
        if (readExactly(this.mInputStream, data, 0, data.length) < data.length) goto L34;
        this.mBytesReadListener.onBytesRead(data.length);
        int contentSize = (int) info.size;
        int offset = 0;
    L7:
        int eol = offset + 1;
    L8:
        if (eol >= contentSize) goto L12;
        if (data[eol] == 32) goto L12;
        eol = eol + 1;
    L12:
        if (eol >= contentSize) goto L32;
        int linelen = (int) extractRadix(data, offset, eol - offset, 10);
        int key = eol + 1;
        int eol2 = (offset + linelen) - 1;
        int value = key + 1;
    L15:
        if (data[value] == 61) goto L18;
        if (value > eol2) goto L18;
        value = value + 1;
    L18:
        if (value > eol2) goto L30;
        String keyStr = new String(data, key, value - key, CharsetNames.UTF_8);
        String valStr = new String(data, value + 1, (eol2 - value) - 1, CharsetNames.UTF_8);
        if ("path".equals(keyStr) == false) goto L23;
        info.path = valStr;
    L26:
        offset = offset + linelen;
        if (offset < contentSize) goto L7;
        return true;
    L23:
        if ("size".equals(keyStr) == false) goto L25;
        info.size = Long.parseLong(valStr);
        goto L26
    L25:
        Slog.i(BackupManagerService.TAG, "Unhandled pax key: " + key);
        goto L26
    L30:
        throw new IOException("Invalid pax declaration");
    L32:
        throw new IOException("Invalid pax data");
    L34:
        throw new IOException("Unable to read full pax header");
    L35:
        Slog.w(BackupManagerService.TAG, "Suspiciously large pax header size " + info.size + " - aborting");
        throw new IOException("Sanity failure: pax header size " + info.size);
    }

    private boolean isAllowlistedForVToURestore(FileMetadata backupFileInfo, PackageInfo installedPackageInfo, int userId, Context context) {
        String vToUAllowlist = getVToUAllowlist(context, userId);
        Arrays.asList(vToUAllowlist.split(","));
        return false;
    }

    private String getVToUAllowlist(Context context, int userId) {
        String allowlist = Settings.Secure.getStringForUser(context.getContentResolver(), "v_to_u_restore_allowlist", userId);
        if (allowlist != null) goto L6;
        return "";
    L6:
        return allowlist;
    }

    private static long extractRadix(byte[] data, int offset, int maxChars, int radix) throws IOException {
        long value = 0;
        int end = offset + maxChars;
        int i = offset;
    L3:
        if (i >= end) goto L16;
        byte b = data[i];
        if (b == 0) goto L16;
        if (b == 32) goto L16;
        if (b < 48) goto L15;
        if (b > ((radix + 48) - 1)) goto L15;
        value = (((long) radix) * value) + ((long) (b - 48));
        i = i + 1;
    L15:
        throw new IOException("Invalid number in header: '" + ((char) b) + "' for radix " + radix);
    L16:
        return value;
    }

    private static String extractString(byte[] data, int offset, int maxChars) throws IOException {
        int end = offset + maxChars;
        int eos = offset;
    L3:
        if (eos >= end) goto L8;
        if (data[eos] == 0) goto L8;
        eos = eos + 1;
    L8:
        return new String(data, offset, eos - offset, CharsetNames.US_ASCII);
    }

    private static void hexLog(byte[] block) {
        int offset = 0;
        int remaining = block.length;
        StringBuilder buf = new StringBuilder(64);
    L3:
        if (remaining <= 0) goto L12;
        buf.append(String.format("%04x   ", new Object[]{Integer.valueOf(offset)}));
        int numThisLine = 16;
        if (remaining > 16) goto L8;
        numThisLine = remaining;
    L8:
        int i = 0;
    L9:
        if (i >= numThisLine) goto L11;
        buf.append(String.format("%02x ", new Object[]{Byte.valueOf(block[offset + i])}));
        i = i + 1;
        goto L9
    L11:
        Slog.i("hexdump", buf.toString());
        buf.setLength(0);
        remaining = remaining - numThisLine;
        offset = offset + numThisLine;
        goto L3
    }

    public IBackupManagerMonitor getMonitor() {
        return this.mBackupManagerMonitorEventSender.getMonitor();
    }

    public byte[] getWidgetData() {
        return this.mWidgetData;
    }
}

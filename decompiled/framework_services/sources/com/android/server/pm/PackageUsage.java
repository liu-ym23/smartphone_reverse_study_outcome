package com.android.server.pm;

import android.os.FileUtils;
import android.util.AtomicFile;
import android.util.Log;
import com.android.internal.util.FrameworkStatsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
class PackageUsage extends AbstractStatsBase<Map<String, PackageSetting>> {
    private static final String USAGE_FILE_MAGIC = "PACKAGE_USAGE__VERSION_";
    private static final String USAGE_FILE_MAGIC_VERSION_1 = "PACKAGE_USAGE__VERSION_1";
    private boolean mIsHistoricalPackageUsageAvailable;

    @Override // com.android.server.pm.AbstractStatsBase
    protected /* bridge */ /* synthetic */ void readInternal(Map<String, PackageSetting> r1) {
        readInternal2(r1);
    }

    @Override // com.android.server.pm.AbstractStatsBase
    protected /* bridge */ /* synthetic */ void writeInternal(Map<String, PackageSetting> r1) {
        writeInternal2(r1);
    }

    PackageUsage() {
        super("package-usage.list", "PackageUsage_DiskWriter", true);
        this.mIsHistoricalPackageUsageAvailable = true;
    }

    boolean isHistoricalPackageUsageAvailable() {
        return this.mIsHistoricalPackageUsageAvailable;
    }

    /* JADX INFO: renamed from: writeInternal, reason: avoid collision after fix types in other method */
    protected void writeInternal2(Map<String, PackageSetting> pkgSettings) {
        AtomicFile file = getFile();
        FileOutputStream f = null;
        f = file.startWrite();     // Catch: IOException -> L16
        BufferedOutputStream out = new BufferedOutputStream(f);     // Catch: IOException -> L16
        FileUtils.setPermissions(file.getBaseFile().getPath(), FrameworkStatsLog.DISPLAY_HBM_STATE_CHANGED, 1000, 1032);     // Catch: IOException -> L16
        StringBuilder sb = new StringBuilder();     // Catch: IOException -> L16
        sb.append(USAGE_FILE_MAGIC_VERSION_1);     // Catch: IOException -> L16
        sb.append('\n');     // Catch: IOException -> L16
        out.write(sb.toString().getBytes(StandardCharsets.US_ASCII));     // Catch: IOException -> L16
        Iterator<PackageSetting> r5 = pkgSettings.values().iterator();     // Catch: IOException -> L16
    L5:
        if (r5.hasNext() == false) goto L19;
        PackageSetting pkgSetting = r5.next();     // Catch: IOException -> L16
        if (pkgSetting == null) goto L5;
        if (pkgSetting.getPkgState() == null) goto L5;
        if (pkgSetting.getPkgState().getLatestPackageUseTimeInMills() == 0) goto L5;
        int r7 = 0;
        sb.setLength(0);     // Catch: IOException -> L16
        sb.append(pkgSetting.getPackageName());     // Catch: IOException -> L16
        long[] r8 = pkgSetting.getPkgState().getLastPackageUsageTimeInMills();     // Catch: IOException -> L16
        int r9 = r8.length;     // Catch: IOException -> L16
    L14:
        if (r7 >= r9) goto L18;
        long usageTimeInMillis = r8[r7];     // Catch: IOException -> L16
        sb.append(' ');     // Catch: IOException -> L16
        sb.append(usageTimeInMillis);     // Catch: IOException -> L16
        r7 = r7 + 1;     // Catch: IOException -> L16
        goto L14
    L18:
        sb.append('\n');     // Catch: IOException -> L16
        out.write(sb.toString().getBytes(StandardCharsets.US_ASCII));     // Catch: IOException -> L16
        goto L5
    L19:
        out.flush();     // Catch: IOException -> L16
        file.finishWrite(f);     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        if (f == null) goto L24;
        file.failWrite(f);
    L24:
        Log.e(PackageManagerServiceMonitorEx.TAG, "Failed to write package usage times", e);
    }

    /* JADX INFO: renamed from: readInternal, reason: avoid collision after fix types in other method */
    protected void readInternal2(Map<String, PackageSetting> pkgSettings) {
        AtomicFile file = getFile();
        BufferedInputStream in = null;
        in = new BufferedInputStream(file.openRead());     // Catch: Throwable -> L9 IOException -> L11 FileNotFoundException -> L13
        StringBuilder sb = new StringBuilder();     // Catch: Throwable -> L9 IOException -> L11 FileNotFoundException -> L13
        String firstLine = readLine(in, sb);     // Catch: Throwable -> L9 IOException -> L11 FileNotFoundException -> L13
        if (firstLine != null) goto L7;
    L27:
    L17:
        IoUtils.closeQuietly(in);
        return;
        goto L20
    L7:
        if (USAGE_FILE_MAGIC_VERSION_1.equals(firstLine) == false) goto L15;
        readVersion1LP(pkgSettings, in, sb);     // Catch: Throwable -> L9 IOException -> L11 FileNotFoundException -> L13
        goto L27
    L15:
        readVersion0LP(pkgSettings, in, sb, firstLine);     // Catch: Throwable -> L9 IOException -> L11 FileNotFoundException -> L13
    L9:
        th = move-exception;
        IoUtils.closeQuietly(in);
        throw th;
    L11:
        e = move-exception;
        Log.w(PackageManagerServiceMonitorEx.TAG, "Failed to read package usage times", e);     // Catch: Throwable -> L9
    L20:
        this.mIsHistoricalPackageUsageAvailable = false;     // Catch: Throwable -> L9
        goto L17
    }

    private void readVersion0LP(Map<String, PackageSetting> pkgSettings, InputStream in, StringBuilder sb, String firstLine) throws IOException {
        String line = firstLine;
    L3:
        if (line == null) goto L17;
        String[] tokens = line.split(" ");
        if (tokens.length != 2) goto L15;
        String packageName = tokens[0];
        PackageSetting pkgSetting = pkgSettings.get(packageName);
        if (pkgSetting == null) goto L13;
        long timestamp = parseAsLong(tokens[1]);
        int reason = 0;
    L11:
        if (reason >= 8) goto L13;
        pkgSetting.getPkgState().setLastPackageUsageTimeInMills(reason, timestamp);
        reason = reason + 1;
    L13:
        line = readLine(in, sb);
        goto L3
    L15:
        throw new IOException("Failed to parse " + line + " as package-timestamp pair.");
    }

    private void readVersion1LP(Map<String, PackageSetting> pkgSettings, InputStream in, StringBuilder sb) throws IOException {
    L2:
        String line = readLine(in, sb);
        if (line == null) goto L16;
        String[] tokens = line.split(" ");
        if (tokens.length != 9) goto L15;
        String packageName = tokens[0];
        PackageSetting pkgSetting = pkgSettings.get(packageName);
        if (pkgSetting == null) goto L2;
        int reason = 0;
    L11:
        if (reason >= 8) goto L2;
        pkgSetting.getPkgState().setLastPackageUsageTimeInMills(reason, parseAsLong(tokens[reason + 1]));
        reason = reason + 1;
        goto L11
    L15:
        throw new IOException("Failed to parse " + line + " as a timestamp array.");
    }

    private long parseAsLong(String token) throws IOException {
        return Long.parseLong(token);
    L4:
        e = move-exception;
        throw new IOException("Failed to parse " + token + " as a long.", e);
    }

    private String readLine(InputStream in, StringBuilder sb) throws IOException {
        return readToken(in, sb, '\n');
    }

    private String readToken(InputStream in, StringBuilder sb, char endOfToken) throws IOException {
        sb.setLength(0);
    L3:
        int ch = in.read();
        if (ch == (-1)) goto L6;
        if (ch == endOfToken) goto L13;
        sb.append((char) ch);
        goto L3
    L13:
        return sb.toString();
    L6:
        if (sb.length() != 0) goto L10;
        return null;
    L10:
        throw new IOException("Unexpected EOF");
    }
}

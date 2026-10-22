package com.android.server.pm.parsing;

import android.content.pm.PackageParserCacheHelper;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Parcel;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Slog;
import com.android.internal.pm.parsing.IPackageCacher;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.pm.parsing.pkg.PackageImpl;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.pm.pkg.component.AconfigFlags;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.server.pm.ApexManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PackageCacher implements IPackageCacher {
    private static final String TAG = "PackageCacher";
    private static final AconfigFlags sAconfigFlags = null;
    public static final AtomicInteger sCachedPackageReadCount = null;
    private final File mCacheDir;
    private final PackageParser2.Callback mCallback;

    public static /* synthetic */ boolean $r8$lambda$A64DucnRlxXK60145SooSBkFrB8(String r0, File r1, String r2) {
        return lambda$cleanCachedResult$0(r0, r1, r2);
    }

    static {
        sCachedPackageReadCount = new AtomicInteger();
        sAconfigFlags = ParsingPackageUtils.getAconfigFlags();
    }

    public PackageCacher(File cacheDir) {
        this(cacheDir, null);
    }

    public PackageCacher(File cacheDir, PackageParser2.Callback callback) {
        this.mCacheDir = cacheDir;
        this.mCallback = callback;
    }

    private String getCacheKey(File packageFile, int flags) {
        return packageFile.getName() + '-' + flags + '-' + packageFile.getAbsolutePath().hashCode();
    }

    protected ParsedPackage fromCacheEntry(byte[] bytes) {
        return fromCacheEntryStatic(bytes, this.mCallback);
    }

    public static ParsedPackage fromCacheEntryStatic(byte[] bytes) {
        return fromCacheEntryStatic(bytes, null);
    }

    private static ParsedPackage fromCacheEntryStatic(byte[] bytes, ParsingPackageUtils.Callback callback) {
        Parcel p = Parcel.obtain();
        p.unmarshall(bytes, 0, bytes.length);
        p.setDataPosition(0);
        PackageParserCacheHelper.ReadHelper helper = new PackageParserCacheHelper.ReadHelper(p);
        helper.startAndInstall();
        PackageImpl r2 = new PackageImpl(p, callback);
        p.recycle();
        sCachedPackageReadCount.incrementAndGet();
        return r2;
    }

    protected byte[] toCacheEntry(ParsedPackage pkg) {
        return toCacheEntryStatic(pkg);
    }

    public static byte[] toCacheEntryStatic(ParsedPackage pkg) {
        Parcel p = Parcel.obtain();
        PackageParserCacheHelper.WriteHelper helper = new PackageParserCacheHelper.WriteHelper(p);
        ((PackageImpl) pkg).writeToParcel(p, 0);
        helper.finishAndUninstall();
        byte[] serialized = p.marshall();
        p.recycle();
        return serialized;
    }

    private static boolean isCacheFileUpToDate(File packageFile, File cacheFile) {
    L8:
        ee = move-exception;
        if (ee.errno == OsConstants.ENOENT) goto L19;
        Slog.w("Error while stating package cache : ", ee);
    L19:
        return false;
    L4:
        if (packageFile.toPath().startsWith(Environment.getApexDirectory().toPath()) == false) goto L11;
        File backingApexFile = ApexManager.getInstance().getBackingApexFile(packageFile);     // Catch: ErrnoException -> L8
        if (backingApexFile != null) goto L10;
        Slog.w(TAG, "Failed to find APEX file backing " + packageFile.getAbsolutePath());     // Catch: ErrnoException -> L8
        goto L11
    L10:
        packageFile = backingApexFile;
    L11:
        StructStat pkg = Os.stat(packageFile.getAbsolutePath());     // Catch: ErrnoException -> L8
        StructStat cache = Os.stat(cacheFile.getAbsolutePath());     // Catch: ErrnoException -> L8
        if (pkg.st_mtime >= cache.st_mtime) goto L22;
        return true;
    L22:
        return false;
    }

    public ParsedPackage getCachedResult(File packageFile, int flags) {
        String cacheKey = getCacheKey(packageFile, flags);
        File cacheFile = new File(this.mCacheDir, cacheKey);
    L18:
        e = move-exception;
        Slog.w(TAG, "Error reading package cache: ", e);
        cacheFile.delete();
        return null;
    L4:
        if (isCacheFileUpToDate(packageFile, cacheFile) == true) goto L6;
        return null;
    L6:
        byte[] bytes = IoUtils.readFileAsByteArray(cacheFile.getAbsolutePath());     // Catch: Throwable -> L18
        PackageImpl r5 = fromCacheEntry(bytes);     // Catch: Throwable -> L18
        if (packageFile.getAbsolutePath().equals(r5.getPath()) == true) goto L9;
        return null;
    L9:
        Map<String, Boolean> featureFlagState = r5.getFeatureFlagState();     // Catch: Throwable -> L18
        if (featureFlagState.isEmpty() == true) goto L21;
        Slog.d(TAG, "Feature flags for package " + packageFile + ": " + featureFlagState);     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, Boolean>> r7 = featureFlagState.entrySet().iterator();     // Catch: Throwable -> L18
    L13:
        if (r7.hasNext() == false) goto L21;
        Map.Entry<String, Boolean> entry = r7.next();     // Catch: Throwable -> L18
        String flagPackageAndName = entry.getKey();     // Catch: Throwable -> L18
        if (Objects.equals(sAconfigFlags.getFlagValue(flagPackageAndName), entry.getValue()) == true) goto L13;
        Slog.i(TAG, "Feature flag " + flagPackageAndName + " changed for package " + packageFile + "; cached result is invalid");     // Catch: Throwable -> L18
        return null;
    L21:
        return r5;
    }

    public void cacheResult(File packageFile, int flags, ParsedPackage parsed) {
        String cacheKey = getCacheKey(packageFile, flags);     // Catch: Throwable -> L8
        File cacheFile = new File(this.mCacheDir, cacheKey);     // Catch: Throwable -> L8
        if (cacheFile.exists() == true) goto L6;
    L10:
        byte[] cacheEntry = toCacheEntry(parsed);     // Catch: Throwable -> L8
        if (cacheEntry != null) goto L32;
        return;
    L32:
        FileOutputStream fos = new FileOutputStream(cacheFile);     // Catch: Throwable -> L8 IOException -> L17
        fos.write(cacheEntry);     // Catch: Throwable -> L19
        fos.close();     // Catch: Throwable -> L8 IOException -> L17
        return;
    L19:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L8 IOException -> L17
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 IOException -> L17
    L17:
        ioe = move-exception;
        Slog.w(TAG, "Error writing cache entry.", ioe);     // Catch: Throwable -> L8
        cacheFile.delete();     // Catch: Throwable -> L8
        return;
    L6:
        if (cacheFile.delete() == true) goto L10;
        Slog.e(TAG, "Unable to delete cache file: " + cacheFile);     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        Slog.w(TAG, "Error saving package cache.", e);
    }

    public void cleanCachedResult(File packageFile) {
        final String packageName = packageFile.getName();
        File[] files = FileUtils.listFilesOrEmpty(this.mCacheDir, new PackageCacher$$ExternalSyntheticLambda0(packageName));
        int r2 = files.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        File file = files[r3];
        if (file.delete() == true) goto L7;
        Slog.e(TAG, "Unable to clean cache file: " + file);
    L7:
        r3 = r3 + 1;
        goto L3
    }

    private static /* synthetic */ boolean lambda$cleanCachedResult$0(String packageName, File dir, String name) {
        return name.startsWith(packageName);
    }
}

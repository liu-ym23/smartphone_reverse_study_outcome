package com.android.server.pm.dex;

import android.os.SystemClock;
import android.util.Slog;
import android.util.jar.StrictJarFile;
import com.android.internal.art.ArtStatsLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes2.dex */
public class ArtStatsLogUtils {
    private static final int ART_COMPILATION_FILTER_FAKE_RUN_FROM_APK_FALLBACK = 14;
    private static final int ART_COMPILATION_FILTER_FAKE_RUN_FROM_VDEX_FALLBACK = 15;
    private static final int ART_COMPILATION_REASON_INSTALL_BULK_DOWNGRADED = 15;
    private static final int ART_COMPILATION_REASON_INSTALL_BULK_SECONDARY = 14;
    private static final int ART_COMPILATION_REASON_INSTALL_BULK_SECONDARY_DOWNGRADED = 16;
    private static final Map<Integer, Integer> COMPILATION_REASON_MAP = null;
    private static final Map<String, Integer> COMPILE_FILTER_MAP = null;
    private static final Map<String, Integer> ISA_MAP = null;
    private static final String PROFILE_DEX_METADATA = "primary.prof";
    private static final String TAG = null;
    private static final String VDEX_DEX_METADATA = "primary.vdex";

    public static class ArtStatsLogger {
        public ArtStatsLogger() {
        }

        public void write(long sessionId, int uid, int compilationReason, String compilerFilter, int kind, long value, int dexMetadataType, int apkType, String isa) {
            ArtStatsLog.write(ArtStatsLog.ART_DATUM_REPORTED, sessionId, uid, ((Integer) ArtStatsLogUtils.m7040$$Nest$sfgetCOMPILE_FILTER_MAP().getOrDefault(compilerFilter, 2)).intValue(), ((Integer) ArtStatsLogUtils.m7039$$Nest$sfgetCOMPILATION_REASON_MAP().getOrDefault(Integer.valueOf(compilationReason), 2)).intValue(), SystemClock.uptimeMillis(), 1, kind, value, dexMetadataType, apkType, ((Integer) ArtStatsLogUtils.m7041$$Nest$sfgetISA_MAP().getOrDefault(isa, 0)).intValue(), 0, 0);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$dql_v5qGCKOuJ_zohA3bPS3-9DM, reason: not valid java name */
    public static /* synthetic */ boolean m7038$r8$lambda$dql_v5qGCKOuJ_zohA3bPS39DM(String r0, String r1) {
        return lambda$getApkType$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCOMPILATION_REASON_MAP, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m7039$$Nest$sfgetCOMPILATION_REASON_MAP() {
        return COMPILATION_REASON_MAP;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCOMPILE_FILTER_MAP, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m7040$$Nest$sfgetCOMPILE_FILTER_MAP() {
        return COMPILE_FILTER_MAP;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetISA_MAP, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m7041$$Nest$sfgetISA_MAP() {
        return ISA_MAP;
    }

    public ArtStatsLogUtils() {
    }

    static {
        TAG = ArtStatsLogUtils.class.getSimpleName();
        COMPILATION_REASON_MAP = new HashMap();
        COMPILATION_REASON_MAP.put(0, 3);
        COMPILATION_REASON_MAP.put(1, 17);
        COMPILATION_REASON_MAP.put(2, 11);
        COMPILATION_REASON_MAP.put(3, 5);
        COMPILATION_REASON_MAP.put(4, 12);
        COMPILATION_REASON_MAP.put(5, 13);
        COMPILATION_REASON_MAP.put(6, 14);
        COMPILATION_REASON_MAP.put(7, 15);
        COMPILATION_REASON_MAP.put(8, 16);
        COMPILATION_REASON_MAP.put(9, 6);
        COMPILATION_REASON_MAP.put(10, 7);
        COMPILATION_REASON_MAP.put(11, 8);
        COMPILATION_REASON_MAP.put(12, 19);
        COMPILATION_REASON_MAP.put(14, 9);
        COMPILE_FILTER_MAP = new HashMap();
        COMPILE_FILTER_MAP.put("error", 1);
        COMPILE_FILTER_MAP.put("unknown", 2);
        COMPILE_FILTER_MAP.put("assume-verified", 3);
        COMPILE_FILTER_MAP.put("extract", 4);
        COMPILE_FILTER_MAP.put("verify", 5);
        COMPILE_FILTER_MAP.put("quicken", 6);
        COMPILE_FILTER_MAP.put("space-profile", 7);
        COMPILE_FILTER_MAP.put("space", 8);
        COMPILE_FILTER_MAP.put("speed-profile", 9);
        COMPILE_FILTER_MAP.put("speed", 10);
        COMPILE_FILTER_MAP.put("everything-profile", 11);
        COMPILE_FILTER_MAP.put("everything", 12);
        COMPILE_FILTER_MAP.put("run-from-apk", 13);
        COMPILE_FILTER_MAP.put("run-from-apk-fallback", 14);
        COMPILE_FILTER_MAP.put("run-from-vdex-fallback", 15);
        ISA_MAP = new HashMap();
        ISA_MAP.put("arm", 1);
        ISA_MAP.put("arm64", 2);
        ISA_MAP.put("x86", 3);
        ISA_MAP.put("x86_64", 4);
        ISA_MAP.put("mips", 5);
        ISA_MAP.put("mips64", 6);
    }

    public static void writeStatsLog(ArtStatsLogger logger, long sessionId, String compilerFilter, int uid, long compileTime, String dexMetadataPath, int compilationReason, int result, int apkType, String isa, String apkPath) {
        int dexMetadataType = getDexMetadataType(dexMetadataPath);
        logger.write(sessionId, uid, compilationReason, compilerFilter, 10, result, dexMetadataType, apkType, isa);
        logger.write(sessionId, uid, compilationReason, compilerFilter, 11, getDexBytes(apkPath), dexMetadataType, apkType, isa);
        logger.write(sessionId, uid, compilationReason, compilerFilter, 12, compileTime, dexMetadataType, apkType, isa);
    }

    public static int getApkType(final String path, String baseApkPath, String[] splitApkPaths) {
        if (path.equals(baseApkPath) == false) goto L7;
        return 1;
    L7:
        if (Arrays.stream(splitApkPaths).anyMatch(new ArtStatsLogUtils$$ExternalSyntheticLambda0(path)) == false) goto L10;
        return 2;
    L10:
        return 0;
    }

    private static /* synthetic */ boolean lambda$getApkType$0(String path, String p) {
        return p.equals(path);
    }

    private static long getDexBytes(String apkPath) {
        StrictJarFile jarFile = null;
        long dexBytes = 0;
        jarFile = new StrictJarFile(apkPath, false, false);     // Catch: Throwable -> L10 IOException -> L12
        Iterator<ZipEntry> it = jarFile.iterator();     // Catch: Throwable -> L10 IOException -> L12
        Pattern p = Pattern.compile("classes(\\d)*[.]dex");     // Catch: Throwable -> L10 IOException -> L12
        Matcher m = p.matcher("");     // Catch: Throwable -> L10 IOException -> L12
    L5:
        if (it.hasNext() == false) goto L39;
        ZipEntry entry = it.next();     // Catch: Throwable -> L10 IOException -> L12
        m.reset(entry.getName());     // Catch: Throwable -> L10 IOException -> L12
        if (m.matches() == false) goto L5;
        dexBytes = dexBytes + entry.getSize();
        goto L5
        goto L21
    L39:
        jarFile.close();     // Catch: IOException -> L18
    L19:
        return dexBytes;
    L10:
        th = move-exception;
        if (jarFile != null) goto L42;
    L36:
        throw th;
    L42:
        jarFile.close();     // Catch: IOException -> L33
    L21:
        Slog.e(TAG, "Error when parsing APK " + apkPath);     // Catch: Throwable -> L10
        if (jarFile == null) goto L49;
        jarFile.close();     // Catch: IOException -> L25
        return -1;
    L28:
        return -1;
    L49:
        return -1;
    }

    private static int getDexMetadataType(String dexMetadataPath) {
        if (dexMetadataPath != null) goto L5;
        return 4;
    L5:
        StrictJarFile jarFile = null;
        jarFile = new StrictJarFile(dexMetadataPath, false, false);     // Catch: Throwable -> L31 IOException -> L33
        boolean hasProfile = findFileName(jarFile, PROFILE_DEX_METADATA);     // Catch: Throwable -> L31 IOException -> L33
        boolean hasVdex = findFileName(jarFile, VDEX_DEX_METADATA);     // Catch: Throwable -> L31 IOException -> L33
        if (hasProfile == false) goto L14;
        if (hasVdex == false) goto L14;
        jarFile.close();     // Catch: IOException -> L11
        return 3;
    L12:
        return 3;
    L14:
        if (hasProfile == true) goto L63;
        if (hasVdex == false) goto L57;
        jarFile.close();     // Catch: IOException -> L23
        return 2;
    L24:
        return 2;
    L57:
        jarFile.close();     // Catch: IOException -> L29
    L30:
        return 0;
    L63:
        jarFile.close();     // Catch: IOException -> L17
        return 1;
    L18:
        return 1;
    L31:
        th = move-exception;
        if (jarFile != null) goto L61;
    L49:
        throw th;
    L61:
        jarFile.close();     // Catch: IOException -> L46
    L34:
        Slog.e(TAG, "Error when parsing dex metadata " + dexMetadataPath);     // Catch: Throwable -> L31
        if (jarFile == null) goto L68;
        jarFile.close();     // Catch: IOException -> L38
        return 5;
    L41:
        return 5;
    L68:
        return 5;
    }

    private static boolean findFileName(StrictJarFile jarFile, String filename) throws IOException {
        Iterator<ZipEntry> it = jarFile.iterator();
    L4:
        if (it.hasNext() == false) goto L10;
        ZipEntry entry = it.next();
        if (entry.getName().equals(filename) == false) goto L4;
        return true;
    L10:
        return false;
    }
}

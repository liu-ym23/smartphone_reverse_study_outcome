package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = null;
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<CompilationStatus> sFuture = null;

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static PackageInfo getPackageInfo(PackageManager r100, Context r101) throws PackageManager.NameNotFoundException {
            return r100.getPackageInfo(r101.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    public static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        public static Cache readFromFile(File r100) throws IOException {
            DataInputStream r101 = new DataInputStream(new FileInputStream(r100));
            Cache r102 = new Cache(r101.readInt(), r101.readInt(), r101.readLong(), r101.readLong());     // Catch: Throwable -> L6
            r101.close();
            return r102;
        L6:
            th = move-exception;
            r101.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if ((r100 instanceof Cache) == false) goto L21;
            Cache r101 = (Cache) r100;
            if (this.mResultCode == r101.mResultCode) goto L13;
        L19:
            return false;
        L13:
            if (this.mPackageLastUpdateTime != r101.mPackageLastUpdateTime) goto L19;
            if (this.mSchema != r101.mSchema) goto L19;
            if (this.mInstalledCurrentProfileSize != r101.mInstalledCurrentProfileSize) goto L19;
            return true;
        }

        public void writeOnFile(File r100) throws IOException {
            r100.delete();
            DataOutputStream r101 = new DataOutputStream(new FileOutputStream(r100));
            r101.writeInt(this.mSchema);     // Catch: Throwable -> L6
            r101.writeInt(this.mResultCode);     // Catch: Throwable -> L6
            r101.writeLong(this.mPackageLastUpdateTime);     // Catch: Throwable -> L6
            r101.writeLong(this.mInstalledCurrentProfileSize);     // Catch: Throwable -> L6
            r101.close();
            return;
        L6:
            th = move-exception;
            r101.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public Cache(int r100, int r101, long r102, long r103) {
            this.mSchema = r100;
            this.mResultCode = r101;
            this.mPackageLastUpdateTime = r102;
            this.mInstalledCurrentProfileSize = r103;
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED = 327680;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_NO_PROFILE_INSTALLED = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasEmbeddedProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        /* JADX INFO: loaded from: classes17.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        public boolean appApkHasEmbeddedProfile() {
            return this.mHasEmbeddedProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }

        public CompilationStatus(int r100, boolean r101, boolean r102, boolean r103) {
            this.mResultCode = r100;
            this.mHasCurrentProfile = r102;
            this.mHasReferenceProfile = r101;
            this.mHasEmbeddedProfile = r103;
        }
    }

    static {
        sFuture = ResolvableFuture.create();
        SYNC_OBJ = new Object();
        sCompilationStatus = null;
    }

    private ProfileVerifier() {
    }

    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context r100) throws PackageManager.NameNotFoundException {
        PackageManager r101 = r100.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getPackageInfo(r101, r100).lastUpdateTime;
    L7:
        return r101.getPackageInfo(r100.getPackageName(), 0).lastUpdateTime;
    }

    public static CompilationStatus writeProfileVerification(Context r100) {
        return writeProfileVerification(r100, false);
    }

    public static CompilationStatus writeProfileVerification(Context r110, boolean r210) {
        if (r210 == true) goto L6;
        CompilationStatus r100 = sCompilationStatus;
        if (r100 == null) goto L6;
        return r100;
    L6:
        Object r101 = SYNC_OBJ;
        monitor-enter(r101);
        if (r210 == false) goto L111;
    L13:
        int r102 = 0;
        AssetFileDescriptor r103 = r110.getAssets().openFd("dexopt/baseline.prof");     // Catch: Throwable -> L31 IOException -> L33
        if (r103.getLength() <= 0) goto L19;
        boolean r104 = true;
    L20:
        r103.close();     // Catch: Throwable -> L31 IOException -> L33
    L34:
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        if (r105 >= 28) goto L37;
    L99:
        CompilationStatus r106 = setCompilationStatus(262144, false, false, r104);     // Catch: Throwable -> L31
        monitor-exit(r101);     // Catch: Throwable -> L31
        return r106;
    L37:
        if (r105 == 30) goto L99;
        File r107 = new File(new File(REF_PROFILES_BASE_DIR, r110.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L31
        long r108 = r107.length();     // Catch: Throwable -> L31
        if (r107.exists() == true) goto L42;
    L44:
        boolean r109 = false;
    L45:
        File r111 = new File(new File(CUR_PROFILES_BASE_DIR, r110.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L31
        long r112 = r111.length();     // Catch: Throwable -> L31
        if (r111.exists() == true) goto L48;
    L50:
        boolean r113 = false;
    L104:
        long r114 = getPackageLastUpdateTime(r110);     // Catch: Throwable -> L31 PackageManager.NameNotFoundException -> L96
        File r115 = new File(r110.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);     // Catch: Throwable -> L31
        if (r115.exists() == true) goto L109;
        Cache r116 = null;
    L62:
        if (r116 != null) goto L64;
    L69:
        if (r104 == true) goto L71;
        r102 = CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED;
    L75:
        if (r210 == false) goto L79;
        if (r113 == false) goto L79;
        if (r102 == 1) goto L79;
        r102 = 2;
    L79:
        if (r116 != null) goto L81;
    L86:
        Cache r117 = new Cache(1, r102, r114, r112);     // Catch: Throwable -> L31
        if (r116 != null) goto L89;
    L112:
        r117.writeOnFile(r115);     // Catch: Throwable -> L31 IOException -> L92
    L93:
        CompilationStatus r118 = setCompilationStatus(r102, r109, r113, r104);     // Catch: Throwable -> L31
        monitor-exit(r101);     // Catch: Throwable -> L31
        return r118;
    L92:
        r102 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        goto L93
    L89:
        if (r116.equals(r117) == true) goto L93;
    L81:
        if (r116.mResultCode != 2) goto L86;
        if (r102 != 1) goto L86;
        if (r108 >= r116.mInstalledCurrentProfileSize) goto L86;
        r102 = 3;
        goto L86
    L71:
        if (r109 == false) goto L73;
        r102 = 1;
        goto L75
    L73:
        if (r113 == false) goto L75;
        r102 = 2;
        goto L75
    L64:
        if (r116.mPackageLastUpdateTime != r114) goto L69;
        int r119 = r116.mResultCode;     // Catch: Throwable -> L31
        if (r119 == 2) goto L69;
        r102 = r119;
        goto L75
    L109:
        r116 = Cache.readFromFile(r115);     // Catch: Throwable -> L31 IOException -> L56
    L59:
        return setCompilationStatus(131072, r109, r113, r104);
    L31:
        th = move-exception;
        throw th;
    L98:
        return setCompilationStatus(65536, r109, r113, r104);
    L48:
        if (r112 <= 0) goto L50;
        r113 = true;
        goto L104
    L42:
        if (r108 <= 0) goto L44;
        r109 = true;
        goto L45
    L19:
        r104 = false;
    L22:
        th = move-exception;
        if (r103 == null) goto L116;
        r103.close();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31 IOException -> L33
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L116:
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L33:
        r104 = false;
        goto L34
    L111:
        CompilationStatus r120 = sCompilationStatus;     // Catch: Throwable -> L31
        if (r120 == null) goto L13;
        monitor-exit(r101);     // Catch: Throwable -> L31
        return r120;
    }

    private static CompilationStatus setCompilationStatus(int r100, boolean r101, boolean r102, boolean r103) {
        CompilationStatus r104 = new CompilationStatus(r100, r101, r102, r103);
        sCompilationStatus = r104;
        sFuture.set(r104);
        return sCompilationStatus;
    }
}

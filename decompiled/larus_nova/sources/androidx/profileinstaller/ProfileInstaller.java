package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = null;
    static final DiagnosticsCallback LOG_DIAGNOSTICS = null;
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int r100, Object r101);

        void onResultReceived(int r100, Object r101);
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    private ProfileInstaller() {
    }

    public static /* synthetic */ void a(DiagnosticsCallback r100, int r101, Object r102) {
        lambda$diagnostic$1(r100, r101, r102);
    }

    public static /* synthetic */ void b(DiagnosticsCallback r100, int r101, Object r102) {
        lambda$result$0(r100, r101, r102);
    }

    static {
        EMPTY_DIAGNOSTICS = new AnonymousClass1();
        LOG_DIAGNOSTICS = new AnonymousClass2();
    }

    public static boolean deleteProfileWrittenFor(File r100) {
        return new File(r100, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    public static void writeProfile(Context r100) {
        writeProfile(r100, new b(), EMPTY_DIAGNOSTICS);
    }

    public static void noteProfileWrittenFor(PackageInfo r100, File r101) {
        DataOutputStream r102 = new DataOutputStream(new FileOutputStream(new File(r101, PROFILE_INSTALLER_SKIP_FILE_NAME)));     // Catch: IOException -> L14
        r102.writeLong(r100.lastUpdateTime);     // Catch: Throwable -> L7
        r102.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    public static void deleteSkipFile(Context r100, Executor r101, DiagnosticsCallback r102) {
        deleteProfileWrittenFor(r100.getFilesDir());
        result(r101, r102, 11, null);
    }

    public static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo r100, File r101, DiagnosticsCallback r102) {
        File r103 = new File(r101, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean r104 = false;
        if (r103.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r105 = new DataInputStream(new FileInputStream(r103));     // Catch: IOException -> L20
        long r106 = r105.readLong();     // Catch: Throwable -> L14
        r105.close();     // Catch: IOException -> L20
        if (r106 != r100.lastUpdateTime) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L13;
        r102.onResultReceived(2, null);
    L13:
        return r104;
    L14:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    private static /* synthetic */ void lambda$diagnostic$1(DiagnosticsCallback r100, int r101, Object r102) {
        r100.onDiagnosticReceived(r101, r102);
    }

    private static /* synthetic */ void lambda$result$0(DiagnosticsCallback r100, int r101, Object r102) {
        r100.onResultReceived(r101, r102);
    }

    public static void writeProfile(Context r100, Executor r101, DiagnosticsCallback r102) {
        writeProfile(r100, r101, r102, false);
    }

    public static void writeSkipFile(Context r100, Executor r101, DiagnosticsCallback r102) {
        String r103 = r100.getApplicationContext().getPackageName();
        PackageInfo r104 = r100.getPackageManager().getPackageInfo(r103, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        noteProfileWrittenFor(r104, r100.getFilesDir());
        result(r101, r102, 10, null);
        return;
    L6:
        e = move-exception;
        result(r101, r102, 7, e);
    }

    public static void diagnostic(Executor r100, final DiagnosticsCallback r101, final int r102, final Object r103) {
        r100.execute(new d(r101, r102, r103));
    }

    public static void result(Executor r100, final DiagnosticsCallback r101, final int r102, final Object r103) {
        r100.execute(new c(r101, r102, r103));
    }

    public static void writeProfile(Context r100, Executor r110, DiagnosticsCallback r111, boolean r112) {
        Context r101 = r100.getApplicationContext();
        String r102 = r101.getPackageName();
        ApplicationInfo r103 = r101.getApplicationInfo();
        AssetManager r104 = r101.getAssets();
        String r105 = new File(r103.sourceDir).getName();
        boolean r106 = false;
        PackageInfo r107 = r100.getPackageManager().getPackageInfo(r102, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r108 = r100.getFilesDir();
        if (r112 == false) goto L7;
    L10:
        r100.getPackageName();
        if (transcodeAndWrite(r104, r102, r107, r108, r105, r110, r111) == false) goto L14;
        if (r112 == false) goto L14;
        r106 = true;
    L14:
        ProfileVerifier.writeProfileVerification(r100, r106);
        return;
    L7:
        if (hasAlreadyWrittenProfileForThisInstall(r107, r108, r111) == false) goto L10;
        r100.getPackageName();
        ProfileVerifier.writeProfileVerification(r100, false);
        return;
    L16:
        e = move-exception;
        r111.onResultReceived(7, e);
        ProfileVerifier.writeProfileVerification(r100, false);
    }

    private static boolean transcodeAndWrite(AssetManager r100, String r101, PackageInfo r110, File r111, String r112, Executor r113, DiagnosticsCallback r114) {
        DeviceProfileWriter r102 = new DeviceProfileWriter(r100, r113, r114, r112, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, r101), PROFILE_FILE));
        if (r102.deviceAllowsProfileInstallerAotWrites() == true) goto L6;
        return false;
    L6:
        boolean r103 = r102.read().transcodeIfNeeded().write();
        if (r103 == false) goto L9;
        noteProfileWrittenFor(r110, r111);
    L9:
        return r103;
    }
}

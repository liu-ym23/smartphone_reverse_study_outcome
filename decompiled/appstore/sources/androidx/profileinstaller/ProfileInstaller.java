package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileInstaller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiagnosticsCallback f3928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiagnosticsCallback f3929b = null;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int r10, @Nullable Object r11);

        void onResultReceived(int r10, @Nullable Object r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ResultCode {
    }

    public class a implements DiagnosticsCallback {
        public a() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r10, Object r11) {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r10, Object r11) {
        }
    }

    public class b implements DiagnosticsCallback {
        public b() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r10, Object r11) {
            if (r10 != 1) goto L5;
            String r12 = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
        L18:
            Log.d("ProfileInstaller", r12);
            return;
        L5:
            if (r10 != 2) goto L7;
            r12 = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
            goto L18
        L7:
            if (r10 != 3) goto L9;
            r12 = "DIAGNOSTIC_REF_PROFILE_EXISTS";
            goto L18
        L9:
            if (r10 != 4) goto L11;
            r12 = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
            goto L18
        L11:
            if (r10 == 5) goto L13;
            r12 = "";
            goto L18
        L13:
            r12 = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
            goto L18
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r10, Object r11) {
            switch(r10) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                case 9: goto L3;
                case 10: goto L5;
                case 11: goto L4;
                default: goto L3;
            };
        L3:
            String r12 = "";
        L15:
            if (r10 != 6) goto L17;
        L21:
            Log.e("ProfileInstaller", r12, (Throwable) r11);
            return;
        L17:
            if (r10 == 7) goto L21;
            if (r10 == 8) goto L21;
            Log.d("ProfileInstaller", r12);
            return;
        L4:
            r12 = "RESULT_DELETE_SKIP_FILE_SUCCESS";
            goto L15
        L5:
            r12 = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
            goto L15
        L6:
            r12 = "RESULT_PARSE_EXCEPTION";
            goto L15
        L7:
            r12 = "RESULT_IO_EXCEPTION";
            goto L15
        L8:
            r12 = "RESULT_BASELINE_PROFILE_NOT_FOUND";
            goto L15
        L9:
            r12 = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
            goto L15
        L10:
            r12 = "RESULT_NOT_WRITABLE";
            goto L15
        L11:
            r12 = "RESULT_UNSUPPORTED_ART_VERSION";
            goto L15
        L12:
            r12 = "RESULT_ALREADY_INSTALLED";
            goto L15
        L13:
            r12 = "RESULT_INSTALL_SUCCESS";
            goto L15
        }
    }

    static {
        f3928a = new a();
        f3929b = new b();
    }

    public static /* synthetic */ void a(DiagnosticsCallback r10, int r11, Object r12) {
        e(r10, r11, r12);
    }

    public static boolean b(File r10) {
        return new File(r10, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(Context r10, Executor r11, DiagnosticsCallback r12) {
        b(r10.getFilesDir());
        g(r11, r12, 11, null);
    }

    public static boolean d(PackageInfo r10, File r11, DiagnosticsCallback r12) {
        File r13 = new File(r11, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        boolean r14 = false;
        if (r13.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r15 = new DataInputStream(new FileInputStream(r13));     // Catch: IOException -> L20
        long r16 = r15.readLong();     // Catch: Throwable -> L14
        r15.close();     // Catch: IOException -> L20
        if (r16 != r10.lastUpdateTime) goto L11;
        r14 = true;
    L11:
        if (r14 == false) goto L13;
        r12.onResultReceived(2, null);
    L13:
        return r14;
    L14:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    public static /* synthetic */ void e(DiagnosticsCallback r10, int r11, Object r12) {
        r10.onResultReceived(r11, r12);
    }

    public static void f(PackageInfo r10, File r11) {
        DataOutputStream r12 = new DataOutputStream(new FileOutputStream(new File(r11, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));     // Catch: IOException -> L14
        r12.writeLong(r10.lastUpdateTime);     // Catch: Throwable -> L7
        r12.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    public static void g(Executor r10, final DiagnosticsCallback r11, final int r12, final Object r13) {
        r10.execute(new g(r11, r12, r13));
    }

    public static boolean h(AssetManager r10, String r11, PackageInfo r12, File r13, String r14, Executor r15, DiagnosticsCallback r16) {
        c r17 = new c(r10, r15, r16, r14, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", r11), "primary.prof"));
        if (r17.e() == true) goto L6;
        return false;
    L6:
        boolean r18 = r17.i().m().n();
        if (r18 == false) goto L9;
        f(r12, r13);
    L9:
        return r18;
    }

    public static void i(Context r10) {
        j(r10, new f(), f3928a);
    }

    public static void j(Context r10, Executor r11, DiagnosticsCallback r12) {
        k(r10, r11, r12, false);
    }

    public static void k(Context r10, Executor r11, DiagnosticsCallback r12, boolean r13) {
        Context r14 = r10.getApplicationContext();
        String r15 = r14.getPackageName();
        ApplicationInfo r16 = r14.getApplicationInfo();
        AssetManager r17 = r14.getAssets();
        String r18 = new File(r16.sourceDir).getName();
        boolean r19 = false;
        PackageInfo r20 = r10.getPackageManager().getPackageInfo(r15, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r21 = r10.getFilesDir();
        if (r13 == false) goto L7;
    L10:
        Log.d("ProfileInstaller", "Installing profile for " + r10.getPackageName());
        if (h(r17, r15, r20, r21, r18, r11, r12) == false) goto L14;
        if (r13 == false) goto L14;
        r19 = true;
    L14:
        ProfileVerifier.c(r10, r19);
        return;
    L7:
        if (d(r20, r21, r12) == false) goto L10;
        Log.d("ProfileInstaller", "Skipping profile installation for " + r10.getPackageName());
        ProfileVerifier.c(r10, false);
        return;
    L16:
        e = move-exception;
        r12.onResultReceived(7, e);
        ProfileVerifier.c(r10, false);
    }

    public static void l(Context r10, Executor r11, DiagnosticsCallback r12) {
        String r13 = r10.getApplicationContext().getPackageName();
        PackageInfo r14 = r10.getPackageManager().getPackageInfo(r13, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        f(r14, r10.getFilesDir());
        g(r11, r12, 10, null);
        return;
    L6:
        e = move-exception;
        g(r11, r12, 7, e);
    }
}

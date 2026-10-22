package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final c f11307a = new a();

    /* renamed from: b, reason: collision with root package name */
    static final c f11308b = new b();

    class a implements c {
        a() {
        }

        @Override // androidx.profileinstaller.i.c
        public void a(int i5, Object obj) {
        }

        @Override // androidx.profileinstaller.i.c
        public void b(int i5, Object obj) {
        }
    }

    class b implements c {
        b() {
        }

        @Override // androidx.profileinstaller.i.c
        public void a(int i5, Object obj) {
            Log.d("ProfileInstaller", i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? BuildConfig.FLAVOR : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.i.c
        public void b(int i5, Object obj) {
            String str;
            switch (i5) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                default:
                    str = BuildConfig.FLAVOR;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i5 == 6 || i5 == 7 || i5 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    public interface c {
        void a(int i5, Object obj);

        void b(int i5, Object obj);
    }

    static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    static void c(Context context, Executor executor, c cVar) {
        b(context.getFilesDir());
        f(executor, cVar, 11, null);
    }

    static boolean d(PackageInfo packageInfo, File file, c cVar) throws IOException {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j5 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z5 = j5 == packageInfo.lastUpdateTime;
                if (z5) {
                    cVar.b(2, null);
                }
                return z5;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    static void e(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    static void f(Executor executor, final c cVar, final int i5, final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.h
            @Override // java.lang.Runnable
            public final void run() {
                cVar.b(i5, obj);
            }
        });
    }

    private static boolean g(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, c cVar) throws IOException {
        androidx.profileinstaller.c cVar2 = new androidx.profileinstaller.c(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!cVar2.e()) {
            return false;
        }
        boolean zM = cVar2.h().l().m();
        if (zM) {
            e(packageInfo, file);
        }
        return zM;
    }

    public static void h(Context context) throws PackageManager.NameNotFoundException {
        i(context, new g(), f11307a);
    }

    public static void i(Context context, Executor executor, c cVar) throws PackageManager.NameNotFoundException {
        j(context, executor, cVar, false);
    }

    static void j(Context context, Executor executor, c cVar, boolean z5) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z6 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z5 && d(packageInfo, filesDir, cVar)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                o.c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (g(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z5) {
                z6 = true;
            }
            o.c(context, z6);
        } catch (PackageManager.NameNotFoundException e6) {
            cVar.b(7, e6);
            o.c(context, false);
        }
    }

    static void k(Context context, Executor executor, c cVar) throws PackageManager.NameNotFoundException, IOException {
        try {
            e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            f(executor, cVar, 10, null);
        } catch (PackageManager.NameNotFoundException e6) {
            f(executor, cVar, 7, e6);
        }
    }
}

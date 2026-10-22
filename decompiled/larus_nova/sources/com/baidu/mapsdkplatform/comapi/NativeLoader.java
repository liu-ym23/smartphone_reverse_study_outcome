package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class NativeLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31947a = "NativeLoader";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f31948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f31949c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f31950d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static NativeLoader f31951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static c f31952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f31953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f31954h;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NativeLoader f31956b;

        public a(NativeLoader r100, String r101) {
            this.f31956b = r100;
            this.f31955a = r101;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r100, String r101) {
            if (r101 != null) goto L6;
            return false;
        L6:
            if (r101.contains("libBaiduMapSDK_") == true) goto L8;
            return false;
        L8:
            if (r101.contains(this.f31955a) == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31957a = null;

        static {
            int[] r100 = new int[c.values().length];
            f31957a = r100;
            r100[c.f31960c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f31957a[c.f31959b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f31957a[c.f31958a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f31957a[c.f31962e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f31957a[c.f31961d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f31958a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f31959b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f31960c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f31961d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f31962e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ c[] f31963f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f31964g;

        static {
            c r100 = new c("ARMEABI", 0, "armeabi");
            f31958a = r100;
            c r101 = new c("ARMV7", 1, "armeabi-v7a");
            f31959b = r101;
            c r102 = new c("ARM64", 2, "arm64-v8a");
            f31960c = r102;
            c r103 = new c("X86", 3, "x86");
            f31961d = r103;
            c r104 = new c("X86_64", 4, "x86_64");
            f31962e = r104;
            f31963f = new c[]{r100, r101, r102, r103, r104};
        }

        public static c[] values() {
            return (c[]) f31963f.clone();
        }

        public String a() {
            return this.f31964g;
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        private c(String r100, int r101, String r102) {
            super(r100, r101);
            this.f31964g = r102;
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        f31949c = new HashSet();
        f31950d = new HashSet();
        f31952f = c.f31958a;
        f31953g = false;
        f31954h = null;
    }

    private String a() {
        if (f31948b != null) goto L7;
        return "";
    L7:
        return f31948b.getPackageCodePath();
    }

    private String b() {
        if (f31948b != null) goto L6;
        return "";
    L6:
        PolarisFileWrapper r100 = new PolarisFileWrapper(f31948b.getFilesDir(), "libs" + File.separator + f31952f.a());
        if (r100.exists() == true) goto L10;
        r100.mkdirs();
    L10:
        return r100.getAbsolutePath();
    }

    private static c c() {
        String r100 = Build.SUPPORTED_ABIS[0];
        if (r100 != null) goto L7;
        return c.f31958a;
    L7:
        if (r100.contains("arm") == false) goto L12;
        if (r100.contains("v7") == false) goto L12;
        f31952f = c.f31959b;
    L12:
        if (r100.contains("arm") == false) goto L19;
        if (r100.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L19;
        if (d() == false) goto L19;
        f31952f = c.f31960c;
    L19:
        if (r100.contains("x86") == false) goto L25;
        if (r100.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L23;
        f31952f = c.f31962e;
        goto L25
    L23:
        f31952f = c.f31961d;
    L25:
        return f31952f;
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return Process.is64Bit();
    L6:
        return Build.CPU_ABI.equals(Build.SUPPORTED_64_BIT_ABIS[0]);
    }

    public static synchronized NativeLoader getInstance() {
        monitor-enter(NativeLoader.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f31951e != null) goto L7;
        f31951e = new NativeLoader();     // Catch: Throwable -> L10
        f31952f = c();     // Catch: Throwable -> L10
    L7:
        NativeLoader r100 = f31951e;     // Catch: Throwable -> L10
        monitor-exit(NativeLoader.class);
        return r100;
    }

    private NativeLoader() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_baidu_mapsdkplatform_comapi_NativeLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private boolean a(String r100) {
        String r101 = System.mapLibraryName(r100);
        Set<String> r102 = f31949c;
        monitor-enter(r102);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (r102.contains(r100) == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L32
        return true;
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L32
        int r103 = b.f31957a[f31952f.ordinal()];
        if (r103 != 1) goto L12;
        boolean r104 = b(r100, r101);
    L25:
        monitor-enter(r102);
        r102.add(r100);     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        return r104;
    L29:
        th = move-exception;
        throw th;
    L12:
        if (r103 != 2) goto L14;
        r104 = d(r100, r101);
        goto L25
    L14:
        if (r103 != 3) goto L16;
        r104 = c(r100, r101);
        goto L25
    L16:
        if (r103 != 4) goto L18;
        r104 = e(r100, r101);
        goto L25
    L18:
        if (r103 == 5) goto L20;
        r104 = false;
        goto L25
    L20:
        r104 = f(r100, r101);
        goto L25
    }

    private boolean b(String r100) {
        Set<String> r101 = f31949c;     // Catch: Throwable -> L20
        monitor-enter(r101);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L5:
        if (r101.contains(r100) == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L17
        return true;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L17
        INVOKESTATIC_com_baidu_mapsdkplatform_comapi_NativeLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: Throwable -> L20
        monitor-enter(r101);     // Catch: Throwable -> L20
        r101.add(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
        return a(r100);
    }

    public static void setContext(Context r100) {
        f31948b = r100;
    }

    public synchronized boolean loadLibrary(String r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (f31953g == true) goto L8;
        boolean r101 = b(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r101;
    L8:
        String r102 = f31954h;     // Catch: Throwable -> L18
        if (r102 != null) goto L11;
    L15:
        monitor-exit(this);
        return false;
    L11:
        if (r102.isEmpty() == true) goto L15;
        boolean r103 = a(r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r103;
    }

    private String a(c r100) {
        return "lib/" + r100.a() + HTTP.URL_DEFAULT;
    }

    private void a(Throwable r100) {
        Iterator<String> r101 = f31950d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        goto L4
    }

    private boolean a(String r100, c r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(b(), r100);
        if (r102.exists() == true) goto L5;
    L7:
        String r103 = a(r101) + r100;
        if (f31953g == true) goto L10;
        String r104 = a();
    L12:
        if (r104 != null) goto L14;
    L34:
        return false;
    L14:
        if (r104.isEmpty() == true) goto L34;
        PolarisZipFileWrapper r105 = null;
        PolarisZipFileWrapper r106 = new PolarisZipFileWrapper(r104);     // Catch: Throwable -> L28 Exception -> L38
        ZipEntry r107 = r106.getEntry(r103);     // Catch: Throwable -> L25 Exception -> L27
        if (r107 == null) goto L42;
        a(r106.getInputStream(r107), new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(b(), r100)));     // Catch: Throwable -> L25 Exception -> L27
        r106.close();     // Catch: IOException -> L35
    L24:
        return true;
    L42:
        r106.close();     // Catch: IOException -> L36
    L21:
        return false;
    L27:
        r105 = r106;
    L25:
        th = th;
        r105 = r106;
    L29:
        if (r105 != null) goto L40;
    L31:
        throw th;
    L40:
        r105.close();     // Catch: IOException -> L37
        goto L31
    L28:
        th = th;
    L32:
        if (r105 == null) goto L34;
        r105.close();     // Catch: IOException -> L39
        goto L34
    L10:
        r104 = f31954h;
        goto L12
    L5:
        if (r102.length() <= 0) goto L7;
        return true;
    }

    private boolean b(String r100, String r101) {
        if (a(r101, c.f31960c) == true) goto L7;
        return d(r100, r101);
    L7:
        return g(r101, r100);
    }

    private boolean c(String r100, String r101) {
        c r102 = c.f31958a;
        if (a(r101, r102) == true) goto L5;
        r102.a();
        return false;
    L5:
        return g(r101, r100);
    }

    private boolean d(String r100, String r101) {
        if (a(r101, c.f31959b) == true) goto L7;
        return c(r100, r101);
    L7:
        return g(r101, r100);
    }

    private boolean e(String r100, String r101) {
        if (a(r101, c.f31962e) == true) goto L7;
        return f(r100, r101);
    L7:
        return g(r101, r100);
    }

    private boolean f(String r100, String r101) {
        if (a(r101, c.f31961d) == true) goto L7;
        return d(r100, r101);
    L7:
        return g(r101, r100);
    }

    private boolean g(String r100, String r101) {
        com.baidu.mapsdkplatform.comapi.util.c.a(new PolarisFileWrapper(b(), r100).getAbsolutePath());     // Catch: Throwable -> L12
        Set<String> r102 = f31949c;     // Catch: Throwable -> L12
        monitor-enter(r102);     // Catch: Throwable -> L12
        r102.add(r101);     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        a(r100, r101);     // Catch: Throwable -> L12
        return true;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Set<String> r103 = f31950d;
        monitor-enter(r103);
        r103.add(r101);     // Catch: Throwable -> L19
        a(th);
        return false;
    L19:
        th = move-exception;
        throw th;
    }

    private void a(String r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (r100.contains("libBaiduMapSDK_") == false) goto L26;
        String[] r102 = r100.split("_v");     // Catch: Exception -> L20
        if (r102.length > 1) goto L11;
        return;
    L11:
        String r103 = r102[1];     // Catch: Exception -> L20
        File[] r104 = new PolarisFileWrapper(b()).listFiles(new a(this, r103));     // Catch: Exception -> L20
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.length == 0) goto L27;
        int r105 = r104.length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L29;
        r104[r106].delete();
        r106 = r106 + 1;
        goto L17
    L29:
        return;
    L27:
        return;
    L28:
        return;
    }

    private void a(InputStream r100, FileOutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];
    L24:
        int r103 = r100.read(r102);     // Catch: Throwable -> L10
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L10
        goto L24
    L6:
        r101.flush();     // Catch: Throwable -> L10
        r100.close();     // Catch: IOException -> L14
    L18:
        r101.close();     // Catch: IOException -> L15
        return;
    L29:
        return;
    L10:
        th = move-exception;
        r100.close();     // Catch: IOException -> L16
    L22:
        r101.close();     // Catch: IOException -> L17
        throw th;
    L30:
        throw th;
    }

    public static void a(boolean r100, String r101) {
        f31953g = r100;
        f31954h = r101;
    }
}

package com.baidu.mapsdkplatform.comapi;

import B0.g;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class NativeLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7823a = "NativeLoader";

    /* renamed from: b, reason: collision with root package name */
    private static Context f7824b;

    /* renamed from: e, reason: collision with root package name */
    private static NativeLoader f7827e;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f7825c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    private static final Set<String> f7826d = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static c f7828f = c.ARMEABI;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f7829g = false;

    /* renamed from: h, reason: collision with root package name */
    private static String f7830h = null;

    public class a implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7831a;

        public a(String str) {
            this.f7831a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.f7831a)) ? false : true;
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7833a;

        static {
            int[] iArr = new int[c.values().length];
            f7833a = iArr;
            try {
                iArr[c.ARM64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7833a[c.ARMV7.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7833a[c.ARMEABI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7833a[c.X86_64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7833a[c.X86.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum c {
        ARMEABI("armeabi"),
        ARMV7("armeabi-v7a"),
        ARM64("arm64-v8a"),
        X86("x86"),
        X86_64("x86_64");


        /* renamed from: g, reason: collision with root package name */
        private String f7840g;

        c(String str) {
            this.f7840g = str;
        }

        public String a() {
            return this.f7840g;
        }
    }

    private NativeLoader() {
    }

    public static void a(boolean z4, String str) {
        f7829g = z4;
        f7830h = str;
    }

    private boolean b(String str) {
        try {
            Set<String> set = f7825c;
            synchronized (set) {
                try {
                    if (set.contains(str)) {
                        return true;
                    }
                    System.loadLibrary(str);
                    synchronized (set) {
                        set.add(str);
                    }
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return a(str);
        }
    }

    private boolean c(String str, String str2) {
        c cVar = c.ARMEABI;
        if (a(str2, cVar)) {
            return g(str2, str);
        }
        Log.e(f7823a, "found lib " + cVar.a() + "/" + str + ".so error");
        return false;
    }

    private boolean d(String str, String str2) {
        return !a(str2, c.ARMV7) ? c(str, str2) : g(str2, str);
    }

    private boolean e(String str, String str2) {
        return !a(str2, c.X86_64) ? f(str, str2) : g(str2, str);
    }

    private boolean f(String str, String str2) {
        return !a(str2, c.X86) ? d(str, str2) : g(str2, str);
    }

    private boolean g(String str, String str2) {
        try {
            System.loadLibrary(new File(b(), str).getAbsolutePath());
            Set<String> set = f7825c;
            synchronized (set) {
                set.add(str2);
            }
            a(str, str2);
            return true;
        } catch (Throwable th) {
            Set<String> set2 = f7826d;
            synchronized (set2) {
                set2.add(str2);
                a(th);
                return false;
            }
        }
    }

    public static synchronized NativeLoader getInstance() {
        try {
            if (f7827e == null) {
                f7827e = new NativeLoader();
                f7828f = c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7827e;
    }

    public static void setContext(Context context) {
        f7824b = context;
    }

    public synchronized boolean loadLibrary(String str) {
        if (!f7829g) {
            return b(str);
        }
        String str2 = f7830h;
        if (str2 == null || str2.isEmpty()) {
            Log.e(f7823a, "Given custom so file path is null, please check!");
            return false;
        }
        return a(str);
    }

    private boolean a(String str) {
        boolean zB;
        String strMapLibraryName = System.mapLibraryName(str);
        Set<String> set = f7825c;
        synchronized (set) {
            try {
                if (set.contains(str)) {
                    return true;
                }
                int i4 = b.f7833a[f7828f.ordinal()];
                if (i4 == 1) {
                    zB = b(str, strMapLibraryName);
                } else if (i4 == 2) {
                    zB = d(str, strMapLibraryName);
                } else if (i4 == 3) {
                    zB = c(str, strMapLibraryName);
                } else if (i4 != 4) {
                    zB = i4 != 5 ? false : f(str, strMapLibraryName);
                } else {
                    zB = e(str, strMapLibraryName);
                }
                synchronized (set) {
                    set.add(str);
                }
                return zB;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TargetApi(21)
    private static c c() {
        String str = Build.SUPPORTED_ABIS[0];
        if (str == null) {
            return c.ARMEABI;
        }
        if (str.contains("arm") && str.contains("v7")) {
            f7828f = c.ARMV7;
        }
        if (str.contains("arm") && str.contains("64") && d()) {
            f7828f = c.ARM64;
        }
        if (str.contains("x86")) {
            if (str.contains("64")) {
                f7828f = c.X86_64;
            } else {
                f7828f = c.X86;
            }
        }
        return f7828f;
    }

    private static boolean d() {
        return Process.is64Bit();
    }

    private boolean b(String str, String str2) {
        if (!a(str2, c.ARM64)) {
            return d(str, str2);
        }
        return g(str2, str);
    }

    private String b() {
        if (f7824b == null) {
            return "";
        }
        File file = new File(f7824b.getFilesDir(), "libs" + File.separator + f7828f.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean a(String str, c cVar) throws Throwable {
        String strA;
        ZipFile zipFile;
        File file = new File(b(), str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        String strR = g.r(new StringBuilder(), a(cVar), str);
        if (!f7829g) {
            strA = a();
        } else {
            strA = f7830h;
        }
        if (strA == null || strA.isEmpty()) {
            return false;
        }
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(strA);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ZipEntry entry = zipFile.getEntry(strR);
            if (entry == null) {
                try {
                    zipFile.close();
                } catch (IOException e5) {
                    Log.e(f7823a, "Release file failed", e5);
                }
                return false;
            }
            a(zipFile.getInputStream(entry), new FileOutputStream(new File(b(), str)));
            try {
                zipFile.close();
            } catch (IOException e6) {
                Log.e(f7823a, "Release file failed", e6);
            }
            return true;
        } catch (Exception e7) {
            e = e7;
            zipFile2 = zipFile;
            Log.e(f7823a, "Copy library file error", e);
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e8) {
                    Log.e(f7823a, "Release file failed", e8);
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e9) {
                    Log.e(f7823a, "Release file failed", e9);
                }
            }
            throw th;
        }
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || !str.contains("libBaiduMapSDK_")) {
            return;
        }
        try {
            String[] strArrSplit = str.split("_v");
            if (strArrSplit.length <= 1) {
                return;
            }
            File[] fileArrListFiles = new File(b()).listFiles(new a(strArrSplit[1]));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    @TargetApi(8)
    private String a() {
        return f7824b == null ? "" : f7824b.getPackageCodePath();
    }

    private void a(Throwable th) {
        Log.e(f7823a, "loadException", th);
        for (String str : f7826d) {
            Log.e(f7823a, str + " Failed to load.");
        }
    }

    private void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i4 = inputStream.read(bArr);
                if (i4 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i4);
                }
            } finally {
            }
        }
        fileOutputStream.flush();
        try {
            inputStream.close();
        } catch (IOException e4) {
            Log.e(f7823a, "Close InputStream error", e4);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e5) {
            Log.e(f7823a, "Close OutputStream error", e5);
        }
    }

    private String a(c cVar) {
        return g.r(new StringBuilder("lib/"), cVar.a(), "/");
    }
}

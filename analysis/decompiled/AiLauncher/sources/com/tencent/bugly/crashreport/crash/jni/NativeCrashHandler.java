package com.tencent.bugly.crashreport.crash.jni;

import O6.l;
import Z7.C1130b;
import Z7.C1131c;
import Z7.C1138j;
import Z7.C1139k;
import Z7.C1143o;
import Z7.C1152y;
import Z7.P;
import Z7.r;
import Z7.z;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.as;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class NativeCrashHandler implements P {

    /* renamed from: k, reason: collision with root package name */
    public static NativeCrashHandler f31523k = null;

    /* renamed from: l, reason: collision with root package name */
    public static int f31524l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static String f31525m = null;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f31526n = true;

    /* renamed from: a, reason: collision with root package name */
    public final Context f31527a;

    /* renamed from: b, reason: collision with root package name */
    public final C1130b f31528b;

    /* renamed from: c, reason: collision with root package name */
    public final C1138j f31529c;

    /* renamed from: d, reason: collision with root package name */
    public Y7.a f31530d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31531e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f31532f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f31533g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f31534h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f31535i = false;

    /* renamed from: j, reason: collision with root package name */
    public as f31536j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!C1143o.t(NativeCrashHandler.this.f31527a, "native_record_lock")) {
                C1139k.d("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                return;
            }
            if (!NativeCrashHandler.f31526n) {
                NativeCrashHandler.g(NativeCrashHandler.this, "false");
            }
            CrashDetailBean crashDetailBeanA = z.a(NativeCrashHandler.this.f31527a, NativeCrashHandler.f31525m, NativeCrashHandler.this.f31530d);
            if (crashDetailBeanA != null) {
                C1139k.d("[Native] Get crash from native record.", new Object[0]);
                if (!NativeCrashHandler.this.f31536j.w(crashDetailBeanA, true)) {
                    NativeCrashHandler.this.f31536j.C(crashDetailBeanA, false);
                }
                z.i(false, NativeCrashHandler.f31525m);
            }
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
            long jZ = C1143o.z() - r.f7587q;
            long jZ2 = C1143o.z() + 86400000;
            File file = new File(NativeCrashHandler.f31525m);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, nativeCrashHandler.new b());
                        long length = 0;
                        int i10 = 0;
                        int i11 = 0;
                        for (File file2 : fileArrListFiles) {
                            long jLastModified = file2.lastModified();
                            length += file2.length();
                            if (jLastModified < jZ || jLastModified >= jZ2 || length >= r.f7586p) {
                                C1139k.d("[Native] Delete record file: %s", file2.getAbsolutePath());
                                i10++;
                                if (file2.delete()) {
                                    i11++;
                                }
                            }
                        }
                        C1139k.h("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i10), Integer.valueOf(i11));
                    }
                } catch (Throwable th) {
                    C1139k.e(th);
                }
            }
            C1143o.E(NativeCrashHandler.this.f31527a, "native_record_lock");
        }
    }

    public class b implements Comparator<File> {
        public b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return Long.compare(file2.lastModified(), file.lastModified());
        }
    }

    @SuppressLint({"SdCardPath"})
    public NativeCrashHandler(Context context, C1130b c1130b, as asVar, C1138j c1138j, boolean z10, String str) {
        this.f31527a = C1143o.a(context);
        if (C1143o.G(f31525m)) {
            try {
                if (C1143o.G(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + C1130b.h(context).f7453e + "/app_bugly";
            }
            f31525m = str;
        }
        this.f31536j = asVar;
        this.f31528b = c1130b;
        this.f31529c = c1138j;
        this.f31531e = z10;
        this.f31530d = new C1152y(context, c1130b, asVar, C1131c.a());
    }

    public static /* synthetic */ boolean g(NativeCrashHandler nativeCrashHandler, String str) {
        return nativeCrashHandler.f(RoomDatabase.MAX_BIND_PARAMETER_CNT, str);
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean h(String str, boolean z10) {
        boolean z11;
        try {
            C1139k.d("[Native] Trying to load so: %s", str);
            if (z10) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th) {
            th = th;
            z11 = false;
        }
        try {
            C1139k.d("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th2) {
            z11 = true;
            th = th2;
            C1139k.i(th.getMessage(), new Object[0]);
            C1139k.i("[Native] Failed to load so: %s", str);
            return z11;
        }
    }

    public static synchronized String q() {
        return f31525m;
    }

    public static synchronized NativeCrashHandler r() {
        return f31523k;
    }

    public static synchronized NativeCrashHandler s(Context context, C1130b c1130b, as asVar, C1131c c1131c, C1138j c1138j, boolean z10, String str) {
        try {
            if (f31523k == null) {
                f31523k = new NativeCrashHandler(context, c1130b, asVar, c1138j, z10, str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f31523k;
    }

    public boolean A(String str) {
        return f(13, str);
    }

    public boolean B(String str) {
        return f(10, str);
    }

    public boolean C(long j10) {
        try {
            return f(15, String.valueOf(j10));
        } catch (NumberFormatException e10) {
            if (C1139k.e(e10)) {
                return false;
            }
            e10.printStackTrace();
            return false;
        }
    }

    public boolean D(String str) {
        return f(11, str);
    }

    public synchronized void E(boolean z10) {
        try {
            n(z10);
            boolean zV = v();
            C1131c c1131cA = C1131c.a();
            if (c1131cA != null) {
                zV = zV && c1131cA.i().f31452f;
            }
            if (zV != this.f31534h) {
                C1139k.d("native changed to %b", Boolean.valueOf(zV));
                k(zV);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void F() {
        try {
            if (!this.f31533g && !this.f31532f) {
                boolean zG = C1143o.G(this.f31528b.f7429K);
                boolean z10 = !zG;
                if (r.f7581k) {
                    boolean zH = h(zG ? "Bugly_Native" : this.f31528b.f7429K, z10);
                    this.f31533g = zH;
                    if (!zH && zG) {
                        this.f31532f = h("NativeRQD", false);
                    }
                } else {
                    String str = "Bugly_Native";
                    C1130b c1130b = this.f31528b;
                    String str2 = c1130b.f7429K;
                    if (zG) {
                        c1130b.getClass();
                    } else {
                        str = str2;
                    }
                    this.f31533g = h(str, z10);
                }
                if (this.f31533g || this.f31532f) {
                    d(this.f31531e);
                    B(this.f31528b.f7422D);
                    z(this.f31528b.f7426H);
                    A(this.f31528b.f7453e);
                    D(this.f31528b.t());
                    a(this.f31528b.k());
                    C(this.f31528b.f7449c);
                    return;
                }
                return;
            }
            d(this.f31531e);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void G(boolean z10) {
        if (z10) {
            f(21, "true");
        } else {
            f(21, "false");
        }
    }

    @Override // Z7.P
    public boolean a(boolean z10) {
        return f(14, z10 ? "true" : "false");
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    @Override // Z7.P
    public String b() {
        if (!this.f31532f && !this.f31533g) {
            return null;
        }
        try {
            return this.f31533g ? getNativeLog() : (String) C1143o.d("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final synchronized void d(boolean z10) {
        if (this.f31534h) {
            C1139k.i("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        int i10 = 1;
        if (this.f31533g) {
            try {
                String strRegist = regist(f31525m, z10, f31524l);
                if (strRegist != null) {
                    C1139k.d("[Native] Native Crash Report enable.", new Object[0]);
                    this.f31528b.f7430L = strRegist;
                    String strConcat = l.DATE_SEPARATOR.concat(strRegist);
                    if (!r.f7581k && !this.f31528b.f7463j.contains(strConcat)) {
                        C1130b c1130b = this.f31528b;
                        c1130b.f7463j = c1130b.f7463j.concat(l.DATE_SEPARATOR).concat(this.f31528b.f7430L);
                    }
                    C1139k.d("comInfo.sdkVersion %s", this.f31528b.f7463j);
                    this.f31534h = true;
                    String strT = t();
                    if (!TextUtils.isEmpty(strT)) {
                        this.f31528b.s(strT);
                    }
                    return;
                }
            } catch (Throwable unused) {
                C1139k.h("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f31532f) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) C1143o.d("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, cls, cls}, new Object[]{f31525m, ab.g(), Integer.valueOf(z10 ? 1 : 5), 1});
                if (str == null) {
                    String str2 = f31525m;
                    String strG = ab.g();
                    C1130b.l();
                    str = (String) C1143o.d("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{str2, strG, Integer.valueOf(C1130b.b())});
                }
                if (str != null) {
                    this.f31534h = true;
                    this.f31528b.f7430L = str;
                    C1143o.d("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    if (!z10) {
                        i10 = 5;
                    }
                    C1143o.d("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(i10)});
                    String strT2 = t();
                    if (!TextUtils.isEmpty(strT2)) {
                        this.f31528b.s(strT2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f31533g = false;
        this.f31532f = false;
    }

    public final boolean f(int i10, String str) {
        if (!this.f31533g) {
            return false;
        }
        try {
            setNativeInfo(i10, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public final synchronized void k(boolean z10) {
        if (z10) {
            F();
        } else {
            m();
        }
    }

    public final synchronized void m() {
        if (!this.f31534h) {
            C1139k.i("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
        } catch (Throwable unused) {
            C1139k.h("[Native] Failed to close native crash report.", new Object[0]);
        }
        if (unregist() != null) {
            C1139k.d("[Native] Successfully closed native crash report.", new Object[0]);
            this.f31534h = false;
            return;
        }
        try {
            C1143o.d("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f31534h = false;
            C1139k.d("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            C1139k.h("[Native] Failed to close native crash report.", new Object[0]);
            this.f31533g = false;
            this.f31532f = false;
            return;
        }
    }

    public final synchronized void n(boolean z10) {
        if (this.f31535i != z10) {
            C1139k.d("user change native %b", Boolean.valueOf(z10));
            this.f31535i = z10;
        }
    }

    public void o() {
        this.f31529c.b(new a());
    }

    public void p() {
        f31524l |= 2;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z10, int i10);

    public native String removeNativeKeyValue(String str);

    public native void setNativeInfo(int i10, String str);

    public String t() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            C1139k.i("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public native void testCrash();

    public String u(String str) {
        return (this.f31533g || this.f31532f) ? getProperties(str) : "fail";
    }

    public native String unregist();

    public synchronized boolean v() {
        return this.f31535i;
    }

    public synchronized void w(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z10 = strategyBean.f31452f;
                if (z10 != this.f31534h) {
                    C1139k.i("server native changed to %b", Boolean.valueOf(z10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z11 = C1131c.a().i().f31452f && this.f31535i;
        if (z11 != this.f31534h) {
            C1139k.d("native changed to %b", Boolean.valueOf(z11));
            k(z11);
        }
    }

    public void x() {
        z.n(f31525m);
    }

    public void y() {
        f(20, "");
    }

    public boolean z(String str) {
        return f(12, str);
    }
}

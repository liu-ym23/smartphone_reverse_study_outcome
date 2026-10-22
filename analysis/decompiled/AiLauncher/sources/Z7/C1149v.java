package Z7;

import X7.a;
import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.as;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: Z7.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1149v {

    /* renamed from: o, reason: collision with root package name */
    public static C1149v f7631o;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7633b;

    /* renamed from: c, reason: collision with root package name */
    public final ActivityManager f7634c;

    /* renamed from: d, reason: collision with root package name */
    public final C1130b f7635d;

    /* renamed from: e, reason: collision with root package name */
    public final C1138j f7636e;

    /* renamed from: f, reason: collision with root package name */
    public final C1131c f7637f;

    /* renamed from: g, reason: collision with root package name */
    public final as f7638g;

    /* renamed from: i, reason: collision with root package name */
    public String f7640i;

    /* renamed from: j, reason: collision with root package name */
    public FileObserver f7641j;

    /* renamed from: l, reason: collision with root package name */
    public B f7643l;

    /* renamed from: m, reason: collision with root package name */
    public int f7644m;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f7632a = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public final Object f7639h = new Object();

    /* renamed from: k, reason: collision with root package name */
    public boolean f7642k = true;

    /* renamed from: n, reason: collision with root package name */
    public long f7645n = 0;

    /* renamed from: Z7.v$a */
    public class a extends FileObserver {
        public a(String str) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i10, String str) {
            if (str == null) {
                return;
            }
            C1139k.i("observe file, dir:%s fileName:%s", C1149v.this.f7640i, str);
            if (!str.startsWith("manual_bugly_trace_") || !str.endsWith(".txt")) {
                C1139k.h("not manual trace file, ignore.", new Object[0]);
                return;
            }
            if (!C1149v.this.f7632a.get()) {
                C1139k.h("proc is not in anr, just ignore", new Object[0]);
                return;
            }
            if (C1149v.this.f7635d.k()) {
                C1139k.h("Found foreground anr, resend sigquit immediately.", new Object[0]);
                NativeCrashHandler.r().y();
                long jA = C1140l.a(str, "manual_bugly_trace_", ".txt");
                C1149v.this.c(jA, C1149v.this.f7640i + "/" + str);
                C1139k.h("Finish handling one anr.", new Object[0]);
                return;
            }
            C1139k.h("Found background anr, resend sigquit later.", new Object[0]);
            long jA2 = C1140l.a(str, "manual_bugly_trace_", ".txt");
            C1149v.this.c(jA2, C1149v.this.f7640i + "/" + str);
            C1139k.h("Finish handling one anr, now resend sigquit.", new Object[0]);
            NativeCrashHandler.r().y();
        }
    }

    /* renamed from: Z7.v$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C1149v.d(C1149v.this);
        }
    }

    public C1149v(Context context, C1131c c1131c, C1130b c1130b, C1138j c1138j, as asVar) {
        Context contextA = C1143o.a(context);
        this.f7633b = contextA;
        this.f7634c = (ActivityManager) contextA.getSystemService("activity");
        if (C1143o.G(NativeCrashHandler.q())) {
            this.f7640i = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f7640i = NativeCrashHandler.q();
        }
        this.f7635d = c1130b;
        this.f7636e = c1138j;
        this.f7637f = c1131c;
        this.f7638g = asVar;
    }

    public static String b(List<C1151x> list, long j10) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb2 = new StringBuilder(4096);
        sb2.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
        sb2.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i10 = 0; i10 < list.size(); i10++) {
            C1151x c1151x = list.get(i10);
            sb2.append("Thread name:");
            sb2.append(c1151x.f7648a);
            sb2.append("\n");
            long j11 = c1151x.f7649b - j10;
            String str = j11 <= 0 ? "before " : "after ";
            sb2.append("Got ");
            sb2.append(str);
            sb2.append("anr:");
            sb2.append(Math.abs(j11));
            sb2.append("ms\n");
            sb2.append(c1151x.f7650c);
            sb2.append("\n");
            if (sb2.length() * 2 >= 101376) {
                break;
            }
        }
        sb2.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb2.toString();
    }

    public static /* synthetic */ void d(C1149v c1149v) {
        long jCurrentTimeMillis = (r.f7587q + System.currentTimeMillis()) - C1143o.z();
        C1140l.c(c1149v.f7640i, "bugly_trace_", ".txt", jCurrentTimeMillis);
        C1140l.c(c1149v.f7640i, "manual_bugly_trace_", ".txt", jCurrentTimeMillis);
        C1140l.c(c1149v.f7640i, "main_stack_record_", ".txt", jCurrentTimeMillis);
        C1140l.c(c1149v.f7640i, "main_stack_record_", ".txt.merged", jCurrentTimeMillis);
    }

    public static boolean f(String str, String str2, String str3) throws Throwable {
        Map<String, String[]> map;
        a.b bVarD = X7.a.d(str3, str, true);
        if (bVarD == null || (map = bVarD.f6865d) == null || map.isEmpty()) {
            C1139k.j("not found trace dump for %s", str3);
            return false;
        }
        StringBuilder sb2 = new StringBuilder(1024);
        String[] strArr = bVarD.f6865d.get("main");
        if (strArr != null && strArr.length >= 3) {
            sb2.append("\"main\" tid=");
            sb2.append(strArr[2]);
            sb2.append(" :\n");
            sb2.append(strArr[0]);
            sb2.append("\n");
            sb2.append(strArr[1]);
            sb2.append("\n\n");
        }
        for (Map.Entry<String, String[]> entry : bVarD.f6865d.entrySet()) {
            if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                sb2.append("\"");
                sb2.append(entry.getKey());
                sb2.append("\" tid=");
                sb2.append(entry.getValue()[2]);
                sb2.append(" :\n");
                sb2.append(entry.getValue()[0]);
                sb2.append("\n");
                sb2.append(entry.getValue()[1]);
                sb2.append("\n\n");
            }
        }
        return C1140l.f(str2, sb2.toString(), sb2.length() * 2);
    }

    public final CrashDetailBean a(C1148u c1148u) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f31472C = ab.m();
            crashDetailBean.f31473D = ab.i();
            crashDetailBean.f31474E = ab.o();
            crashDetailBean.f31475F = this.f7635d.y();
            crashDetailBean.f31476G = this.f7635d.x();
            crashDetailBean.f31477H = this.f7635d.z();
            crashDetailBean.f31478I = ab.c(this.f7633b);
            crashDetailBean.f31479J = ab.j();
            crashDetailBean.f31480K = ab.k();
            crashDetailBean.f31498b = 3;
            crashDetailBean.f31501e = this.f7635d.u();
            C1130b c1130b = this.f7635d;
            crashDetailBean.f31502f = c1130b.f7422D;
            crashDetailBean.f31503g = c1130b.E();
            crashDetailBean.f31509m = this.f7635d.t();
            crashDetailBean.f31510n = "ANR_EXCEPTION";
            crashDetailBean.f31511o = c1148u.f7629f;
            crashDetailBean.f31513q = c1148u.f7630g;
            HashMap map = new HashMap();
            crashDetailBean.f31489T = map;
            map.put("BUGLY_CR_01", c1148u.f7628e);
            String str = crashDetailBean.f31513q;
            int iIndexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f31512p = iIndexOf > 0 ? crashDetailBean.f31513q.substring(0, iIndexOf) : "GET_FAIL";
            crashDetailBean.f31514r = c1148u.f7626c;
            String str2 = crashDetailBean.f31513q;
            if (str2 != null) {
                crashDetailBean.f31517u = C1143o.I(str2.getBytes());
            }
            crashDetailBean.f31522z = c1148u.f7625b;
            crashDetailBean.f31470A = c1148u.f7624a;
            crashDetailBean.f31471B = "main(1)";
            crashDetailBean.f31481L = this.f7635d.G();
            crashDetailBean.f31504h = this.f7635d.D();
            crashDetailBean.f31505i = this.f7635d.a();
            crashDetailBean.f31518v = c1148u.f7627d;
            C1130b c1130b2 = this.f7635d;
            crashDetailBean.f31485P = c1130b2.f7430L;
            crashDetailBean.f31486Q = c1130b2.f7449c;
            crashDetailBean.f31487R = c1130b2.k();
            crashDetailBean.f31490U = this.f7635d.K();
            C1130b c1130b3 = this.f7635d;
            crashDetailBean.f31491V = c1130b3.f7435Q;
            crashDetailBean.f31492W = c1130b3.H();
            crashDetailBean.f31493X = this.f7635d.J();
            crashDetailBean.f31521y = C1142n.b();
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return crashDetailBean;
        }
    }

    public final void c(long j10, String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoA;
        List<C1151x> listC;
        try {
            C1139k.h("anr time:%s", Long.valueOf(j10));
            synchronized (this.f7639h) {
                try {
                    if (this.f7643l != null) {
                        C1139k.h("Disable record main stack trace.", new Object[0]);
                        this.f7643l.d();
                    }
                } finally {
                }
            }
            String strK = C1143o.k(Looper.getMainLooper().getThread());
            Map<String, String> mapQ = C1143o.q(this.f7635d.f7472n0, r.f7585o);
            if (this.f7635d.k()) {
                boolean z10 = ab.r() || ab.s();
                C1139k.h("isAnrCrashDevice:%s", Boolean.valueOf(z10));
                processErrorStateInfoA = z10 ? C1150w.a(this.f7634c, 0L) : C1150w.a(this.f7634c, 21000L);
            }
            if (processErrorStateInfoA == null) {
                C1139k.h("proc state is invisible or not my proc!", new Object[0]);
                return;
            }
            C1148u c1148u = new C1148u();
            c1148u.f7626c = j10;
            c1148u.f7624a = processErrorStateInfoA.processName;
            c1148u.f7629f = processErrorStateInfoA.shortMsg;
            c1148u.f7628e = processErrorStateInfoA.longMsg;
            c1148u.f7625b = mapQ;
            c1148u.f7630g = strK;
            if (TextUtils.isEmpty(strK)) {
                c1148u.f7630g = "main stack is null , some error may be encountered.";
            }
            Long lValueOf = Long.valueOf(c1148u.f7626c);
            String str2 = c1148u.f7627d;
            String str3 = c1148u.f7624a;
            String str4 = c1148u.f7630g;
            String str5 = c1148u.f7629f;
            String str6 = c1148u.f7628e;
            Map<String, String> map = c1148u.f7625b;
            C1139k.h("anr time:%d\ntrace file:%s\nproc:%s\nmain stack:%s\nshort msg:%s\nlong msg:%s\n threads:%d", lValueOf, str2, str3, str4, str5, str6, Integer.valueOf(map == null ? 0 : map.size()));
            C1139k.d("found visible anr , start to upload!", new Object[0]);
            C1139k.h("trace file:%s", str);
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                C1139k.h("trace file is null or not exists, just ignore", new Object[0]);
            } else {
                File file = new File(this.f7640i, "bugly_trace_" + j10 + ".txt");
                C1139k.h("trace file exists", new Object[0]);
                if (str.startsWith("/data/anr/")) {
                    C1139k.d("backup trace isOK:%s", Boolean.valueOf(f(str, file.getAbsolutePath(), c1148u.f7624a)));
                } else {
                    C1139k.d("trace file rename :%s", Boolean.valueOf(new File(str).renameTo(file)));
                }
                synchronized (this.f7639h) {
                    try {
                        B b10 = this.f7643l;
                        listC = b10 != null ? b10.f7310e.c() : null;
                    } finally {
                    }
                }
                if (listC != null) {
                    String strB = b(listC, j10);
                    C1139k.h("save main stack trace", new Object[0]);
                    C1140l.d(file, strB, 2147483647L, true);
                }
                c1148u.f7627d = file.getAbsolutePath();
            }
            CrashDetailBean crashDetailBeanA = a(c1148u);
            r.a().d(crashDetailBeanA);
            if (crashDetailBeanA.f31496a >= 0) {
                C1139k.d("backup anr record success!", new Object[0]);
            } else {
                C1139k.i("backup anr record fail!", new Object[0]);
            }
            as.k("ANR", C1143o.h(j10), c1148u.f7624a, "main", c1148u.f7630g, crashDetailBeanA);
            if (!this.f7638g.w(crashDetailBeanA, !ab.u())) {
                this.f7638g.C(crashDetailBeanA, true);
            }
            this.f7638g.i(crashDetailBeanA);
            synchronized (this.f7639h) {
                try {
                    if (this.f7643l != null) {
                        C1139k.h("Finish anr process.", new Object[0]);
                        this.f7643l.e();
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                C1139k.g(th);
            } finally {
                g(false);
            }
        }
    }

    public final boolean g(boolean z10) {
        boolean zCompareAndSet = this.f7632a.compareAndSet(!z10, z10);
        C1139k.h("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z10), Boolean.valueOf(zCompareAndSet));
        return zCompareAndSet;
    }

    public final synchronized void h() {
        C1139k.i("customer decides whether to open or close.", new Object[0]);
    }

    public final void i(boolean z10) {
        k(z10);
        boolean zM = m();
        C1131c c1131cA = C1131c.a();
        if (c1131cA != null) {
            zM = zM && c1131cA.i().f31452f;
        }
        if (zM != l()) {
            C1139k.d("anr changed to %b", Boolean.valueOf(zM));
            j(zM);
        }
    }

    public final synchronized void j(boolean z10) {
        if (z10) {
            n();
        } else {
            o();
        }
    }

    public final synchronized void k(boolean z10) {
        if (this.f7642k != z10) {
            C1139k.d("user change anr %b", Boolean.valueOf(z10));
            this.f7642k = z10;
        }
    }

    public final synchronized boolean l() {
        return this.f7641j != null;
    }

    public final synchronized boolean m() {
        return this.f7642k;
    }

    public final synchronized void n() {
        if (l()) {
            C1139k.i("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f7640i)) {
            return;
        }
        synchronized (this.f7639h) {
            try {
                B b10 = this.f7643l;
                if (b10 == null || !b10.isAlive()) {
                    B b11 = new B();
                    this.f7643l = b11;
                    boolean z10 = this.f7635d.f7474o0;
                    b11.f7311f = z10;
                    C1139k.h("set record stack trace enable:".concat(String.valueOf(z10)), new Object[0]);
                    B b12 = this.f7643l;
                    StringBuilder sb2 = new StringBuilder("Bugly-ThreadMonitor");
                    int i10 = this.f7644m;
                    this.f7644m = i10 + 1;
                    sb2.append(i10);
                    b12.setName(sb2.toString());
                    this.f7643l.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a aVar = new a(this.f7640i);
        this.f7641j = aVar;
        try {
            aVar.startWatching();
            C1139k.d("startWatchingPrivateAnrDir! dumFilePath is %s", this.f7640i);
            this.f7636e.b(new b());
        } catch (Throwable th2) {
            this.f7641j = null;
            C1139k.i("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (C1139k.e(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public final synchronized void o() {
        if (!l()) {
            C1139k.i("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f7639h) {
            try {
                B b10 = this.f7643l;
                if (b10 != null) {
                    b10.b();
                    this.f7643l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C1139k.d("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f7641j.stopWatching();
            this.f7641j = null;
            C1139k.i("close anr monitor!", new Object[0]);
        } catch (Throwable th2) {
            C1139k.i("stop anr monitor failed!", new Object[0]);
            if (C1139k.e(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }
}

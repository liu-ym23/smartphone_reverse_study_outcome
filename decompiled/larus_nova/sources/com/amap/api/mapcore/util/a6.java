package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w5 f26867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f26870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f26871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f26872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c6 f26873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c6 f26874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private u6.d f26875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private u6.d f26876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Handler f26877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d8 f26878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d8 f26879n;

    public class a implements u6.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a6 f26880a;

        /* JADX INFO: renamed from: com.amap.api.mapcore.util.a6$a$a, reason: collision with other inner class name */
        public class RunnableC0505a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f26881a;

            @Override // java.lang.Runnable
            public final void run() {
                com_amap_api_mapcore_util_a6$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public final void com_amap_api_mapcore_util_a6$a$a__run$___twin___() {
                a6.c(this.f26881a.f26880a);
            }

            public RunnableC0505a(a r100) {
                this.f26881a = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_mapcore_util_a6$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC0505a r100) {
                r100.com_amap_api_mapcore_util_a6$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(a6 r100) {
            this.f26880a = r100;
        }

        @Override // com.amap.api.mapcore.util.u6.d
        public final void a(int r100) {
            if (r100 > 0) goto L5;
            return;
        L5:
            if (a6.a(this.f26880a) != null) goto L7;
            return;
        L7:
            ((b6) a6.b(this.f26880a).f27186f).b(r100);
            long r101 = ((b6) a6.b(this.f26880a).f27186f).d();
            a6.a(this.f26880a, "error", String.valueOf(r101));
            a6.a(this.f26880a).postDelayed(new RunnableC0505a(this), 660000);
        }
    }

    public class b implements u6.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a6 f26882a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f26883a;

            @Override // java.lang.Runnable
            public final void run() {
                com_amap_api_mapcore_util_a6$b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public final void com_amap_api_mapcore_util_a6$b$a__run$___twin___() {
                a6.e(this.f26883a.f26882a);
            }

            public a(b r100) {
                this.f26883a = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_amap_api_mapcore_util_a6$b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
                r100.com_amap_api_mapcore_util_a6$b$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(a6 r100) {
            this.f26882a = r100;
        }

        @Override // com.amap.api.mapcore.util.u6.d
        public final void a(int r100) {
            if (r100 > 0) goto L4;
            return;
        L4:
            ((b6) a6.d(this.f26882a).f27186f).b(r100);
            long r101 = ((b6) a6.d(this.f26882a).f27186f).d();
            a6.a(this.f26882a, "info", String.valueOf(r101));
            if (a6.a(this.f26882a) != null) goto L7;
            return;
        L7:
            a6.a(this.f26882a).postDelayed(new a(this), 660000);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, a6> f26884a;

        static {
            f26884a = new HashMap();
        }
    }

    private String a() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L5
        e6 r101 = e6.a(this.f26866a);     // Catch: Throwable -> L5
        r101.getClass();     // Catch: Throwable -> L5
        r100.append(r101.a() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Throwable -> L5
        r100.append("0|1|debug|");     // Catch: Throwable -> L5
        r100.append(ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L5
        return r100.toString();
    L5:
        return null;
    }

    private boolean b() {
        if (this.f26866a == null) goto L6;
        return true;
    L6:
        return false;
    }

    private d8 c() {
        Context r100 = this.f26866a;
        if (r100 != null) goto L5;
        return null;
    L5:
        d8 r101 = new d8();
        this.f26879n = r101;
        r101.f27181a = a(r100, "CB5E100E5A9A3E7F6D1FD97512215282", this.f26867b);
        d8 r102 = this.f26879n;
        r102.f27182b = 512000000;
        r102.f27184d = 12500;
        r102.f27183c = "1";
        r102.f27188h = -1;
        r102.f27189i = "elkey";
        long r103 = a("error");
        d8 r104 = this.f26879n;
        r104.f27186f = new b6(true, new w8(this.f26866a, this.f26869d), r103, 10000000);
        r104.f27187g = null;
        return r104;
    }

    private d8 d() {
        Context r100 = this.f26866a;
        if (r100 != null) goto L5;
        return null;
    L5:
        d8 r101 = new d8();
        this.f26878m = r101;
        r101.f27181a = a(r100, "CAF9B6B99962BF5C2264824231D7A40C", this.f26867b);
        d8 r102 = this.f26878m;
        r102.f27182b = 512000000;
        r102.f27184d = 12500;
        r102.f27183c = "1";
        r102.f27188h = -1;
        r102.f27189i = "inlkey";
        long r103 = a("info");
        d8 r104 = this.f26878m;
        r104.f27186f = new b6(this.f26871f, new w8(this.f26866a, this.f26869d), r103, 30000000);
        r104.f27187g = null;
        return r104;
    }

    public void e() {
        if (b() == true) goto L5;
        return;
    L5:
        a(2);
        a(1);
    }

    public a6(w5 r100) {
        this.f26868c = true;
        this.f26869d = false;
        this.f26870e = true;
        this.f26871f = false;
        this.f26872g = new ArrayList();
        this.f26873h = new c6((byte) 0);
        this.f26874i = new c6();
        this.f26875j = new a(this);
        this.f26876k = new b(this);
        this.f26877l = null;
        this.f26878m = null;
        this.f26879n = null;
        this.f26867b = r100;
    }

    private d8 b(int r100) {
        if (r100 != 2) goto L12;
        d8 r101 = this.f26879n;
        if (r101 != null) goto L11;
        if (r101 != null) goto L9;
        c();
        r101 = this.f26879n;
    L9:
        this.f26879n = r101;
    L11:
        return this.f26879n;
    L12:
        d8 r102 = this.f26878m;
        if (r102 != null) goto L19;
        if (r102 != null) goto L17;
        d();
        r102 = this.f26878m;
    L17:
        this.f26878m = r102;
    L19:
        return this.f26878m;
    }

    public static d8 d(a6 r100) {
        d8 r101 = r100.f26878m;
        if (r101 != null) goto L7;
        r100.d();
        return r100.f26878m;
    L7:
        return r101;
    }

    public static /* synthetic */ void e(a6 r100) {
        r100.b(false);
    }

    public void a(z5 r110) {
        if (b() == true) goto L5;
        return;
    L5:
        if (this.f26868c == true) goto L8;
        return;
    L8:
        if ((!TextUtils.isEmpty(r110.b())) == true) goto L10;
        return;
    L10:
        List<String> r100 = this.f26872g;
        if (r100 != null) goto L13;
    L24:
        boolean r101 = false;
    L25:
        if (r101 == false) goto L28;
        return;
    L28:
        if (this.f26870e == true) goto L33;
        if (r110.c() != 1) goto L33;
        return;
    L33:
        if (r110.c() != 2) goto L35;
        c6 r102 = this.f26874i;
    L37:
        if (r102.a(r110.b()) == false) goto L48;
        String r103 = z5.a(this.f26866a, r102.a());
        if (this.f26866a != null) goto L42;
        return;
    L42:
        if (TextUtils.isEmpty(r103) == false) goto L44;
        return;
    L44:
        if ("[]".equals(r103) == true) goto L54;
        u6.a(this.f26866a, this.f26867b, r110.a(), b(r110.c()), r103, a());
        a(false);
        b(false);
        r102.b();
        goto L48
    L54:
        return;
    L48:
        r102.a(r110);
        return;
    L35:
        r102 = this.f26873h;
        goto L37
    L13:
        if (r100.size() == 0) goto L24;
        int r104 = 0;
    L17:
        if (r104 >= this.f26872g.size()) goto L24;
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(this.f26872g, r104)) == true) goto L23;
        if (r110.b().contains((CharSequence) ListProtector.get(this.f26872g, r104)) == false) goto L23;
        r101 = true;
    L23:
        r104 = r104 + 1;
        goto L17
    }

    public void c(boolean r100) {
        if (b() == true) goto L5;
        return;
    L5:
        a(r100);
        b(r100);
    }

    private void a(int r110) {
        if (r110 != 2) goto L5;
        c6 r100 = this.f26874i;
    L6:
        String r101 = z5.a(this.f26866a, r100.a());
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        if ("[]".equals(r101) == false) goto L12;
        return;
    L12:
        if (this.f26866a != null) goto L14;
        return;
    L14:
        String r102 = a();
        Context r103 = this.f26866a;
        w5 r104 = this.f26867b;
        if (r110 != 2) goto L17;
        String r105 = "error";
    L18:
        u6.a(r103, r104, r105, b(r110), r101, r102);
        r100.b();
        return;
    L17:
        r105 = "info";
        goto L18
    L5:
        r100 = this.f26873h;
        goto L6
    }

    private void b(boolean r100) {
        d8 r101 = b(1);
        if (r100 == false) goto L5;
        ((b6) r101.f27186f).b(r100);
    L5:
        Context r102 = this.f26866a;
        if (r102 != null) goto L8;
        return;
    L8:
        u6.a(r102, r101, this.f26876k);
    }

    public static /* synthetic */ void c(a6 r100) {
        r100.a(false);
    }

    private long a(String r100) {
        String r101 = new SimpleDateFormat("yyyyMMdd").format(new Date());     // Catch: Throwable -> L5
        return Long.parseLong(d6.a(this.f26867b).a(this.f26866a, "", "", r101 + r100));
    L5:
        return 0;
    }

    public static d8 b(a6 r100) {
        d8 r101 = r100.f26879n;
        if (r101 != null) goto L7;
        r100.c();
        return r100.f26879n;
    L7:
        return r101;
    }

    public static a6 a(w5 r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r100.d()) == false) goto L7;
        return null;
    L7:
        if (c.f26884a.get(r100.d()) != null) goto L10;
        c.f26884a.put(r100.d(), new a6(r100));
    L10:
        return c.f26884a.get(r100.d());
    }

    public static /* synthetic */ Handler a(a6 r100) {
        if (r100.f26866a != null) goto L5;
        return null;
    L5:
        if (r100.f26877l != null) goto L8;
        r100.f26877l = new Handler(r100.f26866a.getMainLooper());
    L8:
        return r100.f26877l;
    }

    private void a(boolean r100) {
        d8 r101 = b(2);
        if (r100 == false) goto L5;
        ((b6) r101.f27186f).b(r100);
    L5:
        Context r102 = this.f26866a;
        if (r102 != null) goto L8;
        return;
    L8:
        u6.a(r102, r101, this.f26875j);
    }

    public void a(Context r100) {
        this.f26866a = r100.getApplicationContext();
    }

    private static String a(Context r100, String r101, w5 r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r102 != null) goto L14;
    L10:
        String r103 = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
    L11:
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L13
        r104.append(r100.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L13
        String r105 = File.separator;     // Catch: Throwable -> L13
        r104.append(r105);     // Catch: Throwable -> L13
        r104.append("EBDEC84EF205FEA2DF0719DEB822869E");     // Catch: Throwable -> L13
        r104.append(r105);     // Catch: Throwable -> L13
        r104.append(r101);     // Catch: Throwable -> L13
        r104.append(r105);     // Catch: Throwable -> L13
        r104.append(r103);     // Catch: Throwable -> L13
        return r104.toString();
    L13:
        return null;
    L14:
        if (TextUtils.isEmpty(r102.d()) == true) goto L10;
        r103 = t5.c(r102.d());     // Catch: Throwable -> L13
        goto L11
    }

    public static /* synthetic */ void a(a6 r100, String r101, String r110) {
        String r102 = new SimpleDateFormat("yyyyMMdd").format(new Date());     // Catch: Throwable -> L6
        d6.a(r100.f26867b).a(r100.f26866a, "", "", r102 + r101, r110);     // Catch: Throwable -> L6
        return;
    }

    public void a(boolean r100, boolean r101, boolean r102, boolean r103, List<String> r104) {
        this.f26868c = r100;
        this.f26869d = r101;
        this.f26870e = r102;
        this.f26871f = r103;
        this.f26872g = r104;
        c();
        d();
    }
}

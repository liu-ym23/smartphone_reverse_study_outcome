package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: RetrofitLayerMetrics.java */
/* JADX INFO: loaded from: classes.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9404a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9405b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f9406c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f9407d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f9408e = 16;
    private static volatile int k = -1;
    public b f;
    public a g;
    public c h;
    r i;
    public d j;

    /* JADX INFO: compiled from: RetrofitLayerMetrics.java */
    public static class a {
        static final /* synthetic */ boolean n = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9413e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        private long o;

        static {
            n = true;
        }

        public a() {
            this.o = -1;
            this.f9409a = -1;
            this.f9410b = -1;
            this.f9411c = -1;
            this.f9412d = -1;
            this.f9413e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
        }

        public void a() {
            if (n == false) goto L5;
        L9:
            this.o = System.nanoTime();
            return;
        L5:
            if (this.o == (-1)) goto L9;
            throw new AssertionError();
        }

        public long b() {
            if (n == false) goto L5;
        L9:
            long r3 = System.nanoTime() - this.o;
            this.o = -1;
            return r3;
        L5:
            if (this.o != (-1)) goto L9;
            throw new AssertionError();
        }

        public JSONObject c() {
            if ((ad.d() & ad.f9405b) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("wait_hcall_exe", String.valueOf(am.b(this.f9409a)));
            r0.put("mon_http_bfr_flt", String.valueOf(am.b(this.f9410b)));
            r0.put("flt_url", String.valueOf(am.b(this.f9411c)));
            r0.put("mon_http_aft_flt", String.valueOf(am.b(this.f9412d)));
            r0.put("add_com_prm", String.valueOf(am.b(this.f9413e)));
            r0.put("encrypt_req", String.valueOf(am.b(this.f)));
            r0.put("req_vfy", String.valueOf(am.b(this.g)));
            r0.put("cmd_lst", String.valueOf(am.b(this.h)));
            r0.put("chk_req_tkt", String.valueOf(am.b(this.i)));
            r0.put("post_cdn_cache_vfy", String.valueOf(am.b(this.j)));
            r0.put("biz_req_itcpt", String.valueOf(am.b(this.k)));
            r0.put("biz_rsp_itcpt", String.valueOf(am.b(this.l)));
            r0.put("hcall_async_cb", String.valueOf(am.b(this.m)));
            return r0;
        }

        public a d() {
            a r0 = new a();
            r0.o = this.o;
            r0.f9409a = this.f9409a;
            r0.f9410b = this.f9410b;
            r0.f9411c = this.f9411c;
            r0.f9412d = this.f9412d;
            r0.f9413e = this.f9413e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            r0.i = this.i;
            r0.j = this.j;
            r0.k = this.k;
            r0.l = this.l;
            r0.m = this.m;
            return r0;
        }
    }

    /* JADX INFO: compiled from: RetrofitLayerMetrics.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9418e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;
        public long o;
        public long p;
        public long q;
        public long r;
        public long s;
        public long t;
        public long u;
        public long v;
        public long w;
        public long x;

        public b() {
            this.f9414a = -1;
            this.f9415b = -1;
            this.f9416c = -1;
            this.f9417d = -1;
            this.f9418e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
        }

        public JSONObject a() {
            if ((ad.d() & ad.f9404a) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("app_start", String.valueOf(am.b(this.f9414a)));
            r0.put("app_start_wc", String.valueOf(this.f9415b));
            r0.put("cronet_init_s", String.valueOf(am.b(this.f9416c)));
            r0.put("cronet_init_e", String.valueOf(am.b(this.f9417d)));
            r0.put("create_hcall_s_wc", String.valueOf(this.f9418e));
            r0.put("create_hcall_s", String.valueOf(am.b(this.f)));
            r0.put("create_hcall_e", String.valueOf(am.b(this.g)));
            r0.put("hcall_api_s", String.valueOf(am.b(this.k)));
            r0.put("hcall_api_s_ws", String.valueOf(this.l));
            r0.put("hcall_api_e", String.valueOf(am.b(this.m)));
            r0.put("req_real_s", String.valueOf(am.b(this.j)));
            r0.put("req_itcpt_s", String.valueOf(am.b(this.n)));
            r0.put("req_itcpt_e", String.valueOf(am.b(this.o)));
            r0.put("sscall_s", String.valueOf(am.b(this.p)));
            r0.put("sscall_e", String.valueOf(am.b(this.q)));
            r0.put("rsp_itcpt_s", String.valueOf(am.b(this.r)));
            r0.put("rsp_itcpt_e", String.valueOf(am.b(this.s)));
            r0.put("biz_rcv_rsp_hdr_wc", String.valueOf(this.u));
            r0.put("biz_rcv_rsp_hdr", String.valueOf(am.b(this.t)));
            r0.put("req_e_wc", String.valueOf(this.w));
            r0.put("req_e", String.valueOf(am.b(this.v)));
            r0.put("log_rpt", String.valueOf(am.b(this.x)));
            return r0;
        }

        public b b() {
            b r0 = new b();
            r0.f9414a = this.f9414a;
            r0.f9415b = this.f9415b;
            r0.f9416c = this.f9416c;
            r0.f9417d = this.f9417d;
            r0.f9418e = this.f9418e;
            r0.f = this.f;
            r0.g = this.g;
            r0.l = this.l;
            r0.j = this.j;
            r0.k = this.k;
            r0.m = this.m;
            r0.n = this.n;
            r0.o = this.o;
            r0.p = this.p;
            r0.q = this.q;
            r0.r = this.r;
            r0.s = this.s;
            r0.t = this.t;
            r0.u = this.u;
            r0.v = this.v;
            r0.w = this.w;
            r0.x = this.x;
            return r0;
        }
    }

    /* JADX INFO: compiled from: RetrofitLayerMetrics.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9422d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9423e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        private Deque<Long> k;

        public c() {
            this.k = new ArrayDeque();
            this.f9419a = -1;
            this.f9420b = -1;
            this.f9421c = -1;
            this.f9422d = -1;
            this.f9423e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
        }

        public void a() {
            this.k.push(Long.valueOf(System.nanoTime()));
        }

        public long b() {
            Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.k.pop(), Long.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L4
            return System.nanoTime() - r4.longValue();
        L4:
            e = move-exception;
            e.printStackTrace();
            return -1;
        }

        public JSONObject c() {
            if ((ad.d() & ad.f9406c) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("crt_req_fact", String.valueOf(am.b(this.f9419a)));
            r0.put("crt_http_svc_meth", String.valueOf(am.b(this.f9420b)));
            r0.put("to_retrofit_req", String.valueOf(am.b(this.f9421c)));
            r0.put("req_delay", String.valueOf(am.b(this.f9422d)));
            r0.put("flt_dup_qry", String.valueOf(am.b(this.f9423e)));
            r0.put("gen_req_tkt", String.valueOf(am.b(this.f)));
            r0.put("pre_cdn_cache_vrf", String.valueOf(am.b(this.g)));
            r0.put("add_cli_key", String.valueOf(am.b(this.h)));
            r0.put("to_ss_rsp", String.valueOf(am.b(this.i)));
            r0.put("upd_cli_key", String.valueOf(am.b(this.j)));
            return r0;
        }

        public c d() {
            c r0 = new c();
            if (this.k.isEmpty() == true) goto L8;
            r0.k = new ArrayDeque();
            Iterator<Long> r1 = this.k.iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            Long r2 = (Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.aiagent.plugin");
            r0.k.push(r2);
        L8:
            r0.f9419a = this.f9419a;
            r0.f9420b = this.f9420b;
            r0.f9421c = this.f9421c;
            r0.f9423e = this.f9423e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            r0.i = this.i;
            r0.j = this.j;
            return r0;
        }
    }

    /* JADX INFO: compiled from: RetrofitLayerMetrics.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Throwable f9426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public transient WeakReference<Throwable> f9428e;
        public long f;
        public long g;

        public d() {
            this.f9424a = false;
            this.f9425b = 0;
            this.f9426c = null;
            this.f9427d = 0;
            this.f9428e = null;
            this.f = -1;
            this.g = -1;
        }

        public JSONObject a() {
            if ((ad.d() & ad.f9408e) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("call_svr_times", this.f9425b);
            r0.put("app_rsm_ssp_req_s", this.f);
            r0.put("app_rsm_ssp_req_e", this.g);
            return r0;
        }

        public d b() {
            d r0 = new d();
            r0.f9424a = this.f9424a;
            r0.f9425b = this.f9425b;
            r0.f9427d = this.f9427d;
            r0.f = this.f;
            r0.g = this.g;
            if (this.f9426c == null) goto L5;
            Throwable r1 = new Throwable(this.f9426c.getMessage());
            r0.f9426c = r1;
            r1.setStackTrace(this.f9426c.getStackTrace());
        L5:
            WeakReference<Throwable> r2 = this.f9428e;
            if (r2 != null) goto L8;
        L10:
            return r0;
        L8:
            if (r2.get() == null) goto L10;
            WeakReference<Throwable> r3 = new WeakReference(new Throwable(((Throwable) ZeusTransformUtils.preCheckCast(this.f9428e.get(), Throwable.class, "com.obric.aiagent.plugin")).getMessage()));
            r0.f9428e = r3;
            ((Throwable) ZeusTransformUtils.preCheckCast(r3.get(), Throwable.class, "com.obric.aiagent.plugin")).setStackTrace(((Throwable) ZeusTransformUtils.preCheckCast(this.f9428e.get(), Throwable.class, "com.obric.aiagent.plugin")).getStackTrace());
            goto L10
        }
    }

    static {
    }

    static /* synthetic */ int d() {
        return k;
    }

    public static void a(int r0) {
        k = r0;
    }

    public ad() {
        this.f = new b();
        this.g = new a();
        this.h = new c();
        this.i = new r();
        this.j = new d();
        if (af.f9430a == null) goto L6;
        b r0 = this.f;
        r0.f9414a = af.f9430a.a();
        b r3 = this.f;
        r3.f9415b = af.f9430a.b();
        return;
    }

    public long a() {
        return this.f.w - this.f.l;
    }

    public JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("event_ts", this.f.a());
        r0.put("biz_span", this.g.c());
        r0.put("inner_span", this.h.c());
        if ((k & f9407d) == 0) goto L5;
        r0.put("intcptr", this.i.c());
    L5:
        r0.put("misc", this.j.a());
        return r0;
    }

    public ad c() {
        ad r0 = new ad();
        r0.f = this.f.b();
        r0.g = this.g.d();
        r0.h = this.h.d();
        r0.i = this.i.d();
        r0.j = this.j.b();
        return r0;
    }
}

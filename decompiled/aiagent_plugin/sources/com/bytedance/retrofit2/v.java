package com.bytedance.retrofit2;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkLibLayerMetrics.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9597a = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9598b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f9599c = 128;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f9600d = 256;
    private static volatile int k = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f9601e;
    public a f;
    public c g;
    public d h;
    public e i;
    public String j;

    /* JADX INFO: compiled from: NetworkLibLayerMetrics.java */
    public static class a {
        static final /* synthetic */ boolean k = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9606e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        private long l;

        static {
            k = true;
        }

        public a() {
            this.l = -1;
            this.f9602a = -1;
            this.f9603b = -1;
            this.f9604c = -1;
            this.f9605d = -1;
            this.f9606e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
        }

        public void a() {
            if (k == false) goto L5;
        L9:
            this.l = System.nanoTime();
            return;
        L5:
            if (this.l == (-1)) goto L9;
            throw new AssertionError();
        }

        public long b() {
            if (k == false) goto L5;
        L9:
            long r3 = System.nanoTime() - this.l;
            this.l = -1;
            return r3;
        L5:
            if (this.l != (-1)) goto L9;
            throw new AssertionError();
        }

        public JSONObject c() {
            if ((v.c() & v.f9598b) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("bdy_encrypt", String.valueOf(am.b(this.f9602a)));
            r0.put("on_try_init", String.valueOf(am.b(this.f9603b)));
            r0.put("init_cookie", String.valueOf(am.b(this.f9604c)));
            r0.put("bd_turing", String.valueOf(am.b(this.f9605d)));
            r0.put("acnt_rty", String.valueOf(am.b(this.f9606e)));
            r0.put("rot_rty", String.valueOf(am.b(this.f)));
            r0.put("wait_rd_rsp_bdy", String.valueOf(am.b(this.h)));
            r0.put("rd_rsp_bdy_intvl", String.valueOf(am.b(this.i)));
            r0.put("input_stream_prc", String.valueOf(am.b(this.j)));
            long r1 = this.g;
            if (r1 <= 0) goto L9;
            r0.put("req_audit", String.valueOf(am.b(r1)));
        L9:
            return r0;
        }

        public a d() {
            a r0 = new a();
            r0.l = this.l;
            r0.f9602a = this.f9602a;
            r0.f9603b = this.f9603b;
            r0.f9604c = this.f9604c;
            r0.f9605d = this.f9605d;
            r0.f9606e = this.f9606e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            r0.i = this.i;
            r0.j = this.j;
            return r0;
        }
    }

    /* JADX INFO: compiled from: NetworkLibLayerMetrics.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9611e;
        public long f;
        public long g;
        public long h;

        public b() {
            this.f9607a = -1;
            this.f9608b = -1;
            this.f9609c = -1;
            this.f9610d = -1;
            this.f9611e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
        }

        public JSONObject a() {
            if ((v.c() & v.f9597a) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("prp_conn_s", String.valueOf(am.b(this.f9607a)));
            r0.put("prp_conn_e", String.valueOf(am.b(this.f9608b)));
            r0.put("exe_conn_s", String.valueOf(am.b(this.f9609c)));
            r0.put("exe_conn_e", String.valueOf(am.b(this.f9610d)));
            r0.put("prc_rsp_bdy_s", String.valueOf(am.b(this.f9611e)));
            r0.put("prc_rsp_bdy_e", String.valueOf(am.b(this.f)));
            r0.put("frs_rd_rsp_bdy_s", String.valueOf(am.b(this.g)));
            r0.put("lst_rd_rsp_bdy_e", String.valueOf(am.b(this.h)));
            return r0;
        }

        public b b() {
            b r0 = new b();
            r0.f9607a = this.f9607a;
            r0.f9608b = this.f9608b;
            r0.f9609c = this.f9609c;
            r0.f9610d = this.f9610d;
            r0.f9611e = this.f9611e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            return r0;
        }
    }

    /* JADX INFO: compiled from: NetworkLibLayerMetrics.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9616e;
        public long f;
        public long g;
        public long h;
        public long i;
        private Deque<Long> j;

        public c() {
            this.j = new ArrayDeque();
            this.f9612a = -1;
            this.f9613b = -1;
            this.f9614c = -1;
            this.f9615d = -1;
            this.f9616e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
        }

        public void a() {
            this.j.push(Long.valueOf(System.nanoTime()));
        }

        public long b() {
            Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.j.pop(), Long.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L4
            return System.nanoTime() - r4.longValue();
        L4:
            e = move-exception;
            e.printStackTrace();
            return -1;
        }

        public JSONObject c() {
            if ((v.c() & v.f9599c) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            r0.put("qry_flt", String.valueOf(am.b(this.f9612a)));
            r0.put("last_cons_conn", String.valueOf(am.b(this.f9613b)));
            r0.put("last_conf_conn", String.valueOf(am.b(this.f9614c)));
            r0.put("last_exe_conn", String.valueOf(am.b(this.f9616e)));
            r0.put("cons_conf_n_rty_conn", String.valueOf(am.b(this.f)));
            r0.put("prc_rsp_bdy", String.valueOf(am.b(this.g)));
            r0.put("post_prc_rsp_bdy", String.valueOf(am.b(this.h)));
            r0.put("total_rd_rsp_bdy", String.valueOf(am.b(this.i)));
            r0.put("reflect", String.valueOf(am.b(this.f9615d)));
            return r0;
        }

        public c d() {
            c r0 = new c();
            r0.f9612a = this.f9612a;
            r0.f9613b = this.f9613b;
            r0.f9614c = this.f9614c;
            r0.f9616e = this.f9616e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            r0.i = this.i;
            r0.f9615d = this.f9615d;
            if (this.j.isEmpty() == true) goto L8;
            r0.j = new ArrayDeque();
            Iterator<Long> r4 = this.j.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(r4.next(), Long.class, "com.obric.aiagent.plugin");
            r0.j.push(r1);
        L8:
            return r0;
        }
    }

    /* JADX INFO: compiled from: NetworkLibLayerMetrics.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9621e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;

        public d() {
            this.f9617a = -1;
            this.f9618b = -1;
            this.f9619c = -1;
            this.f9620d = -1;
            this.f9621e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
        }

        public d a() {
            d r0 = new d();
            r0.f9617a = this.f9617a;
            r0.f9618b = this.f9618b;
            r0.f9619c = this.f9619c;
            r0.f9620d = this.f9620d;
            r0.f9621e = this.f9621e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            r0.i = this.i;
            r0.j = this.j;
            return r0;
        }
    }

    /* JADX INFO: compiled from: NetworkLibLayerMetrics.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f9625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f9626e;
        public boolean f;
        public Object g;
        public JSONObject h;

        public e() {
            this.f9622a = false;
            this.f9623b = -1;
            this.f9624c = null;
            this.f9625d = null;
            this.f9626e = -1;
            this.f = false;
            this.g = null;
            this.h = null;
        }

        public JSONObject a() {
            if ((v.c() & v.f9600d) != 0) goto L6;
            return null;
        L6:
            JSONObject r0 = new JSONObject();
            JSONObject r1 = this.h;
            if (r1 == null) goto L10;
            r0.put("req_audit", r1);
        L10:
            if (TextUtils.isEmpty(this.f9624c) == false) goto L14;
        L12:
            return r0;
        L14:
            r0.put("cookie_rel", new JSONObject(this.f9624c));     // Catch: Throwable -> L13
            goto L12
        }

        public e b() {
            e r0 = new e();
            r0.f9622a = this.f9622a;
            r0.f9623b = this.f9623b;
            r0.f9624c = this.f9624c;
            r0.f9626e = this.f9626e;
            r0.f = this.f;
            r0.g = this.g;
            if (this.f9625d == null) goto L7;
            r0.f9625d = new JSONObject(this.f9625d.toString());     // Catch: JSONException -> L10
        L7:
            if (this.h == null) goto L9;
            r0.h = new JSONObject(this.h.toString());     // Catch: JSONException -> L10
        L9:
            return r0;
        }
    }

    static {
    }

    public v() {
        this.f9601e = new b();
        this.f = new a();
        this.g = new c();
        this.h = new d();
        this.i = new e();
        this.j = "";
    }

    static /* synthetic */ int c() {
        return k;
    }

    public static void a(int r0) {
        k = r0;
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("event_ts", this.f9601e.a());
        r0.put("biz_span", this.f.c());
        r0.put("inner_span", this.g.c());
        r0.put("misc", this.i.a());
        return r0;
    }

    public v b() {
        v r0 = new v();
        r0.f9601e = this.f9601e.b();
        r0.f = this.f.d();
        r0.g = this.g.d();
        r0.h = this.h.a();
        r0.i = this.i.b();
        r0.j = this.j;
        return r0;
    }
}

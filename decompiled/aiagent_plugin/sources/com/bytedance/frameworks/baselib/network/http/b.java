package com.bytedance.frameworks.baselib.network.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.c;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.u;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseHttpRequestInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T extends c> implements u {
    private static volatile a ad;

    @Deprecated
    public long A;

    @Deprecated
    public long B;

    @Deprecated
    public int C;

    @Deprecated
    public boolean D;

    @Deprecated
    public long E;
    public boolean F;
    public int G;
    public int H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @Deprecated
    public String f8134J;
    public JSONObject K;

    @Deprecated
    public boolean L;
    public String M;
    public String N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;

    @Deprecated
    public long U;
    public String V;
    public boolean W;

    @Deprecated
    public long X;
    public boolean Y;
    public j Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8135a;
    public long aa;

    @Deprecated
    public boolean ab;

    @Deprecated
    public final AtomicBoolean ac;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f8137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public af f8138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public long f8139e;

    @Deprecated
    public long f;

    @Deprecated
    public long g;

    @Deprecated
    public long h;

    @Deprecated
    public long i;

    @Deprecated
    public long j;

    @Deprecated
    public long k;

    @Deprecated
    public long l;

    @Deprecated
    public long m;

    @Deprecated
    public long n;

    @Deprecated
    public long o;

    @Deprecated
    public long p;

    @Deprecated
    public long q;

    @Deprecated
    public long r;

    @Deprecated
    public long s;

    @Deprecated
    public long t;

    @Deprecated
    public long u;
    public URL v;

    @Deprecated
    public String w;

    @Deprecated
    public long x;

    @Deprecated
    public long y;
    public long z;

    /* JADX INFO: compiled from: BaseHttpRequestInfo.java */
    public interface a {
        b a();
    }

    public b() {
        this.f8135a = false;
        this.f8136b = -1;
        this.f8138d = new af(this);
        this.g = System.currentTimeMillis();
        this.k = -1;
        this.m = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.F = false;
        this.G = -1;
        this.H = -1;
        this.I = "";
        this.f8134J = "";
        this.K = new JSONObject();
        this.L = false;
        this.O = "";
        this.P = "";
        this.S = false;
        this.T = false;
        this.U = -1;
        this.W = false;
        this.X = -1;
        this.Y = false;
        this.ab = false;
        this.ac = new AtomicBoolean(false);
    }

    public void a(af r3) {
        r3.f9434d = new WeakReference(this);
        this.f8138d = r3;
        long r0 = r3.aE.f.l;
        this.g = r0;
        this.f8139e = r0;
        this.f = r3.p(r3.aE.f.n);
        this.A = r3.aE.j.f;
    }

    @Override // com.bytedance.retrofit2.u
    public void a(long r1) {
        this.j = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void b(long r1) {
        this.n = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void c(long r1) {
        this.o = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void d(long r1) {
        this.p = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void e(long r1) {
        this.q = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void f(long r1) {
        this.r = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void g(long r1) {
        this.s = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void h(long r1) {
        this.t = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void i(long r1) {
        this.u = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void j(long r1) {
        this.B = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void a(String r1) {
        this.f8134J = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void k(long r1) {
        this.U = r1;
    }

    @Override // com.bytedance.retrofit2.u
    public void l(long r1) {
        this.X = r1;
    }

    static {
        ad = new AnonymousClass1();
    }

    public static void a(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        ad = r3;
        return;
    }

    public static JSONObject b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        String[] r5 = r4.split(",");
        JSONArray r0 = new JSONArray();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0.put(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        JSONObject r6 = new JSONObject();
        r6.put("hit", r0);     // Catch: JSONException -> L12
    L14:
        return r6;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static b a() {
        return ad.a();
    }

    @Override // com.bytedance.retrofit2.u
    public void a(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        b(r1);
        c(r1);
    }

    @Deprecated
    private void b(JSONObject r5) {
        r5.put("requestStart", this.g);
        r5.put("responseBack", this.h);
        r5.put("completeReadResponse", this.i);
        r5.put("appLevelRequestStart", this.f8139e);
        r5.put("beforeAllInterceptors", this.f);
        r5.put("requestEnd", this.j);
        r5.put("recycleCount", this.C);
        r5.put("timing_dns", this.n);
        r5.put("timing_connect", this.o);
        r5.put("timing_ssl", this.p);
        r5.put("timing_send", this.q);
        r5.put("timing_waiting", this.s);
        r5.put("timing_receive", this.t);
        r5.put("timing_total", this.u);
        r5.put("timing_isSocketReused", this.D);
        r5.put("timing_totalSendBytes", this.x);
        r5.put("timing_totalReceivedBytes", this.y);
        r5.put("timing_remoteIP", this.w);
        r5.put(MonitorConstants.REQUEST_LOG, this.f8134J);
        JSONObject r0 = this.K;
        if (r0 == null) goto L5;
        r5.put("req_info", r0);
    L5:
        r5.put("download", this.L);
        r5.put("addExecutorToAllInterceptors", this.f - this.f8139e);
        r5.put("addExecutorTime", this.f8139e);
        r5.put("allInterceptorsTime", this.f);
        r5.put("fallback", this.H);
        r5.put("requestHeader", this.M);
        r5.put("responseHeader", this.N);
        if (this.Q == false) goto L9;
        r5.put("hit_rules", 1);
        return;
    }

    @Deprecated
    private void c(JSONObject r21) {
        r21.put("use_deprecated_api", this.ab);
        T r2 = this.f8137c;
        if (r2 != null) goto L5;
    L8:
        af r3 = this.f8138d;
        if (r3 != null) goto L11;
        return;
    L11:
        r21.put("resp_comp", r3.ao);
        r21.put("req_comp", this.f8138d.ap);
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.f8138d.P.get("CallServerInterceptor"), Long.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L14;
        long r7 = r4.longValue();
    L15:
        r21.put("parse_time", r7);
        r21.put("priority_level", this.f8138d.am);
        r21.put("req_priority_level", this.f8138d.an);
        r21.put("thread_priority", Thread.currentThread().getPriority());
        int r15 = 0;
        if (this.f8138d.x <= 0) goto L29;
        r21.put("biz_before_time", this.f8138d.x - this.f8138d.v);
        r21.put("queue_time", this.f8138d.G - this.f8138d.x);
        r21.put("preprocess_time", this.f8138d.f9431J - this.f8138d.G);
        r21.put("realcall_time", this.f8138d.K - this.f8138d.f9431J);
        r21.put("is_async", 0);
        if (this.L == true) goto L20;
        r21.put("postprocess_time", this.f8138d.al - this.f8138d.K);
        r21.put("biz_total_time", this.f8138d.al - this.f8138d.v);
    L42:
        if (this.f8138d.aC.size() <= 0) goto L77;
        HashMap r5 = new HashMap();
        int r6 = 0;
    L45:
        if (r6 >= this.f8138d.aC.size()) goto L51;
        af.c r8 = (af.c) ZeusTransformUtils.preCheckCast(this.f8138d.aC.get(r6), af.c.class, "com.obric.aiagent.plugin");
        long r9 = r8.f9449c - r8.f9448b;
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(r5.get(r8.f9447a), Long.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L49;
        r5.put(r8.f9447a, Long.valueOf(r9));
    L50:
        r6 = r6 + 1;
        goto L45
    L49:
        r5.put(r8.f9447a, Long.valueOf(r10.longValue() + r9));
        goto L50
    L51:
        JSONObject r11 = new JSONObject();
        Iterator r12 = r5.keySet().iterator();
    L53:
        if (r12.hasNext() == false) goto L55;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin");
        r11.put(r13, r5.get(r13));
        goto L53
    L55:
        r21.put("request_interceptors_time", r11);
        HashMap r14 = new HashMap();
    L57:
        if (r15 >= this.f8138d.aD.size()) goto L63;
        af.c r16 = (af.c) ZeusTransformUtils.preCheckCast(this.f8138d.aD.get(r15), af.c.class, "com.obric.aiagent.plugin");
        long r17 = r16.f9449c - r16.f9448b;
        Long r18 = (Long) ZeusTransformUtils.preCheckCast(r14.get(r16.f9447a), Long.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L61;
        r14.put(r16.f9447a, Long.valueOf(r17));
    L62:
        r15 = r15 + 1;
        goto L57
    L61:
        r14.put(r16.f9447a, Long.valueOf(r18.longValue() + r17));
        goto L62
    L63:
        JSONObject r0 = new JSONObject();
        Iterator r19 = r14.keySet().iterator();
    L65:
        if (r19.hasNext() == false) goto L67;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.aiagent.plugin");
        r0.put(r20, r14.get(r20));
        goto L65
    L67:
        r21.put("response_interceptors_time", r0);
        return;
    L77:
        return;
    L20:
        if (this.f8138d.al > 0) goto L22;
        r21.put("postprocess_time", -1);
        r21.put("cb_time", -1);
        r21.put("executeCallEndTime", this.f8138d.K);
        r21.put("executeEndTime", this.f8138d.al);
    L26:
        r21.put("biz_total_time", this.f8138d.K - this.f8138d.v);
        goto L42
    L22:
        if (this.f8138d.aD.size() <= 0) goto L24;
        r21.put("postprocess_time", this.f8138d.al - ((af.c) ZeusTransformUtils.preCheckCast(this.f8138d.aD.get(0), af.c.class, "com.obric.aiagent.plugin")).f9448b);
    L24:
        r21.put("cb_time", this.f8138d.K - this.f8138d.al);
        goto L26
    L29:
        if (this.f8138d.w <= 0) goto L42;
        r21.put("biz_before_time", this.f8138d.w - this.f8138d.v);
        r21.put("queue_time", this.f8138d.G - this.f8138d.w);
        r21.put("preprocess_time", this.f8138d.f9431J - this.f8138d.G);
        r21.put("realcall_time", this.f8138d.K - this.f8138d.f9431J);
        r21.put("is_async", 1);
        if (this.L == true) goto L33;
        long r22 = SystemClock.uptimeMillis();
        r21.put("postprocess_time", this.f8138d.aj - this.f8138d.K);
        r21.put("cb_time", r22 - this.f8138d.aj);
        r21.put("biz_total_time", r22 - this.f8138d.v);
        goto L42
    L33:
        if (this.f8138d.aj > 0) goto L35;
        r21.put("postprocess_time", -1);
        r21.put("cb_time", -1);
        r21.put("enqueueCallbackStartTime", this.f8138d.aj);
        r21.put("executeCallEndTime", this.f8138d.K);
    L39:
        r21.put("biz_total_time", this.f8138d.K - this.f8138d.v);
        goto L42
    L35:
        if (this.f8138d.aD.size() <= 0) goto L37;
        r21.put("postprocess_time", this.f8138d.aj - ((af.c) ZeusTransformUtils.preCheckCast(this.f8138d.aD.get(0), af.c.class, "com.obric.aiagent.plugin")).f9448b);
    L37:
        r21.put("cb_time", this.f8138d.K - this.f8138d.aj);
        goto L39
    L14:
        r7 = 0;
        goto L15
    L5:
        if (r2.i <= 0) goto L7;
        r21.put("protect_timeout", this.f8137c.i);
        r21.put("connect_timeout", this.f8137c.f);
        r21.put(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, this.f8137c.h);
        r21.put("write_timeout", this.f8137c.g);
        goto L8
    L7:
        r21.put("connect_timeout", this.f8137c.f8189c);
        r21.put(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, this.f8137c.f8190d);
        r21.put("write_timeout", this.f8137c.f8191e);
        goto L8
    }
}

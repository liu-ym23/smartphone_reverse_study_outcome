package org.chromium;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.b.i;
import com.ttnet.org.chromium.net.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTCronetRequestFinishedInfoListener.java */
/* JADX INFO: loaded from: classes5.dex */
public class g extends w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f40539a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.b f40540b;

    static {
    }

    private static long a(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r3 == (-1)) goto L11;
        if (r5 > r3) goto L11;
        return r3 - r5;
    }

    public static /* synthetic */ void lambda$LzSiRTzD_MXagkmRvyyDLMEBhdY(Runnable r0) {
        a(r0);
    }

    public g(com.bytedance.frameworks.baselib.network.http.b r2) {
        super($$Lambda$g$LzSiRTzD_MXagkmRvyyDLMEBhdY.INSTANCE);
        this.f40540b = r2;
    }

    private static /* synthetic */ void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.run();
        return;
    }

    @Override // com.ttnet.org.chromium.net.w.a
    public void a(w r13) {
        if (this.f40540b == null) goto L27;
        if (r13 == null) goto L28;
        w.b r14 = r13.a();
        if (r14 != null) goto L9;
        return;
    L9:
        this.f40540b.l = a(r14.a());
        this.f40540b.f8138d.f(a(a(r14.c()), a(r14.b())));
        this.f40540b.f8138d.g(a(a(r14.e()), a(r14.d())));
        this.f40540b.f8138d.h(a(a(r14.g()), a(r14.f())));
        this.f40540b.f8138d.i(a(a(r14.i()), a(r14.h())));
        this.f40540b.f8138d.j(a(a(r14.k()), a(r14.j())));
        this.f40540b.f8138d.k(a(r14.o()));
        this.f40540b.f8138d.l(a(a(r14.m()), a(r14.l())));
        this.f40540b.f8138d.m(a(r14.p()));
        this.f40540b.f8138d.n(a(r14.w()));
        this.f40540b.f8138d.o(a(r14.x()));
        this.f40540b.f8138d.b(a(r14.y()));
        this.f40540b.f8138d.a(r14.E(), r14.H(), r14.I(), r14.F(), r14.G());
        this.f40540b.f8138d.b(r14.D());
        com.bytedance.frameworks.baselib.network.http.cronet.b.d r0 = new com.bytedance.frameworks.baselib.network.http.cronet.b.d();
        r0.f8216a = r14.C();
        this.f40540b.f8138d.a(r0);
        this.f40540b.w = r14.r() + ":" + r14.s();
        this.f40540b.D = r14.n();
        this.f40540b.x = a(r14.q());
        this.f40540b.y = a(r14.J());
        this.f40540b.E = a(r14.t());
        this.f40540b.M = r14.u();
        this.f40540b.N = r14.v();
        this.f40540b.Q = r14.A();
        this.f40540b.R = r14.B();
        if (f40539a == false) goto L12;
    L16:
        this.f40540b.f8138d.a(r14.z());
        if (TextUtils.isEmpty(this.f40540b.f8134J) == false) goto L25;
        a(this.f40540b.K);
    L25:
        this.f40540b.f8138d.ae.put("sentByteCount", Long.valueOf(this.f40540b.x));     // Catch: Throwable -> L21
        this.f40540b.f8138d.ae.put("receivedByteCount", Long.valueOf(this.f40540b.y));     // Catch: Throwable -> L21
        this.f40540b.K.put("retrofit", this.f40540b.f8138d.b());     // Catch: Throwable -> L21
    L23:
        this.f40540b.f8138d.aE();
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L12:
        if (this.f40540b.f8138d != null) goto L16;
        throw new AssertionError();
    L28:
        return;
    }

    private static void a(JSONObject r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (i.a() == null) goto L7;
        JSONObject r0 = i.a().c();
    L8:
        if (r0 == null) goto L16;
        r2.put("ab_test", r0);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r0 = null;
        goto L8
    }

    private static int a(Integer r0) {
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.intValue();
    }

    private static long a(Long r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.longValue();
    }

    private static long a(Date r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getTime();
    }
}

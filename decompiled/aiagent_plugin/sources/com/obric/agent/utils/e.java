package com.obric.agent.utils;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f16023b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f16024c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f16025d;

    /* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f16026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f16027b;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f16026a == r10.f16026a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f16027b, r10.f16027b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f16026a) * 31) + this.f16027b.hashCode();
        }

        public String toString() {
            return "Snapshot(collectedTimestamp=" + this.f16026a + ", infoJson=" + this.f16027b + ')';
        }

        public a(long r2, String r4) {
            d.h.b.o.e(r4, "infoJson");
            this.f16026a = r2;
            this.f16027b = r4;
        }

        public final String a() {
            return this.f16027b;
        }

        public final boolean a(long r3) {
            long r4 = r3 - this.f16026a;
            if (r4 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r4 >= 300000) goto L7;
            return true;
        }
    }

    /* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
    @d.c.b.a.f(b = "ClientPhoneEnvInfo.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.utils.ClientPhoneEnvInfo$prefetch$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f16029b;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            b r4 = new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f16029b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f16028a != 0) goto L21;
            d.o.a(r5);
            am r4 = (am) ZeusTransformUtils.preCheckCast(this.f16029b, am.class, "com.obric.aiagent.plugin");
            d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L7
            String r7 = d.f16020a.a().toString();     // Catch: Throwable -> L7
            d.h.b.o.c(r7, "toString(...)");     // Catch: Throwable -> L7
            Object r8 = d.n.f(new a(System.currentTimeMillis(), r7));     // Catch: Throwable -> L7
        L10:
            if (d.n.a(r8) == false) goto L12;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
            e r1 = e.f16022a;     // Catch: Throwable -> L17
            e.a(r0);     // Catch: Throwable -> L17
        L12:
            Throwable r9 = d.n.c(r8);     // Catch: Throwable -> L17
            if (r9 == null) goto L15;
            ILogDepend.Companion.w("ClientPhoneEnvInfo", "prefetch failed", r9);     // Catch: Throwable -> L17
        L15:
            e.c().set(false);
            return d.x.f38692a;
        L7:
            th = move-exception;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L17
            r8 = d.n.f(d.o.a(th));     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            e.c().set(false);
            throw th;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private e() {
    }

    public static final /* synthetic */ void a(a r0) {
        f16025d = r0;
    }

    public static final /* synthetic */ AtomicBoolean c() {
        return f16024c;
    }

    static {
        f16022a = new e();
        f16023b = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f16024c = new AtomicBoolean(false);
    }

    public final void a() {
        if (f16024c.compareAndSet(false, true) == true) goto L6;
        ILogDepend.Companion.i("ClientPhoneEnvInfo", "prefetch skipped: fetching");
        return;
    L6:
        kotlinx.coroutines.i.a(f16023b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final JSONObject b() {
        long r1 = System.currentTimeMillis();
        a r3 = f16025d;
        Object r4 = null;
        if (r3 != null) goto L5;
    L23:
        return null;
    L5:
        if (r3.a(r1) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L23;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L12
        e r6 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Object r7 = d.n.f(new JSONObject(r3.a()));     // Catch: Throwable -> L12
    L14:
        Throwable r5 = d.n.c(r7);
        if (r5 == null) goto L18;
        ILogDepend.Companion.w("ClientPhoneEnvInfo", "parse cached client info failed", r5);
    L18:
        if (d.n.b(r7) == true) goto L22;
        r4 = r7;
    L22:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin");
    L12:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L14
    }
}

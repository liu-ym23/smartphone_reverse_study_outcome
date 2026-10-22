package com.obric.aiagent.executionengine.scheduler.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: AtomicActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f18111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f18112b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, f> f18113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static kotlinx.coroutines.f.a f18114d;

    /* JADX INFO: compiled from: AtomicActionExecutor.kt */
    @d.c.b.a.f(b = "AtomicActionExecutor.kt", c = {36}, d = "execute", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicActionExecutor")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f18118d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18119e;

        a(g r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18118d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18117c = r3;
            this.f18119e |= Integer.MIN_VALUE;
            return this.f18118d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ Thread lambda$ZKdJGGkB9uA67cnZcjksS4cEpAA(Runnable r0) {
        return a(r0);
    }

    private g() {
    }

    static {
        f18111a = new g();
        TAG = "AtomicActionExecutor";
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$g$ZKdJGGkB9uA67cnZcjksS4cEpAA.INSTANCE);
        o.c(r0, "newSingleThreadExecutor(...)");
        f18112b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
        f18113c = new ConcurrentHashMap();
        f18114d = kotlinx.coroutines.f.c.a(false, 1, null);
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "execute-consumer");
    }

    public final kotlinx.coroutines.f.a a() {
        return f18114d;
    }

    public final Object a(e r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f18119e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18119e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f18117c;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f18119e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        f r10 = (f) ZeusTransformUtils.preCheckCast(r0.f18116b, f.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.f18115a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L22:
        ((Map) ZeusTransformUtils.preCheckCast(f18113c, Map.class, "com.obric.aiagent.plugin")).put(r11, r10);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        String r12 = r6.d();
        if (f18113c.containsKey(r12) == false) goto L17;
        f r3 = f18113c.get(r12);
        o.a(r3);
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
    L18:
        r0.f18115a = r12;
        r0.f18116b = r4;
        r0.f18119e = 1;
        if (r4.a(r6, r0) != r9) goto L21;
        return r9;
    L21:
        r11 = r12;
        r10 = r4;
        goto L22
    L17:
        r4 = new f(r12);
    L7:
        r0 = new a(this, r8);
        goto L8
    }

    public final am b() {
        return f18112b;
    }
}

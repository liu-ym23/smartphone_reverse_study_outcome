package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LocationMonitorAnalyzer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f17119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<l> f17120b = null;

    public static /* synthetic */ float lambda$Sg_zh4FCyOA4JadstPCE2daoxkg(l r0) {
        return a(r0);
    }

    public static /* synthetic */ float lambda$jCZNY2zrbjIPbjzM90Xe8vDkHvE(l r0) {
        return b(r0);
    }

    private g() {
    }

    static {
        f17119a = new g();
        f17120b = m.a();
    }

    public final List<i> a(ae r21) {
        d.h.b.o.e(r21, "window");
        List<n> r0 = r21.g();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.aiagent.plugin");
        r4.add(new i(r6.a() - r21.c().a(), r6.b(), r6.c(), null, k.b(r21.b(), r6), k.c(r21.b(), r6), r6.f()));
        goto L4
    L6:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r7 = 0;
        Iterator r8 = r1.iterator();
    L8:
        if (r8.hasNext() == false) goto L18;
        Object r9 = r8.next();
        int r10 = r7 + 1;
        if (r7 >= 0) goto L12;
        d.a.p.c();
    L12:
        i r11 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (r7 == 0) goto L16;
        n r12 = (n) ZeusTransformUtils.preCheckCast(r0.get(r7 - 1), n.class, "com.obric.aiagent.plugin");
        n r13 = (n) ZeusTransformUtils.preCheckCast(r0.get(r7), n.class, "com.obric.aiagent.plugin");
        r11 = i.a(r11, 0, 0.0f, 0.0f, Float.valueOf(k.a(r12.d(), r12.e(), r13.d(), r13.e())), null, null, null, IdlErrors.E_RejectInferDeviceOverheat, null);
    L16:
        r5.add(r11);
        r7 = r10;
        goto L8
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    }

    public final d.m<ab, t> b(ae r7) {
        d.h.b.o.e(r7, "window");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(f17120b, Iterable.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(d.a.p.a(r6, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        l r4 = (l) ZeusTransformUtils.preCheckCast(r8.next(), l.class, "com.obric.aiagent.plugin");
        d.m r5 = d.s.a(r4.a(), r4.a(r7));
        r2.put(r5.a(), r5.b());
        goto L4
    L6:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(f17120b, Iterable.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(d.a.p.a(r9, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        l r3 = (l) ZeusTransformUtils.preCheckCast(r10.next(), l.class, "com.obric.aiagent.plugin");
        Float r11 = (Float) ZeusTransformUtils.preCheckCast(r2.get(r3.a()), Float.class, "com.obric.aiagent.plugin");
        d.m r12 = d.s.a(r3.c(), r3.a(r11, r7));
        r0.put(r12.a(), r12.b());
        goto L8
    L11:
        return d.s.a(new ab(r2), new t(r0));
    }

    private static final float a(l r2) {
        l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return r3.b();
    }

    public final Float a(t r3) {
        d.h.b.o.e(r3, "metrics");
        return a(r3, f17120b, $$Lambda$g$Sg_zh4FCyOA4JadstPCE2daoxkg.INSTANCE);
    }

    private static final float b(l r2) {
        l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return r3.d();
    }

    public final Float b(t r3) {
        d.h.b.o.e(r3, "metrics");
        return a(r3, f17120b, $$Lambda$g$jCZNY2zrbjIPbjzM90Xe8vDkHvE.INSTANCE);
    }

    private final Float a(t r10, List<? extends l> r11, d.h.a.b<? super l, Float> r12) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        float r1 = 0.0f;
        float r2 = 0.0f;
    L3:
        Object r4 = null;
        boolean r5 = true;
        if (r14.hasNext() == false) goto L17;
        l r3 = (l) ZeusTransformUtils.preCheckCast(r14.next(), l.class, "com.obric.aiagent.plugin");
        Object r7 = r13.invoke(r3);
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).floatValue() > 0.0f) goto L9;
        r5 = false;
    L9:
        if (r5 == false) goto L11;
        r4 = r7;
    L11:
        Float r6 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L3;
        float r8 = r6.floatValue();
        Float r15 = (Float) ZeusTransformUtils.preCheckCast(r10.a().get(r3.c()), Float.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L3;
        r1 = r1 + r8;
        r2 = r2 + (r15.floatValue() * r8);
        goto L3
    L17:
        if (r1 == 0.0f) goto L20;
        r5 = false;
    L20:
        if (r5 == false) goto L23;
        return null;
    L23:
        return Float.valueOf(r2 / r1);
    }
}

package com.obric.autogui.agents.a.j;

import com.obric.autogui.agents.a.f.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectResultRules.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26523a = null;

    static {
        f26523a = new a();
    }

    private a() {
    }

    public final com.obric.autogui.agents.a.f.b a(List<com.obric.autogui.agents.a.f.b> r9) {
        List<com.obric.autogui.agents.a.f.b> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "results");
        if (r10.isEmpty() == true) goto L5;
        com.obric.autogui.agents.a.f.b r0 = a(r10, k.f26443b);
        if (r0 == null) goto L9;
        return r0;
    L9:
        com.obric.autogui.agents.a.f.b r1 = a(r10, k.f26445d);
        if (r1 == null) goto L12;
        return r1;
    L12:
        com.obric.autogui.agents.a.f.b r2 = a(r10, k.f26442a);
        if (r2 == null) goto L15;
        return r2;
    L15:
        com.obric.autogui.agents.a.f.b r3 = a(r10, k.f26444c);
        if (r3 == null) goto L18;
        return r3;
    L18:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L21;
    L23:
        Iterator r6 = r4.iterator();
    L25:
        if (r6.hasNext() == false) goto L22;
        if (((com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin")).b() != k.f26446e) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == true) goto L25;
    L31:
        if (r5 == true) goto L33;
        com.obric.autogui.agents.a.f.b r8 = a(r10, k.f);
        if (r8 == null) goto L37;
        return r8;
    L37:
        return com.obric.autogui.agents.a.f.b.a((com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(p.k(r10), com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin"), null, k.f, "detectors returned no conclusive evidence", null, null, 25, null);
    L33:
        return (com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(p.k(r10), com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin");
    L29:
        r7 = false;
    L22:
        r5 = true;
        goto L31
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
    L5:
        return a();
    }

    public final com.obric.autogui.agents.a.f.b a(com.obric.autogui.agents.a.f.b r10) {
        o.e(r10, "aggregated");
        if (r10.b() == k.f26444c) goto L5;
        return r10;
    L5:
        return com.obric.autogui.agents.a.f.b.a(r10, null, k.f26445d, "detector remained pending after bounded checks", null, null, 25, null);
    }

    private final com.obric.autogui.agents.a.f.b a(List<com.obric.autogui.agents.a.f.b> r3, k r4) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r5 = r2.next();
        if (((com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin")).b() != r4) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L13:
        return (com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin");
    L8:
        r1 = false;
        goto L9
    L11:
        r5 = null;
        goto L13
    }

    private final com.obric.autogui.agents.a.f.b a() {
        return new com.obric.autogui.agents.a.f.b(com.obric.autogui.agents.a.f.c.f26402a, k.f, "no detector result", null, null, 24, null);
    }
}

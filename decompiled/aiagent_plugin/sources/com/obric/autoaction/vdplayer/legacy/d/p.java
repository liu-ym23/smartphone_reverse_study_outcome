package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: VDPlayerAgentActionReducer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f25931a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f25932b = null;

    public static /* synthetic */ AtomicLong lambda$kG_NWGIj26IeVK3L7oWqusC7mYI() {
        return b();
    }

    private p() {
    }

    static {
        f25931a = new p();
        f25932b = d.g.a($$Lambda$p$kG_NWGIj26IeVK3L7oWqusC7mYI.INSTANCE);
    }

    private final AtomicLong a() {
        return (AtomicLong) ZeusTransformUtils.preCheckCast(f25932b.b(), AtomicLong.class, "com.obric.aiagent.plugin");
    }

    private static final AtomicLong b() {
        return new AtomicLong(0);
    }

    public final s a(s r17, com.obric.autogui.vdplayer.api.a.a r18) {
        d.h.b.o.e(r17, "<this>");
        d.h.b.o.e(r18, "action");
        h r6 = a(r17.c(), r18);
        n r4 = a(r17.a(), r18);
        k r5 = a(r17.b(), r18);
        if (ZeusTransformUtils.instanceOf(r18, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L5;
        o r2 = o.f25928c;
    L6:
        o r9 = r2;
        if (ZeusTransformUtils.instanceOf(r18, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L14;
        String r11 = ((com.obric.autogui.vdplayer.api.a.a.f) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.vdplayer.api.a.a.f.class, "com.obric.aiagent.plugin")).a();
        List<Float> r12 = ((com.obric.autogui.vdplayer.api.a.a.f) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.vdplayer.api.a.a.f.class, "com.obric.aiagent.plugin")).d();
        List<Float> r13 = ((com.obric.autogui.vdplayer.api.a.a.f) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.vdplayer.api.a.a.f.class, "com.obric.aiagent.plugin")).c();
        if (com.obric.autogui.common.a.d.f28974a.Z() == false) goto L11;
        long r0 = a().incrementAndGet();
    L12:
        f r10 = new f(r11, r12, r13, r0);
    L19:
        return s.a(r17, r4, r5, r6, null, false, r9, r10, 24, null);
    L11:
        r0 = 0;
        goto L12
    L14:
        if (ZeusTransformUtils.instanceOf(r18, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L16;
        f r1 = null;
    L17:
        r10 = r1;
        goto L19
    L16:
        r1 = r17.f();
        goto L17
    L5:
        r2 = o.f25926a;
        goto L6
    }

    private final n a(n r1, com.obric.autogui.vdplayer.api.a.a r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.d.class) == false) goto L6;
        return (n) ZeusTransformUtils.preCheckCast(n.a.f25924a, n.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L9;
        return (n) ZeusTransformUtils.preCheckCast(n.b.f25925a, n.class, "com.obric.aiagent.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L12;
        return (n) ZeusTransformUtils.preCheckCast(n.b.f25925a, n.class, "com.obric.aiagent.plugin");
    L12:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == false) goto L15;
        return (n) ZeusTransformUtils.preCheckCast(n.b.f25925a, n.class, "com.obric.aiagent.plugin");
    L15:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.b.class) == false) goto L18;
        return (n) ZeusTransformUtils.preCheckCast(n.b.f25925a, n.class, "com.obric.aiagent.plugin");
    L18:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L22;
        return (n) ZeusTransformUtils.preCheckCast(n.b.f25925a, n.class, "com.obric.aiagent.plugin");
    L22:
        throw new d.k();
    }

    private final k a(k r11, com.obric.autogui.vdplayer.api.a.a r12) {
        return k.a(r11, a(r11.a(), r12), a(r11.b(), r12), a(r11.c(), r12), null, null, false, 56, null);
    }

    private final j a(j r1, com.obric.autogui.vdplayer.api.a.a r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.d.class) == false) goto L6;
        return j.f25906c;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L9;
        return j.f25906c;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == false) goto L12;
        return j.f25904a;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.b.class) == false) goto L15;
        return j.f25904a;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L18;
        return j.f25905b;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L24;
        if (r1 == j.f25906c) goto L22;
        return r1;
    L22:
        return j.f25905b;
    L24:
        throw new d.k();
    }

    private final i a(i r11, com.obric.autogui.vdplayer.api.a.a r12) {
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L6;
        return i.a(r11, l.f25914a, null, null, null, null, 8, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == false) goto L9;
        return r11.a(l.f25918e, ((com.obric.autogui.vdplayer.api.a.a.C0870a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.C0870a.class, "com.obric.aiagent.plugin")).b(), null, ((com.obric.autogui.vdplayer.api.a.a.C0870a) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.C0870a.class, "com.obric.aiagent.plugin")).d(), null);
    L9:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.vdplayer.api.a.a.b.class) == false) goto L37;
        l r2 = l.f;
        String r3 = ((com.obric.autogui.vdplayer.api.a.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.b.class, "com.obric.aiagent.plugin")).a();
        List<com.obric.autogui.vdplayer.api.a.a.b.C0871a> r10 = ((com.obric.autogui.vdplayer.api.a.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.b.class, "com.obric.aiagent.plugin")).c();
        if (r10 == null) goto L17;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r4.add(((com.obric.autogui.vdplayer.api.a.a.b.C0871a) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.autogui.vdplayer.api.a.a.b.C0871a.class, "com.obric.aiagent.plugin")).a());
        goto L14
    L16:
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L18:
        List<com.obric.autogui.vdplayer.api.a.a.b.C0871a> r15 = ((com.obric.autogui.vdplayer.api.a.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.b.class, "com.obric.aiagent.plugin")).c();
        if (r15 == null) goto L34;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r7 = 0;
        Iterator r17 = r16.iterator();
    L22:
        if (r17.hasNext() == false) goto L33;
        Object r8 = r17.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L26;
        d.a.p.c();
    L26:
        String r18 = ((com.obric.autogui.vdplayer.api.a.a.b.C0871a) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.vdplayer.api.a.a.b.C0871a.class, "com.obric.aiagent.plugin")).b();
        if (r18 == null) goto L29;
        d.m r19 = d.s.a(Integer.valueOf(r7), r18);
    L30:
        if (r19 == null) goto L32;
        r6.add(r19);
    L32:
        r7 = r9;
        goto L22
    L29:
        r19 = null;
        goto L30
    L33:
        Map<Integer, String> r20 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L62:
        return r11.a(r2, r3, r5, ((com.obric.autogui.vdplayer.api.a.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.b.class, "com.obric.aiagent.plugin")).b(), r20);
    L34:
        r20 = null;
        goto L62
    L17:
        r5 = null;
        goto L18
    L37:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.vdplayer.api.a.a.d.class) == false) goto L48;
        if (((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin")).a() == false) goto L43;
        l r110 = l.f25915b;
    L63:
        return r11.a(r110, ((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin")).c(), null, ((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin")).e(), null);
    L43:
        if (((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin")).b() == false) goto L45;
        r110 = l.f25917d;
        goto L63
    L45:
        r110 = l.f25916c;
        goto L63
    L48:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L51;
        return r11;
    L51:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L55;
        return i.a(r11, l.g, null, null, null, null, 8, null);
    L55:
        throw new d.k();
    }

    private final h a(h r7, com.obric.autogui.vdplayer.api.a.a r8) {
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.vdplayer.api.a.a.b.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.vdplayer.api.a.a.d.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.vdplayer.api.a.a.e.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L15;
        return h.a(r7, true, null, null, 6, null);
    L15:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L18;
        return r7;
    L18:
        throw new d.k();
    L20:
        return h.a(r7, false, null, null, 6, null);
    }

    private final List<a> a(List<a> r4, com.obric.autogui.vdplayer.api.a.a r5) {
        List<a> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.a.C0870a.class) == false) goto L6;
        return c.f25876a.a(c.f25876a.a(c.f25876a.c(), ((com.obric.autogui.vdplayer.api.a.a.C0870a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.api.a.a.C0870a.class, "com.obric.aiagent.plugin")).a()), ((com.obric.autogui.vdplayer.api.a.a.C0870a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.api.a.a.C0870a.class, "com.obric.aiagent.plugin")).c());
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.a.b.class) == false) goto L9;
        return c.f25876a.d();
    L9:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.a.d.class) == false) goto L15;
        if (((com.obric.autogui.vdplayer.api.a.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.api.a.a.d.class, "com.obric.aiagent.plugin")).a() == false) goto L27;
        return c.f25876a.e();
    L27:
        return c.f25876a.f();
    L15:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.a.f.class) == false) goto L18;
        return c.f25876a.a(c.f25876a.a(), ((com.obric.autogui.vdplayer.api.a.a.f) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.api.a.a.f.class, "com.obric.aiagent.plugin")).b());
    L18:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.a.c.class) == false) goto L21;
        return r3;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.a.e.class) == false) goto L24;
        return r3;
    L24:
        throw new d.k();
    }
}

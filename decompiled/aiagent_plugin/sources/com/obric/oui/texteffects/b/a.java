package com.obric.oui.texteffects.b;

import com.obric.oui.texteffects.a.c;
import com.obric.oui.texteffects.a.d;
import com.obric.oui.texteffects.a.e;
import com.obric.oui.texteffects.a.f;
import com.obric.oui.texteffects.a.g;
import com.obric.oui.texteffects.a.h;
import com.obric.oui.texteffects.a.i;
import com.obric.oui.texteffects.a.j;
import com.obric.oui.texteffects.a.k;
import com.obric.oui.texteffects.a.l;
import com.obric.oui.texteffects.a.n;
import com.obric.oui.texteffects.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: DimPointEffectSpecFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c.b f36430b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c.b f36431c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c.b f36432d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c.a f36433e = null;
    private static final c.a f = null;
    private static final c.a g = null;

    private a() {
    }

    static {
        f36429a = new a();
        f36430b = new c.b(0.33f, 0.0f, 0.67f, 1.0f);
        f36431c = new c.b(0.42f, 0.0f, 0.58f, 1.0f);
        f36432d = new c.b(0.26f, 0.0f, 0.6f, 0.2f);
        f36433e = new c.a(0, 0.0f, 0.0f, 1, null);
        f = new c.a(0, 0.4f, 0.0f, 1, null);
        g = new c.a(0, 0.3f, 0.0f, 1, null);
    }

    public final n a() {
        j r7 = (j) ZeusTransformUtils.preCheckCast(j.b.f36408a, j.class, "com.obric.aiagent.plugin");
        o r0 = o.f36425a;
        Float r4 = Float.valueOf(0.0f);
        return new n("oui.dim_point.pending", 0, 1500, r7, p.a(new f("pending_breath", 0, 1500, p.b(new d.b[]{a(this, "base_text", o.f36425a, null, 4, null), b("gradient_overlay", r0, p.a(a(this, new m[]{s.a(0L, r4), s.a(750L, Float.valueOf(0.8f)), s.a(1500L, r4)}, null, 2, null)))}))), 2, null);
    }

    public final n b() {
        return new n("oui.dim_point.prompt_pending_exit", 0, 150, null, p.a(new f("prompt_pending_exit", 0, 150, p.a(a("prompt_text_exit", o.f36425a, p.a(d()))))), 10, null);
    }

    public final n c() {
        return new n("oui.dim_point.prompt_text_switch", 0, 150, null, p.a(new f("prompt_text_switch", 0, 150, p.b(new d.b[]{a("old_prompt_exit", o.f36426b, p.a(d())), a("new_prompt_enter", o.f36427c, p.a(e()))}))), 10, null);
    }

    public final n a(boolean r27) {
        long r17 = Math.max(1250, 1450);
        o r12 = o.f36425a;
        Float r15 = Float.valueOf(0.03f);
        Float r5 = Float.valueOf(0.0f);
        m[] r0 = {s.a(150L, r15), s.a(1250L, r5)};
        Float r1 = Float.valueOf(-0.5f);
        Float r10 = Float.valueOf(1.0f);
        l[] r13 = {d(this, r0, null, 2, null), a(this, new m[]{s.a(0L, r1), s.a(1250L, r10)}, com.obric.oui.texteffects.a.b.f36363a, null, 4, null)};
        o r14 = o.f36425a;
        Float r2 = Float.valueOf(0.8f);
        List r7 = p.c(new d[]{(d) ZeusTransformUtils.preCheckCast(a("generate_scan_base_text", r12, p.b(r13)), d.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(b("generate_scan_text", r14, p.b(new l[]{a(this, new m[]{s.a(0L, r2), s.a(750L, r2), s.a(1450L, r5)}, null, 2, null), d(this, new m[]{s.a(150L, r15), s.a(1400L, r5)}, null, 2, null), a(this, new m[]{s.a(0L, r1), s.a(1250L, r10)}, com.obric.oui.texteffects.a.b.f36363a, null, 4, null)})), d.class, "com.obric.aiagent.plugin")});
        if (r27 == false) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).add(a(0, 1250, -0.4f, 1.0f));
    L6:
        return new n("oui.dim_point.generate", 0, r17, null, p.c(new f[]{new f("generate_enter", 0, r17, r7)}), 10, null);
    }

    public static /* synthetic */ n a(a r0, boolean r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0.0f;
    L9:
        return r0.a(r1, r2);
    }

    public final n a(boolean r36, float r37) {
        long r21 = Math.max(Math.max(1250, 1450), Math.max(600, Math.max(600, 600)));
        o r5 = o.f36426b;
        Float r12 = Float.valueOf(0.0f);
        Float r9 = Float.valueOf(16.0f);
        m[] r0 = {s.a(0L, r12), s.a(600L, r9)};
        Float r11 = Float.valueOf(3.0f);
        m[] r1 = {s.a(0L, r12), s.a(600L, r11)};
        Float r10 = Float.valueOf(-0.4f);
        Float r4 = Float.valueOf(1.0f);
        List r15 = p.c(new d[]{(d) ZeusTransformUtils.preCheckCast(a("old_text_exit", r5, p.b(new l[]{b(this, r0, null, 2, null), c(this, r1, null, 2, null), a(this, new m[]{s.a(0L, r10), s.a(50L, r10), s.a(600L, r4)}, com.obric.oui.texteffects.a.b.f36364b, null, 4, null)})), d.class, "com.obric.aiagent.plugin")});
        Float r6 = Float.valueOf(0.8f);
        if (r37 <= 0.001f) goto L5;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin");
        o r2 = o.f36426b;
        m[] r7 = {s.a(0L, Float.valueOf(d.l.n.a(r37, 0.0f, 0.8f))), s.a(600L, Float.valueOf(d.l.n.a(r37, 0.0f, 0.8f)))};
        m[] r8 = {s.a(0L, r12), s.a(600L, r9)};
        m[] r13 = {s.a(0L, r12), s.a(600L, r11)};
        Float r14 = r4;
        m[] r16 = {s.a(0L, r10), s.a(600L, r14)};
        Float r33 = r6;
        int r17 = 2;
        int r18 = 3;
        r3.add(b("old_gradient_exit", r2, p.b(new l[]{a(this, r7, null, 2, null), b(this, r8, null, 2, null), c(this, r13, null, 2, null), a(this, r16, com.obric.oui.texteffects.a.b.f36364b, null, 4, null)})));
    L6:
        d[] r19 = new d[r17];
        o r110 = o.f36427c;
        l[] r20 = new l[r17];
        m[] r22 = new m[r17];
        r22[0] = s.a(150L, Float.valueOf(0.03f));
        r22[1] = s.a(1400L, r12);
        r20[0] = d(this, r22, null, r17, null);
        m[] r23 = new m[r17];
        r23[0] = s.a(0L, Float.valueOf(-0.5f));
        r23[1] = s.a(1250L, r14);
        r20[1] = a(this, r23, com.obric.oui.texteffects.a.b.f36363a, null, 4, null);
        r19[0] = (d) ZeusTransformUtils.preCheckCast(a("new_text_enter_base", r110, p.b(r20)), d.class, "com.obric.aiagent.plugin");
        o r111 = o.f36427c;
        l[] r24 = new l[r18];
        m[] r25 = new m[r18];
        Float r26 = r33;
        r25[0] = s.a(0L, r26);
        r25[1] = s.a(750L, r26);
        r25[r17] = s.a(1450L, r12);
        r24[0] = a(this, r25, null, r17, null);
        m[] r27 = new m[r17];
        r27[0] = s.a(150L, Float.valueOf(0.03f));
        r27[1] = s.a(1400L, r12);
        r24[1] = d(this, r27, null, r17, null);
        m[] r28 = new m[r17];
        r28[0] = s.a(0L, Float.valueOf(-0.5f));
        r28[1] = s.a(1250L, r14);
        r24[r17] = a(this, r28, com.obric.oui.texteffects.a.b.f36363a, null, 4, null);
        r19[1] = (d) ZeusTransformUtils.preCheckCast(b("new_text_enter", r111, p.b(r24)), d.class, "com.obric.aiagent.plugin");
        List r29 = p.c(r19);
        if (r36 == false) goto L11;
        ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).add(a(0, 600));
        ((Collection) ZeusTransformUtils.preCheckCast(r29, Collection.class, "com.obric.aiagent.plugin")).add(a(this, 0, 1250, 0.0f, 0.0f, 12, null));
    L11:
        return new n("oui.dim_point.rewrite", 0, r21, null, p.c(new f[]{new f("rewrite", 0, r21, p.c((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, r8), (Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.aiagent.plugin")))}), 10, null);
    L5:
        r33 = r6;
        r17 = 2;
        r14 = r4;
        r18 = 3;
        goto L6
    }

    static /* synthetic */ d.b a(a r1, String r2, o r3, List r4, int r5, Object r6) {
        List<l> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = p.b();
    L6:
        return r1.a(r2, r3, r7);
    }

    private final d.b a(String r10, o r11, List<l> r12) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        return new d.b(r10, r11, (h) ZeusTransformUtils.preCheckCast(h.b.f36404a, h.class, "com.obric.aiagent.plugin"), null, r6, 8, null);
    }

    private final d.b b(String r8, o r9, List<l> r10) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        return new d.b(r8, r9, (h) ZeusTransformUtils.preCheckCast(new h.a(b.f36434a.a(), b.f36434a.b()), h.class, "com.obric.aiagent.plugin"), com.obric.oui.texteffects.a.a.o, r6);
    }

    static /* synthetic */ d.a a(a r7, long r8, long r10, float r12, float r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r12 = -0.7f;
    L5:
        float r5 = r12;
        if ((r14 & 8) == 0) goto L9;
        r13 = 1.0f;
    L9:
        return r7.a(r8, r10, r5, r13);
    }

    private final d.a a(long r11, long r13, float r15, float r16) {
        return a("enter_indicator", "enterScanIndicator", com.obric.oui.texteffects.a.b.f36363a, r11, r13, r15, r16);
    }

    private final d.a a(long r11, long r13) {
        return a("exit_indicator", "exitScanIndicator", com.obric.oui.texteffects.a.b.f36364b, r11, r13, -0.7f, 1.0f);
    }

    private final d.a a(String r17, String r18, com.obric.oui.texteffects.a.b r19, long r20, long r22, float r24, float r25) {
        g.f r2 = new g.f(r24);
        g.f r3 = new g.f(r25);
        List r4 = p.a();
        if (r20 <= 0) goto L5;
        r4.add(new i(0, (g) ZeusTransformUtils.preCheckCast(new g.b(0.0f), g.class, "com.obric.aiagent.plugin")));
        r4.add(new i(r20, (g) ZeusTransformUtils.preCheckCast(new g.b(0.0f), g.class, "com.obric.aiagent.plugin")));
    L5:
        r4.add(new i(r20, (g) ZeusTransformUtils.preCheckCast(new g.b(1.0f), g.class, "com.obric.aiagent.plugin")));
        long r11 = r20 + r22;
        r4.add(new i(r11 - 1, (g) ZeusTransformUtils.preCheckCast(new g.b(0.0f), g.class, "com.obric.aiagent.plugin")));
        List r5 = p.a(r4);
        List r8 = p.a();
        if (r20 <= 0) goto L8;
        r8.add(new i(0, (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")));
    L8:
        r8.add(new i(r20, (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")));
        r8.add(new i(r11, (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")));
        List r0 = p.a(r8);
        return new d.a(r17, r18, new k(r19), p.b(new l[]{new l(e.g, r5, (c) ZeusTransformUtils.preCheckCast(c.C0998c.f36375a, c.class, "com.obric.aiagent.plugin"), null, 8, null), new l(e.f36387c, r0, (c) ZeusTransformUtils.preCheckCast(f36431c, c.class, "com.obric.aiagent.plugin"), null, 8, null)}));
    }

    static /* synthetic */ l a(a r0, m[] r1, c r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = (c) ZeusTransformUtils.preCheckCast(f36431c, c.class, "com.obric.aiagent.plugin");
    L6:
        return r0.a(r1, r2);
    }

    private final l a(m<Long, Float>[] r4, c r5) {
        return a(e.f36385a, r5, (m[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), m[].class, "com.obric.aiagent.plugin"));
    }

    private final l d() {
        return a(e.f36385a, (c) ZeusTransformUtils.preCheckCast(f36432d, c.class, "com.obric.aiagent.plugin"), new m[]{s.a(0L, Float.valueOf(1.0f)), s.a(150L, Float.valueOf(0.0f))});
    }

    private final l e() {
        return a(e.f36385a, (c) ZeusTransformUtils.preCheckCast(f36432d, c.class, "com.obric.aiagent.plugin"), new m[]{s.a(0L, Float.valueOf(0.0f)), s.a(150L, Float.valueOf(1.0f))});
    }

    static /* synthetic */ l b(a r0, m[] r1, c r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = (c) ZeusTransformUtils.preCheckCast(f36431c, c.class, "com.obric.aiagent.plugin");
    L6:
        return r0.b(r1, r2);
    }

    private final l b(m<Long, Float>[] r4, c r5) {
        return b(e.f36386b, r5, (m[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), m[].class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ l c(a r0, m[] r1, c r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = (c) ZeusTransformUtils.preCheckCast(f36431c, c.class, "com.obric.aiagent.plugin");
    L6:
        return r0.c(r1, r2);
    }

    private final l c(m<Long, Float>[] r4, c r5) {
        return b(e.f36387c, r5, (m[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), m[].class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ l d(a r0, m[] r1, c r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = (c) ZeusTransformUtils.preCheckCast(f36431c, c.class, "com.obric.aiagent.plugin");
    L6:
        return r0.d(r1, r2);
    }

    private final l d(m<Long, Float>[] r4, c r5) {
        return a(e.f36389e, r5, (m[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), m[].class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ l a(a r0, m[] r1, com.obric.oui.texteffects.a.b r2, com.obric.oui.texteffects.a.b r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r2;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final l a(m<Long, Float>[] r11, com.obric.oui.texteffects.a.b r12, com.obric.oui.texteffects.a.b r13) {
        e r10 = e.f;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r11.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r11.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        m<Long, Float> r4 = r11[r3];
        r0.add(new i(((Number) ZeusTransformUtils.preCheckCast(r4.a(), Number.class, "com.obric.aiagent.plugin")).longValue(), (g) ZeusTransformUtils.preCheckCast(new g.b(((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()), g.class, "com.obric.aiagent.plugin")));
        r3 = r3 + 1;
        goto L3
    L6:
        return new l(r10, (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.preCheckCast(f36431c, c.class, "com.obric.aiagent.plugin"), (com.obric.oui.texteffects.a.m) ZeusTransformUtils.preCheckCast(new com.obric.oui.texteffects.a.m.b(r12, r13, 0.3f, 16.0f), com.obric.oui.texteffects.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final l a(e r10, c r11, m<Long, Float>... r12) {
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r12.length), Collection.class, "com.obric.aiagent.plugin");
        int r0 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        m<Long, Float> r3 = r12[r2];
        r9.add(new i(((Number) ZeusTransformUtils.preCheckCast(r3.a(), Number.class, "com.obric.aiagent.plugin")).longValue(), (g) ZeusTransformUtils.preCheckCast(new g.b(((Number) ZeusTransformUtils.preCheckCast(r3.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()), g.class, "com.obric.aiagent.plugin")));
        r2 = r2 + 1;
        goto L3
    L6:
        return new l(r10, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), r11, null, 8, null);
    }

    private final l b(e r10, c r11, m<Long, Float>... r12) {
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r12.length), Collection.class, "com.obric.aiagent.plugin");
        int r0 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        m<Long, Float> r3 = r12[r2];
        r9.add(new i(((Number) ZeusTransformUtils.preCheckCast(r3.a(), Number.class, "com.obric.aiagent.plugin")).longValue(), (g) ZeusTransformUtils.preCheckCast(new g.a(((Number) ZeusTransformUtils.preCheckCast(r3.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()), g.class, "com.obric.aiagent.plugin")));
        r2 = r2 + 1;
        goto L3
    L6:
        return new l(r10, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), r11, null, 8, null);
    }
}

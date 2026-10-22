package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.util.LruCache;
import android.view.animation.PathInterpolator;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.texteffects.a.f;
import com.obric.oui.texteffects.a.g;
import com.obric.oui.texteffects.a.i;
import com.obric.oui.texteffects.a.j;
import com.obric.oui.texteffects.a.l;
import com.obric.oui.texteffects.a.m;
import com.obric.oui.texteffects.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TextEffectTimelineSampler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f36466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LruCache<com.obric.oui.texteffects.a.c.b, PathInterpolator> f36467b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LruCache<com.obric.oui.texteffects.a.c.a, AeAnimatorInterpolator> f36468c = null;

    /* JADX INFO: compiled from: TextEffectTimelineSampler.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36469a = null;

        static {
            int[] r0 = new int[com.obric.oui.texteffects.a.e.values().length];
            r0[com.obric.oui.texteffects.a.e.f36385a.ordinal()] = 1;
            r0[com.obric.oui.texteffects.a.e.f36389e.ordinal()] = 2;
            r0[com.obric.oui.texteffects.a.e.f.ordinal()] = 3;
            r0[com.obric.oui.texteffects.a.e.g.ordinal()] = 4;
            r0[com.obric.oui.texteffects.a.e.f36386b.ordinal()] = 5;
            r0[com.obric.oui.texteffects.a.e.f36387c.ordinal()] = 6;
            r0[com.obric.oui.texteffects.a.e.f36388d.ordinal()] = 7;
            f36469a = r0;
        }
    }

    private final float a(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    private e() {
    }

    public final d a(n r13, long r14) {
        o.e(r13, "spec");
        long r4 = b(r13, r14);
        ArrayList r0 = new ArrayList(a(r13));
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r12.next(), f.class, "com.obric.aiagent.plugin");
        long r6 = r4 - r1.b();
        if (r6 < 0) goto L4;
        if (r6 > r1.c()) goto L4;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r3.hasNext() == false) goto L4;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(f36466a.a(r1.a(), (com.obric.oui.texteffects.a.d) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.oui.texteffects.a.d.class, "com.obric.aiagent.plugin"), r6));
        goto L12
    L14:
        com.obric.oui.texteffects.a r15 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == false) goto L20;
        if (com.obric.oui.texteffects.a.b() == false) goto L20;
        a(o.a("OUITextEffects/", "TimelineSampler"), "sample spec=" + r13.a() + ", playTime=" + r14 + ", normalized=" + r4 + ", activeLayers=" + r0.size());
    L20:
        return new d(r14, r4, (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"));
    }

    private final long b(n r11, long r12) {
        long r8 = d.l.n.a(r11.b(), 1);
        j r0 = r11.c();
        if (o.a(r0, j.b.f36408a) == false) goto L6;
        return a(r12, r8);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, j.a.class) == false) goto L12;
        if (r12 < (((long) d.l.n.c(((j.a) ZeusTransformUtils.preCheckCast(r11.c(), j.a.class, "com.obric.aiagent.plugin")).a(), 1)) * r8)) goto L18;
        return r8;
    L18:
        return a(d.l.n.a(r12, 0), r8);
    L12:
        if (o.a(r0, j.c.f36409a) == false) goto L16;
        return d.l.n.a(r12, 0, r8);
    L16:
        throw new k();
    }

    private final c a(String r21, com.obric.oui.texteffects.a.d r22, long r23) {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r22.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        float r8 = Float.NaN;
        float r9 = Float.NaN;
        float r10 = Float.NaN;
        float r12 = Float.NaN;
        m.b r11 = null;
        g r13 = null;
        g r14 = null;
        g r18 = null;
    L4:
        if (r1.hasNext() == false) goto L18;
        l r2 = (l) ZeusTransformUtils.preCheckCast(r1.next(), l.class, "com.obric.aiagent.plugin");
        switch(a.f36469a[r2.a().ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L8:
        r18 = f36466a.a(r2, r23);
        goto L4
    L9:
        r14 = f36466a.a(r2, r23);
        goto L4
    L10:
        r13 = f36466a.a(r2, r23);
        goto L4
    L11:
        r12 = f36466a.b(r2, r23);
        goto L4
    L12:
        r9 = f36466a.b(r2, r23);
        m r3 = r2.d();
        if (ZeusTransformUtils.instanceOf(r3, m.b.class) == true) goto L14;
        r11 = null;
        goto L4
    L14:
        r11 = (m.b) ZeusTransformUtils.preCheckCast(r3, m.b.class, "com.obric.aiagent.plugin");
        goto L4
    L16:
        r10 = f36466a.b(r2, r23);
        goto L4
    L17:
        r8 = f36466a.b(r2, r23);
        goto L4
    L18:
        String r4 = r22.a();
        if (ZeusTransformUtils.instanceOf(r22, com.obric.oui.texteffects.a.d.a.class) == false) goto L21;
        com.obric.oui.texteffects.a.d.a r0 = (com.obric.oui.texteffects.a.d.a) ZeusTransformUtils.preCheckCast(r22, com.obric.oui.texteffects.a.d.a.class, "com.obric.aiagent.plugin");
    L22:
        if (r0 != null) goto L24;
        String r5 = null;
    L26:
        return new c(r21, r4, r5, r23, r8, Float.NaN, r9, r10, r11, r12, r13, r14, r18, null, 8192, null);
    L24:
        r5 = r0.c();
        goto L26
    L21:
        r0 = null;
        goto L22
    }

    private final g a(l r10, long r11) {
        List<i> r0 = r10.b();
        if (r0.isEmpty() == false) goto L7;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(0.0f), g.class, "com.obric.aiagent.plugin");
    L7:
        if (r11 > ((i) ZeusTransformUtils.preCheckCast(p.k(r0), i.class, "com.obric.aiagent.plugin")).a()) goto L11;
        return ((i) ZeusTransformUtils.preCheckCast(p.k(r0), i.class, "com.obric.aiagent.plugin")).b();
    L11:
        if (r11 >= ((i) ZeusTransformUtils.preCheckCast(p.m(r0), i.class, "com.obric.aiagent.plugin")).a()) goto L13;
        int r1 = a(r0, r11);
        i r4 = (i) ZeusTransformUtils.preCheckCast(r0.get(r1 - 1), i.class, "com.obric.aiagent.plugin");
        i r2 = (i) ZeusTransformUtils.preCheckCast(r0.get(r1), i.class, "com.obric.aiagent.plugin");
        return a(r4, r2, a(r10.c(), d.l.n.a((r11 - r4.a()) / d.l.n.a(r2.a() - r4.a(), 1), 0.0f, 1.0f)));
    L13:
        return ((i) ZeusTransformUtils.preCheckCast(p.m(r0), i.class, "com.obric.aiagent.plugin")).b();
    }

    private final float b(l r9, long r10) {
        List<i> r0 = r9.b();
        if (r0.isEmpty() == false) goto L6;
        return 0.0f;
    L6:
        if (r10 > ((i) ZeusTransformUtils.preCheckCast(p.k(r0), i.class, "com.obric.aiagent.plugin")).a()) goto L10;
        return a(((i) ZeusTransformUtils.preCheckCast(p.k(r0), i.class, "com.obric.aiagent.plugin")).b(), 0.0f);
    L10:
        if (r10 >= ((i) ZeusTransformUtils.preCheckCast(p.m(r0), i.class, "com.obric.aiagent.plugin")).a()) goto L12;
        int r1 = a(r0, r10);
        i r3 = (i) ZeusTransformUtils.preCheckCast(r0.get(r1 - 1), i.class, "com.obric.aiagent.plugin");
        i r2 = (i) ZeusTransformUtils.preCheckCast(r0.get(r1), i.class, "com.obric.aiagent.plugin");
        return a(a(r3.b(), 0.0f), a(r2.b(), a(r3.b(), 0.0f)), a(r9.c(), d.l.n.a((r10 - r3.a()) / d.l.n.a(r2.a() - r3.a(), 1), 0.0f, 1.0f)));
    L12:
        return a(((i) ZeusTransformUtils.preCheckCast(p.m(r0), i.class, "com.obric.aiagent.plugin")).b(), 0.0f);
    }

    private final float a(com.obric.oui.texteffects.a.c r3, float r4) {
        if (o.a(r3, com.obric.oui.texteffects.a.c.C0998c.f36375a) == false) goto L6;
        return r4;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.a.c.b.class) == false) goto L9;
        return a((com.obric.oui.texteffects.a.c.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.c.b.class, "com.obric.aiagent.plugin")).getInterpolation(r4);
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.texteffects.a.c.a.class) == false) goto L13;
        return a((com.obric.oui.texteffects.a.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.texteffects.a.c.a.class, "com.obric.aiagent.plugin")).getInterpolation(r4);
    L13:
        throw new k();
    }

    private final g a(i r4, i r5, float r6) {
        g r7 = r4.b();
        g r8 = r5.b();
        if (ZeusTransformUtils.instanceOf(r7, g.b.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r8, g.b.class) == false) goto L8;
        return (g) ZeusTransformUtils.preCheckCast(new g.b(a(((g.b) ZeusTransformUtils.preCheckCast(r7, g.b.class, "com.obric.aiagent.plugin")).a(), ((g.b) ZeusTransformUtils.preCheckCast(r8, g.b.class, "com.obric.aiagent.plugin")).a(), r6)), g.class, "com.obric.aiagent.plugin");
    L8:
        if (ZeusTransformUtils.instanceOf(r7, g.a.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r8, g.a.class) == false) goto L13;
        return (g) ZeusTransformUtils.preCheckCast(new g.a(a(((g.a) ZeusTransformUtils.preCheckCast(r7, g.a.class, "com.obric.aiagent.plugin")).a(), ((g.a) ZeusTransformUtils.preCheckCast(r8, g.a.class, "com.obric.aiagent.plugin")).a(), r6)), g.class, "com.obric.aiagent.plugin");
    L13:
        if (a(r7) == false) goto L18;
        if (a(r8) == false) goto L18;
        return (g) ZeusTransformUtils.preCheckCast(new g.c(r7, r8, r6), g.class, "com.obric.aiagent.plugin");
    L18:
        if (r6 >= 1.0f) goto L21;
        return r7;
    L21:
        return r8;
    }

    private final boolean a(g r1) {
        if (ZeusTransformUtils.instanceOf(r1, g.b.class) == false) goto L5;
    L16:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, g.a.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, g.e.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, g.d.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, g.f.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, g.c.class) == true) goto L16;
        return false;
    }

    private final float a(g r2, float r3) {
        if (ZeusTransformUtils.instanceOf(r2, g.b.class) == false) goto L6;
        return ((g.b) ZeusTransformUtils.preCheckCast(r2, g.b.class, "com.obric.aiagent.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, g.a.class) == true) goto L8;
        return r3;
    L8:
        return ((g.a) ZeusTransformUtils.preCheckCast(r2, g.a.class, "com.obric.aiagent.plugin")).a();
    }

    private final int a(n r4) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r3.hasNext() == true) goto L5;
        Comparable r5 = null;
    L12:
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L16;
        return 0;
    L16:
        return r6.intValue();
    L5:
        Comparable r7 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.aiagent.plugin")).d().size()), Comparable.class, "com.obric.aiagent.plugin");
    L7:
        if (r3.hasNext() == false) goto L11;
        Comparable r1 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.aiagent.plugin")).d().size()), Comparable.class, "com.obric.aiagent.plugin");
        if (r7.compareTo(r1) >= 0) goto L7;
        r7 = r1;
        goto L7
    L11:
        r5 = r7;
        goto L12
    }

    private final int a(List<i> r6, long r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r8 = p.b(r5);
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L10;
        int r2 = (r1 + r8) >>> 1;
        if (((i) ZeusTransformUtils.preCheckCast(r5.get(r2), i.class, "com.obric.aiagent.plugin")).a() >= r7) goto L7;
        r1 = r2 + 1;
        goto L4
    L7:
        r8 = r2;
        goto L4
    L10:
        return d.l.n.c(r1, 1);
    }

    private final PathInterpolator a(com.obric.oui.texteffects.a.c.b r6) {
        LruCache<com.obric.oui.texteffects.a.c.b, PathInterpolator> r5 = f36467b;
        PathInterpolator r0 = (PathInterpolator) ZeusTransformUtils.preCheckCast(r5.get(r6), PathInterpolator.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        PathInterpolator r1 = new PathInterpolator(r6.a(), r6.b(), r6.c(), r6.d());
        r5.put(r6, r1);
        return r1;
    L6:
        return r0;
    }

    private final AeAnimatorInterpolator a(com.obric.oui.texteffects.a.c.a r5) {
        LruCache<com.obric.oui.texteffects.a.c.a, AeAnimatorInterpolator> r4 = f36468c;
        AeAnimatorInterpolator r0 = (AeAnimatorInterpolator) ZeusTransformUtils.preCheckCast(r4.get(r5), AeAnimatorInterpolator.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        AeAnimatorInterpolator r1 = new AeAnimatorInterpolator(r5.a(), r5.b(), r5.c());
        r4.put(r5, r1);
        return r1;
    L6:
        return r0;
    }

    private final long a(long r3, long r5) {
        long r4 = r3 % r5;
        if (r4 < 0) goto L5;
        return r4;
    L5:
        return r4 + r5;
    }

    static {
        f36466a = new e();
        f36467b = new LruCache(16);
        f36468c = new LruCache(16);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}

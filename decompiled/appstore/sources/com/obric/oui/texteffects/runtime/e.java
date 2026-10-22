package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.util.LruCache;
import android.view.animation.PathInterpolator;
import bg.h;
import com.obric.oui.texteffects.core.EffectProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import od.f;
import od.g;
import od.i;
import od.j;
import od.k;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f17347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache f17348b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache f17349c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17350a = null;

        static {
            int[] r10 = new int[EffectProperty.values().length];
            r10[EffectProperty.Alpha.ordinal()] = 1;
            r10[EffectProperty.Tracking.ordinal()] = 2;
            r10[EffectProperty.GradientAlphaScan.ordinal()] = 3;
            r10[EffectProperty.Visibility.ordinal()] = 4;
            r10[EffectProperty.BlurRadius.ordinal()] = 5;
            r10[EffectProperty.TranslationX.ordinal()] = 6;
            r10[EffectProperty.TranslationY.ordinal()] = 7;
            f17350a = r10;
        }
    }

    static {
        f17347a = new e();
        f17348b = new LruCache(16);
        f17349c = new LruCache(16);
    }

    public e() {
    }

    public final com.obric.oui.texteffects.runtime.a a(od.a.C0327a r10) {
        LruCache r11 = f17349c;
        com.obric.oui.texteffects.runtime.a r12 = (com.obric.oui.texteffects.runtime.a) r11.get(r10);
        if (r12 != null) goto L6;
        com.obric.oui.texteffects.runtime.a r13 = new com.obric.oui.texteffects.runtime.a(r10.c(), r10.b(), r10.a());
        r11.put(r10, r13);
        return r13;
    L6:
        return r12;
    }

    public final float b(od.a r10, float r11) {
        if (q.b(r10, od.a.c.f22556a) == false) goto L6;
        return r11;
    L6:
        if ((r10 instanceof od.a.b) == false) goto L9;
        return k((od.a.b) r10).getInterpolation(r11);
    L9:
        if ((r10 instanceof od.a.C0327a) == false) goto L13;
        return a((od.a.C0327a) r10).getInterpolation(r11);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final float c(od.d r10, float r11) {
        if ((r10 instanceof od.d.b) == false) goto L6;
        return ((od.d.b) r10).a();
    L6:
        if ((r10 instanceof od.d.a) == true) goto L8;
        return r11;
    L8:
        return ((od.d.a) r10).a();
    }

    public final int d(k r10) {
        Iterator r11 = r10.d().iterator();
        if (r11.hasNext() == true) goto L5;
        Integer r12 = null;
    L12:
        if (r12 != null) goto L15;
        return 0;
    L15:
        return r12.intValue();
    L5:
        Integer r13 = Integer.valueOf(((od.c) r11.next()).c().size());
    L7:
        if (r11.hasNext() == false) goto L11;
        Integer r14 = Integer.valueOf(((od.c) r11.next()).c().size());
        if (r13.compareTo(r14) >= 0) goto L7;
        r13 = r14;
        goto L7
    L11:
        r12 = r13;
        goto L12
    }

    public final long e(long r10, long r11) {
        long r12 = r10 % r11;
        if (r12 < 0) goto L5;
        return r12;
    L5:
        return r12 + r11;
    }

    public final od.d f(f r10, f r11, float r12) {
        od.d r13 = r10.b();
        od.d r14 = r11.b();
        if ((r13 instanceof od.d.b) == false) goto L9;
        if ((r14 instanceof od.d.b) == false) goto L9;
        od.d r15 = new od.d.b(h(((od.d.b) r13).a(), ((od.d.b) r14).a(), r12));
    L23:
        return r15;
    L9:
        if ((r13 instanceof od.d.a) == false) goto L14;
        if ((r14 instanceof od.d.a) == false) goto L14;
        r15 = new od.d.a(h(((od.d.a) r13).a(), ((od.d.a) r14).a(), r12));
    L14:
        if (g(r13) == false) goto L19;
        if (g(r14) == false) goto L19;
        return new od.d.c(r13, r14, r12);
    L19:
        if (r12 >= 1.0f) goto L22;
        return r13;
    L22:
        return r14;
    }

    public final boolean g(od.d r10) {
        if ((r10 instanceof od.d.b) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r10 instanceof od.d.a) == true) goto L12;
        if ((r10 instanceof od.d.C0329d) == true) goto L12;
        if ((r10 instanceof od.d.c) == true) goto L12;
        return false;
    }

    public final float h(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    public final int i(List r10, long r11) {
        int r12 = t.k(r10);
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L10;
        int r14 = (r13 + r12) >>> 1;
        if (((f) r10.get(r14)).a() >= r11) goto L7;
        r13 = r14 + 1;
        goto L4
    L7:
        r12 = r14;
        goto L4
    L10:
        return h.d(r13, 1);
    }

    public final long j(k r11, long r12) {
        long r10 = h.e(r11.a(), 1);
        g r13 = r11.c();
        if (q.b(r13, g.a.f22581a) == false) goto L6;
        return e(r12, r10);
    L6:
        if (q.b(r13, g.b.f22582a) == false) goto L10;
        return h.l(r12, 0, r10);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final PathInterpolator k(od.a.b r10) {
        LruCache r11 = f17348b;
        PathInterpolator r12 = (PathInterpolator) r11.get(r10);
        if (r12 != null) goto L6;
        PathInterpolator r13 = new PathInterpolator(r10.a(), r10.c(), r10.b(), r10.d());
        r11.put(r10, r13);
        return r13;
    L6:
        return r12;
    }

    public final d l(k r11, long r12) {
        q.g(r11, "spec");
        long r10 = j(r11, r12);
        ArrayList r13 = new ArrayList(d(r11));
        Iterator r14 = r11.d().iterator();
    L4:
        if (r14.hasNext() == false) goto L15;
        od.c r15 = (od.c) r14.next();
        long r16 = r10 - r15.d();
        if (r16 < 0) goto L4;
        if (r16 > r15.a()) goto L4;
        Iterator r17 = r15.c().iterator();
    L12:
        if (r17.hasNext() == false) goto L4;
        r13.add(f17347a.m(r15.b(), (od.b) r17.next(), r16));
        goto L12
    L15:
        if (com.obric.oui.texteffects.e.a() == false) goto L20;
        if (com.obric.oui.texteffects.e.b() == false) goto L20;
        Log.d(q.p("OUITextEffects/", "TimelineSampler"), "sample spec=" + r11.b() + ", playTime=" + r12 + ", normalized=" + r10 + ", activeLayers=" + r13.size());
    L20:
        return new d(r12, r10, r13);
    }

    public final c m(String r20, od.b r21, long r22) {
        Iterator r10 = r21.b().iterator();
        String r11 = null;
        float r12 = Float.NaN;
        float r13 = Float.NaN;
        float r14 = Float.NaN;
        float r15 = Float.NaN;
        j.b r16 = null;
        od.d r17 = null;
        od.d r18 = null;
        od.d r19 = null;
    L4:
        if (r10.hasNext() == false) goto L18;
        i r23 = (i) r10.next();
        switch(a.f17350a[r23.c().ordinal()]) {
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
        r19 = f17347a.n(r23, r22);
        goto L4
    L9:
        r18 = f17347a.n(r23, r22);
        goto L4
    L10:
        r17 = f17347a.n(r23, r22);
        goto L4
    L11:
        r15 = f17347a.o(r23, r22);
        goto L4
    L12:
        r13 = f17347a.o(r23, r22);
        j r24 = r23.d();
        if ((r24 instanceof j.b) == true) goto L14;
        r16 = null;
        goto L4
    L14:
        r16 = (j.b) r24;
        goto L4
    L16:
        r14 = f17347a.o(r23, r22);
        goto L4
    L17:
        r12 = f17347a.o(r23, r22);
        goto L4
    L18:
        String r25 = r21.a();
        if ((r21 instanceof od.b.a) == false) goto L21;
        od.b.a r26 = (od.b.a) r21;
    L22:
        if (r26 == null) goto L26;
        r11 = r26.c();
    L26:
        return new c(r20, r25, r11, r22, r12, Float.NaN, r13, r14, r16, r15, r17, r18, r19, null, 8192, null);
    L21:
        r26 = null;
        goto L22
    }

    public final od.d n(i r10, long r11) {
        List r12 = r10.b();
        if (r12.isEmpty() == false) goto L7;
        return new od.d.b(0.0f);
    L7:
        if (r11 > ((f) b0.Y(r12)).a()) goto L11;
        return ((f) b0.Y(r12)).b();
    L11:
        if (r11 >= ((f) b0.i0(r12)).a()) goto L13;
        int r13 = i(r12, r11);
        f r14 = (f) r12.get(r13 - 1);
        f r15 = (f) r12.get(r13);
        return f(r14, r15, b(r10.a(), h.j((r11 - r14.a()) / h.e(r15.a() - r14.a(), 1), 0.0f, 1.0f)));
    L13:
        return ((f) b0.i0(r12)).b();
    }

    public final float o(i r10, long r11) {
        List r12 = r10.b();
        if (r12.isEmpty() == false) goto L6;
        return 0.0f;
    L6:
        if (r11 > ((f) b0.Y(r12)).a()) goto L10;
        return c(((f) b0.Y(r12)).b(), 0.0f);
    L10:
        if (r11 >= ((f) b0.i0(r12)).a()) goto L12;
        int r13 = i(r12, r11);
        f r14 = (f) r12.get(r13 - 1);
        f r15 = (f) r12.get(r13);
        return h(c(r14.b(), 0.0f), c(r15.b(), c(r14.b(), 0.0f)), b(r10.a(), h.j((r11 - r14.a()) / h.e(r15.a() - r14.a(), 1), 0.0f, 1.0f)));
    L12:
        return c(((f) b0.i0(r12)).b(), 0.0f);
    }
}

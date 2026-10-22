package com.obric.oui.banner.a;

import d.h.b.o;
import d.k;
import d.m;

/* JADX INFO: compiled from: GridIndentBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f34035a = null;

    /* JADX INFO: compiled from: GridIndentBannerConfig.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34036a = null;

        static {
            int[] r0 = new int[com.obric.oui.window.a.f.values().length];
            r0[com.obric.oui.window.a.f.f36863a.ordinal()] = 1;
            r0[com.obric.oui.window.a.f.f36864b.ordinal()] = 2;
            r0[com.obric.oui.window.a.f.f36865c.ordinal()] = 3;
            r0[com.obric.oui.window.a.f.f36866d.ordinal()] = 4;
            r0[com.obric.oui.window.a.f.f36867e.ordinal()] = 5;
            r0[com.obric.oui.window.a.f.f.ordinal()] = 6;
            r0[com.obric.oui.window.a.f.g.ordinal()] = 7;
            r0[com.obric.oui.window.a.f.h.ordinal()] = 8;
            r0[com.obric.oui.window.a.f.i.ordinal()] = 9;
            f34036a = r0;
        }
    }

    static {
        f34035a = new d();
    }

    private d() {
    }

    public static final c a(com.obric.oui.window.a.f r15) {
        o.e(r15, "windowSize");
        switch(a.f34036a[r15.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L11;
            case 9: goto L10;
            default: goto L5;
        };
    L5:
        throw new k();
    L10:
        return new c(17.0f, 0.25f, 326);
    L11:
        return new c(17.0f, 0.25f, 0, 4, null);
    L9:
        return new c(16.0f, 0.33333334f, 0, 4, null);
    }

    public static final m<Integer, Integer> a(com.obric.oui.window.a.g r3, float r4) {
        o.e(r3, "windowSizeWithPageSize");
        com.obric.oui.window.a.f r0 = r3.a();
        c r1 = a(r0);
        int r5 = com.obric.oui.common.util.g.b(r3.b().a(), r4) - (com.obric.oui.common.util.g.a(r0.a().c().a(), r4) * 2);
        return new m(Integer.valueOf(r5), Integer.valueOf(Math.min(r1.c(), (int) (r5 * r1.b()))));
    }
}

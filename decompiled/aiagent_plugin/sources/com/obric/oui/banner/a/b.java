package com.obric.oui.banner.a;

import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: GridFillBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f34030a = null;

    /* JADX INFO: compiled from: GridFillBannerConfig.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34031a = null;

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
            f34031a = r0;
        }
    }

    static {
        f34030a = new b();
    }

    private b() {
    }

    public static final com.obric.oui.banner.a.a a(com.obric.oui.window.a.f r15) {
        o.e(r15, "windowSize");
        switch(a.f34031a[r15.ordinal()]) {
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
        return new com.obric.oui.banner.a.a(17.0f, 0.25f, 342);
    L11:
        return new com.obric.oui.banner.a.a(17.0f, 0.25f, 0, 4, null);
    L9:
        return new com.obric.oui.banner.a.a(16.0f, 0.33333334f, 0, 4, null);
    }

    public static final int a(com.obric.oui.window.a.g r2) {
        o.e(r2, "windowSizeWithPageSize");
        com.obric.oui.banner.a.a r0 = a(r2.a());
        return Math.min(r0.c(), (int) (r2.b().b() * r0.b()));
    }
}

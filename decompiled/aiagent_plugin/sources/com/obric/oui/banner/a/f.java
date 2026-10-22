package com.obric.oui.banner.a;

import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: GridTriptychBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f34040a = null;

    /* JADX INFO: compiled from: GridTriptychBannerConfig.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34041a = null;

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
            f34041a = r0;
        }
    }

    static {
        f34040a = new f();
    }

    private f() {
    }

    public static final e a(com.obric.oui.window.a.f r12) {
        o.e(r12, "windowSize");
        switch(a.f34041a[r12.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            default: goto L5;
        };
    L5:
        throw new k();
    L11:
        return new e(17.0f, 10, 0, 4, null);
    L12:
        return new e(17.0f, 10, 0, 4, null);
    L13:
        return new e(16.0f, 6, 0, 4, null);
    L10:
        return new e(16.0f, 8, 0, 4, null);
    }

    public static final int b(com.obric.oui.window.a.f r3) {
        o.e(r3, "currentWindowSizeClass");
        int r0 = a(r3).b();
        return (int) ((r0 * com.obric.oui.window.a.f36851a.c()) + ((r0 - 1) * r3.a().b().a()));
    }
}

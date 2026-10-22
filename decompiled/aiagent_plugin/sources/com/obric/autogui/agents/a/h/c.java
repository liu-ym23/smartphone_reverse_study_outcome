package com.obric.autogui.agents.a.h;

import com.obric.autogui.agents.a.f.j;
import d.a.i;
import d.h.b.o;
import d.k;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectPolicyRegistry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26502a = null;

    /* JADX INFO: compiled from: ActionEffectPolicyRegistry.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26503a = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.a.f.a.values().length];
            r0[com.obric.autogui.agents.a.f.a.f26392a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[com.obric.autogui.agents.a.f.a.f26393b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[com.obric.autogui.agents.a.f.a.f26394c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[com.obric.autogui.agents.a.f.a.f26395d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[com.obric.autogui.agents.a.f.a.f26396e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[com.obric.autogui.agents.a.f.a.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[com.obric.autogui.agents.a.f.a.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[com.obric.autogui.agents.a.f.a.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f26503a = r0;
        }
    }

    static {
        f26502a = new c();
    }

    private c() {
    }

    public final j a(com.obric.autogui.agents.a.f.a r20) {
        o.e(r20, "action");
        switch(a.f26503a[r20.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L5;
        };
    L5:
        throw new k();
    L13:
        return new j(r20, a(new com.obric.autogui.agents.a.f.c[]{com.obric.autogui.agents.a.f.c.f26402a, com.obric.autogui.agents.a.f.c.f26403b}), 100, 1, 1000, 0, false, 0, 0, 0, 0, 0, 4032, null);
    L14:
        return new j(r20, a(new com.obric.autogui.agents.a.f.c[]{com.obric.autogui.agents.a.f.c.g}), 100, 1, 1000, 0, false, 0, 0, 0, 0, 0, 4032, null);
    L15:
        return c(r20);
    L16:
        return b(r20);
    L17:
        return new j(r20, a(new com.obric.autogui.agents.a.f.c[]{com.obric.autogui.agents.a.f.c.f26406e, com.obric.autogui.agents.a.f.c.f26404c, com.obric.autogui.agents.a.f.c.f26405d}), 100, 7, 1000, 100, false, 0, 0, 0, 0, 0, 4032, null);
    L12:
        return b(r20);
    }

    private final j b(com.obric.autogui.agents.a.f.a r19) {
        return new j(r19, a(new com.obric.autogui.agents.a.f.c[]{com.obric.autogui.agents.a.f.c.f26402a, com.obric.autogui.agents.a.f.c.f26403b, com.obric.autogui.agents.a.f.c.f26405d}), 100, 2, 1000, 100, false, 0, 0, 0, 0, 0, 4032, null);
    }

    private final j c(com.obric.autogui.agents.a.f.a r19) {
        return new j(r19, a(new com.obric.autogui.agents.a.f.c[]{com.obric.autogui.agents.a.f.c.f, com.obric.autogui.agents.a.f.c.f26403b, com.obric.autogui.agents.a.f.c.f26405d}), 100, 2, 1000, 100, false, 0, 0, 0, 0, 0, 4032, null);
    }

    private final List<com.obric.autogui.agents.a.f.c> a(com.obric.autogui.agents.a.f.c... r1) {
        return i.g(r1);
    }
}

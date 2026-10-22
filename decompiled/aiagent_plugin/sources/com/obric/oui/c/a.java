package com.obric.oui.c;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BlendConfigStateList.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0930a f34317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f34318b;

    /* JADX INFO: renamed from: com.obric.oui.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BlendConfigStateList.kt */
    public static final class C0930a {
        public /* synthetic */ C0930a(h r1) {
            this();
        }

        private C0930a() {
        }

        public final a a(b r2) {
            o.e(r2, "core");
            return new a(r2, null);
        }

        public final com.obric.oui.color.a[] a(com.obric.oui.color.a[] r1, com.obric.oui.color.a[] r2, float r3) {
            o.e(r1, "fromConfigs");
            o.e(r2, "toConfigs");
            com.obric.oui.color.b[] r0 = b.a(com.obric.oui.color.c.a(r1), com.obric.oui.color.c.a(r2), r3);
            o.c(r0, "getConfigForTransition(\n…   progress\n            )");
            return com.obric.oui.color.c.a(r0);
        }
    }

    static {
        f34317a = new C0930a(null);
    }

    public /* synthetic */ a(b r1, h r2) {
        this(r1);
    }

    private a(b r1) {
        this.f34318b = r1;
    }

    public final com.obric.oui.color.a[] a() {
        com.obric.oui.color.b[] r1 = this.f34318b.a();
        o.c(r1, "core.defaultBlendConfig");
        return com.obric.oui.color.c.a(r1);
    }

    public static /* synthetic */ com.obric.oui.color.a[] a(a r0, int[] r1, com.obric.oui.color.a[] r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.a();
    L6:
        return r0.a(r1, r2);
    }

    public final com.obric.oui.color.a[] a(int[] r2, com.obric.oui.color.a[] r3) {
        o.e(r2, "stateSet");
        o.e(r3, "defaultConfig");
        com.obric.oui.color.b[] r1 = this.f34318b.a(r2, com.obric.oui.color.c.a(r3));
        o.c(r1, "core.getConfigForState(s…aultConfig.toCoreArray())");
        return com.obric.oui.color.c.a(r1);
    }

    public final b b() {
        return this.f34318b;
    }
}

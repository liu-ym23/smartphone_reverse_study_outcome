package ld;

import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0305a f21932b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21933a;

    /* JADX INFO: renamed from: ld.a$a, reason: collision with other inner class name */
    public static final class C0305a {
        public /* synthetic */ C0305a(DefaultConstructorMarker r10) {
            this();
        }

        public final a a(b r10) {
            q.g(r10, "core");
            return new a(r10, null);
        }

        public final com.obric.oui.color.a[] b(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, float r12) {
            q.g(r10, "fromConfigs");
            q.g(r11, "toConfigs");
            com.obric.oui.color.b[] r13 = b.e(com.obric.oui.color.c.c(r10), com.obric.oui.color.c.c(r11), r12);
            q.f(r13, "getConfigForTransition(\n…   progress\n            )");
            return com.obric.oui.color.c.b(r13);
        }

        public final a c(int[][] r10, com.obric.oui.color.a[][] r11) {
            q.g(r10, "states");
            q.g(r11, "configs");
            b r12 = b.h(r10, d(r11));
            q.f(r12, "of(states, configs.toCore2DArray())");
            return new a(r12, null);
        }

        public final com.obric.oui.color.b[][] d(com.obric.oui.color.a[][] r10) {
            ArrayList r11 = new ArrayList(r10.length);
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r11.add(com.obric.oui.color.c.c(r10[r13]));
            r13 = r13 + 1;
            goto L3
        L5:
            Object[] r14 = r11.toArray(new com.obric.oui.color.b[0][]);
            if (r14 == null) goto L10;
            return (com.obric.oui.color.b[][]) r14;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final a e(com.obric.oui.color.a[] r10) {
            q.g(r10, "configs");
            b r11 = b.m(com.obric.oui.color.c.c(r10));
            q.f(r11, "valueOf(configs.toCoreArray())");
            return new a(r11, null);
        }

        public C0305a() {
        }
    }

    static {
        f21932b = new C0305a(null);
    }

    public /* synthetic */ a(b r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static /* synthetic */ com.obric.oui.color.a[] b(a r10, int[] r11, com.obric.oui.color.a[] r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10.c();
    L6:
        return r10.a(r11, r12);
    }

    public final com.obric.oui.color.a[] a(int[] r10, com.obric.oui.color.a[] r11) {
        q.g(r10, "stateSet");
        q.g(r11, "defaultConfig");
        com.obric.oui.color.b[] r12 = this.f21933a.d(r10, com.obric.oui.color.c.c(r11));
        q.f(r12, "core.getConfigForState(s…aultConfig.toCoreArray())");
        return com.obric.oui.color.c.b(r12);
    }

    public final com.obric.oui.color.a[] c() {
        com.obric.oui.color.b[] r10 = this.f21933a.f();
        q.f(r10, "core.defaultBlendConfig");
        return com.obric.oui.color.c.b(r10);
    }

    public final b d() {
        return this.f21933a;
    }

    public a(b r10) {
        this.f21933a = r10;
    }
}

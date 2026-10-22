package ld;

import com.obric.oui.color.j0;
import com.obric.oui.color.k0;
import com.obric.oui.color.l0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21939b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21940a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ c d(a r10, j0 r11, j0 r12, j0 r13, j0 r14, j0 r15, j0 r16, int r17, Object r18) {
            if ((r17 & 1) == 0) goto L6;
            r11 = null;
        L6:
            if ((r17 & 2) == 0) goto L8;
            j0 r19 = r11;
        L10:
            if ((r17 & 4) == 0) goto L12;
            j0 r20 = r19;
        L14:
            if ((r17 & 8) == 0) goto L16;
            j0 r21 = r11;
        L18:
            if ((r17 & 16) == 0) goto L20;
            j0 r22 = r11;
        L22:
            if ((r17 & 32) == 0) goto L24;
            j0 r23 = r11;
        L26:
            return r10.c(r11, r19, r20, r21, r22, r23);
        L24:
            r23 = r16;
            goto L26
        L20:
            r22 = r15;
            goto L22
        L16:
            r21 = r14;
            goto L18
        L12:
            r20 = r13;
            goto L14
        L8:
            r19 = r12;
            goto L10
        }

        public final c a(d r10) {
            q.g(r10, "core");
            return new c(r10, null);
        }

        public final j0 b(j0 r10, j0 r11, float r12) {
            q.g(r10, "fromConfig");
            q.g(r11, "toConfig");
            k0 r13 = d.c(r10.d(), r11.d(), r12);
            if (r13 != null) goto L6;
            return null;
        L6:
            return l0.a(r13);
        }

        public final c c(j0 r10, j0 r11, j0 r12, j0 r13, j0 r14, j0 r15) {
            DefaultConstructorMarker r16 = null;
            if (r10 != null) goto L5;
            k0 r17 = null;
        L6:
            if (r11 != null) goto L8;
            k0 r18 = null;
        L9:
            if (r12 != null) goto L11;
            k0 r19 = null;
        L12:
            if (r13 != null) goto L14;
            k0 r20 = null;
        L15:
            if (r14 != null) goto L17;
            k0 r21 = null;
        L18:
            if (r15 != null) goto L20;
            k0 r22 = null;
        L21:
            d r23 = d.e(r17, r18, r19, r20, r21, r22);
            q.f(r23, "of(\n                    …Core(),\n                )");
            return new c(r23, r16);
        L20:
            r22 = r15.d();
            goto L21
        L17:
            r21 = r14.d();
            goto L18
        L14:
            r20 = r13.d();
            goto L15
        L11:
            r19 = r12.d();
            goto L12
        L8:
            r18 = r11.d();
            goto L9
        L5:
            r17 = r10.d();
            goto L6
        }

        public final c e(j0 r10) {
            DefaultConstructorMarker r11 = null;
            if (r10 != null) goto L5;
            k0 r12 = null;
        L6:
            d r13 = d.g(r12);
            q.f(r13, "valueOf(stroke?.toCore())");
            return new c(r13, r11);
        L5:
            r12 = r10.d();
            goto L6
        }

        public a() {
        }
    }

    static {
        f21939b = new a(null);
    }

    public /* synthetic */ c(d r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static /* synthetic */ j0 b(c r10, int[] r11, j0 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r10.c();
    L6:
        return r10.a(r11, r12);
    }

    public final j0 a(int[] r10, j0 r11) {
        q.g(r10, "stateSet");
        d r12 = this.f21940a;
        if (r11 != null) goto L5;
        k0 r13 = null;
    L6:
        k0 r14 = r12.b(r10, r13);
        if (r14 != null) goto L10;
        return null;
    L10:
        return l0.a(r14);
    L5:
        r13 = r11.d();
        goto L6
    }

    public final j0 c() {
        k0 r10 = this.f21940a.d();
        if (r10 != null) goto L6;
        return null;
    L6:
        return l0.a(r10);
    }

    public final d d() {
        return this.f21940a;
    }

    public c(d r10) {
        this.f21940a = r10;
    }
}

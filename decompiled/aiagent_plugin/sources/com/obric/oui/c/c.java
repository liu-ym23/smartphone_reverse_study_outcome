package com.obric.oui.c;

import com.obric.oui.color.e;
import com.obric.oui.color.f;
import com.obric.oui.color.g;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StrokeStateList.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34324a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f34325b;

    /* JADX INFO: compiled from: StrokeStateList.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a(d r2) {
            o.e(r2, "core");
            return new c(r2, null);
        }

        public final e a(e r1, e r2, float r3) {
            o.e(r1, "fromConfig");
            o.e(r2, "toConfig");
            f r0 = d.a(r1.d(), r2.d(), r3);
            if (r0 != null) goto L6;
            return null;
        L6:
            return g.a(r0);
        }
    }

    static {
        f34324a = new a(null);
    }

    public /* synthetic */ c(d r1, h r2) {
        this(r1);
    }

    private c(d r1) {
        this.f34325b = r1;
    }

    public final e a() {
        f r0 = this.f34325b.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        return g.a(r0);
    }

    public static /* synthetic */ e a(c r0, int[] r1, e r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.a();
    L6:
        return r0.a(r1, r2);
    }

    public final e a(int[] r2, e r3) {
        o.e(r2, "stateSet");
        d r1 = this.f34325b;
        if (r3 != null) goto L5;
        f r4 = null;
    L6:
        f r5 = r1.a(r2, r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        return g.a(r5);
    L5:
        r4 = r3.d();
        goto L6
    }

    public final d b() {
        return this.f34325b;
    }
}

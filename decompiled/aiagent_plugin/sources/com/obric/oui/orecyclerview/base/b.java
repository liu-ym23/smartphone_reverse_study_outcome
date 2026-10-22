package com.obric.oui.orecyclerview.base;

import d.l.n;

/* JADX INFO: compiled from: FluidRubberBand.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35513a = null;

    /* JADX INFO: compiled from: FluidRubberBand.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final float a(float r2, float r3) {
            if (r2 >= 0.0f) goto L5;
            return 0.0f;
        L5:
            if (r3 > 0.0f) goto L8;
            return 0.0f;
        L8:
            return (1.0f - (1.0f / (((r2 / r3) * 0.55f) + 1.0f))) * r3;
        }

        private a() {
        }

        public final float b(float r2, float r3) {
            if (r2 >= 0.0f) goto L5;
        L9:
            return 0.0f;
        L5:
            if (r3 <= 0.0f) goto L9;
            float r1 = n.b(r2, r3 - 1.0E-5f);
            return ((r3 * r1) / (r3 - r1)) / 0.55f;
        }
    }

    static {
        f35513a = new a(null);
    }
}

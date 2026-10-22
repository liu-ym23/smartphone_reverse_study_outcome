package com.obric.common.oea.style.scene.a;

import d.h.b.h;

/* JADX INFO: compiled from: RubberBandHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0889a f32479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f32480b = 0.0f;

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RubberBandHelper.kt */
    public static final class C0889a {
        private C0889a() {
        }

        public /* synthetic */ C0889a(h r1) {
            this();
        }

        public final float a(float r2, float r3, float r4, float r5) {
            if (r4 != r5) goto L5;
        L22:
            return r4;
        L5:
            if (r4 == r3) goto L22;
            if (r2 >= r3) goto L13;
            if (r5 >= r2) goto L13;
            return r5;
        L13:
            if (r2 > r3) goto L15;
        L17:
            float r6 = r3 - r2;
            float r1 = a.a();
            float r7 = ((r1 * (r5 - r2)) / r6) + 1.0f;
            if (r7 != 0.0f) goto L21;
            return 0.0f;
        L21:
            return r2 + ((1.0f - (1.0f / r7)) * r6);
        L15:
            if (r5 <= r2) goto L17;
            return r5;
        }
    }

    public static final /* synthetic */ float a() {
        return f32480b;
    }

    static {
        f32479a = new C0889a(null);
        f32480b = 0.55f;
    }
}

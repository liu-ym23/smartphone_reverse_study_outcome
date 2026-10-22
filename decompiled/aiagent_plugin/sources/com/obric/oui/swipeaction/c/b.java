package com.obric.oui.swipeaction.c;

import d.h.b.h;

/* JADX INFO: compiled from: RubberBandHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f36298b = 0.0f;

    /* JADX INFO: compiled from: RubberBandHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final float a(float r4, float r5, float r6, float r7) {
            boolean r0 = true;
            if (r6 != r7) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L8;
        L31:
            return r6;
        L8:
            if (r6 != r5) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == true) goto L31;
            if (r4 >= r5) goto L19;
            if (r7 >= r4) goto L19;
            return r7;
        L19:
            if (r4 > r5) goto L21;
        L23:
            float r9 = r5 - r4;
            float r10 = ((b.a() * (r7 - r4)) / r9) + 1.0f;
            if (r10 == 0.0f) goto L27;
            r0 = false;
        L27:
            if (r0 == false) goto L30;
            return 0.0f;
        L30:
            return r4 + ((1.0f - (1.0f / r10)) * r9);
        L21:
            if (r7 <= r4) goto L23;
            return r7;
        L10:
            r8 = false;
            goto L11
        L5:
            r3 = false;
            goto L6
        }
    }

    public static final /* synthetic */ float a() {
        return f36298b;
    }

    static {
        f36297a = new a(null);
        f36298b = 1.0f;
    }
}

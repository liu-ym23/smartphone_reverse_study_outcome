package com.obric.common.oea.style.scene.alpha.alphaplayer.b;

import com.obric.common.oea.style.scene.alpha.alphaplayer.a.d;

/* JADX INFO: compiled from: TextureCropUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.b.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextureCropUtil.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32500a = null;

        static {
            int[] r0 = new int[d.values().length];
            f32500a = r0;
            r0[d.f32494b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f32500a[d.f32495c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f32500a[d.f32496d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f32500a[d.f32497e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f32500a[d.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f32500a[d.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f32500a[d.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f32500a[d.i.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f32500a[d.j.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f32500a[d.k.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    private static float[] a(float r6, float r7, float r8, float r9) {
        float r10 = (r6 * 2.0f) - 1.0f;
        float r11 = (r9 * 2.0f) - 1.0f;
        float r12 = 1.0f - (r8 * 2.0f);
        float r13 = 1.0f - (r7 * 2.0f);
        return new float[]{r10, r11, 0.0f, 0.5f, 0.0f, r12, r11, 0.0f, 1.0f, 0.0f, r10, r13, 0.0f, 0.5f, 1.0f, r12, r13, 0.0f, 1.0f, 1.0f};
    }

    private static float[] b(float r6, float r7, float r8, float r9) {
        float r10 = (r6 / 2.0f) + 0.5f;
        float r11 = r9 + 0.0f;
        float r12 = 1.0f - (r8 / 2.0f);
        float r13 = 1.0f - r7;
        return new float[]{-1.0f, -1.0f, 0.0f, r10, r11, 1.0f, -1.0f, 0.0f, r12, r11, -1.0f, 1.0f, 0.0f, r10, r13, 1.0f, 1.0f, 0.0f, r12, r13};
    }

    public static float[] a(d r7, float r8, float r9, float r10, float r11) {
        float r0 = r8 / r9;
        float r12 = r10 / r11;
        float r2 = 0.0f;
        if (r0 <= r12) goto L5;
        float r4 = (1.0f - (r9 / (r8 / r12))) / 2.0f;
        float r3 = 0.0f;
    L7:
        switch(AnonymousClass1.f32500a[r7.ordinal()]) {
            case 1: goto L18;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L24;
            default: goto L23;
        };
    L18:
        if (r0 <= r12) goto L20;
        r2 = (1.0f - ((r9 * r12) / r8)) / 2.0f;
        float r1 = 0.0f;
    L22:
        return a(r2, r1, r2, r1);
    L20:
        r1 = (1.0f - ((r8 / r12) / r9)) / 2.0f;
        goto L22
    L23:
        return b(0.0f, 0.0f, 0.0f, 0.0f);
    L24:
        return a(((1.0f - ((r9 * r12) / r8)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
    L25:
        return a(0.0f, 0.0f, ((1.0f - ((r9 * r12) / r8)) / 2.0f) * 2.0f, 0.0f);
    L26:
        return a(0.0f, ((1.0f - ((r8 / r12) / r9)) / 2.0f) * 2.0f, 0.0f, 0.0f);
    L27:
        return a(0.0f, 0.0f, 0.0f, ((1.0f - ((r8 / r12) / r9)) / 2.0f) * 2.0f);
    L28:
        return b(r3 * 2.0f, r4, 0.0f, r4);
    L29:
        return b(0.0f, r4, r3 * 2.0f, r4);
    L30:
        return b(r3, r4 * 2.0f, r3, 0.0f);
    L31:
        return b(r3, 0.0f, r3, r4 * 2.0f);
    L32:
        return b(r3, r4, r3, r4);
    L5:
        r3 = (1.0f - (r8 / (r9 * r12))) / 2.0f;
        r4 = 0.0f;
        goto L7
    }
}

package vb;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: vb.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0395a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25125a = null;

        static {
            int[] r10 = new int[ScaleType.values().length];
            f25125a = r10;
            r10[ScaleType.ScaleAspectFitCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f25125a[ScaleType.ScaleAspectFill.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f25125a[ScaleType.TopFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f25125a[ScaleType.BottomFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f25125a[ScaleType.LeftFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f25125a[ScaleType.RightFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f25125a[ScaleType.TopFit.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f25125a[ScaleType.BottomFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f25125a[ScaleType.LeftFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f25125a[ScaleType.RightFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static float[] a(ScaleType r10, float r11, float r12, float r13, float r14) {
        float r15 = r11 / r12;
        float r16 = r13 / r14;
        float r17 = 0.0f;
        if (r15 <= r16) goto L5;
        float r18 = (1.0f - (r12 / (r11 / r16))) / 2.0f;
        float r19 = 0.0f;
    L7:
        switch(C0395a.f25125a[r10.ordinal()]) {
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
        if (r15 <= r16) goto L20;
        r17 = (1.0f - ((r12 * r16) / r11)) / 2.0f;
        float r20 = 0.0f;
    L22:
        return c(r17, r20, r17, r20);
    L20:
        r20 = (1.0f - ((r11 / r16) / r12)) / 2.0f;
        goto L22
    L23:
        return b(0.0f, 0.0f, 0.0f, 0.0f);
    L24:
        return c(((1.0f - ((r12 * r16) / r11)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
    L25:
        return c(0.0f, 0.0f, ((1.0f - ((r12 * r16) / r11)) / 2.0f) * 2.0f, 0.0f);
    L26:
        return c(0.0f, ((1.0f - ((r11 / r16) / r12)) / 2.0f) * 2.0f, 0.0f, 0.0f);
    L27:
        return c(0.0f, 0.0f, 0.0f, ((1.0f - ((r11 / r16) / r12)) / 2.0f) * 2.0f);
    L28:
        return b(r19 * 2.0f, r18, 0.0f, r18);
    L29:
        return b(0.0f, r18, r19 * 2.0f, r18);
    L30:
        return b(r19, r18 * 2.0f, r19, 0.0f);
    L31:
        return b(r19, 0.0f, r19, r18 * 2.0f);
    L32:
        return b(r19, r18, r19, r18);
    L5:
        r19 = (1.0f - (r11 / (r12 * r16))) / 2.0f;
        r18 = 0.0f;
        goto L7
    }

    public static float[] b(float r10, float r11, float r12, float r13) {
        float r14 = (r10 / 2.0f) + 0.5f;
        float r15 = r13 + 0.0f;
        float r16 = 1.0f - (r12 / 2.0f);
        float r17 = 1.0f - r11;
        return new float[]{-1.0f, -1.0f, 0.0f, r14, r15, 1.0f, -1.0f, 0.0f, r16, r15, -1.0f, 1.0f, 0.0f, r14, r17, 1.0f, 1.0f, 0.0f, r16, r17};
    }

    public static float[] c(float r10, float r11, float r12, float r13) {
        float r14 = (r10 * 2.0f) - 1.0f;
        float r15 = (r13 * 2.0f) - 1.0f;
        float r16 = 1.0f - (r12 * 2.0f);
        float r17 = 1.0f - (r11 * 2.0f);
        return new float[]{r14, r15, 0.0f, 0.5f, 0.0f, r16, r15, 0.0f, 1.0f, 0.0f, r14, r17, 0.0f, 0.5f, 1.0f, r16, r17, 0.0f, 1.0f, 1.0f};
    }
}

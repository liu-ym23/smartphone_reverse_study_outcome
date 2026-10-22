package com.obric.common.oea.style.scene.alpha.alphaplayer.utils;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;

/* JADX INFO: loaded from: classes3.dex */
public class TextureCropUtil {

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.utils.TextureCropUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType = null;

        static {
            int[] r0 = new int[ScaleType.values().length];
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType = r0;
            r0[ScaleType.ScaleAspectFitCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.ScaleAspectFill.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.TopFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.BottomFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.LeftFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.RightFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.TopFit.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.BottomFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.LeftFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[ScaleType.RightFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    private static float[] getCropData(float r6, float r7, float r8, float r9) {
        float r10 = (r6 / 2.0f) + 0.5f;
        float r11 = r9 + 0.0f;
        float r12 = 1.0f - (r8 / 2.0f);
        float r13 = 1.0f - r7;
        return new float[]{-1.0f, -1.0f, 0.0f, r10, r11, 1.0f, -1.0f, 0.0f, r12, r11, -1.0f, 1.0f, 0.0f, r10, r13, 1.0f, 1.0f, 0.0f, r12, r13};
    }

    private static float[] getZoomData(float r6, float r7, float r8, float r9) {
        float r10 = (r6 * 2.0f) - 1.0f;
        float r11 = (r9 * 2.0f) - 1.0f;
        float r12 = 1.0f - (r8 * 2.0f);
        float r13 = 1.0f - (r7 * 2.0f);
        return new float[]{r10, r11, 0.0f, 0.5f, 0.0f, r12, r11, 0.0f, 1.0f, 0.0f, r10, r13, 0.0f, 0.5f, 1.0f, r12, r13, 0.0f, 1.0f, 1.0f};
    }

    public TextureCropUtil() {
    }

    public static float[] calculateHalfRightVerticeData(ScaleType r7, float r8, float r9, float r10, float r11) {
        float r0 = r8 / r9;
        float r12 = r10 / r11;
        float r2 = 0.0f;
        if (r0 <= r12) goto L5;
        float r4 = (1.0f - (r9 / (r8 / r12))) / 2.0f;
        float r3 = 0.0f;
    L7:
        switch(AnonymousClass1.$SwitchMap$com$obric$common$oea$style$scene$alpha$alphaplayer$model$ScaleType[r7.ordinal()]) {
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
        return getZoomData(r2, r1, r2, r1);
    L20:
        r1 = (1.0f - ((r8 / r12) / r9)) / 2.0f;
        goto L22
    L23:
        return getCropData(0.0f, 0.0f, 0.0f, 0.0f);
    L24:
        return getZoomData(((1.0f - ((r9 * r12) / r8)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
    L25:
        return getZoomData(0.0f, 0.0f, ((1.0f - ((r9 * r12) / r8)) / 2.0f) * 2.0f, 0.0f);
    L26:
        return getZoomData(0.0f, ((1.0f - ((r8 / r12) / r9)) / 2.0f) * 2.0f, 0.0f, 0.0f);
    L27:
        return getZoomData(0.0f, 0.0f, 0.0f, ((1.0f - ((r8 / r12) / r9)) / 2.0f) * 2.0f);
    L28:
        return getCropData(r3 * 2.0f, r4, 0.0f, r4);
    L29:
        return getCropData(0.0f, r4, r3 * 2.0f, r4);
    L30:
        return getCropData(r3, r4 * 2.0f, r3, 0.0f);
    L31:
        return getCropData(r3, 0.0f, r3, r4 * 2.0f);
    L32:
        return getCropData(r3, r4, r3, r4);
    L5:
        r3 = (1.0f - (r8 / (r9 * r12))) / 2.0f;
        r4 = 0.0f;
        goto L7
    }
}

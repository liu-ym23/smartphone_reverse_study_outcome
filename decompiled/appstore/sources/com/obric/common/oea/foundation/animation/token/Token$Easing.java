package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\b\u0002\u0012\n\u0010\u0005\u001a\u00020\u0003\"\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Easing", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "", "", "values", "<init>", "(Ljava/lang/String;I[F)V", "[F", "getValues", "()[F", "OUI_ANIMATION_EASING_LINEAR", "OUI_ANIMATION_EASING_STANDARD", "OUI_ANIMATION_EASING_EASE", "OUI_ANIMATION_EASING_EASE_IN", "OUI_ANIMATION_EASING_EASE_OUT", "OUI_ANIMATION_EASING_EASE_IN_OUT", "OUI_ANIMATION_EASING_EASE_IN_SINE", "OUI_ANIMATION_EASING_EASE_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", "OUI_ANIMATION_EASING_EASE_IN_QUAD", "OUI_ANIMATION_EASING_EASE_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", "OUI_ANIMATION_EASING_EASE_IN_CUBIC", "OUI_ANIMATION_EASING_EASE_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", "OUI_ANIMATION_EASING_EASE_IN_QUART", "OUI_ANIMATION_EASING_EASE_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", "OUI_ANIMATION_EASING_EASE_IN_QUINT", "OUI_ANIMATION_EASING_EASE_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", "OUI_ANIMATION_EASING_EASE_IN_EXPO", "OUI_ANIMATION_EASING_EASE_OUT_EXPO", "OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Easing extends Enum<Token$Easing> {
    private static final /* synthetic */ Token$Easing[] $VALUES = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_IN_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_CUBIC = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_EXPO = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUAD = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUART = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_QUINT = null;
    public static final Token$Easing OUI_ANIMATION_EASING_EASE_OUT_SINE = null;
    public static final Token$Easing OUI_ANIMATION_EASING_LINEAR = null;
    public static final Token$Easing OUI_ANIMATION_EASING_STANDARD = null;

    @NotNull
    private final float[] values;

    static {
        Token$Easing r10 = new Token$Easing("OUI_ANIMATION_EASING_LINEAR", 0, new float[]{0.0f, 0.0f, 1.0f, 1.0f});
        OUI_ANIMATION_EASING_LINEAR = r10;
        Token$Easing r11 = new Token$Easing("OUI_ANIMATION_EASING_STANDARD", 1, new float[]{0.34f, 0.69f, 0.1f, 1.0f});
        OUI_ANIMATION_EASING_STANDARD = r11;
        Token$Easing r12 = new Token$Easing("OUI_ANIMATION_EASING_EASE", 2, new float[]{0.25f, 0.1f, 0.25f, 1.0f});
        OUI_ANIMATION_EASING_EASE = r12;
        Token$Easing r13 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN", 3, new float[]{0.42f, 0.0f, 1.0f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN = r13;
        Token$Easing r14 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT", 4, new float[]{0.0f, 0.0f, 0.58f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT = r14;
        Token$Easing r15 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT", 5, new float[]{0.42f, 0.0f, 0.58f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT = r15;
        Token$Easing r16 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_SINE", 6, new float[]{0.47f, 0.0f, 0.745f, 0.715f});
        OUI_ANIMATION_EASING_EASE_IN_SINE = r16;
        Token$Easing r17 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_SINE", 7, new float[]{0.39f, 0.575f, 0.565f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_SINE = r17;
        Token$Easing r18 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", 8, new float[]{0.445f, 0.05f, 0.55f, 0.95f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_SINE = r18;
        Token$Easing r19 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUAD", 9, new float[]{0.26f, 0.0f, 0.6f, 0.2f});
        OUI_ANIMATION_EASING_EASE_IN_QUAD = r19;
        Token$Easing r110 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUAD", 10, new float[]{0.4f, 0.8f, 0.74f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_QUAD = r110;
        Token$Easing r111 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", 11, new float[]{0.48f, 0.04f, 0.52f, 0.96f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD = r111;
        Token$Easing r112 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_CUBIC", 12, new float[]{0.4f, 0.0f, 0.68f, 0.06f});
        OUI_ANIMATION_EASING_EASE_IN_CUBIC = r112;
        Token$Easing r20 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_CUBIC", 13, new float[]{0.32f, 0.94f, 0.6f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_CUBIC = r20;
        Token$Easing r21 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", 14, new float[]{0.66f, 0.0f, 0.34f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC = r21;
        Token$Easing r22 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUART", 15, new float[]{0.52f, 0.0f, 0.74f, 0.0f});
        OUI_ANIMATION_EASING_EASE_IN_QUART = r22;
        Token$Easing r23 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUART", 16, new float[]{0.26f, 1.0f, 0.48f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_QUART = r23;
        Token$Easing r24 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", 17, new float[]{0.76f, 0.0f, 0.24f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUART = r24;
        Token$Easing r25 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_QUINT", 18, new float[]{0.64f, 0.0f, 0.78f, 0.0f});
        OUI_ANIMATION_EASING_EASE_IN_QUINT = r25;
        Token$Easing r26 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_QUINT", 19, new float[]{0.22f, 1.0f, 0.36f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_QUINT = r26;
        Token$Easing r27 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", 20, new float[]{0.84f, 0.0f, 0.16f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT = r27;
        Token$Easing r28 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_EXPO", 21, new float[]{0.66f, 0.0f, 0.86f, 0.0f});
        OUI_ANIMATION_EASING_EASE_IN_EXPO = r28;
        Token$Easing r29 = new Token$Easing("OUI_ANIMATION_EASING_EASE_OUT_EXPO", 22, new float[]{0.14f, 1.0f, 0.34f, 1.0f});
        OUI_ANIMATION_EASING_EASE_OUT_EXPO = r29;
        Token$Easing r30 = new Token$Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", 23, new float[]{0.9f, 0.0f, 0.1f, 1.0f});
        OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO = r30;
        $VALUES = new Token$Easing[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30};
    }

    private Token$Easing(String r10, int r11, float... r12) {
        super(r10, r11);
        this.values = r12;
    }

    public static Token$Easing valueOf(String r10) {
        return (Token$Easing) Enum.valueOf(Token$Easing.class, r10);
    }

    public static Token$Easing[] values() {
        return (Token$Easing[]) $VALUES.clone();
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }
}

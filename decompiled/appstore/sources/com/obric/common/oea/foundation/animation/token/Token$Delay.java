package com.obric.common.oea.foundation.animation.token;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Delay", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "", CommonKey.KEY_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "OUI_ANIMATION_DELAY_NONE", "OUI_ANIMATION_DELAY_SHORT_1", "OUI_ANIMATION_DELAY_SHORT_2", "OUI_ANIMATION_DELAY_SHORT_3", "OUI_ANIMATION_DELAY_SHORT_4", "OUI_ANIMATION_DELAY_MEDIUM_1", "OUI_ANIMATION_DELAY_MEDIUM_2", "OUI_ANIMATION_DELAY_MEDIUM_3", "OUI_ANIMATION_DELAY_MEDIUM_4", "OUI_ANIMATION_DELAY_LONG_1", "OUI_ANIMATION_DELAY_LONG_2", "OUI_ANIMATION_DELAY_LONG_3", "OUI_ANIMATION_DELAY_LONG_4", "OUI_ANIMATION_DELAY_VERY_LONG_1", "OUI_ANIMATION_DELAY_VERY_LONG_2", "OUI_ANIMATION_DELAY_VERY_LONG_3", "OUI_ANIMATION_DELAY_VERY_LONG_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Delay extends Enum<Token$Delay> {
    private static final /* synthetic */ Token$Delay[] $VALUES = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_4 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_4 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_NONE = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_4 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_4 = null;
    private final int value;

    static {
        Token$Delay r10 = new Token$Delay("OUI_ANIMATION_DELAY_NONE", 0, 0);
        OUI_ANIMATION_DELAY_NONE = r10;
        Token$Delay r11 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_1", 1, 50);
        OUI_ANIMATION_DELAY_SHORT_1 = r11;
        Token$Delay r12 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_2", 2, 100);
        OUI_ANIMATION_DELAY_SHORT_2 = r12;
        Token$Delay r13 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_3", 3, AnimationConstants.DURATION_150);
        OUI_ANIMATION_DELAY_SHORT_3 = r13;
        Token$Delay r14 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_4", 4, 200);
        OUI_ANIMATION_DELAY_SHORT_4 = r14;
        Token$Delay r15 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_1", 5, 250);
        OUI_ANIMATION_DELAY_MEDIUM_1 = r15;
        Token$Delay r16 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_2", 6, 300);
        OUI_ANIMATION_DELAY_MEDIUM_2 = r16;
        Token$Delay r17 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_3", 7, AnimationConstants.DURATION_350);
        OUI_ANIMATION_DELAY_MEDIUM_3 = r17;
        Token$Delay r18 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_4", 8, 400);
        OUI_ANIMATION_DELAY_MEDIUM_4 = r18;
        Token$Delay r19 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_1", 9, AnimationConstants.DURATION_450);
        OUI_ANIMATION_DELAY_LONG_1 = r19;
        Token$Delay r110 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_2", 10, 500);
        OUI_ANIMATION_DELAY_LONG_2 = r110;
        Token$Delay r111 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_3", 11, AnimationConstants.DURATION_550);
        OUI_ANIMATION_DELAY_LONG_3 = r111;
        Token$Delay r112 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_4", 12, 600);
        OUI_ANIMATION_DELAY_LONG_4 = r112;
        Token$Delay r20 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_1", 13, 700);
        OUI_ANIMATION_DELAY_VERY_LONG_1 = r20;
        Token$Delay r21 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_2", 14, 800);
        OUI_ANIMATION_DELAY_VERY_LONG_2 = r21;
        Token$Delay r22 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_3", 15, 900);
        OUI_ANIMATION_DELAY_VERY_LONG_3 = r22;
        Token$Delay r23 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_4", 16, 1000);
        OUI_ANIMATION_DELAY_VERY_LONG_4 = r23;
        $VALUES = new Token$Delay[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23};
    }

    private Token$Delay(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static Token$Delay valueOf(String r10) {
        return (Token$Delay) Enum.valueOf(Token$Delay.class, r10);
    }

    public static Token$Delay[] values() {
        return (Token$Delay[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

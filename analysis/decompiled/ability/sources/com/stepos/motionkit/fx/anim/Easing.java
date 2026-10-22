package com.stepos.motionkit.fx.anim;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.EasingType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/stepos/motionkit/fx/anim/Easing;", "", AppAgent.CONSTRUCT, "()V", "evaluate", "", "type", "Lcom/stepos/motionkit/EasingType;", "t", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Easing {
    public static final Easing INSTANCE = new Easing();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EasingType.values().length];
            try {
                iArr[EasingType.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EasingType.EASE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EasingType.EASE_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EasingType.EASE_IN_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EasingType.SPRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Easing() {
    }

    public final float evaluate(EasingType type, float t9) {
        k.f(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return t9;
        }
        if (i == 2) {
            return t9 * t9;
        }
        if (i == 3) {
            float f = 1.0f - t9;
            return 1.0f - (f * f);
        }
        if (i == 4) {
            if (t9 < 0.5f) {
                return 2.0f * t9 * t9;
            }
            float f7 = (t9 * (-2.0f)) + 2.0f;
            return 1.0f - ((f7 * f7) / 2.0f);
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (t9 <= 0.0f) {
            return 0.0f;
        }
        if (t9 >= 1.0f) {
            return 1.0f;
        }
        return (((float) Math.pow(2.0d, t9 * (-10.0d))) * ((float) Math.sin(((t9 * 10.0f) - 0.75f) * 2.0943952f))) + 1.0f;
    }
}

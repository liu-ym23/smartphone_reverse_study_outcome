package com.obric.common.oea.foundation.animation.token;

import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "", "propertyName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", "a", "X", "Y", "SCALE_X", "SCALE_Y", "ROTATION", "ROTATION_X", "ROTATION_Y", "TRANSLATION_X", "TRANSLATION_Y", "ALPHA", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$FloatProperty extends Enum<AnimationProperty$FloatProperty> {
    private static final /* synthetic */ AnimationProperty$FloatProperty[] $VALUES = null;
    public static final AnimationProperty$FloatProperty ALPHA = null;

    @NotNull
    public static final a Companion = null;
    public static final AnimationProperty$FloatProperty ROTATION = null;
    public static final AnimationProperty$FloatProperty ROTATION_X = null;
    public static final AnimationProperty$FloatProperty ROTATION_Y = null;
    public static final AnimationProperty$FloatProperty SCALE_X = null;
    public static final AnimationProperty$FloatProperty SCALE_Y = null;
    public static final AnimationProperty$FloatProperty TRANSLATION_X = null;
    public static final AnimationProperty$FloatProperty TRANSLATION_Y = null;
    public static final AnimationProperty$FloatProperty X = null;
    public static final AnimationProperty$FloatProperty Y = null;

    @NotNull
    private final String propertyName;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        AnimationProperty$FloatProperty r10 = new AnimationProperty$FloatProperty("X", 0, FixCard.FixStyle.KEY_X);
        X = r10;
        AnimationProperty$FloatProperty r11 = new AnimationProperty$FloatProperty("Y", 1, FixCard.FixStyle.KEY_Y);
        Y = r11;
        AnimationProperty$FloatProperty r12 = new AnimationProperty$FloatProperty("SCALE_X", 2, "scaleX");
        SCALE_X = r12;
        AnimationProperty$FloatProperty r13 = new AnimationProperty$FloatProperty("SCALE_Y", 3, "scaleY");
        SCALE_Y = r13;
        AnimationProperty$FloatProperty r14 = new AnimationProperty$FloatProperty("ROTATION", 4, "rotation");
        ROTATION = r14;
        AnimationProperty$FloatProperty r15 = new AnimationProperty$FloatProperty("ROTATION_X", 5, "rotationX");
        ROTATION_X = r15;
        AnimationProperty$FloatProperty r16 = new AnimationProperty$FloatProperty("ROTATION_Y", 6, "rotationY");
        ROTATION_Y = r16;
        AnimationProperty$FloatProperty r17 = new AnimationProperty$FloatProperty("TRANSLATION_X", 7, "translationX");
        TRANSLATION_X = r17;
        AnimationProperty$FloatProperty r18 = new AnimationProperty$FloatProperty("TRANSLATION_Y", 8, "translationY");
        TRANSLATION_Y = r18;
        AnimationProperty$FloatProperty r19 = new AnimationProperty$FloatProperty("ALPHA", 9, "alpha");
        ALPHA = r19;
        $VALUES = new AnimationProperty$FloatProperty[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        Companion = new a(null);
    }

    private AnimationProperty$FloatProperty(String r10, int r11, String r12) {
        super(r10, r11);
        this.propertyName = r12;
    }

    public static AnimationProperty$FloatProperty valueOf(String r10) {
        return (AnimationProperty$FloatProperty) Enum.valueOf(AnimationProperty$FloatProperty.class, r10);
    }

    public static AnimationProperty$FloatProperty[] values() {
        return (AnimationProperty$FloatProperty[]) $VALUES.clone();
    }

    @NotNull
    public final String getPropertyName() {
        return this.propertyName;
    }
}

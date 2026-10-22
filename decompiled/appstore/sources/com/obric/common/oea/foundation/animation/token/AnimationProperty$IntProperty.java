package com.obric.common.oea.foundation.animation.token;

import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"com/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty", "", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "", "propertyName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getPropertyName", "()Ljava/lang/String;", "Companion", "a", "BACKGROUND_COLOR", "TEXT_COLOR", "STROKE_COLOR", "FILL_COLOR", "WIDTH", "HEIGHT", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationProperty$IntProperty extends Enum<AnimationProperty$IntProperty> {
    private static final /* synthetic */ AnimationProperty$IntProperty[] $VALUES = null;
    public static final AnimationProperty$IntProperty BACKGROUND_COLOR = null;

    @NotNull
    public static final a Companion = null;
    public static final AnimationProperty$IntProperty FILL_COLOR = null;
    public static final AnimationProperty$IntProperty HEIGHT = null;
    public static final AnimationProperty$IntProperty STROKE_COLOR = null;
    public static final AnimationProperty$IntProperty TEXT_COLOR = null;
    public static final AnimationProperty$IntProperty WIDTH = null;

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
        AnimationProperty$IntProperty r10 = new AnimationProperty$IntProperty("BACKGROUND_COLOR", 0, "backgroundColor");
        BACKGROUND_COLOR = r10;
        AnimationProperty$IntProperty r11 = new AnimationProperty$IntProperty("TEXT_COLOR", 1, "textColor");
        TEXT_COLOR = r11;
        AnimationProperty$IntProperty r12 = new AnimationProperty$IntProperty("STROKE_COLOR", 2, "strokeColor");
        STROKE_COLOR = r12;
        AnimationProperty$IntProperty r13 = new AnimationProperty$IntProperty("FILL_COLOR", 3, "fillColor");
        FILL_COLOR = r13;
        AnimationProperty$IntProperty r14 = new AnimationProperty$IntProperty("WIDTH", 4, Style.KEY_WIDTH);
        WIDTH = r14;
        AnimationProperty$IntProperty r15 = new AnimationProperty$IntProperty("HEIGHT", 5, Style.KEY_HEIGHT);
        HEIGHT = r15;
        $VALUES = new AnimationProperty$IntProperty[]{r10, r11, r12, r13, r14, r15};
        Companion = new a(null);
    }

    private AnimationProperty$IntProperty(String r10, int r11, String r12) {
        super(r10, r11);
        this.propertyName = r12;
    }

    public static AnimationProperty$IntProperty valueOf(String r10) {
        return (AnimationProperty$IntProperty) Enum.valueOf(AnimationProperty$IntProperty.class, r10);
    }

    public static AnimationProperty$IntProperty[] values() {
        return (AnimationProperty$IntProperty[]) $VALUES.clone();
    }

    @NotNull
    public final String getPropertyName() {
        return this.propertyName;
    }
}

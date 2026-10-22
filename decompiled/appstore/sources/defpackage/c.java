package defpackage;

import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6017a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f6018b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f6019c = null;

    static {
        int[] r10 = new int[AnimationProperty$FloatProperty.values().length];
        f6017a = r10;
        r10[AnimationProperty$FloatProperty.X.ordinal()] = 1;
        r10[AnimationProperty$FloatProperty.Y.ordinal()] = 2;
        r10[AnimationProperty$FloatProperty.SCALE_X.ordinal()] = 3;
        r10[AnimationProperty$FloatProperty.SCALE_Y.ordinal()] = 4;
        r10[AnimationProperty$FloatProperty.ROTATION.ordinal()] = 5;
        r10[AnimationProperty$FloatProperty.TRANSLATION_X.ordinal()] = 6;
        r10[AnimationProperty$FloatProperty.TRANSLATION_Y.ordinal()] = 7;
        r10[AnimationProperty$FloatProperty.ROTATION_X.ordinal()] = 8;
        r10[AnimationProperty$FloatProperty.ROTATION_Y.ordinal()] = 9;
        r10[AnimationProperty$FloatProperty.ALPHA.ordinal()] = 10;
        int[] r11 = new int[AnimationProperty$IntProperty.values().length];
        f6018b = r11;
        AnimationProperty$IntProperty r12 = AnimationProperty$IntProperty.BACKGROUND_COLOR;
        r11[r12.ordinal()] = 1;
        AnimationProperty$IntProperty r13 = AnimationProperty$IntProperty.TEXT_COLOR;
        r11[r13.ordinal()] = 2;
        AnimationProperty$IntProperty r14 = AnimationProperty$IntProperty.STROKE_COLOR;
        r11[r14.ordinal()] = 3;
        AnimationProperty$IntProperty r15 = AnimationProperty$IntProperty.FILL_COLOR;
        r11[r15.ordinal()] = 4;
        r11[AnimationProperty$IntProperty.WIDTH.ordinal()] = 5;
        r11[AnimationProperty$IntProperty.HEIGHT.ordinal()] = 6;
        int[] r16 = new int[AnimationProperty$IntProperty.values().length];
        f6019c = r16;
        r16[r12.ordinal()] = 1;
        r16[r13.ordinal()] = 2;
        r16[r14.ordinal()] = 3;
        r16[r15.ordinal()] = 4;
    }
}

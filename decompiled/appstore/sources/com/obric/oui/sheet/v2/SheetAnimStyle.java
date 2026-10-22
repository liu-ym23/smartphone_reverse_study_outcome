package com.obric.oui.sheet.v2;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$id;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$DoubleRef;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class SheetAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SheetAnimStyle f16915a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "", "maxRatio", "", "(Ljava/lang/String;IF)V", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        private static final /* synthetic */ HeightLevel[] $values() {
            return new HeightLevel[]{SMALL, MEDIUM, LARGE};
        }

        static {
            SMALL = new HeightLevel("SMALL", 0, 0.4f);
            MEDIUM = new HeightLevel("MEDIUM", 1, 0.8f);
            LARGE = new HeightLevel("LARGE", 2, 1.0f);
            $VALUES = $values();
        }

        private HeightLevel(String r10, int r11, float r12) {
            super(r10, r11);
            this.maxRatio = r12;
        }

        public static HeightLevel valueOf(String r10) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r10);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) $VALUES.clone();
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }
    }

    static {
        f16915a = new SheetAnimStyle();
    }

    public SheetAnimStyle() {
    }

    public static final /* synthetic */ void a(SheetAnimStyle r10, View r11, float r12, float r13, float r14) {
        r10.s(r11, r12, r13, r14);
    }

    public static final /* synthetic */ void b(SheetAnimStyle r10, Window r11, float r12, float r13, float r14) {
        r10.t(r11, r12, r13, r14);
    }

    public static /* synthetic */ float e(SheetAnimStyle r10, float r11, float r12, double r13, double r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L5;
        r13 = 0.5d;
    L5:
        double r17 = r13;
        if ((r15 & 8) == 0) goto L9;
        r14 = 0.1d;
    L9:
        return r10.d(r11, r12, r17, r14);
    }

    public static final float f(Ref$DoubleRef r10, double r11, float r12, float r13) {
        double r14 = Math.abs(r13);
        double r15 = r10.element;
        if (r14 > r15) goto L5;
        return r12;
    L5:
        double r16 = r13;
        double r17 = 1000;
        double r18 = (Math.log(Math.abs(r15 / r16)) / r11) * r17;
        double r19 = r16 / r11;
        return (float) ((((double) r12) - r19) + (r19 * Math.exp((r11 * r18) / r17)));
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.builder.b.a l(SheetAnimStyle r10, View r11, Window r12, View r13, boolean r14, boolean r15, float r16, Runnable r17, Integer r18, int r19, Object r110) {
        Integer r20 = null;
        if ((r19 & 1) == 0) goto L5;
        Window r21 = null;
    L7:
        if ((r19 & 2) == 0) goto L9;
        View r22 = null;
    L10:
        boolean r23 = true;
        if ((r19 & 4) == 0) goto L13;
        boolean r24 = true;
    L15:
        if ((r19 & 8) != 0) goto L19;
        r23 = r15;
    L19:
        if ((r19 & 16) == 0) goto L21;
        float r25 = 0.0f;
    L23:
        if ((r19 & 32) == 0) goto L25;
        Runnable r26 = null;
    L27:
        if ((r19 & 64) != 0) goto L31;
        r20 = r18;
    L31:
        return r10.k(r11, r21, r22, r24, r23, r25, r26, r20);
    L25:
        r26 = r17;
        goto L27
    L21:
        r25 = r16;
        goto L23
    L13:
        r24 = r14;
        goto L15
    L9:
        r22 = r13;
        goto L10
    L5:
        r21 = r12;
        goto L7
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.builder.b.a n(SheetAnimStyle r10, View r11, Window r12, View r13, boolean r14, boolean r15, float r16, float r17, Integer r18, int r19, Object r110) {
        Integer r20 = null;
        if ((r19 & 1) == 0) goto L5;
        Window r21 = null;
    L7:
        if ((r19 & 2) == 0) goto L9;
        View r22 = null;
    L10:
        boolean r23 = true;
        if ((r19 & 4) == 0) goto L13;
        boolean r24 = true;
    L15:
        if ((r19 & 8) != 0) goto L19;
        r23 = r15;
    L19:
        if ((r19 & 16) == 0) goto L21;
        float r25 = 0.6f;
    L23:
        if ((r19 & 32) == 0) goto L25;
        float r26 = 0.0f;
    L27:
        if ((r19 & 64) != 0) goto L31;
        r20 = r18;
    L31:
        return r10.m(r11, r21, r22, r24, r23, r25, r26, r20);
    L25:
        r26 = r17;
        goto L27
    L21:
        r25 = r16;
        goto L23
    L13:
        r24 = r14;
        goto L15
    L9:
        r22 = r13;
        goto L10
    L5:
        r21 = r12;
        goto L7
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.builder.b.a p(SheetAnimStyle r10, View r11, Window r12, View r13, boolean r14, boolean r15, float r16, Integer r17, int r18, Object r19) {
        Integer r20 = null;
        if ((r18 & 1) == 0) goto L5;
        Window r21 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        View r22 = null;
    L10:
        boolean r23 = true;
        if ((r18 & 4) == 0) goto L13;
        boolean r24 = true;
    L15:
        if ((r18 & 8) != 0) goto L19;
        r23 = r15;
    L19:
        if ((r18 & 16) == 0) goto L21;
        float r25 = 0.6f;
    L23:
        if ((r18 & 32) != 0) goto L27;
        r20 = r17;
    L27:
        return r10.o(r11, r21, r22, r24, r23, r25, r20);
    L21:
        r25 = r16;
        goto L23
    L13:
        r24 = r14;
        goto L15
    L9:
        r22 = r13;
        goto L10
    L5:
        r21 = r12;
        goto L7
    }

    public static /* synthetic */ boolean r(SheetAnimStyle r10, View r11, float r12, float r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = 0.333333f;
    L6:
        return r10.q(r11, r12, r13);
    }

    public final void c(View r10) {
        q.g(r10, "container");
        int r11 = tc.f.r(r10, 10);
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13.topMargin >= r11) goto L7;
        r13.topMargin = r11;
    L7:
        r10.setLayoutParams(r12);
    }

    public final float d(float r10, float r11, double r12, double r13) {
        Ref$DoubleRef r14 = new Ref$DoubleRef();
        r14.element = bg.h.b(1.0E-7d, Math.abs(r13));
        return f(r14, bg.h.b(1.0E-4d, r12) * (-4.2d), r10, r11);
    }

    public final float g(float r10) {
        return (float) Math.pow(6.283185307179586d / ((double) r10), 2.0d);
    }

    public final void h(View r10, int r11) {
        q.g(r10, "<this>");
        r10.setTag(r11, null);
    }

    public final Pair i(float r10, boolean r11) {
        float r12 = 1.0f - Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH.getBounce();
        if (r11 == false) goto L7;
        return new Pair(Float.valueOf(r12), Float.valueOf(g(td.b.e(r10, 0.3f, 0.6f, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_1.getDuration() / 1000.0f, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3.getDuration() / 1000.0f))));
    L7:
        return new Pair(Float.valueOf(r12), Float.valueOf(g(td.b.e(r10, 0.3f, 0.6f, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration() / 1000.0f, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2.getDuration() / 1000.0f))));
    }

    public final com.obric.common.oea.foundation.animation.builder.b.a j(View r10, int r11) {
        td.c r12 = td.c.f24796a;
        Object r13 = r10.getTag(r11);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L7:
        com.obric.common.oea.foundation.animation.builder.b.a r14 = (com.obric.common.oea.foundation.animation.builder.b.a) r13;
        if (r14 != null) goto L11;
        com.obric.common.oea.foundation.animation.builder.b.a r15 = new com.obric.common.oea.foundation.animation.builder.b.a(r10);
        r10.setTag(r11, r15);
        return r15;
    L11:
        return r14;
    L6:
        if ((r13 instanceof com.obric.common.oea.foundation.animation.builder.b.a) == false) goto L4;
        goto L4
    }

    public final com.obric.common.oea.foundation.animation.builder.b.a k(final View r20, final Window r21, final View r22, final boolean r23, final boolean r24, float r25, final Runnable r26, Integer r27) {
        q.g(r20, "<this>");
        if (r27 != null) goto L6;
        int r10 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L5:
        int r11 = r10;
        if (r23 == false) goto L15;
        if (r24 == false) goto L15;
        if (r21 == null) goto L15;
        r21.addFlags(2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.w("SheetAnimStyle", q.p("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L15:
        int r12 = r20.getHeight() + tc.f.r(r20, 32);
        Pair r13 = i(r20.getHeight() / r11, false);
        float r14 = ((Number) r13.component1()).floatValue();
        float r15 = ((Number) r13.component2()).floatValue();
        final float r16 = r20.getTranslationY();
        final float r17 = r12;
        final float r18 = 0.0f;
        if (r24 == false) goto L23;
        if (r21 == null) goto L26;
        WindowManager.LayoutParams r19 = r21.getAttributes();
        if (r19 == null) goto L26;
        r18 = r19.dimAmount;
    L26:
        com.obric.common.oea.foundation.animation.builder.b.a r110 = j(r20, R$id.o_dialog_anim_out);
        AnimationProperty$FloatProperty r111 = AnimationProperty$FloatProperty.TRANSLATION_Y;
        float r28 = r20.getTranslationY();
        com.obric.common.oea.foundation.animation.spec.spring.b r29 = kb.a.c(r14, r15, 0, 4, null);
        r29.e(1.0f);
        final float r30 = 0.0f;
        com.obric.common.oea.foundation.animation.builder.b.a r31 = r110.d(r111, Float.valueOf(r28), r17, r29, Float.valueOf(r25)).g(new SheetAnimStyle$sheetHide$animBuilder$2(r23, r24, r21, r16, r17, r18, r30, r22, r20, r26));
        com.obric.oui.animation.style.a.b(r20);
        return r31;
    L23:
        if (r22 == null) goto L26;
        r18 = r22.getAlpha();
        goto L26
    L6:
        r10 = r27.intValue();
        goto L5
    }

    public final com.obric.common.oea.foundation.animation.builder.b.a m(View r16, final Window r17, final View r18, final boolean r19, final boolean r20, final float r21, float r22, Integer r23) {
        q.g(r16, "<this>");
        if (r23 != null) goto L5;
        int r10 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        r16.setAlpha(1.0f);
        float r11 = 0.0f;
        if (r20 == false) goto L14;
        if (r17 != null) goto L10;
    L9:
        final float r12 = r11;
        Pair r13 = i(r16.getHeight() / r10, true);
        float r14 = ((Number) r13.component1()).floatValue();
        float r15 = ((Number) r13.component2()).floatValue();
        if (r19 == false) goto L26;
        if (r20 == false) goto L26;
        if (r17 == null) goto L26;
        r17.addFlags(2);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w("SheetAnimStyle", q.p("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L26:
        final float r24 = r16.getTranslationY();
        com.obric.common.oea.foundation.animation.builder.b.a r25 = j(r16, R$id.o_dialog_anim_in);
        AnimationProperty$FloatProperty r110 = AnimationProperty$FloatProperty.TRANSLATION_Y;
        float r26 = r16.getTranslationY();
        com.obric.common.oea.foundation.animation.spec.spring.b r111 = kb.a.c(r14, r15, 0, 4, null);
        r111.e(1.0f);
        final float r27 = 0.0f;
        return r25.d(r110, Float.valueOf(r26), 0.0f, r111, Float.valueOf(r22)).g(new SheetAnimStyle$sheetPositionSmoothReset$2(r19, r20, r17, r24, r27, r12, r21, r18));
    L10:
        WindowManager.LayoutParams r28 = r17.getAttributes();
        if (r28 == null) goto L9;
        r11 = r28.dimAmount;
        goto L9
    L14:
        if (r18 == null) goto L9;
        r11 = r18.getAlpha();
        goto L9
    L5:
        r10 = r23.intValue();
        goto L6
    }

    public final com.obric.common.oea.foundation.animation.builder.b.a o(View r17, final Window r18, final View r19, final boolean r20, final boolean r21, final float r22, Integer r23) {
        q.g(r17, "<this>");
        if (r23 != null) goto L6;
        int r10 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L5:
        int r11 = r10;
        if (r20 == false) goto L15;
        if (r21 == false) goto L15;
        if (r18 == null) goto L15;
        r18.addFlags(2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.w("SheetAnimStyle", q.p("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L15:
        int r12 = r17.getHeight() + tc.f.r(r17, 32);
        r17.setAlpha(1.0f);
        final float r13 = r12;
        r17.setTranslationY(r13);
        Pair r14 = i(r17.getHeight() / r11, true);
        float r15 = ((Number) r14.component1()).floatValue();
        float r16 = ((Number) r14.component2()).floatValue();
        final float r24 = tc.f.r(r17, 2);
        com.obric.common.oea.foundation.animation.builder.b.a r25 = j(r17, R$id.o_dialog_anim_in);
        AnimationProperty$FloatProperty r26 = AnimationProperty$FloatProperty.TRANSLATION_Y;
        Float r110 = Float.valueOf(r13);
        com.obric.common.oea.foundation.animation.spec.spring.b r111 = kb.a.c(r15, r16, 0, 4, null);
        r111.e(1.0f);
        Unit r27 = Unit.f21064a;
        return com.obric.common.oea.foundation.animation.builder.b.a.e(r25, r26, r110, r24, r111, null, 16, null).g(new SheetAnimStyle$sheetShow$2(r20, r21, r18, r13, r24, r22, r19));
    L6:
        r10 = r23.intValue();
        goto L5
    }

    public final boolean q(View r12, float r13, float r14) {
        q.g(r12, "view");
        if ((r12.getTranslationY() / r12.getHeight()) <= r14) goto L6;
        return true;
    L6:
        if ((e(this, r12.getTranslationY(), r13, 0.0d, 0.0d, 12, null) / r12.getHeight()) > r14) goto L10;
        return false;
    L10:
        return true;
    }

    public final void s(View r10, float r11, float r12, float r13) {
        float r14 = r13 - r12;     // Catch: Exception -> L5
        r10.setAlpha(r12 + (r14 * bg.h.j(r11, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", q.p("updateDimViewWithAnim: ", e.getMessage()));
    }

    public final void t(Window r10, float r11, float r12, float r13) {
        float r14 = r13 - r12;     // Catch: Exception -> L5
        r10.setDimAmount(r12 + (r14 * bg.h.j(r11, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", q.p("updateWindowDimWithAnim: ", e.getMessage()));
    }
}

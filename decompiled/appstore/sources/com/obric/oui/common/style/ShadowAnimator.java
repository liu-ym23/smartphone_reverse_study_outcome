package com.obric.oui.common.style;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class ShadowAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShadowAnimator f13069a = null;

    static {
        f13069a = new ShadowAnimator();
    }

    public ShadowAnimator() {
    }

    public static final void a(final OUILayoutHelper r10, final List r11, final List r12) {
        q.g(r10, "ouiLayout");
        q.g(r11, "oldShadow");
        q.g(r12, "newShadow");
        com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), 0.0f, 1.0f, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4, 0, 4, null), null, 8, null).g(new ShadowAnimator$startAnim$1(r11, r12, r10)).f(new ShadowAnimator$startAnim$2(r10, r12)).c().a();
    }

    public static final void b(final OUILayoutHelper r10, final List r11, final List r12) {
        q.g(r10, "ouiLayout");
        q.g(r11, "oldShadow");
        q.g(r12, "newShadow");
        com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), 0.0f, 1.0f, kb.a.e(Token$Duration.OUI_ANIMATION_DURATION_SHORT_2, Token$Delay.OUI_ANIMATION_DELAY_NONE, Token$Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 8, null).g(new ShadowAnimator$startVisibilityAnim$1(r11, r12, r10)).f(new ShadowAnimator$startVisibilityAnim$2(r10, r12)).c().a();
    }

    public static final jb.d c(final View r24, final float r25, final float r26, final List r27, final List r28) {
        q.g(r24, "view");
        com.obric.common.oea.foundation.animation.builder.b.a r10 = com.obric.common.oea.foundation.animation.builder.c.b(r24, 0.0f, 1, null);
        AnimationProperty$FloatProperty r11 = AnimationProperty$FloatProperty.SCALE_X;
        Float r12 = Float.valueOf(r24.getScaleX());
        Token$Bounce r13 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r14 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r15 = kb.a.d(r13, r14, 0, 4, null);
        r15.e(0.01f);
        Unit r16 = Unit.f21064a;
        com.obric.common.oea.foundation.animation.builder.b.a r17 = com.obric.common.oea.foundation.animation.builder.b.a.e(r10, r11, r12, r26, r15, null, 16, null);
        AnimationProperty$FloatProperty r18 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r19 = Float.valueOf(r24.getScaleY());
        com.obric.common.oea.foundation.animation.spec.spring.b r20 = kb.a.d(r13, r14, 0, 4, null);
        r20.e(0.01f);
        return com.obric.common.oea.foundation.animation.builder.b.b(com.obric.common.oea.foundation.animation.builder.b.a.e(r17, r18, r19, r26, r20, null, 16, null).g(new ShadowAnimator$startWithScaleAnimation$3(r25, r26, r27, r28, r24)).f(new ShadowAnimator$startWithScaleAnimation$4(r24, r28)).b(), null, null, 3, null);
    }
}

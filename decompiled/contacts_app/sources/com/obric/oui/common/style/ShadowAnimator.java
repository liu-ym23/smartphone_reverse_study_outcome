package com.obric.oui.common.style;

import android.view.View;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.utils.AnimUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ShadowAnimator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/common/style/ShadowAnimator;", "", "()V", "getInterpolatedShadow", "", "Lcom/obric/oui/common/style/Shadow;", "rawFraction", "", "shadow0", "shadow1", "startAnim", "", "ouiLayout", "Lcom/obric/oui/common/style/OUILayoutHelper;", "oldShadow", "newShadow", "startWithScaleAnimation", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "view", "Landroid/view/View;", "startScale", "targetScale", "shadowsFrom", "shadowsTo", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShadowAnimator {
    public static final ShadowAnimator INSTANCE = null;

    static {
        INSTANCE = new ShadowAnimator();
    }

    private ShadowAnimator() {
    }

    @JvmStatic
    public static final void startAnim(final OUILayoutHelper r8, final List<Shadow> r9, final List<Shadow> r10) {
        Intrinsics.checkNotNullParameter(r8, "ouiLayout");
        Intrinsics.checkNotNullParameter(r9, "oldShadow");
        Intrinsics.checkNotNullParameter(r10, "newShadow");
        ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), 0.0f, 1.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4, 0, 4, null), null, 8, null).onUpdate(new AnonymousClass1(r9, r10, r8)).onEnd(new AnonymousClass2(r8, r10)).build().start();
    }

    @JvmStatic
    public static final AnimationManager startWithScaleAnimation(final View r24, final float r25, final float r26, final List<Shadow> r27, final List<Shadow> r28) {
        Intrinsics.checkNotNullParameter(r24, "view");
        PropertyAnimatable.Builder r8 = PropertyAnimatableKt.animator$default(r24, 0.0f, 1, null);
        AnimationProperty.FloatProperty r9 = AnimationProperty.FloatProperty.SCALE_X;
        Float r10 = Float.valueOf(r24.getScaleX());
        FloatSpringSpec r0 = AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r0.setAccuracy(0.01f);
        Unit r4 = Unit.INSTANCE;
        PropertyAnimatable.Builder r16 = PropertyAnimatable.Builder.of$default(r8, r9, r10, r26, r0, null, 16, null);
        AnimationProperty.FloatProperty r17 = AnimationProperty.FloatProperty.SCALE_Y;
        Float r18 = Float.valueOf(r24.getScaleY());
        FloatSpringSpec r1 = AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r1.setAccuracy(0.01f);
        Unit r2 = Unit.INSTANCE;
        return PropertyAnimatable.start$default(PropertyAnimatable.Builder.of$default(r16, r17, r18, r26, r1, null, 16, null).onUpdate(new AnonymousClass3(r25, r26, r27, r28, r24)).onEnd(new AnonymousClass4(r24, r28)).build(), null, null, 3, null);
    }

    @Deprecated(message = "use Shadow.getShadowForTransition instead")
    @JvmStatic
    public static final List<Shadow> getInterpolatedShadow(float r16, List<Shadow> r17, List<Shadow> r18) {
        float r0 = RangesKt.coerceIn(r16, 0.0f, 1.0f);
        if (r17 == null) goto L15;
        if (r18 == null) goto L15;
        if (r17.size() != r18.size()) goto L15;
        List<Shadow> r1 = r17;
        Iterator<T> r2 = r1.iterator();
        List<Shadow> r3 = r18;
        Iterator<T> r4 = r3.iterator();
        ArrayList r5 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r1, 10), CollectionsKt.collectionSizeOrDefault(r3, 10)));
    L9:
        if (r2.hasNext() == false) goto L18;
        if (r4.hasNext() == false) goto L18;
        Object r6 = r2.next();
        Shadow r7 = (Shadow) r4.next();
        Shadow r8 = (Shadow) r6;
        r5.add(new Shadow(AnimUtils.evaluateColor(r0, r8.getColor(), r7.getColor()), AnimUtils.lerp(r8.getRadius(), r7.getRadius(), r0), AnimUtils.lerp(r8.getOffsetX(), r7.getOffsetX(), r0), AnimUtils.lerp(r8.getOffsetY(), r7.getOffsetY(), r0), AnimUtils.lerp(r8.getSpread(), r7.getSpread(), r0), null, 0.0f, 96, null));
    L18:
        return r5;
    L15:
        return r17;
    }
}

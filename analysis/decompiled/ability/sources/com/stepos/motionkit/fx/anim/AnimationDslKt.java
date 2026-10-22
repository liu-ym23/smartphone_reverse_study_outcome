package com.stepos.motionkit.fx.anim;

import S7.k;
import com.stepos.motionkit.AnimationDefinition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/anim/AnimationBuilder;", "LC7/r;", "block", "Lcom/stepos/motionkit/AnimationDefinition;", "animation", "(LS7/k;)Lcom/stepos/motionkit/AnimationDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AnimationDslKt {
    public static final AnimationDefinition animation(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        AnimationBuilder animationBuilder = new AnimationBuilder();
        block.invoke(animationBuilder);
        return animationBuilder.build$motionkit_fx_release();
    }
}

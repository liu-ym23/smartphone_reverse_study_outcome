package com.stepos.motionkit.fx;

import S7.k;
import androidx.autofill.HintConstants;
import com.stepos.motionkit.EffectDefinition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/EffectBuilder;", "LC7/r;", "block", "Lcom/stepos/motionkit/EffectDefinition;", "effect", "(Ljava/lang/String;LS7/k;)Lcom/stepos/motionkit/EffectDefinition;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EffectBuilderKt {
    public static final EffectDefinition effect(String name, k block) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(block, "block");
        EffectBuilder effectBuilder = new EffectBuilder(name);
        block.invoke(effectBuilder);
        return effectBuilder.build$motionkit_fx_release();
    }
}

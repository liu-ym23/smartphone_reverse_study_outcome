package com.obric.common.oea.style.scene.qsanim.morph;

import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "anim", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation;", CommonKey.KEY_VALUE, "", "velocity", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelper$heightUpdateListener$1 extends Lambda implements Function3<DynamicAnimation, Float, Float, Unit> {
    final /* synthetic */ a this$0;

    public ViewMorphAnimHelper$heightUpdateListener$1(a r10) {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(DynamicAnimation r10, Float r11, Float r12) {
        invoke(r10, r11.floatValue(), r12.floatValue());
        return Unit.f21064a;
    }

    public final void invoke(@NotNull DynamicAnimation r10, float r11, float r12) {
        q.g(r10, "anim");
        throw null;
    }
}

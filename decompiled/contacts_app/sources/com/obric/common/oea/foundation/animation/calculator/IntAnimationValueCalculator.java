package com.obric.common.oea.foundation.animation.calculator;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntAnimationValueCalculator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0002\u0010\rJ6\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/IntAnimationValueCalculator;", "Lcom/obric/common/oea/foundation/animation/calculator/AnimationValueCalculator;", "", "()V", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "(JIIFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)Ljava/lang/Integer;", "getVelocityFromNanos", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class IntAnimationValueCalculator implements AnimationValueCalculator<Integer> {
    public static final IntAnimationValueCalculator INSTANCE = null;

    static {
        INSTANCE = new IntAnimationValueCalculator();
    }

    private IntAnimationValueCalculator() {
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public /* bridge */ /* synthetic */ Integer getValueFromNanos(long r8, Integer r10, Integer r11, float r12, AnimationSpec<Integer> r13) {
        return getValueFromNanos(r8, r10.intValue(), r11.intValue(), r12, r13);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r8, Integer r10, Integer r11, float r12, AnimationSpec<Integer> r13) {
        return getVelocityFromNanos(r8, r10.intValue(), r11.intValue(), r12, r13);
    }

    public Integer getValueFromNanos(long r7, int r9, int r10, float r11, AnimationSpec<Integer> r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        return r12.getValueFromNanos(r7, Integer.valueOf(r9), Integer.valueOf(r10), r11);
    }

    public float getVelocityFromNanos(long r7, int r9, int r10, float r11, AnimationSpec<Integer> r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        return r12.getVelocityFromNanos(r7, Integer.valueOf(r9), Integer.valueOf(r10), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator
    public boolean isFinishedFromNanos(long r1, long r3, AnimationSpec<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "spec");
        return r5.isFinishedFromNanos(r1, r3);
    }
}

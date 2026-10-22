package com.obric.common.oea.foundation.animation.calculator;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J;\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¢\u0006\u0002\u0010\fJ;\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/AnimationValueCalculator;", "T", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "(JLjava/lang/Object;Ljava/lang/Object;FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)Ljava/lang/Object;", "getVelocityFromNanos", "(JLjava/lang/Object;Ljava/lang/Object;FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)F", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface AnimationValueCalculator<T> {
    T getValueFromNanos(long r10, T r11, T r12, float r13, @NotNull AnimationSpec<T> r14);

    float getVelocityFromNanos(long r10, T r11, T r12, float r13, @NotNull AnimationSpec<T> r14);

    boolean isFinishedFromNanos(long r10, long r11, @NotNull AnimationSpec<T> r12);
}

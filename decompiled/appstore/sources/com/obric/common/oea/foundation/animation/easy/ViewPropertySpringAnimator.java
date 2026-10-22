package com.obric.common.oea.foundation.animation.easy;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewPropertySpringAnimator {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", "T", "Landroid/view/View;", "", "onAnimationCancel", "", "animator", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "onAnimationEnd", "onAnimationStart", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface AnimatorListener<T extends View> {
        void onAnimationCancel(@NotNull ViewPropertySpringAnimator r10);

        void onAnimationEnd(@NotNull ViewPropertySpringAnimator r10);

        void onAnimationStart(@NotNull ViewPropertySpringAnimator r10);
    }
}

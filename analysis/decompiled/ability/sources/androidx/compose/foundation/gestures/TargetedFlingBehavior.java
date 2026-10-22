package androidx.compose.foundation.gestures;

import H7.c;
import S7.k;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;

@Stable
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\b\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "Landroidx/compose/foundation/gestures/ScrollScope;", "", "initialVelocity", "Lkotlin/Function1;", "LC7/r;", "onRemainingDistanceUpdated", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLS7/k;LH7/c;)Ljava/lang/Object;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLH7/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TargetedFlingBehavior extends FlingBehavior {
    static /* synthetic */ Object performFling$suspendImpl(TargetedFlingBehavior targetedFlingBehavior, ScrollScope scrollScope, float f, c<? super Float> cVar) {
        return targetedFlingBehavior.performFling(scrollScope, f, TargetedFlingBehaviorKt.NoOnReport, cVar);
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    default Object performFling(ScrollScope scrollScope, float f, c<? super Float> cVar) {
        return performFling$suspendImpl(this, scrollScope, f, cVar);
    }

    Object performFling(ScrollScope scrollScope, float f, k kVar, c<? super Float> cVar);
}

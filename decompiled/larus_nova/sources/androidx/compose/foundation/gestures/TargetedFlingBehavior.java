package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\tJ\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingDistanceUpdated", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TargetedFlingBehavior extends FlingBehavior {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TargetedFlingBehavior$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$performFling(TargetedFlingBehavior r100, ScrollScope r101, float r102, Continuation r103) {
            return performFling$suspendImpl(r100, r101, r102, r103);
        }

        public static /* synthetic */ Object performFling$suspendImpl(TargetedFlingBehavior r100, ScrollScope r101, float r102, Continuation<? super Float> r103) {
            return r100.performFling(r101, r102, TargetedFlingBehaviorKt.access$getNoOnReport$p(), r103);
        }
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    Object performFling(ScrollScope r100, float r101, Continuation<? super Float> r102);

    Object performFling(ScrollScope r100, float r101, Function1<? super Float, Unit> r102, Continuation<? super Float> r103);
}

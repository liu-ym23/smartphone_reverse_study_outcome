package androidx.compose.foundation.text.selection;

import C7.r;
import D7.v;
import J7.c;
import S7.n;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;

@c(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1", f = "SelectionGestures.kt", l = {277}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/selection/DownResolution;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 extends RestrictedSuspendLambda implements n {
    final /* synthetic */ Ref$LongRef $overSlop;
    final /* synthetic */ long $pointerId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(long j5, Ref$LongRef ref$LongRef, H7.c<? super SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1> cVar) {
        super(2, cVar);
        this.$pointerId = j5;
        this.$overSlop = ref$LongRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(this.$pointerId, this.$overSlop, cVar);
        selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1.L$0 = obj;
        return selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1;
    }

    @Override // S7.n
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super DownResolution> cVar) {
        return ((SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            long j5 = this.$pointerId;
            final Ref$LongRef ref$LongRef = this.$overSlop;
            n nVar = new n() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$firstDragPastSlop$1
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    m1386invokeUv8p0NA((PointerInputChange) obj2, ((Offset) obj3).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m1386invokeUv8p0NA(PointerInputChange pointerInputChange, long j6) {
                    pointerInputChange.consume();
                    ref$LongRef.f4919a = j6;
                }
            };
            this.L$0 = awaitPointerEventScope2;
            this.label = 1;
            Object objM425awaitTouchSlopOrCancellationjO51t88 = DragGestureDetectorKt.m425awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, j5, nVar, this);
            if (objM425awaitTouchSlopOrCancellationjO51t88 == coroutineSingletons) {
                return coroutineSingletons;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj = objM425awaitTouchSlopOrCancellationjO51t88;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            kotlin.b.b(obj);
        }
        if (((PointerInputChange) obj) != null && OffsetKt.m3914isSpecifiedk4lQ0M(this.$overSlop.f4919a)) {
            return DownResolution.Drag;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) v.A0(awaitPointerEventScope.getCurrentEvent().getChanges());
        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            return DownResolution.Cancel;
        }
        pointerInputChange.consume();
        return DownResolution.Up;
    }
}

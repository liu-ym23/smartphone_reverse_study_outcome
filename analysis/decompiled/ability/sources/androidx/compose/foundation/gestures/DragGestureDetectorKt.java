package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\n\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u0010\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001ad\u0010\u0019\u001a\u00020\u0006*\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0082\u0001\u0010\u0019\u001a\u00020\u0006*\u00020\u00142\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0080@¢\u0006\u0004\b\u0019\u0010\u001e\u001ad\u0010\u001f\u001a\u00020\u0006*\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086@¢\u0006\u0004\b\u001f\u0010\u001a\u001a;\u0010\"\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\t\u001aC\u0010'\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010$\u001a\u00020#2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a3\u0010)\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010\u000f\u001a!\u0010+\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0012\u001ad\u0010-\u001a\u00020\u0006*\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0003H\u0086@¢\u0006\u0004\b-\u0010\u001a\u001a;\u0010/\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010\t\u001aC\u00102\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010$\u001a\u00020#2\u0018\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b1\u0010&\u001a3\u00104\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u000f\u001a!\u00106\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u0010\u0012\u001ad\u00108\u001a\u00020\u0006*\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u0003H\u0086@¢\u0006\u0004\b8\u0010\u001a\u001aS\u0010\u0010\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b2\b\u00109\u001a\u0004\u0018\u00010\u001c2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u000bH\u0080Hø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a5\u0010?\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u000bH\u0082Hø\u0001\u0000¢\u0006\u0004\b>\u0010\u000f\u001aM\u0010B\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010$\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u001c2\u0018\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0082Hø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a!\u0010D\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\bC\u0010\u0012\u001a\u001e\u0010H\u001a\u00020\r*\u00020E2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a\u001e\u0010L\u001a\u00020 *\u00020I2\u0006\u0010$\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\"\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010O\"\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010O\"\u0014\u0010Q\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010O\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerId", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/geometry/Offset;", "LC7/r;", "onTouchSlopReached", "awaitTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLS7/n;LH7/c;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "Lkotlin/Function1;", "onDrag", "", "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLS7/k;LH7/c;)Ljava/lang/Object;", "drag", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLH7/c;)Ljava/lang/Object;", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "Lkotlin/Function0;", "onDragEnd", "onDragCancel", "detectDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;LS7/k;LS7/a;LS7/a;LS7/n;LH7/c;)Ljava/lang/Object;", "shouldAwaitTouchSlop", "Landroidx/compose/foundation/gestures/Orientation;", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;LS7/n;LS7/k;LS7/a;LS7/a;Landroidx/compose/foundation/gestures/Orientation;LS7/n;LH7/c;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "", "awaitVerticalTouchSlopOrCancellation-jO51t88", "awaitVerticalTouchSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerType;", "pointerType", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILS7/n;LH7/c;)Ljava/lang/Object;", "awaitVerticalPointerSlopOrCancellation", "verticalDrag-jO51t88", "verticalDrag", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalDragOrCancellation", "onVerticalDrag", "detectVerticalDragGestures", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "awaitHorizontalTouchSlopOrCancellation", "onPointerSlopReached", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "awaitHorizontalPointerSlopOrCancellation", "horizontalDrag-jO51t88", "horizontalDrag", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalDragOrCancellation", "onHorizontalDrag", "detectHorizontalDragGestures", "orientation", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLS7/k;Landroidx/compose/foundation/gestures/Orientation;LS7/k;LH7/c;)Ljava/lang/Object;", "hasDragged", "awaitDragOrUp-jO51t88", "awaitDragOrUp", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;LS7/n;LH7/c;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitLongPressOrCancellation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "isPointerUp", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "pointerSlop", "Landroidx/compose/ui/unit/Dp;", "mouseSlop", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    @c(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", f = "DragGestureDetector.kt", l = {238, 244, 965, 1007, PointerIconCompat.TYPE_ZOOM_IN}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9, reason: invalid class name */
    public static final class AnonymousClass9 extends RestrictedSuspendLambda implements n {
        final /* synthetic */ n $onDrag;
        final /* synthetic */ a $onDragCancel;
        final /* synthetic */ k $onDragEnd;
        final /* synthetic */ n $onDragStart;
        final /* synthetic */ Orientation $orientationLock;
        final /* synthetic */ a $shouldAwaitTouchSlop;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(a aVar, Orientation orientation, n nVar, n nVar2, a aVar2, k kVar, H7.c<? super AnonymousClass9> cVar) {
            super(2, cVar);
            this.$shouldAwaitTouchSlop = aVar;
            this.$orientationLock = orientation;
            this.$onDragStart = nVar;
            this.$onDrag = nVar2;
            this.$onDragCancel = aVar2;
            this.$onDragEnd = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$shouldAwaitTouchSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, cVar);
            anonymousClass9.L$0 = obj;
            return anonymousClass9;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((AnonymousClass9) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:126:0x02f8, code lost:
        
            if (((r2 != null ? r2 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.ui.geometry.Offset.m3896getYimpl(r7) : androidx.compose.ui.geometry.Offset.m3895getXimpl(r7) : androidx.compose.ui.geometry.Offset.m3893getDistanceimpl(r7)) == 0.0f) == false) goto L127;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00fe, code lost:
        
            if (r0 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x024b, code lost:
        
            if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m433isPointerUpDmW0f2w(r2.getCurrentEvent(), r0) != false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0272, code lost:
        
            if (r10 != r6) goto L92;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:104:0x02af, B:115:0x02d8], limit reached: 136 */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0174 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0148 A[PHI: r0 r1 r2 r4 r5 r13 r14 r15
          0x0148: PHI (r0v9 float) = (r0v10 float), (r0v30 float) binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r1v7 androidx.compose.ui.input.pointer.PointerInputChange) = 
          (r1v9 androidx.compose.ui.input.pointer.PointerInputChange)
          (r1v25 androidx.compose.ui.input.pointer.PointerInputChange)
         binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r2v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r2v13 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r2v29 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r4v5 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r4v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r4v20 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r5v3 kotlin.jvm.internal.Ref$LongRef) = (r5v4 kotlin.jvm.internal.Ref$LongRef), (r5v14 kotlin.jvm.internal.Ref$LongRef) binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r13v4 androidx.compose.foundation.gestures.TouchSlopDetector) = 
          (r13v11 androidx.compose.foundation.gestures.TouchSlopDetector)
          (r13v24 androidx.compose.foundation.gestures.TouchSlopDetector)
         binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r14v4 java.lang.Object) = (r14v7 java.lang.Object), (r14v18 java.lang.Object) binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r15v0 kotlin.jvm.internal.Ref$LongRef) = (r15v1 kotlin.jvm.internal.Ref$LongRef), (r15v10 kotlin.jvm.internal.Ref$LongRef) binds: [B:33:0x0144, B:13:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0227  */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v4, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0114 -> B:77:0x020d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x017e -> B:45:0x0181). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x01d3 -> B:77:0x020d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0200 -> B:74:0x0202). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0272 -> B:92:0x0275). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 823
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass9.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @c(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_EASING, 322}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5, reason: invalid class name and case insensitive filesystem */
    public static final class C03965 extends RestrictedSuspendLambda implements n {
        final /* synthetic */ n $onDrag;
        final /* synthetic */ a $onDragCancel;
        final /* synthetic */ a $onDragEnd;
        final /* synthetic */ k $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03965(k kVar, a aVar, a aVar2, n nVar, H7.c<? super C03965> cVar) {
            super(2, cVar);
            this.$onDragStart = kVar;
            this.$onDragEnd = aVar;
            this.$onDragCancel = aVar2;
            this.$onDrag = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C03965 c03965 = new C03965(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, cVar);
            c03965.L$0 = obj;
            return c03965;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((C03965) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0062 A[Catch: CancellationException -> 0x00b1, PHI: r1 r8 r12
          0x0062: PHI (r1v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
          (r1v4 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
          (r1v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
         binds: [B:16:0x002d, B:28:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0062: PHI (r8v6 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) = 
          (r8v2 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5)
          (r8v7 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5)
         binds: [B:16:0x002d, B:28:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0062: PHI (r12v7 java.lang.Object) = (r12v0 java.lang.Object), (r12v12 java.lang.Object) binds: [B:16:0x002d, B:28:0x005f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {CancellationException -> 0x00b1, blocks: (B:36:0x008a, B:38:0x0092, B:40:0x00a1, B:42:0x00ad, B:45:0x00b4, B:46:0x00b7, B:47:0x00bd, B:30:0x0062, B:32:0x0066, B:27:0x0051, B:23:0x0049), top: B:54:0x0049 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[Catch: CancellationException -> 0x00b1, TryCatch #0 {CancellationException -> 0x00b1, blocks: (B:36:0x008a, B:38:0x0092, B:40:0x00a1, B:42:0x00ad, B:45:0x00b4, B:46:0x00b7, B:47:0x00bd, B:30:0x0062, B:32:0x0066, B:27:0x0051, B:23:0x0049), top: B:54:0x0049 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0092 A[Catch: CancellationException -> 0x00b1, TryCatch #0 {CancellationException -> 0x00b1, blocks: (B:36:0x008a, B:38:0x0092, B:40:0x00a1, B:42:0x00ad, B:45:0x00b4, B:46:0x00b7, B:47:0x00bd, B:30:0x0062, B:32:0x0066, B:27:0x0051, B:23:0x0049), top: B:54:0x0049 }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00bd A[Catch: CancellationException -> 0x00b1, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00b1, blocks: (B:36:0x008a, B:38:0x0092, B:40:0x00a1, B:42:0x00ad, B:45:0x00b4, B:46:0x00b7, B:47:0x00bd, B:30:0x0062, B:32:0x0066, B:27:0x0051, B:23:0x0049), top: B:54:0x0049 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 206
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C03965.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @c(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", l = {620, 622, 633}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    public static final class C04005 extends RestrictedSuspendLambda implements n {
        final /* synthetic */ a $onDragCancel;
        final /* synthetic */ a $onDragEnd;
        final /* synthetic */ k $onDragStart;
        final /* synthetic */ n $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04005(k kVar, n nVar, a aVar, a aVar2, H7.c<? super C04005> cVar) {
            super(2, cVar);
            this.$onDragStart = kVar;
            this.$onHorizontalDrag = nVar;
            this.$onDragEnd = aVar;
            this.$onDragCancel = aVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C04005 c04005 = new C04005(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, cVar);
            c04005.L$0 = obj;
            return c04005;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((C04005) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
        
            if (r13 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r12.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L34
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.b.b(r13)
                r8 = r12
                goto La7
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L1d:
                java.lang.Object r1 = r12.L$1
                kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref$FloatRef) r1
                java.lang.Object r3 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.b.b(r13)
                r8 = r12
                goto L71
            L2a:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.b.b(r13)
                r8 = r12
                r6 = r1
                goto L4d
            L34:
                kotlin.b.b(r13)
                java.lang.Object r13 = r12.L$0
                r5 = r13
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                r12.L$0 = r5
                r12.label = r4
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r8 = r12
                java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r13 != r0) goto L4c
                goto La6
            L4c:
                r6 = r5
            L4d:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
                r1.<init>()
                r11 = r8
                long r7 = r13.getId()
                int r9 = r13.getType()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 r10 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
                r10.<init>()
                r11.L$0 = r6
                r11.L$1 = r1
                r11.label = r3
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m421awaitHorizontalPointerSlopOrCancellationgDDlDlE(r6, r7, r9, r10, r11)
                r8 = r11
                if (r13 != r0) goto L70
                goto La6
            L70:
                r3 = r6
            L71:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 == 0) goto Lba
                S7.k r12 = r8.$onDragStart
                long r4 = r13.getPosition()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3884boximpl(r4)
                r12.invoke(r4)
                S7.n r12 = r8.$onHorizontalDrag
                float r1 = r1.f4917a
                java.lang.Float r4 = new java.lang.Float
                r4.<init>(r1)
                r12.invoke(r13, r4)
                long r12 = r13.getId()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1
                S7.n r4 = r8.$onHorizontalDrag
                r1.<init>()
                r4 = 0
                r8.L$0 = r4
                r8.L$1 = r4
                r8.label = r2
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m432horizontalDragjO51t88(r3, r12, r1, r8)
                if (r13 != r0) goto La7
            La6:
                return r0
            La7:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r12 = r13.booleanValue()
                if (r12 == 0) goto Lb5
                S7.a r12 = r8.$onDragEnd
                r12.invoke()
                goto Lba
            Lb5:
                S7.a r12 = r8.$onDragCancel
                r12.invoke()
            Lba:
                C7.r r12 = C7.r.f317a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C04005.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @c(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", l = {472, 474, 482}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    public static final class C04045 extends RestrictedSuspendLambda implements n {
        final /* synthetic */ a $onDragCancel;
        final /* synthetic */ a $onDragEnd;
        final /* synthetic */ k $onDragStart;
        final /* synthetic */ n $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04045(k kVar, n nVar, a aVar, a aVar2, H7.c<? super C04045> cVar) {
            super(2, cVar);
            this.$onDragStart = kVar;
            this.$onVerticalDrag = nVar;
            this.$onDragEnd = aVar;
            this.$onDragCancel = aVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C04045 c04045 = new C04045(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, cVar);
            c04045.L$0 = obj;
            return c04045;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((C04045) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
        
            if (r13 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r12.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L34
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.b.b(r13)
                r8 = r12
                goto La7
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L1d:
                java.lang.Object r1 = r12.L$1
                kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref$FloatRef) r1
                java.lang.Object r3 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.b.b(r13)
                r8 = r12
                goto L71
            L2a:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.b.b(r13)
                r8 = r12
                r6 = r1
                goto L4d
            L34:
                kotlin.b.b(r13)
                java.lang.Object r13 = r12.L$0
                r5 = r13
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                r12.L$0 = r5
                r12.label = r4
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r8 = r12
                java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r13 != r0) goto L4c
                goto La6
            L4c:
                r6 = r5
            L4d:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
                r1.<init>()
                r11 = r8
                long r7 = r13.getId()
                int r9 = r13.getType()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1 r10 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1
                r10.<init>()
                r11.L$0 = r6
                r11.L$1 = r1
                r11.label = r3
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m427awaitVerticalPointerSlopOrCancellationgDDlDlE(r6, r7, r9, r10, r11)
                r8 = r11
                if (r13 != r0) goto L70
                goto La6
            L70:
                r3 = r6
            L71:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 == 0) goto Lba
                S7.k r12 = r8.$onDragStart
                long r4 = r13.getPosition()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3884boximpl(r4)
                r12.invoke(r4)
                S7.n r12 = r8.$onVerticalDrag
                float r1 = r1.f4917a
                java.lang.Float r4 = new java.lang.Float
                r4.<init>(r1)
                r12.invoke(r13, r4)
                long r12 = r13.getId()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1
                S7.n r4 = r8.$onVerticalDrag
                r1.<init>()
                r4 = 0
                r8.L$0 = r4
                r8.L$1 = r4
                r8.label = r2
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m435verticalDragjO51t88(r3, r12, r1, r8)
                if (r13 != r0) goto La7
            La6:
                return r0
            La7:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r12 = r13.booleanValue()
                if (r12 == 0) goto Lb5
                S7.a r12 = r8.$onDragEnd
                r12.invoke()
                goto Lba
            Lb5:
                S7.a r12 = r8.$onDragCancel
                r12.invoke()
            Lba:
                C7.r r12 = C7.r.f317a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C04045.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static {
        float fM6844constructorimpl = Dp.m6844constructorimpl((float) 0.125d);
        mouseSlop = fM6844constructorimpl;
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(18);
        defaultTouchSlop = fM6844constructorimpl2;
        mouseToTouchSlopRatio = fM6844constructorimpl / fM6844constructorimpl2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c8, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:22:0x006a). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m418awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m418awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, H7.c):java.lang.Object");
    }

    /* renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m419awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j5, k kVar, H7.c<? super PointerInputChange> cVar) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.f4919a = j5;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, cVar, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i6);
                if (Boolean.valueOf(PointerId.m5403equalsimpl0(pointerInputChange.getId(), ref$LongRef.f4919a)).booleanValue()) {
                    break;
                }
                i6++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                ref$LongRef.f4919a = pointerInputChange5.getId();
            } else if (((Boolean) kVar.invoke(pointerInputChange2)).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m3895getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:22:0x006a). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m420awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m420awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0176 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x016a -> B:63:0x0170). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m421awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, S7.n r23, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m421awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, S7.n, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x016f -> B:62:0x0175). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m422awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, S7.n r22, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m422awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.n, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m423awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, long r10, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref$ObjectRef) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            kotlin.b.b(r12)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L99
            goto L97
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            kotlin.b.b(r12)
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            boolean r12 = m433isPointerUpDmW0f2w(r12, r10)
            if (r12 == 0) goto L46
            return r4
        L46:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            java.util.List r12 = r12.getChanges()
            int r2 = r12.size()
            r5 = 0
        L53:
            if (r5 >= r2) goto L6a
            java.lang.Object r6 = r12.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.getId()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5403equalsimpl0(r7, r10)
            if (r7 == 0) goto L67
            goto L6b
        L67:
            int r5 = r5 + 1
            goto L53
        L6a:
            r6 = r4
        L6b:
            r10 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L71
            return r4
        L71:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r12.f4920a = r10
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r2 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L98
            r2.<init>(r12, r11, r4)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L98
            r0.L$0 = r10     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L98
            r0.L$1 = r11     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L98
            r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L98
            java.lang.Object r9 = r9.withTimeout(r5, r2, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L98
            if (r9 != r1) goto L97
            return r1
        L97:
            return r4
        L98:
            r9 = r11
        L99:
            java.lang.Object r9 = r9.f4920a
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto La0
            goto La1
        La0:
            r10 = r9
        La1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m423awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, H7.c):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m424awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j5, int i, Orientation orientation, n nVar, H7.c<? super PointerInputChange> cVar) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (m433isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j5)) {
            return null;
        }
        float fM434pointerSlopE8SPZFQ = m434pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.f4919a = j5;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, cVar, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i6 = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i10);
                if (Boolean.valueOf(PointerId.m5403equalsimpl0(pointerInputChange.getId(), ref$LongRef.f4919a)).booleanValue()) {
                    break;
                }
                i10++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i6);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                ref$LongRef.f4919a = pointerInputChange4.getId();
            } else {
                Object objM523addPointerInputChangeGcwITfU = touchSlopDetector.m523addPointerInputChangeGcwITfU(pointerInputChange3, fM434pointerSlopE8SPZFQ);
                if (objM523addPointerInputChangeGcwITfU != null) {
                    nVar.invoke(pointerInputChange3, objM523addPointerInputChangeGcwITfU);
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    touchSlopDetector.reset();
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, cVar);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0161 -> B:62:0x0167). Please report as a decompilation issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m425awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, S7.n r22, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m425awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.n, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m3896getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:22:0x006a). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m426awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m426awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0176 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x016a -> B:63:0x0170). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m427awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, S7.n r23, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m427awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, S7.n, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x016f -> B:62:0x0175). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m428awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, S7.n r22, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m428awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.n, H7.c):java.lang.Object");
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final k kVar, final a aVar, a aVar2, n nVar, H7.c<? super r> cVar) {
        Object objDetectDragGestures = detectDragGestures(pointerInputScope, new n() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.5
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m439invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3905unboximpl());
                return r.f317a;
            }

            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
            public final void m439invokeUv8p0NA(PointerInputChange pointerInputChange, long j5) {
                kVar.invoke(Offset.m3884boximpl(pointerInputChange.getPosition()));
            }
        }, new k() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.6
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerInputChange) obj);
                return r.f317a;
            }

            public final void invoke(PointerInputChange pointerInputChange) {
                aVar.invoke();
            }
        }, aVar2, new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.7
            @Override // S7.a
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        }, null, nVar, cVar);
        return objDetectDragGestures == CoroutineSingletons.f4909a ? objDetectDragGestures : r.f317a;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = new k() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m436invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m436invokek4lQ0M(long j5) {
                }
            };
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.3
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m437invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m437invoke();
                    return r.f317a;
                }
            };
        }
        if ((i & 4) != 0) {
            aVar2 = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.4
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m438invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m438invoke();
                    return r.f317a;
                }
            };
        }
        a aVar3 = aVar2;
        return detectDragGestures(pointerInputScope, kVar, aVar, aVar3, nVar, cVar);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c<? super r> cVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C03965(kVar, aVar, aVar2, nVar, null), cVar);
        return objAwaitEachGesture == CoroutineSingletons.f4909a ? objAwaitEachGesture : r.f317a;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = new k() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m440invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m440invokek4lQ0M(long j5) {
                }
            };
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.3
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m441invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m441invoke();
                    return r.f317a;
                }
            };
        }
        if ((i & 4) != 0) {
            aVar2 = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.4
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m442invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m442invoke();
                    return r.f317a;
                }
            };
        }
        a aVar3 = aVar2;
        return detectDragGesturesAfterLongPress(pointerInputScope, kVar, aVar, aVar3, nVar, cVar);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c<? super r> cVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C04005(kVar, nVar, aVar, aVar2, null), cVar);
        return objAwaitEachGesture == CoroutineSingletons.f4909a ? objAwaitEachGesture : r.f317a;
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = new k() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m443invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m443invokek4lQ0M(long j5) {
                }
            };
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.3
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m444invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m444invoke();
                    return r.f317a;
                }
            };
        }
        if ((i & 4) != 0) {
            aVar2 = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.4
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m445invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m445invoke();
                    return r.f317a;
                }
            };
        }
        a aVar3 = aVar2;
        return detectHorizontalDragGestures(pointerInputScope, kVar, aVar, aVar3, nVar, cVar);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c<? super r> cVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C04045(kVar, nVar, aVar, aVar2, null), cVar);
        return objAwaitEachGesture == CoroutineSingletons.f4909a ? objAwaitEachGesture : r.f317a;
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, k kVar, a aVar, a aVar2, n nVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = new k() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m446invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m446invokek4lQ0M(long j5) {
                }
            };
        }
        if ((i & 2) != 0) {
            aVar = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.3
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m447invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m447invoke();
                    return r.f317a;
                }
            };
        }
        if ((i & 4) != 0) {
            aVar2 = new a() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.4
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m448invoke() {
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m448invoke();
                    return r.f317a;
                }
            };
        }
        a aVar3 = aVar2;
        return detectVerticalDragGestures(pointerInputScope, kVar, aVar, aVar3, nVar, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0118, code lost:
    
        if (((r3 != null ? r3 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.ui.geometry.Offset.m3896getYimpl(r4) : androidx.compose.ui.geometry.Offset.m3895getXimpl(r4) : androidx.compose.ui.geometry.Offset.m3893getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00ce, B:46:0x00f8], limit reached: 69 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r15v2, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [S7.k] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r8v3, types: [S7.k] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008b -> B:23:0x0091). Please report as a decompilation issue!!! */
    /* renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m429dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, S7.k r22, androidx.compose.foundation.gestures.Orientation r23, S7.k r24, H7.c<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m429dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.k, androidx.compose.foundation.gestures.Orientation, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m430dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j5, k kVar, Orientation orientation, k kVar2, H7.c<? super PointerInputChange> cVar) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long id = j5;
        if (m433isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        while (true) {
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.f4919a = id;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, cVar, 1, null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m5403equalsimpl0(pointerInputChange.getId(), ref$LongRef.f4919a)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    ref$LongRef.f4919a = pointerInputChange4.getId();
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(1 ^ ((orientation == null ? Offset.m3893getDistanceimpl(jPositionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Offset.m3896getYimpl(jPositionChangeIgnoreConsumed) : Offset.m3895getXimpl(jPositionChangeIgnoreConsumed)) == 0.0f ? 1 : 0)).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || ((Boolean) kVar2.invoke(pointerInputChange2)).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            kVar.invoke(pointerInputChange2);
            id = pointerInputChange2.getId();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0046 -> B:18:0x0049). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m431dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, S7.k r7, H7.c<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            S7.k r4 = (S7.k) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.b.b(r8)
            r7 = r4
            r4 = r5
            goto L49
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.b.b(r8)
        L3c:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m418awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L49
            return r1
        L49:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L50
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L50:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L59
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L59:
            r7.invoke(r8)
            long r5 = r8.getId()
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m431dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0109, code lost:
    
        if (((r8 != null ? r8 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.ui.geometry.Offset.m3896getYimpl(r4) : androidx.compose.ui.geometry.Offset.m3895getXimpl(r4) : androidx.compose.ui.geometry.Offset.m3893getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00c0, B:46:0x00e9], limit reached: 72 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0081 -> B:23:0x0087). Please report as a decompilation issue!!! */
    /* renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m432horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, S7.k r20, H7.c<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m432horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.k, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m433isPointerUpDmW0f2w(PointerEvent pointerEvent, long j5) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z10 = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m5403equalsimpl0(pointerInputChange.getId(), j5)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z10 = true;
        }
        return true ^ z10;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m434pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m5492equalsimpl0(i, PointerType.INSTANCE.m5497getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0109, code lost:
    
        if (((r8 != null ? r8 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.ui.geometry.Offset.m3896getYimpl(r4) : androidx.compose.ui.geometry.Offset.m3895getXimpl(r4) : androidx.compose.ui.geometry.Offset.m3893getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00c0, B:46:0x00e9], limit reached: 72 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0081 -> B:23:0x0087). Please report as a decompilation issue!!! */
    /* renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m435verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, S7.k r20, H7.c<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m435verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, S7.k, H7.c):java.lang.Object");
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, n nVar, k kVar, a aVar, a aVar2, Orientation orientation, n nVar2, H7.c<? super r> cVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass9(aVar2, orientation, nVar, nVar2, aVar, kVar, null), cVar);
        return objAwaitEachGesture == CoroutineSingletons.f4909a ? objAwaitEachGesture : r.f317a;
    }
}

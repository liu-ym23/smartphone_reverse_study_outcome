package androidx.compose.foundation.draganddrop;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class DragAndDropSourceDefaults$DefaultStartDetector$1 extends SuspendLambda implements Function2<DragAndDropStartDetectorScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DragAndDropSourceDefaults$DefaultStartDetector$1(Continuation<? super DragAndDropSourceDefaults$DefaultStartDetector$1> r100) {
        super(2, r100);
    }

    public static /* synthetic */ Unit a(DragAndDropStartDetectorScope r100, Offset r101) {
        return invokeSuspend$lambda$0(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DragAndDropSourceDefaults$DefaultStartDetector$1 r102 = new DragAndDropSourceDefaults$DefaultStartDetector$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DragAndDropStartDetectorScope r100, Continuation<? super Unit> r101) {
        return ((DragAndDropSourceDefaults$DefaultStartDetector$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(DragAndDropStartDetectorScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        final DragAndDropStartDetectorScope r102 = (DragAndDropStartDetectorScope) this.L$0;
        Function1 r103 = new c(r102);
        this.label = 1;
        if (TapGestureDetectorKt.detectTapGestures$default(r102, null, r103, null, null, this, 13, null) != r100) goto L12;
        return r100;
    }

    private static final Unit invokeSuspend$lambda$0(DragAndDropStartDetectorScope r100, Offset r101) {
        r100.mo363requestDragAndDropTransferk4lQ0M(r101.m4592unboximpl());
        return Unit.INSTANCE;
    }
}

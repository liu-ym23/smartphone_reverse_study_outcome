package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DragScope;
import androidx.exifinterface.media.ExifInterface;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/AnchoredDragScope;", "it", "Landroidx/compose/material3/internal/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableState$draggableState$1$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE}, m = "invokeSuspend", n = {}, s = {})
public final class AnchoredDraggableState$draggableState$1$drag$2<T> extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
    int label;
    final /* synthetic */ AnchoredDraggableState$draggableState$1 this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState$draggableState$1$drag$2(AnchoredDraggableState$draggableState$1 r100, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super AnchoredDraggableState$draggableState$1$drag$2> r102) {
        this.this$0 = r100;
        this.$block = r101;
        super(3, r102);
    }

    public final Object invoke(AnchoredDragScope r100, DraggableAnchors<T> r101, Continuation<? super Unit> r102) {
        return new AnchoredDraggableState$draggableState$1$drag$2(this.this$0, this.$block, r102).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, Object r101, Continuation<? super Unit> r102) {
        return invoke(r100, (DraggableAnchors) r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AnchoredDraggableState$draggableState$1$dragScope$1 r103 = AnchoredDraggableState$draggableState$1.access$getDragScope$p(this.this$0);
        Function2<DragScope, Continuation<? super Unit>, Object> r104 = this.$block;
        this.label = 1;
        if (r104.invoke(r103, this) != r101) goto L12;
        return r101;
    }
}

package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.o;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.gestures.Draggable2DKt$NoOpOnDragStarted$1", f = "Draggable2D.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Landroidx/compose/ui/geometry/Offset;", "it", "LC7/r;", "<anonymous>", "(Lm9/z;Landroidx/compose/ui/geometry/Offset;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class Draggable2DKt$NoOpOnDragStarted$1 extends SuspendLambda implements o {
    int label;

    public Draggable2DKt$NoOpOnDragStarted$1(H7.c<? super Draggable2DKt$NoOpOnDragStarted$1> cVar) {
        super(3, cVar);
    }

    @Override // S7.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m453invoked4ec7I((InterfaceC1733z) obj, ((Offset) obj2).m3905unboximpl(), (H7.c) obj3);
    }

    /* renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final Object m453invoked4ec7I(InterfaceC1733z interfaceC1733z, long j5, H7.c<? super r> cVar) {
        return new Draggable2DKt$NoOpOnDragStarted$1(cVar).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.b(obj);
        return r.f317a;
    }
}

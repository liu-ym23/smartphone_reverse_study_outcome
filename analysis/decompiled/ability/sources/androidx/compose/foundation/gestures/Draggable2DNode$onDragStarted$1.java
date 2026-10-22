package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.n;
import S7.o;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.gestures.Draggable2DNode$onDragStarted$1", f = "Draggable2D.kt", l = {427}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class Draggable2DNode$onDragStarted$1 extends SuspendLambda implements n {
    final /* synthetic */ long $startedPosition;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Draggable2DNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Draggable2DNode$onDragStarted$1(Draggable2DNode draggable2DNode, long j5, H7.c<? super Draggable2DNode$onDragStarted$1> cVar) {
        super(2, cVar);
        this.this$0 = draggable2DNode;
        this.$startedPosition = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        Draggable2DNode$onDragStarted$1 draggable2DNode$onDragStarted$1 = new Draggable2DNode$onDragStarted$1(this.this$0, this.$startedPosition, cVar);
        draggable2DNode$onDragStarted$1.L$0 = obj;
        return draggable2DNode$onDragStarted$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            o oVar = this.this$0.onDragStarted;
            Offset offsetM3884boximpl = Offset.m3884boximpl(this.$startedPosition);
            this.label = 1;
            if (oVar.invoke(interfaceC1733z, offsetM3884boximpl, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((Draggable2DNode$onDragStarted$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}

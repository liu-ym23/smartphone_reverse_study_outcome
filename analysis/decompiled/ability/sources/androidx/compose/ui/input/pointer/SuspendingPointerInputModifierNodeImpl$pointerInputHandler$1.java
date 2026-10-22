package androidx.compose.ui.input.pointer;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1", f = "SuspendingPointerInputFilter.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1 extends SuspendLambda implements n {
    int label;

    public SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1(H7.c<? super SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1(cVar);
    }

    @Override // S7.n
    public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        return ((SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
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

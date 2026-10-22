package androidx.compose.ui.input.pointer;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$onPointerEvent$1", f = "SuspendingPointerInputFilter.kt", l = {718, 720}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class SuspendingPointerInputModifierNodeImpl$onPointerEvent$1 extends SuspendLambda implements n {
    int label;
    final /* synthetic */ SuspendingPointerInputModifierNodeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl, H7.c<? super SuspendingPointerInputModifierNodeImpl$onPointerEvent$1> cVar) {
        super(2, cVar);
        this.this$0 = suspendingPointerInputModifierNodeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this.this$0, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r5.invoke(r1, r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r5.invoke(r1, r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L19
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L15:
            kotlin.b.b(r5)
            goto L49
        L19:
            kotlin.b.b(r5)
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r5 = r4.this$0
            S7.n r5 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.access$get_deprecatedPointerInputHandler$p(r5)
            if (r5 == 0) goto L38
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r5 = r4.this$0
            S7.n r5 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.access$get_deprecatedPointerInputHandler$p(r5)
            kotlin.jvm.internal.k.c(r5)
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r1 = r4.this$0
            r4.label = r3
            java.lang.Object r4 = r5.invoke(r1, r4)
            if (r4 != r0) goto L49
            goto L48
        L38:
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r5 = r4.this$0
            androidx.compose.ui.input.pointer.PointerInputEventHandler r5 = r5.get_pointerInputEventHandler()
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r1 = r4.this$0
            r4.label = r2
            java.lang.Object r4 = r5.invoke(r1, r4)
            if (r4 != r0) goto L49
        L48:
            return r0
        L49:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$onPointerEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((SuspendingPointerInputModifierNodeImpl$onPointerEvent$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}

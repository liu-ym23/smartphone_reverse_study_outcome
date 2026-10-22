package x0;

import b3.InterfaceC0380i;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g extends SuspendLambda implements Function3 {

    /* renamed from: a, reason: collision with root package name */
    public int f15876a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ InterfaceC0380i f15877b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f15878c;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        g gVar = new g(3, (Continuation) obj3);
        gVar.f15877b = (InterfaceC0380i) obj;
        gVar.f15878c = (Object[]) obj2;
        return gVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        c cVar;
        c cVar2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f15876a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC0380i interfaceC0380i = this.f15877b;
            c[] cVarArr = (c[]) this.f15878c;
            int length = cVarArr.length;
            int i5 = 0;
            while (true) {
                cVar = C0979a.f15869a;
                if (i5 >= length) {
                    cVar2 = null;
                    break;
                }
                cVar2 = cVarArr[i5];
                if (!Intrinsics.areEqual(cVar2, cVar)) {
                    break;
                }
                i5++;
            }
            if (cVar2 != null) {
                cVar = cVar2;
            }
            this.f15876a = 1;
            if (interfaceC0380i.emit(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

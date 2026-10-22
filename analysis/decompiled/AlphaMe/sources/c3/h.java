package c3;

import Z2.F;
import a3.InterfaceC0164i;
import b3.InterfaceC0379h;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes2.dex */
public final class h extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f4486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0379h[] f4487b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4488c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f4489d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0164i f4490e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(InterfaceC0379h[] interfaceC0379hArr, int i4, AtomicInteger atomicInteger, InterfaceC0164i interfaceC0164i, Continuation continuation) {
        super(2, continuation);
        this.f4487b = interfaceC0379hArr;
        this.f4488c = i4;
        this.f4489d = atomicInteger;
        this.f4490e = interfaceC0164i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new h(this.f4487b, this.f4488c, this.f4489d, this.f4490e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((h) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f4486a;
        AtomicInteger atomicInteger = this.f4489d;
        InterfaceC0164i interfaceC0164i = this.f4490e;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h[] interfaceC0379hArr = this.f4487b;
                int i5 = this.f4488c;
                InterfaceC0379h interfaceC0379h = interfaceC0379hArr[i5];
                g gVar = new g(interfaceC0164i, i5);
                this.f4486a = 1;
                if (interfaceC0379h.collect(gVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                interfaceC0164i.d(null);
            }
            return Unit.INSTANCE;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                interfaceC0164i.d(null);
            }
        }
    }
}

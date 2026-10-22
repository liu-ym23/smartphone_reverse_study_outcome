package a3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: a3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0158c extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2272a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0160e f2273b;

    /* renamed from: c, reason: collision with root package name */
    public int f2274c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0158c(C0160e c0160e, Continuation continuation) {
        super(continuation);
        this.f2273b = c0160e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2272a = obj;
        this.f2274c |= Integer.MIN_VALUE;
        Object objD = C0160e.D(this.f2273b, this);
        return objD == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objD : new C0168m(objD);
    }
}

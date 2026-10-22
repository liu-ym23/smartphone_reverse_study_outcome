package a3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* renamed from: a3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0159d extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2275a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0160e f2276b;

    /* renamed from: c, reason: collision with root package name */
    public int f2277c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0159d(C0160e c0160e, Continuation continuation) {
        super(continuation);
        this.f2276b = c0160e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2275a = obj;
        this.f2277c |= Integer.MIN_VALUE;
        Object objE = this.f2276b.E(null, 0, 0L, this);
        return objE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objE : new C0168m(objE);
    }
}

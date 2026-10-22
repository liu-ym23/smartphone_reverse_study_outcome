package c3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class f extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4481a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f4482b;

    /* renamed from: c, reason: collision with root package name */
    public int f4483c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Continuation continuation) {
        super(continuation);
        this.f4482b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4481a = obj;
        this.f4483c |= Integer.MIN_VALUE;
        return this.f4482b.emit(null, this);
    }
}

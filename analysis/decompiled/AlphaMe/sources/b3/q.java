package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class q extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public r f4428a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4429b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f4430c;

    /* renamed from: d, reason: collision with root package name */
    public int f4431d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Continuation continuation) {
        super(continuation);
        this.f4430c = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4429b = obj;
        this.f4431d |= Integer.MIN_VALUE;
        return this.f4430c.emit(null, this);
    }
}

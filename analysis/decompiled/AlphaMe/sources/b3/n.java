package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class n extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4418a;

    /* renamed from: b, reason: collision with root package name */
    public int f4419b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f4420c;

    /* renamed from: d, reason: collision with root package name */
    public o f4421d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0380i f4422e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, Continuation continuation) {
        super(continuation);
        this.f4420c = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4418a = obj;
        this.f4419b |= Integer.MIN_VALUE;
        return this.f4420c.collect(null, this);
    }
}

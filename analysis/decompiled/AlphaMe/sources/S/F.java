package S;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class F extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public M f1690a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1691b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ M f1692c;

    /* renamed from: d, reason: collision with root package name */
    public int f1693d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(M m4, Continuation continuation) {
        super(continuation);
        this.f1692c = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1691b = obj;
        this.f1693d |= Integer.MIN_VALUE;
        return this.f1692c.f(this);
    }
}

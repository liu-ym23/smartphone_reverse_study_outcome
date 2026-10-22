package S;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class G extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public M f1694a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1695b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ M f1696c;

    /* renamed from: d, reason: collision with root package name */
    public int f1697d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(M m4, Continuation continuation) {
        super(continuation);
        this.f1696c = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1695b = obj;
        this.f1697d |= Integer.MIN_VALUE;
        return this.f1696c.g(this);
    }
}

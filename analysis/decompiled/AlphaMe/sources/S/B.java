package S;

import Z2.InterfaceC0140n;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class B extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f1663a;

    /* renamed from: b, reason: collision with root package name */
    public M f1664b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0140n f1665c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1666d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ M f1667e;

    /* renamed from: f, reason: collision with root package name */
    public int f1668f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(M m4, Continuation continuation) {
        super(continuation);
        this.f1667e = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1666d = obj;
        this.f1668f |= Integer.MIN_VALUE;
        return M.c(this.f1667e, null, this);
    }
}

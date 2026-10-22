package S;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class J extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public M f1708a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1709b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1710c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1711d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ M f1712e;

    /* renamed from: f, reason: collision with root package name */
    public int f1713f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(M m4, Continuation continuation) {
        super(continuation);
        this.f1712e = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1711d = obj;
        this.f1713f |= Integer.MIN_VALUE;
        return this.f1712e.j(this, null, null);
    }
}

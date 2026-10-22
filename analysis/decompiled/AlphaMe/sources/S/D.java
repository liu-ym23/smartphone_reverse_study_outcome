package S;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class D extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f1678a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1679b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1680c;

    /* renamed from: d, reason: collision with root package name */
    public Ref.ObjectRef f1681d;

    /* renamed from: e, reason: collision with root package name */
    public M f1682e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1683f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ E f1684g;

    /* renamed from: h, reason: collision with root package name */
    public int f1685h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(E e4, Continuation continuation) {
        super(continuation);
        this.f1684g = e4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1683f = obj;
        this.f1685h |= Integer.MIN_VALUE;
        return this.f1684g.a(null, this);
    }
}

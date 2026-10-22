package S;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class I extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f1703a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1704b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1705c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ M f1706d;

    /* renamed from: e, reason: collision with root package name */
    public int f1707e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(M m4, Continuation continuation) {
        super(continuation);
        this.f1706d = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1705c = obj;
        this.f1707e |= Integer.MIN_VALUE;
        return this.f1706d.i(this);
    }
}

package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class s extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public t f4434a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4435b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4436c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f4437d;

    /* renamed from: e, reason: collision with root package name */
    public int f4438e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, Continuation continuation) {
        super(continuation);
        this.f4437d = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4436c = obj;
        this.f4438e |= Integer.MIN_VALUE;
        return this.f4437d.emit(null, this);
    }
}

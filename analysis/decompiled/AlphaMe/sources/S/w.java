package S;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes.dex */
public final class w extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1778a;

    /* renamed from: b, reason: collision with root package name */
    public int f1779b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f1780c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, Continuation continuation) {
        super(continuation);
        this.f1780c = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f1778a = obj;
        this.f1779b |= Integer.MIN_VALUE;
        return this.f1780c.emit(null, this);
    }
}

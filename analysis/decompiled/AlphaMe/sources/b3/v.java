package b3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class v extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public w f4443a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4444b;

    /* renamed from: c, reason: collision with root package name */
    public int f4445c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f4446d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4447e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, Continuation continuation) {
        super(continuation);
        this.f4446d = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4444b = obj;
        this.f4445c |= Integer.MIN_VALUE;
        return this.f4446d.emit(null, this);
    }
}

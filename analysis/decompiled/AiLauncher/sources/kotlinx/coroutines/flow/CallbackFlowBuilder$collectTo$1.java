package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {330}, m = "collectTo", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36363a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36364b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackFlowBuilder<T> f36365c;

    /* renamed from: d, reason: collision with root package name */
    public int f36366d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, InterfaceC4014c<? super CallbackFlowBuilder$collectTo$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36365c = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36364b = obj;
        this.f36366d |= Integer.MIN_VALUE;
        return this.f36365c.i(null, this);
    }
}

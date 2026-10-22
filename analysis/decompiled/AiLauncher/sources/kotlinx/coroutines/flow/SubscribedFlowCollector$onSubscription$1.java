package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {475, 479}, m = "onSubscription", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36665a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36666b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SubscribedFlowCollector<T> f36667c;

    /* renamed from: d, reason: collision with root package name */
    public int f36668d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector<T> subscribedFlowCollector, InterfaceC4014c<? super SubscribedFlowCollector$onSubscription$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36667c = subscribedFlowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36666b = obj;
        this.f36668d |= Integer.MIN_VALUE;
        return this.f36667c.b(this);
    }
}

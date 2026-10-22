package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.DistinctFlowImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {73}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36373a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36374b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f36375c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl.AnonymousClass2<T> f36376d;

    /* renamed from: e, reason: collision with root package name */
    public int f36377e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2$emit$1(DistinctFlowImpl.AnonymousClass2<? super T> anonymousClass2, InterfaceC4014c<? super DistinctFlowImpl$collect$2$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36376d = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36375c = obj;
        this.f36377e |= Integer.MIN_VALUE;
        return this.f36376d.emit(null, this);
    }
}

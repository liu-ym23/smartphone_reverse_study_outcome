package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", f = "Limit.kt", l = {22}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__LimitKt$drop$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36476a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36477b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$drop$2$1<T> f36478c;

    /* renamed from: d, reason: collision with root package name */
    public int f36479d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1$emit$1(FlowKt__LimitKt$drop$2$1<? super T> flowKt__LimitKt$drop$2$1, InterfaceC4014c<? super FlowKt__LimitKt$drop$2$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36478c = flowKt__LimitKt$drop$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36477b = obj;
        this.f36479d |= Integer.MIN_VALUE;
        return this.f36478c.emit(null, this);
    }
}

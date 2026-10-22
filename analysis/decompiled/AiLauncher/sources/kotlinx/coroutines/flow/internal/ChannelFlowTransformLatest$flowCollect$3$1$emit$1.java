package kotlinx.coroutines.flow.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3;

@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {26}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelFlowTransformLatest$flowCollect$3$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36714a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36715b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36716c;

    /* renamed from: d, reason: collision with root package name */
    public int f36717d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f36718e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1<T> f36719f;

    /* renamed from: g, reason: collision with root package name */
    public int f36720g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3$1$emit$1(ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1<? super T> anonymousClass1, InterfaceC4014c<? super ChannelFlowTransformLatest$flowCollect$3$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36719f = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36718e = obj;
        this.f36720g |= Integer.MIN_VALUE;
        return this.f36719f.emit(null, this);
    }
}

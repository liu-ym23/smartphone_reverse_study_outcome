package kotlinx.coroutines.flow;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {32, 33}, m = "emitAllImpl$FlowKt__ChannelsKt", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36393a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36394b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36395c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36396d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f36397e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f36398f;

    /* renamed from: g, reason: collision with root package name */
    public int f36399g;

    public FlowKt__ChannelsKt$emitAllImpl$1(InterfaceC4014c<? super FlowKt__ChannelsKt$emitAllImpl$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36398f = obj;
        this.f36399g |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.c(null, null, false, this);
    }
}

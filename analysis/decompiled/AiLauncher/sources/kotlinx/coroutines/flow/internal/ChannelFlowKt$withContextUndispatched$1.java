package kotlinx.coroutines.flow.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlowKt", f = "ChannelFlow.kt", l = {221}, m = "withContextUndispatched", v = 1)
/* loaded from: classes5.dex */
public final class ChannelFlowKt$withContextUndispatched$1<T, V> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36684a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36685b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36686c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36687d;

    /* renamed from: e, reason: collision with root package name */
    public Object f36688e;

    /* renamed from: f, reason: collision with root package name */
    public Object f36689f;

    /* renamed from: g, reason: collision with root package name */
    public Object f36690g;

    /* renamed from: h, reason: collision with root package name */
    public Object f36691h;

    /* renamed from: i, reason: collision with root package name */
    public int f36692i;

    /* renamed from: j, reason: collision with root package name */
    public int f36693j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f36694k;

    /* renamed from: l, reason: collision with root package name */
    public int f36695l;

    public ChannelFlowKt$withContextUndispatched$1(InterfaceC4014c<? super ChannelFlowKt$withContextUndispatched$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36694k = obj;
        this.f36695l |= Integer.MIN_VALUE;
        return ChannelFlowKt.b(null, null, null, null, this);
    }
}

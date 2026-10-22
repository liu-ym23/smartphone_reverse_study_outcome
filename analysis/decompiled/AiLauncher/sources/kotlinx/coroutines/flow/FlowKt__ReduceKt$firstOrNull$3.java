package kotlinx.coroutines.flow;

import Xa.d;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = "firstOrNull", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ReduceKt$firstOrNull$3<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36527a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36528b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36529c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36530d;

    /* renamed from: e, reason: collision with root package name */
    public Object f36531e;

    /* renamed from: f, reason: collision with root package name */
    public int f36532f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f36533g;

    /* renamed from: h, reason: collision with root package name */
    public int f36534h;

    public FlowKt__ReduceKt$firstOrNull$3(InterfaceC4014c<? super FlowKt__ReduceKt$firstOrNull$3> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36533g = obj;
        this.f36534h |= Integer.MIN_VALUE;
        return d.A(null, null, this);
    }
}

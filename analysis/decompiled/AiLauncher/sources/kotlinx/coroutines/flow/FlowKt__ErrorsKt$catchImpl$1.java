package kotlinx.coroutines.flow;

import Xa.d;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {152}, m = "catchImpl", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36458a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36459b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36460c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36461d;

    /* renamed from: e, reason: collision with root package name */
    public int f36462e;

    public FlowKt__ErrorsKt$catchImpl$1(InterfaceC4014c<? super FlowKt__ErrorsKt$catchImpl$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36461d = obj;
        this.f36462e |= Integer.MIN_VALUE;
        return d.h(null, null, this);
    }
}

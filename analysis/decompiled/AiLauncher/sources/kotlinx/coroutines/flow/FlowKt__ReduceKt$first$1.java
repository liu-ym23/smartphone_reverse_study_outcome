package kotlinx.coroutines.flow;

import Xa.d;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {179}, m = AMapLocationStaticsEntity.FIRST_LOCATE, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ReduceKt$first$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36512a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36513b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36514c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36515d;

    /* renamed from: e, reason: collision with root package name */
    public int f36516e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f36517f;

    /* renamed from: g, reason: collision with root package name */
    public int f36518g;

    public FlowKt__ReduceKt$first$1(InterfaceC4014c<? super FlowKt__ReduceKt$first$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36517f = obj;
        this.f36518g |= Integer.MIN_VALUE;
        return d.y(null, this);
    }
}

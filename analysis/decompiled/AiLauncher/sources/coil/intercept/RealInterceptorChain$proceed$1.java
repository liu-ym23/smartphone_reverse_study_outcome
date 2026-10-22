package coil.intercept;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", l = {32}, m = "proceed")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealInterceptorChain$proceed$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15774a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15775b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15776c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RealInterceptorChain f15777d;

    /* renamed from: e, reason: collision with root package name */
    public int f15778e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealInterceptorChain$proceed$1(RealInterceptorChain realInterceptorChain, InterfaceC4014c<? super RealInterceptorChain$proceed$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15777d = realInterceptorChain;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15776c = obj;
        this.f15778e |= Integer.MIN_VALUE;
        return this.f15777d.f(null, this);
    }
}

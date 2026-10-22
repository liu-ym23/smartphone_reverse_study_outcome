package coil.intercept;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {169}, m = "fetch")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineInterceptor$fetch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15731a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15732b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15733c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15734d;

    /* renamed from: e, reason: collision with root package name */
    public Object f15735e;

    /* renamed from: f, reason: collision with root package name */
    public Object f15736f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15737g;

    /* renamed from: h, reason: collision with root package name */
    public int f15738h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f15739i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15740j;

    /* renamed from: k, reason: collision with root package name */
    public int f15741k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$fetch$1(EngineInterceptor engineInterceptor, InterfaceC4014c<? super EngineInterceptor$fetch$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15740j = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15739i = obj;
        this.f15741k |= Integer.MIN_VALUE;
        return this.f15740j.k(null, null, null, null, null, this);
    }
}

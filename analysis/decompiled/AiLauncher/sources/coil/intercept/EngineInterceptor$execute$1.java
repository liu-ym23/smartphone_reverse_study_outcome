package coil.intercept;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {126, 130, 148}, m = "execute")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineInterceptor$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15712a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15713b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15714c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15715d;

    /* renamed from: e, reason: collision with root package name */
    public Object f15716e;

    /* renamed from: f, reason: collision with root package name */
    public Object f15717f;

    /* renamed from: g, reason: collision with root package name */
    public Object f15718g;

    /* renamed from: h, reason: collision with root package name */
    public Object f15719h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f15720i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15721j;

    /* renamed from: k, reason: collision with root package name */
    public int f15722k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$1(EngineInterceptor engineInterceptor, InterfaceC4014c<? super EngineInterceptor$execute$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f15721j = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15720i = obj;
        this.f15722k |= Integer.MIN_VALUE;
        return this.f15721j.j(null, null, null, null, this);
    }
}

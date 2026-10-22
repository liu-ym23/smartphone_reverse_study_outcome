package coil.intercept;

import A1.g;
import A1.k;
import Ua.M;
import Y8.t;
import coil.intercept.EngineInterceptor;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.p;
import w1.b;
import w1.c;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcoil/intercept/EngineInterceptor$b;", "<anonymous>", "(LUa/M;)Lcoil/intercept/EngineInterceptor$b;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "coil.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", l = {131}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EngineInterceptor$execute$executeResult$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super EngineInterceptor.b>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f15723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15724b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<b> f15725c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<coil.a> f15726d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f15727e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f15728f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<k> f15729g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ coil.b f15730h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$executeResult$1(EngineInterceptor engineInterceptor, Ref$ObjectRef<b> ref$ObjectRef, Ref$ObjectRef<coil.a> ref$ObjectRef2, g gVar, Object obj, Ref$ObjectRef<k> ref$ObjectRef3, coil.b bVar, InterfaceC4014c<? super EngineInterceptor$execute$executeResult$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f15724b = engineInterceptor;
        this.f15725c = ref$ObjectRef;
        this.f15726d = ref$ObjectRef2;
        this.f15727e = gVar;
        this.f15728f = obj;
        this.f15729g = ref$ObjectRef3;
        this.f15730h = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new EngineInterceptor$execute$executeResult$1(this.f15724b, this.f15725c, this.f15726d, this.f15727e, this.f15728f, this.f15729g, this.f15730h, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super EngineInterceptor.b> interfaceC4014c) {
        return ((EngineInterceptor$execute$executeResult$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f15723a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        EngineInterceptor engineInterceptor = this.f15724b;
        c cVar = (c) this.f15725c.f34820a;
        coil.a aVar = this.f15726d.f34820a;
        g gVar = this.f15727e;
        Object obj2 = this.f15728f;
        k kVar = this.f15729g.f34820a;
        coil.b bVar = this.f15730h;
        this.f15723a = 1;
        Object objI = engineInterceptor.i(cVar, aVar, gVar, obj2, kVar, bVar, this);
        return objI == objG ? objG : objI;
    }
}

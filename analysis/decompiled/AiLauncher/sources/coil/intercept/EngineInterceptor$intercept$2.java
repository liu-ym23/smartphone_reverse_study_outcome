package coil.intercept;

import A1.g;
import A1.k;
import A1.o;
import F1.j;
import Ua.M;
import Y8.t;
import android.graphics.drawable.Drawable;
import coil.b;
import coil.decode.DataSource;
import coil.intercept.EngineInterceptor;
import coil.intercept.a;
import coil.memory.MemoryCache;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LA1/o;", "<anonymous>", "(LUa/M;)LA1/o;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", l = {77}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EngineInterceptor$intercept$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super o>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f15747a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15748b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f15749c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f15750d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k f15751e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b f15752f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ MemoryCache.Key f15753g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC0199a f15754h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, g gVar, Object obj, k kVar, b bVar, MemoryCache.Key key, a.InterfaceC0199a interfaceC0199a, InterfaceC4014c<? super EngineInterceptor$intercept$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f15748b = engineInterceptor;
        this.f15749c = gVar;
        this.f15750d = obj;
        this.f15751e = kVar;
        this.f15752f = bVar;
        this.f15753g = key;
        this.f15754h = interfaceC0199a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new EngineInterceptor$intercept$2(this.f15748b, this.f15749c, this.f15750d, this.f15751e, this.f15752f, this.f15753g, this.f15754h, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super o> interfaceC4014c) {
        return ((EngineInterceptor$intercept$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        EngineInterceptor$intercept$2 engineInterceptor$intercept$2;
        Object objG = C4063a.g();
        int i10 = this.f15747a;
        if (i10 == 0) {
            C4849c.b(obj);
            EngineInterceptor engineInterceptor = this.f15748b;
            g gVar = this.f15749c;
            Object obj2 = this.f15750d;
            k kVar = this.f15751e;
            b bVar = this.f15752f;
            this.f15747a = 1;
            engineInterceptor$intercept$2 = this;
            obj = engineInterceptor.j(gVar, obj2, kVar, bVar, engineInterceptor$intercept$2);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            engineInterceptor$intercept$2 = this;
        }
        EngineInterceptor.b bVar2 = (EngineInterceptor.b) obj;
        engineInterceptor$intercept$2.f15748b.systemCallbacks.c();
        boolean zH = engineInterceptor$intercept$2.f15748b.memoryCacheService.h(engineInterceptor$intercept$2.f15753g, engineInterceptor$intercept$2.f15749c, bVar2);
        Drawable drawable = bVar2.getDrawable();
        g gVar2 = engineInterceptor$intercept$2.f15749c;
        DataSource dataSource = bVar2.getDataSource();
        MemoryCache.Key key = engineInterceptor$intercept$2.f15753g;
        if (!zH) {
            key = null;
        }
        return new o(drawable, gVar2, dataSource, key, bVar2.getDiskCacheKey(), bVar2.getIsSampled(), j.t(engineInterceptor$intercept$2.f15754h));
    }
}

package coil;

import A1.g;
import A1.h;
import B1.Size;
import Ua.M;
import Y8.t;
import android.graphics.Bitmap;
import coil.intercept.RealInterceptorChain;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LA1/h;", "<anonymous>", "(LUa/M;)LA1/h;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "coil.RealImageLoader$executeMain$result$1", f = "RealImageLoader.kt", l = {196}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RealImageLoader$executeMain$result$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super h>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f15540a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f15541b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RealImageLoader f15542c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Size f15543d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f15544e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Bitmap f15545f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$executeMain$result$1(g gVar, RealImageLoader realImageLoader, Size size, b bVar, Bitmap bitmap, InterfaceC4014c<? super RealImageLoader$executeMain$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f15541b = gVar;
        this.f15542c = realImageLoader;
        this.f15543d = size;
        this.f15544e = bVar;
        this.f15545f = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RealImageLoader$executeMain$result$1(this.f15541b, this.f15542c, this.f15543d, this.f15544e, this.f15545f, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super h> interfaceC4014c) {
        return ((RealImageLoader$executeMain$result$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f15540a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f15541b, this.f15542c.interceptors, 0, this.f15541b, this.f15543d, this.f15544e, this.f15545f != null);
        g gVar = this.f15541b;
        this.f15540a = 1;
        Object objF = realInterceptorChain.f(gVar, this);
        return objF == objG ? objG : objF;
    }
}

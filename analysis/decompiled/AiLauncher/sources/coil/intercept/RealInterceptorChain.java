package coil.intercept;

import A1.g;
import A1.i;
import B1.Size;
import coil.b;
import coil.intercept.a;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b%\u0010,R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b'\u0010/¨\u00060"}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/a$a;", "LA1/g;", "initialRequest", "", "Lcoil/intercept/a;", "interceptors", "", "index", "request", "LB1/g;", ContentDisposition.Parameters.Size, "Lcoil/b;", "eventListener", "", "isPlaceholderCached", "<init>", "(LA1/g;Ljava/util/List;ILA1/g;LB1/g;Lcoil/b;Z)V", "LA1/h;", "f", "(LA1/g;Le9/c;)Ljava/lang/Object;", "interceptor", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LA1/g;Lcoil/intercept/a;)V", Const.INTENT_KEY_PKGNAME, "(ILA1/g;LB1/g;)Lcoil/intercept/RealInterceptorChain;", "LA1/g;", "getInitialRequest", "()LA1/g;", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "c", "I", "getIndex", "()I", Const.INTENT_KEY_UMID, "getRequest", "e", "LB1/g;", "getSize", "()LB1/g;", "Lcoil/b;", "()Lcoil/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "()Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealInterceptorChain implements a.InterfaceC0199a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g initialRequest;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<a> interceptors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final g request;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Size size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final b eventListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final boolean isPlaceholderCached;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(g gVar, List<? extends a> list, int i10, g gVar2, Size size, b bVar, boolean z10) {
        this.initialRequest = gVar;
        this.interceptors = list;
        this.index = i10;
        this.request = gVar2;
        this.size = size;
        this.eventListener = bVar;
        this.isPlaceholderCached = z10;
    }

    public static /* synthetic */ RealInterceptorChain c(RealInterceptorChain realInterceptorChain, int i10, g gVar, Size size, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = realInterceptorChain.index;
        }
        if ((i11 & 2) != 0) {
            gVar = realInterceptorChain.getRequest();
        }
        if ((i11 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.b(i10, gVar, size);
    }

    public final void a(g request, a interceptor) {
        if (request.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (request.getData() == i.f222a) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (request.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (request.getLifecycle() != this.initialRequest.getLifecycle()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (request.getSizeResolver() == this.initialRequest.getSizeResolver()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    public final RealInterceptorChain b(int index, g request, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, index, request, size, this.eventListener, this.isPlaceholderCached);
    }

    /* renamed from: d, reason: from getter */
    public final b getEventListener() {
        return this.eventListener;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(A1.g r12, e9.InterfaceC4014c<? super A1.h> r13) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r13 instanceof coil.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L13
            r0 = r13
            coil.intercept.RealInterceptorChain$proceed$1 r0 = (coil.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.f15778e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15778e = r1
            goto L18
        L13:
            coil.intercept.RealInterceptorChain$proceed$1 r0 = new coil.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.f15776c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f15778e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r11 = r0.f15775b
            coil.intercept.a r11 = (coil.intercept.a) r11
            java.lang.Object r12 = r0.f15774a
            coil.intercept.RealInterceptorChain r12 = (coil.intercept.RealInterceptorChain) r12
            kotlin.C4849c.b(r13)
            r10 = r13
            r13 = r11
            r11 = r12
            r12 = r10
            goto L76
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.C4849c.b(r13)
            int r13 = r11.index
            if (r13 <= 0) goto L50
            java.util.List<coil.intercept.a> r2 = r11.interceptors
            int r13 = r13 - r3
            java.lang.Object r13 = r2.get(r13)
            coil.intercept.a r13 = (coil.intercept.a) r13
            r11.a(r12, r13)
        L50:
            java.util.List<coil.intercept.a> r13 = r11.interceptors
            int r2 = r11.index
            java.lang.Object r13 = r13.get(r2)
            coil.intercept.a r13 = (coil.intercept.a) r13
            int r2 = r11.index
            int r5 = r2 + 1
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r11
            r6 = r12
            coil.intercept.RealInterceptorChain r11 = c(r4, r5, r6, r7, r8, r9)
            r0.f15774a = r4
            r0.f15775b = r13
            r0.f15778e = r3
            java.lang.Object r11 = r13.a(r11, r0)
            if (r11 != r1) goto L74
            return r1
        L74:
            r12 = r11
            r11 = r4
        L76:
            A1.h r12 = (A1.h) r12
            A1.g r0 = r12.getRequest()
            r11.a(r0, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.RealInterceptorChain.f(A1.g, e9.c):java.lang.Object");
    }

    @Override // coil.intercept.a.InterfaceC0199a
    public g getRequest() {
        return this.request;
    }

    @Override // coil.intercept.a.InterfaceC0199a
    public Size getSize() {
        return this.size;
    }
}

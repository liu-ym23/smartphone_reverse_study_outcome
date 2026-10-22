package coil;

import A1.g;
import A1.n;
import F1.j;
import F1.o;
import F1.q;
import F1.s;
import Ua.C1060i;
import Ua.J;
import Ua.L0;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Y8.h;
import Z8.F;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.b;
import coil.decode.BitmapFactoryDecoder;
import coil.fetch.HttpUriFetcher;
import coil.fetch.a;
import coil.fetch.b;
import coil.fetch.c;
import coil.fetch.d;
import coil.fetch.e;
import coil.fetch.g;
import coil.fetch.h;
import coil.intercept.EngineInterceptor;
import coil.memory.MemoryCache;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import tb.InterfaceC5538e;
import tb.v;
import x1.C5842a;
import x1.C5844c;
import y1.C5916a;
import y1.C5917b;
import y1.e;
import y1.f;
import y1.g;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 c2\u00020\u0001:\u00013Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001f\u0010 J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001cH\u0083@¢\u0006\u0004\b$\u0010%J)\u0010,\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J)\u0010/\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020.2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010;\u001a\u0004\b<\u0010=R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00068\u0006¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b?\u0010=R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b5\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b9\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010SR\u001a\u0010U\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010E\u001a\u0004\b3\u0010GR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010XR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010[R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010]\u001a\u0004\bL\u0010^R\u001d\u0010b\u001a\u0004\u0018\u00010\u00078VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b7\u0010_*\u0004\b`\u0010a¨\u0006d"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/c;", "Landroid/content/Context;", "context", "LA1/b;", "defaults", "LY8/h;", "Lcoil/memory/MemoryCache;", "memoryCacheLazy", "Lcoil/disk/a;", "diskCacheLazy", "Ltb/e$a;", "callFactoryLazy", "Lcoil/b$c;", "eventListenerFactory", "Lcoil/a;", "componentRegistry", "LF1/o;", "options", "LF1/q;", "logger", "<init>", "(Landroid/content/Context;LA1/b;LY8/h;LY8/h;LY8/h;Lcoil/b$c;Lcoil/a;LF1/o;LF1/q;)V", "LA1/g;", "request", "LA1/d;", "c", "(LA1/g;)LA1/d;", "", "level", "LY8/t;", "n", "(I)V", "initialRequest", "type", "LA1/h;", "f", "(LA1/g;ILe9/c;)Ljava/lang/Object;", "LA1/o;", "result", "LC1/c;", "target", "Lcoil/b;", "eventListener", "m", "(LA1/o;LC1/c;Lcoil/b;)V", "LA1/e;", "l", "(LA1/e;LC1/c;Lcoil/b;)V", "k", "(LA1/g;Lcoil/b;)V", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "LA1/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LA1/b;", "LY8/h;", "getMemoryCacheLazy", "()LY8/h;", Const.INTENT_KEY_UMID, "getDiskCacheLazy", "e", "getCallFactoryLazy", "Lcoil/b$c;", "getEventListenerFactory", "()Lcoil/b$c;", "Lcoil/a;", "getComponentRegistry", "()Lcoil/a;", "LF1/o;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LF1/o;", "LUa/M;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LUa/M;", "scope", "LF1/s;", "LF1/s;", "systemCallbacks", "LA1/n;", "LA1/n;", "requestService", "components", "", "Lcoil/intercept/a;", "Ljava/util/List;", "interceptors", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shutdown", "LF1/q;", "()LF1/q;", "()Lcoil/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil/RealImageLoader;)Ljava/lang/Object;", "memoryCache", "o", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealImageLoader implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final A1.b defaults;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h<MemoryCache> memoryCacheLazy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h<coil.disk.a> diskCacheLazy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final h<InterfaceC5538e.a> callFactoryLazy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final b.c eventListenerFactory;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final a componentRegistry;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final o options;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()).plus(new b(J.INSTANCE, this)));

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final s systemCallbacks;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final n requestService;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final a components;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final List<coil.intercept.a> interceptors;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean shutdown;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"coil/RealImageLoader$b", "Lkotlin/coroutines/a;", "LUa/J;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends kotlin.coroutines.a implements J {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealImageLoader f15528a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(J.Companion companion, RealImageLoader realImageLoader) {
            super(companion);
            this.f15528a = realImageLoader;
        }

        @Override // Ua.J
        public void handleException(kotlin.coroutines.d context, Throwable exception) {
            this.f15528a.i();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealImageLoader(Context context, A1.b bVar, h<? extends MemoryCache> hVar, h<? extends coil.disk.a> hVar2, h<? extends InterfaceC5538e.a> hVar3, b.c cVar, a aVar, o oVar, q qVar) {
        this.context = context;
        this.defaults = bVar;
        this.memoryCacheLazy = hVar;
        this.diskCacheLazy = hVar2;
        this.callFactoryLazy = hVar3;
        this.eventListenerFactory = cVar;
        this.componentRegistry = aVar;
        this.options = oVar;
        s sVar = new s(this);
        this.systemCallbacks = sVar;
        n nVar = new n(this, sVar, null);
        this.requestService = nVar;
        this.components = aVar.h().d(new y1.c(), v.class).d(new g(), String.class).d(new C5917b(), Uri.class).d(new f(), Uri.class).d(new e(), Integer.class).d(new C5916a(), byte[].class).c(new C5844c(), Uri.class).c(new C5842a(oVar.getAddLastModifiedToFileCacheKey()), File.class).b(new HttpUriFetcher.b(hVar3, hVar2, oVar.getRespectCacheHeaders()), Uri.class).b(new g.a(), File.class).b(new a.C0198a(), Uri.class).b(new d.a(), Uri.class).b(new h.b(), Uri.class).b(new e.a(), Drawable.class).b(new b.a(), Bitmap.class).b(new c.a(), ByteBuffer.class).a(new BitmapFactoryDecoder.c(oVar.getBitmapFactoryMaxParallelism(), oVar.getBitmapFactoryExifOrientationPolicy())).e();
        this.interceptors = F.T0(getComponents().c(), new EngineInterceptor(this, sVar, nVar, null));
        this.shutdown = new AtomicBoolean(false);
    }

    @Override // coil.c
    /* renamed from: a, reason: from getter */
    public a getComponents() {
        return this.components;
    }

    @Override // coil.c
    public MemoryCache b() {
        return this.memoryCacheLazy.getValue();
    }

    @Override // coil.c
    public A1.d c(A1.g request) {
        Q<? extends A1.h> qB = C1060i.b(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null);
        return request.getTarget() instanceof C1.d ? j.l(((C1.d) request.getTarget()).getView()).b(qB) : new A1.j(qB);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0116 A[Catch: all -> 0x00f6, TryCatch #3 {all -> 0x00f6, blocks: (B:43:0x00fa, B:45:0x0100, B:47:0x0106, B:50:0x010e, B:53:0x0116, B:55:0x0128, B:57:0x012e, B:58:0x0131, B:60:0x013a, B:61:0x013d, B:54:0x0124, B:32:0x00ce, B:34:0x00d6, B:36:0x00db, B:83:0x01b5, B:84:0x01ba), top: B:100:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124 A[Catch: all -> 0x00f6, TryCatch #3 {all -> 0x00f6, blocks: (B:43:0x00fa, B:45:0x0100, B:47:0x0106, B:50:0x010e, B:53:0x0116, B:55:0x0128, B:57:0x012e, B:58:0x0131, B:60:0x013a, B:61:0x013d, B:54:0x0124, B:32:0x00ce, B:34:0x00d6, B:36:0x00db, B:83:0x01b5, B:84:0x01ba), top: B:100:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012e A[Catch: all -> 0x00f6, TryCatch #3 {all -> 0x00f6, blocks: (B:43:0x00fa, B:45:0x0100, B:47:0x0106, B:50:0x010e, B:53:0x0116, B:55:0x0128, B:57:0x012e, B:58:0x0131, B:60:0x013a, B:61:0x013d, B:54:0x0124, B:32:0x00ce, B:34:0x00d6, B:36:0x00db, B:83:0x01b5, B:84:0x01ba), top: B:100:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013a A[Catch: all -> 0x00f6, TryCatch #3 {all -> 0x00f6, blocks: (B:43:0x00fa, B:45:0x0100, B:47:0x0106, B:50:0x010e, B:53:0x0116, B:55:0x0128, B:57:0x012e, B:58:0x0131, B:60:0x013a, B:61:0x013d, B:54:0x0124, B:32:0x00ce, B:34:0x00d6, B:36:0x00db, B:83:0x01b5, B:84:0x01ba), top: B:100:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0189 A[Catch: all -> 0x0194, TryCatch #2 {all -> 0x0194, blocks: (B:69:0x0183, B:71:0x0189, B:74:0x0198, B:76:0x019c, B:79:0x01aa, B:80:0x01af), top: B:99:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0198 A[Catch: all -> 0x0194, TryCatch #2 {all -> 0x0194, blocks: (B:69:0x0183, B:71:0x0189, B:74:0x0198, B:76:0x019c, B:79:0x01aa, B:80:0x01af), top: B:99:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bf A[Catch: all -> 0x01d0, TRY_LEAVE, TryCatch #1 {all -> 0x01d0, blocks: (B:85:0x01bb, B:87:0x01bf, B:92:0x01d2, B:93:0x01d5), top: B:98:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d2 A[Catch: all -> 0x01d0, TRY_ENTER, TryCatch #1 {all -> 0x01d0, blocks: (B:85:0x01bb, B:87:0x01bf, B:92:0x01d2, B:93:0x01d5), top: B:98:0x01bb }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(A1.g r20, int r21, e9.InterfaceC4014c<? super A1.h> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.f(A1.g, int, e9.c):java.lang.Object");
    }

    /* renamed from: g, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: h, reason: from getter */
    public A1.b getDefaults() {
        return this.defaults;
    }

    public final q i() {
        return null;
    }

    /* renamed from: j, reason: from getter */
    public final o getOptions() {
        return this.options;
    }

    public final void k(A1.g request, coil.b eventListener) {
        eventListener.a(request);
        g.b listener = request.getListener();
        if (listener != null) {
            listener.a(request);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(A1.e r3, C1.c r4, coil.b r5) {
        /*
            r2 = this;
            A1.g r2 = r3.getRequest()
            boolean r0 = r4 instanceof E1.c
            if (r0 != 0) goto Lb
            if (r4 == 0) goto L37
            goto L1e
        Lb:
            A1.g r0 = r3.getRequest()
            E1.b$a r0 = r0.getTransitionFactory()
            r1 = r4
            E1.c r1 = (E1.c) r1
            E1.b r0 = r0.a(r1, r3)
            boolean r1 = r0 instanceof E1.a
            if (r1 == 0) goto L26
        L1e:
            android.graphics.drawable.Drawable r0 = r3.getDrawable()
            r4.d(r0)
            goto L37
        L26:
            A1.g r4 = r3.getRequest()
            r5.j(r4, r0)
            r0.a()
            A1.g r4 = r3.getRequest()
            r5.m(r4, r0)
        L37:
            r5.d(r2, r3)
            A1.g$b r4 = r2.getListener()
            if (r4 == 0) goto L43
            r4.d(r2, r3)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.l(A1.e, C1.c, coil.b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(A1.o r3, C1.c r4, coil.b r5) {
        /*
            r2 = this;
            A1.g r2 = r3.getRequest()
            r3.getDataSource()
            boolean r0 = r4 instanceof E1.c
            if (r0 != 0) goto Le
            if (r4 == 0) goto L3a
            goto L21
        Le:
            A1.g r0 = r3.getRequest()
            E1.b$a r0 = r0.getTransitionFactory()
            r1 = r4
            E1.c r1 = (E1.c) r1
            E1.b r0 = r0.a(r1, r3)
            boolean r1 = r0 instanceof E1.a
            if (r1 == 0) goto L29
        L21:
            android.graphics.drawable.Drawable r0 = r3.getDrawable()
            r4.a(r0)
            goto L3a
        L29:
            A1.g r4 = r3.getRequest()
            r5.j(r4, r0)
            r0.a()
            A1.g r4 = r3.getRequest()
            r5.m(r4, r0)
        L3a:
            r5.c(r2, r3)
            A1.g$b r4 = r2.getListener()
            if (r4 == 0) goto L46
            r4.c(r2, r3)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.m(A1.o, C1.c, coil.b):void");
    }

    public final void n(int level) {
        MemoryCache value;
        Y8.h<MemoryCache> hVar = this.memoryCacheLazy;
        if (hVar == null || (value = hVar.getValue()) == null) {
            return;
        }
        value.trimMemory(level);
    }
}

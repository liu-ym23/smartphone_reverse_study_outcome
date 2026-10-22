package coil;

import A1.g;
import F1.h;
import F1.o;
import F1.r;
import android.content.Context;
import coil.b;
import coil.c;
import coil.memory.MemoryCache;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import tb.InterfaceC5538e;
import tb.z;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcoil/c;", "", "LA1/g;", "request", "LA1/d;", "c", "(LA1/g;)LA1/d;", "Lcoil/a;", Const.INTENT_KEY_APIKEY, "()Lcoil/a;", "components", "Lcoil/memory/MemoryCache;", Const.INTENT_KEY_PKGNAME, "()Lcoil/memory/MemoryCache;", "memoryCache", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface c {

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcoil/c$a;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcoil/a;", "components", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcoil/a;)Lcoil/c$a;", "Lkotlin/Function0;", "Lcoil/memory/MemoryCache;", "initializer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lp9/a;)Lcoil/c$a;", "", "enable", Const.INTENT_KEY_UMID, "(Z)Lcoil/c$a;", "Lcoil/c;", "e", "()Lcoil/c;", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "applicationContext", "LA1/b;", Const.INTENT_KEY_PKGNAME, "LA1/b;", "defaults", "LY8/h;", "c", "LY8/h;", "memoryCache", "Lcoil/disk/a;", "diskCache", "Ltb/e$a;", "callFactory", "Lcoil/b$c;", "f", "Lcoil/b$c;", "eventListenerFactory", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcoil/a;", "componentRegistry", "LF1/o;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LF1/o;", "options", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Context applicationContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public A1.b defaults = h.b();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public Y8.h<? extends MemoryCache> memoryCache = null;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public Y8.h<? extends coil.disk.a> diskCache = null;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public Y8.h<? extends InterfaceC5538e.a> callFactory = null;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public b.c eventListenerFactory = null;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public coil.a componentRegistry = null;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public o options = new o(false, false, false, 0, null, 31, null);

        public a(Context context) {
            this.applicationContext = context.getApplicationContext();
        }

        public static final MemoryCache f(a aVar) {
            return new MemoryCache.a(aVar.applicationContext).a();
        }

        public static final coil.disk.a g(a aVar) {
            return r.f2565a.a(aVar.applicationContext);
        }

        public static final z h() {
            return new z();
        }

        public final a d(boolean enable) {
            A1.b bVar = this.defaults;
            this.defaults = bVar.a((32639 & 1) != 0 ? bVar.interceptorDispatcher : null, (32639 & 2) != 0 ? bVar.fetcherDispatcher : null, (32639 & 4) != 0 ? bVar.decoderDispatcher : null, (32639 & 8) != 0 ? bVar.transformationDispatcher : null, (32639 & 16) != 0 ? bVar.transitionFactory : null, (32639 & 32) != 0 ? bVar.precision : null, (32639 & 64) != 0 ? bVar.bitmapConfig : null, (32639 & 128) != 0 ? bVar.allowHardware : enable, (32639 & 256) != 0 ? bVar.allowRgb565 : false, (32639 & 512) != 0 ? bVar.placeholder : null, (32639 & 1024) != 0 ? bVar.error : null, (32639 & 2048) != 0 ? bVar.fallback : null, (32639 & 4096) != 0 ? bVar.memoryCachePolicy : null, (32639 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? bVar.diskCachePolicy : null, (32639 & 16384) != 0 ? bVar.networkCachePolicy : null);
            return this;
        }

        public final c e() {
            Context context = this.applicationContext;
            A1.b bVar = this.defaults;
            Y8.h<? extends MemoryCache> hVarB = this.memoryCache;
            if (hVarB == null) {
                hVarB = C4848b.b(new InterfaceC5063a() { // from class: t1.c
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return c.a.f(this.f41994a);
                    }
                });
            }
            Y8.h<? extends coil.disk.a> hVarB2 = this.diskCache;
            if (hVarB2 == null) {
                hVarB2 = C4848b.b(new InterfaceC5063a() { // from class: t1.d
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return c.a.g(this.f41995a);
                    }
                });
            }
            Y8.h<? extends InterfaceC5538e.a> hVarB3 = this.callFactory;
            if (hVarB3 == null) {
                hVarB3 = C4848b.b(new InterfaceC5063a() { // from class: t1.e
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return c.a.h();
                    }
                });
            }
            b.c cVar = this.eventListenerFactory;
            if (cVar == null) {
                cVar = b.c.f15560b;
            }
            coil.a aVar = this.componentRegistry;
            if (aVar == null) {
                aVar = new coil.a();
            }
            return new RealImageLoader(context, bVar, hVarB, hVarB2, hVarB3, cVar, aVar, this.options, null);
        }

        public final a i(coil.a components) {
            this.componentRegistry = components;
            return this;
        }

        public final a j(InterfaceC5063a<? extends MemoryCache> initializer) {
            this.memoryCache = C4848b.b(initializer);
            return this;
        }
    }

    /* renamed from: a */
    coil.a getComponents();

    MemoryCache b();

    A1.d c(g request);
}

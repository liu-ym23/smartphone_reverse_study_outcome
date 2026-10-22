package w;

import android.util.Log;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0003\u0012\u0007\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u0010R\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001c¨\u0006\u001e"}, d2 = {"Lw/q;", "", "<init>", "()V", "Lw/q$b;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lw/q$b;)V", "e", "Landroid/view/Surface;", "surface", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", Const.INTENT_KEY_UMID, "(Landroid/view/Surface;)Ljava/lang/AutoCloseable;", "Lw/q$c;", "surfaceToken", "c", "(Lw/q$c;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "lock", "", "", "Ljava/util/Map;", "useCountMap", "", "Ljava/util/Set;", "listeners", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5711q {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final Oa.c f43025e = Oa.b.c(0);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<Surface, Integer> useCountMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Set<b> listeners = new LinkedHashSet();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lw/q$a;", "", "<init>", "()V", "LOa/c;", "surfaceTokenDebugIds", "LOa/c;", Const.INTENT_KEY_APIKEY, "()LOa/c;", "", "DEBUG", "Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.q$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Oa.c a() {
            return C5711q.f43025e;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lw/q$b;", "", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/Surface;)V", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.q$b */
    public interface b {
        void a(Surface surface);

        void b(Surface surface);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lw/q$c;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroid/view/Surface;", "surface", "<init>", "(Lw/q;Landroid/view/Surface;)V", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/view/Surface;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/Surface;", "", "I", "debugId", "LOa/a;", "c", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.q$c */
    public final class c implements AutoCloseable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Surface surface;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int debugId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Oa.a closed;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C5711q f43032d;

        public c(C5711q c5711q, Surface surface) {
            kotlin.jvm.internal.p.i(surface, "surface");
            this.f43032d = c5711q;
            this.surface = surface;
            this.debugId = C5711q.INSTANCE.a().d();
            this.closed = Oa.b.a(false);
        }

        /* renamed from: b, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed.a(false, true)) {
                this.f43032d.c(this);
            }
        }

        public String toString() {
            return "SurfaceToken-" + this.debugId;
        }
    }

    public final void b(b listener) {
        Set setKeySet;
        kotlin.jvm.internal.p.i(listener, "listener");
        synchronized (this.lock) {
            try {
                this.listeners.add(listener);
                Map<Surface, Integer> map = this.useCountMap;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Surface, Integer> entry : map.entrySet()) {
                    if (entry.getValue().intValue() > 0) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                setKeySet = linkedHashMap.keySet();
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            listener.a((Surface) it.next());
        }
    }

    public final void c(c surfaceToken) {
        Surface surface;
        List listM1;
        kotlin.jvm.internal.p.i(surfaceToken, "surfaceToken");
        synchronized (this.lock) {
            try {
                surface = surfaceToken.getSurface();
                Integer num = this.useCountMap.get(surface);
                if (num == null) {
                    throw new IllegalStateException(("Surface " + surface + " (" + surfaceToken + ") has no use count").toString());
                }
                int iIntValue = num.intValue() - 1;
                this.useCountMap.put(surface, Integer.valueOf(iIntValue));
                if (iIntValue == 0) {
                    listM1 = Z8.F.m1(this.listeners);
                    this.useCountMap.remove(surface);
                } else {
                    listM1 = null;
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (listM1 != null) {
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(surface);
            }
        }
    }

    public final AutoCloseable d(Surface surface) {
        c cVar;
        List listM1;
        kotlin.jvm.internal.p.i(surface, "surface");
        if (!surface.isValid() && z.k.f44508a.d()) {
            Log.w("CXCP", "registerSurface: Surface " + surface + " isn't valid!");
        }
        synchronized (this.lock) {
            try {
                cVar = new c(this, surface);
                Integer num = this.useCountMap.get(surface);
                int iIntValue = (num != null ? num.intValue() : 0) + 1;
                this.useCountMap.put(surface, Integer.valueOf(iIntValue));
                listM1 = iIntValue == 1 ? Z8.F.m1(this.listeners) : null;
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (listM1 != null) {
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(surface);
            }
        }
        return cVar;
    }

    public final void e(b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        synchronized (this.lock) {
            this.listeners.remove(listener);
        }
    }
}

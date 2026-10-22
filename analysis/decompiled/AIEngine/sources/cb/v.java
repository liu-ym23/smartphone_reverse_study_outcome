package cb;

import android.os.Handler;
import android.os.HandlerThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final fb.a f3402a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3403b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3404c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3405d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f3406e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3407f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f3408g;
    public final LinkedHashMap h;

    /* renamed from: i, reason: collision with root package name */
    public final u f3409i;

    public v(fb.a aVar, androidx.lifecycle.b bVar, Handler uiHandler) {
        kotlin.jvm.internal.g.f(uiHandler, "uiHandler");
        this.f3402a = aVar;
        this.f3403b = uiHandler;
        this.f3404c = new Object();
        this.f3405d = new LinkedHashMap();
        this.f3406e = new LinkedHashMap();
        this.f3407f = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("FetchNotificationsIO");
        handlerThread.start();
        this.f3408g = new Handler(handlerThread.getLooper());
        this.h = new LinkedHashMap();
        this.f3409i = new u(this);
    }

    public final void a() {
        synchronized (this.f3404c) {
            this.f3405d.clear();
            this.f3406e.clear();
            this.f3407f.clear();
            this.h.clear();
            lb.n nVar = lb.n.f10413a;
        }
    }

    public final void b(int i10, ya.f fetchListener) {
        kotlin.jvm.internal.g.f(fetchListener, "fetchListener");
        synchronized (this.f3404c) {
            try {
                Set set = (Set) this.f3405d.get(Integer.valueOf(i10));
                Iterator it = set != null ? set.iterator() : null;
                if (it != null) {
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (kotlin.jvm.internal.g.b(((WeakReference) it.next()).get(), fetchListener)) {
                            it.remove();
                            break;
                        }
                    }
                }
                if (fetchListener instanceof ya.d) {
                    Set set2 = (Set) this.f3406e.get(Integer.valueOf(i10));
                    Iterator it2 = set2 != null ? set2.iterator() : null;
                    if (it2 != null) {
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            } else if (kotlin.jvm.internal.g.b(((WeakReference) it2.next()).get(), fetchListener)) {
                                it2.remove();
                                break;
                            }
                        }
                    }
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package i6;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import id.k;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements ComponentCallbacks2 {

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f5808c;

    /* renamed from: f, reason: collision with root package name */
    public Context f5809f;

    /* renamed from: g, reason: collision with root package name */
    public d6.e f5810g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5811h;
    public boolean i;

    public final synchronized void a() {
        try {
            t5.g gVar = (t5.g) this.f5808c.get();
            if (gVar == null) {
                b();
            } else if (this.f5810g == null) {
                gVar.f13195d.getClass();
                d6.e eVarC = k.c(gVar.f13192a, this);
                this.f5810g = eVarC;
                this.i = eVarC.h();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        try {
            if (this.f5811h) {
                return;
            }
            this.f5811h = true;
            Context context = this.f5809f;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            d6.e eVar = this.f5810g;
            if (eVar != null) {
                eVar.shutdown();
            }
            this.f5808c.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onConfigurationChanged(Configuration configuration) {
        if (((t5.g) this.f5808c.get()) == null) {
            b();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public final synchronized void onTrimMemory(int i) {
        t5.g gVar = (t5.g) this.f5808c.get();
        if (gVar != null) {
            c6.c cVar = (c6.c) gVar.f13194c.getValue();
            if (cVar != null) {
                cVar.f2211a.q(i);
                wd.a aVar = cVar.f2212b;
                synchronized (aVar) {
                    if (i >= 10 && i != 20) {
                        aVar.d();
                    }
                }
            }
        } else {
            b();
        }
    }
}

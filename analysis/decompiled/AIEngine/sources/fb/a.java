package fb;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.Reason;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.lifecycle.b f8779a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8780b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f8781c = new LinkedHashMap();

    public a(androidx.lifecycle.b bVar) {
        this.f8779a = bVar;
    }

    public final void a() {
        synchronized (this.f8780b) {
            try {
                Iterator it = this.f8781c.entrySet().iterator();
                while (it.hasNext()) {
                    if (((WeakReference) ((Map.Entry) it.next()).getValue()).get() == null) {
                        it.remove();
                    }
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final eb.a b(int i10, Reason reason) {
        eb.a aVar;
        g.f(reason, "reason");
        synchronized (this.f8780b) {
            try {
                WeakReference weakReference = (WeakReference) this.f8781c.get(Integer.valueOf(i10));
                aVar = weakReference != null ? (eb.a) weakReference.get() : null;
                if (aVar == null) {
                    aVar = new eb.a();
                    aVar.a(((za.g) this.f8779a.h).f(i10), null, reason);
                    this.f8781c.put(Integer.valueOf(i10), new WeakReference(aVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final eb.a c(int i10, Download download, Reason reason) {
        eb.a aVarB;
        g.f(download, "download");
        g.f(reason, "reason");
        synchronized (this.f8780b) {
            aVarB = b(i10, reason);
            aVarB.a(this.f8779a.b(i10, download), download, reason);
        }
        return aVarB;
    }

    public final void d(int i10, Download download, Reason reason) {
        g.f(download, "download");
        g.f(reason, "reason");
        synchronized (this.f8780b) {
            try {
                WeakReference weakReference = (WeakReference) this.f8781c.get(Integer.valueOf(i10));
                eb.a aVar = weakReference != null ? (eb.a) weakReference.get() : null;
                if (aVar != null) {
                    aVar.a(this.f8779a.b(i10, download), download, reason);
                    n nVar = n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

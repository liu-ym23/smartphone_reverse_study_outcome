package androidx.lifecycle;

import android.os.Looper;
import java.lang.invoke.VarHandle;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ d0 f1365c;

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        synchronized (this.f1365c.f1371a) {
            obj = this.f1365c.f1374d;
            this.f1365c.f1374d = d0.f1370h;
        }
        d0 d0Var = this.f1365c;
        n.a.W().f8611c.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            od.f.e("Cannot invoke setValue on a background thread");
            return;
        }
        d0Var.f1373c = obj;
        if (d0Var.f1375e) {
            d0Var.f1376f = true;
            return;
        }
        d0Var.f1375e = true;
        do {
            d0Var.f1376f = false;
            o.f fVar = d0Var.f1372b;
            fVar.getClass();
            o.d dVar = new o.d();
            dVar.f8969g = fVar;
            dVar.f8968f = true;
            VarHandle.storeStoreFence();
            fVar.f8972g.put(dVar, Boolean.FALSE);
            if (dVar.hasNext()) {
                ((Map.Entry) dVar.next()).getValue().getClass();
                od.f.j();
                return;
            }
        } while (d0Var.f1376f);
        d0Var.f1375e = false;
    }
}

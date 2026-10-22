package Q0;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final Set<T0.d> f4892a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final List<T0.d> f4893b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f4894c;

    private boolean a(T0.d dVar, boolean z5) {
        boolean z6 = true;
        if (dVar == null) {
            return true;
        }
        boolean zRemove = this.f4892a.remove(dVar);
        if (!this.f4893b.remove(dVar) && !zRemove) {
            z6 = false;
        }
        if (z6) {
            dVar.clear();
            if (z5) {
                dVar.b();
            }
        }
        return z6;
    }

    public boolean b(T0.d dVar) {
        return a(dVar, true);
    }

    public void c() {
        Iterator it = X0.k.j(this.f4892a).iterator();
        while (it.hasNext()) {
            a((T0.d) it.next(), false);
        }
        this.f4893b.clear();
    }

    public void d() {
        this.f4894c = true;
        for (T0.d dVar : X0.k.j(this.f4892a)) {
            if (dVar.isRunning()) {
                dVar.clear();
                this.f4893b.add(dVar);
            }
        }
    }

    public void e() {
        for (T0.d dVar : X0.k.j(this.f4892a)) {
            if (!dVar.m() && !dVar.j()) {
                dVar.clear();
                if (this.f4894c) {
                    this.f4893b.add(dVar);
                } else {
                    dVar.k();
                }
            }
        }
    }

    public void f() {
        this.f4894c = false;
        for (T0.d dVar : X0.k.j(this.f4892a)) {
            if (!dVar.m() && !dVar.isRunning()) {
                dVar.k();
            }
        }
        this.f4893b.clear();
    }

    public void g(T0.d dVar) {
        this.f4892a.add(dVar);
        if (!this.f4894c) {
            dVar.k();
            return;
        }
        dVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f4893b.add(dVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f4892a.size() + ", isPaused=" + this.f4894c + "}";
    }
}

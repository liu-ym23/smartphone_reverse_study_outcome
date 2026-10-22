package a0;

import D.C0761b0;
import D.C0777n;
import D.o0;
import android.view.A;
import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7809a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7810b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<a, c> f7811c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<b, Set<a>> f7812d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque<LifecycleOwner> f7813e;

    /* renamed from: f, reason: collision with root package name */
    public E.a f7814f;

    public static abstract class a {
        public static a a(LifecycleOwner lifecycleOwner, C0777n c0777n) {
            return new C1200a(System.identityHashCode(lifecycleOwner), c0777n);
        }

        public abstract C0777n b();

        public abstract int c();
    }

    public static class b implements InterfaceC1397o {

        /* renamed from: a, reason: collision with root package name */
        public final k f7815a;

        /* renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f7816b;

        public b(LifecycleOwner lifecycleOwner, k kVar) {
            this.f7816b = lifecycleOwner;
            this.f7815a = kVar;
        }

        public LifecycleOwner a() {
            return this.f7816b;
        }

        @A(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.f7815a.p(lifecycleOwner);
        }

        @A(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.f7815a.j(lifecycleOwner);
        }

        @A(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.f7815a.k(lifecycleOwner);
        }
    }

    public k() {
        this(M.e.d());
    }

    public void a(c cVar, o0 o0Var, E.a aVar) {
        synchronized (this.f7809a) {
            try {
                B0.h.a(!o0Var.m().isEmpty());
                this.f7814f = aVar;
                LifecycleOwner lifecycleOwnerS = cVar.s();
                g(lifecycleOwnerS);
                b bVarD = d(lifecycleOwnerS);
                if (bVarD == null) {
                    return;
                }
                Set<a> set = this.f7812d.get(bVarD);
                E.a aVar2 = this.f7814f;
                if (aVar2 == null || aVar2.e() != 2) {
                    Iterator<a> it = set.iterator();
                    while (it.hasNext()) {
                        c cVar2 = (c) B0.h.f(this.f7811c.get(it.next()));
                        if (!cVar2.equals(cVar) && !cVar2.t().isEmpty()) {
                            if (cVar2.v() || o0Var.p()) {
                                throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner. Please unbind first.");
                            }
                            cVar2.y();
                        }
                    }
                }
                try {
                    cVar.k(o0Var);
                    if (lifecycleOwnerS.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                        j(lifecycleOwnerS);
                    }
                } catch (CameraUseCaseAdapter.CameraException e10) {
                    throw new IllegalArgumentException(e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public c b(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter, androidx.camera.core.l lVar) {
        synchronized (this.f7809a) {
            try {
                B0.h.b(this.f7811c.get(a.a(lifecycleOwner, cameraUseCaseAdapter.H())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
                c cVar = new c(lifecycleOwner, cameraUseCaseAdapter, lVar);
                if (cameraUseCaseAdapter.M().isEmpty()) {
                    cVar.w();
                }
                if (lifecycleOwner.getLifecycle().getState() == Lifecycle.State.DESTROYED) {
                    return cVar;
                }
                h(cVar);
                return cVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public c c(LifecycleOwner lifecycleOwner, C0777n c0777n) {
        synchronized (this.f7809a) {
            try {
                c cVar = this.f7811c.get(a.a(lifecycleOwner, c0777n));
                if (cVar == null || !cVar.r().n()) {
                    return cVar;
                }
                o(cVar);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final b d(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                for (b bVar : this.f7812d.keySet()) {
                    if (lifecycleOwner.equals(bVar.a())) {
                        return bVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Collection<c> e() {
        Collection<c> collectionUnmodifiableCollection;
        synchronized (this.f7809a) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.f7811c.values());
        }
        return collectionUnmodifiableCollection;
    }

    public final boolean f(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                b bVarD = d(lifecycleOwner);
                if (bVarD == null) {
                    return false;
                }
                Iterator<a> it = this.f7812d.get(bVarD).iterator();
                while (it.hasNext()) {
                    if (!((c) B0.h.f(this.f7811c.get(it.next()))).t().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(LifecycleOwner lifecycleOwner) {
        b bVarD = d(lifecycleOwner);
        if (bVarD == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Set<a> set = this.f7812d.get(bVarD);
        Objects.requireNonNull(set);
        for (a aVar : set) {
            c cVar = this.f7811c.get(aVar);
            if (cVar != null && cVar.r().n()) {
                hashSet.add(aVar);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        C0761b0.o("LifecycleCameraRepository", "Removing " + hashSet.size() + " stale LifecycleCamera(s).");
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            c cVar2 = this.f7811c.get((a) it.next());
            Objects.requireNonNull(cVar2);
            o(cVar2);
        }
    }

    public final void h(c cVar) {
        synchronized (this.f7809a) {
            try {
                LifecycleOwner lifecycleOwnerS = cVar.s();
                a aVarA = a.a(lifecycleOwnerS, cVar.r().H());
                b bVarD = d(lifecycleOwnerS);
                Set<a> hashSet = bVarD != null ? this.f7812d.get(bVarD) : new HashSet<>();
                hashSet.add(aVarA);
                this.f7811c.put(aVarA, cVar);
                if (bVarD == null) {
                    b bVar = new b(lifecycleOwnerS, this);
                    this.f7812d.put(bVar, hashSet);
                    lifecycleOwnerS.getLifecycle().a(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(Set<a> set) {
        synchronized (this.f7809a) {
            if (set == null) {
                try {
                    set = this.f7811c.keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (a aVar : set) {
                if (this.f7811c.containsKey(aVar)) {
                    o(this.f7811c.get(aVar));
                }
            }
        }
    }

    public void j(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                if (f(lifecycleOwner)) {
                    if (this.f7813e.isEmpty()) {
                        this.f7813e.push(lifecycleOwner);
                    } else {
                        E.a aVar = this.f7814f;
                        if (aVar == null || aVar.e() != 2) {
                            LifecycleOwner lifecycleOwnerPeek = this.f7813e.peek();
                            if (!lifecycleOwner.equals(lifecycleOwnerPeek)) {
                                l(lifecycleOwnerPeek);
                                this.f7813e.remove(lifecycleOwner);
                                this.f7813e.push(lifecycleOwner);
                            }
                        }
                    }
                    q(lifecycleOwner);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                this.f7813e.remove(lifecycleOwner);
                l(lifecycleOwner);
                if (!this.f7813e.isEmpty()) {
                    q(this.f7813e.peek());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                b bVarD = d(lifecycleOwner);
                if (bVarD == null) {
                    return;
                }
                Iterator<a> it = this.f7812d.get(bVarD).iterator();
                while (it.hasNext()) {
                    ((c) B0.h.f(this.f7811c.get(it.next()))).w();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(o0 o0Var, Set<a> set) {
        synchronized (this.f7809a) {
            if (set == null) {
                try {
                    set = this.f7811c.keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (a aVar : set) {
                if (this.f7811c.containsKey(aVar)) {
                    c cVar = this.f7811c.get(aVar);
                    boolean zIsEmpty = cVar.t().isEmpty();
                    cVar.x(o0Var);
                    if (!zIsEmpty && cVar.t().isEmpty()) {
                        k(cVar.s());
                    }
                }
            }
        }
    }

    public void n(Set<a> set) {
        synchronized (this.f7809a) {
            if (set == null) {
                try {
                    set = this.f7811c.keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator<a> it = set.iterator();
            while (it.hasNext()) {
                c cVar = this.f7811c.get(it.next());
                if (cVar != null) {
                    cVar.y();
                    k(cVar.s());
                }
            }
        }
    }

    public final void o(c cVar) {
        synchronized (this.f7809a) {
            try {
                LifecycleOwner lifecycleOwnerS = cVar.s();
                a aVarA = a.a(lifecycleOwnerS, cVar.r().H());
                this.f7811c.remove(aVarA);
                HashSet hashSet = new HashSet();
                for (b bVar : this.f7812d.keySet()) {
                    if (lifecycleOwnerS.equals(bVar.a())) {
                        Set<a> set = this.f7812d.get(bVar);
                        set.remove(aVarA);
                        if (set.isEmpty()) {
                            hashSet.add(bVar.a());
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    p((LifecycleOwner) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void p(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                b bVarD = d(lifecycleOwner);
                if (bVarD == null) {
                    return;
                }
                k(lifecycleOwner);
                Iterator<a> it = this.f7812d.get(bVarD).iterator();
                while (it.hasNext()) {
                    this.f7811c.remove(it.next());
                }
                this.f7812d.remove(bVarD);
                bVarD.a().getLifecycle().d(bVarD);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(LifecycleOwner lifecycleOwner) {
        synchronized (this.f7809a) {
            try {
                Iterator<a> it = this.f7812d.get(d(lifecycleOwner)).iterator();
                while (it.hasNext()) {
                    c cVar = this.f7811c.get(it.next());
                    if (!((c) B0.h.f(cVar)).t().isEmpty()) {
                        cVar.z();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public k(int i10) {
        this.f7809a = new Object();
        this.f7811c = new HashMap();
        this.f7812d = new HashMap();
        this.f7813e = new ArrayDeque<>();
        this.f7810b = i10;
    }
}

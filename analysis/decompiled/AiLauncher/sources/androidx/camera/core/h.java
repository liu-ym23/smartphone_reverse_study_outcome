package androidx.camera.core;

import D.K;
import K.InterfaceC0872a0;
import androidx.camera.core.g;
import androidx.camera.core.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class h extends K {

    /* renamed from: v, reason: collision with root package name */
    public final Executor f11309v;

    /* renamed from: w, reason: collision with root package name */
    public final Object f11310w = new Object();

    /* renamed from: x, reason: collision with root package name */
    public i f11311x;

    /* renamed from: y, reason: collision with root package name */
    public b f11312y;

    public class a implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f11313a;

        public a(b bVar) {
            this.f11313a = bVar;
        }

        @Override // O.c
        public void b(Throwable th) {
            this.f11313a.close();
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
        }
    }

    public static class b extends g {

        /* renamed from: d, reason: collision with root package name */
        public final WeakReference<h> f11315d;

        public b(i iVar, h hVar) {
            super(iVar);
            this.f11315d = new WeakReference<>(hVar);
            b(new g.a() { // from class: D.M
                @Override // androidx.camera.core.g.a
                public final void c(androidx.camera.core.i iVar2) {
                    h.b.g(this.f2070a, iVar2);
                }
            });
        }

        public static /* synthetic */ void g(b bVar, i iVar) {
            final h hVar = bVar.f11315d.get();
            if (hVar != null) {
                hVar.f11309v.execute(new Runnable() { // from class: D.N
                    @Override // java.lang.Runnable
                    public final void run() {
                        hVar.w();
                    }
                });
            }
        }
    }

    public h(Executor executor) {
        this.f11309v = executor;
    }

    @Override // D.K
    public i d(InterfaceC0872a0 interfaceC0872a0) {
        return interfaceC0872a0.d();
    }

    @Override // D.K
    public void f() {
        synchronized (this.f11310w) {
            try {
                i iVar = this.f11311x;
                if (iVar != null) {
                    iVar.close();
                    this.f11311x = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // D.K
    public void l(i iVar) {
        synchronized (this.f11310w) {
            try {
                if (!this.f2067u) {
                    iVar.close();
                    return;
                }
                if (this.f11312y == null) {
                    b bVar = new b(iVar, this);
                    this.f11312y = bVar;
                    O.f.b(e(bVar), new a(bVar), N.a.a());
                } else {
                    if (iVar.Z0().getTimestamp() <= this.f11312y.Z0().getTimestamp()) {
                        iVar.close();
                    } else {
                        i iVar2 = this.f11311x;
                        if (iVar2 != null) {
                            iVar2.close();
                        }
                        this.f11311x = iVar;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w() {
        synchronized (this.f11310w) {
            try {
                this.f11312y = null;
                i iVar = this.f11311x;
                if (iVar != null) {
                    this.f11311x = null;
                    l(iVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

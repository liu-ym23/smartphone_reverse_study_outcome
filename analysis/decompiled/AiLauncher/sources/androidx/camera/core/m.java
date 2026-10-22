package androidx.camera.core;

import D.q0;
import K.InterfaceC0872a0;
import android.view.Surface;
import androidx.camera.core.g;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class m implements InterfaceC0872a0 {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0872a0 f11643d;

    /* renamed from: e, reason: collision with root package name */
    public final Surface f11644e;

    /* renamed from: f, reason: collision with root package name */
    public g.a f11645f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f11640a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public int f11641b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11642c = false;

    /* renamed from: g, reason: collision with root package name */
    public final g.a f11646g = new g.a() { // from class: D.m0
        @Override // androidx.camera.core.g.a
        public final void c(androidx.camera.core.i iVar) {
            androidx.camera.core.m.h(this.f2141a, iVar);
        }
    };

    public m(InterfaceC0872a0 interfaceC0872a0) {
        this.f11643d = interfaceC0872a0;
        this.f11644e = interfaceC0872a0.getSurface();
    }

    public static /* synthetic */ void c(m mVar, InterfaceC0872a0.a aVar, InterfaceC0872a0 interfaceC0872a0) {
        mVar.getClass();
        aVar.a(mVar);
    }

    public static /* synthetic */ void h(m mVar, i iVar) {
        g.a aVar;
        synchronized (mVar.f11640a) {
            try {
                int i10 = mVar.f11641b - 1;
                mVar.f11641b = i10;
                if (mVar.f11642c && i10 == 0) {
                    mVar.close();
                }
                aVar = mVar.f11645f;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(iVar);
        }
    }

    @Override // K.InterfaceC0872a0
    public int a() {
        int iA;
        synchronized (this.f11640a) {
            iA = this.f11643d.a();
        }
        return iA;
    }

    @Override // K.InterfaceC0872a0
    public void b(final InterfaceC0872a0.a aVar, Executor executor) {
        synchronized (this.f11640a) {
            this.f11643d.b(new InterfaceC0872a0.a() { // from class: D.l0
                @Override // K.InterfaceC0872a0.a
                public final void a(InterfaceC0872a0 interfaceC0872a0) {
                    androidx.camera.core.m.c(this.f2138a, aVar, interfaceC0872a0);
                }
            }, executor);
        }
    }

    @Override // K.InterfaceC0872a0
    public void close() {
        synchronized (this.f11640a) {
            try {
                Surface surface = this.f11644e;
                if (surface != null) {
                    surface.release();
                }
                this.f11643d.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K.InterfaceC0872a0
    public i d() {
        i iVarL;
        synchronized (this.f11640a) {
            iVarL = l(this.f11643d.d());
        }
        return iVarL;
    }

    @Override // K.InterfaceC0872a0
    public int e() {
        int iE;
        synchronized (this.f11640a) {
            iE = this.f11643d.e();
        }
        return iE;
    }

    @Override // K.InterfaceC0872a0
    public void f() {
        synchronized (this.f11640a) {
            this.f11643d.f();
        }
    }

    @Override // K.InterfaceC0872a0
    public i g() {
        i iVarL;
        synchronized (this.f11640a) {
            iVarL = l(this.f11643d.g());
        }
        return iVarL;
    }

    @Override // K.InterfaceC0872a0
    public int getHeight() {
        int height;
        synchronized (this.f11640a) {
            height = this.f11643d.getHeight();
        }
        return height;
    }

    @Override // K.InterfaceC0872a0
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f11640a) {
            surface = this.f11643d.getSurface();
        }
        return surface;
    }

    @Override // K.InterfaceC0872a0
    public int getWidth() {
        int width;
        synchronized (this.f11640a) {
            width = this.f11643d.getWidth();
        }
        return width;
    }

    public int i() {
        int iA;
        synchronized (this.f11640a) {
            iA = this.f11643d.a() - this.f11641b;
        }
        return iA;
    }

    public void j() {
        synchronized (this.f11640a) {
            try {
                this.f11642c = true;
                this.f11643d.f();
                if (this.f11641b == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(g.a aVar) {
        synchronized (this.f11640a) {
            this.f11645f = aVar;
        }
    }

    public final i l(i iVar) {
        if (iVar == null) {
            return null;
        }
        this.f11641b++;
        q0 q0Var = new q0(iVar);
        q0Var.b(this.f11646g);
        return q0Var;
    }
}

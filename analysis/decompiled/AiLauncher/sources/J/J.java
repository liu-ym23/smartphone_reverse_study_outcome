package J;

import D.p0;
import K.E0;
import K.InterfaceC0872a0;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class J implements InterfaceC0872a0 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0872a0 f3536a;

    /* renamed from: b, reason: collision with root package name */
    public X f3537b;

    public J(InterfaceC0872a0 interfaceC0872a0) {
        this.f3536a = interfaceC0872a0;
    }

    public static /* synthetic */ void c(J j10, InterfaceC0872a0.a aVar, InterfaceC0872a0 interfaceC0872a0) {
        j10.getClass();
        aVar.a(j10);
    }

    @Override // K.InterfaceC0872a0
    public int a() {
        return this.f3536a.a();
    }

    @Override // K.InterfaceC0872a0
    public void b(final InterfaceC0872a0.a aVar, Executor executor) {
        this.f3536a.b(new InterfaceC0872a0.a() { // from class: J.I
            @Override // K.InterfaceC0872a0.a
            public final void a(InterfaceC0872a0 interfaceC0872a0) {
                J.c(this.f3534a, aVar, interfaceC0872a0);
            }
        }, executor);
    }

    @Override // K.InterfaceC0872a0
    public void close() {
        this.f3536a.close();
    }

    @Override // K.InterfaceC0872a0
    public androidx.camera.core.i d() {
        return j(this.f3536a.d());
    }

    @Override // K.InterfaceC0872a0
    public int e() {
        return this.f3536a.e();
    }

    @Override // K.InterfaceC0872a0
    public void f() {
        this.f3536a.f();
    }

    @Override // K.InterfaceC0872a0
    public androidx.camera.core.i g() {
        return j(this.f3536a.g());
    }

    @Override // K.InterfaceC0872a0
    public int getHeight() {
        return this.f3536a.getHeight();
    }

    @Override // K.InterfaceC0872a0
    public Surface getSurface() {
        return this.f3536a.getSurface();
    }

    @Override // K.InterfaceC0872a0
    public int getWidth() {
        return this.f3536a.getWidth();
    }

    public void h(X x10) {
        B0.h.i(this.f3537b == null, "Pending request should be null");
        this.f3537b = x10;
    }

    public void i() {
        this.f3537b = null;
    }

    public final androidx.camera.core.i j(androidx.camera.core.i iVar) {
        if (iVar == null) {
            return null;
        }
        E0 e0B = this.f3537b == null ? E0.b() : E0.a(new Pair(this.f3537b.j(), this.f3537b.i().get(0)));
        this.f3537b = null;
        return new p0(iVar, new Size(iVar.getWidth(), iVar.getHeight()), new P.a(new Y.k(e0B, iVar.Z0().getTimestamp())));
    }
}

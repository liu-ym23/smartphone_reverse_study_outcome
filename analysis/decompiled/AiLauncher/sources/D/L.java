package D;

import K.InterfaceC0872a0;

/* loaded from: classes.dex */
public final class L extends K {

    public class a implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.camera.core.i f2068a;

        public a(androidx.camera.core.i iVar) {
            this.f2068a = iVar;
        }

        @Override // O.c
        public void b(Throwable th) {
            this.f2068a.close();
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
        }
    }

    @Override // D.K
    public androidx.camera.core.i d(InterfaceC0872a0 interfaceC0872a0) {
        return interfaceC0872a0.g();
    }

    @Override // D.K
    public void f() {
    }

    @Override // D.K
    public void l(androidx.camera.core.i iVar) {
        O.f.b(e(iVar), new a(iVar), N.a.a());
    }
}

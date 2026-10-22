package Y;

import K.InterfaceC0898v;
import Y.f;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import g3.InterfaceFutureC4095a;
import java.util.Collection;

/* loaded from: classes.dex */
public class i implements CameraInternal {

    /* renamed from: a, reason: collision with root package name */
    public final CameraInternal f6961a;

    /* renamed from: b, reason: collision with root package name */
    public final o f6962b;

    /* renamed from: c, reason: collision with root package name */
    public final p f6963c;

    /* renamed from: d, reason: collision with root package name */
    public final UseCase.b f6964d;

    public i(CameraInternal cameraInternal, UseCase.b bVar, f.a aVar) {
        this.f6961a = cameraInternal;
        this.f6964d = bVar;
        this.f6962b = new o(cameraInternal.d(), aVar);
        this.f6963c = new p(cameraInternal.i());
    }

    @Override // androidx.camera.core.UseCase.b
    public void b(UseCase useCase) {
        M.n.b();
        this.f6964d.b(useCase);
    }

    @Override // androidx.camera.core.UseCase.b
    public void c(UseCase useCase) {
        M.n.b();
        this.f6964d.c(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public androidx.camera.core.impl.h d() {
        return this.f6962b;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void g(Collection<UseCase> collection) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void h(Collection<UseCase> collection) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public InterfaceC0898v i() {
        return this.f6963c;
    }

    @Override // androidx.camera.core.UseCase.b
    public void k(UseCase useCase) {
        M.n.b();
        this.f6964d.k(useCase);
    }

    @Override // androidx.camera.core.UseCase.b
    public void l(UseCase useCase) {
        M.n.b();
        this.f6964d.l(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean p() {
        return false;
    }

    public void r(int i10) {
        this.f6963c.b(i10);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public InterfaceFutureC4095a<Void> release() {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }
}

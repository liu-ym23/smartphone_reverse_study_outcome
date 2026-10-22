package androidx.camera.core.impl;

import D.InterfaceC0778o;
import K.C0875c;
import K.C0877d;
import K.InterfaceC0898v;
import androidx.camera.core.UseCase;
import g3.InterfaceFutureC4095a;
import java.util.Collection;

/* loaded from: classes.dex */
public class a implements CameraInternal {

    /* renamed from: a, reason: collision with root package name */
    public final CameraInternal f11372a;

    /* renamed from: b, reason: collision with root package name */
    public final C0877d f11373b;

    /* renamed from: c, reason: collision with root package name */
    public final C0875c f11374c;

    public a(CameraInternal cameraInternal, C0877d c0877d) {
        this.f11372a = cameraInternal;
        this.f11373b = c0877d;
        this.f11374c = new C0875c(cameraInternal.d(), c0877d.b().T(null));
    }

    @Override // androidx.camera.core.impl.CameraInternal, D.InterfaceC0771h
    public InterfaceC0778o a() {
        return this.f11373b;
    }

    @Override // androidx.camera.core.UseCase.b
    public void b(UseCase useCase) {
        this.f11372a.b(useCase);
    }

    @Override // androidx.camera.core.UseCase.b
    public void c(UseCase useCase) {
        this.f11372a.c(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public h d() {
        return this.f11374c;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public g e() {
        return this.f11372a.e();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void f(boolean z10) {
        this.f11372a.f(z10);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void g(Collection<UseCase> collection) {
        this.f11372a.g(collection);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void h(Collection<UseCase> collection) {
        this.f11372a.h(collection);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public InterfaceC0898v i() {
        return this.f11373b;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean j() {
        return this.f11372a.j();
    }

    @Override // androidx.camera.core.UseCase.b
    public void k(UseCase useCase) {
        this.f11372a.k(useCase);
    }

    @Override // androidx.camera.core.UseCase.b
    public void l(UseCase useCase) {
        this.f11372a.l(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void m(g gVar) {
        this.f11372a.m(gVar);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean n() {
        return this.f11372a.n();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean p() {
        return this.f11372a.p();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void q(boolean z10) {
        this.f11372a.q(z10);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public InterfaceFutureC4095a<Void> release() {
        return this.f11372a.release();
    }
}

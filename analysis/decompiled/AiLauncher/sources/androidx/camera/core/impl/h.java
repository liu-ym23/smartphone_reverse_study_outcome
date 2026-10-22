package androidx.camera.core.impl;

import J.InterfaceC0857l;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.SessionConfig;
import g3.InterfaceFutureC4095a;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f11423a = new b();

    public class a implements InterfaceC0857l {
        public a() {
        }

        @Override // J.InterfaceC0857l
        public InterfaceFutureC4095a<Void> a() {
            return O.f.h(null);
        }

        @Override // J.InterfaceC0857l
        public InterfaceFutureC4095a<Void> b() {
            return O.f.h(null);
        }
    }

    public class b implements h {
        @Override // androidx.camera.core.impl.h
        public void a() {
        }

        @Override // androidx.camera.core.impl.h
        public void b(SessionConfig.b bVar) {
        }

        @Override // androidx.camera.core.impl.h
        public InterfaceFutureC4095a<List<Void>> c(List<l> list, int i10, int i11) {
            return O.f.h(Collections.EMPTY_LIST);
        }

        @Override // androidx.camera.core.impl.h
        public void d(int i10) {
        }

        @Override // androidx.camera.core.impl.h
        public Config e() {
            return null;
        }

        @Override // androidx.camera.core.impl.h
        public void f(Config config) {
        }

        @Override // androidx.camera.core.impl.h
        public void i() {
        }
    }

    void a();

    void b(SessionConfig.b bVar);

    InterfaceFutureC4095a<List<Void>> c(List<l> list, int i10, int i11);

    void d(int i10);

    Config e();

    void f(Config config);

    default InterfaceFutureC4095a<InterfaceC0857l> g(int i10, int i11) {
        return O.f.h(new a());
    }

    default void h(ImageCapture.h hVar) {
    }

    void i();
}

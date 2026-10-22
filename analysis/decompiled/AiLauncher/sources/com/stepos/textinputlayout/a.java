package com.stepos.textinputlayout;

import android.view.animation.Interpolator;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f31110a;

    /* renamed from: com.stepos.textinputlayout.a$a, reason: collision with other inner class name */
    public class C0376a implements d.InterfaceC0377a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f31111a;

        public C0376a(b bVar) {
            this.f31111a = bVar;
        }

        @Override // com.stepos.textinputlayout.a.d.InterfaceC0377a
        public void a() {
            this.f31111a.a(a.this);
        }
    }

    public interface b {
        void a(a aVar);
    }

    public interface c {
        a a();
    }

    public static abstract class d {

        /* renamed from: com.stepos.textinputlayout.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0377a {
            void a();
        }

        public abstract void a();

        public abstract float b();

        public abstract boolean c();

        public abstract void d(int i10);

        public abstract void e(float f10, float f11);

        public abstract void f(Interpolator interpolator);

        public abstract void g(InterfaceC0377a interfaceC0377a);

        public abstract void h();
    }

    public a(d dVar) {
        this.f31110a = dVar;
    }

    public void a() {
        this.f31110a.a();
    }

    public float b() {
        return this.f31110a.b();
    }

    public boolean c() {
        return this.f31110a.c();
    }

    public void d(int i10) {
        this.f31110a.d(i10);
    }

    public void e(float f10, float f11) {
        this.f31110a.e(f10, f11);
    }

    public void f(Interpolator interpolator) {
        this.f31110a.f(interpolator);
    }

    public void g(b bVar) {
        if (bVar != null) {
            this.f31110a.g(new C0376a(bVar));
        } else {
            this.f31110a.g(null);
        }
    }

    public void h() {
        this.f31110a.h();
    }
}

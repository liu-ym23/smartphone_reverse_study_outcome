package com.stepos.textinputlayout;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0199d f16064a;

    class a implements AbstractC0199d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f16065a;

        a(b bVar) {
            this.f16065a = bVar;
        }

        @Override // com.stepos.textinputlayout.d.AbstractC0199d.a
        public void a() {
            this.f16065a.a(d.this);
        }
    }

    interface b {
        void a(d dVar);
    }

    interface c {
        d a();
    }

    /* renamed from: com.stepos.textinputlayout.d$d, reason: collision with other inner class name */
    static abstract class AbstractC0199d {

        /* renamed from: com.stepos.textinputlayout.d$d$a */
        interface a {
            void a();
        }

        AbstractC0199d() {
        }

        abstract void a();

        abstract float b();

        abstract boolean c();

        abstract void d(int i5);

        abstract void e(float f5, float f6);

        abstract void f(Interpolator interpolator);

        abstract void g(a aVar);

        abstract void h();
    }

    d(AbstractC0199d abstractC0199d) {
        this.f16064a = abstractC0199d;
    }

    public void a() {
        this.f16064a.a();
    }

    public float b() {
        return this.f16064a.b();
    }

    public boolean c() {
        return this.f16064a.c();
    }

    public void d(int i5) {
        this.f16064a.d(i5);
    }

    public void e(float f5, float f6) {
        this.f16064a.e(f5, f6);
    }

    public void f(Interpolator interpolator) {
        this.f16064a.f(interpolator);
    }

    public void g(b bVar) {
        if (bVar != null) {
            this.f16064a.g(new a(bVar));
        } else {
            this.f16064a.g(null);
        }
    }

    public void h() {
        this.f16064a.h();
    }
}

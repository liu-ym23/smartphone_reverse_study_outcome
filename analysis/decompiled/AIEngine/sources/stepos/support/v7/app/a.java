package stepos.support.v7.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.ViewGroup;
import stepos.support.v7.app.AppCompatDelegateImplV7;
import stepos.support.v7.widget.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: stepos.support.v7.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0141a {
        void a(int i10, e0.d dVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class f {
    }

    public abstract boolean a();

    public abstract void b(boolean z);

    public abstract int c();

    public abstract Context d();

    public boolean e() {
        return false;
    }

    public abstract void f();

    public boolean h(int i10, KeyEvent keyEvent) {
        return false;
    }

    public abstract void i(boolean z);

    public abstract void j(boolean z);

    public abstract void k();

    public abstract void l();

    public abstract void m(boolean z);

    public abstract void n(boolean z);

    public abstract void o(CharSequence charSequence);

    public abstract void q(CharSequence charSequence);

    public fe.b r(AppCompatDelegateImplV7.e eVar) {
        return null;
    }

    public fe.b s(AppCompatDelegateImplV7.e eVar) {
        return null;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f12071a;

        public c(c cVar) {
            super((ViewGroup.MarginLayoutParams) cVar);
            this.f12071a = 0;
            this.f12071a = cVar.f12071a;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12071a = 0;
        }
    }

    public void g() {
    }

    public void p(int i10) {
    }
}

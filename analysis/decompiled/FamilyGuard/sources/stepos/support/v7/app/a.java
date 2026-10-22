package stepos.support.v7.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.G;
import b5.b;
import java.security.InvalidParameterException;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f20658a = " [ActionBar] ";

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0240a f20659b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0240a f20660c;

    /* renamed from: d, reason: collision with root package name */
    private b f20661d;

    /* renamed from: e, reason: collision with root package name */
    private b f20662e;

    /* renamed from: stepos.support.v7.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0240a {
        void a(int i5);

        void b(String str);

        Drawable getIcon();

        int getId();

        String getTitle();

        void setEnabled(boolean z5);

        void setIcon(Drawable drawable);

        void setVisible(boolean z5);
    }

    public interface b {
        void a(InterfaceC0240a interfaceC0240a);
    }

    public interface c {
        void a(int i5, InterfaceC0240a interfaceC0240a);
    }

    public interface d {
    }

    public interface f {
        void a(boolean z5);
    }

    public interface g {
    }

    public interface h {
    }

    public static abstract class i {
        public abstract ColorStateList a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract Drawable d();

        public abstract int e();

        public abstract int f();

        public abstract int g();

        public abstract int h();

        public abstract CharSequence i();

        public abstract ColorStateList j();

        public abstract boolean k();

        public abstract void l();

        public abstract void m(boolean z5);

        public abstract i n(ColorStateList colorStateList);

        public abstract void o(int i5);

        public abstract void p(int i5, int i6);

        public abstract i q(j jVar);

        public abstract i r(int i5);

        public abstract i s(ColorStateList colorStateList);
    }

    public interface j {
        void c(i iVar, G g5);

        void d(i iVar, G g5);

        void l(i iVar, G g5);
    }

    public interface k {
    }

    protected void A(int i5, InterfaceC0240a interfaceC0240a) {
        if (i5 == 0) {
            this.f20659b = interfaceC0240a;
            b bVar = this.f20661d;
            if (bVar != null) {
                if (interfaceC0240a != null) {
                    bVar.a(interfaceC0240a);
                }
                this.f20661d = null;
                return;
            }
            return;
        }
        if (i5 != 1) {
            throw new InvalidParameterException();
        }
        this.f20660c = interfaceC0240a;
        b bVar2 = this.f20662e;
        if (bVar2 != null) {
            if (interfaceC0240a != null) {
                bVar2.a(interfaceC0240a);
            }
            this.f20662e = null;
        }
    }

    public abstract void B(View view);

    public abstract void C(View view, e eVar);

    public abstract void D(boolean z5);

    public abstract void E(boolean z5);

    public abstract void F(boolean z5);

    public abstract void G(boolean z5);

    public abstract void H(boolean z5);

    public abstract void I(boolean z5);

    public abstract void J(boolean z5);

    public abstract void K(boolean z5);

    public abstract void L(int i5);

    public abstract void M(boolean z5);

    public abstract void N(Drawable drawable);

    public abstract void O(int i5, float f5, int i6);

    public abstract void P(int i5);

    public abstract void Q(CharSequence charSequence);

    public void R(int i5) {
    }

    public abstract void S(CharSequence charSequence);

    public b5.b T(b.InterfaceC0154b interfaceC0154b) {
        return null;
    }

    public b5.b U(b.InterfaceC0154b interfaceC0154b) {
        return null;
    }

    public abstract void f(i iVar);

    protected void g() {
        A(0, null);
        A(1, null);
    }

    public abstract boolean h();

    public void i(b bVar) {
        F(true);
        InterfaceC0240a interfaceC0240a = this.f20659b;
        if (interfaceC0240a == null) {
            this.f20661d = bVar;
        } else {
            bVar.a(interfaceC0240a);
        }
    }

    public void j(b bVar) {
        F(true);
        InterfaceC0240a interfaceC0240a = this.f20660c;
        if (interfaceC0240a == null) {
            this.f20662e = bVar;
        } else {
            bVar.a(interfaceC0240a);
        }
    }

    public abstract void k(boolean z5);

    public abstract View l();

    public abstract int m();

    public abstract i n(int i5);

    public abstract Context o();

    public stepos.support.v7.widget.m p() {
        return null;
    }

    public abstract void q();

    public boolean r() {
        return false;
    }

    public abstract boolean s();

    public abstract i t();

    public void u(Configuration configuration) {
    }

    void v() {
    }

    public boolean w(int i5, KeyEvent keyEvent) {
        return false;
    }

    public abstract void x(i iVar);

    public abstract void y(Drawable drawable);

    public void z(boolean z5) {
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f20663a;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f20663a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17189t);
            this.f20663a = typedArrayObtainStyledAttributes.getInt(g.j.f17194u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(int i5, int i6) {
            super(i5, i6);
            this.f20663a = 8388627;
        }

        public e(int i5, int i6, int i7) {
            super(i5, i6);
            this.f20663a = i7;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f20663a = 0;
            this.f20663a = eVar.f20663a;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f20663a = 0;
        }
    }
}

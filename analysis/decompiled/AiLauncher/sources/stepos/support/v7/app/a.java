package stepos.support.v7.app;

import Ic.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import java.security.InvalidParameterException;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f40396a = " [ActionBar] ";

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0522a f40397b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0522a f40398c;

    /* renamed from: stepos.support.v7.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0522a {
        void a(String str);

        Drawable getIcon();

        int getId();

        String getTitle();

        void setIcon(Drawable drawable);
    }

    public interface b {
        void a(int i10, InterfaceC0522a interfaceC0522a);
    }

    public interface c {
    }

    public interface e {
        void a(boolean z10);
    }

    public interface f {
    }

    public interface g {
    }

    public static abstract class h {
        public abstract CharSequence a();

        public abstract void b();
    }

    public abstract boolean f();

    public abstract void g(boolean z10);

    public abstract int h();

    public abstract Context i();

    public boolean j() {
        return false;
    }

    public void k(Configuration configuration) {
    }

    public void l() {
    }

    public boolean m(int i10, KeyEvent keyEvent) {
        return false;
    }

    public void n(int i10, InterfaceC0522a interfaceC0522a) {
        if (i10 == 0) {
            this.f40397b = interfaceC0522a;
        } else {
            if (i10 != 1) {
                throw new InvalidParameterException();
            }
            this.f40398c = interfaceC0522a;
        }
    }

    public abstract void o(boolean z10);

    public abstract void p(boolean z10);

    public abstract void q(boolean z10);

    public abstract void r(boolean z10);

    public abstract void s(boolean z10);

    public abstract void t(boolean z10);

    public abstract void u(CharSequence charSequence);

    public void v(int i10) {
    }

    public abstract void w(CharSequence charSequence);

    public Ic.b x(b.InterfaceC0060b interfaceC0060b) {
        return null;
    }

    public Ic.b y(b.InterfaceC0060b interfaceC0060b) {
        return null;
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f40399a;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f40399a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f40399a = typedArrayObtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public d(int i10, int i11) {
            super(i10, i11);
            this.f40399a = 8388627;
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.f40399a = 0;
            this.f40399a = dVar.f40399a;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f40399a = 0;
        }
    }
}

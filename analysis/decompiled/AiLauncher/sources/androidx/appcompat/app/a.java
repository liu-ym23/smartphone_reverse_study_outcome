package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import i.AbstractC4156b;

/* loaded from: classes.dex */
public abstract class a {

    public interface b {
        void a(boolean z10);
    }

    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public abstract void h(boolean z10);

    public abstract int i();

    public abstract Context j();

    public abstract void k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    public void n() {
    }

    public abstract boolean o(int i10, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z10);

    public abstract void s(boolean z10);

    public abstract void t(boolean z10);

    public abstract void u(boolean z10);

    public abstract void v(CharSequence charSequence);

    public AbstractC4156b w(AbstractC4156b.a aVar) {
        return null;
    }

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0127a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f8416a;

        public C0127a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8416a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f8416a = typedArrayObtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0127a(int i10, int i11) {
            super(i10, i11);
            this.f8416a = 8388627;
        }

        public C0127a(C0127a c0127a) {
            super((ViewGroup.MarginLayoutParams) c0127a);
            this.f8416a = 0;
            this.f8416a = c0127a.f8416a;
        }

        public C0127a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8416a = 0;
        }
    }
}

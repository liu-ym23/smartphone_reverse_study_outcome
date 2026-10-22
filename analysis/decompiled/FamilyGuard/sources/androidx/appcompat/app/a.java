package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;

/* loaded from: classes.dex */
public abstract class a {

    public interface b {
        void a(boolean z5);
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

    public abstract void h(boolean z5);

    public abstract int i();

    public abstract Context j();

    public boolean k() {
        return false;
    }

    public abstract void l(Configuration configuration);

    void m() {
    }

    public abstract boolean n(int i5, KeyEvent keyEvent);

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public abstract void q(boolean z5);

    public abstract void r(boolean z5);

    public abstract void s(CharSequence charSequence);

    public abstract androidx.appcompat.view.b t(b.a aVar);

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0104a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f7517a;

        public C0104a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7517a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17189t);
            this.f7517a = typedArrayObtainStyledAttributes.getInt(g.j.f17194u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0104a(int i5, int i6) {
            super(i5, i6);
            this.f7517a = 8388627;
        }

        public C0104a(C0104a c0104a) {
            super((ViewGroup.MarginLayoutParams) c0104a);
            this.f7517a = 0;
            this.f7517a = c0104a.f7517a;
        }

        public C0104a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7517a = 0;
        }
    }
}

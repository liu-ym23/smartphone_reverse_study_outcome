package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f211a;

        public LayoutParams(@NonNull Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f211a = 0;
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ActionBarLayout);
            this.f211a = r12.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            r12.recycle();
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f211a = 8388627;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.f211a = 0;
            this.f211a = r10.f211a;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f211a = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean r10);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int r10, long r11);
    }

    @Deprecated
    public interface TabListener {
        void onTabReselected(a r10, FragmentTransaction r11);

        void onTabSelected(a r10, FragmentTransaction r11);

        void onTabUnselected(a r10, FragmentTransaction r11);
    }

    public static abstract class a {
    }

    public ActionBar() {
    }

    public boolean a() {
        return false;
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener r10);

    public abstract boolean b();

    public abstract void c(boolean r10);

    public abstract int d();

    public abstract Context e();

    public boolean f() {
        return false;
    }

    public abstract void g(Configuration r10);

    public void h() {
    }

    public abstract boolean i(int r10, KeyEvent r11);

    public boolean j(KeyEvent r10) {
        return false;
    }

    public boolean k() {
        return false;
    }

    public abstract void l(boolean r10);

    public abstract void m(int r10);

    public abstract void n(Drawable r10);

    public abstract void o(boolean r10);

    public abstract void p(CharSequence r10);

    public abstract ActionMode q(ActionMode.Callback r10);

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener r10);
}

package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class z extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f3404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FragmentTransaction f3406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f3407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3408e;

    public z(FragmentManager r10, int r11) {
        this.f3406c = null;
        this.f3407d = null;
        this.f3404a = r10;
        this.f3405b = r11;
    }

    public static String b(int r10, long r11) {
        return "android:switcher:" + r10 + ":" + r11;
    }

    public long a(int r10) {
        return r10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        Fragment r13 = (Fragment) r12;
        if (this.f3406c != null) goto L5;
        this.f3406c = this.f3404a.o();
    L5:
        this.f3406c.o(r13);
        if (r13.equals(this.f3407d) == false) goto L9;
        this.f3407d = null;
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup r10) {
        FragmentTransaction r11 = this.f3406c;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f3408e == false) goto L14;
    L12:
        this.f3406c = null;
        return;
    L14:
        this.f3408e = true;     // Catch: Throwable -> L9
        r11.m();     // Catch: Throwable -> L9
        this.f3408e = false;
    L9:
        th = move-exception;
        this.f3408e = false;
        throw th;
    }

    public abstract Fragment getItem(int r10);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r10, int r11) {
        if (this.f3406c != null) goto L5;
        this.f3406c = this.f3404a.o();
    L5:
        long r12 = a(r11);
        String r13 = b(r10.getId(), r12);
        Fragment r14 = this.f3404a.i0(r13);
        if (r14 == null) goto L8;
        this.f3406c.i(r14);
    L10:
        if (r14 == this.f3407d) goto L15;
        r14.setMenuVisibility(false);
        if (this.f3405b != 1) goto L14;
        this.f3406c.x(r14, Lifecycle.State.STARTED);
        goto L15
    L14:
        r14.setUserVisibleHint(false);
    L15:
        return r14;
    L8:
        r14 = getItem(r11);
        this.f3406c.b(r10.getId(), r14, b(r10.getId(), r12));
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r10, Object r11) {
        if (((Fragment) r11).getView() != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r10, ClassLoader r11) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r10, int r11, Object r12) {
        Fragment r13 = (Fragment) r12;
        Fragment r14 = this.f3407d;
        if (r13 != r14) goto L5;
        return;
    L5:
        if (r14 == null) goto L13;
        r14.setMenuVisibility(false);
        if (this.f3405b == 1) goto L9;
        this.f3407d.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.f3406c != null) goto L11;
        this.f3406c = this.f3404a.o();
    L11:
        this.f3406c.x(this.f3407d, Lifecycle.State.STARTED);
    L13:
        r13.setMenuVisibility(true);
        if (this.f3405b == 1) goto L16;
        r13.setUserVisibleHint(true);
    L20:
        this.f3407d = r13;
        return;
    L16:
        if (this.f3406c != null) goto L18;
        this.f3406c = this.f3404a.o();
    L18:
        this.f3406c.x(r13, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup r10) {
        if (r10.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}

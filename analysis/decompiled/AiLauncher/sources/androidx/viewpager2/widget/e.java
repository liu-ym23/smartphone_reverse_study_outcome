package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f15147a;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager2.k f15148b;

    public e(LinearLayoutManager linearLayoutManager) {
        this.f15147a = linearLayoutManager;
    }

    public ViewPager2.k a() {
        return this.f15148b;
    }

    public void b(ViewPager2.k kVar) {
        this.f15148b = kVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f15148b == null) {
            return;
        }
        float f11 = -f10;
        for (int i12 = 0; i12 < this.f15147a.getChildCount(); i12++) {
            View childAt = this.f15147a.getChildAt(i12);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i12), Integer.valueOf(this.f15147a.getChildCount())));
            }
            this.f15148b.a(childAt, (this.f15147a.getPosition(childAt) - i10) + f11);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageSelected(int i10) {
    }
}

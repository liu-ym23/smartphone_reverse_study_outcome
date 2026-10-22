package androidx.viewpager2.widget;

import B0.h;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class d implements ViewPager2.k {

    /* renamed from: a, reason: collision with root package name */
    public final int f15146a;

    public d(int i10) {
        h.e(i10, "Margin must be non-negative");
        this.f15146a = i10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.k
    public void a(View view, float f10) {
        ViewPager2 viewPager2B = b(view);
        float f11 = this.f15146a * f10;
        if (viewPager2B.getOrientation() != 0) {
            view.setTranslationY(f11);
            return;
        }
        if (viewPager2B.g()) {
            f11 = -f11;
        }
        view.setTranslationX(f11);
    }

    public final ViewPager2 b(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}

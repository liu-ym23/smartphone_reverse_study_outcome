package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes17.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int r100) {
        Preconditions.checkArgumentNonnegative(r100, "Margin must be non-negative");
        this.mMarginPx = r100;
    }

    private ViewPager2 requireViewPager(View r100) {
        ViewParent r101 = r100.getParent();
        ViewParent r102 = r101.getParent();
        if ((r101 instanceof RecyclerView) == false) goto L9;
        if ((r102 instanceof ViewPager2) == false) goto L9;
        return (ViewPager2) r102;
    L9:
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r100, float r101) {
        ViewPager2 r102 = requireViewPager(r100);
        float r103 = this.mMarginPx * r101;
        if (r102.getOrientation() == 0) goto L5;
        r100.setTranslationY(r103);
        return;
    L5:
        if (r102.isRtl() == false) goto L7;
        r103 = -r103;
    L7:
        r100.setTranslationX(r103);
    }
}

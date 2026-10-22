package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.compose.foundation.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes2.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i6) {
        if (this.mPageTransformer == null) {
            return;
        }
        float f7 = -f;
        for (int i10 = 0; i10 < this.mLayoutManager.getChildCount(); i10++) {
            View childAt = this.mLayoutManager.getChildAt(i10);
            if (childAt == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException(b.o(i10, "LayoutManager returned a null child at pos ", this.mLayoutManager.getChildCount(), "/", " while transforming pages"));
            }
            this.mPageTransformer.transformPage(childAt, (this.mLayoutManager.getPosition(childAt) - i) + f7);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }

    public void setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }
}

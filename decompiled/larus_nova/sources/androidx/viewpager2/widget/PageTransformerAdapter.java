package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r100) {
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    public PageTransformerAdapter(LinearLayoutManager r100) {
        this.mLayoutManager = r100;
    }

    public void setPageTransformer(ViewPager2.PageTransformer r100) {
        this.mPageTransformer = r100;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r100, float r101, int r102) {
        if (this.mPageTransformer != null) goto L5;
        return;
    L5:
        float r103 = -r101;
        int r104 = 0;
    L7:
        if (r104 >= this.mLayoutManager.getChildCount()) goto L13;
        View r105 = this.mLayoutManager.getChildAt(r104);
        if (r105 == null) goto L12;
        this.mPageTransformer.transformPage(r105, (this.mLayoutManager.getPosition(r105) - r100) + r103);
        r104 = r104 + 1;
        goto L7
    L12:
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(r104), Integer.valueOf(this.mLayoutManager.getChildCount())}));
    }
}

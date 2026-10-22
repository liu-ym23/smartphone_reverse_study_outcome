package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class e extends ViewPager2.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f5204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager2.PageTransformer f5205b;

    public e(LinearLayoutManager r10) {
        this.f5204a = r10;
    }

    public ViewPager2.PageTransformer a() {
        return this.f5205b;
    }

    public void b(ViewPager2.PageTransformer r10) {
        this.f5205b = r10;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.h
    public void onPageScrollStateChanged(int r10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.h
    public void onPageScrolled(int r10, float r11, int r12) {
        if (this.f5205b != null) goto L5;
        return;
    L5:
        float r13 = -r11;
        int r14 = 0;
    L7:
        if (r14 >= this.f5204a.getChildCount()) goto L13;
        View r15 = this.f5204a.getChildAt(r14);
        if (r15 == null) goto L12;
        this.f5205b.transformPage(r15, (this.f5204a.getPosition(r15) - r10) + r13);
        r14 = r14 + 1;
        goto L7
    L12:
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(r14), Integer.valueOf(this.f5204a.getChildCount())}));
    }

    @Override // androidx.viewpager2.widget.ViewPager2.h
    public void onPageSelected(int r10) {
    }
}

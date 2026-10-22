package com.bytedanceos.appstore.buss.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedanceos.common.ui.widget.ViewPagerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/viewpager/HeightViewPager;", "Lcom/bytedanceos/common/ui/widget/ViewPagerCompat;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeightViewPager extends ViewPagerCompat {

    public static final class a implements ViewPagerCompat.OnPageChangeListener {
        public a() {
        }

        @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
        }

        @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat.OnPageChangeListener
        public void onPageScrolled(int r10, float r11, int r12) {
        }

        @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat.OnPageChangeListener
        public void onPageSelected(int r10) {
        }
    }

    public HeightViewPager(@NotNull Context r10, @NotNull AttributeSet r11) {
        q.g(r10, "context");
        q.g(r11, "attributeSet");
        super(r10, r11);
        setClipChildren(false);
        setDescendantFocusability(393216);
        setOverScrollMode(0);
        setOnPageChangeListener(new a());
    }

    @Override // com.bytedanceos.common.ui.widget.ViewPagerCompat, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }
}

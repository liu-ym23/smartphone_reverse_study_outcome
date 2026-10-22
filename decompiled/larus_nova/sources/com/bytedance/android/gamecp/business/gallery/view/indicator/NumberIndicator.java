package com.bytedance.android.gamecp.business.gallery.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;
import java.util.Locale;

/* JADX INFO: loaded from: classes44.dex */
public class NumberIndicator extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f53365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f53367c;

    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NumberIndicator f53368a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public a(NumberIndicator r100) {
            this.f53368a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            ViewPager r101 = this.f53368a.f53365a;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getAdapter() == null) goto L12;
            NumberIndicator r102 = this.f53368a;
            if (r102.f53366b <= 0) goto L13;
            r102.setText(String.format(Locale.getDefault(), "%s/%s", new Object[]{Integer.valueOf((r100 % this.f53368a.f53366b) + 1), Integer.valueOf(this.f53368a.f53366b)}));
            return;
        L13:
            return;
        }
    }

    public int getCurrentItem() {
        ViewPager r100 = this.f53365a;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getCurrentItem() % this.f53366b;
    }

    public NumberIndicator(Context r100) {
        this(r100, null);
    }

    public void setRealSize(int r100) {
        if (r100 <= 0) goto L5;
        this.f53366b = r100;
        return;
    }

    public void setViewPager(ViewPager r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getAdapter() == null) goto L8;
        this.f53365a = r100;
        r100.removeOnPageChangeListener(this.f53367c);
        this.f53365a.addOnPageChangeListener(this.f53367c);
        this.f53367c.onPageSelected(this.f53365a.getCurrentItem());
        return;
    }

    public NumberIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NumberIndicator(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f53366b = 0;
        this.f53367c = new a(this);
        setTextSize(14.0f);
    }
}

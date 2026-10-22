package com.bytedance.android.livesdk.feed.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public class RoundIndicatorView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f123646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f123647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f123648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f123649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f123650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f123651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f123652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f123653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f123654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f123655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPager f123656k;

    public class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoundIndicatorView f123657a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public a(RoundIndicatorView r100) {
            this.f123657a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            RoundIndicatorView r101 = this.f123657a;
            int r102 = r101.f123652g;
            if (r102 <= 0) goto L9;
            int r103 = r100 % r102;
            if (r103 >= r102) goto L7;
            r101.setLocation(r103);
            return;
        L7:
            r101.setLocation(0);
            return;
        }
    }

    public RoundIndicatorView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f123653h = getPaddingLeft();
        this.f123654i = getPaddingTop();
        this.f123651f.setColor(this.f123647b);
        float r101 = this.f123653h;
        int r102 = 0;
    L4:
        if (r102 >= this.f123652g) goto L10;
        if (this.f123655j != r102) goto L8;
        this.f123651f.setColor(this.f123646a);
    L9:
        float r103 = this.f123650e;
        r100.drawCircle(r101 + r103, this.f123654i + r103, r103, this.f123651f);
        r101 = r101 + (this.f123649d + this.f123648c);
        r102 = r102 + 1;
        goto L4
    L8:
        this.f123651f.setColor(this.f123647b);
        goto L9
    }

    public void setCount(int r100) {
        this.f123652g = r100;
        measure(0, 0);
        invalidate();
    }

    public void setLocation(int r100) {
        this.f123655j = r100;
        invalidate();
    }

    public void setSizeDp(float r100) {
        float r101 = s1.f(r100);
        this.f123649d = r101;
        this.f123650e = r101 / 2.0f;
        invalidate();
    }

    public void setSpaceDp(float r100) {
        this.f123648c = s1.f(r100);
        invalidate();
    }

    public void setViewPager(ViewPager r100) {
        this.f123656k = r100;
        if (r100 == null) goto L6;
        r100.addOnPageChangeListener(new a(this));
        return;
    }

    public RoundIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 == 1073741824) goto L10;
        r104 = getPaddingLeft() + getPaddingRight();
        int r106 = this.f123652g;
        if (r106 <= 0) goto L8;
        r104 = (int) (r104 + ((r106 * this.f123649d) + ((r106 - 1) * this.f123648c)));
    L8:
        if (r102 != Integer.MIN_VALUE) goto L10;
        r104 = Math.max(r104, getSuggestedMinimumWidth());
    L10:
        if (r103 == 1073741824) goto L17;
        r105 = getPaddingBottom() + getPaddingTop();
        if (this.f123652g <= 0) goto L15;
        r105 = r105 + ((int) this.f123649d);
    L15:
        if (r103 != Integer.MIN_VALUE) goto L17;
        r105 = Math.max(r105, getSuggestedMinimumHeight());
    L17:
        setMeasuredDimension(r104, r105);
    }

    public RoundIndicatorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f123652g = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ri_count, R.attr.ri_default_color, R.attr.ri_selected_color, R.attr.ri_size, R.attr.ri_space, R.attr.ttlive_ri_count, R.attr.ttlive_ri_default_color, R.attr.ttlive_ri_selected_color, R.attr.ttlive_ri_size, R.attr.ttlive_ri_space}, r102, 0);
        this.f123648c = r103.getDimension(4, 0.0f);
        float r104 = r103.getDimension(3, 0.0f);
        this.f123649d = r104;
        this.f123650e = r104 / 2.0f;
        this.f123647b = r103.getColor(1, -1726079458);
        this.f123646a = r103.getColor(2, -10704);
        this.f123652g = r103.getInt(0, 0);
        r103.recycle();
        Paint r105 = new Paint();
        this.f123651f = r105;
        r105.setAntiAlias(true);
        this.f123655j = 0;
    }
}

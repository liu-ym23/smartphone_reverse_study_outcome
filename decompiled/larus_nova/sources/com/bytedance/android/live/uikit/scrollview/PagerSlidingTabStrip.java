package com.bytedance.android.live.uikit.scrollview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static final int[] C = null;
    public int A;
    public final Locale B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout.LayoutParams f102413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout.LayoutParams f102414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f102415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f102416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f102417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f102418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f102419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f102420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f102421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f102422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f102423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f102424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f102425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f102426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f102427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f102428p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f102429q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f102430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f102431s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f102432t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f102433u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f102434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f102435w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f102436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f102437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f102438z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f102439a;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f102439a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f102439a);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f102440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f102441b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if ((this.f102441b.f102418f.getAdapter() instanceof d) == true) goto L5;
        L8:
            this.f102441b.f102418f.setCurrentItem(this.f102440a);
            return;
        L5:
            if (this.f102441b.f102418f.getCurrentItem() != this.f102440a) goto L8;
            ((d) this.f102441b.f102418f.getAdapter()).a();
        }

        public a(PagerSlidingTabStrip r100, int r101) {
            this.f102441b = r100;
            this.f102440a = r101;
        }
    }

    public interface b {
        int a();
    }

    public class c implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f102442a;

        public c(PagerSlidingTabStrip r100) {
            this.f102442a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L4;
            PagerSlidingTabStrip r101 = this.f102442a;
            PagerSlidingTabStrip.a(r101, r101.f102418f.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r102 = this.f102442a.f102416d;
            if (r102 == null) goto L8;
            r102.onPageScrollStateChanged(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PagerSlidingTabStrip r101 = this.f102442a;
            if (r101.f102429q == false) goto L22;
            int r102 = r101.f102418f.getCurrentItem();
            int r103 = 0;
        L6:
            if (r103 >= r101.f102419g) goto L22;
            View r104 = r101.f102417e.getChildAt(r103);
            if ((r101.f102418f.getAdapter() instanceof d) == false) goto L10;
            TextView r105 = ((d) r101.f102418f.getAdapter()).c();
        L11:
            if (r105 == null) goto L13;
        L15:
            if (r105 == null) goto L21;
            if (r102 == r103) goto L18;
        L20:
            r105.setTextColor(r101.f102437y);
            goto L21
        L18:
            if (r101.f102429q == false) goto L20;
            r105.setTextColor(r101.f102424l);
        L21:
            r103 = r103 + 1;
            goto L6
        L13:
            if ((r104 instanceof TextView) == false) goto L15;
            r105 = (TextView) r104;
            goto L15
        L10:
            r105 = null;
        L22:
            ViewPager.OnPageChangeListener r106 = this.f102442a.f102416d;
            if (r106 == null) goto L30;
            r106.onPageSelected(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            PagerSlidingTabStrip r103 = this.f102442a;
            r103.f102420h = r100;
            r103.f102421i = r101;
            PagerSlidingTabStrip.a(r103, r100, (int) (r103.f102417e.getChildAt(r100).getWidth() * r101));
            this.f102442a.invalidate();
            ViewPager.OnPageChangeListener r104 = this.f102442a.f102416d;
            if (r104 == null) goto L6;
            r104.onPageScrolled(r100, r101, r102);
            return;
        }
    }

    public interface d {
        void a();

        View b();

        TextView c();
    }

    static {
        C = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final void c() {
        int r100 = this.f102418f.getCurrentItem();
        int r101 = 0;
    L4:
        if (r101 >= this.f102419g) goto L24;
        View r102 = this.f102417e.getChildAt(r101);
        r102.setBackgroundResource(this.A);
        if ((this.f102418f.getAdapter() instanceof d) == false) goto L8;
        TextView r103 = ((d) this.f102418f.getAdapter()).c();
    L9:
        if (r103 == null) goto L11;
    L13:
        if (r103 == null) goto L23;
        r103.setTextSize(0, this.f102436x);
        r103.setTypeface(null, 0);
        if (r100 == r101) goto L17;
    L19:
        r103.setTextColor(this.f102437y);
    L21:
        if (this.f102428p == false) goto L23;
        r103.setAllCaps(true);
        goto L23
    L17:
        if (this.f102429q == false) goto L19;
        r103.setTextColor(this.f102424l);
    L23:
        r101 = r101 + 1;
        goto L4
    L11:
        if ((r102 instanceof TextView) == false) goto L13;
        r103 = (TextView) r102;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f102439a = this.f102420h;
        return r100;
    }

    public int getDividerColor() {
        return this.f102426n;
    }

    public int getDividerPadding() {
        return this.f102434v;
    }

    public boolean getHighlightTitle() {
        return this.f102429q;
    }

    public int getIndicatorColor() {
        return this.f102424l;
    }

    public int getIndicatorHeight() {
        return this.f102432t;
    }

    public int getScrollOffset() {
        return this.f102431s;
    }

    public boolean getShouldExpand() {
        return this.f102427o;
    }

    public int getTabBackground() {
        return this.A;
    }

    public int getTabPaddingLeftRight() {
        return this.f102435w;
    }

    public int getTextColor() {
        return this.f102437y;
    }

    public int getTextSize() {
        return this.f102436x;
    }

    public int getUnderlineColor() {
        return this.f102425m;
    }

    public int getUnderlineHeight() {
        return this.f102433u;
    }

    public PagerSlidingTabStrip(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f102419g == 0) goto L24;
        int r100 = getHeight();
        if (this.f102430r == false) goto L10;
        this.f102422j.setColor(this.f102425m);
        r110.drawRect(0.0f, r100 - this.f102433u, this.f102417e.getWidth(), r100, this.f102422j);
    L10:
        this.f102422j.setColor(this.f102424l);
        View r101 = this.f102417e.getChildAt(this.f102420h);
        float r102 = r101.getLeft();
        float r103 = r101.getRight();
        if (this.f102421i <= 0.0f) goto L15;
        int r104 = this.f102420h;
        if (r104 >= (this.f102419g - 1)) goto L15;
        View r105 = this.f102417e.getChildAt(r104 + 1);
        float r106 = r105.getLeft();
        float r107 = r105.getRight();
        float r108 = this.f102421i;
        r102 = (r106 * r108) + ((1.0f - r108) * r102);
        r103 = (r107 * r108) + ((1.0f - r108) * r103);
    L15:
        float r111 = r100;
        r110.drawRect(r102, r100 - this.f102432t, r103, r111, this.f102422j);
        if (this.f102430r == true) goto L18;
        this.f102422j.setColor(this.f102425m);
        r110.drawRect(0.0f, r100 - this.f102433u, this.f102417e.getWidth(), r111, this.f102422j);
    L18:
        this.f102423k.setColor(this.f102426n);
        int r109 = 0;
    L20:
        if (r109 >= (this.f102419g - 1)) goto L25;
        View r112 = this.f102417e.getChildAt(r109);
        r110.drawLine(r112.getRight(), this.f102434v, r112.getRight(), r100 - this.f102434v, this.f102423k);
        r109 = r109 + 1;
        goto L20
    L25:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f102420h = r101.f102439a;
        requestLayout();
    }

    public void setAllCaps(boolean r100) {
        this.f102428p = r100;
    }

    public void setDividerColor(int r100) {
        this.f102426n = r100;
        invalidate();
    }

    public void setDividerColorResource(int r100) {
        this.f102426n = getResources().getColor(r100);
        invalidate();
    }

    public void setDividerPadding(int r100) {
        this.f102434v = r100;
        invalidate();
    }

    public void setHighlightTitle(boolean r100) {
        this.f102429q = r100;
    }

    public void setIndicatorColor(int r100) {
        this.f102424l = r100;
        invalidate();
    }

    public void setIndicatorColorResource(int r100) {
        this.f102424l = getResources().getColor(r100);
        invalidate();
    }

    public void setIndicatorHeight(int r100) {
        this.f102432t = r100;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f102416d = r100;
    }

    public void setOverlayIndicator(boolean r100) {
        this.f102430r = r100;
    }

    public void setScrollOffset(int r100) {
        this.f102431s = r100;
        invalidate();
    }

    public void setShouldExpand(boolean r100) {
        this.f102427o = r100;
        requestLayout();
    }

    public void setTabBackground(int r100) {
        this.A = r100;
    }

    public void setTabPaddingLeftRight(int r100) {
        this.f102435w = r100;
        c();
    }

    public void setTextColor(int r100) {
        this.f102437y = r100;
        c();
    }

    public void setTextColorResource(int r100) {
        this.f102437y = getResources().getColor(r100);
        c();
    }

    public void setTextSize(int r100) {
        this.f102436x = r100;
        c();
    }

    public void setUnderlineColor(int r100) {
        this.f102425m = r100;
        invalidate();
    }

    public void setUnderlineColorResource(int r100) {
        this.f102425m = getResources().getColor(r100);
        invalidate();
    }

    public void setUnderlineHeight(int r100) {
        this.f102433u = r100;
        invalidate();
    }

    public void setViewPager(ViewPager r100) {
        this.f102418f = r100;
        if (r100.getAdapter() == null) goto L23;
        r100.setOnPageChangeListener(this.f102415c);
        this.f102417e.removeAllViews();
        this.f102419g = this.f102418f.getAdapter().getCount();
        int r101 = 0;
    L6:
        if (r101 >= this.f102419g) goto L20;
        if ((this.f102418f.getAdapter() instanceof b) == false) goto L10;
        int r102 = ((b) this.f102418f.getAdapter()).a();
        ImageButton r103 = new ImageButton(getContext());
        r103.setImageResource(r102);
        b(r101, r103);
    L19:
        r101 = r101 + 1;
        goto L6
    L10:
        String r104 = this.f102418f.getAdapter().getPageTitle(r101).toString();
        TextView r105 = null;
        if ((this.f102418f.getAdapter() instanceof d) == false) goto L15;
        d r106 = (d) this.f102418f.getAdapter();
        View r107 = r106.b();
        if (r107 == null) goto L16;
        r105 = r106.c();
    L16:
        if (r105 != null) goto L18;
        r105 = new TextView(getContext());
        r107 = r105;
    L18:
        r105.setText(r104);
        r105.setGravity(17);
        r105.setSingleLine();
        b(r101, r107);
        goto L19
    L15:
        r107 = null;
        goto L16
    L20:
        c();
        getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.live.uikit.scrollview.a(this));
        return;
    L23:
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public PagerSlidingTabStrip(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(int r100, View r101) {
        r101.setFocusable(true);
        r101.setOnClickListener(new a(this, r100));
        int r102 = this.f102435w;
        r101.setPadding(r102, 0, r102, 0);
        LinearLayout r103 = this.f102417e;
        if (this.f102427o == false) goto L5;
        LinearLayout.LayoutParams r104 = this.f102414b;
    L6:
        r103.addView(r101, r100, r104);
        return;
    L5:
        r104 = this.f102413a;
        goto L6
    }

    public PagerSlidingTabStrip(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f102415c = new c(this);
        this.f102420h = 0;
        this.f102421i = 0.0f;
        this.f102424l = -10066330;
        this.f102425m = 436207616;
        this.f102426n = 436207616;
        this.f102427o = false;
        this.f102428p = true;
        this.f102429q = false;
        this.f102430r = false;
        this.f102431s = 52;
        this.f102432t = 8;
        this.f102433u = 2;
        this.f102434v = 12;
        this.f102435w = 24;
        this.f102436x = 12;
        this.f102437y = -10066330;
        this.f102438z = 0;
        this.A = com.larus.nova.R.drawable.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r101 = new LinearLayout(r100);
        this.f102417e = r101;
        r101.setOrientation(0);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r101);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        this.f102431s = (int) TypedValue.applyDimension(1, this.f102431s, r103);
        this.f102432t = (int) TypedValue.applyDimension(1, this.f102432t, r103);
        this.f102433u = (int) TypedValue.applyDimension(1, this.f102433u, r103);
        this.f102434v = (int) TypedValue.applyDimension(1, this.f102434v, r103);
        this.f102435w = (int) TypedValue.applyDimension(1, this.f102435w, r103);
        int r104 = (int) TypedValue.applyDimension(1, 1, r103);
        this.f102436x = (int) TypedValue.applyDimension(2, this.f102436x, r103);
        TypedArray r105 = r100.obtainStyledAttributes(r110, C);
        this.f102436x = r105.getDimensionPixelSize(0, this.f102436x);
        this.f102437y = r105.getColor(1, this.f102437y);
        r105.recycle();
        TypedArray r106 = r100.obtainStyledAttributes(r110, new int[]{com.larus.nova.R.attr.isTextUnderLine, com.larus.nova.R.attr.pstsDividerColor, com.larus.nova.R.attr.pstsDividerPadding, com.larus.nova.R.attr.pstsIndicatorColor, com.larus.nova.R.attr.pstsIndicatorHeight, com.larus.nova.R.attr.pstsIndicatorPadding, com.larus.nova.R.attr.pstsScrollOffset, com.larus.nova.R.attr.pstsShouldExpand, com.larus.nova.R.attr.pstsTabBackground, com.larus.nova.R.attr.pstsTabPaddingLeftRight, com.larus.nova.R.attr.pstsTabSpaceing, com.larus.nova.R.attr.pstsTextAllCaps, com.larus.nova.R.attr.pstsUnderlineColor, com.larus.nova.R.attr.pstsUnderlineHeight, com.larus.nova.R.attr.tabIndicatorTextColor});
        this.f102424l = r106.getColor(3, this.f102424l);
        this.f102425m = r106.getColor(12, this.f102425m);
        this.f102426n = r106.getColor(1, this.f102426n);
        this.f102432t = r106.getDimensionPixelSize(4, this.f102432t);
        this.f102433u = r106.getDimensionPixelSize(13, this.f102433u);
        this.f102434v = r106.getDimensionPixelSize(2, this.f102434v);
        this.f102435w = r106.getDimensionPixelSize(9, this.f102435w);
        this.A = r106.getResourceId(8, this.A);
        this.f102427o = r106.getBoolean(7, this.f102427o);
        this.f102431s = r106.getDimensionPixelSize(6, this.f102431s);
        this.f102428p = r106.getBoolean(11, this.f102428p);
        r106.recycle();
        Paint r107 = new Paint();
        this.f102422j = r107;
        r107.setAntiAlias(true);
        r107.setStyle(Paint.Style.FILL);
        Paint r108 = new Paint();
        this.f102423k = r108;
        r108.setAntiAlias(true);
        r108.setStrokeWidth(r104);
        this.f102413a = new LinearLayout.LayoutParams(-2, -1);
        this.f102414b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.B != null) goto L6;
        this.B = getResources().getConfiguration().locale;
        return;
    }

    public static void a(PagerSlidingTabStrip r100, int r101, int r102) {
        if (r100.f102419g == 0) goto L14;
        int r103 = r100.f102417e.getChildAt(r101).getLeft() + r102;
        if (r101 > 0) goto L8;
        if (r102 > 0) goto L8;
    L10:
        if (r103 == r100.f102438z) goto L13;
        r100.f102438z = r103;
        r100.scrollTo(r103, 0);
        return;
    L13:
        return;
    L8:
        r103 = r103 - r100.f102431s;
        goto L10
    }
}

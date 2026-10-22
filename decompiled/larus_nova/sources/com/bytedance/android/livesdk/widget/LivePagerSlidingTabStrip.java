package com.bytedance.android.livesdk.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.r3;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public class LivePagerSlidingTabStrip extends HorizontalScrollView {
    public static final int[] N = null;
    public Typeface A;
    public int B;
    public int C;
    public int D;
    public final Locale E;
    public boolean F;
    public boolean G;
    public final SparseArray<String> H;
    public final SparseArray<String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final SparseArray<String> f161047J;
    public int K;
    public e L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout.LayoutParams f161048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout.LayoutParams f161049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f161050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f161051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f161052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f161053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f161054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f161056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f161057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f161058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f161059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f161060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f161061n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f161062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f161063p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f161064q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f161065r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f161066s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f161067t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f161068u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f161069v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f161070w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f161071x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f161072y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f161073z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f161074a;

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
            this.f161074a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f161074a);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f161075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LivePagerSlidingTabStrip f161076b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f161076b.L;
            if (r101 == null) goto L5;
            r101.onClick();
        L5:
            this.f161076b.f161053f.setCurrentItem(this.f161075a);
        }

        public a(LivePagerSlidingTabStrip r100, int r101) {
            this.f161076b = r100;
            this.f161075a = r101;
        }
    }

    public interface b {
        View c(Context r100, int r101);
    }

    public interface c {
        int a();
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f161077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f161078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f161079c;

        public d() {
        }
    }

    public interface e {
        void onClick();
    }

    public class f implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePagerSlidingTabStrip f161080a;

        public f(LivePagerSlidingTabStrip r100) {
            this.f161080a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L4;
            LivePagerSlidingTabStrip r101 = this.f161080a;
            LivePagerSlidingTabStrip.b(r101, r101.f161053f.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r102 = this.f161080a.f161051d;
            if (r102 == null) goto L8;
            r102.onPageScrollStateChanged(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            ViewPager.OnPageChangeListener r101 = this.f161080a.f161051d;
            if (r101 == null) goto L6;
            r101.onPageSelected(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            LivePagerSlidingTabStrip r103 = this.f161080a;
            int r104 = r103.f161055h;
            if (r104 == r100) goto L5;
            LivePagerSlidingTabStrip.a(r103, r104, false);
            LivePagerSlidingTabStrip.a(this.f161080a, r100, true);
        L5:
            LivePagerSlidingTabStrip r105 = this.f161080a;
            r105.f161055h = r100;
            r105.f161056i = r101;
            LivePagerSlidingTabStrip.b(r105, r100, (int) (r105.f161052e.getChildAt(r100).getWidth() * r101));
            this.f161080a.invalidate();
            ViewPager.OnPageChangeListener r106 = this.f161080a.f161051d;
            if (r106 == null) goto L9;
            r106.onPageScrolled(r100, r101, r102);
            return;
        }
    }

    static {
        N = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final void d() {
        int r100 = 0;
    L4:
        if (r100 >= this.f161054g) goto L9;
        View r101 = this.f161052e.getChildAt(r100);
        r101.setBackgroundResource(this.D);
        Object r102 = r101.getTag();
        if ((r102 instanceof d) == false) goto L8;
        d r103 = (d) r102;
        r103.f161077a.setTextSize(0, this.f161071x);
        r103.f161077a.setTypeface(this.A, this.B);
        r103.f161077a.setTextColor(this.f161072y);
    L8:
        r100 = r100 + 1;
        goto L4
    }

    public void setIconResId(int r100) {
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f161074a = this.f161055h;
        return r100;
    }

    public int getDividerColor() {
        return this.f161063p;
    }

    public int getDividerPadding() {
        return this.f161069v;
    }

    public int getIndicatorColor() {
        return this.f161061n;
    }

    public int getIndicatorHeight() {
        return this.f161067t;
    }

    public int getIndicatorWidth() {
        return this.f161059l;
    }

    public ViewPager getPager() {
        return this.f161053f;
    }

    public int getScrollOffset() {
        return this.f161066s;
    }

    public boolean getShouldExpand() {
        return this.f161064q;
    }

    public int getTabBackground() {
        return this.D;
    }

    public int getTabPaddingLeftRight() {
        return this.f161070w;
    }

    public LinearLayout getTabsContainer() {
        return this.f161052e;
    }

    public ColorStateList getTextColor() {
        return this.f161072y;
    }

    public int getTextSize() {
        return this.f161071x;
    }

    public int getUnderlineColor() {
        return this.f161062o;
    }

    public int getUnderlineHeight() {
        return this.f161068u;
    }

    public LivePagerSlidingTabStrip(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f161054g == 0) goto L33;
        int r100 = getHeight();
        if (TextUtils.isEmpty(this.f161047J.get(this.f161055h)) == true) goto L10;
        this.f161057j.setColor(com.bytedance.android.live.core.utils.s1.i(this.f161047J.get(this.f161055h), this.f161061n));
    L11:
        View r101 = this.f161052e.getChildAt(this.f161055h);
        float r102 = r101.getLeft();
        float r103 = r101.getRight();
        if (this.f161056i <= 0.0f) goto L16;
        int r104 = this.f161055h;
        if (r104 >= (this.f161054g - 1)) goto L16;
        View r105 = this.f161052e.getChildAt(r104 + 1);
        float r106 = r105.getLeft();
        float r107 = r105.getRight();
        float r108 = this.f161056i;
        r102 = (r106 * r108) + ((1.0f - r108) * r102);
        r103 = (r107 * r108) + ((1.0f - r108) * r103);
    L16:
        int r109 = this.f161059l;
        if (r109 == 0) goto L19;
        float r111 = ((r103 - r102) - r109) / 2.0f;
        r102 = r102 + r111;
        r103 = r103 - r111;
    L19:
        float r112 = r103;
        float r113 = r102;
        if (this.F == false) goto L27;
        int r114 = this.f161060m;
        if (r114 > 0) goto L24;
    L26:
        int r115 = r100 - this.f161067t;
        int r116 = this.K;
        r110.drawRect(r113, r115 - r116, r112, r100 - r116, this.f161057j);
        goto L27
    L24:
        if (Build.VERSION.SDK_INT <= 21) goto L26;
        int r117 = r100 - this.f161067t;
        int r118 = this.K;
        r110.drawRoundRect(r113, r117 - r118, r112, r100 - r118, r114, r114, this.f161057j);
    L27:
        this.f161057j.setColor(this.f161062o);
        r110.drawRect(0.0f, r100 - this.f161068u, this.f161052e.getWidth(), r100, this.f161057j);
        this.f161058k.setColor(this.f161063p);
        int r119 = 0;
    L29:
        if (r119 >= (this.f161054g - 1)) goto L34;
        View r120 = this.f161052e.getChildAt(r119);
        r110.drawLine(r120.getRight(), this.f161069v, r120.getRight(), r100 - this.f161069v, this.f161058k);
        r119 = r119 + 1;
        goto L29
    L34:
        return;
    L10:
        this.f161057j.setColor(this.f161061n);
        goto L11
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f161055h = r101.f161074a;
        requestLayout();
    }

    public void setAllCaps(boolean r100) {
        this.f161065r = r100;
    }

    public void setDividerColor(int r100) {
        this.f161063p = r100;
        invalidate();
    }

    public void setDividerColorResource(int r100) {
        this.f161063p = getResources().getColor(r100);
        invalidate();
    }

    public void setDividerPadding(int r100) {
        this.f161069v = r100;
        invalidate();
    }

    public void setEnableIndicator(boolean r100) {
        this.F = r100;
    }

    public void setIncludeFontPadding(boolean r100) {
        this.G = r100;
    }

    public void setIndicatorBottomMargin(int r100) {
        this.K = r100;
    }

    public void setIndicatorColor(int r100) {
        this.f161061n = r100;
        invalidate();
    }

    public void setIndicatorColorResource(int r100) {
        this.f161061n = getResources().getColor(r100);
        invalidate();
    }

    public void setIndicatorHeight(int r100) {
        this.f161067t = r100;
        invalidate();
    }

    public void setIndicatorRadius(int r100) {
        this.f161060m = r100;
        d();
    }

    public void setIndicatorWidth(int r100) {
        this.f161059l = r100;
        d();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f161051d = r100;
    }

    public void setScrollOffset(int r100) {
        this.f161066s = r100;
        invalidate();
    }

    public void setShouldExpand(boolean r100) {
        this.f161064q = r100;
        requestLayout();
    }

    public void setTabBackground(int r100) {
        this.D = r100;
    }

    public void setTabClickListener(e r100) {
        this.L = r100;
    }

    public void setTabPaddingLeftRight(int r100) {
        this.f161070w = r100;
        d();
    }

    public void setTabTextSelectColor(ColorStateList r100) {
        this.f161073z = r100;
    }

    public void setTextColor(int r100) {
        this.f161072y = ColorStateList.valueOf(r100);
        d();
    }

    public void setTextColorResource(int r100) {
        this.f161072y = getResources().getColorStateList(r100);
        d();
    }

    public void setTextSelectedStyle(int r100) {
        this.M = r100;
    }

    public void setTextSize(int r100) {
        this.f161071x = r100;
        d();
    }

    public void setUnderlineColor(int r100) {
        this.f161062o = r100;
        invalidate();
    }

    public void setUnderlineColorResource(int r100) {
        this.f161062o = getResources().getColor(r100);
        invalidate();
    }

    public void setUnderlineHeight(int r100) {
        this.f161068u = r100;
        invalidate();
    }

    public void setViewPager(ViewPager r100) {
        this.f161053f = r100;
        if (r100.getAdapter() == null) goto L20;
        r100.setOnPageChangeListener(this.f161050c);
        this.f161052e.removeAllViews();
        this.f161054g = this.f161053f.getAdapter().getCount();
        int r101 = 0;
    L6:
        if (r101 >= this.f161054g) goto L17;
        if ((this.f161053f.getAdapter() instanceof b) == false) goto L11;
        c(r101, ((b) this.f161053f.getAdapter()).c(getContext(), r101));
    L16:
        r101 = r101 + 1;
        goto L6
    L11:
        if ((this.f161053f.getAdapter() instanceof c) == false) goto L13;
        int r102 = ((c) this.f161053f.getAdapter()).a();
        ImageButton r103 = new ImageButton(getContext());
        r103.setImageResource(r102);
        c(r101, r103);
        goto L16
    L13:
        CharSequence r104 = this.f161053f.getAdapter().getPageTitle(r101);
        if (r104 == null) goto L16;
        String r105 = r104.toString();
        d r106 = new d();
        View r107 = LayoutInflater.from(getContext()).inflate(com.larus.nova.R.layout.ttlive_item_pager_sliding_tab_strip, null, false);
        r106.f161077a = (TextView) r107.findViewById(com.larus.nova.R.id.text);
        View r108 = r107.findViewById(com.larus.nova.R.id.dot);
        r106.f161078b = r108;
        r108.setVisibility(8);
        View r109 = r107.findViewById(com.larus.nova.R.id.icon);
        r106.f161079c = r109;
        r109.setVisibility(8);
        r106.f161077a.setText(r105);
        r106.f161077a.setGravity(17);
        r106.f161077a.setSingleLine();
        r106.f161077a.setIncludeFontPadding(this.G);
        r3.d(r107, r105, false, false);
        r107.setTag(r106);
        c(r101, r107);
        goto L16
    L17:
        d();
        getViewTreeObserver().addOnGlobalLayoutListener(new f1(this));
        return;
    L20:
        throw new IllegalStateException("ViewPager does not have adapter INSTANCE.");
    }

    public LivePagerSlidingTabStrip(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void c(int r100, View r101) {
        r101.setFocusable(true);
        r101.setOnClickListener(new a(this, r100));
        int r102 = this.f161070w;
        r101.setPadding(r102, 0, r102, 0);
        if (RTLUtil.isAppRTL(getContext()) == false) goto L5;
        int r103 = this.f161070w;
        r101.setPaddingRelative(r103, 0, r103, 0);
    L5:
        LinearLayout r104 = this.f161052e;
        if (this.f161064q == false) goto L8;
        LinearLayout.LayoutParams r105 = this.f161049b;
    L9:
        r104.addView(r101, r100, r105);
        return;
    L8:
        r105 = this.f161048a;
        goto L9
    }

    public LivePagerSlidingTabStrip(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f161050c = new f(this);
        this.f161055h = 0;
        this.f161056i = 0.0f;
        this.f161059l = 0;
        this.f161060m = 0;
        this.f161061n = 16737894;
        this.f161062o = 436207616;
        this.f161063p = 436207616;
        this.f161064q = false;
        this.f161065r = true;
        this.f161066s = 52;
        this.f161067t = 8;
        this.f161068u = 2;
        this.f161069v = 12;
        this.f161070w = 24;
        this.f161071x = 12;
        this.f161072y = ColorStateList.valueOf(16737894);
        this.f161073z = null;
        this.A = null;
        this.B = 1;
        this.C = 0;
        this.D = com.larus.nova.R.drawable.ttlive_background_tab;
        this.F = true;
        this.G = true;
        this.H = new SparseArray();
        this.I = new SparseArray();
        this.f161047J = new SparseArray();
        this.K = 0;
        this.M = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r100 = new LinearLayout(r110);
        this.f161052e = r100;
        r100.setOrientation(0);
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r100);
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        this.f161066s = (int) TypedValue.applyDimension(1, this.f161066s, r102);
        this.f161067t = (int) TypedValue.applyDimension(1, this.f161067t, r102);
        this.f161068u = (int) TypedValue.applyDimension(1, this.f161068u, r102);
        this.f161069v = (int) TypedValue.applyDimension(1, this.f161069v, r102);
        this.f161070w = (int) TypedValue.applyDimension(1, this.f161070w, r102);
        int r103 = (int) TypedValue.applyDimension(1, 1, r102);
        this.f161071x = (int) TypedValue.applyDimension(1, this.f161071x, r102);
        this.f161059l = (int) TypedValue.applyDimension(1, this.f161059l, r102);
        TypedArray r104 = r110.obtainStyledAttributes(r111, N);
        this.f161071x = r104.getDimensionPixelSize(0, this.f161071x);
        this.f161072y = r104.getColorStateList(1);
        r104.recycle();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.tab_background, com.larus.nova.R.attr.tab_divider_color, com.larus.nova.R.attr.tab_divider_padding, com.larus.nova.R.attr.tab_height, com.larus.nova.R.attr.tab_indicator_color, com.larus.nova.R.attr.tab_indicator_height, com.larus.nova.R.attr.tab_indicator_radius, com.larus.nova.R.attr.tab_indicator_width, com.larus.nova.R.attr.tab_margin_left, com.larus.nova.R.attr.tab_margin_right, com.larus.nova.R.attr.tab_padding_left_right, com.larus.nova.R.attr.tab_scroll_offset, com.larus.nova.R.attr.tab_should_expand, com.larus.nova.R.attr.tab_text_all_caps, com.larus.nova.R.attr.tab_text_color, com.larus.nova.R.attr.tab_text_select_size, com.larus.nova.R.attr.tab_text_size, com.larus.nova.R.attr.tab_typeface_style, com.larus.nova.R.attr.tab_underline_color, com.larus.nova.R.attr.tab_underline_height, com.larus.nova.R.attr.tab_widget});
        this.f161061n = r113.getColor(4, this.f161061n);
        this.f161062o = r113.getColor(18, this.f161062o);
        this.f161063p = r113.getColor(1, this.f161063p);
        this.f161067t = r113.getDimensionPixelSize(5, this.f161067t);
        this.f161068u = r113.getDimensionPixelSize(19, this.f161068u);
        this.f161069v = r113.getDimensionPixelSize(2, this.f161069v);
        this.f161070w = r113.getDimensionPixelSize(10, this.f161070w);
        this.D = r113.getResourceId(0, this.D);
        this.f161064q = r113.getBoolean(12, this.f161064q);
        this.f161066s = r113.getDimensionPixelSize(11, this.f161066s);
        this.f161065r = r113.getBoolean(13, this.f161065r);
        this.f161071x = r113.getDimensionPixelSize(16, this.f161071x);
        this.f161072y = r113.getColorStateList(14);
        this.f161059l = r113.getDimensionPixelSize(7, this.f161059l);
        this.f161060m = r113.getDimensionPixelSize(6, 0);
        this.B = r113.getInt(17, 1);
        int r114 = r113.getDimensionPixelSize(8, 0);
        int r105 = r113.getDimensionPixelSize(9, 0);
        r113.recycle();
        Paint r115 = new Paint();
        this.f161057j = r115;
        r115.setAntiAlias(true);
        r115.setStyle(Paint.Style.FILL);
        Paint r116 = new Paint();
        this.f161058k = r116;
        r116.setAntiAlias(true);
        r116.setStrokeWidth(r103);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -1);
        this.f161048a = r117;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.f161049b = r106;
        r117.leftMargin = r114;
        r106.leftMargin = r114;
        r117.rightMargin = r105;
        r106.rightMargin = r105;
        if (this.E != null) goto L6;
        this.E = getResources().getConfiguration().locale;
    L6:
        if (this.f161072y != null) goto L9;
        this.f161072y = ColorStateList.valueOf(16737894);
        return;
    }

    public static void a(LivePagerSlidingTabStrip r100, int r101, boolean r102) {
        int r103 = r100.f161052e.getChildCount();
        if (r103 == 0) goto L39;
        if (r101 < 0) goto L35;
        if (r101 >= r103) goto L40;
        View r104 = r100.f161052e.getChildAt(r101);
        r104.setSelected(r102);
        Object r105 = r104.getTag();
        if ((r105 instanceof d) == false) goto L36;
        d r106 = (d) r105;
        if (r102 == false) goto L23;
        String r107 = r100.H.get(r101);
        if (TextUtils.isEmpty(r107) == true) goto L18;
        View r108 = r106.f161079c;
        if ((r108 instanceof HSImageView) == false) goto L18;
        r108.setVisibility(0);
        ImageLoader.bindImage((HSImageView) r106.f161079c, r107);
    L18:
        if (TextUtils.isEmpty(r100.f161047J.get(r101)) == true) goto L20;
        r106.f161077a.setTextColor(com.bytedance.android.live.core.utils.s1.i(r100.f161047J.get(r101), r100.f161061n));
    L20:
        ColorStateList r109 = r100.f161073z;
        if (r109 == null) goto L30;
        r106.f161077a.setTextColor(r109);
    L30:
        if (r100.M != 1) goto L37;
        if (r102 == false) goto L33;
        r106.f161077a.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L33:
        r106.f161077a.setTypeface(Typeface.DEFAULT);
        return;
    L37:
        return;
    L23:
        String r110 = r100.I.get(r101);
        if (TextUtils.isEmpty(r110) == true) goto L28;
        View r111 = r106.f161079c;
        if ((r111 instanceof HSImageView) == false) goto L28;
        r111.setVisibility(0);
        ImageLoader.bindImage((HSImageView) r106.f161079c, r110);
    L28:
        r106.f161077a.setTextColor(r100.f161072y);
        goto L30
    L36:
        return;
    L40:
        return;
    L35:
        return;
    }

    public static void b(LivePagerSlidingTabStrip r100, int r101, int r102) {
        if (r100.f161054g == 0) goto L20;
        View r103 = r100.f161052e.getChildAt(r101);
        if (r103 != null) goto L9;
        return;
    L9:
        if (RTLUtil.isAppRTL(r100.getContext()) == false) goto L11;
        int r104 = r103.getLeft() - r102;
    L12:
        if (r101 > 0) goto L14;
        if (r102 > 0) goto L14;
    L16:
        if (r104 == r100.C) goto L19;
        r100.C = r104;
        r100.scrollTo(r104, 0);
        return;
    L19:
        return;
    L14:
        r104 = r104 - r100.f161066s;
        goto L16
    L11:
        r104 = r103.getLeft() + r102;
        goto L12
    }
}

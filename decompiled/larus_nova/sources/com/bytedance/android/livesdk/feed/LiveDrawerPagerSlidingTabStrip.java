package com.bytedance.android.livesdk.feed;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class LiveDrawerPagerSlidingTabStrip extends HorizontalScrollView {
    public static final int[] N = null;
    public final ColorStateList A;
    public final int B;
    public int C;
    public int D;
    public final Locale E;
    public final SparseArray<String> F;
    public final SparseArray<String> G;
    public e H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f123518J;
    public boolean K;
    public LiveDrawerTabScrollShadow L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout.LayoutParams f123519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout.LayoutParams f123520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f123521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f123522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f123523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f123524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f123525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f123526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f123527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f123528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f123529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f123530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f123531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f123532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f123533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f123534p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f123535q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f123536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f123537s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f123538t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f123539u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f123540v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f123541w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f123542x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f123543y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f123544z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f123545a;

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
            this.f123545a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f123545a);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f123546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveDrawerPagerSlidingTabStrip f123547b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = this.f123547b.H;
            if (r101 == null) goto L5;
            r101.a(this.f123546a);
        L5:
            this.f123547b.f123524f.setCurrentItem(this.f123546a);
        }

        public a(LiveDrawerPagerSlidingTabStrip r100, int r101) {
            this.f123547b = r100;
            this.f123546a = r101;
        }
    }

    public interface b {
        View a();
    }

    public interface c {
        int a();
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f123548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f123549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f123550c;

        public d() {
        }
    }

    public interface e {
        void a(int r100);
    }

    public class f implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDrawerPagerSlidingTabStrip f123551a;

        public f(LiveDrawerPagerSlidingTabStrip r100) {
            this.f123551a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L4;
            LiveDrawerPagerSlidingTabStrip r101 = this.f123551a;
            LiveDrawerPagerSlidingTabStrip.a(r101, r101.f123524f.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r102 = this.f123551a.f123522d;
            if (r102 == null) goto L8;
            r102.onPageScrollStateChanged(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            LiveDrawerPagerSlidingTabStrip r101 = this.f123551a;
            r101.f123526h = r100;
            ViewPager.OnPageChangeListener r102 = r101.f123522d;
            if (r102 == null) goto L5;
            r102.onPageSelected(r100);
        L5:
            this.f123551a.d();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            LiveDrawerPagerSlidingTabStrip r103 = this.f123551a;
            r103.f123527i = r101;
            LiveDrawerPagerSlidingTabStrip.a(r103, r100, (int) (r103.f123523e.getChildAt(r100).getWidth() * r101));
            this.f123551a.invalidate();
            ViewPager.OnPageChangeListener r104 = this.f123551a.f123522d;
            if (r104 == null) goto L6;
            r104.onPageScrolled(r100, r101, r102);
            return;
        }
    }

    static {
        N = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final boolean c() {
        View r100 = getChildAt(0);
        if (r100 == null) goto L8;
        int r101 = r100.getWidth();
        if (getWidth() >= ((r101 + getPaddingLeft()) + getPaddingRight())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public final void d() {
        int r100 = 0;
    L4:
        if (r100 >= this.f123525g) goto L25;
        View r101 = this.f123523e.getChildAt(r100);
        r101.setBackgroundResource(this.D);
        Object r102 = r101.getTag();
        if ((r102 instanceof d) == false) goto L24;
        d r103 = (d) r102;
        TextView r104 = r103.f123548a;
        if (this.f123526h != r100) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        int r106 = this.f123544z;
    L14:
        r104.setTextSize(0, r106);
        r103.f123548a.setTypeface(null, this.B);
        TextView r107 = r103.f123548a;
        if (r100 != this.f123526h) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L20;
        ColorStateList r109 = this.A;
    L21:
        r107.setTextColor(r109);
        if (this.f123536r == false) goto L24;
        r103.f123548a.setAllCaps(true);
        goto L24
    L20:
        r109 = this.f123543y;
        goto L21
    L17:
        r108 = false;
        goto L18
    L13:
        r106 = this.f123542x;
        goto L14
    L10:
        r105 = false;
    L24:
        r100 = r100 + 1;
        goto L4
    }

    public void setIconResId(int r100) {
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f123545a = this.f123526h;
        return r100;
    }

    public int getDividerColor() {
        return this.f123534p;
    }

    public int getDividerPadding() {
        return this.f123540v;
    }

    public int getIndicatorColor() {
        return this.f123532n;
    }

    public int getIndicatorHeight() {
        return this.f123538t;
    }

    public int getIndicatorWidth() {
        return this.f123530l;
    }

    public ViewPager getPager() {
        return this.f123524f;
    }

    public int getScrollOffset() {
        return this.f123537s;
    }

    public boolean getShouldExpand() {
        return this.f123535q;
    }

    public int getTabBackground() {
        return this.D;
    }

    public int getTabPaddingLeftRight() {
        return this.f123541w;
    }

    public ColorStateList getTextColor() {
        return this.f123543y;
    }

    public int getTextSize() {
        return this.f123542x;
    }

    public int getUnderlineColor() {
        return this.f123533o;
    }

    public int getUnderlineHeight() {
        return this.f123539u;
    }

    public LiveDrawerPagerSlidingTabStrip(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(true);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f123525g == 0) goto L40;
        int r100 = getHeight();
        if (TextUtils.isEmpty(this.G.get(this.f123526h)) == true) goto L10;
        this.f123528j.setColor(s1.i(this.G.get(this.f123526h), this.f123532n));
    L11:
        View r101 = this.f123523e.getChildAt(this.f123526h);
        float r102 = r101.getLeft();
        float r103 = r101.getRight();
        if (this.f123527i <= 0.0f) goto L16;
        int r104 = this.f123526h;
        if (r104 >= (this.f123525g - 1)) goto L16;
        View r105 = this.f123523e.getChildAt(r104 + 1);
        float r106 = r105.getLeft();
        float r107 = r105.getRight();
        float r108 = this.f123527i;
        float r109 = 1.0f - r108;
        r102 = (r102 * r109) + (r106 * r108);
        r103 = (r107 * r108) + (r109 * r103);
    L16:
        int r111 = this.f123530l;
        if (r111 == 0) goto L19;
        float r112 = ((r103 - r102) - r111) / 2.0f;
        r102 = r102 + r112;
        r103 = r103 - r112;
    L19:
        float r113 = r103;
        float r114 = r102;
        int r115 = this.f123531m;
        if (r115 > 0) goto L22;
    L24:
        int r116 = r100 - this.f123538t;
        int r117 = this.I;
        r110.drawRect(r114, r116 - r117, r113, r100 - r117, this.f123528j);
    L25:
        this.f123528j.setColor(this.f123533o);
        r110.drawRect(0.0f, r100 - this.f123539u, this.f123523e.getWidth(), r100, this.f123528j);
        int r118 = 0;
        if (c() == true) goto L28;
        this.f123518J = false;
    L34:
        this.f123529k.setColor(this.f123534p);
    L36:
        if (r118 >= (this.f123525g - 1)) goto L41;
        View r119 = this.f123523e.getChildAt(r118);
        r110.drawLine(r119.getRight(), this.f123540v, r119.getRight(), r100 - this.f123540v, this.f123529k);
        r118 = r118 + 1;
        goto L36
    L41:
        return;
    L28:
        LiveDrawerTabScrollShadow r120 = this.L;
        if (r120 == null) goto L34;
        boolean r121 = this.f123518J;
        boolean r122 = this.K;
        r120.f123555d = r122;
        r120.f123556e = r121;
        if (r122 == true) goto L33;
        if (r121 == false) goto L34;
    L33:
        r120.invalidate();
        goto L34
    L22:
        if (Build.VERSION.SDK_INT <= 21) goto L24;
        int r123 = r100 - this.f123538t;
        int r124 = this.I;
        float r125 = r115;
        r110.drawRoundRect(r114, r123 - r124, r113, r100 - r124, r125, r125, this.f123528j);
        goto L25
    L10:
        this.f123528j.setColor(this.f123532n);
        goto L11
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f123526h = r101.f123545a;
        requestLayout();
    }

    public void setAllCaps(boolean r100) {
        this.f123536r = r100;
    }

    public void setDividerColor(int r100) {
        this.f123534p = r100;
        invalidate();
    }

    public void setDividerColorResource(int r100) {
        this.f123534p = getResources().getColor(r100);
        invalidate();
    }

    public void setDividerPadding(int r100) {
        this.f123540v = r100;
        invalidate();
    }

    public void setIndicatorBottomMargin(int r100) {
        this.I = r100;
    }

    public void setIndicatorColor(int r100) {
        this.f123532n = r100;
        invalidate();
    }

    public void setIndicatorColorResource(int r100) {
        this.f123532n = getResources().getColor(r100);
        invalidate();
    }

    public void setIndicatorHeight(int r100) {
        this.f123538t = r100;
        invalidate();
    }

    public void setIndicatorRadius(int r100) {
        this.f123531m = r100;
        d();
    }

    public void setIndicatorWidth(int r100) {
        this.f123530l = r100;
        d();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f123522d = r100;
    }

    public void setOnTabClickListener(e r100) {
        this.H = r100;
    }

    public void setScrollOffset(int r100) {
        this.f123537s = r100;
        invalidate();
    }

    public void setShadeView(LiveDrawerTabScrollShadow r100) {
        this.L = r100;
    }

    public void setShouldExpand(boolean r100) {
        this.f123535q = r100;
        requestLayout();
    }

    public void setTabBackground(int r100) {
        this.D = r100;
    }

    public void setTabPaddingLeftRight(int r100) {
        this.f123541w = r100;
        d();
    }

    public void setTabTextSelectSize(int r100) {
        this.f123544z = r100;
        d();
    }

    public void setTextColor(int r100) {
        this.f123543y = ColorStateList.valueOf(r100);
        d();
    }

    public void setTextColorResource(int r100) {
        this.f123543y = getResources().getColorStateList(r100);
        d();
    }

    public void setTextSelectedStyle(int r100) {
        this.M = r100;
    }

    public void setTextSize(int r100) {
        this.f123542x = r100;
        d();
    }

    public void setUnderlineColor(int r100) {
        this.f123533o = r100;
        invalidate();
    }

    public void setUnderlineColorResource(int r100) {
        this.f123533o = getResources().getColor(r100);
        invalidate();
    }

    public void setUnderlineHeight(int r100) {
        this.f123539u = r100;
        invalidate();
    }

    public void setViewPager(ViewPager r100) {
        this.f123524f = r100;
        if (r100.getAdapter() == null) goto L20;
        r100.setOnPageChangeListener(this.f123521c);
        this.f123523e.removeAllViews();
        this.f123525g = this.f123524f.getAdapter().getCount();
        int r101 = 0;
    L6:
        if (r101 >= this.f123525g) goto L17;
        if ((this.f123524f.getAdapter() instanceof b) == false) goto L11;
        b r102 = (b) this.f123524f.getAdapter();
        getContext();
        b(r101, r102.a());
    L16:
        r101 = r101 + 1;
        goto L6
    L11:
        if ((this.f123524f.getAdapter() instanceof c) == false) goto L13;
        int r103 = ((c) this.f123524f.getAdapter()).a();
        ImageButton r104 = new ImageButton(getContext());
        r104.setImageResource(r103);
        b(r101, r104);
        goto L16
    L13:
        CharSequence r105 = this.f123524f.getAdapter().getPageTitle(r101);
        if (r105 == null) goto L16;
        String r106 = r105.toString();
        d r107 = new d();
        View r108 = LayoutInflater.from(getContext()).inflate(com.larus.nova.R.layout.ttlive_item_pager_sliding_tab_strip, null, false);
        r107.f123548a = (TextView) r108.findViewById(com.larus.nova.R.id.text);
        View r109 = r108.findViewById(com.larus.nova.R.id.dot);
        r107.f123549b = r109;
        r109.setVisibility(8);
        View r110 = r108.findViewById(com.larus.nova.R.id.icon);
        r107.f123550c = r110;
        r110.setVisibility(8);
        r107.f123548a.setText(r106);
        r107.f123548a.setGravity(17);
        r107.f123548a.setSingleLine();
        r108.setTag(r107);
        b(r101, r108);
        goto L16
    L17:
        d();
        getViewTreeObserver().addOnGlobalLayoutListener(new w0(this));
        return;
    L20:
        throw new IllegalStateException("ViewPager does not have adapter INSTANCE.");
    }

    public LiveDrawerPagerSlidingTabStrip(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(int r100, View r101) {
        r101.setFocusable(true);
        r101.setOnClickListener(new a(this, r100));
        int r102 = this.f123541w;
        r101.setPadding(r102, 0, r102, 0);
        if (RTLUtil.isAppRTL(getContext()) == false) goto L5;
        int r103 = this.f123541w;
        r101.setPaddingRelative(r103, 0, r103, 0);
    L5:
        LinearLayout r104 = this.f123523e;
        if (this.f123535q == false) goto L8;
        LinearLayout.LayoutParams r105 = this.f123520b;
    L9:
        r104.addView(r101, r100, r105);
        return;
    L8:
        r105 = this.f123519a;
        goto L9
    }

    public LiveDrawerPagerSlidingTabStrip(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f123521c = new f(this);
        this.f123526h = 0;
        this.f123527i = 0.0f;
        this.f123530l = 0;
        this.f123531m = 0;
        this.f123532n = 16737894;
        this.f123533o = 436207616;
        this.f123534p = 436207616;
        this.f123535q = false;
        this.f123536r = true;
        this.f123537s = 52;
        this.f123538t = 8;
        this.f123539u = 2;
        this.f123540v = 12;
        this.f123541w = 24;
        this.f123542x = 12;
        this.f123543y = ColorStateList.valueOf(16737894);
        this.f123544z = 20;
        ColorStateList r100 = getResources().getColorStateList(com.larus.nova.R.color.ttlive_feed_tab_select_color);
        this.A = r100;
        this.B = 1;
        this.C = 0;
        this.D = com.larus.nova.R.drawable.ttlive_background_tab;
        this.F = new SparseArray();
        new SparseArray();
        this.G = new SparseArray();
        this.I = 0;
        this.f123518J = false;
        this.K = false;
        this.L = null;
        this.M = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r101 = new LinearLayout(r110);
        this.f123523e = r101;
        r101.setOrientation(0);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r101);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        this.f123537s = (int) TypedValue.applyDimension(1, this.f123537s, r103);
        this.f123538t = (int) TypedValue.applyDimension(1, this.f123538t, r103);
        this.f123539u = (int) TypedValue.applyDimension(1, this.f123539u, r103);
        this.f123540v = (int) TypedValue.applyDimension(1, this.f123540v, r103);
        this.f123541w = (int) TypedValue.applyDimension(1, this.f123541w, r103);
        int r104 = (int) TypedValue.applyDimension(1, 1, r103);
        this.f123542x = (int) TypedValue.applyDimension(1, this.f123542x, r103);
        this.f123544z = (int) TypedValue.applyDimension(1, this.f123544z, r103);
        this.f123530l = (int) TypedValue.applyDimension(1, this.f123530l, r103);
        TypedArray r105 = r110.obtainStyledAttributes(r111, N);
        this.f123542x = r105.getDimensionPixelSize(0, this.f123542x);
        this.f123543y = r105.getColorStateList(1);
        r105.recycle();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.tab_background, com.larus.nova.R.attr.tab_divider_color, com.larus.nova.R.attr.tab_divider_padding, com.larus.nova.R.attr.tab_height, com.larus.nova.R.attr.tab_indicator_color, com.larus.nova.R.attr.tab_indicator_height, com.larus.nova.R.attr.tab_indicator_radius, com.larus.nova.R.attr.tab_indicator_width, com.larus.nova.R.attr.tab_margin_left, com.larus.nova.R.attr.tab_margin_right, com.larus.nova.R.attr.tab_padding_left_right, com.larus.nova.R.attr.tab_scroll_offset, com.larus.nova.R.attr.tab_should_expand, com.larus.nova.R.attr.tab_text_all_caps, com.larus.nova.R.attr.tab_text_color, com.larus.nova.R.attr.tab_text_select_size, com.larus.nova.R.attr.tab_text_size, com.larus.nova.R.attr.tab_typeface_style, com.larus.nova.R.attr.tab_underline_color, com.larus.nova.R.attr.tab_underline_height, com.larus.nova.R.attr.tab_widget});
        this.f123532n = r113.getColor(4, this.f123532n);
        this.f123533o = r113.getColor(18, this.f123533o);
        this.f123534p = r113.getColor(1, this.f123534p);
        this.f123538t = r113.getDimensionPixelSize(5, this.f123538t);
        this.f123539u = r113.getDimensionPixelSize(19, this.f123539u);
        this.f123540v = r113.getDimensionPixelSize(2, this.f123540v);
        this.f123541w = r113.getDimensionPixelSize(10, this.f123541w);
        this.D = r113.getResourceId(0, this.D);
        this.f123535q = r113.getBoolean(12, this.f123535q);
        this.f123537s = r113.getDimensionPixelSize(11, this.f123537s);
        this.f123536r = r113.getBoolean(13, this.f123536r);
        this.f123542x = r113.getDimensionPixelSize(16, this.f123542x);
        this.f123543y = r113.getColorStateList(14);
        this.f123544z = r113.getDimensionPixelSize(15, this.f123544z);
        this.f123530l = r113.getDimensionPixelSize(7, this.f123530l);
        this.f123531m = r113.getDimensionPixelSize(6, 0);
        this.B = r113.getInt(17, 1);
        r113.recycle();
        Paint r114 = new Paint();
        this.f123528j = r114;
        r114.setAntiAlias(true);
        r114.setStyle(Paint.Style.FILL);
        Paint r115 = new Paint();
        this.f123529k = r115;
        r115.setAntiAlias(true);
        r115.setStrokeWidth(r104);
        this.f123519a = new LinearLayout.LayoutParams(-2, -1);
        this.f123520b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.E != null) goto L6;
        this.E = getResources().getConfiguration().locale;
    L6:
        if (this.f123543y != null) goto L8;
        this.f123543y = ColorStateList.valueOf(16737894);
    L8:
        if (r100 != null) goto L11;
        this.A = this.f123543y;
        return;
    }

    public static void a(LiveDrawerPagerSlidingTabStrip r100, int r101, int r102) {
        if (r100.f123525g == 0) goto L20;
        View r103 = r100.f123523e.getChildAt(r101);
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
        r104 = r104 - r100.f123537s;
        goto L16
    L11:
        r104 = r103.getLeft() + r102;
        goto L12
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        int r104 = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
        if (c() == false) goto L6;
        this.K = true;
        this.f123518J = true;
    L6:
        if (getScrollX() != 0) goto L9;
        this.K = false;
    L11:
        boolean r105 = this.f123518J;
        if (r105 == false) goto L14;
    L15:
        LiveDrawerTabScrollShadow r106 = this.L;
        if (r106 == null) goto L23;
        boolean r107 = this.K;
        r106.f123555d = r107;
        r106.f123556e = r105;
        if (r107 == true) goto L20;
        if (r105 == true) goto L20;
        return;
    L20:
        r106.invalidate();
        return;
    L23:
        return;
    L14:
        if (this.K == true) goto L15;
        return;
    L9:
        if (getScrollX() != r104) goto L11;
        this.f123518J = false;
        goto L11
    }
}

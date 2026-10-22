package com.tmall.ultraviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$styleable;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.tangram.view.TangramBannerView;
import com.google.common.primitives.Ints;
import d9.a;

/* JADX INFO: loaded from: classes4.dex */
public class UltraViewPager extends RelativeLayout implements IUltraViewPagerFeature {
    private boolean isScrollNextPageFirst;
    private TimerHandler.TimerHandlerListener mTimerHandlerListener;
    private int maxHeight;
    private final Point maxSize;
    private int maxWidth;
    private UltraViewPagerIndicator pagerIndicator;
    private float ratio;
    private final Point size;
    private TimerHandler timer;
    private UltraViewPagerView viewPager;

    public static final enum Orientation extends Enum<Orientation> {
        private static final /* synthetic */ Orientation[] $VALUES = null;
        public static final Orientation HORIZONTAL = null;
        public static final Orientation VERTICAL = null;

        private static /* synthetic */ Orientation[] $values() {
            return new Orientation[]{HORIZONTAL, VERTICAL};
        }

        static {
            HORIZONTAL = new Orientation("HORIZONTAL", 0);
            VERTICAL = new Orientation("VERTICAL", 1);
            $VALUES = $values();
        }

        private Orientation(String r10, int r11) {
            super(r10, r11);
        }

        public static Orientation valueOf(String r10) {
            return (Orientation) Enum.valueOf(Orientation.class, r10);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }
    }

    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        private static final /* synthetic */ ScrollDirection[] $VALUES = null;
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;
        public static final ScrollDirection NONE = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        int f18210id;

        private static /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{NONE, BACKWARD, FORWARD};
        }

        static {
            NONE = new ScrollDirection("NONE", 0, 0);
            BACKWARD = new ScrollDirection("BACKWARD", 1, 1);
            FORWARD = new ScrollDirection("FORWARD", 2, 2);
            $VALUES = $values();
        }

        private ScrollDirection(String r10, int r11, int r12) {
            super(r10, r11);
            this.f18210id = r12;
        }

        public static ScrollDirection getScrollDirection(int r10) {
            ScrollDirection[] r11 = values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            ScrollDirection r14 = r11[r13];
            if (r14.f18210id == r10) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            throw new IllegalArgumentException();
        }

        public static ScrollDirection valueOf(String r10) {
            return (ScrollDirection) Enum.valueOf(ScrollDirection.class, r10);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) $VALUES.clone();
        }
    }

    public static final enum ScrollMode extends Enum<ScrollMode> {
        private static final /* synthetic */ ScrollMode[] $VALUES = null;
        public static final ScrollMode HORIZONTAL = null;
        public static final ScrollMode VERTICAL = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        int f18211id;

        private static /* synthetic */ ScrollMode[] $values() {
            return new ScrollMode[]{HORIZONTAL, VERTICAL};
        }

        static {
            HORIZONTAL = new ScrollMode("HORIZONTAL", 0, 0);
            VERTICAL = new ScrollMode("VERTICAL", 1, 1);
            $VALUES = $values();
        }

        private ScrollMode(String r10, int r11, int r12) {
            super(r10, r11);
            this.f18211id = r12;
        }

        public static ScrollMode getScrollMode(int r10) {
            ScrollMode[] r11 = values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            ScrollMode r14 = r11[r13];
            if (r14.f18211id == r10) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            throw new IllegalArgumentException();
        }

        public static ScrollMode valueOf(String r10) {
            return (ScrollMode) Enum.valueOf(ScrollMode.class, r10);
        }

        public static ScrollMode[] values() {
            return (ScrollMode[]) $VALUES.clone();
        }
    }

    public UltraViewPager(Context r10) {
        super(r10);
        this.ratio = Float.NaN;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.isScrollNextPageFirst = true;
        this.mTimerHandlerListener = new AnonymousClass2(this);
        this.size = new Point();
        this.maxSize = new Point();
        initView();
    }

    public static /* synthetic */ UltraViewPagerIndicator access$000(UltraViewPager r10) {
        return r10.pagerIndicator;
    }

    private void constrainTo(Point r10, Point r11) {
        int r12 = r11.x;
        if (r12 >= 0) goto L5;
    L7:
        int r13 = r11.y;
        if (r13 >= 0) goto L10;
        return;
    L10:
        if (r10.y <= r13) goto L14;
        r10.y = r13;
        return;
    L14:
        return;
    L5:
        if (r10.x <= r12) goto L7;
        r10.x = r12;
        goto L7
    }

    private void initView() {
        UltraViewPagerView r10 = new UltraViewPagerView(getContext());
        this.viewPager = r10;
        r10.setImportantForAccessibility(2);
        this.viewPager.setId(View.generateViewId());
        addView(this.viewPager, new ViewGroup.LayoutParams(-1, -1));
    }

    private void reportBannerExpose() {
        if (this.isScrollNextPageFirst == false) goto L7;
        this.isScrollNextPageFirst = false;
        return;
    L7:
        if (BaseApplication.c().p() == false) goto L14;
        View r10 = this.viewPager.getChildAt(0);
        if ((r10 instanceof TangramBannerView) == false) goto L15;
        TangramBannerView r11 = (TangramBannerView) r10;
        Topic r12 = r11.getTopic();
        if (r12 == null) goto L16;
        a.e().l(r12, r11.getCell().pos);
        return;
    L16:
        return;
    L15:
        return;
    }

    private void startTimer() {
        TimerHandler r10 = this.timer;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStopped == false) goto L10;
        r10.listener = this.mTimerHandlerListener;
        r10.removeCallbacksAndMessages(null);
        TimerHandler r11 = this.timer;
        r11.sendEmptyMessageDelayed(87108, r11.interval);
        this.timer.isStopped = false;
        return;
    }

    private void stopTimer() {
        TimerHandler r10 = this.timer;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStopped == true) goto L10;
        r10.removeCallbacksAndMessages(null);
        TimerHandler r11 = this.timer;
        r11.listener = null;
        r11.isStopped = true;
        return;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void disableAutoScroll() {
        stopTimer();
        this.timer = null;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void disableIndicator() {
        UltraViewPagerIndicator r10 = this.pagerIndicator;
        if (r10 == null) goto L6;
        removeView(r10);
        this.pagerIndicator = null;
        return;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void disableScrollDirection(ScrollDirection r10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (this.timer == null) goto L13;
        int r11 = r10.getAction();
        if (r11 != 0) goto L8;
        stopTimer();
    L8:
        if (r11 != 1) goto L10;
    L11:
        startTimer();
        goto L13
    L10:
        if (r11 == 3) goto L11;
    L13:
        return super.dispatchTouchEvent(r10);
    }

    public PagerAdapter getAdapter() {
        if (this.viewPager.getAdapter() != null) goto L6;
        return null;
    L6:
        return ((UltraViewPagerAdapter) this.viewPager.getAdapter()).getAdapter();
    }

    public int getCurrentItem() {
        return this.viewPager.getCurrentItem();
    }

    public IUltraIndicatorBuilder getIndicator() {
        return this.pagerIndicator;
    }

    public ViewPager getViewPager() {
        return this.viewPager;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public IUltraIndicatorBuilder initIndicator() {
        disableIndicator();
        UltraViewPagerIndicator r10 = new UltraViewPagerIndicator(getContext());
        this.pagerIndicator = r10;
        r10.setViewPager(this.viewPager);
        this.pagerIndicator.setIndicatorBuildListener(new AnonymousClass1(this));
        return this.pagerIndicator;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTimer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopTimer();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        startTimer();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (Float.isNaN(this.ratio) == true) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(r10) / this.ratio), Ints.MAX_POWER_OF_TWO);
    L5:
        this.size.set(View.MeasureSpec.getSize(r10), View.MeasureSpec.getSize(r11));
        int r12 = this.maxWidth;
        if (r12 < 0) goto L8;
    L9:
        this.maxSize.set(r12, this.maxHeight);
        constrainTo(this.size, this.maxSize);
        r10 = View.MeasureSpec.makeMeasureSpec(this.size.x, Ints.MAX_POWER_OF_TWO);
        r11 = View.MeasureSpec.makeMeasureSpec(this.size.y, Ints.MAX_POWER_OF_TWO);
    L11:
        if (this.viewPager.getConstrainLength() > 0) goto L13;
        super.onMeasure(r10, r11);
        return;
    L13:
        if (this.viewPager.getConstrainLength() != r11) goto L16;
        this.viewPager.measure(r10, r11);
        Point r13 = this.size;
        setMeasuredDimension(r13.x, r13.y);
        return;
    L16:
        if (this.viewPager.getScrollMode() != ScrollMode.HORIZONTAL) goto L18;
        super.onMeasure(r10, this.viewPager.getConstrainLength());
        return;
    L18:
        super.onMeasure(this.viewPager.getConstrainLength(), r11);
        return;
    L8:
        if (this.maxHeight < 0) goto L11;
        goto L9
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopTimer();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r11 != 0) goto L5;
        startTimer();
        return;
    L5:
        stopTimer();
    }

    public void scheduleNextPageScroll(int r10) {
        TimerHandler r11 = this.timer;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isStopped == true) goto L10;
        r11.removeCallbacksAndMessages(null);
        this.timer.sendEmptyMessageDelayed(87108, r10);
        return;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void scrollNextPage() {
        if (isShown() == true) goto L5;
        return;
    L5:
        UltraViewPagerView r10 = this.viewPager;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.getAdapter() != null) goto L10;
        return;
    L10:
        if (this.viewPager.getAdapter().getCount() <= 0) goto L19;
        int r11 = this.viewPager.getCurrentItemFake();
        reportBannerExpose();
        if (r11 >= (this.viewPager.getAdapter().getCount() - 1)) goto L14;
        int r12 = r11 + 1;
    L15:
        this.viewPager.setCurrentItemFake(r12, true);
        return;
    L14:
        r12 = 0;
        goto L15
    }

    public void setAdapter(PagerAdapter r10) {
        this.viewPager.setAdapter(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setAutoMeasureHeight(boolean r10) {
        this.viewPager.setAutoMeasureHeight(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setAutoScroll(int r10) {
        if (r10 != 0) goto L5;
        return;
    L5:
        if (this.timer == null) goto L7;
        disableAutoScroll();
    L7:
        this.timer = new TimerHandler(this.mTimerHandlerListener, r10);
        startTimer();
    }

    public void setCurrentItem(int r10) {
        this.viewPager.setCurrentItem(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setHGap(int r10) {
        int r11 = getContext().getResources().getDisplayMetrics().widthPixels;
        this.viewPager.setMultiScreen((r11 - r10) / r11);
        this.viewPager.setPageMargin(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setInfiniteLoop(boolean r10) {
        this.viewPager.setEnableLoop(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setInfiniteRatio(int r10) {
        if (this.viewPager.getAdapter() != null) goto L5;
        return;
    L5:
        if ((this.viewPager.getAdapter() instanceof UltraViewPagerAdapter) == false) goto L9;
        ((UltraViewPagerAdapter) this.viewPager.getAdapter()).setInfiniteRatio(r10);
        return;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setItemMargin(int r10, int r11, int r12, int r13) {
        this.viewPager.setItemMargin(r10, r11, r12, r13);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setItemRatio(double r10) {
        this.viewPager.setItemRatio(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setMaxHeight(int r10) {
        this.maxHeight = r10;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setMaxWidth(int r10) {
        this.maxWidth = r10;
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setMultiScreen(float r10) {
        if (r10 <= 0.0f) goto L11;
        if (r10 > 1.0f) goto L11;
        if (r10 > 1.0f) goto L12;
        this.viewPager.setMultiScreen(r10);
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("");
    }

    public void setOffscreenPageLimit(int r10) {
        this.viewPager.setOffscreenPageLimit(r10);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r10) {
        UltraViewPagerIndicator r11 = this.pagerIndicator;
        if (r11 != null) goto L5;
        this.viewPager.setOnPageChangeListener(r10);
        return;
    L5:
        r11.setPageChangeListener(r10);
    }

    public void setPageTransformer(boolean r10, ViewPager.PageTransformer r11) {
        this.viewPager.setPageTransformer(r10, r11);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setRatio(float r10) {
        this.ratio = r10;
        this.viewPager.setRatio(r10);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setScrollMargin(int r10, int r11) {
        this.viewPager.setPadding(r10, 0, r11, 0);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public void setScrollMode(ScrollMode r10) {
        this.viewPager.setScrollMode(r10);
    }

    public void setCurrentItem(int r10, boolean r11) {
        this.viewPager.setCurrentItem(r10, r11);
    }

    private void initView(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.UltraViewPager);
        setAutoScroll(r12.getInt(R$styleable.UltraViewPager_upv_autoscroll, 0));
        setInfiniteLoop(r12.getBoolean(R$styleable.UltraViewPager_upv_infiniteloop, false));
        setRatio(r12.getFloat(R$styleable.UltraViewPager_upv_ratio, Float.NaN));
        setScrollMode(ScrollMode.getScrollMode(r12.getInt(R$styleable.UltraViewPager_upv_scrollmode, 0)));
        disableScrollDirection(ScrollDirection.getScrollDirection(r12.getInt(R$styleable.UltraViewPager_upv_disablescroll, 0)));
        setMultiScreen(r12.getFloat(R$styleable.UltraViewPager_upv_multiscreen, 1.0f));
        setAutoMeasureHeight(r12.getBoolean(R$styleable.UltraViewPager_upv_automeasure, false));
        setItemRatio(r12.getFloat(R$styleable.UltraViewPager_upv_itemratio, Float.NaN));
        r12.recycle();
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public IUltraIndicatorBuilder initIndicator(int r10, int r11, int r12, int r13) {
        return initIndicator().setFocusColor(r10).setNormalColor(r11).setRadius(r12).setGravity(r13);
    }

    public UltraViewPager(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.ratio = Float.NaN;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.isScrollNextPageFirst = true;
        this.mTimerHandlerListener = new AnonymousClass2(this);
        this.size = new Point();
        this.maxSize = new Point();
        initView();
        initView(r10, r11);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public IUltraIndicatorBuilder initIndicator(int r10, int r11, int r12, int r13, int r14, int r15) {
        return initIndicator().setFocusColor(r10).setNormalColor(r11).setStrokeWidth(r13).setStrokeColor(r12).setRadius(r14).setGravity(r15);
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public IUltraIndicatorBuilder initIndicator(int r10, int r11, int r12) {
        return initIndicator().setFocusResId(r10).setNormalResId(r11).setGravity(r12);
    }

    public UltraViewPager(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.ratio = Float.NaN;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.isScrollNextPageFirst = true;
        this.mTimerHandlerListener = new AnonymousClass2(this);
        this.size = new Point();
        this.maxSize = new Point();
        initView();
    }

    @Override // com.tmall.ultraviewpager.IUltraViewPagerFeature
    public IUltraIndicatorBuilder initIndicator(Bitmap r10, Bitmap r11, int r12) {
        return initIndicator().setFocusIcon(r10).setNormalIcon(r11).setGravity(r12);
    }
}

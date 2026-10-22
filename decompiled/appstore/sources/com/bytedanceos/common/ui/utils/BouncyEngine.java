package com.bytedanceos.common.ui.utils;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.tangram.bouncy.DecelerateSmoothScroller;
import com.bytedanceos.common.tangram.bouncy.SpringScroller;
import com.bytedanceos.common.view.RecyclerviewCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class BouncyEngine implements SpringScroller.SpringScrollerListener {
    private boolean isSpringFirstValue;
    private final Object lockSpring;
    private BouncyConfig mConfig;
    private boolean mFirstScrollBy;
    private boolean mFlingOverScrollBack;
    private int mGapLimitPx;
    private final GestureDetectorCompat mGestureDetector;
    private boolean mGestureOnIntercept;
    private final Handler mHandlerUI;
    private HeaderFooterUtil mHeaderFooterUtil;
    private boolean mIsScrollBack;
    private VirtualLayoutManager mLayoutManager;
    private RecyclerviewCompat mListView;
    private int mPrevFooterVisible;
    private int mPrevHeaderVisible;
    private long mPrevTime;
    private double mScrollSpeed;
    private DecelerateSmoothScroller mScroller;
    private boolean mShouldUseSpring;
    private SpringScroller mSpringScroller;
    private int minDistanceToScrollBack;

    public class MouseOverScrollFooterAnchor implements View.OnGenericMotionListener, Runnable {
        private static final int ANCHOR = 1;
        final /* synthetic */ BouncyEngine this$0;

        private MouseOverScrollFooterAnchor(BouncyEngine r10) {
            this.this$0 = r10;
        }

        @Override // android.view.View.OnGenericMotionListener
        public boolean onGenericMotion(View r10, MotionEvent r11) {
            if (r11.getAction() == 8) goto L5;
            return false;
        L5:
            if (r11.getAxisValue(9) >= 0.0f) goto L15;
            r10.post(this);
            if (BouncyEngine.access$100(this.this$0) <= 0) goto L9;
            return true;
        L9:
            if (BouncyEngine.access$200(this.this$0) <= 0) goto L16;
            return true;
        L16:
            return false;
        L15:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BouncyEngine.access$800(this.this$0) == null) goto L10;
            int r10 = BouncyEngine.access$100(this.this$0);
            int r11 = BouncyEngine.access$200(this.this$0);
            if (r10 <= 1) goto L7;
            BouncyEngine.access$800(this.this$0).scrollBy(0, (-r10) + 1);
            return;
        L7:
            if (r11 <= 1) goto L12;
            BouncyEngine.access$800(this.this$0).scrollBy(0, (-r11) + 1);
            return;
        L12:
            return;
        }

        public /* synthetic */ MouseOverScrollFooterAnchor(BouncyEngine r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static class SimpleOnItemTouchListener implements RecyclerView.OnItemTouchListener {
        public SimpleOnItemTouchListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r10) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView r10, MotionEvent r11) {
        }
    }

    public BouncyEngine(RecyclerviewCompat r10, HeaderFooterUtil r11) {
        this(r10, r11, BouncyConfig.DEFAULT);
    }

    public static /* synthetic */ boolean access$002(BouncyEngine r10, boolean r11) {
        r10.mFlingOverScrollBack = r11;
        return r11;
    }

    public static /* synthetic */ int access$100(BouncyEngine r10) {
        return r10.getFooterVisibleLength();
    }

    public static /* synthetic */ Handler access$1000(BouncyEngine r10) {
        return r10.mHandlerUI;
    }

    public static /* synthetic */ void access$1200(BouncyEngine r10, int r11, int r12) {
        r10.computeScrollSpeed(r11, r12);
    }

    public static /* synthetic */ boolean access$1300(BouncyEngine r10) {
        return r10.mIsScrollBack;
    }

    public static /* synthetic */ boolean access$1302(BouncyEngine r10, boolean r11) {
        r10.mIsScrollBack = r11;
        return r11;
    }

    public static /* synthetic */ SpringScroller access$1400(BouncyEngine r10) {
        return r10.mSpringScroller;
    }

    public static /* synthetic */ int access$1500(BouncyEngine r10) {
        return r10.minDistanceToScrollBack;
    }

    public static /* synthetic */ int access$1502(BouncyEngine r10, int r11) {
        r10.minDistanceToScrollBack = r11;
        return r11;
    }

    public static /* synthetic */ double access$1600(BouncyEngine r10) {
        return r10.mScrollSpeed;
    }

    public static /* synthetic */ int access$1700(BouncyEngine r10, double r11, int r12) {
        return r10.getMinDistanceToScrollBack(r11, r12);
    }

    public static /* synthetic */ void access$1800(BouncyEngine r10, int r11) {
        r10.scrollBack(r11);
    }

    public static /* synthetic */ void access$1900(BouncyEngine r10, double r11, int r12, boolean r13) {
        r10.reduceScrollSpeed(r11, r12, r13);
    }

    public static /* synthetic */ int access$200(BouncyEngine r10) {
        return r10.getHeaderVisibleLength();
    }

    public static /* synthetic */ long access$2002(BouncyEngine r10, long r11) {
        r10.mPrevTime = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$2102(BouncyEngine r10, boolean r11) {
        r10.mShouldUseSpring = r11;
        return r11;
    }

    public static /* synthetic */ void access$2200(BouncyEngine r10) {
        r10.onActionUp();
    }

    public static /* synthetic */ GestureDetectorCompat access$2300(BouncyEngine r10) {
        return r10.mGestureDetector;
    }

    public static /* synthetic */ boolean access$2400(BouncyEngine r10) {
        return r10.shouldInterceptTouch();
    }

    public static /* synthetic */ boolean access$302(BouncyEngine r10, boolean r11) {
        r10.mFirstScrollBy = r11;
        return r11;
    }

    public static /* synthetic */ int access$400(BouncyEngine r10) {
        return r10.mGapLimitPx;
    }

    public static /* synthetic */ boolean access$500(BouncyEngine r10) {
        return r10.directionVertical();
    }

    public static /* synthetic */ void access$600(BouncyEngine r10, int r11) {
        r10.scrollBy(r11);
    }

    public static /* synthetic */ boolean access$700(BouncyEngine r10) {
        return r10.mGestureOnIntercept;
    }

    public static /* synthetic */ boolean access$702(BouncyEngine r10, boolean r11) {
        r10.mGestureOnIntercept = r11;
        return r11;
    }

    public static /* synthetic */ RecyclerviewCompat access$800(BouncyEngine r10) {
        return r10.mListView;
    }

    public static /* synthetic */ VirtualLayoutManager access$900(BouncyEngine r10) {
        return r10.mLayoutManager;
    }

    private void computeScrollSpeed(int r10, int r11) {
        long r12 = SystemClock.elapsedRealtime();
        if (directionVertical() == false) goto L6;
        r10 = r11;
    L6:
        if (this.mFirstScrollBy == false) goto L19;
        this.mFirstScrollBy = false;
        if (this.mLayoutManager.getReverseLayout() == false) goto L10;
        int r13 = -1;
    L11:
        int r14 = r13 * r10;
        if (r14 <= 0) goto L14;
        r10 = getFooterVisibleLength();
    L17:
        if (this.mLayoutManager.getReverseLayout() == false) goto L19;
        r10 = r10 * (-1);
        goto L19
    L14:
        if (r14 >= 0) goto L17;
        r10 = getHeaderVisibleLength();
        goto L17
    L10:
        r13 = 1;
    L19:
        this.mScrollSpeed = ((double) r10) / (r12 - this.mPrevTime);
        this.mPrevTime = r12;
    }

    public static BouncyEngine configBouncy(RecyclerviewCompat r10, HeaderFooterUtil r11) {
        return new BouncyEngine(r10, r11);
    }

    private void configListView() {
        initScrollListener();
        initTouchListener();
        initGenericMotionListener();
    }

    private boolean directionVertical() {
        if (this.mLayoutManager.getOrientation() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private double dpToPx(double r10) {
        return r10 * (((double) BaseApplication.c().getResources().getDisplayMetrics().densityDpi) / 160.0d);
    }

    private int getDecelTargetPos(int r10, boolean r11) {
        if (r10 <= 0) goto L7;
        if (r11 == false) goto L6;
        return this.mHeaderFooterUtil.getLastVisiblePosition();
    L6:
        return this.mHeaderFooterUtil.getFirstVisiblePosition();
    L7:
        return 0;
    }

    private PointF getDecelVector() {
        int r10 = -1;
        if (directionVertical() == false) goto L10;
        if (this.mLayoutManager.getReverseLayout() == true) goto L8;
        r10 = 1;
    L8:
        return new PointF(0.0f, r10);
    L10:
        if (this.mLayoutManager.getReverseLayout() == true) goto L13;
        r10 = 1;
    L13:
        return new PointF(r10, 0.0f);
    }

    private int getFooterVisible(int r10) {
        return Math.max(0, (this.mListView.getHeight() - r10) - this.mListView.getPaddingBottom());
    }

    private int getFooterVisibleLength() {
        int r10 = this.mHeaderFooterUtil.getFooterTop();
        if (r10 >= 0) goto L6;
        this.mPrevFooterVisible = 0;
        return 0;
    L6:
        int r11 = getFooterVisible(r10);
        this.mPrevFooterVisible = r11;
        return r11;
    }

    private int getHeaderVisible(int r10) {
        return Math.max(0, r10 + this.mListView.getPaddingTop());
    }

    private int getHeaderVisibleLength() {
        int r10 = this.mHeaderFooterUtil.getHeaderBottom();
        if (r10 >= 0) goto L6;
        this.mPrevHeaderVisible = 0;
        return 0;
    L6:
        int r11 = getHeaderVisible(r10);
        this.mPrevHeaderVisible = r11;
        return r11;
    }

    private int getMinDistanceToScrollBack(double r10, int r11) {
        if (this.mLayoutManager.getReverseLayout() == false) goto L5;
        r10 = r10 * (-1.0d);
    L5:
        if (r11 != 0) goto L7;
        return 0;
    L7:
        if (Math.abs(r10) != 0.0d) goto L10;
        return 0;
    L10:
        return (int) Math.min((((double) this.mGapLimitPx) / this.mConfig.speedFactor) * pxToDp(r10), this.mGapLimitPx);
    }

    private void init(RecyclerviewCompat r10, BouncyConfig r11) {
        this.mListView = r10;
        this.mConfig = r11;
        this.mLayoutManager = (VirtualLayoutManager) r10.getLayoutManager();
        this.mScroller = new DecelerateSmoothScroller(r10.getContext().getApplicationContext());
        this.mSpringScroller = new SpringScroller(r11.tension, r11.friction, this);
        this.mGapLimitPx = (int) dpToPx(r11.gapLimit);
    }

    private void initGenericMotionListener() {
        this.mListView.setOnGenericMotionListener(new MouseOverScrollFooterAnchor(this, null));
    }

    private void initScrollListener() {
        this.mListView.addOnScrollListener(new AnonymousClass2(this));
    }

    private void initTouchListener() {
        this.mListView.addOnItemTouchListener(new AnonymousClass3(this));
    }

    private void onActionUp() {
        int r10 = getFooterVisibleLength();
        int r11 = getHeaderVisibleLength();
        if (r10 > 0) goto L5;
        if (r11 > 0) goto L5;
    L15:
        this.mShouldUseSpring = true;
        return;
    L5:
        if (r10 <= 0) goto L7;
        r11 = r10;
    L7:
        int r12 = getMinDistanceToScrollBack(this.mScrollSpeed, r11);
        this.minDistanceToScrollBack = r12;
        if (r11 >= r12) goto L14;
        double r13 = this.mScrollSpeed;
        if (r10 <= 0) goto L12;
        boolean r14 = true;
    L13:
        reduceScrollSpeed(r13, r11, r14);
        goto L15
    L12:
        r14 = false;
        goto L13
    L14:
        scrollBack(r11);
        goto L15
    }

    private double pxToDp(double r10) {
        return r10 / (((double) BaseApplication.c().getResources().getDisplayMetrics().densityDpi) / 160.0d);
    }

    private void reduceScrollSpeed(double r10, int r11, boolean r12) {
        this.mListView.stopScroll();
        int r13 = this.minDistanceToScrollBack;
        this.mScroller.f(getDecelVector());
        this.mScroller.setTargetPosition(getDecelTargetPos(r11, r12));
        this.mScroller.d(r13);
        this.mScroller.e((float) Math.abs(r10));
        this.mLayoutManager.startSmoothScroll(this.mScroller);
    }

    private void scrollBack(int r10) {
        Object r11 = this.lockSpring;
        monitor-enter(r11);
        this.mIsScrollBack = true;     // Catch: Throwable -> L8
        this.isSpringFirstValue = true;     // Catch: Throwable -> L8
        this.mListView.stopScroll();     // Catch: Throwable -> L8
        if (r10 <= 0) goto L10;
        startSpringScroll(r10);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void scrollBy(int r10) {
        if (directionVertical() == false) goto L5;
        this.mListView.scrollBy(0, r10);
        return;
    L5:
        this.mListView.scrollBy(r10, 0);
    }

    private boolean shouldInterceptTouch() {
        if (getFooterVisibleLength() <= 0) goto L5;
    L8:
        return true;
    L5:
        if (getHeaderVisibleLength() > 0) goto L8;
        return false;
    }

    private void startSpringScroll(int r10) {
        if (directionVertical() == false) goto L5;
        this.mSpringScroller.d(0, r10);
        return;
    L5:
        this.mSpringScroller.d(r10, 0);
    }

    @Override // com.bytedanceos.common.tangram.bouncy.SpringScroller.SpringScrollerListener
    public void onSpringAtRest() {
        this.mIsScrollBack = false;
        HeaderFooterUtil r10 = this.mHeaderFooterUtil;
        if (r10 == null) goto L6;
        r10.reset();
        return;
    }

    @Override // com.bytedanceos.common.tangram.bouncy.SpringScroller.SpringScrollerListener
    public void onSpringUpdate(int r10, int r11) {
        if (this.mShouldUseSpring == true) goto L5;
        return;
    L5:
        Object r12 = this.lockSpring;
        monitor-enter(r12);
        int r13 = getFooterVisibleLength();     // Catch: Throwable -> L20
        int r14 = getHeaderVisibleLength();     // Catch: Throwable -> L20
        if (r13 <= 0) goto L11;
        r14 = r13;
    L11:
        if (directionVertical() == false) goto L13;
        r10 = r11;
    L13:
        int r15 = r10 - r14;     // Catch: Throwable -> L20
        if (r15 < 0) goto L16;
    L32:
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L16:
        if (this.isSpringFirstValue == false) goto L23;
        this.isSpringFirstValue = false;     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L23:
        if (this.mFlingOverScrollBack == true) goto L26;
        this.mListView.stopScroll();     // Catch: Throwable -> L20
    L26:
        if (this.mLayoutManager.getReverseLayout() == false) goto L28;
        r15 = r15 * (-1);     // Catch: Throwable -> L20
    L28:
        if (r13 > 0) goto L31;
        r15 = -r15;
    L31:
        scrollBy(r15);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public BouncyEngine(RecyclerviewCompat r10, HeaderFooterUtil r11, BouncyConfig r12) {
        this.lockSpring = new Object();
        this.mHandlerUI = new Handler(Looper.getMainLooper());
        this.minDistanceToScrollBack = 1;
        this.mPrevFooterVisible = 0;
        this.mPrevHeaderVisible = 0;
        this.mScrollSpeed = 0.0d;
        this.mPrevTime = SystemClock.elapsedRealtime();
        this.mFirstScrollBy = false;
        this.mIsScrollBack = false;
        this.isSpringFirstValue = true;
        this.mShouldUseSpring = false;
        this.mGestureOnIntercept = true;
        this.mFlingOverScrollBack = false;
        this.mGestureDetector = new GestureDetectorCompat(BaseApplication.c(), new AnonymousClass1(this));
        Objects.requireNonNull(r10, "RecyclerView must not be null");
        Objects.requireNonNull(r11, "LoadBouncyMoreUtil must not be null");
        this.mHeaderFooterUtil = r11;
        init(r10, r12);
        configListView();
    }
}

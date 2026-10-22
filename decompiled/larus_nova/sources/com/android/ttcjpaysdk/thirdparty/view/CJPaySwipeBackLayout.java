package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySwipeBackLayout extends FrameLayout {
    public static final int SWIPE_BOTTOM = 4;
    public static final int SWIPE_LEFT = 1;
    public static final int SWIPE_NONE = -1;
    public static final int SWIPE_RIGHT = 2;
    public static final int SWIPE_TOP = 3;
    boolean ComputeScrollFinish;
    private boolean hideShadow;
    private boolean isClose;
    private Context mContext;
    private int mCurryX;
    private int mCurryY;
    private int mDelX;
    private int mDelY;
    private int mLastDownX;
    private int mLastDownY;
    private Paint mPaint;
    private int mScreenHeight;
    private int mScreenWidth;
    private Scroller mScroller;
    private int mTouchSlop;
    protected int model;
    private OnSwipeFinishListener onSwipeFinishListener;
    List<ViewPager> viewPagers;

    public interface OnSwipeFinishListener {
        void swipeFinish();

        void swipeStart();
    }

    private void setupView() {
        this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.mScroller = new Scroller(this.mContext);
        WindowManager r100 = (WindowManager) this.mContext.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getDefaultDisplay().getMetrics(r101);
        this.mScreenHeight = r101.heightPixels + CJPayBasicUtils.getStatusBarHeight(this.mContext);
        this.mScreenWidth = r101.widthPixels;
        setClickable(true);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        Paint r102 = new Paint();
        this.mPaint = r102;
        r102.setStrokeWidth(2.0f);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(FakePickerAvatarCreator.DKGRAY);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset() == false) goto L6;
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        postInvalidate();
        return;
    L6:
        if (this.isClose == false) goto L12;
        setVisibility(8);
        OnSwipeFinishListener r100 = this.onSwipeFinishListener;
        if (r100 == null) goto L13;
        r100.swipeFinish();
        return;
    L13:
        return;
    }

    public CJPaySwipeBackLayout(Context r100) {
        super(r100);
        this.model = 2;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mLastDownX = 0;
        this.mLastDownY = 0;
        this.isClose = false;
        this.viewPagers = new ArrayList();
        this.hideShadow = false;
        this.ComputeScrollFinish = true;
        this.mContext = r100;
        setupView();
    }

    private void drawShadow(Canvas r100) {
        r100.save();
        RectF r101 = new RectF(0.0f, 0.0f, this.mScreenWidth, this.mScreenHeight);
        int r102 = 0;
        if (this.hideShadow == true) goto L18;
        int r103 = this.model;
        if (r103 != 2) goto L8;
        int r104 = (int) (((getScrollX() / (this.mScreenWidth / 2)) * 255.0f) + 255.0f);
        RectF r105 = new RectF(getScrollX(), 0.0f, this.mScreenWidth, this.mScreenHeight);
    L14:
        if (r104 < 0) goto L17;
        r102 = r104;
    L17:
        r101 = r105;
        goto L18
    L8:
        if (r103 != 1) goto L11;
        r104 = (int) (255.0f - ((getScrollX() / (this.mScreenWidth / 2)) * 255.0f));
        r105 = new RectF(0.0f, 0.0f, this.mScreenWidth + getScrollX(), this.mScreenHeight);
        goto L14
    L11:
        if (r103 != 4) goto L13;
        r104 = (int) (((getScrollY() / (this.mScreenHeight / 2)) * 255.0f) + 255.0f);
        r105 = new RectF(0.0f, getScrollY(), this.mScreenWidth, this.mScreenHeight);
        goto L14
    L13:
        r104 = (int) (255.0f - ((getScrollY() / (this.mScreenHeight / 2)) * 255.0f));
        r105 = new RectF(0.0f, 0.0f, this.mScreenWidth, this.mScreenHeight + getScrollY());
    L18:
        this.mPaint.setAlpha(r102);
        r100.drawRect(r101, this.mPaint);
        r100.restore();
    }

    private void findViewPager(ViewGroup r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() != 0) goto L21;
        int r101 = 0;
    L8:
        if (r101 >= r100.getChildCount()) goto L22;
        View r102 = r100.getChildAt(r101);
        if ((r102 instanceof ViewPager) == false) goto L13;
        this.viewPagers.add((ViewPager) r102);
    L15:
        r101 = r101 + 1;
        goto L8
    L13:
        if ((r102 instanceof ViewGroup) == false) goto L15;
        findViewPager((ViewGroup) r102);
        goto L15
    L22:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        drawShadow(r100);
        super.dispatchDraw(r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 != 0) goto L8;
        this.mLastDownX = (int) r100.getX();
        this.mLastDownY = (int) r100.getY();
    L35:
        return false;
    L8:
        if (r101 != 2) goto L35;
        float r102 = r100.getX();
        float r103 = r100.getY();
        float r104 = Math.abs(r102 - this.mLastDownX);
        float r105 = Math.abs(r103 - this.mLastDownY);
        int r106 = this.model;
        if (r106 == 1) goto L24;
        if (r106 == 2) goto L24;
        if (r106 == 3) goto L19;
        if (r106 != 4) goto L35;
    L19:
        if (r105 <= this.mTouchSlop) goto L35;
        if (r104 >= r105) goto L35;
        return true;
    L24:
        if (r104 <= this.mTouchSlop) goto L35;
        if (r104 <= r105) goto L35;
        Iterator<ViewPager> r107 = this.viewPagers.iterator();
    L29:
        if (r107.hasNext() == false) goto L33;
        if (inRangeOfView(r107.next(), r100) == false) goto L29;
        return false;
    L33:
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        if (r100 == 1) goto L23;
        if (r100 != 2) goto L53;
        this.mCurryX = (int) r110.getX();
        int r101 = (int) r110.getY();
        this.mCurryY = r101;
        this.mDelX = this.mCurryX - this.mLastDownX;
        this.mDelY = r101 - this.mLastDownY;
        invalidate();
        int r102 = this.model;
        if (r102 != 2) goto L11;
        int r103 = this.mDelX;
        if (r103 <= 0) goto L11;
        scrollTo(-r103, 0);
    L11:
        if (r102 != 4) goto L15;
        int r104 = this.mDelY;
        if (r104 <= 0) goto L15;
        scrollTo(0, -r104);
    L15:
        if (r102 != 1) goto L19;
        int r105 = this.mDelX;
        if (r105 >= 0) goto L19;
        scrollTo(-r105, 0);
    L19:
        if (r102 != 3) goto L53;
        int r106 = this.mDelY;
        if (r106 >= 0) goto L53;
        scrollTo(0, -r106);
    L53:
        return super.onTouchEvent(r110);
    L23:
        this.mCurryX = (int) r110.getX();
        int r107 = (int) r110.getY();
        this.mCurryY = r107;
        int r108 = this.mCurryX - this.mLastDownX;
        this.mDelX = r108;
        int r109 = r107 - this.mLastDownY;
        this.mDelY = r109;
        int r111 = this.model;
        if (r111 == 2) goto L26;
        if (r111 == 4) goto L33;
        if (r111 == 1) goto L40;
        if (r111 != 3) goto L53;
        if (Math.abs(r109) > (this.mScreenHeight / 8)) goto L49;
    L51:
        startScroll(0, getScrollY(), 0, -getScrollY(), 500);
        goto L53
    L49:
        if (this.mDelY >= 0) goto L51;
        startScrollToFinish(0, getScrollY(), 0, this.mScreenHeight - getScrollY(), 500);
        goto L53
    L40:
        if (Math.abs(r108) > (this.mScreenWidth / 2)) goto L42;
    L44:
        startScroll(getScrollX(), 0, -getScrollX(), 0, 500);
        goto L53
    L42:
        if (this.mDelX >= 0) goto L44;
        startScrollToFinish(getScrollX(), 0, this.mScreenWidth - getScrollX(), 0, 500);
        goto L53
    L33:
        if (Math.abs(r109) > (this.mScreenHeight / 8)) goto L35;
    L37:
        startScroll(0, getScrollY(), 0, -getScrollY(), 500);
        goto L53
    L35:
        if (this.mDelY <= 0) goto L37;
        startScrollToFinish(0, getScrollY(), 0, (-this.mScreenHeight) - getScrollY(), 500);
        goto L53
    L26:
        if (Math.abs(r108) > (this.mScreenWidth / 2)) goto L28;
    L30:
        startScroll(getScrollX(), 0, -getScrollX(), 0, 500);
        goto L53
    L28:
        if (this.mDelX <= 0) goto L30;
        startScrollToFinish(getScrollX(), 0, (-this.mScreenWidth) - getScrollX(), 0, 500);
        goto L53
    }

    public void setComputeScrollFinish(boolean r100) {
        this.ComputeScrollFinish = r100;
    }

    public void setModel(int r100) {
        this.model = r100;
    }

    public void setOnSwipeFinishListener(OnSwipeFinishListener r100) {
        this.onSwipeFinishListener = r100;
    }

    public CJPaySwipeBackLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.model = 2;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mLastDownX = 0;
        this.mLastDownY = 0;
        this.isClose = false;
        this.viewPagers = new ArrayList();
        this.hideShadow = false;
        this.ComputeScrollFinish = true;
        this.mContext = r100;
        setupView();
    }

    private boolean inRangeOfView(View r100, MotionEvent r101) {
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int r103 = r102[0];
        int r104 = r102[1];
        if (r101.getX() >= r103) goto L5;
    L12:
        return false;
    L5:
        if (r101.getX() > (r103 + r100.getWidth())) goto L12;
        if (r101.getY() < r104) goto L12;
        if (r101.getY() > (r104 + r100.getHeight())) goto L12;
        return true;
    }

    private void startScroll(int r100, int r101, int r102, int r110, int r111) {
        this.mScroller.startScroll(r100, r101, r102, r110, r111);
        invalidate();
    }

    private void startScrollToFinish(int r100, int r101, int r102, int r103, int r104) {
        if (this.ComputeScrollFinish == false) goto L5;
        startScroll(r100, r101, r102, r103, r104);
    L5:
        this.isClose = true;
        this.hideShadow = true;
        invalidate();
        OnSwipeFinishListener r105 = this.onSwipeFinishListener;
        if (r105 == null) goto L9;
        r105.swipeStart();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.viewPagers.clear();
        findViewPager(this);
    }
}

package com.android.ttcjpaysdk.thirdparty.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayObservableStateScrollView extends ScrollView {
    private static final int CHECK_SCROLL_STOP_DELAY_MILLIS = 80;
    private static final boolean DEBUG = false;
    private static final int MSG_SCROLL = 1;
    public static final int SCROLL_STATE_FLING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    private boolean enableScrolling;
    private final Handler mHandler;
    private boolean mIsTouched;
    private OnScrollListener mOnScrollListener;
    private int mScrollState;

    public interface OnScrollListener {
        void onScroll(CJPayObservableStateScrollView r100, boolean r101, int r102, int r103, int r104, int r105);

        void onScrollStateChanged(CJPayObservableStateScrollView r100, int r101);
    }

    private void restartCheckStopTiming() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 80);
    }

    public boolean isEnableScrolling() {
        return this.enableScrolling;
    }

    public CJPayObservableStateScrollView(Context r100) {
        super(r100);
        this.enableScrolling = true;
        this.mIsTouched = false;
        this.mScrollState = 0;
        this.mHandler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    public static /* synthetic */ boolean access$000(CJPayObservableStateScrollView r100) {
        return r100.mIsTouched;
    }

    public static /* synthetic */ void access$200(CJPayObservableStateScrollView r100) {
        r100.restartCheckStopTiming();
    }

    private void handleDownEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L7;
        this.mIsTouched = true;
        return;
    }

    private void handleUpEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 1) goto L5;
    L7:
        this.mIsTouched = false;
        restartCheckStopTiming();
        return;
    L5:
        if (r101 == 3) goto L7;
    }

    private void setScrollState(int r100) {
        if (this.mScrollState == r100) goto L8;
        this.mScrollState = r100;
        OnScrollListener r101 = this.mOnScrollListener;
        if (r101 == null) goto L9;
        r101.onScrollStateChanged(this, r100);
        return;
    L9:
        return;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (isEnableScrolling() == false) goto L6;
        handleDownEvent(r100);
        return super.onInterceptTouchEvent(r100);
    L6:
        return false;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (isEnableScrolling() == false) goto L6;
        handleUpEvent(r100);
        return super.onTouchEvent(r100);
    L6:
        return false;
    }

    public void setEnableScrolling(boolean r100) {
        this.enableScrolling = r100;
    }

    public void setOnScrollListener(OnScrollListener r100) {
        this.mOnScrollListener = r100;
    }

    public CJPayObservableStateScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.enableScrolling = true;
        this.mIsTouched = false;
        this.mScrollState = 0;
        this.mHandler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    public static /* synthetic */ void access$100(CJPayObservableStateScrollView r100, int r101) {
        r100.setScrollState(r101);
    }

    public CJPayObservableStateScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.enableScrolling = true;
        this.mIsTouched = false;
        this.mScrollState = 0;
        this.mHandler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    @Override // android.view.View
    public void onScrollChanged(int r100, int r110, int r111, int r112) {
        super.onScrollChanged(r100, r110, r111, r112);
        if (this.mIsTouched == false) goto L5;
        setScrollState(1);
    L6:
        OnScrollListener r101 = this.mOnScrollListener;
        if (r101 == null) goto L10;
        r101.onScroll(this, this.mIsTouched, r100, r110, r111, r112);
        return;
    L10:
        return;
    L5:
        setScrollState(2);
        restartCheckStopTiming();
        goto L6
    }
}

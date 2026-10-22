package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class VerticalScrollView extends ScrollView {
    private static final int CHECK_SCROLL_INTERVAL = 100;
    private static final int INITIAL_VALUE = -1;
    private static final float XY_DISTANCE_OFFSET = 1.73f;
    private long lastScrollUpdate;
    private float lastX;
    private float lastY;
    private boolean mIsScrolling;
    private Object mScrollingTag;
    private float mTouchSlop;
    private float xDistance;
    private float yDistance;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.widget.VerticalScrollView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ScrollStateHandler implements Runnable {
        final /* synthetic */ VerticalScrollView this$0;

        private ScrollStateHandler(VerticalScrollView r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((System.currentTimeMillis() - VerticalScrollView.access$000(this.this$0)) <= 100) goto L5;
            VerticalScrollView.access$002(this.this$0, -1);
            VerticalScrollView.access$100(this.this$0);
            return;
        L5:
            this.this$0.postDelayed(this, 100);
        }

        public /* synthetic */ ScrollStateHandler(VerticalScrollView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public VerticalScrollView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.lastScrollUpdate = -1;
        this.mTouchSlop = ViewConfiguration.get(r10).getScaledTouchSlop() / 2.0f;
    }

    public static /* synthetic */ long access$000(VerticalScrollView r10) {
        return r10.lastScrollUpdate;
    }

    public static /* synthetic */ long access$002(VerticalScrollView r10, long r11) {
        r10.lastScrollUpdate = r11;
        return r11;
    }

    public static /* synthetic */ void access$100(VerticalScrollView r10) {
        r10.onScrollEnd();
    }

    private void onScrollEnd() {
        this.mIsScrolling = false;
        this.mScrollingTag = null;
    }

    private void onScrollStart() {
        this.mIsScrolling = true;
    }

    public Object getScrollingTag() {
        return this.mScrollingTag;
    }

    public boolean isScrollToBottom() {
        if (getChildCount() != 0) goto L6;
        return true;
    L6:
        if (getScrollY() < (getChildAt(0).getHeight() - getHeight())) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isScrollToTop() {
        if (getChildCount() != 0) goto L6;
        return true;
    L6:
        if (getScrollY() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isScrolling() {
        return this.mIsScrolling;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        this.yDistance = 0.0f;
        this.xDistance = 0.0f;
        this.lastX = r10.getX();
        this.lastY = r10.getY();
    L17:
        return super.onInterceptTouchEvent(r10);
    L5:
        if (r11 == 1) goto L17;
        if (r11 != 2) goto L17;
        float r12 = r10.getX();
        float r13 = r10.getY();
        this.xDistance += Math.abs(r12 - this.lastX);
        this.yDistance += Math.abs(r13 - this.lastY);
        this.lastX = r12;
        this.lastY = r13;
        if (Math.abs(this.xDistance * XY_DISTANCE_OFFSET) <= this.mTouchSlop) goto L17;
        if (Math.abs(this.yDistance) >= Math.abs(this.xDistance * XY_DISTANCE_OFFSET)) goto L17;
        return false;
    }

    @Override // android.view.View
    public void onScrollChanged(int r10, int r11, int r12, int r13) {
        if (this.lastScrollUpdate != (-1)) goto L5;
        onScrollStart();
        postDelayed(new ScrollStateHandler(this, null), 100);
    L5:
        this.lastScrollUpdate = System.currentTimeMillis();
        super.onScrollChanged(r10, r11, r12, r13);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        this.yDistance = 0.0f;
        this.xDistance = 0.0f;
        this.lastX = r10.getX();
        this.lastY = r10.getY();
    L15:
        return super.onTouchEvent(r10);
    L5:
        if (r11 != 2) goto L15;
        float r12 = r10.getX();
        float r13 = r10.getY();
        this.xDistance += Math.abs(r12 - this.lastX);
        float r14 = this.yDistance + Math.abs(r13 - this.lastY);
        this.yDistance = r14;
        this.lastX = r12;
        this.lastY = r13;
        if (Math.abs(r14) >= Math.abs(this.xDistance)) goto L15;
        if (this.mIsScrolling == false) goto L15;
        j.a("VerticalScrollView return false");
        return false;
    }

    public void setScrollingTag(Object r10) {
        this.mScrollingTag = r10;
    }
}

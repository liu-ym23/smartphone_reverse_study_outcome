package com.bytedanceos.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerviewCompat extends RecyclerView {
    private static final float XY_DISTANCE_OFFSET = 1.73f;
    private float lastX;
    private float lastY;
    private List<RecyclerView.OnScrollListener> mListeners;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private float mTouchSlop;
    private float xDistance;
    private float yDistance;

    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerviewCompat f10228a;

        public a(RecyclerviewCompat r10) {
            this.f10228a = r10;
        }

        public final void a(RecyclerView r10, int r11) {
            int r12 = 0;
        L4:
            if (r12 >= RecyclerviewCompat.access$000(this.f10228a).size()) goto L6;
            ((RecyclerView.OnScrollListener) RecyclerviewCompat.access$000(this.f10228a).get(r12)).onScrollStateChanged(r10, r11);
            r12 = r12 + 1;
            goto L4
        }

        public final void b(RecyclerView r10, int r11, int r12) {
            int r13 = 0;
        L4:
            if (r13 >= RecyclerviewCompat.access$000(this.f10228a).size()) goto L6;
            ((RecyclerView.OnScrollListener) RecyclerviewCompat.access$000(this.f10228a).get(r13)).onScrolled(r10, r11, r12);
            r13 = r13 + 1;
            goto L4
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            a(r10, r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r10, int r11, int r12) {
            b(r10, r11, r12);
        }
    }

    public RecyclerviewCompat(Context r10) {
        this(r10, null);
    }

    private void M() {
        setOnScrollListener(this.mOnScrollListener);
    }

    public static /* synthetic */ List access$000(RecyclerviewCompat r10) {
        return r10.mListeners;
    }

    public final boolean L() {
        return ((Boolean) Class.forName(super.getClass().getName()).getMethod("isComputingLayout", null).invoke(this, null)).booleanValue();
    L4:
        return false;
    }

    public final boolean N() {
        if (getScrollState() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnScrollListener(RecyclerView.OnScrollListener r10) {
        this.mListeners.add(r10);
    }

    public boolean isNowComputingLayout() {
        return L();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
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

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
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
        if (N() == false) goto L15;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnScrollListener(RecyclerView.OnScrollListener r10) {
        this.mListeners.remove(r10);
    }

    public RecyclerviewCompat(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public RecyclerviewCompat(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mListeners = new ArrayList();
        this.mOnScrollListener = new a(this);
        M();
        this.mTouchSlop = ViewConfiguration.get(r10).getScaledTouchSlop() / 2.0f;
    }
}

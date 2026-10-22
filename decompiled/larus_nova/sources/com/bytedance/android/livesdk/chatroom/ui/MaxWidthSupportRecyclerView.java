package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes8.dex */
public class MaxWidthSupportRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f112424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f112425b;

    public interface a {
    }

    public void setDrawerSlideOperation(a r100) {
    }

    public MaxWidthSupportRecyclerView(Context r100) {
        super(r100);
        this.f112424a = 3.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L7;
        if (r101 != 1) goto L7;
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
    L10:
        return super.dispatchTouchEvent(r100);
    }

    public void setEnable(boolean r100) {
        this.f112425b = r100;
    }

    public void setMaxItem(float r100) {
        this.f112424a = r100;
    }

    public MaxWidthSupportRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f112424a = 3.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        float r102 = this.f112424a;
        int r103 = (int) r102;
        float r104 = r102 % r103;
        if (this.f112425b == true) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if (getAdapter().getItemCount() >= r103) goto L9;
        return;
    L9:
        if (getChildCount() < r103) goto L34;
        int r105 = 0;
        int r106 = 0;
    L11:
        if (r105 >= r103) goto L19;
        View r107 = getChildAt(r105);
        if (r107 == null) goto L17;
        r106 = r106 + r107.getMeasuredWidth();
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r106 = r106 + (r109.leftMargin + r109.rightMargin);
    L17:
        r105 = r105 + 1;
        goto L11
    L19:
        if (getAdapter().getItemCount() > r103) goto L21;
    L25:
        setMeasuredDimension(r106, View.MeasureSpec.getSize(r101));
        return;
    L21:
        if (r104 <= 0.0f) goto L25;
        View r110 = getChildAt(r103);
        r106 = r106 + (r110.getMeasuredWidth() / 2);
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r106 = r106 + ((r112.leftMargin + r112.rightMargin) / 2);
        goto L25
    }

    public MaxWidthSupportRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f112424a = 3.0f;
    }
}

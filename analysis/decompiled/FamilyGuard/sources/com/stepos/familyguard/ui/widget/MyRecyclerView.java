package com.stepos.familyguard.ui.widget;

import T1.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Space;
import androidx.core.view.C0473s;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import f2.C0702g;
import g2.C0737g;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public class MyRecyclerView extends StepOSRecyclerView {

    /* renamed from: F0, reason: collision with root package name */
    private boolean f15178F0;

    /* renamed from: G0, reason: collision with root package name */
    private boolean f15179G0;

    /* renamed from: H0, reason: collision with root package name */
    private boolean f15180H0;

    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public MyRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private View q1(int i5) {
        Space space = new Space(getContext());
        space.setLayoutParams(new RecyclerView.LayoutParams(-1, i5));
        return space;
    }

    public boolean getScrollable() {
        return this.f15178F0;
    }

    public void m1() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        o1(g.b(getContext(), R.attr.marginBottomMax));
    }

    public void n1() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        p1(g.b(getContext(), R.attr.marginMedium));
    }

    public void o1(int i5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        f0(new a(q1(i5)));
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (C0473s.c(motionEvent) == 2 && !this.f15178F0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void p1(int i5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        h0(new a(q1(i5)));
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView, androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.setAdapter(adapter);
        if (this.f15179G0) {
            n1();
        }
        if (this.f15180H0) {
            m1();
        }
    }

    public void setNeedDefaultFooter(boolean z5) {
        this.f15180H0 = z5;
    }

    public void setNeedDefaultHeader(boolean z5) {
        this.f15179G0 = z5;
    }

    public void setScrollable(boolean z5) {
        this.f15178F0 = z5;
        C0702g.b("MyRecyclerView", "setScrollable scrollable = " + z5);
    }

    public MyRecyclerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f15178F0 = true;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0737g.f17465l2, i5, 0);
        this.f15179G0 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f15180H0 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}

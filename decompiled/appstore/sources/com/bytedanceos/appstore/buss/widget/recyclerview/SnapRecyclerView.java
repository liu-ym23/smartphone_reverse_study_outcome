package com.bytedanceos.appstore.buss.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.bytedanceos.appstore.R$styleable;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public class SnapRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public GravitySnapHelper f9349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9350m;

    public SnapRecyclerView(@NonNull Context r10) {
        this(r10, null);
    }

    public void N(Boolean r10) {
        if (r10.booleanValue() == false) goto L5;
        this.f9349l.b(this);
    L6:
        this.f9350m = r10.booleanValue();
        return;
    L5:
        this.f9349l.b(null);
        goto L6
    }

    public void O(Context r10, AttributeSet r11, int r12, int r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.SnapRecyclerView, r12, r13);
        int r15 = r14.getInt(2, 0);
        boolean r16 = r14.getBoolean(6, false);
        boolean r17 = r14.getBoolean(3, false);
        float r18 = r14.getFloat(4, -1.0f);
        int r19 = r14.getInteger(1, 100);
        int r110 = r14.getInteger(0, 5000);
        float r20 = r14.getFloat(5, 100.0f);
        boolean r21 = r14.getBoolean(7, true);
        r14.recycle();
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 == 2) goto L14;
        if (r15 == 3) goto L13;
        if (r15 != 4) goto L12;
        this.f9349l = new GravitySnapHelper(17);
    L17:
        this.f9349l.L(r16);
        this.f9349l.J(r17);
        this.f9349l.G(r18);
        this.f9349l.H(r19);
        this.f9349l.F(r110);
        this.f9349l.I(r20);
        N(Boolean.valueOf(r21));
        return;
    L12:
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    L13:
        this.f9349l = new GravitySnapHelper(80);
        goto L17
    L14:
        this.f9349l = new GravitySnapHelper(8388613);
        goto L17
    L15:
        this.f9349l = new GravitySnapHelper(48);
        goto L17
    L16:
        this.f9349l = new GravitySnapHelper(8388611);
        goto L17
    }

    public int getCurrentSnappedPosition() {
        return this.f9349l.y();
    }

    @NonNull
    public GravitySnapHelper getSnapHelper() {
        return this.f9349l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int r10) {
        if (this.f9350m == true) goto L5;
    L6:
        super.scrollToPosition(r10);
        return;
    L5:
        if (this.f9349l.E(r10) == false) goto L6;
    }

    public void setSnapListener(GravitySnapHelper.SnapListener r10) {
        this.f9349l.K(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int r10) {
        if (this.f9350m == true) goto L5;
    L6:
        super.smoothScrollToPosition(r10);
        return;
    L5:
        if (this.f9349l.M(r10) == false) goto L6;
    }

    public SnapRecyclerView(@NonNull Context r10, @NonNull AttributeSet r11) {
        this(r10, r11, R.attr.recyclerViewStyle);
    }

    public SnapRecyclerView(@NonNull Context r10, @NonNull AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public SnapRecyclerView(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12);
        this.f9350m = false;
        O(r10, r11, r12, r13);
    }
}

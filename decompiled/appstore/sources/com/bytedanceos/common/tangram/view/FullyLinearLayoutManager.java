package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class FullyLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f9942a;

    public FullyLinearLayoutManager(Context r10) {
        super(r10);
        this.f9942a = new int[2];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler r12, RecyclerView.State r13, int r14, int r15) {
        int r16 = View.MeasureSpec.getMode(r14);
        int r10 = View.MeasureSpec.getMode(r15);
        int r17 = View.MeasureSpec.getSize(r14);
        int r18 = View.MeasureSpec.getSize(r15);
        int r11 = 0;
        int r19 = 0;
        int r110 = 0;
    L4:
        if (r11 >= getItemCount()) goto L11;
        y(r12, r11, View.MeasureSpec.makeMeasureSpec(r11, 0), View.MeasureSpec.makeMeasureSpec(r11, 0), this.f9942a);
        if (getOrientation() != 0) goto L8;
        int[] r20 = this.f9942a;
        r110 = r110 + r20[0];
        r19 = Math.max(r19, r20[1]);
    L9:
        r11 = r11 + 1;
        goto L4
    L8:
        int[] r21 = this.f9942a;
        r19 = r19 + r21[1];
        r110 = Math.max(r110, r21[0]);
        goto L9
    L11:
        if (r16 == 1073741824) goto L13;
        r17 = r110;
    L13:
        if (r10 == 1073741824) goto L15;
        r18 = r19;
    L15:
        setMeasuredDimension(r17, r18);
    }

    public final void y(RecyclerView.Recycler r10, int r11, int r12, int r13, int[] r14) {
        View r15 = r10.o(0);     // Catch: Throwable -> L7 Exception -> L9
        if (r15 == null) goto L16;
        RecyclerView.LayoutParams r16 = (RecyclerView.LayoutParams) r15.getLayoutParams();     // Catch: Throwable -> L7 Exception -> L9
        r15.measure(ViewGroup.getChildMeasureSpec(r12, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r16).width), ViewGroup.getChildMeasureSpec(r13, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r16).height));     // Catch: Throwable -> L7 Exception -> L9
        r14[0] = (r15.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r16).leftMargin) + ((ViewGroup.MarginLayoutParams) r16).rightMargin;     // Catch: Throwable -> L7 Exception -> L9
        r14[1] = (r15.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r16).bottomMargin) + ((ViewGroup.MarginLayoutParams) r16).topMargin;     // Catch: Throwable -> L7 Exception -> L9
        r10.G(r15);     // Catch: Throwable -> L7 Exception -> L9
    L17:
        return;
    L16:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

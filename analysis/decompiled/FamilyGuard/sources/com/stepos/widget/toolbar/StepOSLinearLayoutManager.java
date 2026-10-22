package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import j4.k;

/* loaded from: classes.dex */
public final class StepOSLinearLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLinearLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        k.g(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        k.g(state, "state");
        k.g(iArr, "extraLayoutSpace");
        super.calculateExtraLayoutSpace(state, iArr);
        if (getOrientation() == 1) {
            iArr[0] = Math.max(iArr[0], getPaddingTop());
            iArr[1] = Math.max(iArr[1], getPaddingBottom());
        } else {
            iArr[0] = Math.max(iArr[0], getPaddingStart());
            iArr[1] = Math.max(iArr[1], getPaddingEnd());
        }
    }
}

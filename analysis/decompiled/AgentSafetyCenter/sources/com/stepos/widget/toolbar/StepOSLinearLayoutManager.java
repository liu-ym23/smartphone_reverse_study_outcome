package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class StepOSLinearLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i3) {
        super(context, attributeSet, i, i3);
        context.getClass();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        state.getClass();
        iArr.getClass();
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

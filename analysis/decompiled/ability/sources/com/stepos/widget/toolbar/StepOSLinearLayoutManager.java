package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSLinearLayoutManager extends LinearLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i6) {
        super(context, attributeSet, i, i6);
        k.f(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        k.f(state, "state");
        k.f(extraLayoutSpace, "extraLayoutSpace");
        super.calculateExtraLayoutSpace(state, extraLayoutSpace);
        if (getOrientation() == 1) {
            extraLayoutSpace[0] = Math.max(extraLayoutSpace[0], getPaddingTop());
            extraLayoutSpace[1] = Math.max(extraLayoutSpace[1], getPaddingBottom());
        } else {
            extraLayoutSpace[0] = Math.max(extraLayoutSpace[0], getPaddingStart());
            extraLayoutSpace[1] = Math.max(extraLayoutSpace[1], getPaddingEnd());
        }
    }
}

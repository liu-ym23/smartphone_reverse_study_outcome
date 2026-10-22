package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "b", "getScrollDy", "setScrollDy", "scrollDy", "", "c", "Z", "getParentIsTop", "()Z", "setParentIsTop", "(Z)V", "parentIsTop", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MaxHeightRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f172202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f172203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f172204c;

    public MaxHeightRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MaxHeightRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getMaxHeight() {
        return this.f172202a;
    }

    public final boolean getParentIsTop() {
        return this.f172204c;
    }

    public final int getScrollDy() {
        return this.f172203b;
    }

    public final void setMaxHeight(int r100) {
        if (this.f172202a == r100) goto L5;
        requestLayout();
    L5:
        this.f172202a = r100;
    }

    public final void setParentIsTop(boolean r100) {
        this.f172204c = r100;
    }

    public final void setScrollDy(int r100) {
        this.f172203b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f172202a;
        if (r102 <= 0) goto L5;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE));
        return;
    L5:
        super.onMeasure(r100, r101);
    }

    public MaxHeightRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172204c = true;
        setTag("MaxHeightYataRecyclerView");
        addOnScrollListener(new AnonymousClass1(this));
    }

    public /* synthetic */ MaxHeightRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AutoHeightTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoHeightTabLayout extends TabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f168197a;

    public AutoHeightTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.google.android.material.tabs.TabLayout, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChildCount() <= 0) goto L5;
        View r102 = getChildAt(0);
        Intrinsics.checkNotNull(r102);
        r102.measure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f168197a = r102.getMeasuredHeight();
    L5:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f168197a, 1073741824));
    }
}

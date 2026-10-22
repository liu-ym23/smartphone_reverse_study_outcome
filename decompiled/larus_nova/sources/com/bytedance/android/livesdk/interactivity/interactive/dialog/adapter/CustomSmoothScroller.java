package com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/adapter/CustomSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f137210a;

    public CustomSmoothScroller(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f137210a = 300;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int r100) {
        float r101 = r100;
        RecyclerView.LayoutManager r102 = getLayoutManager();
        if (r102 == null) goto L5;
        float r103 = r102.getWidth();
    L7:
        return (int) (this.f137210a * (r101 / r103));
    L5:
        r103 = 1.0f;
        goto L7
    }
}

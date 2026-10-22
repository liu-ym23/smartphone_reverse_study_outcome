package com.bytedance.android.live.search.impl.search.ui;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/FixedSizeLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedSizeLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f100794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f100795b;

    public FixedSizeLinearLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 0, true);
        this.f100794a = Integer.MAX_VALUE;
        this.f100795b = Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void setMeasuredDimension(int r100, int r101) {
        int r102 = this.f100794a;
        if (r100 <= r102) goto L7;
        int r103 = this.f100795b;
        if (r101 <= r103) goto L7;
        super.setMeasuredDimension(r102, r103);
        return;
    L7:
        if (r100 > r102) goto L9;
    L11:
        if (r100 > r102) goto L15;
        int r104 = this.f100795b;
        if (r101 <= r104) goto L15;
        super.setMeasuredDimension(r100, r104);
        return;
    L15:
        super.setMeasuredDimension(r100, r101);
        return;
    L9:
        if (r101 > this.f100795b) goto L11;
        super.setMeasuredDimension(r102, r101);
    }
}

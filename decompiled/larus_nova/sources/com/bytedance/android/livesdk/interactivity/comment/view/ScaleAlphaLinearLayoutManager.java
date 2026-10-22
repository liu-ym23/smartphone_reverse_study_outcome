package com.bytedance.android.livesdk.interactivity.comment.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/view/ScaleAlphaLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScaleAlphaLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f136288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f136289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f136290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f136291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f136292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f136293f;

    public ScaleAlphaLinearLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 1, false);
        this.f136289b = 1.0f;
        this.f136290c = 1.0f;
        this.f136291d = 1.0f;
        this.f136292e = 1.0f;
        this.f136293f = LazyKt.lazy(ScaleAlphaLinearLayoutManager$mSnapHelper$2.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        super.onAttachedToWindow(r100);
        ((LinearSnapHelper) this.f136293f.getValue()).attachToRecyclerView(r100);
        this.f136288a = r100;
    }

    public final void p(View r100) {
        if (r100 == null) goto L9;
        getDecoratedMeasuredWidth(r100);
        int r101 = getDecoratedMeasuredHeight(r100);
        getDecoratedLeft(r100);
        getDecoratedRight(r100);
        float r102 = (getDecoratedTop(r100) + getDecoratedBottom(r100)) / 2.0f;
        RecyclerView r103 = this.f136288a;
        if (r103 == null) goto L6;
        float r104 = r103.getHeight() * 0.3f;
    L7:
        float r105 = ((Number) RangesKt.coerceIn(Float.valueOf(Math.abs(r102 - r104) / Math.abs((getHeight() / 2.0f) - (r101 / 2.0f))), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
        float r106 = 1 - r105;
        float r107 = (this.f136290c * r106) + (this.f136289b * r105);
        float r108 = (this.f136292e * r106) + (this.f136291d * r105);
        r100.setScaleX(r107);
        r100.setScaleY(r107);
        r100.setAlpha(r108);
        return;
    L6:
        r104 = 0.0f;
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        int r103 = 0;
        if (getOrientation() != 1) goto L10;
        int r104 = super.scrollVerticallyBy(r100, r101, r102);
        int r105 = getChildCount();
    L5:
        if (r103 >= r105) goto L8;
        p(getChildAt(r103));
        r103 = r103 + 1;
        goto L5
    L8:
        return r104;
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void layoutDecorated(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.layoutDecorated(r100, r101, r102, r103, r104);
        p(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void layoutDecoratedWithMargins(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.layoutDecoratedWithMargins(r100, r101, r102, r103, r104);
        p(r100);
    }
}

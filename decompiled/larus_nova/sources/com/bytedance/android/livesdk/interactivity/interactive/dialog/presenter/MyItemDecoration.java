package com.bytedance.android.livesdk.interactivity.interactive.dialog.presenter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/presenter/MyItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MyItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f137233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f137234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f137235c;

    public MyItemDecoration(int r100, int r101, int r102) {
        this.f137233a = r100;
        this.f137234b = r101;
        this.f137235c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != 0) goto L6;
        r100.left = this.f137234b;
        return;
    L6:
        if (r104 != (r103.getItemCount() - 1)) goto L8;
        r100.left = this.f137233a;
        r100.right = this.f137235c;
        return;
    L8:
        r100.left = this.f137233a;
    }
}

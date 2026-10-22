package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f164674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f164675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f164676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f164677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f164678e;

    public GridItemDecoration(int r100, int r101) {
        this.f164677d = r100;
        this.f164678e = r101;
        this.f164675b = new int[r100];
        this.f164676c = new int[r100];
        this.f164674a = MathKt.roundToInt(((r101 * (r100 - 1)) * 1.0f) / r100);
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L8;
        if (r102 != 0) goto L6;
        this.f164675b[r102] = 0;
    L7:
        this.f164676c[r102] = this.f164674a - this.f164675b[r102];
        r102 = r102 + 1;
        goto L3
    L6:
        int[] r103 = this.f164675b;
        r103[r102] = this.f164678e - (this.f164674a - r103[r102 - 1]);
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f164677d;
        int r106 = r104 % r105;
        r100.left = this.f164675b[r106];
        r100.right = this.f164676c[r106];
        if (r104 < r105) goto L6;
        r100.top = this.f164678e;
        return;
    }
}

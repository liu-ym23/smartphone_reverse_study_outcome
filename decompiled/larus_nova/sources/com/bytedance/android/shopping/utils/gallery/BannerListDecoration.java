package com.bytedance.android.shopping.utils.gallery;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/BannerListDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerListDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f187096a;

    public BannerListDecoration(int r100) {
        this.f187096a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L5;
        int r106 = r105.getItemCount();
    L6:
        if (r104 != 0) goto L9;
        r100.left = 0;
        r100.right = this.f187096a / 2;
        return;
    L9:
        if (r104 != (r106 - 1)) goto L11;
        r100.left = this.f187096a / 2;
        r100.right = 0;
        return;
    L11:
        int r107 = this.f187096a;
        r100.left = r107 / 2;
        r100.right = r107 / 2;
        return;
    L5:
        r106 = 0;
        goto L6
    }
}

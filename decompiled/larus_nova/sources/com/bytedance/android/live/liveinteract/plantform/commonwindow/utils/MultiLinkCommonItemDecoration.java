package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/utils/MultiLinkCommonItemDecoration;", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkCommonItemDecoration extends BaseEqualGridItemDecoration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75874b;

    public MultiLinkCommonItemDecoration(m r100, int r101, Drawable r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        super(r102);
        this.f75874b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "state");
        Drawable r112 = this.f79761a;
        if (r112 == null) goto L19;
        int r101 = r110.getChildCount();
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L12;
        View r104 = r110.getChildAt(r103);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L11;
        RecyclerView.LayoutParams r106 = (RecyclerView.LayoutParams) r105;
        int r107 = r104.getLeft() - ((ViewGroup.MarginLayoutParams) r106).leftMargin;
        int r108 = (r104.getRight() + ((ViewGroup.MarginLayoutParams) r106).rightMargin) + this.f75874b;
        r112.setBounds(r107, r104.getBottom(), r108, (r104.getBottom() + ((ViewGroup.MarginLayoutParams) r106).bottomMargin) + this.f75874b);
        r112.draw(r100);
        r103 = r103 + 1;
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L12:
        int r109 = r110.getChildCount();
    L13:
        if (r102 >= r109) goto L24;
        View r113 = r110.getChildAt(r102);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L18;
        RecyclerView.LayoutParams r115 = (RecyclerView.LayoutParams) r114;
        int r116 = r113.getTop() - ((ViewGroup.MarginLayoutParams) r115).topMargin;
        int r117 = r113.getBottom() + ((ViewGroup.MarginLayoutParams) r115).bottomMargin;
        r112.setBounds(r113.getRight(), r116, (r113.getRight() + ((ViewGroup.MarginLayoutParams) r115).rightMargin) + this.f75874b, r117);
        r112.draw(r100);
        r102 = r102 + 1;
        goto L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L24:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        r100.left = 0;
        r100.top = 0;
        r100.right = 0;
        r100.bottom = 0;
    }
}

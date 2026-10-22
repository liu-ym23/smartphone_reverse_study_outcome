package com.bytedance.android.livesdk.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f160895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f160896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f160897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f160898d;

    public GridItemDecoration(int r100) {
        this.f160895a = r100;
        this.f160896b = 30;
        this.f160897c = false;
        this.f160898d = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "state");
        Drawable r112 = this.f160898d;
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
        int r108 = (r104.getRight() + ((ViewGroup.MarginLayoutParams) r106).rightMargin) + this.f160896b;
        int r109 = r104.getBottom() + ((ViewGroup.MarginLayoutParams) r106).bottomMargin;
        r112.setBounds(r107, r109, r108, this.f160896b + r109);
        r112.draw(r100);
        r103 = r103 + 1;
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L12:
        Drawable r113 = this.f160898d;
        int r114 = r110.getChildCount();
    L13:
        if (r102 >= r114) goto L24;
        View r115 = r110.getChildAt(r102);
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L18;
        RecyclerView.LayoutParams r117 = (RecyclerView.LayoutParams) r116;
        int r118 = r115.getTop() - ((ViewGroup.MarginLayoutParams) r117).topMargin;
        int r119 = r115.getBottom() + ((ViewGroup.MarginLayoutParams) r117).bottomMargin;
        int r120 = r115.getRight() + ((ViewGroup.MarginLayoutParams) r117).rightMargin;
        r113.setBounds(r120, r118, this.f160896b + r120, r119);
        r113.draw(r100);
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
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f160895a;
        int r106 = r104 % r105;
        if (this.f160897c == false) goto L8;
        int r107 = this.f160896b;
        r100.left = r107 - ((r106 * r107) / r105);
        r100.right = ((r106 + 1) * r107) / r105;
        if (r104 >= r105) goto L7;
        r100.top = r107;
    L7:
        r100.bottom = r107;
        return;
    L8:
        int r108 = this.f160896b;
        r100.left = (r106 * r108) / r105;
        r100.right = r108 - (((r106 + 1) * r108) / r105);
        if (r104 < r105) goto L13;
        r100.top = r108;
        return;
    }
}

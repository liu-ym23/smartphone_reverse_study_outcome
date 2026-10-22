package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class LinearDividerDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f135209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f135210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f135211c;

    public LinearDividerDecoration(Resources r100, int r101) {
        this.f135209a = new ColorDrawable(r100.getColor(R.color.transparent));
        this.f135210b = r101;
        this.f135211c = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        int r101 = 0;
        if (this.f135211c != 0) goto L10;
        int r112 = r110.getPaddingTop();
        int r102 = r110.getHeight() - r110.getPaddingBottom();
        int r103 = r110.getChildCount();
    L5:
        if (r101 >= r103) goto L16;
        View r104 = r110.getChildAt(r101);
        RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r104.getLayoutParams();
        int r106 = r104.getRight() + ((ViewGroup.MarginLayoutParams) r105).rightMargin;
        int r107 = this.f135210b + r106;
        this.f135209a.setBounds(r106, r112, r107, r102);
        this.f135209a.draw(r100);
        if (r101 != 0) goto L9;
        int r108 = r104.getLeft() - ((ViewGroup.MarginLayoutParams) r105).leftMargin;
        int r109 = r108 - this.f135210b;
        this.f135209a.setBounds(r109, r112, r108, r102);
        this.f135209a.draw(r100);
    L9:
        r101 = r101 + 1;
        goto L5
    L16:
        return;
    L10:
        int r113 = r110.getPaddingLeft();
        int r114 = r110.getWidth() - r110.getPaddingRight();
        int r115 = r110.getChildCount();
    L11:
        if (r101 >= r115) goto L23;
        View r116 = r110.getChildAt(r101);
        RecyclerView.LayoutParams r117 = (RecyclerView.LayoutParams) r116.getLayoutParams();
        int r118 = r116.getBottom() + ((ViewGroup.MarginLayoutParams) r117).bottomMargin;
        int r119 = this.f135210b + r118;
        this.f135209a.setBounds(r113, r118, r114, r119);
        this.f135209a.draw(r100);
        if (r101 != 0) goto L15;
        int r120 = r116.getTop() - ((ViewGroup.MarginLayoutParams) r117).topMargin;
        int r121 = r120 - this.f135210b;
        this.f135209a.setBounds(r113, r121, r114, r120);
        this.f135209a.draw(r100);
    L15:
        r101 = r101 + 1;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        if (this.f135211c != 0) goto L9;
        if (r102.getChildAdapterPosition(r101) != 0) goto L7;
        r100.left = this.f135210b;
    L7:
        r100.right = this.f135210b;
        return;
    L9:
        if (r102.getChildAdapterPosition(r101) != 0) goto L11;
        r100.top = this.f135210b;
    L11:
        r100.bottom = this.f135210b;
    }
}

package com.obric.ui.dialog;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: VerticalSpaceItemDecoration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/ui/dialog/VerticalSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerHeight", "", "dividerColor", "", "dividerTopSpace", "dividerBottomSpace", "horizontalInset", "(FIFFF)V", "bottomSpace", "hasDivider", "", "inset", "itemOffset", "lineHeight", "paint", "Landroid/graphics/Paint;", "topSpace", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final float bottomSpace;
    private final boolean hasDivider;
    private final float inset;
    private final int itemOffset;
    private final float lineHeight;
    private final Paint paint;
    private final float topSpace;

    public /* synthetic */ VerticalSpaceItemDecoration(float r7, int r8, float r9, float r10, float r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = 0.0f;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public VerticalSpaceItemDecoration(float r2, int r3, float r4, float r5, float r6) {
        float r7 = RangesKt.coerceAtLeast(r2, 0.0f);
        this.lineHeight = r7;
        float r8 = RangesKt.coerceAtLeast(r4, 0.0f);
        this.topSpace = r8;
        float r9 = RangesKt.coerceAtLeast(r5, 0.0f);
        this.bottomSpace = r9;
        this.inset = RangesKt.coerceAtLeast(r6, 0.0f);
        if (r7 <= 0.0f) goto L5;
        boolean r10 = true;
    L6:
        this.hasDivider = r10;
        this.itemOffset = (int) Math.ceil((r8 + r7) + r9);
        Paint r11 = new Paint(1);
        r11.setColor(r3);
        this.paint = r11;
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (r4.getChildAdapterPosition(r3) != 0) goto L5;
        r2.top = 0;
        return;
    L5:
        r2.top = this.itemOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        if (this.hasDivider == true) goto L5;
        return;
    L5:
        float r13 = r11.getPaddingLeft() + this.inset;
        float r0 = (r11.getWidth() - r11.getPaddingRight()) - this.inset;
        if (r0 > r13) goto L8;
        return;
    L8:
        int r7 = r11.getChildCount();
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L15;
        View r1 = r11.getChildAt(r8);
        if (r11.getChildAdapterPosition(r1) <= 0) goto L14;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        float r3 = (r1.getTop() - ((RecyclerView.LayoutParams) r2).topMargin) - this.bottomSpace;
        float r4 = this.lineHeight;
        float r5 = r3 - r4;
        r10.drawRect(r13, r5, r0, r5 + r4, this.paint);
    L14:
        r8 = r8 + 1;
        goto L9
    }
}

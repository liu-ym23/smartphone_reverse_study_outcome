package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/DividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f85079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f85080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f85081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f85082d;

    public DividerItemDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f85079a = 1;
        int[] r101 = {R.attr.listDivider};
        this.f85082d = new Rect();
        TypedArray r102 = r100.obtainStyledAttributes(r101);
        this.f85080b = r102.getDrawable(0);
        r102.recycle();
        this.f85081c = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (r101.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.f85080b == null) goto L30;
        int r103 = 0;
        if (this.f85081c != this.f85079a) goto L17;
        r100.save();
        if (r101.getClipToPadding() == false) goto L12;
        int r104 = r101.getPaddingLeft();
        int r105 = r101.getWidth() - r101.getPaddingRight();
        r100.clipRect(r104, r101.getPaddingTop(), r105, r101.getHeight() - r101.getPaddingBottom());
    L13:
        int r106 = r101.getChildCount() - 1;
    L14:
        if (r103 >= r106) goto L16;
        View r107 = r101.getChildAt(r103);
        r101.getDecoratedBoundsWithMargins(r107, this.f85082d);
        int r108 = this.f85082d.bottom + Math.round(r107.getTranslationY());
        Drawable r109 = this.f85080b;
        Intrinsics.checkNotNull(r109);
        int r110 = r108 - r109.getIntrinsicHeight();
        Drawable r111 = this.f85080b;
        Intrinsics.checkNotNull(r111);
        r111.setBounds(r104, r110, r105, r108);
        Drawable r112 = this.f85080b;
        Intrinsics.checkNotNull(r112);
        r112.draw(r100);
        r103 = r103 + 1;
        goto L14
    L16:
        r100.restore();
        return;
    L12:
        r105 = r101.getWidth();
        r104 = 0;
        goto L13
    L17:
        r100.save();
        if (r101.getClipToPadding() == false) goto L20;
        int r113 = r101.getPaddingTop();
        int r114 = r101.getHeight() - r101.getPaddingBottom();
        r100.clipRect(r101.getPaddingLeft(), r113, r101.getWidth() - r101.getPaddingRight(), r114);
    L21:
        int r115 = r101.getChildCount() - 1;
    L22:
        if (r103 >= r115) goto L24;
        View r116 = r101.getChildAt(r103);
        RecyclerView.LayoutManager r117 = r101.getLayoutManager();
        Intrinsics.checkNotNull(r117);
        r117.getDecoratedBoundsWithMargins(r116, this.f85082d);
        int r118 = this.f85082d.right + Math.round(r116.getTranslationX());
        Drawable r119 = this.f85080b;
        Intrinsics.checkNotNull(r119);
        int r120 = r118 - r119.getIntrinsicWidth();
        Drawable r121 = this.f85080b;
        Intrinsics.checkNotNull(r121);
        r121.setBounds(r120, r113, r118, r114);
        Drawable r122 = this.f85080b;
        Intrinsics.checkNotNull(r122);
        r122.draw(r100);
        r103 = r103 + 1;
        goto L22
    L24:
        r100.restore();
        return;
    L20:
        r114 = r101.getHeight();
        r113 = 0;
        goto L21
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Drawable r104 = this.f85080b;
        if (r104 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return;
    L7:
        if (this.f85081c != this.f85079a) goto L9;
        Intrinsics.checkNotNull(r104);
        r100.set(0, 0, 0, r104.getIntrinsicHeight());
        return;
    L9:
        Intrinsics.checkNotNull(r104);
        r100.set(0, 0, r104.getIntrinsicWidth(), 0);
    }
}

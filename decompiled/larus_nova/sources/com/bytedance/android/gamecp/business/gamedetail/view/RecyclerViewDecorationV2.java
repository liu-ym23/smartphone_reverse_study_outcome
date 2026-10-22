package com.bytedance.android.gamecp.business.gamedetail.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/RecyclerViewDecorationV2;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewDecorationV2 extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f55730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.j f55732c;

    public RecyclerViewDecorationV2(boolean r100, com.bytedance.android.gamecp.business.gamedetail.base.model.j r101) {
        this.f55731b = r100;
        this.f55732c = r101;
        Paint r102 = new Paint();
        this.f55730a = r102;
        r102.setAntiAlias(true);
        if (r101 != null) goto L5;
    L11:
        int r103 = 0;
    L12:
        r102.setColor(r103);
        return;
    L5:
        if (r101.f53489a != true) goto L11;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r104 = r101.b();
        if (r104 != null) goto L9;
    L10:
        r103 = ColorProtector.parseColor("#FFF3F3F4");
        goto L12
    L9:
        if (r104.e() == true) goto L11;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        int r111 = r101.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r111) goto L11;
        View r103 = r101.getChildAt(r102);
        int r104 = r101.getChildAdapterPosition(r103);
        if (r104 == 0) goto L10;
        if (r104 == 1) goto L9;
        r100.drawRect(new Rect(0, r103.getTop() - y0.b(8.0f), y0.g(), r103.getTop()), this.f55730a);
        goto L10
    L9:
        r100.drawRect(new Rect(0, r103.getTop() - y0.b(20.0f), y0.g(), r103.getTop() + y0.b(20.0f)), this.f55730a);
    L10:
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = 0;
        if (r104 != 0) goto L5;
        r100.top = 0;
        return;
    L5:
        if (r104 == 1) goto L7;
        r100.top = y0.b(8.0f);
        return;
    L7:
        com.bytedance.android.gamecp.business.gamedetail.base.model.j r106 = this.f55732c;
        if (r106 == null) goto L17;
        if (r106.f53489a != true) goto L17;
        com.bytedance.android.gamecp.business.gamedetail.base.model.i r107 = r106.b();
        if (r107 == null) goto L17;
        if (r107.e() != true) goto L17;
    L21:
        r100.top = r105;
        return;
    L17:
        if (this.f55731b == false) goto L19;
        int r108 = y0.b(8.0f);
    L20:
        r105 = r108;
        goto L21
    L19:
        r108 = y0.b(16.0f);
        goto L20
    }
}

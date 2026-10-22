package com.bytedance.android.gamecp.business.gamedetail.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/ChildRecyclerViewDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChildRecyclerViewDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f55642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f55643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f55644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f55645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f55646e;

    public ChildRecyclerViewDecoration() {
        this(null, com.bytedance.android.gamecp.business.gamedetail.h.a(), true, 8.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, "state");
        if (this.f55644c == false) goto L5;
        return;
    L5:
        int r112 = r110.getChildCount();
        int r101 = 0;
    L6:
        if (r101 >= r112) goto L15;
        View r102 = r110.getChildAt(r101);
        if (r101 != (r112 - 1)) goto L11;
        r100.drawRect(new Rect(0, r102.getBottom(), y0.g(), r102.getBottom() + y0.b(24.0f)), this.f55642a);
    L11:
        if (this.f55645d == true) goto L13;
        if (r101 != 0) goto L13;
    L14:
        r101 = r101 + 1;
    L13:
        r100.drawRect(new Rect(0, r102.getTop() - y0.b(this.f55646e), y0.g(), r102.getTop()), this.f55642a);
        goto L14
    }

    public ChildRecyclerViewDecoration(Function0<Integer> r100, boolean r101, boolean r102, float r103) {
        this.f55643b = r100;
        this.f55644c = r101;
        this.f55645d = r102;
        this.f55646e = r103;
        Paint r104 = new Paint();
        this.f55642a = r104;
        r104.setAntiAlias(true);
        r104.setColor(y0.c(R.color.transparent));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Function0<Integer> r104 = this.f55643b;
        if (r104 == null) goto L7;
        Integer r105 = r104.invoke();
        if (r105 == null) goto L7;
        int r106 = r105.intValue();
    L8:
        int r107 = r102.getChildAdapterPosition(r101);
        if (r107 != (r106 - 1)) goto L11;
        r100.bottom = y0.b(24.0f);
    L12:
        int r108 = 0;
        if (this.f55645d == true) goto L17;
        if (r107 != 0) goto L17;
        r100.top = 0;
        return;
    L17:
        float r109 = this.f55646e;
        if (r109 == 0.0f) goto L21;
        r108 = y0.b(r109);
    L21:
        r100.top = r108;
        return;
    L11:
        r100.bottom = y0.b(0.0f);
    L7:
        r106 = r102.getChildCount();
        goto L8
    }
}

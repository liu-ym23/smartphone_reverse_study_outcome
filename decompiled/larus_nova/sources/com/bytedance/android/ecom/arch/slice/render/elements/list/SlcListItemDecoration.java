package com.bytedance.android.ecom.arch.slice.render.elements.list;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/list/SlcListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcListItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f50468c;

    public SlcListItemDecoration() {
        this.f50468c = true;
    }

    public SlcListItemDecoration(int r100, int r101, boolean r102) {
        this();
        this.f50466a = r100;
        this.f50467b = r101;
        this.f50468c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r110, View r111, RecyclerView r112, RecyclerView.State r113) {
        if (this.f50466a == 0) goto L5;
    L10:
        RecyclerView.LayoutManager r114 = r112.getLayoutManager();
        ViewGroup.LayoutParams r100 = null;
        if ((r114 instanceof GridLayoutManager) == false) goto L21;
        ViewGroup.LayoutParams r101 = r111.getLayoutParams();
        if ((r101 instanceof GridLayoutManager.LayoutParams) == false) goto L16;
        r100 = r101;
    L16:
        GridLayoutManager.LayoutParams r102 = (GridLayoutManager.LayoutParams) r100;
        if (r102 == null) goto L19;
        int r103 = r102.getSpanIndex();
        GridLayoutManager r115 = (GridLayoutManager) r114;
        int r104 = r115.getSpanCount();
        int r105 = r112.getChildLayoutPosition(r111);
        h(r110, r115.getOrientation(), r103, r104, r105);
        return;
    L19:
        r110.set(0, 0, 0, 0);
        return;
    L21:
        if ((r114 instanceof LinearLayoutManager) == false) goto L37;
        if (((LinearLayoutManager) r114).getOrientation() != 0) goto L31;
        if (this.f50466a > 0) goto L27;
        return;
    L27:
        if (r112.getChildLayoutPosition(r111) <= 0) goto L29;
        r110.set(this.f50466a, 0, 0, 0);
        return;
    L29:
        r110.set(0, 0, 0, 0);
        return;
    L31:
        if (this.f50467b > 0) goto L33;
        return;
    L33:
        if (r112.getChildLayoutPosition(r111) <= 0) goto L35;
        r110.set(0, this.f50467b, 0, 0);
        return;
    L35:
        r110.set(0, 0, 0, 0);
        return;
    L37:
        if ((r114 instanceof StaggeredGridLayoutManager) == false) goto L57;
        ViewGroup.LayoutParams r106 = r111.getLayoutParams();
        if ((r106 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L42;
        r100 = r106;
    L42:
        StaggeredGridLayoutManager.LayoutParams r107 = (StaggeredGridLayoutManager.LayoutParams) r100;
        if (r107 == null) goto L45;
        int r108 = r107.getSpanIndex();
        StaggeredGridLayoutManager r116 = (StaggeredGridLayoutManager) r114;
        int r109 = r116.getSpanCount();
        int r117 = r112.getChildLayoutPosition(r111);
        h(r110, r116.getOrientation(), r108, r109, r117);
        return;
    L45:
        r110.set(0, 0, 0, 0);
        return;
    L57:
        return;
    L5:
        if (this.f50467b != 0) goto L10;
        if (this.f50468c == false) goto L9;
        r110.set(0, 0, 0, 0);
        return;
    L9:
        super.getItemOffsets(r110, r111, r112, r113);
    }

    public final void h(Rect r100, int r101, int r102, int r103, int r104) {
        if (r101 != 0) goto L15;
        int r105 = this.f50467b / 2;
        if (r104 >= r103) goto L7;
        int r106 = 0;
    L8:
        if (r102 != 0) goto L10;
        int r107 = 0;
    L12:
        if (r102 != (r103 - 1)) goto L14;
        r105 = 0;
    L14:
        r100.set(r106, r107, 0, r105);
        return;
    L10:
        r107 = r105;
        goto L12
    L7:
        r106 = this.f50466a;
        goto L8
    L15:
        int r108 = this.f50466a / 2;
        if (r102 != 0) goto L18;
        int r109 = 0;
    L19:
        if (r104 >= r103) goto L21;
        int r110 = 0;
    L23:
        if (r102 != (r103 - 1)) goto L25;
        r108 = 0;
    L25:
        r100.set(r109, r110, r108, 0);
        return;
    L21:
        r110 = this.f50467b;
        goto L23
    L18:
        r109 = r108;
        goto L19
    }
}

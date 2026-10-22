package com.bytedance.android.live.ktv.common.karaokestation;

import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.ktv.common.util.j;
import nb0.c;

/* JADX INFO: loaded from: classes45.dex */
public final class ItemExposureCheckHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f69484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f69485b;

    public static final class a {
    }

    static {
    }

    public ItemExposureCheckHelper() {
    }

    public final void a(boolean r110) {
        RecyclerView r100 = this.f69485b;
        if (r100 != null) goto L5;
    L29:
        boolean r101 = true;
    L30:
        if (r110 == false) goto L33;
        if (r101 == false) goto L33;
        boolean r102 = true;
    L34:
        if (r102 == false) goto L75;
        return;
    L75:
        int[] r103 = new int[2];     // Catch: Exception -> L72
        RecyclerView r104 = this.f69485b;     // Catch: Exception -> L72
        if (r104 == null) goto L40;
        RecyclerView.LayoutManager r105 = r104.getLayoutManager();     // Catch: Exception -> L72
    L42:
        if ((r105 instanceof GridLayoutManager) == false) goto L45;
        GridLayoutManager r106 = (GridLayoutManager) r105;     // Catch: Exception -> L72
        r103 = new int[]{r106.findFirstVisibleItemPosition(), r106.findLastVisibleItemPosition()};     // Catch: Exception -> L72
    L63:
        if (r103.length >= 2) goto L65;
        return;
    L65:
        j.j("ItemExposureCheckHelper", "handleCurrentVisibleItems ;; visible item ;;  start position == " + r103[0] + " ;;  end position == " + r103[1] + ' ');     // Catch: Exception -> L72
        int r107 = r103[0];     // Catch: Exception -> L72
        int r108 = r103[1];     // Catch: Exception -> L72
        if (r107 > r108) goto L84;
    L67:
        c r109 = this.f69484a;     // Catch: Exception -> L72
        if (r109 == null) goto L70;
        r109.a(r107, r110);     // Catch: Exception -> L72
    L70:
        if (r107 == r108) goto L85;
        r107 = r107 + 1;
        goto L67
    L85:
        return;
    L84:
        return;
    L45:
        if ((r105 instanceof LinearLayoutManager) == false) goto L48;
        LinearLayoutManager r111 = (LinearLayoutManager) r105;     // Catch: Exception -> L72
        r103 = new int[]{r111.findFirstVisibleItemPosition(), r111.findLastVisibleItemPosition()};     // Catch: Exception -> L72
        goto L63
    L48:
        if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L63;
        StaggeredGridLayoutManager r112 = (StaggeredGridLayoutManager) r105;     // Catch: Exception -> L72
        int r113 = r112.getSpanCount();     // Catch: Exception -> L72
        int[] r114 = new int[r113];     // Catch: Exception -> L72
        int r115 = r112.getSpanCount();     // Catch: Exception -> L72
        int[] r116 = new int[r115];     // Catch: Exception -> L72
        r112.findFirstVisibleItemPositions(r114);     // Catch: Exception -> L72
        r112.findLastVisibleItemPositions(r116);     // Catch: Exception -> L72
        int r117 = r114[0];     // Catch: Exception -> L72
        int r118 = r116[0];     // Catch: Exception -> L72
        int r119 = 1;
    L50:
        if (r119 >= r113) goto L55;
        int r120 = r114[r119];     // Catch: Exception -> L72
        if (r117 <= r120) goto L54;
        r117 = r120;
    L54:
        r119 = r119 + 1;     // Catch: Exception -> L72
        goto L50
    L55:
        int r121 = 1;
    L56:
        if (r121 >= r115) goto L61;
        int r122 = r116[r121];     // Catch: Exception -> L72
        if (r118 >= r122) goto L60;
        r118 = r122;
    L60:
        r121 = r121 + 1;     // Catch: Exception -> L72
        goto L56
    L61:
        r103 = new int[]{r117, r118};     // Catch: Exception -> L72
        goto L63
    L40:
        r105 = null;
    L72:
        e = move-exception;
        j.j("ItemExposureCheckHelper", "handleCurrentVisibleItems ;; error message == " + e.getMessage());
        return;
    L33:
        r102 = false;
        goto L34
    L5:
        if (r100.getVisibility() != 0) goto L29;
        RecyclerView r123 = this.f69485b;
        if (r123 == null) goto L29;
        if (r123.isShown() != true) goto L29;
        RecyclerView r124 = this.f69485b;
        Rect r125 = new Rect();
        if (r124 == null) goto L16;
        if (r124.getGlobalVisibleRect(r125) != true) goto L16;
    L25:
        boolean r126 = true;
    L26:
        if (r126 == false) goto L29;
        r101 = false;
    L16:
        if (r125.top != 0) goto L25;
        if (r125.bottom != 0) goto L25;
        if (r125.left != 0) goto L25;
        if (r125.right != 0) goto L25;
        r126 = false;
        goto L26
    }

    public final void b(RecyclerView r100, c r101) {
        this.f69484a = r101;
        this.f69485b = r100;
        if (r100 == null) goto L6;
        r100.addOnScrollListener(new ItemExposureCheckHelper$setRecyclerItemExposureListener$1(this));
        return;
    }
}

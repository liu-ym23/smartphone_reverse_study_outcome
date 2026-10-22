package b90;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final int a(RecyclerView.LayoutManager r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L11;
        int[] r101 = ((StaggeredGridLayoutManager) r100).findFirstCompletelyVisibleItemPositions(null);
        if (r101 != null) goto L18;
        return 0;
    L18:
        return r101[0];
    L11:
        if ((r100 instanceof GridLayoutManager) == false) goto L14;
        return ((GridLayoutManager) r100).findFirstCompletelyVisibleItemPosition();
    L14:
        if ((r100 instanceof LinearLayoutManager) == true) goto L16;
        return 0;
    L16:
        return ((LinearLayoutManager) r100).findFirstCompletelyVisibleItemPosition();
    }

    @JvmStatic
    public static final int b(RecyclerView.LayoutManager r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L11;
        int[] r101 = ((StaggeredGridLayoutManager) r100).findFirstVisibleItemPositions(null);
        if (r101 != null) goto L18;
        return 0;
    L18:
        return r101[0];
    L11:
        if ((r100 instanceof GridLayoutManager) == false) goto L14;
        return ((GridLayoutManager) r100).findFirstVisibleItemPosition();
    L14:
        if ((r100 instanceof LinearLayoutManager) == true) goto L16;
        return 0;
    L16:
        return ((LinearLayoutManager) r100).findFirstVisibleItemPosition();
    }

    @JvmStatic
    public static final void c(RecyclerView.LayoutManager r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L8;
        ((StaggeredGridLayoutManager) r100).scrollToPositionWithOffset(r101, r102);
        return;
    L8:
        if ((r100 instanceof GridLayoutManager) == false) goto L11;
        ((GridLayoutManager) r100).scrollToPositionWithOffset(r101, r102);
        return;
    L11:
        if ((r100 instanceof LinearLayoutManager) == false) goto L16;
        ((LinearLayoutManager) r100).scrollToPositionWithOffset(r101, r102);
        return;
    }
}

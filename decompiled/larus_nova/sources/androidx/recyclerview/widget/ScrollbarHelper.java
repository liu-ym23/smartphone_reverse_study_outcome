package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    public static int computeScrollExtent(RecyclerView.State r100, OrientationHelper r101, View r102, View r103, RecyclerView.LayoutManager r104, boolean r105) {
        if (r104.getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r100.getItemCount() == 0) goto L16;
        if (r102 == null) goto L17;
        if (r103 == null) goto L18;
        if (r105 == false) goto L11;
        int r106 = r101.getDecoratedEnd(r103) - r101.getDecoratedStart(r102);
        return Math.min(r101.getTotalSpace(), r106);
    L11:
        return Math.abs(r104.getPosition(r102) - r104.getPosition(r103)) + 1;
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static int computeScrollRange(RecyclerView.State r100, OrientationHelper r101, View r102, View r103, RecyclerView.LayoutManager r104, boolean r105) {
        if (r104.getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r100.getItemCount() == 0) goto L16;
        if (r102 == null) goto L17;
        if (r103 == null) goto L18;
        if (r105 == true) goto L13;
        return r100.getItemCount();
    L13:
        return (int) (((r101.getDecoratedEnd(r103) - r101.getDecoratedStart(r102)) / (Math.abs(r104.getPosition(r102) - r104.getPosition(r103)) + 1)) * r100.getItemCount());
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static int computeScrollOffset(RecyclerView.State r100, OrientationHelper r101, View r102, View r103, RecyclerView.LayoutManager r104, boolean r105, boolean r110) {
        if (r104.getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r100.getItemCount() == 0) goto L17;
        if (r102 == null) goto L17;
        if (r103 == null) goto L17;
        int r106 = Math.min(r104.getPosition(r102), r104.getPosition(r103));
        int r107 = Math.max(r104.getPosition(r102), r104.getPosition(r103));
        if (r110 == false) goto L12;
        int r108 = Math.max(0, (r100.getItemCount() - r107) - 1);
    L13:
        if (r105 == true) goto L16;
        return r108;
    L16:
        return Math.round((r108 * (Math.abs(r101.getDecoratedEnd(r103) - r101.getDecoratedStart(r102)) / (Math.abs(r104.getPosition(r102) - r104.getPosition(r103)) + 1))) + (r101.getStartAfterPadding() - r101.getDecoratedStart(r102)));
    L12:
        r108 = Math.max(0, r106);
        goto L13
    }
}

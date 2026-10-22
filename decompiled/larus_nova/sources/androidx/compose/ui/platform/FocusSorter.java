package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%¢\u0006\u0002\u0010&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006'"}, d2 = {"Landroidx/compose/ui/platform/FocusSorter;", "", "<init>", "()V", "rectPool", "Landroidx/collection/MutableObjectList;", "Landroid/graphics/Rect;", "getRectPool", "()Landroidx/collection/MutableObjectList;", "lastPoolIndex", "", "getLastPoolIndex", "()I", "setLastPoolIndex", "(I)V", "rtlMult", "getRtlMult", "setRtlMult", "rectByView", "Landroidx/collection/MutableScatterMap;", "Landroid/view/View;", "getRectByView", "()Landroidx/collection/MutableScatterMap;", "topsComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getTopsComparator", "()Ljava/util/Comparator;", "sidesComparator", "getSidesComparator", "sort", "", "views", "", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "isRtl", "", "([Landroid/view/View;Landroid/view/ViewGroup;Z)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FocusSorter {
    public static final FocusSorter INSTANCE = null;
    private static int lastPoolIndex;
    private static final MutableScatterMap<View, Rect> rectByView = null;
    private static final MutableObjectList<Rect> rectPool = null;
    private static int rtlMult;
    private static final Comparator<View> sidesComparator = null;
    private static final Comparator<View> topsComparator = null;

    private FocusSorter() {
    }

    public static /* synthetic */ int a(View r100, View r101) {
        return sidesComparator$lambda$1(r100, r101);
    }

    public static /* synthetic */ int b(View r100, View r101) {
        return topsComparator$lambda$0(r100, r101);
    }

    static {
        INSTANCE = new FocusSorter();
        int r100 = 0;
        int r101 = 1;
        rectPool = new MutableObjectList(r100, r101, null);
        rtlMult = 1;
        rectByView = ScatterMapKt.mutableScatterMapOf();
        topsComparator = new o();
        sidesComparator = new p();
    }

    public final int getLastPoolIndex() {
        return lastPoolIndex;
    }

    public final MutableScatterMap<View, Rect> getRectByView() {
        return rectByView;
    }

    public final MutableObjectList<Rect> getRectPool() {
        return rectPool;
    }

    public final int getRtlMult() {
        return rtlMult;
    }

    public final Comparator<View> getSidesComparator() {
        return sidesComparator;
    }

    public final Comparator<View> getTopsComparator() {
        return topsComparator;
    }

    public final void setLastPoolIndex(int r100) {
        lastPoolIndex = r100;
    }

    public final void setRtlMult(int r100) {
        rtlMult = r100;
    }

    private static final int sidesComparator$lambda$1(View r100, View r101) {
        if (r100 != r101) goto L4;
        return 0;
    L4:
        MutableScatterMap<View, Rect> r102 = rectByView;
        Rect r103 = r102.get(r100);
        Intrinsics.checkNotNull(r103);
        Rect r104 = r103;
        Rect r105 = r102.get(r101);
        Intrinsics.checkNotNull(r105);
        Rect r106 = r105;
        int r107 = r104.left - r106.left;
        if (r107 != 0) goto L8;
        return (r104.right - r106.right) * rtlMult;
    L8:
        return rtlMult * r107;
    }

    private static final int topsComparator$lambda$0(View r100, View r101) {
        if (r100 != r101) goto L4;
        return 0;
    L4:
        MutableScatterMap<View, Rect> r102 = rectByView;
        Rect r103 = r102.get(r100);
        Intrinsics.checkNotNull(r103);
        Rect r104 = r103;
        Rect r105 = r102.get(r101);
        Intrinsics.checkNotNull(r105);
        Rect r106 = r105;
        int r107 = r104.top - r106.top;
        if (r107 != 0) goto L8;
        return r104.bottom - r106.bottom;
    L8:
        return r107;
    }

    public final void sort(View[] r100, ViewGroup r110, boolean r111) {
        int r101 = r100.length;
        if (r101 >= 2) goto L5;
        return;
    L5:
        int r102 = r101 - rectPool.getSize();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        rectPool.add(new Rect());
        r103 = r103 + 1;
        goto L6
    L8:
        int r104 = r100.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        View r106 = r100[r105];
        MutableObjectList<Rect> r107 = rectPool;
        int r108 = lastPoolIndex;
        lastPoolIndex = r108 + 1;
        Rect r109 = r107.get(r108);
        r106.getDrawingRect(r109);
        r110.offsetDescendantRectToMyCoords(r106, r109);
        rectByView.set(r106, r109);
        r105 = r105 + 1;
        goto L9
    L11:
        ArraysKt.sortWith(r100, topsComparator);
        Rect r112 = rectByView.get(r100[0]);
        Intrinsics.checkNotNull(r112);
        int r113 = r112.bottom;
        if (r111 == false) goto L14;
        int r114 = -1;
    L15:
        rtlMult = r114;
        int r115 = 0;
        int r116 = 0;
    L16:
        if (r115 >= r101) goto L26;
        Rect r117 = rectByView.get(r100[r115]);
        Intrinsics.checkNotNull(r117);
        Rect r118 = r117;
        if (r118.top >= r113) goto L20;
        r113 = Math.max(r113, r118.bottom);
    L24:
        r115 = r115 + 1;
        goto L16
    L20:
        if ((r115 - r116) <= 1) goto L22;
        ArraysKt.sortWith(r100, sidesComparator, r116, r115);
    L22:
        r113 = r118.bottom;
        r116 = r115;
        goto L24
    L26:
        if ((r101 - r116) <= 1) goto L28;
        ArraysKt.sortWith(r100, sidesComparator, r116, r101);
    L28:
        lastPoolIndex = 0;
        rectByView.clear();
        return;
    L14:
        r114 = 1;
        goto L15
    }
}

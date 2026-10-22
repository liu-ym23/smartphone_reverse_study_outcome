package ai2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3729a = 0;

    public b() {
    }

    static {
    }

    public static final void a(RecyclerView r110, a r111) {
        if (r110.getVisibility() == 0) goto L5;
        return;
    L5:
        if (r110.isShown() == true) goto L7;
        return;
    L7:
        if (r110.getGlobalVisibleRect(new Rect()) == true) goto L81;
        return;
    L81:
        int[] r100 = new int[2];     // Catch: Exception -> L80
        RecyclerView.LayoutManager r112 = r110.getLayoutManager();     // Catch: Exception -> L80
        if ((r112 instanceof LinearLayoutManager) == false) goto L18;
        if (r112 == null) goto L16;
        LinearLayoutManager r101 = (LinearLayoutManager) r112;     // Catch: Exception -> L80
        int[] r102 = {r101.findFirstVisibleItemPosition(), r101.findLastVisibleItemPosition()};     // Catch: Exception -> L80
        int r103 = r101.getOrientation();     // Catch: Exception -> L80
    L14:
        int[] r113 = r102;
        int r104 = r103;
        r100 = r113;
    L43:
        if (r100.length < 2) goto L90;
        r111.b(new Pair(Integer.valueOf(r100[0]), Integer.valueOf(r100[1])));     // Catch: Exception -> L80
        int r105 = r100[0];     // Catch: Exception -> L80
        int r106 = r100[1];     // Catch: Exception -> L80
        if (r105 > r106) goto L91;
    L47:
        if (r112 == null) goto L49;
        View r107 = r112.findViewByPosition(r105);     // Catch: Exception -> L80
    L50:
        if (r107 != null) goto L52;
    L77:
        if (r105 == r106) goto L94;
        r105 = r105 + 1;
        goto L47
    L94:
        return;
    L52:
        if (r107.getVisibility() != 0) goto L77;
        if (r107.isShown() == false) goto L77;
        if (r107.getGlobalVisibleRect(new Rect()) == false) goto L77;
        Rect r108 = new Rect();     // Catch: Exception -> L80
        boolean r109 = r107.getGlobalVisibleRect(r108);     // Catch: Exception -> L80
        if (r104 == 1) goto L61;
    L63:
        boolean r114 = false;
    L64:
        if (r104 == 0) goto L66;
    L68:
        boolean r115 = false;
    L69:
        if (r114 == true) goto L73;
        if (r115 == true) goto L73;
        boolean r116 = false;
    L74:
        if (r109 == false) goto L77;
        if (r116 == false) goto L77;
        r111.a(r105);     // Catch: Exception -> L80
    L73:
        r116 = true;
        goto L74
    L66:
        if (r108.width() < r107.getMeasuredWidth()) goto L68;
        r115 = true;
        goto L69
    L61:
        if (r108.height() < r107.getMeasuredHeight()) goto L63;
        r114 = true;
        goto L64
    L49:
        r107 = null;
        goto L50
    L91:
        return;
    L90:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");     // Catch: Exception -> L80
    L18:
        if ((r112 instanceof GridLayoutManager) == false) goto L24;
        if (r112 == null) goto L22;
        GridLayoutManager r117 = (GridLayoutManager) r112;     // Catch: Exception -> L80
        r102 = new int[]{r117.findFirstVisibleItemPosition(), r117.findLastVisibleItemPosition()};     // Catch: Exception -> L80
        r103 = r117.getOrientation();     // Catch: Exception -> L80
        goto L14
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");     // Catch: Exception -> L80
    L24:
        if ((r112 instanceof StaggeredGridLayoutManager) == false) goto L41;
        if (r112 == null) goto L40;
        StaggeredGridLayoutManager r118 = (StaggeredGridLayoutManager) r112;     // Catch: Exception -> L80
        int r119 = r118.getSpanCount();     // Catch: Exception -> L80
        int[] r120 = new int[r119];     // Catch: Exception -> L80
        int r121 = r118.getSpanCount();     // Catch: Exception -> L80
        int[] r122 = new int[r121];     // Catch: Exception -> L80
        r118.findFirstVisibleItemPositions(r120);     // Catch: Exception -> L80
        r118.findLastVisibleItemPositions(r122);     // Catch: Exception -> L80
        int r123 = r120[0];     // Catch: Exception -> L80
        int r124 = r122[0];     // Catch: Exception -> L80
        int r125 = 1;
    L27:
        if (r125 >= r119) goto L32;
        int r126 = r120[r125];     // Catch: Exception -> L80
        if (r123 <= r126) goto L31;
        r123 = r126;
    L31:
        r125 = r125 + 1;     // Catch: Exception -> L80
        goto L27
    L32:
        int r127 = 1;
    L33:
        if (r127 >= r121) goto L38;
        int r128 = r122[r127];     // Catch: Exception -> L80
        if (r124 >= r128) goto L37;
        r124 = r128;
    L37:
        r127 = r127 + 1;     // Catch: Exception -> L80
        goto L33
    L38:
        r102 = new int[]{r123, r124};     // Catch: Exception -> L80
        r103 = r118.getOrientation();     // Catch: Exception -> L80
        goto L14
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");     // Catch: Exception -> L80
    L41:
        r104 = -1;
        goto L43
    }
}

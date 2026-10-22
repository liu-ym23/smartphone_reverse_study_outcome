package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class p extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10699a = J.g(null);

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f10700b = J.g(null);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f10701c;

    public p(s sVar) {
        this.f10701c = sVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Object obj;
        if ((recyclerView.getAdapter() instanceof M) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            M m4 = (M) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            s sVar = this.f10701c;
            Iterator it = sVar.f10706c.e().iterator();
            while (it.hasNext()) {
                J.b bVar = (J.b) it.next();
                Object obj2 = bVar.f848a;
                if (obj2 != null && (obj = bVar.f849b) != null) {
                    long jLongValue = ((Long) obj2).longValue();
                    Calendar calendar = this.f10699a;
                    calendar.setTimeInMillis(jLongValue);
                    long jLongValue2 = ((Long) obj).longValue();
                    Calendar calendar2 = this.f10700b;
                    calendar2.setTimeInMillis(jLongValue2);
                    int i4 = calendar.get(1) - m4.f10625a.f10707d.f10599a.f10659c;
                    int i5 = calendar2.get(1) - m4.f10625a.f10707d.f10599a.f10659c;
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i4);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i5);
                    int spanCount = i4 / gridLayoutManager.getSpanCount();
                    int spanCount2 = i5 / gridLayoutManager.getSpanCount();
                    int i6 = spanCount;
                    while (i6 <= spanCount2) {
                        if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i6) != null) {
                            canvas.drawRect((i6 != spanCount || viewFindViewByPosition == null) ? 0 : (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft(), ((Rect) ((H.d) sVar.f10711h.f13799d).f661c).top + r10.getTop(), (i6 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft(), r10.getBottom() - ((Rect) ((H.d) sVar.f10711h.f13799d).f661c).bottom, (Paint) sVar.f10711h.f13803h);
                        }
                        i6++;
                    }
                }
            }
        }
    }
}

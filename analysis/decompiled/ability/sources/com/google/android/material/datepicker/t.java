package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* loaded from: classes3.dex */
public final class t extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f2436a = O.g(null);
    public final Calendar b = O.g(null);
    public final /* synthetic */ MaterialCalendar c;

    public t(MaterialCalendar materialCalendar) {
        this.c = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if ((recyclerView.getAdapter() instanceof S) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            S s5 = (S) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            MaterialCalendar materialCalendar = this.c;
            for (Pair<Long, Long> pair : materialCalendar.c.getSelectedRanges()) {
                Long l = pair.first;
                if (l != null && pair.second != null) {
                    long jLongValue = l.longValue();
                    Calendar calendar = this.f2436a;
                    calendar.setTimeInMillis(jLongValue);
                    long jLongValue2 = pair.second.longValue();
                    Calendar calendar2 = this.b;
                    calendar2.setTimeInMillis(jLongValue2);
                    int i = calendar.get(1) - s5.f2423a.d.getStart().year;
                    int i6 = calendar2.get(1) - s5.f2423a.d.getStart().year;
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i);
                    View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i6);
                    int spanCount = i / gridLayoutManager.getSpanCount();
                    int spanCount2 = i6 / gridLayoutManager.getSpanCount();
                    for (int i10 = spanCount; i10 <= spanCount2; i10++) {
                        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i10);
                        if (viewFindViewByPosition3 != null) {
                            int top = viewFindViewByPosition3.getTop() + ((Rect) ((C0900c) materialCalendar.h.d).b).top;
                            int bottom = viewFindViewByPosition3.getBottom() - ((Rect) ((C0900c) materialCalendar.h.d).b).bottom;
                            canvas.drawRect((i10 != spanCount || viewFindViewByPosition == null) ? 0 : (viewFindViewByPosition.getWidth() / 2) + viewFindViewByPosition.getLeft(), top, (i10 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : (viewFindViewByPosition2.getWidth() / 2) + viewFindViewByPosition2.getLeft(), bottom, (Paint) materialCalendar.h.h);
                        }
                    }
                }
            }
        }
    }
}

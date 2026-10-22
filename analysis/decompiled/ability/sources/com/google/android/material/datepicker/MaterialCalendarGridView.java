package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f2419a;
    public final boolean b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2419a = O.g(null);
        if (A.d(R.attr.windowFullscreen, getContext())) {
            setNextFocusLeftId(com.stepos.ability.R.id.cancel_button);
            setNextFocusRightId(com.stepos.ability.R.id.confirm_button);
        }
        this.b = A.d(com.stepos.ability.R.attr.nestedScrollable, getContext());
        ViewCompat.setAccessibilityDelegate(this, new C0914q(2));
    }

    public final D a() {
        return (D) super.getAdapter();
    }

    public final View b(int i) {
        return getChildAt(i - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (D) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((D) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        int i;
        int width3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        D d = (D) super.getAdapter();
        DateSelector dateSelector = d.b;
        Month month = d.f2410a;
        C5.f fVar = d.d;
        int iMax = Math.max(d.a(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(d.c(), materialCalendarGridView.getLastVisiblePosition());
        Long item = d.getItem(iMax);
        Long item2 = d.getItem(iMin);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            Long l = next.first;
            if (l == null) {
                materialCalendarGridView = this;
            } else if (next.second != null) {
                Long l5 = l;
                long jLongValue = l5.longValue();
                Long l9 = next.second;
                long jLongValue2 = l9.longValue();
                if (item == null || item2 == null || l5.longValue() > item2.longValue() || l9.longValue() < item.longValue()) {
                    materialCalendarGridView = this;
                    month = month;
                    it = it;
                    d = d;
                } else {
                    boolean z10 = materialCalendarGridView.getLayoutDirection() == 1;
                    long jLongValue3 = item.longValue();
                    Calendar calendar = materialCalendarGridView.f2419a;
                    if (jLongValue < jLongValue3) {
                        width = iMax % month.daysInWeek == 0 ? 0 : !z10 ? materialCalendarGridView.b(iMax - 1).getRight() : materialCalendarGridView.b(iMax - 1).getLeft();
                        iA = iMax;
                    } else {
                        calendar.setTimeInMillis(jLongValue);
                        iA = d.a() + (calendar.get(5) - 1);
                        View viewB = materialCalendarGridView.b(iA);
                        width = (viewB.getWidth() / 2) + viewB.getLeft();
                    }
                    if (jLongValue2 > item2.longValue()) {
                        width2 = (iMin + 1) % month.daysInWeek == 0 ? materialCalendarGridView.getWidth() : !z10 ? materialCalendarGridView.b(iMin).getRight() : materialCalendarGridView.b(iMin).getLeft();
                        iA2 = iMin;
                    } else {
                        calendar.setTimeInMillis(jLongValue2);
                        iA2 = d.a() + (calendar.get(5) - 1);
                        View viewB2 = materialCalendarGridView.b(iA2);
                        width2 = (viewB2.getWidth() / 2) + viewB2.getLeft();
                    }
                    int itemId = (int) d.getItemId(iA);
                    Iterator<Pair<Long, Long>> it2 = it;
                    Month month2 = month;
                    int itemId2 = (int) d.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        D d6 = d;
                        int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                        View viewB3 = materialCalendarGridView.b(numColumns);
                        int top = viewB3.getTop() + ((Rect) ((C0900c) fVar.f302a).b).top;
                        int i6 = itemId2;
                        int bottom = viewB3.getBottom() - ((Rect) ((C0900c) fVar.f302a).b).bottom;
                        if (z10) {
                            int i10 = iA2 > numColumns2 ? 0 : width2;
                            int width4 = numColumns > iA ? getWidth() : width;
                            i = i10;
                            width3 = width4;
                        } else {
                            i = numColumns > iA ? 0 : width;
                            width3 = iA2 > numColumns2 ? getWidth() : width2;
                        }
                        canvas.drawRect(i, top, width3, bottom, (Paint) fVar.h);
                        itemId++;
                        materialCalendarGridView = this;
                        d = d6;
                        itemId2 = i6;
                    }
                    materialCalendarGridView = this;
                    month = month2;
                    it = it2;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z10, int i, Rect rect) {
        if (!z10) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((D) super.getAdapter()).c());
        } else if (i == 130) {
            setSelection(((D) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((D) super.getAdapter()).a() && selectedItemPosition <= ((D) super.getAdapter()).c())) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((D) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i6) {
        if (!this.b) {
            super.onMeasure(i, i6);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((D) super.getAdapter()).a()) {
            super.setSelection(((D) super.getAdapter()).a());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (D) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof D)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), D.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}

package com.google.android.material.datepicker;

import K.S;
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
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10626a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10627b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f10626a = J.g(null);
        if (MaterialDatePicker.k(R.attr.windowFullscreen, getContext())) {
            setNextFocusLeftId(com.stepos.alphame.R.id.cancel_button);
            setNextFocusRightId(com.stepos.alphame.R.id.confirm_button);
        }
        this.f10627b = MaterialDatePicker.k(com.stepos.alphame.R.attr.nestedScrollable, getContext());
        S.h(this, new C0434m(3, this));
    }

    public final y a() {
        return (y) super.getAdapter();
    }

    public final View b(int i4) {
        return getChildAt(i4 - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (y) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((y) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        int i4;
        int width3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        y yVar = (y) super.getAdapter();
        DateSelector dateSelector = yVar.f10736b;
        o2.d dVar = yVar.f10738d;
        int iMax = Math.max(yVar.a(), getFirstVisiblePosition());
        int iMin = Math.min(yVar.c(), getLastVisiblePosition());
        Long item = yVar.getItem(iMax);
        Long item2 = yVar.getItem(iMin);
        Iterator it = dateSelector.e().iterator();
        while (it.hasNext()) {
            J.b bVar = (J.b) it.next();
            Object obj = bVar.f848a;
            if (obj != null) {
                Object obj2 = bVar.f849b;
                if (obj2 != null) {
                    Long l4 = (Long) obj;
                    long jLongValue = l4.longValue();
                    Long l5 = (Long) obj2;
                    long jLongValue2 = l5.longValue();
                    if (item == null || item2 == null || l4.longValue() > item2.longValue() || l5.longValue() < item.longValue()) {
                        materialCalendarGridView = this;
                        iMax = iMax;
                        yVar = yVar;
                        it = it;
                    } else {
                        boolean z4 = getLayoutDirection() == 1;
                        long jLongValue3 = item.longValue();
                        Calendar calendar = materialCalendarGridView.f10626a;
                        Month month = yVar.f10735a;
                        if (jLongValue < jLongValue3) {
                            width = iMax % month.f10660d == 0 ? 0 : !z4 ? materialCalendarGridView.b(iMax - 1).getRight() : materialCalendarGridView.b(iMax - 1).getLeft();
                            iA = iMax;
                        } else {
                            calendar.setTimeInMillis(jLongValue);
                            iA = yVar.a() + (calendar.get(5) - 1);
                            View viewB = materialCalendarGridView.b(iA);
                            width = (viewB.getWidth() / 2) + viewB.getLeft();
                        }
                        if (jLongValue2 > item2.longValue()) {
                            width2 = (iMin + 1) % month.f10660d == 0 ? getWidth() : !z4 ? materialCalendarGridView.b(iMin).getRight() : materialCalendarGridView.b(iMin).getLeft();
                            iA2 = iMin;
                        } else {
                            calendar.setTimeInMillis(jLongValue2);
                            iA2 = yVar.a() + (calendar.get(5) - 1);
                            View viewB2 = materialCalendarGridView.b(iA2);
                            width2 = (viewB2.getWidth() / 2) + viewB2.getLeft();
                        }
                        int itemId = (int) yVar.getItemId(iA);
                        int itemId2 = (int) yVar.getItemId(iA2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            y yVar2 = yVar;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View viewB3 = materialCalendarGridView.b(numColumns);
                            int top = ((Rect) ((H.d) dVar.f13796a).f661c).top + viewB3.getTop();
                            Iterator it2 = it;
                            int bottom = viewB3.getBottom() - ((Rect) ((H.d) dVar.f13796a).f661c).bottom;
                            if (z4) {
                                int i5 = iA2 > numColumns2 ? 0 : width2;
                                int width4 = numColumns > iA ? getWidth() : width;
                                i4 = i5;
                                width3 = width4;
                            } else {
                                i4 = numColumns > iA ? 0 : width;
                                width3 = iA2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i4, top, width3, bottom, (Paint) dVar.f13803h);
                            itemId++;
                            materialCalendarGridView = this;
                            iMax = iMax;
                            yVar = yVar2;
                            it = it2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z4, int i4, Rect rect) {
        if (!z4) {
            super.onFocusChanged(false, i4, rect);
            return;
        }
        if (i4 == 33) {
            setSelection(((y) super.getAdapter()).c());
        } else if (i4 == 130) {
            setSelection(((y) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i4, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (!super.onKeyDown(i4, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((y) super.getAdapter()).a() && selectedItemPosition <= ((y) super.getAdapter()).c())) {
            return true;
        }
        if (19 != i4) {
            return false;
        }
        setSelection(((y) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (!this.f10627b) {
            super.onMeasure(i4, i5);
            return;
        }
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i4) {
        if (i4 < ((y) super.getAdapter()).a()) {
            super.setSelection(((y) super.getAdapter()).a());
        } else {
            super.setSelection(i4);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (y) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof y)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), y.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}

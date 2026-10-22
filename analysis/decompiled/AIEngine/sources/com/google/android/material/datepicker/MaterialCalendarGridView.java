package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.stepos.aiengine.R;
import java.util.Calendar;
import java.util.Iterator;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f4920a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4921b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4920a = s.g(null);
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f4921b = MaterialDatePicker.isNestedScrollable(getContext());
        e0.j(this, new i());
    }

    public final m a() {
        return (m) super.getAdapter();
    }

    public final View b(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (m) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((m) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iB;
        int width;
        int iB2;
        int width2;
        int i10;
        int width3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        m mVar = (m) super.getAdapter();
        DateSelector<?> dateSelector = mVar.f4974b;
        Month month = mVar.f4973a;
        b bVar = mVar.f4976d;
        int iMax = Math.max(mVar.b(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(mVar.d(), materialCalendarGridView.getLastVisiblePosition());
        Long item = mVar.getItem(iMax);
        Long item2 = mVar.getItem(iMin);
        Iterator<u0.b<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            u0.b<Long, Long> next = it.next();
            Long l10 = next.f13138a;
            Long l11 = next.f13139b;
            if (l10 == null) {
                materialCalendarGridView = this;
            } else if (l11 != null) {
                Long l12 = l10;
                long jLongValue = l12.longValue();
                Long l13 = l11;
                long jLongValue2 = l13.longValue();
                if (item == null || item2 == null || l12.longValue() > item2.longValue() || l13.longValue() < item.longValue()) {
                    materialCalendarGridView = this;
                    month = month;
                    it = it;
                    mVar = mVar;
                } else {
                    boolean z = materialCalendarGridView.getLayoutDirection() == 1;
                    long jLongValue3 = item.longValue();
                    Calendar calendar = materialCalendarGridView.f4920a;
                    if (jLongValue < jLongValue3) {
                        width = iMax % month.daysInWeek == 0 ? 0 : !z ? materialCalendarGridView.b(iMax - 1).getRight() : materialCalendarGridView.b(iMax - 1).getLeft();
                        iB = iMax;
                    } else {
                        calendar.setTimeInMillis(jLongValue);
                        iB = mVar.b() + (calendar.get(5) - 1);
                        View viewB = materialCalendarGridView.b(iB);
                        width = (viewB.getWidth() / 2) + viewB.getLeft();
                    }
                    if (jLongValue2 > item2.longValue()) {
                        width2 = (iMin + 1) % month.daysInWeek == 0 ? materialCalendarGridView.getWidth() : !z ? materialCalendarGridView.b(iMin).getRight() : materialCalendarGridView.b(iMin).getLeft();
                        iB2 = iMin;
                    } else {
                        calendar.setTimeInMillis(jLongValue2);
                        iB2 = mVar.b() + (calendar.get(5) - 1);
                        View viewB2 = materialCalendarGridView.b(iB2);
                        width2 = (viewB2.getWidth() / 2) + viewB2.getLeft();
                    }
                    int itemId = (int) mVar.getItemId(iB);
                    Iterator<u0.b<Long, Long>> it2 = it;
                    Month month2 = month;
                    int itemId2 = (int) mVar.getItemId(iB2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        m mVar2 = mVar;
                        int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                        View viewB3 = materialCalendarGridView.b(numColumns);
                        int top = viewB3.getTop() + bVar.f4945a.f4939a.top;
                        int i11 = itemId2;
                        int bottom = viewB3.getBottom() - bVar.f4945a.f4939a.bottom;
                        if (z) {
                            int i12 = iB2 > numColumns2 ? 0 : width2;
                            int width4 = numColumns > iB ? getWidth() : width;
                            i10 = i12;
                            width3 = width4;
                        } else {
                            i10 = numColumns > iB ? 0 : width;
                            width3 = iB2 > numColumns2 ? getWidth() : width2;
                        }
                        canvas.drawRect(i10, top, width3, bottom, bVar.h);
                        itemId++;
                        materialCalendarGridView = this;
                        mVar = mVar2;
                        itemId2 = i11;
                    }
                    materialCalendarGridView = this;
                    month = month2;
                    it = it2;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i10, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i10, rect);
            return;
        }
        if (i10 == 33) {
            setSelection(((m) super.getAdapter()).d());
        } else if (i10 == 130) {
            setSelection(((m) super.getAdapter()).b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((m) super.getAdapter()).b() && selectedItemPosition <= ((m) super.getAdapter()).d())) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(((m) super.getAdapter()).b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (!this.f4921b) {
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i10) {
        if (i10 < ((m) super.getAdapter()).b()) {
            super.setSelection(((m) super.getAdapter()).b());
        } else {
            super.setSelection(i10);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (m) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof m)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}

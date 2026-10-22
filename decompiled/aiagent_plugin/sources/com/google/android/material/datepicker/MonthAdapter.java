package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = 0;
    final CalendarConstraints calendarConstraints;
    b calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ View getView(int r1, View r2, ViewGroup r3) {
        return getView(r1, r2, r3);
    }

    static {
        MAXIMUM_WEEKS = i.c().getMaximum(4);
    }

    MonthAdapter(Month r3, DateSelector<?> r4, CalendarConstraints r5) {
        DateSelector<?> r6 = (DateSelector) ZeusTransformUtils.wrapperContextForParams(r4, DateSelector.class, "com.obric.aiagent.plugin");
        this.month = r3;
        this.dateSelector = r6;
        this.calendarConstraints = r5;
        this.previouslySelectedDates = r6.getSelectedDays();
    }

    @Override // android.widget.Adapter
    public Long getItem(int r2) {
        if (r2 >= this.month.daysFromStartOfWeekToFirstOfMonth()) goto L5;
        return null;
    L5:
        if (r2 <= lastPositionInMonth()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.month.getDay(positionToDay(r2)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1 / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    public TextView getView(int r6, View r7, ViewGroup r8) {
        initializeStyles((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        r0 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_day, "layout", "mtrl_calendar_day"), r8, false, "com.obric.aiagent.plugin"), TextView.class, "com.obric.aiagent.plugin");
    L5:
        int r9 = r6 - firstPositionInMonth();
        if (r9 >= 0) goto L8;
    L15:
        r0.setVisibility(8);
        r0.setEnabled(false);
    L16:
        Long r10 = getItem(r6);
        if (r10 != null) goto L19;
        return r0;
    L19:
        updateSelectedState(r0, r10.longValue());
        return r0;
    L8:
        if (r9 >= this.month.daysInMonth) goto L15;
        int r11 = r9 + 1;
        r0.setTag(this.month);
        r0.setText(String.format(ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)}));
        long r3 = this.month.getDay(r11);
        if (this.month.year != Month.current().year) goto L13;
        r0.setContentDescription(c.d(r3));
    L14:
        r0.setVisibility(0);
        r0.setEnabled(true);
        goto L16
    L13:
        r0.setContentDescription(c.e(r3));
        goto L14
    }

    public void updateSelectedStates(MaterialCalendarGridView r6) {
        Iterator<Long> r0 = this.previouslySelectedDates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        updateSelectedStateForDate(r6, ((Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin")).longValue());
        goto L4
    L6:
        DateSelector<?> r1 = this.dateSelector;
        if (r1 == null) goto L16;
        Iterator<Long> r2 = r1.getSelectedDays().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        updateSelectedStateForDate(r6, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.aiagent.plugin")).longValue());
        goto L10
    L12:
        this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        return;
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView r3, long r4) {
        if (Month.create(r4).equals(this.month) == false) goto L6;
        int r0 = this.month.getDayOfMonth(r4);
        updateSelectedState((TextView) ZeusTransformUtils.preCheckCast(r3.getChildAt(r3.getAdapter().dayToPosition(r0) - r3.getFirstVisiblePosition()), TextView.class, "com.obric.aiagent.plugin"), r4);
        return;
    }

    private void updateSelectedState(TextView r3, long r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.calendarConstraints.getDateValidator().isValid(r4) == false) goto L13;
        r3.setEnabled(true);
        if (isSelected(r4) == false) goto L10;
        a r2 = this.calendarStyle.f13360b;
    L14:
        r2.a(r3);
        return;
    L10:
        if (i.b().getTimeInMillis() != r4) goto L12;
        r2 = this.calendarStyle.f13361c;
        goto L14
    L12:
        r2 = this.calendarStyle.f13359a;
        goto L14
    L13:
        r3.setEnabled(false);
        r2 = this.calendarStyle.g;
        goto L14
    }

    private boolean isSelected(long r5) {
        Iterator<Long> r4 = this.dateSelector.getSelectedDays().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        long r0 = ((Long) ZeusTransformUtils.preCheckCast(r4.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
        if (i.a(r5) != i.a(r0)) goto L4;
        return true;
    L9:
        return false;
    }

    private void initializeStyles(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.calendarStyle != null) goto L6;
        this.calendarStyle = new b(r4);
        return;
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int r1) {
        return (r1 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    int dayToPosition(int r1) {
        return firstPositionInMonth() + (r1 - 1);
    }

    boolean withinMonth(int r2) {
        if (r2 >= firstPositionInMonth()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > lastPositionInMonth()) goto L7;
        return true;
    }

    boolean isFirstInRow(int r1) {
        if ((r1 % this.month.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLastInRow(int r2) {
        if (((r2 + 1) % this.month.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }
}

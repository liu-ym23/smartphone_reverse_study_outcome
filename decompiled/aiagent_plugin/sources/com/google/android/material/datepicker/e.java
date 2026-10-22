package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CalendarConstraints f13364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateSelector<?> f13365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaterialCalendar.b f13366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13367d;

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    public static class a extends RecyclerView.u {
        final TextView r;
        final MaterialCalendarGridView s;

        a(LinearLayout r6, boolean r7) {
            super(r6);
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.month_title, DbHelper.COL_ID, "month_title")), TextView.class, "com.obric.aiagent.plugin");
            this.r = r0;
            ViewCompat.d(r0, true);
            this.s = (MaterialCalendarGridView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.month_grid, DbHelper.COL_ID, "month_grid")), MaterialCalendarGridView.class, "com.obric.aiagent.plugin");
            if (r7 == true) goto L6;
            r0.setVisibility(8);
            return;
        }
    }

    static /* synthetic */ MaterialCalendar.b a(e r0) {
        return r0.f13366c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return c(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    e(Context r4, DateSelector<?> r5, CalendarConstraints r6, MaterialCalendar.b r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        DateSelector<?> r9 = (DateSelector) ZeusTransformUtils.wrapperContextForParams(r5, DateSelector.class, "com.obric.aiagent.plugin");
        MaterialCalendar.b r10 = (MaterialCalendar.b) ZeusTransformUtils.wrapperContextForParams(r7, MaterialCalendar.b.class, "com.obric.aiagent.plugin");
        Month r0 = r6.getStart();
        Month r1 = r6.getEnd();
        Month r2 = r6.getOpenAt();
        if (r0.compareTo2(r2) > 0) goto L15;
        if (r2.compareTo2(r1) > 0) goto L13;
        int r3 = MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(r8);
        if (MaterialDatePicker.isFullscreen(r8) == false) goto L9;
        int r11 = MaterialCalendar.getDayHeight(r8);
    L10:
        this.f13367d = r3 + r11;
        this.f13364a = r6;
        this.f13365b = r9;
        this.f13366c = r10;
        a(true);
        return;
    L9:
        r11 = 0;
        goto L10
    L13:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L15:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    public a c(ViewGroup r5, int r6) {
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_month_labeled, "layout", "mtrl_calendar_month_labeled"), r5, false, "com.obric.aiagent.plugin"), LinearLayout.class, "com.obric.aiagent.plugin");
        if (MaterialDatePicker.isFullscreen((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L7;
        r7.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f13367d));
        return new a(r7, true);
    L7:
        return new a(r7, false);
    }

    public void a(a r4, int r5) {
        Month r6 = this.f13364a.getStart().monthsLater(r5);
        r4.r.setText(r6.getLongName());
        final MaterialCalendarGridView r7 = (MaterialCalendarGridView) ZeusTransformUtils.preCheckCast(r4.s.findViewById(ZeusTransformUtils.mapRes(R.id.month_grid, DbHelper.COL_ID, "month_grid")), MaterialCalendarGridView.class, "com.obric.aiagent.plugin");
        if (r7.getAdapter() != null) goto L5;
    L7:
        MonthAdapter r0 = new MonthAdapter(r6, this.f13365b, this.f13364a);
        r7.setNumColumns(r6.daysInWeek);
        r7.setAdapter(r0);
    L8:
        r7.setOnItemClickListener(new MonthsPagerAdapter$1(this, r7));
        return;
    L5:
        if (r6.equals(r7.getAdapter().month) == false) goto L7;
        r7.invalidate();
        r7.getAdapter().updateSelectedStates(r7);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long b(int r1) {
        return this.f13364a.getStart().monthsLater(r1).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f13364a.getMonthSpan();
    }

    CharSequence c(int r1) {
        return f(r1).getLongName();
    }

    Month f(int r1) {
        return this.f13364a.getStart().monthsLater(r1);
    }

    int a(Month r1) {
        return this.f13364a.getStart().monthsUntil(r1);
    }
}

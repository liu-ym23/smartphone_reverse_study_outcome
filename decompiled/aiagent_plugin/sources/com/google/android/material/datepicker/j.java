package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.timepicker.TimeModel;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialCalendar<?> f13372a;

    /* JADX INFO: compiled from: YearGridAdapter.java */
    public static class a extends RecyclerView.u {
        final TextView r;

        a(TextView r1) {
            super(r1);
            this.r = r1;
        }
    }

    static /* synthetic */ MaterialCalendar a(j r0) {
        return r0.f13372a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return c(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    j(MaterialCalendar<?> r1) {
        this.f13372a = r1;
    }

    public a c(ViewGroup r4, int r5) {
        return new a((TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_year, "layout", "mtrl_calendar_year"), r4, false, "com.obric.aiagent.plugin"), TextView.class, "com.obric.aiagent.plugin"));
    }

    public void a(a r9, int r10) {
        int r11 = f(r10);
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.r.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_navigate_to_year_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_navigate_to_year_description"));
        r9.r.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)}));
        r9.r.setContentDescription(String.format(r0, new Object[]{Integer.valueOf(r11)}));
        b r1 = this.f13372a.getCalendarStyle();
        Calendar r2 = i.b();
        if (r2.get(1) != r11) goto L5;
        com.google.android.material.datepicker.a r3 = r1.f;
    L6:
        Iterator<Long> r5 = this.f13372a.getDateSelector().getSelectedDays().iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        r2.setTimeInMillis(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r2.get(1) != r11) goto L8;
        r3 = r1.f13363e;
        goto L8
    L12:
        r3.a(r9.r);
        r9.r.setOnClickListener(g(r11));
        return;
    L5:
        r3 = r1.f13362d;
        goto L6
    }

    private View.OnClickListener g(final int r2) {
        return new YearGridAdapter$1(this, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f13372a.getCalendarConstraints().getYearSpan();
    }

    int c(int r1) {
        return r1 - this.f13372a.getCalendarConstraints().getStart().year;
    }

    int f(int r1) {
        return this.f13372a.getCalendarConstraints().getStart().year + r1;
    }
}

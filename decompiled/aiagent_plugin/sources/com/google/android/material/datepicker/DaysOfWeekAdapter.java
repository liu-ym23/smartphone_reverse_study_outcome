package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE = 0;
    private static final int NARROW_FORMAT = 4;
    private final Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    static {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r0 = 4;
    L6:
        CALENDAR_DAY_STYLE = r0;
        return;
    L5:
        r0 = 1;
        goto L6
    }

    public DaysOfWeekAdapter() {
        Calendar r0 = i.c();
        this.calendar = r0;
        this.daysInWeek = r0.getMaximum(7);
        this.firstDayOfWeek = r0.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public Integer getItem(int r2) {
        if (r2 < this.daysInWeek) goto L7;
        return null;
    L7:
        return Integer.valueOf(positionToDayOfWeek(r2));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    public View getView(int r6, View r7, ViewGroup r8) {
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        r0 = (TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_day_of_week, "layout", "mtrl_calendar_day_of_week"), r8, false, "com.obric.aiagent.plugin"), TextView.class, "com.obric.aiagent.plugin");
    L5:
        this.calendar.set(7, positionToDayOfWeek(r6));
        r0.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").getConfiguration().locale));
        r0.setContentDescription(String.format(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_day_of_week_column_header, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_day_of_week_column_header")), new Object[]{this.calendar.getDisplayName(7, 2, Locale.getDefault())}));
        return r0;
    }

    private int positionToDayOfWeek(int r2) {
        int r3 = r2 + this.firstDayOfWeek;
        int r1 = this.daysInWeek;
        if (r3 > r1) goto L5;
        return r3;
    L5:
        return r3 - r1;
    }
}

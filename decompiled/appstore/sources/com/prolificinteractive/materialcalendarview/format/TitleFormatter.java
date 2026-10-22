package com.prolificinteractive.materialcalendarview.format;

import ce.d;
import com.prolificinteractive.materialcalendarview.CalendarDay;

/* JADX INFO: loaded from: classes4.dex */
public interface TitleFormatter {
    public static final TitleFormatter DEFAULT = null;
    public static final String DEFAULT_FORMAT = "LLLL yyyy";

    static {
        DEFAULT = new d();
    }

    CharSequence format(CalendarDay r10);
}

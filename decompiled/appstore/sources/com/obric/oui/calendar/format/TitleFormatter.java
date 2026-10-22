package com.obric.oui.calendar.format;

import com.obric.oui.calendar.CalendarDay;
import qc.d;

/* JADX INFO: loaded from: classes4.dex */
public interface TitleFormatter {
    public static final TitleFormatter DEFAULT = null;
    public static final String DEFAULT_FORMAT = "LLLL yyyy";

    static {
        DEFAULT = new d();
    }

    CharSequence format(CalendarDay r10);
}

package com.obric.oui.calendar.format;

import org.threeten.bp.DayOfWeek;
import qc.b;

/* JADX INFO: loaded from: classes4.dex */
public interface WeekDayFormatter {
    public static final WeekDayFormatter DEFAULT = null;

    static {
        DEFAULT = new b();
    }

    CharSequence format(DayOfWeek r10);
}

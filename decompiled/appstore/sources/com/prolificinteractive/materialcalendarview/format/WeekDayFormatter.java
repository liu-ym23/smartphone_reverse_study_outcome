package com.prolificinteractive.materialcalendarview.format;

import ce.b;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public interface WeekDayFormatter {
    public static final WeekDayFormatter DEFAULT = null;

    static {
        DEFAULT = new b();
    }

    CharSequence format(DayOfWeek r10);
}

package com.obric.oui.calendar.format;

import androidx.annotation.NonNull;
import com.obric.oui.calendar.CalendarDay;
import qc.c;

/* JADX INFO: loaded from: classes4.dex */
public interface DayFormatter {
    public static final DayFormatter DEFAULT = null;
    public static final String DEFAULT_FORMAT = "d";

    static {
        DEFAULT = new c();
    }

    @NonNull
    String format(@NonNull CalendarDay r10);
}

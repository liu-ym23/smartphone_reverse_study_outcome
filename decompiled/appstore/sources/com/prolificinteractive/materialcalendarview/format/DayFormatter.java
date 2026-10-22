package com.prolificinteractive.materialcalendarview.format;

import androidx.annotation.NonNull;
import ce.c;
import com.prolificinteractive.materialcalendarview.CalendarDay;

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

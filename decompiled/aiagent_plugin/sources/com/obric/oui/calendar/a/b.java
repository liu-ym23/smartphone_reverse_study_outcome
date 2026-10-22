package com.obric.oui.calendar.a;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: compiled from: CalendarWeekDayFormatter.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements h {
    public b() {
    }

    @Override // com.obric.oui.calendar.a.h
    public CharSequence a(DayOfWeek r2) {
        return r2.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}

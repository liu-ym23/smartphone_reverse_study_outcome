package com.obric.event.task.base.conditiontask.holiday;

import com.bytedance.retrofit2.c.h;

/* JADX INFO: compiled from: HolidaysApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface HolidaysApi {
    @h(a = "obj/calendarholidays/holidays.xml")
    Object downloadHolidaysXml(d.c.d<? super String> r1);

    @h(a = "obj/calendarholidays/version.txt")
    Object getVersion(d.c.d<? super String> r1);
}

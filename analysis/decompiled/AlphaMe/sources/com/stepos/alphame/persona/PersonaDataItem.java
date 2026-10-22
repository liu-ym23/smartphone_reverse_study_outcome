package com.stepos.alphame.persona;

import B0.g;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.utils.StringUtil;

/* loaded from: classes.dex */
public class PersonaDataItem extends DataItem {
    public long arrive_home_time;
    public String company;
    public long date;
    public int day_off;
    public String holiday;
    public String home;
    public String home_city;
    public int id;
    public long leave_home_time;
    public long off_duty_cost;
    public long off_duty_time;
    public long on_duty_cost;
    public long on_duty_time;
    public String public_space;
    public long rise_time;
    public long sleep_cost;
    public long sleep_time;
    public String weather;
    public String weekday;
    public String ymd;

    @NotProguard
    public void fill(int i4, String str, String str2, String str3, int i5, String str4, String str5, String str6, String str7, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        this.id = i4;
        this.ymd = str;
        this.weekday = str2;
        this.holiday = str3;
        this.day_off = i5;
        this.weather = str4;
        this.home = str5;
        this.company = str6;
        this.public_space = str7;
        this.on_duty_time = j4;
        this.on_duty_cost = j5;
        this.off_duty_time = j6;
        this.off_duty_cost = j7;
        this.sleep_time = j8;
        this.rise_time = j9;
        this.sleep_cost = j10;
        this.date = j11;
    }

    public String toString() {
        int i4 = this.id;
        String str = this.ymd;
        String str2 = this.weekday;
        String str3 = this.holiday;
        int i5 = this.day_off;
        String str4 = this.weather;
        String str5 = this.home;
        String str6 = this.company;
        String str7 = this.public_space;
        String dateHM = StringUtil.formatDateHM(this.on_duty_time);
        String dateHM2 = StringUtil.formatDateHM(this.off_duty_time);
        String timeMill = StringUtil.formatTimeMill(this.on_duty_cost);
        String timeMill2 = StringUtil.formatTimeMill(this.off_duty_cost);
        String dateHM3 = StringUtil.formatDateHM(this.sleep_time);
        String dateHM4 = StringUtil.formatDateHM(this.rise_time);
        String timeMill3 = StringUtil.formatTimeMill(this.sleep_cost);
        String dateFull = StringUtil.formatDateFull(this.date);
        StringBuilder sb = new StringBuilder("[id=");
        sb.append(i4);
        sb.append(" ymd=");
        sb.append(str);
        sb.append(" weekday=");
        AbstractC0351g.C(sb, str2, " holiday=", str3, " day_off=");
        sb.append(i5);
        sb.append(" weather=");
        sb.append(str4);
        sb.append(" home=");
        AbstractC0351g.C(sb, str5, " company=", str6, " public_space=");
        AbstractC0351g.C(sb, str7, " on_duty_time=", dateHM, " off_duty_time=");
        AbstractC0351g.C(sb, dateHM2, " on_duty_cost=", timeMill, " off_duty_cost=");
        AbstractC0351g.C(sb, timeMill2, " sleep_time=", dateHM3, " rise_time=");
        AbstractC0351g.C(sb, dateHM4, " sleep_cost=", timeMill3, " date=");
        return g.r(sb, dateFull, "]");
    }

    @NotProguard
    public void fill(PersonaDataItem personaDataItem) {
        this.id = personaDataItem.id;
        this.weekday = personaDataItem.weekday;
        this.weather = personaDataItem.weather;
        this.holiday = personaDataItem.holiday;
        this.day_off = personaDataItem.day_off;
        this.home = personaDataItem.home;
        this.company = personaDataItem.company;
        this.public_space = personaDataItem.public_space;
        this.on_duty_time = personaDataItem.on_duty_time;
        this.on_duty_cost = personaDataItem.on_duty_cost;
        this.off_duty_time = personaDataItem.off_duty_time;
        this.off_duty_cost = personaDataItem.off_duty_cost;
        this.sleep_time = personaDataItem.sleep_time;
        this.rise_time = personaDataItem.rise_time;
        this.sleep_cost = personaDataItem.sleep_cost;
        this.date = personaDataItem.date;
    }
}

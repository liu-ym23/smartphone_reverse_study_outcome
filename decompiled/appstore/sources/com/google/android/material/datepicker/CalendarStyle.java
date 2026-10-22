package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes3.dex */
final class CalendarStyle {

    @NonNull
    final CalendarItemStyle day;

    @NonNull
    final CalendarItemStyle invalidDay;

    @NonNull
    final Paint rangeFill;

    @NonNull
    final CalendarItemStyle selectedDay;

    @NonNull
    final CalendarItemStyle selectedYear;

    @NonNull
    final CalendarItemStyle todayDay;

    @NonNull
    final CalendarItemStyle todayYear;

    @NonNull
    final CalendarItemStyle year;

    public CalendarStyle(@NonNull Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(r10, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.day = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList r12 = MaterialResources.getColorStateList(r10, r11, R.styleable.MaterialCalendar_rangeFillColor);
        this.year = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = CalendarItemStyle.create(r10, r11.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint r13 = new Paint();
        this.rangeFill = r13;
        r13.setColor(r12.getDefaultColor());
        r11.recycle();
    }
}

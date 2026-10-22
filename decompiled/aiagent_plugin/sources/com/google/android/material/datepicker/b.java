package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f13359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f13360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f13361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a f13362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a f13363e;
    final a f;
    final a g;
    final Paint h;

    b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        TypedArray r0 = r8.obtainStyledAttributes(com.google.android.material.g.b.a(r8, ZeusTransformUtils.mapRes(R.attr.materialCalendarStyle, "attr", "materialCalendarStyle"), MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f13359a = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_dayStyle, "styleable", "MaterialCalendar_dayStyle"), 0));
        this.g = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_dayInvalidStyle, "styleable", "MaterialCalendar_dayInvalidStyle"), 0));
        this.f13360b = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_daySelectedStyle, "styleable", "MaterialCalendar_daySelectedStyle"), 0));
        this.f13361c = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_dayTodayStyle, "styleable", "MaterialCalendar_dayTodayStyle"), 0));
        ColorStateList r1 = com.google.android.material.g.c.a(r8, r0, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_rangeFillColor, "styleable", "MaterialCalendar_rangeFillColor"));
        this.f13362d = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_yearStyle, "styleable", "MaterialCalendar_yearStyle"), 0));
        this.f13363e = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_yearSelectedStyle, "styleable", "MaterialCalendar_yearSelectedStyle"), 0));
        this.f = a.a(r8, r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendar_yearTodayStyle, "styleable", "MaterialCalendar_yearTodayStyle"), 0));
        Paint r9 = new Paint();
        this.h = r9;
        r9.setColor(r1.getDefaultColor());
        r0.recycle();
    }
}

package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DateTimeSerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l<T> extends ai<T> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Boolean f12902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final DateFormat f12903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final AtomicReference<DateFormat> f12904d;

    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r1, T r2) {
        return false;
    }

    public abstract l<T> b(Boolean r1, DateFormat r2);

    public l(Class<T> r1, Boolean r2, DateFormat r3) {
        super(r1);
        this.f12902b = r2;
        this.f12903c = r3;
        if (r3 != null) goto L5;
        AtomicReference<DateFormat> r4 = null;
    L6:
        this.f12904d = r4;
        return;
    L5:
        r4 = new AtomicReference();
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r9, com.fasterxml.jackson.databind.d r10) {
        JsonFormat.Value r11 = a(r9, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r10, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
        if (r11 != null) goto L5;
        return this;
    L5:
        JsonFormat.Shape r0 = r11.getShape();
        if (r0.isNumeric() == false) goto L10;
        return b(Boolean.TRUE, null);
    L10:
        if (r11.hasPattern() == true) goto L12;
        boolean r2 = r11.hasLocale();
        boolean r3 = r11.hasTimeZone();
        boolean r5 = true;
        if (r0 != JsonFormat.Shape.STRING) goto L24;
        boolean r1 = true;
    L25:
        if (r2 == true) goto L29;
        if (r3 == true) goto L29;
        if (r1 == true) goto L29;
        return this;
    L29:
        DateFormat r4 = r9.c().r();
        if (ZeusTransformUtils.instanceOf(r4, com.fasterxml.jackson.databind.l.x.class) == false) goto L40;
        com.fasterxml.jackson.databind.l.x r12 = (com.fasterxml.jackson.databind.l.x) ZeusTransformUtils.preCheckCast(r4, com.fasterxml.jackson.databind.l.x.class, "com.obric.aiagent.plugin");
        if (r11.hasLocale() == false) goto L35;
        r12 = r12.a(r11.getLocale());
    L35:
        if (r11.hasTimeZone() == false) goto L38;
        r12 = r12.a(r11.getTimeZone());
    L38:
        return b(Boolean.FALSE, r12);
    L40:
        if (ZeusTransformUtils.instanceOf(r4, SimpleDateFormat.class) == true) goto L42;
        r9.a(a(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", new Object[]{r4.getClass().getName()}));
    L42:
        SimpleDateFormat r13 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(r4, SimpleDateFormat.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L45;
        SimpleDateFormat r6 = new SimpleDateFormat(r13.toPattern(), r11.getLocale());
    L46:
        TimeZone r14 = r11.getTimeZone();
        if (r14 != null) goto L49;
    L51:
        r5 = false;
    L52:
        if (r5 == false) goto L55;
        r6.setTimeZone(r14);
    L55:
        return b(Boolean.FALSE, r6);
    L49:
        if (r14.equals(r6.getTimeZone()) == true) goto L51;
    L45:
        r6 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(r13.clone(), SimpleDateFormat.class, "com.obric.aiagent.plugin");
        goto L46
    L24:
        r1 = false;
        goto L25
    L12:
        if (r11.hasLocale() == false) goto L14;
        Locale r7 = r11.getLocale();
    L15:
        SimpleDateFormat r8 = new SimpleDateFormat(r11.getPattern(), r7);
        if (r11.hasTimeZone() == false) goto L18;
        TimeZone r15 = r11.getTimeZone();
    L19:
        r8.setTimeZone(r15);
        return b(Boolean.FALSE, r8);
    L18:
        r15 = r9.h();
        goto L19
    L14:
        r7 = r9.g();
        goto L15
    }

    public boolean a(com.fasterxml.jackson.databind.ac r3) {
        Boolean r0 = this.f12902b;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (this.f12903c != null) goto L13;
        if (r3 == null) goto L12;
        return r3.a(com.fasterxml.jackson.databind.ab.j);
    L12:
        throw new IllegalArgumentException("Null SerializerProvider passed for " + a().getName());
    L13:
        return false;
    }

    public void b(Date r4, com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6) {
        if (this.f12903c != null) goto L6;
        r6.a(r4, r5);
        return;
    L6:
        DateFormat r7 = (DateFormat) ZeusTransformUtils.preCheckCast(this.f12904d.getAndSet(null), DateFormat.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L9;
        r7 = (DateFormat) ZeusTransformUtils.preCheckCast(this.f12903c.clone(), DateFormat.class, "com.obric.aiagent.plugin");
    L9:
        r5.b(r7.format(r4));
        this.f12904d.compareAndSet(null, r7);
    }
}

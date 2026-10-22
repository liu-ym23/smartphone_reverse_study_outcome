package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f4360c;

    /* renamed from: d, reason: collision with root package name */
    public final DateFormat f4361d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference<DateFormat> f4362e;

    public DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this.f4360c = bool;
        this.f4361d = dateFormat;
        this.f4362e = dateFormat == null ? null : new AtomicReference<>();
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) {
        TimeZone timeZoneC;
        Class<T> cls = this.f4417a;
        JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, cls);
        SerializationConfig serializationConfig = hVar.f3044a;
        if (valueK != null) {
            String str = valueK.f3450a;
            Locale locale = valueK.f3452c;
            JsonFormat.Shape shape = valueK.f3451b;
            if (shape.a()) {
                return q(Boolean.TRUE, null);
            }
            if (str != null && str.length() > 0) {
                if (locale == null) {
                    locale = serializationConfig.f3828b.f3794j;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                if (valueK.d()) {
                    timeZoneC = valueK.c();
                } else {
                    serializationConfig.f3828b.getClass();
                    timeZoneC = BaseSettings.f3788l;
                }
                simpleDateFormat.setTimeZone(timeZoneC);
                return q(Boolean.FALSE, simpleDateFormat);
            }
            boolean z = locale != null;
            boolean zD = valueK.d();
            boolean z3 = shape == JsonFormat.Shape.f3446l;
            if (z || zD || z3) {
                DateFormat dateFormat = serializationConfig.f3828b.h;
                if (dateFormat instanceof StdDateFormat) {
                    StdDateFormat stdDateFormat = (StdDateFormat) dateFormat;
                    if (locale != null && !locale.equals(stdDateFormat.f4524b)) {
                        stdDateFormat = new StdDateFormat(stdDateFormat.f4523a, locale, stdDateFormat.f4525c, stdDateFormat.h);
                    }
                    if (valueK.d()) {
                        TimeZone timeZoneC2 = valueK.c();
                        if (timeZoneC2 == null) {
                            timeZoneC2 = StdDateFormat.f4518m;
                        }
                        TimeZone timeZone = stdDateFormat.f4523a;
                        if (timeZoneC2 != timeZone && !timeZoneC2.equals(timeZone)) {
                            stdDateFormat = new StdDateFormat(timeZoneC2, stdDateFormat.f4524b, stdDateFormat.f4525c, stdDateFormat.h);
                        }
                    }
                    return q(Boolean.FALSE, stdDateFormat);
                }
                if (!(dateFormat instanceof SimpleDateFormat)) {
                    hVar.i(cls, "Configured `DateFormat` (" + dateFormat.getClass().getName() + ") not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`");
                    throw null;
                }
                SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
                SimpleDateFormat simpleDateFormat3 = z ? new SimpleDateFormat(simpleDateFormat2.toPattern(), locale) : (SimpleDateFormat) simpleDateFormat2.clone();
                TimeZone timeZoneC3 = valueK.c();
                if (timeZoneC3 != null && !timeZoneC3.equals(simpleDateFormat3.getTimeZone())) {
                    simpleDateFormat3.setTimeZone(timeZoneC3);
                }
                return q(Boolean.FALSE, simpleDateFormat3);
            }
        }
        return this;
    }

    @Override // b3.f
    public final boolean d(h hVar, T t8) {
        return false;
    }

    public final boolean o(h hVar) {
        Boolean bool = this.f4360c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.f4361d != null) {
            return false;
        }
        if (hVar == null) {
            throw new IllegalArgumentException("Null SerializerProvider passed for ".concat(this.f4417a.getName()));
        }
        return hVar.f3044a.q(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public final void p(Date date, JsonGenerator jsonGenerator, h hVar) {
        DateFormat dateFormat = this.f4361d;
        if (dateFormat == null) {
            hVar.getClass();
            if (hVar.f3044a.q(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.N0(date.getTime());
                return;
            } else {
                jsonGenerator.f1(hVar.n().format(date));
                return;
            }
        }
        AtomicReference<DateFormat> atomicReference = this.f4362e;
        DateFormat andSet = atomicReference.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) dateFormat.clone();
        }
        jsonGenerator.f1(andSet.format(date));
        while (!atomicReference.compareAndSet(null, andSet) && atomicReference.get() == null) {
        }
    }

    public abstract DateTimeSerializerBase<T> q(Boolean bool, DateFormat dateFormat);
}

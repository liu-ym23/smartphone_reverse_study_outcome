package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import e3.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DateDeserializers {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f3967a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class DateDeserializer extends DateBasedDeserializer<Date> {
        public static final DateDeserializer h = new DateDeserializer();

        public DateDeserializer() {
            super(Date.class);
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            return new Date(0L);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
        public final DateBasedDeserializer<Date> j0(DateFormat dateFormat, String str) {
            return new DateDeserializer(this, dateFormat, str);
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f3967a = hashSet;
        hashSet.add("java.util.Calendar");
        hashSet.add("java.util.GregorianCalendar");
        hashSet.add("java.util.Date");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class CalendarDeserializer extends DateBasedDeserializer<Calendar> {
        public final Constructor<Calendar> h;

        public CalendarDeserializer() {
            super(Calendar.class);
            this.h = null;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws ValueInstantiationException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            Date dateN = N(jsonParser, deserializationContext);
            if (dateN == null) {
                return null;
            }
            Constructor<Calendar> constructor = this.h;
            if (constructor == null) {
                deserializationContext.f3663c.f3828b.getClass();
                Calendar calendar = Calendar.getInstance(BaseSettings.f3788l);
                calendar.setTime(dateN);
                return calendar;
            }
            try {
                Calendar calendarNewInstance = constructor.newInstance(null);
                calendarNewInstance.setTimeInMillis(dateN.getTime());
                deserializationContext.f3663c.f3828b.getClass();
                TimeZone timeZone = BaseSettings.f3788l;
                if (timeZone == null) {
                    return calendarNewInstance;
                }
                calendarNewInstance.setTimeZone(timeZone);
                return calendarNewInstance;
            } catch (Exception e10) {
                deserializationContext.w(this.f4054a, e10);
                throw null;
            }
        }

        @Override // b3.c
        public final Object j(DeserializationContext deserializationContext) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
        public final DateBasedDeserializer<Calendar> j0(DateFormat dateFormat, String str) {
            return new CalendarDeserializer(this, dateFormat, str);
        }

        public CalendarDeserializer(int i10) {
            super(GregorianCalendar.class);
            this.h = com.fasterxml.jackson.databind.util.a.k(GregorianCalendar.class, false);
        }

        public CalendarDeserializer(CalendarDeserializer calendarDeserializer, DateFormat dateFormat, String str) {
            super(calendarDeserializer, dateFormat, str);
            this.h = calendarDeserializer.h;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class DateBasedDeserializer<T> extends StdScalarDeserializer<T> implements c {

        /* renamed from: d, reason: collision with root package name */
        public final DateFormat f3968d;

        /* renamed from: e, reason: collision with root package name */
        public final String f3969e;

        public DateBasedDeserializer(Class<?> cls) {
            super(cls);
            this.f3968d = null;
            this.f3969e = null;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
        public final Date N(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Date date;
            if (this.f3968d == null || !jsonParser.i1(JsonToken.VALUE_STRING)) {
                return super.N(jsonParser, deserializationContext);
            }
            String strTrim = jsonParser.V0().trim();
            if (strTrim.isEmpty()) {
                if (v(deserializationContext, strTrim).ordinal() != 3) {
                    return null;
                }
                return new Date(0L);
            }
            synchronized (this.f3968d) {
                try {
                    try {
                        date = this.f3968d.parse(strTrim);
                    } catch (ParseException unused) {
                        deserializationContext.G(this.f4054a, strTrim, "expected format \"%s\"", this.f3969e);
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return date;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.text.DateFormat] */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.text.DateFormat] */
        /* JADX WARN: Type inference failed for: r4v7, types: [com.fasterxml.jackson.databind.util.StdDateFormat] */
        /* JADX WARN: Type inference failed for: r4v8 */
        @Override // e3.c
        public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
            DateFormat dateFormat;
            ?? stdDateFormat;
            Boolean bool;
            JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, this.f4054a);
            DeserializationConfig deserializationConfig = deserializationContext.f3663c;
            if (valueD0 == null) {
                return this;
            }
            String str = valueD0.f3450a;
            Locale locale = valueD0.f3452c;
            TimeZone timeZoneC = valueD0.c();
            Boolean bool2 = valueD0.f3454e;
            if (str != null && str.length() > 0) {
                if (locale == null) {
                    locale = deserializationConfig.f3828b.f3794j;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                if (timeZoneC == null) {
                    deserializationConfig.f3828b.getClass();
                    timeZoneC = BaseSettings.f3788l;
                }
                simpleDateFormat.setTimeZone(timeZoneC);
                if (bool2 != null) {
                    simpleDateFormat.setLenient(bool2.booleanValue());
                }
                return j0(simpleDateFormat, str);
            }
            String strO = this.f3969e;
            if (timeZoneC != null) {
                DateFormat dateFormat2 = deserializationConfig.f3828b.h;
                if (dateFormat2.getClass() == StdDateFormat.class) {
                    if (locale == null) {
                        locale = deserializationConfig.f3828b.f3794j;
                    }
                    StdDateFormat stdDateFormat2 = (StdDateFormat) dateFormat2;
                    TimeZone timeZone = stdDateFormat2.f4523a;
                    StdDateFormat stdDateFormat3 = stdDateFormat2;
                    if (timeZoneC != timeZone) {
                        stdDateFormat3 = stdDateFormat2;
                        if (!timeZoneC.equals(timeZone)) {
                            stdDateFormat3 = new StdDateFormat(timeZoneC, stdDateFormat2.f4524b, stdDateFormat2.f4525c, stdDateFormat2.h);
                        }
                    }
                    boolean zEquals = locale.equals(stdDateFormat3.f4524b);
                    stdDateFormat = stdDateFormat3;
                    if (!zEquals) {
                        stdDateFormat = new StdDateFormat(stdDateFormat3.f4523a, locale, stdDateFormat3.f4525c, stdDateFormat3.h);
                    }
                    if (bool2 != null && bool2 != (bool = stdDateFormat.f4525c) && !bool2.equals(bool)) {
                        stdDateFormat = new StdDateFormat(stdDateFormat.f4523a, stdDateFormat.f4524b, bool2, stdDateFormat.h);
                    }
                } else {
                    stdDateFormat = (DateFormat) dateFormat2.clone();
                    stdDateFormat.setTimeZone(timeZoneC);
                    if (bool2 != null) {
                        stdDateFormat.setLenient(bool2.booleanValue());
                    }
                }
                return j0(stdDateFormat, strO);
            }
            if (bool2 == null) {
                return this;
            }
            DateFormat dateFormat3 = deserializationConfig.f3828b.h;
            if (dateFormat3.getClass() == StdDateFormat.class) {
                StdDateFormat stdDateFormat4 = (StdDateFormat) dateFormat3;
                Boolean bool3 = stdDateFormat4.f4525c;
                StdDateFormat stdDateFormat5 = stdDateFormat4;
                if (bool2 != bool3) {
                    stdDateFormat5 = stdDateFormat4;
                    if (!bool2.equals(bool3)) {
                        stdDateFormat5 = new StdDateFormat(stdDateFormat4.f4523a, stdDateFormat4.f4524b, bool2, stdDateFormat4.h);
                    }
                }
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (");
                strO = ai.onnxruntime.a.o(sb2, Boolean.FALSE.equals(stdDateFormat5.f4525c) ? "strict" : "lenient", ")]");
                dateFormat = stdDateFormat5;
            } else {
                DateFormat dateFormat4 = (DateFormat) dateFormat3.clone();
                dateFormat4.setLenient(bool2.booleanValue());
                boolean z = dateFormat4 instanceof SimpleDateFormat;
                dateFormat = dateFormat4;
                if (z) {
                    ((SimpleDateFormat) dateFormat4).toPattern();
                    dateFormat = dateFormat4;
                }
            }
            if (strO == null) {
                strO = "[unknown]";
            }
            return j0(dateFormat, strO);
        }

        @Override // b3.c
        public Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return N(jsonParser, deserializationContext);
        }

        public abstract DateBasedDeserializer<T> j0(DateFormat dateFormat, String str);

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
        public final LogicalType o() {
            return LogicalType.f4438o;
        }

        public DateBasedDeserializer(DateBasedDeserializer<T> dateBasedDeserializer, DateFormat dateFormat, String str) {
            super(dateBasedDeserializer.f4054a);
            this.f3968d = dateFormat;
            this.f3969e = str;
        }
    }
}

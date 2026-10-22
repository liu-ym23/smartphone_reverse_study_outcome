package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonFormat {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Feature {

        /* renamed from: a, reason: collision with root package name */
        public static final Feature f3434a;

        /* renamed from: b, reason: collision with root package name */
        public static final Feature f3435b;

        /* renamed from: c, reason: collision with root package name */
        public static final Feature f3436c;

        /* renamed from: d, reason: collision with root package name */
        public static final Feature f3437d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Feature[] f3438e;

        static {
            Feature feature = new Feature("ACCEPT_SINGLE_VALUE_AS_ARRAY", 0);
            f3434a = feature;
            Feature feature2 = new Feature("ACCEPT_CASE_INSENSITIVE_PROPERTIES", 1);
            f3435b = feature2;
            Feature feature3 = new Feature("ACCEPT_CASE_INSENSITIVE_VALUES", 2);
            Feature feature4 = new Feature("WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS", 3);
            Feature feature5 = new Feature("WRITE_DATES_WITH_ZONE_ID", 4);
            Feature feature6 = new Feature("WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED", 5);
            f3436c = feature6;
            Feature feature7 = new Feature("WRITE_SORTED_MAP_ENTRIES", 6);
            f3437d = feature7;
            f3438e = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, new Feature("ADJUST_DATES_TO_CONTEXT_TIME_ZONE", 7)};
        }

        public Feature() {
            throw null;
        }

        public static Feature valueOf(String str) {
            return (Feature) Enum.valueOf(Feature.class, str);
        }

        public static Feature[] values() {
            return (Feature[]) f3438e.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Shape {

        /* renamed from: a, reason: collision with root package name */
        public static final Shape f3439a;

        /* renamed from: b, reason: collision with root package name */
        public static final Shape f3440b;

        /* renamed from: c, reason: collision with root package name */
        public static final Shape f3441c;

        /* renamed from: d, reason: collision with root package name */
        public static final Shape f3442d;

        /* renamed from: e, reason: collision with root package name */
        public static final Shape f3443e;
        public static final Shape h;

        /* renamed from: j, reason: collision with root package name */
        public static final Shape f3444j;

        /* renamed from: k, reason: collision with root package name */
        public static final Shape f3445k;

        /* renamed from: l, reason: collision with root package name */
        public static final Shape f3446l;

        /* renamed from: m, reason: collision with root package name */
        public static final Shape f3447m;

        /* renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ Shape[] f3448n;

        static {
            Shape shape = new Shape("ANY", 0);
            f3439a = shape;
            Shape shape2 = new Shape("NATURAL", 1);
            f3440b = shape2;
            Shape shape3 = new Shape("SCALAR", 2);
            f3441c = shape3;
            Shape shape4 = new Shape("ARRAY", 3);
            f3442d = shape4;
            Shape shape5 = new Shape("OBJECT", 4);
            f3443e = shape5;
            Shape shape6 = new Shape("NUMBER", 5);
            h = shape6;
            Shape shape7 = new Shape("NUMBER_FLOAT", 6);
            f3444j = shape7;
            Shape shape8 = new Shape("NUMBER_INT", 7);
            f3445k = shape8;
            Shape shape9 = new Shape("STRING", 8);
            f3446l = shape9;
            Shape shape10 = new Shape("BOOLEAN", 9);
            Shape shape11 = new Shape("BINARY", 10);
            f3447m = shape11;
            f3448n = new Shape[]{shape, shape2, shape3, shape4, shape5, shape6, shape7, shape8, shape9, shape10, shape11};
        }

        public Shape() {
            throw null;
        }

        public static Shape valueOf(String str) {
            return (Shape) Enum.valueOf(Shape.class, str);
        }

        public static Shape[] values() {
            return (Shape[]) f3448n.clone();
        }

        public final boolean a() {
            return this == h || this == f3445k || this == f3444j;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Value implements Serializable {

        /* renamed from: k, reason: collision with root package name */
        public static final Value f3449k = new Value();

        /* renamed from: a, reason: collision with root package name */
        public final String f3450a;

        /* renamed from: b, reason: collision with root package name */
        public final Shape f3451b;

        /* renamed from: c, reason: collision with root package name */
        public final Locale f3452c;

        /* renamed from: d, reason: collision with root package name */
        public final String f3453d;

        /* renamed from: e, reason: collision with root package name */
        public final Boolean f3454e;
        public final a h;

        /* renamed from: j, reason: collision with root package name */
        public transient TimeZone f3455j;

        public Value() {
            this("", Shape.f3439a, "", "", a.f3456c, null);
        }

        public static boolean a(Serializable serializable, Object obj) {
            if (obj == null) {
                return serializable == null;
            }
            if (serializable == null) {
                return false;
            }
            return obj.equals(serializable);
        }

        public final Boolean b(Feature feature) {
            a aVar = this.h;
            aVar.getClass();
            int iOrdinal = 1 << feature.ordinal();
            if ((aVar.f3458b & iOrdinal) != 0) {
                return Boolean.FALSE;
            }
            if ((aVar.f3457a & iOrdinal) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public final TimeZone c() {
            TimeZone timeZone = this.f3455j;
            if (timeZone != null) {
                return timeZone;
            }
            String str = this.f3453d;
            if (str == null) {
                return null;
            }
            TimeZone timeZone2 = TimeZone.getTimeZone(str);
            this.f3455j = timeZone2;
            return timeZone2;
        }

        public final boolean d() {
            if (this.f3455j != null) {
                return true;
            }
            String str = this.f3453d;
            return (str == null || str.isEmpty()) ? false : true;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0054 A[PHI: r1
          0x0054: PHI (r1v9 com.fasterxml.jackson.annotation.JsonFormat$a) = 
          (r1v8 com.fasterxml.jackson.annotation.JsonFormat$a)
          (r1v10 com.fasterxml.jackson.annotation.JsonFormat$a)
          (r1v8 com.fasterxml.jackson.annotation.JsonFormat$a)
          (r1v8 com.fasterxml.jackson.annotation.JsonFormat$a)
         binds: [B:26:0x0037, B:40:0x0056, B:38:0x0052, B:30:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.fasterxml.jackson.annotation.JsonFormat.Value e(com.fasterxml.jackson.annotation.JsonFormat.Value r11) {
            /*
                r10 = this;
                if (r11 == 0) goto L7f
                com.fasterxml.jackson.annotation.JsonFormat$a r0 = r11.h
                com.fasterxml.jackson.annotation.JsonFormat$Value r1 = com.fasterxml.jackson.annotation.JsonFormat.Value.f3449k
                if (r11 == r1) goto L7f
                if (r11 != r10) goto Lc
                goto L7f
            Lc:
                if (r10 != r1) goto Lf
                return r11
            Lf:
                java.lang.String r1 = r11.f3450a
                if (r1 == 0) goto L1c
                boolean r2 = r1.isEmpty()
                if (r2 == 0) goto L1a
                goto L1c
            L1a:
                r3 = r1
                goto L1f
            L1c:
                java.lang.String r1 = r10.f3450a
                goto L1a
            L1f:
                com.fasterxml.jackson.annotation.JsonFormat$Shape r1 = r11.f3451b
                com.fasterxml.jackson.annotation.JsonFormat$Shape r2 = com.fasterxml.jackson.annotation.JsonFormat.Shape.f3439a
                if (r1 != r2) goto L27
                com.fasterxml.jackson.annotation.JsonFormat$Shape r1 = r10.f3451b
            L27:
                r4 = r1
                java.util.Locale r1 = r11.f3452c
                if (r1 != 0) goto L2e
                java.util.Locale r1 = r10.f3452c
            L2e:
                r5 = r1
                com.fasterxml.jackson.annotation.JsonFormat$a r1 = r10.h
                if (r1 != 0) goto L35
            L33:
                r8 = r0
                goto L5c
            L35:
                int r2 = r1.f3458b
                if (r0 != 0) goto L3a
                goto L54
            L3a:
                int r6 = r0.f3458b
                int r7 = r0.f3457a
                if (r6 != 0) goto L43
                if (r7 != 0) goto L43
                goto L54
            L43:
                int r8 = r1.f3457a
                if (r8 != 0) goto L4a
                if (r2 != 0) goto L4a
                goto L33
            L4a:
                int r0 = ~r6
                r0 = r0 & r8
                r0 = r0 | r7
                int r7 = ~r7
                r7 = r7 & r2
                r6 = r6 | r7
                if (r0 != r8) goto L56
                if (r6 != r2) goto L56
            L54:
                r0 = r1
                goto L33
            L56:
                com.fasterxml.jackson.annotation.JsonFormat$a r1 = new com.fasterxml.jackson.annotation.JsonFormat$a
                r1.<init>(r0, r6)
                goto L54
            L5c:
                java.lang.Boolean r0 = r11.f3454e
                if (r0 != 0) goto L62
                java.lang.Boolean r0 = r10.f3454e
            L62:
                r9 = r0
                java.lang.String r0 = r11.f3453d
                if (r0 == 0) goto L73
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L6e
                goto L73
            L6e:
                java.util.TimeZone r10 = r11.f3455j
                r7 = r10
            L71:
                r6 = r0
                goto L79
            L73:
                java.util.TimeZone r11 = r10.f3455j
                java.lang.String r0 = r10.f3453d
                r7 = r11
                goto L71
            L79:
                com.fasterxml.jackson.annotation.JsonFormat$Value r2 = new com.fasterxml.jackson.annotation.JsonFormat$Value
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return r2
            L7f:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.annotation.JsonFormat.Value.e(com.fasterxml.jackson.annotation.JsonFormat$Value):com.fasterxml.jackson.annotation.JsonFormat$Value");
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            if (this.f3451b != value.f3451b || !this.h.equals(value.h)) {
                return false;
            }
            if (!a(value.f3454e, this.f3454e)) {
                return false;
            }
            if (!a(value.f3453d, this.f3453d)) {
                return false;
            }
            if (!a(value.f3450a, this.f3450a)) {
                return false;
            }
            if (a(value.f3455j, this.f3455j)) {
                return a(value.f3452c, this.f3452c);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f3453d;
            int iHashCode = str == null ? 1 : str.hashCode();
            String str2 = this.f3450a;
            if (str2 != null) {
                iHashCode ^= str2.hashCode();
            }
            int iHashCode2 = this.f3451b.hashCode() + iHashCode;
            Boolean bool = this.f3454e;
            if (bool != null) {
                iHashCode2 ^= bool.hashCode();
            }
            Locale locale = this.f3452c;
            if (locale != null) {
                iHashCode2 += locale.hashCode();
            }
            return this.h.hashCode() ^ iHashCode2;
        }

        public final String toString() {
            return "JsonFormat.Value(pattern=" + this.f3450a + ",shape=" + this.f3451b + ",lenient=" + this.f3454e + ",locale=" + this.f3452c + ",timezone=" + this.f3453d + ",features=" + this.h + ")";
        }

        public Value(String str, Shape shape, String str2, String str3, a aVar, Boolean bool) {
            this(str, shape, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, aVar, bool);
        }

        public Value(String str, Shape shape, Locale locale, String str2, TimeZone timeZone, a aVar, Boolean bool) {
            this.f3450a = str == null ? "" : str;
            this.f3451b = shape == null ? Shape.f3439a : shape;
            this.f3452c = locale;
            this.f3455j = timeZone;
            this.f3453d = str2;
            this.h = aVar == null ? a.f3456c : aVar;
            this.f3454e = bool;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final a f3456c = new a(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final int f3457a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3458b;

        public a(int i10, int i11) {
            this.f3457a = i10;
            this.f3458b = i11;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.f3457a == this.f3457a && aVar.f3458b == this.f3458b;
        }

        public final int hashCode() {
            return this.f3458b + this.f3457a;
        }

        public final String toString() {
            return this == f3456c ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f3457a), Integer.valueOf(this.f3458b));
        }
    }

    OptBoolean lenient() default OptBoolean.f3502b;

    String locale() default "##default";

    String pattern() default "";

    Shape shape() default Shape.f3439a;

    String timezone() default "##default";

    Feature[] with() default {};

    Feature[] without() default {};
}

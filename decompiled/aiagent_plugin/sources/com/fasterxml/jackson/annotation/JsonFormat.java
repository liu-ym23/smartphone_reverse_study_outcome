package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {
    public static final String DEFAULT_LOCALE = "##default";
    public static final String DEFAULT_TIMEZONE = "##default";

    public static final enum Feature extends Enum<Feature> {
        private static final /* synthetic */ Feature[] $VALUES = null;
        public static final Feature ACCEPT_CASE_INSENSITIVE_PROPERTIES = null;
        public static final Feature ACCEPT_CASE_INSENSITIVE_VALUES = null;
        public static final Feature ACCEPT_SINGLE_VALUE_AS_ARRAY = null;
        public static final Feature ADJUST_DATES_TO_CONTEXT_TIME_ZONE = null;
        public static final Feature WRITE_DATES_WITH_ZONE_ID = null;
        public static final Feature WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS = null;
        public static final Feature WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED = null;
        public static final Feature WRITE_SORTED_MAP_ENTRIES = null;

        private Feature(String r1, int r2) {
            super(r1, r2);
        }

        public static Feature valueOf(String r2) {
            return (Feature) ZeusTransformUtils.preCheckCast(Enum.valueOf(Feature.class, r2), Feature.class, "com.obric.aiagent.plugin");
        }

        public static Feature[] values() {
            return (Feature[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Feature[].class, "com.obric.aiagent.plugin");
        }

        static {
            Feature r0 = new Feature("ACCEPT_SINGLE_VALUE_AS_ARRAY", 0);
            ACCEPT_SINGLE_VALUE_AS_ARRAY = r0;
            Feature r1 = new Feature("ACCEPT_CASE_INSENSITIVE_PROPERTIES", 1);
            ACCEPT_CASE_INSENSITIVE_PROPERTIES = r1;
            Feature r3 = new Feature("ACCEPT_CASE_INSENSITIVE_VALUES", 2);
            ACCEPT_CASE_INSENSITIVE_VALUES = r3;
            Feature r5 = new Feature("WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS", 3);
            WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS = r5;
            Feature r7 = new Feature("WRITE_DATES_WITH_ZONE_ID", 4);
            WRITE_DATES_WITH_ZONE_ID = r7;
            Feature r9 = new Feature("WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED", 5);
            WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED = r9;
            Feature r11 = new Feature("WRITE_SORTED_MAP_ENTRIES", 6);
            WRITE_SORTED_MAP_ENTRIES = r11;
            Feature r13 = new Feature("ADJUST_DATES_TO_CONTEXT_TIME_ZONE", 7);
            ADJUST_DATES_TO_CONTEXT_TIME_ZONE = r13;
            $VALUES = new Feature[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    public static class Features {
        private static final Features EMPTY = null;
        private final int _disabled;
        private final int _enabled;

        static {
            EMPTY = new Features(0, 0);
        }

        private Features(int r1, int r2) {
            this._enabled = r1;
            this._disabled = r2;
        }

        public static Features empty() {
            return EMPTY;
        }

        public static Features construct(JsonFormat r2) {
            JsonFormat r3 = (JsonFormat) ZeusTransformUtils.wrapperContextForParams(r2, JsonFormat.class, "com.obric.aiagent.plugin");
            return construct(r3.with(), r3.without());
        }

        public static Features construct(Feature[] r6, Feature[] r7) {
            int r0 = r6.length;
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
        L4:
            if (r2 >= r0) goto L6;
            r3 = r3 | (1 << r6[r2].ordinal());
            r2 = r2 + 1;
            goto L4
        L6:
            int r8 = r7.length;
            int r4 = 0;
        L7:
            if (r1 >= r8) goto L10;
            r4 = r4 | (1 << r7[r1].ordinal());
            r1 = r1 + 1;
            goto L7
        L10:
            return new Features(r3, r4);
        }

        public Features withOverrides(Features r5) {
            if (r5 != null) goto L4;
            return this;
        L4:
            int r0 = r5._disabled;
            int r1 = r5._enabled;
            if (r0 != 0) goto L8;
            if (r1 != 0) goto L8;
            return this;
        L8:
            int r2 = this._enabled;
            if (r2 == 0) goto L11;
        L13:
            int r6 = ((~r0) & r2) | r1;
            int r3 = this._disabled;
            int r4 = r0 | ((~r1) & r3);
            if (r6 != r2) goto L18;
            if (r4 != r3) goto L18;
            return this;
        L18:
            return new Features(r6, r4);
        L11:
            if (this._disabled != 0) goto L13;
            return r5;
        }

        public Features with(Feature... r6) {
            int r0 = this._enabled;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0 = r0 | (1 << r6[r2].ordinal());
            r2 = r2 + 1;
            goto L3
        L6:
            if (r0 != this._enabled) goto L9;
            return this;
        L9:
            return new Features(r0, this._disabled);
        }

        public Features without(Feature... r6) {
            int r0 = this._disabled;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            r0 = r0 | (1 << r6[r2].ordinal());
            r2 = r2 + 1;
            goto L3
        L6:
            if (r0 != this._disabled) goto L9;
            return this;
        L9:
            return new Features(this._enabled, r0);
        }

        public Boolean get(Feature r2) {
            int r3 = 1 << r2.ordinal();
            if ((this._disabled & r3) == 0) goto L7;
            return Boolean.FALSE;
        L7:
            if ((this._enabled & r3) != 0) goto L9;
            return null;
        L9:
            return Boolean.TRUE;
        }

        public String toString() {
            if (this != EMPTY) goto L7;
            return "EMPTY";
        L7:
            return String.format("(enabled=0x%x,disabled=0x%x)", new Object[]{Integer.valueOf(this._enabled), Integer.valueOf(this._disabled)});
        }

        public int hashCode() {
            return this._disabled + this._enabled;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() == getClass()) goto L11;
            return false;
        L11:
            Features r6 = (Features) ZeusTransformUtils.preCheckCast(r5, Features.class, "com.obric.aiagent.plugin");
            if (r6._enabled != this._enabled) goto L17;
            if (r6._disabled != this._disabled) goto L17;
            return true;
        L17:
            return false;
        }
    }

    public static final enum Shape extends Enum<Shape> {
        private static final /* synthetic */ Shape[] $VALUES = null;
        public static final Shape ANY = null;
        public static final Shape ARRAY = null;
        public static final Shape BINARY = null;
        public static final Shape BOOLEAN = null;
        public static final Shape NATURAL = null;
        public static final Shape NUMBER = null;
        public static final Shape NUMBER_FLOAT = null;
        public static final Shape NUMBER_INT = null;
        public static final Shape OBJECT = null;
        public static final Shape SCALAR = null;
        public static final Shape STRING = null;

        private Shape(String r1, int r2) {
            super(r1, r2);
        }

        public static Shape valueOf(String r2) {
            return (Shape) ZeusTransformUtils.preCheckCast(Enum.valueOf(Shape.class, r2), Shape.class, "com.obric.aiagent.plugin");
        }

        public static Shape[] values() {
            return (Shape[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Shape[].class, "com.obric.aiagent.plugin");
        }

        static {
            Shape r0 = new Shape("ANY", 0);
            ANY = r0;
            Shape r1 = new Shape("NATURAL", 1);
            NATURAL = r1;
            Shape r3 = new Shape("SCALAR", 2);
            SCALAR = r3;
            Shape r5 = new Shape("ARRAY", 3);
            ARRAY = r5;
            Shape r7 = new Shape("OBJECT", 4);
            OBJECT = r7;
            Shape r9 = new Shape("NUMBER", 5);
            NUMBER = r9;
            Shape r11 = new Shape("NUMBER_FLOAT", 6);
            NUMBER_FLOAT = r11;
            Shape r13 = new Shape("NUMBER_INT", 7);
            NUMBER_INT = r13;
            Shape r15 = new Shape("STRING", 8);
            STRING = r15;
            Shape r14 = new Shape("BOOLEAN", 9);
            BOOLEAN = r14;
            Shape r12 = new Shape("BINARY", 10);
            BINARY = r12;
            $VALUES = new Shape[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        public boolean isNumeric() {
            if (this != NUMBER) goto L5;
        L10:
            return true;
        L5:
            if (this == NUMBER_INT) goto L10;
            if (this == NUMBER_FLOAT) goto L10;
            return false;
        }

        public boolean isStructured() {
            if (this != OBJECT) goto L5;
        L8:
            return true;
        L5:
            if (this == ARRAY) goto L8;
            return false;
        }
    }

    public static class Value implements JacksonAnnotationValue<JsonFormat>, Serializable {
        private static final Value EMPTY = null;
        private static final long serialVersionUID = 1;
        private final Features _features;
        private final Boolean _lenient;
        private final Locale _locale;
        private final String _pattern;
        private final Shape _shape;
        private transient TimeZone _timezone;
        private final String _timezoneStr;

        static {
            EMPTY = new Value();
        }

        public Value() {
            this("", Shape.ANY, "", "", Features.empty(), null);
        }

        public Value(JsonFormat r8) {
            JsonFormat r9 = (JsonFormat) ZeusTransformUtils.wrapperContextForParams(r8, JsonFormat.class, "com.obric.aiagent.plugin");
            this(r9.pattern(), r9.shape(), r9.locale(), r9.timezone(), Features.construct(r9), r9.lenient().asBoolean());
        }

        public Value(String r14, Shape r15, String r16, String r17, Features r18, Boolean r19) {
            if (r16 != null) goto L5;
        L10:
            Locale r8 = null;
        L11:
            if (r17 != null) goto L13;
        L18:
            String r9 = null;
        L19:
            this(r14, r15, r8, r9, null, r18, r19);
            return;
        L13:
            if (r17.length() == 0) goto L18;
            if ("##default".equals(r17) == true) goto L18;
            r9 = r17;
            goto L19
        L5:
            if (r16.length() == 0) goto L10;
            if ("##default".equals(r16) == true) goto L10;
            r8 = new Locale(r16);
            goto L11
        }

        public Value(String r1, Shape r2, Locale r3, TimeZone r4, Features r5, Boolean r6) {
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            this._pattern = r1;
            if (r2 != null) goto L8;
            r2 = Shape.ANY;
        L8:
            this._shape = r2;
            this._locale = r3;
            this._timezone = r4;
            this._timezoneStr = null;
            if (r5 != null) goto L11;
            r5 = Features.empty();
        L11:
            this._features = r5;
            this._lenient = r6;
        }

        public Value(String r1, Shape r2, Locale r3, String r4, TimeZone r5, Features r6, Boolean r7) {
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            this._pattern = r1;
            if (r2 != null) goto L8;
            r2 = Shape.ANY;
        L8:
            this._shape = r2;
            this._locale = r3;
            this._timezone = r5;
            this._timezoneStr = r4;
            if (r6 != null) goto L11;
            r6 = Features.empty();
        L11:
            this._features = r6;
            this._lenient = r7;
        }

        @Deprecated
        public Value(String r9, Shape r10, Locale r11, String r12, TimeZone r13, Features r14) {
            this(r9, r10, r11, r12, r13, r14, null);
        }

        @Deprecated
        public Value(String r8, Shape r9, String r10, String r11, Features r12) {
            this(r8, r9, r10, r11, r12, null);
        }

        @Deprecated
        public Value(String r8, Shape r9, Locale r10, TimeZone r11, Features r12) {
            this(r8, r9, r10, r11, r12, null);
        }

        public static final Value empty() {
            return EMPTY;
        }

        public static Value merge(Value r0, Value r1) {
            if (r0 != null) goto L5;
            return r1;
        L5:
            return r0.withOverrides(r1);
        }

        public static Value mergeAll(Value... r4) {
            int r0 = r4.length;
            Value r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            Value r3 = r4[r2];
            if (r3 == null) goto L10;
            if (r1 == null) goto L9;
            r3 = r1.withOverrides(r3);
        L9:
            r1 = r3;
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            return r1;
        }

        public static final Value from(JsonFormat r2) {
            JsonFormat r3 = (JsonFormat) ZeusTransformUtils.wrapperContextForParams(r2, JsonFormat.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L6;
            return EMPTY;
        L6:
            return new Value(r3);
        }

        public final Value withOverrides(Value r10) {
            if (r10 == null) goto L36;
            Value r0 = EMPTY;
            if (r10 == r0) goto L37;
            if (r10 == this) goto L38;
            if (this != r0) goto L9;
            return r10;
        L9:
            String r1 = r10._pattern;
            if (r1 != null) goto L12;
        L13:
            r1 = this._pattern;
        L14:
            String r2 = r1;
            Shape r3 = r10._shape;
            if (r3 != Shape.ANY) goto L17;
            r3 = this._shape;
        L17:
            Shape r4 = r3;
            Locale r5 = r10._locale;
            if (r5 != null) goto L20;
            r5 = this._locale;
        L20:
            Locale r6 = r5;
            Features r7 = this._features;
            if (r7 != null) goto L23;
            Features r8 = r10._features;
        L24:
            Features r9 = r8;
            Boolean r11 = r10._lenient;
            if (r11 != null) goto L27;
            r11 = this._lenient;
        L27:
            Boolean r12 = r11;
            String r13 = r10._timezoneStr;
            if (r13 != null) goto L30;
        L33:
            String r14 = this._timezoneStr;
            TimeZone r15 = this._timezone;
            String r16 = r14;
        L35:
            return new Value(r2, r4, r6, r16, r15, r9, r12);
        L30:
            if (r13.isEmpty() == true) goto L33;
            r15 = r10._timezone;
            r16 = r13;
            goto L35
        L23:
            r8 = r7.withOverrides(r10._features);
            goto L24
        L12:
            if (r1.isEmpty() == false) goto L14;
        L38:
            return this;
        L37:
            return this;
        L36:
            return this;
        }

        public static Value forPattern(String r9) {
            return new Value(r9, null, null, null, null, Features.empty(), null);
        }

        public static Value forShape(Shape r9) {
            return new Value("", r9, null, null, null, Features.empty(), null);
        }

        public static Value forLeniency(boolean r9) {
            return new Value("", null, null, null, null, Features.empty(), Boolean.valueOf(r9));
        }

        public Value withPattern(String r10) {
            return new Value(r10, this._shape, this._locale, this._timezoneStr, this._timezone, this._features, this._lenient);
        }

        public Value withShape(Shape r10) {
            if (r10 != this._shape) goto L6;
            return this;
        L6:
            return new Value(this._pattern, r10, this._locale, this._timezoneStr, this._timezone, this._features, this._lenient);
        }

        public Value withLocale(Locale r10) {
            return new Value(this._pattern, this._shape, r10, this._timezoneStr, this._timezone, this._features, this._lenient);
        }

        public Value withTimeZone(TimeZone r10) {
            return new Value(this._pattern, this._shape, this._locale, null, r10, this._features, this._lenient);
        }

        public Value withLenient(Boolean r10) {
            if (r10 != this._lenient) goto L6;
            return this;
        L6:
            return new Value(this._pattern, this._shape, this._locale, this._timezoneStr, this._timezone, this._features, r10);
        }

        public Value withFeature(Feature r12) {
            Features r9 = this._features.with(new Feature[]{r12});
            if (r9 != this._features) goto L6;
            return this;
        L6:
            return new Value(this._pattern, this._shape, this._locale, this._timezoneStr, this._timezone, r9, this._lenient);
        }

        public Value withoutFeature(Feature r12) {
            Features r9 = this._features.without(new Feature[]{r12});
            if (r9 != this._features) goto L6;
            return this;
        L6:
            return new Value(this._pattern, this._shape, this._locale, this._timezoneStr, this._timezone, r9, this._lenient);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonFormat> valueFor() {
            return JsonFormat.class;
        }

        public String getPattern() {
            return this._pattern;
        }

        public Shape getShape() {
            return this._shape;
        }

        public Locale getLocale() {
            return this._locale;
        }

        public Boolean getLenient() {
            return this._lenient;
        }

        public boolean isLenient() {
            return Boolean.TRUE.equals(this._lenient);
        }

        public String timeZoneAsString() {
            TimeZone r0 = this._timezone;
            if (r0 == null) goto L7;
            return r0.getID();
        L7:
            return this._timezoneStr;
        }

        public TimeZone getTimeZone() {
            TimeZone r0 = this._timezone;
            if (r0 != null) goto L10;
            String r1 = this._timezoneStr;
            if (r1 != null) goto L8;
            return null;
        L8:
            TimeZone r2 = TimeZone.getTimeZone(r1);
            this._timezone = r2;
            return r2;
        L10:
            return r0;
        }

        public boolean hasShape() {
            if (this._shape == Shape.ANY) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasPattern() {
            String r0 = this._pattern;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.length() <= 0) goto L7;
            return true;
        }

        public boolean hasLocale() {
            if (this._locale == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTimeZone() {
            if (this._timezone != null) goto L10;
            String r1 = this._timezoneStr;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.isEmpty() == true) goto L9;
        L10:
            return true;
        }

        public boolean hasLenient() {
            if (this._lenient == null) goto L5;
            return true;
        L5:
            return false;
        }

        public Boolean getFeature(Feature r1) {
            return this._features.get(r1);
        }

        public Features getFeatures() {
            return this._features;
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", new Object[]{this._pattern, this._shape, this._lenient, this._locale, this._timezoneStr, this._features});
        }

        public int hashCode() {
            String r0 = this._timezoneStr;
            if (r0 != null) goto L5;
            int r1 = 1;
        L6:
            String r2 = this._pattern;
            if (r2 == null) goto L9;
            r1 = r1 ^ r2.hashCode();
        L9:
            int r3 = r1 + this._shape.hashCode();
            Boolean r4 = this._lenient;
            if (r4 == null) goto L12;
            r3 = r3 ^ r4.hashCode();
        L12:
            Locale r5 = this._locale;
            if (r5 == null) goto L16;
            r3 = r3 + r5.hashCode();
        L16:
            return this._features.hashCode() ^ r3;
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() == getClass()) goto L11;
            return false;
        L11:
            Value r6 = (Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.aiagent.plugin");
            if (this._shape == r6._shape) goto L14;
        L29:
            return false;
        L14:
            if (this._features.equals(r6._features) == false) goto L29;
            if (_equal(this._lenient, r6._lenient) == false) goto L28;
            if (_equal(this._timezoneStr, r6._timezoneStr) == false) goto L28;
            if (_equal(this._pattern, r6._pattern) == false) goto L28;
            if (_equal(this._timezone, r6._timezone) == false) goto L28;
            if (_equal(this._locale, r6._locale) == false) goto L28;
            return true;
        L28:
            return false;
        }

        private static <T> boolean _equal(T r1, T r2) {
            if (r1 != null) goto L7;
            if (r2 != null) goto L11;
            return true;
        L11:
            return false;
        L7:
            if (r2 != null) goto L10;
            return false;
        L10:
            return r1.equals(r2);
        }
    }

    OptBoolean lenient() default OptBoolean.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    Shape shape() default Shape.ANY;

    String timezone() default "##default";

    Feature[] with() default {};

    Feature[] without() default {};
}

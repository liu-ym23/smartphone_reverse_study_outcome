package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    public static final enum Include extends Enum<Include> {
        private static final /* synthetic */ Include[] $VALUES = null;
        public static final Include ALWAYS = null;
        public static final Include CUSTOM = null;
        public static final Include NON_ABSENT = null;
        public static final Include NON_DEFAULT = null;
        public static final Include NON_EMPTY = null;
        public static final Include NON_NULL = null;
        public static final Include USE_DEFAULTS = null;

        private Include(String r1, int r2) {
            super(r1, r2);
        }

        public static Include valueOf(String r2) {
            return (Include) ZeusTransformUtils.preCheckCast(Enum.valueOf(Include.class, r2), Include.class, "com.obric.aiagent.plugin");
        }

        public static Include[] values() {
            return (Include[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Include[].class, "com.obric.aiagent.plugin");
        }

        static {
            Include r0 = new Include("ALWAYS", 0);
            ALWAYS = r0;
            Include r1 = new Include("NON_NULL", 1);
            NON_NULL = r1;
            Include r3 = new Include("NON_ABSENT", 2);
            NON_ABSENT = r3;
            Include r5 = new Include("NON_EMPTY", 3);
            NON_EMPTY = r5;
            Include r7 = new Include("NON_DEFAULT", 4);
            NON_DEFAULT = r7;
            Include r9 = new Include("CUSTOM", 5);
            CUSTOM = r9;
            Include r11 = new Include("USE_DEFAULTS", 6);
            USE_DEFAULTS = r11;
            $VALUES = new Include[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static class Value implements JacksonAnnotationValue<JsonInclude>, Serializable {
        protected static final Value EMPTY = null;
        private static final long serialVersionUID = 1;
        protected final Class<?> _contentFilter;
        protected final Include _contentInclusion;
        protected final Class<?> _valueFilter;
        protected final Include _valueInclusion;

        static {
            EMPTY = new Value(Include.USE_DEFAULTS, Include.USE_DEFAULTS, null, null);
        }

        public Value(JsonInclude r4) {
            JsonInclude r5 = (JsonInclude) ZeusTransformUtils.wrapperContextForParams(r4, JsonInclude.class, "com.obric.aiagent.plugin");
            this(r5.value(), r5.content(), r5.valueFilter(), r5.contentFilter());
        }

        public Value(Include r1, Include r2, Class<?> r3, Class<?> r4) {
            if (r1 != null) goto L5;
            r1 = Include.USE_DEFAULTS;
        L5:
            this._valueInclusion = r1;
            if (r2 != null) goto L8;
            r2 = Include.USE_DEFAULTS;
        L8:
            this._contentInclusion = r2;
            if (r3 != Void.class) goto L11;
            r3 = null;
        L11:
            this._valueFilter = r3;
            if (r4 != Void.class) goto L14;
            r4 = null;
        L14:
            this._contentFilter = r4;
        }

        public static Value empty() {
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

        public Object readResolve() {
            if (this._valueInclusion == Include.USE_DEFAULTS) goto L5;
            return this;
        L5:
            if (this._contentInclusion == Include.USE_DEFAULTS) goto L7;
            return this;
        L7:
            if (this._valueFilter == null) goto L9;
            return this;
        L9:
            if (this._contentFilter == null) goto L11;
            return this;
        L11:
            return EMPTY;
        }

        public Value withOverrides(Value r9) {
            if (r9 != null) goto L4;
        L35:
            return this;
        L4:
            if (r9 == EMPTY) goto L35;
            Include r0 = r9._valueInclusion;
            Include r1 = r9._contentInclusion;
            Class<?> r2 = r9._valueFilter;
            Class<?> r10 = r9._contentFilter;
            boolean r4 = true;
            if (r0 != this._valueInclusion) goto L9;
        L11:
            boolean r3 = false;
        L13:
            if (r1 != this._contentInclusion) goto L15;
        L17:
            boolean r6 = false;
        L18:
            Class<?> r7 = this._valueFilter;
            if (r2 != r7) goto L23;
            if (r10 != r7) goto L23;
            r4 = false;
        L23:
            if (r3 == false) goto L29;
            if (r6 == false) goto L28;
            return new Value(r0, r1, r2, r10);
        L28:
            return new Value(r0, this._contentInclusion, r2, r10);
        L29:
            if (r6 == true) goto L31;
            if (r4 == false) goto L35;
            return new Value(this._valueInclusion, this._contentInclusion, r2, r10);
        L31:
            return new Value(this._valueInclusion, r1, r2, r10);
        L15:
            if (r1 == Include.USE_DEFAULTS) goto L17;
            r6 = true;
            goto L18
        L9:
            if (r0 == Include.USE_DEFAULTS) goto L11;
            r3 = true;
            goto L13
        }

        public static Value construct(Include r2, Include r3) {
            if (r2 == Include.USE_DEFAULTS) goto L6;
            if (r2 == null) goto L6;
        L10:
            return new Value(r2, r3, null, null);
        L6:
            if (r3 == Include.USE_DEFAULTS) goto L12;
            if (r3 != null) goto L10;
        L12:
            return EMPTY;
        }

        public static Value construct(Include r2, Include r3, Class<?> r4, Class<?> r5) {
            if (r4 != Void.class) goto L6;
            r4 = null;
        L6:
            if (r5 != Void.class) goto L9;
            r5 = null;
        L9:
            if (r2 == Include.USE_DEFAULTS) goto L12;
            if (r2 == null) goto L12;
        L19:
            return new Value(r2, r3, r4, r5);
        L12:
            if (r3 == Include.USE_DEFAULTS) goto L14;
            if (r3 != null) goto L19;
        L14:
            if (r4 != null) goto L19;
            if (r5 != null) goto L19;
            return EMPTY;
        }

        public static Value from(JsonInclude r5) {
            JsonInclude r6 = (JsonInclude) ZeusTransformUtils.wrapperContextForParams(r5, JsonInclude.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L5;
            Include r0 = r6.value();
            Include r1 = r6.content();
            if (r0 == Include.USE_DEFAULTS) goto L9;
        L12:
            Class<?> r2 = r6.valueFilter();
            Class<?> r4 = null;
            if (r2 != Void.class) goto L15;
            r2 = null;
        L15:
            Class<?> r7 = r6.contentFilter();
            if (r7 == Void.class) goto L20;
            r4 = r7;
        L20:
            return new Value(r0, r1, r2, r4);
        L9:
            if (r1 != Include.USE_DEFAULTS) goto L12;
            return EMPTY;
        L5:
            return EMPTY;
        }

        public Value withValueInclusion(Include r4) {
            if (r4 != this._valueInclusion) goto L6;
            return this;
        L6:
            return new Value(r4, this._contentInclusion, this._valueFilter, this._contentFilter);
        }

        public Value withValueFilter(Class<?> r3) {
            if (r3 != null) goto L4;
        L7:
            Include r0 = Include.USE_DEFAULTS;
            r3 = null;
        L9:
            return construct(r0, this._contentInclusion, r3, this._contentFilter);
        L4:
            if (r3 == Void.class) goto L7;
            r0 = Include.CUSTOM;
            goto L9
        }

        public Value withContentFilter(Class<?> r3) {
            if (r3 != null) goto L4;
        L7:
            Include r0 = Include.USE_DEFAULTS;
            r3 = null;
        L9:
            return construct(this._valueInclusion, r0, this._valueFilter, r3);
        L4:
            if (r3 == Void.class) goto L7;
            r0 = Include.CUSTOM;
            goto L9
        }

        public Value withContentInclusion(Include r4) {
            if (r4 != this._contentInclusion) goto L6;
            return this;
        L6:
            return new Value(this._valueInclusion, r4, this._valueFilter, this._contentFilter);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonInclude> valueFor() {
            return JsonInclude.class;
        }

        public Include getValueInclusion() {
            return this._valueInclusion;
        }

        public Include getContentInclusion() {
            return this._contentInclusion;
        }

        public Class<?> getValueFilter() {
            return this._valueFilter;
        }

        public Class<?> getContentFilter() {
            return this._contentFilter;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(80);
            r0.append("JsonInclude.Value(value=").append(this._valueInclusion).append(",content=").append(this._contentInclusion);
            if (this._valueFilter == null) goto L6;
            r0.append(",valueFilter=").append(this._valueFilter.getName()).append(".class");
        L6:
            if (this._contentFilter == null) goto L9;
            r0.append(",contentFilter=").append(this._contentFilter.getName()).append(".class");
        L9:
            return r0.append(')').toString();
        }

        public int hashCode() {
            return (this._valueInclusion.hashCode() << 2) + this._contentInclusion.hashCode();
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
            if (r6._valueInclusion != this._valueInclusion) goto L21;
            if (r6._contentInclusion != this._contentInclusion) goto L21;
            if (r6._valueFilter != this._valueFilter) goto L21;
            if (r6._contentFilter != this._contentFilter) goto L21;
            return true;
        L21:
            return false;
        }
    }

    Include content() default Include.ALWAYS;

    Class<?> contentFilter() default Void.class;

    Include value() default Include.ALWAYS;

    Class<?> valueFilter() default Void.class;
}

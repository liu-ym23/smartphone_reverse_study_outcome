package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSetter {

    public static class Value implements JacksonAnnotationValue<JsonSetter>, Serializable {
        protected static final Value EMPTY = null;
        private static final long serialVersionUID = 1;
        private final Nulls _contentNulls;
        private final Nulls _nulls;

        static {
            EMPTY = new Value(Nulls.DEFAULT, Nulls.DEFAULT);
        }

        public Value(Nulls r1, Nulls r2) {
            this._nulls = r1;
            this._contentNulls = r2;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonSetter> valueFor() {
            return JsonSetter.class;
        }

        public Object readResolve() {
            if (_empty(this._nulls, this._contentNulls) == true) goto L5;
            return this;
        L5:
            return EMPTY;
        }

        public static Value from(JsonSetter r2) {
            JsonSetter r3 = (JsonSetter) ZeusTransformUtils.wrapperContextForParams(r2, JsonSetter.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L7;
            return EMPTY;
        L7:
            return construct(r3.nulls(), r3.contentNulls());
        }

        public static Value construct(Nulls r1, Nulls r2) {
            if (r1 != null) goto L4;
            r1 = Nulls.DEFAULT;
        L4:
            if (r2 != null) goto L7;
            r2 = Nulls.DEFAULT;
        L7:
            if (_empty(r1, r2) == false) goto L11;
            return EMPTY;
        L11:
            return new Value(r1, r2);
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

        public static Value forValueNulls(Nulls r1) {
            return construct(r1, Nulls.DEFAULT);
        }

        public static Value forValueNulls(Nulls r0, Nulls r1) {
            return construct(r0, r1);
        }

        public static Value forContentNulls(Nulls r1) {
            return construct(Nulls.DEFAULT, r1);
        }

        public Value withOverrides(Value r3) {
            if (r3 != null) goto L4;
            return this;
        L4:
            if (r3 == EMPTY) goto L20;
            Nulls r0 = r3._nulls;
            Nulls r4 = r3._contentNulls;
            if (r0 != Nulls.DEFAULT) goto L10;
            r0 = this._nulls;
        L10:
            if (r4 != Nulls.DEFAULT) goto L13;
            r4 = this._contentNulls;
        L13:
            if (r0 != this._nulls) goto L18;
            if (r4 != this._contentNulls) goto L18;
            return this;
        L18:
            return construct(r0, r4);
        L20:
            return this;
        }

        public Value withValueNulls(Nulls r2) {
            if (r2 != null) goto L5;
            r2 = Nulls.DEFAULT;
        L5:
            if (r2 != this._nulls) goto L8;
            return this;
        L8:
            return construct(r2, this._contentNulls);
        }

        public Value withValueNulls(Nulls r2, Nulls r3) {
            if (r2 != null) goto L4;
            r2 = Nulls.DEFAULT;
        L4:
            if (r3 != null) goto L7;
            r3 = Nulls.DEFAULT;
        L7:
            if (r2 != this._nulls) goto L12;
            if (r3 != this._contentNulls) goto L12;
            return this;
        L12:
            return construct(r2, r3);
        }

        public Value withContentNulls(Nulls r2) {
            if (r2 != null) goto L5;
            r2 = Nulls.DEFAULT;
        L5:
            if (r2 != this._contentNulls) goto L8;
            return this;
        L8:
            return construct(this._nulls, r2);
        }

        public Nulls getValueNulls() {
            return this._nulls;
        }

        public Nulls getContentNulls() {
            return this._contentNulls;
        }

        public Nulls nonDefaultValueNulls() {
            if (this._nulls != Nulls.DEFAULT) goto L6;
            return null;
        L6:
            return this._nulls;
        }

        public Nulls nonDefaultContentNulls() {
            if (this._contentNulls != Nulls.DEFAULT) goto L6;
            return null;
        L6:
            return this._contentNulls;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[]{this._nulls, this._contentNulls});
        }

        public int hashCode() {
            return this._nulls.ordinal() + (this._contentNulls.ordinal() << 2);
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() != getClass()) goto L17;
            Value r6 = (Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.aiagent.plugin");
            if (r6._nulls != this._nulls) goto L16;
            if (r6._contentNulls != this._contentNulls) goto L16;
            return true;
        L16:
            return false;
        L17:
            return false;
        }

        private static boolean _empty(Nulls r1, Nulls r2) {
            if (r1 == Nulls.DEFAULT) goto L5;
        L7:
            return false;
        L5:
            if (r2 != Nulls.DEFAULT) goto L7;
            return true;
        }
    }

    Nulls contentNulls() default Nulls.DEFAULT;

    Nulls nulls() default Nulls.DEFAULT;

    String value() default "";
}

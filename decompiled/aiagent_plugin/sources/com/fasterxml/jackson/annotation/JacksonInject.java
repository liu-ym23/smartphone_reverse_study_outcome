package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JacksonInject {

    public static class Value implements JacksonAnnotationValue<JacksonInject>, Serializable {
        protected static final Value EMPTY = null;
        private static final long serialVersionUID = 1;
        protected final Object _id;
        protected final Boolean _useInput;

        private static boolean _empty(Object r0, Boolean r1) {
            if (r0 != null) goto L5;
            if (r1 != null) goto L5;
            return true;
        L5:
            return false;
        }

        static {
            EMPTY = new Value(null, null);
        }

        public Value(Object r1, Boolean r2) {
            this._id = r1;
            this._useInput = r2;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JacksonInject> valueFor() {
            return JacksonInject.class;
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value construct(Object r1, Boolean r2) {
            if ("".equals(r1) == false) goto L6;
            r1 = null;
        L6:
            if (_empty(r1, r2) == false) goto L10;
            return EMPTY;
        L10:
            return new Value(r1, r2);
        }

        public static Value from(JacksonInject r2) {
            JacksonInject r3 = (JacksonInject) ZeusTransformUtils.wrapperContextForParams(r2, JacksonInject.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L7;
            return EMPTY;
        L7:
            return construct(r3.value(), r3.useInput().asBoolean());
        }

        public static Value forId(Object r1) {
            return construct(r1, null);
        }

        public Value withId(Object r2) {
            if (r2 != null) goto L7;
            if (this._id != null) goto L10;
            return this;
        L10:
            return new Value(r2, this._useInput);
        L7:
            if (r2.equals(this._id) == false) goto L10;
            return this;
        }

        public Value withUseInput(Boolean r2) {
            if (r2 != null) goto L7;
            if (this._useInput != null) goto L10;
            return this;
        L10:
            return new Value(this._id, r2);
        L7:
            if (r2.equals(this._useInput) == false) goto L10;
            return this;
        }

        public Object getId() {
            return this._id;
        }

        public Boolean getUseInput() {
            return this._useInput;
        }

        public boolean hasId() {
            if (this._id == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean willUseInput(boolean r1) {
            Boolean r0 = this._useInput;
            if (r0 != null) goto L6;
            return r1;
        L6:
            return r0.booleanValue();
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", new Object[]{this._id, this._useInput});
        }

        public int hashCode() {
            Object r0 = this._id;
            int r1 = 1;
            if (r0 == null) goto L5;
            r1 = 1 + r0.hashCode();
        L5:
            Boolean r2 = this._useInput;
            if (r2 != null) goto L8;
            return r1;
        L8:
            return r1 + r2.hashCode();
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (r5.getClass() != getClass()) goto L21;
            Value r6 = (Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.aiagent.plugin");
            if (OptBoolean.equals(this._useInput, r6._useInput) == false) goto L21;
            Object r4 = this._id;
            if (r4 != null) goto L20;
            if (r6._id != null) goto L18;
            return true;
        L18:
            return false;
        L20:
            return r4.equals(r6._id);
        L21:
            return false;
        }
    }

    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";
}

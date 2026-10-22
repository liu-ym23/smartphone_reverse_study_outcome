package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JacksonInject {

    public static class Value implements JacksonAnnotationValue<JacksonInject>, Serializable {
        protected static final Value EMPTY = new Value(null, null, null);
        private static final long serialVersionUID = 1;
        protected final Object _id;
        protected final Boolean _optional;
        protected final Boolean _useInput;

        public Value(Object obj, Boolean bool, Boolean bool2) {
            this._id = obj;
            this._useInput = bool;
            this._optional = bool2;
        }

        private static boolean _empty(Object obj, Boolean bool, Boolean bool2) {
            return obj == null && bool == null && bool2 == null;
        }

        @Deprecated
        public static Value construct(Object obj, Boolean bool) {
            return construct(obj, bool, null);
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value forId(Object obj) {
            return construct(obj, null, null);
        }

        public static Value from(JacksonInject jacksonInject) {
            return jacksonInject == null ? EMPTY : construct(jacksonInject.value(), jacksonInject.useInput().asBoolean(), jacksonInject.optional().asBoolean());
        }

        public boolean equals(Object obj) {
            Boolean bool;
            Boolean bool2;
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Value value = (Value) obj;
                Object obj2 = this._id;
                if (((obj2 == null && value._id == null) || (obj2 != null && obj2.equals(value._id))) && ((((bool = this._useInput) == null && value._useInput == null) || (bool != null && bool.equals(value._useInput))) && (((bool2 = this._optional) == null && value._optional == null) || (bool2 != null && bool2.equals(value._optional))))) {
                    return true;
                }
            }
            return false;
        }

        public Object getId() {
            return this._id;
        }

        public Boolean getOptional() {
            return this._optional;
        }

        public Boolean getUseInput() {
            return this._useInput;
        }

        public boolean hasId() {
            return this._id != null;
        }

        public int hashCode() {
            Object obj = this._id;
            int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
            Boolean bool = this._useInput;
            if (bool != null) {
                iHashCode += bool.hashCode();
            }
            Boolean bool2 = this._optional;
            return bool2 != null ? iHashCode + bool2.hashCode() : iHashCode;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s,optional=%s)", this._id, this._useInput, this._optional);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JacksonInject> valueFor() {
            return JacksonInject.class;
        }

        public boolean willUseInput(boolean z10) {
            Boolean bool = this._useInput;
            return bool == null ? z10 : bool.booleanValue();
        }

        public Value withId(Object obj) {
            return (obj != null ? !obj.equals(this._id) : this._id != null) ? new Value(obj, this._useInput, this._optional) : this;
        }

        public Value withOptional(Boolean bool) {
            return (bool != null ? !bool.equals(this._optional) : this._optional != null) ? new Value(this._id, this._useInput, bool) : this;
        }

        public Value withUseInput(Boolean bool) {
            return (bool != null ? !bool.equals(this._useInput) : this._useInput != null) ? new Value(this._id, bool, this._optional) : this;
        }

        public static Value construct(Object obj, Boolean bool, Boolean bool2) {
            if ("".equals(obj)) {
                obj = null;
            }
            return _empty(obj, bool, bool2) ? EMPTY : new Value(obj, bool, bool2);
        }
    }

    OptBoolean optional() default OptBoolean.DEFAULT;

    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";
}

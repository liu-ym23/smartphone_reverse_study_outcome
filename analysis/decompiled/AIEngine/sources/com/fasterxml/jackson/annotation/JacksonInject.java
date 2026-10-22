package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JacksonInject {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Value implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final Value f3421c = new Value(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Object f3422a;

        /* renamed from: b, reason: collision with root package name */
        public final Boolean f3423b;

        public Value(Object obj, Boolean bool) {
            this.f3422a = obj;
            this.f3423b = bool;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Value value = (Value) obj;
                Object obj2 = value.f3422a;
                Boolean bool = value.f3423b;
                Boolean bool2 = this.f3423b;
                if (bool2 == null ? bool == null : bool2.equals(bool)) {
                    Object obj3 = this.f3422a;
                    return obj3 == null ? obj2 == null : obj3.equals(obj2);
                }
            }
            return false;
        }

        public final int hashCode() {
            Object obj = this.f3422a;
            int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
            Boolean bool = this.f3423b;
            return bool != null ? bool.hashCode() + iHashCode : iHashCode;
        }

        public final String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", this.f3422a, this.f3423b);
        }
    }

    OptBoolean useInput() default OptBoolean.f3502b;

    String value() default "";
}

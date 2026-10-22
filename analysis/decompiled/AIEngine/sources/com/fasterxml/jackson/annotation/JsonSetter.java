package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonSetter {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Value implements Serializable {

        /* renamed from: c, reason: collision with root package name */
        public static final Value f3478c;

        /* renamed from: a, reason: collision with root package name */
        public final Nulls f3479a;

        /* renamed from: b, reason: collision with root package name */
        public final Nulls f3480b;

        static {
            Nulls nulls = Nulls.f3494d;
            f3478c = new Value(nulls, nulls);
        }

        public Value(Nulls nulls, Nulls nulls2) {
            this.f3479a = nulls;
            this.f3480b = nulls2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Value value = (Value) obj;
                if (value.f3479a == this.f3479a && value.f3480b == this.f3480b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f3479a.ordinal() + (this.f3480b.ordinal() << 2);
        }

        public Object readResolve() {
            Nulls nulls = this.f3479a;
            Nulls nulls2 = Nulls.f3494d;
            return (nulls == nulls2 && this.f3480b == nulls2) ? f3478c : this;
        }

        public final String toString() {
            return "JsonSetter.Value(valueNulls=" + this.f3479a + ",contentNulls=" + this.f3480b + ")";
        }
    }

    Nulls contentNulls() default Nulls.f3494d;

    Nulls nulls() default Nulls.f3494d;

    String value() default "";
}

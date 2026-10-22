package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonIncludeProperties {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Value implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final Value f3474b = new Value(null);

        /* renamed from: a, reason: collision with root package name */
        public final Set<String> f3475a;

        public Value(Set<String> set) {
            this.f3475a = set;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Set<String> set = ((Value) obj).f3475a;
                Set<String> set2 = this.f3475a;
                if (set2 == null ? set == null : set2.equals(set)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Set<String> set = this.f3475a;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public final String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this.f3475a);
        }
    }

    String[] value() default {};
}

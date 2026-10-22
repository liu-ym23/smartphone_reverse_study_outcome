package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonIgnoreProperties {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Value implements Serializable {
        public static final Value h = new Value(Collections.EMPTY_SET, false, false, false, true);

        /* renamed from: a, reason: collision with root package name */
        public final Set<String> f3459a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3460b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f3461c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f3462d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f3463e;

        public Value(Set<String> set, boolean z, boolean z3, boolean z10, boolean z11) {
            if (set == null) {
                this.f3459a = Collections.EMPTY_SET;
            } else {
                this.f3459a = set;
            }
            this.f3460b = z;
            this.f3461c = z3;
            this.f3462d = z10;
            this.f3463e = z11;
        }

        public static boolean a(Set<String> set, boolean z, boolean z3, boolean z10, boolean z11) {
            Value value = h;
            if (z == value.f3460b && z3 == value.f3461c && z10 == value.f3462d && z11 == value.f3463e) {
                return set == null || set.size() == 0;
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Value value = (Value) obj;
                if (this.f3460b == value.f3460b && this.f3463e == value.f3463e && this.f3461c == value.f3461c && this.f3462d == value.f3462d && this.f3459a.equals(value.f3459a)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f3459a.size() + (this.f3460b ? 1 : -3) + (this.f3461c ? 3 : -7) + (this.f3462d ? 7 : -11) + (this.f3463e ? 11 : -13);
        }

        public Object readResolve() {
            return a(this.f3459a, this.f3460b, this.f3461c, this.f3462d, this.f3463e) ? h : this;
        }

        public final String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this.f3459a, Boolean.valueOf(this.f3460b), Boolean.valueOf(this.f3461c), Boolean.valueOf(this.f3462d), Boolean.valueOf(this.f3463e));
        }
    }

    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};
}

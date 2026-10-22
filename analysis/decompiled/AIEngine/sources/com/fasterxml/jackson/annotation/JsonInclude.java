package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonInclude {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Include {

        /* renamed from: a, reason: collision with root package name */
        public static final Include f3464a;

        /* renamed from: b, reason: collision with root package name */
        public static final Include f3465b;

        /* renamed from: c, reason: collision with root package name */
        public static final Include f3466c;

        /* renamed from: d, reason: collision with root package name */
        public static final Include f3467d;

        /* renamed from: e, reason: collision with root package name */
        public static final Include f3468e;
        public static final /* synthetic */ Include[] h;

        static {
            Include include = new Include("ALWAYS", 0);
            f3464a = include;
            Include include2 = new Include("NON_NULL", 1);
            f3465b = include2;
            Include include3 = new Include("NON_ABSENT", 2);
            Include include4 = new Include("NON_EMPTY", 3);
            f3466c = include4;
            Include include5 = new Include("NON_DEFAULT", 4);
            f3467d = include5;
            Include include6 = new Include("CUSTOM", 5);
            Include include7 = new Include("USE_DEFAULTS", 6);
            f3468e = include7;
            h = new Include[]{include, include2, include3, include4, include5, include6, include7};
        }

        public Include() {
            throw null;
        }

        public static Include valueOf(String str) {
            return (Include) Enum.valueOf(Include.class, str);
        }

        public static Include[] values() {
            return (Include[]) h.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Value implements Serializable {

        /* renamed from: e, reason: collision with root package name */
        public static final Value f3469e;

        /* renamed from: a, reason: collision with root package name */
        public final Include f3470a;

        /* renamed from: b, reason: collision with root package name */
        public final Include f3471b;

        /* renamed from: c, reason: collision with root package name */
        public final Class<?> f3472c;

        /* renamed from: d, reason: collision with root package name */
        public final Class<?> f3473d;

        static {
            Include include = Include.f3468e;
            f3469e = new Value(include, include, null, null);
        }

        public Value(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            Include include3 = Include.f3468e;
            this.f3470a = include == null ? include3 : include;
            this.f3471b = include2 == null ? include3 : include2;
            this.f3472c = cls == Void.class ? null : cls;
            this.f3473d = cls2 == Void.class ? null : cls2;
        }

        public final Value a(Value value) {
            if (value == null || value == f3469e) {
                return this;
            }
            Include include = value.f3470a;
            Include include2 = value.f3471b;
            Class<?> cls = value.f3472c;
            Class<?> cls2 = value.f3473d;
            Include include3 = Include.f3468e;
            Include include4 = this.f3470a;
            boolean z = (include == include4 || include == include3) ? false : true;
            Include include5 = this.f3471b;
            boolean z3 = (include2 == include5 || include2 == include3) ? false : true;
            Class<?> cls3 = this.f3472c;
            return z ? z3 ? new Value(include, include2, cls, cls2) : new Value(include, include5, cls, cls2) : z3 ? new Value(include4, include2, cls, cls2) : (cls == cls3 && cls2 == cls3) ? false : true ? new Value(include4, include5, cls, cls2) : this;
        }

        public final Value b(Include include) {
            if (include == this.f3470a) {
                return this;
            }
            return new Value(include, this.f3471b, this.f3472c, this.f3473d);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            return value.f3470a == this.f3470a && value.f3471b == this.f3471b && value.f3472c == this.f3472c && value.f3473d == this.f3473d;
        }

        public final int hashCode() {
            return this.f3471b.hashCode() + (this.f3470a.hashCode() << 2);
        }

        public Object readResolve() {
            Include include = this.f3470a;
            Include include2 = Include.f3468e;
            return (include == include2 && this.f3471b == include2 && this.f3472c == null && this.f3473d == null) ? f3469e : this;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(80);
            sb2.append("JsonInclude.Value(value=");
            sb2.append(this.f3470a);
            sb2.append(",content=");
            sb2.append(this.f3471b);
            Class<?> cls = this.f3472c;
            if (cls != null) {
                sb2.append(",valueFilter=");
                sb2.append(cls.getName());
                sb2.append(".class");
            }
            Class<?> cls2 = this.f3473d;
            if (cls2 != null) {
                sb2.append(",contentFilter=");
                sb2.append(cls2.getName());
                sb2.append(".class");
            }
            sb2.append(')');
            return sb2.toString();
        }
    }

    Include content() default Include.f3464a;

    Class<?> contentFilter() default Void.class;

    Include value() default Include.f3464a;

    Class<?> valueFilter() default Void.class;
}

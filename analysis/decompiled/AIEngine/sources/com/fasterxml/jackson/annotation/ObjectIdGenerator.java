package com.fasterxml.jackson.annotation;

import com.stepos.core.download.ModelFlowMeta;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class IdKey implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f3496a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f3497b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f3498c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3499d;

        public IdKey(Class<?> cls, Class<?> cls2, Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("Can not construct IdKey for null key");
            }
            this.f3496a = cls;
            this.f3497b = cls2;
            this.f3498c = obj;
            int iHashCode = cls.getName().hashCode() + obj.hashCode();
            this.f3499d = cls2 != null ? iHashCode ^ cls2.getName().hashCode() : iHashCode;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != IdKey.class) {
                return false;
            }
            IdKey idKey = (IdKey) obj;
            return idKey.f3498c.equals(this.f3498c) && idKey.f3496a == this.f3496a && idKey.f3497b == this.f3497b;
        }

        public final int hashCode() {
            return this.f3499d;
        }

        public final String toString() {
            String name = ModelFlowMeta.PLAN_NONE;
            Class<?> cls = this.f3496a;
            String name2 = cls == null ? ModelFlowMeta.PLAN_NONE : cls.getName();
            Class<?> cls2 = this.f3497b;
            if (cls2 != null) {
                name = cls2.getName();
            }
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", this.f3498c, name2, name);
        }
    }

    public abstract boolean a(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> b(Class<?> cls);

    public abstract T c(Object obj);

    public abstract Class<?> d();

    public abstract IdKey e(Object obj);

    public abstract ObjectIdGenerator f();
}

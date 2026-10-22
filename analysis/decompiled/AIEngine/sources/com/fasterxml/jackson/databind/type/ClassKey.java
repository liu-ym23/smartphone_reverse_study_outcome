package com.fasterxml.jackson.databind.type;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ClassKey implements Comparable<ClassKey>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f4424a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f4425b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4426c;

    public ClassKey() {
        this.f4425b = null;
        this.f4424a = null;
        this.f4426c = 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(ClassKey classKey) {
        return this.f4424a.compareTo(classKey.f4424a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == ClassKey.class && ((ClassKey) obj).f4425b == this.f4425b;
    }

    public final int hashCode() {
        return this.f4426c;
    }

    public final String toString() {
        return this.f4424a;
    }

    public ClassKey(Class<?> cls) {
        this.f4425b = cls;
        String name = cls.getName();
        this.f4424a = name;
        this.f4426c = name.hashCode();
    }
}

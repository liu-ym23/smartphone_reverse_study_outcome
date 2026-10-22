package com.fasterxml.jackson.databind.jsontype;

import ai.onnxruntime.a;
import java.io.Serializable;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NamedType implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f4235a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4236b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4237c;

    public NamedType() {
        throw null;
    }

    public NamedType(Class<?> cls, String str) {
        this.f4235a = cls;
        this.f4236b = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        this.f4237c = (str == null || str.isEmpty()) ? null : str;
    }

    public final boolean a() {
        return this.f4237c != null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != NamedType.class) {
            return false;
        }
        NamedType namedType = (NamedType) obj;
        return this.f4235a == namedType.f4235a && Objects.equals(this.f4237c, namedType.f4237c);
    }

    public final int hashCode() {
        return this.f4236b;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[NamedType, class ");
        sb2.append(this.f4235a.getName());
        sb2.append(", name: ");
        return a.o(sb2, this.f4237c == null ? "null" : a.o(new StringBuilder("'"), this.f4237c, "'"), "]");
    }
}

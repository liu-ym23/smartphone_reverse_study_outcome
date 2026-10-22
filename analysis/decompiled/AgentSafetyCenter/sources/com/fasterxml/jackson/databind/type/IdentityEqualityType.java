package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
abstract class IdentityEqualityType extends TypeBase {
    private static final long serialVersionUID = 1;

    public IdentityEqualityType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z10) {
        super(cls, typeBindings, javaType, javaTypeArr, i, obj, obj2, z10);
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.fasterxml.jackson.databind.JavaType
    public final int hashCode() {
        return System.identityHashCode(this);
    }
}

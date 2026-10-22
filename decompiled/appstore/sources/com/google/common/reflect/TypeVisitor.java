package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class TypeVisitor {
    private final Set<Type> visited;

    public TypeVisitor() {
        this.visited = Sets.newHashSet();
    }

    public final void visit(Type... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L31;
        Type r13 = r10[r12];
        if (r13 == null) goto L30;
        if (this.visited.add(r13) == false) goto L30;
    L12:
        th = move-exception;
        this.visited.remove(r13);
        throw th;
    L10:
        if ((r13 instanceof TypeVariable) == false) goto L15;
        visitTypeVariable((TypeVariable) r13);     // Catch: Throwable -> L12
        goto L30
    L15:
        if ((r13 instanceof WildcardType) == false) goto L18;
        visitWildcardType((WildcardType) r13);     // Catch: Throwable -> L12
        goto L30
    L18:
        if ((r13 instanceof ParameterizedType) == false) goto L21;
        visitParameterizedType((ParameterizedType) r13);     // Catch: Throwable -> L12
        goto L30
    L21:
        if ((r13 instanceof Class) == false) goto L24;
        visitClass((Class) r13);     // Catch: Throwable -> L12
        goto L30
    L24:
        if ((r13 instanceof GenericArrayType) == false) goto L27;
        visitGenericArrayType((GenericArrayType) r13);     // Catch: Throwable -> L12
        goto L30
    L27:
        throw new AssertionError("Unknown type: " + r13);     // Catch: Throwable -> L12
    L30:
        r12 = r12 + 1;
        goto L3
    }

    public void visitClass(Class<?> r10) {
    }

    public void visitGenericArrayType(GenericArrayType r10) {
    }

    public void visitParameterizedType(ParameterizedType r10) {
    }

    public void visitTypeVariable(TypeVariable<?> r10) {
    }

    public void visitWildcardType(WildcardType r10) {
    }
}

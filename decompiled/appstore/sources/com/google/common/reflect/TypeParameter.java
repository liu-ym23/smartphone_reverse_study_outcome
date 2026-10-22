package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class TypeParameter<T> extends TypeCapture<T> {
    final TypeVariable<?> typeVariable;

    public TypeParameter() {
        Type r10 = capture();
        Preconditions.checkArgument(r10 instanceof TypeVariable, "%s should be a type variable.", r10);
        this.typeVariable = (TypeVariable) r10;
    }

    public final boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof TypeParameter) == true) goto L5;
        return false;
    L5:
        return this.typeVariable.equals(((TypeParameter) r10).typeVariable);
    }

    public final int hashCode() {
        return this.typeVariable.hashCode();
    }

    public String toString() {
        return this.typeVariable.toString();
    }
}

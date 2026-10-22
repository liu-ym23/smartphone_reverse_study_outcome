package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeParameter<T> extends TypeCapture<T> {
    final TypeVariable<?> typeVariable;

    protected TypeParameter() {
        Type r0 = capture();
        Preconditions.checkArgument(r0 instanceof TypeVariable, "%s should be a type variable.", new Object[]{r0});
        this.typeVariable = (TypeVariable) r0;
    }

    public final int hashCode() {
        return this.typeVariable.hashCode();
    }

    public final boolean equals(@Nullable Object r2) {
        if ((r2 instanceof TypeParameter) == true) goto L5;
        return false;
    L5:
        return this.typeVariable.equals(((TypeParameter) r2).typeVariable);
    }

    public String toString() {
        return this.typeVariable.toString();
    }
}

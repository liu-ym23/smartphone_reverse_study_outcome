package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    public RuntimeEnumAdapter(Class<E> r10) {
        super(r10);
        this.type = r10;
    }

    private Method getFromValueMethod() {
        Method r10 = this.fromValueMethod;
        if (r10 == null) goto L10;
        return r10;
    L10:
        Method r11 = this.type.getMethod("fromValue", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L7
        this.fromValueMethod = r11;     // Catch: NoSuchMethodException -> L7
        return r11;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof RuntimeEnumAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeEnumAdapter) r10).type != this.type) goto L7;
        return true;
    }

    @Override // com.squareup.wire.EnumAdapter
    public E fromValue(int r10) {
        return (E) getFromValueMethod().invoke(null, new Object[]{Integer.valueOf(r10)});
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}

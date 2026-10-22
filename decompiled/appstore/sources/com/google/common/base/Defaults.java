package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class Defaults {
    private static final Double DOUBLE_DEFAULT = null;
    private static final Float FLOAT_DEFAULT = null;

    static {
        DOUBLE_DEFAULT = Double.valueOf(0.0d);
        FLOAT_DEFAULT = Float.valueOf(0.0f);
    }

    private Defaults() {
    }

    @NullableDecl
    public static <T> T defaultValue(Class<T> r10) {
        Preconditions.checkNotNull(r10);
        if (r10 != Boolean.TYPE) goto L7;
        return (T) Boolean.FALSE;
    L7:
        if (r10 != Character.TYPE) goto L11;
        return (T) (char) 0;
    L11:
        if (r10 != Byte.TYPE) goto L15;
        return (T) (byte) 0;
    L15:
        if (r10 != Short.TYPE) goto L19;
        return (T) (short) 0;
    L19:
        if (r10 != Integer.TYPE) goto L23;
        return (T) 0;
    L23:
        if (r10 != Long.TYPE) goto L27;
        return (T) 0L;
    L27:
        if (r10 != Float.TYPE) goto L31;
        return (T) FLOAT_DEFAULT;
    L31:
        if (r10 == Double.TYPE) goto L33;
        return null;
    L33:
        return (T) DOUBLE_DEFAULT;
    }
}

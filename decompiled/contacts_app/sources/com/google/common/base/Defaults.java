package com.google.common.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Defaults {
    private static final Map<Class<?>, Object> DEFAULTS = null;

    private Defaults() {
    }

    static {
        HashMap r0 = new HashMap();
        put(r0, Boolean.TYPE, false);
        put(r0, Character.TYPE, (char) 0);
        put(r0, Byte.TYPE, (byte) 0);
        put(r0, Short.TYPE, (short) 0);
        put(r0, Integer.TYPE, 0);
        put(r0, Long.TYPE, 0L);
        put(r0, Float.TYPE, Float.valueOf(0.0f));
        put(r0, Double.TYPE, Double.valueOf(0.0d));
        DEFAULTS = Collections.unmodifiableMap(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void put(Map<Class<?>, Object> r0, Class<T> r1, T r2) {
        r0.put(r1, r2);
    }

    @Nullable
    public static <T> T defaultValue(Class<T> r1) {
        return (T) DEFAULTS.get(Preconditions.checkNotNull(r1));
    }
}

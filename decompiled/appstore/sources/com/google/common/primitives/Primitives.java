package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class Primitives {
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE = null;
    private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE = null;

    static {
        LinkedHashMap r10 = new LinkedHashMap(16);
        LinkedHashMap r11 = new LinkedHashMap(16);
        add(r10, r11, Boolean.TYPE, Boolean.class);
        add(r10, r11, Byte.TYPE, Byte.class);
        add(r10, r11, Character.TYPE, Character.class);
        add(r10, r11, Double.TYPE, Double.class);
        add(r10, r11, Float.TYPE, Float.class);
        add(r10, r11, Integer.TYPE, Integer.class);
        add(r10, r11, Long.TYPE, Long.class);
        add(r10, r11, Short.TYPE, Short.class);
        add(r10, r11, Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(r10);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(r11);
    }

    private Primitives() {
    }

    private static void add(Map<Class<?>, Class<?>> r10, Map<Class<?>, Class<?>> r11, Class<?> r12, Class<?> r13) {
        r10.put(r12, r13);
        r11.put(r13, r12);
    }

    public static Set<Class<?>> allPrimitiveTypes() {
        return PRIMITIVE_TO_WRAPPER_TYPE.keySet();
    }

    public static Set<Class<?>> allWrapperTypes() {
        return WRAPPER_TO_PRIMITIVE_TYPE.keySet();
    }

    public static boolean isWrapperType(Class<?> r10) {
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(Preconditions.checkNotNull(r10));
    }

    public static <T> Class<T> unwrap(Class<T> r10) {
        Preconditions.checkNotNull(r10);
        Class<T> r11 = (Class) WRAPPER_TO_PRIMITIVE_TYPE.get(r10);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static <T> Class<T> wrap(Class<T> r10) {
        Preconditions.checkNotNull(r10);
        Class<T> r11 = (Class) PRIMITIVE_TO_WRAPPER_TYPE.get(r10);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }
}

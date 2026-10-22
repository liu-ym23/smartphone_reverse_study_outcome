package com.google.common.base;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Enums {
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = null;

    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(Object r1) {
            return doBackward((Enum) r1);
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ Object doForward(String r1) {
            return doForward2(r1);
        }

        StringConverter(Class<T> r1) {
            this.enumClass = (Class) Preconditions.checkNotNull(r1);
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        protected T doForward2(String r1) {
            return (T) Enum.valueOf(this.enumClass, r1);
        }

        protected String doBackward(T r1) {
            return r1.name();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof StringConverter) == true) goto L5;
            return false;
        L5:
            return this.enumClass.equals(((StringConverter) r2).enumClass);
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }
    }

    private Enums() {
    }

    public static Field getField(Enum<?> r1) {
        Class<E> r0 = r1.getDeclaringClass();
        return r0.getDeclaredField(r1.name());
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> r0, String r1) {
        Preconditions.checkNotNull(r0);
        Preconditions.checkNotNull(r1);
        return Platform.getEnumIfPresent(r0, r1);
    }

    static {
        enumConstantCache = new WeakHashMap();
    }

    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> r5) {
        HashMap r0 = new HashMap();
        Iterator r1 = EnumSet.allOf(r5).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Enum r2 = (Enum) r1.next();
        r0.put(r2.name(), new WeakReference(r2));
        goto L4
    L6:
        enumConstantCache.put(r5, r0);
        return r0;
    }

    static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> r2) {
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> r0 = enumConstantCache;
        monitor-enter(r0);
        Map<String, WeakReference<? extends Enum<?>>> r1 = r0.get(r2);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = populateCache(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> r1) {
        return new StringConverter(r1);
    }
}

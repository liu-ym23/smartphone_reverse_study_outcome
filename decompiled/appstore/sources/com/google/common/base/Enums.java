package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Enums {

    @GwtIncompatible
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = null;

    public static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        public StringConverter(Class<T> r10) {
            this.enumClass = (Class) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Object r10) {
            return doBackward((Enum) r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Object doForward(String r10) {
            return doForward2(r10);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof StringConverter) == true) goto L5;
            return false;
        L5:
            return this.enumClass.equals(((StringConverter) r10).enumClass);
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }

        public String doBackward(T r10) {
            return r10.name();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public T doForward2(String r10) {
            return (T) Enum.valueOf(this.enumClass, r10);
        }
    }

    static {
        enumConstantCache = new WeakHashMap();
    }

    private Enums() {
    }

    @GwtIncompatible
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> r10) {
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> r11 = enumConstantCache;
        monitor-enter(r11);
        Map<String, WeakReference<? extends Enum<?>>> r12 = r11.get(r10);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = populateCache(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @GwtIncompatible
    public static Field getField(Enum<?> r10) {
        Class<E> r11 = r10.getDeclaringClass();
        return r11.getDeclaredField(r10.name());
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> r10, String r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return Platform.getEnumIfPresent(r10, r11);
    }

    @GwtIncompatible
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> r10) {
        HashMap r11 = new HashMap();
        Iterator r12 = EnumSet.allOf(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Enum r13 = (Enum) r12.next();
        r11.put(r13.name(), new WeakReference(r13));
        goto L4
    L6:
        enumConstantCache.put(r10, r11);
        return r11;
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> r10) {
        return new StringConverter(r10);
    }
}

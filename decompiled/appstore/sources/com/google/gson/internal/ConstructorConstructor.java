package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstructorConstructor {
    private final ReflectionAccessor accessor;
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r10) {
        this.accessor = ReflectionAccessor.getInstance();
        this.instanceCreators = r10;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r10) {
        final Constructor<? super T> r11 = r10.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L8
        if (r11.isAccessible() == true) goto L6;
        this.accessor.makeAccessible(r11);     // Catch: NoSuchMethodException -> L8
    L6:
        return new AnonymousClass3(this, r11);
    L8:
        return null;
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type r10, Class<? super T> r11) {
        if (Collection.class.isAssignableFrom(r11) == false) goto L23;
        if (SortedSet.class.isAssignableFrom(r11) == false) goto L9;
        return new AnonymousClass4(this);
    L9:
        if (EnumSet.class.isAssignableFrom(r11) == false) goto L13;
        return new AnonymousClass5(this, r10);
    L13:
        if (Set.class.isAssignableFrom(r11) == false) goto L17;
        return new AnonymousClass6(this);
    L17:
        if (Queue.class.isAssignableFrom(r11) == false) goto L21;
        return new AnonymousClass7(this);
    L21:
        return new AnonymousClass8(this);
    L23:
        if (Map.class.isAssignableFrom(r11) == true) goto L25;
        return null;
    L25:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r11) == false) goto L29;
        return new AnonymousClass9(this);
    L29:
        if (ConcurrentMap.class.isAssignableFrom(r11) == false) goto L33;
        return new AnonymousClass10(this);
    L33:
        if (SortedMap.class.isAssignableFrom(r11) == false) goto L37;
        return new AnonymousClass11(this);
    L37:
        if ((r10 instanceof ParameterizedType) == false) goto L43;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) r10).getActualTypeArguments()[0]).getRawType()) == true) goto L43;
        return new AnonymousClass12(this);
    L43:
        return new AnonymousClass13(this);
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Type r10, final Class<? super T> r11) {
        return new AnonymousClass14(this, r11, r10);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r10) {
        final Type r11 = r10.getType();
        Class<? super T> r12 = r10.getRawType();
        final InstanceCreator<?> r13 = this.instanceCreators.get(r11);
        if (r13 != null) goto L5;
        final InstanceCreator<?> r14 = this.instanceCreators.get(r12);
        if (r14 != null) goto L9;
        ObjectConstructor<T> r15 = newDefaultConstructor(r12);
        if (r15 == null) goto L13;
        return r15;
    L13:
        ObjectConstructor<T> r16 = newDefaultImplementationConstructor(r11, r12);
        if (r16 == null) goto L17;
        return r16;
    L17:
        return newUnsafeAllocator(r11, r12);
    L9:
        return new AnonymousClass2(this, r14, r11);
    L5:
        return new AnonymousClass1(this, r13, r11);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}

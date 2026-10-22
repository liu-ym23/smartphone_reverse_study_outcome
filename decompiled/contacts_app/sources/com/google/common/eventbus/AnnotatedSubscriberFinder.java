package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class AnnotatedSubscriberFinder implements SubscriberFindingStrategy {
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = null;

    private static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        MethodIdentifier(Method r2) {
            this.name = r2.getName();
            this.parameterTypes = Arrays.asList(r2.getParameterTypes());
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.name, this.parameterTypes});
        }

        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof MethodIdentifier) == false) goto L10;
            MethodIdentifier r5 = (MethodIdentifier) r4;
            if (this.name.equals(r5.name) == true) goto L7;
            return false;
        L7:
            if (this.parameterTypes.equals(r5.parameterTypes) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    AnnotatedSubscriberFinder() {
    }

    static /* synthetic */ ImmutableList access$000(Class r0) {
        return getAnnotatedMethodsInternal(r0);
    }

    static {
        subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new AnonymousClass1());
    }

    @Override // com.google.common.eventbus.SubscriberFindingStrategy
    public Multimap<Class<?>, EventSubscriber> findAllSubscribers(Object r5) {
        HashMultimap r4 = HashMultimap.create();
        UnmodifiableIterator<Method> r0 = getAnnotatedMethods(r5.getClass()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Method r1 = r0.next();
        r4.put(r1.getParameterTypes()[0], makeSubscriber(r5, r1));
        goto L4
    L6:
        return r4;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> r1) {
        return subscriberMethodsCache.getUnchecked(r1);
    L4:
        e = move-exception;
        throw Throwables.propagate(e.getCause());
    }

    private static ImmutableList<Method> getAnnotatedMethodsInternal(Class<?> r8) {
        Set r9 = TypeToken.of(r8).getTypes().rawTypes();
        HashMap r0 = Maps.newHashMap();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        Method[] r1 = ((Class) r10.next()).getMethods();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L4;
        Method r4 = r1[r3];
        if (r4.isAnnotationPresent(Subscribe.class) == true) goto L10;
    L18:
        r3 = r3 + 1;
        goto L6
    L10:
        if (r4.isBridge() == true) goto L18;
        Class<?>[] r5 = r4.getParameterTypes();
        if (r5.length != 1) goto L17;
        MethodIdentifier r6 = new MethodIdentifier(r4);
        if (r0.containsKey(r6) == true) goto L18;
        r0.put(r6, r4);
        goto L18
    L17:
        throw new IllegalArgumentException("Method " + r4 + " has @Subscribe annotation, but requires " + r5.length + " arguments.  Event subscriber methods must require a single argument.");
    L20:
        return ImmutableList.copyOf(r0.values());
    }

    private static EventSubscriber makeSubscriber(Object r1, Method r2) {
        if (methodIsDeclaredThreadSafe(r2) == false) goto L6;
        return new EventSubscriber(r1, r2);
    L6:
        return new SynchronizedEventSubscriber(r1, r2);
    }

    private static boolean methodIsDeclaredThreadSafe(Method r1) {
        if (r1.getAnnotation(AllowConcurrentEvents.class) == null) goto L5;
        return true;
    L5:
        return false;
    }
}

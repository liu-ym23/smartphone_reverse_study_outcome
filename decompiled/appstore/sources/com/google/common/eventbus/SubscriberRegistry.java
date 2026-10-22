package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.TypeToken;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
final class SubscriberRegistry {
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> flattenHierarchyCache = null;
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = null;

    @Weak
    private final EventBus bus;
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers;

    public static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        public MethodIdentifier(Method r10) {
            this.name = r10.getName();
            this.parameterTypes = Arrays.asList(r10.getParameterTypes());
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof MethodIdentifier) == false) goto L10;
            MethodIdentifier r11 = (MethodIdentifier) r10;
            if (this.name.equals(r11.name) == true) goto L7;
            return false;
        L7:
            if (this.parameterTypes.equals(r11.parameterTypes) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.name, this.parameterTypes});
        }
    }

    static {
        subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new AnonymousClass1());
        flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new AnonymousClass2());
    }

    public SubscriberRegistry(EventBus r10) {
        this.subscribers = Maps.newConcurrentMap();
        this.bus = (EventBus) Preconditions.checkNotNull(r10);
    }

    public static /* synthetic */ ImmutableList access$000(Class r10) {
        return getAnnotatedMethodsNotCached(r10);
    }

    private Multimap<Class<?>, Subscriber> findAllSubscribers(Object r10) {
        HashMultimap r11 = HashMultimap.create();
        UnmodifiableIterator<Method> r12 = getAnnotatedMethods(r10.getClass()).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Method r13 = r12.next();
        r11.put(r13.getParameterTypes()[0], Subscriber.create(this.bus, r10, r13));
        goto L4
    L6:
        return r11;
    }

    @VisibleForTesting
    public static ImmutableSet<Class<?>> flattenHierarchy(Class<?> r10) {
        return flattenHierarchyCache.getUnchecked(r10);
    L4:
        e = move-exception;
        throw Throwables.propagate(e.getCause());
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> r10) {
        return subscriberMethodsCache.getUnchecked(r10);
    }

    private static ImmutableList<Method> getAnnotatedMethodsNotCached(Class<?> r10) {
        Set r11 = TypeToken.of(r10).getTypes().rawTypes();
        HashMap r12 = Maps.newHashMap();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L20;
        Method[] r14 = ((Class) r13.next()).getDeclaredMethods();
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L4;
        Method r17 = r14[r16];
        if (r17.isAnnotationPresent(Subscribe.class) == true) goto L10;
    L18:
        r16 = r16 + 1;
        goto L6
    L10:
        if (r17.isSynthetic() == true) goto L18;
        Class<?>[] r18 = r17.getParameterTypes();
        boolean r19 = true;
        if (r18.length == 1) goto L15;
        r19 = false;
    L15:
        Preconditions.checkArgument(r19, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", r17, r18.length);
        MethodIdentifier r20 = new MethodIdentifier(r17);
        if (r12.containsKey(r20) == true) goto L18;
        r12.put(r20, r17);
        goto L18
    L20:
        return ImmutableList.copyOf(r12.values());
    }

    public Iterator<Subscriber> getSubscribers(Object r10) {
        ImmutableSet<Class<?>> r11 = flattenHierarchy(r10.getClass());
        ArrayList r12 = Lists.newArrayListWithCapacity(r11.size());
        UnmodifiableIterator<Class<?>> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Class<?> r14 = r13.next();
        CopyOnWriteArraySet<Subscriber> r15 = this.subscribers.get(r14);
        if (r15 == null) goto L4;
        r12.add(r15.iterator());
        goto L4
    L9:
        return Iterators.concat(r12.iterator());
    }

    @VisibleForTesting
    public Set<Subscriber> getSubscribersForTesting(Class<?> r10) {
        return (Set) MoreObjects.firstNonNull(this.subscribers.get(r10), ImmutableSet.of());
    }

    public void register(Object r10) {
        Iterator<Map.Entry<Class<?>, Collection<Subscriber>>> r11 = findAllSubscribers(r10).asMap().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Class<?>, Collection<Subscriber>> r12 = r11.next();
        Class<?> r13 = r12.getKey();
        Collection<Subscriber> r14 = r12.getValue();
        CopyOnWriteArraySet<Subscriber> r15 = this.subscribers.get(r13);
        if (r15 != null) goto L8;
        CopyOnWriteArraySet<Subscriber> r16 = new CopyOnWriteArraySet();
        r15 = (CopyOnWriteArraySet) MoreObjects.firstNonNull(this.subscribers.putIfAbsent(r13, r16), r16);
    L8:
        r15.addAll(r14);
        goto L4
    }

    public void unregister(Object r10) {
        Iterator<Map.Entry<Class<?>, Collection<Subscriber>>> r11 = findAllSubscribers(r10).asMap().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<Class<?>, Collection<Subscriber>> r12 = r11.next();
        Class<?> r13 = r12.getKey();
        Collection<Subscriber> r14 = r12.getValue();
        CopyOnWriteArraySet<Subscriber> r15 = this.subscribers.get(r13);
        if (r15 == null) goto L11;
        if (r15.removeAll(r14) == true) goto L4;
    L11:
        throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + r10 + " registered?");
    }
}

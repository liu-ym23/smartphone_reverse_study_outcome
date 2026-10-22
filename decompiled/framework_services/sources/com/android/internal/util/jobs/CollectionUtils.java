package com.android.internal.util.jobs;

import android.Manifest;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.ExceptionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> boolean contains(Collection<T> collection, T element) {
        if (collection != null) goto L4;
    L6:
        return false;
    L4:
        if (collection.contains(element) == false) goto L6;
        return true;
    }

    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        ArrayList<T> result = null;
        int i = 0;
    L4:
        if (i >= size(list)) goto L10;
        T item = list.get(i);
        if (predicate.test(item) == false) goto L8;
        result = ArrayUtils.add(result, item);
    L8:
        i = i + 1;
        goto L4
    L10:
        return emptyIfNull(result);
    }

    public static <T> Set<T> filter(Set<T> r6, Predicate<? super T> r7) {
        if (r6 == null) goto L25;
        if (r6.size() == 0) goto L25;
        ArraySet<T> r0 = null;
        if ((r6 instanceof ArraySet) == false) goto L15;
        ArraySet r1 = (ArraySet) r6;
        int r2 = r1.size();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L23;
        Manifest.permission r4 = (T) r1.valueAt(r3);
        if (r7.test(r4) == false) goto L13;
        r0 = ArrayUtils.add(r0, r4);
    L13:
        r3 = r3 + 1;
    L23:
        return emptyIfNull(r0);
    L15:
        Iterator<T> r5 = r6.iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        Object r8 = r5.next();
        if (r7.test(r8) == false) goto L17;
        r0 = ArrayUtils.add(r0, r8);
    L25:
        return Collections.emptySet();
    }

    public static <T> void addIf(List<T> source, Collection<? super T> dest, Predicate<? super T> predicate) {
        int i = 0;
    L4:
        if (i >= size(source)) goto L10;
        T item = source.get(i);
        if (predicate.test(item) == false) goto L8;
        dest.add(item);
    L8:
        i = i + 1;
        goto L4
    }

    public static <I, O> List<O> map(List<I> cur, Function<? super I, ? extends O> f) {
        if (isEmpty(cur) == true) goto L5;
        int size = cur.size();
        ArrayList<O> result = new ArrayList(size);
        int i = 0;
    L7:
        if (i >= size) goto L10;
        result.add(f.apply(cur.get(i)));
        i = i + 1;
        goto L7
    L10:
        return result;
    L5:
        return Collections.emptyList();
    }

    public static <I, O> Set<O> map(Set<I> r5, Function<? super I, ? extends O> r6) {
        if (isEmpty(r5) == true) goto L5;
        ArraySet r0 = new ArraySet(r5.size());
        if ((r5 instanceof ArraySet) == false) goto L12;
        ArraySet r1 = (ArraySet) r5;
        int r2 = r1.size();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L16;
        r0.add(r6.apply((I) r1.valueAt(r3)));
        r3 = r3 + 1;
    L16:
        return r0;
    L12:
        Iterator<I> r4 = r5.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        r0.add(r6.apply(r4.next()));
        goto L14
    L5:
        return Collections.emptySet();
    }

    public static <I, O> List<O> mapNotNull(List<I> cur, Function<? super I, ? extends O> f) {
        if (isEmpty(cur) == true) goto L5;
        List<O> result = null;
        int i = 0;
        int size = cur.size();
    L7:
        if (i >= size) goto L13;
        O transformed = f.apply(cur.get(i));
        if (transformed == null) goto L11;
        result = add(result, transformed);
    L11:
        i = i + 1;
        goto L7
    L13:
        return emptyIfNull(result);
    L5:
        return Collections.emptyList();
    }

    public static <T> List<T> emptyIfNull(List<T> cur) {
        if (cur != null) goto L5;
        return Collections.emptyList();
    L5:
        return cur;
    }

    public static <T> Set<T> emptyIfNull(Set<T> cur) {
        if (cur != null) goto L5;
        return Collections.emptySet();
    L5:
        return cur;
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> cur) {
        if (cur != null) goto L5;
        return Collections.emptyMap();
    L5:
        return cur;
    }

    public static int size(Collection<?> cur) {
        if (cur != null) goto L6;
        return 0;
    L6:
        return cur.size();
    }

    public static int size(Map<?, ?> cur) {
        if (cur != null) goto L6;
        return 0;
    L6:
        return cur.size();
    }

    public static boolean isEmpty(Collection<?> cur) {
        if (size(cur) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isEmpty(Map<?, ?> cur) {
        if (size(cur) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> List<T> filter(List<?> list, Class<T> c) {
        if (isEmpty(list) == true) goto L5;
        ArrayList<T> result = null;
        int i = 0;
        int size = list.size();
    L7:
        if (i >= size) goto L13;
        Object item = list.get(i);
        if (c.isInstance(item) == false) goto L11;
        result = ArrayUtils.add(result, item);
    L11:
        i = i + 1;
        goto L7
    L13:
        return emptyIfNull(result);
    L5:
        return Collections.emptyList();
    }

    public static <T> boolean any(List<T> items, Predicate<T> predicate) {
        if (find(items, predicate) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> boolean any(Set<T> items, Predicate<T> predicate) {
        if (find(items, predicate) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> T find(List<T> items, Predicate<T> predicate) {
        if (isEmpty(items) == false) goto L5;
        return null;
    L5:
        int i = 0;
        int size = items.size();
    L6:
        if (i >= size) goto L12;
        T item = items.get(i);
        if (predicate.test(item) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return item;
    L12:
        return null;
    }

    public static <T> T find(Set<T> cur, Predicate<T> r7) {
        if (cur == null) goto L31;
        if (r7 == null) goto L31;
        int size = cur.size();
        if (size != 0) goto L32;
        return null;
    L32:
    L17:
        e = move-exception;
        throw ExceptionUtils.propagate(e);
    L10:
        if ((cur instanceof ArraySet) == false) goto L20;
        ArraySet<T> arraySet = (ArraySet) cur;     // Catch: Exception -> L17
        int i = 0;
    L12:
        if (i >= size) goto L28;
        T item = arraySet.valueAt(i);     // Catch: Exception -> L17
        if (r7.test(item) == true) goto L15;
        i = i + 1;     // Catch: Exception -> L17
        goto L12
    L15:
        return item;
    L28:
        return null;
    L20:
        Iterator<T> r2 = cur.iterator();     // Catch: Exception -> L17
    L22:
        if (r2.hasNext() == false) goto L28;
        T t = r2.next();     // Catch: Exception -> L17
        if (r7.test(t) == false) goto L22;
        return t;
    L31:
        return null;
    }

    public static <T> List<T> add(List<T> cur, T val) {
        if (cur != null) goto L4;
    L5:
        cur = new ArrayList();
    L6:
        cur.add(val);
        return cur;
    L4:
        if (cur != Collections.emptyList()) goto L6;
        goto L5
    }

    public static <T> List<T> add(List<T> cur, int index, T val) {
        if (cur != null) goto L4;
    L5:
        cur = new ArrayList();
    L6:
        cur.add(index, val);
        return cur;
    L4:
        if (cur != Collections.emptyList()) goto L6;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Set<T> addAll(Set<T> cur, Collection<T> r2) {
        if (isEmpty(r2) == false) goto L8;
        if (cur == null) goto L7;
        return cur;
    L7:
        return Collections.emptySet();
    L8:
        if (cur != null) goto L10;
    L11:
        cur = new ArraySet();
    L12:
        cur.addAll(r2);
        return cur;
    L10:
        if (cur != Collections.emptySet()) goto L12;
        goto L11
    }

    public static <T> Set<T> add(Set<T> cur, T val) {
        if (cur != null) goto L4;
    L5:
        cur = new ArraySet();
    L6:
        cur.add(val);
        return cur;
    L4:
        if (cur != Collections.emptySet()) goto L6;
        goto L5
    }

    public static <K, V> Map<K, V> add(Map<K, V> map, K key, V value) {
        if (map != null) goto L4;
    L5:
        map = new ArrayMap();
    L6:
        map.put(key, value);
        return map;
    L4:
        if (map != Collections.emptyMap()) goto L6;
        goto L5
    }

    public static <T> List<T> remove(List<T> cur, T val) {
        if (isEmpty(cur) == true) goto L5;
        cur.remove(val);
        return cur;
    L5:
        return emptyIfNull(cur);
    }

    public static <T> Set<T> remove(Set<T> cur, T val) {
        if (isEmpty(cur) == true) goto L5;
        cur.remove(val);
        return cur;
    L5:
        return emptyIfNull(cur);
    }

    public static <T> List<T> copyOf(List<T> cur) {
        if (isEmpty(cur) == false) goto L6;
        return Collections.emptyList();
    L6:
        return new ArrayList(cur);
    }

    public static <T> Set<T> copyOf(Set<T> cur) {
        if (isEmpty(cur) == false) goto L6;
        return Collections.emptySet();
    L6:
        return new ArraySet(cur);
    }

    public static <T> Set<T> toSet(Collection<T> cur) {
        if (isEmpty(cur) == false) goto L6;
        return Collections.emptySet();
    L6:
        return new ArraySet(cur);
    }

    public static <T> void forEach(Set<T> cur, FunctionalUtils.ThrowingConsumer<T> r5) {
        if (cur == null) goto L25;
        if (r5 == null) goto L30;
        int size = cur.size();
        if (size != 0) goto L26;
        return;
    L26:
    L13:
        e = move-exception;
        throw ExceptionUtils.propagate(e);
    L9:
        if ((cur instanceof ArraySet) == false) goto L16;
        ArraySet<T> arraySet = (ArraySet) cur;     // Catch: Exception -> L13
        int i = 0;
    L11:
        if (i >= size) goto L22;
        r5.acceptOrThrow(arraySet.valueAt(i));     // Catch: Exception -> L13
        i = i + 1;     // Catch: Exception -> L13
        goto L11
    L22:
        return;
    L16:
        Iterator<T> r1 = cur.iterator();     // Catch: Exception -> L13
    L18:
        if (r1.hasNext() == false) goto L29;
        T t = r1.next();     // Catch: Exception -> L13
        r5.acceptOrThrow(t);     // Catch: Exception -> L13
        goto L18
    L29:
        return;
    L30:
        return;
    }

    public static <K, V> void forEach(Map<K, V> cur, BiConsumer<K, V> r6) {
        if (cur == null) goto L19;
        if (r6 == null) goto L23;
        int size = cur.size();
        if (size != 0) goto L9;
        return;
    L9:
        if ((cur instanceof ArrayMap) == false) goto L14;
        ArrayMap<K, V> arrayMap = (ArrayMap) cur;
        int i = 0;
    L11:
        if (i >= size) goto L18;
        r6.accept(arrayMap.keyAt(i), arrayMap.valueAt(i));
        i = i + 1;
        goto L11
    L18:
        return;
    L14:
        Iterator<K> r1 = cur.keySet().iterator();
    L16:
        if (r1.hasNext() == false) goto L22;
        K key = r1.next();
        r6.accept(key, cur.get(key));
        goto L16
    L22:
        return;
    L23:
        return;
    }

    public static <T> T firstOrNull(List<T> cur) {
        if (isEmpty(cur) == false) goto L6;
        return null;
    L6:
        return cur.get(0);
    }

    public static <T> T firstOrNull(Collection<T> cur) {
        if (isEmpty(cur) == false) goto L6;
        return null;
    L6:
        return cur.iterator().next();
    }

    public static <T> List<T> singletonOrEmpty(T item) {
        if (item != null) goto L5;
        return Collections.emptyList();
    L5:
        return Collections.singletonList(item);
    }
}

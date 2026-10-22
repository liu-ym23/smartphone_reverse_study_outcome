package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
final class Platform {
    private Platform() {
    }

    public static <T> T[] copy(Object[] r10, int r11, int r12, T[] r13) {
        return (T[]) Arrays.copyOfRange(r10, r11, r12, r13.getClass());
    }

    public static <T> T[] newArray(T[] r10, int r11) {
        return (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r11));
    }

    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int r10) {
        return CompactHashMap.createWithExpectedSize(r10);
    }

    public static <E> Set<E> newHashSetWithExpectedSize(int r10) {
        return CompactHashSet.createWithExpectedSize(r10);
    }

    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int r10) {
        return CompactLinkedHashMap.createWithExpectedSize(r10);
    }

    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int r10) {
        return CompactLinkedHashSet.createWithExpectedSize(r10);
    }

    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static int reduceExponentIfGwt(int r10) {
        return r10;
    }

    public static int reduceIterationsIfGwt(int r10) {
        return r10;
    }

    public static MapMaker tryWeakKeys(MapMaker r10) {
        return r10.weakKeys();
    }
}

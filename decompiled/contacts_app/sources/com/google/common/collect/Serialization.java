package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class Serialization {

    /* JADX INFO: renamed from: com.google.common.collect.Serialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class FieldSetter<T> {
        private final Field field;

        /* synthetic */ FieldSetter(Field r1, AnonymousClass1 r2) {
            this(r1);
        }

        private FieldSetter(Field r1) {
            this.field = r1;
            r1.setAccessible(true);
        }

        void set(T r1, Object r2) {
            this.field.set(r1, r2);     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        void set(T r1, int r2) {
            this.field.set(r1, Integer.valueOf(r2));     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    private Serialization() {
    }

    static int readCount(ObjectInputStream r0) throws IOException {
        return r0.readInt();
    }

    static <K, V> void writeMap(Map<K, V> r2, ObjectOutputStream r3) throws IOException {
        r3.writeInt(r2.size());
        Iterator<Map.Entry<K, V>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<K, V> r0 = r4.next();
        r3.writeObject(r0.getKey());
        r3.writeObject(r0.getValue());
        goto L4
    }

    static <K, V> void populateMap(Map<K, V> r1, ObjectInputStream r2) throws IOException, ClassNotFoundException {
        populateMap(r1, r2, r2.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void populateMap(Map<K, V> r3, ObjectInputStream r4, int r5) throws IOException, ClassNotFoundException {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.put(r4.readObject(), r4.readObject());
        r0 = r0 + 1;
        goto L3
    }

    static <E> void writeMultiset(Multiset<E> r2, ObjectOutputStream r3) throws IOException {
        r3.writeInt(r2.entrySet().size());
        Iterator<Multiset.Entry<E>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Multiset.Entry<E> r0 = r4.next();
        r3.writeObject(r0.getElement());
        r3.writeInt(r0.getCount());
        goto L4
    }

    static <E> void populateMultiset(Multiset<E> r1, ObjectInputStream r2) throws IOException, ClassNotFoundException {
        populateMultiset(r1, r2, r2.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> void populateMultiset(Multiset<E> r3, ObjectInputStream r4, int r5) throws IOException, ClassNotFoundException {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.add(r4.readObject(), r4.readInt());
        r0 = r0 + 1;
        goto L3
    }

    static <K, V> void writeMultimap(Multimap<K, V> r2, ObjectOutputStream r3) throws IOException {
        r3.writeInt(r2.asMap().size());
        Iterator<Map.Entry<K, Collection<V>>> r4 = r2.asMap().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<K, Collection<V>> r0 = r4.next();
        r3.writeObject(r0.getKey());
        r3.writeInt(r0.getValue().size());
        Iterator<V> r1 = r0.getValue().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        r3.writeObject(r1.next());
        goto L7
    }

    static <K, V> void populateMultimap(Multimap<K, V> r1, ObjectInputStream r2) throws IOException, ClassNotFoundException {
        populateMultimap(r1, r2, r2.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void populateMultimap(Multimap<K, V> r6, ObjectInputStream r7, int r8) throws IOException, ClassNotFoundException {
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        Collection r2 = r6.get(r7.readObject());
        int r3 = r7.readInt();
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r2.add(r7.readObject());
        r4 = r4 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    }

    static <T> FieldSetter<T> getFieldSetter(Class<T> r1, String r2) {
        return new FieldSetter(r1.getDeclaredField(r2), null);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}

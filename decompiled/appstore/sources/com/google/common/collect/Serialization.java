package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class Serialization {

    /* JADX INFO: renamed from: com.google.common.collect.Serialization$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class FieldSetter<T> {
        private final Field field;

        public /* synthetic */ FieldSetter(Field r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void set(T r10, Object r11) {
            this.field.set(r10, r11);     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        private FieldSetter(Field r10) {
            this.field = r10;
            r10.setAccessible(true);
        }

        public void set(T r10, int r11) {
            this.field.set(r10, Integer.valueOf(r11));     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    private Serialization() {
    }

    public static <T> FieldSetter<T> getFieldSetter(Class<T> r10, String r11) {
        return new FieldSetter(r10.getDeclaredField(r11), null);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static <K, V> void populateMap(Map<K, V> r10, ObjectInputStream r11) throws IOException, ClassNotFoundException {
        populateMap(r10, r11, r11.readInt());
    }

    public static <K, V> void populateMultimap(Multimap<K, V> r10, ObjectInputStream r11) throws IOException, ClassNotFoundException {
        populateMultimap(r10, r11, r11.readInt());
    }

    public static <E> void populateMultiset(Multiset<E> r10, ObjectInputStream r11) throws IOException, ClassNotFoundException {
        populateMultiset(r10, r11, r11.readInt());
    }

    public static int readCount(ObjectInputStream r10) throws IOException {
        return r10.readInt();
    }

    public static <K, V> void writeMap(Map<K, V> r10, ObjectOutputStream r11) throws IOException {
        r11.writeInt(r10.size());
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<K, V> r13 = r12.next();
        r11.writeObject(r13.getKey());
        r11.writeObject(r13.getValue());
        goto L4
    }

    public static <K, V> void writeMultimap(Multimap<K, V> r10, ObjectOutputStream r11) throws IOException {
        r11.writeInt(r10.asMap().size());
        Iterator<Map.Entry<K, Collection<V>>> r12 = r10.asMap().entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<K, Collection<V>> r13 = r12.next();
        r11.writeObject(r13.getKey());
        r11.writeInt(r13.getValue().size());
        Iterator<V> r14 = r13.getValue().iterator();
    L7:
        if (r14.hasNext() == false) goto L4;
        r11.writeObject(r14.next());
        goto L7
    }

    public static <E> void writeMultiset(Multiset<E> r10, ObjectOutputStream r11) throws IOException {
        r11.writeInt(r10.entrySet().size());
        Iterator<Multiset.Entry<E>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Multiset.Entry<E> r13 = r12.next();
        r11.writeObject(r13.getElement());
        r11.writeInt(r13.getCount());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void populateMap(Map<K, V> r10, ObjectInputStream r11, int r12) throws IOException, ClassNotFoundException {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.put(r11.readObject(), r11.readObject());
        r13 = r13 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void populateMultimap(Multimap<K, V> r10, ObjectInputStream r11, int r12) throws IOException, ClassNotFoundException {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Collection r14 = r10.get(r11.readObject());
        int r15 = r11.readInt();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L7;
        r14.add(r11.readObject());
        r16 = r16 + 1;
        goto L5
    L7:
        r13 = r13 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void populateMultiset(Multiset<E> r10, ObjectInputStream r11, int r12) throws IOException, ClassNotFoundException {
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10.add(r11.readObject(), r11.readInt());
        r13 = r13 + 1;
        goto L3
    }
}

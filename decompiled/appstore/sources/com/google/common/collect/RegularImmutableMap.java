package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = null;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;

    @VisibleForTesting
    final transient Object[] alternatingKeysAndValues;
    private final transient Object hashTable;
    private final transient int size;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        public EntrySet(ImmutableMap<K, V> r10, Object[] r11, int r12, int r13) {
            this.map = r10;
            this.alternatingKeysAndValues = r11;
            this.keyOffset = r12;
            this.size = r13;
        }

        public static /* synthetic */ int access$000(EntrySet r10) {
            return r10.size;
        }

        public static /* synthetic */ Object[] access$100(EntrySet r10) {
            return r10.alternatingKeysAndValues;
        }

        public static /* synthetic */ int access$200(EntrySet r10) {
            return r10.keyOffset;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L10;
            Map.Entry r11 = (Map.Entry) r10;
            Object r12 = r11.getKey();
            Object r13 = r11.getValue();
            if (r13 != null) goto L7;
            return false;
        L7:
            if (r13.equals(this.map.get(r12)) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r10, int r11) {
            return asList().copyIntoArray(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        public KeySet(ImmutableMap<K, ?> r10, ImmutableList<K> r11) {
            this.map = r10;
            this.list = r11;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if (this.map.get(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r10, int r11) {
            return asList().copyIntoArray(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        public KeysOrValuesAsList(Object[] r10, int r11, int r12) {
            this.alternatingKeysAndValues = r10;
            this.offset = r11;
            this.size = r12;
        }

        @Override // java.util.List
        public Object get(int r10) {
            Preconditions.checkElementIndex(r10, this.size);
            return this.alternatingKeysAndValues[(r10 * 2) + this.offset];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    static {
        EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    }

    private RegularImmutableMap(Object r10, Object[] r11, int r12) {
        this.hashTable = r10;
        this.alternatingKeysAndValues = r11;
        this.size = r12;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int r10, Object[] r11) {
        if (r10 != 0) goto L6;
        return (RegularImmutableMap) EMPTY;
    L6:
        if (r10 != 1) goto L9;
        CollectPreconditions.checkEntryNotNull(r11[0], r11[1]);
        return new RegularImmutableMap(null, r11, 1);
    L9:
        Preconditions.checkPositionIndex(r10, r11.length >> 1);
        return new RegularImmutableMap(createHashTable(r11, r10, ImmutableSet.chooseTableSize(r10), 0), r11, r10);
    }

    public static Object createHashTable(Object[] r10, int r11, int r12, int r13) {
        if (r11 != 1) goto L6;
        CollectPreconditions.checkEntryNotNull(r10[r13], r10[r13 ^ 1]);
        return null;
    L6:
        int r14 = r12 - 1;
        int r15 = 0;
        if (r12 > 128) goto L21;
        byte[] r16 = new byte[r12];
        Arrays.fill(r16, (byte) -1);
    L9:
        if (r15 >= r11) goto L19;
        int r17 = (r15 * 2) + r13;
        Object r18 = r10[r17];
        Object r19 = r10[r17 ^ 1];
        CollectPreconditions.checkEntryNotNull(r18, r19);
        int r20 = Hashing.smear(r18.hashCode());
    L11:
        int r21 = r20 & r14;
        int r22 = r16[r21] & 255;
        if (r22 == 255) goto L13;
        if (r10[r22].equals(r18) == true) goto L18;
        r20 = r21 + 1;
        goto L11
    L18:
        throw duplicateKeyException(r18, r19, r10, r22);
    L13:
        r16[r21] = (byte) r17;
        r15 = r15 + 1;
        goto L9
    L19:
        return r16;
    L21:
        if (r12 > 32768) goto L34;
        short[] r110 = new short[r12];
        Arrays.fill(r110, -1);
    L23:
        if (r15 >= r11) goto L33;
        int r23 = (r15 * 2) + r13;
        Object r24 = r10[r23];
        Object r25 = r10[r23 ^ 1];
        CollectPreconditions.checkEntryNotNull(r24, r25);
        int r26 = Hashing.smear(r24.hashCode());
    L25:
        int r27 = r26 & r14;
        int r28 = r110[r27] & 65535;
        if (r28 == 65535) goto L27;
        if (r10[r28].equals(r24) == true) goto L32;
        r26 = r27 + 1;
        goto L25
    L32:
        throw duplicateKeyException(r24, r25, r10, r28);
    L27:
        r110[r27] = (short) r23;
        r15 = r15 + 1;
        goto L23
    L33:
        return r110;
    L34:
        int[] r111 = new int[r12];
        Arrays.fill(r111, -1);
    L35:
        if (r15 >= r11) goto L45;
        int r29 = (r15 * 2) + r13;
        Object r30 = r10[r29];
        Object r31 = r10[r29 ^ 1];
        CollectPreconditions.checkEntryNotNull(r30, r31);
        int r32 = Hashing.smear(r30.hashCode());
    L37:
        int r33 = r32 & r14;
        int r34 = r111[r33];
        if (r34 == (-1)) goto L39;
        if (r10[r34].equals(r30) == true) goto L44;
        r32 = r33 + 1;
        goto L37
    L44:
        throw duplicateKeyException(r30, r31, r10, r34);
    L39:
        r111[r33] = r29;
        r15 = r15 + 1;
        goto L35
    L45:
        return r111;
    }

    private static IllegalArgumentException duplicateKeyException(Object r10, Object r11, Object[] r12, int r13) {
        return new IllegalArgumentException("Multiple entries with same key: " + r10 + "=" + r11 + " and " + r12[r13] + "=" + r12[r13 ^ 1]);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object r10) {
        return (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, r10);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    public static Object get(@NullableDecl Object r10, @NullableDecl Object[] r11, int r12, int r13, @NullableDecl Object r14) {
        if (r14 != null) goto L6;
        return null;
    L6:
        if (r12 == 1) goto L8;
        if (r10 != null) goto L14;
        return null;
    L14:
        if ((r10 instanceof byte[]) == false) goto L25;
        byte[] r15 = (byte[]) r10;
        int r16 = r15.length - 1;
        int r17 = Hashing.smear(r14.hashCode());
    L16:
        int r18 = r17 & r16;
        int r19 = r15[r18] & 255;
        if (r19 == 255) goto L18;
        if (r11[r19].equals(r14) == true) goto L22;
        r17 = r18 + 1;
        goto L16
    L22:
        return r11[r19 ^ 1];
    L18:
        return null;
    L25:
        if ((r10 instanceof short[]) == false) goto L35;
        short[] r20 = (short[]) r10;
        int r21 = r20.length - 1;
        int r22 = Hashing.smear(r14.hashCode());
    L27:
        int r23 = r22 & r21;
        int r24 = r20[r23] & 65535;
        if (r24 == 65535) goto L29;
        if (r11[r24].equals(r14) == true) goto L33;
        r22 = r23 + 1;
        goto L27
    L33:
        return r11[r24 ^ 1];
    L29:
        return null;
    L35:
        int[] r25 = (int[]) r10;
        int r26 = r25.length - 1;
        int r27 = Hashing.smear(r14.hashCode());
    L36:
        int r28 = r27 & r26;
        int r29 = r25[r28];
        if (r29 == (-1)) goto L38;
        if (r11[r29].equals(r14) == true) goto L42;
        r27 = r28 + 1;
        goto L36
    L42:
        return r11[r29 ^ 1];
    L38:
        return null;
    L8:
        if (r11[r13].equals(r14) == true) goto L10;
        return null;
    L10:
        return r11[r13 ^ 1];
    }
}

package org.apache.commons.math.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.apache.commons.math.Field;
import org.apache.commons.math.FieldElement;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class OpenIntToFieldHashMap<T extends FieldElement<T>> implements Serializable {
    private static final int DEFAULT_EXPECTED_SIZE = 16;
    protected static final byte FREE = 0;
    protected static final byte FULL = 1;
    private static final float LOAD_FACTOR = 0.5f;
    private static final int PERTURB_SHIFT = 5;
    protected static final byte REMOVED = 2;
    private static final int RESIZE_MULTIPLIER = 2;
    private static final long serialVersionUID = -9179080286849120720L;
    private transient int count;
    private final Field<T> field;
    private int[] keys;
    private int mask;
    private final T missingEntries;
    private int size;
    private byte[] states;
    private T[] values;

    /* JADX INFO: renamed from: org.apache.commons.math.util.OpenIntToFieldHashMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public class Iterator {
        private int current;
        private int next;
        private final int referenceCount;
        final /* synthetic */ OpenIntToFieldHashMap this$0;

        /* synthetic */ Iterator(OpenIntToFieldHashMap x0, AnonymousClass1 x1) {
            this(x0);
        }

        private Iterator(OpenIntToFieldHashMap this$0) {
            this.this$0 = this$0;
            this.referenceCount = OpenIntToFieldHashMap.access$100(this$0);
            this.next = -1;
            advance();     // Catch: NoSuchElementException -> L5
            return;
        }

        public boolean hasNext() {
            if (this.next < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int key() throws ConcurrentModificationException, NoSuchElementException {
            if (this.referenceCount != OpenIntToFieldHashMap.access$100(this.this$0)) goto L11;
            if (this.current < 0) goto L9;
            return OpenIntToFieldHashMap.access$200(this.this$0)[this.current];
        L9:
            throw MathRuntimeException.createNoSuchElementException(LocalizedFormats.ITERATOR_EXHAUSTED, new Object[0]);
        L11:
            throw MathRuntimeException.createConcurrentModificationException(LocalizedFormats.MAP_MODIFIED_WHILE_ITERATING, new Object[0]);
        }

        public T value() throws ConcurrentModificationException, NoSuchElementException {
            if (this.referenceCount != OpenIntToFieldHashMap.access$100(this.this$0)) goto L11;
            if (this.current < 0) goto L9;
            return (T) OpenIntToFieldHashMap.access$300(this.this$0)[this.current];
        L9:
            throw MathRuntimeException.createNoSuchElementException(LocalizedFormats.ITERATOR_EXHAUSTED, new Object[0]);
        L11:
            throw MathRuntimeException.createConcurrentModificationException(LocalizedFormats.MAP_MODIFIED_WHILE_ITERATING, new Object[0]);
        }

        public void advance() throws ConcurrentModificationException, NoSuchElementException {
            if (this.referenceCount != OpenIntToFieldHashMap.access$100(this.this$0)) goto L16;
            this.current = this.next;
        L17:
            byte[] r0 = OpenIntToFieldHashMap.access$400(this.this$0);     // Catch: ArrayIndexOutOfBoundsException -> L9
            int r1 = this.next + 1;     // Catch: ArrayIndexOutOfBoundsException -> L9
            this.next = r1;     // Catch: ArrayIndexOutOfBoundsException -> L9
            if (r0[r1] != 1) goto L17;
            return;
        L10:
            this.next = -2;
            if (this.current < 0) goto L14;
            return;
        L14:
            throw MathRuntimeException.createNoSuchElementException(LocalizedFormats.ITERATOR_EXHAUSTED, new Object[0]);
        L16:
            throw MathRuntimeException.createConcurrentModificationException(LocalizedFormats.MAP_MODIFIED_WHILE_ITERATING, new Object[0]);
        }
    }

    static /* synthetic */ int access$100(OpenIntToFieldHashMap x0) {
        return x0.count;
    }

    static /* synthetic */ int[] access$200(OpenIntToFieldHashMap x0) {
        return x0.keys;
    }

    static /* synthetic */ FieldElement[] access$300(OpenIntToFieldHashMap x0) {
        return x0.values;
    }

    static /* synthetic */ byte[] access$400(OpenIntToFieldHashMap x0) {
        return x0.states;
    }

    public OpenIntToFieldHashMap(Field<T> field) {
        this(field, 16, field.getZero());
    }

    public OpenIntToFieldHashMap(Field<T> field, T missingEntries) {
        this(field, 16, missingEntries);
    }

    public OpenIntToFieldHashMap(Field<T> field, int expectedSize) {
        this(field, expectedSize, field.getZero());
    }

    public OpenIntToFieldHashMap(Field<T> r3, int r4, T r5) {
        this.field = r3;
        int r0 = computeCapacity(r4);
        this.keys = new int[r0];
        this.values = (T[]) buildArray(r0);
        this.states = new byte[r0];
        this.missingEntries = r5;
        this.mask = r0 - 1;
    }

    public OpenIntToFieldHashMap(OpenIntToFieldHashMap<T> r5) {
        this.field = r5.field;
        int r0 = r5.keys.length;
        this.keys = new int[r0];
        System.arraycopy(r5.keys, 0, this.keys, 0, r0);
        this.values = (T[]) buildArray(r0);
        System.arraycopy(r5.values, 0, this.values, 0, r0);
        this.states = new byte[r0];
        System.arraycopy(r5.states, 0, this.states, 0, r0);
        this.missingEntries = r5.missingEntries;
        this.size = r5.size;
        this.mask = r5.mask;
        this.count = r5.count;
    }

    private static int computeCapacity(int expectedSize) {
        if (expectedSize != 0) goto L5;
        return 1;
    L5:
        int capacity = (int) FastMath.ceil(expectedSize / LOAD_FACTOR);
        int powerOfTwo = Integer.highestOneBit(capacity);
        if (powerOfTwo != capacity) goto L9;
        return capacity;
    L9:
        return nextPowerOfTwo(capacity);
    }

    private static int nextPowerOfTwo(int i) {
        return Integer.highestOneBit(i) << 1;
    }

    public T get(int key) {
        int hash = hashOf(key);
        int index = this.mask & hash;
        if (containsKey(key, index) == false) goto L7;
        return this.values[index];
    L7:
        if (this.states[index] == 0) goto L9;
        int j = index;
        int perturb = perturb(hash);
    L12:
        if (this.states[index] == 0) goto L19;
        j = probe(perturb, j);
        index = j & this.mask;
        if (containsKey(key, index) == true) goto L16;
        perturb = perturb >> 5;
        goto L12
    L16:
        return this.values[index];
    L19:
        return this.missingEntries;
    L9:
        return this.missingEntries;
    }

    public boolean containsKey(int key) {
        int hash = hashOf(key);
        int index = this.mask & hash;
        if (containsKey(key, index) == false) goto L6;
        return true;
    L6:
        if (this.states[index] != 0) goto L8;
        return false;
    L8:
        int j = index;
        int perturb = perturb(hash);
    L10:
        if (this.states[index] == 0) goto L16;
        j = probe(perturb, j);
        index = j & this.mask;
        if (containsKey(key, index) == true) goto L13;
        perturb = perturb >> 5;
        goto L10
    L13:
        return true;
    L16:
        return false;
    }

    public OpenIntToFieldHashMap<T>.Iterator iterator() {
        return new Iterator(this, null);
    }

    private static int perturb(int hash) {
        return Integer.MAX_VALUE & hash;
    }

    private int findInsertionIndex(int key) {
        return findInsertionIndex(this.keys, this.states, key, this.mask);
    }

    private static int findInsertionIndex(int[] keys, byte[] states, int key, int mask) {
        int hash = hashOf(key);
        int index = hash & mask;
        if (states[index] != 0) goto L6;
        return index;
    L6:
        if (states[index] == 1) goto L8;
    L11:
        int perturb = perturb(hash);
        int j = index;
        if (states[index] != 1) goto L18;
    L13:
        j = probe(perturb, j);
        index = j & mask;
        perturb = perturb >> 5;
        if (states[index] != 1) goto L18;
        if (keys[index] != key) goto L13;
    L18:
        if (states[index] != 0) goto L21;
        return index;
    L21:
        if (states[index] == 1) goto L23;
        int firstRemoved = index;
    L25:
        j = probe(perturb, j);
        int index2 = j & mask;
        if (states[index2] == 0) goto L27;
        if (states[index2] != 1) goto L34;
        if (keys[index2] != key) goto L34;
        return changeIndexSign(index2);
    L34:
        perturb = perturb >> 5;
        goto L25
    L27:
        return firstRemoved;
    L23:
        return changeIndexSign(index);
    L8:
        if (keys[index] != key) goto L11;
        return changeIndexSign(index);
    }

    private static int probe(int perturb, int j) {
        return (((j << 2) + j) + perturb) + 1;
    }

    private static int changeIndexSign(int index) {
        return (-index) - 1;
    }

    public int size() {
        return this.size;
    }

    public T remove(int r6) {
        int r0 = hashOf(r6);
        int r1 = this.mask & r0;
        if (containsKey(r6, r1) == false) goto L7;
        return (T) doRemove(r1);
    L7:
        if (this.states[r1] == 0) goto L9;
        int r2 = r1;
        int r3 = perturb(r0);
    L12:
        if (this.states[r1] == 0) goto L19;
        r2 = probe(r3, r2);
        r1 = r2 & this.mask;
        if (containsKey(r6, r1) == true) goto L16;
        r3 = r3 >> 5;
        goto L12
    L16:
        return (T) doRemove(r1);
    L19:
        return this.missingEntries;
    L9:
        return this.missingEntries;
    }

    private boolean containsKey(int key, int index) {
        if (key != 0) goto L7;
        if (this.states[index] == 1) goto L7;
    L9:
        return false;
    L7:
        if (this.keys[index] != key) goto L9;
        return true;
    }

    private T doRemove(int index) {
        this.keys[index] = 0;
        this.states[index] = 2;
        T previous = this.values[index];
        this.values[index] = this.missingEntries;
        this.size--;
        this.count++;
        return previous;
    }

    public T put(int key, T value) {
        int index = findInsertionIndex(key);
        T previous = this.missingEntries;
        boolean newMapping = true;
        if (index >= 0) goto L5;
        index = changeIndexSign(index);
        previous = this.values[index];
        newMapping = false;
    L5:
        this.keys[index] = key;
        this.states[index] = 1;
        this.values[index] = value;
        if (newMapping == false) goto L11;
        this.size++;
        if (shouldGrowTable() == false) goto L10;
        growTable();
    L10:
        this.count++;
    L11:
        return previous;
    }

    private void growTable() {
        int r0 = this.states.length;
        int[] r1 = this.keys;
        T[] r2 = this.values;
        byte[] r3 = this.states;
        int r4 = r0 * 2;
        int[] r5 = new int[r4];
        T[] r6 = (T[]) buildArray(r4);
        byte[] r7 = new byte[r4];
        int r8 = r4 - 1;
        int r9 = 0;
    L3:
        if (r9 >= r0) goto L8;
        if (r3[r9] != 1) goto L7;
        int r10 = r1[r9];
        int r12 = findInsertionIndex(r5, r7, r10, r8);
        r5[r12] = r10;
        r6[r12] = r2[r9];
        r7[r12] = 1;
    L7:
        r9 = r9 + 1;
        goto L3
    L8:
        this.mask = r8;
        this.keys = r5;
        this.values = r6;
        this.states = r7;
    }

    private boolean shouldGrowTable() {
        if (this.size > ((this.mask + 1) * LOAD_FACTOR)) goto L7;
        return false;
    L7:
        return true;
    }

    private static int hashOf(int key) {
        int h = ((key >>> 20) ^ (key >>> 12)) ^ key;
        return ((h >>> 7) ^ h) ^ (h >>> 4);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.count = 0;
    }

    private T[] buildArray(int r2) {
        return (T[]) ((FieldElement[]) Array.newInstance(this.field.getZero().getClass(), r2));
    }
}

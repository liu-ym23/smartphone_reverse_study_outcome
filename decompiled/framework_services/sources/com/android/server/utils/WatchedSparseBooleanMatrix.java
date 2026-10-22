package com.android.server.utils;

import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class WatchedSparseBooleanMatrix extends WatchableImpl implements Snappable {
    private static final int PACKING = 32;
    static final int STEP = 64;
    static final int STRING_INUSE_INDEX = 2;
    static final int STRING_KEY_INDEX = 0;
    static final int STRING_MAP_INDEX = 1;
    private boolean[] mInUse;
    private int[] mKeys;
    private int[] mMap;
    private int mOrder;
    private int mSize;
    private int[] mValues;

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private void onChanged() {
        dispatchChange(this);
    }

    public WatchedSparseBooleanMatrix() {
        this(64);
    }

    public WatchedSparseBooleanMatrix(int initialCapacity) {
        this.mOrder = initialCapacity;
        if (this.mOrder >= 64) goto L6;
        this.mOrder = 64;
    L6:
        if ((this.mOrder % 64) == 0) goto L9;
        this.mOrder = ((initialCapacity / 64) + 1) * 64;
    L9:
        if (this.mOrder < 64) goto L15;
        if ((this.mOrder % 64) != 0) goto L15;
        this.mInUse = ArrayUtils.newUnpaddedBooleanArray(this.mOrder);
        this.mKeys = ArrayUtils.newUnpaddedIntArray(this.mOrder);
        this.mMap = ArrayUtils.newUnpaddedIntArray(this.mOrder);
        this.mValues = ArrayUtils.newUnpaddedIntArray((this.mOrder * this.mOrder) / 32);
        this.mSize = 0;
        return;
    L15:
        throw new RuntimeException("mOrder is " + this.mOrder + " initCap is " + initialCapacity);
    }

    private WatchedSparseBooleanMatrix(WatchedSparseBooleanMatrix r) {
        copyFrom(r);
    }

    public void copyFrom(WatchedSparseBooleanMatrix src) {
        this.mOrder = src.mOrder;
        this.mSize = src.mSize;
        this.mKeys = (int[]) src.mKeys.clone();
        this.mMap = (int[]) src.mMap.clone();
        this.mInUse = (boolean[]) src.mInUse.clone();
        this.mValues = (int[]) src.mValues.clone();
    }

    @Override // com.android.server.utils.Snappable
    public WatchedSparseBooleanMatrix snapshot() {
        return new WatchedSparseBooleanMatrix(this);
    }

    public boolean get(int row, int col) {
        return get(row, col, false);
    }

    public boolean get(int row, int col, boolean valueIfKeyNotFound) {
        int r = indexOfKey(row, false);
        int c = indexOfKey(col, false);
        if (r < 0) goto L7;
        if (c < 0) goto L7;
        return valueAt(r, c);
    L7:
        return valueIfKeyNotFound;
    }

    public void put(int row, int col, boolean value) {
        int r = indexOfKey(row);
        int c = indexOfKey(col);
        if (r < 0) goto L6;
        if (c < 0) goto L6;
    L11:
        if (r < 0) goto L16;
        if (c < 0) goto L16;
        setValueAt(r, c, value);
        return;
    L16:
        throw new RuntimeException("matrix overflow");
    L6:
        if (r >= 0) goto L8;
        indexOfKey(row, true);
    L8:
        if (c >= 0) goto L10;
        indexOfKey(col, true);
    L10:
        r = indexOfKey(row);
        c = indexOfKey(col);
        goto L11
    }

    public void deleteKey(int key) {
        int i = indexOfKey(key, false);
        if (i < 0) goto L6;
        removeAt(i);
        return;
    }

    public void removeAt(int index) {
        validateIndex(index);
        this.mInUse[this.mMap[index]] = false;
        System.arraycopy(this.mKeys, index + 1, this.mKeys, index, this.mSize - (index + 1));
        this.mKeys[this.mSize - 1] = 0;
        System.arraycopy(this.mMap, index + 1, this.mMap, index, this.mSize - (index + 1));
        this.mMap[this.mSize - 1] = 0;
        this.mSize--;
        onChanged();
    }

    public void removeRange(int fromIndex, int toIndex) {
        if (toIndex < fromIndex) goto L17;
        int num = toIndex - fromIndex;
        if (num != 0) goto L6;
        return;
    L6:
        validateIndex(fromIndex);
        validateIndex(toIndex - 1);
        int i = fromIndex;
    L8:
        if (i >= toIndex) goto L10;
        this.mInUse[this.mMap[i]] = false;
        i = i + 1;
        goto L8
    L10:
        System.arraycopy(this.mKeys, toIndex, this.mKeys, fromIndex, this.mSize - toIndex);
        System.arraycopy(this.mMap, toIndex, this.mMap, fromIndex, this.mSize - toIndex);
        int i2 = this.mSize - num;
    L12:
        if (i2 >= this.mSize) goto L14;
        this.mKeys[i2] = 0;
        this.mMap[i2] = 0;
        i2 = i2 + 1;
        goto L12
    L14:
        int i3 = this.mSize;
        this.mSize = i3 - num;
        onChanged();
        return;
    L17:
        throw new ArrayIndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.mSize;
    }

    public void clear() {
        this.mSize = 0;
        Arrays.fill(this.mInUse, false);
        onChanged();
    }

    public int keyAt(int index) {
        validateIndex(index);
        return this.mKeys[index];
    }

    private boolean valueAtInternal(int row, int col) {
        int element = (this.mOrder * row) + col;
        int offset = element / 32;
        int mask = 1 << (element % 32);
        if ((this.mValues[offset] & mask) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean valueAt(int rowIndex, int colIndex) {
        validateIndex(rowIndex, colIndex);
        int r = this.mMap[rowIndex];
        int c = this.mMap[colIndex];
        return valueAtInternal(r, c);
    }

    private void setValueAtInternal(int row, int col, boolean value) {
        int element = (this.mOrder * row) + col;
        int offset = element / 32;
        int mask = 1 << (element % 32);
        if (value == false) goto L5;
        int[] r3 = this.mValues;
        r3[offset] = r3[offset] | mask;
        return;
    L5:
        int[] r4 = this.mValues;
        r4[offset] = r4[offset] & (~mask);
    }

    public void setValueAt(int rowIndex, int colIndex, boolean value) {
        validateIndex(rowIndex, colIndex);
        int r = this.mMap[rowIndex];
        int c = this.mMap[colIndex];
        setValueAtInternal(r, c, value);
        onChanged();
    }

    public int indexOfKey(int key) {
        return binarySearch(this.mKeys, this.mSize, key);
    }

    public boolean contains(int key) {
        if (indexOfKey(key) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int indexOfKey(int key, boolean grow) {
        int i = binarySearch(this.mKeys, this.mSize, key);
        if (i >= 0) goto L12;
        if (grow == false) goto L12;
        i = ~i;
        if (this.mSize < this.mOrder) goto L8;
        growMatrix();
    L8:
        int newIndex = nextFree(true);
        this.mKeys = GrowingArrayUtils.insert(this.mKeys, this.mSize, i, key);
        this.mMap = GrowingArrayUtils.insert(this.mMap, this.mSize, i, newIndex);
        this.mSize++;
        int valueRow = this.mOrder / 32;
        int offset = newIndex / 32;
        int mask = ~(1 << (newIndex % 32));
        Arrays.fill(this.mValues, newIndex * valueRow, (newIndex + 1) * valueRow, 0);
        int n = 0;
    L10:
        if (n >= this.mSize) goto L12;
        int[] r6 = this.mValues;
        int r7 = (n * valueRow) + offset;
        r6[r7] = r6[r7] & mask;
        n = n + 1;
    L12:
        return i;
    }

    private void validateIndex(int index) {
        if (index >= this.mSize) goto L6;
        return;
    L6:
        throw new ArrayIndexOutOfBoundsException(index);
    }

    private void validateIndex(int row, int col) {
        validateIndex(row);
        validateIndex(col);
    }

    private void growMatrix() {
        resizeMatrix(this.mOrder + 64);
    }

    private void resizeMatrix(int newOrder) {
        if ((newOrder % 64) != 0) goto L10;
        int minOrder = Math.min(this.mOrder, newOrder);
        boolean[] newInUse = ArrayUtils.newUnpaddedBooleanArray(newOrder);
        System.arraycopy(this.mInUse, 0, newInUse, 0, minOrder);
        int[] newMap = ArrayUtils.newUnpaddedIntArray(newOrder);
        System.arraycopy(this.mMap, 0, newMap, 0, minOrder);
        int[] newKeys = ArrayUtils.newUnpaddedIntArray(newOrder);
        System.arraycopy(this.mKeys, 0, newKeys, 0, minOrder);
        int[] newValues = ArrayUtils.newUnpaddedIntArray((newOrder * newOrder) / 32);
        int i = 0;
    L5:
        if (i >= minOrder) goto L7;
        int row = (this.mOrder * i) / 32;
        int newRow = (newOrder * i) / 32;
        System.arraycopy(this.mValues, row, newValues, newRow, minOrder / 32);
        i = i + 1;
        goto L5
    L7:
        this.mInUse = newInUse;
        this.mMap = newMap;
        this.mKeys = newKeys;
        this.mValues = newValues;
        this.mOrder = newOrder;
        return;
    L10:
        throw new IllegalArgumentException("matrix order " + newOrder + " is not a multiple of 64");
    }

    private int nextFree(boolean acquire) {
        int i = 0;
    L4:
        if (i >= this.mInUse.length) goto L11;
        if (this.mInUse[i] == false) goto L7;
        i = i + 1;
        goto L4
    L7:
        this.mInUse[i] = acquire;
        return i;
    L11:
        throw new RuntimeException();
    }

    private int lastInuse() {
        int i = this.mOrder - 1;
    L3:
        if (i < 0) goto L16;
        if (this.mInUse[i] == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        int j = 0;
    L8:
        if (j >= this.mSize) goto L14;
        if (this.mMap[j] == i) goto L11;
        j = j + 1;
        goto L8
    L11:
        return j;
    L14:
        throw new IndexOutOfBoundsException();
    L16:
        return -1;
    }

    private void pack() {
        if (this.mSize != 0) goto L5;
        return;
    L5:
        if (this.mSize == this.mOrder) goto L26;
        int dst = nextFree(false);
    L9:
        if (dst >= this.mSize) goto L20;
        this.mInUse[dst] = true;
        int srcIndex = lastInuse();
        int src = this.mMap[srcIndex];
        this.mInUse[src] = false;
        this.mMap[srcIndex] = dst;
        System.arraycopy(this.mValues, (this.mOrder * src) / 32, this.mValues, (this.mOrder * dst) / 32, this.mOrder / 32);
        int srcOffset = src / 32;
        int srcMask = 1 << (src % 32);
        int dstOffset = dst / 32;
        int dstMask = 1 << (dst % 32);
        int i = 0;
    L12:
        if (i >= this.mOrder) goto L18;
        if ((this.mValues[srcOffset] & srcMask) != 0) goto L16;
        int[] r9 = this.mValues;
        r9[dstOffset] = r9[dstOffset] & (~dstMask);
    L17:
        srcOffset = srcOffset + (this.mOrder / 32);
        dstOffset = dstOffset + (this.mOrder / 32);
        i = i + 1;
        goto L12
    L16:
        int[] r10 = this.mValues;
        r10[dstOffset] = r10[dstOffset] | dstMask;
        goto L17
    L18:
        dst = nextFree(false);
        goto L9
    L20:
        return;
    }

    public void compact() {
        pack();
        int unused = (this.mOrder - this.mSize) / 64;
        if (unused <= 0) goto L6;
        resizeMatrix(this.mOrder - (unused * 64));
        return;
    }

    public int[] keys() {
        return Arrays.copyOf(this.mKeys, this.mSize);
    }

    public int capacity() {
        return this.mOrder;
    }

    public void setCapacity(int capacity) {
        if (capacity > this.mOrder) goto L6;
        return;
    L6:
        if ((capacity % 64) == 0) goto L8;
        capacity = ((capacity / 64) + 1) * 64;
    L8:
        resizeMatrix(capacity);
    }

    public int hashCode() {
        int r0 = (((this.mSize * 31) + Arrays.hashCode(this.mKeys)) * 31) + Arrays.hashCode(this.mMap);
        int r1 = 0;
    L4:
        if (r1 >= this.mSize) goto L11;
        int r2 = this.mMap[r1];
        int r3 = 0;
    L7:
        if (r3 >= this.mSize) goto L9;
        r0 = (r0 * 31) + (valueAtInternal(r2, this.mMap[r3]) ? 1 : 0);
        r3 = r3 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    public boolean equals(Object that) {
        if (this != that) goto L6;
        return true;
    L6:
        if ((that instanceof WatchedSparseBooleanMatrix) == true) goto L8;
        return false;
    L8:
        WatchedSparseBooleanMatrix other = (WatchedSparseBooleanMatrix) that;
        if (this.mSize == other.mSize) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.mKeys, other.mKeys) == true) goto L14;
        return false;
    L14:
        int i = 0;
    L16:
        if (i >= this.mSize) goto L26;
        int row = this.mMap[i];
        int j = 0;
    L19:
        if (j >= this.mSize) goto L24;
        int col = this.mMap[j];
        if (valueAtInternal(row, col) != other.valueAtInternal(row, col)) goto L22;
        j = j + 1;
        goto L19
    L22:
        return false;
    L24:
        i = i + 1;
        goto L16
    L26:
        return true;
    }

    String[] matrixToStringMeta() {
        String[] result = new String[3];
        StringBuilder k = new StringBuilder();
        int i = 0;
    L4:
        if (i >= this.mSize) goto L9;
        k.append(this.mKeys[i]);
        if (i >= (this.mSize - 1)) goto L8;
        k.append(" ");
    L8:
        i = i + 1;
        goto L4
    L9:
        result[0] = k.substring(0);
        StringBuilder m = new StringBuilder();
        int i2 = 0;
    L11:
        if (i2 >= this.mSize) goto L16;
        m.append(this.mMap[i2]);
        if (i2 >= (this.mSize - 1)) goto L15;
        m.append(" ");
    L15:
        i2 = i2 + 1;
        goto L11
    L16:
        result[1] = m.substring(0);
        StringBuilder u = new StringBuilder();
        int i3 = 0;
    L18:
        if (i3 >= this.mOrder) goto L24;
        if (this.mInUse[i3] == false) goto L22;
        String r6 = "1";
    L23:
        u.append(r6);
        i3 = i3 + 1;
        goto L18
    L22:
        r6 = "0";
        goto L23
    L24:
        result[2] = u.substring(0);
        return result;
    }

    String[] matrixToStringRaw() {
        String[] result = new String[this.mOrder];
        int i = 0;
    L4:
        if (i >= this.mOrder) goto L15;
        StringBuilder line = new StringBuilder(this.mOrder);
        int j = 0;
    L7:
        if (j >= this.mOrder) goto L13;
        if (valueAtInternal(i, j) == false) goto L11;
        String r4 = "1";
    L12:
        line.append(r4);
        j = j + 1;
        goto L7
    L11:
        r4 = "0";
        goto L12
    L13:
        result[i] = line.substring(0);
        i = i + 1;
        goto L4
    L15:
        return result;
    }

    String[] matrixToStringCooked() {
        String[] result = new String[this.mSize];
        int i = 0;
    L4:
        if (i >= this.mSize) goto L15;
        int row = this.mMap[i];
        StringBuilder line = new StringBuilder(this.mSize);
        int j = 0;
    L7:
        if (j >= this.mSize) goto L13;
        if (valueAtInternal(row, this.mMap[j]) == false) goto L11;
        String r5 = "1";
    L12:
        line.append(r5);
        j = j + 1;
        goto L7
    L11:
        r5 = "0";
        goto L12
    L13:
        result[i] = line.substring(0);
        i = i + 1;
        goto L4
    L15:
        return result;
    }

    public String[] matrixToString(boolean raw) {
        String[] meta = matrixToStringMeta();
        if (raw == false) goto L5;
        String[] data = matrixToStringRaw();
    L6:
        String[] result = new String[meta.length + data.length];
        System.arraycopy(meta, 0, result, 0, meta.length);
        System.arraycopy(data, 0, result, meta.length, data.length);
        return result;
    L5:
        data = matrixToStringCooked();
        goto L6
    }

    public String toString() {
        return "{" + this.mSize + "x" + this.mSize + "}";
    }

    private static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
    L3:
        if (lo > hi) goto L12;
        int mid = (lo + hi) >>> 1;
        int midVal = array[mid];
        if (midVal < value) goto L6;
        if (midVal <= value) goto L10;
        hi = mid - 1;
        goto L3
    L10:
        return mid;
    L6:
        lo = mid + 1;
        goto L3
    L12:
        return ~lo;
    }
}

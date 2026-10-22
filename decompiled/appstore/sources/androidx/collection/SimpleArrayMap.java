package androidx.collection;

import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";

    @Nullable
    static Object[] mBaseCache;
    static int mBaseCacheSize;

    @Nullable
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = b.f1206a;
        this.mArray = b.f1208c;
        this.mSize = 0;
    }

    public static int b(int[] r10, int r11, int r12) {
        return b.a(r10, r11, r12);
    L5:
        throw new ConcurrentModificationException();
    }

    public static void c(int[] r10, Object[] r11, int r12) {
        if (r10.length != 8) goto L19;
        monitor-enter(SimpleArrayMap.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mTwiceBaseCacheSize >= 10) goto L14;
        r11[0] = mTwiceBaseCache;     // Catch: Throwable -> L11
        r11[1] = r10;     // Catch: Throwable -> L11
        int r13 = (r12 << 1) - 1;     // Catch: Throwable -> L11
    L9:
        if (r13 < 2) goto L13;
        r11[r13] = null;     // Catch: Throwable -> L11
        r13 = r13 - 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        mTwiceBaseCache = r11;     // Catch: Throwable -> L11
        mTwiceBaseCacheSize++;     // Catch: Throwable -> L11
    L14:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L11
        return;
    L19:
        if (r10.length == 4) goto L21;
        return;
    L21:
        monitor-enter(SimpleArrayMap.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (mBaseCacheSize >= 10) goto L30;
        r11[0] = mBaseCache;     // Catch: Throwable -> L27
        r11[1] = r10;     // Catch: Throwable -> L27
        int r14 = (r12 << 1) - 1;     // Catch: Throwable -> L27
    L25:
        if (r14 < 2) goto L29;
        r11[r14] = null;     // Catch: Throwable -> L27
        r14 = r14 - 1;     // Catch: Throwable -> L27
        goto L25
    L29:
        mBaseCache = r11;     // Catch: Throwable -> L27
        mBaseCacheSize++;     // Catch: Throwable -> L27
    L30:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L27
    }

    public final void a(int r10) {
        if (r10 != 8) goto L18;
        monitor-enter(SimpleArrayMap.class);
        Object[] r11 = mTwiceBaseCache;     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        this.mArray = r11;     // Catch: Throwable -> L11
        mTwiceBaseCache = (Object[]) r11[0];     // Catch: Throwable -> L11
        this.mHashes = (int[]) r11[1];     // Catch: Throwable -> L11
        r11[1] = null;     // Catch: Throwable -> L11
        r11[0] = null;     // Catch: Throwable -> L11
        mTwiceBaseCacheSize--;     // Catch: Throwable -> L11
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L11
    L32:
        this.mHashes = new int[r10];
        this.mArray = new Object[r10 << 1];
        return;
    L11:
        th = move-exception;
        throw th;
    L18:
        if (r10 != 4) goto L32;
        monitor-enter(SimpleArrayMap.class);
        Object[] r12 = mBaseCache;     // Catch: Throwable -> L26
        if (r12 == null) goto L28;
        this.mArray = r12;     // Catch: Throwable -> L26
        mBaseCache = (Object[]) r12[0];     // Catch: Throwable -> L26
        this.mHashes = (int[]) r12[1];     // Catch: Throwable -> L26
        r12[1] = null;     // Catch: Throwable -> L26
        r12[0] = null;     // Catch: Throwable -> L26
        mBaseCacheSize--;     // Catch: Throwable -> L26
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L26
        return;
    L28:
        monitor-exit(SimpleArrayMap.class);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public void clear() {
        int r10 = this.mSize;
        if (r10 <= 0) goto L6;
        int[] r11 = this.mHashes;
        Object[] r12 = this.mArray;
        this.mHashes = b.f1206a;
        this.mArray = b.f1208c;
        this.mSize = 0;
        c(r11, r12, r10);
    L6:
        if (this.mSize > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(@Nullable Object r10) {
        if (indexOfKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(Object r10) {
        if (indexOfValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r10) {
        int r11 = this.mSize;
        int[] r12 = this.mHashes;
        if (r12.length >= r10) goto L9;
        Object[] r13 = this.mArray;
        a(r10);
        if (this.mSize <= 0) goto L7;
        System.arraycopy(r12, 0, this.mHashes, 0, r11);
        System.arraycopy(r13, 0, this.mArray, 0, r11 << 1);
    L7:
        c(r12, r13, r11);
    L9:
        if (this.mSize != r11) goto L12;
        return;
    L12:
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SimpleArrayMap) == false) goto L26;
        SimpleArrayMap r11 = (SimpleArrayMap) r10;
        if (size() == r11.size()) goto L10;
        return false;
    L10:
        int r12 = 0;
    L48:
        if (r12 >= this.mSize) goto L23;
        Object r13 = keyAt(r12);     // Catch: Throwable -> L24
        Object r14 = valueAt(r12);     // Catch: Throwable -> L24
        Object r15 = r11.get(r13);     // Catch: Throwable -> L24
        if (r14 != null) goto L20;
        if (r15 != null) goto L18;
        if (r11.containsKey(r13) == false) goto L18;
    L22:
        r12 = r12 + 1;
    L18:
        return false;
    L20:
        if (r14.equals(r15) == true) goto L22;
        return false;
    L23:
        return true;
    L24:
        return false;
    L26:
        if ((r10 instanceof Map) == false) goto L44;
        Map r16 = (Map) r10;
        if (size() == r16.size()) goto L30;
        return false;
    L30:
        int r17 = 0;
    L46:
        if (r17 >= this.mSize) goto L43;
        Object r18 = keyAt(r17);     // Catch: Throwable -> L45
        Object r19 = valueAt(r17);     // Catch: Throwable -> L45
        Object r20 = r16.get(r18);     // Catch: Throwable -> L45
        if (r19 != null) goto L40;
        if (r20 != null) goto L38;
        if (r16.containsKey(r18) == false) goto L38;
    L42:
        r17 = r17 + 1;
    L38:
        return false;
    L40:
        if (r19.equals(r20) == true) goto L42;
        return false;
    L43:
        return true;
    L44:
        return false;
    }

    @Nullable
    public Object get(Object r10) {
        return getOrDefault(r10, null);
    }

    public Object getOrDefault(Object r10, Object r11) {
        int r12 = indexOfKey(r10);
        if (r12 >= 0) goto L5;
        return r11;
    L5:
        return this.mArray[(r12 << 1) + 1];
    }

    public int hashCode() {
        int[] r10 = this.mHashes;
        Object[] r11 = this.mArray;
        int r12 = this.mSize;
        int r13 = 1;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r12) goto L9;
        Object r16 = r11[r13];
        int r17 = r10[r14];
        if (r16 != null) goto L7;
        int r18 = 0;
    L8:
        r15 = r15 + (r18 ^ r17);
        r14 = r14 + 1;
        r13 = r13 + 2;
        goto L3
    L7:
        r18 = r16.hashCode();
        goto L8
    L9:
        return r15;
    }

    public int indexOf(Object r10, int r11) {
        int r12 = this.mSize;
        if (r12 != 0) goto L6;
        return -1;
    L6:
        int r13 = b(this.mHashes, r12, r11);
        if (r13 >= 0) goto L10;
        return r13;
    L10:
        if (r10.equals(this.mArray[r13 << 1]) == false) goto L12;
        return r13;
    L12:
        int r14 = r13 + 1;
    L13:
        if (r14 >= r12) goto L20;
        if (this.mHashes[r14] != r11) goto L20;
        if (r10.equals(this.mArray[r14 << 1]) == true) goto L18;
        r14 = r14 + 1;
        goto L13
    L18:
        return r14;
    L20:
        int r15 = r13 - 1;
    L21:
        if (r15 < 0) goto L29;
        if (this.mHashes[r15] != r11) goto L29;
        if (r10.equals(this.mArray[r15 << 1]) == true) goto L26;
        r15 = r15 - 1;
        goto L21
    L26:
        return r15;
    L29:
        return ~r14;
    }

    public int indexOfKey(@Nullable Object r10) {
        if (r10 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r10, r10.hashCode());
    }

    public int indexOfNull() {
        int r10 = this.mSize;
        if (r10 != 0) goto L6;
        return -1;
    L6:
        int r11 = b(this.mHashes, r10, 0);
        if (r11 >= 0) goto L10;
        return r11;
    L10:
        if (this.mArray[r11 << 1] != null) goto L12;
        return r11;
    L12:
        int r12 = r11 + 1;
    L13:
        if (r12 >= r10) goto L20;
        if (this.mHashes[r12] != 0) goto L20;
        if (this.mArray[r12 << 1] == null) goto L18;
        r12 = r12 + 1;
        goto L13
    L18:
        return r12;
    L20:
        int r13 = r11 - 1;
    L21:
        if (r13 < 0) goto L29;
        if (this.mHashes[r13] != 0) goto L29;
        if (this.mArray[r13 << 1] == null) goto L26;
        r13 = r13 - 1;
        goto L21
    L26:
        return r13;
    L29:
        return ~r12;
    }

    public int indexOfValue(Object r10) {
        int r11 = this.mSize * 2;
        Object[] r12 = this.mArray;
        if (r10 != null) goto L11;
        int r13 = 1;
    L5:
        if (r13 >= r11) goto L18;
        if (r12[r13] == null) goto L9;
        r13 = r13 + 2;
        goto L5
    L9:
        return r13 >> 1;
    L18:
        return -1;
    L11:
        int r14 = 1;
    L12:
        if (r14 >= r11) goto L24;
        if (r10.equals(r12[r14]) == true) goto L16;
        r14 = r14 + 2;
        goto L12
    L16:
        return r14 >> 1;
    L24:
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Object keyAt(int r10) {
        return this.mArray[r10 << 1];
    }

    public Object put(Object r10, Object r11) {
        int r12 = this.mSize;
        if (r10 != null) goto L5;
        int r13 = indexOfNull();
        int r14 = 0;
    L6:
        if (r13 < 0) goto L9;
        int r15 = (r13 << 1) + 1;
        Object[] r16 = this.mArray;
        Object r17 = r16[r15];
        r16[r15] = r11;
        return r17;
    L9:
        int r18 = ~r13;
        int[] r19 = this.mHashes;
        if (r12 < r19.length) goto L26;
        int r20 = 8;
        if (r12 < 8) goto L15;
        r20 = (r12 >> 1) + r12;
    L18:
        Object[] r21 = this.mArray;
        a(r20);
        if (r12 != this.mSize) goto L25;
        int[] r22 = this.mHashes;
        if (r22.length <= 0) goto L23;
        System.arraycopy(r19, 0, r22, 0, r19.length);
        System.arraycopy(r21, 0, this.mArray, 0, r21.length);
    L23:
        c(r19, r21, r12);
        goto L26
    L25:
        throw new ConcurrentModificationException();
    L15:
        if (r12 >= 4) goto L18;
        r20 = 4;
    L26:
        if (r18 >= r12) goto L28;
        int[] r23 = this.mHashes;
        int r24 = r18 + 1;
        System.arraycopy(r23, r18, r23, r24, r12 - r18);
        Object[] r25 = this.mArray;
        System.arraycopy(r25, r18 << 1, r25, r24 << 1, (this.mSize - r18) << 1);
    L28:
        int r26 = this.mSize;
        if (r12 != r26) goto L35;
        int[] r27 = this.mHashes;
        if (r18 >= r27.length) goto L35;
        r27[r18] = r14;
        Object[] r28 = this.mArray;
        int r29 = r18 << 1;
        r28[r29] = r10;
        r28[r29 + 1] = r11;
        this.mSize = r26 + 1;
        return null;
    L35:
        throw new ConcurrentModificationException();
    L5:
        int r30 = r10.hashCode();
        r14 = r30;
        r13 = indexOf(r10, r30);
        goto L6
    }

    public void putAll(SimpleArrayMap r10) {
        int r11 = r10.mSize;
        ensureCapacity(this.mSize + r11);
        int r12 = 0;
        if (this.mSize != 0) goto L6;
        if (r11 <= 0) goto L8;
        System.arraycopy(r10.mHashes, 0, this.mHashes, 0, r11);
        System.arraycopy(r10.mArray, 0, this.mArray, 0, r11 << 1);
        this.mSize = r11;
        return;
    L8:
        return;
    L6:
        if (r12 >= r11) goto L11;
        put(r10.keyAt(r12), r10.valueAt(r12));
        r12 = r12 + 1;
        goto L6
    }

    @Nullable
    public Object putIfAbsent(Object r10, Object r11) {
        Object r12 = get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return put(r10, r11);
    }

    @Nullable
    public Object remove(Object r10) {
        int r11 = indexOfKey(r10);
        if (r11 >= 0) goto L5;
        return null;
    L5:
        return removeAt(r11);
    }

    public Object removeAt(int r11) {
        Object[] r10 = this.mArray;
        int r12 = r11 << 1;
        Object r13 = r10[r12 + 1];
        int r14 = this.mSize;
        int r15 = 0;
        if (r14 > 1) goto L5;
        c(this.mHashes, r10, r14);
        this.mHashes = b.f1206a;
        this.mArray = b.f1208c;
    L24:
        if (r14 != this.mSize) goto L28;
        this.mSize = r15;
        return r13;
    L28:
        throw new ConcurrentModificationException();
    L5:
        int r16 = r14 - 1;
        int[] r17 = this.mHashes;
        int r18 = 8;
        if (r17.length > 8) goto L8;
    L19:
        if (r11 >= r16) goto L21;
        int r19 = r11 + 1;
        int r20 = r16 - r11;
        System.arraycopy(r17, r19, r17, r11, r20);
        Object[] r110 = this.mArray;
        System.arraycopy(r110, r19 << 1, r110, r12, r20 << 1);
    L21:
        Object[] r111 = this.mArray;
        int r21 = r16 << 1;
        r111[r21] = null;
        r111[r21 + 1] = null;
    L22:
        r15 = r16;
        goto L24
    L8:
        if (r14 >= (r17.length / 3)) goto L19;
        if (r14 <= 8) goto L11;
        r18 = r14 + (r14 >> 1);
    L11:
        a(r18);
        if (r14 != this.mSize) goto L18;
        if (r11 <= 0) goto L15;
        System.arraycopy(r17, 0, this.mHashes, 0, r11);
        System.arraycopy(r10, 0, this.mArray, 0, r12);
    L15:
        if (r11 >= r16) goto L22;
        int r22 = r11 + 1;
        int r23 = r16 - r11;
        System.arraycopy(r17, r22, this.mHashes, r11, r23);
        System.arraycopy(r10, r22 << 1, this.mArray, r12, r23 << 1);
        goto L22
    L18:
        throw new ConcurrentModificationException();
    }

    @Nullable
    public Object replace(Object r10, Object r11) {
        int r12 = indexOfKey(r10);
        if (r12 >= 0) goto L5;
        return null;
    L5:
        return setValueAt(r12, r11);
    }

    public Object setValueAt(int r10, Object r11) {
        int r12 = (r10 << 1) + 1;
        Object[] r13 = this.mArray;
        Object r14 = r13[r12];
        r13[r12] = r11;
        return r14;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder(this.mSize * 28);
        r10.append('{');
        int r11 = 0;
    L8:
        if (r11 >= this.mSize) goto L20;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        Object r12 = keyAt(r11);
        if (r12 == this) goto L14;
        r10.append(r12);
    L15:
        r10.append('=');
        Object r13 = valueAt(r11);
        if (r13 == this) goto L18;
        r10.append(r13);
    L19:
        r11 = r11 + 1;
        goto L8
    L18:
        r10.append("(this Map)");
        goto L19
    L14:
        r10.append("(this Map)");
        goto L15
    L20:
        r10.append('}');
        return r10.toString();
    }

    public Object valueAt(int r10) {
        return this.mArray[(r10 << 1) + 1];
    }

    public boolean remove(Object r10, Object r11) {
        int r12 = indexOfKey(r10);
        if (r12 < 0) goto L11;
        Object r13 = valueAt(r12);
        if (r11 == r13) goto L9;
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.equals(r13) == true) goto L9;
        return false;
    L9:
        removeAt(r12);
        return true;
    L11:
        return false;
    }

    public boolean replace(Object r10, Object r11, Object r12) {
        int r13 = indexOfKey(r10);
        if (r13 < 0) goto L11;
        Object r14 = valueAt(r13);
        if (r14 == r11) goto L9;
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.equals(r14) == true) goto L9;
        return false;
    L9:
        setValueAt(r13, r12);
        return true;
    L11:
        return false;
    }

    public SimpleArrayMap(int r10) {
        if (r10 != 0) goto L5;
        this.mHashes = b.f1206a;
        this.mArray = b.f1208c;
    L6:
        this.mSize = 0;
        return;
    L5:
        a(r10);
        goto L6
    }

    public SimpleArrayMap(SimpleArrayMap r10) {
        this();
        if (r10 == null) goto L6;
        putAll(r10);
        return;
    }
}

package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = null;
    int mArgCount;
    private final int[] mBindingTypes;
    final byte[][] mBlobBindings;
    final int mCapacity;
    final double[] mDoubleBindings;
    final long[] mLongBindings;
    private volatile String mQuery;
    final String[] mStringBindings;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    static {
        sQueryPool = new TreeMap();
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        final RoomSQLiteQuery r0 = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new AnonymousClass1(r0));
        return r0;
    }

    public static RoomSQLiteQuery acquire(String query, int argumentCount) {
        TreeMap<Integer, RoomSQLiteQuery> r0 = sQueryPool;
        monitor-enter(r0);
        Map.Entry<Integer, RoomSQLiteQuery> r1 = r0.ceilingEntry(Integer.valueOf(argumentCount));     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r0.remove(r1.getKey());     // Catch: Throwable -> L12
        RoomSQLiteQuery r2 = r1.getValue();     // Catch: Throwable -> L12
        r2.init(query, argumentCount);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        RoomSQLiteQuery r3 = new RoomSQLiteQuery(argumentCount);
        r3.init(query, argumentCount);
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    private RoomSQLiteQuery(int capacity) {
        this.mCapacity = capacity;
        int r2 = capacity + 1;
        this.mBindingTypes = new int[r2];
        this.mLongBindings = new long[r2];
        this.mDoubleBindings = new double[r2];
        this.mStringBindings = new String[r2];
        this.mBlobBindings = new byte[r2][];
    }

    void init(String query, int argCount) {
        this.mQuery = query;
        this.mArgCount = argCount;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> r0 = sQueryPool;
        monitor-enter(r0);
        r0.put(Integer.valueOf(this.mCapacity), this);     // Catch: Throwable -> L7
        prunePoolLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> r0 = sQueryPool;
        if (r0.size() <= 15) goto L8;
        int r1 = r0.size() - 10;
        Iterator<Integer> r2 = r0.descendingKeySet().iterator();
    L5:
        int r3 = r1 - 1;
        if (r1 <= 0) goto L10;
        r2.next();
        r2.remove();
        r1 = r3;
        goto L5
    L10:
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram program) {
        int r1 = 1;
    L4:
        if (r1 > this.mArgCount) goto L22;
        int r2 = this.mBindingTypes[r1];
        if (r2 != 1) goto L8;
        program.bindNull(r1);
    L21:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2 != 2) goto L10;
        program.bindLong(r1, this.mLongBindings[r1]);
        goto L21
    L10:
        if (r2 != 3) goto L12;
        program.bindDouble(r1, this.mDoubleBindings[r1]);
        goto L21
    L12:
        if (r2 != 4) goto L14;
        program.bindString(r1, this.mStringBindings[r1]);
        goto L21
    L14:
        if (r2 != 5) goto L21;
        program.bindBlob(r1, this.mBlobBindings[r1]);
        goto L21
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        this.mBindingTypes[index] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        this.mBindingTypes[index] = 2;
        this.mLongBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        this.mBindingTypes[index] = 3;
        this.mDoubleBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        this.mBindingTypes[index] = 4;
        this.mStringBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        this.mBindingTypes[index] = 5;
        this.mBlobBindings[index] = value;
    }

    public void copyArgumentsFrom(RoomSQLiteQuery other) {
        int r0 = other.getArgCount() + 1;
        System.arraycopy(other.mBindingTypes, 0, this.mBindingTypes, 0, r0);
        System.arraycopy(other.mLongBindings, 0, this.mLongBindings, 0, r0);
        System.arraycopy(other.mStringBindings, 0, this.mStringBindings, 0, r0);
        System.arraycopy(other.mBlobBindings, 0, this.mBlobBindings, 0, r0);
        System.arraycopy(other.mDoubleBindings, 0, this.mDoubleBindings, 0, r0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, null);
        Arrays.fill(this.mBlobBindings, null);
        this.mQuery = null;
    }
}

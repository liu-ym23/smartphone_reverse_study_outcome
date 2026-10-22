package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
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

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> r100 = sQueryPool;
        if (r100.size() <= 15) goto L8;
        int r101 = r100.size() - 10;
        Iterator<Integer> r102 = r100.descendingKeySet().iterator();
    L5:
        int r103 = r101 - 1;
        if (r101 <= 0) goto L10;
        r102.next();
        r102.remove();
        r101 = r103;
        goto L5
    L10:
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, null);
        Arrays.fill(this.mBlobBindings, null);
        this.mQuery = null;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> r100 = sQueryPool;
        monitor-enter(r100);
        r100.put(Integer.valueOf(this.mCapacity), this);     // Catch: Throwable -> L7
        prunePoolLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    private RoomSQLiteQuery(int r100) {
        this.mCapacity = r100;
        int r101 = r100 + 1;
        this.mBindingTypes = new int[r101];
        this.mLongBindings = new long[r101];
        this.mDoubleBindings = new double[r101];
        this.mStringBindings = new String[r101];
        this.mBlobBindings = new byte[r101][];
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery r100) {
        final RoomSQLiteQuery r101 = acquire(r100.getSql(), r100.getArgCount());
        r100.bindTo(new AnonymousClass1(r101));
        return r101;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        this.mBindingTypes[r100] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r100) {
        int r101 = 1;
    L4:
        if (r101 > this.mArgCount) goto L22;
        int r102 = this.mBindingTypes[r101];
        if (r102 != 1) goto L8;
        r100.bindNull(r101);
    L21:
        r101 = r101 + 1;
        goto L4
    L8:
        if (r102 != 2) goto L10;
        r100.bindLong(r101, this.mLongBindings[r101]);
        goto L21
    L10:
        if (r102 != 3) goto L12;
        r100.bindDouble(r101, this.mDoubleBindings[r101]);
        goto L21
    L12:
        if (r102 != 4) goto L14;
        r100.bindString(r101, this.mStringBindings[r101]);
        goto L21
    L14:
        if (r102 != 5) goto L21;
        r100.bindBlob(r101, this.mBlobBindings[r101]);
        goto L21
    }

    public void copyArgumentsFrom(RoomSQLiteQuery r100) {
        int r101 = r100.getArgCount() + 1;
        System.arraycopy(r100.mBindingTypes, 0, this.mBindingTypes, 0, r101);
        System.arraycopy(r100.mLongBindings, 0, this.mLongBindings, 0, r101);
        System.arraycopy(r100.mStringBindings, 0, this.mStringBindings, 0, r101);
        System.arraycopy(r100.mBlobBindings, 0, this.mBlobBindings, 0, r101);
        System.arraycopy(r100.mDoubleBindings, 0, this.mDoubleBindings, 0, r101);
    }

    public static RoomSQLiteQuery acquire(String r100, int r101) {
        TreeMap<Integer, RoomSQLiteQuery> r102 = sQueryPool;
        monitor-enter(r102);
        Map.Entry<Integer, RoomSQLiteQuery> r103 = r102.ceilingEntry(Integer.valueOf(r101));     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        r102.remove(r103.getKey());     // Catch: Throwable -> L12
        RoomSQLiteQuery r104 = r103.getValue();     // Catch: Throwable -> L12
        r104.init(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return r104;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L12
        RoomSQLiteQuery r105 = new RoomSQLiteQuery(r101);
        r105.init(r100, r101);
        return r105;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r100, byte[] r101) {
        this.mBindingTypes[r100] = 5;
        this.mBlobBindings[r100] = r101;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        this.mBindingTypes[r100] = 3;
        this.mDoubleBindings[r100] = r101;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        this.mBindingTypes[r100] = 2;
        this.mLongBindings[r100] = r101;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        this.mBindingTypes[r100] = 4;
        this.mStringBindings[r100] = r101;
    }

    public void init(String r100, int r101) {
        this.mQuery = r100;
        this.mArgCount = r101;
    }
}

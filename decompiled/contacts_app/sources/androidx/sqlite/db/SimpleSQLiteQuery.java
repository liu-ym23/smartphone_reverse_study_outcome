package androidx.sqlite.db;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String r1, Object[] r2) {
        this.mQuery = r1;
        this.mBindArgs = r2;
    }

    public SimpleSQLiteQuery(String r2) {
        this(r2, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r1) {
        bind(r1, this.mBindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r0 = this.mBindArgs;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public static void bind(SupportSQLiteProgram r3, Object[] r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        Object r2 = r4[r1];
        r1 = r1 + 1;
        bind(r3, r1, r2);
        goto L5
    }

    private static void bind(SupportSQLiteProgram r2, int r3, Object r4) {
        if (r4 != null) goto L5;
        r2.bindNull(r3);
        return;
    L5:
        if ((r4 instanceof byte[]) == false) goto L8;
        r2.bindBlob(r3, (byte[]) r4);
        return;
    L8:
        if ((r4 instanceof Float) == false) goto L11;
        r2.bindDouble(r3, ((Float) r4).floatValue());
        return;
    L11:
        if ((r4 instanceof Double) == false) goto L14;
        r2.bindDouble(r3, ((Double) r4).doubleValue());
        return;
    L14:
        if ((r4 instanceof Long) == false) goto L17;
        r2.bindLong(r3, ((Long) r4).longValue());
        return;
    L17:
        if ((r4 instanceof Integer) == false) goto L20;
        r2.bindLong(r3, ((Integer) r4).intValue());
        return;
    L20:
        if ((r4 instanceof Short) == false) goto L23;
        r2.bindLong(r3, ((Short) r4).shortValue());
        return;
    L23:
        if ((r4 instanceof Byte) == false) goto L26;
        r2.bindLong(r3, ((Byte) r4).byteValue());
        return;
    L26:
        if ((r4 instanceof String) == false) goto L29;
        r2.bindString(r3, (String) r4);
        return;
    L29:
        if ((r4 instanceof Boolean) == false) goto L37;
        if (((Boolean) r4).booleanValue() == false) goto L33;
        long r0 = 1;
    L34:
        r2.bindLong(r3, r0);
        return;
    L33:
        r0 = 0;
        goto L34
    L37:
        throw new IllegalArgumentException("Cannot bind " + r4 + " at index " + r3 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}

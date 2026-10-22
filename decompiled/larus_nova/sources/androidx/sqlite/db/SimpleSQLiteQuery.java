package androidx.sqlite.db;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "", "(Ljava/lang/String;)V", "bindArgs", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "argCount", "", "getArgCount", "()I", "[Ljava/lang/Object;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = null;
    private final Object[] bindArgs;
    private final String query;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/SimpleSQLiteQuery$Companion;", "", "()V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteProgram;", "bindArgs", "", "(Landroidx/sqlite/db/SupportSQLiteProgram;[Ljava/lang/Object;)V", "index", "", "arg", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final void bind(SupportSQLiteProgram r100, Object[] r101) {
            Intrinsics.checkNotNullParameter(r100, "statement");
            if (r101 != null) goto L5;
            return;
        L5:
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L8;
            Object r104 = r101[r103];
            r103 = r103 + 1;
            bind(r100, r103, r104);
            goto L6
        }

        private final void bind(SupportSQLiteProgram r100, int r101, Object r102) {
            if (r102 != null) goto L5;
            r100.bindNull(r101);
            return;
        L5:
            if ((r102 instanceof byte[]) == false) goto L8;
            r100.bindBlob(r101, (byte[]) r102);
            return;
        L8:
            if ((r102 instanceof Float) == false) goto L11;
            r100.bindDouble(r101, ((Number) r102).floatValue());
            return;
        L11:
            if ((r102 instanceof Double) == false) goto L14;
            r100.bindDouble(r101, ((Number) r102).doubleValue());
            return;
        L14:
            if ((r102 instanceof Long) == false) goto L17;
            r100.bindLong(r101, ((Number) r102).longValue());
            return;
        L17:
            if ((r102 instanceof Integer) == false) goto L20;
            r100.bindLong(r101, ((Number) r102).intValue());
            return;
        L20:
            if ((r102 instanceof Short) == false) goto L23;
            r100.bindLong(r101, ((Number) r102).shortValue());
            return;
        L23:
            if ((r102 instanceof Byte) == false) goto L26;
            r100.bindLong(r101, ((Number) r102).byteValue());
            return;
        L26:
            if ((r102 instanceof String) == false) goto L29;
            r100.bindString(r101, (String) r102);
            return;
        L29:
            if ((r102 instanceof Boolean) == false) goto L37;
            if (((Boolean) r102).booleanValue() == false) goto L33;
            long r103 = 1;
        L34:
            r100.bindLong(r101, r103);
            return;
        L33:
            r103 = 0;
            goto L34
        L37:
            throw new IllegalArgumentException("Cannot bind " + r102 + " at index " + r101 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void bind(SupportSQLiteProgram r100, Object[] r101) {
        Companion.bind(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r100 = this.bindArgs;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.query;
    }

    public SimpleSQLiteQuery(String r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        this(r100, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r100) {
        Intrinsics.checkNotNullParameter(r100, "statement");
        Companion.bind(r100, this.bindArgs);
    }

    public SimpleSQLiteQuery(String r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "query");
        this.query = r100;
        this.bindArgs = r101;
    }
}

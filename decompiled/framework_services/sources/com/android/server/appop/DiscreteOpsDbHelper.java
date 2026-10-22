package com.android.server.appop;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteRawStatement;
import android.os.Environment;
import android.util.IntArray;
import android.util.Slog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class DiscreteOpsDbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "app_op_history.db";
    private static final int DATABASE_VERSION = 1;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "DiscreteOpsDbHelper";

    private static final enum ColumnFilter extends Enum<ColumnFilter> {
        private static final /* synthetic */ ColumnFilter[] $VALUES = null;
        public static final ColumnFilter ATTR_TAG = null;
        public static final ColumnFilter BEGIN_TIME = null;
        public static final ColumnFilter END_TIME = null;
        public static final ColumnFilter OP_CODE_EQUAL = null;
        public static final ColumnFilter OP_CODE_IN = null;
        public static final ColumnFilter OP_FLAGS = null;
        public static final ColumnFilter PACKAGE_NAME = null;
        public static final ColumnFilter UID = null;
        final String mCondition;

        private static /* synthetic */ ColumnFilter[] $values() {
            return new ColumnFilter[]{PACKAGE_NAME, UID, ATTR_TAG, END_TIME, OP_CODE_EQUAL, BEGIN_TIME, OP_FLAGS, OP_CODE_IN};
        }

        public static ColumnFilter valueOf(String name) {
            return (ColumnFilter) Enum.valueOf(ColumnFilter.class, name);
        }

        public static ColumnFilter[] values() {
            return (ColumnFilter[]) $VALUES.clone();
        }

        static {
            PACKAGE_NAME = new ColumnFilter("PACKAGE_NAME", 0, "package_name = ? ");
            UID = new ColumnFilter("UID", 1, "uid = ? ");
            ATTR_TAG = new ColumnFilter("ATTR_TAG", 2, "attribution_tag = ? ");
            END_TIME = new ColumnFilter("END_TIME", 3, "access_time < ? ");
            OP_CODE_EQUAL = new ColumnFilter("OP_CODE_EQUAL", 4, "op_code = ? ");
            BEGIN_TIME = new ColumnFilter("BEGIN_TIME", 5, "access_time + access_duration > ? ");
            OP_FLAGS = new ColumnFilter("OP_FLAGS", 6, "(op_flags & ? ) != 0");
            OP_CODE_IN = new ColumnFilter("OP_CODE_IN", 7, "op_code IN ");
            $VALUES = $values();
        }

        private ColumnFilter(String r1, int r2, String condition) {
            super(r1, r2);
            this.mCondition = condition;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mCondition;
        }
    }

    static final class DiscreteOpsDatabaseErrorHandler implements DatabaseErrorHandler {
        private final DefaultDatabaseErrorHandler mDefaultDatabaseErrorHandler;

        DiscreteOpsDatabaseErrorHandler() {
            this.mDefaultDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase dbObj) {
            Slog.e(DiscreteOpsDbHelper.LOG_TAG, "discrete ops database got corrupted.");
            this.mDefaultDatabaseErrorHandler.onCorruption(dbObj);
        }
    }

    static final class SQLCondition {
        private final ColumnFilter mColumnFilter;
        private final Object mFilterValue;

        /* JADX INFO: renamed from: -$$Nest$fgetmColumnFilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ ColumnFilter m1764$$Nest$fgetmColumnFilter(SQLCondition r0) {
            return r0.mColumnFilter;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFilterValue, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m1765$$Nest$fgetmFilterValue(SQLCondition r0) {
            return r0.mFilterValue;
        }

        SQLCondition(ColumnFilter columnFilter, Object filterValue) {
            this.mColumnFilter = columnFilter;
            this.mFilterValue = filterValue;
        }

        public String toString() {
            if (this.mColumnFilter != ColumnFilter.OP_CODE_IN) goto L7;
            return this.mColumnFilter + " ( " + this.mFilterValue + " )";
        L7:
            return this.mColumnFilter.toString();
        }
    }

    DiscreteOpsDbHelper(Context context, File databaseFile) {
        super(context, databaseFile.getAbsolutePath(), null, 1, new DiscreteOpsDatabaseErrorHandler());
        setOpenParams(getDatabaseOpenParams());
    }

    private static SQLiteDatabase.OpenParams getDatabaseOpenParams() {
        return new SQLiteDatabase.OpenParams.Builder().addOpenFlags(536870912).build();
    }

    static File getDatabaseFile() {
        return new File(new File(Environment.getDataSystemDirectory(), "appops"), DATABASE_NAME);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase db) {
        db.execSQL("PRAGMA synchronous = NORMAL");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS app_op_accesses(id INTEGER PRIMARY KEY,uid INTEGER,package_name TEXT,device_id TEXT NOT NULL,op_code INTEGER,attribution_tag TEXT,access_time INTEGER,access_duration INTEGER,uid_state INTEGER,op_flags INTEGER,attribution_flags INTEGER,chain_id INTEGER)");
        db.execSQL("CREATE INDEX IF NOT EXISTS app_op_access_index ON app_op_accesses (access_time, uid, op_code)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    void insertDiscreteOps(List<DiscreteOpsSqlRegistry.DiscreteOp> opEvents) {
        if (opEvents.isEmpty() == false) goto L5;
        return;
    L5:
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        SQLiteRawStatement statement = db.createRawStatement("INSERT INTO app_op_accesses(uid, package_name, device_id, op_code, attribution_tag, access_time, access_duration, uid_state, op_flags, attribution_flags, chain_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");     // Catch: Throwable -> L28
        Iterator<DiscreteOpsSqlRegistry.DiscreteOp> r6 = opEvents.iterator();     // Catch: Throwable -> L14
    L9:
        if (r6.hasNext() == false) goto L24;
        DiscreteOpsSqlRegistry.DiscreteOp event = r6.next();     // Catch: Throwable -> L14
        statement.bindInt(1, event.getUid());     // Catch: Throwable -> L16 Exception -> L18
        bindTextOrNull(statement, 2, event.getPackageName());     // Catch: Throwable -> L16 Exception -> L18
        bindTextOrNull(statement, 3, event.getDeviceId());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindInt(4, event.getOpCode());     // Catch: Throwable -> L16 Exception -> L18
        bindTextOrNull(statement, 5, event.getAttributionTag());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindLong(6, event.getAccessTime());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindLong(7, event.getDuration());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindInt(8, event.getUidState());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindInt(9, event.getOpFlags());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindInt(10, event.getAttributionFlags());     // Catch: Throwable -> L16 Exception -> L18
        statement.bindLong(11, event.getChainId());     // Catch: Throwable -> L16 Exception -> L18
        statement.step();     // Catch: Throwable -> L16 Exception -> L18
    L12:
        statement.reset();     // Catch: Throwable -> L14
    L16:
        th = move-exception;
        statement.reset();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L18:
        exception = move-exception;
        Slog.e(LOG_TAG, "Error inserting the discrete op: " + event, exception);     // Catch: Throwable -> L16
        goto L12
    L24:
        db.setTransactionSuccessful();     // Catch: Throwable -> L14
        if (statement == null) goto L49;
        statement.close();     // Catch: Throwable -> L28
    L49:
        db.endTransaction();     // Catch: SQLiteException -> L32
        return;
    L32:
        exception = move-exception;
        Slog.e(LOG_TAG, "Couldn't commit transaction when inserting discrete ops, database file size (bytes) : " + getDatabaseFile().length(), exception);
        return;
    L14:
        th = move-exception;
        if (statement != null) goto L53;
    L42:
        throw th;     // Catch: Throwable -> L28
    L53:
        statement.close();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        db.endTransaction();     // Catch: SQLiteException -> L45
    L47:
        throw th;
    L45:
        exception = move-exception;
        Slog.e(LOG_TAG, "Couldn't commit transaction when inserting discrete ops, database file size (bytes) : " + getDatabaseFile().length(), exception);
        goto L47
    }

    private void bindTextOrNull(SQLiteRawStatement statement, int index, String text) {
        if (text != null) goto L4;
        statement.bindNull(index);
        return;
    L4:
        statement.bindText(index, text);
    }

    long getLargestAttributionChainId() {
        long chainId = 0;
        SQLiteDatabase db = getReadableDatabase();     // Catch: SQLiteException -> L16
        db.beginTransactionReadOnly();     // Catch: SQLiteException -> L16
        SQLiteRawStatement statement = db.createRawStatement("SELECT MAX(chain_id) FROM app_op_accesses");     // Catch: Throwable -> L18
    L10:
        th = move-exception;
        if (statement != null) goto L34;
    L26:
        throw th;     // Catch: Throwable -> L18
    L34:
        statement.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18
        goto L26
    L6:
        if (statement.step() == false) goto L12;
        chainId = statement.getColumnLong(0);     // Catch: Throwable -> L10
        if (chainId >= 0) goto L12;
        chainId = 0;
    L12:
        db.setTransactionSuccessful();     // Catch: Throwable -> L10
        statement.close();     // Catch: Throwable -> L18
        db.endTransaction();     // Catch: SQLiteException -> L16
    L30:
        return chainId;
    L18:
        th = move-exception;
        db.endTransaction();     // Catch: SQLiteException -> L16
        throw th;     // Catch: SQLiteException -> L16
    L16:
        exception = move-exception;
        Slog.e(LOG_TAG, "Error reading attribution chain id", exception);
        goto L30
    }

    void execSQL(String sql) {
        execSQL(sql, null);
    }

    void execSQL(String sql, Object[] bindArgs) {
        SQLiteDatabase db = getWritableDatabase();     // Catch: SQLiteFullException -> L5
        if (bindArgs != null) goto L7;
        db.execSQL(sql);     // Catch: SQLiteFullException -> L5
    L11:
        return;
    L7:
        db.execSQL(sql, bindArgs);     // Catch: SQLiteFullException -> L5
    L5:
        exception = move-exception;
        Slog.e(LOG_TAG, "Couldn't exec sql command, disk is full. Discrete ops db file size (bytes) : " + getDatabaseFile().length(), exception);
    }

    List<DiscreteOpsSqlRegistry.DiscreteOp> getDiscreteOps(int requestFilters, int uidFilter, String packageNameFilter, String attributionTagFilter, IntArray opCodesFilter, int opFlagsFilter, long beginTime, long endTime, int limit, String orderByColumn, boolean ascending) {
        List<SQLCondition> conditions = prepareConditions(beginTime, endTime, requestFilters, uidFilter, packageNameFilter, attributionTagFilter, opCodesFilter, opFlagsFilter);
        String sql = buildSql(conditions, orderByColumn, ascending, limit);
        SQLiteDatabase db = getReadableDatabase();
        List<DiscreteOpsSqlRegistry.DiscreteOp> results = new ArrayList();
        db.beginTransactionReadOnly();
        SQLiteRawStatement statement = db.createRawStatement(sql);     // Catch: Throwable -> L26
        int size = conditions.size();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= size) goto L20;
        SQLCondition condition = conditions.get(i);     // Catch: Throwable -> L11
        switch(SQLCondition.m1764$$Nest$fgetmColumnFilter(condition).ordinal()) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L15;
            case 7: goto L13;
            default: goto L10;
        };
    L10:
        Slog.w(LOG_TAG, "unknown sql condition " + condition);     // Catch: Throwable -> L11
    L17:
        i = i + 1;     // Catch: Throwable -> L11
        size = size;
        goto L6
    L13:
        Slog.d(LOG_TAG, "No binding for In operator");     // Catch: Throwable -> L11
        goto L17
    L14:
        int size2 = i + 1;     // Catch: Throwable -> L11
        statement.bindLong(size2, Long.parseLong(SQLCondition.m1765$$Nest$fgetmFilterValue(condition).toString()));     // Catch: Throwable -> L11
        goto L17
    L15:
        int size3 = i + 1;     // Catch: Throwable -> L11
        statement.bindInt(size3, Integer.parseInt(SQLCondition.m1765$$Nest$fgetmFilterValue(condition).toString()));     // Catch: Throwable -> L11
        goto L17
    L16:
        int size4 = i + 1;     // Catch: Throwable -> L11
        statement.bindText(size4, SQLCondition.m1765$$Nest$fgetmFilterValue(condition).toString());     // Catch: Throwable -> L11
    L20:
        if (statement.step() == false) goto L22;
        int uid = statement.getColumnInt(0);     // Catch: Throwable -> L11
        String packageName = statement.getColumnText(1);     // Catch: Throwable -> L11
        String deviceId = statement.getColumnText(2);     // Catch: Throwable -> L11
        int opCode = statement.getColumnInt(3);     // Catch: Throwable -> L11
        String attributionTag = statement.getColumnText(4);     // Catch: Throwable -> L11
        long accessTime = statement.getColumnLong(5);     // Catch: Throwable -> L11
        long duration = statement.getColumnLong(6);     // Catch: Throwable -> L11
        int uidState = statement.getColumnInt(7);     // Catch: Throwable -> L11
        int opFlags = statement.getColumnInt(8);     // Catch: Throwable -> L11
        int attributionFlags = statement.getColumnInt(9);     // Catch: Throwable -> L11
        long chainId = statement.getColumnLong(10);     // Catch: Throwable -> L11
        DiscreteOpsSqlRegistry.DiscreteOp event = new DiscreteOpsSqlRegistry.DiscreteOp(uid, packageName, attributionTag, deviceId, opCode, opFlags, attributionFlags, uidState, chainId, accessTime, duration);     // Catch: Throwable -> L11
        results.add(event);     // Catch: Throwable -> L11
        goto L20
    L22:
        db.setTransactionSuccessful();     // Catch: Throwable -> L11
        statement.close();     // Catch: Throwable -> L26
        db.endTransaction();
        return results;
    L11:
        th = move-exception;
        if (statement == null) goto L49;
        statement.close();     // Catch: Throwable -> L31
    L50:
        throw th;     // Catch: Throwable -> L26
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L49:
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        db.endTransaction();
        throw th;
    }

    private String buildSql(List<SQLCondition> conditions, String orderByColumn, boolean ascending, int limit) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT uid,package_name,device_id,op_code,attribution_tag,access_time,access_duration,uid_state,op_flags,attribution_flags,chain_id FROM app_op_accesses");
        if (conditions.isEmpty() == true) goto L10;
        sql.append(" WHERE ");
        int size = conditions.size();
        int i = 0;
    L5:
        if (i >= size) goto L10;
        sql.append(conditions.get(i).toString());
        if (i >= (size - 1)) goto L9;
        sql.append(" AND ");
    L9:
        i = i + 1;
    L10:
        if (orderByColumn == null) goto L16;
        sql.append(" ORDER BY ");
        sql.append(orderByColumn);
        if (ascending == false) goto L14;
        String r1 = " ASC ";
    L15:
        sql.append(r1);
        goto L16
    L14:
        r1 = " DESC ";
    L16:
        if (limit <= 0) goto L19;
        sql.append(" LIMIT ");
        sql.append(limit);
    L19:
        return sql.toString();
    }

    private List<SQLCondition> prepareConditions(long beginTime, long endTime, int requestFilters, int uid, String packageName, String attributionTag, IntArray opCodes, int opFlags) {
        List<SQLCondition> conditions = new ArrayList();
        if (beginTime == (-1)) goto L6;
        conditions.add(new SQLCondition(ColumnFilter.BEGIN_TIME, Long.valueOf(beginTime)));
    L6:
        if (endTime == (-1)) goto L8;
        conditions.add(new SQLCondition(ColumnFilter.END_TIME, Long.valueOf(endTime)));
    L8:
        if (opFlags == 0) goto L10;
        conditions.add(new SQLCondition(ColumnFilter.OP_FLAGS, Integer.valueOf(opFlags)));
    L10:
        if (requestFilters == 0) goto L38;
        if ((requestFilters & 2) == 0) goto L16;
        conditions.add(new SQLCondition(ColumnFilter.PACKAGE_NAME, packageName));
    L16:
        if ((requestFilters & 1) == 0) goto L19;
        conditions.add(new SQLCondition(ColumnFilter.UID, Integer.valueOf(uid)));
    L19:
        if ((requestFilters & 4) == 0) goto L23;
        conditions.add(new SQLCondition(ColumnFilter.ATTR_TAG, attributionTag));
    L23:
        if (opCodes != null) goto L25;
    L27:
        if (opCodes == null) goto L38;
        if (opCodes.size() <= 1) goto L38;
        StringBuilder b = new StringBuilder();
        int size = opCodes.size();
        int i = 0;
    L31:
        if (i >= size) goto L36;
        b.append(opCodes.get(i));
        if (i >= (size - 1)) goto L35;
        b.append(", ");
    L35:
        i = i + 1;
        goto L31
    L36:
        conditions.add(new SQLCondition(ColumnFilter.OP_CODE_IN, b.toString()));
        goto L38
    L25:
        if (opCodes.size() != 1) goto L27;
        conditions.add(new SQLCondition(ColumnFilter.OP_CODE_EQUAL, Integer.valueOf(opCodes.get(0))));
    L38:
        return conditions;
    }

    List<DiscreteOpsSqlRegistry.DiscreteOp> getAllDiscreteOps(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        List<DiscreteOpsSqlRegistry.DiscreteOp> results = new ArrayList();
        db.beginTransactionReadOnly();
        SQLiteRawStatement statement = db.createRawStatement(sql);     // Catch: Throwable -> L14
    L28:
    L8:
        th = move-exception;
        if (statement == null) goto L31;
        statement.close();     // Catch: Throwable -> L19
    L32:
        throw th;     // Catch: Throwable -> L14
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L31:
        throw th;     // Catch: Throwable -> L14
    L6:
        if (statement.step() == false) goto L10;
        int uid = statement.getColumnInt(0);     // Catch: Throwable -> L8
        String packageName = statement.getColumnText(1);     // Catch: Throwable -> L8
        String deviceId = statement.getColumnText(2);     // Catch: Throwable -> L8
        int opCode = statement.getColumnInt(3);     // Catch: Throwable -> L8
        String attributionTag = statement.getColumnText(4);     // Catch: Throwable -> L8
        long accessTime = statement.getColumnLong(5);     // Catch: Throwable -> L8
        long duration = statement.getColumnLong(6);     // Catch: Throwable -> L8
        int uidState = statement.getColumnInt(7);     // Catch: Throwable -> L8
        int opFlags = statement.getColumnInt(8);     // Catch: Throwable -> L8
        int attributionFlags = statement.getColumnInt(9);     // Catch: Throwable -> L8
        long chainId = statement.getColumnLong(10);     // Catch: Throwable -> L8
        DiscreteOpsSqlRegistry.DiscreteOp event = new DiscreteOpsSqlRegistry.DiscreteOp(uid, packageName, attributionTag, deviceId, opCode, opFlags, attributionFlags, uidState, chainId, accessTime, duration);     // Catch: Throwable -> L8
        results.add(event);     // Catch: Throwable -> L8
        goto L28
    L10:
        db.setTransactionSuccessful();     // Catch: Throwable -> L8
        statement.close();     // Catch: Throwable -> L14
        db.endTransaction();
        return results;
    L14:
        th = move-exception;
        db.endTransaction();
        throw th;
    }
}

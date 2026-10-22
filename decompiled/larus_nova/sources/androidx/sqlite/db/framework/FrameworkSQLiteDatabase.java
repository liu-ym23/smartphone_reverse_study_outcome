package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.trace.CopyContentTypeString;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0002[\\B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bH\u0016J3\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u00108J\b\u00109\u001a\u00020(H\u0017J\b\u0010:\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020(H\u0016J)\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0012\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010>J\b\u0010@\u001a\u00020\fH\u0016J \u0010A\u001a\u00020\u00142\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0016J\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0003J\u0010\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020!H\u0016J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020KH\u0016J\u001a\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0017J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\bH\u0016J'\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\fH\u0017J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020!H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010V\u001a\u00020(H\u0016JC\u0010W\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020\fH\u0016J\u0010\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u0014H\u0016R(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006]"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "numBytes", "", "maximumSize", "getMaximumSize", "()J", "setMaximumSize", "(J)V", "pageSize", "getPageSize", "setPageSize", "path", "getPath", "()Ljava/lang/String;", "value", "", "version", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", CopyContentTypeString.TABLE, "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "isDelegate", "sqLiteDatabase", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "Api30Impl", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = null;
    public static final Companion Companion = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private final SQLiteDatabase delegate;

    /* JADX INFO: loaded from: classes17.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Api30Impl;", "", "()V", "execPerConnectionSQL", "", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sql", "", "bindArgs", "", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = null;

        static {
            INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase r100, String r101, Object[] r102) {
            Intrinsics.checkNotNullParameter(r100, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(r101, "sql");
            r100.execPerConnectionSQL(r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Companion;", "", "()V", "CONFLICT_VALUES", "", "", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public static /* synthetic */ Cursor a(SupportSQLiteQuery r100, SQLiteDatabase r101, SQLiteCursorDriver r102, String r103, SQLiteQuery r104) {
        return query$lambda$1(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Cursor b(Function4 r100, SQLiteDatabase r101, SQLiteCursorDriver r102, String r103, SQLiteQuery r104) {
        return query$lambda$0(r100, r101, r102, r103, r104);
    }

    static {
        Companion = new Companion(null);
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.delegate = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "transactionListener");
        this.delegate.beginTransactionWithListener(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sql");
        return new FrameworkSQLiteStatement(this.delegate.compileStatement(r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100) throws SQLException {
        Intrinsics.checkNotNullParameter(r100, "sql");
        this.delegate.execSQL(r100);
    }

    public final boolean isDelegate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "sqLiteDatabase");
        return Intrinsics.areEqual(this.delegate, r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r100) {
        return this.delegate.needUpgrade(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        final Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> r101 = new FrameworkSQLiteDatabase$query$cursorFactory$1(r100);
        return this.delegate.rawQueryWithFactory(new b(r101), r100.getSql(), EMPTY_STRING_ARRAY, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r100) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        this.delegate.setLocale(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r100) {
        this.delegate.setMaxSqlCacheSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r100) {
        this.delegate.setMaximumSize(r100);
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r100) {
        this.delegate.setPageSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r100) {
        this.delegate.setVersion(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r100) {
        return this.delegate.yieldIfContendedSafely(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        return query(new SimpleSQLiteQuery(r100));
    }

    /* JADX INFO: renamed from: setMaximumSize, reason: collision with other method in class */
    public void m7957setMaximumSize(long r100) {
        this.delegate.setMaximumSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "sql");
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 30) goto L7;
        Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, r100, r101);
        return;
    L7:
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100, Object[] r101) throws SQLException {
        Intrinsics.checkNotNullParameter(r100, "sql");
        Intrinsics.checkNotNullParameter(r101, "bindArgs");
        this.delegate.execSQL(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r100, CancellationSignal r101) {
        Intrinsics.checkNotNullParameter(r100, "query");
        SQLiteDatabase r102 = this.delegate;
        String r103 = r100.getSql();
        String[] r104 = EMPTY_STRING_ARRAY;
        Intrinsics.checkNotNull(r101);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(r102, r103, r104, null, r101, new a(r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "bindArgs");
        return query(new SimpleSQLiteQuery(r100, r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r100, String r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r100, CopyContentTypeString.TABLE);
        StringBuilder r103 = new StringBuilder("DELETE FROM ");
        r103.append(r100);
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        r103.append(" WHERE ");
        r103.append(r101);
    L11:
        SupportSQLiteStatement r105 = compileStatement(r103.toString());
        SimpleSQLiteQuery.Companion.bind(r105, r102);
        return r105.executeUpdateDelete();
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r100, int r101, ContentValues r102) throws SQLException {
        Intrinsics.checkNotNullParameter(r100, CopyContentTypeString.TABLE);
        Intrinsics.checkNotNullParameter(r102, "values");
        return this.delegate.insertWithOnConflict(r100, null, r102, r101);
    }

    private static final Cursor query$lambda$0(Function4 r100, SQLiteDatabase r101, SQLiteCursorDriver r102, String r103, SQLiteQuery r104) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return (Cursor) r100.invoke(r101, r102, r103, r104);
    }

    private static final Cursor query$lambda$1(SupportSQLiteQuery r100, SQLiteDatabase r101, SQLiteCursorDriver r102, String r103, SQLiteQuery r104) {
        Intrinsics.checkNotNullParameter(r100, "$query");
        Intrinsics.checkNotNull(r104);
        r100.bindTo(new FrameworkSQLiteProgram(r104));
        return new SQLiteCursor(r102, r103, r104);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r100, int r101, ContentValues r102, String r110, Object[] r111) {
        Intrinsics.checkNotNullParameter(r100, CopyContentTypeString.TABLE);
        Intrinsics.checkNotNullParameter(r102, "values");
        int r103 = 0;
        if (r102.size() == 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L29;
        int r105 = r102.size();
        if (r111 != null) goto L10;
        int r106 = r105;
    L11:
        Object[] r107 = new Object[r106];
        StringBuilder r108 = new StringBuilder("UPDATE ");
        r108.append(CONFLICT_VALUES[r101]);
        r108.append(r100);
        r108.append(" SET ");
        Iterator<String> r109 = r102.keySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L19;
        String r112 = r109.next();
        if (r103 <= 0) goto L17;
        String r113 = ",";
    L18:
        r108.append(r113);
        r108.append(r112);
        r107[r103] = r102.get(r112);
        r108.append("=?");
        r103 = r103 + 1;
        goto L13
    L17:
        r113 = "";
        goto L18
    L19:
        if (r111 == null) goto L24;
        int r114 = r105;
    L21:
        if (r114 >= r106) goto L24;
        r107[r114] = r111[r114 - r105];
        r114 = r114 + 1;
    L24:
        if (TextUtils.isEmpty(r110) == true) goto L26;
        r108.append(" WHERE ");
        r108.append(r110);
    L26:
        SupportSQLiteStatement r115 = compileStatement(r108.toString());
        SimpleSQLiteQuery.Companion.bind(r115, r107);
        return r115.executeUpdateDelete();
    L10:
        r106 = r111.length + r105;
        goto L11
    L29:
        throw new IllegalArgumentException("Empty values".toString());
    L5:
        r104 = false;
        goto L6
    }
}

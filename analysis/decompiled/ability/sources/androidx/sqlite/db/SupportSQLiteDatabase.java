package androidx.sqlite.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import com.stepos.aiengine.args.SingleFileBundle;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0017\u0010\u001aJ-\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0001\u0010\u001d\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0018H&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020$2\u0006\u0010#\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010%J)\u0010#\u001a\u00020$2\u0006\u0010#\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001bH&¢\u0006\u0004\b#\u0010&J\u0017\u0010#\u001a\u00020$2\u0006\u0010#\u001a\u00020'H&¢\u0006\u0004\b#\u0010(J!\u0010#\u001a\u00020$2\u0006\u0010#\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H&¢\u0006\u0004\b#\u0010+J'\u00101\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H&¢\u0006\u0004\b1\u00102J5\u00105\u001a\u00020-2\u0006\u0010,\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u00022\u0012\u00104\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH&¢\u0006\u0004\b5\u00106JE\u00107\u001a\u00020-2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\b\u00103\u001a\u0004\u0018\u00010\u00022\u0012\u00104\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH&¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b9\u0010:J)\u00109\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001bH&¢\u0006\u0004\b9\u0010\u001fJ\u0017\u0010<\u001a\u00020\u00142\u0006\u0010;\u001a\u00020-H&¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>H&¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020-H&¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0014H&¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0014H&¢\u0006\u0004\bH\u0010\u0016J\u000f\u0010I\u001a\u00020\u0007H&¢\u0006\u0004\bI\u0010\tR\u0014\u0010J\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0016R\u0014\u0010K\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0016R\u001c\u0010O\u001a\u00020-8&@&X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010DR\u0014\u0010R\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u001c\u0010V\u001a\u00020\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\bS\u0010Q\"\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0016R\u0014\u0010X\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0016R\u0016\u0010[\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0016R(\u0010a\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020^\u0018\u00010]8&X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006cÀ\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteDatabase;", "Ljava/io/Closeable;", "", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "compileStatement", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "LC7/r;", "beginTransaction", "()V", "beginTransactionNonExclusive", "beginTransactionReadOnly", "Landroid/database/sqlite/SQLiteTransactionListener;", "transactionListener", "beginTransactionWithListener", "(Landroid/database/sqlite/SQLiteTransactionListener;)V", "beginTransactionWithListenerNonExclusive", "beginTransactionWithListenerReadOnly", "endTransaction", "setTransactionSuccessful", "", "inTransaction", "()Z", "yieldIfContendedSafely", "", "sleepAfterYieldDelayMillis", "(J)Z", "", "", "bindArgs", "execPerConnectionSQL", "(Ljava/lang/String;[Ljava/lang/Object;)V", "numBytes", "setMaximumSize", "(J)J", "query", "Landroid/database/Cursor;", "(Ljava/lang/String;)Landroid/database/Cursor;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "insert", "(Ljava/lang/String;ILandroid/content/ContentValues;)J", "whereClause", "whereArgs", "delete", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "execSQL", "(Ljava/lang/String;)V", "newVersion", "needUpgrade", "(I)Z", "Ljava/util/Locale;", "locale", "setLocale", "(Ljava/util/Locale;)V", "cacheSize", "setMaxSqlCacheSize", "(I)V", "enabled", "setForeignKeyConstraintsEnabled", "(Z)V", "enableWriteAheadLogging", "disableWriteAheadLogging", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "getVersion", "()I", "setVersion", "version", "getMaximumSize", "()J", "maximumSize", "getPageSize", "setPageSize", "(J)V", "pageSize", "isReadOnly", "isOpen", "getPath", "()Ljava/lang/String;", SingleFileBundle.KEY_PATH, "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "getAttachedDbs", "()Ljava/util/List;", "attachedDbs", "isDatabaseIntegrityOk", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    default void beginTransactionReadOnly() {
        beginTransaction();
    }

    void beginTransactionWithListener(SQLiteTransactionListener transactionListener);

    void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener);

    default void beginTransactionWithListenerReadOnly(SQLiteTransactionListener transactionListener) {
        k.f(transactionListener, "transactionListener");
        beginTransactionWithListener(transactionListener);
    }

    SupportSQLiteStatement compileStatement(String sql);

    int delete(String table, String whereClause, Object[] whereArgs);

    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    default void execPerConnectionSQL(String sql, @SuppressLint({"ArrayReturn"}) Object[] bindArgs) {
        k.f(sql, "sql");
        throw new UnsupportedOperationException();
    }

    void execSQL(String sql) throws SQLException;

    void execSQL(String sql, Object[] bindArgs) throws SQLException;

    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(String table, int conflictAlgorithm, ContentValues values) throws SQLException;

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    default boolean isExecPerConnectionSQLSupported() {
        return false;
    }

    boolean isOpen();

    boolean isReadOnly();

    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int newVersion);

    Cursor query(SupportSQLiteQuery query);

    Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal);

    Cursor query(String query);

    Cursor query(String query, Object[] bindArgs);

    void setForeignKeyConstraintsEnabled(boolean enabled);

    void setLocale(Locale locale);

    void setMaxSqlCacheSize(int cacheSize);

    long setMaximumSize(long numBytes);

    void setPageSize(long j5);

    void setTransactionSuccessful();

    void setVersion(int i);

    int update(String table, int conflictAlgorithm, ContentValues values, String whereClause, Object[] whereArgs);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long sleepAfterYieldDelayMillis);
}

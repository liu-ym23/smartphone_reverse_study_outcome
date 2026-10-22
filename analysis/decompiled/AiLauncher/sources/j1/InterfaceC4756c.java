package j1;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0001\u0010\u0018\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001dJ)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00022\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0016H&¢\u0006\u0004\b\u001b\u0010\u001eJ\u0017\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001fH&¢\u0006\u0004\b\u001b\u0010 J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0013H&¢\u0006\u0004\b#\u0010\u0015J\u000f\u0010$\u001a\u00020\u0007H&¢\u0006\u0004\b$\u0010\tR\u0014\u0010%\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0015R\u0014\u0010&\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0015R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0015R(\u0010/\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020,\u0018\u00010+8&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, d2 = {"Lj1/c;", "Ljava/io/Closeable;", "", "sql", "Lj1/h;", "compileStatement", "(Ljava/lang/String;)Lj1/h;", "LY8/t;", "beginTransaction", "()V", "beginTransactionNonExclusive", "beginTransactionReadOnly", "Landroid/database/sqlite/SQLiteTransactionListener;", "transactionListener", "beginTransactionWithListener", "(Landroid/database/sqlite/SQLiteTransactionListener;)V", "beginTransactionWithListenerReadOnly", "endTransaction", "setTransactionSuccessful", "", "inTransaction", "()Z", "", "", "bindArgs", "execPerConnectionSQL", "(Ljava/lang/String;[Ljava/lang/Object;)V", "query", "Landroid/database/Cursor;", "(Ljava/lang/String;)Landroid/database/Cursor;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Lj1/f;", "(Lj1/f;)Landroid/database/Cursor;", "execSQL", "(Ljava/lang/String;)V", "enableWriteAheadLogging", "disableWriteAheadLogging", "isExecPerConnectionSQLSupported", "isOpen", "getPath", "()Ljava/lang/String;", "path", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "getAttachedDbs", "()Ljava/util/List;", "attachedDbs", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: j1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC4756c extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    default void beginTransactionReadOnly() {
        beginTransaction();
    }

    void beginTransactionWithListener(SQLiteTransactionListener transactionListener);

    default void beginTransactionWithListenerReadOnly(SQLiteTransactionListener transactionListener) {
        p.i(transactionListener, "transactionListener");
        beginTransactionWithListener(transactionListener);
    }

    h compileStatement(String sql);

    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    default void execPerConnectionSQL(String sql, @SuppressLint({"ArrayReturn"}) Object[] bindArgs) {
        p.i(sql, "sql");
        throw new UnsupportedOperationException();
    }

    void execSQL(String sql) throws SQLException;

    List<Pair<String, String>> getAttachedDbs();

    String getPath();

    boolean inTransaction();

    default boolean isExecPerConnectionSQLSupported() {
        return false;
    }

    boolean isOpen();

    boolean isWriteAheadLoggingEnabled();

    Cursor query(InterfaceC4759f query);

    Cursor query(String query);

    Cursor query(String query, Object[] bindArgs);

    void setTransactionSuccessful();
}

package k0;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;

/* renamed from: k0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0674b extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    j compileStatement(String str);

    void endTransaction();

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    boolean inTransaction();

    boolean isOpen();

    boolean isWriteAheadLoggingEnabled();

    Cursor query(String str);

    Cursor query(i iVar);

    Cursor query(i iVar, CancellationSignal cancellationSignal);

    void setTransactionSuccessful();

    int update(String str, int i4, ContentValues contentValues, String str2, Object[] objArr);
}

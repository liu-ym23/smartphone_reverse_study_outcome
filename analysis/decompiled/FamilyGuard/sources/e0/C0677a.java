package e0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import d0.C0646a;
import d0.InterfaceC0647b;
import d0.InterfaceC0650e;
import d0.InterfaceC0651f;
import java.util.List;
import org.libpag.BuildConfig;

/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0677a implements InterfaceC0647b {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f16633b = {BuildConfig.FLAVOR, " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f16634c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f16635a;

    /* renamed from: e0.a$a, reason: collision with other inner class name */
    class C0208a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0650e f16636a;

        C0208a(InterfaceC0650e interfaceC0650e) {
            this.f16636a = interfaceC0650e;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f16636a.a(new C0680d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    C0677a(SQLiteDatabase sQLiteDatabase) {
        this.f16635a = sQLiteDatabase;
    }

    @Override // d0.InterfaceC0647b
    public void B() {
        this.f16635a.setTransactionSuccessful();
    }

    @Override // d0.InterfaceC0647b
    public long M(String str, int i5, ContentValues contentValues) {
        return this.f16635a.insertWithOnConflict(str, null, contentValues, i5);
    }

    @Override // d0.InterfaceC0647b
    public void P() {
        this.f16635a.endTransaction();
    }

    @Override // d0.InterfaceC0647b
    public Cursor a0(InterfaceC0650e interfaceC0650e) {
        return this.f16635a.rawQueryWithFactory(new C0208a(interfaceC0650e), interfaceC0650e.c(), f16634c, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f16635a.close();
    }

    @Override // d0.InterfaceC0647b
    public Cursor d(String str) {
        return a0(new C0646a(str));
    }

    @Override // d0.InterfaceC0647b
    public String f0() {
        return this.f16635a.getPath();
    }

    @Override // d0.InterfaceC0647b
    public void g() {
        this.f16635a.beginTransaction();
    }

    @Override // d0.InterfaceC0647b
    public List<Pair<String, String>> h() {
        return this.f16635a.getAttachedDbs();
    }

    @Override // d0.InterfaceC0647b
    public boolean i0() {
        return this.f16635a.inTransaction();
    }

    @Override // d0.InterfaceC0647b
    public boolean isOpen() {
        return this.f16635a.isOpen();
    }

    @Override // d0.InterfaceC0647b
    public void k(String str) throws SQLException {
        this.f16635a.execSQL(str);
    }

    @Override // d0.InterfaceC0647b
    public InterfaceC0651f p(String str) {
        return new C0681e(this.f16635a.compileStatement(str));
    }
}

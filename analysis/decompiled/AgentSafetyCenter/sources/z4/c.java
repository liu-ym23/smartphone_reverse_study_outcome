package z4;

import a4.r;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import h5.t;
import java.io.Closeable;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f16382f = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f16383g = new String[0];

    /* renamed from: h, reason: collision with root package name */
    public static final Object f16384h;
    public static final Object i;

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f16385c;

    static {
        jb.e eVar = jb.e.f6757f;
        f16384h = t.G(eVar, new yc.g(5));
        i = t.G(eVar, new yc.g(6));
    }

    public final Cursor A(String str) {
        r rVar = new r();
        rVar.f192c = str;
        VarHandle.storeStoreFence();
        return C(rVar);
    }

    public final Cursor C(y4.e eVar) {
        k2.c cVar = new k2.c(1);
        cVar.f7179f = eVar;
        VarHandle.storeStoreFence();
        SQLiteDatabase sQLiteDatabase = this.f16385c;
        a aVar = new a();
        aVar.f16381a = cVar;
        VarHandle.storeStoreFence();
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(aVar, eVar.n(), f16383g, null);
        cursorRawQueryWithFactory.getClass();
        return cursorRawQueryWithFactory;
    }

    public final void F() {
        this.f16385c.setTransactionSuccessful();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f16385c.close();
    }

    public final void d() {
        this.f16385c.beginTransaction();
    }

    public final void e() {
        this.f16385c.beginTransactionNonExclusive();
    }

    public final j g(String str) throws SQLException {
        str.getClass();
        SQLiteStatement sQLiteStatementCompileStatement = this.f16385c.compileStatement(str);
        sQLiteStatementCompileStatement.getClass();
        j jVar = new j();
        jVar.f16408c = sQLiteStatementCompileStatement;
        jVar.f16409f = sQLiteStatementCompileStatement;
        VarHandle.storeStoreFence();
        return jVar;
    }

    public final void i() {
        this.f16385c.endTransaction();
    }

    public final void n(String str) throws SQLException {
        this.f16385c.execSQL(str);
    }

    public final void o(Object[] objArr) throws SQLException {
        this.f16385c.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    public final boolean r() {
        return this.f16385c.inTransaction();
    }
}

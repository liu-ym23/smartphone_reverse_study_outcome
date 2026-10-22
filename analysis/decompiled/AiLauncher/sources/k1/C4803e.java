package k1;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import j1.C4754a;
import j1.InterfaceC4756c;
import j1.InterfaceC4759f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.r;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 72\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001cJ)\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0010\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001e0\u001dH\u0016¢\u0006\u0004\b\u001a\u0010 J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020!H\u0016¢\u0006\u0004\b\u001a\u0010\"J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0017H\u0016¢\u0006\u0004\b%\u0010\u0019J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0011J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0011J\u0017\u0010)\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0019R\u0016\u00100\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R(\u00106\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b03\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lk1/e;", "Lj1/c;", "Landroid/database/sqlite/SQLiteDatabase;", "delegate", "<init>", "(Landroid/database/sqlite/SQLiteDatabase;)V", "Landroid/database/sqlite/SQLiteTransactionListener;", "transactionListener", "LY8/t;", "G", "(Landroid/database/sqlite/SQLiteTransactionListener;)V", "", "sql", "Lj1/h;", "compileStatement", "(Ljava/lang/String;)Lj1/h;", "beginTransaction", "()V", "beginTransactionNonExclusive", "beginTransactionReadOnly", "beginTransactionWithListener", "endTransaction", "setTransactionSuccessful", "", "inTransaction", "()Z", "query", "Landroid/database/Cursor;", "(Ljava/lang/String;)Landroid/database/Cursor;", "", "", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Lj1/f;", "(Lj1/f;)Landroid/database/Cursor;", "execSQL", "(Ljava/lang/String;)V", "enableWriteAheadLogging", "disableWriteAheadLogging", "close", "sqLiteDatabase", "J", "(Landroid/database/sqlite/SQLiteDatabase;)Z", Const.INTENT_KEY_APIKEY, "Landroid/database/sqlite/SQLiteDatabase;", "isOpen", "getPath", "()Ljava/lang/String;", "path", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "getAttachedDbs", "()Ljava/util/List;", "attachedDbs", Const.INTENT_KEY_PKGNAME, "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: k1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4803e implements InterfaceC4756c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f34579c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f34580d = new String[0];

    /* renamed from: e, reason: collision with root package name */
    public static final Y8.h<Method> f34581e;

    /* renamed from: f, reason: collision with root package name */
    public static final Y8.h<Method> f34582f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SQLiteDatabase delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lk1/e$a;", "", "<init>", "()V", "Ljava/lang/reflect/Method;", "getThreadSessionMethod$delegate", "LY8/h;", Const.INTENT_KEY_UMID, "()Ljava/lang/reflect/Method;", "getThreadSessionMethod", "beginTransactionMethod$delegate", "c", "beginTransactionMethod", "", "", "CONFLICT_VALUES", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: k1.e$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Method c() {
            return (Method) C4803e.f34582f.getValue();
        }

        public final Method d() {
            return (Method) C4803e.f34581e.getValue();
        }

        public Companion() {
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        f34581e = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: k1.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4803e.A();
            }
        });
        f34582f = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: k1.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4803e.n();
            }
        });
    }

    public C4803e(SQLiteDatabase delegate) {
        p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    public static final Method A() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final SQLiteCursor U(InterfaceC4759f interfaceC4759f, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        p.f(sQLiteQuery);
        interfaceC4759f.c(new C4807i(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static final Cursor V(r rVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) rVar.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static final Method n() {
        Class<?> returnType;
        try {
            Method methodD = INSTANCE.d();
            if (methodD == null || (returnType = methodD.getReturnType()) == null) {
                return null;
            }
            Class cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final void G(SQLiteTransactionListener transactionListener) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Companion companion = INSTANCE;
        if (companion.c() == null || companion.d() == null) {
            if (transactionListener != null) {
                beginTransactionWithListener(transactionListener);
                return;
            } else {
                beginTransaction();
                return;
            }
        }
        Method methodC = companion.c();
        p.f(methodC);
        Method methodD = companion.d();
        p.f(methodD);
        Object objInvoke = methodD.invoke(this.delegate, null);
        if (objInvoke == null) {
            throw new IllegalStateException("Required value was null.");
        }
        methodC.invoke(objInvoke, 0, transactionListener, 0, null);
    }

    public final boolean J(SQLiteDatabase sqLiteDatabase) {
        p.i(sqLiteDatabase, "sqLiteDatabase");
        return p.d(this.delegate, sqLiteDatabase);
    }

    @Override // j1.InterfaceC4756c
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionReadOnly() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        G(null);
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        p.i(transactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // j1.InterfaceC4756c
    public j1.h compileStatement(String sql) throws SQLException {
        p.i(sql, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.delegate.compileStatement(sql);
        p.h(sQLiteStatementCompileStatement, "compileStatement(...)");
        return new C4808j(sQLiteStatementCompileStatement);
    }

    @Override // j1.InterfaceC4756c
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // j1.InterfaceC4756c
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // j1.InterfaceC4756c
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // j1.InterfaceC4756c
    public void execSQL(String sql) throws SQLException {
        p.i(sql, "sql");
        this.delegate.execSQL(sql);
    }

    @Override // j1.InterfaceC4756c
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // j1.InterfaceC4756c
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // j1.InterfaceC4756c
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // j1.InterfaceC4756c
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // j1.InterfaceC4756c
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // j1.InterfaceC4756c
    public Cursor query(String query) {
        p.i(query, "query");
        return query(new C4754a(query));
    }

    @Override // j1.InterfaceC4756c
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override // j1.InterfaceC4756c
    public Cursor query(String query, Object[] bindArgs) {
        p.i(query, "query");
        p.i(bindArgs, "bindArgs");
        return query(new C4754a(query, bindArgs));
    }

    @Override // j1.InterfaceC4756c
    public Cursor query(final InterfaceC4759f query) {
        p.i(query, "query");
        final r rVar = new r() { // from class: k1.a
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return C4803e.U(query, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
            }
        };
        Cursor cursorRawQueryWithFactory = this.delegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: k1.b
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return C4803e.V(rVar, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, query.getQuery(), f34580d, null);
        p.h(cursorRawQueryWithFactory, "rawQueryWithFactory(...)");
        return cursorRawQueryWithFactory;
    }
}

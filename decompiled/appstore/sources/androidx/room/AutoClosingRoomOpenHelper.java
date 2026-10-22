package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.apm.constant.CommonKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SupportSQLiteOpenHelper f4436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AutoClosingSupportSQLiteDatabase f4438c;

    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f4439a;

        public AutoClosingSupportSQLiteDatabase(e r10) {
            kotlin.jvm.internal.q.g(r10, "autoCloser");
            this.f4439a = r10;
        }

        public final void a() {
            this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            this.f4439a.j().beginTransaction();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            this.f4439a.j().beginTransactionNonExclusive();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener r10) {
            kotlin.jvm.internal.q.g(r10, "transactionListener");
            this.f4439a.j().beginTransactionWithListener(r10);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10) {
            kotlin.jvm.internal.q.g(r10, "transactionListener");
            this.f4439a.j().beginTransactionWithListenerNonExclusive(r10);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4439a.d();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String r10) {
            kotlin.jvm.internal.q.g(r10, "sql");
            return new AutoClosingSupportSqliteStatement(r10, this.f4439a);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String r10, final String r11, final Object[] r12) {
            kotlin.jvm.internal.q.g(r10, "table");
            return ((Number) this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(r10, r11, r12))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.f4439a.h() == null) goto L11;
            SupportSQLiteDatabase r10 = this.f4439a.h();     // Catch: Throwable -> L7
            kotlin.jvm.internal.q.d(r10);     // Catch: Throwable -> L7
            r10.endTransaction();     // Catch: Throwable -> L7
            this.f4439a.e();
            return;
        L7:
            th = move-exception;
            this.f4439a.e();
            throw th;
        L11:
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r10) {
            kotlin.jvm.internal.q.g(r10, "sql");
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List getAttachedDbs() {
            return (List) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Number) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Number) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Number) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.INSTANCE)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.f4439a.h() != null) goto L6;
            return false;
        L6:
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String r10, final int r11, final ContentValues r12) {
            kotlin.jvm.internal.q.g(r10, "table");
            kotlin.jvm.internal.q.g(r12, "values");
            return ((Number) this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(r10, r11, r12))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.f4439a.h() != null) goto L6;
            return false;
        L6:
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase r10 = this.f4439a.h();
            if (r10 != null) goto L7;
            return false;
        L7:
            return r10.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int r10) {
            return ((Boolean) this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(r10))).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r10) {
            kotlin.jvm.internal.q.g(r10, "query");
            Cursor r11 = this.f4439a.j().query(r10);     // Catch: Throwable -> L6
            return new a(r11, this.f4439a);
        L6:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setForeignKeyConstraintsEnabled(final boolean r10) {
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale r10) {
            kotlin.jvm.internal.q.g(r10, "locale");
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int r10) {
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long r10) {
            return ((Number) this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(r10))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long r10) {
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase r10 = this.f4439a.h();
            if (r10 == null) goto L5;
            r10.setTransactionSuccessful();
            Unit r11 = Unit.f21064a;
        L6:
            if (r11 == null) goto L9;
            return;
        L9:
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        L5:
            r11 = null;
            goto L6
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int r10) {
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String r10, final int r11, final ContentValues r12, final String r13, final Object[] r14) {
            kotlin.jvm.internal.q.g(r10, "table");
            kotlin.jvm.internal.q.g(r12, "values");
            return ((Number) this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(r10, r11, r12, r13, r14))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r10, final Object[] r11) {
            kotlin.jvm.internal.q.g(r10, "sql");
            kotlin.jvm.internal.q.g(r11, "bindArgs");
            this.f4439a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(r10, r11));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long r10) {
            return ((Boolean) this.f4439a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r10, Object[] r11) {
            kotlin.jvm.internal.q.g(r10, "query");
            kotlin.jvm.internal.q.g(r11, "bindArgs");
            Cursor r12 = this.f4439a.j().query(r10, r11);     // Catch: Throwable -> L6
            return new a(r12, this.f4439a);
        L6:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r10) {
            kotlin.jvm.internal.q.g(r10, "query");
            Cursor r11 = this.f4439a.j().query(r10);     // Catch: Throwable -> L6
            return new a(r11, this.f4439a);
        L6:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r10, CancellationSignal r11) {
            kotlin.jvm.internal.q.g(r10, "query");
            Cursor r12 = this.f4439a.j().query(r10, r11);     // Catch: Throwable -> L6
            return new a(r12, this.f4439a);
        L6:
            th = move-exception;
            this.f4439a.e();
            throw th;
        }
    }

    public static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f4441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f4442c;

        public AutoClosingSupportSqliteStatement(String r10, e r11) {
            kotlin.jvm.internal.q.g(r10, "sql");
            kotlin.jvm.internal.q.g(r11, "autoCloser");
            this.f4440a = r10;
            this.f4441b = r11;
            this.f4442c = new ArrayList();
        }

        public static final /* synthetic */ void a(AutoClosingSupportSqliteStatement r10, SupportSQLiteStatement r11) {
            r10.c(r11);
        }

        public static final /* synthetic */ String b(AutoClosingSupportSqliteStatement r10) {
            return r10.f4440a;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int r10, byte[] r11) {
            kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
            e(r10, r11);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int r10, double r11) {
            e(r10, Double.valueOf(r11));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int r10, long r11) {
            e(r10, Long.valueOf(r11));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int r10) {
            e(r10, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int r10, String r11) {
            kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
            e(r10, r11);
        }

        public final void c(SupportSQLiteStatement r10) {
            Iterator r11 = this.f4442c.iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L24;
            r11.next();
            int r13 = r12 + 1;
            if (r12 >= 0) goto L8;
            kotlin.collections.t.q();
        L8:
            Object r14 = this.f4442c.get(r12);
            if (r14 != null) goto L12;
            r10.bindNull(r13);
        L23:
            r12 = r13;
            goto L4
        L12:
            if ((r14 instanceof Long) == false) goto L15;
            r10.bindLong(r13, ((Number) r14).longValue());
            goto L23
        L15:
            if ((r14 instanceof Double) == false) goto L18;
            r10.bindDouble(r13, ((Number) r14).doubleValue());
            goto L23
        L18:
            if ((r14 instanceof String) == false) goto L21;
            r10.bindString(r13, (String) r14);
            goto L23
        L21:
            if ((r14 instanceof byte[]) == false) goto L23;
            r10.bindBlob(r13, (byte[]) r14);
            goto L23
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.f4442c.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final Object d(final Function1 r10) {
            return this.f4441b.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, r10));
        }

        public final void e(int r10, Object r11) {
            int r12 = r10 - 1;
            if (r12 < this.f4442c.size()) goto L9;
            int r13 = this.f4442c.size();
            if (r13 > r12) goto L9;
        L6:
            this.f4442c.add(null);
            if (r13 == r12) goto L9;
            r13 = r13 + 1;
        L9:
            this.f4442c.set(r12, r11);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Number) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Number) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Number) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE);
        }
    }

    public static final class a implements Cursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f4443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f4444b;

        public a(Cursor r10, e r11) {
            kotlin.jvm.internal.q.g(r10, "delegate");
            kotlin.jvm.internal.q.g(r11, "autoCloser");
            this.f4443a = r10;
            this.f4444b = r11;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4443a.close();
            this.f4444b.e();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int r10, CharArrayBuffer r11) {
            this.f4443a.copyStringToBuffer(r10, r11);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.f4443a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int r10) {
            return this.f4443a.getBlob(r10);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f4443a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String r10) {
            return this.f4443a.getColumnIndex(r10);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String r10) {
            return this.f4443a.getColumnIndexOrThrow(r10);
        }

        @Override // android.database.Cursor
        public String getColumnName(int r10) {
            return this.f4443a.getColumnName(r10);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f4443a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f4443a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int r10) {
            return this.f4443a.getDouble(r10);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f4443a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int r10) {
            return this.f4443a.getFloat(r10);
        }

        @Override // android.database.Cursor
        public int getInt(int r10) {
            return this.f4443a.getInt(r10);
        }

        @Override // android.database.Cursor
        public long getLong(int r10) {
            return this.f4443a.getLong(r10);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return c0.c.a(this.f4443a);
        }

        @Override // android.database.Cursor
        public List getNotificationUris() {
            return c0.f.a(this.f4443a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f4443a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int r10) {
            return this.f4443a.getShort(r10);
        }

        @Override // android.database.Cursor
        public String getString(int r10) {
            return this.f4443a.getString(r10);
        }

        @Override // android.database.Cursor
        public int getType(int r10) {
            return this.f4443a.getType(r10);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f4443a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f4443a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f4443a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f4443a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f4443a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f4443a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int r10) {
            return this.f4443a.isNull(r10);
        }

        @Override // android.database.Cursor
        public boolean move(int r10) {
            return this.f4443a.move(r10);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f4443a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f4443a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f4443a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int r10) {
            return this.f4443a.moveToPosition(r10);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f4443a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver r10) {
            this.f4443a.registerContentObserver(r10);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver r10) {
            this.f4443a.registerDataSetObserver(r10);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.f4443a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle r10) {
            return this.f4443a.respond(r10);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle r10) {
            kotlin.jvm.internal.q.g(r10, "extras");
            c0.e.a(this.f4443a, r10);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver r10, Uri r11) {
            this.f4443a.setNotificationUri(r10, r11);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver r10, List r11) {
            kotlin.jvm.internal.q.g(r10, "cr");
            kotlin.jvm.internal.q.g(r11, "uris");
            c0.f.b(this.f4443a, r10, r11);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver r10) {
            this.f4443a.unregisterContentObserver(r10);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver r10) {
            this.f4443a.unregisterDataSetObserver(r10);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper r10, e r11) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        kotlin.jvm.internal.q.g(r11, "autoCloser");
        this.f4436a = r10;
        this.f4437b = r11;
        r11.k(getDelegate());
        this.f4438c = new AutoClosingSupportSQLiteDatabase(r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4438c.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f4436a.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.f4436a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        this.f4438c.a();
        return this.f4438c;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        this.f4438c.a();
        return this.f4438c;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r10) {
        this.f4436a.setWriteAheadLoggingEnabled(r10);
    }
}

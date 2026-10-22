package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final AutoCloser mAutoCloser;
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    /* JADX INFO: loaded from: classes17.dex */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        private final AutoCloser mAutoCloser;

        public static /* synthetic */ Object a(String r100, Object[] r101, SupportSQLiteDatabase r102) {
            return lambda$execSQL$8(r100, r101, r102);
        }

        public static /* synthetic */ Object b(boolean r100, SupportSQLiteDatabase r101) {
            return lambda$setForeignKeyConstraintsEnabled$12(r100, r101);
        }

        public static /* synthetic */ Object c(Locale r100, SupportSQLiteDatabase r101) {
            return lambda$setLocale$10(r100, r101);
        }

        public static /* synthetic */ Integer d(String r100, int r101, ContentValues r102, String r103, Object[] r104, SupportSQLiteDatabase r105) {
            return lambda$update$6(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ Integer e(String r100, String r101, Object[] r102, SupportSQLiteDatabase r103) {
            return lambda$delete$5(r100, r101, r102, r103);
        }

        public static /* synthetic */ Object f(long r100, SupportSQLiteDatabase r101) {
            return lambda$setPageSize$3(r100, r101);
        }

        public static /* synthetic */ Object g(String r100, SupportSQLiteDatabase r101) {
            return lambda$execSQL$7(r100, r101);
        }

        public static /* synthetic */ Long h(long r100, SupportSQLiteDatabase r101) {
            return lambda$setMaximumSize$2(r100, r101);
        }

        public static /* synthetic */ Boolean i(int r100, SupportSQLiteDatabase r101) {
            return lambda$needUpgrade$9(r100, r101);
        }

        public static /* synthetic */ Long j(String r100, int r101, ContentValues r102, SupportSQLiteDatabase r103) {
            return lambda$insert$4(r100, r101, r102, r103);
        }

        public static /* synthetic */ Boolean k(SupportSQLiteDatabase r100) {
            return lambda$isWriteAheadLoggingEnabled$13(r100);
        }

        public static /* synthetic */ Object l(int r100, SupportSQLiteDatabase r101) {
            return lambda$setMaxSqlCacheSize$11(r100, r101);
        }

        private static /* synthetic */ Object lambda$pokeOpen$0(SupportSQLiteDatabase r100) {
            return null;
        }

        public static /* synthetic */ Object m(SupportSQLiteDatabase r100) {
            return lambda$pokeOpen$0(r100);
        }

        public static /* synthetic */ Object n(int r100, SupportSQLiteDatabase r101) {
            return lambda$setVersion$1(r100, r101);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final /* synthetic */ void execPerConnectionSQL(String r100, Object[] r101) {
            SupportSQLiteDatabase.CC.$default$execPerConnectionSQL(this, r100, r101);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return SupportSQLiteDatabase.CC.$default$isExecPerConnectionSQLSupported(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
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
            if (this.mAutoCloser.getDelegateDatabase() == null) goto L11;
            this.mAutoCloser.getDelegateDatabase().endTransaction();     // Catch: Throwable -> L7
            this.mAutoCloser.decrementCountAndScheduleClose();
            return;
        L7:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        L11:
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.mAutoCloser.executeRefCountingFunction(new x());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new d())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new k())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.mAutoCloser.executeRefCountingFunction(new n());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new q())).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() != null) goto L7;
            return false;
        L7:
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new w())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new e())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() != null) goto L7;
            return false;
        L7:
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new r())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase r100 = this.mAutoCloser.getDelegateDatabase();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new s())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new a())).booleanValue();
        }

        public void pokeOpen() {
            this.mAutoCloser.executeRefCountingFunction(new b());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase r100 = this.mAutoCloser.getDelegateDatabase();
            if (r100 == null) goto L7;
            r100.setTransactionSuccessful();
            return;
        L7:
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new o())).booleanValue();
        }

        public AutoClosingSupportSQLiteDatabase(AutoCloser r100) {
            this.mAutoCloser = r100;
        }

        private static /* synthetic */ Boolean lambda$isWriteAheadLoggingEnabled$13(SupportSQLiteDatabase r100) {
            return Boolean.valueOf(r100.isWriteAheadLoggingEnabled());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener r100) {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(r100);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(r100);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String r100) {
            return new AutoClosingSupportSqliteStatement(r100, this.mAutoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r100) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new c(r100));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int r100) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new i(r100))).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r100) {
            Cursor r101 = this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(r100);     // Catch: Throwable -> L5
            return new KeepAliveCursor(r101, this.mAutoCloser);
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setForeignKeyConstraintsEnabled(final boolean r100) {
            this.mAutoCloser.executeRefCountingFunction(new l(r100));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale r100) {
            this.mAutoCloser.executeRefCountingFunction(new v(r100));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int r100) {
            this.mAutoCloser.executeRefCountingFunction(new t(r100));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long r100) {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new h(r100))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long r100) {
            this.mAutoCloser.executeRefCountingFunction(new j(r100));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int r100) {
            this.mAutoCloser.executeRefCountingFunction(new f(r100));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long r100) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new o())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r100) {
            Cursor r101 = this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(r100);     // Catch: Throwable -> L5
            return new KeepAliveCursor(r101, this.mAutoCloser);
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        private static /* synthetic */ Object lambda$execSQL$7(String r100, SupportSQLiteDatabase r101) {
            r101.execSQL(r100);
            return null;
        }

        private static /* synthetic */ Boolean lambda$needUpgrade$9(int r100, SupportSQLiteDatabase r101) {
            return Boolean.valueOf(r101.needUpgrade(r100));
        }

        private static /* synthetic */ Object lambda$setForeignKeyConstraintsEnabled$12(boolean r100, SupportSQLiteDatabase r101) {
            r101.setForeignKeyConstraintsEnabled(r100);
            return null;
        }

        private static /* synthetic */ Object lambda$setLocale$10(Locale r100, SupportSQLiteDatabase r101) {
            r101.setLocale(r100);
            return null;
        }

        private static /* synthetic */ Object lambda$setMaxSqlCacheSize$11(int r100, SupportSQLiteDatabase r101) {
            r101.setMaxSqlCacheSize(r100);
            return null;
        }

        private static /* synthetic */ Long lambda$setMaximumSize$2(long r100, SupportSQLiteDatabase r101) {
            return Long.valueOf(r101.setMaximumSize(r100));
        }

        private static /* synthetic */ Object lambda$setPageSize$3(long r100, SupportSQLiteDatabase r101) {
            r101.setPageSize(r100);
            return null;
        }

        private static /* synthetic */ Object lambda$setVersion$1(int r100, SupportSQLiteDatabase r101) {
            r101.setVersion(r100);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r100, final Object[] r101) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new m(r100, r101));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r100, CancellationSignal r101) {
            Cursor r102 = this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(r100, r101);     // Catch: Throwable -> L5
            return new KeepAliveCursor(r102, this.mAutoCloser);
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r100, Object[] r101) {
            Cursor r102 = this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(r100, r101);     // Catch: Throwable -> L5
            return new KeepAliveCursor(r102, this.mAutoCloser);
        L5:
            th = move-exception;
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        private static /* synthetic */ Object lambda$execSQL$8(String r100, Object[] r101, SupportSQLiteDatabase r102) {
            r102.execSQL(r100, r101);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String r100, final String r101, final Object[] r102) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new g(r100, r101, r102))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String r100, final int r101, final ContentValues r102) throws SQLException {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new p(r100, r101, r102))).longValue();
        }

        private static /* synthetic */ Integer lambda$delete$5(String r100, String r101, Object[] r102, SupportSQLiteDatabase r103) {
            return Integer.valueOf(r103.delete(r100, r101, r102));
        }

        private static /* synthetic */ Long lambda$insert$4(String r100, int r101, ContentValues r102, SupportSQLiteDatabase r103) {
            return Long.valueOf(r103.insert(r100, r101, r102));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String r100, final int r110, final ContentValues r111, final String r112, final Object[] r113) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new u(r100, r110, r111, r112, r113))).intValue();
        }

        private static /* synthetic */ Integer lambda$update$6(String r100, int r101, ContentValues r102, String r103, Object[] r110, SupportSQLiteDatabase r111) {
            return Integer.valueOf(r111.update(r100, r101, r102, r103, r110));
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser mAutoCloser;
        private final ArrayList<Object> mBinds;
        private final String mSql;

        public static /* synthetic */ Object a(SupportSQLiteStatement r100) {
            return lambda$execute$1(r100);
        }

        public static /* synthetic */ Object b(AutoClosingSupportSqliteStatement r100, Function r101, SupportSQLiteDatabase r102) {
            return r100.lambda$executeSqliteStatementWithRefCount$0(r101, r102);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.mBinds.clear();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(new d0());
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Long) executeSqliteStatementWithRefCount(new b0())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Integer) executeSqliteStatementWithRefCount(new y())).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Long) executeSqliteStatementWithRefCount(new c0())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(new z());
        }

        private void doBinds(SupportSQLiteStatement r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.mBinds.size()) goto L21;
            int r102 = r101 + 1;
            Object r103 = ListProtector.get(this.mBinds, r101);
            if (r103 != null) goto L9;
            r100.bindNull(r102);
        L20:
            r101 = r102;
            goto L4
        L9:
            if ((r103 instanceof Long) == false) goto L12;
            r100.bindLong(r102, ((Long) r103).longValue());
            goto L20
        L12:
            if ((r103 instanceof Double) == false) goto L15;
            r100.bindDouble(r102, ((Double) r103).doubleValue());
            goto L20
        L15:
            if ((r103 instanceof String) == false) goto L18;
            r100.bindString(r102, (String) r103);
            goto L20
        L18:
            if ((r103 instanceof byte[]) == false) goto L20;
            r100.bindBlob(r102, (byte[]) r103);
            goto L20
        }

        private <T> T executeSqliteStatementWithRefCount(final Function<SupportSQLiteStatement, T> r100) {
            return (T) this.mAutoCloser.executeRefCountingFunction(new a0(this, r100));
        }

        private static /* synthetic */ Object lambda$execute$1(SupportSQLiteStatement r100) {
            r100.execute();
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int r100) {
            saveBinds(r100, null);
        }

        public AutoClosingSupportSqliteStatement(String r100, AutoCloser r101) {
            this.mBinds = new ArrayList();
            this.mSql = r100;
            this.mAutoCloser = r101;
        }

        private /* synthetic */ Object lambda$executeSqliteStatementWithRefCount$0(Function r100, SupportSQLiteDatabase r101) {
            SupportSQLiteStatement r102 = r101.compileStatement(this.mSql);
            doBinds(r102);
            return r100.apply(r102);
        }

        private void saveBinds(int r100, Object r101) {
            int r102 = r100 - 1;
            if (r102 < this.mBinds.size()) goto L7;
            int r103 = this.mBinds.size();
        L5:
            if (r103 > r102) goto L7;
            this.mBinds.add(null);
            r103 = r103 + 1;
        L7:
            ListProtector.set(this.mBinds, r102, r101);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int r100, byte[] r101) {
            saveBinds(r100, r101);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int r100, double r101) {
            saveBinds(r100, Double.valueOf(r101));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int r100, long r101) {
            saveBinds(r100, Long.valueOf(r101));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int r100, String r101) {
            saveBinds(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class KeepAliveCursor implements Cursor {
        private final AutoCloser mAutoCloser;
        private final Cursor mDelegate;

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.mDelegate);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.mDelegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int r100) {
            return this.mDelegate.getBlob(r100);
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String r100) {
            return this.mDelegate.getColumnIndex(r100);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String r100) throws IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(r100);
        }

        @Override // android.database.Cursor
        public String getColumnName(int r100) {
            return this.mDelegate.getColumnName(r100);
        }

        @Override // android.database.Cursor
        public double getDouble(int r100) {
            return this.mDelegate.getDouble(r100);
        }

        @Override // android.database.Cursor
        public float getFloat(int r100) {
            return this.mDelegate.getFloat(r100);
        }

        @Override // android.database.Cursor
        public int getInt(int r100) {
            return this.mDelegate.getInt(r100);
        }

        @Override // android.database.Cursor
        public long getLong(int r100) {
            return this.mDelegate.getLong(r100);
        }

        @Override // android.database.Cursor
        public short getShort(int r100) {
            return this.mDelegate.getShort(r100);
        }

        @Override // android.database.Cursor
        public String getString(int r100) {
            return this.mDelegate.getString(r100);
        }

        @Override // android.database.Cursor
        public int getType(int r100) {
            return this.mDelegate.getType(r100);
        }

        @Override // android.database.Cursor
        public boolean isNull(int r100) {
            return this.mDelegate.isNull(r100);
        }

        @Override // android.database.Cursor
        public boolean move(int r100) {
            return this.mDelegate.move(r100);
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int r100) {
            return this.mDelegate.moveToPosition(r100);
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver r100) {
            this.mDelegate.registerContentObserver(r100);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver r100) {
            this.mDelegate.registerDataSetObserver(r100);
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle r100) {
            return this.mDelegate.respond(r100);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle r100) {
            SupportSQLiteCompat.Api23Impl.setExtras(this.mDelegate, r100);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver r100) {
            this.mDelegate.unregisterContentObserver(r100);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver r100) {
            this.mDelegate.unregisterDataSetObserver(r100);
        }

        public KeepAliveCursor(Cursor r100, AutoCloser r101) {
            this.mDelegate = r100;
            this.mAutoCloser = r101;
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int r100, CharArrayBuffer r101) {
            this.mDelegate.copyStringToBuffer(r100, r101);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver r100, Uri r101) {
            this.mDelegate.setNotificationUri(r100, r101);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver r100, List<Uri> r101) {
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.mDelegate, r100, r101);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mAutoClosingDb.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        SneakyThrow.reThrow(e);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    public AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    public SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r100) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(r100);
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper r100, AutoCloser r101) {
        this.mDelegateOpenHelper = r100;
        this.mAutoCloser = r101;
        r101.init(r100);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(r101);
    }
}

package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.android.contacts.common.SimContactsConstants;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private final SQLiteDatabase mDelegate;

    static {
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    FrameworkSQLiteDatabase(SQLiteDatabase r1) {
        this.mDelegate = r1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r2) {
        return new FrameworkSQLiteStatement(this.mDelegate.compileStatement(r2));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r1) {
        this.mDelegate.beginTransactionWithListener(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r1) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r1) {
        return this.mDelegate.yieldIfContendedSafely(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r1) {
        this.mDelegate.setVersion(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r1) {
        return this.mDelegate.setMaximumSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r1) {
        this.mDelegate.setPageSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r2) {
        return query(new SimpleSQLiteQuery(r2));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r2, Object[] r3) {
        return query(new SimpleSQLiteQuery(r2, r3));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r4) {
        return this.mDelegate.rawQueryWithFactory(new AnonymousClass1(this, r4), r4.getSql(), EMPTY_STRING_ARRAY, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r7, CancellationSignal r8) {
        return this.mDelegate.rawQueryWithFactory(new AnonymousClass2(this, r7), r7.getSql(), EMPTY_STRING_ARRAY, null, r8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r2, int r3, ContentValues r4) throws SQLException {
        return this.mDelegate.insertWithOnConflict(r2, null, r4, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r3, String r4, Object[] r5) {
        StringBuilder r6 = new StringBuilder("DELETE FROM ").append(r3);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        String r7 = "";
    L6:
        SupportSQLiteStatement r2 = compileStatement(r6.append(r7).toString());
        SimpleSQLiteQuery.bind(r2, r5);
        return r2.executeUpdateDelete();
    L5:
        r7 = " WHERE " + r4;
        goto L6
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r7, int r8, ContentValues r9, String r10, Object[] r11) {
        if (r9 == null) goto L27;
        if (r9.size() == 0) goto L27;
        StringBuilder r0 = new StringBuilder(120);
        r0.append("UPDATE ");
        r0.append(CONFLICT_VALUES[r8]);
        r0.append(r7);
        r0.append(" SET ");
        int r12 = r9.size();
        if (r11 != null) goto L8;
        int r13 = r12;
    L9:
        Object[] r1 = new Object[r13];
        Iterator<String> r2 = r9.keySet().iterator();
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L17;
        String r4 = r2.next();
        if (r3 <= 0) goto L15;
        String r5 = SimContactsConstants.EMAIL_SEP;
    L16:
        r0.append(r5);
        r0.append(r4);
        r1[r3] = r9.get(r4);
        r0.append("=?");
        r3 = r3 + 1;
        goto L11
    L15:
        r5 = "";
        goto L16
    L17:
        if (r11 == null) goto L22;
        int r14 = r12;
    L19:
        if (r14 >= r13) goto L22;
        r1[r14] = r11[r14 - r12];
        r14 = r14 + 1;
    L22:
        if (TextUtils.isEmpty(r10) == true) goto L24;
        r0.append(" WHERE ");
        r0.append(r10);
    L24:
        SupportSQLiteStatement r6 = compileStatement(r0.toString());
        SimpleSQLiteQuery.bind(r6, r1);
        return r6.executeUpdateDelete();
    L8:
        r13 = r11.length + r12;
    L27:
        throw new IllegalArgumentException("Empty values");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r1) throws SQLException {
        this.mDelegate.execSQL(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r1, Object[] r2) throws SQLException {
        this.mDelegate.execSQL(r1, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r1) {
        return this.mDelegate.needUpgrade(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r1) {
        this.mDelegate.setLocale(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r1) {
        this.mDelegate.setMaxSqlCacheSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r1) {
        this.mDelegate.setForeignKeyConstraintsEnabled(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    boolean isDelegate(SQLiteDatabase r1) {
        if (this.mDelegate != r1) goto L5;
        return true;
    L5:
        return false;
    }
}

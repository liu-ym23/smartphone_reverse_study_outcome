package com.android.common.content;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class SQLiteContentProvider extends ContentProvider implements SQLiteTransactionListener {
    private static final int MAX_OPERATIONS_PER_YIELD_POINT = 500;
    private static final int SLEEP_AFTER_YIELD_DELAY = 4000;
    private static final String TAG = "SQLiteContentProvider";
    private final ThreadLocal<Boolean> mApplyingBatch;
    protected SQLiteDatabase mDb;
    private volatile boolean mNotifyChange;
    private SQLiteOpenHelper mOpenHelper;

    protected void beforeTransactionCommit() {
    }

    protected abstract int deleteInTransaction(Uri r1, String r2, String[] r3);

    protected abstract SQLiteOpenHelper getDatabaseHelper(Context r1);

    public int getMaxOperationsPerYield() {
        return 500;
    }

    protected abstract Uri insertInTransaction(Uri r1, ContentValues r2);

    protected abstract void notifyChange();

    protected void onBeginTransaction() {
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onRollback() {
    }

    protected abstract int updateInTransaction(Uri r1, ContentValues r2, String r3, String[] r4);

    public SQLiteContentProvider() {
        this.mApplyingBatch = new ThreadLocal();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mOpenHelper = getDatabaseHelper(getContext());
        return true;
    }

    public SQLiteOpenHelper getDatabaseHelper() {
        return this.mOpenHelper;
    }

    private boolean applyingBatch() {
        if (this.mApplyingBatch.get() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mApplyingBatch.get().booleanValue() == false) goto L7;
        return true;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r3, ContentValues r4) {
        if (applyingBatch() == true) goto L13;
        SQLiteDatabase r0 = this.mOpenHelper.getWritableDatabase();
        this.mDb = r0;
        r0.beginTransactionWithListener(this);
        Uri r5 = insertInTransaction(r3, r4);     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        this.mNotifyChange = true;     // Catch: Throwable -> L10
    L8:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.mDb.endTransaction();
        onEndTransaction();
    L16:
        return r5;
    L10:
        th = move-exception;
        this.mDb.endTransaction();
        throw th;
    L13:
        r5 = insertInTransaction(r3, r4);
        if (r5 == null) goto L16;
        this.mNotifyChange = true;
        goto L16
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri r5, ContentValues[] r6) {
        int r0 = r6.length;
        SQLiteDatabase r1 = this.mOpenHelper.getWritableDatabase();
        this.mDb = r1;
        r1.beginTransactionWithListener(this);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
    L11:
        th = move-exception;
        this.mDb.endTransaction();
        throw th;
    L5:
        if (insertInTransaction(r5, r6[r2]) == null) goto L7;
        this.mNotifyChange = true;     // Catch: Throwable -> L11
    L7:
        boolean r3 = this.mNotifyChange;     // Catch: Throwable -> L11
        SQLiteDatabase r4 = this.mDb;     // Catch: Throwable -> L11
        r4.yieldIfContendedSafely();     // Catch: Throwable -> L11
        this.mDb = r4;     // Catch: Throwable -> L11
        this.mNotifyChange = r3;     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L3
    L8:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L11
        this.mDb.endTransaction();
        onEndTransaction();
        return r0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r3, ContentValues r4, String r5, String[] r6) {
        if (applyingBatch() == true) goto L13;
        SQLiteDatabase r0 = this.mOpenHelper.getWritableDatabase();
        this.mDb = r0;
        r0.beginTransactionWithListener(this);
        int r7 = updateInTransaction(r3, r4, r5, r6);     // Catch: Throwable -> L10
        if (r7 <= 0) goto L8;
        this.mNotifyChange = true;     // Catch: Throwable -> L10
    L8:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.mDb.endTransaction();
        onEndTransaction();
    L16:
        return r7;
    L10:
        th = move-exception;
        this.mDb.endTransaction();
        throw th;
    L13:
        r7 = updateInTransaction(r3, r4, r5, r6);
        if (r7 <= 0) goto L16;
        this.mNotifyChange = true;
        goto L16
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r3, String r4, String[] r5) {
        if (applyingBatch() == true) goto L13;
        SQLiteDatabase r0 = this.mOpenHelper.getWritableDatabase();
        this.mDb = r0;
        r0.beginTransactionWithListener(this);
        int r6 = deleteInTransaction(r3, r4, r5);     // Catch: Throwable -> L10
        if (r6 <= 0) goto L8;
        this.mNotifyChange = true;     // Catch: Throwable -> L10
    L8:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.mDb.endTransaction();
        onEndTransaction();
    L16:
        return r6;
    L10:
        th = move-exception;
        this.mDb.endTransaction();
        throw th;
    L13:
        r6 = deleteInTransaction(r3, r4, r5);
        if (r6 <= 0) goto L16;
        this.mNotifyChange = true;
        goto L16
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> r12) throws OperationApplicationException {
        SQLiteDatabase r0 = this.mOpenHelper.getWritableDatabase();
        this.mDb = r0;
        r0.beginTransactionWithListener(this);
        this.mApplyingBatch.set(true);     // Catch: Throwable -> L21
        int r1 = r12.size();     // Catch: Throwable -> L21
        ContentProviderResult[] r3 = new ContentProviderResult[r1];     // Catch: Throwable -> L21
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r4 >= r1) goto L18;
        r5 = r5 + 1;     // Catch: Throwable -> L21
        if (r5 > getMaxOperationsPerYield()) goto L17;
        ContentProviderOperation r7 = r12.get(r4);     // Catch: Throwable -> L21
        if (r4 <= 0) goto L15;
        if (r7.isYieldAllowed() == false) goto L15;
        boolean r8 = this.mNotifyChange;     // Catch: Throwable -> L21
        if (this.mDb.yieldIfContendedSafely(4000) == false) goto L14;
        this.mDb = this.mOpenHelper.getWritableDatabase();     // Catch: Throwable -> L21
        this.mNotifyChange = r8;     // Catch: Throwable -> L21
        r6 = r6 + 1;     // Catch: Throwable -> L21
    L14:
        r5 = 0;
    L15:
        r3[r4] = r7.apply(this, r3, r4);     // Catch: Throwable -> L21
        r4 = r4 + 1;     // Catch: Throwable -> L21
        goto L4
    L17:
        throw new OperationApplicationException("Too many content provider operations between yield points. The maximum number of operations per yield point is 500", r6);     // Catch: Throwable -> L21
    L18:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L21
        this.mApplyingBatch.set(false);
        this.mDb.endTransaction();
        onEndTransaction();
        return r3;
    L21:
        th = move-exception;
        this.mApplyingBatch.set(false);
        this.mDb.endTransaction();
        onEndTransaction();
        throw th;
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onBegin() {
        onBeginTransaction();
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onCommit() {
        beforeTransactionCommit();
    }

    protected void onEndTransaction() {
        if (this.mNotifyChange == false) goto L6;
        this.mNotifyChange = false;
        notifyChange();
        return;
    }
}

package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkProgress> __insertionAdapterOfWorkProgress;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    @Override // androidx.work.impl.model.WorkProgressDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r100);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r100);
        throw th;
    }

    public WorkProgressDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__insertionAdapterOfWorkProgress = new AnonymousClass1(this, r100);
        this.__preparedStmtOfDelete = new AnonymousClass2(this, r100);
        this.__preparedStmtOfDeleteAll = new AnonymousClass3(this, r100);
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void delete(String r100) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.__preparedStmtOfDelete.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r101);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public Data getProgressForWorkSpecId(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT progress FROM WorkProgress WHERE work_spec_id=?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Data r102 = null;
        Cursor r103 = DBUtil.query(this.__db, r101, false, null);
    L12:
        th = move-exception;
        r103.close();
        r101.release();
        throw th;
    L8:
        if (r103.moveToFirst() == false) goto L10;
        r102 = Data.fromByteArray(r103.getBlob(0));     // Catch: Throwable -> L12
    L10:
        r103.close();
        r101.release();
        return r102;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public List<Data> getProgressForWorkSpecIds(List<String> r100) {
        StringBuilder r101 = StringUtil.newStringBuilder();
        r101.append("SELECT progress FROM WorkProgress WHERE work_spec_id IN (");
        int r102 = r100.size();
        StringUtil.appendPlaceholders(r101, r102);
        r101.append(")");
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire(r101.toString(), r102 + 0);
        Iterator<String> r104 = r100.iterator();
        int r105 = 1;
    L4:
        if (r104.hasNext() == false) goto L10;
        String r106 = r104.next();
        if (r106 != null) goto L8;
        r103.bindNull(r105);
    L9:
        r105 = r105 + 1;
        goto L4
    L8:
        r103.bindString(r105, r106);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r107 = DBUtil.query(this.__db, r103, false, null);
        ArrayList r108 = new ArrayList(r107.getCount());     // Catch: Throwable -> L18
    L13:
        if (r107.moveToNext() == false) goto L16;
        r108.add(Data.fromByteArray(r107.getBlob(0)));     // Catch: Throwable -> L18
        goto L13
    L16:
        r107.close();
        r103.release();
        return r108;
    L18:
        th = move-exception;
        r107.close();
        r103.release();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void insert(WorkProgress r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfWorkProgress.insert(r100);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}

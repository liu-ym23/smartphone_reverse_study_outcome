package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class DependencyDao_Impl implements DependencyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Dependency> __insertionAdapterOfDependency;

    public DependencyDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__insertionAdapterOfDependency = new AnonymousClass1(this, r100);
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getDependentWorkIds(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L14
    L9:
        if (r102.moveToNext() == false) goto L12;
        r103.add(r102.getString(0));     // Catch: Throwable -> L14
        goto L9
    L12:
        r102.close();
        r101.release();
        return r103;
    L14:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getPrerequisites(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L14
    L9:
        if (r102.moveToNext() == false) goto L12;
        r103.add(r102.getString(0));     // Catch: Throwable -> L14
        goto L9
    L12:
        r102.close();
        r101.release();
        return r103;
    L14:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasCompletedAllPrerequisites(String r100) {
        boolean r101 = true;
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r103 = false;
        Cursor r104 = DBUtil.query(this.__db, r102, false, null);
    L16:
        th = move-exception;
        r104.close();
        r102.release();
        throw th;
    L8:
        if (r104.moveToFirst() == false) goto L14;
        if (r104.getInt(0) != 0) goto L13;
        r101 = false;
    L13:
        r103 = r101;
    L14:
        r104.close();
        r102.release();
        return r103;
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasDependents(String r100) {
        boolean r101 = true;
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r103 = false;
        Cursor r104 = DBUtil.query(this.__db, r102, false, null);
    L16:
        th = move-exception;
        r104.close();
        r102.release();
        throw th;
    L8:
        if (r104.moveToFirst() == false) goto L14;
        if (r104.getInt(0) != 0) goto L13;
        r101 = false;
    L13:
        r103 = r101;
    L14:
        r104.close();
        r102.release();
        return r103;
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void insertDependency(Dependency r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfDependency.insert(r100);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}

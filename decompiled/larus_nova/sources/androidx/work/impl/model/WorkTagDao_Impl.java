package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class WorkTagDao_Impl implements WorkTagDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkTag> __insertionAdapterOfWorkTag;

    public WorkTagDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__insertionAdapterOfWorkTag = new AnonymousClass1(this, r100);
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public List<String> getTagsForWorkSpecId(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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

    @Override // androidx.work.impl.model.WorkTagDao
    public List<String> getWorkSpecIdsWithTag(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM worktag WHERE tag=?", 1);
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

    @Override // androidx.work.impl.model.WorkTagDao
    public void insert(WorkTag r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfWorkTag.insert(r100);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}

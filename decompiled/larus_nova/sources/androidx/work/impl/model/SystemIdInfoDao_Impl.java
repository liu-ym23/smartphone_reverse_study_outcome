package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SystemIdInfo> __insertionAdapterOfSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo;

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List<String> getWorkSpecIds() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        ArrayList r102 = new ArrayList(r101.getCount());     // Catch: Throwable -> L10
    L5:
        if (r101.moveToNext() == false) goto L8;
        r102.add(r101.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r101.close();
        r100.release();
        return r102;
    L10:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public SystemIdInfoDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__insertionAdapterOfSystemIdInfo = new AnonymousClass1(this, r100);
        this.__preparedStmtOfRemoveSystemIdInfo = new AnonymousClass2(this, r100);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        SystemIdInfo r102 = null;
        Cursor r103 = DBUtil.query(this.__db, r101, false, null);
        int r104 = CursorUtil.getColumnIndexOrThrow(r103, "work_spec_id");     // Catch: Throwable -> L13
        int r105 = CursorUtil.getColumnIndexOrThrow(r103, "system_id");     // Catch: Throwable -> L13
        if (r103.moveToFirst() == false) goto L11;
        r102 = new SystemIdInfo(r103.getString(r104), r103.getInt(r105));     // Catch: Throwable -> L13
    L11:
        r103.close();
        r101.release();
        return r102;
    L13:
        th = move-exception;
        r103.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(SystemIdInfo r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfSystemIdInfo.insert(r100);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String r100) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.__preparedStmtOfRemoveSystemIdInfo.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo.release(r101);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }
}

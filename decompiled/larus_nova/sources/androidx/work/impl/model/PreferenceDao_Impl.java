package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    public PreferenceDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__insertionAdapterOfPreference = new AnonymousClass1(this, r100);
    }

    public static /* synthetic */ RoomDatabase access$000(PreferenceDao_Impl r100) {
        return r100.__db;
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Long r102 = null;
        Cursor r103 = DBUtil.query(this.__db, r101, false, null);
    L15:
        th = move-exception;
        r103.close();
        r101.release();
        throw th;
    L8:
        if (r103.moveToFirst() == true) goto L10;
    L13:
        r103.close();
        r101.release();
        return r102;
    L10:
        if (r103.isNull(0) == true) goto L13;
        r102 = Long.valueOf(r103.getLong(0));     // Catch: Throwable -> L15
        goto L13
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public LiveData<Long> getObservableLongValue(String r100) {
        final RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, new AnonymousClass2(this, r101));
    L5:
        r101.bindString(1, r100);
        goto L7
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(Preference r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPreference.insert(r100);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}

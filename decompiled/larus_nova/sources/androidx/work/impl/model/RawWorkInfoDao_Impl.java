package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase r100) {
        this.__db = r100;
    }

    private void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> r100) {
        Set<String> r101 = r100.keySet();
        if (r101.isEmpty() == false) goto L6;
        return;
    L6:
        if (r100.size() <= 999) goto L16;
        ArrayMap<String, ArrayList<Data>> r102 = new ArrayMap(999);
        int r103 = r100.size();
        int r104 = 0;
    L8:
        int r105 = 0;
    L9:
        if (r104 >= r103) goto L13;
        r102.put(r100.keyAt(r104), r100.valueAt(r104));
        r104 = r104 + 1;
        r105 = r105 + 1;
        if (r105 != 999) goto L9;
        __fetchRelationshipWorkProgressAsandroidxWorkData(r102);
        r102 = new ArrayMap(999);
        goto L8
    L13:
        if (r105 <= 0) goto L58;
        __fetchRelationshipWorkProgressAsandroidxWorkData(r102);
        return;
    L58:
        return;
    L16:
        StringBuilder r106 = StringUtil.newStringBuilder();
        r106.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int r107 = r101.size();
        StringUtil.appendPlaceholders(r106, r107);
        r106.append(")");
        RoomSQLiteQuery r108 = RoomSQLiteQuery.acquire(r106.toString(), r107 + 0);
        Iterator<String> r109 = r101.iterator();
        int r110 = 1;
    L18:
        if (r109.hasNext() == false) goto L24;
        String r111 = r109.next();
        if (r111 != null) goto L22;
        r108.bindNull(r110);
    L23:
        r110 = r110 + 1;
        goto L18
    L22:
        r108.bindString(r110, r111);
        goto L23
    L24:
        Cursor r112 = DBUtil.query(this.__db, r108, false, null);
        int r113 = CursorUtil.getColumnIndex(r112, "work_spec_id");     // Catch: Throwable -> L40
        if (r113 != (-1)) goto L31;
        r112.close();
        return;
    L31:
        if (r112.moveToNext() == false) goto L38;
        if (r112.isNull(r113) == true) goto L31;
        ArrayList<Data> r114 = r100.get(r112.getString(r113));     // Catch: Throwable -> L40
        if (r114 == null) goto L31;
        r114.add(Data.fromByteArray(r112.getBlob(0)));     // Catch: Throwable -> L40
        goto L31
    L38:
        r112.close();
        return;
    L40:
        th = move-exception;
        r112.close();
        throw th;
    }

    private void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> r100) {
        Set<String> r101 = r100.keySet();
        if (r101.isEmpty() == false) goto L6;
        return;
    L6:
        if (r100.size() <= 999) goto L16;
        ArrayMap<String, ArrayList<String>> r102 = new ArrayMap(999);
        int r103 = r100.size();
        int r104 = 0;
    L8:
        int r105 = 0;
    L9:
        if (r104 >= r103) goto L13;
        r102.put(r100.keyAt(r104), r100.valueAt(r104));
        r104 = r104 + 1;
        r105 = r105 + 1;
        if (r105 != 999) goto L9;
        __fetchRelationshipWorkTagAsjavaLangString(r102);
        r102 = new ArrayMap(999);
        goto L8
    L13:
        if (r105 <= 0) goto L58;
        __fetchRelationshipWorkTagAsjavaLangString(r102);
        return;
    L58:
        return;
    L16:
        StringBuilder r106 = StringUtil.newStringBuilder();
        r106.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int r107 = r101.size();
        StringUtil.appendPlaceholders(r106, r107);
        r106.append(")");
        RoomSQLiteQuery r108 = RoomSQLiteQuery.acquire(r106.toString(), r107 + 0);
        Iterator<String> r109 = r101.iterator();
        int r110 = 1;
    L18:
        if (r109.hasNext() == false) goto L24;
        String r111 = r109.next();
        if (r111 != null) goto L22;
        r108.bindNull(r110);
    L23:
        r110 = r110 + 1;
        goto L18
    L22:
        r108.bindString(r110, r111);
        goto L23
    L24:
        Cursor r112 = DBUtil.query(this.__db, r108, false, null);
        int r113 = CursorUtil.getColumnIndex(r112, "work_spec_id");     // Catch: Throwable -> L40
        if (r113 != (-1)) goto L31;
        r112.close();
        return;
    L31:
        if (r112.moveToNext() == false) goto L38;
        if (r112.isNull(r113) == true) goto L31;
        ArrayList<String> r114 = r100.get(r112.getString(r113));     // Catch: Throwable -> L40
        if (r114 == null) goto L31;
        r114.add(r112.getString(0));     // Catch: Throwable -> L40
        goto L31
    L38:
        r112.close();
        return;
    L40:
        th = move-exception;
        r112.close();
        throw th;
    }

    public static /* synthetic */ RoomDatabase access$000(RawWorkInfoDao_Impl r100) {
        return r100.__db;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery r110) {
        this.__db.assertNotSuspendingTransaction();
        Cursor r111 = DBUtil.query(this.__db, r110, true, null);
        int r100 = CursorUtil.getColumnIndex(r111, "id");     // Catch: Throwable -> L44
        int r101 = CursorUtil.getColumnIndex(r111, "state");     // Catch: Throwable -> L44
        int r102 = CursorUtil.getColumnIndex(r111, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L44
        int r103 = CursorUtil.getColumnIndex(r111, "run_attempt_count");     // Catch: Throwable -> L44
        ArrayMap<String, ArrayList<String>> r104 = new ArrayMap();     // Catch: Throwable -> L44
        ArrayMap<String, ArrayList<Data>> r105 = new ArrayMap();     // Catch: Throwable -> L44
    L5:
        if (r111.moveToNext() == false) goto L16;
        if (r111.isNull(r100) == true) goto L12;
        String r106 = r111.getString(r100);     // Catch: Throwable -> L44
        if (r104.get(r106) != null) goto L12;
        r104.put(r106, new ArrayList());     // Catch: Throwable -> L44
    L12:
        if (r111.isNull(r100) == true) goto L5;
        String r107 = r111.getString(r100);     // Catch: Throwable -> L44
        if (r105.get(r107) != null) goto L5;
        r105.put(r107, new ArrayList());     // Catch: Throwable -> L44
        goto L5
    L16:
        r111.moveToPosition(-1);     // Catch: Throwable -> L44
        __fetchRelationshipWorkTagAsjavaLangString(r104);     // Catch: Throwable -> L44
        __fetchRelationshipWorkProgressAsandroidxWorkData(r105);     // Catch: Throwable -> L44
        ArrayList r108 = new ArrayList(r111.getCount());     // Catch: Throwable -> L44
    L17:
        if (r111.moveToNext() == false) goto L42;
        if (r111.isNull(r100) == true) goto L22;
        ArrayList<String> r109 = r104.get(r111.getString(r100));     // Catch: Throwable -> L44
    L23:
        if (r109 != null) goto L26;
        r109 = new ArrayList();     // Catch: Throwable -> L44
    L26:
        if (r111.isNull(r100) == true) goto L28;
        ArrayList<Data> r112 = r105.get(r111.getString(r100));     // Catch: Throwable -> L44
    L29:
        if (r112 != null) goto L31;
        r112 = new ArrayList();     // Catch: Throwable -> L44
    L31:
        WorkSpec.WorkInfoPojo r113 = new WorkSpec.WorkInfoPojo();     // Catch: Throwable -> L44
        if (r100 == (-1)) goto L34;
        r113.f15688id = r111.getString(r100);     // Catch: Throwable -> L44
    L34:
        if (r101 == (-1)) goto L36;
        r113.state = WorkTypeConverters.intToState(r111.getInt(r101));     // Catch: Throwable -> L44
    L36:
        if (r102 == (-1)) goto L38;
        r113.output = Data.fromByteArray(r111.getBlob(r102));     // Catch: Throwable -> L44
    L38:
        if (r103 == (-1)) goto L40;
        r113.runAttemptCount = r111.getInt(r103);     // Catch: Throwable -> L44
    L40:
        r113.tags = r109;     // Catch: Throwable -> L44
        r113.progress = r112;     // Catch: Throwable -> L44
        r108.add(r113);     // Catch: Throwable -> L44
        goto L17
    L28:
        r112 = null;
        goto L29
    L22:
        r109 = null;
        goto L23
    L42:
        r111.close();
        return r108;
    L44:
        th = move-exception;
        r111.close();
        throw th;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery r100) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new AnonymousClass1(this, r100));
    }

    public static /* synthetic */ void access$100(RawWorkInfoDao_Impl r100, ArrayMap r101) {
        r100.__fetchRelationshipWorkTagAsjavaLangString(r101);
    }

    public static /* synthetic */ void access$200(RawWorkInfoDao_Impl r100, ArrayMap r101) {
        r100.__fetchRelationshipWorkProgressAsandroidxWorkData(r101);
    }
}

package com.obric.cloudsdk.kv.room.manager;

import com.android.contacts.ContactSaveService;
import com.obric.cloudsdk.kv.base.KvLog;
import com.obric.cloudsdk.kv.room.AbsDatabase;
import com.obric.cloudsdk.kv.room.DbManager;
import com.obric.cloudsdk.kv.room.dao.DataSyncStateDao;
import com.obric.cloudsdk.kv.room.model.DataSyncStateModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataSyncStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bJ\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bJ\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/cloudsdk/kv/room/manager/DataSyncStateManager;", "", "()V", "TAG", "", "delete", "", "dataSyncState", "Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;", "(Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;)Ljava/lang/Integer;", "getAll", "", "getByDataIdAndTableName", ContactSaveService.EXTRA_DATA_ID, "", "tableName", "insert", "(Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;)Ljava/lang/Long;", "insertAll", "", "dataSyncStateList", "(Ljava/util/List;)Lkotlin/Unit;", "setDeletedState", "update", "(JLjava/lang/String;)Ljava/lang/Integer;", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataSyncStateManager {
    public static final DataSyncStateManager INSTANCE = null;
    private static final String TAG = "DataSyncStateManager";

    static {
        INSTANCE = new DataSyncStateManager();
    }

    private DataSyncStateManager() {
    }

    public final synchronized List<DataSyncStateModel> getAll() {
        monitor-enter(this);
        KvLog.INSTANCE.d(TAG, "getAll");     // Catch: Throwable -> L16
        Integer r3 = null;
        AbsDatabase r1 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Throwable -> L16
        if (r1 == null) goto L9;
        DataSyncStateDao r2 = r1.dataSyncStateDao();     // Catch: Throwable -> L16
        if (r2 == null) goto L9;
        List<DataSyncStateModel> r4 = r2.getAll();     // Catch: Throwable -> L16
    L10:
        KvLog r5 = KvLog.INSTANCE;     // Catch: Throwable -> L16
        StringBuilder r6 = new StringBuilder("getAll, result: ");     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        r3 = Integer.valueOf(r4.size());     // Catch: Throwable -> L16
    L13:
        r5.d(TAG, r6.append(r3).toString());     // Catch: Throwable -> L16
        monitor-exit(this);
        return r4;
    L9:
        r4 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized List<DataSyncStateModel> getByDataIdAndTableName(long r6, String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "tableName");     // Catch: Throwable -> L21
        KvLog.INSTANCE.d(TAG, "getByDataIdAndTableName, dataId: " + r6 + ", tableName: " + r8);     // Catch: Throwable -> L21
        Integer r1 = null;
        AbsDatabase r2 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L12 Throwable -> L21
        if (r2 == null) goto L14;
        DataSyncStateDao r3 = r2.dataSyncStateDao();     // Catch: Exception -> L12 Throwable -> L21
        if (r3 == null) goto L14;
        List<DataSyncStateModel> r7 = r3.getDataSyncState(r6, r8);     // Catch: Exception -> L12 Throwable -> L21
    L15:
        KvLog r9 = KvLog.INSTANCE;     // Catch: Throwable -> L21
        StringBuilder r4 = new StringBuilder("getByDataIdAndTableName, result: ");     // Catch: Throwable -> L21
        if (r7 == null) goto L18;
        r1 = Integer.valueOf(r7.size());     // Catch: Throwable -> L21
    L18:
        r9.d(TAG, r4.append(r1).toString());     // Catch: Throwable -> L21
        monitor-exit(this);
        return r7;
    L14:
        r7 = null;
    L12:
        e = move-exception;
        KvLog.INSTANCE.e(TAG, "getByDataIdAndTableName, error", e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized Long insert(DataSyncStateModel r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "dataSyncState");     // Catch: Throwable -> L17
        Long r2 = null;
        KvLog.INSTANCE.d(TAG, "insert, dataSyncState: " + r7);     // Catch: Exception -> L13 Throwable -> L17
        AbsDatabase r1 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L13 Throwable -> L17
        if (r1 == null) goto L11;
        DataSyncStateDao r3 = r1.dataSyncStateDao();     // Catch: Exception -> L13 Throwable -> L17
        if (r3 == null) goto L11;
        r2 = Long.valueOf(r3.insert(r7));     // Catch: Exception -> L13 Throwable -> L17
    L11:
        monitor-exit(this);
        return r2;
    L13:
        e = move-exception;
        KvLog.INSTANCE.w(TAG, "insert, error:" + e.getMessage());     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized Unit insertAll(List<DataSyncStateModel> r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "dataSyncStateList");     // Catch: Throwable -> L17
        Unit r2 = null;
        KvLog.INSTANCE.d(TAG, "insertAll, dataSyncStateList: " + r7);     // Catch: Exception -> L13 Throwable -> L17
        AbsDatabase r1 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L13 Throwable -> L17
        if (r1 == null) goto L11;
        DataSyncStateDao r3 = r1.dataSyncStateDao();     // Catch: Exception -> L13 Throwable -> L17
        if (r3 == null) goto L11;
        DataSyncStateModel[] r8 = (DataSyncStateModel[]) r7.toArray(new DataSyncStateModel[0]);     // Catch: Exception -> L13 Throwable -> L17
        r3.insertAll((DataSyncStateModel[]) Arrays.copyOf(r8, r8.length));     // Catch: Exception -> L13 Throwable -> L17
        r2 = Unit.INSTANCE;     // Catch: Exception -> L13 Throwable -> L17
    L11:
        monitor-exit(this);
        return r2;
    L13:
        e = move-exception;
        KvLog.INSTANCE.w(TAG, "insertAll, error:" + e.getMessage());     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized Integer delete(DataSyncStateModel r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "dataSyncState");     // Catch: Throwable -> L17
        Integer r2 = null;
        KvLog.INSTANCE.d(TAG, "delete, dataSyncState: " + r7);     // Catch: Exception -> L13 Throwable -> L17
        AbsDatabase r1 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L13 Throwable -> L17
        if (r1 == null) goto L11;
        DataSyncStateDao r3 = r1.dataSyncStateDao();     // Catch: Exception -> L13 Throwable -> L17
        if (r3 == null) goto L11;
        r2 = Integer.valueOf(r3.delete(r7));     // Catch: Exception -> L13 Throwable -> L17
    L11:
        monitor-exit(this);
        return r2;
    L13:
        e = move-exception;
        KvLog.INSTANCE.w(TAG, "delete, error:" + e.getMessage());     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized Integer setDeletedState(DataSyncStateModel r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "dataSyncState");     // Catch: Throwable -> L16
        Integer r2 = null;
        KvLog.INSTANCE.d(TAG, "setDeletedState, dataSyncState: " + r8);     // Catch: Exception -> L12 Throwable -> L16
        r8.setDeleted(1);     // Catch: Exception -> L12 Throwable -> L16
        r8.setDirty(1);     // Catch: Exception -> L12 Throwable -> L16
        r8.setLastUpdateTime(System.currentTimeMillis() / ((long) 1000));     // Catch: Exception -> L12 Throwable -> L16
        r8.setLastUpdateTime2(System.currentTimeMillis());     // Catch: Exception -> L12 Throwable -> L16
        AbsDatabase r1 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L12 Throwable -> L16
        if (r1 == null) goto L14;
        DataSyncStateDao r3 = r1.dataSyncStateDao();     // Catch: Exception -> L12 Throwable -> L16
        if (r3 == null) goto L14;
        r2 = Integer.valueOf(r3.update(r8));     // Catch: Exception -> L12 Throwable -> L16
        goto L14
    L14:
        monitor-exit(this);
        return r2;
    L12:
        e = move-exception;
        KvLog.INSTANCE.w(TAG, "setDeletedState, error:" + e.getMessage());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized Integer update(long r13, String r15) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r15, "tableName");     // Catch: Throwable -> L33
        Integer r3 = null;
        KvLog.INSTANCE.d(TAG, "update, dataId: " + r13 + ", tableName: " + r15);     // Catch: Exception -> L29 Throwable -> L33
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L29 Throwable -> L33
        AbsDatabase r2 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L29 Throwable -> L33
        if (r2 == null) goto L13;
        DataSyncStateDao r4 = r2.dataSyncStateDao();     // Catch: Exception -> L29 Throwable -> L33
        if (r4 == null) goto L13;
        DataSyncStateModel r5 = r4.getSyncId(r13, r15);     // Catch: Exception -> L29 Throwable -> L33
        if (r5 == null) goto L13;
        String r7 = r5.getSyncId();     // Catch: Exception -> L29 Throwable -> L33
    L14:
        String r6 = r7;     // Catch: Exception -> L29 Throwable -> L33
        if (r6 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L27;
        AbsDatabase r14 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L29 Throwable -> L33
        if (r14 == null) goto L31;
        DataSyncStateDao r9 = r14.dataSyncStateDao();     // Catch: Exception -> L29 Throwable -> L33
        if (r9 == null) goto L31;
        r3 = Integer.valueOf(r9.update(r7, r10 / ((long) 1000), r10));     // Catch: Exception -> L29 Throwable -> L33
    L31:
        monitor-exit(this);
        return r3;
    L27:
        KvLog.INSTANCE.w(TAG, "update, syncId is null, dataId: " + r13 + ", tableName: " + r15);     // Catch: Exception -> L29 Throwable -> L33
        goto L31
    L17:
        if (r6.length() == 0) goto L20;
        r8 = false;
    L13:
        r7 = null;
    L29:
        e = move-exception;
        KvLog.INSTANCE.w(TAG, "update, error:" + e.getMessage());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public final synchronized void update(DataSyncStateModel r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "dataSyncState");     // Catch: Throwable -> L15
        KvLog.INSTANCE.d(TAG, "update, dataSyncState: " + r6);     // Catch: Exception -> L11 Throwable -> L15
        AbsDatabase r1 = DbManager.getInstance$default(DbManager.INSTANCE, null, 1, null);     // Catch: Exception -> L11 Throwable -> L15
        if (r1 == null) goto L13;
        DataSyncStateDao r2 = r1.dataSyncStateDao();     // Catch: Exception -> L11 Throwable -> L15
        if (r2 == null) goto L13;
        r2.update(r6);     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        KvLog.INSTANCE.w(TAG, "update, error:" + e.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}

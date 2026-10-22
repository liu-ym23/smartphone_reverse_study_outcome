package com.obric.cloudsdk.kv.room.model;

import com.android.contacts.ContactSaveService;
import com.obric.cloudsdk.kv.base.KvSyncUtil;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataSyncStateModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b5\b\u0007\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001e\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001e\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001e\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001e\u0010&\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010)\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\rR\u001e\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001e\u00101\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R\u001e\u00106\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R\u001e\u00109\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012¨\u0006<"}, d2 = {"Lcom/obric/cloudsdk/kv/room/model/DataSyncStateModel;", "", ContactSaveService.EXTRA_DATA_ID, "", "tableName", "", "shouldSync", "", "(JLjava/lang/String;I)V", "_id", "get_id", "()I", "set_id", "(I)V", "cloudId", "getCloudId", "()Ljava/lang/String;", "setCloudId", "(Ljava/lang/String;)V", "getDataId", "()J", "setDataId", "(J)V", "deleted", "getDeleted", "setDeleted", "dirty", "getDirty", "setDirty", "hash", "getHash", "setHash", "lastSyncTime", "getLastSyncTime", "setLastSyncTime", "lastUpdateTime", "getLastUpdateTime", "setLastUpdateTime", "lastUpdateTime2", "getLastUpdateTime2", "setLastUpdateTime2", "operateCursor", "getOperateCursor", "setOperateCursor", "getShouldSync", "setShouldSync", "syncId", "getSyncId", "setSyncId", "syncType", "getSyncType", "setSyncType", "getTableName", "setTableName", "uniqueId", "getUniqueId", "setUniqueId", AccountInfoBundleKey.USER_ID, "getUserId", "setUserId", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataSyncStateModel {
    private int _id;
    private String cloudId;
    private long dataId;
    private int deleted;
    private int dirty;
    private int hash;
    private long lastSyncTime;
    private long lastUpdateTime;
    private long lastUpdateTime2;
    private long operateCursor;
    private int shouldSync;
    private String syncId;
    private int syncType;
    private String tableName;
    private String uniqueId;
    private String userId;

    public final int get_id() {
        return this._id;
    }

    public final void set_id(int r1) {
        this._id = r1;
    }

    public final long getDataId() {
        return this.dataId;
    }

    public final void setDataId(long r1) {
        this.dataId = r1;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    public final String getSyncId() {
        return this.syncId;
    }

    public final void setSyncId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.syncId = r2;
    }

    public final long getOperateCursor() {
        return this.operateCursor;
    }

    public final void setOperateCursor(long r1) {
        this.operateCursor = r1;
    }

    public final int getDeleted() {
        return this.deleted;
    }

    public final void setDeleted(int r1) {
        this.deleted = r1;
    }

    public final int getDirty() {
        return this.dirty;
    }

    public final void setDirty(int r1) {
        this.dirty = r1;
    }

    public final int getShouldSync() {
        return this.shouldSync;
    }

    public final void setShouldSync(int r1) {
        this.shouldSync = r1;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final void setTableName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tableName = r2;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final void setLastUpdateTime(long r1) {
        this.lastUpdateTime = r1;
    }

    public final long getLastSyncTime() {
        return this.lastSyncTime;
    }

    public final void setLastSyncTime(long r1) {
        this.lastSyncTime = r1;
    }

    public final int getHash() {
        return this.hash;
    }

    public final void setHash(int r1) {
        this.hash = r1;
    }

    public final int getSyncType() {
        return this.syncType;
    }

    public final void setSyncType(int r1) {
        this.syncType = r1;
    }

    public final String getCloudId() {
        return this.cloudId;
    }

    public final void setCloudId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cloudId = r2;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uniqueId = r2;
    }

    public final long getLastUpdateTime2() {
        return this.lastUpdateTime2;
    }

    public final void setLastUpdateTime2(long r1) {
        this.lastUpdateTime2 = r1;
    }

    public DataSyncStateModel(long r3, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "tableName");
        this.userId = "";
        this.syncId = "";
        boolean r1 = true;
        this.dirty = 1;
        this.cloudId = "";
        this.uniqueId = "";
        this.dataId = r3;
        this.tableName = r5;
        this.shouldSync = r6;
        KvSyncUtil r7 = KvSyncUtil.INSTANCE;
        if (r6 == 1) goto L6;
        r1 = false;
    L6:
        this.syncId = r7.generateSyncId(r3, r1);
        this.lastUpdateTime = System.currentTimeMillis() / ((long) 1000);
        this.lastUpdateTime2 = System.currentTimeMillis();
    }

    public /* synthetic */ DataSyncStateModel(long r1, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 1;
    L8:
        this(r1, r3, r4);
    }
}

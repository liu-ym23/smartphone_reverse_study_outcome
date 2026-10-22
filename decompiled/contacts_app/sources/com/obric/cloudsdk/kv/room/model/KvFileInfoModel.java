package com.obric.cloudsdk.kv.room.model;

import com.bytedance.apm.constant.PerfConsts;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: KvFileInfoModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/obric/cloudsdk/kv/room/model/KvFileInfoModel;", "", "()V", "_id", "", "get_id", "()I", "set_id", "(I)V", "fileId", "", "getFileId", "()Ljava/lang/String;", "setFileId", "(Ljava/lang/String;)V", "localPath", "getLocalPath", "setLocalPath", "md5", "getMd5", "setMd5", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", AccountInfoBundleKey.USER_ID, "getUserId", "setUserId", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvFileInfoModel {
    private int _id;
    private String fileId;
    private String localPath;
    private String md5;
    private Long size;
    private String userId;

    public KvFileInfoModel() {
        this.size = 0L;
    }

    public final int get_id() {
        return this._id;
    }

    public final void set_id(int r1) {
        this._id = r1;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final void setLocalPath(String r1) {
        this.localPath = r1;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final void setFileId(String r1) {
        this.fileId = r1;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String r1) {
        this.userId = r1;
    }

    public final Long getSize() {
        return this.size;
    }

    public final void setSize(Long r1) {
        this.size = r1;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String r1) {
        this.md5 = r1;
    }
}

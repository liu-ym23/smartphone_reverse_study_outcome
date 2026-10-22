package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.BackupSEI")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\u0000J\b\u0010\"\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/BackupSeiModel;", "", "()V", "backupFromSource", "", "getBackupFromSource", "()Ljava/lang/String;", "setBackupFromSource", "(Ljava/lang/String;)V", "backupSei", "getBackupSei", "setBackupSei", "keyFrameOnly", "", "getKeyFrameOnly", "()Z", "setKeyFrameOnly", "(Z)V", "pts", "", "getPts", "()J", "setPts", "(J)V", "seiIndex", "getSeiIndex", "setSeiIndex", "seiKeyList", "", "getSeiKeyList", "()Ljava/util/List;", "setSeiKeyList", "(Ljava/util/List;)V", "deepCopy", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BackupSeiModel implements vh7.h {
    private String backupFromSource;

    @SerializedName("sei")
    protected String backupSei;

    @SerializedName("key_frame_only")
    protected boolean keyFrameOnly;

    @SerializedName("pts")
    protected long pts;

    @SerializedName("sei_index")
    protected long seiIndex;

    @SerializedName("sei_key_list")
    protected List<String> seiKeyList;

    public final BackupSeiModel deepCopy() {
        BackupSeiModel r100 = new BackupSeiModel();
        r100.seiKeyList = this.seiKeyList;
        r100.backupSei = this.backupSei;
        r100.seiIndex = this.seiIndex;
        r100.keyFrameOnly = this.keyFrameOnly;
        r100.backupFromSource = this.backupFromSource;
        return r100;
    }

    public String toString() {
        return "{\"pts\": " + this.pts + ", \"sei_key_list\": " + this.seiKeyList + ", \"backupFromSource\": " + this.backupFromSource + ", \"sei\": " + this.backupSei + '}';
    }

    public BackupSeiModel() {
        this.backupFromSource = "";
    }

    public final String getBackupFromSource() {
        return this.backupFromSource;
    }

    public final String getBackupSei() {
        return this.backupSei;
    }

    public final boolean getKeyFrameOnly() {
        return this.keyFrameOnly;
    }

    public final long getPts() {
        return this.pts;
    }

    public final long getSeiIndex() {
        return this.seiIndex;
    }

    public final List<String> getSeiKeyList() {
        return this.seiKeyList;
    }

    public BackupSeiModel(am3.g r100) {
        this.seiKeyList = new ArrayList();
        this.backupFromSource = "";
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.pts = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.seiKeyList.add(am3.h.c(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.backupSei = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.seiIndex = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.keyFrameOnly = am3.h.a(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setBackupFromSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.backupFromSource = r100;
    }

    public final void setBackupSei(String r100) {
        this.backupSei = r100;
    }

    public final void setKeyFrameOnly(boolean r100) {
        this.keyFrameOnly = r100;
    }

    public final void setPts(long r100) {
        this.pts = r100;
    }

    public final void setSeiIndex(long r100) {
        this.seiIndex = r100;
    }

    public final void setSeiKeyList(List<String> r100) {
        this.seiKeyList = r100;
    }
}

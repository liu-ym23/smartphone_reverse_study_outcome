package com.stepos.ailauncher.taskstore.chat;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/F;", "", "", "taskId", "versionId", "", "Lcom/stepos/ailauncher/taskstore/chat/E;", "artifacts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "getVersionId", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.F, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskResultCodePayload {

    @SerializedName("artifacts")
    private final List<TaskResultCodeItem> artifacts;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("version_id")
    private final String versionId;

    public TaskResultCodePayload() {
        this(null, null, null, 7, null);
    }

    public final List<TaskResultCodeItem> a() {
        return this.artifacts;
    }

    /* renamed from: b, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultCodePayload)) {
            return false;
        }
        TaskResultCodePayload taskResultCodePayload = (TaskResultCodePayload) other;
        return kotlin.jvm.internal.p.d(this.taskId, taskResultCodePayload.taskId) && kotlin.jvm.internal.p.d(this.versionId, taskResultCodePayload.versionId) && kotlin.jvm.internal.p.d(this.artifacts, taskResultCodePayload.artifacts);
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.versionId;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.artifacts.hashCode();
    }

    public String toString() {
        return "TaskResultCodePayload(taskId=" + this.taskId + ", versionId=" + this.versionId + ", artifacts=" + this.artifacts + ")";
    }

    public TaskResultCodePayload(String str, String str2, List<TaskResultCodeItem> artifacts) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        this.taskId = str;
        this.versionId = str2;
        this.artifacts = artifacts;
    }

    public /* synthetic */ TaskResultCodePayload(String str, String str2, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? C1173v.m() : list);
    }
}

package com.stepos.ailauncher.taskstore.database;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/c;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "artKey", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "taskId", "c", "", "downloadedAt", "J", Const.INTENT_KEY_PKGNAME, "()J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.database.c, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DownloadedArtifactEntity {
    private final String artKey;
    private final long downloadedAt;
    private final String taskId;

    /* renamed from: a, reason: from getter */
    public final String getArtKey() {
        return this.artKey;
    }

    /* renamed from: b, reason: from getter */
    public final long getDownloadedAt() {
        return this.downloadedAt;
    }

    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadedArtifactEntity)) {
            return false;
        }
        DownloadedArtifactEntity downloadedArtifactEntity = (DownloadedArtifactEntity) other;
        return kotlin.jvm.internal.p.d(this.artKey, downloadedArtifactEntity.artKey) && kotlin.jvm.internal.p.d(this.taskId, downloadedArtifactEntity.taskId) && this.downloadedAt == downloadedArtifactEntity.downloadedAt;
    }

    public int hashCode() {
        return (((this.artKey.hashCode() * 31) + this.taskId.hashCode()) * 31) + Long.hashCode(this.downloadedAt);
    }

    public String toString() {
        return "DownloadedArtifactEntity(artKey=" + this.artKey + ", taskId=" + this.taskId + ", downloadedAt=" + this.downloadedAt + ")";
    }
}

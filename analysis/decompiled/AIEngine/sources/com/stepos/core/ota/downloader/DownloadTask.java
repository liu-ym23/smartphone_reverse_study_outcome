package com.stepos.core.ota.downloader;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadTask {
    private final long createdAtMillis;
    private long downloaded;
    private final String file;
    private final int groupId;

    /* renamed from: id, reason: collision with root package name */
    private final int f7574id;
    private long total;
    private final String url;

    public DownloadTask(int i10, int i11, String url, String file, long j10, long j11, long j12) {
        g.f(url, "url");
        g.f(file, "file");
        this.f7574id = i10;
        this.groupId = i11;
        this.url = url;
        this.file = file;
        this.downloaded = j10;
        this.total = j11;
        this.createdAtMillis = j12;
    }

    public static /* synthetic */ DownloadTask copy$default(DownloadTask downloadTask, int i10, int i11, String str, String str2, long j10, long j11, long j12, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = downloadTask.f7574id;
        }
        if ((i12 & 2) != 0) {
            i11 = downloadTask.groupId;
        }
        if ((i12 & 4) != 0) {
            str = downloadTask.url;
        }
        if ((i12 & 8) != 0) {
            str2 = downloadTask.file;
        }
        if ((i12 & 16) != 0) {
            j10 = downloadTask.downloaded;
        }
        if ((i12 & 32) != 0) {
            j11 = downloadTask.total;
        }
        if ((i12 & 64) != 0) {
            j12 = downloadTask.createdAtMillis;
        }
        long j13 = j12;
        long j14 = j11;
        long j15 = j10;
        return downloadTask.copy(i10, i11, str, str2, j15, j14, j13);
    }

    public final int component1() {
        return this.f7574id;
    }

    public final int component2() {
        return this.groupId;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.file;
    }

    public final long component5() {
        return this.downloaded;
    }

    public final long component6() {
        return this.total;
    }

    public final long component7() {
        return this.createdAtMillis;
    }

    public final DownloadTask copy(int i10, int i11, String url, String file, long j10, long j11, long j12) {
        g.f(url, "url");
        g.f(file, "file");
        return new DownloadTask(i10, i11, url, file, j10, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadTask)) {
            return false;
        }
        DownloadTask downloadTask = (DownloadTask) obj;
        return this.f7574id == downloadTask.f7574id && this.groupId == downloadTask.groupId && g.b(this.url, downloadTask.url) && g.b(this.file, downloadTask.file) && this.downloaded == downloadTask.downloaded && this.total == downloadTask.total && this.createdAtMillis == downloadTask.createdAtMillis;
    }

    public final long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final long getDownloaded() {
        return this.downloaded;
    }

    public final String getFile() {
        return this.file;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.f7574id;
    }

    public final long getTotal() {
        return this.total;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Long.hashCode(this.createdAtMillis) + a0.a.c(a0.a.c(v1.d.a(v1.d.a(ai.onnxruntime.a.d(this.groupId, Integer.hashCode(this.f7574id) * 31, 31), 31, this.url), 31, this.file), this.downloaded, 31), this.total, 31);
    }

    public final void setDownloaded(long j10) {
        this.downloaded = j10;
    }

    public final void setTotal(long j10) {
        this.total = j10;
    }

    public String toString() {
        int i10 = this.f7574id;
        int i11 = this.groupId;
        String str = this.url;
        String str2 = this.file;
        long j10 = this.downloaded;
        long j11 = this.total;
        long j12 = this.createdAtMillis;
        StringBuilder sbD = h0.e.d(i10, "DownloadTask(id=", i11, ", groupId=", ", url=");
        ai.onnxruntime.a.z(sbD, str, ", file=", str2, ", downloaded=");
        sbD.append(j10);
        a0.a.s(j11, ", total=", ", createdAtMillis=", sbD);
        return ai.onnxruntime.a.m(sbD, j12, ")");
    }

    public /* synthetic */ DownloadTask(int i10, int i11, String str, String str2, long j10, long j11, long j12, int i12, kotlin.jvm.internal.e eVar) {
        this(i10, i11, str, str2, (i12 & 16) != 0 ? 0L : j10, (i12 & 32) != 0 ? -1L : j11, (i12 & 64) != 0 ? 0L : j12);
    }
}

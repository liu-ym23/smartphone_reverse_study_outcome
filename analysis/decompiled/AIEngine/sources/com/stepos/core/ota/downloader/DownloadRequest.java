package com.stepos.core.ota.downloader;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadRequest {
    private final boolean allowCellular;
    private final int fetchId;
    private final String file;
    private final int groupId;
    private final String url;

    public DownloadRequest(String url, String file, int i10, boolean z, int i11) {
        g.f(url, "url");
        g.f(file, "file");
        this.url = url;
        this.file = file;
        this.groupId = i10;
        this.allowCellular = z;
        this.fetchId = i11;
    }

    public static /* synthetic */ DownloadRequest copy$default(DownloadRequest downloadRequest, String str, String str2, int i10, boolean z, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = downloadRequest.url;
        }
        if ((i12 & 2) != 0) {
            str2 = downloadRequest.file;
        }
        if ((i12 & 4) != 0) {
            i10 = downloadRequest.groupId;
        }
        if ((i12 & 8) != 0) {
            z = downloadRequest.allowCellular;
        }
        if ((i12 & 16) != 0) {
            i11 = downloadRequest.fetchId;
        }
        int i13 = i11;
        int i14 = i10;
        return downloadRequest.copy(str, str2, i14, z, i13);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.file;
    }

    public final int component3() {
        return this.groupId;
    }

    public final boolean component4() {
        return this.allowCellular;
    }

    public final int component5() {
        return this.fetchId;
    }

    public final DownloadRequest copy(String url, String file, int i10, boolean z, int i11) {
        g.f(url, "url");
        g.f(file, "file");
        return new DownloadRequest(url, file, i10, z, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return g.b(this.url, downloadRequest.url) && g.b(this.file, downloadRequest.file) && this.groupId == downloadRequest.groupId && this.allowCellular == downloadRequest.allowCellular && this.fetchId == downloadRequest.fetchId;
    }

    public final boolean getAllowCellular() {
        return this.allowCellular;
    }

    public final int getFetchId() {
        return this.fetchId;
    }

    public final String getFile() {
        return this.file;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.url.hashCode();
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Integer.hashCode(this.fetchId) + ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.groupId, v1.d.a(this.url.hashCode() * 31, 31, this.file), 31), 31, this.allowCellular);
    }

    public String toString() {
        String str = this.url;
        String str2 = this.file;
        int i10 = this.groupId;
        boolean z = this.allowCellular;
        int i11 = this.fetchId;
        StringBuilder sbS = ai.onnxruntime.a.s("DownloadRequest(url=", str, ", file=", str2, ", groupId=");
        sbS.append(i10);
        sbS.append(", allowCellular=");
        sbS.append(z);
        sbS.append(", fetchId=");
        return ai.onnxruntime.a.j(")", i11, sbS);
    }

    public /* synthetic */ DownloadRequest(String str, String str2, int i10, boolean z, int i11, int i12, kotlin.jvm.internal.e eVar) {
        this(str, str2, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? false : z, (i12 & 16) != 0 ? 0 : i11);
    }
}

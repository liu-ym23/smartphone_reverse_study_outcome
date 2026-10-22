package com.stepos.core.ota.domain.port;

import a0.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadSpec {
    private final boolean allowCellular;
    private final long expectedSizeBytes;
    private final String otaId;
    private final String targetFilePath;
    private final String url;

    public DownloadSpec(String otaId, String url, String targetFilePath, long j10, boolean z) {
        g.f(otaId, "otaId");
        g.f(url, "url");
        g.f(targetFilePath, "targetFilePath");
        this.otaId = otaId;
        this.url = url;
        this.targetFilePath = targetFilePath;
        this.expectedSizeBytes = j10;
        this.allowCellular = z;
    }

    public static /* synthetic */ DownloadSpec copy$default(DownloadSpec downloadSpec, String str, String str2, String str3, long j10, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = downloadSpec.otaId;
        }
        if ((i10 & 2) != 0) {
            str2 = downloadSpec.url;
        }
        if ((i10 & 4) != 0) {
            str3 = downloadSpec.targetFilePath;
        }
        if ((i10 & 8) != 0) {
            j10 = downloadSpec.expectedSizeBytes;
        }
        if ((i10 & 16) != 0) {
            z = downloadSpec.allowCellular;
        }
        boolean z3 = z;
        String str4 = str3;
        return downloadSpec.copy(str, str2, str4, j10, z3);
    }

    public final String component1() {
        return this.otaId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.targetFilePath;
    }

    public final long component4() {
        return this.expectedSizeBytes;
    }

    public final boolean component5() {
        return this.allowCellular;
    }

    public final DownloadSpec copy(String otaId, String url, String targetFilePath, long j10, boolean z) {
        g.f(otaId, "otaId");
        g.f(url, "url");
        g.f(targetFilePath, "targetFilePath");
        return new DownloadSpec(otaId, url, targetFilePath, j10, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadSpec)) {
            return false;
        }
        DownloadSpec downloadSpec = (DownloadSpec) obj;
        return g.b(this.otaId, downloadSpec.otaId) && g.b(this.url, downloadSpec.url) && g.b(this.targetFilePath, downloadSpec.targetFilePath) && this.expectedSizeBytes == downloadSpec.expectedSizeBytes && this.allowCellular == downloadSpec.allowCellular;
    }

    public final boolean getAllowCellular() {
        return this.allowCellular;
    }

    public final long getExpectedSizeBytes() {
        return this.expectedSizeBytes;
    }

    public final String getOtaId() {
        return this.otaId;
    }

    public final String getTargetFilePath() {
        return this.targetFilePath;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Boolean.hashCode(this.allowCellular) + a.c(d.a(d.a(this.otaId.hashCode() * 31, 31, this.url), 31, this.targetFilePath), this.expectedSizeBytes, 31);
    }

    public String toString() {
        String str = this.otaId;
        String str2 = this.url;
        String str3 = this.targetFilePath;
        long j10 = this.expectedSizeBytes;
        boolean z = this.allowCellular;
        StringBuilder sbS = ai.onnxruntime.a.s("DownloadSpec(otaId=", str, ", url=", str2, ", targetFilePath=");
        com.stepos.core.ota.d.p(j10, str3, ", expectedSizeBytes=", sbS);
        sbS.append(", allowCellular=");
        sbS.append(z);
        sbS.append(")");
        return sbS.toString();
    }

    public /* synthetic */ DownloadSpec(String str, String str2, String str3, long j10, boolean z, int i10, e eVar) {
        this(str, str2, str3, j10, (i10 & 16) != 0 ? false : z);
    }
}

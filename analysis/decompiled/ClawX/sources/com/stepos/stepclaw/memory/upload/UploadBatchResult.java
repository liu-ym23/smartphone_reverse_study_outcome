package com.stepos.stepclaw.memory.upload;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/UploadBatchResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "totalFiles", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "successCount", "failedCount", "results", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/upload/FileUploadResult;", "<init>", "(IIILjava/util/List;)V", "getTotalFiles", "()I", "getSuccessCount", "getFailedCount", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UploadBatchResult {
    private final int failedCount;
    private final List<FileUploadResult> results;
    private final int successCount;
    private final int totalFiles;

    public UploadBatchResult(int i8, int i9, int i10, List<FileUploadResult> results) {
        p.e(results, "results");
        this.totalFiles = i8;
        this.successCount = i9;
        this.failedCount = i10;
        this.results = results;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadBatchResult copy$default(UploadBatchResult uploadBatchResult, int i8, int i9, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i8 = uploadBatchResult.totalFiles;
        }
        if ((i11 & 2) != 0) {
            i9 = uploadBatchResult.successCount;
        }
        if ((i11 & 4) != 0) {
            i10 = uploadBatchResult.failedCount;
        }
        if ((i11 & 8) != 0) {
            list = uploadBatchResult.results;
        }
        return uploadBatchResult.copy(i8, i9, i10, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotalFiles() {
        return this.totalFiles;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFailedCount() {
        return this.failedCount;
    }

    public final List<FileUploadResult> component4() {
        return this.results;
    }

    public final UploadBatchResult copy(int totalFiles, int successCount, int failedCount, List<FileUploadResult> results) {
        p.e(results, "results");
        return new UploadBatchResult(totalFiles, successCount, failedCount, results);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadBatchResult)) {
            return false;
        }
        UploadBatchResult uploadBatchResult = (UploadBatchResult) other;
        return this.totalFiles == uploadBatchResult.totalFiles && this.successCount == uploadBatchResult.successCount && this.failedCount == uploadBatchResult.failedCount && p.a(this.results, uploadBatchResult.results);
    }

    public final int getFailedCount() {
        return this.failedCount;
    }

    public final List<FileUploadResult> getResults() {
        return this.results;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public int hashCode() {
        return this.results.hashCode() + b.C(this.failedCount, b.C(this.successCount, Integer.hashCode(this.totalFiles) * 31, 31), 31);
    }

    public String toString() {
        int i8 = this.totalFiles;
        int i9 = this.successCount;
        int i10 = this.failedCount;
        List<FileUploadResult> list = this.results;
        StringBuilder sbT = b.t("UploadBatchResult(totalFiles=", i8, ", successCount=", i9, ", failedCount=");
        sbT.append(i10);
        sbT.append(", results=");
        sbT.append(list);
        sbT.append(")");
        return sbT.toString();
    }
}

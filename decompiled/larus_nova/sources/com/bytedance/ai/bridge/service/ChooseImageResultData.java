package com.bytedance.ai.bridge.service;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/service/ChooseImageResultData;", "", "tempFilePaths", "", "", "tempFiles", "Lcom/bytedance/ai/bridge/service/ChooseImageFileResult;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getTempFilePaths", "()Ljava/util/List;", "getTempFiles", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseImageResultData {
    private final List<String> tempFilePaths;
    private final List<ChooseImageFileResult> tempFiles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChooseImageResultData copy$default(ChooseImageResultData r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tempFilePaths;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tempFiles;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.tempFilePaths;
    }

    public final List<ChooseImageFileResult> component2() {
        return this.tempFiles;
    }

    public final ChooseImageResultData copy(List<String> r100, List<ChooseImageFileResult> r101) {
        Intrinsics.checkNotNullParameter(r100, "tempFilePaths");
        Intrinsics.checkNotNullParameter(r101, "tempFiles");
        return new ChooseImageResultData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChooseImageResultData) == true) goto L8;
        return false;
    L8:
        ChooseImageResultData r101 = (ChooseImageResultData) r100;
        if (Intrinsics.areEqual(this.tempFilePaths, r101.tempFilePaths) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tempFiles, r101.tempFiles) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.tempFilePaths.hashCode() * 31) + this.tempFiles.hashCode();
    }

    public String toString() {
        return "ChooseImageResultData(tempFilePaths=" + this.tempFilePaths + ", tempFiles=" + this.tempFiles + ')';
    }

    public final List<String> getTempFilePaths() {
        return this.tempFilePaths;
    }

    public final List<ChooseImageFileResult> getTempFiles() {
        return this.tempFiles;
    }

    public ChooseImageResultData(List<String> r100, List<ChooseImageFileResult> r101) {
        Intrinsics.checkNotNullParameter(r100, "tempFilePaths");
        Intrinsics.checkNotNullParameter(r101, "tempFiles");
        this.tempFilePaths = r100;
        this.tempFiles = r101;
    }
}

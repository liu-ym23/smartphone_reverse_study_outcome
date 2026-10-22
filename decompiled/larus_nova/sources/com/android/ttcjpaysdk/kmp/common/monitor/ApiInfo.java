package com.android.ttcjpaysdk.kmp.common.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/monitor/ApiInfo;", "", "path", "", "bizSuccessCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getBizSuccessCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApiInfo {
    public static final int $stable = 0;
    private final String bizSuccessCode;
    private final String path;

    public static /* synthetic */ ApiInfo copy$default(ApiInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.path;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.bizSuccessCode;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.bizSuccessCode;
    }

    public final ApiInfo copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "bizSuccessCode");
        return new ApiInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApiInfo) == true) goto L8;
        return false;
    L8:
        ApiInfo r101 = (ApiInfo) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizSuccessCode, r101.bizSuccessCode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.bizSuccessCode.hashCode();
    }

    public String toString() {
        return "ApiInfo(path=" + this.path + ", bizSuccessCode=" + this.bizSuccessCode + ')';
    }

    public final String getBizSuccessCode() {
        return this.bizSuccessCode;
    }

    public final String getPath() {
        return this.path;
    }

    public ApiInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "bizSuccessCode");
        this.path = r100;
        this.bizSuccessCode = r101;
    }
}

package com.bytedance.android.live.saas.middleware.fresco;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/fresco/FrescoConfig;", "", "standalone", "", "isToBVersion", "nativeDir", "", "(ZZLjava/lang/String;)V", "()Z", "getNativeDir", "()Ljava/lang/String;", "getStandalone", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class FrescoConfig {
    private final boolean isToBVersion;
    private final String nativeDir;
    private final boolean standalone;

    public FrescoConfig() {
        this(false, false, null, 7, null);
    }

    public FrescoConfig(boolean r100) {
        this(r100, false, null, 6, null);
    }

    public FrescoConfig(boolean r100, boolean r101) {
        this(r100, r101, null, 4, null);
    }

    public static /* synthetic */ FrescoConfig copy$default(FrescoConfig r100, boolean r101, boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.standalone;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isToBVersion;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.nativeDir;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.standalone;
    }

    public final boolean component2() {
        return this.isToBVersion;
    }

    public final String component3() {
        return this.nativeDir;
    }

    public final FrescoConfig copy(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "nativeDir");
        return new FrescoConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FrescoConfig) == false) goto L12;
        FrescoConfig r101 = (FrescoConfig) r100;
        if (this.standalone == r101.standalone) goto L8;
        return false;
    L8:
        if (this.isToBVersion == r101.isToBVersion) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nativeDir, r101.nativeDir) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean r100 = this.standalone;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.isToBVersion;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        String r106 = this.nativeDir;
        if (r106 == null) goto L12;
        int r107 = r106.hashCode();
    L14:
        return r105 + r107;
    L12:
        r107 = 0;
        goto L14
    }

    public String toString() {
        return "FrescoConfig(standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", nativeDir=" + this.nativeDir + ")";
    }

    public final String getNativeDir() {
        return this.nativeDir;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public FrescoConfig(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "nativeDir");
        this.standalone = r100;
        this.isToBVersion = r101;
        this.nativeDir = r102;
    }

    public /* synthetic */ FrescoConfig(boolean r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}

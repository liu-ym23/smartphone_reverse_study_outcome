package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/EnterParams;", "", "enterFromMerge", "", "enterMethod", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnterFromMerge", "()Ljava/lang/String;", "getEnterMethod", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterParams {
    private final String enterFromMerge;
    private final String enterMethod;

    public static /* synthetic */ EnterParams copy$default(EnterParams r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enterFromMerge;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enterMethod;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.enterFromMerge;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final EnterParams copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        return new EnterParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EnterParams) == false) goto L10;
        EnterParams r101 = (EnterParams) r100;
        if (Intrinsics.areEqual(this.enterFromMerge, r101.enterFromMerge) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.enterFromMerge;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterMethod;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EnterParams(enterFromMerge=" + this.enterFromMerge + ", enterMethod=" + this.enterMethod + ")";
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public EnterParams(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        this.enterFromMerge = r100;
        this.enterMethod = r101;
    }
}

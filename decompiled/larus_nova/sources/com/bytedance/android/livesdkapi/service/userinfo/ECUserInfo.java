package com.bytedance.android.livesdkapi.service.userinfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/userinfo/ECUserInfo;", "", "ecomUserInfo", "", "(Ljava/lang/String;)V", "getEcomUserInfo", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserInfo {
    private final String ecomUserInfo;

    public static /* synthetic */ ECUserInfo copy$default(ECUserInfo r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.ecomUserInfo;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.ecomUserInfo;
    }

    public final ECUserInfo copy(String r100) {
        return new ECUserInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECUserInfo) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.ecomUserInfo, ((ECUserInfo) r100).ecomUserInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.ecomUserInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ECUserInfo(ecomUserInfo=" + this.ecomUserInfo + ")";
    }

    public final String getEcomUserInfo() {
        return this.ecomUserInfo;
    }

    public ECUserInfo(String r100) {
        this.ecomUserInfo = r100;
    }
}

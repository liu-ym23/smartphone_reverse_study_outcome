package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.CheckSellingPointResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/a;", "", "", "isPass", "Z", "c", "()Z", "", "rejectType", "I", "b", "()I", "", "rejectReason", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("is_pass")
    protected boolean isPass;

    @SerializedName("reject_reason")
    protected String rejectReason;

    @SerializedName("reject_reason_type")
    protected int rejectType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.isPass == r101.isPass) goto L8;
        return false;
    L8:
        if (this.rejectType == r101.rejectType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rejectReason, r101.rejectReason) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.isPass;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.rejectType) * 31;
        String r103 = this.rejectReason;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "CheckSellingPointResponse(isPass=" + this.isPass + ", rejectType=" + this.rejectType + ", rejectReason=" + this.rejectReason + ")";
    }

    public a() {
        this.isPass = false;
        this.rejectType = CheckSellingPointRejectType.UNKNOWN.ordinal();
        this.rejectReason = null;
    }

    public final String a() {
        return this.rejectReason;
    }

    public final int b() {
        return this.rejectType;
    }

    public final boolean c() {
        return this.isPass;
    }

    public a(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this.isPass = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.rejectReason = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this.rejectType = r100.i();
        r102 = r102 | 2;
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L18;
        this.isPass = false;
    L18:
        if ((r102 & 2) != 0) goto L21;
        this.rejectType = CheckSellingPointRejectType.UNKNOWN.ordinal();
    L21:
        if (this.rejectReason != null) goto L36;
        this.rejectReason = null;
        return;
    }
}

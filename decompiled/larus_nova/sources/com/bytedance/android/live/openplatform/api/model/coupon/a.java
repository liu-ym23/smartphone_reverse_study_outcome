package com.bytedance.android.live.openplatform.api.model.coupon;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("open.promotion.api.IsShowSendCouponEntranceResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/coupon/a;", "", "", "statusCode", "I", "c", "()I", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "", "showEntrance", "Z", "b", "()Z", "jumpUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setJumpUrl", "(Ljava/lang/String;)V", "description", "getDescription", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("copy_writing")
    protected String description;

    @SerializedName("jump_url")
    protected String jumpUrl;

    @SerializedName("show_entrance_result")
    protected boolean showEntrance;

    @SerializedName("status_code")
    protected int statusCode;

    @SerializedName("status_msg")
    protected String statusMsg;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.statusCode == r101.statusCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L10;
        return false;
    L10:
        if (this.showEntrance == r101.showEntrance) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        int r100 = this.statusCode * 31;
        String r101 = this.statusMsg;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.showEntrance;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        String r108 = this.jumpUrl;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.description;
        if (r111 == null) goto L17;
        r102 = r111.hashCode();
    L17:
        return r110 + r102;
    L12:
        r109 = 0;
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CouponEntranceInfo(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", showEntrance=" + this.showEntrance + ", jumpUrl=" + this.jumpUrl + ", description=" + this.description + ")";
    }

    public a() {
        this.statusCode = 0;
        this.statusMsg = null;
        this.showEntrance = false;
        this.jumpUrl = null;
        this.description = null;
    }

    public final String a() {
        return this.jumpUrl;
    }

    public final boolean b() {
        return this.showEntrance;
    }

    public final int c() {
        return this.statusCode;
    }

    public a(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.statusCode = (int) r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.statusMsg = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.showEntrance = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.jumpUrl = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.description = am3.h.c(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L24;
        this.statusCode = 0;
    L24:
        if (this.statusMsg != null) goto L27;
        this.statusMsg = null;
    L27:
        if ((r102 & 2) != 0) goto L30;
        this.showEntrance = false;
    L30:
        if (this.jumpUrl != null) goto L33;
        this.jumpUrl = null;
    L33:
        if (this.description != null) goto L54;
        this.description = null;
        return;
    }
}

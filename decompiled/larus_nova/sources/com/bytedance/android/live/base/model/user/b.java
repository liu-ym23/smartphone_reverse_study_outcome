package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.user.AnchorHomelandBanner")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/user/b;", "", "", "schema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "homelandInfo", "b", "setHomelandInfo", "", "height", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setHeight", "(I)V", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("height")
    protected int height;

    @SerializedName("anchor_homeland_info")
    protected String homelandInfo;

    @SerializedName("schema")
    protected String schema;

    public final int hashCode() {
        return (((this.height * 31) + this.schema.hashCode()) * 31) + this.homelandInfo.hashCode();
    }

    public final String toString() {
        return "AnchorHomelandBanner(height=" + this.height + ", scheme: " + this.schema + ", homelandInfo: " + this.homelandInfo + ')';
    }

    public b() {
        this.schema = "";
        this.homelandInfo = "";
    }

    public final int a() {
        return this.height;
    }

    public final String b() {
        return this.homelandInfo;
    }

    public final String c() {
        return this.schema;
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.schema = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.homelandInfo = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.height = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.schema != null) goto L19;
        this.schema = "";
    L19:
        if (this.homelandInfo != null) goto L34;
        this.homelandInfo = "";
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        String r101 = null;
        if ((r100 instanceof b) == true) goto L8;
        r100 = null;
    L8:
        b r102 = (b) r100;
        String r103 = this.schema;
        if (r102 == null) goto L12;
        r101 = r102.schema;
    L12:
        if (Intrinsics.areEqual(r103, r101) == true) goto L14;
    L18:
        return false;
    L14:
        if (Intrinsics.areEqual(this.homelandInfo, r102.homelandInfo) == false) goto L18;
        if (this.height != r102.height) goto L18;
        return true;
    }
}

package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/s0;", "", "", "motionStyleId", "Ljava/lang/String;", "getMotionStyleId", "()Ljava/lang/String;", "setMotionStyleId", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "motionStyleName", "getMotionStyleName", "setMotionStyleName", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("app_id")
    private String appId;

    @SerializedName("motion_style_id")
    private String motionStyleId;

    @SerializedName("motion_style_name")
    private String motionStyleName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L12;
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.motionStyleId, r101.motionStyleId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.motionStyleName, r101.motionStyleName) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.motionStyleId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.appId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.motionStyleName;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MotionStyleInfo(motionStyleId=" + this.motionStyleId + ", appId=" + this.appId + ", motionStyleName=" + this.motionStyleName + ")";
    }

    public s0() {
        this.motionStyleId = "";
        this.appId = "";
        this.motionStyleName = "";
    }
}

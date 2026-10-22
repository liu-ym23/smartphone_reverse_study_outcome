package com.bytedance.android.gamecp.business.gamedetail.component.nav;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/nav/a;", "", "", "navId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "navName", "b", "navTitle", "d", "navTargetId", "c", "", "navType", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("id")
    private final String navId;

    @SerializedName("alias")
    private final String navName;

    @SerializedName("jump_target")
    private final String navTargetId;

    @SerializedName("title")
    private final String navTitle;

    @SerializedName("jump_type")
    private final Integer navType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.navId, r101.navId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.navName, r101.navName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.navTitle, r101.navTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.navTargetId, r101.navTargetId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.navType, r101.navType) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.navId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.navName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.navTitle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.navTargetId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.navType;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameNavInfo(navId=" + this.navId + ", navName=" + this.navName + ", navTitle=" + this.navTitle + ", navTargetId=" + this.navTargetId + ", navType=" + this.navType + ")";
    }

    public a() {
        this.navId = null;
        this.navName = null;
        this.navTitle = null;
        this.navTargetId = null;
        this.navType = null;
    }

    public final String a() {
        return this.navId;
    }

    public final String b() {
        return this.navName;
    }

    public final String c() {
        return this.navTargetId;
    }

    public final String d() {
        return this.navTitle;
    }

    public final Integer e() {
        return this.navType;
    }
}

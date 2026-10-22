package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/fansgroup/i;", "", "", "name", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "avartarUrl", "b", "notice", ce.f26391f, "", "memberCount", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "groupId", "d", "", "applyStatus", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/fansgroup/g;", "entryLimit", "Ljava/util/List;", "c", "()Ljava/util/List;", "ownerUid", "h", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("apply_status")
    private final Integer applyStatus;

    @SerializedName("avatar_uri")
    private final String avartarUrl;

    @SerializedName("entry_limit")
    private final List<g> entryLimit;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("member_count")
    private final Long memberCount;

    @SerializedName("name")
    private final String name;

    @SerializedName("notice")
    private final String notice;

    @SerializedName("owner_uid")
    private final Long ownerUid;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L22;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avartarUrl, r101.avartarUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.notice, r101.notice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.memberCount, r101.memberCount) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.applyStatus, r101.applyStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entryLimit, r101.entryLimit) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ownerUid, r101.ownerUid) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.avartarUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.notice;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.memberCount;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.groupId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.applyStatus;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<g> r119 = this.entryLimit;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.ownerUid;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "GameFansGroupData(name=" + this.name + ", avartarUrl=" + this.avartarUrl + ", notice=" + this.notice + ", memberCount=" + this.memberCount + ", groupId=" + this.groupId + ", applyStatus=" + this.applyStatus + ", entryLimit=" + this.entryLimit + ", ownerUid=" + this.ownerUid + ")";
    }

    public i() {
        this.name = null;
        this.avartarUrl = null;
        this.notice = null;
        this.memberCount = null;
        this.groupId = null;
        this.applyStatus = null;
        this.entryLimit = null;
        this.ownerUid = null;
    }

    public final Integer a() {
        return this.applyStatus;
    }

    public final String b() {
        return this.avartarUrl;
    }

    public final List<g> c() {
        return this.entryLimit;
    }

    public final String d() {
        return this.groupId;
    }

    public final Long e() {
        return this.memberCount;
    }

    public final String f() {
        return this.name;
    }

    public final String g() {
        return this.notice;
    }

    public final Long h() {
        return this.ownerUid;
    }
}

package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u001d\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001<Bs\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b9\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\tHÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0003Ju\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\t\u0010\u001e\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\u0013\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003R\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b.\u0010-R\u001a\u0010\u0017\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b/\u0010-R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b0\u0010%R\u001a\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b1\u0010%R\u001a\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b2\u0010%R\u001a\u0010\u001b\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u00105R$\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00103\u001a\u0004\b6\u00105\"\u0004\b7\u00108¨\u0006="}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "Ljava/io/Serializable;", "", "isInGroup", "", "component1", "", "Lcom/bytedance/android/ec/model/response/anchorv3/GroupAvatarTimeStruct;", "component2", "", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", "component10", "endTime", "avatars", "joined", "groupSize", "persent", "skuMinPrice", "skuMaxPrice", "groupId", "rulePageUrl", "activityId", "copy", "toString", "hashCode", "", "other", "equals", "J", "getEndTime", "()J", "Ljava/util/List;", "getAvatars", "()Ljava/util/List;", "setAvatars", "(Ljava/util/List;)V", "I", "getJoined", "()I", "getGroupSize", "getPersent", "getSkuMinPrice", "getSkuMaxPrice", "getGroupId", "Ljava/lang/String;", "getRulePageUrl", "()Ljava/lang/String;", "getActivityId", "setActivityId", "(Ljava/lang/String;)V", "<init>", "(JLjava/util/List;IIIJJJLjava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class GroupInfo implements Serializable {
    public static final a Companion = null;
    public static final int ONE_THOUSAND = 1000;

    @SerializedName("id")
    private String activityId;

    @SerializedName("avatar_time_list")
    private List<GroupAvatarTimeStruct> avatars;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("group_id")
    private final long groupId;

    @SerializedName("group_size")
    private final int groupSize;

    @SerializedName("joined")
    private final int joined;

    @SerializedName("persent")
    private final int persent;

    @SerializedName("rule_page_url")
    private final String rulePageUrl;

    @SerializedName("sku_max_price")
    private final long skuMaxPrice;

    @SerializedName("sku_min_price")
    private final long skuMinPrice;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GroupInfo() {
        this(0, null, 0, 0, 0, 0, 0, 0, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupInfo copy$default(GroupInfo r110, long r111, List r112, int r113, int r210, int r211, long r212, long r213, long r214, String r215, String r216, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        long r100 = r110.endTime;
    L7:
        if ((r310 & 2) == 0) goto L9;
        List r101 = r110.avatars;
    L11:
        if ((r310 & 4) == 0) goto L13;
        int r102 = r110.joined;
    L15:
        if ((r310 & 8) == 0) goto L17;
        int r103 = r110.groupSize;
    L19:
        if ((r310 & 16) == 0) goto L21;
        int r104 = r110.persent;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r105 = r110.skuMinPrice;
    L27:
        if ((r310 & 64) == 0) goto L29;
        long r114 = r110.skuMaxPrice;
    L31:
        if ((r310 & 128) == 0) goto L33;
        long r115 = r110.groupId;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r116 = r110.rulePageUrl;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r106 = r110.activityId;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r106);
    L41:
        r106 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.endTime;
    }

    public final String component10() {
        return this.activityId;
    }

    public final List<GroupAvatarTimeStruct> component2() {
        return this.avatars;
    }

    public final int component3() {
        return this.joined;
    }

    public final int component4() {
        return this.groupSize;
    }

    public final int component5() {
        return this.persent;
    }

    public final long component6() {
        return this.skuMinPrice;
    }

    public final long component7() {
        return this.skuMaxPrice;
    }

    public final long component8() {
        return this.groupId;
    }

    public final String component9() {
        return this.rulePageUrl;
    }

    public final GroupInfo copy(long r110, List<GroupAvatarTimeStruct> r111, int r210, int r211, int r212, long r213, long r214, long r215, String r216, String r310) {
        Intrinsics.checkNotNullParameter(r111, "avatars");
        Intrinsics.checkNotNullParameter(r216, "rulePageUrl");
        return new GroupInfo(r110, r111, r210, r211, r212, r213, r214, r215, r216, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GroupInfo) == false) goto L26;
        GroupInfo r101 = (GroupInfo) r100;
        if (this.endTime == r101.endTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatars, r101.avatars) == true) goto L10;
        return false;
    L10:
        if (this.joined == r101.joined) goto L12;
        return false;
    L12:
        if (this.groupSize == r101.groupSize) goto L14;
        return false;
    L14:
        if (this.persent == r101.persent) goto L16;
        return false;
    L16:
        if (this.skuMinPrice == r101.skuMinPrice) goto L18;
        return false;
    L18:
        if (this.skuMaxPrice == r101.skuMaxPrice) goto L20;
        return false;
    L20:
        if (this.groupId == r101.groupId) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rulePageUrl, r101.rulePageUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        long r100 = this.endTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<GroupAvatarTimeStruct> r102 = this.avatars;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (((((((r101 + r104) * 31) + this.joined) * 31) + this.groupSize) * 31) + this.persent) * 31;
        long r106 = this.skuMinPrice;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.skuMaxPrice;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.groupId;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.rulePageUrl;
        if (r112 == null) goto L9;
        int r113 = r112.hashCode();
    L10:
        int r114 = (r111 + r113) * 31;
        String r115 = this.activityId;
        if (r115 == null) goto L14;
        r103 = r115.hashCode();
    L14:
        return r114 + r103;
    L9:
        r113 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "GroupInfo(endTime=" + this.endTime + ", avatars=" + this.avatars + ", joined=" + this.joined + ", groupSize=" + this.groupSize + ", persent=" + this.persent + ", skuMinPrice=" + this.skuMinPrice + ", skuMaxPrice=" + this.skuMaxPrice + ", groupId=" + this.groupId + ", rulePageUrl=" + this.rulePageUrl + ", activityId=" + this.activityId + ")";
    }

    public final boolean isInGroup() {
        if ((System.currentTimeMillis() / ((long) 1000)) >= this.endTime) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final List<GroupAvatarTimeStruct> getAvatars() {
        return this.avatars;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final int getGroupSize() {
        return this.groupSize;
    }

    public final int getJoined() {
        return this.joined;
    }

    public final int getPersent() {
        return this.persent;
    }

    public final String getRulePageUrl() {
        return this.rulePageUrl;
    }

    public final long getSkuMaxPrice() {
        return this.skuMaxPrice;
    }

    public final long getSkuMinPrice() {
        return this.skuMinPrice;
    }

    public final void setActivityId(String r100) {
        this.activityId = r100;
    }

    public final void setAvatars(List<GroupAvatarTimeStruct> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatars = r100;
    }

    public GroupInfo(long r100, List<GroupAvatarTimeStruct> r101, int r102, int r103, int r104, long r105, long r110, long r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r101, "avatars");
        Intrinsics.checkNotNullParameter(r112, "rulePageUrl");
        this.endTime = r100;
        this.avatars = r101;
        this.joined = r102;
        this.groupSize = r103;
        this.persent = r104;
        this.skuMinPrice = r105;
        this.skuMaxPrice = r110;
        this.groupId = r111;
        this.rulePageUrl = r112;
        this.activityId = r113;
    }

    public /* synthetic */ GroupInfo(long r110, List r111, int r112, int r113, int r210, long r211, long r212, long r213, String r214, String r215, int r216, DefaultConstructorMarker r310) {
        long r100 = 0;
        if ((r216 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r216 & 2) == 0) goto L9;
        List r102 = CollectionsKt.emptyList();
    L10:
        int r103 = 0;
        if ((r216 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r216 & 16) != 0) goto L23;
        r103 = r210;
    L23:
        if ((r216 & 32) == 0) goto L25;
        long r106 = 0;
    L27:
        if ((r216 & 64) == 0) goto L29;
        long r114 = 0;
    L31:
        if ((r216 & 128) != 0) goto L35;
        r100 = r213;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r107 = null;
    L42:
        this(r101, r102, r104, r105, r103, r106, r114, r100, r115, r107);
        return;
    L41:
        r107 = r215;
        goto L42
    L37:
        r115 = r214;
        goto L39
    L29:
        r114 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}

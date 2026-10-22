package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l93.b;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010 \u001a\u0004\u0018\u00010\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0006\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "", "id", "", "name", "avatar", "isFollowed", "", "isLive", "roomId", "secId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getRoomId", "getSecId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECUserStruct;", "equals", "other", "getAvatarUrl", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserStruct {

    @SerializedName("avatar")
    private final Object avatar;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f170333id;

    @SerializedName("is_followed")
    private final Boolean isFollowed;

    @SerializedName("is_live")
    private final Boolean isLive;

    @SerializedName("name")
    private final String name;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sec_id")
    private final String secId;

    public ECUserStruct() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ECUserStruct copy$default(ECUserStruct r100, String r101, String r102, Object r103, Boolean r104, Boolean r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f170333id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.avatar;
    L11:
        Object r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isFollowed;
    L14:
        Boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isLive;
    L17:
        Boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.roomId;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.secId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.f170333id;
    }

    public final String component2() {
        return this.name;
    }

    public final Object component3() {
        return this.avatar;
    }

    public final Boolean component4() {
        return this.isFollowed;
    }

    public final Boolean component5() {
        return this.isLive;
    }

    public final String component6() {
        return this.roomId;
    }

    public final String component7() {
        return this.secId;
    }

    public final ECUserStruct copy(String r110, String r111, Object r112, Boolean r113, Boolean r114, String r115, String r116) {
        return new ECUserStruct(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECUserStruct) == false) goto L20;
        ECUserStruct r101 = (ECUserStruct) r100;
        if (Intrinsics.areEqual(this.f170333id, r101.f170333id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFollowed, r101.isFollowed) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isLive, r101.isLive) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secId, r101.secId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.f170333id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.avatar;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isFollowed;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isLive;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.roomId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.secId;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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

    public String toString() {
        return "ECUserStruct(id=" + this.f170333id + ", name=" + this.name + ", avatar=" + this.avatar + ", isFollowed=" + this.isFollowed + ", isLive=" + this.isLive + ", roomId=" + this.roomId + ", secId=" + this.secId + ")";
    }

    public final String getAvatarUrl() {
        return b.a(this.avatar);
    }

    public final Object getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.f170333id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecId() {
        return this.secId;
    }

    public final Boolean isFollowed() {
        return this.isFollowed;
    }

    public final Boolean isLive() {
        return this.isLive;
    }

    public ECUserStruct(String r100, String r101, Object r102, Boolean r103, Boolean r104, String r105, String r106) {
        this.f170333id = r100;
        this.name = r101;
        this.avatar = r102;
        this.isFollowed = r103;
        this.isLive = r104;
        this.roomId = r105;
        this.secId = r106;
    }

    public /* synthetic */ ECUserStruct(String r100, String r101, Object r102, Boolean r110, Boolean r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Object r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Boolean r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}

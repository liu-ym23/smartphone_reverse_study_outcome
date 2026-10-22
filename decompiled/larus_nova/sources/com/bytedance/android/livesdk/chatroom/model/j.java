package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/j;", "", "", "itemId", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "itemType", "f", "", "coverUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "likeCount", "getLikeCount", "title", "h", "nickName", ce.f26391f, "avatar", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "createTime", "c", "width", RXScreenCaptureService.KEY_INDEX, "height", "d", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("url")
    private final String coverUrl;

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("height")
    private final Long height;

    @SerializedName("item_id")
    private final Long itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Long itemType;

    @SerializedName("count")
    private final Long likeCount;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("title")
    private final String title;

    @SerializedName("width")
    private final Long width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L26;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.likeCount, r101.likeCount) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.itemId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.itemType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.coverUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.likeCount;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.title;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.nickName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.avatar;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.createTime;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.width;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.height;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
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
        return "AwemeVideo(itemId=" + this.itemId + ", itemType=" + this.itemType + ", coverUrl=" + this.coverUrl + ", likeCount=" + this.likeCount + ", title=" + this.title + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", createTime=" + this.createTime + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public j() {
        this.itemId = null;
        this.itemType = null;
        this.coverUrl = null;
        this.likeCount = null;
        this.title = null;
        this.nickName = null;
        this.avatar = null;
        this.createTime = null;
        this.width = null;
        this.height = null;
    }

    public final String a() {
        return this.avatar;
    }

    public final String b() {
        return this.coverUrl;
    }

    public final Long c() {
        return this.createTime;
    }

    public final Long d() {
        return this.height;
    }

    public final Long e() {
        return this.itemId;
    }

    public final Long f() {
        return this.itemType;
    }

    public final String g() {
        return this.nickName;
    }

    public final String h() {
        return this.title;
    }

    public final Long i() {
        return this.width;
    }
}

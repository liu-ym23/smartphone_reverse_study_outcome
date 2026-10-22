package com.bytedance.android.livesdk.ktvapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/OrderSongSeiModel;", "", "userId", "", "userIdStr", "", "avatarThumb", "nickName", "songTitle", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarThumb", "()Ljava/lang/String;", "setAvatarThumb", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getSongTitle", "setSongTitle", "getUserId", "()J", "setUserId", "(J)V", "getUserIdStr", "setUserIdStr", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderSongSeiModel {

    @SerializedName("avatar_thumb")
    private String avatarThumb;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("song_title")
    private String songTitle;

    @SerializedName("user_id")
    private long userId;

    @SerializedName("user_id_str")
    private String userIdStr;

    public OrderSongSeiModel() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OrderSongSeiModel copy$default(OrderSongSeiModel r100, long r101, String r110, String r111, String r112, String r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.userId;
    L5:
        long r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.userIdStr;
    L8:
        String r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.avatarThumb;
    L11:
        String r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = r100.nickName;
    L14:
        String r105 = r112;
        if ((r114 & 16) == 0) goto L18;
        r113 = r100.songTitle;
    L18:
        return r100.copy(r102, r103, r104, r105, r113);
    }

    public final long component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userIdStr;
    }

    public final String component3() {
        return this.avatarThumb;
    }

    public final String component4() {
        return this.nickName;
    }

    public final String component5() {
        return this.songTitle;
    }

    public final OrderSongSeiModel copy(long r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "userIdStr");
        Intrinsics.checkNotNullParameter(r112, "nickName");
        Intrinsics.checkNotNullParameter(r113, "songTitle");
        return new OrderSongSeiModel(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OrderSongSeiModel) == false) goto L16;
        OrderSongSeiModel r101 = (OrderSongSeiModel) r100;
        if (this.userId == r101.userId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userIdStr, r101.userIdStr) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.avatarThumb, r101.avatarThumb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.songTitle, r101.songTitle) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = this.userId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.userIdStr;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.avatarThumb;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.nickName;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.songTitle;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "OrderSongSeiModel(userId=" + this.userId + ", userIdStr=" + this.userIdStr + ", avatarThumb=" + this.avatarThumb + ", nickName=" + this.nickName + ", songTitle=" + this.songTitle + ")";
    }

    public final String getAvatarThumb() {
        return this.avatarThumb;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getSongTitle() {
        return this.songTitle;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserIdStr() {
        return this.userIdStr;
    }

    public final void setAvatarThumb(String r100) {
        this.avatarThumb = r100;
    }

    public final void setNickName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nickName = r100;
    }

    public final void setSongTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.songTitle = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void setUserIdStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userIdStr = r100;
    }

    public OrderSongSeiModel(long r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "userIdStr");
        Intrinsics.checkNotNullParameter(r103, "nickName");
        Intrinsics.checkNotNullParameter(r104, "songTitle");
        this.userId = r100;
        this.userIdStr = r101;
        this.avatarThumb = r102;
        this.nickName = r103;
        this.songTitle = r104;
    }

    public /* synthetic */ OrderSongSeiModel(long r100, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        String r102 = "";
    L10:
        if ((r114 & 4) == 0) goto L12;
        r111 = null;
    L12:
        String r103 = r111;
        if ((r114 & 8) == 0) goto L15;
        String r104 = "";
    L17:
        if ((r114 & 16) == 0) goto L19;
        String r105 = "";
    L20:
        this(r101, r102, r103, r104, r105);
        return;
    L19:
        r105 = r113;
        goto L20
    L15:
        r104 = r112;
        goto L17
    L8:
        r102 = r110;
        goto L10
    }
}

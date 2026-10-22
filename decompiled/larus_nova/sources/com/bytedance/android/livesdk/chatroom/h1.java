package com.bytedance.android.livesdk.chatroom;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/h1;", "", "", "", "userImg", "Ljava/util/List;", "getUserImg", "()Ljava/util/List;", "userName", "Ljava/lang/String;", "getUserName", "()Ljava/lang/String;", "", "userId", "Ljava/lang/Long;", "getUserId", "()Ljava/lang/Long;", "secUserId", "getSecUserId", "", "hasDraw", "Ljava/lang/Boolean;", "getHasDraw", "()Ljava/lang/Boolean;", "lifeShareId", "getLifeShareId", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h1 {

    @SerializedName("has_draw")
    private final Boolean hasDraw;

    @SerializedName("life_share_id")
    private final String lifeShareId;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("user_id")
    private final Long userId;

    @SerializedName("user_img")
    private final List<String> userImg;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h1) == false) goto L18;
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.userImg, r101.userImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secUserId, r101.secUserId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hasDraw, r101.hasDraw) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lifeShareId, r101.lifeShareId) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.userImg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.userName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.userId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secUserId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.hasDraw;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.lifeShareId;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "ShareUserInfo(userImg=" + this.userImg + ", userName=" + this.userName + ", userId=" + this.userId + ", secUserId=" + this.secUserId + ", hasDraw=" + this.hasDraw + ", lifeShareId=" + this.lifeShareId + ")";
    }

    public h1() {
        this.userImg = null;
        this.userName = null;
        this.userId = null;
        this.secUserId = null;
        this.hasDraw = null;
        this.lifeShareId = null;
    }
}

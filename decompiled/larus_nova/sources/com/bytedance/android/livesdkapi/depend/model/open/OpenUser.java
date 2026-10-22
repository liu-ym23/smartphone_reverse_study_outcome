package com.bytedance.android.livesdkapi.depend.model.open;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/open/OpenUser;", "", InstantPlayContext.NICKNAME, "", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "openId", "followInfo", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "(Ljava/lang/String;Lcom/bytedance/android/live/base/model/ImageModel;Ljava/lang/String;Lcom/bytedance/android/live/base/model/user/FollowInfo;)V", "getAvatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getFollowInfo", "()Lcom/bytedance/android/live/base/model/user/FollowInfo;", "getNickname", "()Ljava/lang/String;", "getOpenId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenUser {

    @SerializedName("avatar_thumb")
    private final ImageModel avatarThumb;

    @SerializedName("follow_info")
    private final FollowInfo followInfo;

    @SerializedName(InstantPlayContext.NICKNAME)
    private final String nickname;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private final String openId;

    public static /* synthetic */ OpenUser copy$default(OpenUser r100, String r101, ImageModel r102, String r103, FollowInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.nickname;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.avatarThumb;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.openId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.followInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.nickname;
    }

    public final ImageModel component2() {
        return this.avatarThumb;
    }

    public final String component3() {
        return this.openId;
    }

    public final FollowInfo component4() {
        return this.followInfo;
    }

    public final OpenUser copy(String r100, ImageModel r101, String r102, FollowInfo r103) {
        return new OpenUser(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OpenUser) == false) goto L14;
        OpenUser r101 = (OpenUser) r100;
        if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatarThumb, r101.avatarThumb) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.openId, r101.openId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followInfo, r101.followInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.nickname;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ImageModel r104 = this.avatarThumb;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.openId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        FollowInfo r110 = this.followInfo;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "OpenUser(nickname=" + this.nickname + ", avatarThumb=" + this.avatarThumb + ", openId=" + this.openId + ", followInfo=" + this.followInfo + ")";
    }

    public final ImageModel getAvatarThumb() {
        return this.avatarThumb;
    }

    public final FollowInfo getFollowInfo() {
        return this.followInfo;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public OpenUser(String r100, ImageModel r101, String r102, FollowInfo r103) {
        this.nickname = r100;
        this.avatarThumb = r101;
        this.openId = r102;
        this.followInfo = r103;
    }
}

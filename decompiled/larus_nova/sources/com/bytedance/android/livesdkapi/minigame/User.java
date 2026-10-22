package com.bytedance.android.livesdkapi.minigame;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003JM\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/User;", "Ljava/io/Serializable;", "nickName", "", "avatarThumb", "Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "id", "userHonor", "Lcom/bytedance/android/livesdkapi/minigame/UserHonor;", "fansclub", "Lcom/bytedance/android/livesdkapi/minigame/Fansclub;", "followStatus", "", "(Ljava/lang/String;Lcom/bytedance/android/livesdkapi/minigame/ImageModel;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/minigame/UserHonor;Lcom/bytedance/android/livesdkapi/minigame/Fansclub;J)V", "getAvatarThumb", "()Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "setAvatarThumb", "(Lcom/bytedance/android/livesdkapi/minigame/ImageModel;)V", "getFansclub", "()Lcom/bytedance/android/livesdkapi/minigame/Fansclub;", "setFansclub", "(Lcom/bytedance/android/livesdkapi/minigame/Fansclub;)V", "getFollowStatus", "()J", "setFollowStatus", "(J)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getUserHonor", "()Lcom/bytedance/android/livesdkapi/minigame/UserHonor;", "setUserHonor", "(Lcom/bytedance/android/livesdkapi/minigame/UserHonor;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class User implements Serializable {

    @SerializedName("avatar_thumb")
    private ImageModel avatarThumb;

    @SerializedName("fansclub")
    private Fansclub fansclub;

    @SerializedName("follow_status")
    private long followStatus;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f162633id;

    @SerializedName(InstantPlayContext.NICKNAME)
    private String nickName;

    @SerializedName("user_honor")
    private UserHonor userHonor;

    public User() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ User copy$default(User r100, String r101, ImageModel r102, String r103, UserHonor r104, Fansclub r110, long r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.nickName;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.avatarThumb;
    L8:
        ImageModel r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f162633id;
    L11:
        String r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.userHonor;
    L14:
        UserHonor r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.fansclub;
    L17:
        Fansclub r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.followStatus;
    L20:
        String r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final String component1() {
        return this.nickName;
    }

    public final ImageModel component2() {
        return this.avatarThumb;
    }

    public final String component3() {
        return this.f162633id;
    }

    public final UserHonor component4() {
        return this.userHonor;
    }

    public final Fansclub component5() {
        return this.fansclub;
    }

    public final long component6() {
        return this.followStatus;
    }

    public final User copy(String r110, ImageModel r111, String r112, UserHonor r113, Fansclub r114, long r115) {
        Intrinsics.checkNotNullParameter(r112, "id");
        return new User(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof User) == false) goto L18;
        User r101 = (User) r100;
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatarThumb, r101.avatarThumb) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f162633id, r101.f162633id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userHonor, r101.userHonor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansclub, r101.fansclub) == true) goto L16;
        return false;
    L16:
        if (this.followStatus == r101.followStatus) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.nickName;
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
        String r107 = this.f162633id;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        UserHonor r110 = this.userHonor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Fansclub r113 = this.fansclub;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        long r115 = this.followStatus;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
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
        return "User(nickName=" + this.nickName + ", avatarThumb=" + this.avatarThumb + ", id=" + this.f162633id + ", userHonor=" + this.userHonor + ", fansclub=" + this.fansclub + ", followStatus=" + this.followStatus + ")";
    }

    public final ImageModel getAvatarThumb() {
        return this.avatarThumb;
    }

    public final Fansclub getFansclub() {
        return this.fansclub;
    }

    public final long getFollowStatus() {
        return this.followStatus;
    }

    public final String getId() {
        return this.f162633id;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final UserHonor getUserHonor() {
        return this.userHonor;
    }

    public final void setAvatarThumb(ImageModel r100) {
        this.avatarThumb = r100;
    }

    public final void setFansclub(Fansclub r100) {
        this.fansclub = r100;
    }

    public final void setFollowStatus(long r100) {
        this.followStatus = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f162633id = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setUserHonor(UserHonor r100) {
        this.userHonor = r100;
    }

    public User(String r100, ImageModel r101, String r102, UserHonor r103, Fansclub r104, long r105) {
        Intrinsics.checkNotNullParameter(r102, "id");
        this.nickName = r100;
        this.avatarThumb = r101;
        this.f162633id = r102;
        this.userHonor = r103;
        this.fansclub = r104;
        this.followStatus = r105;
    }

    public /* synthetic */ User(String r100, ImageModel r101, String r102, UserHonor r103, Fansclub r104, long r110, int r111, DefaultConstructorMarker r112) {
        Fansclub r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        ImageModel r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = "0";
    L13:
        String r107 = r102;
        if ((r111 & 8) == 0) goto L16;
        UserHonor r108 = null;
    L18:
        if ((r111 & 16) != 0) goto L22;
        r105 = r104;
    L22:
        if ((r111 & 32) == 0) goto L24;
        r110 = 0;
    L24:
        this(r113, r106, r107, r108, r105, r110);
        return;
    L16:
        r108 = r103;
        goto L18
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}

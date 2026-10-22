package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/format/model/q;", "", "", "virtualAvatarResourceId", "Ljava/lang/String;", "getVirtualAvatarResourceId", "()Ljava/lang/String;", "Lcom/bytedance/android/format/model/d1;", "sceneAssert", "Lcom/bytedance/android/format/model/d1;", "getSceneAssert", "()Lcom/bytedance/android/format/model/d1;", "Lcom/bytedance/android/format/model/s0;", "motionStyle", "Lcom/bytedance/android/format/model/s0;", "getMotionStyle", "()Lcom/bytedance/android/format/model/s0;", "Lcom/bytedance/android/format/model/SingleSong;", "songInfo", "Lcom/bytedance/android/format/model/SingleSong;", "getSongInfo", "()Lcom/bytedance/android/format/model/SingleSong;", "coverImgUri", "getCoverImgUri", "", "isPublish", "I", "()I", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("cover_img_uri")
    private final String coverImgUri;

    @SerializedName("is_publish")
    private final int isPublish;

    @SerializedName("motion_style")
    private final s0 motionStyle;

    @SerializedName("scene_assert")
    private final d1 sceneAssert;

    @SerializedName("song_info")
    private final SingleSong songInfo;

    @SerializedName("virtual_avatar_resource_id")
    private final String virtualAvatarResourceId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L18;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.virtualAvatarResourceId, r101.virtualAvatarResourceId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sceneAssert, r101.sceneAssert) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.motionStyle, r101.motionStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.songInfo, r101.songInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.coverImgUri, r101.coverImgUri) == true) goto L16;
        return false;
    L16:
        if (this.isPublish == r101.isPublish) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.virtualAvatarResourceId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d1 r104 = this.sceneAssert;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        s0 r107 = this.motionStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        SingleSong r110 = this.songInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.coverImgUri;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.isPublish;
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
        return "ConfirmVirtualAvatarRequest(virtualAvatarResourceId=" + this.virtualAvatarResourceId + ", sceneAssert=" + this.sceneAssert + ", motionStyle=" + this.motionStyle + ", songInfo=" + this.songInfo + ", coverImgUri=" + this.coverImgUri + ", isPublish=" + this.isPublish + ")";
    }
}

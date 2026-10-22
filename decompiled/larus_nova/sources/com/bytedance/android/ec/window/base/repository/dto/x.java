package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/x;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "videoCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getVideoCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "videoPlayAddr", "getVideoPlayAddr", "", "maxPlayDuration", "Ljava/lang/Integer;", "getMaxPlayDuration", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/window/base/repository/dto/j;", "PlayerIcon", "Lcom/bytedance/android/ec/window/base/repository/dto/j;", "getPlayerIcon", "()Lcom/bytedance/android/ec/window/base/repository/dto/j;", "videoType", "b", "", "videoId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "showInStatic", "Z", "getShowInStatic", "()Z", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("player_icon")
    private final j PlayerIcon;

    @SerializedName("max_play_duration")
    private final Integer maxPlayDuration;

    @SerializedName("need_static_show_player_icon")
    private final boolean showInStatic;

    @SerializedName("video_cover")
    private final ECUrlModel videoCover;

    @SerializedName("video_id")
    private final String videoId;

    @SerializedName("video_play_addr")
    private final ECUrlModel videoPlayAddr;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE)
    private final Integer videoType;

    public x() {
        this.videoCover = null;
        this.videoPlayAddr = null;
        this.maxPlayDuration = -1;
        this.PlayerIcon = null;
        this.videoType = null;
        this.videoId = null;
        this.showInStatic = false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L20;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.videoCover, r101.videoCover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.videoPlayAddr, r101.videoPlayAddr) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxPlayDuration, r101.maxPlayDuration) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.PlayerIcon, r101.PlayerIcon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.videoType, r101.videoType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L18;
        return false;
    L18:
        if (this.showInStatic == r101.showInStatic) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        ECUrlModel r100 = this.videoCover;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.videoPlayAddr;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.maxPlayDuration;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        j r110 = this.PlayerIcon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.videoType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.videoId;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.showInStatic;
        ?? r119 = r118;
        if (r118 == false) goto L29;
        r119 = 1;
    L29:
        return r117 + r119;
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
        return "WindowVideoDto(videoCover=" + this.videoCover + ", videoPlayAddr=" + this.videoPlayAddr + ", maxPlayDuration=" + this.maxPlayDuration + ", PlayerIcon=" + this.PlayerIcon + ", videoType=" + this.videoType + ", videoId=" + this.videoId + ", showInStatic=" + this.showInStatic + ")";
    }

    public final String a() {
        return this.videoId;
    }

    public final Integer b() {
        return this.videoType;
    }
}

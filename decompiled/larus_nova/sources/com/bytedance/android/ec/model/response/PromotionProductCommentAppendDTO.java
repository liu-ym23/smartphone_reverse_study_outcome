package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0003JW\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionProductCommentAppendDTO;", "Ljava/io/Serializable;", "commentTime", "", "photos", "", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentPhotoDTO;", "content", "videos", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "videosV2", "Lcom/bytedance/android/ec/model/response/ECCommentVideo;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCommentTime", "()Ljava/lang/String;", "getContent", "getPhotos", "()Ljava/util/List;", "getVideos", "getVideosV2", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentAppendDTO implements Serializable {

    @SerializedName("comment_time")
    private final String commentTime;

    @SerializedName("content")
    private final String content;

    @SerializedName("photos")
    private final List<PromotionProductCommentPhotoDTO> photos;

    @SerializedName("videos")
    private final List<PromotionVideoInfo> videos;

    @SerializedName("videos_v2")
    private final List<ECCommentVideo> videosV2;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionProductCommentAppendDTO copy$default(PromotionProductCommentAppendDTO r100, String r101, List r102, String r103, List r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.commentTime;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.photos;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.videos;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.videosV2;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.commentTime;
    }

    public final List<PromotionProductCommentPhotoDTO> component2() {
        return this.photos;
    }

    public final String component3() {
        return this.content;
    }

    public final List<PromotionVideoInfo> component4() {
        return this.videos;
    }

    public final List<ECCommentVideo> component5() {
        return this.videosV2;
    }

    public final PromotionProductCommentAppendDTO copy(String r100, List<PromotionProductCommentPhotoDTO> r101, String r110, List<PromotionVideoInfo> r111, List<ECCommentVideo> r112) {
        return new PromotionProductCommentAppendDTO(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductCommentAppendDTO) == false) goto L16;
        PromotionProductCommentAppendDTO r101 = (PromotionProductCommentAppendDTO) r100;
        if (Intrinsics.areEqual(this.commentTime, r101.commentTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videos, r101.videos) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.videosV2, r101.videosV2) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.commentTime;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<PromotionProductCommentPhotoDTO> r104 = this.photos;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<PromotionVideoInfo> r110 = this.videos;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ECCommentVideo> r113 = this.videosV2;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "PromotionProductCommentAppendDTO(commentTime=" + this.commentTime + ", photos=" + this.photos + ", content=" + this.content + ", videos=" + this.videos + ", videosV2=" + this.videosV2 + ")";
    }

    public final String getCommentTime() {
        return this.commentTime;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<PromotionProductCommentPhotoDTO> getPhotos() {
        return this.photos;
    }

    public final List<PromotionVideoInfo> getVideos() {
        return this.videos;
    }

    public final List<ECCommentVideo> getVideosV2() {
        return this.videosV2;
    }

    public PromotionProductCommentAppendDTO(String r100, List<PromotionProductCommentPhotoDTO> r101, String r102, List<PromotionVideoInfo> r103, List<ECCommentVideo> r104) {
        this.commentTime = r100;
        this.photos = r101;
        this.content = r102;
        this.videos = r103;
        this.videosV2 = r104;
    }

    public /* synthetic */ PromotionProductCommentAppendDTO(String r100, List r101, String r110, List r111, List r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        List r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        List r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}

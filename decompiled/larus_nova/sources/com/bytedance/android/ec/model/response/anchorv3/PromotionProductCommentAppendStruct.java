package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentAppendStruct;", "Ljava/io/Serializable;", "()V", "commentTime", "", "getCommentTime", "()Ljava/lang/String;", "content", "getContent", "photos", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;", "getPhotos", "()Ljava/util/List;", "videos", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "getVideos", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentAppendStruct implements Serializable {

    @SerializedName("comment_time")
    private final String commentTime;

    @SerializedName("content")
    private final String content;

    @SerializedName("photos")
    private final List<PromotionProductCommentPhotoStruct> photos;

    @SerializedName("videos")
    private final List<PromotionVideoInfo> videos;

    public PromotionProductCommentAppendStruct() {
    }

    public final String getCommentTime() {
        return this.commentTime;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<PromotionProductCommentPhotoStruct> getPhotos() {
        return this.photos;
    }

    public final List<PromotionVideoInfo> getVideos() {
        return this.videos;
    }
}

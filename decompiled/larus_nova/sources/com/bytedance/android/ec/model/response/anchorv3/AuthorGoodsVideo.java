package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/AuthorGoodsVideo;", "Ljava/io/Serializable;", "()V", "author", "Lcom/bytedance/android/ec/model/response/anchorv3/ShopBindAuthorStruct;", "getAuthor", "()Lcom/bytedance/android/ec/model/response/anchorv3/ShopBindAuthorStruct;", "commentCount", "", "getCommentCount", "()Ljava/lang/String;", "description", "getDescription", "likeCount", "getLikeCount", "video", "Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;", "getVideo", "()Lcom/bytedance/android/ec/model/response/anchorv3/VideoModelStruct;", "videoCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getVideoCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "videoLinkUrl", "getVideoLinkUrl", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AuthorGoodsVideo implements Serializable {

    @SerializedName("author")
    private final ShopBindAuthorStruct author;

    @SerializedName("comment_count")
    private final String commentCount;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String description;

    @SerializedName("like_count")
    private final String likeCount;

    @SerializedName("video")
    private final VideoModelStruct video;

    @SerializedName("video_cover")
    private final ECUrlModel videoCover;

    @SerializedName("video_link_url")
    private final String videoLinkUrl;

    public AuthorGoodsVideo() {
    }

    public final ShopBindAuthorStruct getAuthor() {
        return this.author;
    }

    public final String getCommentCount() {
        return this.commentCount;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLikeCount() {
        return this.likeCount;
    }

    public final VideoModelStruct getVideo() {
        return this.video;
    }

    public final ECUrlModel getVideoCover() {
        return this.videoCover;
    }

    public final String getVideoLinkUrl() {
        return this.videoLinkUrl;
    }
}

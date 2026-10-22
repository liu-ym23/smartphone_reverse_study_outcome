package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMediaMeta;", "Ljava/io/Serializable;", "imageUrlList", "", "", "video", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;)V", "getImageUrlList", "()Ljava/util/List;", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentMediaMeta implements Serializable {

    @SerializedName("image_url_list")
    private final List<String> imageUrlList;

    @SerializedName("video")
    private final VideoModel video;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4CommentMediaMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4CommentMediaMeta copy$default(AnchorV4CommentMediaMeta r100, List r101, VideoModel r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.imageUrlList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.video;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.imageUrlList;
    }

    public final VideoModel component2() {
        return this.video;
    }

    public final AnchorV4CommentMediaMeta copy(List<String> r100, VideoModel r101) {
        return new AnchorV4CommentMediaMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4CommentMediaMeta) == false) goto L10;
        AnchorV4CommentMediaMeta r101 = (AnchorV4CommentMediaMeta) r100;
        if (Intrinsics.areEqual(this.imageUrlList, r101.imageUrlList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.imageUrlList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VideoModel r104 = this.video;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4CommentMediaMeta(imageUrlList=" + this.imageUrlList + ", video=" + this.video + ")";
    }

    public final List<String> getImageUrlList() {
        return this.imageUrlList;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public AnchorV4CommentMediaMeta(List<String> r100, VideoModel r101) {
        this.imageUrlList = r100;
        this.video = r101;
    }

    public /* synthetic */ AnchorV4CommentMediaMeta(List r100, VideoModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

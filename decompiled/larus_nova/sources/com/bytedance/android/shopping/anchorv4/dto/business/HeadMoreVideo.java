package com.bytedance.android.shopping.anchorv4.dto.business;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/HeadMoreVideo;", "Ljava/io/Serializable;", "anchorVideo", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "anchorIndex", "", "videoHolderList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/VideoHolderItem;", GXTemplateKey.GAIAX_TRACK, "", "", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;ILjava/util/List;Ljava/util/Map;)V", "getAnchorIndex", "()I", "getAnchorVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "getTrack", "()Ljava/util/Map;", "getVideoHolderList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadMoreVideo implements Serializable {

    @SerializedName("anchor_index")
    private final int anchorIndex;

    @SerializedName("anchor_video")
    private final VideoModel anchorVideo;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final Map<String, Object> track;

    @SerializedName("video_list")
    private final List<VideoHolderItem> videoHolderList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeadMoreVideo copy$default(HeadMoreVideo r100, VideoModel r101, int r102, List r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.anchorVideo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.anchorIndex;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.videoHolderList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.track;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final VideoModel component1() {
        return this.anchorVideo;
    }

    public final int component2() {
        return this.anchorIndex;
    }

    public final List<VideoHolderItem> component3() {
        return this.videoHolderList;
    }

    public final Map<String, Object> component4() {
        return this.track;
    }

    public final HeadMoreVideo copy(VideoModel r100, int r101, List<VideoHolderItem> r102, Map<String, ? extends Object> r103) {
        return new HeadMoreVideo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeadMoreVideo) == false) goto L14;
        HeadMoreVideo r101 = (HeadMoreVideo) r100;
        if (Intrinsics.areEqual(this.anchorVideo, r101.anchorVideo) == true) goto L8;
        return false;
    L8:
        if (this.anchorIndex == r101.anchorIndex) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.videoHolderList, r101.videoHolderList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        VideoModel r100 = this.anchorVideo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.anchorIndex) * 31;
        List<VideoHolderItem> r104 = this.videoHolderList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.track;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "HeadMoreVideo(anchorVideo=" + this.anchorVideo + ", anchorIndex=" + this.anchorIndex + ", videoHolderList=" + this.videoHolderList + ", track=" + this.track + ")";
    }

    public final int getAnchorIndex() {
        return this.anchorIndex;
    }

    public final VideoModel getAnchorVideo() {
        return this.anchorVideo;
    }

    public final Map<String, Object> getTrack() {
        return this.track;
    }

    public final List<VideoHolderItem> getVideoHolderList() {
        return this.videoHolderList;
    }

    public HeadMoreVideo(VideoModel r100, int r101, List<VideoHolderItem> r102, Map<String, ? extends Object> r103) {
        this.anchorVideo = r100;
        this.anchorIndex = r101;
        this.videoHolderList = r102;
        this.track = r103;
    }

    public /* synthetic */ HeadMoreVideo(VideoModel r100, int r101, List r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}

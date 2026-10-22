package com.bytedance.android.livesdkapi.depend.model.match;

import am3.g;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b[\u0010\\J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR*\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R$\u00109\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0011\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010\u0015R$\u0010?\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR$\u0010B\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u000b\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0011\u001a\u0004\bF\u0010\u0013\"\u0004\bG\u0010\u0015R$\u0010H\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR$\u0010K\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000fR$\u0010N\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR$\u0010Q\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u000b\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "collectionId", "Ljava/lang/String;", "getCollectionId", "()Ljava/lang/String;", "setCollectionId", "(Ljava/lang/String;)V", "collectionType", "I", "getCollectionType", "()I", "setCollectionType", "(I)V", "title", "getTitle", d.f25925o, "Lpy/k;", "coverImage", "Lpy/k;", "getCoverImage", "()Lpy/k;", "setCoverImage", "(Lpy/k;)V", "originalVid", "getOriginalVid", "setOriginalVid", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "getVideoDuration", "setVideoDuration", "collectionTiming", "getCollectionTiming", "setCollectionTiming", "templateVid", "getTemplateVid", "setTemplateVid", "", "reflowTagList", "Ljava/util/List;", "getReflowTagList", "()Ljava/util/List;", "setReflowTagList", "(Ljava/util/List;)V", "roomId", "getRoomId", "setRoomId", "collectionSource", "getCollectionSource", "setCollectionSource", "originalVidUrl", "getOriginalVidUrl", "setOriginalVidUrl", "collectionTag", "getCollectionTag", "setCollectionTag", "episodeId", "getEpisodeId", "setEpisodeId", "shareInfo", "getShareInfo", "setShareInfo", "status", "getStatus", "setStatus", "ugShareInfo", "getUgShareInfo", "setUgShareInfo", "localVideoPath", "getLocalVideoPath", "setLocalVideoPath", "localImagePath", "getLocalImagePath", "setLocalImagePath", "localPreviewTopTitle", "getLocalPreviewTopTitle", "setLocalPreviewTopTitle", "Landroid/graphics/Bitmap;", "localImagePreviewBitmap", "Landroid/graphics/Bitmap;", "getLocalImagePreviewBitmap", "()Landroid/graphics/Bitmap;", "setLocalImagePreviewBitmap", "(Landroid/graphics/Bitmap;)V", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectionItem implements Parcelable, h {
    public static final Parcelable.Creator<CollectionItem> CREATOR = null;

    @SerializedName("collection_id")
    protected String collectionId;

    @SerializedName("collection_source")
    protected int collectionSource;

    @SerializedName("collection_tag")
    protected int collectionTag;

    @SerializedName("collection_timing")
    protected String collectionTiming;

    @SerializedName("collection_type")
    protected int collectionType;

    @SerializedName("cover_img")
    protected k coverImage;

    @SerializedName("episode_id")
    protected String episodeId;
    private String localImagePath;
    private Bitmap localImagePreviewBitmap;
    private String localPreviewTopTitle;
    private String localVideoPath;

    @SerializedName("original_vid")
    protected String originalVid;

    @SerializedName("original_vid_url")
    protected String originalVidUrl;

    @SerializedName("reflow_tag_list")
    protected List<Integer> reflowTagList;

    @SerializedName("room_id")
    protected String roomId;

    @SerializedName("share_info")
    protected String shareInfo;

    @SerializedName("status")
    protected int status;

    @SerializedName("tmpl_vid")
    protected String templateVid;

    @SerializedName("title")
    protected String title;

    @SerializedName("ug_share_info")
    protected String ugShareInfo;

    @SerializedName("video_duration")
    protected String videoDuration;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static class Creator implements Parcelable.Creator<CollectionItem> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectionItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new CollectionItem();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectionItem[] newArray(int r100) {
            return new CollectionItem[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectionItem createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectionItem[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(1);
    }

    public CollectionItem() {
        this.localVideoPath = "";
        this.localImagePath = "";
        this.localPreviewTopTitle = "";
        this.collectionId = "";
        this.title = "";
        this.originalVid = "";
        this.videoDuration = "";
        this.collectionTiming = "";
        this.templateVid = "";
        this.roomId = "";
        this.originalVidUrl = "";
        this.episodeId = "";
        this.shareInfo = "";
        this.ugShareInfo = "";
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final int getCollectionSource() {
        return this.collectionSource;
    }

    public final int getCollectionTag() {
        return this.collectionTag;
    }

    public final String getCollectionTiming() {
        return this.collectionTiming;
    }

    public final int getCollectionType() {
        return this.collectionType;
    }

    public final k getCoverImage() {
        return this.coverImage;
    }

    public final String getEpisodeId() {
        return this.episodeId;
    }

    public final String getLocalImagePath() {
        return this.localImagePath;
    }

    public final Bitmap getLocalImagePreviewBitmap() {
        return this.localImagePreviewBitmap;
    }

    public final String getLocalPreviewTopTitle() {
        return this.localPreviewTopTitle;
    }

    public final String getLocalVideoPath() {
        return this.localVideoPath;
    }

    public final String getOriginalVid() {
        return this.originalVid;
    }

    public final String getOriginalVidUrl() {
        return this.originalVidUrl;
    }

    public final List<Integer> getReflowTagList() {
        return this.reflowTagList;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getShareInfo() {
        return this.shareInfo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTemplateVid() {
        return this.templateVid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUgShareInfo() {
        return this.ugShareInfo;
    }

    public final String getVideoDuration() {
        return this.videoDuration;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, py.k] */
    public CollectionItem(g r100) {
        this.reflowTagList = new ArrayList();
        this.localVideoPath = "";
        this.localImagePath = "";
        this.localPreviewTopTitle = "";
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        switch(r102) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L6;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L6;
            case 18: goto L8;
            case 19: goto L7;
            default: goto L6;
        };
    L7:
        this.ugShareInfo = am3.h.c(r100);
        goto L3
    L8:
        this.status = r100.i();
        goto L3
    L9:
        this.shareInfo = am3.h.c(r100);
        goto L3
    L10:
        this.episodeId = am3.h.c(r100);
        goto L3
    L11:
        this.collectionTag = r100.i();
        goto L3
    L12:
        this.originalVidUrl = am3.h.c(r100);
        goto L3
    L13:
        this.collectionSource = r100.i();
        goto L3
    L14:
        this.roomId = am3.h.c(r100);
        goto L3
    L15:
        this.reflowTagList.add(Integer.valueOf(r100.i()));
        goto L3
    L16:
        this.templateVid = am3.h.c(r100);
        goto L3
    L17:
        this.collectionTiming = am3.h.c(r100);
        goto L3
    L18:
        this.videoDuration = am3.h.c(r100);
        goto L3
    L19:
        this.originalVid = am3.h.c(r100);
        goto L3
    L20:
        this.coverImage = f.a(r100, k.class);
        goto L3
    L21:
        this.title = am3.h.c(r100);
        goto L3
    L22:
        this.collectionType = r100.i();
        goto L3
    L23:
        this.collectionId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.collectionId != null) goto L28;
        this.collectionId = "";
    L28:
        if (this.title != null) goto L31;
        this.title = "";
    L31:
        if (this.originalVid != null) goto L34;
        this.originalVid = "";
    L34:
        if (this.videoDuration != null) goto L37;
        this.videoDuration = "";
    L37:
        if (this.collectionTiming != null) goto L40;
        this.collectionTiming = "";
    L40:
        if (this.templateVid != null) goto L43;
        this.templateVid = "";
    L43:
        if (this.roomId != null) goto L46;
        this.roomId = "";
    L46:
        if (this.originalVidUrl != null) goto L49;
        this.originalVidUrl = "";
    L49:
        if (this.episodeId != null) goto L52;
        this.episodeId = "";
    L52:
        if (this.shareInfo != null) goto L55;
        this.shareInfo = "";
    L55:
        if (this.ugShareInfo != null) goto L96;
        this.ugShareInfo = "";
        return;
    }

    public final void setCollectionId(String r100) {
        this.collectionId = r100;
    }

    public final void setCollectionSource(int r100) {
        this.collectionSource = r100;
    }

    public final void setCollectionTag(int r100) {
        this.collectionTag = r100;
    }

    public final void setCollectionTiming(String r100) {
        this.collectionTiming = r100;
    }

    public final void setCollectionType(int r100) {
        this.collectionType = r100;
    }

    public final void setCoverImage(k r100) {
        this.coverImage = r100;
    }

    public final void setEpisodeId(String r100) {
        this.episodeId = r100;
    }

    public final void setLocalImagePath(String r100) {
        this.localImagePath = r100;
    }

    public final void setLocalImagePreviewBitmap(Bitmap r100) {
        this.localImagePreviewBitmap = r100;
    }

    public final void setLocalPreviewTopTitle(String r100) {
        this.localPreviewTopTitle = r100;
    }

    public final void setLocalVideoPath(String r100) {
        this.localVideoPath = r100;
    }

    public final void setOriginalVid(String r100) {
        this.originalVid = r100;
    }

    public final void setOriginalVidUrl(String r100) {
        this.originalVidUrl = r100;
    }

    public final void setReflowTagList(List<Integer> r100) {
        this.reflowTagList = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setShareInfo(String r100) {
        this.shareInfo = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTemplateVid(String r100) {
        this.templateVid = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUgShareInfo(String r100) {
        this.ugShareInfo = r100;
    }

    public final void setVideoDuration(String r100) {
        this.videoDuration = r100;
    }
}

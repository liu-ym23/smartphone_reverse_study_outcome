package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;", "Ljava/io/Serializable;", "url", "", DocCallbackImpl.KEY_THUMBNAIL, "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getHeight", "()J", "getThumbnail", "()Ljava/lang/String;", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentPhotoStruct implements Serializable {

    @SerializedName("height")
    private final long height;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private final String thumbnail;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final long width;

    public PromotionProductCommentPhotoStruct() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ PromotionProductCommentPhotoStruct copy$default(PromotionProductCommentPhotoStruct r100, String r101, String r102, long r103, long r104, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.thumbnail;
    L8:
        String r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.width;
    L11:
        long r105 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.height;
    L14:
        String r106 = r101;
        return r100.copy(r106, r112, r105, r104);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.thumbnail;
    }

    public final long component3() {
        return this.width;
    }

    public final long component4() {
        return this.height;
    }

    public final PromotionProductCommentPhotoStruct copy(String r100, String r110, long r111, long r112) {
        return new PromotionProductCommentPhotoStruct(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductCommentPhotoStruct) == false) goto L14;
        PromotionProductCommentPhotoStruct r101 = (PromotionProductCommentPhotoStruct) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.thumbnail, r101.thumbnail) == true) goto L10;
        return false;
    L10:
        if (this.width == r101.width) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.thumbnail;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.width;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.height;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionProductCommentPhotoStruct(url=" + this.url + ", thumbnail=" + this.thumbnail + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public final long getHeight() {
        return this.height;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getWidth() {
        return this.width;
    }

    public PromotionProductCommentPhotoStruct(String r100, String r101, long r102, long r103) {
        this.url = r100;
        this.thumbnail = r101;
        this.width = r102;
        this.height = r103;
    }

    public /* synthetic */ PromotionProductCommentPhotoStruct(String r100, String r101, long r102, long r110, int r111, DefaultConstructorMarker r112) {
        String r103 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) != 0) goto L11;
        r103 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r111 & 8) == 0) goto L17;
        long r114 = 0;
    L18:
        this(r113, r103, r104, r114);
        return;
    L17:
        r114 = r110;
        goto L18
    L13:
        r104 = r102;
        goto L15
    L5:
        r113 = r100;
        goto L7
    }
}

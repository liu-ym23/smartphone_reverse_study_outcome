package com.bytedance.android.ec.model.response;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionProductCommentPhotoDTO;", "Ljava/io/Serializable;", "url", "", DocCallbackImpl.KEY_THUMBNAIL, "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;II)V", "getHeight", "()I", "getThumbnail", "()Ljava/lang/String;", "getUrl", "getWidth", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentPhotoDTO implements Serializable {

    @SerializedName("height")
    private final int height;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private final String thumbnail;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final int width;

    public final int getHeight() {
        return this.height;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public PromotionProductCommentPhotoDTO(String r100, String r101, int r102, int r103) {
        this.url = r100;
        this.thumbnail = r101;
        this.width = r102;
        this.height = r103;
    }

    public /* synthetic */ PromotionProductCommentPhotoDTO(String r100, String r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = 0;
    L8:
        this(r100, r101, r102, r103);
    }
}

package com.bytedance.android.live.room.api.ssposter.api;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/room/api/ssposter/api/PosterResponse;", "", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "shareOrder", "", "shareContent", "", "posterOrder", "", "posterNumber", "posterText", "posters", "", "Lcom/bytedance/android/live/room/api/ssposter/api/PosterImages;", "(Lcom/bytedance/android/live/base/model/ImageModel;JLjava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getPosterNumber", "()I", "getPosterOrder", "getPosterText", "()Ljava/lang/String;", "getPosters", "()Ljava/util/List;", "getShareContent", "getShareOrder", "()J", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PosterResponse {

    @SerializedName("image")
    private final ImageModel image;

    @SerializedName("poster_nums")
    private final int posterNumber;

    @SerializedName("poster_order")
    private final int posterOrder;

    @SerializedName("poster_text")
    private final String posterText;

    @SerializedName("image_list")
    private final List<PosterImages> posters;

    @SerializedName(a.KEY_SHARE_CONTENT)
    private final String shareContent;

    @SerializedName("share_order")
    private final long shareOrder;

    public final ImageModel getImage() {
        return this.image;
    }

    public final int getPosterNumber() {
        return this.posterNumber;
    }

    public final int getPosterOrder() {
        return this.posterOrder;
    }

    public final String getPosterText() {
        return this.posterText;
    }

    public final List<PosterImages> getPosters() {
        return this.posters;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final long getShareOrder() {
        return this.shareOrder;
    }

    public PosterResponse(ImageModel r100, long r101, String r102, int r103, int r104, String r105, List<PosterImages> r106) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r102, "shareContent");
        this.image = r100;
        this.shareOrder = r101;
        this.shareContent = r102;
        this.posterOrder = r103;
        this.posterNumber = r104;
        this.posterText = r105;
        this.posters = r106;
    }
}

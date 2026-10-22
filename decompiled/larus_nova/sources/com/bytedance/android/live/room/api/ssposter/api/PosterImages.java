package com.bytedance.android.live.room.api.ssposter.api;

import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/api/ssposter/api/PosterImages;", "", "preImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "saveImage", "(Lcom/bytedance/android/live/base/model/ImageModel;Lcom/bytedance/android/live/base/model/ImageModel;)V", "getPreImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "getSaveImage", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PosterImages {

    @SerializedName("preview_image")
    private final ImageModel preImage;

    @SerializedName("image")
    private final ImageModel saveImage;

    /* JADX WARN: Multi-variable type inference failed */
    public PosterImages() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final ImageModel getPreImage() {
        return this.preImage;
    }

    public final ImageModel getSaveImage() {
        return this.saveImage;
    }

    public PosterImages(ImageModel r100, ImageModel r101) {
        this.preImage = r100;
        this.saveImage = r101;
    }

    public /* synthetic */ PosterImages(ImageModel r100, ImageModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

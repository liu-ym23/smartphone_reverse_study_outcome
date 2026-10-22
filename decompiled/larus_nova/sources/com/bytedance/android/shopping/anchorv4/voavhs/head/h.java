package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/h;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "video", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "b", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "backgroundControl", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/GaussianBlurConfig;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("background_control")
    private final GaussianBlurConfig backgroundControl;

    @SerializedName("video_player_box")
    private final VideoModel video;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backgroundControl, r101.backgroundControl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        VideoModel r100 = this.video;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        GaussianBlurConfig r104 = this.backgroundControl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GoodGoodsComment(video=" + this.video + ", backgroundControl=" + this.backgroundControl + ")";
    }

    public h() {
        this.video = null;
        this.backgroundControl = null;
    }

    public final GaussianBlurConfig a() {
        return this.backgroundControl;
    }

    public final VideoModel b() {
        return this.video;
    }
}

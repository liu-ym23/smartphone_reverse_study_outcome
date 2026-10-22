package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBannerItemStruct;", "Ljava/io/Serializable;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "contentColor", "getContentColor", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "leftMargin", "", "getLeftMargin", "()I", NameKeys.LoadStrategy_Use, "", "getUse", "()Z", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionBannerItemStruct implements Serializable {

    @SerializedName("content")
    private final String content;

    @SerializedName("content_color")
    private final String contentColor;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("left_distance")
    private final int leftMargin;

    @SerializedName(NameKeys.LoadStrategy_Use)
    private final boolean use;

    public PromotionBannerItemStruct() {
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentColor() {
        return this.contentColor;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final boolean getUse() {
        return this.use;
    }
}

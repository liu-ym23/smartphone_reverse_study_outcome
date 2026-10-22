package com.bytedance.android.shopping.anchorv3.detail.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/vo/DialogImageInfo;", "Ljava/io/Serializable;", "()V", "closeStatusImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCloseStatusImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setCloseStatusImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "openStatusImage", "getOpenStatusImage", "setOpenStatusImage", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogImageInfo implements Serializable {

    @SerializedName("close_image")
    private ECUrlModel closeStatusImage;

    @SerializedName("open_image")
    private ECUrlModel openStatusImage;

    public DialogImageInfo() {
    }

    public final ECUrlModel getCloseStatusImage() {
        return this.closeStatusImage;
    }

    public final ECUrlModel getOpenStatusImage() {
        return this.openStatusImage;
    }

    public final void setCloseStatusImage(ECUrlModel r100) {
        this.closeStatusImage = r100;
    }

    public final void setOpenStatusImage(ECUrlModel r100) {
        this.openStatusImage = r100;
    }
}

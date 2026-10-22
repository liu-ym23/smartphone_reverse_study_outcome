package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/DetailImageStruct;", "Ljava/io/Serializable;", "()V", "detailMoreInfo", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/DetailMoreInfo;", "getDetailMoreInfo", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/DetailMoreInfo;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "showHeight", "", "getShowHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailImageStruct implements Serializable {

    @SerializedName("more_info")
    private final DetailMoreInfo detailMoreInfo;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("show_height")
    private final Integer showHeight;

    @SerializedName(a.KEY_PIC_TYPE)
    private final String size;

    public DetailImageStruct() {
    }

    public final DetailMoreInfo getDetailMoreInfo() {
        return this.detailMoreInfo;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final Integer getShowHeight() {
        return this.showHeight;
    }

    public final String getSize() {
        return this.size;
    }
}

package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/DetailImageStruct;", "Ljava/io/Serializable;", "()V", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "size", "", "getSize", "()Ljava/lang/String;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailImageStruct implements Serializable {

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName(a.KEY_PIC_TYPE)
    private final String size;

    public DetailImageStruct() {
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final String getSize() {
        return this.size;
    }
}

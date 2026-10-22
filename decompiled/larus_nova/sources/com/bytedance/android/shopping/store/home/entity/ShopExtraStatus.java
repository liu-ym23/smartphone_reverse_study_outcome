package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopExtraStatus;", "Ljava/io/Serializable;", "()V", "extraStatusType", "", "getExtraStatusType", "()Ljava/lang/Integer;", "setExtraStatusType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tagList", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopExtraStatus implements Serializable {

    @SerializedName("extra_status_type")
    private Integer extraStatusType;

    @SerializedName("tag_list")
    private List<? extends ECUrlModel> tagList;

    public ShopExtraStatus() {
    }

    public final Integer getExtraStatusType() {
        return this.extraStatusType;
    }

    public final List<ECUrlModel> getTagList() {
        return this.tagList;
    }

    public final void setExtraStatusType(Integer r100) {
        this.extraStatusType = r100;
    }

    public final void setTagList(List<? extends ECUrlModel> r100) {
        this.tagList = r100;
    }
}

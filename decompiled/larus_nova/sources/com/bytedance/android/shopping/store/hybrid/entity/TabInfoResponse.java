package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/TabInfoResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/shopping/store/hybrid/entity/c;", "isvInfo", "Lcom/bytedance/android/shopping/store/hybrid/entity/c;", "getIsvInfo", "()Lcom/bytedance/android/shopping/store/hybrid/entity/c;", "", "Lcom/bytedance/android/shopping/store/hybrid/entity/a;", "componentBriefList", "Ljava/util/List;", "getComponentBriefList", "()Ljava/util/List;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabInfoResponse extends CommerceBaseResponse {

    @SerializedName("component_brief_list")
    private final List<a> componentBriefList;

    @SerializedName("isv_info")
    private final c isvInfo;

    public TabInfoResponse() {
    }

    public final List<a> getComponentBriefList() {
        return this.componentBriefList;
    }

    public final c getIsvInfo() {
        return this.isvInfo;
    }
}

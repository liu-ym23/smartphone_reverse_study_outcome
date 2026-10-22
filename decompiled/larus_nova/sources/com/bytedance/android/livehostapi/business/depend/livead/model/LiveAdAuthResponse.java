package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveAdAuthResponse;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "()V", "miniAppAuthList", "", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/MiniAppAuthResponse;", "getMiniAppAuthList", "()Ljava/util/List;", "setMiniAppAuthList", "(Ljava/util/List;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAdAuthResponse extends BaseResponse {

    @SerializedName("webcast_auth_list")
    private List<MiniAppAuthResponse> miniAppAuthList;

    public LiveAdAuthResponse() {
    }

    public final List<MiniAppAuthResponse> getMiniAppAuthList() {
        return this.miniAppAuthList;
    }

    public final void setMiniAppAuthList(List<MiniAppAuthResponse> r100) {
        this.miniAppAuthList = r100;
    }
}

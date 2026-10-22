package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSensitiveResponse;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "()V", BaseHttpRequestInfo.KEY_HIT, "", "getHit", "()Z", "setHit", "(Z)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampSensitiveResponse extends BaseResponse {

    @SerializedName(BaseHttpRequestInfo.KEY_HIT)
    private boolean hit;

    public StampSensitiveResponse() {
    }

    public final boolean getHit() {
        return this.hit;
    }

    public final void setHit(boolean r100) {
        this.hit = r100;
    }
}

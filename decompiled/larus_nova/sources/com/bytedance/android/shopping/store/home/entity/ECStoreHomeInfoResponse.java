package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeInfoResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderBaseInfoVO;", "baseInfo", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderBaseInfoVO;", "getBaseInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderBaseInfoVO;", "setBaseInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderBaseInfoVO;)V", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderConfigInfoVO;", "configInfo", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderConfigInfoVO;", "getConfigInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderConfigInfoVO;", "setConfigInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderConfigInfoVO;)V", "Lim/v;", "liveInfo", "Lim/v;", "getLiveInfo", "()Lim/v;", "setLiveInfo", "(Lim/v;)V", "", "", "logExtra", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeStyleInfoVO;", "homeStyleInfo", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeStyleInfoVO;", "getHomeStyleInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeStyleInfoVO;", "setHomeStyleInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeStyleInfoVO;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHomeInfoResponse extends CommerceBaseResponse {

    @SerializedName("home_base_info")
    private ECStoreHeaderBaseInfoVO baseInfo;

    @SerializedName("home_config_info")
    private ECStoreHeaderConfigInfoVO configInfo;

    @SerializedName("home_style_info")
    private ECStoreHomeStyleInfoVO homeStyleInfo;

    @SerializedName("live_info")
    private im.v liveInfo;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    public ECStoreHomeInfoResponse() {
    }

    public final ECStoreHeaderBaseInfoVO getBaseInfo() {
        return this.baseInfo;
    }

    public final ECStoreHeaderConfigInfoVO getConfigInfo() {
        return this.configInfo;
    }

    public final ECStoreHomeStyleInfoVO getHomeStyleInfo() {
        return this.homeStyleInfo;
    }

    public final im.v getLiveInfo() {
        return this.liveInfo;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final void setBaseInfo(ECStoreHeaderBaseInfoVO r100) {
        this.baseInfo = r100;
    }

    public final void setConfigInfo(ECStoreHeaderConfigInfoVO r100) {
        this.configInfo = r100;
    }

    public final void setHomeStyleInfo(ECStoreHomeStyleInfoVO r100) {
        this.homeStyleInfo = r100;
    }

    public final void setLiveInfo(im.v r100) {
        this.liveInfo = r100;
    }

    public final void setLogExtra(Map<String, String> r100) {
        this.logExtra = r100;
    }
}

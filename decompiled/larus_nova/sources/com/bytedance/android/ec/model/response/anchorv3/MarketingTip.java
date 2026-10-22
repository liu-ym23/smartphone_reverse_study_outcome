package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;", "Ljava/io/Serializable;", "()V", "jumpUrl", "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "tipComponentList", "", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTipComponent;", "getTipComponentList", "()Ljava/util/List;", "setTipComponentList", "(Ljava/util/List;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MarketingTip implements Serializable {

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("tip_component_list")
    private List<MarketingTipComponent> tipComponentList;

    @SerializedName("type")
    private Integer type;

    public MarketingTip() {
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<MarketingTipComponent> getTipComponentList() {
        return this.tipComponentList;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setTipComponentList(List<MarketingTipComponent> r100) {
        this.tipComponentList = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}

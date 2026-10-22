package com.bytedance.android.shopping.anchorv3.commentv2.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R,\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellData;", "Ljava/io/Serializable;", "()V", RuleConditionBean.BIZ_DATA_KEY, "", "getBizData", "()Ljava/lang/String;", "setBizData", "(Ljava/lang/String;)V", "config", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellDataConfig;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellDataConfig;", "setConfig", "(Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellDataConfig;)V", "extraParams", "", "getExtraParams", "()Ljava/util/Map;", "setExtraParams", "(Ljava/util/Map;)V", "mobParams", "getMobParams", "setMobParams", "type", "", "getType", "()I", "setType", "(I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceCellData implements Serializable {

    @SerializedName("biz_data")
    private String bizData;

    @SerializedName("config")
    private SliceCellDataConfig config;

    @SerializedName("extra_params")
    private Map<String, String> extraParams;

    @SerializedName("mob_params")
    private Map<String, String> mobParams;

    @SerializedName("type")
    private int type;

    public SliceCellData() {
        this.type = SliceDataTypeEnum.TYPE_DEFAULT.getType();
    }

    public final String getBizData() {
        return this.bizData;
    }

    public final SliceCellDataConfig getConfig() {
        return this.config;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final Map<String, String> getMobParams() {
        return this.mobParams;
    }

    public final int getType() {
        return this.type;
    }

    public final void setBizData(String r100) {
        this.bizData = r100;
    }

    public final void setConfig(SliceCellDataConfig r100) {
        this.config = r100;
    }

    public final void setExtraParams(Map<String, String> r100) {
        this.extraParams = r100;
    }

    public final void setMobParams(Map<String, String> r100) {
        this.mobParams = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}

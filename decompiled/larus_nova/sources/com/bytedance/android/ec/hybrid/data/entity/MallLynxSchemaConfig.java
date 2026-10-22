package com.bytedance.android.ec.hybrid.data.entity;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/MallLynxSchemaConfig;", "Ljava/io/Serializable;", "()V", "cardName", "", "getCardName", "()Ljava/lang/String;", "setCardName", "(Ljava/lang/String;)V", "itemType", "", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lynxSchema", "getLynxSchema", "setLynxSchema", "ppeLynxSchema", "getPpeLynxSchema", "setPpeLynxSchema", "predictHeight", "getPredictHeight", "setPredictHeight", "queryMap", "", "getQueryMap", "()Ljava/util/Map;", "setQueryMap", "(Ljava/util/Map;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallLynxSchemaConfig implements Serializable {

    @SerializedName("card_name")
    private String cardName;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private String lynxSchema;

    @SerializedName("lynx_schema_ppe")
    private String ppeLynxSchema;

    @SerializedName("predict_height")
    private Integer predictHeight;

    @SerializedName("query_map")
    private Map<String, String> queryMap;

    public MallLynxSchemaConfig() {
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final String getLynxSchema() {
        return this.lynxSchema;
    }

    public final String getPpeLynxSchema() {
        return this.ppeLynxSchema;
    }

    public final Integer getPredictHeight() {
        return this.predictHeight;
    }

    public final Map<String, String> getQueryMap() {
        return this.queryMap;
    }

    public final void setCardName(String r100) {
        this.cardName = r100;
    }

    public final void setItemType(Integer r100) {
        this.itemType = r100;
    }

    public final void setLynxSchema(String r100) {
        this.lynxSchema = r100;
    }

    public final void setPpeLynxSchema(String r100) {
        this.ppeLynxSchema = r100;
    }

    public final void setPredictHeight(Integer r100) {
        this.predictHeight = r100;
    }

    public final void setQueryMap(Map<String, String> r100) {
        this.queryMap = r100;
    }
}

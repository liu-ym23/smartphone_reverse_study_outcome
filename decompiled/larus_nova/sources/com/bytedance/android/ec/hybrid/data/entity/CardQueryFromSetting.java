package com.bytedance.android.ec.hybrid.data.entity;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/CardQueryFromSetting;", "Ljava/io/Serializable;", "()V", "itemType", "", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "queryMap", "", "", "getQueryMap", "()Ljava/util/Map;", "setQueryMap", "(Ljava/util/Map;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardQueryFromSetting implements Serializable {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("query_map")
    private Map<String, String> queryMap;

    public CardQueryFromSetting() {
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final Map<String, String> getQueryMap() {
        return this.queryMap;
    }

    public final void setItemType(Integer r100) {
        this.itemType = r100;
    }

    public final void setQueryMap(Map<String, String> r100) {
        this.queryMap = r100;
    }
}

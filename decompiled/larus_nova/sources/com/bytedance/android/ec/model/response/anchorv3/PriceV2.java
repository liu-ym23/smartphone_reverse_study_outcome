package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PriceV2;", "Ljava/io/Serializable;", "()V", "maxPrice", "", "getMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "minPrice", "getMinPrice", "prefix", "", "getPrefix", "()Ljava/lang/String;", "styleType", "", "getStyleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "suffix", "getSuffix", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PriceV2 implements Serializable {

    @SerializedName("max_price")
    private final Long maxPrice;

    @SerializedName("min_price")
    private final Long minPrice;

    @SerializedName("prefix")
    private final String prefix;

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private final Integer styleType;

    @SerializedName("suffix")
    private final String suffix;

    public PriceV2() {
        this.styleType = 1;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final Integer getStyleType() {
        return this.styleType;
    }

    public final String getSuffix() {
        return this.suffix;
    }
}

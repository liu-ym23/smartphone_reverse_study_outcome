package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PriceDescription;", "Ljava/io/Serializable;", "()V", "styleType", "", "getStyleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "text", "", "getText", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PriceDescription implements Serializable {

    @SerializedName(MapMonitorConst.STYLE_TYPE)
    private final Integer styleType;

    @SerializedName("text")
    private final String text;

    public PriceDescription() {
        this.styleType = 1;
    }

    public final Integer getStyleType() {
        return this.styleType;
    }

    public final String getText() {
        return this.text;
    }
}

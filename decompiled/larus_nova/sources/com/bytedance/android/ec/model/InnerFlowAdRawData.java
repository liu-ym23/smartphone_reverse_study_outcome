package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/InnerFlowAdRawData;", "Ljava/io/Serializable;", "()V", "adData", "Lcom/bytedance/android/ec/model/InnerFlowAdData;", "getAdData", "()Lcom/bytedance/android/ec/model/InnerFlowAdData;", "logExtra", "", "getLogExtra", "()Ljava/lang/String;", "setLogExtra", "(Ljava/lang/String;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class InnerFlowAdRawData implements Serializable {

    @SerializedName(DynamicPatch.KEY_AD_DATA)
    private final InnerFlowAdData adData;

    @SerializedName("log_extra")
    private String logExtra;

    public InnerFlowAdRawData() {
    }

    public final InnerFlowAdData getAdData() {
        return this.adData;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }
}

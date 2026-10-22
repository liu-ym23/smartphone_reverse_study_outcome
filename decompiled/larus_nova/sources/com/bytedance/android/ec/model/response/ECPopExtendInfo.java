package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPopExtendInfo;", "Ljava/io/Serializable;", "()V", "content", "", "Lcom/bytedance/android/ec/model/response/ExtendInfoContent;", "getContent", "()Ljava/util/List;", "delay", "", "getDelay", "()J", "topContent", "Lcom/bytedance/android/ec/model/response/ExtendInfoTopContent;", "getTopContent", "()Lcom/bytedance/android/ec/model/response/ExtendInfoTopContent;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPopExtendInfo implements Serializable {

    @SerializedName("content")
    private final List<ExtendInfoContent> content;

    @SerializedName("delay")
    private final long delay;

    @SerializedName("top_content")
    private final ExtendInfoTopContent topContent;

    public ECPopExtendInfo() {
        this.delay = 5000;
    }

    public final List<ExtendInfoContent> getContent() {
        return this.content;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final ExtendInfoTopContent getTopContent() {
        return this.topContent;
    }
}

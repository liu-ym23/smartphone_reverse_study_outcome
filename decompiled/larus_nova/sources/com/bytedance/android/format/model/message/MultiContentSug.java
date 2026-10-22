package com.bytedance.android.format.model.message;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/format/model/message/MultiContentSug;", "Ljava/io/Serializable;", "()V", "algoSugType", "", "getAlgoSugType", "()Ljava/lang/String;", "setAlgoSugType", "(Ljava/lang/String;)V", "bizType", "getBizType", "setBizType", "content", "Lcom/bytedance/android/format/model/message/SugContent;", "getContent", "()Lcom/bytedance/android/format/model/message/SugContent;", "setContent", "(Lcom/bytedance/android/format/model/message/SugContent;)V", "funType", "", "getFunType", "()I", "setFunType", "(I)V", "sugId", "getSugId", "setSugId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiContentSug implements Serializable {

    @SerializedName("algo_sug_type")
    private String algoSugType;

    @SerializedName("sug_business_type")
    private String bizType;

    @SerializedName("content")
    private SugContent content;

    @SerializedName("sug_func_type")
    private int funType;

    @SerializedName("sug_id")
    private String sugId;

    public MultiContentSug() {
        this.funType = LiveMsgSugFuncType.SugFuncType_Simple.getType();
    }

    public final String getAlgoSugType() {
        return this.algoSugType;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final SugContent getContent() {
        return this.content;
    }

    public final int getFunType() {
        return this.funType;
    }

    public final String getSugId() {
        return this.sugId;
    }

    public final void setAlgoSugType(String r100) {
        this.algoSugType = r100;
    }

    public final void setBizType(String r100) {
        this.bizType = r100;
    }

    public final void setContent(SugContent r100) {
        this.content = r100;
    }

    public final void setFunType(int r100) {
        this.funType = r100;
    }

    public final void setSugId(String r100) {
        this.sugId = r100;
    }
}

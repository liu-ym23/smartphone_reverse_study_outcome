package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTipComponent;", "Ljava/io/Serializable;", "()V", "countDown", "Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "getCountDown", "()Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MarketingTipComponent implements Serializable {

    @SerializedName("countdown")
    private CountDown countDown;

    @SerializedName("text")
    private String text;

    @SerializedName("type")
    private Integer type;

    public MarketingTipComponent() {
        this.type = 0;
    }

    public final CountDown getCountDown() {
        return this.countDown;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setCountDown(CountDown r100) {
        this.countDown = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}

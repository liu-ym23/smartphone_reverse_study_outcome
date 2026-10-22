package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class FallbackPage implements Serializable {

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("show")
    private boolean show;

    @SerializedName("text")
    private String text;

    public FallbackPage() {
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getText() {
        return this.text;
    }

    public final void setIcon(ECUrlModel r100) {
        this.icon = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}

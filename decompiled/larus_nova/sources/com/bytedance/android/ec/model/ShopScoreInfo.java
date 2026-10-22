package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/ShopScoreInfo;", "Ljava/io/Serializable;", "()V", "defaultDesc", "", "getDefaultDesc", "()Ljava/lang/String;", "setDefaultDesc", "(Ljava/lang/String;)V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScore", "setScore", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ShopScoreInfo implements Serializable {

    @SerializedName("default_desc")
    private String defaultDesc;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private String score;

    public ShopScoreInfo() {
    }

    public final String getDefaultDesc() {
        return this.defaultDesc;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getScore() {
        return this.score;
    }

    public final void setDefaultDesc(String r100) {
        this.defaultDesc = r100;
    }

    public final void setIcon(ECUrlModel r100) {
        this.icon = r100;
    }

    public final void setScore(String r100) {
        this.score = r100;
    }
}

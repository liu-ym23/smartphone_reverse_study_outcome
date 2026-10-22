package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/CardBusinessType;", "Ljava/io/Serializable;", "()V", "isAd", "", "()Ljava/lang/Boolean;", "setAd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isLife", "setLife", "isLive", "setLive", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardBusinessType implements Serializable {

    @SerializedName("is_ad")
    private Boolean isAd;

    @SerializedName("is_life")
    private Boolean isLife;

    @SerializedName("is_live")
    private Boolean isLive;

    public CardBusinessType() {
    }

    public final Boolean isAd() {
        return this.isAd;
    }

    public final Boolean isLife() {
        return this.isLife;
    }

    public final Boolean isLive() {
        return this.isLive;
    }

    public final void setAd(Boolean r100) {
        this.isAd = r100;
    }

    public final void setLife(Boolean r100) {
        this.isLife = r100;
    }

    public final void setLive(Boolean r100) {
        this.isLive = r100;
    }
}

package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/FeedCardStyle;", "Ljava/io/Serializable;", "()V", "cardSpacing", "", "getCardSpacing", "()Ljava/lang/Integer;", "setCardSpacing", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedCardStyle implements Serializable {

    @SerializedName("card_spacing")
    private Integer cardSpacing;

    public FeedCardStyle() {
    }

    public final Integer getCardSpacing() {
        return this.cardSpacing;
    }

    public final void setCardSpacing(Integer r100) {
        this.cardSpacing = r100;
    }
}

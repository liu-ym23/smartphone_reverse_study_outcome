package com.bytedance.android.shopping.store.hybridproduct.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopFooterDTO;", "Ljava/io/Serializable;", "()V", "fontSize", "", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "text", "", "getText", "()Ljava/lang/String;", "textColor", "getTextColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFooterDTO implements Serializable {

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public ECShopFooterDTO() {
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }
}

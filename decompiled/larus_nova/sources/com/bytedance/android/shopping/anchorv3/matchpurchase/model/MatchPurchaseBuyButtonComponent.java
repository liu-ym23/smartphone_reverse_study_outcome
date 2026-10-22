package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseBuyButtonComponent;", "Ljava/io/Serializable;", "()V", "links", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseLinks;", "getLinks", "()Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/MatchPurchaseLinks;", n.KEY_SUB_TEXT, "", "getSubText", "()Ljava/lang/String;", "text", "getText", "wordColor", "getWordColor", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchaseBuyButtonComponent implements Serializable {

    @SerializedName("links")
    private final MatchPurchaseLinks links;

    @SerializedName("sub_text")
    private final String subText;

    @SerializedName("text")
    private final String text;

    @SerializedName("word_color")
    private final String wordColor;

    public MatchPurchaseBuyButtonComponent() {
    }

    public final MatchPurchaseLinks getLinks() {
        return this.links;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getWordColor() {
        return this.wordColor;
    }
}

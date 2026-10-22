package com.stepos.ailauncher.network.model;

import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/network/model/RecommendCard;", "", "id", "", "iconUrl", "displayText", HighlightArgsBundle.KEY_PROMPT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIconUrl", "getDisplayText", "getPrompt", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RecommendCard {

    @SerializedName("displayText")
    private final String displayText;

    @SerializedName("iconUrl")
    private final String iconUrl;

    @SerializedName("id")
    private final String id;

    @SerializedName(HighlightArgsBundle.KEY_PROMPT)
    private final String prompt;

    public RecommendCard() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RecommendCard copy$default(RecommendCard recommendCard, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = recommendCard.id;
        }
        if ((i10 & 2) != 0) {
            str2 = recommendCard.iconUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = recommendCard.displayText;
        }
        if ((i10 & 8) != 0) {
            str4 = recommendCard.prompt;
        }
        return recommendCard.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayText() {
        return this.displayText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public final RecommendCard copy(String id, String iconUrl, String displayText, String prompt) {
        return new RecommendCard(id, iconUrl, displayText, prompt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendCard)) {
            return false;
        }
        RecommendCard recommendCard = (RecommendCard) other;
        return p.d(this.id, recommendCard.id) && p.d(this.iconUrl, recommendCard.iconUrl) && p.d(this.displayText, recommendCard.displayText) && p.d(this.prompt, recommendCard.prompt);
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.displayText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.prompt;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "RecommendCard(id=" + this.id + ", iconUrl=" + this.iconUrl + ", displayText=" + this.displayText + ", prompt=" + this.prompt + ")";
    }

    public RecommendCard(String str, String str2, String str3, String str4) {
        this.id = str;
        this.iconUrl = str2;
        this.displayText = str3;
        this.prompt = str4;
    }

    public /* synthetic */ RecommendCard(String str, String str2, String str3, String str4, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}

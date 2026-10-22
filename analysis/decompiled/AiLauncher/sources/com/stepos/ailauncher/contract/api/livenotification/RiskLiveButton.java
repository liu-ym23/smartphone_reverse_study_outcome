package com.stepos.ailauncher.contract.api.livenotification;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "", "id", "", "text", "style", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getText", "getStyle", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RiskLiveButton {
    private final String id;
    private final String style;
    private final String text;

    public RiskLiveButton(String id, String text, String style) {
        p.i(id, "id");
        p.i(text, "text");
        p.i(style, "style");
        this.id = id;
        this.text = text;
        this.style = style;
    }

    public static /* synthetic */ RiskLiveButton copy$default(RiskLiveButton riskLiveButton, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = riskLiveButton.id;
        }
        if ((i10 & 2) != 0) {
            str2 = riskLiveButton.text;
        }
        if ((i10 & 4) != 0) {
            str3 = riskLiveButton.style;
        }
        return riskLiveButton.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    public final RiskLiveButton copy(String id, String text, String style) {
        p.i(id, "id");
        p.i(text, "text");
        p.i(style, "style");
        return new RiskLiveButton(id, text, style);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiskLiveButton)) {
            return false;
        }
        RiskLiveButton riskLiveButton = (RiskLiveButton) other;
        return p.d(this.id, riskLiveButton.id) && p.d(this.text, riskLiveButton.text) && p.d(this.style, riskLiveButton.style);
    }

    public final String getId() {
        return this.id;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + this.style.hashCode();
    }

    public String toString() {
        return "RiskLiveButton(id=" + this.id + ", text=" + this.text + ", style=" + this.style + ")";
    }
}

package com.stepos.agentframework.adapter.dify.bean;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.k;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u00064"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/Usage;", "", "completionPrice", "", "completionPriceUnit", "completionTokens", "", "completionUnitPrice", "currency", "latency", "", "promptPrice", "promptPriceUnit", "promptTokens", "promptUnitPrice", "totalPrice", "totalTokens", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getCompletionPrice", "()Ljava/lang/String;", "getCompletionPriceUnit", "getCompletionTokens", "()I", "getCompletionUnitPrice", "getCurrency", "getLatency", "()D", "getPromptPrice", "getPromptPriceUnit", "getPromptTokens", "getPromptUnitPrice", "getTotalPrice", "getTotalTokens", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Usage {

    @SerializedName("completion_price")
    private final String completionPrice;

    @SerializedName("completion_price_unit")
    private final String completionPriceUnit;

    @SerializedName("completion_tokens")
    private final int completionTokens;

    @SerializedName("completion_unit_price")
    private final String completionUnitPrice;

    @SerializedName("currency")
    private final String currency;

    @SerializedName("latency")
    private final double latency;

    @SerializedName("prompt_price")
    private final String promptPrice;

    @SerializedName("prompt_price_unit")
    private final String promptPriceUnit;

    @SerializedName("prompt_tokens")
    private final int promptTokens;

    @SerializedName("prompt_unit_price")
    private final String promptUnitPrice;

    @SerializedName("total_price")
    private final String totalPrice;

    @SerializedName("total_tokens")
    private final int totalTokens;

    public Usage(String completionPrice, String completionPriceUnit, int i, String completionUnitPrice, String currency, double d, String promptPrice, String promptPriceUnit, int i6, String promptUnitPrice, String totalPrice, int i10) {
        k.f(completionPrice, "completionPrice");
        k.f(completionPriceUnit, "completionPriceUnit");
        k.f(completionUnitPrice, "completionUnitPrice");
        k.f(currency, "currency");
        k.f(promptPrice, "promptPrice");
        k.f(promptPriceUnit, "promptPriceUnit");
        k.f(promptUnitPrice, "promptUnitPrice");
        k.f(totalPrice, "totalPrice");
        this.completionPrice = completionPrice;
        this.completionPriceUnit = completionPriceUnit;
        this.completionTokens = i;
        this.completionUnitPrice = completionUnitPrice;
        this.currency = currency;
        this.latency = d;
        this.promptPrice = promptPrice;
        this.promptPriceUnit = promptPriceUnit;
        this.promptTokens = i6;
        this.promptUnitPrice = promptUnitPrice;
        this.totalPrice = totalPrice;
        this.totalTokens = i10;
    }

    public static /* synthetic */ Usage copy$default(Usage usage, String str, String str2, int i, String str3, String str4, double d, String str5, String str6, int i6, String str7, String str8, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = usage.completionPrice;
        }
        return usage.copy(str, (i11 & 2) != 0 ? usage.completionPriceUnit : str2, (i11 & 4) != 0 ? usage.completionTokens : i, (i11 & 8) != 0 ? usage.completionUnitPrice : str3, (i11 & 16) != 0 ? usage.currency : str4, (i11 & 32) != 0 ? usage.latency : d, (i11 & 64) != 0 ? usage.promptPrice : str5, (i11 & 128) != 0 ? usage.promptPriceUnit : str6, (i11 & 256) != 0 ? usage.promptTokens : i6, (i11 & 512) != 0 ? usage.promptUnitPrice : str7, (i11 & 1024) != 0 ? usage.totalPrice : str8, (i11 & 2048) != 0 ? usage.totalTokens : i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCompletionPrice() {
        return this.completionPrice;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPromptUnitPrice() {
        return this.promptUnitPrice;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTotalPrice() {
        return this.totalPrice;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTotalTokens() {
        return this.totalTokens;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCompletionPriceUnit() {
        return this.completionPriceUnit;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCompletionTokens() {
        return this.completionTokens;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCompletionUnitPrice() {
        return this.completionUnitPrice;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component6, reason: from getter */
    public final double getLatency() {
        return this.latency;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPromptPrice() {
        return this.promptPrice;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPromptPriceUnit() {
        return this.promptPriceUnit;
    }

    /* renamed from: component9, reason: from getter */
    public final int getPromptTokens() {
        return this.promptTokens;
    }

    public final Usage copy(String completionPrice, String completionPriceUnit, int completionTokens, String completionUnitPrice, String currency, double latency, String promptPrice, String promptPriceUnit, int promptTokens, String promptUnitPrice, String totalPrice, int totalTokens) {
        k.f(completionPrice, "completionPrice");
        k.f(completionPriceUnit, "completionPriceUnit");
        k.f(completionUnitPrice, "completionUnitPrice");
        k.f(currency, "currency");
        k.f(promptPrice, "promptPrice");
        k.f(promptPriceUnit, "promptPriceUnit");
        k.f(promptUnitPrice, "promptUnitPrice");
        k.f(totalPrice, "totalPrice");
        return new Usage(completionPrice, completionPriceUnit, completionTokens, completionUnitPrice, currency, latency, promptPrice, promptPriceUnit, promptTokens, promptUnitPrice, totalPrice, totalTokens);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Usage)) {
            return false;
        }
        Usage usage = (Usage) other;
        return k.b(this.completionPrice, usage.completionPrice) && k.b(this.completionPriceUnit, usage.completionPriceUnit) && this.completionTokens == usage.completionTokens && k.b(this.completionUnitPrice, usage.completionUnitPrice) && k.b(this.currency, usage.currency) && Double.compare(this.latency, usage.latency) == 0 && k.b(this.promptPrice, usage.promptPrice) && k.b(this.promptPriceUnit, usage.promptPriceUnit) && this.promptTokens == usage.promptTokens && k.b(this.promptUnitPrice, usage.promptUnitPrice) && k.b(this.totalPrice, usage.totalPrice) && this.totalTokens == usage.totalTokens;
    }

    public final String getCompletionPrice() {
        return this.completionPrice;
    }

    public final String getCompletionPriceUnit() {
        return this.completionPriceUnit;
    }

    public final int getCompletionTokens() {
        return this.completionTokens;
    }

    public final String getCompletionUnitPrice() {
        return this.completionUnitPrice;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final double getLatency() {
        return this.latency;
    }

    public final String getPromptPrice() {
        return this.promptPrice;
    }

    public final String getPromptPriceUnit() {
        return this.promptPriceUnit;
    }

    public final int getPromptTokens() {
        return this.promptTokens;
    }

    public final String getPromptUnitPrice() {
        return this.promptUnitPrice;
    }

    public final String getTotalPrice() {
        return this.totalPrice;
    }

    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public int hashCode() {
        return Integer.hashCode(this.totalTokens) + a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.promptTokens, a.c(a.c((Double.hashCode(this.latency) + a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.completionTokens, a.c(this.completionPrice.hashCode() * 31, 31, this.completionPriceUnit), 31), 31, this.completionUnitPrice), 31, this.currency)) * 31, 31, this.promptPrice), 31, this.promptPriceUnit), 31), 31, this.promptUnitPrice), 31, this.totalPrice);
    }

    public String toString() {
        String str = this.completionPrice;
        String str2 = this.completionPriceUnit;
        int i = this.completionTokens;
        String str3 = this.completionUnitPrice;
        String str4 = this.currency;
        double d = this.latency;
        String str5 = this.promptPrice;
        String str6 = this.promptPriceUnit;
        int i6 = this.promptTokens;
        String str7 = this.promptUnitPrice;
        String str8 = this.totalPrice;
        int i10 = this.totalTokens;
        StringBuilder sbW = a.w("Usage(completionPrice=", str, ", completionPriceUnit=", str2, ", completionTokens=");
        sbW.append(i);
        sbW.append(", completionUnitPrice=");
        sbW.append(str3);
        sbW.append(", currency=");
        sbW.append(str4);
        sbW.append(", latency=");
        sbW.append(d);
        androidx.constraintlayout.core.dsl.a.A(sbW, ", promptPrice=", str5, ", promptPriceUnit=", str6);
        sbW.append(", promptTokens=");
        sbW.append(i6);
        sbW.append(", promptUnitPrice=");
        sbW.append(str7);
        sbW.append(", totalPrice=");
        sbW.append(str8);
        sbW.append(", totalTokens=");
        sbW.append(i10);
        sbW.append(")");
        return sbW.toString();
    }
}

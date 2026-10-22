package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d0;", "", "", "text", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "color", "b", "setColor", "", CommodityText.BOLD, "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setBold", "(Z)V", "showStrikeThrough", "Ljava/lang/Boolean;", "getShowStrikeThrough", "()Ljava/lang/Boolean;", "setShowStrikeThrough", "(Ljava/lang/Boolean;)V", "", "fontSize", "I", "getFontSize", "()I", "setFontSize", "(I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName(CommodityText.BOLD)
    private boolean bold;

    @SerializedName("color")
    private String color;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("show_strike_through")
    private Boolean showStrikeThrough;

    @SerializedName("text")
    private String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d0) == false) goto L16;
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L10;
        return false;
    L10:
        if (this.bold == r101.bold) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showStrikeThrough, r101.showStrikeThrough) == true) goto L14;
        return false;
    L14:
        if (this.fontSize == r101.fontSize) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.color;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.bold;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showStrikeThrough;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return ((r109 + r101) * 31) + this.fontSize;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroPriceDescriptionText(text=" + this.text + ", color=" + this.color + ", bold=" + this.bold + ", showStrikeThrough=" + this.showStrikeThrough + ", fontSize=" + this.fontSize + ")";
    }

    public d0() {
        this.text = null;
        this.color = null;
        this.bold = false;
        this.showStrikeThrough = null;
        this.fontSize = 0;
    }

    public final boolean a() {
        return this.bold;
    }

    public final String b() {
        return this.color;
    }

    public final String c() {
        return this.text;
    }

    public final void d(String r100) {
        this.text = r100;
    }
}

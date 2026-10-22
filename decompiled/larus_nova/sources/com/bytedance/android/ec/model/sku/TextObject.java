package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/model/sku/TextObject;", "Ljava/io/Serializable;", "text", "", "fontColor", "fontSize", "", CommodityText.BOLD, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBold", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFontColor", "()Ljava/lang/String;", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/ec/model/sku/TextObject;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class TextObject implements Serializable {

    @SerializedName(CommodityText.BOLD)
    private final Boolean bold;

    @SerializedName("font_color")
    private final String fontColor;

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName("text")
    private final String text;

    public TextObject() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TextObject copy$default(TextObject r100, String r101, String r102, Integer r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fontColor;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.fontSize;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bold;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.fontColor;
    }

    public final Integer component3() {
        return this.fontSize;
    }

    public final Boolean component4() {
        return this.bold;
    }

    public final TextObject copy(String r100, String r101, Integer r102, Boolean r103) {
        return new TextObject(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextObject) == false) goto L14;
        TextObject r101 = (TextObject) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bold, r101.bold) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.fontColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.fontSize;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.bold;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TextObject(text=" + this.text + ", fontColor=" + this.fontColor + ", fontSize=" + this.fontSize + ", bold=" + this.bold + ")";
    }

    public final Boolean getBold() {
        return this.bold;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final String getText() {
        return this.text;
    }

    public TextObject(String r100, String r101, Integer r102, Boolean r103) {
        this.text = r100;
        this.fontColor = r101;
        this.fontSize = r102;
        this.bold = r103;
    }

    public /* synthetic */ TextObject(String r100, String r101, Integer r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = Boolean.FALSE;
    L14:
        this(r100, r101, r102, r103);
    }
}

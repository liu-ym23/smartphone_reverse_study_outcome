package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/TextPattern;", "Ljava/io/Serializable;", "height", "", "textSize", "innerPadding", "outerPadding", "(IIII)V", "getHeight", "()I", "getInnerPadding", "getOuterPadding", "getTextSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class TextPattern implements Serializable {

    @SerializedName("height")
    private final int height;

    @SerializedName("inner_padding")
    private final int innerPadding;

    @SerializedName("outer_padding")
    private final int outerPadding;

    @SerializedName("text_size")
    private final int textSize;

    public TextPattern() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ TextPattern copy$default(TextPattern r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.height;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.textSize;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.innerPadding;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.outerPadding;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.textSize;
    }

    public final int component3() {
        return this.innerPadding;
    }

    public final int component4() {
        return this.outerPadding;
    }

    public final TextPattern copy(int r100, int r101, int r102, int r103) {
        return new TextPattern(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextPattern) == false) goto L14;
        TextPattern r101 = (TextPattern) r100;
        if (this.height == r101.height) goto L8;
        return false;
    L8:
        if (this.textSize == r101.textSize) goto L10;
        return false;
    L10:
        if (this.innerPadding == r101.innerPadding) goto L12;
        return false;
    L12:
        if (this.outerPadding == r101.outerPadding) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.height * 31) + this.textSize) * 31) + this.innerPadding) * 31) + this.outerPadding;
    }

    public String toString() {
        return "TextPattern(height=" + this.height + ", textSize=" + this.textSize + ", innerPadding=" + this.innerPadding + ", outerPadding=" + this.outerPadding + ")";
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getInnerPadding() {
        return this.innerPadding;
    }

    public final int getOuterPadding() {
        return this.outerPadding;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public TextPattern(int r100, int r101, int r102, int r103) {
        this.height = r100;
        this.textSize = r101;
        this.innerPadding = r102;
        this.outerPadding = r103;
    }

    public /* synthetic */ TextPattern(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 16;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 10;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 4;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}

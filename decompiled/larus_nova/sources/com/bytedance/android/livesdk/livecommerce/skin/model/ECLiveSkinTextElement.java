package com.bytedance.android.livesdk.livecommerce.skin.model;

import androidx.core.provider.FontsContractCompat;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;", "Ljava/io/Serializable;", "fontSize", "", "color", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "fontWeight", "(ILjava/util/List;I)V", "getColor", "()Ljava/util/List;", "getFontSize", "()I", "getFontWeight", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinTextElement implements Serializable {

    @SerializedName("color")
    private final List<String> color;

    @SerializedName("font_size")
    private final int fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final int fontWeight;

    public ECLiveSkinTextElement() {
        this(0, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinTextElement copy$default(ECLiveSkinTextElement r100, int r101, List r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.fontSize;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.color;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.fontWeight;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.fontSize;
    }

    public final List<String> component2() {
        return this.color;
    }

    public final int component3() {
        return this.fontWeight;
    }

    public final ECLiveSkinTextElement copy(int r100, List<String> r101, int r102) {
        return new ECLiveSkinTextElement(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinTextElement) == false) goto L12;
        ECLiveSkinTextElement r101 = (ECLiveSkinTextElement) r100;
        if (this.fontSize == r101.fontSize) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L10;
        return false;
    L10:
        if (this.fontWeight == r101.fontWeight) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.fontSize * 31;
        List<String> r101 = this.color;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.fontWeight;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "ECLiveSkinTextElement(fontSize=" + this.fontSize + ", color=" + this.color + ", fontWeight=" + this.fontWeight + ")";
    }

    public final List<String> getColor() {
        return this.color;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getFontWeight() {
        return this.fontWeight;
    }

    public ECLiveSkinTextElement(int r100, List<String> r101, int r102) {
        this.fontSize = r100;
        this.color = r101;
        this.fontWeight = r102;
    }

    public /* synthetic */ ECLiveSkinTextElement(int r100, List r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}

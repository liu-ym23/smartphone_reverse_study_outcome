package com.bytedance.android.shopping.anchorv4.dto.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Highlight;", "Ljava/io/Serializable;", "start", "", "end", "highlightStyle", "Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "link", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;)V", "getEnd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHighlightStyle", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "getLink", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getStart", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;)Lcom/bytedance/android/shopping/anchorv4/dto/base/Highlight;", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Highlight implements Serializable {

    @SerializedName("end")
    private final Integer end;

    @SerializedName("highlight_style")
    private final FontStyle highlightStyle;

    @SerializedName("link")
    private final Link link;

    @SerializedName("start")
    private final Integer start;

    public Highlight() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Highlight copy$default(Highlight r100, Integer r101, Integer r102, FontStyle r103, Link r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.start;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.end;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.highlightStyle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.link;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.start;
    }

    public final Integer component2() {
        return this.end;
    }

    public final FontStyle component3() {
        return this.highlightStyle;
    }

    public final Link component4() {
        return this.link;
    }

    public final Highlight copy(Integer r100, Integer r101, FontStyle r102, Link r103) {
        return new Highlight(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Highlight) == false) goto L14;
        Highlight r101 = (Highlight) r100;
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.highlightStyle, r101.highlightStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.start;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.end;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FontStyle r107 = this.highlightStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Link r110 = this.link;
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
        return "Highlight(start=" + this.start + ", end=" + this.end + ", highlightStyle=" + this.highlightStyle + ", link=" + this.link + ")";
    }

    public final Integer getEnd() {
        return this.end;
    }

    public final FontStyle getHighlightStyle() {
        return this.highlightStyle;
    }

    public final Link getLink() {
        return this.link;
    }

    public final Integer getStart() {
        return this.start;
    }

    public Highlight(Integer r100, Integer r101, FontStyle r102, Link r103) {
        this.start = r100;
        this.end = r101;
        this.highlightStyle = r102;
        this.link = r103;
    }

    public /* synthetic */ Highlight(Integer r100, Integer r101, FontStyle r102, Link r103, int r104, DefaultConstructorMarker r105) {
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
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

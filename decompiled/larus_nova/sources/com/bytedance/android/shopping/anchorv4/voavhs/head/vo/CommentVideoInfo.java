package com.bytedance.android.shopping.anchorv4.voavhs.head.vo;

import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "Ljava/io/Serializable;", "authorHead", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "authorName", "moreText", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getAuthorHead", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getAuthorName", "getMoreText", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentVideoInfo implements Serializable {

    @SerializedName("author_head")
    private final TextWithOneIconElement authorHead;

    @SerializedName("author_name")
    private final TextWithOneIconElement authorName;

    @SerializedName("more_text")
    private final TextWithOneIconElement moreText;

    public CommentVideoInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CommentVideoInfo copy$default(CommentVideoInfo r100, TextWithOneIconElement r101, TextWithOneIconElement r102, TextWithOneIconElement r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.authorHead;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.authorName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.moreText;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final TextWithOneIconElement component1() {
        return this.authorHead;
    }

    public final TextWithOneIconElement component2() {
        return this.authorName;
    }

    public final TextWithOneIconElement component3() {
        return this.moreText;
    }

    public final CommentVideoInfo copy(TextWithOneIconElement r100, TextWithOneIconElement r101, TextWithOneIconElement r102) {
        return new CommentVideoInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommentVideoInfo) == false) goto L12;
        CommentVideoInfo r101 = (CommentVideoInfo) r100;
        if (Intrinsics.areEqual(this.authorHead, r101.authorHead) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.authorName, r101.authorName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moreText, r101.moreText) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r100 = this.authorHead;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextWithOneIconElement r104 = this.authorName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextWithOneIconElement r107 = this.moreText;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CommentVideoInfo(authorHead=" + this.authorHead + ", authorName=" + this.authorName + ", moreText=" + this.moreText + ")";
    }

    public final TextWithOneIconElement getAuthorHead() {
        return this.authorHead;
    }

    public final TextWithOneIconElement getAuthorName() {
        return this.authorName;
    }

    public final TextWithOneIconElement getMoreText() {
        return this.moreText;
    }

    public CommentVideoInfo(TextWithOneIconElement r100, TextWithOneIconElement r101, TextWithOneIconElement r102) {
        this.authorHead = r100;
        this.authorName = r101;
        this.moreText = r102;
    }

    public /* synthetic */ CommentVideoInfo(TextWithOneIconElement r100, TextWithOneIconElement r101, TextWithOneIconElement r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

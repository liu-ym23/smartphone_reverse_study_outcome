package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/FeaturedComment;", "Ljava/io/Serializable;", "featuredTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "featuredCommentList", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/CommentInfoVO;", "moreCommentTitle", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getFeaturedCommentList", "()Ljava/util/List;", "getFeaturedTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getMoreCommentTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeaturedComment implements Serializable {

    @SerializedName("feature_comment_list")
    private final List<CommentInfoVO> featuredCommentList;

    @SerializedName("featured_title")
    private final TextWithOneIconElement featuredTitle;

    @SerializedName("more_comment_title")
    private final TextWithOneIconElement moreCommentTitle;

    public FeaturedComment() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeaturedComment copy$default(FeaturedComment r100, TextWithOneIconElement r101, List r102, TextWithOneIconElement r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.featuredTitle;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.featuredCommentList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.moreCommentTitle;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final TextWithOneIconElement component1() {
        return this.featuredTitle;
    }

    public final List<CommentInfoVO> component2() {
        return this.featuredCommentList;
    }

    public final TextWithOneIconElement component3() {
        return this.moreCommentTitle;
    }

    public final FeaturedComment copy(TextWithOneIconElement r100, List<CommentInfoVO> r101, TextWithOneIconElement r102) {
        return new FeaturedComment(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FeaturedComment) == false) goto L12;
        FeaturedComment r101 = (FeaturedComment) r100;
        if (Intrinsics.areEqual(this.featuredTitle, r101.featuredTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.featuredCommentList, r101.featuredCommentList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moreCommentTitle, r101.moreCommentTitle) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r100 = this.featuredTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<CommentInfoVO> r104 = this.featuredCommentList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextWithOneIconElement r107 = this.moreCommentTitle;
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
        return "FeaturedComment(featuredTitle=" + this.featuredTitle + ", featuredCommentList=" + this.featuredCommentList + ", moreCommentTitle=" + this.moreCommentTitle + ")";
    }

    public final List<CommentInfoVO> getFeaturedCommentList() {
        return this.featuredCommentList;
    }

    public final TextWithOneIconElement getFeaturedTitle() {
        return this.featuredTitle;
    }

    public final TextWithOneIconElement getMoreCommentTitle() {
        return this.moreCommentTitle;
    }

    public FeaturedComment(TextWithOneIconElement r100, List<CommentInfoVO> r101, TextWithOneIconElement r102) {
        this.featuredTitle = r100;
        this.featuredCommentList = r101;
        this.moreCommentTitle = r102;
    }

    public /* synthetic */ FeaturedComment(TextWithOneIconElement r100, List r101, TextWithOneIconElement r102, int r103, DefaultConstructorMarker r104) {
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

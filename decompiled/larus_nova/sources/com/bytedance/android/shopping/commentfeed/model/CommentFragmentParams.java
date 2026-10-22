package com.bytedance.android.shopping.commentfeed.model;

import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/model/CommentFragmentParams;", "Ljava/io/Serializable;", "comment", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "curIndex", "", "(Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;I)V", "getComment", "()Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "getCurIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentFragmentParams implements Serializable {
    private final PromotionProductCommentDTO comment;
    private final int curIndex;

    public static /* synthetic */ CommentFragmentParams copy$default(CommentFragmentParams r100, PromotionProductCommentDTO r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.comment;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.curIndex;
    L9:
        return r100.copy(r101, r102);
    }

    public final PromotionProductCommentDTO component1() {
        return this.comment;
    }

    public final int component2() {
        return this.curIndex;
    }

    public final CommentFragmentParams copy(PromotionProductCommentDTO r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "comment");
        return new CommentFragmentParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommentFragmentParams) == false) goto L10;
        CommentFragmentParams r101 = (CommentFragmentParams) r100;
        if (Intrinsics.areEqual(this.comment, r101.comment) == true) goto L8;
        return false;
    L8:
        if (this.curIndex == r101.curIndex) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        PromotionProductCommentDTO r100 = this.comment;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.curIndex;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "CommentFragmentParams(comment=" + this.comment + ", curIndex=" + this.curIndex + ")";
    }

    public final PromotionProductCommentDTO getComment() {
        return this.comment;
    }

    public final int getCurIndex() {
        return this.curIndex;
    }

    public CommentFragmentParams(PromotionProductCommentDTO r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "comment");
        this.comment = r100;
        this.curIndex = r101;
    }
}

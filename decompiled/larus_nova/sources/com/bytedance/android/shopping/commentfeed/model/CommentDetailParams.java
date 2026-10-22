package com.bytedance.android.shopping.commentfeed.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/model/CommentDetailParams;", "Ljava/io/Serializable;", "productId", "", "commentId", "commentCursor", "", "commentEntrance", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getCommentCursor", "()J", "setCommentCursor", "(J)V", "getCommentEntrance", "()Ljava/lang/String;", "setCommentEntrance", "(Ljava/lang/String;)V", "getCommentId", "setCommentId", "getProductId", "setProductId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentDetailParams implements Serializable {
    private long commentCursor;
    private String commentEntrance;
    private String commentId;
    private String productId;

    public CommentDetailParams() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ CommentDetailParams copy$default(CommentDetailParams r100, String r101, String r102, long r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.productId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.commentId;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.commentCursor;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.commentEntrance;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.commentId;
    }

    public final long component3() {
        return this.commentCursor;
    }

    public final String component4() {
        return this.commentEntrance;
    }

    public final CommentDetailParams copy(String r100, String r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "commentId");
        Intrinsics.checkNotNullParameter(r111, "commentEntrance");
        return new CommentDetailParams(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommentDetailParams) == false) goto L14;
        CommentDetailParams r101 = (CommentDetailParams) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commentId, r101.commentId) == true) goto L10;
        return false;
    L10:
        if (this.commentCursor == r101.commentCursor) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentEntrance, r101.commentEntrance) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.commentId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.commentCursor;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.commentEntrance;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CommentDetailParams(productId=" + this.productId + ", commentId=" + this.commentId + ", commentCursor=" + this.commentCursor + ", commentEntrance=" + this.commentEntrance + ")";
    }

    public final long getCommentCursor() {
        return this.commentCursor;
    }

    public final String getCommentEntrance() {
        return this.commentEntrance;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setCommentCursor(long r100) {
        this.commentCursor = r100;
    }

    public final void setCommentEntrance(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentEntrance = r100;
    }

    public final void setCommentId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentId = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public CommentDetailParams(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "commentId");
        Intrinsics.checkNotNullParameter(r103, "commentEntrance");
        this.productId = r100;
        this.commentId = r101;
        this.commentCursor = r102;
        this.commentEntrance = r103;
    }

    public /* synthetic */ CommentDetailParams(String r100, String r101, long r102, String r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r105 = r102;
        if ((r110 & 8) == 0) goto L16;
        String r113 = "";
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L9:
        r104 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}

package com.bytedance.android.gamecp.business.gamedetail.component.comment;

import com.bytedance.android.gamecp.business.comment.data.d;
import com.bytedance.android.gamecp.business.comment.data.f;
import com.bytedance.android.gamecp.business.comment.data.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/comment/b;", "", "Lcom/bytedance/android/gamecp/business/comment/data/d;", "commentEntrance", "Lcom/bytedance/android/gamecp/business/comment/data/d;", "Lcom/bytedance/android/gamecp/business/comment/data/g;", "gradeInfo", "Lcom/bytedance/android/gamecp/business/comment/data/g;", "Lcom/bytedance/android/gamecp/business/comment/data/f;", "gameInfo", "Lcom/bytedance/android/gamecp/business/comment/data/f;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMMENT_ENTRANCE)
    public d commentEntrance;

    @SerializedName("game_info")
    public f gameInfo;

    @SerializedName("grade_info")
    public g gradeInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.commentEntrance, r101.commentEntrance) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gradeInfo, r101.gradeInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gameInfo, r101.gameInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        d r100 = this.commentEntrance;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        g r104 = this.gradeInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.gameInfo;
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

    public final String toString() {
        return "GameCommentEntryData(commentEntrance=" + this.commentEntrance + ", gradeInfo=" + this.gradeInfo + ", gameInfo=" + this.gameInfo + ")";
    }

    public b() {
        this.commentEntrance = null;
        this.gradeInfo = null;
        this.gameInfo = null;
    }
}

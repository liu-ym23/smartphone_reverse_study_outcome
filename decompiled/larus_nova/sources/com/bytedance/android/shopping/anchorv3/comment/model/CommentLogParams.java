package com.bytedance.android.shopping.anchorv3.comment.model;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentLogParams;", "Ljava/io/Serializable;", "commentEntrance", "", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "v3EventAddition", "entranceInfo", "anchorV3ExtraData", "Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "sourcePage", "tagLabelName", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;Ljava/lang/String;Ljava/lang/String;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAnchorV3ExtraData", "()Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "getCommentEntrance", "()Ljava/lang/String;", "setCommentEntrance", "(Ljava/lang/String;)V", "getEntranceInfo", "getSourcePage", "getTagLabelName", "getV3EventAddition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentLogParams implements Serializable {
    private final ECAdLogExtra adLogExtra;
    private final ECAnchorV3ExtraData anchorV3ExtraData;
    private String commentEntrance;
    private final String entranceInfo;
    private final String sourcePage;
    private final String tagLabelName;
    private final String v3EventAddition;

    public CommentLogParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CommentLogParams copy$default(CommentLogParams r100, String r101, ECAdLogExtra r102, String r103, String r104, ECAnchorV3ExtraData r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.commentEntrance;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.adLogExtra;
    L8:
        ECAdLogExtra r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.v3EventAddition;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.entranceInfo;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.anchorV3ExtraData;
    L17:
        ECAnchorV3ExtraData r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.sourcePage;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.tagLabelName;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.commentEntrance;
    }

    public final ECAdLogExtra component2() {
        return this.adLogExtra;
    }

    public final String component3() {
        return this.v3EventAddition;
    }

    public final String component4() {
        return this.entranceInfo;
    }

    public final ECAnchorV3ExtraData component5() {
        return this.anchorV3ExtraData;
    }

    public final String component6() {
        return this.sourcePage;
    }

    public final String component7() {
        return this.tagLabelName;
    }

    public final CommentLogParams copy(String r110, ECAdLogExtra r111, String r112, String r113, ECAnchorV3ExtraData r114, String r115, String r116) {
        return new CommentLogParams(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommentLogParams) == false) goto L20;
        CommentLogParams r101 = (CommentLogParams) r100;
        if (Intrinsics.areEqual(this.commentEntrance, r101.commentEntrance) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.adLogExtra, r101.adLogExtra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.v3EventAddition, r101.v3EventAddition) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.anchorV3ExtraData, r101.anchorV3ExtraData) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tagLabelName, r101.tagLabelName) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.commentEntrance;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECAdLogExtra r104 = this.adLogExtra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.v3EventAddition;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.entranceInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECAnchorV3ExtraData r113 = this.anchorV3ExtraData;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.sourcePage;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.tagLabelName;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "CommentLogParams(commentEntrance=" + this.commentEntrance + ", adLogExtra=" + this.adLogExtra + ", v3EventAddition=" + this.v3EventAddition + ", entranceInfo=" + this.entranceInfo + ", anchorV3ExtraData=" + this.anchorV3ExtraData + ", sourcePage=" + this.sourcePage + ", tagLabelName=" + this.tagLabelName + ")";
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final ECAnchorV3ExtraData getAnchorV3ExtraData() {
        return this.anchorV3ExtraData;
    }

    public final String getCommentEntrance() {
        return this.commentEntrance;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getTagLabelName() {
        return this.tagLabelName;
    }

    public final String getV3EventAddition() {
        return this.v3EventAddition;
    }

    public final void setCommentEntrance(String r100) {
        this.commentEntrance = r100;
    }

    public CommentLogParams(String r100, ECAdLogExtra r101, String r102, String r103, ECAnchorV3ExtraData r104, String r105, String r106) {
        this.commentEntrance = r100;
        this.adLogExtra = r101;
        this.v3EventAddition = r102;
        this.entranceInfo = r103;
        this.anchorV3ExtraData = r104;
        this.sourcePage = r105;
        this.tagLabelName = r106;
    }

    public /* synthetic */ CommentLogParams(String r100, ECAdLogExtra r101, String r102, String r110, ECAnchorV3ExtraData r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        ECAdLogExtra r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        ECAnchorV3ExtraData r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}

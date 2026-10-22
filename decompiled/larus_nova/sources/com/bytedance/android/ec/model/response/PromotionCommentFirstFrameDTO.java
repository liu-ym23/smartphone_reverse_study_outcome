package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionCommentFirstFrameDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/s0;", "component1", "Lcom/bytedance/android/ec/model/response/t0;", "component2", "firstFramePageData", "firstFrameListData", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/ec/model/response/s0;", "getFirstFramePageData", "()Lcom/bytedance/android/ec/model/response/s0;", "setFirstFramePageData", "(Lcom/bytedance/android/ec/model/response/s0;)V", "Lcom/bytedance/android/ec/model/response/t0;", "getFirstFrameListData", "()Lcom/bytedance/android/ec/model/response/t0;", "setFirstFrameListData", "(Lcom/bytedance/android/ec/model/response/t0;)V", "<init>", "(Lcom/bytedance/android/ec/model/response/s0;Lcom/bytedance/android/ec/model/response/t0;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionCommentFirstFrameDTO implements Serializable {

    @SerializedName("comment_head_list")
    private t0 firstFrameListData;

    @SerializedName("comment_head_page")
    private s0 firstFramePageData;

    /* JADX WARN: Multi-variable type inference failed */
    public PromotionCommentFirstFrameDTO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PromotionCommentFirstFrameDTO copy$default(PromotionCommentFirstFrameDTO r100, s0 r101, t0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.firstFramePageData;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.firstFrameListData;
    L9:
        return r100.copy(r101, r102);
    }

    public final s0 component1() {
        return this.firstFramePageData;
    }

    public final t0 component2() {
        return this.firstFrameListData;
    }

    public final PromotionCommentFirstFrameDTO copy(s0 r100, t0 r101) {
        return new PromotionCommentFirstFrameDTO(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionCommentFirstFrameDTO) == false) goto L10;
        PromotionCommentFirstFrameDTO r101 = (PromotionCommentFirstFrameDTO) r100;
        if (Intrinsics.areEqual(this.firstFramePageData, r101.firstFramePageData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.firstFrameListData, r101.firstFrameListData) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        s0 r100 = this.firstFramePageData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t0 r104 = this.firstFrameListData;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionCommentFirstFrameDTO(firstFramePageData=" + this.firstFramePageData + ", firstFrameListData=" + this.firstFrameListData + ")";
    }

    public final t0 getFirstFrameListData() {
        return this.firstFrameListData;
    }

    public final s0 getFirstFramePageData() {
        return this.firstFramePageData;
    }

    public final void setFirstFrameListData(t0 r100) {
        this.firstFrameListData = r100;
    }

    public final void setFirstFramePageData(s0 r100) {
        this.firstFramePageData = r100;
    }

    public PromotionCommentFirstFrameDTO(s0 r100, t0 r101) {
        this.firstFramePageData = r100;
        this.firstFrameListData = r101;
    }

    public /* synthetic */ PromotionCommentFirstFrameDTO(s0 r100, t0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

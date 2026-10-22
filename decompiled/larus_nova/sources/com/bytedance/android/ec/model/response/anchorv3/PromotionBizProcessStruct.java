package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBizProcessStruct;", "Ljava/io/Serializable;", "processNodes", "", "Lcom/bytedance/android/ec/model/response/anchorv3/ProcessNodeStruct;", "title", "", "bizType", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionEntranceStruct;", "(Ljava/util/List;Ljava/lang/String;JLcom/bytedance/android/ec/model/response/anchorv3/PromotionEntranceStruct;)V", "getBizType", "()J", "getEntrance", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionEntranceStruct;", "getProcessNodes", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionBizProcessStruct implements Serializable {

    @SerializedName("biz_type")
    private final long bizType;

    @SerializedName(SoloKtvContext.SOLO_PAGE_ENTRANCE)
    private final PromotionEntranceStruct entrance;

    @SerializedName("process_node")
    private final List<ProcessNodeStruct> processNodes;

    @SerializedName("title")
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionBizProcessStruct copy$default(PromotionBizProcessStruct r100, List r101, String r102, long r103, PromotionEntranceStruct r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.processNodes;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.bizType;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.entrance;
    L14:
        List r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final List<ProcessNodeStruct> component1() {
        return this.processNodes;
    }

    public final String component2() {
        return this.title;
    }

    public final long component3() {
        return this.bizType;
    }

    public final PromotionEntranceStruct component4() {
        return this.entrance;
    }

    public final PromotionBizProcessStruct copy(List<ProcessNodeStruct> r100, String r101, long r110, PromotionEntranceStruct r111) {
        Intrinsics.checkNotNullParameter(r101, "title");
        return new PromotionBizProcessStruct(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionBizProcessStruct) == false) goto L14;
        PromotionBizProcessStruct r101 = (PromotionBizProcessStruct) r100;
        if (Intrinsics.areEqual(this.processNodes, r101.processNodes) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (this.bizType == r101.bizType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entrance, r101.entrance) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<ProcessNodeStruct> r100 = this.processNodes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.bizType;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        PromotionEntranceStruct r109 = this.entrance;
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
        return "PromotionBizProcessStruct(processNodes=" + this.processNodes + ", title=" + this.title + ", bizType=" + this.bizType + ", entrance=" + this.entrance + ")";
    }

    public final long getBizType() {
        return this.bizType;
    }

    public final PromotionEntranceStruct getEntrance() {
        return this.entrance;
    }

    public final List<ProcessNodeStruct> getProcessNodes() {
        return this.processNodes;
    }

    public final String getTitle() {
        return this.title;
    }

    public PromotionBizProcessStruct(List<ProcessNodeStruct> r100, String r101, long r102, PromotionEntranceStruct r103) {
        Intrinsics.checkNotNullParameter(r101, "title");
        this.processNodes = r100;
        this.title = r101;
        this.bizType = r102;
        this.entrance = r103;
    }

    public /* synthetic */ PromotionBizProcessStruct(List r100, String r101, long r110, PromotionEntranceStruct r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        List r102 = null;
    L7:
        if ((r112 & 8) == 0) goto L9;
        PromotionEntranceStruct r103 = null;
    L10:
        this(r102, r101, r110, r103);
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r100;
        goto L7
    }
}

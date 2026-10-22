package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveLifeModel;", "", "liveExplainType", "", "liveExpandType", "needCircleExtendIcon", "", "productId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getLiveExpandType", "()Ljava/lang/String;", "setLiveExpandType", "(Ljava/lang/String;)V", "getLiveExplainType", "setLiveExplainType", "getNeedCircleExtendIcon", "()I", "setNeedCircleExtendIcon", "(I)V", "getProductId", "setProductId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeModel {
    private String liveExpandType;
    private String liveExplainType;
    private int needCircleExtendIcon;
    private String productId;

    public static /* synthetic */ LiveLifeModel copy$default(LiveLifeModel r100, String r101, String r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.liveExplainType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.liveExpandType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.needCircleExtendIcon;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.productId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.liveExplainType;
    }

    public final String component2() {
        return this.liveExpandType;
    }

    public final int component3() {
        return this.needCircleExtendIcon;
    }

    public final String component4() {
        return this.productId;
    }

    public final LiveLifeModel copy(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "productId");
        return new LiveLifeModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveLifeModel) == false) goto L14;
        LiveLifeModel r101 = (LiveLifeModel) r100;
        if (Intrinsics.areEqual(this.liveExplainType, r101.liveExplainType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveExpandType, r101.liveExpandType) == true) goto L10;
        return false;
    L10:
        if (this.needCircleExtendIcon == r101.needCircleExtendIcon) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.liveExplainType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveExpandType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.needCircleExtendIcon) * 31;
        String r107 = this.productId;
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
        return "LiveLifeModel(liveExplainType=" + this.liveExplainType + ", liveExpandType=" + this.liveExpandType + ", needCircleExtendIcon=" + this.needCircleExtendIcon + ", productId=" + this.productId + ")";
    }

    public final String getLiveExpandType() {
        return this.liveExpandType;
    }

    public final String getLiveExplainType() {
        return this.liveExplainType;
    }

    public final int getNeedCircleExtendIcon() {
        return this.needCircleExtendIcon;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setLiveExpandType(String r100) {
        this.liveExpandType = r100;
    }

    public final void setLiveExplainType(String r100) {
        this.liveExplainType = r100;
    }

    public final void setNeedCircleExtendIcon(int r100) {
        this.needCircleExtendIcon = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public LiveLifeModel(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "productId");
        this.liveExplainType = r100;
        this.liveExpandType = r101;
        this.needCircleExtendIcon = r102;
        this.productId = r103;
    }
}

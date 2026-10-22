package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdParams;", "", "entranceInfo", "", "currentEcomSceneId", "type", "Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "addEcomSceneId", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;Ljava/lang/String;)V", "getAddEcomSceneId", "()Ljava/lang/String;", "getCurrentEcomSceneId", "getEntranceInfo", "getType", "()Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomSceneIdParams {
    private final String addEcomSceneId;
    private final String currentEcomSceneId;
    private final String entranceInfo;
    private final EcomSceneIdUrlType type;

    public static /* synthetic */ EcomSceneIdParams copy$default(EcomSceneIdParams r100, String r101, String r102, EcomSceneIdUrlType r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.entranceInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.currentEcomSceneId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.addEcomSceneId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.entranceInfo;
    }

    public final String component2() {
        return this.currentEcomSceneId;
    }

    public final EcomSceneIdUrlType component3() {
        return this.type;
    }

    public final String component4() {
        return this.addEcomSceneId;
    }

    public final EcomSceneIdParams copy(String r100, String r101, EcomSceneIdUrlType r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "type");
        return new EcomSceneIdParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EcomSceneIdParams) == false) goto L14;
        EcomSceneIdParams r101 = (EcomSceneIdParams) r100;
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.currentEcomSceneId, r101.currentEcomSceneId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.addEcomSceneId, r101.addEcomSceneId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.entranceInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.currentEcomSceneId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        EcomSceneIdUrlType r107 = this.type;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.addEcomSceneId;
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
        return "EcomSceneIdParams(entranceInfo=" + this.entranceInfo + ", currentEcomSceneId=" + this.currentEcomSceneId + ", type=" + this.type + ", addEcomSceneId=" + this.addEcomSceneId + ")";
    }

    public final String getAddEcomSceneId() {
        return this.addEcomSceneId;
    }

    public final String getCurrentEcomSceneId() {
        return this.currentEcomSceneId;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final EcomSceneIdUrlType getType() {
        return this.type;
    }

    public EcomSceneIdParams(String r100, String r101, EcomSceneIdUrlType r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "type");
        this.entranceInfo = r100;
        this.currentEcomSceneId = r101;
        this.type = r102;
        this.addEcomSceneId = r103;
    }

    public /* synthetic */ EcomSceneIdParams(String r100, String r101, EcomSceneIdUrlType r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L5;
        r102 = EcomSceneIdUrlType.URL;
    L5:
        this(r100, r101, r102, r103);
    }
}

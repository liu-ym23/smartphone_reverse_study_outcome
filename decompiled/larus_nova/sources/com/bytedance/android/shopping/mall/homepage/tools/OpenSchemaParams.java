package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/OpenSchemaParams;", "", "schema", "", "clickTime", "", "entranceInfo", "currentEcomSceneId", "type", "Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "addEcomSceneId", "addSpecialEcomSceneId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;Ljava/lang/String;Ljava/lang/String;)V", "getAddEcomSceneId", "()Ljava/lang/String;", "getAddSpecialEcomSceneId", "getClickTime", "()J", "getCurrentEcomSceneId", "getEntranceInfo", "getSchema", "getType", "()Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSchemaParams {
    private final String addEcomSceneId;
    private final String addSpecialEcomSceneId;
    private final long clickTime;
    private final String currentEcomSceneId;
    private final String entranceInfo;
    private final String schema;
    private final EcomSceneIdUrlType type;

    public static /* synthetic */ OpenSchemaParams copy$default(OpenSchemaParams r100, String r110, long r111, String r112, String r113, EcomSceneIdUrlType r114, String r115, String r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.schema;
    L7:
        if ((r117 & 2) == 0) goto L9;
        long r102 = r100.clickTime;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.entranceInfo;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.currentEcomSceneId;
    L19:
        if ((r117 & 16) == 0) goto L21;
        EcomSceneIdUrlType r105 = r100.type;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.addEcomSceneId;
    L27:
        if ((r117 & 64) == 0) goto L29;
        String r107 = r100.addSpecialEcomSceneId;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.schema;
    }

    public final long component2() {
        return this.clickTime;
    }

    public final String component3() {
        return this.entranceInfo;
    }

    public final String component4() {
        return this.currentEcomSceneId;
    }

    public final EcomSceneIdUrlType component5() {
        return this.type;
    }

    public final String component6() {
        return this.addEcomSceneId;
    }

    public final String component7() {
        return this.addSpecialEcomSceneId;
    }

    public final OpenSchemaParams copy(String r110, long r111, String r112, String r113, EcomSceneIdUrlType r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r114, "type");
        return new OpenSchemaParams(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OpenSchemaParams) == false) goto L20;
        OpenSchemaParams r101 = (OpenSchemaParams) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (this.clickTime == r101.clickTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentEcomSceneId, r101.currentEcomSceneId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.addEcomSceneId, r101.addEcomSceneId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.addSpecialEcomSceneId, r101.addSpecialEcomSceneId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.clickTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.entranceInfo;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.currentEcomSceneId;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        EcomSceneIdUrlType r111 = this.type;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.addEcomSceneId;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.addSpecialEcomSceneId;
        if (r117 == null) goto L26;
        r101 = r117.hashCode();
    L26:
        return r116 + r101;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "OpenSchemaParams(schema=" + this.schema + ", clickTime=" + this.clickTime + ", entranceInfo=" + this.entranceInfo + ", currentEcomSceneId=" + this.currentEcomSceneId + ", type=" + this.type + ", addEcomSceneId=" + this.addEcomSceneId + ", addSpecialEcomSceneId=" + this.addSpecialEcomSceneId + ")";
    }

    public final String getAddEcomSceneId() {
        return this.addEcomSceneId;
    }

    public final String getAddSpecialEcomSceneId() {
        return this.addSpecialEcomSceneId;
    }

    public final long getClickTime() {
        return this.clickTime;
    }

    public final String getCurrentEcomSceneId() {
        return this.currentEcomSceneId;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final EcomSceneIdUrlType getType() {
        return this.type;
    }

    public OpenSchemaParams(String r100, long r101, String r102, String r103, EcomSceneIdUrlType r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r104, "type");
        this.schema = r100;
        this.clickTime = r101;
        this.entranceInfo = r102;
        this.currentEcomSceneId = r103;
        this.type = r104;
        this.addEcomSceneId = r105;
        this.addSpecialEcomSceneId = r106;
    }

    public /* synthetic */ OpenSchemaParams(String r110, long r111, String r112, String r113, EcomSceneIdUrlType r114, String r115, String r116, int r117, DefaultConstructorMarker r210) {
        if ((r117 & 16) == 0) goto L5;
        EcomSceneIdUrlType r100 = EcomSceneIdUrlType.URL;
    L7:
        if ((r117 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 64) == 0) goto L13;
        String r102 = null;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}

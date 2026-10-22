package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "Ljava/io/Serializable;", "type", "", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "", SocialConstants.PARAM_APP_DESC, "schema", "(ILcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getSchema", "getTitle", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBannerStruct implements Serializable {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final int type;

    public static /* synthetic */ SkuBannerStruct copy$default(SkuBannerStruct r100, int r101, ECUrlModel r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        ECUrlModel r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.title;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.desc;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.schema;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.type;
    }

    public final ECUrlModel component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.schema;
    }

    public final SkuBannerStruct copy(int r100, ECUrlModel r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r112, "schema");
        return new SkuBannerStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuBannerStruct) == false) goto L16;
        SkuBannerStruct r101 = (SkuBannerStruct) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        ECUrlModel r101 = this.icon;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.title;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.desc;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.schema;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "SkuBannerStruct(type=" + this.type + ", icon=" + this.icon + ", title=" + this.title + ", desc=" + this.desc + ", schema=" + this.schema + ")";
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public SkuBannerStruct(int r100, ECUrlModel r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r104, "schema");
        this.type = r100;
        this.icon = r101;
        this.title = r102;
        this.desc = r103;
        this.schema = r104;
    }
}

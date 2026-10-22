package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0011¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfoItem;", "Ljava/io/Serializable;", "id", "", "name", "enabled", "", "selected", "defaultSelect", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "price", "(Ljava/lang/String;Ljava/lang/String;ZZZLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "getDefaultSelect", "()Z", "getEnabled", "setEnabled", "(Z)V", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getPrice", "setPrice", "getSelected", "setSelected", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecInfoItem implements Serializable {

    @SerializedName("default_select")
    private final boolean defaultSelect;
    private boolean enabled;
    private final ECUrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f43094id;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;
    private boolean selected;

    public SpecInfoItem() {
        this(null, null, false, false, false, null, null, 127, null);
    }

    public static /* synthetic */ SpecInfoItem copy$default(SpecInfoItem r100, String r101, String r102, boolean r103, boolean r104, boolean r110, ECUrlModel r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f43094id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.enabled;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.selected;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.defaultSelect;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.icon;
    L20:
        ECUrlModel r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.price;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.f43094id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final boolean component4() {
        return this.selected;
    }

    public final boolean component5() {
        return this.defaultSelect;
    }

    public final ECUrlModel component6() {
        return this.icon;
    }

    public final String component7() {
        return this.price;
    }

    public final SpecInfoItem copy(String r110, String r111, boolean r112, boolean r113, boolean r114, ECUrlModel r115, String r116) {
        return new SpecInfoItem(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SpecInfoItem) == false) goto L20;
        SpecInfoItem r101 = (SpecInfoItem) r100;
        if (Intrinsics.areEqual(this.f43094id, r101.f43094id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (this.selected == r101.selected) goto L14;
        return false;
    L14:
        if (this.defaultSelect == r101.defaultSelect) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.f43094id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.enabled;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.selected;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.defaultSelect;
        if (r114 == true) goto L20;
        r108 = r114;
    L20:
        int r115 = (r113 + r108) * 31;
        ECUrlModel r116 = this.icon;
        if (r116 == null) goto L23;
        int r117 = r116.hashCode();
    L24:
        int r118 = (r115 + r117) * 31;
        String r119 = this.price;
        if (r119 == null) goto L28;
        r101 = r119.hashCode();
    L28:
        return r118 + r101;
    L23:
        r117 = 0;
        goto L24
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SpecInfoItem(id=" + this.f43094id + ", name=" + this.name + ", enabled=" + this.enabled + ", selected=" + this.selected + ", defaultSelect=" + this.defaultSelect + ", icon=" + this.icon + ", price=" + this.price + ")";
    }

    public final boolean getDefaultSelect() {
        return this.defaultSelect;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f43094id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrice() {
        return this.price;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public final void setId(String r100) {
        this.f43094id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPrice(String r100) {
        this.price = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public SpecInfoItem(String r100, String r101, boolean r102, boolean r103, boolean r104, ECUrlModel r105, String r106) {
        this.f43094id = r100;
        this.name = r101;
        this.enabled = r102;
        this.selected = r103;
        this.defaultSelect = r104;
        this.icon = r105;
        this.price = r106;
    }

    public /* synthetic */ SpecInfoItem(String r100, String r101, boolean r102, boolean r110, boolean r111, ECUrlModel r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r104 = true;
    L15:
        if ((r114 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        ECUrlModel r107 = null;
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

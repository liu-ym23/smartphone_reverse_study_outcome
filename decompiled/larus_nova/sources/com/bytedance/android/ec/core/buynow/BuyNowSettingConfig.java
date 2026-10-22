package com.bytedance.android.ec.core.buynow;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/BuyNowSettingConfig;", "Ljava/io/Serializable;", "buynow_yata_check", "", "extendFields", "", "", "(ZLjava/util/List;)V", "getBuynow_yata_check", "()Z", "getExtendFields", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowSettingConfig implements Serializable {

    @SerializedName("buynow_yata_check")
    private final boolean buynow_yata_check;

    @SerializedName("extend_fields")
    private final List<String> extendFields;

    /* JADX WARN: Multi-variable type inference failed */
    public BuyNowSettingConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuyNowSettingConfig copy$default(BuyNowSettingConfig r100, boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.buynow_yata_check;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extendFields;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.buynow_yata_check;
    }

    public final List<String> component2() {
        return this.extendFields;
    }

    public final BuyNowSettingConfig copy(boolean r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "extendFields");
        return new BuyNowSettingConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BuyNowSettingConfig) == false) goto L10;
        BuyNowSettingConfig r101 = (BuyNowSettingConfig) r100;
        if (this.buynow_yata_check == r101.buynow_yata_check) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extendFields, r101.extendFields) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.buynow_yata_check;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.extendFields;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "BuyNowSettingConfig(buynow_yata_check=" + this.buynow_yata_check + ", extendFields=" + this.extendFields + ")";
    }

    public final boolean getBuynow_yata_check() {
        return this.buynow_yata_check;
    }

    public final List<String> getExtendFields() {
        return this.extendFields;
    }

    public BuyNowSettingConfig(boolean r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "extendFields");
        this.buynow_yata_check = r100;
        this.extendFields = r101;
    }

    public /* synthetic */ BuyNowSettingConfig(boolean r100, List r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r110 = CollectionsKt.listOf(new String[]{"all_products", "product_click_index", "product_click_event", "type", "is_scroll", "add_on_desc", "title", "products"});
    L8:
        this(r100, r110);
    }
}

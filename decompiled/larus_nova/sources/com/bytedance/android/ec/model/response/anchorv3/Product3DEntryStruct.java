package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/Product3DEntryStruct;", "Ljava/io/Serializable;", "navLink", "", "text", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getNavLink", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class Product3DEntryStruct implements Serializable {

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("nav_link")
    private final String navLink;

    @SerializedName("text")
    private final String text;

    public Product3DEntryStruct() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Product3DEntryStruct copy$default(Product3DEntryStruct r100, String r101, String r102, ECUrlModel r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.navLink;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.icon;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.navLink;
    }

    public final String component2() {
        return this.text;
    }

    public final ECUrlModel component3() {
        return this.icon;
    }

    public final Product3DEntryStruct copy(String r100, String r101, ECUrlModel r102) {
        return new Product3DEntryStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Product3DEntryStruct) == false) goto L12;
        Product3DEntryStruct r101 = (Product3DEntryStruct) r100;
        if (Intrinsics.areEqual(this.navLink, r101.navLink) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.navLink;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.icon;
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
        return "Product3DEntryStruct(navLink=" + this.navLink + ", text=" + this.text + ", icon=" + this.icon + ")";
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getNavLink() {
        return this.navLink;
    }

    public final String getText() {
        return this.text;
    }

    public Product3DEntryStruct(String r100, String r101, ECUrlModel r102) {
        this.navLink = r100;
        this.text = r101;
        this.icon = r102;
    }

    public /* synthetic */ Product3DEntryStruct(String r100, String r101, ECUrlModel r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

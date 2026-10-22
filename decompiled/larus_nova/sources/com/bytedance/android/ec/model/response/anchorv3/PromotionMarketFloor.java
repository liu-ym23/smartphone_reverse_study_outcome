package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003JQ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006)"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionMarketFloor;", "Ljava/io/Serializable;", "title", "", "name", "url", "tma_url", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getImage", "setImage", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getTitle", com.alipay.sdk.m.x.d.f25925o, "getTma_url", "setTma_url", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionMarketFloor implements Serializable {

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("image")
    private ECUrlModel image;

    @SerializedName("name")
    private String name;

    @SerializedName("title")
    private String title;

    @SerializedName("tma_url")
    private String tma_url;

    @SerializedName("url")
    private String url;

    public PromotionMarketFloor() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PromotionMarketFloor copy$default(PromotionMarketFloor r100, String r101, String r102, String r103, String r104, ECUrlModel r105, ECUrlModel r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.url;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.tma_url;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.icon;
    L17:
        ECUrlModel r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.image;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.tma_url;
    }

    public final ECUrlModel component5() {
        return this.icon;
    }

    public final ECUrlModel component6() {
        return this.image;
    }

    public final PromotionMarketFloor copy(String r100, String r110, String r111, String r112, ECUrlModel r113, ECUrlModel r114) {
        return new PromotionMarketFloor(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionMarketFloor) == false) goto L18;
        PromotionMarketFloor r101 = (PromotionMarketFloor) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tma_url, r101.tma_url) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.title;
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
        String r107 = this.url;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tma_url;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.icon;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.image;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "PromotionMarketFloor(title=" + this.title + ", name=" + this.name + ", url=" + this.url + ", tma_url=" + this.tma_url + ", icon=" + this.icon + ", image=" + this.image + ")";
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTma_url() {
        return this.tma_url;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setIcon(ECUrlModel r100) {
        this.icon = r100;
    }

    public final void setImage(ECUrlModel r100) {
        this.image = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTma_url(String r100) {
        this.tma_url = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public PromotionMarketFloor(String r100, String r101, String r102, String r103, ECUrlModel r104, ECUrlModel r105) {
        this.title = r100;
        this.name = r101;
        this.url = r102;
        this.tma_url = r103;
        this.icon = r104;
        this.image = r105;
    }

    public /* synthetic */ PromotionMarketFloor(String r100, String r101, String r102, String r103, ECUrlModel r104, ECUrlModel r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = "";
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        ECUrlModel r108 = null;
    L23:
        if ((r111 & 32) == 0) goto L25;
        ECUrlModel r114 = null;
    L26:
        this(r113, r106, r107, r105, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}

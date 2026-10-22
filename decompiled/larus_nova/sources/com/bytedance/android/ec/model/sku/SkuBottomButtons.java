package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "Ljava/io/Serializable;", "buttonType", "", "jumpUrl", "", "text", "isGray", "", "displayStatus", "Lcom/bytedance/android/ec/model/sku/ButtonUIParam;", "clickStatus", "hideCountDown", "icon", "Lcom/bytedance/android/ec/model/sku/ImageObject;", "(ILjava/lang/String;Ljava/lang/String;ZLcom/bytedance/android/ec/model/sku/ButtonUIParam;Lcom/bytedance/android/ec/model/sku/ButtonUIParam;ZLcom/bytedance/android/ec/model/sku/ImageObject;)V", "getButtonType", "()I", "getClickStatus", "()Lcom/bytedance/android/ec/model/sku/ButtonUIParam;", "getDisplayStatus", "getHideCountDown", "()Z", "getIcon", "()Lcom/bytedance/android/ec/model/sku/ImageObject;", "getJumpUrl", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuBottomButtons implements Serializable {

    @SerializedName(a.KEY_BUTTON_TYPE)
    private final int buttonType;

    @SerializedName("click_ui_param")
    private final ButtonUIParam clickStatus;

    @SerializedName("display_ui_param")
    private final ButtonUIParam displayStatus;

    @SerializedName("hide_count_down")
    private final boolean hideCountDown;

    @SerializedName("icon")
    private final ImageObject icon;

    @SerializedName("is_gray")
    private final boolean isGray;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("label")
    private final String text;

    public SkuBottomButtons() {
        this(0, null, null, false, null, null, false, null, 255, null);
    }

    public static /* synthetic */ SkuBottomButtons copy$default(SkuBottomButtons r100, int r110, String r111, String r112, boolean r113, ButtonUIParam r114, ButtonUIParam r115, boolean r116, ImageObject r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.buttonType;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.jumpUrl;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.text;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.isGray;
    L19:
        if ((r118 & 16) == 0) goto L21;
        ButtonUIParam r105 = r100.displayStatus;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ButtonUIParam r106 = r100.clickStatus;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.hideCountDown;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ImageObject r108 = r100.icon;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
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

    public final int component1() {
        return this.buttonType;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final String component3() {
        return this.text;
    }

    public final boolean component4() {
        return this.isGray;
    }

    public final ButtonUIParam component5() {
        return this.displayStatus;
    }

    public final ButtonUIParam component6() {
        return this.clickStatus;
    }

    public final boolean component7() {
        return this.hideCountDown;
    }

    public final ImageObject component8() {
        return this.icon;
    }

    public final SkuBottomButtons copy(int r110, String r111, String r112, boolean r113, ButtonUIParam r114, ButtonUIParam r115, boolean r116, ImageObject r117) {
        return new SkuBottomButtons(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuBottomButtons) == false) goto L22;
        SkuBottomButtons r101 = (SkuBottomButtons) r100;
        if (this.buttonType == r101.buttonType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.isGray == r101.isGray) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.displayStatus, r101.displayStatus) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.clickStatus, r101.clickStatus) == true) goto L18;
        return false;
    L18:
        if (this.hideCountDown == r101.hideCountDown) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r100 = this.buttonType * 31;
        String r101 = this.jumpUrl;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.text;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.isGray;
        ?? r109 = 1;
        ?? r110 = r108;
        if (r108 == false) goto L13;
        r110 = 1;
    L13:
        int r111 = (r107 + r110) * 31;
        ButtonUIParam r112 = this.displayStatus;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        ButtonUIParam r115 = this.clickStatus;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        boolean r118 = this.hideCountDown;
        if (r118 == true) goto L25;
        r109 = r118;
    L25:
        int r119 = (r117 + r109) * 31;
        ImageObject r120 = this.icon;
        if (r120 == null) goto L29;
        r102 = r120.hashCode();
    L29:
        return r119 + r102;
    L20:
        r116 = 0;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "SkuBottomButtons(buttonType=" + this.buttonType + ", jumpUrl=" + this.jumpUrl + ", text=" + this.text + ", isGray=" + this.isGray + ", displayStatus=" + this.displayStatus + ", clickStatus=" + this.clickStatus + ", hideCountDown=" + this.hideCountDown + ", icon=" + this.icon + ")";
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    public final ButtonUIParam getClickStatus() {
        return this.clickStatus;
    }

    public final ButtonUIParam getDisplayStatus() {
        return this.displayStatus;
    }

    public final boolean getHideCountDown() {
        return this.hideCountDown;
    }

    public final ImageObject getIcon() {
        return this.icon;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isGray() {
        return this.isGray;
    }

    public SkuBottomButtons(int r100, String r101, String r102, boolean r103, ButtonUIParam r104, ButtonUIParam r105, boolean r106, ImageObject r107) {
        this.buttonType = r100;
        this.jumpUrl = r101;
        this.text = r102;
        this.isGray = r103;
        this.displayStatus = r104;
        this.clickStatus = r105;
        this.hideCountDown = r106;
        this.icon = r107;
    }

    public /* synthetic */ SkuBottomButtons(int r110, String r111, String r112, boolean r113, ButtonUIParam r114, ButtonUIParam r115, boolean r116, ImageObject r117, int r118, DefaultConstructorMarker r210) {
        boolean r100 = false;
        if ((r118 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        ImageObject r102 = null;
        if ((r118 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r118 & 16) == 0) goto L21;
        ButtonUIParam r106 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ButtonUIParam r107 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r101, r103, r104, r105, r106, r107, r100, r102);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}

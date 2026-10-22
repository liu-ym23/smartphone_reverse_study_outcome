package com.bytedance.android.live.base.model;

import android.text.TextUtils;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.PanelWidget")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010,\u001a\u00020\u0004H\u0016J\u0006\u0010-\u001a\u00020*J\b\u0010.\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR \u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR \u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR \u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR \u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/base/model/PanelWidget;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "imageFallbackUrl", "", "getImageFallbackUrl", "()Ljava/lang/String;", "setImageFallbackUrl", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "isGray", "setGray", "name", "getName", "setName", WsConstants.KEY_PAYLOAD, "getPayload", "setPayload", "scheme", "getScheme", "setScheme", "showType", "getShowType", "setShowType", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "toast", "getToast", "setToast", "type", "getType", "setType", "equals", "", "o", "hashCode", "needGray", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelWidget implements vh7.h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected int f58824id;

    @SerializedName("image_fallback_url")
    protected String imageFallbackUrl;

    @SerializedName("image_url")
    protected String imageUrl;

    @SerializedName("is_gray")
    protected int isGray;

    @SerializedName("name")
    protected String name;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    protected String payload;

    @SerializedName("scheme_url")
    protected String scheme;

    @SerializedName("show_type")
    protected int showType;

    @SerializedName("display_text")
    protected String title;

    @SerializedName("toast")
    protected String toast;

    @SerializedName("type")
    protected int type;

    public PanelWidget() {
    }

    public int hashCode() {
        int r100 = this.f58824id * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 == null) goto L6;
        if (r101 == null) goto L6;
        int r103 = r101.hashCode();
    L7:
        int r104 = (r100 + r103) * 31;
        String r105 = this.title;
        if (r105 == null) goto L11;
        if (r105 == null) goto L11;
        int r106 = r105.hashCode();
    L12:
        int r107 = (((r104 + r106) * 31) + this.type) * 31;
        String r108 = this.scheme;
        if (r108 == null) goto L16;
        if (r108 == null) goto L16;
        int r109 = r108.hashCode();
    L17:
        int r110 = (r107 + r109) * 31;
        String r111 = this.imageUrl;
        if (r111 == null) goto L21;
        if (r111 == null) goto L21;
        int r112 = r111.hashCode();
    L22:
        int r113 = (r110 + r112) * 31;
        String r114 = this.imageFallbackUrl;
        if (r114 == null) goto L26;
        if (r114 == null) goto L26;
        int r115 = r114.hashCode();
    L27:
        int r116 = (((r113 + r115) * 31) + this.isGray) * 31;
        String r117 = this.toast;
        if (r117 == null) goto L31;
        if (r117 == null) goto L31;
        int r118 = r117.hashCode();
    L32:
        int r119 = (((r116 + r118) * 31) + this.showType) * 31;
        String r120 = this.payload;
        if (r120 == null) goto L37;
        if (r120 == null) goto L37;
        r102 = r120.hashCode();
    L37:
        return r119 + r102;
    L31:
        r118 = 0;
    L26:
        r115 = 0;
    L21:
        r112 = 0;
    L16:
        r109 = 0;
    L11:
        r106 = 0;
    L6:
        r103 = 0;
        goto L7
    }

    public final boolean needGray() {
        if (this.isGray == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        if (TextUtils.isEmpty(this.title) == false) goto L8;
        String r100 = this.name;
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100;
    L8:
        return this.title;
    }

    public final int getId() {
        return this.f58824id;
    }

    public final String getImageFallbackUrl() {
        return this.imageFallbackUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getShowType() {
        return this.showType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToast() {
        return this.toast;
    }

    public final int getType() {
        return this.type;
    }

    public final int isGray() {
        return this.isGray;
    }

    public PanelWidget(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L28;
        if (r102 != 1) goto L8;
        this.f58824id = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.title = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.type = r100.i();
        goto L3
    L14:
        if (r102 != 100) goto L15;
        this.payload = am3.h.c(r100);
        goto L3
    L15:
        switch(r102) {
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            default: goto L16;
        };
    L17:
        this.scheme = am3.h.c(r100);
        goto L3
    L18:
        this.showType = r100.i();
        goto L3
    L19:
        this.toast = am3.h.c(r100);
        goto L3
    L20:
        this.isGray = r100.i();
        goto L3
    L21:
        this.imageFallbackUrl = am3.h.c(r100);
        goto L3
    L22:
        this.imageUrl = am3.h.c(r100);
        goto L3
    L16:
        am3.h.e(r100);
        goto L3
    L28:
        r100.d(r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L83:
        return false;
    L8:
        if ((!Intrinsics.areEqual(PanelWidget.class, r100.getClass())) == true) goto L83;
        PanelWidget r101 = (PanelWidget) r100;
        if (this.f58824id == r101.f58824id) goto L14;
        return false;
    L14:
        if (this.type == r101.type) goto L17;
        return false;
    L17:
        if (this.isGray == r101.isGray) goto L20;
        return false;
    L20:
        if (this.showType == r101.showType) goto L22;
        return false;
    L22:
        String r102 = this.name;
        if (r102 == null) goto L26;
        boolean r103 = !Intrinsics.areEqual(r102, r101.name);
    L29:
        if (r103 == false) goto L31;
        return false;
    L31:
        String r104 = this.title;
        if (r104 == null) goto L35;
        boolean r105 = !Intrinsics.areEqual(r104, r101.title);
    L38:
        if (r105 == false) goto L40;
        return false;
    L40:
        String r106 = this.scheme;
        if (r106 == null) goto L44;
        boolean r107 = !Intrinsics.areEqual(r106, r101.scheme);
    L47:
        if (r107 == false) goto L49;
        return false;
    L49:
        String r108 = this.imageUrl;
        if (r108 == null) goto L53;
        boolean r109 = !Intrinsics.areEqual(r108, r101.imageUrl);
    L56:
        if (r109 == false) goto L58;
        return false;
    L58:
        String r110 = this.imageFallbackUrl;
        if (r110 == null) goto L62;
        boolean r111 = !Intrinsics.areEqual(r110, r101.imageFallbackUrl);
    L65:
        if (r111 == false) goto L67;
        return false;
    L67:
        String r112 = this.toast;
        if (r112 == null) goto L71;
        boolean r113 = !Intrinsics.areEqual(r112, r101.toast);
    L74:
        if (r113 == false) goto L76;
        return false;
    L76:
        String r114 = this.payload;
        String r115 = r101.payload;
        if (r114 != null) goto L84;
        if (r115 == null) goto L85;
        return false;
    L85:
        return true;
    L84:
        return Intrinsics.areEqual(r114, r115);
    L71:
        if (r101.toast == null) goto L73;
        r113 = true;
        goto L74
    L73:
        r113 = false;
        goto L74
    L62:
        if (r101.imageFallbackUrl == null) goto L64;
        r111 = true;
        goto L65
    L64:
        r111 = false;
        goto L65
    L53:
        if (r101.imageUrl == null) goto L55;
        r109 = true;
        goto L56
    L55:
        r109 = false;
        goto L56
    L44:
        if (r101.scheme == null) goto L46;
        r107 = true;
        goto L47
    L46:
        r107 = false;
        goto L47
    L35:
        if (r101.title == null) goto L37;
        r105 = true;
        goto L38
    L37:
        r105 = false;
        goto L38
    L26:
        if (r101.name == null) goto L28;
        r103 = true;
        goto L29
    L28:
        r103 = false;
        goto L29
    }

    public final void setGray(int r100) {
        this.isGray = r100;
    }

    public final void setId(int r100) {
        this.f58824id = r100;
    }

    public final void setImageFallbackUrl(String r100) {
        this.imageFallbackUrl = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPayload(String r100) {
        this.payload = r100;
    }

    public final void setScheme(String r100) {
        this.scheme = r100;
    }

    public final void setShowType(int r100) {
        this.showType = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setToast(String r100) {
        this.toast = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}

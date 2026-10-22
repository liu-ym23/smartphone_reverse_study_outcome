package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/e0;", "", "Lpy/k;", "background", "Lpy/k;", "getBackground", "()Lpy/k;", "cardCover", "getCardCover", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "buttonImg", "getButtonImg", "buttonText", "getButtonText", "url", "getUrl", "jumpType", "getJumpType", "", "cardType", "I", "getCardType", "()I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("common_background")
    private final py.k background;

    @SerializedName("card_button_icon")
    private final py.k buttonImg;

    @SerializedName("card_button_text")
    private final String buttonText;

    @SerializedName("card_cover")
    private final py.k cardCover;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName("jump_type")
    private final String jumpType;

    @SerializedName("card_title")
    private final String title;

    @SerializedName("card_url")
    private final String url;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L22;
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cardCover, r101.cardCover) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonImg, r101.buttonImg) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jumpType, r101.jumpType) == true) goto L20;
        return false;
    L20:
        if (this.cardType == r101.cardType) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        py.k r100 = this.background;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        py.k r104 = this.cardCover;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        py.k r110 = this.buttonImg;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.buttonText;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.url;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.jumpType;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return ((r118 + r101) * 31) + this.cardType;
    L25:
        r117 = 0;
        goto L26
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

    public final String toString() {
        return "EndingPageCardInfo(background=" + this.background + ", cardCover=" + this.cardCover + ", title=" + this.title + ", buttonImg=" + this.buttonImg + ", buttonText=" + this.buttonText + ", url=" + this.url + ", jumpType=" + this.jumpType + ", cardType=" + this.cardType + ")";
    }

    public e0() {
        this.background = null;
        this.cardCover = null;
        this.title = "";
        this.buttonImg = null;
        this.buttonText = "";
        this.url = null;
        this.jumpType = null;
        this.cardType = 0;
    }
}

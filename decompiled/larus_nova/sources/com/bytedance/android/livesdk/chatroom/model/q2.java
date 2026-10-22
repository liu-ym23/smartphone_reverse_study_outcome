package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/q2;", "", "", "giftIdListStr", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "h", "(Ljava/lang/String;)V", "", "orderSingAutoEnlarge", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/Boolean;)V", "autoPlayMv", "b", ce.f26391f, "auditionGiftIdListStr", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "f", "showGiftInfo", "e", ce.f26395j, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q2 {

    @SerializedName("audition_gift_id_list_str")
    private String auditionGiftIdListStr;

    @SerializedName("auto_play_mv")
    private Boolean autoPlayMv;

    @SerializedName("gift_id_list_str")
    private String giftIdListStr;

    @SerializedName("order_sing_auto_enlarge")
    private Boolean orderSingAutoEnlarge;

    @SerializedName("show_gift_info")
    private Boolean showGiftInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q2) == false) goto L16;
        q2 r101 = (q2) r100;
        if (Intrinsics.areEqual(this.giftIdListStr, r101.giftIdListStr) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderSingAutoEnlarge, r101.orderSingAutoEnlarge) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.autoPlayMv, r101.autoPlayMv) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.auditionGiftIdListStr, r101.auditionGiftIdListStr) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showGiftInfo, r101.showGiftInfo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.giftIdListStr;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.orderSingAutoEnlarge;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.autoPlayMv;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.auditionGiftIdListStr;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.showGiftInfo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "OrderSongTurnOnConfig(giftIdListStr=" + this.giftIdListStr + ", orderSingAutoEnlarge=" + this.orderSingAutoEnlarge + ", autoPlayMv=" + this.autoPlayMv + ", auditionGiftIdListStr=" + this.auditionGiftIdListStr + ", showGiftInfo=" + this.showGiftInfo + ")";
    }

    public q2() {
        Boolean r100 = Boolean.FALSE;
        this.giftIdListStr = "";
        this.orderSingAutoEnlarge = r100;
        this.autoPlayMv = r100;
        this.auditionGiftIdListStr = "";
        this.showGiftInfo = r100;
    }

    public final String a() {
        return this.auditionGiftIdListStr;
    }

    public final Boolean b() {
        return this.autoPlayMv;
    }

    public final String c() {
        return this.giftIdListStr;
    }

    public final Boolean d() {
        return this.orderSingAutoEnlarge;
    }

    public final Boolean e() {
        return this.showGiftInfo;
    }

    public final void f(String r100) {
        this.auditionGiftIdListStr = r100;
    }

    public final void g(Boolean r100) {
        this.autoPlayMv = r100;
    }

    public final void h(String r100) {
        this.giftIdListStr = r100;
    }

    public final void i(Boolean r100) {
        this.orderSingAutoEnlarge = r100;
    }

    public final void j(Boolean r100) {
        this.showGiftInfo = r100;
    }
}

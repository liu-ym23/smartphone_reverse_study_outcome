package com.bytedance.android.ec.core.vmsdk;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/c;", "", "", "ecomVmsdkVerifyBase", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ecomVmsdkVerifyLiveCheck", ce.f26391f, "ecomVmsdkVerifyECRoomEnterCheck", "d", "ecomVmsdkVerifyGoodsDetailCheck", "e", "ecomVmsdkVerifyVideo", RXScreenCaptureService.KEY_INDEX, "ecomEnterMall", "getEcomEnterMall", "ecomShopPage", "getEcomShopPage", "ecomWindowPage", ce.f26395j, "ecomVmsdkVerifyLiveApiRequestCheck", "getEcomVmsdkVerifyLiveApiRequestCheck", "ecomVmsdkVerifyLiveRoomController", "h", "comVmsdkLiveSplicingParams", "getComVmsdkLiveSplicingParams", "ecomVmsdkBuyNowCheck", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ecomVmsdkNativeMallVideo", "getEcomVmsdkNativeMallVideo", "ecomVmsdkNativeCartPage", "b", "ecomVmsdkNativeMallLive", "getEcomVmsdkNativeMallLive", "ecomVmsdkNativeMallChannel", "getEcomVmsdkNativeMallChannel", "ecomVmsdkNativeMallOneoff", "getEcomVmsdkNativeMallOneoff", "ecomVmsdkNativeMallProduct", "getEcomVmsdkNativeMallProduct", "ecomVmsdknativeMallSearch", "getEcomVmsdknativeMallSearch", "ecomVmsdkNativeMallTool", "getEcomVmsdkNativeMallTool", "ecomVmsdkVerifyLiveApiMonitorCheck", "f", "ecom_immersive_goods_feed", ce.f26396k, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("ecom_vmsdk_live_splicing_params")
    private final String comVmsdkLiveSplicingParams;

    @SerializedName("ecom_enter_mall")
    private final String ecomEnterMall;

    @SerializedName("ecom_shop_page")
    private final String ecomShopPage;

    @SerializedName("ecom_vmsdk_verify_buynow_check")
    private final String ecomVmsdkBuyNowCheck;

    @SerializedName("ecom_native_cart_page")
    private final String ecomVmsdkNativeCartPage;

    @SerializedName("ecom_native_mall_channel")
    private final String ecomVmsdkNativeMallChannel;

    @SerializedName("ecom_native_mall_live")
    private final String ecomVmsdkNativeMallLive;

    @SerializedName("ecom_native_mall_oneoff")
    private final String ecomVmsdkNativeMallOneoff;

    @SerializedName("ecom_native_mall_product")
    private final String ecomVmsdkNativeMallProduct;

    @SerializedName("ecom_native_mall_tool")
    private final String ecomVmsdkNativeMallTool;

    @SerializedName("ecom_native_mall_video")
    private final String ecomVmsdkNativeMallVideo;

    @SerializedName("ecom_vmsdk_verify_base")
    private final String ecomVmsdkVerifyBase;

    @SerializedName("ecom_vmsdk_verify_ec_room_enter_check")
    private final String ecomVmsdkVerifyECRoomEnterCheck;

    @SerializedName("ecom_vmsdk_verify_goods_detail_check")
    private final String ecomVmsdkVerifyGoodsDetailCheck;

    @SerializedName("ecom_vmsdk_verify_live_api_monitor_check")
    private final String ecomVmsdkVerifyLiveApiMonitorCheck;

    @SerializedName("ecom_vmsdk_verify_live_api_request_check")
    private final String ecomVmsdkVerifyLiveApiRequestCheck;

    @SerializedName("ecom_vmsdk_verify_live_check")
    private final String ecomVmsdkVerifyLiveCheck;

    @SerializedName("ecom_vmsdk_verify_live_room_controller")
    private final String ecomVmsdkVerifyLiveRoomController;

    @SerializedName("ecom_short_video")
    private final String ecomVmsdkVerifyVideo;

    @SerializedName("ecom_native_mall_search")
    private final String ecomVmsdknativeMallSearch;

    @SerializedName("ecom_window_page")
    private final String ecomWindowPage;

    @SerializedName("ecom_immersive_goods_feed")
    private final String ecom_immersive_goods_feed;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L50;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyBase, r101.ecomVmsdkVerifyBase) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveCheck, r101.ecomVmsdkVerifyLiveCheck) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyECRoomEnterCheck, r101.ecomVmsdkVerifyECRoomEnterCheck) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyGoodsDetailCheck, r101.ecomVmsdkVerifyGoodsDetailCheck) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyVideo, r101.ecomVmsdkVerifyVideo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ecomEnterMall, r101.ecomEnterMall) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ecomShopPage, r101.ecomShopPage) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ecomWindowPage, r101.ecomWindowPage) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveApiRequestCheck, r101.ecomVmsdkVerifyLiveApiRequestCheck) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveRoomController, r101.ecomVmsdkVerifyLiveRoomController) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.comVmsdkLiveSplicingParams, r101.comVmsdkLiveSplicingParams) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.ecomVmsdkBuyNowCheck, r101.ecomVmsdkBuyNowCheck) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallVideo, r101.ecomVmsdkNativeMallVideo) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeCartPage, r101.ecomVmsdkNativeCartPage) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallLive, r101.ecomVmsdkNativeMallLive) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallChannel, r101.ecomVmsdkNativeMallChannel) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallOneoff, r101.ecomVmsdkNativeMallOneoff) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallProduct, r101.ecomVmsdkNativeMallProduct) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ecomVmsdknativeMallSearch, r101.ecomVmsdknativeMallSearch) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallTool, r101.ecomVmsdkNativeMallTool) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveApiMonitorCheck, r101.ecomVmsdkVerifyLiveApiMonitorCheck) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ecom_immersive_goods_feed, r101.ecom_immersive_goods_feed) == true) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        String r100 = this.ecomVmsdkVerifyBase;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.ecomVmsdkVerifyLiveCheck;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ecomVmsdkVerifyECRoomEnterCheck;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.ecomVmsdkVerifyGoodsDetailCheck;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.ecomVmsdkVerifyVideo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ecomEnterMall;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.ecomShopPage;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.ecomWindowPage;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.ecomVmsdkVerifyLiveApiRequestCheck;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.ecomVmsdkVerifyLiveRoomController;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.comVmsdkLiveSplicingParams;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.ecomVmsdkBuyNowCheck;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.ecomVmsdkNativeMallVideo;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.ecomVmsdkNativeCartPage;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.ecomVmsdkNativeMallLive;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.ecomVmsdkNativeMallChannel;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.ecomVmsdkNativeMallOneoff;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.ecomVmsdkNativeMallProduct;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.ecomVmsdknativeMallSearch;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.ecomVmsdkNativeMallTool;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.ecomVmsdkVerifyLiveApiMonitorCheck;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.ecom_immersive_goods_feed;
        if (r164 == null) goto L90;
        r101 = r164.hashCode();
    L90:
        return r163 + r101;
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "VmSdkResourceConfig(ecomVmsdkVerifyBase=" + this.ecomVmsdkVerifyBase + ", ecomVmsdkVerifyLiveCheck=" + this.ecomVmsdkVerifyLiveCheck + ", ecomVmsdkVerifyECRoomEnterCheck=" + this.ecomVmsdkVerifyECRoomEnterCheck + ", ecomVmsdkVerifyGoodsDetailCheck=" + this.ecomVmsdkVerifyGoodsDetailCheck + ", ecomVmsdkVerifyVideo=" + this.ecomVmsdkVerifyVideo + ", ecomEnterMall=" + this.ecomEnterMall + ", ecomShopPage=" + this.ecomShopPage + ", ecomWindowPage=" + this.ecomWindowPage + ", ecomVmsdkVerifyLiveApiRequestCheck=" + this.ecomVmsdkVerifyLiveApiRequestCheck + ", ecomVmsdkVerifyLiveRoomController=" + this.ecomVmsdkVerifyLiveRoomController + ", comVmsdkLiveSplicingParams=" + this.comVmsdkLiveSplicingParams + ", ecomVmsdkBuyNowCheck=" + this.ecomVmsdkBuyNowCheck + ", ecomVmsdkNativeMallVideo=" + this.ecomVmsdkNativeMallVideo + ", ecomVmsdkNativeCartPage=" + this.ecomVmsdkNativeCartPage + ", ecomVmsdkNativeMallLive=" + this.ecomVmsdkNativeMallLive + ", ecomVmsdkNativeMallChannel=" + this.ecomVmsdkNativeMallChannel + ", ecomVmsdkNativeMallOneoff=" + this.ecomVmsdkNativeMallOneoff + ", ecomVmsdkNativeMallProduct=" + this.ecomVmsdkNativeMallProduct + ", ecomVmsdknativeMallSearch=" + this.ecomVmsdknativeMallSearch + ", ecomVmsdkNativeMallTool=" + this.ecomVmsdkNativeMallTool + ", ecomVmsdkVerifyLiveApiMonitorCheck=" + this.ecomVmsdkVerifyLiveApiMonitorCheck + ", ecom_immersive_goods_feed=" + this.ecom_immersive_goods_feed + ")";
    }

    public final String a() {
        return this.ecomVmsdkBuyNowCheck;
    }

    public final String b() {
        return this.ecomVmsdkNativeCartPage;
    }

    public final String c() {
        return this.ecomVmsdkVerifyBase;
    }

    public final String d() {
        return this.ecomVmsdkVerifyECRoomEnterCheck;
    }

    public final String e() {
        return this.ecomVmsdkVerifyGoodsDetailCheck;
    }

    public final String f() {
        return this.ecomVmsdkVerifyLiveApiMonitorCheck;
    }

    public final String g() {
        return this.ecomVmsdkVerifyLiveCheck;
    }

    public final String h() {
        return this.ecomVmsdkVerifyLiveRoomController;
    }

    public final String i() {
        return this.ecomVmsdkVerifyVideo;
    }

    public final String j() {
        return this.ecomWindowPage;
    }

    public final String k() {
        return this.ecom_immersive_goods_feed;
    }

    public c(int r100) {
        this.ecomVmsdkVerifyBase = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/init.js";
        this.ecomVmsdkVerifyLiveCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/live_check.js";
        this.ecomVmsdkVerifyECRoomEnterCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk_live_enter_check/index.js";
        this.ecomVmsdkVerifyGoodsDetailCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/goods_detail_page_check.js";
        this.ecomVmsdkVerifyVideo = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/video_check.js";
        this.ecomEnterMall = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_enter_mall/index.js";
        this.ecomShopPage = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/shop_check.js";
        this.ecomWindowPage = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/window_check.js";
        this.ecomVmsdkVerifyLiveApiRequestCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/ecom_vmsdk_verify_live_api_request_check.js";
        this.ecomVmsdkVerifyLiveRoomController = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/ecom_vmsdk_verify_live_room_controller.js";
        this.comVmsdkLiveSplicingParams = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_live_splicing_params/index.js";
        this.ecomVmsdkBuyNowCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/buynow_yata_check.js";
        this.ecomVmsdkNativeMallVideo = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_video.js";
        this.ecomVmsdkNativeCartPage = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/cart_check.js";
        this.ecomVmsdkNativeMallLive = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_live.js";
        this.ecomVmsdkNativeMallChannel = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_channel.js";
        this.ecomVmsdkNativeMallOneoff = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_oneoff.js";
        this.ecomVmsdkNativeMallProduct = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_product.js";
        this.ecomVmsdknativeMallSearch = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_search.js";
        this.ecomVmsdkNativeMallTool = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_tool.js";
        this.ecomVmsdkVerifyLiveApiMonitorCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/ecom_live_api_monitor.js";
        this.ecom_immersive_goods_feed = "https://tosv.byted.org/obj/gecko-internal/10997/gecko/resource/ecom_short_video_track_event/ecom_immersive_goods_feed.js";
    }
}

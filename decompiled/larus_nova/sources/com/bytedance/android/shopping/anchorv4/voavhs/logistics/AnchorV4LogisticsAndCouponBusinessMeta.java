package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÞ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00122\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\b\u0010D\u001a\u0004\u0018\u00010\u0003J\b\u0010E\u001a\u0004\u0018\u00010\u0003J\b\u0010F\u001a\u0004\u0018\u00010\u0003J\t\u0010G\u001a\u00020\u000bHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006I"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponBusinessMeta;", "Ljava/io/Serializable;", PromotionProductPrivilegesStruct.SERVICES, "", "specialService", "couponMeta", "openInfoMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;", "logisticsJumpUrls", "", "logisticsTextType", "", "logisticsType", "deliveryStatus", "", "rawData", "logData", "hasLogistics", "", "newbieServiceUrl", "carModelLink", "hasAddCar", "guaranteeHeaderUrl", "servicePanelUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCarModelLink", "()Ljava/lang/String;", "getCouponMeta", "getDeliveryStatus", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGuaranteeHeaderUrl", "getHasAddCar", "getHasLogistics", "()Z", "getLogData", "getLogisticsJumpUrls", "()Ljava/util/List;", "getLogisticsTextType", "getLogisticsType", "getNewbieServiceUrl", "getOpenInfoMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;", "getRawData", "getServicePanelUrl", "getServices", "getSpecialService", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/OpenInfoMeta;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponBusinessMeta;", "equals", "other", "", "getServiceTypes", "getTextTypes", "getTypes", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsAndCouponBusinessMeta implements Serializable {

    @SerializedName("car_model_link")
    private final String carModelLink;

    @SerializedName("coupon_meta")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String couponMeta;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_DELIVERY_STATUS)
    private final Long deliveryStatus;

    @SerializedName("guarantee_header_url")
    private final String guaranteeHeaderUrl;

    @SerializedName("has_add_car")
    private final String hasAddCar;

    @SerializedName("has_logistics")
    private final boolean hasLogistics;

    @SerializedName("log_data")
    private final String logData;

    @SerializedName("logistics_jump_urls")
    private final List<String> logisticsJumpUrls;

    @SerializedName("logistics_text_types")
    private final List<Integer> logisticsTextType;

    @SerializedName("logistics_types")
    private final List<Integer> logisticsType;

    @SerializedName("newbie_service_url")
    private final String newbieServiceUrl;

    @SerializedName("open_info")
    private final OpenInfoMeta openInfoMeta;

    @SerializedName(EventConstant.Key.RAW_DATA)
    @JsonAdapter(JsonToStringAdapter.class)
    private final String rawData;

    @SerializedName("new_services_panel_url")
    private final String servicePanelUrl;

    @SerializedName(PromotionProductPrivilegesStruct.SERVICES)
    @JsonAdapter(JsonToStringAdapter.class)
    private final String services;

    @SerializedName("special_services")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String specialService;

    public AnchorV4LogisticsAndCouponBusinessMeta() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4LogisticsAndCouponBusinessMeta copy$default(AnchorV4LogisticsAndCouponBusinessMeta r110, String r111, String r112, String r210, OpenInfoMeta r211, List r212, List r213, List r214, Long r215, String r216, String r217, boolean r218, String r219, String r310, String r311, String r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.services;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.specialService;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.couponMeta;
    L15:
        if ((r314 & 8) == 0) goto L17;
        OpenInfoMeta r103 = r110.openInfoMeta;
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r104 = r110.logisticsJumpUrls;
    L23:
        if ((r314 & 32) == 0) goto L25;
        List r105 = r110.logisticsTextType;
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r106 = r110.logisticsType;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Long r107 = r110.deliveryStatus;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r113 = r110.rawData;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = r110.logData;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        boolean r115 = r110.hasLogistics;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r116 = r110.newbieServiceUrl;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.carModelLink;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r118 = r110.hasAddCar;
    L58:
        String r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        String r119 = r110.guaranteeHeaderUrl;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.servicePanelUrl;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.services;
    }

    public final String component10() {
        return this.logData;
    }

    public final boolean component11() {
        return this.hasLogistics;
    }

    public final String component12() {
        return this.newbieServiceUrl;
    }

    public final String component13() {
        return this.carModelLink;
    }

    public final String component14() {
        return this.hasAddCar;
    }

    public final String component15() {
        return this.guaranteeHeaderUrl;
    }

    public final String component16() {
        return this.servicePanelUrl;
    }

    public final String component2() {
        return this.specialService;
    }

    public final String component3() {
        return this.couponMeta;
    }

    public final OpenInfoMeta component4() {
        return this.openInfoMeta;
    }

    public final List<String> component5() {
        return this.logisticsJumpUrls;
    }

    public final List<Integer> component6() {
        return this.logisticsTextType;
    }

    public final List<Integer> component7() {
        return this.logisticsType;
    }

    public final Long component8() {
        return this.deliveryStatus;
    }

    public final String component9() {
        return this.rawData;
    }

    public final AnchorV4LogisticsAndCouponBusinessMeta copy(String r110, String r210, String r211, OpenInfoMeta r212, List<String> r213, List<Integer> r214, List<Integer> r215, Long r216, String r217, String r218, boolean r219, String r310, String r311, String r312, String r313, String r314) {
        return new AnchorV4LogisticsAndCouponBusinessMeta(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4LogisticsAndCouponBusinessMeta) == false) goto L38;
        AnchorV4LogisticsAndCouponBusinessMeta r101 = (AnchorV4LogisticsAndCouponBusinessMeta) r100;
        if (Intrinsics.areEqual(this.services, r101.services) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.specialService, r101.specialService) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponMeta, r101.couponMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openInfoMeta, r101.openInfoMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.logisticsJumpUrls, r101.logisticsJumpUrls) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.logisticsTextType, r101.logisticsTextType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logisticsType, r101.logisticsType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.deliveryStatus, r101.deliveryStatus) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logData, r101.logData) == true) goto L26;
        return false;
    L26:
        if (this.hasLogistics == r101.hasLogistics) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.newbieServiceUrl, r101.newbieServiceUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.carModelLink, r101.carModelLink) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.hasAddCar, r101.hasAddCar) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.guaranteeHeaderUrl, r101.guaranteeHeaderUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.servicePanelUrl, r101.servicePanelUrl) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v56 */
    public int hashCode() {
        String r100 = this.services;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.specialService;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.couponMeta;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        OpenInfoMeta r110 = this.openInfoMeta;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.logisticsJumpUrls;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<Integer> r116 = this.logisticsTextType;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<Integer> r119 = this.logisticsType;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.deliveryStatus;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.rawData;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.logData;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        boolean r131 = this.hasLogistics;
        ?? r132 = r131;
        if (r131 == false) goto L45;
        r132 = 1;
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.newbieServiceUrl;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.carModelLink;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        String r140 = this.hasAddCar;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        String r143 = this.guaranteeHeaderUrl;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        String r146 = this.servicePanelUrl;
        if (r146 == null) goto L65;
        r101 = r146.hashCode();
    L65:
        return r145 + r101;
    L60:
        r144 = 0;
        goto L61
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
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

    public String toString() {
        return "AnchorV4LogisticsAndCouponBusinessMeta(services=" + this.services + ", specialService=" + this.specialService + ", couponMeta=" + this.couponMeta + ", openInfoMeta=" + this.openInfoMeta + ", logisticsJumpUrls=" + this.logisticsJumpUrls + ", logisticsTextType=" + this.logisticsTextType + ", logisticsType=" + this.logisticsType + ", deliveryStatus=" + this.deliveryStatus + ", rawData=" + this.rawData + ", logData=" + this.logData + ", hasLogistics=" + this.hasLogistics + ", newbieServiceUrl=" + this.newbieServiceUrl + ", carModelLink=" + this.carModelLink + ", hasAddCar=" + this.hasAddCar + ", guaranteeHeaderUrl=" + this.guaranteeHeaderUrl + ", servicePanelUrl=" + this.servicePanelUrl + ")";
    }

    public final String getServiceTypes() {
        String r100 = this.services;
        if (r100 == null) goto L5;
        JSONArray r101 = k.t(r100);
    L6:
        int r102 = 0;
        if (r101 == null) goto L9;
        int r103 = r101.length();
    L10:
        if (r103 <= 0) goto L28;
        ArrayList r104 = new ArrayList();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L24
        if (r101 == null) goto L15;
        int r106 = r101.length();     // Catch: Throwable -> L24
    L16:
        if (r102 >= r106) goto L22;
        if (r101 == null) goto L21;
        JSONObject r107 = r101.optJSONObject(r102);     // Catch: Throwable -> L24
        if (r107 == null) goto L21;
        r104.add(Integer.valueOf(r107.optInt("service_type")));     // Catch: Throwable -> L24
    L21:
        r102 = r102 + 1;     // Catch: Throwable -> L24
        goto L16
    L22:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L27:
        return CollectionsKt.joinToString$default(r104, ",", "[", "]", 0, null, null, 56, null);
    L15:
        r106 = 0;
    L24:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L28:
        return null;
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final String getTextTypes() {
        List<Integer> r100 = this.logisticsTextType;
        if (r100 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null);
    }

    public final String getTypes() {
        List<Integer> r100 = this.logisticsType;
        if (r100 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null);
    }

    public final String getCarModelLink() {
        return this.carModelLink;
    }

    public final String getCouponMeta() {
        return this.couponMeta;
    }

    public final Long getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public final String getGuaranteeHeaderUrl() {
        return this.guaranteeHeaderUrl;
    }

    public final String getHasAddCar() {
        return this.hasAddCar;
    }

    public final boolean getHasLogistics() {
        return this.hasLogistics;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final List<String> getLogisticsJumpUrls() {
        return this.logisticsJumpUrls;
    }

    public final List<Integer> getLogisticsTextType() {
        return this.logisticsTextType;
    }

    public final List<Integer> getLogisticsType() {
        return this.logisticsType;
    }

    public final String getNewbieServiceUrl() {
        return this.newbieServiceUrl;
    }

    public final OpenInfoMeta getOpenInfoMeta() {
        return this.openInfoMeta;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getServicePanelUrl() {
        return this.servicePanelUrl;
    }

    public final String getServices() {
        return this.services;
    }

    public final String getSpecialService() {
        return this.specialService;
    }

    public AnchorV4LogisticsAndCouponBusinessMeta(String r100, String r101, String r102, OpenInfoMeta r103, List<String> r104, List<Integer> r105, List<Integer> r106, Long r110, String r111, String r112, boolean r113, String r114, String r115, String r116, String r117, String r118) {
        this.services = r100;
        this.specialService = r101;
        this.couponMeta = r102;
        this.openInfoMeta = r103;
        this.logisticsJumpUrls = r104;
        this.logisticsTextType = r105;
        this.logisticsType = r106;
        this.deliveryStatus = r110;
        this.rawData = r111;
        this.logData = r112;
        this.hasLogistics = r113;
        this.newbieServiceUrl = r114;
        this.carModelLink = r115;
        this.hasAddCar = r116;
        this.guaranteeHeaderUrl = r117;
        this.servicePanelUrl = r118;
    }

    public /* synthetic */ AnchorV4LogisticsAndCouponBusinessMeta(String r110, String r111, String r210, OpenInfoMeta r211, List r212, List r213, List r214, Long r215, String r216, String r217, boolean r218, String r219, String r310, String r311, String r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        OpenInfoMeta r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Long r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}

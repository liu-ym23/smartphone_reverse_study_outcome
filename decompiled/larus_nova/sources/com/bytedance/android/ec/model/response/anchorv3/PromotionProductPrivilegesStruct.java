package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 Z2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\bX\u0010YJ\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u00100R*\u00101\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b2\u0010\u000f\"\u0004\b3\u00100R*\u00104\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u00100R\u001c\u00108\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010B\u001a\u0004\u0018\u00010A8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010G\u001a\u0004\u0018\u00010F8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010P\u001a\u0004\u0018\u00010O8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR4\u0010W\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058F@BX\u0086\u000e¢\u0006\f\n\u0004\bU\u0010\r\u001a\u0004\bV\u0010\u000f¨\u0006["}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesStruct;", "Ljava/io/Serializable;", "", "", "getExtraInfoMap", "", "getTagCodeList", "key", "Lorg/json/JSONObject;", "getTagsInfo", "getAllTagsInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductServiceStruct;", PromotionProductPrivilegesStruct.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLogisticsStruct;", PromotionProductPrivilegesStruct.LOGISTICS, "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLogisticsStruct;", "getLogistics", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLogisticsStruct;", "setLogistics", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLogisticsStruct;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCouponsStruct;", "coupons", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCouponsStruct;", "getCoupons", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCouponsStruct;", "setCoupons", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCouponsStruct;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductActivitiesStruct;", "activities", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductActivitiesStruct;", "getActivities", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductActivitiesStruct;", "setActivities", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductActivitiesStruct;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductInstallmentStruct;", com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductInstallmentStruct;", "getInstallment", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductInstallmentStruct;", "setInstallment", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductInstallmentStruct;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBannerStruct;", PromotionProductPrivilegesStruct.BANNERS, "getBanners", "setBanners", "(Ljava/util/List;)V", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "labels", "getLabels", "setLabels", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductChoosePanel;", "choosePanel", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductChoosePanel;", "getChoosePanel", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductChoosePanel;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeServiceStruct;", "newbeeService", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeServiceStruct;", "getNewbeeService", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeServiceStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBrandPromiseStruct;", "brandPromise", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBrandPromiseStruct;", "getBrandPromise", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBrandPromiseStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionExclusiveStruct;", "exclusive", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionExclusiveStruct;", "getExclusive", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionExclusiveStruct;", "extraInfo", "Ljava/lang/String;", "getExtraInfo", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesFirstAreaStruct;", "privilegeFirstAreaInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesFirstAreaStruct;", "getPrivilegeFirstAreaInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesFirstAreaStruct;", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getTagInfoShowList", "tagInfoShowList", "<init>", "()V", "Companion", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductPrivilegesStruct implements Serializable {
    public static final String ATMOSPHERE_TAGS = "atmosphere_tags";
    public static final String BANNERS = "banners";
    public static final a Companion = null;
    public static final String LOGISTICS = "logistics";
    public static final String MARKET = "market";
    public static final String SERVICES = "services";
    public static final String TAGS = "tags";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<? extends JSONObject> f47941a;

    @SerializedName("activities")
    private PromotionProductActivitiesStruct activities;

    @SerializedName(BANNERS)
    private List<PromotionProductBannerStruct> banners;

    @SerializedName("brand_promise")
    private final PromotionBrandPromiseStruct brandPromise;

    @SerializedName("choose_panel")
    private final PromotionProductChoosePanel choosePanel;

    @SerializedName("coupons")
    private PromotionProductCouponsStruct coupons;

    @SerializedName("exclusive")
    private final PromotionExclusiveStruct exclusive;

    @SerializedName("extra_log")
    private final String extraInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO)
    private PromotionProductInstallmentStruct installment;

    @SerializedName("labels")
    private List<PromotionProductBannerStruct> labels;

    @SerializedName(LOGISTICS)
    private PromotionProductLogisticsStruct logistics;

    @SerializedName("newbee_service")
    private final PromotionNewbeeServiceStruct newbeeService;

    @SerializedName("privilege_first_area_info")
    private final PromotionProductPrivilegesFirstAreaStruct privilegeFirstAreaInfo;

    @SerializedName(SERVICES)
    private final List<PromotionProductServiceStruct> services;

    @SerializedName(TAGS)
    private List<PromotionProductBannerStruct> tags;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesStruct$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesStruct$c", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/ec/model/response/anchorv3/e;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class c extends TypeToken<List<? extends e>> {
        public c() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductPrivilegesStruct() {
    }

    public final List<JSONObject> getAllTagsInfo() {
        ArrayList r100 = new ArrayList();
        Map<String, String> r101 = getExtraInfoMap();
        if (r101 == null) goto L12;
        Set<String> r102 = r101.keySet();
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        List<JSONObject> r104 = getTagsInfo((String) r103.next());
        if (r104 == null) goto L8;
        r100.addAll(r104);
    L12:
        return r100;
    }

    public final Map<String, String> getExtraInfoMap() {
        String r100 = this.extraInfo;
        if (r100 == null) goto L10;
        return (Map) GsonProtectorUtils.fromJson(new Gson(), r100, new b().getType());
    L11:
        return null;
    L10:
        return null;
    }

    public final List<String> getTagCodeList() {
        ArrayList r100 = new ArrayList();
        List<JSONObject> r101 = getTagInfoShowList();
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.add(((JSONObject) r102.next()).optString("tag_code"));
    L8:
        return r100;
    }

    public final List<JSONObject> getTagInfoShowList() {
        if (this.f47941a != null) goto L6;
        this.f47941a = getAllTagsInfo();
    L6:
        return this.f47941a;
    }

    public final PromotionProductActivitiesStruct getActivities() {
        return this.activities;
    }

    public final List<PromotionProductBannerStruct> getBanners() {
        return this.banners;
    }

    public final PromotionBrandPromiseStruct getBrandPromise() {
        return this.brandPromise;
    }

    public final PromotionProductChoosePanel getChoosePanel() {
        return this.choosePanel;
    }

    public final PromotionProductCouponsStruct getCoupons() {
        return this.coupons;
    }

    public final PromotionExclusiveStruct getExclusive() {
        return this.exclusive;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final PromotionProductInstallmentStruct getInstallment() {
        return this.installment;
    }

    public final List<PromotionProductBannerStruct> getLabels() {
        return this.labels;
    }

    public final PromotionProductLogisticsStruct getLogistics() {
        return this.logistics;
    }

    public final PromotionNewbeeServiceStruct getNewbeeService() {
        return this.newbeeService;
    }

    public final PromotionProductPrivilegesFirstAreaStruct getPrivilegeFirstAreaInfo() {
        return this.privilegeFirstAreaInfo;
    }

    public final List<PromotionProductServiceStruct> getServices() {
        return this.services;
    }

    public final List<PromotionProductBannerStruct> getTags() {
        return this.tags;
    }

    public final List<JSONObject> getTagsInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Map<String, String> r101 = getExtraInfoMap();
        List r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.get(r100);
        if (r103 == null) goto L9;
        r102 = (List) GsonProtectorUtils.fromJson(new Gson(), r103, new c().getType());     // Catch: JsonSyntaxException -> L8
    L9:
        ArrayList r104 = new ArrayList();
        if (r102 == null) goto L19;
        Iterator r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        String r106 = ((e) r105.next()).a();
        if (r106 == null) goto L13;
        JSONObject r107 = com.bytedance.android.shopping.anchorv3.a.d(r106);
        if (r107 == null) goto L13;
        r104.add(r107);
    L19:
        return r104;
    }

    public final void setActivities(PromotionProductActivitiesStruct r100) {
        this.activities = r100;
    }

    public final void setBanners(List<PromotionProductBannerStruct> r100) {
        this.banners = r100;
    }

    public final void setCoupons(PromotionProductCouponsStruct r100) {
        this.coupons = r100;
    }

    public final void setInstallment(PromotionProductInstallmentStruct r100) {
        this.installment = r100;
    }

    public final void setLabels(List<PromotionProductBannerStruct> r100) {
        this.labels = r100;
    }

    public final void setLogistics(PromotionProductLogisticsStruct r100) {
        this.logistics = r100;
    }

    public final void setTags(List<PromotionProductBannerStruct> r100) {
        this.tags = r100;
    }
}

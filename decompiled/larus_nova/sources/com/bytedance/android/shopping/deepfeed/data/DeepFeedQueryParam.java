package com.bytedance.android.shopping.deepfeed.data;

import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.deepfeed.data.repo.DeepFeedAbValues;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\u0018\u00002\u00020\u00012\u00020\u0002B»\u0001\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bi\u0010jJ\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003J\u0010\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u0016R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u0007R\u0017\u0010\"\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R0\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+\"\u0004\b.\u0010/R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b0\u0010\u0007R$\u00101\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u0007R\u001c\u00104\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001c\u00106\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001dR\u001c\u00108\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010\u001dR\u001c\u0010:\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u001b\u001a\u0004\b;\u0010\u001dR\u001c\u0010<\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010\u001dR$\u0010>\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001b\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u0007R$\u0010A\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u001b\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u0007R\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0013\u0010L\u001a\u0004\u0018\u00010I8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0013\u0010N\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bM\u0010\u001dR\u0013\u0010P\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bO\u0010\u001dR\u0013\u0010R\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bQ\u0010\u001dR\u0013\u0010T\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bS\u0010\u001dR\u0013\u0010V\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bU\u0010\u001dR\u0013\u0010X\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bW\u0010\u001dR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bY\u0010\u001dR\u0013\u0010\\\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b[\u0010\u001dR\u0013\u0010^\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b]\u0010\u001dR\u0013\u0010`\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b_\u0010\u001dR\u0013\u0010b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\ba\u0010\u001dR\u0013\u0010d\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bc\u0010\u001dR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\be\u0010\u001dR\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u001d¨\u0006k"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/DeepFeedQueryParam;", "Ljava/io/Serializable;", "Lzl/b;", "", "filters", "", "fillFiltersFromMall$ec_shopping_impl_saasRelease", "(Ljava/lang/String;)V", "fillFiltersFromMall", "id", "appendFilters", "filtersToAll", "allFilters", "deepFeedFilters", "appendInnerAction", "", "getFilters", "", "generatedTime", "J", "", "recFilterList", "Ljava/util/List;", "deepFeedAllFilters", "filtersFromMall", "innerActionList", "firstCardProductId", "Ljava/lang/String;", "getFirstCardProductId", "()Ljava/lang/String;", "setFirstCardProductId", "preInflateCacheKey", "getPreInflateCacheKey", "setPreInflateCacheKey", "uid", "getUid", "()J", "eSceneId", "getESceneId", "", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Ljava/util/Map;", "getTracker", "()Ljava/util/Map;", "requestAddition", "getRequestAddition", "setRequestAddition", "(Ljava/util/Map;)V", "setFilters", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "bizCode", "getBizCode", "sceneCode", "getSceneCode", "cardParam", "getCardParam", "passThroughParams", "getPassThroughParams", "triggers", "getTriggers", "shareElementViewId", "getShareElementViewId", "setShareElementViewId", "negFeedbackJson", "getNegFeedbackJson", "setNegFeedbackJson", "Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "abValues", "Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "getAbValues", "()Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "", "getOutflowRank", "()Ljava/lang/Integer;", "outflowRank", "getPrevPage", "prevPage", "getPageName", "pageName", "getEnterFromMerge", "enterFromMerge", "getEnterFrom", "enterFrom", "getEcomEntranceForm", "ecomEntranceForm", "getCarrierSource", "carrierSource", "getSourcePage", "sourcePage", "getProductSourcePage", "productSourcePage", "getTabId", "tabId", "getTabName", "tabName", "getRecommendInfo", "recommendInfo", "getRequestID", "requestID", "getProductActivityType", "productActivityType", "getLastAction", "lastAction", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedQueryParam implements Serializable, zl.b {

    @SerializedName("ab_values")
    private final DeepFeedAbValues abValues;

    @SerializedName(UniContext.KEY_OF_BIZ_CODE)
    private final String bizCode;

    @SerializedName("card_param")
    private final String cardParam;
    private final List<String> deepFeedAllFilters;

    @SerializedName("ecom_scene_id")
    private final String eSceneId;

    @SerializedName("filters")
    private String filters;
    private final List<String> filtersFromMall;
    private String firstCardProductId;
    private final long generatedTime;
    private final List<String> innerActionList;

    @SerializedName("neg_feedback_json")
    private String negFeedbackJson;

    @SerializedName("pass_through_params")
    private final String passThroughParams;
    private String preInflateCacheKey;
    private final List<String> recFilterList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REC_PASS_PARAMS)
    private Map<String, ? extends Object> requestAddition;

    @SerializedName("scene_code")
    private final String sceneCode;

    @SerializedName("share_element_view_id")
    private String shareElementViewId;

    @SerializedName(PhotoEnterModel.SOURCE_BTM_TOKEN)
    private String sourceBtmToken;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TRACKER)
    private final Map<String, Object> tracker;

    @SerializedName("triggers")
    private final String triggers;
    private final long uid;

    public DeepFeedQueryParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public final String allFilters() {
        StringBuilder r100 = new StringBuilder();
        ArrayList r101 = new ArrayList();
        r101.addAll(this.filtersFromMall);
        r101.addAll(this.deepFeedAllFilters);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r100.append((String) r102.next());
        r100.append(",");
        goto L4
    L7:
        if (r100.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        r100.delete(r100.length() - 1, r100.length());
    L12:
        String r104 = r100.toString();
        DeepFeedFoldHelper.e();
        return r104;
    L9:
        r103 = false;
        goto L10
    }

    public final String deepFeedFilters() {
        if (this.recFilterList.isEmpty() == false) goto L6;
        return "";
    L6:
        StringBuilder r100 = new StringBuilder();
        Iterator<T> r101 = this.recFilterList.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r100.append((String) r101.next());
        r100.append(",");
        goto L8
    L10:
        r100.delete(r100.length() - 1, r100.length());
        return r100.toString();
    }

    public final String getCarrierSource() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getEcomEntranceForm() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getEnterFrom() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("enter_from");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getEnterFromMerge() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("enter_from_merge");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    @Override // zl.b
    /* JADX INFO: renamed from: getFilters, reason: collision with other method in class */
    public Map<String, String> mo8289getFilters() {
        if (this.deepFeedAllFilters.isEmpty() == true) goto L5;
        StringBuilder r100 = new StringBuilder();
        Iterator<T> r101 = this.deepFeedAllFilters.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r100.append((String) r101.next());
        r100.append(",");
        goto L8
    L10:
        r100.delete(r100.length() - 1, r100.length());
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("filters", r100.toString());
        return r102;
    L5:
        return MapsKt.emptyMap();
    }

    public final String getLastAction() {
        Map<String, ? extends Object> r100 = this.requestAddition;
        if (r100 == null) goto L7;
        Object r101 = r100.get("last_actions");
        if (r101 == null) goto L7;
        String r102 = r101.toString();
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final Integer getOutflowRank() {
        Map<String, Object> r100 = this.tracker;
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("outflow_order");
    L7:
        if ((r102 instanceof Integer) == false) goto L11;
        r101 = r102;
    L11:
        return (Integer) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final String getPageName() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("page_name");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getPrevPage() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("previous_page");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getProductActivityType() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L11;
        Object r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_INFO);
        if (r101 == null) goto L11;
        String r102 = r101.toString();
        if (r102 == null) goto L11;
        JSONObject r103 = k.c(r102);
        if (r103 == null) goto L11;
        String r104 = r103.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE);
    L12:
        if (r104 != null) goto L15;
        return "";
    L15:
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    public final String getProductSourcePage() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE);
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getRecommendInfo() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getRequestID() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("outer_reqid");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getSourcePage() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("source_page");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getTabId() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get("tab_id");
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final String getTabName() {
        Map<String, Object> r100 = this.tracker;
        if (r100 == null) goto L7;
        Object r101 = r100.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final DeepFeedAbValues getAbValues() {
        return this.abValues;
    }

    public final String getBizCode() {
        return this.bizCode;
    }

    public final String getCardParam() {
        return this.cardParam;
    }

    public final String getESceneId() {
        return this.eSceneId;
    }

    public final String getFirstCardProductId() {
        return this.firstCardProductId;
    }

    public final String getNegFeedbackJson() {
        return this.negFeedbackJson;
    }

    public final String getPassThroughParams() {
        return this.passThroughParams;
    }

    public final String getPreInflateCacheKey() {
        return this.preInflateCacheKey;
    }

    public final Map<String, Object> getRequestAddition() {
        return this.requestAddition;
    }

    public final String getSceneCode() {
        return this.sceneCode;
    }

    public final String getShareElementViewId() {
        return this.shareElementViewId;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final Map<String, Object> getTracker() {
        return this.tracker;
    }

    public final String getTriggers() {
        return this.triggers;
    }

    public final long getUid() {
        return this.uid;
    }

    public final String getFilters() {
        return this.filters;
    }

    public final void appendFilters(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.recFilterList.add(r100);
    }

    public final void appendInnerAction(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (this.innerActionList.isEmpty() == false) goto L15;
        this.innerActionList.add(r100);
        return;
    L15:
        if (this.innerActionList.size() < 5) goto L17;
        ListProtector.remove(this.innerActionList, 0);
        this.innerActionList.add(r100);
        return;
    L17:
        this.innerActionList.add(r100);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void fillFiltersFromMall$ec_shopping_impl_saasRelease(String r100) {
        this.filters = r100;
        this.filtersFromMall.clear();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        List r102 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L11
        if ((!r102.isEmpty()) == false) goto L9;
        this.filtersFromMall.addAll(r102);     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void filtersToAll(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.deepFeedAllFilters.add(r100);
    }

    public final void setFilters(String r100) {
        this.filters = r100;
    }

    public final void setFirstCardProductId(String r100) {
        this.firstCardProductId = r100;
    }

    public final void setNegFeedbackJson(String r100) {
        this.negFeedbackJson = r100;
    }

    public final void setPreInflateCacheKey(String r100) {
        this.preInflateCacheKey = r100;
    }

    public final void setRequestAddition(Map<String, ? extends Object> r100) {
        this.requestAddition = r100;
    }

    public final void setShareElementViewId(String r100) {
        this.shareElementViewId = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    public DeepFeedQueryParam(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, DeepFeedAbValues r113) {
        this.eSceneId = r100;
        this.tracker = r101;
        this.requestAddition = r102;
        this.filters = r103;
        this.sourceBtmToken = r104;
        this.bizCode = r105;
        this.sceneCode = r106;
        this.cardParam = r107;
        this.passThroughParams = r108;
        this.triggers = r110;
        this.shareElementViewId = r111;
        this.negFeedbackJson = r112;
        this.abValues = r113;
        this.generatedTime = SystemClock.uptimeMillis();
        this.recFilterList = new ArrayList();
        this.deepFeedAllFilters = new ArrayList();
        ArrayList r109 = new ArrayList();
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L11
        String r115 = this.filters;     // Catch: Throwable -> L11
        if (r115 != null) goto L6;
        r115 = "";
    L6:
        List r116 = StringsKt.split$default(r115, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L11
        if ((!r116.isEmpty()) == false) goto L9;
        r109.addAll(r116);     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        this.filtersFromMall = r109;
        this.innerActionList = new ArrayList();
        this.uid = this.generatedTime;
        return;
    L11:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public /* synthetic */ DeepFeedQueryParam(String r110, Map r111, Map r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, DeepFeedAbValues r217, int r218, DefaultConstructorMarker r219) {
        DeepFeedAbValues r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        Map r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Map r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
}

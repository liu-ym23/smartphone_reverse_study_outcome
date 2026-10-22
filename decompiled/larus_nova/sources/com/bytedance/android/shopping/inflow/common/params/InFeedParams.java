package com.bytedance.android.shopping.inflow.common.params;

import android.os.SystemClock;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\bM\u0018\u0000 x2\u00020\u0001:\u0001yB\u0085\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\b\b\u0002\u0010$\u001a\u00020\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bv\u0010wJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR4\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010 \u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b&\u0010'R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010'R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010'R#\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010'R#\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0,8\u0006¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00101R\u0019\u00106\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b6\u0010\u0012\u001a\u0004\b7\u0010'R\u0019\u00108\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b8\u0010\u0012\u001a\u0004\b9\u0010'R\u0019\u0010:\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b;\u0010'R\u0019\u0010<\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010'R\u0019\u0010>\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010'R\u0019\u0010@\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b@\u0010\u0012\u001a\u0004\bA\u0010'R\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bB\u0010\u0012\u001a\u0004\bC\u0010'R\u0019\u0010D\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bD\u0010\u0012\u001a\u0004\bE\u0010'R\u0019\u0010F\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bG\u0010'R\u0019\u0010H\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bH\u0010\u0012\u001a\u0004\bI\u0010'R\u0019\u0010J\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bJ\u0010\u0012\u001a\u0004\bK\u0010'R\u0013\u0010M\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\bL\u0010\u001dR\u0013\u0010O\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bN\u0010'R\u0013\u0010Q\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bP\u0010'R\u0013\u0010S\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bR\u0010'R\u0013\u0010U\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bT\u0010'R\u0013\u0010W\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bV\u0010'R\u0013\u0010Y\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bX\u0010'R\u0013\u0010[\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bZ\u0010'R\u0013\u0010]\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\\\u0010'R\u0013\u0010_\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b^\u0010'R\u0013\u0010a\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b`\u0010'R\u0011\u0010c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bb\u0010'R\u0011\u0010e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bd\u0010'R\u0011\u0010g\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bf\u0010'R\u0011\u0010i\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bh\u0010'R\u0011\u0010k\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bj\u0010'R\u0011\u0010m\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bl\u0010'R\u0013\u0010o\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bn\u0010'R\u0013\u0010q\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bp\u0010'R\u0013\u0010s\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\br\u0010'R\u0013\u0010u\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\bt\u0010'¨\u0006z"}, d2 = {"Lcom/bytedance/android/shopping/inflow/common/params/InFeedParams;", "Ljava/io/Serializable;", "", "productId", "getUpdateProductIdLogExtra", "getOriginLogExtra", "", "ids", "", "appendRecFilters", "", "generatedTime", "J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtraObj", "Ljava/util/HashMap;", "logExtraProductId", "Ljava/lang/String;", "", "recFilterList", "Ljava/util/List;", "uid", "getUid", "()J", "", "outerCardType", "Ljava/lang/Integer;", "getOuterCardType", "()Ljava/lang/Integer;", "outerEntranceType", "getOuterEntranceType", "inFeedType", "I", "getInFeedType", "()I", "display", "getDisplay", "getProductId", "()Ljava/lang/String;", "eSceneId", "getESceneId", "bgColor", "getBgColor", "", "", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Ljava/util/Map;", "getTracker", "()Ljava/util/Map;", "metaData", "getMetaData", "requestAddition", "getRequestAddition", "themeBg", "getThemeBg", "themeLabel", "getThemeLabel", "activityBg", "getActivityBg", "activityTitle", "getActivityTitle", "activitySubtitle", "getActivitySubtitle", "activitySubtitleColor", "getActivitySubtitleColor", "firstCardData", "getFirstCardData", "imageUrl", "getImageUrl", "transitionName", "getTransitionName", "transitionId", "getTransitionId", "sourceBtmToken", "getSourceBtmToken", "getOutflowRank", "outflowRank", "getPrevPage", "prevPage", "getPageName", "pageName", "getEnterFromMerge", "enterFromMerge", "getEnterFrom", "enterFrom", "getCarrierSource", "carrierSource", "getSourcePage", "sourcePage", "getProductSourcePage", "productSourcePage", "getTabId", "tabId", "getTabName", "tabName", "getRecommendInfo", "recommendInfo", "getSceneId", "sceneId", "getPackBlockName", "packBlockName", "getActivityBlockName", "activityBlockName", "getBlockName", "blockName", "getRecRelated", "recRelated", "getRecFilters", "recFilters", "getRecTopicId", "recTopicId", "getRecTopicText", "recTopicText", "getRecTopicSchemeType", "recTopicSchemeType", "getRecTopicTag", "recTopicTag", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedParams implements Serializable {
    public static final a Companion = null;
    public static final int ENTRANCE_TYPE_HALF_SCREEN = 0;
    public static final int ENTRANCE_TYPE_LIVE_CARD = 2;
    public static final int ENTRANCE_TYPE_PRODUCT_CARD = 1;
    public static final int ENTRANCE_TYPE_VIDEO_CARD = 3;
    public static final int IN_FEED_MXIED_TYPE = 4;
    public static final int IN_FEED_TYPE_ACTIVITY = 3;
    public static final int IN_FEED_TYPE_NORMAL = 1;
    public static final int IN_FEED_TYPE_THEME = 2;
    private static final long serialVersionUID = -1;
    private final String activityBg;
    private final String activitySubtitle;
    private final String activitySubtitleColor;
    private final String activityTitle;
    private final String bgColor;
    private final int display;
    private final String eSceneId;
    private final String firstCardData;
    private final long generatedTime;
    private final String imageUrl;
    private final int inFeedType;
    private final HashMap<String, String> logExtraObj;
    private final String logExtraProductId;
    private final String metaData;
    private final Integer outerCardType;
    private final Integer outerEntranceType;
    private final String productId;
    private final List<String> recFilterList;
    private final Map<String, Object> requestAddition;
    private final String sourceBtmToken;
    private final String themeBg;
    private final String themeLabel;
    private final Map<String, Object> tracker;
    private final String transitionId;
    private final String transitionName;
    private final long uid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getOriginLogExtra() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if (this.logExtraObj == null) goto L15;
        String r102 = this.logExtraProductId;     // Catch: Throwable -> L18
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        this.logExtraObj.put("product_id", this.logExtraProductId);     // Catch: Throwable -> L18
    L14:
        String r104 = cd.a.c(this.logExtraObj).toString();     // Catch: Throwable -> L18
    L16:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r105) == true) goto L25;
        r100 = r105;
    L25:
        return (String) r100;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L15:
        r104 = null;
    L18:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public final String getActivityBlockName() {
        Object r100 = this.requestAddition.get("activity_block_name");
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        Intrinsics.checkNotNullParameter("product_inner_activity_header", "default");
        if (r101 == null) goto L9;
        return r101;
    L9:
        return "product_inner_activity_header";
    L5:
        r101 = null;
        goto L6
    }

    public final String getBlockName() {
        Object r100 = this.requestAddition.get("block_name");
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getCarrierSource() {
        Object r100 = this.tracker.get(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getEnterFrom() {
        Object r100 = this.tracker.get("enter_from");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getEnterFromMerge() {
        Object r100 = this.tracker.get("enter_from_merge");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final Integer getOutflowRank() {
        Object r100 = this.tracker.get("outflow_order");
        if ((r100 instanceof Integer) == true) goto L6;
        r100 = null;
    L6:
        return (Integer) r100;
    }

    public final String getPackBlockName() {
        Object r100 = this.requestAddition.get("pack_block_name");
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        Intrinsics.checkNotNullParameter("product_inner_head", "default");
        if (r101 == null) goto L9;
        return r101;
    L9:
        return "product_inner_head";
    L5:
        r101 = null;
        goto L6
    }

    public final String getPageName() {
        Object r100 = this.tracker.get("page_name");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getPrevPage() {
        Object r100 = this.tracker.get("previous_page");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getProductSourcePage() {
        Object r100 = this.tracker.get(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getRecFilters() {
        if (this.inFeedType != 1) goto L11;
        Object r100 = this.requestAddition.get("rec_filters");
        if (r100 == null) goto L7;
        String r101 = r100.toString();
    L8:
        if (r101 != null) goto L18;
        return "";
    L18:
        return r101;
    L7:
        r101 = null;
        goto L8
    L11:
        StringBuilder r102 = new StringBuilder();
        Iterator<T> r103 = this.recFilterList.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        r102.append((String) r103.next());
        r102.append(",");
        goto L13
    L15:
        r102.delete(r102.length() - 1, r102.length());
        return r102.toString();
    }

    public final String getRecRelated() {
        Object r100 = this.requestAddition.get("rec_related");
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getRecTopicId() {
        Object r100 = this.requestAddition.get("topic_rec_id");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getRecTopicSchemeType() {
        Object r100 = this.requestAddition.get("topic_schema_type");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getRecTopicTag() {
        Object r100 = this.requestAddition.get("topic_tag");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getRecTopicText() {
        Object r100 = this.requestAddition.get("topic_rec_text");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getRecommendInfo() {
        Object r100 = this.tracker.get(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getSceneId() {
        Object r100 = this.requestAddition.get("scene_id");
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getSourcePage() {
        Object r100 = this.tracker.get("source_page");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getTabId() {
        Object r100 = this.tracker.get("tab_id");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getTabName() {
        Object r100 = this.tracker.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public final String getActivityBg() {
        return this.activityBg;
    }

    public final String getActivitySubtitle() {
        return this.activitySubtitle;
    }

    public final String getActivitySubtitleColor() {
        return this.activitySubtitleColor;
    }

    public final String getActivityTitle() {
        return this.activityTitle;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getDisplay() {
        return this.display;
    }

    public final String getESceneId() {
        return this.eSceneId;
    }

    public final String getFirstCardData() {
        return this.firstCardData;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getInFeedType() {
        return this.inFeedType;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final Integer getOuterCardType() {
        return this.outerCardType;
    }

    public final Integer getOuterEntranceType() {
        return this.outerEntranceType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Map<String, Object> getRequestAddition() {
        return this.requestAddition;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getThemeBg() {
        return this.themeBg;
    }

    public final String getThemeLabel() {
        return this.themeLabel;
    }

    public final Map<String, Object> getTracker() {
        return this.tracker;
    }

    public final String getTransitionId() {
        return this.transitionId;
    }

    public final String getTransitionName() {
        return this.transitionName;
    }

    public final long getUid() {
        return this.uid;
    }

    public final void appendRecFilters(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        int r101 = this.inFeedType;
        if (r101 != 2) goto L5;
    L8:
        this.recFilterList.addAll(r100);
        return;
    L5:
        if (r101 == 3) goto L8;
        if (r101 == 4) goto L8;
    }

    public final String getUpdateProductIdLogExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        HashMap<String, String> r103 = this.logExtraObj;     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r103.put("product_id", r100);     // Catch: Throwable -> L9
        String r104 = cd.a.c(this.logExtraObj).toString();     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r101 = r105;
    L16:
        return (String) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public InFeedParams(Integer r110, Integer r111, int r112, int r113, String r114, String r115, String r116, Map<String, ? extends Object> r210, String r211, Map<String, ? extends Object> r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r114, "productId");
        Intrinsics.checkNotNullParameter(r210, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Intrinsics.checkNotNullParameter(r211, "metaData");
        Intrinsics.checkNotNullParameter(r212, "requestAddition");
        this.outerCardType = r110;
        this.outerEntranceType = r111;
        this.inFeedType = r112;
        this.display = r113;
        this.productId = r114;
        this.eSceneId = r115;
        this.bgColor = r116;
        this.tracker = r210;
        this.metaData = r211;
        this.requestAddition = r212;
        this.themeBg = r213;
        this.themeLabel = r214;
        this.activityBg = r215;
        this.activityTitle = r216;
        this.activitySubtitle = r217;
        this.activitySubtitleColor = r218;
        this.firstCardData = r219;
        this.imageUrl = r310;
        this.transitionName = r311;
        this.transitionId = r312;
        this.sourceBtmToken = r313;
        this.generatedTime = SystemClock.uptimeMillis();
        Object r100 = r210.get("log_extra");
        String r101 = null;
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r102 = (String) r100;
        JSONArray r103 = k.t(r102);
        boolean r104 = true;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L22
        if (r103 != null) goto L9;
    L19:
        HashMap r106 = null;
    L20:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r107) == false) goto L27;
        r107 = null;
    L27:
        HashMap<String, String> r108 = (HashMap) r107;
        this.logExtraObj = r108;
        if (r108 == null) goto L30;
        String r109 = r108.get("product_id");
    L31:
        this.logExtraProductId = r109;
        if (r102 != null) goto L34;
    L37:
        boolean r117 = true;
    L38:
        if (r117 == true) goto L44;
        Map<String, Object> r118 = this.tracker;
        if (r118 == null) goto L43;
        ((HashMap) r118).remove("log_extra");
        goto L44
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
    L44:
        String r119 = getRecTopicId();
        if (r119 != null) goto L47;
    L50:
        boolean r120 = true;
    L51:
        if (r120 == true) goto L54;
        if (r108 == null) goto L54;
        String r121 = r108.put("topic_id", r119);
    L54:
        ArrayList r122 = new ArrayList();
        Object r123 = this.requestAddition.get("rec_filters");     // Catch: Throwable -> L70
        if (r123 == null) goto L58;
        r101 = r123.toString();     // Catch: Throwable -> L70
    L58:
        if (r101 != null) goto L60;
        r101 = "";
    L60:
        List r124 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L70
        List r125 = r124;     // Catch: Throwable -> L70
        if (r125 != null) goto L63;
    L66:
        if (r104 == true) goto L68;
        r122.addAll(r124);     // Catch: Throwable -> L70
    L68:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L72:
        this.recFilterList = r122;
        this.uid = this.generatedTime;
        return;
    L63:
        if (r125.isEmpty() == true) goto L66;
        r104 = false;
    L70:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L72
    L47:
        if (r119.length() == 0) goto L50;
        r120 = false;
        goto L51
    L34:
        if (r102.length() == 0) goto L37;
        r117 = false;
        goto L38
    L30:
        r109 = null;
        goto L31
    L9:
        if (r103.length() <= 0) goto L19;
        JSONObject r127 = JSONArrayProtectorUtils.getJSONObject(r103, 0);     // Catch: Throwable -> L22
        r106 = new HashMap();     // Catch: Throwable -> L22
        Iterator<String> r128 = r127.keys();     // Catch: Throwable -> L22
    L12:
        if (r128.hasNext() == false) goto L20;
        String r129 = r128.next();     // Catch: Throwable -> L22
        String r130 = r127.opt(r129).toString();     // Catch: Throwable -> L22
        if (r130.length() <= 0) goto L16;
        boolean r131 = true;
    L17:
        if (r131 == false) goto L12;
        r106.put(r129, r130);     // Catch: Throwable -> L22
        goto L12
    L16:
        r131 = false;
    L22:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public /* synthetic */ InFeedParams(Integer r210, Integer r211, int r212, int r310, String r311, String r312, String r313, Map r314, String r315, Map r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, int r418, DefaultConstructorMarker r419) {
        if ((r418 & 1) == 0) goto L5;
        Integer r100 = 0;
    L7:
        if ((r418 & 2) == 0) goto L9;
        Integer r101 = 0;
    L11:
        if ((r418 & 8) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r418 & 32) == 0) goto L17;
        String r110 = null;
    L19:
        if ((r418 & 64) == 0) goto L21;
        String r111 = null;
    L23:
        if ((r418 & 1024) == 0) goto L25;
        String r112 = null;
    L27:
        if ((r418 & 2048) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r418 & 4096) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r418 & 8192) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r418 & 16384) == 0) goto L41;
        String r116 = null;
    L43:
        if ((32768 & r418) == 0) goto L45;
        String r213 = null;
    L47:
        if ((65536 & r418) == 0) goto L49;
        String r214 = null;
    L51:
        if ((131072 & r418) == 0) goto L53;
        String r215 = null;
    L55:
        if ((262144 & r418) == 0) goto L57;
        String r216 = null;
    L59:
        if ((524288 & r418) == 0) goto L61;
        String r217 = null;
    L63:
        if ((r418 & 1048576) == 0) goto L65;
        String r218 = null;
    L66:
        this(r100, r101, r212, r102, r311, r110, r111, r314, r315, r316, r112, r113, r114, r115, r116, r213, r214, r215, r216, r217, r218);
        return;
    L65:
        r218 = r417;
        goto L66
    L61:
        r217 = r416;
        goto L63
    L57:
        r216 = r415;
        goto L59
    L53:
        r215 = r414;
        goto L55
    L49:
        r214 = r413;
        goto L51
    L45:
        r213 = r412;
        goto L47
    L41:
        r116 = r411;
        goto L43
    L37:
        r115 = r410;
        goto L39
    L33:
        r114 = r319;
        goto L35
    L29:
        r113 = r318;
        goto L31
    L25:
        r112 = r317;
        goto L27
    L21:
        r111 = r313;
        goto L23
    L17:
        r110 = r312;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}

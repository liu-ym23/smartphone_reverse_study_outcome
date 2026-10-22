package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.m;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001a\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-R:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tRB\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;", "Ljava/io/Serializable;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "commonData", "Ljava/util/HashMap;", "getCommonData", "()Ljava/util/HashMap;", "trackCommonData", "getTrackCommonData", "setTrackCommonData", "(Ljava/util/HashMap;)V", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECExposureDataDTO;", "exposureData", "Ljava/util/List;", "getExposureData", "()Ljava/util/List;", "setExposureData", "(Ljava/util/List;)V", "", "adActionData", "Ljava/util/Map;", "getAdActionData", "()Ljava/util/Map;", "setAdActionData", "(Ljava/util/Map;)V", "clickData", "getClickData", "setClickData", "feedbackCommonData", "getFeedbackCommonData", "setFeedbackCommonData", "conditionData", "getConditionData", "setConditionData", "trackDataKey", "Ljava/lang/String;", "getTrackDataKey", "()Ljava/lang/String;", "setTrackDataKey", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTrackDataDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("ad_action_data")
    private Map<String, ? extends Object> adActionData;

    @SerializedName("click_data")
    private List<ECExposureDataDTO> clickData;

    @SerializedName("real_common_data")
    private final HashMap<String, Object> commonData;

    @SerializedName("condition_data")
    private List<ECExposureDataDTO> conditionData;

    @SerializedName("exposure_data")
    private List<ECExposureDataDTO> exposureData;

    @SerializedName("feedback_common_data")
    private Map<String, ? extends Object> feedbackCommonData;

    @SerializedName("track_common_data")
    private HashMap<String, Object> trackCommonData;

    @SerializedName("track_data_key")
    private String trackDataKey;

    public static final class a {
        public a() {
        }

        public static n b(ECTrackDataDTO r100, ECHybridListItemVO r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            Intrinsics.checkNotNullParameter(r101, "listItemVo");
            n r102 = new n();
            r102.f47139a = r100.getCommonData();
            r102.f47140b = r100.getTrackCommonData();
            List<ECExposureDataDTO> r103 = r100.getExposureData();
            List<com.bytedance.android.ec.hybrid.list.entity.c> r104 = null;
            if (r103 == null) goto L5;
            ECTrackDataDTO.Companion.getClass();
            List<com.bytedance.android.ec.hybrid.list.entity.c> r105 = a(r103, r100, r101);
        L6:
            r102.f47141c = r105;
            r102.f47142d = r100.getAdActionData();
            List<ECExposureDataDTO> r106 = r100.getClickData();
            if (r106 == null) goto L9;
            ECTrackDataDTO.Companion.getClass();
            List<com.bytedance.android.ec.hybrid.list.entity.c> r107 = a(r106, r100, r101);
        L10:
            r102.f47143e = r107;
            r102.f47144f = r100.getFeedbackCommonData();
            List<ECExposureDataDTO> r108 = r100.getConditionData();
            if (r108 == null) goto L13;
            ECTrackDataDTO.Companion.getClass();
            r104 = a(r108, r100, r101);
        L13:
            r102.f47145g = r104;
            r102.f47146h = r100.getTrackDataKey();
            return r102;
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }

        public static List a(List r110, ECTrackDataDTO r111, ECHybridListItemVO r112) {
            List r113 = r110;
            ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator r114 = r113.iterator();
        L4:
            if (r114.hasNext() == false) goto L42;
            ECExposureDataDTO r101 = (ECExposureDataDTO) r114.next();
            ECExposureDataDTO.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "dto");
            Intrinsics.checkNotNullParameter(r112, "itemVo");
            com.bytedance.android.ec.hybrid.list.entity.c r102 = new com.bytedance.android.ec.hybrid.list.entity.c();
            r102.f47071a = r101.getEventName();
            r102.f47072b = r101.getParams();
            r102.f47074d = r101.getExtra();
            r102.f47075e = r112;
            List<ECParamsFromClientDTO> r103 = r101.getParamsFromClient();
            if (r103 == null) goto L11;
            List<ECParamsFromClientDTO> r104 = r103;
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator<T> r106 = r104.iterator();
        L9:
            if (r106.hasNext() == false) goto L12;
            ECParamsFromClientDTO r107 = (ECParamsFromClientDTO) r106.next();
            m r108 = new m();
            r108.f47137a = r107.getClientKey();
            r108.f47138b = r107.getReportKey();
            r105.add(r108);
        L12:
            r102.f47073c = r105;
            r102.f47076f = r101.getBstRuleKey();
            r102.f47077g = r101.getParamsSameAs();
            if (Intrinsics.areEqual(r101.getMergeRealCommon(), Boolean.TRUE) == false) goto L41;
            a r109 = ECTrackDataDTO.Companion;
            HashMap<String, Object> r115 = r111.getCommonData();
            r109.getClass();
            if (r115 == null) goto L41;
            if (r102.f47072b != null) goto L19;
            r102.f47072b = new HashMap();
        L19:
            Iterator<T> r116 = r115.keySet().iterator();
        L21:
            if (r116.hasNext() == false) goto L41;
            String r117 = (String) r116.next();
            Map<String, Object> r118 = r102.f47072b;
            if (r118 == null) goto L38;
            boolean r119 = true;
            if (r118.containsKey(r117) != true) goto L38;
            Map<String, Object> r120 = r102.f47072b;
            if (r120 == null) goto L31;
            Object r121 = r120.get(r117);
            if (r121 == null) goto L31;
            String r122 = r121.toString();
        L32:
            if (r122 != null) goto L34;
        L37:
            if (r119 == false) goto L21;
        L34:
            if (r122.length() == 0) goto L37;
            r119 = false;
        L31:
            r122 = null;
        L38:
            Map<String, Object> r123 = r102.f47072b;
            if (r123 == null) goto L21;
            r123.put(r117, r115.get(r117));
        L41:
            r100.add(r102);
            goto L4
        L11:
            r105 = null;
            goto L12
        L42:
            return r100;
        }
    }

    static {
        Companion = new a();
    }

    public ECTrackDataDTO() {
    }

    public final Map<String, Object> getAdActionData() {
        return this.adActionData;
    }

    public final List<ECExposureDataDTO> getClickData() {
        return this.clickData;
    }

    public final HashMap<String, Object> getCommonData() {
        return this.commonData;
    }

    public final List<ECExposureDataDTO> getConditionData() {
        return this.conditionData;
    }

    public final List<ECExposureDataDTO> getExposureData() {
        return this.exposureData;
    }

    public final Map<String, Object> getFeedbackCommonData() {
        return this.feedbackCommonData;
    }

    public final HashMap<String, Object> getTrackCommonData() {
        return this.trackCommonData;
    }

    public final String getTrackDataKey() {
        return this.trackDataKey;
    }

    public final void setAdActionData(Map<String, ? extends Object> r100) {
        this.adActionData = r100;
    }

    public final void setClickData(List<ECExposureDataDTO> r100) {
        this.clickData = r100;
    }

    public final void setConditionData(List<ECExposureDataDTO> r100) {
        this.conditionData = r100;
    }

    public final void setExposureData(List<ECExposureDataDTO> r100) {
        this.exposureData = r100;
    }

    public final void setFeedbackCommonData(Map<String, ? extends Object> r100) {
        this.feedbackCommonData = r100;
    }

    public final void setTrackCommonData(HashMap<String, Object> r100) {
        this.trackCommonData = r100;
    }

    public final void setTrackDataKey(String r100) {
        this.trackDataKey = r100;
    }
}

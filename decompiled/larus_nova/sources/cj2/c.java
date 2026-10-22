package cj2;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.g;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.ec.model.playback.PlaybackEventExtraData;
import com.bytedance.android.livesdk.livecommerce.playback.applog.ExplainPlayBackPDPEntryLogExtra;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import dj2.e;
import dj2.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f23955d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f23956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f23957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f23958c;

    public static final class a {
        public static c a(e r110) {
            Intrinsics.checkNotNullParameter(r110, "param");
            c r100 = new c();
            r100.f23957b = g.a();
            f r101 = r110.f468888a;
            if (r101 == null) goto L5;
            String r102 = String.valueOf(r101.f468892a);
            String r103 = String.valueOf(r101.f468893b);
        L6:
            LogExtraData r104 = r110.f468889b;
            String r105 = null;
            if (r104 == null) goto L9;
            String r106 = r104.getSourcePage();
        L10:
            r100.a("source_page", r106, "");
            r100.a(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r102, "");
            r100.a("product_id", r103, "");
            PlaybackEventExtraData r107 = r110.f468890c;
            if (r107 == null) goto L13;
            String r108 = r107.getCommodityType();
        L14:
            r100.a(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r108, "");
            PlaybackEventExtraData r109 = r110.f468890c;
            if (r109 == null) goto L17;
            String r111 = r109.getFollowStatus();
        L18:
            r100.a("follow_status", String.valueOf(r111), "0");
            LogExtraData r112 = r110.f468889b;
            if (r112 == null) goto L21;
            String r113 = r112.getEComEntranceForm();
        L22:
            r100.a("enter_from_merge", r113, "");
            LogExtraData r114 = r110.f468889b;
            if (r114 == null) goto L25;
            String r115 = r114.getEnterMethod();
        L26:
            r100.a("enter_method", r115, "");
            PlaybackEventExtraData r116 = r110.f468890c;
            if (r116 == null) goto L29;
            String r117 = r116.getWithSku();
        L30:
            r100.a(com.bytedance.android.ec.core.event.a.KEY_WITH_SKU, r117, "");
            PlaybackEventExtraData r118 = r110.f468890c;
            if (r118 == null) goto L33;
            String r119 = r118.getUserId();
        L34:
            r100.a("author_id", r119, "");
            LogExtraData r120 = r110.f468889b;
            if (r120 == null) goto L37;
            String r121 = r120.getRoomId();
        L38:
            r100.a("room_id", r121, "");
            if (EComABUtils.isOuterEntranceInfoReport() == true) goto L45;
            LogExtraData r122 = r110.f468889b;
            if (r122 == null) goto L43;
            String r123 = r122.getEntranceInfo();
        L44:
            r100.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r123, "");
            goto L45
        L43:
            r123 = null;
        L45:
            LogExtraData r124 = r110.f468889b;
            if (r124 == null) goto L48;
            String r125 = r124.getFragmentId();
        L49:
            r100.a("fragment_id", r125, "");
            LogExtraData r126 = r110.f468889b;
            if (r126 == null) goto L52;
            String r127 = r126.getEnterScene();
        L53:
            r100.a("enter_scene", r127, "");
            LogExtraData r128 = r110.f468889b;
            if (r128 == null) goto L56;
            String r129 = r128.getEntranceInfo();
        L57:
            JSONObject r130 = z1.g(r129);
            LogExtraData r131 = r110.f468889b;
            if (r131 == null) goto L70;
            String r132 = r131.getCarrierSource();
            if (r132 == null) goto L70;
            if (r132.length() <= 0) goto L64;
            boolean r133 = true;
        L65:
            if (r133 == true) goto L68;
            r132 = null;
        L68:
            if (r132 == null) goto L70;
            r100.a(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r132, "");
        L75:
            LogExtraData r134 = r110.f468889b;
            if (r134 == null) goto L78;
            String r135 = r134.getEnterScene();
        L80:
            if (Intrinsics.areEqual(r135, "search") == false) goto L82;
            r100.a(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product_card", "");
        L86:
            r100.a(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD, "");
            if (r130 == null) goto L95;
            String r136 = r130.optString("group_id");
            HashMap<String, String> r137 = r100.f23956a;
            if (TextUtils.isEmpty(r136) == true) goto L95;
            if (TextUtils.equals("null", r136) == true) goto L95;
            if (r136 != null) goto L94;
            r136 = "";
        L94:
            r137.put(com.bytedance.android.ec.core.event.a.KEY_LIVE_GROUP_ID, r136);
        L95:
            LogExtraData r138 = r110.f468889b;
            if (r138 == null) goto L100;
            Intrinsics.checkNotNullParameter(r138, "$this$isFromProductDetail");
            if (Intrinsics.areEqual(r138.getSourcePage(), com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) != true) goto L100;
            r100.a("page_name", "product_detail_replay", "");
        L100:
            LogExtraData r139 = r110.f468889b;
            if (r139 == null) goto L103;
            String r140 = r139.getSearchParam();
        L104:
            r100.a("search_params", r140, "");
            ExplainPlayBackPDPEntryLogExtra r141 = r110.f468891d;
            if (r141 == null) goto L107;
            r100.a(com.bytedance.android.ec.core.event.a.KEY_IS_FLOAT, r141.isFloat(), "");
            r100.a("entrance_form", r141.getEntranceForm(), "");
        L107:
            PlaybackEventExtraData r142 = r110.f468890c;
            if (r142 == null) goto L112;
            Integer r143 = r142.getModelType();
            if (r143 == null) goto L112;
            r105 = String.valueOf(r143.intValue());
        L112:
            HashMap<String, String> r144 = r100.f23956a;
            if (TextUtils.isEmpty(r105) == true) goto L120;
            if (TextUtils.equals("null", r105) == true) goto L120;
            if (r105 != null) goto L118;
            r105 = "";
        L118:
            r144.put(AdDownloadModel.JsonKey.MODEL_TYPE, r105);
        L120:
            if (ExplainPlaybackUtils.d() == false) goto L155;
            f r145 = r110.f468888a;
            if (EComABUtils.isOuterEntranceInfoReport() == false) goto L129;
            if (r145 == null) goto L129;
            Map<String, String> r146 = r145.f468894c;
            if (r146 == null) goto L129;
            r100.a("author_type", r146.get("author_type"), "");
            r100.a("video_id", r146.get("video_id"), "");
            r100.a("total_duration", r146.get("total_duration"), "");
            r100.a("video_quality", r146.get("video_quality"), "");
        L129:
            if (EComABUtils.isOuterEntranceInfoReport() == false) goto L184;
            if (r130 == null) goto L184;
            Iterator<String> r147 = r130.keys();
        L134:
            if (r147.hasNext() == false) goto L184;
            String r148 = r147.next();
            String r149 = r130.optString(r148);
            if (r148 == null) goto L154;
            int r150 = r148.hashCode();
            if (r150 != (-758956222)) goto L141;
            if (r148.equals(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE) == false) goto L154;
        L141:
            if (r150 != (-316981042)) goto L143;
            if (r148.equals(com.bytedance.android.ec.core.event.a.KEY_LIVE_GROUP_ID) == false) goto L154;
        L143:
            if (r150 != 186187293) goto L154;
            if (r148.equals(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE) == true) goto L134;
        L154:
            r100.a(r148, r149, "");
        L184:
            return r100;
        L155:
            f r151 = r110.f468888a;
            if (r151 == null) goto L171;
            Map<String, String> r152 = r151.f468894c;
            if (r152 == null) goto L171;
            Iterator<Map.Entry<String, String>> r153 = r152.entrySet().iterator();
        L161:
            if (r153.hasNext() == false) goto L171;
            Map.Entry<String, String> r154 = r153.next();
            String r155 = r154.getKey();
            String r156 = r154.getValue();
            String r157 = r100.f23956a.get(r155);
            if (r157 != null) goto L165;
        L168:
            boolean r158 = true;
        L169:
            if (r158 == false) goto L161;
            r100.a(r155, r156, "");
            goto L161
        L165:
            if (r157.length() == 0) goto L168;
            r158 = false;
        L171:
            if (r130 == null) goto L184;
            Iterator<String> r159 = r130.keys();
        L174:
            if (r159.hasNext() == false) goto L184;
            String r160 = r159.next();
            String r161 = r100.f23956a.get(r160);
            if (r161 != null) goto L178;
        L181:
            boolean r162 = true;
        L182:
            if (r162 == false) goto L174;
            r100.a(r160, r130.optString(r160), "");
            goto L174
        L178:
            if (r161.length() == 0) goto L181;
            r162 = false;
            goto L182
        L103:
            r140 = null;
            goto L104
        L82:
            if (r130 == null) goto L84;
            String r163 = r130.optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        L85:
            r100.a(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r163, "product_card");
            goto L86
        L84:
            r163 = null;
            goto L85
        L78:
            r135 = null;
            goto L80
        L64:
            r133 = false;
        L70:
            if (r130 == null) goto L73;
            String r164 = r130.optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE);
            if (r164 == null) goto L73;
        L74:
            r100.a(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r164, "");
        L73:
            r164 = "";
            goto L74
        L56:
            r129 = null;
            goto L57
        L52:
            r127 = null;
            goto L53
        L48:
            r125 = null;
            goto L49
        L37:
            r121 = null;
            goto L38
        L33:
            r119 = null;
            goto L34
        L29:
            r117 = null;
            goto L30
        L25:
            r115 = null;
            goto L26
        L21:
            r113 = null;
            goto L22
        L17:
            r111 = null;
            goto L18
        L13:
            r108 = null;
            goto L14
        L9:
            r106 = null;
            goto L10
        L5:
            r103 = "";
            r102 = r103;
            goto L6
        }
    }

    static {
    }

    public c() {
        this.f23956a = new HashMap();
        this.f23957b = -1.0d;
        this.f23958c = -1.0d;
    }

    public final void a(String r100, String r101, String r102) {
        HashMap<String, String> r103 = this.f23956a;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L9:
        r101 = r102;
    L10:
        r103.put(r100, r101);
        return;
    L5:
        if (TextUtils.equals("null", r101) == true) goto L9;
        if (r101 != null) goto L10;
        r101 = "";
        goto L10
    }
}

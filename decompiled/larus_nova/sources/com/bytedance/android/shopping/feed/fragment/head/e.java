package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175081a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        if (Intrinsics.areEqual(r100, "order_center_video") == false) goto L7;
        return "product_flow_page_" + r100 + "_order_homepage";
    L7:
        return "product_flow_page_".concat(r100);
    }

    public static void b(k r100, d r101, Context r102, boolean r103, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "contextData");
        Intrinsics.checkNotNullParameter(r111, "searchEntranceStyle");
        String r104 = r100.f175103a;
        String r105 = r100.f175104b;
        JSONObject r106 = new JSONObject();
        r106.put("suggest_word", r104);     // Catch: JSONException -> L5
        r106.put("suggest_word_id", r105);     // Catch: JSONException -> L5
    L7:
        String r107 = r106.toString();
        Uri.Builder r108 = UriProtector.parse("aweme://search").buildUpon().appendQueryParameter("enter_from", r101.f175072a).appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_ENTER_GROUP_ID, r101.f175078g).appendQueryParameter("group_id", r101.f175079h).appendQueryParameter("search_style", "commodity_center").appendQueryParameter("previous_page", r101.f175075d).appendQueryParameter("transitionType", "1").appendQueryParameter("search_channel", "ecom_order_center");
        if (r110 == false) goto L10;
        String r112 = "1";
    L11:
        Uri.Builder r113 = r108.appendQueryParameter("is_search_button", r112).appendQueryParameter("author_id", r101.f175073b).appendQueryParameter(ECFindSimilarConfig.ENTER_FROM_SECOND, r101.f175076e).appendQueryParameter("middleInfoExtra", r107).appendQueryParameter("need_prefetch", "1").appendQueryParameter("type", "goods").appendQueryParameter("search_entrance_style", r111).appendQueryParameter("needBack2Origin", "1").appendQueryParameter("is_direct_jump", "1").appendQueryParameter("enter_method", r101.f175077f).appendQueryParameter("ecom_scene_id", r101.f175074c);
        if (r103 == false) goto L14;
        r113.appendQueryParameter("keyword", r104);
        r113.appendQueryParameter("displayKeywordID", r105);
    L15:
        String r109 = r101.f175080i;
        if (r109 == null) goto L18;
        r113.appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r109);
    L18:
        String r114 = r113.build().toString();
        p.f48130a.openSchema(com.bytedance.android.ec.sdk.plugin.e.getActivity(r102), r114);
        ps3.b.a(new String[]{"url: " + r114});
        return;
    L14:
        r113.appendQueryParameter("search_hint_word", r104);
        r113.appendQueryParameter("search_hint_word_id", r105);
        goto L15
    L10:
        r112 = "0";
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }
}

package com.bytedance.android.shopping.api.mall.common.tools;

import com.android.ttcjpaysdk.facelive.utils.CJPayUploadVideoUtil;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170442a = 0;

    static {
    }

    public static void a(String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        if (Intrinsics.areEqual(r100, "homepage") == false) goto L6;
        String r104 = "ies_ecommerce_client_homepage_request";
    L9:
        if (r104 != null) goto L11;
        return;
    L11:
        JSONObject r105 = new JSONObject();
        r105.putOpt(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r105.putOpt("status_type", 2);
        r105.putOpt("error_code", CJPayUploadVideoUtil.ERROR_CODE_EXCEPTION);
        r105.putOpt("error_detail", r101);
        r105.putOpt("log_id", r102);
        r105.putOpt(ChameleonOpenTracker.ParamKey.RES_VERSION, String.valueOf(r103));
        AppLogNewUtils.onEventV3(r104, r105);
        return;
    L6:
        if (Intrinsics.areEqual(r100, "favorite_feed") == false) goto L8;
        r104 = "ies_ecommerce_client_favorite_feed_request";
        goto L9
    L8:
        r104 = null;
        goto L9
    }
}

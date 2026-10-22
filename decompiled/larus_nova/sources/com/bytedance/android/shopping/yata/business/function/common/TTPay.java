package com.bytedance.android.shopping.yata.business.function.common;

import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.sva.sdk.utils.InteractConst;
import java.util.LinkedHashMap;
import jta.g;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class TTPay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187579a = 0;

    public static final class a implements IH5PayCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f187580a;

        public a(Function2 r100) {
            this.f187580a = r100;
        }

        @Override // com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback
        public final void onResult(int r100, String r101) {
            this.f187580a.invoke(Integer.valueOf(r100), r101);
            TTCJPayUtils.Companion.getInstance().releaseAll();
        }
    }

    static {
    }

    public static void a(Context r110, JSONObject r111, Function2 r112) {
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        JSONObject r100 = r111.optJSONObject("sdk_info");
        int r101 = r111.optInt("service", -1);
        String r102 = "";
        String r103 = r111.optString("sub_way", "");
        String r104 = r111.optString("ext", SliceInitService.DEFAULT_SWITCH);
        String r105 = r111.optString(AppConstants.BUNDLE_REFERER, "");
        TTCJPayUtils r113 = TTCJPayUtils.Companion.getInstance().setContext(r110);
        ECAppInfoService r114 = ECAppInfoService.f48114e;
        TTCJPayUtils r115 = r113.setAid(r114.getAppId()).setDid(g.d());
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("channel", r114.getChannel());
        r106.put(WsConstants.KEY_INSTALL_ID, g.e());
        TTCJPayUtils r116 = r115.setRiskInfoParams(r106);
        LinkedHashMap r107 = new LinkedHashMap();
        String r117 = r114.getSessionID();
        if (r117 == null) goto L6;
        r102 = r117;
    L6:
        r107.put(InteractConst.INTENT_SESSION_ID, r102);
        TTCJPayUtils r108 = r116.setLoginToken(r107).setObserver(new TTPay$ttpay$1());
        if (r100 == null) goto L9;
        String r118 = r100.toString();
    L10:
        r108.pay(r118, r101, r103, r105, r104, new a(r112));
        return;
    L9:
        r118 = null;
        goto L10
    }
}

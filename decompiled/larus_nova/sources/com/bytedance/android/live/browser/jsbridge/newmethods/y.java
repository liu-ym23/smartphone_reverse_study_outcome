package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "adInfo")
public final class y extends w20.a<w20.f7, w20.g7> {
    public y() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.f7 r102 = (w20.f7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        w20.g7 r103 = new w20.g7();
        JsonObject r104 = new JsonObject();
        JSONObject r105 = com.bytedance.android.livesdk.utils.a3.f158816a;
        if (r105 == null) goto L16;
        String r106 = r102.a();
        String r107 = r102.b();
        if (Intrinsics.areEqual(r106, com.bytedance.android.livesdk.utils.a3.f158817b) == true) goto L7;
    L10:
        boolean r108 = false;
    L11:
        if (r108 == false) goto L16;
        Iterator<String> r109 = r105.keys();
    L14:
        if (r109.hasNext() == false) goto L19;
        String r110 = r109.next();
        r104.addProperty(r110, JSONObjectProtectorUtils.getString(r105, r110));
    L19:
        r103.a(1);
        r103.b(r104);
        finishWithResult(r103);
        return;
    L7:
        if (Intrinsics.areEqual(r107, com.bytedance.android.livesdk.utils.a3.f158818c) == false) goto L10;
        if (r106 == null) goto L10;
        r108 = true;
    L16:
        am2.n r111 = am2.n.f();
        int r112 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r111.c()) == false) goto L19;
        r104.addProperty("is_other_channel", r111.f4315d);
        r104.addProperty("creative_id", r111.c());
        r104.addProperty("log_extra", r111.d());
        r104.addProperty(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE, r111.f4313b);
        r104.addProperty("is_ad_coin", Boolean.valueOf(r111.f4318g));
        r104.addProperty(DbJsonConstants.DBJSON_KEY_TASK_KEY, r111.b());
        goto L19
    }
}

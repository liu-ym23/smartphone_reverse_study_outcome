package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.GetBatchClientSettingsResultModel;
import com.bytedance.android.livesdk.config.bc1;
import com.bytedance.android.livesdk.config.d00;
import com.bytedance.android.livesdk.config.dp;
import com.bytedance.android.livesdk.config.ep;
import com.bytedance.android.livesdk.config.jp;
import com.bytedance.android.livesdk.config.mp;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.l9;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getBatchClientSettings")
public final class v0 extends w20.e1<l9, GetBatchClientSettingsResultModel> {
    public v0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((l9) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetBatchClientSettingsResultModel r102 = new GetBatchClientSettingsResultModel();
        GetBatchClientSettingsResultModel.a r103 = new GetBatchClientSettingsResultModel.a();
        JsonObject r104 = new JsonObject();
        r104.addProperty("new_dynamic_drawer_title_style", com.bytedance.android.livesdk.config.q2.f121024a.getValue());
        r104.add("live_history_pop_config", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), d00.f119992a.getValue()));
        r104.addProperty("live_feed_drawer_concern_list_guide_continued_seconds", com.bytedance.android.livesdk.config.m2.f120726a.getValue());
        r104.add("live_follow_moment_schema", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), com.bytedance.android.livesdk.config.e5.f120090a.getValue()));
        r104.add("live_enable_open_topic", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), uj.f121379a.getValue()));
        r104.add("live_drawer_entrance_key", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), ep.f120144a.getValue()));
        r104.add("live_drawer_need_replace_feed", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), jp.f120542a.getValue()));
        r104.add("feed_drawer_urls", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), mp.f120773a.getValue()));
        r104.add("live_drawer_multi_tab_config", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), dp.f120054a.getValue()));
        r104.add("nearby_tv_drawer_info", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), bc1.f119857a.getValue()));
        Unit r105 = Unit.INSTANCE;
        r103.a(r104);
        r102.b(r103);
        r102.a(GetBatchClientSettingsResultModel.Code.Success);
        finishWithResult(r102);
    }
}

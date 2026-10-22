package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetVisualEventTrackingEditorResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getVisualEventTrackingEditor")
public final class i5 extends w20.x1<JsonObject, GetVisualEventTrackingEditorResultModel> {

    public static final class a {
    }

    static {
    }

    public i5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = r101.getContext().getSharedPreferences("jsb_virtual_event_tracking_debug_settings", 0).getBoolean(EventConstants.ExtraJson.SWITCH_STATUS, false);
        GetVisualEventTrackingEditorResultModel r103 = new GetVisualEventTrackingEditorResultModel();
        r103.a(GetVisualEventTrackingEditorResultModel.Code.Success);
        GetVisualEventTrackingEditorResultModel.a r104 = new GetVisualEventTrackingEditorResultModel.a();
        r104.a(Boolean.valueOf(r102));
        Unit r105 = Unit.INSTANCE;
        r103.b(r104);
        finishWithResult(r103);
    }
}

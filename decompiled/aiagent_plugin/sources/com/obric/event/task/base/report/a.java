package com.obric.event.task.base.report;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: AddIconGuideMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "AddIconGuideMobHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32756a = null;

    static {
        f32756a = new a();
    }

    private a() {
    }

    public static /* synthetic */ void a(a r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "omni_instruction_management";
    L5:
        r0.a(r1);
    }

    public final void a(String r9) {
        d.h.b.o.e(r9, "bannerPosition");
        JSONObject r2 = new JSONObject();
        r2.put("banner_position", r9);
        Loog.INSTANCE.i(TAG, "reportAddIconBannerShow: bannerPosition=" + r9);
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "obric_omni_add_icon_banner_show", r2, false, false, null, 16, null);
    }

    public static /* synthetic */ void a(a r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "omni_instruction_management";
    L5:
        r0.a(r1, r2);
    }

    public final void a(String r9, String r10) {
        d.h.b.o.e(r9, "clickItem");
        d.h.b.o.e(r10, "bannerPosition");
        JSONObject r2 = new JSONObject();
        r2.put("banner_position", r10);
        r2.put("click_item", r9);
        Loog.INSTANCE.i(TAG, "reportAddIconBannerClick: bannerPosition=" + r10 + ", clickItem=" + r9);
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "obric_omni_add_icon_banner_click", r2, false, false, null, 16, null);
    }

    public static /* synthetic */ void b(a r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "confirm_add";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "omni_instruction_management";
    L8:
        r0.b(r1, r2);
    }

    public final void b(String r9, String r10) {
        d.h.b.o.e(r9, "itemName");
        d.h.b.o.e(r10, DBHelper.BATTERY_COL_SOURCE);
        JSONObject r2 = new JSONObject();
        r2.put("item_name", r9);
        r2.put(DBHelper.BATTERY_COL_SOURCE, r10);
        Loog.INSTANCE.i(TAG, "reportAddIconCardItemClick: itemName=" + r9 + ", source=" + r10);
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "obric_omni_add_icon_card_item_click", r2, false, false, null, 16, null);
    }
}

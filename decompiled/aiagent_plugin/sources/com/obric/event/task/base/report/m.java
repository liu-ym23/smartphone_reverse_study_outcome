package com.obric.event.task.base.report;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: PinShortCutMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f32868a = null;

    static {
        f32868a = new m();
    }

    private m() {
    }

    public final void a() {
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "add_launcher_icon", new JSONObject(), false, false, null, 28, null);
    }

    public final void b() {
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "remove_launcher_icon", new JSONObject(), false, false, null, 28, null);
    }

    public final void c() {
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "add_pin_short_cut", new JSONObject(), false, false, null, 28, null);
    }
}

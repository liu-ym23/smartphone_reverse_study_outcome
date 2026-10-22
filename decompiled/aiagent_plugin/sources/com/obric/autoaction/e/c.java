package com.obric.autoaction.e;

import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: MobHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f24681a = null;

    static {
        f24681a = new c();
    }

    private c() {
    }

    public final void a(String r9, int r10, Integer r11, String r12, String r13) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put(KnowledgeActivity.KEY_TASK_ID, r9);
        r2.put("task_mode", r10);
        r2.put(KnowledgeActivity.KEY_TASK_TYPE, r11);
        r2.put("source_from", r12);
        r2.put("execution_mode", r13);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_trigger_task", r2, false, false, null, 28, null);
    }
}

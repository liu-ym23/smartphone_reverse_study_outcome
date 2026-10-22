package com.obric.event.task.base.report;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: ShortcutMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f32869a = null;

    static {
        f32869a = new n();
    }

    private n() {
    }

    public final void a(String r4, String r5, String r6, String r7, String r8, String r9, int r10, String r11, Long r12) {
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();
        r0.put("shortcut_id", r4);
        r0.put("task_mode", r5);
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        r0.put("has_shortcut", !r14);
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        r0.put("instruct", r7);
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r0.put("short_instruct", r6);
        r0.put(DBHelper.BATTERY_COL_SCENE, r8);
        r0.put("enter_from", r9);
        r0.put(MonitorConstants.CODE, r10);
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r0.put("msg", r11);
        if (r12 == null) goto L21;
        r0.put("duration", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue());
    L21:
        r0.put("type", "gui");
        x r15 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "oauto_shortcut_task_update", r0, false, false, null, 28, null);
        return;
    L5:
        if (r13.length() == 0) goto L8;
        r14 = false;
        goto L9
    }

    public final void a(String r11, Integer r12) {
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        if (r11 == null) goto L5;
        r4.put(KnowledgeActivity.KEY_TASK_TYPE, r11);
    L5:
        if (r12 == null) goto L7;
        r4.put("task_mode", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());
    L7:
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_delete_task", r4, false, false, null, 28, null);
    }
}

package com.obric.event.task.base.report;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConditionMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32757a = null;

    private b() {
    }

    static {
        f32757a = new b();
        TAG = "ConditionMobHelper";
    }

    public final void a(f r11, String r12, String r13, String r14, int r15, String r16, Long r17) {
        d.h.b.o.e(r12, DBHelper.BATTERY_COL_SCENE);
        if (r11 != null) goto L5;
        f r5 = new f(null, d.a.p.b(), false);
    L6:
        IAutoActionTrackingApi r6 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        if (r14 == null) goto L9;
        r7.put("enter_from", r14);
    L9:
        r7.put(DBHelper.BATTERY_COL_SCENE, r12);
        PeriodicPolicy r0 = r5.a();
        if (r0 == null) goto L12;
        r7.put("periodic", d.f32758a.a(r0));
    L12:
        f32757a.a(r7, r5.b());
        r7.put("has_knowledge", r5.c());
        if (r13 == null) goto L15;
        r7.put("history_count", r13);
    L15:
        r7.put(MonitorConstants.CODE, r15);
        if (r16 != null) goto L18;
        String r1 = "";
    L19:
        r7.put("msg", r1);
        if (r17 == null) goto L22;
        r7.put("duration", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).longValue());
    L22:
        r7.put("type", "gui");
        x r2 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r6, "condition_task_update", r7, false, false, null, 28, null);
        return;
    L18:
        r1 = r16;
        goto L19
    L5:
        r5 = r11;
        goto L6
    }

    public final void a(ConditionTask r12, String r13) {
        d.h.b.o.e(r13, DBHelper.BATTERY_COL_SCENE);
        if (r12 != null) goto L6;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportConditionTaskUpdateMobFromQuery task empty");
        return;
    L6:
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put(DBHelper.BATTERY_COL_SCENE, r13);
        r5.put("periodic", d.f32758a.a(r12.getPeriodicPolicy()));
        f32757a.a(r5, (List) ZeusTransformUtils.preCheckCast(r12.getConditions().getConditions(), List.class, "com.obric.aiagent.plugin"));
        TaskKnowledge r11 = r12.getTaskKnowledge();
        if (r11 == null) goto L9;
        String r14 = r11.getContent();
    L10:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L13;
    L16:
        boolean r16 = true;
    L17:
        r5.put("has_knowledge", !r16);
        r5.put(MonitorConstants.CODE, 0);
        r5.put("msg", "");
        r5.put("type", DownloadConstants.QUERY_KEY);
        x r17 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "condition_task_update", r5, false, false, null, 28, null);
        return;
    L13:
        if (r15.length() == 0) goto L16;
        r16 = false;
        goto L17
    L9:
        r14 = null;
        goto L10
    }

    public final void a(boolean r11, Long r12) {
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("enable", r11);
        if (r12 == null) goto L5;
        r4.put("duration", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue());
    L5:
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_condition_task_enable_switch", r4, false, false, null, 28, null);
    }

    private final void a(JSONObject r3, List<? extends Condition> r4) {
        List<? extends Condition> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        r3.put("location_condition", d.f32758a.b(r2));     // Catch: Exception -> L5
        r3.put("time_condition", d.f32758a.a(r2));     // Catch: Exception -> L5
        r3.put("wifi_condition", d.f32758a.e(r2));     // Catch: Exception -> L5
        r3.put("battery_condition", d.f32758a.d(r2));     // Catch: Exception -> L5
        r3.put("bluetooth_condition", d.f32758a.f(r2));     // Catch: Exception -> L5
        r3.put("sms_condition", d.f32758a.c(r2));     // Catch: Exception -> L5
        r3.put("storage_condition", d.f32758a.g(r2));     // Catch: Exception -> L5
        r3.put("condition_count", r2.size());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "putConditionReportParams e", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void a(b r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    public final void a(boolean r9, String r10) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("is_success", r9);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r2.put("error_msg", r10);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_condition_task_upgrade", r2, false, false, null, 28, null);
    }

    public final void a(f r9) {
        if (r9 != null) goto L4;
        r9 = new f(null, d.a.p.b(), false);
    L4:
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        PeriodicPolicy r8 = r9.a();
        if (r8 == null) goto L7;
        r2.put("periodic", d.f32758a.a(r8));
    L7:
        List<Condition> r10 = r9.b();
        r2.put("location_condition", d.f32758a.b(r10));
        r2.put("time_condition", d.f32758a.a(r10));
        r2.put("condition_count", r10.size());
        r2.put("has_knowledge", r9.c());
        x r11 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "oauto_condition_task_test_run", r2, false, false, null, 28, null);
    }
}

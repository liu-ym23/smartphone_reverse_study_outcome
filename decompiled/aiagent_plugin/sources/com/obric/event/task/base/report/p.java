package com.obric.event.task.base.report;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.aj;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskPageTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f32888a;

    public p() {
        this.f32888a = new JSONObject();
    }

    public final void a(Intent r5, String r6) {
        d.h.b.o.e(r5, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r6, "pageName");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L12
        p r2 = (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Bundle r7 = r5.getExtras();     // Catch: Throwable -> L12
        String r3 = "{}";
        if (r7 == null) goto L10;
        String r8 = r7.getString("log_extras", "{}");     // Catch: Throwable -> L12
        if (r8 == null) goto L10;
        r3 = r8;
    L10:
        Object r9 = d.n.f(new JSONObject(r3));     // Catch: Throwable -> L12
    L14:
        JSONObject r4 = new JSONObject();
        if (d.n.b(r9) == false) goto L17;
        r9 = r4;
    L17:
        JSONObject r10 = (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.aiagent.plugin");
        this.f32888a = r10;
        r10.put("current_page", r6);
        return;
    L12:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L14
    }

    public final void a(String r10, String r11, String r12, String r13) {
        d.h.b.o.e(r10, "firstModuleType");
        AOBizTracking r0 = AOBizTracking.INSTANCE;
        if (r0 == null) goto L11;
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(r0, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject(this.f32888a.toString());
        r3.put("first_module_type", r10);
        r3.put("session_state", r11);
        if (r12 == null) goto L7;
        r3.put("oauto_timer_task_id", r12);
    L7:
        if (r13 == null) goto L9;
        r3.put("oauto_session_id", r13);
    L9:
        x r9 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, "oauto_module_show", r3, false, false, null, 28, null);
        return;
    }
}

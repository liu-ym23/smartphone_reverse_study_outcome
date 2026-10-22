package com.obric.autoaction.common.ext;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.FragmentExtension;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: FragmentPageReportExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentPageReportExtension extends FragmentExtension<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f24636a;

    public FragmentPageReportExtension(b r3, Fragment r4) {
        o.e(r3, "config");
        o.e(r4, "host");
        super((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // androidx.lifecycle.d
    public void a(p r9) {
        p r10 = (p) ZeusTransformUtils.wrapperContextForParams(r9, p.class, "com.obric.aiagent.plugin");
        o.e(r10, "owner");
        super.a(r10);
        if (((b) ZeusTransformUtils.preCheckCast(a(), b.class, "com.obric.aiagent.plugin")).b() == null) goto L6;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_page_enter", c(), false, false, null, 28, null);
        return;
    }

    @Override // androidx.lifecycle.d
    public void b(p r9) {
        p r10 = (p) ZeusTransformUtils.wrapperContextForParams(r9, p.class, "com.obric.aiagent.plugin");
        o.e(r10, "owner");
        super.b(r10);
        if (((b) ZeusTransformUtils.preCheckCast(a(), b.class, "com.obric.aiagent.plugin")).b() == null) goto L6;
        this.f24636a = System.currentTimeMillis();
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "oauto_page_show", c(), false, false, null, 28, null);
        return;
    }

    @Override // androidx.lifecycle.d
    public void d(p r15) {
        p r16 = (p) ZeusTransformUtils.wrapperContextForParams(r15, p.class, "com.obric.aiagent.plugin");
        o.e(r16, "owner");
        super.d(r16);
        if (((b) ZeusTransformUtils.preCheckCast(a(), b.class, "com.obric.aiagent.plugin")).b() == null) goto L9;
        long r4 = 0;
        if (this.f24636a <= 0) goto L7;
        r4 = System.currentTimeMillis() - this.f24636a;
    L7:
        IAutoActionTrackingApi r6 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r8 = c();
        r8.put("stay_duration", r4);
        x r14 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r6, "oauto_page_leave", r8, false, false, null, 28, null);
        return;
    }

    private final JSONObject c() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L15
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Fragment) ZeusTransformUtils.preCheckCast(((FragmentPageReportExtension) ZeusTransformUtils.preCheckCast(this, FragmentPageReportExtension.class, "com.obric.aiagent.plugin")).b(), Fragment.class, "com.obric.aiagent.plugin")).getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        String r3 = "{}";
        if (r2 == null) goto L13;
        Intent r4 = r2.getIntent();     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        Bundle r5 = r4.getExtras();     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        String r6 = r5.getString("log_extras", "{}");     // Catch: Throwable -> L15
        if (r6 == null) goto L13;
        r3 = r6;
    L13:
        Object r7 = n.f(new JSONObject(r3));     // Catch: Throwable -> L15
    L17:
        JSONObject r8 = new JSONObject();
        if (n.b(r7) == false) goto L20;
        r7 = r8;
    L20:
        JSONObject r9 = (JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin");
        r9.put("current_page", ((b) ZeusTransformUtils.preCheckCast(a(), b.class, "com.obric.aiagent.plugin")).b());
        return r9;
    L15:
        th = move-exception;
        n.a r10 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L17
    }
}

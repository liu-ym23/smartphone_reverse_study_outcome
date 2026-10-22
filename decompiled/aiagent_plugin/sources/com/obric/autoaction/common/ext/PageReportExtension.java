package com.obric.autoaction.common.ext;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.ActivityExtension;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: PageReportExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PageReportExtension extends ActivityExtension<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f24637a;

    public PageReportExtension(b r3, AppCompatActivity r4) {
        AppCompatActivity r5 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r4, AppCompatActivity.class, "com.obric.aiagent.plugin");
        o.e(r3, "config");
        o.e(r5, "host");
        super((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"), r5);
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
        this.f24637a = System.currentTimeMillis();
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
        if (this.f24637a <= 0) goto L7;
        r4 = System.currentTimeMillis() - this.f24637a;
    L7:
        IAutoActionTrackingApi r6 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r8 = c();
        r8.put("stay_duration", r4);
        x r14 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r6, "oauto_page_leave", r8, false, false, null, 28, null);
        return;
    }

    private final JSONObject c() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L12
        Bundle r2 = ((AppCompatActivity) ZeusTransformUtils.preCheckCast(((PageReportExtension) ZeusTransformUtils.preCheckCast(this, PageReportExtension.class, "com.obric.aiagent.plugin")).b(), AppCompatActivity.class, "com.obric.aiagent.plugin")).getIntent().getExtras();     // Catch: Throwable -> L12
        String r3 = "{}";
        if (r2 == null) goto L10;
        String r4 = r2.getString("log_extras", "{}");     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r3 = r4;
    L10:
        Object r5 = n.f(new JSONObject(r3));     // Catch: Throwable -> L12
    L14:
        JSONObject r6 = new JSONObject();
        if (n.b(r5) == false) goto L17;
        r5 = r6;
    L17:
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin");
        r7.put("current_page", ((b) ZeusTransformUtils.preCheckCast(a(), b.class, "com.obric.aiagent.plugin")).b());
        return r7;
    L12:
        th = move-exception;
        n.a r8 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L14
    }
}

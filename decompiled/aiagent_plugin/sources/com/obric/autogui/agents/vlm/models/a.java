package com.obric.autogui.agents.vlm.models;

import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import d.x;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f27234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f27236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27237e;

    public a(String r2, long r3, int r5, long r6, boolean r8) {
        o.e(r2, "stepId");
        this.f27233a = r2;
        this.f27234b = r3;
        this.f27235c = r5;
        this.f27236d = r6;
        this.f27237e = r8;
    }

    public /* synthetic */ a(String r8, long r9, int r11, long r12, boolean r14, int r15, h r16) {
        long r1 = 0;
        if ((r15 & 2) == 0) goto L5;
        long r3 = 0;
    L6:
        boolean r5 = false;
        if ((r15 & 4) == 0) goto L9;
        int r0 = 0;
    L11:
        if ((r15 & 8) != 0) goto L15;
        r1 = r12;
    L15:
        if ((r15 & 16) != 0) goto L18;
        r5 = r14;
    L18:
        this(r8, r3, r0, r1, r5);
        return;
    L9:
        r0 = r11;
        goto L11
    L5:
        r3 = r9;
        goto L6
    }

    public final long a() {
        return this.f27234b;
    }

    public final void a(long r1) {
        this.f27234b = r1;
    }

    public final void a(int r1) {
        this.f27235c = r1;
    }

    public final int b() {
        return this.f27235c;
    }

    public final void b(long r1) {
        this.f27236d = r1;
    }

    public final long c() {
        return this.f27236d;
    }

    public final void a(boolean r1) {
        this.f27237e = r1;
    }

    public final void a(com.obric.autogui.session.a r11, String r12) {
        o.e(r11, "forSession");
        o.e(r12, "stepId");
        if (o.a(r12, this.f27233a) == true) goto L6;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "attempts to upload an untracked stepId=" + r12 + " (cc=" + this.f27235c + ')');
        return;
    L6:
        int r0 = this.f27235c;
        if (r0 != 0) goto L10;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "uploading a step without any request (id=" + r12 + ')');
        return;
    L10:
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("acquire_screenshot_duration", this.f27234b);
        r4.put("request_count", r0);
        r4.put("request_duration", this.f27236d);
        r4.put("request_duration_avg", this.f27236d / ((long) r0));
        r4.put("succeed", this.f27237e);
        r4.put("step_id", r12);
        com.obric.autogui.session.c.b.a(r4, r11);
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "step_exec", r4, false, false, null, 28, null);
    }

    public final Map<String, Object> d() {
        return ao.a(new m[]{s.a("acquire_screenshot_duration", Long.valueOf(this.f27234b)), s.a("request_duration", Long.valueOf(this.f27236d))});
    }
}

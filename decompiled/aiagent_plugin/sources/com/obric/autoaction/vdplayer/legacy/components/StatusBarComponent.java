package com.obric.autoaction.vdplayer.legacy.components;

import android.app.Activity;
import android.content.Context;
import android.view.WindowInsetsController;
import androidx.lifecycle.p;
import com.obric.autoaction.a.f;
import com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: StatusBarComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StatusBarComponent implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IVirtualDisplayApi f25774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.a.c f25775c;

    public static /* synthetic */ x lambda$9rs1yT0Qv447vjbBDHCz0ImM0do(StatusBarComponent r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$sY65RqQv4S_OMnPkanzx1mKhlbk(Activity r0, int r1) {
        a(r0, r1);
    }

    public StatusBarComponent() {
        this.f25773a = "StatusBarComponent";
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r3) {
        o.e(r3, "componentHost");
        this.f25775c = r3;
        this.f25774b = (IVirtualDisplayApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtualDisplayApi.class), IVirtualDisplayApi.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.lifecycle.d
    public void a(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        o.e(r5, "owner");
        super.a(r5);
        IVirtualDisplayApi r6 = this.f25774b;
        if (r6 == null) goto L5;
        r6.registerStatusBarAppearanceListener(new $$Lambda$StatusBarComponent$9rs1yT0Qv447vjbBDHCz0ImM0do(this));
    L5:
        IVirtualDisplayApi r7 = this.f25774b;
        if (r7 == null) goto L8;
        int r8 = r7.getStatusBarAppearance();
    L9:
        com.obric.autoaction.a.c r3 = this.f25775c;
        Activity r0 = null;
        if (r3 == null) goto L12;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L14:
        if (ZeusTransformUtils.instanceOf(r9, Activity.class) == false) goto L16;
        r0 = (Activity) ZeusTransformUtils.preCheckCast(r9, Activity.class, "com.obric.aiagent.plugin");
    L16:
        if (r0 == null) goto L21;
        WindowInsetsController r10 = ZeusTransformUtils.getWindow(r0, "com.obric.aiagent.plugin").getInsetsController();
        if (r10 == null) goto L22;
        r10.setSystemBarsAppearance(r8, 8);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        r9 = null;
        goto L14
    L8:
        r8 = 0;
        goto L9
    }

    private static final x a(StatusBarComponent r3, final int r4) {
        com.obric.autoaction.a.c r5 = r3.f25775c;
        final Activity r0 = null;
        if (r5 == null) goto L5;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == false) goto L9;
        r0 = (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin");
    L9:
        if (r0 == null) goto L11;
        r0.runOnUiThread(new $$Lambda$StatusBarComponent$sY65RqQv4S_OMnPkanzx1mKhlbk(r0, r4));
        return x.f38692a;
    L11:
        return x.f38692a;
    L5:
        r6 = null;
        goto L7
    }

    private static final void a(Activity r2, int r3) {
        WindowInsetsController r4 = ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getInsetsController();
        if (r4 == null) goto L6;
        r4.setSystemBarsAppearance(r3, 8);
        return;
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        IVirtualDisplayApi r2 = this.f25774b;
        if (r2 == null) goto L6;
        r2.registerStatusBarAppearanceListener(null);
        return;
    }
}

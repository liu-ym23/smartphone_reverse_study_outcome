package com.bytedance.bdturing.verify;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.bdturing.VerifyDialog;
import com.bytedance.bdturing.c;
import com.bytedance.bdturing.e;
import com.bytedance.bdturing.setting.g;
import com.bytedance.bdturing.setting.h;
import com.google.protobuf.DescriptorProtos;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: RiskControlService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RiskControlService implements com.bytedance.bdturing.verify.a {
    private VerifyDialog mDialogShowing;

    /* JADX INFO: compiled from: RiskControlService.kt */
    public static final class a implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RiskControlService f6633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.verify.a.a f6634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f6635c;

        /* JADX INFO: renamed from: com.bytedance.bdturing.verify.RiskControlService$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RiskControlService.kt */
        static final class RunnableC0147a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f6636a;

            RunnableC0147a(a r1) {
                this.f6636a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.a();
                RiskControlService.access$setMDialogShowing$p(this.f6636a.f6633a, new VerifyDialog(this.f6636a.f6634b, this.f6636a.f6635c));
                VerifyDialog r0 = RiskControlService.access$getMDialogShowing$p(this.f6636a.f6633a);
                if (r0 == null) goto L5;
                r0.setOnDismissListener((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(new RiskControlService$execute$1$onResponse$1$1(this), DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin"));
            L5:
                VerifyDialog r4 = RiskControlService.access$getMDialogShowing$p(this.f6636a.f6633a);
                if (r4 == null) goto L8;
                r4.show();
            L8:
                e.b();
            }
        }

        a(RiskControlService r3, com.bytedance.bdturing.verify.a.a r4, c r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
            this.f6633a = r3;
            this.f6634b = r4;
            this.f6635c = r6;
        }

        @Override // com.bytedance.bdturing.setting.g.a
        public void a(int r1, String r2, long r3) {
            Activity r4 = ZeusTransformUtils.getActivity(this.f6634b, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
        L7:
            Activity r5 = ZeusTransformUtils.getActivity(this.f6634b, "com.obric.aiagent.plugin");
            if (r5 == null) goto L11;
            r5.runOnUiThread((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC0147a(this), Runnable.class, "com.obric.aiagent.plugin"));
            return;
        L11:
            return;
        L5:
            if (r4.isFinishing() != true) goto L7;
        }
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean isProcess(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 != 2) goto L7;
        return true;
    L7:
        if (r2 != 3) goto L9;
        return true;
    L9:
        if (r2 != 5) goto L11;
        return true;
    L11:
        if (r2 == 12) goto L18;
        return false;
    L18:
        return true;
    }

    public RiskControlService() {
    }

    public static final /* synthetic */ VerifyDialog access$getMDialogShowing$p(RiskControlService r0) {
        return r0.mDialogShowing;
    }

    public static final /* synthetic */ void access$setMDialogShowing$p(RiskControlService r0, VerifyDialog r1) {
        r0.mDialogShowing = r1;
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean execute(com.bytedance.bdturing.verify.a.a r6, c r7) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.aiagent.plugin");
        o.d(r6, Ext.KEY_REQUEST);
        o.d(r8, "callback");
        if (isOnVerify() == false) goto L6;
        com.bytedance.bdturing.g.a("BdTuring", "verifyDialog still showing skip this request");
        r8.a(DescriptorProtos.Edition.EDITION_PROTO2_VALUE, null);
        return true;
    L6:
        h.f6610a.a(false, (g.a) ZeusTransformUtils.preCheckCast(new a(this, r6, r8), g.a.class, "com.obric.aiagent.plugin"));
        return true;
    }

    public final synchronized boolean isOnVerify() {
        monitor-enter(this);
        VerifyDialog r0 = this.mDialogShowing;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        if (r0 != null) goto L7;
        o.a();     // Catch: Throwable -> L13
    L7:
        if (r0.isShowing() == false) goto L10;
        boolean r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L10:
        r1 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final void dismissVerifyDialog() {
        VerifyDialog r0 = this.mDialogShowing;     // Catch: Exception -> L13
        if (r0 == null) goto L17;
        if (r0 != null) goto L7;
        o.a();     // Catch: Exception -> L13
    L7:
        if (r0.isShowing() == false) goto L18;
        VerifyDialog r1 = this.mDialogShowing;     // Catch: Exception -> L13
        if (r1 != null) goto L11;
        o.a();     // Catch: Exception -> L13
    L11:
        r1.dismiss();     // Catch: Exception -> L13
        return;
    L18:
        return;
    L17:
        return;
    L13:
        com.bytedance.bdturing.g.c("BdTuring", "an exception caught in the stage of VerifyDialog dismissing.");
    }
}

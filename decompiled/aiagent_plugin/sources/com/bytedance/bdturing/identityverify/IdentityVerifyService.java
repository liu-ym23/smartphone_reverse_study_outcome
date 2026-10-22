package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.e;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.utils.ActivityLifeCycleObserver;
import com.bytedance.bdturing.verify.a.f;
import com.bytedance.bdturing.verify.a.k;
import com.google.protobuf.DescriptorProtos;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IdentityVerifyService extends ActivityLifeCycleObserver implements com.bytedance.bdturing.verify.a {
    private static final String MSG_SUCCESS = "certificate_success";
    private static final String TAG = "CertifyService";
    private static final String TWO_FACTOR_VERIFY_FLOW = "webcast_risk_auth";
    private boolean isOnVerify;
    private IdentityVerifyDialog mDialog;

    @Override // com.bytedance.bdturing.verify.a
    public boolean isProcess(int r1) {
        if (14 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public IdentityVerifyService() {
    }

    static /* synthetic */ void access$000(IdentityVerifyService r2, Activity r3, com.bytedance.bdturing.verify.a.a r4, com.bytedance.bdturing.c r5) {
        r2.verifyWithDialog((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), r4, (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void access$100(IdentityVerifyService r2, Activity r3, com.bytedance.bdturing.verify.a.a r4, com.bytedance.bdturing.c r5) {
        r2.verifyWithOutDialog((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), r4, (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void access$200(IdentityVerifyService r2, f r3, Activity r4, com.bytedance.bdturing.c r5) {
        r2.doVerify(r3, (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin"), (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void access$300(IdentityVerifyService r0, boolean r1) {
        r0.setVerifySate(r1);
    }

    static /* synthetic */ void access$400(IdentityVerifyService r2, boolean r3, JSONObject r4, com.bytedance.bdturing.c r5) {
        r2.noticeResult(r3, r4, (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean access$500(IdentityVerifyService r0, JSONObject r1, JSONObject r2) {
        return r0.isVerifySuccess(r1, r2);
    }

    static /* synthetic */ void access$600(IdentityVerifyService r0, JSONObject r1, f r2) {
        r0.reportVerifyResult(r1, r2);
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean execute(com.bytedance.bdturing.verify.a.a r7, com.bytedance.bdturing.c r8) {
        final com.bytedance.bdturing.c r9 = (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, k.class) == false) goto L5;
        final com.bytedance.bdturing.verify.a.a r0 = ((k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.aiagent.plugin")).i();
    L7:
        if (r0 != null) goto L9;
    L20:
        JSONObject r6 = new JSONObject();
        com.bytedance.bdturing.utils.c.a(r6, "errorMsg", "request type is not CertifyRequest!");
        r9.a(996, r6);
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L20;
        if (isOnVerify() == false) goto L15;
        r9.a(DescriptorProtos.Edition.EDITION_PROTO2_VALUE, null);
        return true;
    L15:
        final Activity r10 = ZeusTransformUtils.getActivity(r7, "com.obric.aiagent.plugin");
        if (r10 == null) goto L18;
        r10.runOnUiThread(new AnonymousClass1(this, r0, r10, r9));
    L19:
        return true;
    L18:
        g.e(TAG, "topActivity is null");
        JSONObject r11 = new JSONObject();
        com.bytedance.bdturing.utils.c.a(r11, "errorMsg", "topActivity is null");
        noticeResult(false, r11, r9);
        goto L19
    L5:
        r0 = null;
        goto L7
    }

    private void verifyWithOutDialog(Activity r3, com.bytedance.bdturing.verify.a.a r4, com.bytedance.bdturing.c r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        com.bytedance.bdturing.c r7 = (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin");
        e.d(2);     // Catch: Exception -> L5
        setVerifySate(true);     // Catch: Exception -> L5
        doVerify((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"), r6, r7);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        JSONObject r8 = new JSONObject();
        com.bytedance.bdturing.utils.c.a(r8, "errorMsg", "doVerify exception");
        noticeResult(false, r8, r7);
    }

    private void verifyWithDialog(Activity r5, final com.bytedance.bdturing.verify.a.a r6, com.bytedance.bdturing.c r7) {
        final Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        final com.bytedance.bdturing.c r9 = (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin");
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).unregisterActivityLifecycleCallbacks(this);     // Catch: Exception -> L9
        this.mDialog = new IdentityVerifyDialog(r8, new AnonymousClass2(this, r6, r8, r9));     // Catch: Exception -> L9
        if (r8.isFinishing() == false) goto L6;
        return;
    L6:
        if (this.mDialog.isShowing() == true) goto L19;
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks(this);     // Catch: Exception -> L9
        this.mDialog.show();     // Catch: Exception -> L9
        e.d(0);     // Catch: Exception -> L9
        setVerifySate(true);     // Catch: Exception -> L9
        return;
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        e.d(1);
        if (r8 == null) goto L13;
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).unregisterActivityLifecycleCallbacks(this);
    L13:
        if (r9 == null) goto L20;
        JSONObject r4 = new JSONObject();
        com.bytedance.bdturing.utils.c.a(r4, "errorMsg", "hand cert verify fail");
        r9.a(1, r4);
        return;
    }

    private void doVerify(final f r11, Activity r12, com.bytedance.bdturing.c r13) {
        Activity r14 = (Activity) ZeusTransformUtils.wrapperContextForParams(r12, Activity.class, "com.obric.aiagent.plugin");
        final com.bytedance.bdturing.c r15 = (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin");
        String r0 = r11.i();
        String r1 = r11.k();
        String r2 = r11.j();
        g.e(TAG, "===>execute:scene=" + r0 + ":channel=" + r1 + ":flow=" + r2);
        com.bytedance.bdturing.c.b r5 = null;
        if (com.bytedance.bdturing.b.a().b() == null) goto L5;
        a r3 = com.bytedance.bdturing.b.a().b().getIdentityVerifyDepend();
    L7:
        if (r3 != null) goto L25;
        g.a(TAG, "certVerifyDepend is null");
        JSONObject r16 = new JSONObject();
        com.bytedance.bdturing.utils.c.a(r16, "msg", "certVerifyDepend is null");
        noticeResult(false, r16, r15);
        return;
    L25:
        HashMap r8 = new HashMap();     // Catch: Exception -> L21
        r8.put(DBHelper.BATTERY_COL_SCENE, r0);     // Catch: Exception -> L21
        r8.put("flow", r2);     // Catch: Exception -> L21
        r8.put("cert_app_id", com.bytedance.bdturing.b.a().b().getAppId());     // Catch: Exception -> L21
        r8.put("mode", "0");     // Catch: Exception -> L21
        r8.put(DBHelper.BATTERY_COL_SOURCE, r1);     // Catch: Exception -> L21
        r8.put("use_new_api", "true");     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r11.m()) == true) goto L13;
        r8.put("ticket", r11.m());     // Catch: Exception -> L21
    L13:
        if (com.bytedance.bdturing.b.a().b().getRegionType() != BdTuringConfig.b.f6466e) goto L15;
        boolean r4 = true;
    L16:
        c r6 = new c(r14, r8, r4);     // Catch: Exception -> L21
        com.bytedance.bdturing.c.c r17 = com.bytedance.bdturing.b.a().b().getThemeConfig();     // Catch: Exception -> L21
        if (r17 == null) goto L19;
        r5 = r17.b();     // Catch: Exception -> L21
    L19:
        r6.a(r5);     // Catch: Exception -> L21
        r3.a(r6, new AnonymousClass3(this, r15, r11));     // Catch: Exception -> L21
        e.f(0);     // Catch: Exception -> L21
        return;
    L15:
        r4 = false;
    L21:
        e = move-exception;
        e.printStackTrace();
        e.f(1);
        JSONObject r18 = new JSONObject();
        com.bytedance.bdturing.utils.c.a(r18, "msg", "load cert sdk failed");
        noticeResult(false, r18, r15);
        return;
    L5:
        r3 = null;
        goto L7
    }

    private void reportVerifyResult(final JSONObject r3, final f r4) {
        VerifyTaskHandler.a().a(new AnonymousClass4(this, r4, r3));
    }

    private boolean isVerifySuccess(JSONObject r2, JSONObject r3) {
        if (r2 == null) goto L8;
        int r1 = r2.optInt("error_code", -1);
        String r4 = r2.optString("error_msg");
        if (MSG_SUCCESS.equals(r4) == false) goto L7;
        if (r1 != 0) goto L7;
        return true;
    L7:
        com.bytedance.bdturing.utils.c.a(r3, "errorCode", Integer.valueOf(r1));
        com.bytedance.bdturing.utils.c.a(r3, "errorMsg", r4);
    L8:
        return false;
    }

    @Override // com.bytedance.bdturing.utils.ActivityLifeCycleObserver, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        IdentityVerifyDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == true) goto L7;
        return;
    L7:
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mDialog.getOwnerActivity(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) != r5) goto L12;
        setVerifySate(false);
        this.mDialog.dismiss();
        this.mDialog = null;
        return;
    }

    private synchronized void setVerifySate(boolean r1) {
        monitor-enter(this);
        this.isOnVerify = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isOnVerify() {
        monitor-enter(this);
        boolean r0 = this.isOnVerify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void noticeResult(boolean r3, JSONObject r4, com.bytedance.bdturing.c r5) {
        com.bytedance.bdturing.c r6 = (com.bytedance.bdturing.c) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.bdturing.c.class, "com.obric.aiagent.plugin");
        setVerifySate(false);
        this.mDialog = null;
        if (r6 == null) goto L15;
        if (r3 == false) goto L6;
        r6.b(0, new JSONObject());     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r6.a(1, r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}

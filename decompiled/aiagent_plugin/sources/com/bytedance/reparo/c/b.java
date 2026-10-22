package com.bytedance.reparo.c;

import android.app.Application;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.crash.Npth;
import com.bytedance.crash.ac;
import com.bytedance.reparo.IReparoConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CheckedReparoConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends IReparoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IReparoConfig f9105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9107c;

    public b(IReparoConfig r2) {
        this.f9106b = null;
        this.f9107c = -1;
        this.f9105a = r2;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public boolean enable() {
        return this.f9105a.enable();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public Application getApplication() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f9105a.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getUpdateVersionCode() {
        return this.f9105a.getUpdateVersionCode();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getAppId() {
        return this.f9105a.getAppId();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getDeviceId() {
        if (a(this.f9106b) == true) goto L5;
        String r0 = this.f9105a.getDeviceId();
        this.f9106b = r0;
        if (a(r0) == true) goto L12;
        if (Npth.isInit() == false) goto L12;
        this.f9106b = ac.d().a();     // Catch: Throwable -> L16
    L12:
        if (a(this.f9106b) == true) goto L19;
        return "1";
    L19:
        return this.f9106b;
    L5:
        return this.f9106b;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getChannel() {
        if (this.f9107c != (-1)) goto L13;
    L11:
        this.f9107c = 0;
        goto L13
    L6:
        if (TextUtils.isEmpty(Settings.Global.getString(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver(), "bytest_automation_info")) == false) goto L8;
        int r0 = 0;
    L9:
        this.f9107c = r0;     // Catch: Throwable -> L11
        goto L13
    L8:
        r0 = 1;
    L13:
        if (this.f9107c != 1) goto L16;
        return "reparo_test";
    L16:
        return this.f9105a.getChannel();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String executePatchRequest(int r1, String r2, byte[] r3, String r4) {
        return this.f9105a.executePatchRequest(r1, r2, r3, r4);
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public boolean isMainProcess() {
        return this.f9105a.isMainProcess();
    }

    public static boolean a(String r1) {
        if (r1 != null) goto L4;
    L10:
        return false;
    L4:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if ("0".equals(r1) == true) goto L10;
        if ("1".equals(r1) == true) goto L10;
        return true;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public com.bytedance.reparo.core.g.a getAbiHelper(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        return this.f9105a.getAbiHelper(r4);
    }
}

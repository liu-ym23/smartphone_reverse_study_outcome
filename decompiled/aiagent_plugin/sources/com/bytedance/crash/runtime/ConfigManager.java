package com.bytedance.crash.runtime;

import com.bytedance.crash.config.f;
import com.bytedance.crash.config.h;
import com.bytedance.crash.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ConfigManager {
    private boolean mEnsureEnable;

    public ConfigManager() {
        this.mEnsureEnable = true;
    }

    public void setLaunchCrashUrl(String r1) {
        f.a().a(r1);
    }

    public void setNativeCrashUrl(String r1) {
        f.a().b(r1);
    }

    public void setDefaultAnrCheckInterval(long r1) {
        h.a(r1);
    }

    public long getDefaultAnrCheckInterval() {
        return h.a();
    }

    public void setAlogUploadUrl(String r1) {
        f.a().c(r1);
    }

    public void setConfigGetUrl(String r1) {
        f.a().e(r1);
    }

    public boolean isReportErrorEnable() {
        return h.h();
    }

    public void setReportErrorEnable(boolean r1) {
        h.b(r1);
    }

    public void setJavaCrashUploadUrl(String r1) {
        f.a().d(r1);
    }

    public void setLaunchCrashInterval(long r1) {
        h.b(r1);
    }

    public void setEnsureEnable(boolean r1) {
        h.c(r1);
    }

    public void setCurrentProcessName(String r1) {
        com.bytedance.crash.o.b.a(r1);
    }

    public void setEncryptImpl(o r2) {
        o r1 = (o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        h.a(r1);
        return;
    }

    public boolean isDebugMode() {
        return h.d();
    }

    public void setDebugMode(boolean r1) {
        h.a(r1);
    }

    public boolean isEnsureEnable() {
        if (h.i() == true) goto L5;
        return false;
    L5:
        com.bytedance.crash.monitor.a r1 = com.bytedance.crash.monitor.h.a();
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.c().b();
    }

    public String getAlogUploadUrl() {
        f.a();
        return f.m();
    }

    public String getNativeCrashUploadUrl() {
        return f.d();
    }
}

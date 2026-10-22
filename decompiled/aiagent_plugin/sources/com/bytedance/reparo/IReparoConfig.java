package com.bytedance.reparo;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class IReparoConfig {
    public boolean autoFailThenSyncMode() {
        return false;
    }

    public boolean autoFetchPatch() {
        return false;
    }

    public abstract boolean enable();

    public abstract String executePatchRequest(int r1, String r2, byte[] r3, String r4);

    public abstract String getAppId();

    public abstract Application getApplication();

    public abstract String getChannel();

    public abstract String getDeviceId();

    public abstract String getUpdateVersionCode();

    public abstract boolean isMainProcess();

    public IReparoConfig() {
    }

    public com.bytedance.reparo.core.g.a getAbiHelper(Application r2) {
        return new com.bytedance.reparo.core.g.b((Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin"));
    }
}

package com.obric.autogui.common.api.configs;

import com.obric.autogui.common.a.a.a;
import com.ss.android.ugc.aweme.framework.services.DynamicProxy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AutoActionConfigs.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionConfigs implements a {
    public static final AutoActionConfigs INSTANCE = null;

    static {
        INSTANCE = new AutoActionConfigs();
    }

    private AutoActionConfigs() {
    }

    @Override // com.obric.autogui.common.a.a.a
    public long getVersion() {
        a r2 = acquireRepo();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getVersion();
    }

    @Override // com.obric.autogui.common.a.a.a
    public String getStringCfg(String r2) {
        o.e(r2, "key");
        a r1 = acquireRepo();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getStringCfg(r2);
    }

    @Override // com.obric.autogui.common.a.a.a
    public boolean getBooleanCfg(String r2, boolean r3) {
        o.e(r2, "key");
        a r1 = acquireRepo();
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1.getBooleanCfg(r2, r3);
    }

    @Override // com.obric.autogui.common.a.a.a
    public int getIntCfg(String r2, int r3) {
        o.e(r2, "key");
        a r1 = acquireRepo();
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1.getIntCfg(r2, r3);
    }

    @Override // com.obric.autogui.common.a.a.a
    public long getLongCfg(String r2, long r3) {
        o.e(r2, "key");
        a r1 = acquireRepo();
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1.getLongCfg(r2, r3);
    }

    @Override // com.obric.autogui.common.a.a.a
    public List<?> getListCfg(String r2) {
        o.e(r2, "key");
        a r1 = acquireRepo();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getListCfg(r2);
    }

    private final a acquireRepo() {
        IAutoActionConfigsApi r2 = (IAutoActionConfigsApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionConfigsApi.class), IAutoActionConfigsApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        a r3 = r2.getRepo();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, DynamicProxy.class) == true) goto L11;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return null;
    L5:
        r3 = null;
        goto L7
    }
}

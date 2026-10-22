package com.obric.autogui.net.ttnet;

import android.content.Context;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.net.ttnet.b.f;
import com.obric.autogui.tools.api.net.IAutoActionNetApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TTNetNetworkApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TTNetNetworkApiImpl implements IAutoActionNetApi {
    private final com.obric.autogui.tools.api.net.a mClient;

    @Override // com.obric.autogui.tools.api.net.IAutoActionNetApi
    public void initNet(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
    }

    public TTNetNetworkApiImpl() {
        this.mClient = (com.obric.autogui.tools.api.net.a) ZeusTransformUtils.preCheckCast(new b(), com.obric.autogui.tools.api.net.a.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "I am TTNet!");
    }

    @Override // com.obric.autogui.tools.api.net.IAutoActionNetApi
    public com.obric.autogui.tools.api.net.a obtainHttpClient() {
        return this.mClient;
    }

    @Override // com.obric.autogui.tools.api.net.IAutoActionNetApi
    public void addTimeoutConfig(String r1, long r2) {
        o.e(r1, "forUrl");
        f.f29233a.a(r1, r2);
    }
}

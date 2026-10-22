package com.obric.autogui.net.status;

import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.tools.api.net.IAutoActionNetStatusApi;
import com.obric.utilsLib.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ObricNetStatusImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ObricNetStatusImpl implements IAutoActionNetStatusApi {
    public ObricNetStatusImpl() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        isInternetConnected(r0);
        return;
    }

    @Override // com.obric.autogui.tools.api.net.IAutoActionNetStatusApi
    public boolean isInternetConnected(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return b.b(r1);
    }
}

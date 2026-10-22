package com.obric.autogui.session.state;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.tools.api.net.IAutoActionNetStatusApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOStateCheckingTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "AO-State-Chk";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f31395a = null;

    static {
        f31395a = new c();
    }

    private c() {
    }

    public final Object a(d.c.d<? super com.obric.autogui.common.e> r2) {
        d.c.d<? super com.obric.autogui.common.e> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.session.state.a.b.f31222a.checkNetworkLinkage(r1);
    }

    public final com.obric.autogui.common.e a() {
        IAutoActionNetStatusApi r8 = (IAutoActionNetStatusApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionNetStatusApi.class), IAutoActionNetStatusApi.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L6;
        Loog.INSTANCE.e(TAG, "NetStatus API is null.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L6:
        Application r6 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.f31396a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        Loog.INSTANCE.e(TAG, "appContext is null.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L11:
        if (r8.isInternetConnected((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin")) == true) goto L15;
        Loog.INSTANCE.e(TAG, " - network is not available.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_network_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_network_error"), null, 2, null);
    L15:
        return com.obric.autogui.common.e.f29014b.a();
    }
}

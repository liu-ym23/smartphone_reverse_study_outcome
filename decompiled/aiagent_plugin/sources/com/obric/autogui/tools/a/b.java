package com.obric.autogui.tools.a;

import com.obric.autogui.tools.api.net.push.IAutoActionPushApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AOPush.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31481a = null;

    static {
        f31481a = new b();
    }

    private b() {
    }

    public final void a(com.obric.autogui.tools.api.net.push.a r3) {
        com.obric.autogui.tools.api.net.push.a r4 = (com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "callback");
        IAutoActionPushApi r2 = a();
        if (r2 == null) goto L6;
        r2.registerPushMessageCallback(r4);
        return;
    }

    public final void b(com.obric.autogui.tools.api.net.push.a r3) {
        com.obric.autogui.tools.api.net.push.a r4 = (com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "callback");
        IAutoActionPushApi r2 = a();
        if (r2 == null) goto L6;
        r2.unregisterPushMessageCallback(r4);
        return;
    }

    private final IAutoActionPushApi a() {
        IAutoActionPushApi r2 = (IAutoActionPushApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPushApi.class), IAutoActionPushApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return null;
    }
}

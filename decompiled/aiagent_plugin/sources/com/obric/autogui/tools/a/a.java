package com.obric.autogui.tools.a;

import com.obric.autogui.tools.api.net.IAutoActionNetApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AONetInterface.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31480a = null;

    static {
        f31480a = new a();
    }

    private a() {
    }

    private final IAutoActionNetApi b() {
        IAutoActionNetApi r2 = (IAutoActionNetApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionNetApi.class), IAutoActionNetApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return null;
    }

    public final com.obric.autogui.tools.api.net.a a() {
        IAutoActionNetApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.obtainHttpClient();
    }
}

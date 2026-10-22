package com.obric.aiagent.plugin_impl.autoaction.app;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin_api.autoaction.app.HostResProvider;
import com.obric.autogui.common.api.app.IAutoActionHostResProvider;
import com.volcengine.zeus.ComponentManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.HashMap;

/* JADX INFO: compiled from: AutoActionHostResProviderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoActionHostResProviderImpl implements IAutoActionHostResProvider {
    public static final a Companion = null;
    private static final String TAG = "AutoActionHostResProviderImpl";

    /* JADX INFO: compiled from: AutoActionHostResProviderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoActionHostResProviderImpl() {
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostResProvider
    public int getAppIconRes() {
        return HostResProvider.getAppIconRes();
    }

    @Override // com.obric.autogui.common.api.app.IAutoActionHostResProvider
    public String getStubActivityName(String r6) {
        o.e(r6, "pluginActivityName");
        HashMap r1 = ComponentManager.targetString2StubActivity;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get(r6), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L7:
        ILogDepend.Companion.d(TAG, "getStubActivityName success, pluginActivityName: " + r6 + ", stubActivityName: " + r2);     // Catch: Throwable -> L9
        return r2;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "getStubActivityName failed", th);
        return null;
    }
}

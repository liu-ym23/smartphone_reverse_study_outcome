package com.obric.autogui.platforms.tools.security;

import android.content.ComponentName;
import android.content.Context;
import com.obric.aiagent.privacy_sec.IPrivacy;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BaseSecurityApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements IAutoActionSecurityApi {
    private static final String TAG = "Std/SecurityApi";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0822a f30525b = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.security.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseSecurityApiImpl.kt */
    public static final class C0822a {
        public /* synthetic */ C0822a(h r1) {
            this();
        }

        private C0822a() {
        }
    }

    static {
        f30525b = new C0822a(null);
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public IAutoActionSecurityApi.PageOperationPolicy acquirePageOperationPolicy(Context r2, ComponentName r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, "topComponent");
        return null;
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public IAutoActionSecurityApi.PermissionStrategy acquirePermissionStrategy(DisplayedAppInfo r2) {
        o.e((DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r2, DisplayedAppInfo.class, "com.obric.aiagent.plugin"), "topApp");
        return null;
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public IAutoActionSecurityApi.SensitiveOperation acquireSensitiveOperation(Context r2, ComponentName r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r3, "topComponent");
        return null;
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public boolean checkSensitiveWord(String r1) {
        o.e(r1, "content");
        return true;
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public Object checkVirus(String r3, d.c.d<? super Boolean> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a() {
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public com.obric.autogui.common.e checkPrompt(String r1) {
        o.e(r1, Params.PROMPT);
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public String makeAttestationString(String r4, String r5) {
        o.e(r4, "name");
        o.e(r5, "content");
        IPrivacy r1 = (IPrivacy) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacy.class), IPrivacy.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.getPemCertChain(r4, r5);
    L12:
        return null;
    L7:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "MakeAttestationString -> Failed (" + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    static /* synthetic */ Object a(a r0, String r1, d.c.d<? super Boolean> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.c.b.a.b.a(false);
    }
}

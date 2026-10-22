package com.obric.init.task.comon;

import android.app.Application;
import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.security.IAiAgentSecurityService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitMsSdkServiceSdk.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitMsSdkServiceSdk implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_MS_SDK_SERVICE";

    /* JADX INFO: compiled from: InitMsSdkServiceSdk.kt */
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

    public InitMsSdkServiceSdk() {
    }

    @Override // java.lang.Runnable
    public void run() {
        IAiAgentSecurityService r3 = (IAiAgentSecurityService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAiAgentSecurityService.class), IAiAgentSecurityService.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.msInit((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    }
}

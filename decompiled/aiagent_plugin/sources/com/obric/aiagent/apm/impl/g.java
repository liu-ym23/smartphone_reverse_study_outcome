package com.obric.aiagent.apm.impl;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.reparo.IReparoConfig;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.init.task.comon.InitRepatoTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: RepatoInitImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f16116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f16117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f16118c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f f16119d = null;

    /* JADX INFO: compiled from: RepatoInitImpl.kt */
    public static final class a extends IReparoConfig {
        @Override // com.bytedance.reparo.IReparoConfig
        public boolean enable() {
            return true;
        }

        a() {
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public Application getApplication() {
            return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public String getUpdateVersionCode() {
            String r1 = String.valueOf(IAppContext.Companion.getUpdateVersionCode());
            o.c(r1, "valueOf(...)");
            return r1;
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public String getAppId() {
            return String.valueOf(IAppContext.Companion.getAppId());
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public String getDeviceId() {
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L5;
            String r3 = r2.getFlowDid();
        L6:
            if (r3 != null) goto L9;
            return "";
        L9:
            return r3;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public String getChannel() {
            return IAppContext.Companion.getBuildChannel();
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public String executePatchRequest(int r2, String r3, byte[] r4, String r5) {
            o.e(r3, "url");
            o.e(r4, "localPatchInfoBytes");
            o.e(r5, "contentType");
            return com.ss.android.common.util.d.a(r2, a(r3), r4, i.a.f6731b, r5);
        }

        private final String a(String r5) {
            Uri.Builder r6 = Uri.parse(r5).buildUpon();
            r6.appendQueryParameter("device_id", getDeviceId()).appendQueryParameter("channel", getChannel()).appendQueryParameter(WsConstants.KEY_APP_ID, getAppId()).appendQueryParameter("device_platform", "android").appendQueryParameter(RomInfo.KEY_ROM_OS_API, String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("update_version_code", getUpdateVersionCode());
            String r4 = Build.VERSION.RELEASE;     // Catch: Exception -> L10
            if (r4 != null) goto L6;
        L8:
            r6.appendQueryParameter(RomInfo.KEY_ROM_OS_VERSION, r4);     // Catch: Exception -> L10
        L12:
            String r7 = r6.build().toString();
            o.c(r7, "toString(...)");
            return r7;
        L6:
            if (r4.length() <= 10) goto L8;
            r4 = r4.substring(0, 10);     // Catch: Exception -> L10
            o.c(r4, "substring(...)");     // Catch: Exception -> L10
        L10:
            e = move-exception;
            ILogDepend.Companion.e(InitRepatoTask.ID, e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L12
        }

        @Override // com.bytedance.reparo.IReparoConfig
        public boolean isMainProcess() {
            return IRuntimeContext.Companion.isMainProcess();
        }
    }

    /* JADX INFO: renamed from: lambda$A44grGlS-nAGIRswfzY2D4h5yVs, reason: not valid java name */
    public static /* synthetic */ void m117lambda$A44grGlSnAGIRswfzY2D4h5yVs() {
        g();
    }

    public static /* synthetic */ Runnable lambda$KxC5EIbTEZmbDvkHsPNor8vAxGk() {
        return h();
    }

    public static /* synthetic */ Handler lambda$a4dGkAm3mxeEvSf2b291Mx4MxlU() {
        return f();
    }

    private g() {
    }

    static {
        f16116a = new g();
        f16117b = 60000;
        f16118c = d.g.a($$Lambda$g$a4dGkAm3mxeEvSf2b291Mx4MxlU.INSTANCE);
        f16119d = d.g.a($$Lambda$g$KxC5EIbTEZmbDvkHsPNor8vAxGk.INSTANCE);
    }

    private final Handler b() {
        return (Handler) ZeusTransformUtils.preCheckCast(f16118c.b(), Handler.class, "com.obric.aiagent.plugin");
    }

    private static final Handler f() {
        return new Handler(Looper.getMainLooper());
    }

    private final Runnable c() {
        return (Runnable) ZeusTransformUtils.preCheckCast(f16119d.b(), Runnable.class, "com.obric.aiagent.plugin");
    }

    private static final Runnable h() {
        return $$Lambda$g$A44grGlSnAGIRswfzY2D4h5yVs.INSTANCE;
    }

    private static final void g() {
        com.bytedance.reparo.g.a().c();
        g r0 = f16116a;
        r0.b().postDelayed(r0.c(), f16117b);
    }

    public final void a() {
        com.bytedance.reparo.g.a().a(d());
        e();
    }

    private final IReparoConfig d() {
        return (IReparoConfig) ZeusTransformUtils.preCheckCast(new a(), IReparoConfig.class, "com.obric.aiagent.plugin");
    }

    private final void e() {
        com.bytedance.reparo.g.a().a(f16117b);
        com.bytedance.reparo.g.a().c();
        b().postDelayed(c(), f16117b);
    }
}

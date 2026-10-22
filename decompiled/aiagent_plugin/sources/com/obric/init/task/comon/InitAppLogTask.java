package com.obric.init.task.comon;

import android.app.Application;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.applog.ICommonParams;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.obric.aiagent.platform.utils.PriorityConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: InitAppLogTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitAppLogTask implements IInitTask {
    public static final b Companion = null;
    private static final String DEBUG_KEY = "applog.debug";
    public static final String ID = "INIT_APPLOG_TASK";

    /* JADX INFO: compiled from: InitAppLogTask.kt */
    public static final class a extends PriorityConfig<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33251a;

        /* JADX INFO: renamed from: lambda$Az1gfoHEthKFyvgSQY-_2Nt_JQ8, reason: not valid java name */
        public static /* synthetic */ Boolean m947lambda$Az1gfoHEthKFyvgSQY_2Nt_JQ8() {
            return a();
        }

        public a() {
            super(Boolean.valueOf(IAppContext.Companion.isDebug()));
            this.f33251a = "AppLogDebugConfig";
            addDefaultValue(false);
            addByDefault($$Lambda$InitAppLogTask$a$Az1gfoHEthKFyvgSQY_2Nt_JQ8.INSTANCE);
            PriorityConfig.addBySystemDebug$default((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin"), IAppContext.Companion.getPackageName() + ".applog.debug", false, 2, null);
        }

        @Override // com.obric.aiagent.platform.utils.PriorityConfig
        public String getTag() {
            return this.f33251a;
        }

        private static final Boolean a() {
            Boolean r0 = Boolean.valueOf(!IAppContext.Companion.isReleaseChannel());
            if (r0.booleanValue() == true) goto L7;
            return null;
        L7:
            return r0;
        }
    }

    /* JADX INFO: compiled from: InitAppLogTask.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    static {
        Companion = new b(null);
    }

    public static /* synthetic */ x lambda$qq3WHRyUM4JRyT4gRu0e__zhb9I(String r0, String r1, String r2) {
        return run$lambda$0(r0, r1, r2);
    }

    public InitAppLogTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ILogDepend.Companion.i(ID, "prepare AppLog init, oldAppId=773565, iAppContextAid=" + IAppContext.Companion.getAppId() + ", channel=" + IAppContext.Companion.getBuildChannel());
        IAppLog r0 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.init(new com.obric.aiagent.applog.a(773565, IAppContext.Companion.getAppName(), IAppContext.Companion.getManifestVersionCode(), IAppContext.Companion.getManifestVersionName(), IAppContext.Companion.getUpdateVersionCode(), IAppContext.Companion.getBuildChannel(), false, ((Boolean) ZeusTransformUtils.preCheckCast(new a().get(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), false, false, false, false, false, 0, 0, 0, false, false, false, 524032, null));
    L5:
        ILogDepend.Companion.i(ID, "AppLog init done, using appid = 773565");
        ILogDepend.Companion.i(ID, "run");
        com.obric.aiagent.utils.a.a.f22293a.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        ICommonParams r1 = (ICommonParams) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICommonParams.class), ICommonParams.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        r1.init();
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(ITraceDepend.Companion.getDeviceId(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        ISecureLogDepend.Companion.i(ID, "AppLog did=" + ITraceDepend.Companion.getDeviceId());
        return;
    L14:
        ITraceDepend.Companion.awaitTraceId($$Lambda$InitAppLogTask$qq3WHRyUM4JRyT4gRu0e__zhb9I.INSTANCE);
        return;
    L11:
        r2 = false;
        goto L12
    }

    private static final x run$lambda$0(String r1, String r2, String r3) {
        o.e(r1, "did");
        o.e(r2, "<unused var>");
        o.e(r3, "<unused var>");
        ISecureLogDepend.Companion.i(ID, "AppLog did=" + r1);
        return x.f38692a;
    }
}

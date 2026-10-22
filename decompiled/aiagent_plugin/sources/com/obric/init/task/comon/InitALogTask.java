package com.obric.init.task.comon;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.apm.IApm;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.platform.utils.PriorityConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: InitALogTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitALogTask implements IInitTask {
    public static final c Companion = null;
    private static final String DEBUG_KEY = "alog.debug";
    public static final String ID = "INIT_ALOG_TASK";
    private static final String LEVEL_KEY = "alog.level";

    /* JADX INFO: compiled from: InitALogTask.kt */
    public static final class a extends PriorityConfig<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33249a;

        /* JADX INFO: renamed from: lambda$dd8eDNYZ-vJhCRc4r0NCVwwlghY, reason: not valid java name */
        public static /* synthetic */ Boolean m946lambda$dd8eDNYZvJhCRc4r0NCVwwlghY() {
            return a();
        }

        public a() {
            super(Boolean.valueOf(IAppContext.Companion.isDebug()));
            this.f33249a = "ALogDebugConfig";
            addDefaultValue(false);
            addByDefault($$Lambda$InitALogTask$a$dd8eDNYZvJhCRc4r0NCVwwlghY.INSTANCE);
            PriorityConfig.addBySystemDebug$default((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin"), IAppContext.Companion.getPackageName() + ".alog.debug", false, 2, null);
        }

        @Override // com.obric.aiagent.platform.utils.PriorityConfig
        public String getTag() {
            return this.f33249a;
        }

        private static final Boolean a() {
            Boolean r0 = Boolean.valueOf(!IAppContext.Companion.isReleaseChannel());
            if (r0.booleanValue() == true) goto L7;
            return null;
        L7:
            return r0;
        }
    }

    /* JADX INFO: compiled from: InitALogTask.kt */
    public static final class b extends PriorityConfig<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33250a;

        public b() {
            super(0);
            this.f33250a = "ALogLevelConfig";
            addDefaultValue(4);
            PriorityConfig.addBySystemDebug$default((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin"), IAppContext.Companion.getPackageName() + ".alog.level", false, 2, null);
        }

        @Override // com.obric.aiagent.platform.utils.PriorityConfig
        public String getTag() {
            return this.f33250a;
        }
    }

    /* JADX INFO: compiled from: InitALogTask.kt */
    public static final class c {
        public /* synthetic */ c(h r1) {
            this();
        }

        private c() {
        }
    }

    static {
        Companion = new c(null);
    }

    public InitALogTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ILogDepend.Companion.i(ID, "run");
        ISysLogDepend.Companion.i(ID, "run");
        IApm r5 = (IApm) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IApm.class), IApm.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.initLog(new com.obric.aiagent.apm.a(((Boolean) ZeusTransformUtils.preCheckCast(new a().get(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), ((Number) ZeusTransformUtils.preCheckCast(new b().get(), Number.class, "com.obric.aiagent.plugin")).intValue(), 30));
        return;
    }
}

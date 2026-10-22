package com.obric.init.task.comon;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.utils.PriorityConfig;
import com.obric.aiagent.ttnet.ITTNet;
import com.obric.aiagent.ttnet.e;
import com.obric.aiagent.ttnet.g;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.h;
import d.o.o;
import d.x;
import java.util.Set;

/* JADX INFO: compiled from: InitTtNetTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitTtNetTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_TTNET_TASK";
    private static final String OAUTO_2B5_PATH = "/api/v1/chat/completions";
    private static final String OAUTO_URL_PREFIX = null;
    private static final String RESTRICT_ALLOWS_KEY = "ttnet.restrict.allows";
    private static final String RESTRICT_DEBUG_KEY = "ttnet.restrict.debug";
    private static final String RESTRICT_DURATION_KEY = "ttnet.restrict.duration";
    private static final String SKILL_STORE_API_URL_PATTERN = "^https?://[^/]+/assistant/skills_store/api(?:/|\\?|$).*";
    private static final String SKILL_STORE_CLI_ARTIFACT_URL_PATTERN = "^https://[^/]+-skills-store-sign\\.oceancloudapi\\.com/ocean-skills-store-bucket/cli-binaries(?:/|\\?|$).*";
    private static final String ZEUS_RESOURCE_HOST = "zeus-api.obriccloud.com";

    /* JADX INFO: compiled from: InitTtNetTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: InitTtNetTask.kt */
    public static final class b extends PriorityConfig<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33252a;

        public b() {
            super("");
            this.f33252a = "RequestRestrictAllowUserConfig";
            PriorityConfig.addBySystemDebug$default((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin"), IAppContext.Companion.getPackageName() + ".ttnet.restrict.allows", false, 2, null);
        }

        @Override // com.obric.aiagent.platform.utils.PriorityConfig
        public String getTag() {
            return this.f33252a;
        }
    }

    /* JADX INFO: compiled from: InitTtNetTask.kt */
    public static final class c extends PriorityConfig<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33253a;

        public static /* synthetic */ Boolean lambda$5Y_UD4BKC166viJjJhYlQ6W9lp4() {
            return a();
        }

        public c() {
            super(Boolean.valueOf(IAppContext.Companion.isDebug()));
            this.f33253a = "RequestRestrictDebugConfig";
            addDefaultValue(false);
            addByDefault($$Lambda$InitTtNetTask$c$5Y_UD4BKC166viJjJhYlQ6W9lp4.INSTANCE);
            PriorityConfig.addBySystemDebug$default((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin"), IAppContext.Companion.getPackageName() + ".ttnet.restrict.debug", false, 2, null);
        }

        @Override // com.obric.aiagent.platform.utils.PriorityConfig
        public String getTag() {
            return this.f33253a;
        }

        private static final Boolean a() {
            Boolean r0 = Boolean.valueOf(!IAppContext.Companion.isReleaseChannel());
            if (r0.booleanValue() == true) goto L7;
            return null;
        L7:
            return r0;
        }
    }

    /* JADX INFO: compiled from: InitTtNetTask.kt */
    public static final class d extends PriorityConfig<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33254a;

        public d() {
            super(180000L);
            this.f33254a = "RequestRestrictDurationConfig";
            PriorityConfig.addBySystemDebug$default((PriorityConfig) ZeusTransformUtils.preCheckCast(this, PriorityConfig.class, "com.obric.aiagent.plugin"), IAppContext.Companion.getPackageName() + ".ttnet.restrict.duration", false, 2, null);
        }

        @Override // com.obric.aiagent.platform.utils.PriorityConfig
        public String getTag() {
            return this.f33254a;
        }
    }

    public InitTtNetTask() {
    }

    static {
        Companion = new a(null);
        OAUTO_URL_PREFIX = com.obric.aiagent.product.a.a.f18769a.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        ILogDepend.Companion.i(ID, "run");
        ITTNet r13 = (ITTNet) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNet.class), ITTNet.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
        return;
    L5:
        if (IAppContext.Companion.isDebug() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        g r0 = new g(r2, com.obric.aiagent.ttnet.a.a.f22200a.a(), com.obric.aiagent.ttnet.a.a.f22200a.b(), true);
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(new c().get(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(new d().get(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Set r7 = p.q((Iterable) ZeusTransformUtils.preCheckCast(o.b((CharSequence) ZeusTransformUtils.preCheckCast(new b().get(), CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.ttnet.d r1 = new com.obric.aiagent.ttnet.d();
        r1.c('^' + OAUTO_URL_PREFIX + ".*");
        r1.b(OAUTO_2B5_PATH);
        r1.c(SKILL_STORE_API_URL_PATTERN);
        r1.c(SKILL_STORE_CLI_ARTIFACT_URL_PATTERN);
        r1.a(ZEUS_RESOURCE_HOST);
        x r3 = x.f38692a;
        r13.init(r0, new e(r4, r5, r7, ax.a(r1)));
        return;
    L7:
        if (IAppContext.Companion.isReleaseChannel() == false) goto L10;
        r2 = false;
        goto L11
    }
}

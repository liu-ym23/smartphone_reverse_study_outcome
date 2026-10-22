package com.obric.aiagent.platform;

import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.IBuildContext;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: IAIAgentPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAIAgentPlatform {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IAIAgentPlatform.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Map<String, Object> commons = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            commons = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        }

        public final void setCommonParams(String r1, Object r2) {
            o.e(r1, "key");
            o.e(r2, "obj");
            commons.put(r1, r2);
        }

        public final Object getCommonParams(String r1) {
            o.e(r1, "key");
            return commons.get(r1);
        }
    }

    /* JADX INFO: compiled from: IAIAgentPlatform.kt */
    public static final class DefaultImpls {
        public static IAppContext getAppContext(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static IBuildContext getBuildContext(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static ICloudConfig getCloudConfig(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static ILogDepend getLogger(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static IRuntimeContext getRuntimeContext(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static ISecureLogDepend getSecureLogger(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static ISysLogDepend getSysLogger(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }

        public static ITraceDepend getTracer(IAIAgentPlatform r2) {
            IAIAgentPlatform r3 = (IAIAgentPlatform) ZeusTransformUtils.wrapperContextForParams(r2, IAIAgentPlatform.class, "com.obric.aiagent.plugin");
            return null;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    IAppContext getAppContext();

    IBuildContext getBuildContext();

    ICloudConfig getCloudConfig();

    ILogDepend getLogger();

    IRuntimeContext getRuntimeContext();

    ISecureLogDepend getSecureLogger();

    ISysLogDepend getSysLogger();

    ITraceDepend getTracer();
}

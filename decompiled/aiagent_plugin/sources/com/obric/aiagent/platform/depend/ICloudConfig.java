package com.obric.aiagent.platform.depend;

import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: ICloudConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ICloudConfig {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ICloudConfig.kt */
    public static final class Companion implements ICloudConfig {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final f<ICloudConfig> impl$delegate = null;

        public static /* synthetic */ ICloudConfig lambda$Tdn_0DLOybLS3z8vpPUkNsR51Wo() {
            return impl_delegate$lambda$0();
        }

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            impl$delegate = g.a($$Lambda$ICloudConfig$Companion$Tdn_0DLOybLS3z8vpPUkNsR51Wo.INSTANCE);
        }

        private final ICloudConfig getImpl() {
            return (ICloudConfig) ZeusTransformUtils.preCheckCast(impl$delegate.b(), ICloudConfig.class, "com.obric.aiagent.plugin");
        }

        private static final ICloudConfig impl_delegate$lambda$0() {
            IAIAgentPlatform r0 = AIAgentPlatform.INSTANCE.get$platform_release();
            if (r0 == null) goto L7;
            ICloudConfig r1 = r0.getCloudConfig();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (ICloudConfig) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ICloudConfig.class), ICloudConfig.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.platform.depend.ICloudConfig
        public JSONObject getSettingsConfig(String r2) {
            o.e(r2, "key");
            ICloudConfig r1 = getImpl();
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.getSettingsConfig(r2);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    JSONObject getSettingsConfig(String r1);
}

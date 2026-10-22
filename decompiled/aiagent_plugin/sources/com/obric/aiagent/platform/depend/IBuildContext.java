package com.obric.aiagent.platform.depend;

import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;

/* JADX INFO: compiled from: IBuildContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IBuildContext {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IBuildContext.kt */
    public static final class Companion implements IBuildContext {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final f<IBuildContext> impl$delegate = null;

        public static /* synthetic */ IBuildContext lambda$MrUPRV80_Mj3i_HWSMAU87fZCeY() {
            return impl_delegate$lambda$0();
        }

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            impl$delegate = g.a($$Lambda$IBuildContext$Companion$MrUPRV80_Mj3i_HWSMAU87fZCeY.INSTANCE);
        }

        private final IBuildContext getImpl() {
            return (IBuildContext) ZeusTransformUtils.preCheckCast(impl$delegate.b(), IBuildContext.class, "com.obric.aiagent.plugin");
        }

        private static final IBuildContext impl_delegate$lambda$0() {
            IAIAgentPlatform r0 = AIAgentPlatform.INSTANCE.get$platform_release();
            if (r0 == null) goto L7;
            IBuildContext r1 = r0.getBuildContext();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (IBuildContext) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IBuildContext.class), IBuildContext.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.platform.depend.IBuildContext
        public int getBuildId() {
            IBuildContext r0 = getImpl();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getBuildId();
        }

        @Override // com.obric.aiagent.platform.depend.IBuildContext
        public String getBuildTime() {
            IBuildContext r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getBuildTime();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.IBuildContext
        public String getBranchId() {
            IBuildContext r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getBranchId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.IBuildContext
        public String getCommitId() {
            IBuildContext r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getCommitId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.IBuildContext
        public String getBuildVariant() {
            IBuildContext r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getBuildVariant();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String getBranchId();

    int getBuildId();

    String getBuildTime();

    String getBuildVariant();

    String getCommitId();
}

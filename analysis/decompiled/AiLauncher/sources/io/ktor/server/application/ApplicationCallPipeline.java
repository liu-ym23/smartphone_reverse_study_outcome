package io.ktor.server.application;

import Y8.t;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.Pipeline;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/server/application/ApplicationCallPipeline;", "Lio/ktor/util/pipeline/Pipeline;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "", "developmentMode", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "<init>", "(ZLio/ktor/server/application/ApplicationEnvironment;)V", "Z", "getDevelopmentMode", "()Z", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "Lio/ktor/server/request/ApplicationReceivePipeline;", "receivePipeline", "Lio/ktor/server/request/ApplicationReceivePipeline;", "getReceivePipeline", "()Lio/ktor/server/request/ApplicationReceivePipeline;", "Lio/ktor/server/response/ApplicationSendPipeline;", "sendPipeline", "Lio/ktor/server/response/ApplicationSendPipeline;", "getSendPipeline", "()Lio/ktor/server/response/ApplicationSendPipeline;", "ApplicationPhase", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ApplicationCallPipeline extends Pipeline<t, PipelineCall> {
    private static final Phase Call;
    private static final Phase Fallback;
    private static final Phase Features;
    private static final Phase Plugins;
    private final boolean developmentMode;
    private final ApplicationEnvironment environment;
    private final ApplicationReceivePipeline receivePipeline;
    private final ApplicationSendPipeline sendPipeline;

    /* renamed from: ApplicationPhase, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Phase Setup = new Phase("Setup");
    private static final Phase Monitoring = new Phase("Monitoring");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR \u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lio/ktor/server/application/ApplicationCallPipeline$ApplicationPhase;", "", "<init>", "()V", "Lio/ktor/util/pipeline/PipelinePhase;", "Setup", "Lio/ktor/util/pipeline/PipelinePhase;", "getSetup", "()Lio/ktor/util/pipeline/PipelinePhase;", "Monitoring", "getMonitoring", "Plugins", "getPlugins", "Call", "getCall", "Fallback", "getFallback", "Features", "getFeatures", "getFeatures$annotations", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.ApplicationCallPipeline$ApplicationPhase, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void getFeatures$annotations() {
        }

        public final Phase getCall() {
            return ApplicationCallPipeline.Call;
        }

        public final Phase getFallback() {
            return ApplicationCallPipeline.Fallback;
        }

        public final Phase getFeatures() {
            return ApplicationCallPipeline.Features;
        }

        public final Phase getMonitoring() {
            return ApplicationCallPipeline.Monitoring;
        }

        public final Phase getPlugins() {
            return ApplicationCallPipeline.Plugins;
        }

        public final Phase getSetup() {
            return ApplicationCallPipeline.Setup;
        }

        private Companion() {
        }
    }

    static {
        Phase phase = new Phase("Plugins");
        Plugins = phase;
        Call = new Phase("Call");
        Fallback = new Phase("Fallback");
        Features = phase;
    }

    public /* synthetic */ ApplicationCallPipeline(boolean z10, ApplicationEnvironment applicationEnvironment, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10, applicationEnvironment);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final ApplicationEnvironment getEnvironment() {
        return this.environment;
    }

    public final ApplicationReceivePipeline getReceivePipeline() {
        return this.receivePipeline;
    }

    public final ApplicationSendPipeline getSendPipeline() {
        return this.sendPipeline;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCallPipeline(boolean z10, ApplicationEnvironment environment) {
        super(Setup, Monitoring, Plugins, Call, Fallback);
        p.i(environment, "environment");
        this.developmentMode = z10;
        this.environment = environment;
        this.receivePipeline = new ApplicationReceivePipeline(z10);
        this.sendPipeline = new ApplicationSendPipeline(z10);
    }
}

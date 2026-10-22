package io.ktor.server.engine;

import io.ktor.server.application.PipelineCall;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.Pipeline;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/server/engine/EnginePipeline;", "Lio/ktor/util/pipeline/Pipeline;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "", "developmentMode", "<init>", "(Z)V", "Z", "getDevelopmentMode", "()Z", "Lio/ktor/server/request/ApplicationReceivePipeline;", "receivePipeline", "Lio/ktor/server/request/ApplicationReceivePipeline;", "getReceivePipeline", "()Lio/ktor/server/request/ApplicationReceivePipeline;", "Lio/ktor/server/response/ApplicationSendPipeline;", "sendPipeline", "Lio/ktor/server/response/ApplicationSendPipeline;", "getSendPipeline", "()Lio/ktor/server/response/ApplicationSendPipeline;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EnginePipeline extends Pipeline<Y8.t, PipelineCall> {
    private final boolean developmentMode;
    private final ApplicationReceivePipeline receivePipeline;
    private final ApplicationSendPipeline sendPipeline;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Phase Before = new Phase("before");
    private static final Phase Call = new Phase("call");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/server/engine/EnginePipeline$Companion;", "", "<init>", "()V", "Lio/ktor/util/pipeline/PipelinePhase;", "Before", "Lio/ktor/util/pipeline/PipelinePhase;", "getBefore", "()Lio/ktor/util/pipeline/PipelinePhase;", "Call", "getCall", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Phase getBefore() {
            return EnginePipeline.Before;
        }

        public final Phase getCall() {
            return EnginePipeline.Call;
        }

        private Companion() {
        }
    }

    public EnginePipeline() {
        this(false, 1, null);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final ApplicationReceivePipeline getReceivePipeline() {
        return this.receivePipeline;
    }

    public final ApplicationSendPipeline getSendPipeline() {
        return this.sendPipeline;
    }

    public /* synthetic */ EnginePipeline(boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public EnginePipeline(boolean z10) {
        super(Before, Call);
        this.developmentMode = z10;
        this.receivePipeline = new ApplicationReceivePipeline(getDevelopmentMode());
        this.sendPipeline = new ApplicationSendPipeline(getDevelopmentMode());
    }
}

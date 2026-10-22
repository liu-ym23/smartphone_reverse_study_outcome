package io.ktor.server.request;

import io.ktor.server.application.PipelineCall;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.Pipeline;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lio/ktor/server/request/ApplicationReceivePipeline;", "Lio/ktor/util/pipeline/Pipeline;", "", "Lio/ktor/server/application/PipelineCall;", "", "developmentMode", "<init>", "(Z)V", "Z", "getDevelopmentMode", "()Z", "Phases", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ApplicationReceivePipeline extends Pipeline<Object, PipelineCall> {
    private final boolean developmentMode;

    /* renamed from: Phases, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Phase Before = new Phase("Before");
    private static final Phase Transform = new Phase("Transform");
    private static final Phase After = new Phase("After");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lio/ktor/server/request/ApplicationReceivePipeline$Phases;", "", "<init>", "()V", "Lio/ktor/util/pipeline/PipelinePhase;", "Before", "Lio/ktor/util/pipeline/PipelinePhase;", "getBefore", "()Lio/ktor/util/pipeline/PipelinePhase;", "Transform", "getTransform", "After", "getAfter", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.request.ApplicationReceivePipeline$Phases, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Phase getAfter() {
            return ApplicationReceivePipeline.After;
        }

        public final Phase getBefore() {
            return ApplicationReceivePipeline.Before;
        }

        public final Phase getTransform() {
            return ApplicationReceivePipeline.Transform;
        }

        private Companion() {
        }
    }

    public ApplicationReceivePipeline() {
        this(false, 1, null);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public /* synthetic */ ApplicationReceivePipeline(boolean z10, int i10, i iVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public ApplicationReceivePipeline(boolean z10) {
        super(Before, Transform, After);
        this.developmentMode = z10;
    }
}

package io.ktor.server.application;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.Pipeline;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR/\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/application/Interception;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lkotlin/Function1;", "Lio/ktor/util/pipeline/Pipeline;", "Lio/ktor/server/application/PipelineCall;", "LY8/t;", "action", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;Lp9/l;)V", "Lio/ktor/util/pipeline/PipelinePhase;", "getPhase", "()Lio/ktor/util/pipeline/PipelinePhase;", "Lp9/l;", "getAction", "()Lp9/l;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Interception<T> {
    private final InterfaceC5074l<Pipeline<T, PipelineCall>, t> action;
    private final Phase phase;

    /* JADX WARN: Multi-variable type inference failed */
    public Interception(Phase phase, InterfaceC5074l<? super Pipeline<T, PipelineCall>, t> action) {
        p.i(phase, "phase");
        p.i(action, "action");
        this.phase = phase;
        this.action = action;
    }

    public final InterfaceC5074l<Pipeline<T, PipelineCall>, t> getAction() {
        return this.action;
    }

    public final Phase getPhase() {
        return this.phase;
    }
}

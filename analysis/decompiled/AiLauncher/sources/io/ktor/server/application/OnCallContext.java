package io.ktor.server.application;

import Y8.t;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@KtorDsl
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\b\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/server/application/OnCallContext;", "", "PluginConfig", "Lio/ktor/server/application/CallContext;", "pluginConfig", "Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "context", "<init>", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OnCallContext<PluginConfig> extends CallContext<PluginConfig> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnCallContext(PluginConfig pluginConfig, PipelineContext<t, PipelineCall> context) {
        super(pluginConfig, context);
        p.i(pluginConfig, "pluginConfig");
        p.i(context, "context");
    }
}

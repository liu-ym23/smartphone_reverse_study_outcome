package io.ktor.server.application;

import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;

@KtorDsl
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/server/application/Hook;", "HookHandler", "", "Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Ljava/lang/Object;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Hook<HookHandler> {
    void install(ApplicationCallPipeline pipeline, HookHandler handler);
}

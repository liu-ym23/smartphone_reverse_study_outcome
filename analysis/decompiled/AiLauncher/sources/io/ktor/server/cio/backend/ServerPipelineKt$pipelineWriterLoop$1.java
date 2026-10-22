package io.ktor.server.cio.backend;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.ktor.server.cio.backend.ServerPipelineKt", f = "ServerPipeline.kt", l = {208, 212, 213}, m = "pipelineWriterLoop-dWUq8MI")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerPipelineKt$pipelineWriterLoop$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ServerPipelineKt$pipelineWriterLoop$1(InterfaceC4014c<? super ServerPipelineKt$pipelineWriterLoop$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ServerPipelineKt.m170pipelineWriterLoopdWUq8MI(null, 0L, null, this);
    }
}

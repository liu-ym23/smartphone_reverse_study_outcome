package io.ktor.client.engine.cio;

import Ua.C1060i;
import Ua.M;
import io.ktor.network.sockets.Connection;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010#¨\u0006'"}, d2 = {"Lio/ktor/client/engine/cio/ConnectionPipeline;", "LUa/M;", "", "keepAliveTime", "", "pipelineMaxSize", "Lio/ktor/network/sockets/Connection;", "connection", "", "overProxy", "LWa/g;", "Lio/ktor/client/engine/cio/RequestTask;", "tasks", "Lkotlin/coroutines/d;", "parentContext", "<init>", "(JILio/ktor/network/sockets/Connection;ZLWa/g;Lkotlin/coroutines/d;)V", "coroutineContext", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lio/ktor/utils/io/ByteReadChannel;", "networkInput", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "networkOutput", "Lio/ktor/utils/io/ByteWriteChannel;", "Leb/g;", "requestLimit", "Leb/g;", "Lio/ktor/client/engine/cio/ConnectionResponseTask;", "responseChannel", "LWa/g;", "Lkotlinx/coroutines/g;", "pipelineContext", "Lkotlinx/coroutines/g;", "getPipelineContext", "()Lkotlinx/coroutines/g;", "responseHandler", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionPipeline implements M {
    private final kotlin.coroutines.d coroutineContext;
    private final ByteReadChannel networkInput;
    private final ByteWriteChannel networkOutput;
    private final kotlinx.coroutines.g pipelineContext;
    private final eb.g requestLimit;
    private final Wa.g<ConnectionResponseTask> responseChannel;
    private final kotlinx.coroutines.g responseHandler;

    public ConnectionPipeline(long j10, int i10, Connection connection, boolean z10, Wa.g<RequestTask> tasks, kotlin.coroutines.d parentContext) {
        p.i(connection, "connection");
        p.i(tasks, "tasks");
        p.i(parentContext, "parentContext");
        this.coroutineContext = parentContext.plus(JobKt__JobKt.b(null, 1, null));
        this.networkInput = connection.getInput();
        this.networkOutput = connection.getOutput();
        this.requestLimit = eb.j.b(i10, 0, 2, null);
        this.responseChannel = Wa.j.b(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineStart coroutineStart = CoroutineStart.LAZY;
        kotlinx.coroutines.g gVarD = C1060i.d(this, null, coroutineStart, new ConnectionPipeline$pipelineContext$1(j10, this, z10, tasks, null), 1, null);
        this.pipelineContext = gVarD;
        kotlinx.coroutines.g gVarD2 = C1060i.d(this, null, coroutineStart, new ConnectionPipeline$responseHandler$1(this, connection, null), 1, null);
        this.responseHandler = gVarD2;
        gVarD.start();
        gVarD2.start();
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    public final kotlinx.coroutines.g getPipelineContext() {
        return this.pipelineContext;
    }
}

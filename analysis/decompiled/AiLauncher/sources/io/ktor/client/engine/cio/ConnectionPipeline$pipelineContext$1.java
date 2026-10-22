package io.ktor.client.engine.cio;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1", f = "ConnectionPipeline.kt", l = {44, 49, 50, 56, 57}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ConnectionPipeline$pipelineContext$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $keepAliveTime;
    final /* synthetic */ boolean $overProxy;
    final /* synthetic */ Wa.g<RequestTask> $tasks;
    Object L$0;
    int label;
    final /* synthetic */ ConnectionPipeline this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPipeline$pipelineContext$1(long j10, ConnectionPipeline connectionPipeline, boolean z10, Wa.g<RequestTask> gVar, InterfaceC4014c<? super ConnectionPipeline$pipelineContext$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$keepAliveTime = j10;
        this.this$0 = connectionPipeline;
        this.$overProxy = z10;
        this.$tasks = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConnectionPipeline$pipelineContext$1(this.$keepAliveTime, this.this$0, this.$overProxy, this.$tasks, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ConnectionPipeline$pipelineContext$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8 A[Catch: ClosedChannelException | CancellationException | ClosedReceiveChannelException -> 0x0027, ClosedChannelException | CancellationException | ClosedReceiveChannelException -> 0x0027, ClosedChannelException | CancellationException | ClosedReceiveChannelException -> 0x0027, all -> 0x00e4, PHI: r1 r14
      0x00a8: PHI (r1v11 io.ktor.client.engine.cio.RequestTask) = (r1v18 io.ktor.client.engine.cio.RequestTask), (r1v19 io.ktor.client.engine.cio.RequestTask) binds: [B:21:0x0040, B:42:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x00a8: PHI (r14v15 'this' io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1) = 
      (r14v0 'this' io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1 A[IMMUTABLE_TYPE, THIS])
      (r14v17 'this' io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1)
     binds: [B:21:0x0040, B:42:0x00a5] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {ClosedChannelException | CancellationException | ClosedReceiveChannelException -> 0x0027, blocks: (B:10:0x001c, B:31:0x0058, B:31:0x0058, B:31:0x0058, B:34:0x006d, B:34:0x006d, B:34:0x006d, B:44:0x00a8, B:44:0x00a8, B:44:0x00a8, B:18:0x0036, B:18:0x0036, B:18:0x0036, B:28:0x0051, B:28:0x0051, B:28:0x0051), top: B:67:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c9 A[Catch: all -> 0x00e1, ClosedChannelException | CancellationException | ClosedReceiveChannelException -> 0x00fc, PHI: r1 r13
      0x00c9: PHI (r1v10 io.ktor.client.engine.cio.RequestTask) = (r1v20 io.ktor.client.engine.cio.RequestTask), (r1v21 io.ktor.client.engine.cio.RequestTask) binds: [B:19:0x0039, B:47:0x00c6] A[DONT_GENERATE, DONT_INLINE]
      0x00c9: PHI (r13v11 io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1) = 
      (r13v4 io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1)
      (r13v12 io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1)
     binds: [B:19:0x0039, B:47:0x00c6] A[DONT_GENERATE, DONT_INLINE], TryCatch #7 {ClosedChannelException | CancellationException | ClosedReceiveChannelException -> 0x00fc, all -> 0x00e1, blocks: (B:46:0x00c2, B:49:0x00c9, B:59:0x00ea, B:60:0x00f1), top: B:74:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.ConnectionPipeline$pipelineContext$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

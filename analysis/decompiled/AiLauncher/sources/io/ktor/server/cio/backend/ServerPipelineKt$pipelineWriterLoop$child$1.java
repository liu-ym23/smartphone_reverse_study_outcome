package io.ktor.server.cio.backend;

import Ua.M;
import Wa.r;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/utils/io/ByteReadChannel;", "<anonymous>", "(LUa/M;)Lio/ktor/utils/io/ByteReadChannel;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.cio.backend.ServerPipelineKt$pipelineWriterLoop$child$1", f = "ServerPipeline.kt", l = {209}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ServerPipelineKt$pipelineWriterLoop$child$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super ByteReadChannel>, Object> {
    final /* synthetic */ r<ByteReadChannel> $channel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ServerPipelineKt$pipelineWriterLoop$child$1(r<? extends ByteReadChannel> rVar, InterfaceC4014c<? super ServerPipelineKt$pipelineWriterLoop$child$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$channel = rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ServerPipelineKt$pipelineWriterLoop$child$1(this.$channel, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super ByteReadChannel> interfaceC4014c) {
        return ((ServerPipelineKt$pipelineWriterLoop$child$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objU;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            r<ByteReadChannel> rVar = this.$channel;
            this.label = 1;
            objU = rVar.u(this);
            if (objU == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objU = ((kotlinx.coroutines.channels.a) obj).getHolder();
        }
        return kotlinx.coroutines.channels.a.f(objU);
    }
}

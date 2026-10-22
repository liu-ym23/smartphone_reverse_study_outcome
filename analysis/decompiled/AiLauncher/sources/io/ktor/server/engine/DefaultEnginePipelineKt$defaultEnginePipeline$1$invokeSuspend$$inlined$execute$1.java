package io.ktor.server.engine;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.pipeline.Pipeline;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"LY8/t;", "<anonymous>", "()V", "io/ktor/util/pipeline/PipelineKt$execute$2"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.util.pipeline.PipelineKt$execute$2", f = "Pipeline.kt", l = {510}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Object $context;
    final /* synthetic */ Pipeline $this_execute;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1(Pipeline pipeline, Object obj, InterfaceC4014c interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$this_execute = pipeline;
        this.$context = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1(this.$this_execute, this.$context, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Pipeline pipeline = this.$this_execute;
            Object obj2 = this.$context;
            Y8.t tVar = Y8.t.f7040a;
            this.label = 1;
            if (pipeline.execute(obj2, tVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}

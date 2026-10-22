package io.ktor.server.application.hooks;

import W4.b;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.Hook;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.InternalAPI;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;
import w9.InterfaceC5745d;

@InternalAPI
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJA\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/application/hooks/BeforeResponseTransform;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/server/application/Hook;", "Lkotlin/Function3;", "Lio/ktor/server/application/ApplicationCall;", "Le9/c;", "Lw9/d;", "clazz", "<init>", "(Lw9/d;)V", "Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "handler", "LY8/t;", b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Lp9/q;)V", "Lw9/d;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BeforeResponseTransform<T> implements Hook<q<? super ApplicationCall, ? super T, ? super InterfaceC4014c<? super Object>, ? extends Object>> {
    private final InterfaceC5745d<T> clazz;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "body", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.hooks.BeforeResponseTransform$install$1", f = "CommonHooks.kt", l = {170}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.hooks.BeforeResponseTransform$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<ApplicationCall, T, InterfaceC4014c<Object>, Object> $handler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ BeforeResponseTransform<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(BeforeResponseTransform<T> beforeResponseTransform, q<? super ApplicationCall, ? super T, ? super InterfaceC4014c<Object>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.this$0 = beforeResponseTransform;
            this.$handler = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                Object obj2 = this.L$1;
                if (TypeInfoJvmKt.instanceOf(obj2, ((BeforeResponseTransform) this.this$0).clazz)) {
                    q<ApplicationCall, T, InterfaceC4014c<Object>, Object> qVar = this.$handler;
                    PipelineCall pipelineCall = (PipelineCall) pipelineContext2.getContext();
                    p.g(obj2, "null cannot be cast to non-null type T of io.ktor.server.application.hooks.BeforeResponseTransform");
                    this.L$0 = pipelineContext2;
                    this.label = 1;
                    Object objInvoke = qVar.invoke(pipelineCall, obj2, this);
                    if (objInvoke == objG) {
                        return objG;
                    }
                    obj = objInvoke;
                    pipelineContext = pipelineContext2;
                }
                return t.f7040a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pipelineContext = (PipelineContext) this.L$0;
            C4849c.b(obj);
            pipelineContext.setSubject(obj);
            return t.f7040a;
        }
    }

    public BeforeResponseTransform(InterfaceC5745d<T> clazz) {
        p.i(clazz, "clazz");
        this.clazz = clazz;
    }

    @Override // io.ktor.server.application.Hook
    public void install(ApplicationCallPipeline pipeline, q<? super ApplicationCall, ? super T, ? super InterfaceC4014c<Object>, ? extends Object> handler) throws InvalidPhaseException {
        p.i(pipeline, "pipeline");
        p.i(handler, "handler");
        Phase phase = new Phase("BeforeTransform");
        pipeline.getSendPipeline().insertPhaseBefore(ApplicationSendPipeline.INSTANCE.getTransform(), phase);
        pipeline.getSendPipeline().intercept(phase, new AnonymousClass1(this, handler, null));
    }
}

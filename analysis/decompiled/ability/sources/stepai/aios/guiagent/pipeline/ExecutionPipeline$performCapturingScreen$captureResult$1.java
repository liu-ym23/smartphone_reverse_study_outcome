package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import N9.j;
import S7.k;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiagent.ability.CaptureOptions;
import stepai.aios.guiagent.ability.CaptureResult;
import stepai.aios.guiagent.ability.GuiAbilityProvider;
import za.e;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$performCapturingScreen$captureResult$1", f = "ExecutionPipeline.kt", l = {TypedValues.Custom.TYPE_BOOLEAN}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lstepai/aios/guiagent/ability/CaptureResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$performCapturingScreen$captureResult$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6075a;
    public final /* synthetic */ b b;
    public final /* synthetic */ e c;
    public final /* synthetic */ Aa.e d;

    @c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$performCapturingScreen$captureResult$1$1", f = "ExecutionPipeline.kt", l = {TypedValues.Custom.TYPE_DIMENSION}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lstepai/aios/guiagent/ability/CaptureResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiagent.pipeline.ExecutionPipeline$performCapturingScreen$captureResult$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements k {

        /* renamed from: a, reason: collision with root package name */
        public int f6076a;
        public final /* synthetic */ Aa.e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Aa.e eVar, H7.c cVar) {
            super(1, cVar);
            this.b = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(H7.c cVar) {
            return new AnonymousClass1(this.b, cVar);
        }

        @Override // S7.k
        public final Object invoke(Object obj) {
            return ((AnonymousClass1) create((H7.c) obj)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f6076a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            GuiAbilityProvider guiAbilityProvider = this.b.f168a.getGuiAbilityProvider();
            CaptureOptions captureOptionsForMainLoop$default = CaptureOptions.Companion.forMainLoop$default(CaptureOptions.INSTANCE, false, 1, null);
            this.f6076a = 1;
            Object objCaptureScreenResult = guiAbilityProvider.captureScreenResult(captureOptionsForMainLoop$default, this);
            return objCaptureScreenResult == coroutineSingletons ? coroutineSingletons : objCaptureScreenResult;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$performCapturingScreen$captureResult$1(b bVar, e eVar, Aa.e eVar2, H7.c cVar) {
        super(1, cVar);
        this.b = bVar;
        this.c = eVar;
        this.d = eVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new ExecutionPipeline$performCapturingScreen$captureResult$1(this.b, this.c, this.d, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((ExecutionPipeline$performCapturingScreen$captureResult$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6075a;
        try {
            if (i == 0) {
                kotlin.b.b(obj);
                a aVar = this.b.e;
                Integer num = this.c.d;
                int iIntValue = num != null ? num.intValue() : 0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.d, null);
                this.f6075a = 1;
                obj = aVar.c(iIntValue, anonymousClass1, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return (CaptureResult) obj;
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e6) {
            j.G("Capture screen failed: " + e6.getMessage(), "GuiExecutionPipeline");
            return new CaptureResult(null, null, null, null, null, null, 63, null);
        }
    }
}

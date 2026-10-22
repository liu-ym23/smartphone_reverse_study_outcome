package stepai.aios.guiagent.pipeline;

import Aa.e;
import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiagent.ability.CaptureOptions;
import stepai.aios.guiagent.ability.CaptureResult;
import stepai.aios.guiagent.ability.GuiAbilityProvider;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$handleTakeover$screenshot$1", f = "ExecutionPipeline.kt", l = {1424}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$handleTakeover$screenshot$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6072a;
    public final /* synthetic */ e b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$handleTakeover$screenshot$1(e eVar, H7.c cVar) {
        super(1, cVar);
        this.b = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new ExecutionPipeline$handleTakeover$screenshot$1(this.b, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((ExecutionPipeline$handleTakeover$screenshot$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6072a;
        if (i == 0) {
            kotlin.b.b(obj);
            GuiAbilityProvider guiAbilityProvider = this.b.f168a.getGuiAbilityProvider();
            CaptureOptions captureOptionsForTakeover$default = CaptureOptions.Companion.forTakeover$default(CaptureOptions.INSTANCE, false, 1, null);
            this.f6072a = 1;
            obj = guiAbilityProvider.captureScreenResult(captureOptionsForTakeover$default, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return ((CaptureResult) obj).getBitmap();
    }
}

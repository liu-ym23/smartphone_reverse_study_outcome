package stepai.aios.guiagent.llm;

import C7.r;
import J7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.d;
import stepai.android.mindx.client.config.StepChatResult;

@c(c = "stepai.aios.guiagent.llm.StepService$chatStream$$inlined$transform$1", f = "StepService.kt", l = {40}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lp9/d;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
public final class StepService$chatStream$$inlined$transform$1 extends SuspendLambda implements n {
    final /* synthetic */ p9.c $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepService$chatStream$$inlined$transform$1(p9.c cVar, H7.c cVar2) {
        super(2, cVar2);
        this.$this_transform = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        StepService$chatStream$$inlined$transform$1 stepService$chatStream$$inlined$transform$1 = new StepService$chatStream$$inlined$transform$1(this.$this_transform, cVar);
        stepService$chatStream$$inlined$transform$1.L$0 = obj;
        return stepService$chatStream$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            final d dVar = (d) this.L$0;
            p9.c cVar = this.$this_transform;
            d dVar2 = new d() { // from class: stepai.aios.guiagent.llm.StepService$chatStream$$inlined$transform$1.1
                @Override // p9.d
                public final Object emit(T t9, H7.c<? super r> cVar2) {
                    StepChatResult stepChatResult = (StepChatResult) t9;
                    if (stepChatResult instanceof StepChatResult.Error) {
                        new LlmChatResponse(null, "", 0L, false, ((StepChatResult.Error) stepChatResult).getMessage(), null, null, null, null, 485, null);
                    } else {
                        if (!(stepChatResult instanceof StepChatResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        new LlmChatResponse(null, ((StepChatResult.Success) stepChatResult).getMessage(), 0L, false, null, null, null, null, null, 509, null);
                    }
                    return r.f317a;
                }
            };
            this.L$0 = null;
            this.label = 1;
            if (cVar.collect(dVar2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(d dVar, H7.c<? super r> cVar) {
        return ((StepService$chatStream$$inlined$transform$1) create(dVar, cVar)).invokeSuspend(r.f317a);
    }
}

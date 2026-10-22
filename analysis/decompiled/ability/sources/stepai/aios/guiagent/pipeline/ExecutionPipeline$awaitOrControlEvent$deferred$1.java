package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitOrControlEvent$deferred$1", f = "ExecutionPipeline.kt", l = {942}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitOrControlEvent$deferred$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6051a;
    public final /* synthetic */ k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitOrControlEvent$deferred$1(k kVar, H7.c cVar) {
        super(2, cVar);
        this.b = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$awaitOrControlEvent$deferred$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitOrControlEvent$deferred$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6051a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        this.f6051a = 1;
        Object objInvoke = ((ExecutionPipeline$performCapturingScreen$captureResult$1) this.b).invoke(this);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}

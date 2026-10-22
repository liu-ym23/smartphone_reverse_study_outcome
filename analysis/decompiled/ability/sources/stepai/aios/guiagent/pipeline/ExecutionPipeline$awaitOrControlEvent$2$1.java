package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitOrControlEvent$2$1", f = "ExecutionPipeline.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitOrControlEvent$2$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6049a;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        ExecutionPipeline$awaitOrControlEvent$2$1 executionPipeline$awaitOrControlEvent$2$1 = new ExecutionPipeline$awaitOrControlEvent$2$1(2, cVar);
        executionPipeline$awaitOrControlEvent$2$1.f6049a = obj;
        return executionPipeline$awaitOrControlEvent$2$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitOrControlEvent$2$1) create(obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = this.f6049a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        return obj2;
    }
}

package stepai.aios.guiagent.pipeline;

import Aa.d;
import C7.r;
import J7.c;
import S7.n;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1687E;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitOrControlEvent$2$2", f = "ExecutionPipeline.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", NotificationCompat.CATEGORY_EVENT, "Lstepai/aios/guiagent/pipeline/ExecutionPipeline$ControlEvent;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitOrControlEvent$2$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6050a;
    public final /* synthetic */ d b;
    public final /* synthetic */ C1687E c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitOrControlEvent$2$2(d dVar, C1687E c1687e, H7.c cVar) {
        super(2, cVar);
        this.b = dVar;
        this.c = c1687e;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        ExecutionPipeline$awaitOrControlEvent$2$2 executionPipeline$awaitOrControlEvent$2$2 = new ExecutionPipeline$awaitOrControlEvent$2$2(this.b, this.c, cVar);
        executionPipeline$awaitOrControlEvent$2$2.f6050a = obj;
        return executionPipeline$awaitOrControlEvent$2$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        ((ExecutionPipeline$awaitOrControlEvent$2$2) create((ExecutionPipeline$ControlEvent) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ExecutionPipeline$ControlEvent executionPipeline$ControlEvent = (ExecutionPipeline$ControlEvent) this.f6050a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        this.b.f.a(executionPipeline$ControlEvent);
        this.c.cancel(null);
        return null;
    }
}

package h2;

import androidx.appcompat.widget.z0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {
    public static CallbackToFutureAdapter.c a(final kotlin.coroutines.d context, final zb.p pVar) {
        final CoroutineStart start = CoroutineStart.DEFAULT;
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(start, "start");
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b(start, pVar) { // from class: androidx.work.b
            public final /* synthetic */ CoroutineStart h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ SuspendLambda f2828i;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f2828i = (SuspendLambda) pVar;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, zb.p] */
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object c(CallbackToFutureAdapter.a aVar) {
                Job.Key key = Job.Key;
                d dVar = this.f2827g;
                z0 z0Var = new z0((Job) dVar.get(key), 14);
                d0.a<Void> aVar2 = aVar.f1024c;
                if (aVar2 != null) {
                    aVar2.a(z0Var, DirectExecutor.f2772a);
                }
                return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dVar), null, this.h, new ListenableFutureKt$launchFuture$1$2(this.f2828i, aVar, null), 1, null);
            }
        });
    }
}

package kotlinx.coroutines.flow;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$BooleanRef;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__LimitKt {
    public static final <T> Flow<T> dropWhile(final Flow<? extends T> flow, final p<? super T, ? super qb.b<? super Boolean>, ? extends Object> pVar) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, qb.b<? super n> bVar) {
                Object objCollect = flow.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), flowCollector, pVar), bVar);
                return objCollect == CoroutineSingletons.f10059a ? objCollect : n.f10413a;
            }
        };
    }
}

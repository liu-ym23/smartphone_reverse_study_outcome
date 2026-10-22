package Ya;

import Za.y;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/d;", "currentContext", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/coroutines/flow/internal/SafeCollector;Lkotlin/coroutines/d;)V", "Lkotlinx/coroutines/g;", "collectJob", Const.INTENT_KEY_UMID, "(Lkotlinx/coroutines/g;Lkotlinx/coroutines/g;)Lkotlinx/coroutines/g;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n {
    public static final void b(final SafeCollector<?> safeCollector, kotlin.coroutines.d dVar) {
        if (((Number) dVar.fold(0, new p9.p() { // from class: Ya.m
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(n.c(safeCollector, ((Integer) obj).intValue(), (d.b) obj2));
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + dVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final int c(SafeCollector safeCollector, int i10, d.b bVar) {
        d.c<?> key = bVar.getKey();
        d.b bVar2 = safeCollector.collectContext.get(key);
        if (key != kotlinx.coroutines.g.INSTANCE) {
            if (bVar != bVar2) {
                return Integer.MIN_VALUE;
            }
            return i10 + 1;
        }
        kotlinx.coroutines.g gVar = (kotlinx.coroutines.g) bVar2;
        kotlin.jvm.internal.p.g(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        kotlinx.coroutines.g gVarD = d((kotlinx.coroutines.g) bVar, gVar);
        if (gVarD == gVar) {
            return gVar == null ? i10 : i10 + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + gVarD + ", expected child of " + gVar + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    public static final kotlinx.coroutines.g d(kotlinx.coroutines.g gVar, kotlinx.coroutines.g gVar2) {
        while (gVar != null) {
            if (gVar == gVar2 || !(gVar instanceof y)) {
                return gVar;
            }
            gVar = ((y) gVar).a0();
        }
        return null;
    }
}

package Ua;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4111c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001a\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u00020\u0016H\u0080\u0010¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"LUa/M;", "Lkotlin/coroutines/d;", "context", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LUa/M;Lkotlin/coroutines/d;)Lkotlin/coroutines/d;", "addedContext", "k", "(Lkotlin/coroutines/d;Lkotlin/coroutines/d;)Lkotlin/coroutines/d;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlin/coroutines/d;)Z", "originalContext", "appendContext", "isNewCoroutine", Const.INTENT_KEY_UMID, "(Lkotlin/coroutines/d;Lkotlin/coroutines/d;Z)Lkotlin/coroutines/d;", "Le9/c;", "", "oldValue", "LUa/S0;", "m", "(Le9/c;Lkotlin/coroutines/d;Ljava/lang/Object;)LUa/S0;", "Lg9/c;", "l", "(Lg9/c;)LUa/S0;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlin/coroutines/d;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class G {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final kotlin.coroutines.d d(kotlin.coroutines.d dVar, kotlin.coroutines.d dVar2, final boolean z10) {
        boolean zH = h(dVar);
        boolean zH2 = h(dVar2);
        if (!zH && !zH2) {
            return dVar.plus(dVar2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f34820a = dVar2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f34779a;
        kotlin.coroutines.d dVar3 = (kotlin.coroutines.d) dVar.fold(emptyCoroutineContext, new p9.p() { // from class: Ua.E
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return G.e(ref$ObjectRef, z10, (kotlin.coroutines.d) obj, (d.b) obj2);
            }
        });
        if (zH2) {
            ref$ObjectRef.f34820a = ((kotlin.coroutines.d) ref$ObjectRef.f34820a).fold(emptyCoroutineContext, new p9.p() { // from class: Ua.F
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return G.f((kotlin.coroutines.d) obj, (d.b) obj2);
                }
            });
        }
        return dVar3.plus((kotlin.coroutines.d) ref$ObjectRef.f34820a);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, kotlin.coroutines.d] */
    public static final kotlin.coroutines.d e(Ref$ObjectRef ref$ObjectRef, boolean z10, kotlin.coroutines.d dVar, d.b bVar) {
        if (!(bVar instanceof B)) {
            return dVar.plus(bVar);
        }
        d.b bVar2 = ((kotlin.coroutines.d) ref$ObjectRef.f34820a).get(bVar.getKey());
        if (bVar2 == null) {
            return dVar.plus(z10 ? ((B) bVar).V() : (B) bVar);
        }
        ref$ObjectRef.f34820a = ((kotlin.coroutines.d) ref$ObjectRef.f34820a).minusKey(bVar.getKey());
        return dVar.plus(((B) bVar).n(bVar2));
    }

    public static final kotlin.coroutines.d f(kotlin.coroutines.d dVar, d.b bVar) {
        return bVar instanceof B ? dVar.plus(((B) bVar).V()) : dVar.plus(bVar);
    }

    public static final String g(kotlin.coroutines.d dVar) {
        return null;
    }

    public static final boolean h(kotlin.coroutines.d dVar) {
        return ((Boolean) dVar.fold(Boolean.FALSE, new p9.p() { // from class: Ua.D
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(G.i(((Boolean) obj).booleanValue(), (d.b) obj2));
            }
        })).booleanValue();
    }

    public static final boolean i(boolean z10, d.b bVar) {
        return z10 || (bVar instanceof B);
    }

    public static final kotlin.coroutines.d j(M m10, kotlin.coroutines.d dVar) {
        kotlin.coroutines.d dVarD = d(m10.getCoroutineContext(), dVar, true);
        return (dVarD == Y.a() || dVarD.get(kotlin.coroutines.c.INSTANCE) != null) ? dVarD : dVarD.plus(Y.a());
    }

    public static final kotlin.coroutines.d k(kotlin.coroutines.d dVar, kotlin.coroutines.d dVar2) {
        return !h(dVar2) ? dVar.plus(dVar2) : d(dVar, dVar2, false);
    }

    public static final S0<?> l(InterfaceC4111c interfaceC4111c) {
        while (!(interfaceC4111c instanceof kotlinx.coroutines.e) && (interfaceC4111c = interfaceC4111c.getCallerFrame()) != null) {
            if (interfaceC4111c instanceof S0) {
                return (S0) interfaceC4111c;
            }
        }
        return null;
    }

    public static final S0<?> m(InterfaceC4014c<?> interfaceC4014c, kotlin.coroutines.d dVar, Object obj) {
        if (!(interfaceC4014c instanceof InterfaceC4111c) || dVar.get(T0.f6349a) == null) {
            return null;
        }
        S0<?> s0L = l((InterfaceC4111c) interfaceC4014c);
        if (s0L != null) {
            s0L.e1(dVar, obj);
        }
        return s0L;
    }
}

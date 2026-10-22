package kotlinx.coroutines;

import b6.f;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineContextKt;
import rb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final d foldCopies(d dVar, d dVar2, final boolean z) {
        boolean zHasCopyableElements = hasCopyableElements(dVar);
        boolean zHasCopyableElements2 = hasCopyableElements(dVar2);
        if (!zHasCopyableElements && !zHasCopyableElements2) {
            return dVar.plus(dVar2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f10076a = dVar2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f10057a;
        d dVar3 = (d) dVar.fold(emptyCoroutineContext, new p() { // from class: jc.a
            @Override // zb.p
            public final Object invoke(Object obj, Object obj2) {
                return CoroutineContextKt.foldCopies$lambda$1(ref$ObjectRef, z, (d) obj, (d.a) obj2);
            }
        });
        if (zHasCopyableElements2) {
            ref$ObjectRef.f10076a = ((d) ref$ObjectRef.f10076a).fold(emptyCoroutineContext, new f(3));
        }
        return dVar3.plus((d) ref$ObjectRef.f10076a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, kotlin.coroutines.d] */
    public static final d foldCopies$lambda$1(Ref$ObjectRef ref$ObjectRef, boolean z, d dVar, d.a aVar) {
        if (!(aVar instanceof CopyableThreadContextElement)) {
            return dVar.plus(aVar);
        }
        d.a aVar2 = ((d) ref$ObjectRef.f10076a).get(aVar.getKey());
        if (aVar2 == null) {
            return dVar.plus(z ? ((CopyableThreadContextElement) aVar).copyForChild() : (CopyableThreadContextElement) aVar);
        }
        ref$ObjectRef.f10076a = ((d) ref$ObjectRef.f10076a).minusKey(aVar.getKey());
        return dVar.plus(((CopyableThreadContextElement) aVar).mergeForChild(aVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d foldCopies$lambda$2(d dVar, d.a aVar) {
        return aVar instanceof CopyableThreadContextElement ? dVar.plus(((CopyableThreadContextElement) aVar).copyForChild()) : dVar.plus(aVar);
    }

    public static final String getCoroutineName(d dVar) {
        return null;
    }

    private static final boolean hasCopyableElements(d dVar) {
        return ((Boolean) dVar.fold(Boolean.FALSE, new f(2))).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasCopyableElements$lambda$0(boolean z, d.a aVar) {
        return z || (aVar instanceof CopyableThreadContextElement);
    }

    public static final d newCoroutineContext(CoroutineScope coroutineScope, d dVar) {
        d dVarFoldCopies = foldCopies(coroutineScope.getCoroutineContext(), dVar, true);
        return (dVarFoldCopies == Dispatchers.getDefault() || dVarFoldCopies.get(c.a.f10058a) != null) ? dVarFoldCopies : dVarFoldCopies.plus(Dispatchers.getDefault());
    }

    public static final UndispatchedCoroutine<?> undispatchedCompletion(b bVar) {
        while (!(bVar instanceof DispatchedCoroutine) && (bVar = bVar.getCallerFrame()) != null) {
            if (bVar instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) bVar;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(qb.b<?> bVar, d dVar, Object obj) {
        if (!(bVar instanceof b) || dVar.get(UndispatchedMarker.INSTANCE) == null) {
            return null;
        }
        UndispatchedCoroutine<?> undispatchedCoroutineUndispatchedCompletion = undispatchedCompletion((b) bVar);
        if (undispatchedCoroutineUndispatchedCompletion != null) {
            undispatchedCoroutineUndispatchedCompletion.saveThreadContext(dVar, obj);
        }
        return undispatchedCoroutineUndispatchedCompletion;
    }

    public static final d newCoroutineContext(d dVar, d dVar2) {
        return !hasCopyableElements(dVar2) ? dVar.plus(dVar2) : foldCopies(dVar, dVar2, false);
    }
}

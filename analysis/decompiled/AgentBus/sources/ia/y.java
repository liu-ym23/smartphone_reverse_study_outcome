package ia;

import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public abstract class y {
    public static <R> R fold(CoroutineExceptionHandler coroutineExceptionHandler, R r10, p7.n nVar) {
        return (R) g7.i.fold(coroutineExceptionHandler, r10, nVar);
    }

    public static <E extends g7.j> E get(CoroutineExceptionHandler coroutineExceptionHandler, g7.k kVar) {
        return (E) g7.i.get(coroutineExceptionHandler, kVar);
    }

    public static g7.l minusKey(CoroutineExceptionHandler coroutineExceptionHandler, g7.k kVar) {
        return g7.i.minusKey(coroutineExceptionHandler, kVar);
    }

    public static g7.l plus(CoroutineExceptionHandler coroutineExceptionHandler, g7.l lVar) {
        return g7.i.plus(coroutineExceptionHandler, lVar);
    }
}

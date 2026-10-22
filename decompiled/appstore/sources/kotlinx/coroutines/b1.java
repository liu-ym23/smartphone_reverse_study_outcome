package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b1 {
    public static final /* synthetic */ Object a(CoroutineContext r10, Function0 r11) {
        return b(r10, r11);
    }

    public static final Object b(CoroutineContext r10, Function0 r11) {
        a2 r12 = new a2(h1.j(r10));     // Catch: InterruptedException -> L6
        r12.d();     // Catch: InterruptedException -> L6
        Object r13 = r11.invoke();     // Catch: Throwable -> L8
        r12.a();     // Catch: InterruptedException -> L6
        return r13;
    L8:
        th = move-exception;
        r12.a();     // Catch: InterruptedException -> L6
        throw th;     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
    }
}

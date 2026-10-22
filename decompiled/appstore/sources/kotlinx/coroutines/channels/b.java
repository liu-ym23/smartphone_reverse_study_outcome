package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final SendChannel a(CoroutineScope r10, CoroutineContext r11, int r12, CoroutineStart r13, Function1 r14, Function2 r15) {
        CoroutineContext r16 = CoroutineContextKt.e(r10, r11);
        Channel r17 = e.b(r12, null, null, 6, null);
        if (r13.isLazy() == false) goto L5;
        a r18 = new LazyActorCoroutine(r16, r17, r15);
    L6:
        if (r14 == null) goto L8;
        r18.invokeOnCompletion(r14);
    L8:
        r18.q0(r13, r18, r15);
        return r18;
    L5:
        r18 = new a(r16, r17, true);
        goto L6
    }

    public static /* synthetic */ SendChannel b(CoroutineScope r10, CoroutineContext r11, int r12, CoroutineStart r13, Function1 r14, Function2 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        r11 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r18 = r11;
        if ((r16 & 2) == 0) goto L8;
        r12 = 0;
    L8:
        int r19 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = CoroutineStart.DEFAULT;
    L11:
        CoroutineStart r20 = r13;
        if ((r16 & 8) == 0) goto L15;
        r14 = null;
    L15:
        return a(r10, r18, r19, r20, r14, r15);
    }
}

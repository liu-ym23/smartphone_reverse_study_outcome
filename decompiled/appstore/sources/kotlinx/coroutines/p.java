package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p {
    public static final void a(CancellableContinuation r10, DisposableHandle r11) {
        r10.invokeOnCancellation(new n0(r11));
    }

    public static final n b(Continuation r10) {
        if ((r10 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        n r11 = ((kotlinx.coroutines.internal.i) r10).h();
        if (r11 == null) goto L16;
        if (r11.B() == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L16;
        return r11;
    L16:
        return new n(r10, 2);
    L5:
        return new n(r10, 1);
    }
}

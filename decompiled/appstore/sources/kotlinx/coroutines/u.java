package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u {
    public static final CompletableDeferred a(Job r10) {
        return new t(r10);
    }

    public static /* synthetic */ CompletableDeferred b(Job r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return a(r10);
    }
}

package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class x1 {
    public static final CompletableJob a(Job r10) {
        return new w1(r10);
    }

    public static /* synthetic */ CompletableJob b(Job r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return a(r10);
    }
}

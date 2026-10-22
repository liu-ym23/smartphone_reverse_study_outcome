package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m {
    public static final void a(int r10) {
        if (r10 < 1) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + r10).toString());
    }
}

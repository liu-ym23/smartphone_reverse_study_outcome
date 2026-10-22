package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o1 extends CoroutineDispatcher {
    public o1() {
    }

    public abstract o1 e();

    public final String f() {
        o1 r10 = l0.c();
        if (this != r10) goto L14;
        return "Dispatchers.Main";
    L14:
        o1 r11 = r10.e();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r11) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r11 = null;
        goto L10
    }
}

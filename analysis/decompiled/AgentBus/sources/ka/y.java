package ka;

/* loaded from: classes.dex */
public abstract class y {
    public static /* synthetic */ boolean close$default(z zVar, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
        if ((i2 & 1) != 0) {
            th = null;
        }
        return zVar.j(th);
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    @c7.a
    public static <E> boolean offer(z zVar, E e10) throws Throwable {
        Object objU = zVar.u(e10);
        if (!(objU instanceof m)) {
            return true;
        }
        Throwable thA = n.a(objU);
        if (thA == null) {
            return false;
        }
        int i2 = na.t.f6928a;
        throw thA;
    }
}

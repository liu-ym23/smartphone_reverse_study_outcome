package og;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public b() {
    }

    public void a(Throwable r10) {
    }

    public final String b(Object r10) {
        return c(r10);
    L6:
        Thread.currentThread().interrupt();
    L8:
        return r10.getClass().getName() + ".errorRendering";
    L4:
        th = move-exception;
        rx.exceptions.a.e(th);
        goto L8
    }

    public String c(Object r10) {
        return null;
    }
}

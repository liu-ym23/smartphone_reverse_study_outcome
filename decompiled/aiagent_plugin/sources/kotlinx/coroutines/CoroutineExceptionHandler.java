package kotlinx.coroutines;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface CoroutineExceptionHandler extends d.c.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38768a = null;

    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class a implements d.c.g.c<CoroutineExceptionHandler> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f38769a = null;

        static {
            f38769a = new a();
        }

        private a() {
        }
    }

    static {
        f38768a = a.f38769a;
    }

    void handleException(d.c.g r1, Throwable r2);
}

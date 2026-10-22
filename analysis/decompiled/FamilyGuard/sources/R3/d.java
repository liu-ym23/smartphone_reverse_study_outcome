package R3;

/* loaded from: classes.dex */
public final class d {
    public static void a() {
        if (S3.a.i()) {
            if ((Thread.currentThread() instanceof O3.i) || S3.a.p()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}

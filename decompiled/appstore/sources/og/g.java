package og;

import java.util.concurrent.ThreadFactory;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f22628a = null;

    static {
        f22628a = new g();
    }

    public g() {
    }

    public static jg.a a() {
        return b(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static jg.a b(ThreadFactory r10) {
        if (r10 == null) goto L6;
        return new rx.internal.schedulers.b(r10);
    L6:
        throw new NullPointerException("threadFactory == null");
    }

    public static jg.a c() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static jg.a d(ThreadFactory r10) {
        if (r10 == null) goto L6;
        return new rx.internal.schedulers.a(r10);
    L6:
        throw new NullPointerException("threadFactory == null");
    }

    public static jg.a e() {
        return f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static jg.a f(ThreadFactory r10) {
        if (r10 == null) goto L6;
        return new rx.internal.schedulers.c(r10);
    L6:
        throw new NullPointerException("threadFactory == null");
    }

    public static g h() {
        return f22628a;
    }

    public jg.a g() {
        return null;
    }

    public jg.a i() {
        return null;
    }

    public jg.a j() {
        return null;
    }

    public Action0 k(Action0 r10) {
        return r10;
    }
}

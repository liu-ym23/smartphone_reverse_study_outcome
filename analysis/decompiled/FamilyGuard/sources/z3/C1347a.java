package z3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import x3.p;
import y3.C1326a;

/* renamed from: z3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1347a {

    /* renamed from: a, reason: collision with root package name */
    private static final p f24067a = C1326a.d(new CallableC0259a());

    /* renamed from: z3.a$a, reason: collision with other inner class name */
    static class CallableC0259a implements Callable<p> {
        CallableC0259a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return b.f24068a;
        }
    }

    /* renamed from: z3.a$b */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final p f24068a = new C1348b(new Handler(Looper.getMainLooper()), false);
    }

    public static p a() {
        return C1326a.e(f24067a);
    }
}

package t4;

import V3.n;
import V3.o;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import j4.k;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f22705a;
    private static volatile Choreographer choreographer;

    static {
        Object objA;
        try {
            n.a aVar = n.f5531a;
            objA = n.a(new C1149c(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            n.a aVar2 = n.f5531a;
            objA = n.a(o.a(th));
        }
        f22705a = (d) (n.c(objA) ? null : objA);
    }

    public static final Handler a(Looper looper, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z5) {
            return new Handler(looper);
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        k.e(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}

package n9;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* renamed from: n9.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1750f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5371a = 0;
    private static volatile Choreographer choreographer;

    static {
        Object objA;
        try {
            objA = new C1748d(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        k.d(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}

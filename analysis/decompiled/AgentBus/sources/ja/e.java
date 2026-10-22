package ja;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import c7.l;
import java.lang.reflect.InvocationTargetException;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5425a = 0;
    private static volatile Choreographer choreographer;

    static {
        Object objN;
        try {
            objN = new d(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        if (objN instanceof l) {
            objN = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        k.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}

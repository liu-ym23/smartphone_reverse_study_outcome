package b6;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import b5.h;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g {
    private static volatile Choreographer choreographer;

    static {
        Object objO;
        try {
            objO = new f(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        if (objO instanceof h) {
            objO = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        p.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}

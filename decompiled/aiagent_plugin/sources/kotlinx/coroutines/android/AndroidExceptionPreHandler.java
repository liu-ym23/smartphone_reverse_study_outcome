package kotlinx.coroutines.android;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: AndroidExceptionPreHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidExceptionPreHandler extends d.c.a implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super((g.c) ZeusTransformUtils.preCheckCast(CoroutineExceptionHandler.f38768a, g.c.class, "com.obric.aiagent.plugin"));
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object r0 = this._preHandler;
        if (r0 != this) goto L5;
        Method r1 = null;
        boolean r3 = false;
        Method r2 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);     // Catch: Throwable -> L16
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L12;
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L12;
        r3 = true;
    L12:
        if (r3 == false) goto L14;
        r1 = r2;
    L14:
        this._preHandler = r1;
        return r1;
    L5:
        return (Method) ZeusTransformUtils.preCheckCast(r0, Method.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(g r4, Throwable r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        int r7 = Build.VERSION.SDK_INT;
        if (26 <= r7) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L19;
        Method r3 = preHandler();
        Thread.UncaughtExceptionHandler r9 = null;
        if (r3 == null) goto L12;
        Object r10 = r3.invoke(null, new Object[0]);
    L14:
        if (ZeusTransformUtils.instanceOf(r10, Thread.UncaughtExceptionHandler.class) == false) goto L16;
        r9 = (Thread.UncaughtExceptionHandler) ZeusTransformUtils.preCheckCast(r10, Thread.UncaughtExceptionHandler.class, "com.obric.aiagent.plugin");
    L16:
        if (r9 == null) goto L20;
        r9.uncaughtException(Thread.currentThread(), r5);
        return;
    L20:
        return;
    L12:
        r10 = null;
        goto L14
    L19:
        return;
    L5:
        if (r7 >= 28) goto L7;
        r8 = true;
        goto L8
    }
}

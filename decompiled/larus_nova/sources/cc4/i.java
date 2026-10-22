package cc4;

import android.view.MotionEvent;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f23292a;

    public i(Window.Callback r100) {
        this.f23292a = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r101.invoke(this.f23292a, r102);
    L3:
        if ("dispatchTouchEvent".equals(r101.getName()) == false) goto L14;
        if (r102 == null) goto L14;
        if (r102.length <= 0) goto L14;
        Object r103 = r102[0];     // Catch: Exception -> L11
        if ((r103 instanceof MotionEvent) == false) goto L14;
        g r104 = g.d();     // Catch: Exception -> L11
        r104.j((MotionEvent) r103);     // Catch: Exception -> L11
        goto L14
    }
}

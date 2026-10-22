package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f38850a = null;
    private static volatile Choreographer choreographer;

    public static final Handler a(Looper r8, boolean r9) {
        if (r9 == false) goto L16;
        if (Build.VERSION.SDK_INT < 16) goto L16;
        if (Build.VERSION.SDK_INT < 28) goto L17;
        Object r10 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r8});
        o.a(r10, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) ZeusTransformUtils.preCheckCast(r10, Handler.class, "com.obric.aiagent.plugin");
    L17:
        return (Handler) ZeusTransformUtils.preCheckCast(Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r8, null, true}), Handler.class, "com.obric.aiagent.plugin");
    L14:
        return new Handler(r8);
    L16:
        return new Handler(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object r0 = null;
        Object[] r1 = 0;
        Object[] r2 = 0;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L5
        Object[] r4 = r2 == true ? 1 : 0;
        Object r5 = n.f(new a(a(Looper.getMainLooper(), true), r4, 2, r1 == true ? 1 : 0));     // Catch: Throwable -> L5
    L8:
        if (n.b(r5) == true) goto L11;
        r0 = r5;
    L11:
        f38850a = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        return;
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L8
    }
}

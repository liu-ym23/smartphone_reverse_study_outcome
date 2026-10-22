package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f21315a = null;

    @Nullable
    private static volatile Choreographer choreographer;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object r10 = null;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L5
        Object[] r14 = r12 == true ? 1 : 0;
        Object r15 = Result.m35constructorimpl(new HandlerContext(a(Looper.getMainLooper(), true), r14, 2, r11 == true ? 1 : 0));     // Catch: Throwable -> L5
    L8:
        if (Result.m41isFailureimpl(r15) == true) goto L11;
        r10 = r15;
    L11:
        f21315a = (d) r10;
        return;
    L5:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }

    public static final Handler a(Looper r10, boolean r11) {
        if (r11 == false) goto L6;
        Object r12 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r10});
        q.e(r12, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) r12;
    L6:
        return new Handler(r10);
    }
}

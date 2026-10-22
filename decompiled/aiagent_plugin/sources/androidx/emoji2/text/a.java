package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ConcurrencyHelpers.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: androidx.emoji2.text.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConcurrencyHelpers.java */
    static class C0049a {
        public static Handler a(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    public static /* synthetic */ Thread lambda$7p_q2aXmCr3SeA5TSJ7FKCLsdhk(String r0, Runnable r1) {
        return a(r0, r1);
    }

    static ThreadPoolExecutor a(final String r8) {
        ThreadFactory r7 = new $$Lambda$a$7p_q2aXmCr3SeA5TSJ7FKCLsdhk(r8);
        ThreadPoolExecutor r9 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r7);
        r9.allowCoreThreadTimeOut(true);
        return r9;
    }

    private static /* synthetic */ Thread a(String r2, Runnable r3) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), r2);
        r0.setPriority(10);
        return r0;
    }

    static Handler a() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return C0049a.a(Looper.getMainLooper());
    L7:
        return new Handler(Looper.getMainLooper());
    }
}

package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a {
        @DoNotInline
        public static Handler a(Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    public static /* synthetic */ Thread a(String r10, Runnable r11) {
        return c(r10, r11);
    }

    public static ThreadPoolExecutor b(final String r10) {
        ThreadFactory r11 = new androidx.emoji2.text.a(r10);
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r11);
        r12.allowCoreThreadTimeOut(true);
        return r12;
    }

    public static /* synthetic */ Thread c(String r10, Runnable r11) {
        Thread r12 = new Thread(r11, r10);
        r12.setPriority(10);
        return r12;
    }

    public static Handler d() {
        return a.a(Looper.getMainLooper());
    }
}

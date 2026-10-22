package androidx.core.os;

import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: ExecutorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: compiled from: ExecutorCompat.java */
    private static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f1268a;

        a(Handler r3) {
            this.f1268a = (Handler) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), Handler.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            if (this.f1268a.post((Runnable) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin")), Runnable.class, "com.obric.aiagent.plugin")) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.f1268a + " is shutting down");
        }
    }

    public static Executor a(Handler r1) {
        return new a(r1);
    }
}

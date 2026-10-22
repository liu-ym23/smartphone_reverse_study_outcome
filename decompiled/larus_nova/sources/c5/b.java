package c5;

import com.bytedance.ai.infra.thread_pool.f;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements RejectedExecutionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22446a = 0;

    public static final class a {
    }

    static {
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "poolName");
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable r100, final ThreadPoolExecutor r101) {
        if (r100 == null) goto L4;
        f.f36616f.execute(r100);
    L4:
        if (r101 == null) goto L7;
        f.f36613c.submit(new c5.a(this, r101));
        return;
    }
}

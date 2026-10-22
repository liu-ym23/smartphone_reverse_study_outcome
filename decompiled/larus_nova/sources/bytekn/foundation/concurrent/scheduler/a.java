package bytekn.foundation.concurrent.scheduler;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f21739a;

    /* JADX INFO: renamed from: bytekn.foundation.concurrent.scheduler.a$a, reason: collision with other inner class name */
    public static final class C0379a {
    }

    static {
    }

    @Override // bytekn.foundation.concurrent.scheduler.f
    public final ScheduledExecutorService get() {
        return PThreadExecutorsUtils.newScheduledThreadPool(5, this.f21739a);
    }

    public a(ThreadFactoryImpl r100) {
        this.f21739a = r100;
    }
}

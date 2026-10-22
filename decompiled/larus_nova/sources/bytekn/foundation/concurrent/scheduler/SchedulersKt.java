package bytekn.foundation.concurrent.scheduler;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SchedulersKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0.d<Lazy<i>> f21736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0.d<Lazy<i>> f21737b = null;

    static {
        f21736a = new c0.d(LazyKt.lazy(SchedulersKt$mainSchedulerFactory$1.INSTANCE));
        f21737b = new c0.d(LazyKt.lazy(SchedulersKt$ioSchedulerFactory$1.INSTANCE));
    }
}

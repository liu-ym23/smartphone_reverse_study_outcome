package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.ServiceLoader;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collection<CoroutineExceptionHandler> f39395a = null;

    public static final Collection<CoroutineExceptionHandler> a() {
        return f39395a;
    }

    static {
        f39395a = (Collection) ZeusTransformUtils.preCheckCast(d.n.m.g(d.n.m.a(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator())), Collection.class, "com.obric.aiagent.plugin");
    }

    public static final void a(Throwable r2) {
        Thread r0 = Thread.currentThread();
        r0.getUncaughtExceptionHandler().uncaughtException(r0, r2);
    }
}

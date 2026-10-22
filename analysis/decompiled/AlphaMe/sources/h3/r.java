package h3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final RealConnectionPool f12962a;

    public r() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        RealConnectionPool delegate = new RealConnectionPool(TaskRunner.INSTANCE, 5, 5L, timeUnit);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f12962a = delegate;
    }
}

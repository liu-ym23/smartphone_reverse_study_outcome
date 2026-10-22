package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.am;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f39242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f39243b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39244c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39245d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f39246e = 0;
    public static g f;
    public static final i g = null;
    public static final i h = null;

    static {
        f39242a = am.a("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        f39243b = am.a("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
        f39244c = am.a("kotlinx.coroutines.scheduler.core.pool.size", d.l.n.c(am.a(), 2), 1, 0, 8, null);
        f39245d = am.a("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f39246e = TimeUnit.SECONDS.toNanos(am.a("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
        f = (g) ZeusTransformUtils.preCheckCast(e.f39237a, g.class, "com.obric.aiagent.plugin");
        g = (i) ZeusTransformUtils.preCheckCast(new j(0), i.class, "com.obric.aiagent.plugin");
        h = (i) ZeusTransformUtils.preCheckCast(new j(1), i.class, "com.obric.aiagent.plugin");
    }
}

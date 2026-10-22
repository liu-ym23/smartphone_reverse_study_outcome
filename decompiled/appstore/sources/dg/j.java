package dg;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f19212b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f19213c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f19214d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f19215e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static f f19216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TaskContext f19217g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TaskContext f19218h = null;

    static {
        f19211a = c0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        f19212b = c0.h("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
        f19213c = c0.g("kotlinx.coroutines.scheduler.core.pool.size", bg.h.d(c0.a(), 2), 1, 0, 8, null);
        f19214d = c0.g("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f19215e = TimeUnit.SECONDS.toNanos(c0.h("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
        f19216f = d.f19201a;
        f19217g = new h(0);
        f19218h = new h(1);
    }
}

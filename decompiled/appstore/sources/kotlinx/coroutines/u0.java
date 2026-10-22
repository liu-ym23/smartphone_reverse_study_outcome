package kotlinx.coroutines;

import com.bytedance.apm.battery.config.BatteryFactorConfig;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21759b = null;

    static {
        f21758a = new kotlinx.coroutines.internal.b0("REMOVED_TASK");
        f21759b = new kotlinx.coroutines.internal.b0("CLOSED_EMPTY");
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 a() {
        return f21759b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 b() {
        return f21758a;
    }

    public static final long c(long r10) {
        return r10 / BatteryFactorConfig.WIFI_BPS;
    }

    public static final long d(long r10) {
        if (r10 > 0) goto L6;
        return 0;
    L6:
        if (r10 < 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        return BatteryFactorConfig.WIFI_BPS * r10;
    }
}

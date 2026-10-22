package com.stepos.ailauncher.container.glass;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/container/glass/j;", "", "", "intervalMs", "<init>", "(J)V", "", "force", Const.INTENT_KEY_APIKEY, "(Z)Z", "J", "lastAt", "Companion", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final long INTERVAL_MS = 32;
    private final long intervalMs;
    private long lastAt;

    public j(long j10) {
        this.intervalMs = j10;
    }

    public final boolean a(boolean force) {
        if (force) {
            this.lastAt = SystemClock.uptimeMillis();
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.lastAt < this.intervalMs) {
            return false;
        }
        this.lastAt = jUptimeMillis;
        return true;
    }

    public /* synthetic */ j(long j10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? 32L : j10);
    }
}

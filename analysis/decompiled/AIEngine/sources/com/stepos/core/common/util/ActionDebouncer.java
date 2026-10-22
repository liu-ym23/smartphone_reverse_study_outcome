package com.stepos.core.common.util;

import android.os.SystemClock;
import java.util.HashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ActionDebouncer {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_KEY = "";
    public static final long DEFAULT_WINDOW_MS = 800;
    private final HashMap<String, Long> lastAcceptedMs;
    private final long windowMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public ActionDebouncer() {
        this(0L, 1, null);
    }

    public static /* synthetic */ boolean tryAcquire$default(ActionDebouncer actionDebouncer, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = DEFAULT_KEY;
        }
        return actionDebouncer.tryAcquire(str);
    }

    public final synchronized void reset() {
        this.lastAcceptedMs.clear();
    }

    public final synchronized boolean tryAcquire(String key) {
        g.f(key, "key");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l10 = this.lastAcceptedMs.get(key);
        if (l10 != null && jElapsedRealtime - l10.longValue() < this.windowMs) {
            return false;
        }
        this.lastAcceptedMs.put(key, Long.valueOf(jElapsedRealtime));
        return true;
    }

    public ActionDebouncer(long j10) {
        this.windowMs = j10;
        this.lastAcceptedMs = new HashMap<>();
    }

    public /* synthetic */ ActionDebouncer(long j10, int i10, e eVar) {
        this((i10 & 1) != 0 ? 800L : j10);
    }
}

package com.stepos.core.ota.process;

import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaIdleExitPolicy {
    public static final OtaIdleExitPolicy INSTANCE = new OtaIdleExitPolicy();
    public static final long PAUSED_EXIT_MS = 3600000;
    public static final long TERMINAL_IDLE_MS = 1800000;
    private static volatile Long pausedExitMsOverride;
    private static volatile Long terminalIdleMsOverride;

    private OtaIdleExitPolicy() {
    }

    private final long getPausedExitMs() {
        Long l10 = pausedExitMsOverride;
        return l10 != null ? l10.longValue() : PAUSED_EXIT_MS;
    }

    private final long getTerminalIdleMs() {
        Long l10 = terminalIdleMsOverride;
        return l10 != null ? l10.longValue() : TERMINAL_IDLE_MS;
    }

    public final Long getPausedExitMsOverride() {
        return pausedExitMsOverride;
    }

    public final Long getTerminalIdleMsOverride() {
        return terminalIdleMsOverride;
    }

    public final Long millisUntilExit(Map<String, OtaStateSnapshot> snapshots, long j10) {
        g.f(snapshots, "snapshots");
        if (snapshots.isEmpty()) {
            return null;
        }
        Collection<OtaStateSnapshot> collectionValues = snapshots.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((OtaStateSnapshot) it.next()).getState().isActive()) {
                    return null;
                }
            }
        }
        boolean z = false;
        long jMax = 0;
        for (OtaStateSnapshot otaStateSnapshot : snapshots.values()) {
            OtaState state = otaStateSnapshot.getState();
            if (state instanceof OtaState.Paused) {
                jMax = Math.max(jMax, otaStateSnapshot.getUpdatedAtMonotonicMs() + getPausedExitMs());
            } else if ((state instanceof OtaState.Installed) || (state instanceof OtaState.Failed)) {
                jMax = Math.max(jMax, otaStateSnapshot.getUpdatedAtMonotonicMs() + getTerminalIdleMs());
            } else if (!(state instanceof OtaState.Idle) && !(state instanceof OtaState.Removed)) {
                return null;
            }
            z = true;
        }
        if (!z) {
            return null;
        }
        long j11 = jMax - j10;
        return Long.valueOf(j11 >= 0 ? j11 : 0L);
    }

    public final void setPausedExitMsOverride(Long l10) {
        pausedExitMsOverride = l10;
    }

    public final void setTerminalIdleMsOverride(Long l10) {
        terminalIdleMsOverride = l10;
    }

    public final boolean shouldExitNow(Map<String, OtaStateSnapshot> snapshots, long j10) {
        g.f(snapshots, "snapshots");
        Collection<OtaStateSnapshot> collectionValues = snapshots.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((OtaStateSnapshot) it.next()).getState().isActive()) {
                    return false;
                }
            }
        }
        Long lMillisUntilExit = millisUntilExit(snapshots, j10);
        return lMillisUntilExit != null && lMillisUntilExit.longValue() == 0;
    }
}

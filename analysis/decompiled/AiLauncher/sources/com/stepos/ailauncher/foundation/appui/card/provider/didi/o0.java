package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\bJ!\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010 \u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0014¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u0004008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004008\u0006¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104R\u0014\u00107\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010:\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010;\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010/¨\u0006<"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/o0;", "", "<init>", "()V", "", D6.a.KEY_TASK_STATUS, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Integer;)Z", "", "trackStatus", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Integer;Ljava/lang/String;)Z", "f", "current", "incoming", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "iso", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/Long;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;", "vendor", "nextPollAt", "nowWallMs", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/String;Ljava/lang/Integer;J)J", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;Ljava/lang/Integer;)J", "consecutiveFailures", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/p0;ILjava/lang/Integer;)J", "elapsedSinceStartMs", "e", "(J)Z", "k", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "MIN_INTERVAL_MS", "J", "MAX_INTERVAL_MS", "FALLBACK_ACTIVE_MS", "FALLBACK_ON_TRIP_MS", "BUDGET_MS", "MAX_BACKOFF_MS", "EXTRA_TICKS_AFTER_TERMINAL", "I", "", "TERMINAL_TASK_STATUSES", "Ljava/util/Set;", "getTERMINAL_TASK_STATUSES", "()Ljava/util/Set;", "POLLABLE_TASK_STATUSES", "getPOLLABLE_TASK_STATUSES", "TRACK_STATUS_TERMINAL", "Ljava/lang/String;", "TRACK_STATUS_PAUSED", "TRACK_STATUS_ACTIVE", "TERMINAL_STATUS_RANK", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o0 {
    public static final long BUDGET_MS = 2700000;
    public static final int EXTRA_TICKS_AFTER_TERMINAL = 2;
    public static final long FALLBACK_ACTIVE_MS = 5000;
    public static final long FALLBACK_ON_TRIP_MS = 20000;
    public static final long MAX_BACKOFF_MS = 60000;
    public static final long MAX_INTERVAL_MS = 60000;
    public static final long MIN_INTERVAL_MS = 3000;
    private static final int TERMINAL_STATUS_RANK = 100;
    public static final String TRACK_STATUS_ACTIVE = "active";
    public static final String TRACK_STATUS_PAUSED = "paused";
    public static final String TRACK_STATUS_TERMINAL = "terminal";
    public static final o0 INSTANCE = new o0();
    private static final Set<Integer> TERMINAL_TASK_STATUSES = Z8.Y.j(0, 6, 7, 27, 8, 9, 10);
    private static final Set<Integer> POLLABLE_TASK_STATUSES = Z8.Y.j(2, 3, 4, 5);

    public final boolean a(Integer taskStatus, String trackStatus) {
        return taskStatus != null && taskStatus.intValue() == 6 && kotlin.jvm.internal.p.d(trackStatus, "active");
    }

    public final long b(TaxiVendorSpec vendor, int consecutiveFailures, Integer taskStatus) {
        kotlin.jvm.internal.p.i(vendor, "vendor");
        long jC = c(vendor, taskStatus);
        return consecutiveFailures <= 0 ? jC : C5685n.k(jC << C5685n.j(consecutiveFailures - 1, 10), Math.max(60000L, jC));
    }

    public final long c(TaxiVendorSpec vendor, Integer taskStatus) {
        kotlin.jvm.internal.p.i(vendor, "vendor");
        Long l10 = vendor.j().get(taskStatus);
        return l10 != null ? l10.longValue() : (taskStatus != null && taskStatus.intValue() == 5) ? 20000L : 5000L;
    }

    public final long d(TaxiVendorSpec vendor, String nextPollAt, Integer taskStatus, long nowWallMs) {
        kotlin.jvm.internal.p.i(vendor, "vendor");
        Long l10 = vendor.j().get(taskStatus);
        if (l10 != null) {
            return l10.longValue();
        }
        Long lJ = j(nextPollAt);
        return lJ != null ? C5685n.o(lJ.longValue() - nowWallMs, 3000L, 60000L) : c(vendor, taskStatus);
    }

    public final boolean e(long elapsedSinceStartMs) {
        return elapsedSinceStartMs >= BUDGET_MS;
    }

    public final boolean f(Integer taskStatus) {
        return taskStatus != null && POLLABLE_TASK_STATUSES.contains(taskStatus);
    }

    public final boolean g(Integer current, Integer incoming) {
        return !kotlin.jvm.internal.p.d(current, incoming) && h(current, incoming);
    }

    public final boolean h(Integer current, Integer incoming) {
        if (kotlin.jvm.internal.p.d(current, incoming)) {
            return true;
        }
        Integer numK = k(current);
        Integer numK2 = k(incoming);
        return numK2 == null ? numK == null : numK == null || numK2.intValue() >= numK.intValue();
    }

    public final boolean i(Integer taskStatus) {
        return taskStatus != null && TERMINAL_TASK_STATUSES.contains(taskStatus);
    }

    public final Long j(String iso) {
        String string;
        Object objB;
        Object objB2;
        if (iso != null && (string = La.H.D1(iso).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(Long.valueOf(Instant.parse(string).toEpochMilli()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                Long l10 = (Long) objB;
                if (l10 != null) {
                    return l10;
                }
                try {
                    objB2 = Result.b(Long.valueOf(OffsetDateTime.parse(string).toInstant().toEpochMilli()));
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th2));
                }
                return (Long) (Result.g(objB2) ? null : objB2);
            }
        }
        return null;
    }

    public final Integer k(Integer taskStatus) {
        if (taskStatus == null) {
            return null;
        }
        return POLLABLE_TASK_STATUSES.contains(taskStatus) ? taskStatus : TERMINAL_TASK_STATUSES.contains(taskStatus) ? 100 : null;
    }
}

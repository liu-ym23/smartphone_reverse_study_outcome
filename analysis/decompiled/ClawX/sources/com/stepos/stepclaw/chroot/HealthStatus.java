package com.stepos.stepclaw.chroot;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/chroot/HealthStatus;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "OK", "WARNING", "CRITICAL", "FATAL", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HealthStatus {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ HealthStatus[] $VALUES;
    public static final HealthStatus OK = new HealthStatus("OK", 0);
    public static final HealthStatus WARNING = new HealthStatus("WARNING", 1);
    public static final HealthStatus CRITICAL = new HealthStatus("CRITICAL", 2);
    public static final HealthStatus FATAL = new HealthStatus("FATAL", 3);

    private static final /* synthetic */ HealthStatus[] $values() {
        return new HealthStatus[]{OK, WARNING, CRITICAL, FATAL};
    }

    static {
        HealthStatus[] healthStatusArr$values = $values();
        $VALUES = healthStatusArr$values;
        $ENTRIES = a.a.F(healthStatusArr$values);
    }

    private HealthStatus(String str, int i8) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static HealthStatus valueOf(String str) {
        return (HealthStatus) Enum.valueOf(HealthStatus.class, str);
    }

    public static HealthStatus[] values() {
        return (HealthStatus[]) $VALUES.clone();
    }
}

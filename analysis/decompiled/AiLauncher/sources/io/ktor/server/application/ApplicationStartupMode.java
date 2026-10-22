package io.ktor.server.application;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/server/application/ApplicationStartupMode;", "", "<init>", "(Ljava/lang/String;I)V", "SEQUENTIAL", "CONCURRENT", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationStartupMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ApplicationStartupMode[] $VALUES;
    public static final ApplicationStartupMode SEQUENTIAL = new ApplicationStartupMode("SEQUENTIAL", 0);
    public static final ApplicationStartupMode CONCURRENT = new ApplicationStartupMode("CONCURRENT", 1);

    private static final /* synthetic */ ApplicationStartupMode[] $values() {
        return new ApplicationStartupMode[]{SEQUENTIAL, CONCURRENT};
    }

    static {
        ApplicationStartupMode[] applicationStartupModeArr$values = $values();
        $VALUES = applicationStartupModeArr$values;
        $ENTRIES = kotlin.enums.a.a(applicationStartupModeArr$values);
    }

    private ApplicationStartupMode(String str, int i10) {
    }

    public static InterfaceC4149a<ApplicationStartupMode> getEntries() {
        return $ENTRIES;
    }

    public static ApplicationStartupMode valueOf(String str) {
        return (ApplicationStartupMode) Enum.valueOf(ApplicationStartupMode.class, str);
    }

    public static ApplicationStartupMode[] values() {
        return (ApplicationStartupMode[]) $VALUES.clone();
    }
}

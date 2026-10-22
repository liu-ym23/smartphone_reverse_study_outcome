package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentbus/generated/CronRunStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "OK", "ERROR", "SKIPPED", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CronRunStatus {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ CronRunStatus[] $VALUES;
    public static final CronRunStatus OK = new CronRunStatus("OK", 0);
    public static final CronRunStatus ERROR = new CronRunStatus("ERROR", 1);
    public static final CronRunStatus SKIPPED = new CronRunStatus("SKIPPED", 2);

    private static final /* synthetic */ CronRunStatus[] $values() {
        return new CronRunStatus[]{OK, ERROR, SKIPPED};
    }

    static {
        CronRunStatus[] cronRunStatusArr$values = $values();
        $VALUES = cronRunStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(cronRunStatusArr$values);
    }

    private CronRunStatus(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static CronRunStatus valueOf(String str) {
        return (CronRunStatus) Enum.valueOf(CronRunStatus.class, str);
    }

    public static CronRunStatus[] values() {
        return (CronRunStatus[]) $VALUES.clone();
    }
}

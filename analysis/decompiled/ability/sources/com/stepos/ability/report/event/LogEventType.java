package com.stepos.ability.report.event;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ability/report/event/LogEventType;", "", "value", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "START_CALL", "END_CALL", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogEventType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ LogEventType[] $VALUES;
    private final String value;
    public static final LogEventType START_CALL = new LogEventType("START_CALL", 0, "start_call");
    public static final LogEventType END_CALL = new LogEventType("END_CALL", 1, "end_call");

    private static final /* synthetic */ LogEventType[] $values() {
        return new LogEventType[]{START_CALL, END_CALL};
    }

    static {
        LogEventType[] logEventTypeArr$values = $values();
        $VALUES = logEventTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(logEventTypeArr$values);
    }

    private LogEventType(String str, int i, String str2) {
        this.value = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static LogEventType valueOf(String str) {
        return (LogEventType) Enum.valueOf(LogEventType.class, str);
    }

    public static LogEventType[] values() {
        return (LogEventType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}

package com.stepos.motionkit;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/motionkit/ErrorLevel;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "WARNING", "DEGRADED", "FATAL", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ErrorLevel {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ErrorLevel[] $VALUES;
    public static final ErrorLevel WARNING = new ErrorLevel("WARNING", 0);
    public static final ErrorLevel DEGRADED = new ErrorLevel("DEGRADED", 1);
    public static final ErrorLevel FATAL = new ErrorLevel("FATAL", 2);

    private static final /* synthetic */ ErrorLevel[] $values() {
        return new ErrorLevel[]{WARNING, DEGRADED, FATAL};
    }

    static {
        ErrorLevel[] errorLevelArr$values = $values();
        $VALUES = errorLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(errorLevelArr$values);
    }

    private ErrorLevel(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ErrorLevel valueOf(String str) {
        return (ErrorLevel) Enum.valueOf(ErrorLevel.class, str);
    }

    public static ErrorLevel[] values() {
        return (ErrorLevel[]) $VALUES.clone();
    }
}

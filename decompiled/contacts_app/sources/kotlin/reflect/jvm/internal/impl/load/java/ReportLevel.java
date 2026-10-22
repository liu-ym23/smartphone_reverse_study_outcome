package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReportLevel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ReportLevel extends Enum<ReportLevel> {
    private static final /* synthetic */ ReportLevel[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReportLevel IGNORE = null;
    public static final ReportLevel STRICT = null;
    public static final ReportLevel WARN = null;
    private final String description;

    /* JADX INFO: compiled from: ReportLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ReportLevel[] $values() {
        return new ReportLevel[]{IGNORE, WARN, STRICT};
    }

    public static ReportLevel valueOf(String r1) {
        return (ReportLevel) Enum.valueOf(ReportLevel.class, r1);
    }

    public static ReportLevel[] values() {
        return (ReportLevel[]) $VALUES.clone();
    }

    private ReportLevel(String r1, int r2, String r3) {
        super(r1, r2);
        this.description = r3;
    }

    public final String getDescription() {
        return this.description;
    }

    static {
        IGNORE = new ReportLevel("IGNORE", 0, "ignore");
        WARN = new ReportLevel("WARN", 1, "warn");
        STRICT = new ReportLevel("STRICT", 2, "strict");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final boolean isWarning() {
        if (this != WARN) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isIgnore() {
        if (this != IGNORE) goto L5;
        return true;
    L5:
        return false;
    }
}

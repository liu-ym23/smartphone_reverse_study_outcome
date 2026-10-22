package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ReportLevel {
    public static final ReportLevel b;
    public static final ReportLevel c;
    public static final ReportLevel d;
    public static final /* synthetic */ ReportLevel[] e;

    /* renamed from: a, reason: collision with root package name */
    public final String f4989a;

    static {
        ReportLevel reportLevel = new ReportLevel("IGNORE", 0, "ignore");
        b = reportLevel;
        ReportLevel reportLevel2 = new ReportLevel("WARN", 1, "warn");
        c = reportLevel2;
        ReportLevel reportLevel3 = new ReportLevel("STRICT", 2, "strict");
        d = reportLevel3;
        ReportLevel[] reportLevelArr = {reportLevel, reportLevel2, reportLevel3};
        e = reportLevelArr;
        kotlin.enums.a.a(reportLevelArr);
    }

    public ReportLevel(String str, int i, String str2) {
        this.f4989a = str2;
    }

    public static ReportLevel valueOf(String str) {
        return (ReportLevel) Enum.valueOf(ReportLevel.class, str);
    }

    public static ReportLevel[] values() {
        return (ReportLevel[]) e.clone();
    }
}

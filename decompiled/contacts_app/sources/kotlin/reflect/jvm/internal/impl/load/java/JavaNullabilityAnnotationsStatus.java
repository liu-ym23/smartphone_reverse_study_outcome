package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JavaNullabilityAnnotationsStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaNullabilityAnnotationsStatus {
    public static final Companion Companion = null;
    private static final JavaNullabilityAnnotationsStatus DEFAULT = null;
    private final ReportLevel reportLevelAfter;
    private final ReportLevel reportLevelBefore;
    private final KotlinVersion sinceVersion;

    /* JADX INFO: compiled from: JavaNullabilityAnnotationsStatus.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final JavaNullabilityAnnotationsStatus getDEFAULT() {
            return JavaNullabilityAnnotationsStatus.access$getDEFAULT$cp();
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JavaNullabilityAnnotationsStatus) == true) goto L8;
        return false;
    L8:
        JavaNullabilityAnnotationsStatus r6 = (JavaNullabilityAnnotationsStatus) r5;
        if (this.reportLevelBefore == r6.reportLevelBefore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sinceVersion, r6.sinceVersion) == true) goto L15;
        return false;
    L15:
        if (this.reportLevelAfter == r6.reportLevelAfter) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.reportLevelBefore.hashCode() * 31;
        KotlinVersion r1 = this.sinceVersion;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.reportLevelAfter.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.reportLevelBefore + ", sinceVersion=" + this.sinceVersion + ", reportLevelAfter=" + this.reportLevelAfter + ')';
    }

    public JavaNullabilityAnnotationsStatus(ReportLevel r2, KotlinVersion r3, ReportLevel r4) {
        Intrinsics.checkNotNullParameter(r2, "reportLevelBefore");
        Intrinsics.checkNotNullParameter(r4, "reportLevelAfter");
        this.reportLevelBefore = r2;
        this.sinceVersion = r3;
        this.reportLevelAfter = r4;
    }

    public static final /* synthetic */ JavaNullabilityAnnotationsStatus access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final ReportLevel getReportLevelBefore() {
        return this.reportLevelBefore;
    }

    public /* synthetic */ JavaNullabilityAnnotationsStatus(ReportLevel r2, KotlinVersion r3, ReportLevel r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = new KotlinVersion(1, 0);
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = r2;
    L8:
        this(r2, r3, r4);
    }

    public final KotlinVersion getSinceVersion() {
        return this.sinceVersion;
    }

    public final ReportLevel getReportLevelAfter() {
        return this.reportLevelAfter;
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new JavaNullabilityAnnotationsStatus(ReportLevel.STRICT, null, null, 6, null);
    }
}

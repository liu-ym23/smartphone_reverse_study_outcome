package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: Jsr305Settings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Jsr305Settings {
    private final Lazy description$delegate;
    private final ReportLevel globalLevel;
    private final boolean isDisabled;
    private final ReportLevel migrationLevel;
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Jsr305Settings) == true) goto L8;
        return false;
    L8:
        Jsr305Settings r6 = (Jsr305Settings) r5;
        if (this.globalLevel == r6.globalLevel) goto L12;
        return false;
    L12:
        if (this.migrationLevel == r6.migrationLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, r6.userDefinedLevelForSpecificAnnotation) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.globalLevel.hashCode() * 31;
        ReportLevel r1 = this.migrationLevel;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(ReportLevel r2, ReportLevel r3, Map<FqName, ? extends ReportLevel> r4) {
        Intrinsics.checkNotNullParameter(r2, "globalLevel");
        Intrinsics.checkNotNullParameter(r4, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = r2;
        this.migrationLevel = r3;
        this.userDefinedLevelForSpecificAnnotation = r4;
        this.description$delegate = LazyKt.lazy(new Jsr305Settings$description$2(this));
        if (r2 == ReportLevel.IGNORE) goto L5;
    L9:
        boolean r5 = false;
    L10:
        this.isDisabled = r5;
        return;
    L5:
        if (r3 != ReportLevel.IGNORE) goto L9;
        if (r4.isEmpty() == false) goto L9;
        r5 = true;
        goto L10
    }

    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    public /* synthetic */ Jsr305Settings(ReportLevel r1, ReportLevel r2, Map r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        this(r1, r2, r3);
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }
}

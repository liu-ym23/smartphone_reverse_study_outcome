package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    private final NullabilityQualifier qualifier;

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus r0, NullabilityQualifier r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.qualifier;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isForWarningOnly;
    L9:
        return r0.copy(r1, r2);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NullabilityQualifierWithMigrationStatus) == true) goto L8;
        return false;
    L8:
        NullabilityQualifierWithMigrationStatus r6 = (NullabilityQualifierWithMigrationStatus) r5;
        if (this.qualifier == r6.qualifier) goto L12;
        return false;
    L12:
        if (this.isForWarningOnly == r6.isForWarningOnly) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int r0 = this.qualifier.hashCode() * 31;
        boolean r1 = this.isForWarningOnly;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.qualifier + ", isForWarningOnly=" + this.isForWarningOnly + ')';
    }

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "qualifier");
        this.qualifier = r2;
        this.isForWarningOnly = r3;
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }
}

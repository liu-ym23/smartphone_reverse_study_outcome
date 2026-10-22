package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers r0, NullabilityQualifierWithMigrationStatus r1, Collection r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.nullabilityQualifier;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.qualifierApplicabilityTypes;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.definitelyNotNull;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus r1, Collection<? extends AnnotationQualifierApplicabilityType> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r2, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JavaDefaultQualifiers) == true) goto L8;
        return false;
    L8:
        JavaDefaultQualifiers r6 = (JavaDefaultQualifiers) r5;
        if (Intrinsics.areEqual(this.nullabilityQualifier, r6.nullabilityQualifier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.qualifierApplicabilityTypes, r6.qualifierApplicabilityTypes) == true) goto L15;
        return false;
    L15:
        if (this.definitelyNotNull == r6.definitelyNotNull) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31;
        boolean r2 = this.definitelyNotNull;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", definitelyNotNull=" + this.definitelyNotNull + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r2, Collection<? extends AnnotationQualifierApplicabilityType> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(r3, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = r2;
        this.qualifierApplicabilityTypes = r3;
        this.definitelyNotNull = r4;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus r1, Collection r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) != 0) goto L5;
    L8:
        this(r1, r2, r3);
        return;
    L5:
        if (r1.getQualifier() != NullabilityQualifier.NOT_NULL) goto L7;
        r3 = true;
        goto L8
    L7:
        r3 = false;
        goto L8
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }
}

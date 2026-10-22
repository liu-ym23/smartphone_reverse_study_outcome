package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaNullabilityAnnotationSettingsKt {
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = null;
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE = null;
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS = null;
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS = null;

    static {
        FqName r0 = new FqName("org.jspecify.nullness");
        JSPECIFY_ANNOTATIONS_PACKAGE = r0;
        FqName r1 = new FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = r1;
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(new Pair[]{TuplesKt.to(new FqName("org.jetbrains.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(r1, JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation.RecentlyNullable"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null)), TuplesKt.to(new FqName("lombok"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(r0, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 8), ReportLevel.STRICT)), TuplesKt.to(new FqName("io.reactivex.rxjava3.annotations"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 8), ReportLevel.STRICT))}));
        JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, null, null, 4, null);
    }

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = KotlinVersion.CURRENT;
    L6:
        return getDefaultJsr305Settings(r0);
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion r6) {
        Intrinsics.checkNotNullParameter(r6, "configuredKotlinVersion");
        JavaNullabilityAnnotationsStatus r0 = JSR_305_DEFAULT_SETTINGS;
        if (r0.getSinceVersion() != null) goto L5;
    L7:
        ReportLevel r7 = r0.getReportLevelBefore();
    L8:
        ReportLevel r1 = r7;
        return new Jsr305Settings(r1, getDefaultMigrationJsr305ReportLevelForGivenGlobal(r1), null, 4, null);
    L5:
        if (r0.getSinceVersion().compareTo2(r6) > 0) goto L7;
        r7 = r0.getReportLevelAfter();
        goto L8
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel r1) {
        Intrinsics.checkNotNullParameter(r1, "globalReportLevel");
        if (r1 != ReportLevel.WARN) goto L6;
        return null;
    L6:
        return r1;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName r3) {
        Intrinsics.checkNotNullParameter(r3, "annotationFqName");
        return getReportLevelForAnnotation$default(r3, NullabilityAnnotationStates.Companion.getEMPTY(), null, 4, null);
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName r1, NullabilityAnnotationStates r2, KotlinVersion r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = new KotlinVersion(1, 7, 20);
    L6:
        return getReportLevelForAnnotation(r1, r2, r3);
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName r1, NullabilityAnnotationStates<? extends ReportLevel> r2, KotlinVersion r3) {
        Intrinsics.checkNotNullParameter(r1, "annotation");
        Intrinsics.checkNotNullParameter(r2, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(r3, "configuredKotlinVersion");
        ReportLevel r4 = r2.get(r1);
        if (r4 == null) goto L5;
        return r4;
    L5:
        JavaNullabilityAnnotationsStatus r5 = NULLABILITY_ANNOTATION_SETTINGS.get(r1);
        if (r5 != null) goto L10;
        return ReportLevel.IGNORE;
    L10:
        if (r5.getSinceVersion() == null) goto L15;
        if (r5.getSinceVersion().compareTo2(r3) > 0) goto L15;
        return r5.getReportLevelAfter();
    L15:
        return r5.getReportLevelBefore();
    }
}

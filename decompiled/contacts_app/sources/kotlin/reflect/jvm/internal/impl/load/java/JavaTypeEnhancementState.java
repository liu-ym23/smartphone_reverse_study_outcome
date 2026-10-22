package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypeEnhancementState {
    public static final Companion Companion = null;
    private static final JavaTypeEnhancementState DEFAULT = null;
    private final boolean disabledDefaultAnnotations;
    private final Function1<FqName, ReportLevel> getReportLevelForAnnotation;
    private final Jsr305Settings jsr305;

    /* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeEnhancementState getDEFAULT() {
            return JavaTypeEnhancementState.access$getDEFAULT$cp();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(Jsr305Settings r2, Function1<? super FqName, ? extends ReportLevel> r3) {
        Intrinsics.checkNotNullParameter(r2, "jsr305");
        Intrinsics.checkNotNullParameter(r3, "getReportLevelForAnnotation");
        this.jsr305 = r2;
        this.getReportLevelForAnnotation = r3;
        if (r2.isDisabled() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        this.disabledDefaultAnnotations = r4;
        return;
    L5:
        if (r3.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE) goto L8;
        r4 = false;
        goto L9
    }

    public static final /* synthetic */ JavaTypeEnhancementState access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    static {
        Companion = new Companion(null);
        DEFAULT = new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings$default(null, 1, null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + ')';
    }
}

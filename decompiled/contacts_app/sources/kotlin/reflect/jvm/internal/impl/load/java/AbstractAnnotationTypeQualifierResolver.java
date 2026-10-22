package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractAnnotationTypeQualifierResolver<TAnnotation> {
    private static final Companion Companion = null;

    @Deprecated
    private static final Map<String, AnnotationQualifierApplicabilityType> JAVA_APPLICABILITY_TYPES = null;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final ConcurrentHashMap<Object, TAnnotation> resolvedNicknames;

    /* JADX INFO: compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    protected abstract Iterable<String> enumArguments(TAnnotation r1, boolean r2);

    protected abstract FqName getFqName(TAnnotation r1);

    protected abstract Object getKey(TAnnotation r1);

    protected abstract Iterable<TAnnotation> getMetaAnnotations(TAnnotation r1);

    public AbstractAnnotationTypeQualifierResolver(JavaTypeEnhancementState r2) {
        Intrinsics.checkNotNullParameter(r2, "javaTypeEnhancementState");
        this.javaTypeEnhancementState = r2;
        this.resolvedNicknames = new ConcurrentHashMap();
    }

    private final TAnnotation findAnnotation(TAnnotation r3, FqName r4) {
        Iterator<TAnnotation> r5 = getMetaAnnotations(r3).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        TAnnotation r0 = r5.next();
        if (Intrinsics.areEqual(getFqName(r0), r4) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private final boolean hasAnnotation(TAnnotation r3, FqName r4) {
        Iterable<TAnnotation> r5 = getMetaAnnotations(r3);
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<TAnnotation> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(getFqName(r6.next()), r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) r5).isEmpty() == false) goto L7;
        return false;
    }

    public final TAnnotation resolveTypeQualifierAnnotation(TAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L6;
        return null;
    L6:
        if (CollectionsKt.contains(AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES(), getFqName(r5)) == false) goto L8;
    L29:
        return r5;
    L8:
        if (hasAnnotation(r5, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_FQNAME()) == true) goto L29;
        if (hasAnnotation(r5, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_NICKNAME_FQNAME()) == true) goto L13;
        return null;
    L13:
        ConcurrentHashMap<Object, TAnnotation> r0 = this.resolvedNicknames;
        Object r2 = getKey(r5);
        TAnnotation r3 = r0.get(r2);
        if (r3 != null) goto L33;
        Iterator<TAnnotation> r6 = getMetaAnnotations(r5).iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        TAnnotation r4 = resolveTypeQualifierAnnotation(r6.next());
        if (r4 == null) goto L17;
    L22:
        if (r4 != null) goto L24;
        return null;
    L24:
        TAnnotation r7 = r0.putIfAbsent(r2, r4);
        if (r7 != null) goto L28;
        return r4;
    L28:
        return r7;
    L21:
        r4 = null;
        goto L22
    L33:
        return r3;
    }

    private final JavaDefaultQualifiers resolveQualifierBuiltInDefaultAnnotation(TAnnotation r9) {
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return null;
    L5:
        JavaDefaultQualifiers r2 = AnnotationQualifiersFqNamesKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(getFqName(r9));
        if (r2 == null) goto L18;
        ReportLevel r8 = resolveDefaultAnnotationState(r9);
        if (r8 == ReportLevel.IGNORE) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L14;
        r8 = null;
    L14:
        if (r8 != null) goto L17;
        return null;
    L17:
        return JavaDefaultQualifiers.copy$default(r2, NullabilityQualifierWithMigrationStatus.copy$default(r2.getNullabilityQualifier(), null, r8.isWarning(), 1, null), null, false, 6, null);
    L10:
        r10 = false;
        goto L11
    L18:
        return null;
    }

    private final ReportLevel resolveDefaultAnnotationState(TAnnotation r3) {
        FqName r0 = getFqName(r3);
        if (r0 == null) goto L9;
        if (AnnotationQualifiersFqNamesKt.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(r0) == false) goto L9;
        return this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r0);
    L9:
        return resolveJsr305AnnotationState(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<AnnotationQualifierApplicabilityType> allIfTypeUse(Set<? extends AnnotationQualifierApplicabilityType> r2) {
        if (r2.contains(AnnotationQualifierApplicabilityType.TYPE_USE) == true) goto L5;
        return r2;
    L5:
        return SetsKt.plus(SetsKt.minus(ArraysKt.toSet(AnnotationQualifierApplicabilityType.values()), AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS), r2);
    }

    private final Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> resolveTypeQualifierDefaultAnnotation(TAnnotation r6) {
        if (this.javaTypeEnhancementState.getJsr305().isDisabled() == false) goto L5;
        return null;
    L5:
        TAnnotation r0 = findAnnotation(r6, AnnotationQualifiersFqNamesKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        if (r0 != null) goto L8;
        return null;
    L8:
        Iterator<TAnnotation> r7 = getMetaAnnotations(r6).iterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        TAnnotation r2 = r7.next();
        if (resolveTypeQualifierAnnotation(r2) == null) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
    L18:
        if (r2 != null) goto L20;
        return null;
    L20:
        Iterable<String> r8 = enumArguments(r0, true);
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<String> r9 = r8.iterator();
    L22:
        if (r9.hasNext() == false) goto L27;
        AnnotationQualifierApplicabilityType r3 = JAVA_APPLICABILITY_TYPES.get(r9.next());
        if (r3 == null) goto L22;
        r1.add(r3);
        goto L22
    L27:
        return new Pair(r2, allIfTypeUse(r1));
    L14:
        r4 = false;
        goto L15
    L17:
        r2 = null;
        goto L18
    }

    public final boolean isTypeUseAnnotation(TAnnotation r3) {
        Intrinsics.checkNotNullParameter(r3, "annotation");
        TAnnotation r4 = findAnnotation(r3, StandardNames.FqNames.target);
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterable<String> r2 = enumArguments(r4, false);
        if ((r2 instanceof Collection) == true) goto L8;
    L10:
        Iterator<String> r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r5.next(), KotlinTarget.TYPE.name()) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (((Collection) r2).isEmpty() == false) goto L10;
        return false;
    }

    private final ReportLevel resolveJsr305AnnotationState(TAnnotation r1) {
        ReportLevel r2 = resolveJsr305CustomState(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return this.javaTypeEnhancementState.getJsr305().getGlobalLevel();
    }

    private final ReportLevel resolveJsr305CustomState(TAnnotation r3) {
        ReportLevel r0 = this.javaTypeEnhancementState.getJsr305().getUserDefinedLevelForSpecificAnnotation().get(getFqName(r3));
        if (r0 == null) goto L5;
        return r0;
    L5:
        TAnnotation r4 = findAnnotation(r3, AnnotationQualifiersFqNamesKt.getMIGRATION_ANNOTATION_FQNAME());
        if (r4 == null) goto L35;
        Iterable<String> r5 = enumArguments(r4, false);
        if (r5 == null) goto L36;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L40;
        ReportLevel r2 = this.javaTypeEnhancementState.getJsr305().getMigrationLevel();
        if (r2 != null) goto L34;
        int r7 = r6.hashCode();
        if (r7 == (-2137067054)) goto L30;
        if (r7 == (-1838656823)) goto L26;
        if (r7 == 2656902) goto L22;
        return null;
    L22:
        if (r6.equals("WARN") == true) goto L37;
        return null;
    L37:
        return ReportLevel.WARN;
    L26:
        if (r6.equals("STRICT") == true) goto L38;
        return null;
    L38:
        return ReportLevel.STRICT;
    L30:
        if (r6.equals("IGNORE") == true) goto L39;
        return null;
    L39:
        return ReportLevel.IGNORE;
    L34:
        return r2;
    L40:
        return null;
    L36:
        return null;
    L35:
        return null;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullability(TAnnotation r4, Function1<? super TAnnotation, Boolean> r5) {
        NullabilityQualifierWithMigrationStatus r0 = knownNullability(r4, r5.invoke(r4).booleanValue());
        if (r0 == null) goto L5;
        return r0;
    L5:
        TAnnotation r1 = resolveTypeQualifierAnnotation(r4);
        if (r1 != null) goto L8;
        return null;
    L8:
        ReportLevel r6 = resolveJsr305AnnotationState(r4);
        if (r6.isIgnore() == false) goto L11;
        return null;
    L11:
        NullabilityQualifierWithMigrationStatus r3 = knownNullability(r1, r5.invoke(r1).booleanValue());
        if (r3 != null) goto L14;
        return null;
    L14:
        return NullabilityQualifierWithMigrationStatus.copy$default(r3, null, r6.isWarning(), 1, null);
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(Iterable<? extends TAnnotation> r5, Function1<? super TAnnotation, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Intrinsics.checkNotNullParameter(r6, "forceWarning");
        NullabilityQualifierWithMigrationStatus r1 = (NullabilityQualifierWithMigrationStatus) null;
        Iterator<? extends TAnnotation> r7 = r5.iterator();
        NullabilityQualifierWithMigrationStatus r2 = null;
    L4:
        if (r7.hasNext() == false) goto L23;
        NullabilityQualifierWithMigrationStatus r3 = extractNullability(r7.next(), r6);
        if (r2 == null) goto L21;
        if (r3 == null) goto L4;
        if (Intrinsics.areEqual(r3, r2) == true) goto L4;
        if (r3.isForWarningOnly() == false) goto L18;
        if (r2.isForWarningOnly() == false) goto L4;
    L18:
        if (r3.isForWarningOnly() == true) goto L22;
        if (r2.isForWarningOnly() == true) goto L21;
    L22:
        return null;
    L21:
        r2 = r3;
        goto L4
    L23:
        return r2;
    }

    public final MutabilityQualifier extractMutability(Iterable<? extends TAnnotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        MutabilityQualifier r1 = (MutabilityQualifier) null;
        Iterator<? extends TAnnotation> r6 = r5.iterator();
        MutabilityQualifier r2 = null;
    L4:
        if (r6.hasNext() == false) goto L15;
        FqName r3 = getFqName(r6.next());
        if (JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS().contains(r3) == true) goto L7;
        if (JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS().contains(r3) == false) goto L4;
        MutabilityQualifier r4 = MutabilityQualifier.MUTABLE;
    L11:
        if (r2 == null) goto L14;
        if (r2 == r4) goto L14;
        return null;
    L14:
        r2 = r4;
        goto L4
    L7:
        r4 = MutabilityQualifier.READ_ONLY;
        goto L11
    L15:
        return r2;
    }

    private final JavaDefaultQualifiers extractDefaultQualifiers(TAnnotation r10) {
        JavaDefaultQualifiers r0 = resolveQualifierBuiltInDefaultAnnotation(r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Pair<TAnnotation, Set<AnnotationQualifierApplicabilityType>> r1 = resolveTypeQualifierDefaultAnnotation(r10);
        if (r1 != null) goto L8;
        return null;
    L8:
        TAnnotation r2 = r1.component1();
        Set<AnnotationQualifierApplicabilityType> r3 = r1.component2();
        ReportLevel r11 = resolveJsr305CustomState(r10);
        if (r11 != null) goto L12;
        r11 = resolveJsr305AnnotationState(r2);
    L12:
        if (r11.isIgnore() == false) goto L14;
        return null;
    L14:
        NullabilityQualifierWithMigrationStatus r9 = extractNullability(r2, AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1.INSTANCE);
        if (r9 != null) goto L18;
        return null;
    L18:
        return new JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus.copy$default(r9, null, r11.isWarning(), 1, null), r3, false, 4, null);
    }

    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(JavaTypeQualifiersByElementType r5, Iterable<? extends TAnnotation> r6) {
        Intrinsics.checkNotNullParameter(r6, "annotations");
        if (this.javaTypeEnhancementState.getDisabledDefaultAnnotations() == false) goto L5;
        return r5;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<? extends TAnnotation> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L11;
        JavaDefaultQualifiers r1 = extractDefaultQualifiers(r7.next());
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        ArrayList r2 = r0;
        if (r2.isEmpty() == false) goto L14;
        return r5;
    L14:
        if (r5 == null) goto L18;
        EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> r4 = r5.getDefaultQualifiers();
        if (r4 == null) goto L18;
        EnumMap r8 = new EnumMap(r4);
    L19:
        Iterator r9 = r2.iterator();
        boolean r3 = false;
    L21:
        if (r9.hasNext() == false) goto L26;
        JavaDefaultQualifiers r10 = (JavaDefaultQualifiers) r9.next();
        Iterator<AnnotationQualifierApplicabilityType> r11 = r10.getQualifierApplicabilityTypes().iterator();
    L24:
        if (r11.hasNext() == false) goto L21;
        EnumMap r12 = r8;
        r12.put(r11.next(), r10);
        r3 = true;
        goto L24
    L26:
        if (r3 == true) goto L29;
        return r5;
    L29:
        return new JavaTypeQualifiersByElementType(r8);
    L18:
        r8 = new EnumMap(AnnotationQualifierApplicabilityType.class);
        goto L19
    }

    private final NullabilityQualifierWithMigrationStatus knownNullability(TAnnotation r6, boolean r7) {
        FqName r0 = getFqName(r6);
        if (r0 != null) goto L5;
        return null;
    L5:
        ReportLevel r2 = this.javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(r0);
        if (r2.isIgnore() == false) goto L8;
        return null;
    L8:
        boolean r4 = false;
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(r0) == false) goto L12;
        NullabilityQualifier r5 = NullabilityQualifier.NULLABLE;
    L56:
        if (r2.isWarning() == true) goto L58;
        if (r7 == true) goto L58;
    L60:
        return new NullabilityQualifierWithMigrationStatus(r5, r4);
    L58:
        r4 = true;
        goto L60
    L12:
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(r0) == false) goto L15;
        r5 = NullabilityQualifier.NOT_NULL;
        goto L56
    L15:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_NULLABLE()) == false) goto L18;
        r5 = NullabilityQualifier.NULLABLE;
        goto L56
    L18:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN()) == false) goto L21;
        r5 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L56
    L21:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION()) == false) goto L44;
        String r8 = (String) CollectionsKt.firstOrNull(enumArguments(r6, false));
        if (r8 != null) goto L25;
    L42:
        r5 = NullabilityQualifier.NOT_NULL;
        goto L56
    L25:
        switch(r8.hashCode()) {
            case 73135176: goto L38;
            case 74175084: goto L35;
            case 433141802: goto L31;
            case 1933739535: goto L28;
            default: goto L41;
        };
    L41:
        return null;
    L28:
        if (r8.equals("ALWAYS") == false) goto L41;
    L31:
        if (r8.equals("UNKNOWN") == false) goto L41;
        r5 = NullabilityQualifier.FORCE_FLEXIBILITY;
        goto L56
    L35:
        if (r8.equals("NEVER") == false) goto L41;
    L40:
        r5 = NullabilityQualifier.NULLABLE;
        goto L56
    L38:
        if (r8.equals("MAYBE") == true) goto L40;
    L44:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) == false) goto L47;
        r5 = NullabilityQualifier.NULLABLE;
        goto L56
    L47:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) == false) goto L50;
        r5 = NullabilityQualifier.NOT_NULL;
        goto L56
    L50:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION()) == false) goto L53;
        r5 = NullabilityQualifier.NOT_NULL;
        goto L56
    L53:
        if (Intrinsics.areEqual(r0, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION()) == false) goto L61;
        r5 = NullabilityQualifier.NULLABLE;
        goto L56
    L61:
        return null;
    }

    static {
        Companion = new Companion(null);
        LinkedHashMap r0 = new LinkedHashMap();
        AnnotationQualifierApplicabilityType[] r1 = AnnotationQualifierApplicabilityType.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        AnnotationQualifierApplicabilityType r4 = r1[r3];
        String r5 = r4.getJavaTarget();
        if (r0.get(r5) != null) goto L7;
        r0.put(r5, r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        JAVA_APPLICABILITY_TYPES = r0;
    }
}

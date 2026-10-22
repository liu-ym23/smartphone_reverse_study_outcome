package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* JADX INFO: compiled from: AbstractSignatureParts.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractSignatureParts<TAnnotation> {

    /* JADX INFO: compiled from: AbstractSignatureParts.kt */
    private static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker r1, JavaTypeQualifiersByElementType r2, TypeParameterMarker r3) {
            this.type = r1;
            this.defaultQualifiers = r2;
            this.typeParameterForArgument = r3;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }

    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker r1);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker r1);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract boolean getForceWarning(TAnnotation r1);

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker r1);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker r1);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker r1, KotlinTypeMarker r2);

    public abstract boolean isFromJava(TypeParameterMarker r1);

    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return false;
    }

    public AbstractSignatureParts() {
    }

    public static final /* synthetic */ JavaTypeQualifiersByElementType access$extractAndMergeDefaultQualifiers(AbstractSignatureParts r0, KotlinTypeMarker r1, JavaTypeQualifiersByElementType r2) {
        return r0.extractAndMergeDefaultQualifiers(r1, r2);
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker r2) {
        TypeSystemContext r1 = getTypeSystem();
        if (r1.isMarkedNullable(r1.lowerBoundIfFlexible(r2)) == false) goto L6;
        return NullabilityQualifier.NULLABLE;
    L6:
        if (r1.isMarkedNullable(r1.upperBoundIfFlexible(r2)) == false) goto L11;
        return null;
    L11:
        return NullabilityQualifier.NOT_NULL;
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker r7) {
        NullabilityQualifier r0 = getNullabilityQualifier(r7);
        MutabilityQualifier r1 = null;
        if (r0 != null) goto L8;
        KotlinTypeMarker r2 = getEnhancedForWarnings(r7);
        if (r2 == null) goto L7;
        NullabilityQualifier r3 = getNullabilityQualifier(r2);
    L9:
        TypeSystemContext r4 = getTypeSystem();
        if (JavaToKotlinClassMap.INSTANCE.isReadOnly(getFqNameUnsafe(r4.lowerBoundIfFlexible(r7))) == false) goto L13;
        r1 = MutabilityQualifier.READ_ONLY;
    L15:
        boolean r5 = false;
        if (getTypeSystem().isDefinitelyNotNullType(r7) == false) goto L18;
    L21:
        boolean r6 = true;
    L23:
        if (r3 == r0) goto L26;
        r5 = true;
    L26:
        return new JavaTypeQualifiers(r3, r1, r6, r5);
    L18:
        if (isNotNullTypeParameterCompat(r7) == true) goto L21;
        r6 = false;
        goto L23
    L13:
        if (JavaToKotlinClassMap.INSTANCE.isMutable(getFqNameUnsafe(r4.upperBoundIfFlexible(r7))) == false) goto L15;
        r1 = MutabilityQualifier.MUTABLE;
        goto L15
    L7:
        r3 = null;
        goto L9
    L8:
        r3 = r0;
        goto L9
    }

    private final JavaTypeQualifiers extractQualifiersFromAnnotations(TypeAndDefaultQualifiers r12) {
        NullabilityQualifier r1 = null;
        if (r12.getType() != null) goto L12;
        TypeSystemContext r0 = getTypeSystem();
        TypeParameterMarker r2 = r12.getTypeParameterForArgument();
        if (r2 == null) goto L7;
        TypeVariance r3 = r0.getVariance(r2);
    L9:
        if (r3 != TypeVariance.IN) goto L12;
        return JavaTypeQualifiers.Companion.getNONE();
    L7:
        r3 = null;
    L12:
        boolean r4 = true;
        if (r12.getTypeParameterForArgument() != null) goto L15;
        boolean r5 = true;
    L16:
        KotlinTypeMarker r6 = r12.getType();
        if (r6 == null) goto L20;
        List r7 = getAnnotations(r6);
        if (r7 == null) goto L20;
    L21:
        TypeSystemContext r8 = getTypeSystem();
        KotlinTypeMarker r9 = r12.getType();
        if (r9 == null) goto L26;
        TypeConstructorMarker r10 = r8.typeConstructor(r9);
        if (r10 == null) goto L26;
        TypeParameterMarker r11 = r8.getTypeParameterClassifier(r10);
    L28:
        if (getContainerApplicabilityType() != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) goto L30;
        boolean r13 = true;
    L31:
        if (r5 == false) goto L51;
        if (r13 == false) goto L35;
    L50:
        r7 = CollectionsKt.plus(getContainerAnnotations(), r7);
        goto L51
    L35:
        if (getEnableImprovementsInStrictMode() == false) goto L50;
        KotlinTypeMarker r14 = r12.getType();
        if (r14 != null) goto L39;
    L41:
        boolean r15 = false;
    L42:
        if (r15 == false) goto L50;
        Iterable<TAnnotation> r16 = getContainerAnnotations();
        ArrayList r17 = new ArrayList();
        Iterator<TAnnotation> r18 = r16.iterator();
    L45:
        if (r18.hasNext() == false) goto L49;
        TAnnotation r19 = r18.next();
        if ((!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(r19)) == false) goto L45;
        r17.add(r19);
        goto L45
    L49:
        r7 = CollectionsKt.plus(r17, r7);
        goto L51
    L39:
        if (isArrayOrPrimitiveArray(r14) != true) goto L41;
        r15 = true;
    L51:
        MutabilityQualifier r20 = getAnnotationTypeQualifierResolver().extractMutability(r7);
        NullabilityQualifierWithMigrationStatus r21 = getAnnotationTypeQualifierResolver().extractNullability(r7, new AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(this));
        if (r21 == null) goto L60;
        NullabilityQualifier r110 = r21.getQualifier();
        if (r21.getQualifier() != NullabilityQualifier.NOT_NULL) goto L57;
        if (r11 == null) goto L57;
    L59:
        return new JavaTypeQualifiers(r110, r20, r4, r21.isForWarningOnly());
    L57:
        r4 = false;
        goto L59
    L60:
        if (r5 == true) goto L64;
        if (r13 == true) goto L64;
        AnnotationQualifierApplicabilityType r22 = AnnotationQualifierApplicabilityType.TYPE_USE;
    L65:
        JavaTypeQualifiersByElementType r23 = r12.getDefaultQualifiers();
        if (r23 == null) goto L68;
        JavaDefaultQualifiers r24 = r23.get(r22);
    L69:
        if (r11 == null) goto L71;
        NullabilityQualifierWithMigrationStatus r25 = getBoundsNullability(r11);
    L73:
        if (r25 == null) goto L76;
        NullabilityQualifierWithMigrationStatus r26 = NullabilityQualifierWithMigrationStatus.copy$default(r25, NullabilityQualifier.NOT_NULL, false, 2, null);
        if (r26 == null) goto L76;
    L79:
        if (r25 == null) goto L81;
        NullabilityQualifier r27 = r25.getQualifier();
    L83:
        if (r27 == NullabilityQualifier.NOT_NULL) goto L93;
        if (r11 == null) goto L92;
        if (r24 != null) goto L87;
    L89:
        boolean r28 = false;
    L90:
        if (r28 == false) goto L92;
    L87:
        if (r24.getDefinitelyNotNull() != true) goto L89;
        r28 = true;
    L92:
        boolean r29 = false;
    L94:
        TypeParameterMarker r111 = r12.getTypeParameterForArgument();
        if (r111 == null) goto L101;
        NullabilityQualifierWithMigrationStatus r112 = getBoundsNullability(r111);
        if (r112 == null) goto L101;
        if (r112.getQualifier() != NullabilityQualifier.NULLABLE) goto L102;
        r112 = NullabilityQualifierWithMigrationStatus.copy$default(r112, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
    L102:
        NullabilityQualifierWithMigrationStatus r113 = mostSpecific(r112, r26);
        if (r113 == null) goto L105;
        r1 = r113.getQualifier();
    L105:
        if (r113 != null) goto L107;
    L109:
        r4 = false;
    L111:
        return new JavaTypeQualifiers(r1, r20, r29, r4);
    L107:
        if (r113.isForWarningOnly() != true) goto L109;
    L101:
        r112 = null;
    L93:
        r29 = true;
        goto L94
    L81:
        r27 = null;
    L76:
        if (r24 == null) goto L78;
        r26 = r24.getNullabilityQualifier();
        goto L79
    L78:
        r26 = null;
        goto L79
    L71:
        r25 = null;
        goto L73
    L68:
        r24 = null;
    L64:
        r22 = getContainerApplicabilityType();
        goto L65
    L30:
        r13 = false;
    L26:
        r11 = null;
    L20:
        r7 = CollectionsKt.emptyList();
        goto L21
    L15:
        r5 = false;
        goto L16
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus r2, NullabilityQualifierWithMigrationStatus r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        if (r3 != null) goto L7;
        return r2;
    L7:
        if (r2.isForWarningOnly() == false) goto L12;
        if (r3.isForWarningOnly() == true) goto L12;
        return r3;
    L12:
        if (r2.isForWarningOnly() == true) goto L17;
        if (r3.isForWarningOnly() == false) goto L17;
        return r2;
    L17:
        if (r2.getQualifier().compareTo(r3.getQualifier()) >= 0) goto L20;
        return r3;
    L20:
        if (r2.getQualifier().compareTo(r3.getQualifier()) <= 0) goto L22;
        return r2;
    L22:
        return r3;
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker r9) {
        TypeSystemContext r0 = getTypeSystem();
        if (isFromJava(r9) == true) goto L5;
        return null;
    L5:
        List<KotlinTypeMarker> r10 = r0.getUpperBounds(r9);
        List<KotlinTypeMarker> r1 = r10;
        boolean r3 = r1 instanceof Collection;
        boolean r4 = false;
        if (r3 == true) goto L8;
    L10:
        Iterator<T> r6 = r1.iterator();
    L12:
        if (r6.hasNext() == false) goto L9;
        if (r0.isError((KotlinTypeMarker) r6.next()) == true) goto L12;
        boolean r7 = false;
    L16:
        if (r7 == false) goto L18;
        return null;
    L18:
        if (r3 == true) goto L20;
    L22:
        Iterator<T> r8 = r1.iterator();
    L24:
        if (r8.hasNext() == false) goto L21;
        if (getNullabilityQualifier((KotlinTypeMarker) r8.next()) == null) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L24;
        boolean r12 = true;
    L31:
        if (r12 == false) goto L33;
        ArrayList r2 = r10;
    L54:
        List<KotlinTypeMarker> r13 = r2;
        if ((r13 instanceof Collection) == true) goto L57;
    L59:
        Iterator<T> r14 = r13.iterator();
    L61:
        if (r14.hasNext() == false) goto L58;
        if (r0.isNullableType((KotlinTypeMarker) r14.next()) == true) goto L61;
        boolean r15 = false;
    L65:
        if (r15 == false) goto L67;
        NullabilityQualifier r16 = NullabilityQualifier.NULLABLE;
    L69:
        if (r2 == r10) goto L72;
        r4 = true;
    L72:
        return new NullabilityQualifierWithMigrationStatus(r16, r4);
    L67:
        r16 = NullabilityQualifier.NOT_NULL;
    L58:
        r15 = true;
        goto L65
    L57:
        if (r13.isEmpty() == false) goto L59;
    L33:
        if (r3 == true) goto L35;
    L37:
        Iterator<T> r5 = r1.iterator();
    L39:
        if (r5.hasNext() == false) goto L36;
        if (getEnhancedForWarnings((KotlinTypeMarker) r5.next()) == null) goto L43;
        boolean r17 = true;
    L44:
        if (r17 == false) goto L39;
        boolean r18 = true;
    L46:
        if (r18 == false) goto L73;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r1.iterator();
    L49:
        if (r20.hasNext() == false) goto L53;
        KotlinTypeMarker r21 = getEnhancedForWarnings((KotlinTypeMarker) r20.next());
        if (r21 == null) goto L49;
        r19.add(r21);
        goto L49
    L53:
        r2 = r19;
        goto L54
    L73:
        return null;
    L43:
        r17 = false;
    L36:
        r18 = false;
        goto L46
    L35:
        if (r1.isEmpty() == false) goto L37;
    L28:
        r11 = false;
    L21:
        r12 = false;
        goto L31
    L20:
        if (r1.isEmpty() == false) goto L22;
    L9:
        r7 = true;
        goto L16
    L8:
        if (r1.isEmpty() == false) goto L10;
        goto L9
    }

    public final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiers(KotlinTypeMarker r10, Iterable<? extends KotlinTypeMarker> r11, final TypeEnhancementInfo r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "overrides");
        List<TypeAndDefaultQualifiers> r0 = toIndexed(r10);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<? extends KotlinTypeMarker> r2 = r11.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(toIndexed(r2.next()));
        goto L4
    L6:
        ArrayList r3 = r1;
        if (getForceOnlyHeadTypeConstructor() == false) goto L9;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L27;
        int r15 = 1;
    L28:
        final JavaTypeQualifiers[] r16 = new JavaTypeQualifiers[r15];
        int r4 = 0;
    L29:
        if (r4 >= r15) goto L54;
        JavaTypeQualifiers r5 = extractQualifiersFromAnnotations(r0.get(r4));
        ArrayList r7 = new ArrayList();
        Iterator r6 = r3.iterator();
    L32:
        if (r6.hasNext() == false) goto L41;
        TypeAndDefaultQualifiers r8 = (TypeAndDefaultQualifiers) CollectionsKt.getOrNull((List) r6.next(), r4);
        if (r8 == null) goto L38;
        KotlinTypeMarker r9 = r8.getType();
        if (r9 == null) goto L38;
        JavaTypeQualifiers r17 = extractQualifiers(r9);
    L39:
        if (r17 == null) goto L32;
        r7.add(r17);
    L38:
        r17 = null;
        goto L39
    L41:
        ArrayList r18 = r7;
        if (r4 == 0) goto L44;
    L46:
        boolean r19 = false;
    L47:
        if (r4 == 0) goto L49;
    L51:
        boolean r20 = false;
    L52:
        r16[r4] = TypeEnhancementUtilsKt.computeQualifiersForOverride(r5, r18, r19, r20, r13);
        r4 = r4 + 1;
        goto L29
    L49:
        if (getContainerIsVarargParameter() == false) goto L51;
        r20 = true;
        goto L52
    L44:
        if (isCovariant() == false) goto L46;
        r19 = true;
        goto L47
    L54:
        return new AnonymousClass1(r12, r16);
    L27:
        r15 = r0.size();
        goto L28
    L9:
        if (isCovariant() == true) goto L11;
    L23:
        r14 = false;
        goto L25
    L11:
        if ((r11 instanceof Collection) == true) goto L13;
    L15:
        Iterator<? extends KotlinTypeMarker> r110 = r11.iterator();
    L17:
        if (r110.hasNext() == false) goto L14;
        if ((!isEqual(r10, r110.next())) == false) goto L17;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
    L14:
        r111 = false;
        goto L21
    L13:
        if (((Collection) r11).isEmpty() == false) goto L15;
        goto L14
    }

    private final <T> void flattenTree(T r2, List<T> r3, Function1<? super T, ? extends Iterable<? extends T>> r4) {
        r3.add(r2);
        Iterable<? extends T> r5 = r4.invoke(r2);
        if (r5 == null) goto L8;
        Iterator<? extends T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        flattenTree(r6.next(), r3, r4);
        goto L6
    L10:
        return;
    }

    private final <T> List<T> flattenTree(T r3, Function1<? super T, ? extends Iterable<? extends T>> r4) {
        ArrayList r0 = new ArrayList(1);
        flattenTree(r3, r0, r4);
        return r0;
    }

    private final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker r2, JavaTypeQualifiersByElementType r3) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(r3, getAnnotations(r2));
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker r5) {
        final TypeSystemContext r0 = getTypeSystem();
        return flattenTree(new TypeAndDefaultQualifiers(r5, extractAndMergeDefaultQualifiers(r5, getContainerDefaultTypeQualifiers()), null), new AbstractSignatureParts$toIndexed$1$1(this, r0));
    }
}

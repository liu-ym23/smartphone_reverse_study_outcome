package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: KotlinTypePreparator.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {

    /* JADX INFO: compiled from: KotlinTypePreparator.kt */
    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator$prepareType$1, reason: invalid class name */
    /* JADX INFO: compiled from: KotlinTypePreparator.kt */
    /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<KotlinTypeMarker, UnwrappedType> {
        AnonymousClass1(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "prepareType";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(KotlinTypePreparator.class);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ UnwrappedType invoke(KotlinTypeMarker r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final UnwrappedType invoke2(KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return ((KotlinTypePreparator) this.receiver).prepareType(r2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public /* bridge */ /* synthetic */ KotlinTypeMarker prepareType(KotlinTypeMarker r1) {
        return prepareType(r1);
    }

    public KotlinTypePreparator() {
    }

    private final SimpleType transformToNewType(SimpleType r17) {
        TypeConstructor r0 = r17.getConstructor();
        boolean r2 = true;
        boolean r3 = false;
        IntersectionTypeConstructor r5 = null;
        UnwrappedType r6 = null;
        r6 = null;
        KotlinType r7 = null;
        if ((r0 instanceof CapturedTypeConstructorImpl) == false) goto L25;
        CapturedTypeConstructorImpl r1 = (CapturedTypeConstructorImpl) r0;
        TypeProjection r4 = r1.getProjection();
        if (r4.getProjectionKind() == Variance.IN_VARIANCE) goto L8;
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L15;
        KotlinType r8 = r4.getType();
        if (r8 == null) goto L15;
        r6 = r8.unwrap();
    L15:
        UnwrappedType r9 = r6;
        if (r1.getNewTypeConstructor() != null) goto L22;
        TypeProjection r11 = r1.getProjection();
        Collection<KotlinType> r10 = r1.mo2084getSupertypes();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r12.add(((KotlinType) r13.next()).unwrap());
        goto L19
    L21:
        r1.setNewTypeConstructor(new NewCapturedTypeConstructor(r11, r12, null, 4, null));
    L22:
        CaptureStatus r14 = CaptureStatus.FOR_SUBTYPING;
        NewCapturedTypeConstructor r15 = r1.getNewTypeConstructor();
        Intrinsics.checkNotNull(r15);
        return new NewCapturedType(r14, r15, r9, r17.getAttributes(), r17.isMarkedNullable(), false, 32, null);
    L25:
        if ((r0 instanceof IntegerValueTypeConstructor) == false) goto L33;
        Collection<KotlinType> r16 = ((IntegerValueTypeConstructor) r0).mo2084getSupertypes();
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r19 = r16.iterator();
    L28:
        if (r19.hasNext() == false) goto L31;
        KotlinType r20 = TypeUtils.makeNullableAsSpecified((KotlinType) r19.next(), r17.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(r20, "makeNullableAsSpecified(it, type.isMarkedNullable)");
        r18.add(r20);
        goto L28
    L31:
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r17.getAttributes(), new IntersectionTypeConstructor(r18), CollectionsKt.emptyList(), false, r17.getMemberScope());
    L33:
        if ((r0 instanceof IntersectionTypeConstructor) == true) goto L35;
    L52:
        return r17;
    L35:
        if (r17.isMarkedNullable() == false) goto L52;
        IntersectionTypeConstructor r21 = (IntersectionTypeConstructor) r0;
        Collection<KotlinType> r22 = r21.mo2084getSupertypes();
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L38:
        if (r24.hasNext() == false) goto L40;
        r23.add(TypeUtilsKt.makeNullable((KotlinType) r24.next()));
        r3 = true;
        goto L38
    L40:
        ArrayList r25 = r23;
        if (r3 == false) goto L47;
        KotlinType r26 = r21.getAlternativeType();
        if (r26 == null) goto L46;
        r7 = TypeUtilsKt.makeNullable(r26);
    L46:
        r5 = new IntersectionTypeConstructor(r25).setAlternative(r7);
    L47:
        if (r5 == null) goto L51;
        r21 = r5;
    L51:
        return r21.createType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof KotlinType) == false) goto L21;
        UnwrappedType r6 = ((KotlinType) r5).unwrap();
        if ((r6 instanceof SimpleType) == false) goto L8;
        SimpleType r0 = transformToNewType((SimpleType) r6);
    L17:
        return TypeWithEnhancementKt.inheritEnhancement(r0, r6, new AnonymousClass1(this));
    L8:
        if ((r6 instanceof FlexibleType) == false) goto L19;
        FlexibleType r1 = (FlexibleType) r6;
        SimpleType r2 = transformToNewType(r1.getLowerBound());
        SimpleType r3 = transformToNewType(r1.getUpperBound());
        if (r2 == r1.getLowerBound()) goto L12;
    L15:
        r0 = KotlinTypeFactory.flexibleType(r2, r3);
        goto L17
    L12:
        if (r3 != r1.getUpperBound()) goto L15;
        r0 = r6;
        goto L17
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

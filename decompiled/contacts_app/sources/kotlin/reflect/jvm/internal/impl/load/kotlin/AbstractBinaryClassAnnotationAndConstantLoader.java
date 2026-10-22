package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>> implements AnnotationAndConstantLoader<A, C> {
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
        private final Map<MemberSignature, C> annotationParametersDefaultValues;
        private final Map<MemberSignature, List<A>> memberAnnotations;
        private final Map<MemberSignature, C> propertyConstants;

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer
        public Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }

        public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
            return this.annotationParametersDefaultValues;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> r2, Map<MemberSignature, ? extends C> r3, Map<MemberSignature, ? extends C> r4) {
            Intrinsics.checkNotNullParameter(r2, "memberAnnotations");
            Intrinsics.checkNotNullParameter(r3, "propertyConstants");
            Intrinsics.checkNotNullParameter(r4, "annotationParametersDefaultValues");
            this.memberAnnotations = r2;
            this.propertyConstants = r3;
            this.annotationParametersDefaultValues = r4;
        }
    }

    protected abstract C loadConstant(String r1, Object r2);

    protected abstract C transformToUnsignedConstant(C r1);

    public static final /* synthetic */ AnnotationsContainerWithConstants access$loadAnnotationsAndInitializers(AbstractBinaryClassAnnotationAndConstantLoader r0, KotlinJvmBinaryClass r1) {
        return r0.loadAnnotationsAndInitializers(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public /* bridge */ /* synthetic */ AbstractBinaryClassAnnotationLoader.AnnotationsContainer getAnnotationsContainer(KotlinJvmBinaryClass r1) {
        return getAnnotationsContainer(r1);
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager r2, KotlinClassFinder r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "kotlinClassFinder");
        super(r3);
        this.storage = r2.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(KotlinJvmBinaryClass r2) {
        Intrinsics.checkNotNullParameter(r2, "binaryClass");
        return this.storage.invoke(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadAnnotationDefaultValue(ProtoContainer r8, ProtoBuf.Property r9, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r9, "proto");
        Intrinsics.checkNotNullParameter(r10, "expectedType");
        return loadConstantFromProperty(r8, r9, AnnotatedCallableKind.PROPERTY_GETTER, r10, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer r8, ProtoBuf.Property r9, KotlinType r10) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r9, "proto");
        Intrinsics.checkNotNullParameter(r10, "expectedType");
        return loadConstantFromProperty(r8, r9, AnnotatedCallableKind.PROPERTY, r10, C04711.INSTANCE);
    }

    private final C loadConstantFromProperty(ProtoContainer r11, ProtoBuf.Property r12, AnnotatedCallableKind r13, KotlinType r14, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> r15) {
        KotlinJvmBinaryClass r0 = findClassWithAnnotationsAndInitializers(r11, getSpecialCaseContainerClass(r11, true, true, Flags.IS_CONST.get(r12.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(r12)));
        if (r0 != null) goto L5;
        return null;
    L5:
        boolean r9 = r0.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm());
        MemberSignature r16 = getCallableSignature(r12, r11.getNameResolver(), r11.getTypeTable(), r13, r9);
        if (r16 != null) goto L8;
        return null;
    L8:
        C r17 = r15.invoke(this.storage.invoke(r0), r16);
        if (r17 != null) goto L12;
        return null;
    L12:
        if (UnsignedTypes.isUnsignedType(r14) == true) goto L14;
        return r17;
    L14:
        return transformToUnsignedConstant(r17);
    }

    private final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(final KotlinJvmBinaryClass r11) {
        final HashMap r6 = new HashMap();
        final HashMap r7 = new HashMap();
        final HashMap r8 = new HashMap();
        r11.visitMembers(new C04701(this, r6, r11, r8, r7), getCachedFileContent(r11));
        return new AnnotationsContainerWithConstants(r6, r7, r8);
    }

    protected final boolean isRepeatableWithImplicitContainer(ClassId r3, Map<Name, ? extends ConstantValue<?>> r4) {
        Intrinsics.checkNotNullParameter(r3, "annotationClassId");
        Intrinsics.checkNotNullParameter(r4, "arguments");
        if (Intrinsics.areEqual(r3, SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE()) == true) goto L5;
        return false;
    L5:
        ConstantValue<?> r5 = r4.get(Name.identifier("value"));
        KClassValue.Value.NormalClass r1 = null;
        if ((r5 instanceof KClassValue) == false) goto L8;
        KClassValue r6 = (KClassValue) r5;
    L9:
        if (r6 != null) goto L11;
        return false;
    L11:
        KClassValue.Value r7 = r6.getValue();
        if ((r7 instanceof KClassValue.Value.NormalClass) == false) goto L14;
        r1 = (KClassValue.Value.NormalClass) r7;
    L14:
        if (r1 != null) goto L17;
        return false;
    L17:
        return isImplicitRepeatableContainer(r1.getClassId());
    L8:
        r6 = null;
        goto L9
    }
}

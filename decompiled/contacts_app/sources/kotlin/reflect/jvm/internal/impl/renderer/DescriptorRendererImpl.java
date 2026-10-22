package kotlin.reflect.jvm.internal.impl.renderer;

import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import obric.util.Utils;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate;
    private final DescriptorRendererOptionsImpl options;

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl this$0;

        /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[PropertyAccessorRenderingPolicy.values().length];
                r0[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl r1) {
            this.this$0 = r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor r1, StringBuilder r2) {
            visitClassDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor r1, StringBuilder r2) {
            visitConstructorDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor r1, StringBuilder r2) {
            visitFunctionDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor r1, StringBuilder r2) {
            visitModuleDeclaration2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor r1, StringBuilder r2) {
            visitPackageFragmentDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor r1, StringBuilder r2) {
            visitPackageViewDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor r1, StringBuilder r2) {
            visitPropertyDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor r1, StringBuilder r2) {
            visitPropertyGetterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor r1, StringBuilder r2) {
            visitPropertySetterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor r1, StringBuilder r2) {
            visitReceiverParameterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor r1, StringBuilder r2) {
            visitTypeAliasDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor r1, StringBuilder r2) {
            visitTypeParameterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor r1, StringBuilder r2) {
            visitValueParameterDescriptor2(r1, r2);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderValueParameter(this.this$0, r2, true, r3, true);
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderProperty(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            visitPropertyAccessorDescriptor(r2, r3, "getter");
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            visitPropertyAccessorDescriptor(r2, r3, "setter");
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor r3, StringBuilder r4, String r5) {
            int r0 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getPropertyAccessorRenderingPolicy().ordinal()];
            if (r0 != 1) goto L5;
            DescriptorRendererImpl.access$renderAccessorModifiers(this.this$0, r3, r4);
            r4.append(r5 + " for ");
            DescriptorRendererImpl r2 = this.this$0;
            PropertyDescriptor r6 = r3.getCorrespondingProperty();
            Intrinsics.checkNotNullExpressionValue(r6, "descriptor.correspondingProperty");
            DescriptorRendererImpl.access$renderProperty(r2, r6, r4);
            return;
        L5:
            if (r0 != 2) goto L11;
            visitFunctionDescriptor2(r3, r4);
            return;
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderFunction(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor r1, StringBuilder r2) {
            Intrinsics.checkNotNullParameter(r1, "descriptor");
            Intrinsics.checkNotNullParameter(r2, "builder");
            r2.append(r1.getName());
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderConstructor(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderTypeParameter(this.this$0, r2, r3, true);
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderPackageFragment(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderPackageView(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderName(this.this$0, r2, r3, true);
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderClass(this.this$0, r2, r3);
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor r2, StringBuilder r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            Intrinsics.checkNotNullParameter(r3, "builder");
            DescriptorRendererImpl.access$renderTypeAlias(this.this$0, r2, r3);
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[RenderingFormat.values().length];
            r0[RenderingFormat.PLAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[RenderingFormat.HTML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[ParameterNameRenderingPolicy.values().length];
            r1[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r1;
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(ClassifierNamePolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setClassifierNamePolicy(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean r1) {
        this.options.setDebugMode(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(Set<FqName> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(Set<? extends DescriptorRendererModifier> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setModifiers(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setParameterNameRenderingPolicy(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean r1) {
        this.options.setReceiverAfterName(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean r1) {
        this.options.setRenderCompanionObjectName(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean r1) {
        this.options.setStartFromName(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(RenderingFormat r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.options.setTextFormat(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean r1) {
        this.options.setVerbose(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean r1) {
        this.options.setWithDefinedIn(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean r1) {
        this.options.setWithoutSuperTypes(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean r1) {
        this.options.setWithoutTypeParameters(r1);
    }

    public static final /* synthetic */ void access$renderAccessorModifiers(DescriptorRendererImpl r0, PropertyAccessorDescriptor r1, StringBuilder r2) {
        r0.renderAccessorModifiers(r1, r2);
    }

    public static final /* synthetic */ void access$renderClass(DescriptorRendererImpl r0, ClassDescriptor r1, StringBuilder r2) {
        r0.renderClass(r1, r2);
    }

    public static final /* synthetic */ String access$renderConstant(DescriptorRendererImpl r0, ConstantValue r1) {
        return r0.renderConstant(r1);
    }

    public static final /* synthetic */ void access$renderConstructor(DescriptorRendererImpl r0, ConstructorDescriptor r1, StringBuilder r2) {
        r0.renderConstructor(r1, r2);
    }

    public static final /* synthetic */ void access$renderFunction(DescriptorRendererImpl r0, FunctionDescriptor r1, StringBuilder r2) {
        r0.renderFunction(r1, r2);
    }

    public static final /* synthetic */ void access$renderName(DescriptorRendererImpl r0, DeclarationDescriptor r1, StringBuilder r2, boolean r3) {
        r0.renderName(r1, r2, r3);
    }

    public static final /* synthetic */ void access$renderPackageFragment(DescriptorRendererImpl r0, PackageFragmentDescriptor r1, StringBuilder r2) {
        r0.renderPackageFragment(r1, r2);
    }

    public static final /* synthetic */ void access$renderPackageView(DescriptorRendererImpl r0, PackageViewDescriptor r1, StringBuilder r2) {
        r0.renderPackageView(r1, r2);
    }

    public static final /* synthetic */ void access$renderProperty(DescriptorRendererImpl r0, PropertyDescriptor r1, StringBuilder r2) {
        r0.renderProperty(r1, r2);
    }

    public static final /* synthetic */ void access$renderTypeAlias(DescriptorRendererImpl r0, TypeAliasDescriptor r1, StringBuilder r2) {
        r0.renderTypeAlias(r1, r2);
    }

    public static final /* synthetic */ void access$renderTypeParameter(DescriptorRendererImpl r0, TypeParameterDescriptor r1, StringBuilder r2, boolean r3) {
        r0.renderTypeParameter(r1, r2, r3);
    }

    public static final /* synthetic */ void access$renderValueParameter(DescriptorRendererImpl r0, ValueParameterDescriptor r1, boolean r2, StringBuilder r3, boolean r4) {
        r0.renderValueParameter(r1, r2, r3, r4);
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "options");
        this.options = r2;
        r2.isLocked();
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String renderKeyword(String r3) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r0 != 1) goto L5;
        return r3;
    L5:
        if (r0 != 2) goto L11;
        if (getBoldOnlyForNamesInHtml() == false) goto L13;
        return r3;
    L13:
        return "<b>" + r3 + "</b>";
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private final String renderError(String r2) {
        int r1 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r1 != 1) goto L5;
        return r2;
    L5:
        if (r1 != 2) goto L8;
        return "<font color=red><b>" + r2 + "</b></font>";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final String escape(String r1) {
        return getTextFormat().escape(r1);
    }

    private final String lt() {
        return escape("<");
    }

    private final String gt() {
        return escape(">");
    }

    private final String arrow() {
        RenderingFormat r0 = getTextFormat();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return "&rarr;";
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return escape("->");
    }

    public String renderMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        int r1 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (r1 != 1) goto L5;
        return r2;
    L5:
        if (r1 != 2) goto L8;
        return "<i>" + r2 + "</i>";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderName(Name r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        String r4 = escape(RenderingUtilsKt.render(r2));
        if (getBoldOnlyForNamesInHtml() == true) goto L5;
        return r4;
    L5:
        if (getTextFormat() != RenderingFormat.HTML) goto L10;
        if (r3 == true) goto L8;
        return r4;
    L8:
        return "<b>" + r4 + "</b>";
    L10:
        return r4;
    }

    private final void renderName(DeclarationDescriptor r2, StringBuilder r3, boolean r4) {
        Name r5 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "descriptor.name");
        r3.append(renderName(r5, r4));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor r3, StringBuilder r4) {
        if (getRenderCompanionObjectName() == false) goto L11;
        if (getStartFromName() == false) goto L7;
        r4.append("companion object");
    L7:
        renderSpaceIfNeeded(r4);
        DeclarationDescriptor r0 = r3.getContainingDeclaration();
        if (r0 == null) goto L11;
        r4.append("of ");
        Name r1 = r0.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "containingDeclaration.name");
        r4.append(renderName(r1, false));
    L11:
        if (getVerbose() == true) goto L15;
        if (Intrinsics.areEqual(r3.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT) == false) goto L15;
        return;
    L15:
        if (getStartFromName() == true) goto L17;
        renderSpaceIfNeeded(r4);
    L17:
        Name r5 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "descriptor.name");
        r4.append(renderName(r5, true));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFqName(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        List<Name> r3 = r2.pathSegments();
        Intrinsics.checkNotNullExpressionValue(r3, "fqName.pathSegments()");
        return renderFqName(r3);
    }

    private final String renderFqName(List<Name> r1) {
        return escape(RenderingUtilsKt.renderFqName(r1));
    }

    public String renderClassifierName(ClassifierDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        if (ErrorUtils.isError(r2) == false) goto L6;
        return r2.getTypeConstructor().toString();
    L6:
        return getClassifierNamePolicy().renderClassifier(r2, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderType(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        StringBuilder r0 = new StringBuilder();
        renderNormalizedType(r0, getTypeNormalizer().invoke(r3));
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    }

    private final void renderNormalizedType(StringBuilder r3, KotlinType r4) {
        UnwrappedType r0 = r4.unwrap();
        if ((r0 instanceof AbbreviatedType) == false) goto L5;
        AbbreviatedType r1 = (AbbreviatedType) r0;
    L6:
        if (r1 != null) goto L8;
        renderNormalizedTypeAsIs(r3, r4);
        return;
    L8:
        if (getRenderTypeExpansions() == false) goto L10;
        renderNormalizedTypeAsIs(r3, r1.getExpandedType());
        return;
    L10:
        renderNormalizedTypeAsIs(r3, r1.getAbbreviation());
        if (getRenderUnabbreviatedType() == false) goto L17;
        renderAbbreviatedTypeExpansion(r3, r1);
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder r3, AbbreviatedType r4) {
        if (getTextFormat() != RenderingFormat.HTML) goto L5;
        r3.append("<font color=\"808080\"><i>");
    L5:
        r3.append(" /* = ");
        renderNormalizedTypeAsIs(r3, r4.getExpandedType());
        r3.append(" */");
        if (getTextFormat() != RenderingFormat.HTML) goto L9;
        r3.append("</i></font>");
        return;
    }

    private final void renderNormalizedTypeAsIs(StringBuilder r2, KotlinType r3) {
        if ((r3 instanceof WrappedType) == true) goto L5;
    L10:
        UnwrappedType r4 = r3.unwrap();
        if ((r4 instanceof FlexibleType) == false) goto L14;
        r2.append(((FlexibleType) r4).render(this, this));
        return;
    L14:
        if ((r4 instanceof SimpleType) == false) goto L18;
        renderSimpleType(r2, (SimpleType) r4);
        return;
    L18:
        return;
    L5:
        if (getDebugMode() == false) goto L10;
        if (((WrappedType) r3).isComputed() == true) goto L10;
        r2.append("<Not computed yet>");
    }

    private final void renderSimpleType(StringBuilder r4, SimpleType r5) {
        if (Intrinsics.areEqual(r5, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) == true) goto L23;
        SimpleType r0 = r5;
        if (TypeUtils.isDontCarePlaceholder(r0) == true) goto L23;
        if (ErrorUtils.isUninferredTypeVariable(r0) == false) goto L15;
        if (getUninferredTypeParameterAsName() == false) goto L12;
        TypeConstructor r6 = r5.getConstructor();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        r4.append(renderError(((ErrorTypeConstructor) r6).getParam(0)));
        return;
    L12:
        r4.append("???");
        return;
    L15:
        if (KotlinTypeKt.isError(r0) == false) goto L19;
        renderDefaultType(r4, r0);
        return;
    L19:
        if (shouldRenderAsPrettyFunctionType(r0) == false) goto L21;
        renderFunctionType(r4, r0);
        return;
    L21:
        renderDefaultType(r4, r0);
        return;
    L23:
        r4.append("???");
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType r3) {
        if (FunctionTypesKt.isBuiltinFunctionalType(r3) == false) goto L21;
        List<TypeProjection> r2 = r3.getArguments();
        if ((r2 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        if (((TypeProjection) r4.next()).isStarProjection() == false) goto L11;
        boolean r5 = false;
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        return true;
    L8:
        r5 = true;
        goto L15
    L7:
        if (r2.isEmpty() == false) goto L9;
    L21:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFlexibleType(String r13, String r14, KotlinBuiltIns r15) {
        Intrinsics.checkNotNullParameter(r13, "lowerRendered");
        Intrinsics.checkNotNullParameter(r14, "upperRendered");
        Intrinsics.checkNotNullParameter(r15, "builtIns");
        if (differsOnlyInNullability(r13, r14) == true) goto L5;
        ClassifierNamePolicy r0 = getClassifierNamePolicy();
        ClassDescriptor r4 = r15.getCollection();
        Intrinsics.checkNotNullExpressionValue(r4, "builtIns.collection");
        DescriptorRendererImpl r5 = this;
        String r1 = StringsKt.substringBefore$default(r0.renderClassifier(r4, r5), "Collection", null, 2, null);
        String r6 = replacePrefixes(r13, r1 + "Mutable", r14, r1, r1 + "(Mutable)");
        if (r6 == null) goto L13;
        return r6;
    L13:
        String r2 = replacePrefixes(r13, r1 + "MutableMap.MutableEntry", r14, r1 + "Map.Entry", r1 + "(Mutable)Map.(Mutable)Entry");
        if (r2 == null) goto L16;
        return r2;
    L16:
        ClassifierNamePolicy r3 = getClassifierNamePolicy();
        ClassDescriptor r16 = r15.getArray();
        Intrinsics.checkNotNullExpressionValue(r16, "builtIns.array");
        String r17 = StringsKt.substringBefore$default(r3.renderClassifier(r16, r5), "Array", null, 2, null);
        String r12 = replacePrefixes(r13, r17 + escape("Array<"), r14, r17 + escape("Array<out "), r17 + escape("Array<(out) "));
        if (r12 == null) goto L20;
        return r12;
    L20:
        return "(" + r13 + ".." + r14 + ')';
    L5:
        if (StringsKt.startsWith$default(r14, "(", false, 2, null) == false) goto L9;
        return "(" + r13 + ")!";
    L9:
        return r13 + '!';
    }

    public String renderTypeArguments(List<? extends TypeProjection> r3) {
        Intrinsics.checkNotNullParameter(r3, "typeArguments");
        if (r3.isEmpty() == false) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(lt());
        appendTypeProjections(r0, r3);
        r0.append(gt());
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    }

    private final void renderDefaultType(StringBuilder r7, KotlinType r8) {
        renderAnnotations$default(this, r7, r8, null, 2, null);
        SimpleType r1 = null;
        if ((r8 instanceof DefinitelyNotNullType) == false) goto L5;
        DefinitelyNotNullType r0 = (DefinitelyNotNullType) r8;
    L6:
        if (r0 == null) goto L9;
        r1 = r0.getOriginal();
    L9:
        if (KotlinTypeKt.isError(r8) == false) goto L23;
        if (TypeUtilsKt.isUnresolvedType(r8) == false) goto L16;
        if (getPresentableUnresolvedTypes() == false) goto L16;
        r7.append(((ErrorType) r8).getDebugMessage());
    L21:
        r7.append(renderTypeArguments(r8.getArguments()));
    L30:
        if (r8.isMarkedNullable() == false) goto L33;
        r7.append("?");
    L33:
        if (SpecialTypesKt.isDefinitelyNotNullType(r8) == false) goto L36;
        r7.append(" & Any");
        return;
    L36:
        return;
    L16:
        if ((r8 instanceof ErrorType) == true) goto L18;
    L20:
        r7.append(r8.getConstructor().toString());
        goto L21
    L18:
        if (getInformativeErrorType() == true) goto L20;
        r7.append(((ErrorType) r8).getDebugMessage());
        goto L21
    L23:
        if ((r8 instanceof StubTypeForBuilderInference) == false) goto L26;
        r7.append(((StubTypeForBuilderInference) r8).getOriginalTypeVariable().toString());
        goto L30
    L26:
        if ((r1 instanceof StubTypeForBuilderInference) == false) goto L28;
        r7.append(((StubTypeForBuilderInference) r1).getOriginalTypeVariable().toString());
        goto L30
    L28:
        renderTypeConstructorAndArguments$default(this, r7, r8, null, 2, null);
        goto L30
    L5:
        r0 = null;
        goto L6
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl r0, StringBuilder r1, KotlinType r2, TypeConstructor r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = r2.getConstructor();
    L5:
        r0.renderTypeConstructorAndArguments(r1, r2, r3);
    }

    private final void renderTypeConstructorAndArguments(StringBuilder r2, KotlinType r3, TypeConstructor r4) {
        PossiblyInnerType r0 = TypeParameterUtilsKt.buildPossiblyInnerType(r3);
        if (r0 != null) goto L6;
        r2.append(renderTypeConstructor(r4));
        r2.append(renderTypeArguments(r3.getArguments()));
        return;
    L6:
        renderPossiblyInnerType(r2, r0);
    }

    private final void renderPossiblyInnerType(StringBuilder r3, PossiblyInnerType r4) {
        PossiblyInnerType r0 = r4.getOuterType();
        if (r0 == null) goto L6;
        renderPossiblyInnerType(r3, r0);
        r3.append('.');
        Name r1 = r4.getClassifierDescriptor().getName();
        Intrinsics.checkNotNullExpressionValue(r1, "possiblyInnerType.classifierDescriptor.name");
        if (r3.append(renderName(r1, false)) == null) goto L6;
    L7:
        r3.append(renderTypeArguments(r4.getArguments()));
        return;
    L6:
        TypeConstructor r2 = r4.getClassifierDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r2, "possiblyInnerType.classi…escriptor.typeConstructor");
        r3.append(renderTypeConstructor(r2));
        goto L7
    }

    public String renderTypeConstructor(TypeConstructor r4) {
        Intrinsics.checkNotNullParameter(r4, "typeConstructor");
        ClassifierDescriptor r0 = r4.mo2083getDeclarationDescriptor();
        boolean r2 = true;
        if ((r0 instanceof TypeParameterDescriptor) == false) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r2 = r0 instanceof TypeAliasDescriptor;
    L9:
        if (r2 == true) goto L19;
        if (r0 != null) goto L18;
        if ((r4 instanceof IntersectionTypeConstructor) == false) goto L16;
        return ((IntersectionTypeConstructor) r4).makeDebugNameForIntersectionType(C04751.INSTANCE);
    L16:
        return r4.toString();
    L18:
        throw new IllegalStateException(("Unexpected classifier: " + r0.getClass()).toString());
    L19:
        return renderClassifierName(r0);
    L5:
        r1 = r0 instanceof ClassDescriptor;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderTypeProjection(TypeProjection r2) {
        Intrinsics.checkNotNullParameter(r2, "typeProjection");
        StringBuilder r0 = new StringBuilder();
        appendTypeProjections(r0, CollectionsKt.listOf(r2));
        String r1 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "StringBuilder().apply(builderAction).toString()");
        return r1;
    }

    private final void appendTypeProjections(StringBuilder r11, List<? extends TypeProjection> r12) {
        CollectionsKt.joinTo$default(r12, r11, ", ", null, null, 0, null, new AnonymousClass1(this), 60, null);
    }

    private final void renderFunctionType(StringBuilder r13, KotlinType r14) {
        int r0 = r13.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), r13, r14, null, 2, null);
        if (r13.length() == r0) goto L5;
        boolean r1 = true;
    L6:
        KotlinType r4 = FunctionTypesKt.getReceiverTypeFromFunctionType(r14);
        List<KotlinType> r5 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r14);
        if ((!r5.isEmpty()) == false) goto L13;
        r13.append("context(");
        Iterator<KotlinType> r6 = r5.subList(0, CollectionsKt.getLastIndex(r5)).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        renderNormalizedType(r13, r6.next());
        r13.append(", ");
        goto L10
    L12:
        renderNormalizedType(r13, (KotlinType) CollectionsKt.last(r5));
        r13.append(") ");
    L13:
        boolean r7 = FunctionTypesKt.isSuspendFunctionType(r14);
        boolean r8 = r14.isMarkedNullable();
        if (r8 == true) goto L19;
        if (r1 == false) goto L18;
        if (r4 != null) goto L19;
    L18:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L29;
        if (r7 == false) goto L24;
        r13.insert(r0, '(');
        goto L29
    L24:
        if (r1 == false) goto L28;
        StringBuilder r2 = r13;
        CharsKt.isWhitespace(StringsKt.last(r2));
        if (r13.charAt(StringsKt.getLastIndex(r2) - 1) == ')') goto L28;
        r13.insert(StringsKt.getLastIndex(r2), "()");
    L28:
        r13.append("(");
    L29:
        renderModifier(r13, r7, "suspend");
        if (r4 != null) goto L32;
    L45:
        r13.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(r14) == true) goto L48;
    L50:
        Iterator<TypeProjection> r3 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r14).iterator();
        int r10 = 0;
    L52:
        if (r3.hasNext() == false) goto L63;
        int r11 = r10 + 1;
        TypeProjection r12 = r3.next();
        if (r10 <= 0) goto L57;
        r13.append(", ");
    L57:
        if (getParameterNamesInFunctionalTypes() == false) goto L59;
        KotlinType r15 = r12.getType();
        Intrinsics.checkNotNullExpressionValue(r15, "typeProjection.type");
        Name r16 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r15);
    L60:
        if (r16 == null) goto L62;
        r13.append(renderName(r16, false));
        r13.append(": ");
    L62:
        r13.append(renderTypeProjection(r12));
        r10 = r11;
        goto L52
    L59:
        r16 = null;
    L63:
        r13.append(") ").append(arrow()).append(HanziToPinyin.Token.SEPARATOR);
        renderNormalizedType(r13, FunctionTypesKt.getReturnTypeFromFunctionType(r14));
        if (r9 == false) goto L66;
        r13.append(")");
    L66:
        if (r8 == false) goto L73;
        r13.append("?");
        return;
    L73:
        return;
    L48:
        if (r14.getArguments().size() > 1) goto L50;
        r13.append("???");
        goto L63
    L32:
        if (shouldRenderAsPrettyFunctionType(r4) == false) goto L36;
        if (r4.isMarkedNullable() == true) goto L36;
    L37:
        boolean r17 = true;
    L39:
        if (r17 == false) goto L41;
        r13.append("(");
    L41:
        renderNormalizedType(r13, r4);
        if (r17 == false) goto L44;
        r13.append(")");
    L44:
        r13.append(LibrarianImpl.Constants.DOT);
    L36:
        if (hasModifiersOrAnnotations(r4) == true) goto L37;
        r17 = false;
    L19:
        r9 = true;
        goto L21
    L5:
        r1 = false;
        goto L6
    }

    private final boolean hasModifiersOrAnnotations(KotlinType r1) {
        if (FunctionTypesKt.isSuspendFunctionType(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.getAnnotations().isEmpty() == false) goto L8;
        return false;
    }

    private final void appendDefinedIn(StringBuilder r5, DeclarationDescriptor r6) {
        if ((r6 instanceof PackageFragmentDescriptor) == false) goto L5;
        return;
    L5:
        if ((r6 instanceof PackageViewDescriptor) == true) goto L32;
        DeclarationDescriptor r0 = r6.getContainingDeclaration();
        if (r0 != null) goto L10;
        return;
    L10:
        if ((r0 instanceof ModuleDescriptor) == true) goto L27;
        r5.append(HanziToPinyin.Token.SEPARATOR).append(renderMessage("defined in")).append(HanziToPinyin.Token.SEPARATOR);
        FqNameUnsafe r2 = DescriptorUtils.getFqName(r0);
        Intrinsics.checkNotNullExpressionValue(r2, "getFqName(containingDeclaration)");
        if (r2.isRoot() == false) goto L14;
        String r3 = "root package";
    L15:
        r5.append(r3);
        if (getWithSourceFileForTopLevel() == true) goto L18;
        return;
    L18:
        if ((r0 instanceof PackageFragmentDescriptor) == true) goto L20;
        return;
    L20:
        if ((r6 instanceof DeclarationDescriptorWithSource) == false) goto L30;
        String r7 = ((DeclarationDescriptorWithSource) r6).getSource().getContainingFile().getName();
        if (r7 == null) goto L31;
        r5.append(HanziToPinyin.Token.SEPARATOR).append(renderMessage("in file")).append(HanziToPinyin.Token.SEPARATOR).append(r7);
        return;
    L31:
        return;
    L30:
        return;
    L14:
        r3 = renderFqName(r2);
        goto L15
    L27:
        return;
    }

    static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl r0, StringBuilder r1, Annotated r2, AnnotationUseSiteTarget r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r0.renderAnnotations(r1, r2, r3);
    }

    private final void renderAnnotations(StringBuilder r6, Annotated r7, AnnotationUseSiteTarget r8) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L6;
        return;
    L6:
        if ((r7 instanceof KotlinType) == false) goto L8;
        Set<FqName> r0 = getExcludedTypeAnnotationClasses();
    L9:
        Function1<AnnotationDescriptor, Boolean> r1 = getAnnotationFilter();
        Iterator<AnnotationDescriptor> r9 = r7.getAnnotations().iterator();
    L11:
        if (r9.hasNext() == false) goto L23;
        AnnotationDescriptor r2 = r9.next();
        if (CollectionsKt.contains(r0, r2.getFqName()) == true) goto L11;
        if (isParameterName(r2) == true) goto L11;
        if (r1 == null) goto L19;
        if (r1.invoke(r2).booleanValue() == false) goto L11;
    L19:
        r6.append(renderAnnotation(r2, r8));
        if (getEachAnnotationOnNewLine() == true) goto L21;
        r6.append(HanziToPinyin.Token.SEPARATOR);
        goto L11
    L21:
        Intrinsics.checkNotNullExpressionValue(r6.append('\n'), "append('\\n')");
        goto L11
    L23:
        return;
    L8:
        r0 = getExcludedAnnotationClasses();
        goto L9
    }

    private final boolean isParameterName(AnnotationDescriptor r1) {
        return Intrinsics.areEqual(r1.getFqName(), StandardNames.FqNames.parameterName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderAnnotation(AnnotationDescriptor r13, AnnotationUseSiteTarget r14) {
        Intrinsics.checkNotNullParameter(r13, "annotation");
        StringBuilder r0 = new StringBuilder();
        r0.append('@');
        if (r14 == null) goto L5;
        r0.append(r14.getRenderName() + ':');
    L5:
        KotlinType r15 = r13.getType();
        r0.append(renderType(r15));
        if (getIncludeAnnotationArguments() == false) goto L13;
        List<String> r16 = renderAndSortAnnotationArguments(r13);
        if (getIncludeEmptyAnnotationArguments() == false) goto L10;
    L11:
        CollectionsKt.joinTo$default(r16, r0, ", ", "(", ")", 0, null, null, 112, null);
        goto L13
    L10:
        if ((!r16.isEmpty()) == true) goto L11;
    L13:
        if (getVerbose() == true) goto L15;
    L19:
        String r12 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    L15:
        if (KotlinTypeKt.isError(r15) == false) goto L17;
    L18:
        r0.append(" /* annotation class not found */");
        goto L19
    L17:
        if ((r15.getConstructor().mo2083getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == false) goto L19;
        goto L18
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor r8) {
        Map<Name, ConstantValue<?>> r0 = r8.getAllValueArguments();
        ArrayList r2 = null;
        if (getRenderDefaultAnnotationArguments() == false) goto L5;
        ClassDescriptor r9 = DescriptorUtilsKt.getAnnotationClass(r8);
    L7:
        if (r9 == null) goto L23;
        ClassConstructorDescriptor r10 = r9.mo2077getUnsubstitutedPrimaryConstructor();
        if (r10 == null) goto L23;
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        if (r11 == null) goto L23;
        ArrayList r3 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        Object r4 = r12.next();
        if (((ValueParameterDescriptor) r4).declaresDefaultValue() == false) goto L14;
        r3.add(r4);
        goto L14
    L18:
        ArrayList r5 = r3;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L22;
        r13.add(((ValueParameterDescriptor) r6.next()).getName());
        goto L20
    L22:
        r2 = r13;
    L23:
        if (r2 != null) goto L25;
        r2 = CollectionsKt.emptyList();
    L25:
        ArrayList r7 = new ArrayList();
        Iterator r14 = r2.iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        Name r16 = (Name) r15;
        Intrinsics.checkNotNullExpressionValue(r16, "it");
        if ((!r0.containsKey(r16)) == false) goto L27;
        r7.add(r15);
        goto L27
    L31:
        ArrayList r17 = r7;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L33:
        if (r19.hasNext() == false) goto L35;
        r18.add(((Name) r19.next()).asString() + " = ...");
        goto L33
    L35:
        ArrayList r20 = r18;
        Set<Map.Entry<Name, ConstantValue<?>>> r1 = r0.entrySet();
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r22 = r1.iterator();
    L37:
        if (r22.hasNext() == false) goto L44;
        Map.Entry r23 = (Map.Entry) r22.next();
        Name r24 = (Name) r23.getKey();
        ConstantValue<?> r25 = (ConstantValue) r23.getValue();
        StringBuilder r26 = new StringBuilder().append(r24.asString()).append(" = ");
        if (r2.contains(r24) == true) goto L41;
        String r27 = renderConstant(r25);
    L42:
        r21.add(r26.append(r27).toString());
        goto L37
    L41:
        r27 = "...";
        goto L42
    L44:
        return CollectionsKt.sorted(CollectionsKt.plus(r20, r21));
    L5:
        r9 = null;
        goto L7
    }

    private final String renderConstant(ConstantValue<?> r10) {
        if ((r10 instanceof ArrayValue) == false) goto L6;
        return CollectionsKt.joinToString$default(((ArrayValue) r10).getValue(), ", ", "{", "}", 0, null, new C04721(this), 24, null);
    L6:
        if ((r10 instanceof AnnotationValue) == false) goto L9;
        return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, ((AnnotationValue) r10).getValue(), null, 2, null), "@");
    L9:
        if ((r10 instanceof KClassValue) == false) goto L22;
        KClassValue.Value r9 = ((KClassValue) r10).getValue();
        if ((r9 instanceof KClassValue.Value.LocalClass) == false) goto L14;
        return ((KClassValue.Value.LocalClass) r9).getType() + "::class";
    L14:
        if ((r9 instanceof KClassValue.Value.NormalClass) == false) goto L20;
        KClassValue.Value.NormalClass r11 = (KClassValue.Value.NormalClass) r9;
        String r12 = r11.getClassId().asSingleFqName().asString();
        Intrinsics.checkNotNullExpressionValue(r12, "classValue.classId.asSingleFqName().asString()");
        int r1 = 0;
    L16:
        if (r1 >= r11.getArrayDimensions()) goto L27;
        r12 = "kotlin.Array<" + r12 + '>';
        r1 = r1 + 1;
        goto L16
    L27:
        return r12 + "::class";
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        return r10.toString();
    }

    private final boolean renderVisibility(DescriptorVisibility r3, StringBuilder r4) {
        if (getModifiers().contains(DescriptorRendererModifier.VISIBILITY) == true) goto L6;
        return false;
    L6:
        if (getNormalizedVisibilities() == false) goto L9;
        r3 = r3.normalize();
    L9:
        if (getRenderDefaultVisibility() == false) goto L11;
    L13:
        r4.append(renderKeyword(r3.getInternalDisplayName())).append(HanziToPinyin.Token.SEPARATOR);
        return true;
    L11:
        if (Intrinsics.areEqual(r3, DescriptorVisibilities.DEFAULT_VISIBILITY) == false) goto L13;
        return false;
    }

    private final void renderModality(Modality r2, StringBuilder r3, Modality r4) {
        if (getRenderDefaultModality() == true) goto L6;
        if (r2 != r4) goto L6;
        return;
    L6:
        renderModifier(r3, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r2.name()));
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor r3) {
        if ((r3 instanceof ClassDescriptor) == true) goto L5;
        DeclarationDescriptor r2 = r3.getContainingDeclaration();
        if ((r2 instanceof ClassDescriptor) == false) goto L12;
        ClassDescriptor r4 = (ClassDescriptor) r2;
    L13:
        if (r4 != null) goto L17;
        return Modality.FINAL;
    L17:
        if ((r3 instanceof CallableMemberDescriptor) == false) goto L19;
        CallableMemberDescriptor r5 = (CallableMemberDescriptor) r3;
        Collection<? extends CallableMemberDescriptor> r0 = r5.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r0, "this.overriddenDescriptors");
        if ((!r0.isEmpty()) == false) goto L27;
        if (r4.getModality() == Modality.FINAL) goto L27;
        return Modality.OPEN;
    L27:
        if (r4.getKind() != ClassKind.INTERFACE) goto L35;
        if (Intrinsics.areEqual(r5.getVisibility(), DescriptorVisibilities.PRIVATE) == true) goto L35;
        if (r5.getModality() != Modality.ABSTRACT) goto L38;
        return Modality.ABSTRACT;
    L38:
        return Modality.OPEN;
    L35:
        return Modality.FINAL;
    L19:
        return Modality.FINAL;
    L12:
        r4 = null;
        goto L13
    L5:
        if (((ClassDescriptor) r3).getKind() != ClassKind.INTERFACE) goto L8;
        return Modality.ABSTRACT;
    L8:
        return Modality.FINAL;
    }

    private final void renderModalityForCallable(CallableMemberDescriptor r3, StringBuilder r4) {
        if (DescriptorUtils.isTopLevelDeclaration(r3) == false) goto L7;
        if (r3.getModality() != Modality.FINAL) goto L7;
        return;
    L7:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE) goto L9;
    L13:
        Modality r0 = r3.getModality();
        Intrinsics.checkNotNullExpressionValue(r0, "callable.modality");
        renderModality(r0, r4, implicitModalityWithoutExtensions(r3));
        return;
    L9:
        if (r3.getModality() != Modality.OPEN) goto L13;
        if (overridesSomething(r3) == false) goto L13;
    }

    private final void renderOverride(CallableMemberDescriptor r3, StringBuilder r4) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) == true) goto L6;
        return;
    L6:
        if (overridesSomething(r3) == true) goto L8;
        return;
    L8:
        if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OPEN) goto L14;
        renderModifier(r4, true, "override");
        if (getVerbose() == false) goto L15;
        r4.append("/*").append(r3.getOverriddenDescriptors().size()).append("*/ ");
        return;
    L15:
        return;
    }

    private final void renderMemberKind(CallableMemberDescriptor r3, StringBuilder r4) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) == true) goto L6;
        return;
    L6:
        if (getVerbose() == true) goto L8;
        return;
    L8:
        if (r3.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L12;
        r4.append("/*").append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(r3.getKind().name())).append("*/ ");
        return;
    }

    private final void renderModifier(StringBuilder r1, boolean r2, String r3) {
        if (r2 == false) goto L5;
        r1.append(renderKeyword(r3));
        r1.append(HanziToPinyin.Token.SEPARATOR);
        return;
    }

    private final void renderMemberModifiers(MemberDescriptor r5, StringBuilder r6) {
        renderModifier(r6, r5.isExternal(), "external");
        boolean r1 = true;
        if (getModifiers().contains(DescriptorRendererModifier.EXPECT) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        renderModifier(r6, r0, "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) == true) goto L11;
    L13:
        r1 = false;
    L14:
        renderModifier(r6, r1, "actual");
        return;
    L11:
        if (r5.isActual() == false) goto L13;
    L5:
        if (r5.isExpect() == false) goto L7;
        r0 = true;
        goto L8
    }

    private final void renderAdditionalModifiers(FunctionDescriptor r6, StringBuilder r7) {
        boolean r2 = false;
        if (r6.isOperator() == false) goto L17;
        Collection<? extends FunctionDescriptor> r0 = r6.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r0, "functionDescriptor.overriddenDescriptors");
        Collection<? extends FunctionDescriptor> r1 = r0;
        if (r1.isEmpty() == false) goto L7;
    L6:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
    L16:
        boolean r4 = true;
    L19:
        if (r6.isInfix() == false) goto L33;
        Collection<? extends FunctionDescriptor> r5 = r6.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r5, "functionDescriptor.overriddenDescriptors");
        Collection<? extends FunctionDescriptor> r8 = r5;
        if (r8.isEmpty() == false) goto L23;
    L22:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L31;
    L32:
        r2 = true;
        goto L33
    L31:
        if (getAlwaysRenderModifiers() == false) goto L33;
    L23:
        Iterator<T> r10 = r8.iterator();
    L25:
        if (r10.hasNext() == false) goto L22;
        if (((FunctionDescriptor) r10.next()).isInfix() == false) goto L25;
        r9 = false;
    L33:
        renderModifier(r7, r6.isTailrec(), "tailrec");
        renderSuspendModifier(r6, r7);
        renderModifier(r7, r6.isInline(), "inline");
        renderModifier(r7, r2, "infix");
        renderModifier(r7, r4, Utils.BUNDLE_TAG_OPERATOR);
        return;
    L15:
        if (getAlwaysRenderModifiers() == false) goto L17;
    L7:
        Iterator<T> r11 = r1.iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        if (((FunctionDescriptor) r11.next()).isOperator() == false) goto L9;
        r3 = false;
    L17:
        r4 = false;
        goto L19
    }

    private final void renderSuspendModifier(FunctionDescriptor r2, StringBuilder r3) {
        renderModifier(r3, r2.isSuspend(), "suspend");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String render(DeclarationDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "declarationDescriptor");
        StringBuilder r0 = new StringBuilder();
        r3.accept(new RenderDeclarationDescriptorVisitor(this), r0);
        if (getWithDefinedIn() == false) goto L5;
        appendDefinedIn(r0, r3);
    L5:
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    }

    private final void renderTypeParameter(TypeParameterDescriptor r11, StringBuilder r12, boolean r13) {
        if (r13 == false) goto L5;
        r12.append(lt());
    L5:
        if (getVerbose() == false) goto L7;
        r12.append("/*").append(r11.getIndex()).append("*/ ");
    L7:
        renderModifier(r12, r11.isReified(), "reified");
        String r0 = r11.getVariance().getLabel();
        boolean r3 = true;
        if (r0.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        renderModifier(r12, r1, r0);
        renderAnnotations$default(this, r12, r11, null, 2, null);
        renderName(r11, r12, r13);
        int r2 = r11.getUpperBounds().size();
        if (r2 <= 1) goto L14;
        if (r13 == true) goto L14;
    L15:
        KotlinType r14 = r11.getUpperBounds().iterator().next();
        if (KotlinBuiltIns.isDefaultBound(r14) == true) goto L29;
        StringBuilder r4 = r12.append(" : ");
        Intrinsics.checkNotNullExpressionValue(r14, "upperBound");
        r4.append(renderType(r14));
    L29:
        if (r13 == false) goto L37;
        r12.append(gt());
        return;
    L37:
        return;
    L14:
        if (r2 == 1) goto L15;
        if (r13 == false) goto L29;
        Iterator<KotlinType> r15 = r11.getUpperBounds().iterator();
    L21:
        if (r15.hasNext() == false) goto L29;
        KotlinType r5 = r15.next();
        if (KotlinBuiltIns.isDefaultBound(r5) == true) goto L21;
        if (r3 == false) goto L27;
        r12.append(" : ");
    L28:
        Intrinsics.checkNotNullExpressionValue(r5, "upperBound");
        r12.append(renderType(r5));
        r3 = false;
        goto L21
    L27:
        r12.append(" & ");
        goto L28
    L10:
        r1 = false;
        goto L11
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> r2, StringBuilder r3, boolean r4) {
        if (getWithoutTypeParameters() == false) goto L6;
        return;
    L6:
        if ((!r2.isEmpty()) == false) goto L11;
        r3.append(lt());
        renderTypeParameterList(r3, r2);
        r3.append(gt());
        if (r4 == false) goto L12;
        r3.append(HanziToPinyin.Token.SEPARATOR);
        return;
    L12:
        return;
    }

    private final void renderTypeParameterList(StringBuilder r3, List<? extends TypeParameterDescriptor> r4) {
        Iterator<? extends TypeParameterDescriptor> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        renderTypeParameter(r5.next(), r3, false);
        if (r5.hasNext() == false) goto L4;
        r3.append(", ");
        goto L4
    }

    private final void renderFunction(FunctionDescriptor r10, StringBuilder r11) {
        if (getStartFromName() == false) goto L5;
    L22:
        renderName(r10, r11, true);
        List<ValueParameterDescriptor> r0 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r0, "function.valueParameters");
        renderValueParameters(r0, r10.hasSynthesizedParameterNames(), r11);
        renderReceiverAfterName(r10, r11);
        KotlinType r1 = r10.getReturnType();
        if (getWithoutReturnType() == false) goto L25;
    L34:
        List<TypeParameterDescriptor> r12 = r10.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "function.typeParameters");
        renderWhereSuffix(r12, r11);
        return;
    L25:
        if (getUnitReturnType() == true) goto L29;
        if (r1 == null) goto L29;
        if (KotlinBuiltIns.isUnit(r1) == true) goto L34;
    L29:
        StringBuilder r2 = r11.append(": ");
        if (r1 != null) goto L32;
        String r3 = "[NULL]";
    L33:
        r2.append(r3);
        goto L34
    L32:
        r3 = renderType(r1);
        goto L33
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L21;
        renderAnnotations$default(this, r11, r10, null, 2, null);
        List<ReceiverParameterDescriptor> r4 = r10.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(r4, "function.contextReceiverParameters");
        renderContextReceivers(r4, r11);
        DescriptorVisibility r5 = r10.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r5, "function.visibility");
        renderVisibility(r5, r11);
        FunctionDescriptor r6 = r10;
        renderModalityForCallable(r6, r11);
        if (getIncludeAdditionalModifiers() == false) goto L9;
        renderMemberModifiers(r10, r11);
    L9:
        renderOverride(r6, r11);
        if (getIncludeAdditionalModifiers() == false) goto L12;
        renderAdditionalModifiers(r10, r11);
    L13:
        renderMemberKind(r6, r11);
        if (getVerbose() == false) goto L21;
        if (r10.isHiddenToOvercomeSignatureClash() == false) goto L19;
        r11.append("/*isHiddenToOvercomeSignatureClash*/ ");
    L19:
        if (r10.isHiddenForResolutionEverywhereBesideSupercalls() == false) goto L21;
        r11.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
        goto L21
    L12:
        renderSuspendModifier(r10, r11);
    L21:
        r11.append(renderKeyword("fun")).append(HanziToPinyin.Token.SEPARATOR);
        List<TypeParameterDescriptor> r7 = r10.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "function.typeParameters");
        renderTypeParameters(r7, r11, true);
        renderReceiver(r10, r11);
        goto L22
    }

    private final void renderReceiverAfterName(CallableDescriptor r2, StringBuilder r3) {
        if (getReceiverAfterName() == true) goto L5;
        return;
    L5:
        ReceiverParameterDescriptor r4 = r2.getExtensionReceiverParameter();
        if (r4 == null) goto L9;
        StringBuilder r5 = r3.append(" on ");
        KotlinType r6 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r6, "receiver.type");
        r5.append(renderType(r6));
        return;
    }

    private final String renderForReceiver(KotlinType r2) {
        String r0 = renderType(r2);
        if (shouldRenderAsPrettyFunctionType(r2) == true) goto L5;
        return r0;
    L5:
        if (TypeUtils.isNullableType(r2) == false) goto L7;
        return r0;
    L7:
        return "(" + r0 + ')';
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> r7, StringBuilder r8) {
        if ((!r7.isEmpty()) == false) goto L12;
        r8.append("context(");
        Iterator<? extends ReceiverParameterDescriptor> r0 = r7.iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L16;
        int r2 = r1 + 1;
        ReceiverParameterDescriptor r3 = r0.next();
        renderAnnotations(r8, r3, AnnotationUseSiteTarget.RECEIVER);
        KotlinType r4 = r3.getType();
        Intrinsics.checkNotNullExpressionValue(r4, "contextReceiver.type");
        r8.append(renderForReceiver(r4));
        if (r1 != CollectionsKt.getLastIndex(r7)) goto L10;
        r8.append(") ");
    L11:
        r1 = r2;
        goto L6
    L10:
        r8.append(", ");
        goto L11
    L16:
        return;
    }

    private final void renderReceiver(CallableDescriptor r3, StringBuilder r4) {
        ReceiverParameterDescriptor r5 = r3.getExtensionReceiverParameter();
        if (r5 == null) goto L6;
        renderAnnotations(r4, r5, AnnotationUseSiteTarget.RECEIVER);
        KotlinType r6 = r5.getType();
        Intrinsics.checkNotNullExpressionValue(r6, "receiver.type");
        r4.append(renderForReceiver(r6)).append(LibrarianImpl.Constants.DOT);
        return;
    }

    private final void renderConstructor(ConstructorDescriptor r18, StringBuilder r19) {
        renderAnnotations$default(this, r19, r18, null, 2, null);
        if (this.options.getRenderDefaultVisibility() == false) goto L5;
    L6:
        DescriptorVisibility r0 = r18.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r0, "constructor.visibility");
        if (renderVisibility(r0, r19) == false) goto L9;
        boolean r1 = true;
    L10:
        renderMemberKind(r18, r19);
        if (getRenderConstructorKeyword() == false) goto L13;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        r19.append(renderKeyword("constructor"));
    L20:
        ClassifierDescriptorWithTypeParameters r3 = r18.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r3, "constructor.containingDeclaration");
        if (getSecondaryConstructorsAsPrimary() == false) goto L25;
        if (r2 == false) goto L24;
        r19.append(HanziToPinyin.Token.SEPARATOR);
    L24:
        renderName(r3, r19, true);
        List<TypeParameterDescriptor> r4 = r18.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r4, "constructor.typeParameters");
        renderTypeParameters(r4, r19, false);
    L25:
        List<ValueParameterDescriptor> r5 = r18.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "constructor.valueParameters");
        renderValueParameters(r5, r18.hasSynthesizedParameterNames(), r19);
        if (getRenderConstructorDelegation() == false) goto L48;
        if (r18.isPrimary() == true) goto L48;
        if ((r3 instanceof ClassDescriptor) == false) goto L48;
        ClassConstructorDescriptor r6 = ((ClassDescriptor) r3).mo2077getUnsubstitutedPrimaryConstructor();
        if (r6 == null) goto L48;
        List<ValueParameterDescriptor> r7 = r6.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "primaryConstructor.valueParameters");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L35:
        if (r9.hasNext() == false) goto L44;
        Object r10 = r9.next();
        ValueParameterDescriptor r11 = (ValueParameterDescriptor) r10;
        if (r11.declaresDefaultValue() == false) goto L39;
    L41:
        boolean r12 = false;
    L42:
        if (r12 == false) goto L35;
        r8.add(r10);
        goto L35
    L39:
        if (r11.getVarargElementType() != null) goto L41;
        r12 = true;
        goto L42
    L44:
        ArrayList r13 = r8;
        if ((!r13.isEmpty()) == false) goto L48;
        r19.append(" : ").append(renderKeyword("this"));
        r19.append(CollectionsKt.joinToString$default(r13, ", ", "(", ")", 0, null, C04731.INSTANCE, 24, null));
    L48:
        if (getSecondaryConstructorsAsPrimary() == false) goto L56;
        List<TypeParameterDescriptor> r14 = r18.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "constructor.typeParameters");
        renderWhereSuffix(r14, r19);
        return;
    L56:
        return;
    L13:
        if (r18.isPrimary() == false) goto L17;
        if (r1 == true) goto L17;
        r2 = false;
    L9:
        r1 = false;
        goto L10
    L5:
        if (r18.getConstructedClass().getModality() == Modality.SEALED) goto L9;
        goto L6
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> r12, StringBuilder r13) {
        if (getWithoutTypeParameters() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(0);
        Iterator<? extends TypeParameterDescriptor> r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L14;
        TypeParameterDescriptor r2 = r14.next();
        List<KotlinType> r4 = r2.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r4, "typeParameter.upperBounds");
        Iterator r3 = CollectionsKt.drop(r4, 1).iterator();
    L10:
        if (r3.hasNext() == false) goto L7;
        KotlinType r5 = (KotlinType) r3.next();
        StringBuilder r6 = new StringBuilder();
        Name r7 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "typeParameter.name");
        StringBuilder r8 = r6.append(renderName(r7, false)).append(" : ");
        Intrinsics.checkNotNullExpressionValue(r5, "it");
        r0.add(r8.append(renderType(r5)).toString());
        goto L10
    L14:
        if ((!r0.isEmpty()) == false) goto L19;
        r13.append(HanziToPinyin.Token.SEPARATOR).append(renderKeyword("where")).append(HanziToPinyin.Token.SEPARATOR);
        CollectionsKt.joinTo$default(r0, r13, ", ", null, null, 0, null, null, 124, null);
        return;
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> r7, boolean r8, StringBuilder r9) {
        boolean r10 = shouldRenderParameterNames(r8);
        int r0 = r7.size();
        getValueParametersHandler().appendBeforeValueParameters(r0, r9);
        Iterator<? extends ValueParameterDescriptor> r11 = r7.iterator();
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        ValueParameterDescriptor r4 = r11.next();
        getValueParametersHandler().appendBeforeValueParameter(r4, r2, r0, r9);
        renderValueParameter(r4, r10, r9, false);
        getValueParametersHandler().appendAfterValueParameter(r4, r2, r0, r9);
        r2 = r2 + 1;
        goto L4
    L6:
        getValueParametersHandler().appendAfterValueParameters(r0, r9);
    }

    private final boolean shouldRenderParameterNames(boolean r4) {
        ParameterNameRenderingPolicy r3 = getParameterNameRenderingPolicy();
        int r5 = WhenMappings.$EnumSwitchMapping$1[r3.ordinal()];
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 != 2) goto L7;
        if (r4 == true) goto L13;
        return true;
    L13:
        return false;
    L7:
        if (r5 == 3) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    private final void renderValueParameter(ValueParameterDescriptor r10, boolean r11, StringBuilder r12, boolean r13) {
        if (r13 == false) goto L5;
        r12.append(renderKeyword("value-parameter")).append(HanziToPinyin.Token.SEPARATOR);
    L5:
        if (getVerbose() == false) goto L7;
        r12.append("/*").append(r10.getIndex()).append("*/ ");
    L7:
        renderAnnotations$default(this, r12, r10, null, 2, null);
        renderModifier(r12, r10.isCrossinline(), "crossinline");
        renderModifier(r12, r10.isNoinline(), "noinline");
        boolean r1 = true;
        if (getRenderPrimaryConstructorParametersAsProperties() == false) goto L20;
        CallableDescriptor r0 = r10.getContainingDeclaration();
        if ((r0 instanceof ClassConstructorDescriptor) == false) goto L12;
        ClassConstructorDescriptor r2 = (ClassConstructorDescriptor) r0;
    L13:
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
        renderModifier(r12, getActualPropertiesInPrimaryConstructor(), "actual");
    L23:
        renderVariable(r10, r11, r12, r13, r8);
        if (getDefaultParameterValueRenderer() != null) goto L26;
    L31:
        r1 = false;
    L32:
        if (r1 == false) goto L35;
        StringBuilder r14 = new StringBuilder(" = ");
        Function1<ValueParameterDescriptor, String> r9 = getDefaultParameterValueRenderer();
        Intrinsics.checkNotNull(r9);
        r12.append(r14.append(r9.invoke(r10)).toString());
        return;
    L35:
        return;
    L26:
        if (getDebugMode() == false) goto L28;
        boolean r15 = r10.declaresDefaultValue();
    L29:
        if (r15 == false) goto L31;
    L28:
        r15 = DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10);
        goto L29
    L15:
        if (r2.isPrimary() != true) goto L17;
        r3 = true;
        goto L18
    L12:
        r2 = null;
    L20:
        r8 = false;
        goto L21
    }

    static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl r0, VariableDescriptor r1, StringBuilder r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.renderValVarPrefix(r1, r2, r3);
    }

    private final void renderValVarPrefix(VariableDescriptor r1, StringBuilder r2, boolean r3) {
        if (r3 == true) goto L6;
        if ((r1 instanceof ValueParameterDescriptor) == false) goto L6;
        return;
    L6:
        if (r1.isVar() == false) goto L8;
        String r4 = "var";
    L9:
        r2.append(renderKeyword(r4)).append(HanziToPinyin.Token.SEPARATOR);
        return;
    L8:
        r4 = "val";
        goto L9
    }

    private final void renderVariable(VariableDescriptor r6, boolean r7, StringBuilder r8, boolean r9, boolean r10) {
        KotlinType r0 = r6.getType();
        Intrinsics.checkNotNullExpressionValue(r0, "variable.type");
        KotlinType r2 = null;
        if ((r6 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r1 = (ValueParameterDescriptor) r6;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.getVarargElementType();
    L8:
        if (r2 != null) goto L10;
        KotlinType r3 = r0;
    L11:
        if (r2 == null) goto L13;
        boolean r4 = true;
    L14:
        renderModifier(r8, r4, "vararg");
        if (r10 == true) goto L19;
        if (r9 == true) goto L18;
    L20:
        if (r7 == false) goto L22;
        renderName(r6, r8, r9);
        r8.append(": ");
    L22:
        r8.append(renderType(r3));
        renderInitializer(r6, r8);
        if (getVerbose() == false) goto L27;
        if (r2 == null) goto L28;
        r8.append(" /*").append(renderType(r0)).append("*/");
        return;
    L28:
        return;
    L27:
        return;
    L18:
        if (getStartFromName() == true) goto L20;
    L19:
        renderValVarPrefix(r6, r8, r10);
        goto L20
    L13:
        r4 = false;
        goto L14
    L10:
        r3 = r2;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private final void renderProperty(PropertyDescriptor r12, StringBuilder r13) {
        if (getStartFromName() == false) goto L5;
    L19:
        renderName(r12, r13, true);
        StringBuilder r0 = r13.append(": ");
        KotlinType r2 = r12.getType();
        Intrinsics.checkNotNullExpressionValue(r2, "property.type");
        r0.append(renderType(r2));
        renderReceiverAfterName(r12, r13);
        renderInitializer(r12, r13);
        List<TypeParameterDescriptor> r14 = r12.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "property.typeParameters");
        renderWhereSuffix(r14, r13);
        return;
    L5:
        if (getStartFromDeclarationKeyword() == true) goto L18;
        renderPropertyAnnotations(r12, r13);
        List<ReceiverParameterDescriptor> r1 = r12.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "property.contextReceiverParameters");
        renderContextReceivers(r1, r13);
        DescriptorVisibility r3 = r12.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r3, "property.visibility");
        renderVisibility(r3, r13);
        boolean r4 = false;
        if (getModifiers().contains(DescriptorRendererModifier.CONST) == true) goto L9;
    L11:
        boolean r5 = false;
    L12:
        renderModifier(r13, r5, "const");
        renderMemberModifiers(r12, r13);
        PropertyDescriptor r6 = r12;
        renderModalityForCallable(r6, r13);
        renderOverride(r6, r13);
        if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) == true) goto L15;
    L17:
        renderModifier(r13, r4, "lateinit");
        renderMemberKind(r6, r13);
        goto L18
    L15:
        if (r12.isLateInit() == false) goto L17;
        r4 = true;
        goto L17
    L9:
        if (r12.isConst() == false) goto L11;
        r5 = true;
    L18:
        renderValVarPrefix$default(this, r12, r13, false, 4, null);
        List<TypeParameterDescriptor> r7 = r12.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "property.typeParameters");
        renderTypeParameters(r7, r13, true);
        renderReceiver(r12, r13);
        goto L19
    }

    private final void renderPropertyAnnotations(PropertyDescriptor r8, StringBuilder r9) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS) == true) goto L5;
        return;
    L5:
        renderAnnotations$default(this, r9, r8, null, 2, null);
        FieldDescriptor r0 = r8.getBackingField();
        if (r0 == null) goto L8;
        renderAnnotations(r9, r0, AnnotationUseSiteTarget.FIELD);
    L8:
        FieldDescriptor r1 = r8.getDelegateField();
        if (r1 == null) goto L12;
        renderAnnotations(r9, r1, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
    L12:
        if (getPropertyAccessorRenderingPolicy() != PropertyAccessorRenderingPolicy.NONE) goto L20;
        PropertyGetterDescriptor r2 = r8.getGetter();
        if (r2 == null) goto L16;
        renderAnnotations(r9, r2, AnnotationUseSiteTarget.PROPERTY_GETTER);
    L16:
        PropertySetterDescriptor r10 = r8.getSetter();
        if (r10 == null) goto L21;
        renderAnnotations(r9, r10, AnnotationUseSiteTarget.PROPERTY_SETTER);
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "setter.valueParameters");
        ValueParameterDescriptor r12 = (ValueParameterDescriptor) CollectionsKt.single(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "it");
        renderAnnotations(r9, r12, AnnotationUseSiteTarget.SETTER_PARAMETER);
        return;
    L21:
        return;
    }

    private final void renderInitializer(VariableDescriptor r2, StringBuilder r3) {
        if (getIncludePropertyConstant() == false) goto L8;
        ConstantValue<?> r4 = r2.mo2079getCompileTimeInitializer();
        if (r4 == null) goto L9;
        r3.append(" = ").append(escape(renderConstant(r4)));
        return;
    L9:
        return;
    }

    private final void renderTypeAlias(TypeAliasDescriptor r7, StringBuilder r8) {
        renderAnnotations$default(this, r8, r7, null, 2, null);
        DescriptorVisibility r0 = r7.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r0, "typeAlias.visibility");
        renderVisibility(r0, r8);
        renderMemberModifiers(r7, r8);
        r8.append(renderKeyword("typealias")).append(HanziToPinyin.Token.SEPARATOR);
        renderName(r7, r8, true);
        List<TypeParameterDescriptor> r1 = r7.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "typeAlias.declaredTypeParameters");
        renderTypeParameters(r1, r8, false);
        renderCapturedTypeParametersIfRequired(r7, r8);
        r8.append(" = ").append(renderType(r7.getUnderlyingType()));
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters r4, StringBuilder r5) {
        List<TypeParameterDescriptor> r0 = r4.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r0, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> r1 = r4.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "classifier.typeConstructor.parameters");
        if (getVerbose() == true) goto L5;
        return;
    L5:
        if (r4.isInner() == true) goto L7;
        return;
    L7:
        if (r1.size() <= r0.size()) goto L12;
        r5.append(" /*captured type parameters: ");
        renderTypeParameterList(r5, r1.subList(r0.size(), r1.size()));
        r5.append("*/");
        return;
    }

    private final void renderClass(ClassDescriptor r11, StringBuilder r12) {
        if (r11.getKind() != ClassKind.ENUM_ENTRY) goto L5;
        boolean r0 = true;
    L7:
        if (getStartFromName() == true) goto L51;
        renderAnnotations$default(this, r12, r11, null, 2, null);
        List<ReceiverParameterDescriptor> r1 = r11.getContextReceivers();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.contextReceivers");
        renderContextReceivers(r1, r12);
        if (r0 == true) goto L12;
        DescriptorVisibility r2 = r11.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r2, "klass.visibility");
        renderVisibility(r2, r12);
    L12:
        if (r11.getKind() != ClassKind.INTERFACE) goto L16;
        if (r11.getModality() != Modality.ABSTRACT) goto L16;
    L20:
        renderMemberModifiers(r11, r12);
        if (getModifiers().contains(DescriptorRendererModifier.INNER) == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        renderModifier(r12, r3, "inner");
        if (getModifiers().contains(DescriptorRendererModifier.DATA) == true) goto L29;
    L31:
        boolean r4 = false;
    L32:
        renderModifier(r12, r4, "data");
        if (getModifiers().contains(DescriptorRendererModifier.INLINE) == true) goto L35;
    L37:
        boolean r5 = false;
    L38:
        renderModifier(r12, r5, "inline");
        if (getModifiers().contains(DescriptorRendererModifier.VALUE) == true) goto L41;
    L43:
        boolean r6 = false;
    L44:
        renderModifier(r12, r6, "value");
        if (getModifiers().contains(DescriptorRendererModifier.FUN) == true) goto L47;
    L49:
        boolean r7 = false;
    L50:
        renderModifier(r12, r7, "fun");
        renderClassKindPrefix(r11, r12);
        goto L51
    L47:
        if (r11.isFun() == false) goto L49;
        r7 = true;
        goto L50
    L41:
        if (r11.isValue() == false) goto L43;
        r6 = true;
        goto L44
    L35:
        if (r11.isInline() == false) goto L37;
        r5 = true;
        goto L38
    L29:
        if (r11.isData() == false) goto L31;
        r4 = true;
        goto L32
    L23:
        if (r11.isInner() == false) goto L25;
        r3 = true;
    L16:
        if (r11.getKind().isSingleton() == true) goto L18;
    L19:
        Modality r8 = r11.getModality();
        Intrinsics.checkNotNullExpressionValue(r8, "klass.modality");
        renderModality(r8, r12, implicitModalityWithoutExtensions(r11));
        goto L20
    L18:
        if (r11.getModality() == Modality.FINAL) goto L20;
    L51:
        ClassDescriptor r9 = r11;
        if (DescriptorUtils.isCompanionObject(r9) == false) goto L54;
        renderCompanionObjectName(r9, r12);
    L58:
        if (r0 == false) goto L60;
        return;
    L60:
        List<TypeParameterDescriptor> r10 = r11.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredTypeParameters");
        renderTypeParameters(r10, r12, false);
        renderCapturedTypeParametersIfRequired(r11, r12);
        if (r11.getKind().isSingleton() == false) goto L63;
    L67:
        renderSuperTypes(r11, r12);
        renderWhereSuffix(r10, r12);
        return;
    L63:
        if (getClassWithPrimaryConstructor() == false) goto L67;
        ClassConstructorDescriptor r13 = r11.mo2077getUnsubstitutedPrimaryConstructor();
        if (r13 == null) goto L67;
        r12.append(HanziToPinyin.Token.SEPARATOR);
        renderAnnotations$default(this, r12, r13, null, 2, null);
        DescriptorVisibility r14 = r13.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r14, "primaryConstructor.visibility");
        renderVisibility(r14, r12);
        r12.append(renderKeyword("constructor"));
        List<ValueParameterDescriptor> r15 = r13.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r15, "primaryConstructor.valueParameters");
        renderValueParameters(r15, r13.hasSynthesizedParameterNames(), r12);
        goto L67
    L54:
        if (getStartFromName() == true) goto L56;
        renderSpaceIfNeeded(r12);
    L56:
        renderName(r9, r12, true);
        goto L58
    L5:
        r0 = false;
        goto L7
    }

    private final void renderSuperTypes(ClassDescriptor r12, StringBuilder r13) {
        if (getWithoutSuperTypes() == false) goto L6;
        return;
    L6:
        if (KotlinBuiltIns.isNothing(r12.getDefaultType()) == false) goto L8;
        return;
    L8:
        Collection<KotlinType> r14 = r12.getTypeConstructor().mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r14, "klass.typeConstructor.supertypes");
        if (r14.isEmpty() == false) goto L11;
        return;
    L11:
        if (r14.size() == 1) goto L13;
    L15:
        renderSpaceIfNeeded(r13);
        r13.append(": ");
        CollectionsKt.joinTo$default(r14, r13, ", ", null, null, 0, null, new C04741(this), 60, null);
        return;
    L13:
        if (KotlinBuiltIns.isAnyOrNullableAny(r14.iterator().next()) == false) goto L15;
    }

    private final void renderClassKindPrefix(ClassDescriptor r2, StringBuilder r3) {
        r3.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(r2)));
    }

    private final void renderPackageView(PackageViewDescriptor r3, StringBuilder r4) {
        renderPackageHeader(r3.getFqName(), "package", r4);
        if (getDebugMode() == false) goto L6;
        r4.append(" in context of ");
        renderName(r3.getModule(), r4, false);
        return;
    }

    private final void renderPackageFragment(PackageFragmentDescriptor r3, StringBuilder r4) {
        renderPackageHeader(r3.getFqName(), "package-fragment", r4);
        if (getDebugMode() == false) goto L6;
        r4.append(" in ");
        renderName(r3.getContainingDeclaration(), r4, false);
        return;
    }

    private final void renderPackageHeader(FqName r1, String r2, StringBuilder r3) {
        r3.append(renderKeyword(r2));
        FqNameUnsafe r4 = r1.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r4, "fqName.toUnsafe()");
        String r0 = renderFqName(r4);
        if (r0.length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        r3.append(HanziToPinyin.Token.SEPARATOR);
        r3.append(r0);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final void renderAccessorModifiers(PropertyAccessorDescriptor r1, StringBuilder r2) {
        renderMemberModifiers(r1, r2);
    }

    private final void renderSpaceIfNeeded(StringBuilder r2) {
        int r1 = r2.length();
        if (r1 != 0) goto L5;
    L6:
        r2.append(' ');
        return;
    L5:
        if (r2.charAt(r1 - 1) != ' ') goto L6;
    }

    private final String replacePrefixes(String r5, String r6, String r7, String r8, String r9) {
        if (StringsKt.startsWith$default(r5, r6, false, 2, null) == true) goto L5;
    L13:
        return null;
    L5:
        if (StringsKt.startsWith$default(r7, r8, false, 2, null) == false) goto L13;
        String r10 = r5.substring(r6.length());
        Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).substring(startIndex)");
        String r11 = r7.substring(r8.length());
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).substring(startIndex)");
        String r12 = r9 + r10;
        if (Intrinsics.areEqual(r10, r11) == false) goto L10;
        return r12;
    L10:
        if (differsOnlyInNullability(r10, r11) == false) goto L13;
        return r12 + '!';
    }

    private final boolean differsOnlyInNullability(String r7, String r8) {
        if (Intrinsics.areEqual(r7, StringsKt.replace$default(r8, "?", "", false, 4, null)) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.endsWith$default(r8, "?", false, 2, null) == false) goto L9;
        if (Intrinsics.areEqual(r7 + '?', r8) == true) goto L10;
    L9:
        if (Intrinsics.areEqual("(" + r7 + ")?", r8) == true) goto L10;
        return false;
    }

    private final boolean overridesSomething(CallableMemberDescriptor r1) {
        return !r1.getOverriddenDescriptors().isEmpty();
    }
}

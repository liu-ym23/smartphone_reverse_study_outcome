package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DescriptorRenderer {
    public static final DescriptorRenderer COMPACT = null;
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES = null;
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS = null;
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES = null;
    public static final Companion Companion = null;
    public static final DescriptorRenderer DEBUG_TEXT = null;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES = null;
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = null;
    public static final DescriptorRenderer HTML = null;
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES = null;
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES = null;

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: DescriptorRenderer.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[ClassKind.values().length];
                r0[ClassKind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[ClassKind.INTERFACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[ClassKind.ENUM_CLASS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[ClassKind.OBJECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[ClassKind.ENUM_ENTRY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r1) {
            Intrinsics.checkNotNullParameter(r1, "changeOptions");
            DescriptorRendererOptionsImpl r0 = new DescriptorRendererOptionsImpl();
            r1.invoke(r0);
            r0.lock();
            return new DescriptorRendererImpl(r0);
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters r3) {
            Intrinsics.checkNotNullParameter(r3, "classifier");
            if ((r3 instanceof TypeAliasDescriptor) == false) goto L6;
            return "typealias";
        L6:
            if ((r3 instanceof ClassDescriptor) == false) goto L22;
            ClassDescriptor r4 = (ClassDescriptor) r3;
            if (r4.isCompanionObject() == false) goto L11;
            return "companion object";
        L11:
            switch(WhenMappings.$EnumSwitchMapping$0[r4.getKind().ordinal()]) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                default: goto L13;
            };
        L14:
            return "enum entry";
        L15:
            return "annotation class";
        L16:
            return "object";
        L17:
            return "enum class";
        L18:
            return "interface";
        L19:
            return "class";
        L13:
            throw new NoWhenBranchMatchedException();
        L22:
            throw new AssertionError("Unexpected classifier: " + r3);
        }
    }

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public interface ValueParametersHandler {

        /* JADX INFO: compiled from: DescriptorRenderer.kt */
        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = null;

            static {
                INSTANCE = new DEFAULT();
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4) {
                Intrinsics.checkNotNullParameter(r1, "parameter");
                Intrinsics.checkNotNullParameter(r4, "builder");
            }

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int r1, StringBuilder r2) {
                Intrinsics.checkNotNullParameter(r2, "builder");
                r2.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int r1, StringBuilder r2) {
                Intrinsics.checkNotNullParameter(r2, "builder");
                r2.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4) {
                Intrinsics.checkNotNullParameter(r1, "parameter");
                Intrinsics.checkNotNullParameter(r4, "builder");
                if (r2 == (r3 - 1)) goto L6;
                r4.append(", ");
                return;
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4);

        void appendAfterValueParameters(int r1, StringBuilder r2);

        void appendBeforeValueParameter(ValueParameterDescriptor r1, int r2, int r3, StringBuilder r4);

        void appendBeforeValueParameters(int r1, StringBuilder r2);
    }

    public abstract String render(DeclarationDescriptor r1);

    public abstract String renderAnnotation(AnnotationDescriptor r1, AnnotationUseSiteTarget r2);

    public abstract String renderFlexibleType(String r1, String r2, KotlinBuiltIns r3);

    public abstract String renderFqName(FqNameUnsafe r1);

    public abstract String renderName(Name r1, boolean r2);

    public abstract String renderType(KotlinType r1);

    public abstract String renderTypeProjection(TypeProjection r1);

    public DescriptorRenderer() {
    }

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl r1 = ((DescriptorRendererImpl) this).getOptions().copy();
        r2.invoke(r1);
        r1.lock();
        return new DescriptorRendererImpl(r1);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer r0, AnnotationDescriptor r1, AnnotationUseSiteTarget r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.renderAnnotation(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        COMPACT_WITH_MODIFIERS = r0.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        COMPACT = r0.withOptions(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = r0.withOptions(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = r0.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = r0.withOptions(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES = r0.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = r0.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        SHORT_NAMES_IN_TYPES = r0.withOptions(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        DEBUG_TEXT = r0.withOptions(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        HTML = r0.withOptions(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }
}

package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class KClassValue extends ConstantValue<Value> {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ConstantValue<?> create(KotlinType r5) {
            Intrinsics.checkNotNullParameter(r5, "argumentType");
            if (KotlinTypeKt.isError(r5) == false) goto L5;
            return null;
        L5:
            int r2 = 0;
            KotlinType r1 = r5;
        L7:
            if (KotlinBuiltIns.isArray(r1) == false) goto L9;
            r1 = ((TypeProjection) CollectionsKt.single(r1.getArguments())).getType();
            Intrinsics.checkNotNullExpressionValue(r1, "type.arguments.single().type");
            r2 = r2 + 1;
            goto L7
        L9:
            ClassifierDescriptor r3 = r1.getConstructor().mo2083getDeclarationDescriptor();
            if ((r3 instanceof ClassDescriptor) == false) goto L17;
            ClassId r4 = DescriptorUtilsKt.getClassId(r3);
            if (r4 != null) goto L21;
            return new KClassValue(new Value.LocalClass(r5));
        L21:
            return new KClassValue(r4, r2);
        L17:
            if ((r3 instanceof TypeParameterDescriptor) == false) goto L22;
            ClassId r0 = ClassId.topLevel(StandardNames.FqNames.any.toSafe());
            Intrinsics.checkNotNullExpressionValue(r0, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new KClassValue(r0, 0);
        L22:
            return null;
        }
    }

    /* JADX INFO: compiled from: constantValues.kt */
    public static abstract class Value {

        /* JADX INFO: compiled from: constantValues.kt */
        public static final class LocalClass extends Value {
            private final KotlinType type;

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof LocalClass) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.type, ((LocalClass) r4).type) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.type + ')';
            }

            public LocalClass(KotlinType r2) {
                Intrinsics.checkNotNullParameter(r2, "type");
                super(null);
                this.type = r2;
            }

            public final KotlinType getType() {
                return this.type;
            }
        }

        /* JADX INFO: compiled from: constantValues.kt */
        public static final class NormalClass extends Value {
            private final ClassLiteralValue value;

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof NormalClass) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.value, ((NormalClass) r4).value) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.value + ')';
            }

            public NormalClass(ClassLiteralValue r2) {
                Intrinsics.checkNotNullParameter(r2, "value");
                super(null);
                this.value = r2;
            }

            public final ClassLiteralValue getValue() {
                return this.value;
            }

            public final ClassId getClassId() {
                return this.value.getClassId();
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }
        }

        public /* synthetic */ Value(DefaultConstructorMarker r1) {
            this();
        }

        private Value() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KClassValue(Value r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        super(r2);
    }

    public KClassValue(ClassLiteralValue r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this(new Value.NormalClass(r2));
    }

    public KClassValue(ClassId r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        this(new ClassLiteralValue(r2, r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "module");
        TypeAttributes r0 = TypeAttributes.Companion.getEmpty();
        ClassDescriptor r1 = r4.getBuiltIns().getKClass();
        Intrinsics.checkNotNullExpressionValue(r1, "module.builtIns.kClass");
        return KotlinTypeFactory.simpleNotNullType(r0, r1, CollectionsKt.listOf(new TypeProjectionImpl(getArgumentType(r4))));
    }

    public final KotlinType getArgumentType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Value r0 = getValue();
        if ((r0 instanceof Value.LocalClass) == false) goto L7;
        return ((Value.LocalClass) getValue()).getType();
    L7:
        if ((r0 instanceof Value.NormalClass) == false) goto L18;
        ClassLiteralValue r4 = ((Value.NormalClass) getValue()).getValue();
        ClassId r1 = r4.component1();
        int r6 = r4.component2();
        ClassDescriptor r2 = FindClassInModuleKt.findClassAcrossModuleDependencies(r5, r1);
        int r3 = 0;
        if (r2 != null) goto L12;
        ErrorTypeKind r7 = ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE;
        String r8 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "classId.toString()");
        return ErrorUtils.createErrorType(r7, new String[]{r8, String.valueOf(r6)});
    L12:
        SimpleType r9 = r2.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r9, "descriptor.defaultType");
        KotlinType r10 = TypeUtilsKt.replaceArgumentsWithStarProjections(r9);
    L13:
        if (r3 >= r6) goto L16;
        r10 = r5.getBuiltIns().getArrayType(Variance.INVARIANT, r10);
        Intrinsics.checkNotNullExpressionValue(r10, "module.builtIns.getArray…Variance.INVARIANT, type)");
        r3 = r3 + 1;
        goto L13
    L16:
        return r10;
    L18:
        throw new NoWhenBranchMatchedException();
    }
}

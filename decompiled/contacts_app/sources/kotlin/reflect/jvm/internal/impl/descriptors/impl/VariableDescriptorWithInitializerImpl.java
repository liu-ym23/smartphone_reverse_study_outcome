package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
    protected Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory;
    private final boolean isVar;

    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        Object[] r1 = new Object[3];
        if (r7 == 1) goto L12;
        if (r7 == 2) goto L11;
        if (r7 == 3) goto L10;
        if (r7 == 4) goto L9;
        if (r7 == 5) goto L9;
        r1[0] = "containingDeclaration";
    L13:
        r1[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (r7 == 4) goto L18;
        if (r7 == 5) goto L17;
        r1[2] = "<init>";
    L20:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
    L17:
        r1[2] = "setCompileTimeInitializer";
        goto L20
    L18:
        r1[2] = "setCompileTimeInitializerFactory";
    L9:
        r1[0] = "compileTimeInitializerFactory";
        goto L13
    L10:
        r1[0] = "source";
        goto L13
    L11:
        r1[0] = "name";
        goto L13
    L12:
        r1[0] = "annotations";
        goto L13
    }

    static {
    }

    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor r7, Annotations r8, Name r9, KotlinType r10, boolean r11, SourceElement r12) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r8 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r9 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r7, r8, r9, r10, r12);
        this.isVar = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.isVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer */
    public ConstantValue<?> mo2079getCompileTimeInitializer() {
        NullableLazyValue<ConstantValue<?>> r0 = this.compileTimeInitializer;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.invoke();
    }

    public void setCompileTimeInitializerFactory(Function0<NullableLazyValue<ConstantValue<?>>> r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        setCompileTimeInitializer(null, r2);
    }

    public void setCompileTimeInitializer(NullableLazyValue<ConstantValue<?>> r2, Function0<NullableLazyValue<ConstantValue<?>>> r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        this.compileTimeInitializerFactory = r3;
        if (r2 != null) goto L8;
        r2 = r3.invoke();
    L8:
        this.compileTimeInitializer = r2;
    }
}

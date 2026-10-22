package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    private final KotlinType annotationType;
    private final SourceElement source;
    private final Map<Name, ConstantValue<?>> valueArguments;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 3) goto L7;
        if (r10 == 4) goto L7;
        if (r10 == 5) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        if (r10 == 5) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        if (r10 == 1) goto L23;
        if (r10 == 2) goto L22;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        if (r10 == 5) goto L21;
        r6[0] = "annotationType";
    L24:
        if (r10 == 3) goto L30;
        if (r10 == 4) goto L29;
        if (r10 == 5) goto L28;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
    L31:
        if (r10 == 3) goto L35;
        if (r10 == 4) goto L35;
        if (r10 == 5) goto L35;
        r6[2] = "<init>";
    L35:
        String r4 = String.format(r3, r6);
        if (r10 == 3) goto L41;
        if (r10 == 4) goto L41;
        if (r10 == 5) goto L41;
        throw new IllegalArgumentException(r4);
    L41:
        throw new IllegalStateException(r4);
    L28:
        r6[1] = "getSource";
        goto L31
    L29:
        r6[1] = "getAllValueArguments";
        goto L31
    L30:
        r6[1] = "getType";
    L21:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        goto L24
    L22:
        r6[0] = "source";
        goto L24
    L23:
        r6[0] = "valueArguments";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public AnnotationDescriptorImpl(KotlinType r2, Map<Name, ConstantValue<?>> r3, SourceElement r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        this.annotationType = r2;
        this.valueArguments = r3;
        this.source = r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public KotlinType getType() {
        KotlinType r1 = this.annotationType;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        Map<Name, ConstantValue<?>> r1 = this.valueArguments;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement r1 = this.source;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, null);
    }
}

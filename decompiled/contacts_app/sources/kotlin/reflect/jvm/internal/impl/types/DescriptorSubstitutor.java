package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes4.dex */
public class DescriptorSubstitutor {
    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        if (r7 == 4) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 4) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L12;
        };
    L12:
        r4[0] = "typeParameters";
    L18:
        if (r7 == 4) goto L20;
        r4[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
    L21:
        if (r7 == 4) goto L23;
        r4[2] = "substituteTypeParameters";
    L23:
        String r2 = String.format(r1, r4);
        if (r7 == 4) goto L27;
        throw new IllegalArgumentException(r2);
    L27:
        throw new IllegalStateException(r2);
    L20:
        r4[1] = "substituteTypeParameters";
        goto L21
    L13:
        r4[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        goto L18
    L14:
        r4[0] = "result";
        goto L18
    L15:
        r4[0] = "newContainingDeclaration";
        goto L18
    L16:
        r4[0] = "originalSubstitution";
        goto L18
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> r1, TypeSubstitution r2, DeclarationDescriptor r3, List<TypeParameterDescriptor> r4) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r3 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r4 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        TypeSubstitutor r5 = substituteTypeParameters(r1, r2, r3, r4, null);
        if (r5 == null) goto L16;
        if (r5 != null) goto L14;
        $$$reportNull$$$0(4);
    L14:
        return r5;
    L16:
        throw new AssertionError("Substitution failed");
    }

    public static TypeSubstitutor substituteTypeParameters(List<TypeParameterDescriptor> r16, TypeSubstitution r17, DeclarationDescriptor r18, List<TypeParameterDescriptor> r19, boolean[] r20) {
        if (r16 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        if (r17 != null) goto L7;
        $$$reportNull$$$0(6);
    L7:
        if (r18 != null) goto L9;
        $$$reportNull$$$0(7);
    L9:
        if (r19 != null) goto L11;
        $$$reportNull$$$0(8);
    L11:
        HashMap r2 = new HashMap();
        HashMap r11 = new HashMap();
        Iterator<TypeParameterDescriptor> r12 = r16.iterator();
        int r8 = 0;
    L13:
        if (r12.hasNext() == false) goto L15;
        TypeParameterDescriptor r14 = r12.next();
        TypeParameterDescriptorImpl r3 = TypeParameterDescriptorImpl.createForFurtherModification(r18, r14.getAnnotations(), r14.isReified(), r14.getVariance(), r14.getName(), r8, SourceElement.NO_SOURCE, r14.getStorageManager());
        r2.put(r14.getTypeConstructor(), new TypeProjectionImpl(r3.getDefaultType()));
        r11.put(r14, r3);
        r19.add(r3);
        r8 = r8 + 1;
        goto L13
    L15:
        TypeConstructorSubstitution r1 = TypeConstructorSubstitution.createByConstructorsMap(r2);
        TypeSubstitutor r4 = TypeSubstitutor.createChainedSubstitutor(r17, r1);
        TypeSubstitutor r0 = TypeSubstitutor.createChainedSubstitutor(r17.replaceWithNonApproximating(), r1);
        Iterator<TypeParameterDescriptor> r5 = r16.iterator();
    L17:
        if (r5.hasNext() == false) goto L36;
        TypeParameterDescriptor r6 = r5.next();
        TypeParameterDescriptorImpl r7 = (TypeParameterDescriptorImpl) r11.get(r6);
        Iterator<KotlinType> r9 = r6.getUpperBounds().iterator();
    L20:
        if (r9.hasNext() == false) goto L35;
        KotlinType r10 = r9.next();
        ClassifierDescriptor r13 = r10.getConstructor().mo2083getDeclarationDescriptor();
        if ((r13 instanceof TypeParameterDescriptor) == true) goto L24;
    L26:
        TypeSubstitutor r15 = r0;
    L27:
        KotlinType r21 = r15.substitute(r10, Variance.OUT_VARIANCE);
        if (r21 == null) goto L29;
        if (r21 == r10) goto L34;
        if (r20 == null) goto L34;
        r20[0] = true;
    L34:
        r7.addUpperBound(r21);
        goto L20
    L29:
        return null;
    L24:
        if (TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor) r13) == false) goto L26;
        r15 = r4;
        goto L27
    L35:
        r7.setInitialized();
        goto L17
    L36:
        return r4;
    }
}

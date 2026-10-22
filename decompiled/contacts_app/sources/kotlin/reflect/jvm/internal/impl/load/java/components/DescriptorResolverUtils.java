package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorResolverUtils {
    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        if (r7 == 18) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 18) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L12;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L12;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L13;
            default: goto L12;
        };
    L12:
        r4[0] = "name";
    L21:
        if (r7 == 18) goto L23;
        r4[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
    L24:
        switch(r7) {
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L29;
            case 19: goto L26;
            case 20: goto L26;
            default: goto L25;
        };
    L25:
        r4[2] = "resolveOverridesForNonStaticMembers";
        goto L29
    L26:
        r4[2] = "getAnnotationParameterByName";
        goto L29
    L27:
        r4[2] = "resolveOverrides";
        goto L29
    L28:
        r4[2] = "resolveOverridesForStaticMembers";
    L29:
        String r2 = String.format(r1, r4);
        if (r7 == 18) goto L33;
        throw new IllegalArgumentException(r2);
    L33:
        throw new IllegalStateException(r2);
    L23:
        r4[1] = "resolveOverrides";
        goto L24
    L13:
        r4[0] = "annotationClass";
        goto L21
    L14:
        r4[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        goto L21
    L15:
        r4[0] = "overridingUtil";
        goto L21
    L16:
        r4[0] = "errorReporter";
        goto L21
    L17:
        r4[0] = "classDescriptor";
        goto L21
    L18:
        r4[0] = "membersFromCurrent";
        goto L21
    L19:
        r4[0] = "membersFromSupertypes";
        goto L21
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name r8, Collection<D> r9, Collection<D> r10, ClassDescriptor r11, ErrorReporter r12, OverridingUtil r13) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r10 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r11 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r12 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r13 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        return resolveOverrides(r8, r9, r10, r11, r12, r13, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name r8, Collection<D> r9, Collection<D> r10, ClassDescriptor r11, ErrorReporter r12, OverridingUtil r13) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r10 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r11 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        if (r12 != null) goto L12;
        $$$reportNull$$$0(10);
    L12:
        if (r13 != null) goto L15;
        $$$reportNull$$$0(11);
    L15:
        return resolveOverrides(r8, r9, r10, r11, r12, r13, true);
    }

    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(Name r7, Collection<D> r8, Collection<D> r9, ClassDescriptor r10, final ErrorReporter r11, OverridingUtil r12, final boolean r13) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r8 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r9 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r10 != null) goto L10;
        $$$reportNull$$$0(15);
    L10:
        if (r11 != null) goto L12;
        $$$reportNull$$$0(16);
    L12:
        if (r12 != null) goto L14;
        $$$reportNull$$$0(17);
    L14:
        final LinkedHashSet r0 = new LinkedHashSet();
        r12.generateOverridesInFunctionGroup(r7, r8, r9, r10, new AnonymousClass1(r11, r0, r13));
        return r0;
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name r3, ClassDescriptor r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        Collection<ClassConstructorDescriptor> r5 = r4.getConstructors();
        if (r5.size() == 1) goto L9;
        return null;
    L9:
        Iterator<ValueParameterDescriptor> r6 = r5.iterator().next().getValueParameters().iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        ValueParameterDescriptor r0 = r6.next();
        if (r0.getName().equals(r3) == false) goto L11;
        return r0;
    L15:
        return null;
    }
}

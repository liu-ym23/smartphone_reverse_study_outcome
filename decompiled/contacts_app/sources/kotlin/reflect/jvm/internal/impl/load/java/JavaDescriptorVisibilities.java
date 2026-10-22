package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes4.dex */
public class JavaDescriptorVisibilities {
    public static final DescriptorVisibility PACKAGE_VISIBILITY = null;
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE = null;
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY = null;
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 5) goto L6;
        if (r9 == 6) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 5) goto L11;
        if (r9 == 6) goto L11;
        int r5 = 3;
    L12:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r6[0] = "what";
    L21:
        if (r9 == 5) goto L24;
        if (r9 == 6) goto L24;
        r6[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
    L25:
        if (r9 == 2) goto L33;
        if (r9 == 3) goto L33;
        if (r9 == 4) goto L32;
        if (r9 == 5) goto L34;
        if (r9 == 6) goto L34;
        r6[2] = "isVisibleForProtectedAndPackage";
    L34:
        String r3 = String.format(r2, r6);
        if (r9 == 5) goto L39;
        if (r9 == 6) goto L39;
        throw new IllegalArgumentException(r3);
    L39:
        throw new IllegalStateException(r3);
    L32:
        r6[2] = "toDescriptorVisibility";
    L33:
        r6[2] = "areInSamePackage";
    L24:
        r6[1] = "toDescriptorVisibility";
        goto L25
    L15:
        r6[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        goto L21
    L16:
        r6[0] = "visibility";
        goto L21
    L17:
        r6[0] = "second";
        goto L21
    L18:
        r6[0] = "first";
        goto L21
    L19:
        r6[0] = "from";
    L11:
        r5 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static /* synthetic */ boolean access$000(DeclarationDescriptor r0, DeclarationDescriptor r1) {
        return areInSamePackage(r0, r1);
    }

    static /* synthetic */ boolean access$100(ReceiverValue r0, DeclarationDescriptorWithVisibility r1, DeclarationDescriptor r2) {
        return isVisibleForProtectedAndPackage(r0, r1, r2);
    }

    static {
        final JavaVisibilities.PackageVisibility r1 = JavaVisibilities.PackageVisibility.INSTANCE;
        DelegatedDescriptorVisibility r0 = new AnonymousClass1(r1);
        PACKAGE_VISIBILITY = r0;
        final JavaVisibilities.ProtectedStaticVisibility r2 = JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        DelegatedDescriptorVisibility r3 = new AnonymousClass2(r2);
        PROTECTED_STATIC_VISIBILITY = r3;
        final JavaVisibilities.ProtectedAndPackage r4 = JavaVisibilities.ProtectedAndPackage.INSTANCE;
        DelegatedDescriptorVisibility r5 = new AnonymousClass3(r4);
        PROTECTED_AND_PACKAGE = r5;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r0);
        recordVisibilityMapping(r3);
        recordVisibilityMapping(r5);
    }

    private static boolean isVisibleForProtectedAndPackage(ReceiverValue r3, DeclarationDescriptorWithVisibility r4, DeclarationDescriptor r5) {
        if (r4 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r5 != null) goto L9;
        $$$reportNull$$$0(1);
    L9:
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(r4), r5) == false) goto L12;
        return true;
    L12:
        return DescriptorVisibilities.PROTECTED.isVisible(r3, r4, r5, false);
    }

    private static boolean areInSamePackage(DeclarationDescriptor r2, DeclarationDescriptor r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(3);
    L6:
        PackageFragmentDescriptor r4 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r2, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor r5 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r3, PackageFragmentDescriptor.class, false);
        if (r5 == null) goto L13;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r4.getFqName().equals(r5.getFqName()) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    private static void recordVisibilityMapping(DescriptorVisibility r2) {
        visibilitiesMapping.put(r2.getDelegate(), r2);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        DescriptorVisibility r0 = visibilitiesMapping.get(r1);
        if (r0 != null) goto L10;
        DescriptorVisibility r2 = DescriptorVisibilities.toDescriptorVisibility(r1);
        if (r2 != null) goto L9;
        $$$reportNull$$$0(5);
    L9:
        return r2;
    L10:
        if (r0 != null) goto L12;
        $$$reportNull$$$0(6);
    L12:
        return r0;
    }
}

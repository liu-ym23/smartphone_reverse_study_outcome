package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = null;

    static {
        INSTANCE = new DescriptorEquivalenceForOverrides();
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor r9, TypeParameterDescriptor r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "a");
        Intrinsics.checkNotNullParameter(r10, "b");
        return areTypeParametersEquivalent$default(this, r9, r10, r11, null, 8, null);
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides r0, DeclarationDescriptor r1, DeclarationDescriptor r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = true;
    L6:
        return r0.areEquivalent(r1, r2, r3, r4);
    }

    public final boolean areEquivalent(DeclarationDescriptor r11, DeclarationDescriptor r12, boolean r13, boolean r14) {
        if ((r11 instanceof ClassDescriptor) == false) goto L8;
        if ((r12 instanceof ClassDescriptor) == false) goto L8;
        return areClassesEquivalent((ClassDescriptor) r11, (ClassDescriptor) r12);
    L8:
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L13;
        if ((r12 instanceof TypeParameterDescriptor) == false) goto L13;
        return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) r11, (TypeParameterDescriptor) r12, r13, null, 8, null);
    L13:
        if ((r11 instanceof CallableDescriptor) == false) goto L18;
        if ((r12 instanceof CallableDescriptor) == false) goto L18;
        return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) r11, (CallableDescriptor) r12, r13, r14, false, KotlinTypeRefiner.Default.INSTANCE, 16, null);
    L18:
        if ((r11 instanceof PackageFragmentDescriptor) == false) goto L23;
        if ((r12 instanceof PackageFragmentDescriptor) == false) goto L23;
        return Intrinsics.areEqual(((PackageFragmentDescriptor) r11).getFqName(), ((PackageFragmentDescriptor) r12).getFqName());
    L23:
        return Intrinsics.areEqual(r11, r12);
    }

    private final boolean areClassesEquivalent(ClassDescriptor r1, ClassDescriptor r2) {
        return Intrinsics.areEqual(r1.getTypeConstructor(), r2.getTypeConstructor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides r0, TypeParameterDescriptor r1, TypeParameterDescriptor r2, boolean r3, C04761 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = C04761.INSTANCE;
    L6:
        return r0.areTypeParametersEquivalent(r1, r2, r3, r4);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor r5, TypeParameterDescriptor r6, boolean r7, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r6, "b");
        Intrinsics.checkNotNullParameter(r8, "equivalentCallables");
        if (Intrinsics.areEqual(r5, r6) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r5.getContainingDeclaration(), r6.getContainingDeclaration()) == false) goto L9;
        return false;
    L9:
        if (ownersEquivalent(r5, r6, r8, r7) == true) goto L12;
        return false;
    L12:
        if (r5.getIndex() != r6.getIndex()) goto L15;
        return true;
    L15:
        return false;
    }

    private final SourceElement singleSource(CallableMemberDescriptor r3) {
    L3:
        if ((r3 instanceof CallableMemberDescriptor) == false) goto L13;
        CallableMemberDescriptor r2 = (CallableMemberDescriptor) r3;
        if (r2.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L13;
        Collection<? extends CallableMemberDescriptor> r4 = r2.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r4, "overriddenDescriptors");
        CallableMemberDescriptor r5 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(r4);
        if (r5 == null) goto L10;
        r3 = r5;
        goto L3
    L10:
        return null;
    L13:
        return r3.getSource();
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides r7, CallableDescriptor r8, CallableDescriptor r9, boolean r10, boolean r11, boolean r12, KotlinTypeRefiner r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = true;
    L5:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r12 = false;
    L9:
        return r7.areCallableDescriptorsEquivalent(r8, r9, r10, r4, r12, r13);
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor r5, final CallableDescriptor r6, final boolean r7, boolean r8, boolean r9, KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r5, "a");
        Intrinsics.checkNotNullParameter(r6, "b");
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        if (Intrinsics.areEqual(r5, r6) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r5.getName(), r6.getName()) == true) goto L8;
        return false;
    L8:
        if (r8 == false) goto L17;
        if ((r5 instanceof MemberDescriptor) == false) goto L17;
        if ((r6 instanceof MemberDescriptor) == false) goto L17;
        if (((MemberDescriptor) r5).isExpect() == ((MemberDescriptor) r6).isExpect()) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r5.getContainingDeclaration(), r6.getContainingDeclaration()) == false) goto L23;
        if (r7 == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(singleSource(r5), singleSource(r6)) == true) goto L23;
        return false;
    L23:
        CallableDescriptor r11 = r5;
        if (DescriptorUtils.isLocal(r11) == true) goto L38;
        CallableDescriptor r0 = r6;
        if (DescriptorUtils.isLocal(r0) == true) goto L38;
        if (ownersEquivalent(r11, r0, AnonymousClass1.INSTANCE, r7) == true) goto L31;
        return false;
    L31:
        OverridingUtil r4 = OverridingUtil.create(r10, new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(r7, r5, r6));
        Intrinsics.checkNotNullExpressionValue(r4, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        if (r4.isOverridableBy(r5, r6, null, !r9).getResult() != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L37;
        if (r4.isOverridableBy(r6, r5, null, !r9).getResult() != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L37;
        return true;
    L37:
        return false;
    L38:
        return false;
    }

    private final boolean ownersEquivalent(DeclarationDescriptor r8, DeclarationDescriptor r9, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> r10, boolean r11) {
        DeclarationDescriptor r1 = r8.getContainingDeclaration();
        DeclarationDescriptor r2 = r9.getContainingDeclaration();
        if ((r1 instanceof CallableMemberDescriptor) == true) goto L9;
        if ((r2 instanceof CallableMemberDescriptor) == true) goto L9;
        return areEquivalent$default(this, r1, r2, r11, false, 8, null);
    L9:
        return r10.invoke(r1, r2).booleanValue();
    }
}

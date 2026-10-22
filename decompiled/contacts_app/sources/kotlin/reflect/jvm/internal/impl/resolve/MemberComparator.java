package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public class MemberComparator implements Comparator<DeclarationDescriptor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final MemberComparator INSTANCE = null;
    private static final DescriptorRenderer RENDERER = null;

    public static class NameAndTypeMemberComparator implements Comparator<DeclarationDescriptor> {
        public static final NameAndTypeMemberComparator INSTANCE = null;

        static /* synthetic */ Integer access$000(DeclarationDescriptor r0, DeclarationDescriptor r1) {
            return compareInternal(r0, r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor r1, DeclarationDescriptor r2) {
            return compare2(r1, r2);
        }

        static {
            INSTANCE = new NameAndTypeMemberComparator();
        }

        private NameAndTypeMemberComparator() {
        }

        private static int getDeclarationPriority(DeclarationDescriptor r1) {
            if (DescriptorUtils.isEnumEntry(r1) == false) goto L7;
            return 8;
        L7:
            if ((r1 instanceof ConstructorDescriptor) == false) goto L11;
            return 7;
        L11:
            if ((r1 instanceof PropertyDescriptor) == false) goto L19;
            if (((PropertyDescriptor) r1).getExtensionReceiverParameter() != null) goto L16;
            return 6;
        L16:
            return 5;
        L19:
            if ((r1 instanceof FunctionDescriptor) == false) goto L27;
            if (((FunctionDescriptor) r1).getExtensionReceiverParameter() != null) goto L24;
            return 4;
        L24:
            return 3;
        L27:
            if ((r1 instanceof ClassDescriptor) == false) goto L31;
            return 2;
        L31:
            if ((r1 instanceof TypeAliasDescriptor) == false) goto L34;
            return 1;
        L34:
            return 0;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(DeclarationDescriptor r1, DeclarationDescriptor r2) {
            Integer r0 = compareInternal(r1, r2);
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.intValue();
        }

        private static Integer compareInternal(DeclarationDescriptor r2, DeclarationDescriptor r3) {
            int r0 = getDeclarationPriority(r3) - getDeclarationPriority(r2);
            if (r0 == 0) goto L7;
            return Integer.valueOf(r0);
        L7:
            if (DescriptorUtils.isEnumEntry(r2) == true) goto L9;
        L12:
            int r4 = r2.getName().compareTo2(r3.getName());
            if (r4 != 0) goto L15;
            return null;
        L15:
            return Integer.valueOf(r4);
        L9:
            if (DescriptorUtils.isEnumEntry(r3) == false) goto L12;
            return 0;
        }
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(DeclarationDescriptor r1, DeclarationDescriptor r2) {
        return compare2(r1, r2);
    }

    static {
        INSTANCE = new MemberComparator();
        RENDERER = DescriptorRenderer.Companion.withOptions(new AnonymousClass1());
    }

    private MemberComparator() {
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(DeclarationDescriptor r12, DeclarationDescriptor r13) {
        Integer r11 = NameAndTypeMemberComparator.access$000(r12, r13);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        if ((r12 instanceof TypeAliasDescriptor) == false) goto L14;
        if ((r13 instanceof TypeAliasDescriptor) == false) goto L14;
        DescriptorRenderer r1 = RENDERER;
        int r14 = r1.renderType(((TypeAliasDescriptor) r12).getUnderlyingType()).compareTo(r1.renderType(((TypeAliasDescriptor) r13).getUnderlyingType()));
        if (r14 == 0) goto L71;
        return r14;
    L71:
        DescriptorRenderer r15 = RENDERER;
        int r16 = r15.render(r12).compareTo(r15.render(r13));
        if (r16 == 0) goto L75;
        return r16;
    L75:
        return DescriptorUtils.getContainingModule(r12).getName().compareTo2(DescriptorUtils.getContainingModule(r13).getName());
    L14:
        if ((r12 instanceof CallableDescriptor) == false) goto L57;
        if ((r13 instanceof CallableDescriptor) == false) goto L57;
        CallableDescriptor r17 = (CallableDescriptor) r12;
        CallableDescriptor r2 = (CallableDescriptor) r13;
        ReceiverParameterDescriptor r3 = r17.getExtensionReceiverParameter();
        ReceiverParameterDescriptor r4 = r2.getExtensionReceiverParameter();
        if (r3 == null) goto L22;
        DescriptorRenderer r5 = RENDERER;
        int r6 = r5.renderType(r3.getType()).compareTo(r5.renderType(r4.getType()));
        if (r6 == 0) goto L22;
        return r6;
    L22:
        List<ValueParameterDescriptor> r7 = r17.getValueParameters();
        List<ValueParameterDescriptor> r8 = r2.getValueParameters();
        int r9 = 0;
    L24:
        if (r9 >= Math.min(r7.size(), r8.size())) goto L29;
        DescriptorRenderer r10 = RENDERER;
        int r18 = r10.renderType(r7.get(r9).getType()).compareTo(r10.renderType(r8.get(r9).getType()));
        if (r18 != 0) goto L27;
        r9 = r9 + 1;
        goto L24
    L27:
        return r18;
    L29:
        int r19 = r7.size() - r8.size();
        if (r19 == 0) goto L32;
        return r19;
    L32:
        List<TypeParameterDescriptor> r20 = r17.getTypeParameters();
        List<TypeParameterDescriptor> r21 = r2.getTypeParameters();
        int r22 = 0;
    L34:
        if (r22 >= Math.min(r20.size(), r21.size())) goto L46;
        List<KotlinType> r23 = r20.get(r22).getUpperBounds();
        List<KotlinType> r24 = r21.get(r22).getUpperBounds();
        int r25 = r23.size() - r24.size();
        if (r25 != 0) goto L37;
        int r26 = 0;
    L40:
        if (r26 >= r23.size()) goto L45;
        DescriptorRenderer r27 = RENDERER;
        int r28 = r27.renderType(r23.get(r26)).compareTo(r27.renderType(r24.get(r26)));
        if (r28 != 0) goto L43;
        r26 = r26 + 1;
        goto L40
    L43:
        return r28;
    L45:
        r22 = r22 + 1;
        goto L34
    L37:
        return r25;
    L46:
        int r0 = r20.size() - r21.size();
        if (r0 == 0) goto L50;
        return r0;
    L50:
        if ((r17 instanceof CallableMemberDescriptor) == false) goto L71;
        if ((r2 instanceof CallableMemberDescriptor) == false) goto L71;
        int r110 = ((CallableMemberDescriptor) r17).getKind().ordinal() - ((CallableMemberDescriptor) r2).getKind().ordinal();
        if (r110 == 0) goto L71;
        return r110;
    L57:
        if ((r12 instanceof ClassDescriptor) == false) goto L77;
        if ((r13 instanceof ClassDescriptor) == false) goto L77;
        ClassDescriptor r111 = (ClassDescriptor) r12;
        ClassDescriptor r29 = (ClassDescriptor) r13;
        if (r111.getKind().ordinal() == r29.getKind().ordinal()) goto L65;
        return r111.getKind().ordinal() - r29.getKind().ordinal();
    L65:
        if (r111.isCompanionObject() == r29.isCompanionObject()) goto L71;
        if (r111.isCompanionObject() == true) goto L84;
        return -1;
    L84:
        return 1;
    L77:
        throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{r12, r12.getClass(), r13, r13.getClass()}));
    }
}

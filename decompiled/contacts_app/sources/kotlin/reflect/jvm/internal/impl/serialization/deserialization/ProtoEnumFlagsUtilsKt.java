package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ProtoEnumFlagsUtilsKt {

    /* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[ProtoBuf.MemberKind.values().length];
            r0[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r0[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r0[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L44:
            r0[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L10:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[CallableMemberDescriptor.Kind.values().length];
            r1[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L58:
            r1[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            r1[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r1[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L15:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[ProtoBuf.Visibility.values().length];
            r2[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L40:
            r2[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L48:
            r2[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L54:
            r2[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L62:
            r2[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L42:
            r2[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L22:
            $EnumSwitchMapping$2 = r2;
        }
    }

    public static final CallableMemberDescriptor.Kind memberKind(ProtoEnumFlags r1, ProtoBuf.MemberKind r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L22;
        if (r3 == 4) goto L21;
        return CallableMemberDescriptor.Kind.DECLARATION;
    L21:
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    L22:
        return CallableMemberDescriptor.Kind.DELEGATION;
    L23:
        return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
    L19:
        return CallableMemberDescriptor.Kind.DECLARATION;
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L7
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags r1, ProtoBuf.Visibility r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L8:
        DescriptorVisibility r4 = DescriptorVisibilities.PRIVATE;
        Intrinsics.checkNotNullExpressionValue(r4, "PRIVATE");
        return r4;
    L9:
        DescriptorVisibility r5 = DescriptorVisibilities.LOCAL;
        Intrinsics.checkNotNullExpressionValue(r5, "LOCAL");
        return r5;
    L10:
        DescriptorVisibility r6 = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(r6, "PUBLIC");
        return r6;
    L11:
        DescriptorVisibility r7 = DescriptorVisibilities.PROTECTED;
        Intrinsics.checkNotNullExpressionValue(r7, "PROTECTED");
        return r7;
    L12:
        DescriptorVisibility r8 = DescriptorVisibilities.PRIVATE_TO_THIS;
        Intrinsics.checkNotNullExpressionValue(r8, "PRIVATE_TO_THIS");
        return r8;
    L13:
        DescriptorVisibility r9 = DescriptorVisibilities.PRIVATE;
        Intrinsics.checkNotNullExpressionValue(r9, "PRIVATE");
        return r9;
    L14:
        DescriptorVisibility r10 = DescriptorVisibilities.INTERNAL;
        Intrinsics.checkNotNullExpressionValue(r10, "INTERNAL");
        return r10;
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$2[r2.ordinal()];
        goto L7
    }
}

package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AbstractBinaryClassAnnotationLoaderKt {
    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf.Property r7, NameResolver r8, TypeTable r9, boolean r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r13 & 16) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r13 & 32) == 0) goto L14;
        r12 = true;
    L14:
        return getPropertySignature(r7, r8, r9, r4, r5, r12);
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public static final MemberSignature getPropertySignature(ProtoBuf.Property r3, NameResolver r4, TypeTable r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "proto");
        Intrinsics.checkNotNullParameter(r4, "nameResolver");
        Intrinsics.checkNotNullParameter(r5, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r1 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r1, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r0 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r3, r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r6 == false) goto L11;
        JvmMemberSignature.Field r9 = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(r3, r4, r5, r8);
        if (r9 != null) goto L10;
        return null;
    L10:
        return MemberSignature.Companion.fromJvmMemberSignature(r9);
    L11:
        if (r7 == true) goto L13;
    L16:
        return null;
    L13:
        if (r0.hasSyntheticMethod() == false) goto L16;
        MemberSignature.Companion r10 = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature r11 = r0.getSyntheticMethod();
        Intrinsics.checkNotNullExpressionValue(r11, "signature.syntheticMethod");
        return r10.fromMethod(r4, r11);
    }
}

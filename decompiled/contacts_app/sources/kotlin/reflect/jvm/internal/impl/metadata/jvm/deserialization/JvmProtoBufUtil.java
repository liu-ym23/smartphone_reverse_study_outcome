package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: compiled from: JvmProtoBufUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY = null;
    public static final JvmProtoBufUtil INSTANCE = null;

    private JvmProtoBufUtil() {
    }

    static {
        INSTANCE = new JvmProtoBufUtil();
        ExtensionRegistryLite r0 = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(r0);
        Intrinsics.checkNotNullExpressionValue(r0, "newInstance().apply(JvmP…f::registerAllExtensions)");
        EXTENSION_REGISTRY = r0;
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] r1, String[] r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r2, "strings");
        byte[] r3 = BitEncoding.decodeBytes(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "decodeBytes(data)");
        return readClassDataFrom(r3, r2);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        Intrinsics.checkNotNullParameter(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r2);
        ByteArrayInputStream r1 = r0;
        return new Pair(INSTANCE.readNameResolver(r1, r3), ProtoBuf.Class.parseFrom(r1, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] r1, String[] r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r2, "strings");
        byte[] r3 = BitEncoding.decodeBytes(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "decodeBytes(data)");
        return readPackageDataFrom(r3, r2);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        Intrinsics.checkNotNullParameter(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r2);
        ByteArrayInputStream r1 = r0;
        return new Pair(INSTANCE.readNameResolver(r1, r3), ProtoBuf.Package.parseFrom(r1, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(BitEncoding.decodeBytes(r2));
        ByteArrayInputStream r1 = r0;
        return new Pair(INSTANCE.readNameResolver(r1, r3), ProtoBuf.Function.parseFrom(r1, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream r2, String[] r3) {
        JvmProtoBuf.StringTableTypes r4 = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(r2, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(r4, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new JvmNameResolver(r4, r3);
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function r13, NameResolver r14, TypeTable r15) {
        Intrinsics.checkNotNullParameter(r13, "proto");
        Intrinsics.checkNotNullParameter(r14, "nameResolver");
        Intrinsics.checkNotNullParameter(r15, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> r1 = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(r1, "methodSignature");
        JvmProtoBuf.JvmMethodSignature r0 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r13, r1);
        if (r0 != null) goto L5;
    L7:
        int r2 = r13.getName();
    L8:
        if (r0 != null) goto L10;
    L12:
        List r3 = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(r13, r15));
        List<ProtoBuf.ValueParameter> r4 = r13.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r4, "proto.valueParameterList");
        List<ProtoBuf.ValueParameter> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        ProtoBuf.ValueParameter r8 = (ProtoBuf.ValueParameter) r7.next();
        Intrinsics.checkNotNullExpressionValue(r8, "it");
        r6.add(ProtoTypeTableUtilKt.type(r8, r15));
        goto L14
    L16:
        List r9 = CollectionsKt.plus(r3, r6);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L23;
        String r12 = INSTANCE.mapTypeDefault((ProtoBuf.Type) r11.next(), r14);
        if (r12 == null) goto L21;
        r10.add(r12);
        goto L18
    L21:
        return null;
    L23:
        ArrayList r16 = r10;
        String r17 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r13, r15), r14);
        if (r17 != null) goto L26;
        return null;
    L26:
        String r18 = CollectionsKt.joinToString$default(r16, "", "(", ")", 0, null, null, 56, null) + r17;
    L28:
        return new JvmMemberSignature.Method(r14.getString(r2), r18);
    L10:
        if (r0.hasDesc() == false) goto L12;
        r18 = r14.getString(r0.getDesc());
        goto L28
    L5:
        if (r0.hasName() == false) goto L7;
        r2 = r0.getName();
        goto L8
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor r11, NameResolver r12, TypeTable r13) {
        Intrinsics.checkNotNullParameter(r11, "proto");
        Intrinsics.checkNotNullParameter(r12, "nameResolver");
        Intrinsics.checkNotNullParameter(r13, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> r0 = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(r0, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature r10 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r11, r0);
        if (r10 != null) goto L5;
    L7:
        String r1 = "<init>";
    L8:
        if (r10 != null) goto L10;
    L12:
        List<ProtoBuf.ValueParameter> r14 = r11.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r14, "proto.valueParameterList");
        List<ProtoBuf.ValueParameter> r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L14:
        if (r17.hasNext() == false) goto L20;
        ProtoBuf.ValueParameter r2 = (ProtoBuf.ValueParameter) r17.next();
        JvmProtoBufUtil r3 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        String r4 = r3.mapTypeDefault(ProtoTypeTableUtilKt.type(r2, r13), r12);
        if (r4 == null) goto L17;
        r16.add(r4);
        goto L14
    L17:
        return null;
    L20:
        String r18 = CollectionsKt.joinToString$default(r16, "", "(", ")V", 0, null, null, 56, null);
    L22:
        return new JvmMemberSignature.Method(r1, r18);
    L10:
        if (r10.hasDesc() == false) goto L12;
        r18 = r12.getString(r10.getDesc());
        goto L22
    L5:
        if (r10.hasName() == false) goto L7;
        r1 = r12.getString(r10.getName());
        goto L8
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil r0, ProtoBuf.Property r1, NameResolver r2, TypeTable r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = true;
    L6:
        return r0.getJvmFieldSignature(r1, r2, r3, r4);
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property r4, NameResolver r5, TypeTable r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        Intrinsics.checkNotNullParameter(r6, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r1 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r1, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r0 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r4, r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.hasField() == false) goto L8;
        JvmProtoBuf.JvmFieldSignature r2 = r0.getField();
    L9:
        if (r2 != null) goto L12;
        if (r7 == false) goto L12;
        return null;
    L12:
        if (r2 != null) goto L14;
    L16:
        int r8 = r4.getName();
    L17:
        if (r2 != null) goto L19;
    L21:
        String r3 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r4, r6), r5);
        if (r3 != null) goto L25;
        return null;
    L25:
        return new JvmMemberSignature.Field(r5.getString(r8), r3);
    L19:
        if (r2.hasDesc() == false) goto L21;
        r3 = r5.getString(r2.getDesc());
        goto L25
    L14:
        if (r2.hasName() == false) goto L16;
        r8 = r2.getName();
        goto L17
    L8:
        r2 = null;
        goto L9
    }

    private final String mapTypeDefault(ProtoBuf.Type r1, NameResolver r2) {
        if (r1.hasClassName() == true) goto L7;
        return null;
    L7:
        return ClassMapperLite.mapClass(r2.getQualifiedClassName(r1.getClassName()));
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property r2) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        Flags.BooleanFlagField r0 = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object r3 = r2.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(r3, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean r4 = r0.get(((Number) r3).intValue());
        Intrinsics.checkNotNullExpressionValue(r4, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return r4.booleanValue();
    }
}

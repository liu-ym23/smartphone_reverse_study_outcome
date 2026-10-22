package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: compiled from: protoTypeTableUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ProtoTypeTableUtilKt {
    public static final List<ProtoBuf.Type> supertypes(ProtoBuf.Class r3, TypeTable r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "typeTable");
        List<ProtoBuf.Type> r0 = r3.getSupertypeList();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L14;
        List<Integer> r5 = r3.getSupertypeIdList();
        Intrinsics.checkNotNullExpressionValue(r5, "supertypeIdList");
        List<Integer> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        Integer r2 = (Integer) r7.next();
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.add(r4.get(r2.intValue()));
        goto L9
    L12:
        return r1;
    L14:
        return r0;
    }

    public static final ProtoBuf.Type inlineClassUnderlyingType(ProtoBuf.Class r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasInlineClassUnderlyingType() == false) goto L6;
        return r1.getInlineClassUnderlyingType();
    L6:
        if (r1.hasInlineClassUnderlyingTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getInlineClassUnderlyingTypeId());
    }

    public static final ProtoBuf.Type type(ProtoBuf.Type.Argument r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasType() == false) goto L6;
        return r1.getType();
    L6:
        if (r1.hasTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getTypeId());
    }

    public static final ProtoBuf.Type flexibleUpperBound(ProtoBuf.Type r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasFlexibleUpperBound() == false) goto L6;
        return r1.getFlexibleUpperBound();
    L6:
        if (r1.hasFlexibleUpperBoundId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getFlexibleUpperBoundId());
    }

    public static final List<ProtoBuf.Type> upperBounds(ProtoBuf.TypeParameter r3, TypeTable r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "typeTable");
        List<ProtoBuf.Type> r0 = r3.getUpperBoundList();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L14;
        List<Integer> r5 = r3.getUpperBoundIdList();
        Intrinsics.checkNotNullExpressionValue(r5, "upperBoundIdList");
        List<Integer> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        Integer r2 = (Integer) r7.next();
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.add(r4.get(r2.intValue()));
        goto L9
    L12:
        return r1;
    L14:
        return r0;
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Function r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasReturnType() == false) goto L6;
        ProtoBuf.Type r3 = r1.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r3, "returnType");
        return r3;
    L6:
        if (r1.hasReturnTypeId() == false) goto L10;
        return r2.get(r1.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final boolean hasReceiver(ProtoBuf.Function r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Function r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasReceiverType() == false) goto L6;
        return r1.getReceiverType();
    L6:
        if (r1.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getReceiverTypeId());
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Property r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasReturnType() == false) goto L6;
        ProtoBuf.Type r3 = r1.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r3, "returnType");
        return r3;
    L6:
        if (r1.hasReturnTypeId() == false) goto L10;
        return r2.get(r1.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final boolean hasReceiver(ProtoBuf.Property r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Property r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasReceiverType() == false) goto L6;
        return r1.getReceiverType();
    L6:
        if (r1.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getReceiverTypeId());
    }

    public static final ProtoBuf.Type type(ProtoBuf.ValueParameter r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasType() == false) goto L6;
        ProtoBuf.Type r3 = r1.getType();
        Intrinsics.checkNotNullExpressionValue(r3, "type");
        return r3;
    L6:
        if (r1.hasTypeId() == false) goto L10;
        return r2.get(r1.getTypeId());
    L10:
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final ProtoBuf.Type varargElementType(ProtoBuf.ValueParameter r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasVarargElementType() == false) goto L6;
        return r1.getVarargElementType();
    L6:
        if (r1.hasVarargElementTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getVarargElementTypeId());
    }

    public static final ProtoBuf.Type outerType(ProtoBuf.Type r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasOuterType() == false) goto L6;
        return r1.getOuterType();
    L6:
        if (r1.hasOuterTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getOuterTypeId());
    }

    public static final ProtoBuf.Type abbreviatedType(ProtoBuf.Type r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasAbbreviatedType() == false) goto L6;
        return r1.getAbbreviatedType();
    L6:
        if (r1.hasAbbreviatedTypeId() == true) goto L11;
        return null;
    L11:
        return r2.get(r1.getAbbreviatedTypeId());
    }

    public static final ProtoBuf.Type underlyingType(ProtoBuf.TypeAlias r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasUnderlyingType() == false) goto L6;
        ProtoBuf.Type r3 = r1.getUnderlyingType();
        Intrinsics.checkNotNullExpressionValue(r3, "underlyingType");
        return r3;
    L6:
        if (r1.hasUnderlyingTypeId() == false) goto L10;
        return r2.get(r1.getUnderlyingTypeId());
    L10:
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final ProtoBuf.Type expandedType(ProtoBuf.TypeAlias r1, TypeTable r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "typeTable");
        if (r1.hasExpandedType() == false) goto L6;
        ProtoBuf.Type r3 = r1.getExpandedType();
        Intrinsics.checkNotNullExpressionValue(r3, "expandedType");
        return r3;
    L6:
        if (r1.hasExpandedTypeId() == false) goto L10;
        return r2.get(r1.getExpandedTypeId());
    L10:
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Class r3, TypeTable r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "typeTable");
        List<ProtoBuf.Type> r0 = r3.getContextReceiverTypeList();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L14;
        List<Integer> r5 = r3.getContextReceiverTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r5, "contextReceiverTypeIdList");
        List<Integer> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        Integer r2 = (Integer) r7.next();
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.add(r4.get(r2.intValue()));
        goto L9
    L12:
        return r1;
    L14:
        return r0;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Function r3, TypeTable r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "typeTable");
        List<ProtoBuf.Type> r0 = r3.getContextReceiverTypeList();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L14;
        List<Integer> r5 = r3.getContextReceiverTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r5, "contextReceiverTypeIdList");
        List<Integer> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        Integer r2 = (Integer) r7.next();
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.add(r4.get(r2.intValue()));
        goto L9
    L12:
        return r1;
    L14:
        return r0;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Property r3, TypeTable r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "typeTable");
        List<ProtoBuf.Type> r0 = r3.getContextReceiverTypeList();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L14;
        List<Integer> r5 = r3.getContextReceiverTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r5, "contextReceiverTypeIdList");
        List<Integer> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        Integer r2 = (Integer) r7.next();
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.add(r4.get(r2.intValue()));
        goto L9
    L12:
        return r1;
    L14:
        return r0;
    }
}
